package com.android.setupwizardlib.gesture;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class ConsecutiveTapsGestureDetector {
    private final int consecutiveTapTimeout;
    private final int consecutiveTapTouchSlopSquare;
    private int consecutiveTapsCounter;
    private final OnConsecutiveTapsListener listener;
    private MotionEvent previousTapEvent;
    private final View view;

    public interface OnConsecutiveTapsListener {
        void onConsecutiveTaps(int r1);
    }

    public ConsecutiveTapsGestureDetector(OnConsecutiveTapsListener r2, View r3) {
        this.consecutiveTapsCounter = 0;
        this.listener = r2;
        this.view = r3;
        int r4 = ViewConfiguration.get(r3.getContext()).getScaledDoubleTapSlop();
        this.consecutiveTapTouchSlopSquare = r4 * r4;
        this.consecutiveTapTimeout = ViewConfiguration.getDoubleTapTimeout();
    }

    public void onTouchEvent(MotionEvent r9) {
        if (r9.getAction() != 1) goto L17;
        Rect r0 = new Rect();
        int[] r2 = new int[2];
        this.view.getLocationOnScreen(r2);
        int r4 = r2[0];
        r0.set(r4, r2[1], this.view.getWidth() + r4, r2[1] + this.view.getHeight());
        if (r0.contains((int) r9.getX(), (int) r9.getY()) == true) goto L7;
        this.consecutiveTapsCounter = 0;
    L12:
        MotionEvent r1 = this.previousTapEvent;
        if (r1 == null) goto L15;
        r1.recycle();
    L15:
        this.previousTapEvent = MotionEvent.obtain(r9);
        return;
    L7:
        if (isConsecutiveTap(r9) == false) goto L9;
        this.consecutiveTapsCounter++;
    L10:
        this.listener.onConsecutiveTaps(this.consecutiveTapsCounter);
        goto L12
    L9:
        this.consecutiveTapsCounter = 1;
        goto L10
    }

    public void resetCounter() {
        this.consecutiveTapsCounter = 0;
    }

    private boolean isConsecutiveTap(MotionEvent r11) {
        MotionEvent r0 = this.previousTapEvent;
        if (r0 != null) goto L5;
        return false;
    L5:
        double r2 = r0.getX() - r11.getX();
        double r4 = this.previousTapEvent.getY() - r11.getY();
        long r6 = r11.getEventTime() - this.previousTapEvent.getEventTime();
        if (((r2 * r2) + (r4 * r4)) <= this.consecutiveTapTouchSlopSquare) goto L8;
        return false;
    L8:
        if (r6 >= this.consecutiveTapTimeout) goto L12;
        return true;
    L12:
        return false;
    }
}
