package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public Runnable c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OverScroller f306d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public VelocityTracker i;

    public class FlingRunnable implements Runnable {
        public final CoordinatorLayout b;
        public final View c;
        public final /* synthetic */ HeaderBehavior e;

        public FlingRunnable(HeaderBehavior r1, CoordinatorLayout r2, View r3) {
            this.e = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.c;
            if (r0 == null) goto L11;
            HeaderBehavior r1 = this.e;
            if (r1.f306d == null) goto L12;
            Log.i("djd ", "FlingRunnable: " + r0.getClass().getName() + "  scroller.getCurrY：" + r1.f306d.getCurrY());
            boolean r2 = r1.f306d.computeScrollOffset();
            CoordinatorLayout r3 = this.b;
            if (r2 == false) goto L9;
            r1.setHeaderTopBottomOffset(r3, r0, r1.f306d.getCurrY());
            ViewCompat.postOnAnimation(r0, this);
            return;
        L9:
            r1.onFlingFinished(r3, r0);
            return;
        L12:
            return;
        }
    }

    public HeaderBehavior() {
        this.f = -1;
        this.h = -1;
    }

    public boolean canDragView(View r1) {
        return false;
    }

    public boolean fling(CoordinatorLayout r14, View r15, int r16, int r17, float r18) {
        Runnable r2 = this.c;
        if (r2 == null) goto L6;
        r15.removeCallbacks(r2);
        this.c = null;
    L6:
        if (this.f306d != null) goto L8;
        this.f306d = new OverScroller(r15.getContext());
    L8:
        this.f306d.fling(0, getTopAndBottomOffset(), 0, Math.round(r18), 0, 0, r16, r17);
        if (this.f306d.computeScrollOffset() == false) goto L12;
        FlingRunnable r3 = new FlingRunnable(this, r14, r15);
        this.c = r3;
        ViewCompat.postOnAnimation(r15, r3);
        return true;
    L12:
        onFlingFinished(r14, r15);
        return false;
    }

    public int getMaxDragOffset(View r1) {
        return -r1.getHeight();
    }

    public int getScrollRangeForDragFling(View r1) {
        return r1.getHeight();
    }

    public final int getTopAndBottomOffset() {
        ViewOffsetHelper r0 = this.f308a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f310d;
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void onFlingFinished(CoordinatorLayout r1, View r2) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r7, View r8, MotionEvent r9) {
        if (this.h >= 0) goto L6;
        this.h = ViewConfiguration.get(r7.getContext()).getScaledTouchSlop();
    L6:
        if (r9.getActionMasked() != 2) goto L20;
        if (this.e == false) goto L20;
        int r0 = this.f;
        if (r0 != (-1)) goto L12;
        return false;
    L12:
        int r1 = r9.findPointerIndex(r0);
        if (r1 != (-1)) goto L15;
        return false;
    L15:
        int r2 = (int) r9.getY(r1);
        if (Math.abs(r2 - this.g) <= this.h) goto L20;
        this.g = r2;
        return true;
    L20:
        if (r9.getActionMasked() != 0) goto L38;
        this.f = -1;
        int r3 = (int) r9.getX();
        int r4 = (int) r9.getY();
        if (canDragView(r8) == true) goto L24;
    L26:
        boolean r10 = false;
    L27:
        this.e = r10;
        if (r10 == false) goto L38;
        this.g = r4;
        this.f = r9.getPointerId(0);
        if (this.i != null) goto L32;
        this.i = VelocityTracker.obtain();
    L32:
        OverScroller r11 = this.f306d;
        if (r11 == null) goto L38;
        if (r11.isFinished() == true) goto L38;
        this.f306d.abortAnimation();
        return true;
    L24:
        if (r7.isPointInChildBounds(r8, r3, r4) == false) goto L26;
        r10 = true;
    L38:
        VelocityTracker r6 = this.i;
        if (r6 == null) goto L41;
        r6.addMovement(r9);
    L41:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r12, View r13, MotionEvent r14) {
        int r0 = r14.getActionMasked();
        if (r0 != 1) goto L5;
        VelocityTracker r1 = this.i;
        if (r1 == null) goto L24;
        r1.addMovement(r14);
        this.i.computeCurrentVelocity(1000);
        fling(r12, r13, -getScrollRangeForDragFling(r13), 0, this.i.getYVelocity(this.f));
        boolean r15 = true;
    L25:
        this.e = false;
        this.f = -1;
        VelocityTracker r16 = this.i;
        if (r16 == null) goto L28;
        r16.recycle();
        this.i = null;
    L28:
        VelocityTracker r17 = this.i;
        if (r17 == null) goto L32;
        r17.addMovement(r14);
    L32:
        if (this.e == true) goto L37;
        if (r15 == false) goto L36;
        return true;
    L36:
        return false;
    L37:
        return true;
    L24:
        r15 = false;
        goto L25
    L5:
        if (r0 != 2) goto L7;
        int r2 = r14.findPointerIndex(this.f);
        if (r2 != (-1)) goto L19;
        return false;
    L19:
        int r3 = (int) r14.getY(r2);
        int r4 = this.g - r3;
        this.g = r3;
        setHeaderTopBottomOffset(r12, r13, getTopBottomOffsetForScrollingSibling() - r4, getMaxDragOffset(r13), 0);
    L20:
        r15 = false;
        goto L28
    L7:
        if (r0 == 3) goto L24;
        if (r0 != 6) goto L20;
        if (r14.getActionIndex() != 0) goto L14;
        int r18 = 1;
    L15:
        this.f = r14.getPointerId(r18);
        this.g = (int) (r14.getY(r18) + 0.5f);
        goto L20
    L14:
        r18 = 0;
        goto L15
    }

    public final int setHeaderTopBottomOffset(CoordinatorLayout r7, View r8, int r9) {
        return setHeaderTopBottomOffset(r7, r8, r9, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r1, View r2, int r3, int r4, int r5) {
        int r6 = getTopAndBottomOffset();
        if (r4 == 0) goto L15;
        if (r6 < r4) goto L15;
        if (r6 > r5) goto L15;
        int r7 = MathUtils.clamp(r3, r4, r5);
        if (r6 == r7) goto L15;
        ViewOffsetHelper r8 = this.f308a;
        if (r8 != null) goto L11;
        this.b = r7;
    L17:
        return r6 - r7;
    L11:
        if (r8.f310d == r7) goto L17;
        r8.f310d = r7;
        r8.a();
    L15:
        return 0;
    }

    public HeaderBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f = -1;
        this.h = -1;
    }
}
