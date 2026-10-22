package com.google.android.material.dialog;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public class InsetDialogOnTouchListener implements View.OnTouchListener {
    private final Dialog dialog;
    private final int leftInset;
    private final int prePieSlop;
    private final int topInset;

    public InsetDialogOnTouchListener(Dialog r2, Rect r3) {
        this.dialog = r2;
        this.leftInset = r3.left;
        this.topInset = r3.top;
        this.prePieSlop = ViewConfiguration.get(r2.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r6, MotionEvent r7) {
        View r0 = r6.findViewById(R.id.content);
        int r1 = this.leftInset + r0.getLeft();
        int r2 = r0.getWidth() + r1;
        int r3 = this.topInset + r0.getTop();
        if (new RectF(r1, r3, r2, r0.getHeight() + r3).contains(r7.getX(), r7.getY()) == false) goto L6;
        return false;
    L6:
        MotionEvent r4 = MotionEvent.obtain(r7);
        if (r7.getAction() != 1) goto L9;
        r4.setAction(4);
    L9:
        r6.performClick();
        return this.dialog.onTouchEvent(r4);
    }
}
