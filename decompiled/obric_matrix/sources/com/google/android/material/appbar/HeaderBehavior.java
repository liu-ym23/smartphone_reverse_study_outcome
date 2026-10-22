package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;

    @Nullable
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop;

    @Nullable
    private VelocityTracker velocityTracker;

    /* JADX WARN: Field signature parse error: layout
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TV at position 1 ('V'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:161)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:37)
     */
    private class FlingRunnable implements Runnable {
        private final View layout;
        private final CoordinatorLayout parent;
        final /* synthetic */ HeaderBehavior this$0;

        FlingRunnable(HeaderBehavior r1, CoordinatorLayout r2, V r3) {
            this.this$0 = r1;
            this.parent = r2;
            this.layout = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            if (this.layout == null) goto L11;
            OverScroller r0 = this.this$0.scroller;
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.computeScrollOffset() == false) goto L9;
            HeaderBehavior r1 = this.this$0;
            r1.setHeaderTopBottomOffset(this.parent, this.layout, r1.scroller.getCurrY());
            ViewCompat.postOnAnimation(this.layout, this);
            return;
        L9:
            this.this$0.onFlingFinished(this.parent, this.layout);
            return;
        }
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public HeaderBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker != null) goto L6;
        this.velocityTracker = VelocityTracker.obtain();
        return;
    }

    boolean canDragView(V r1) {
        return false;
    }

    final boolean fling(CoordinatorLayout r14, @NonNull V r15, int r16, int r17, float r18) {
        Runnable r2 = this.flingRunnable;
        if (r2 == null) goto L6;
        r15.removeCallbacks(r2);
        this.flingRunnable = null;
    L6:
        if (this.scroller != null) goto L8;
        this.scroller = new OverScroller(r15.getContext());
    L8:
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(r18), 0, 0, r16, r17);
        if (this.scroller.computeScrollOffset() == false) goto L12;
        FlingRunnable r3 = new FlingRunnable(this, r14, r15);
        this.flingRunnable = r3;
        ViewCompat.postOnAnimation(r15, r3);
        return true;
    L12:
        onFlingFinished(r14, r15);
        return false;
    }

    int getMaxDragOffset(@NonNull V r1) {
        return -r1.getHeight();
    }

    int getScrollRangeForDragFling(@NonNull V r1) {
        return r1.getHeight();
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    void onFlingFinished(CoordinatorLayout r1, V r2) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r7, @NonNull V r8, @NonNull MotionEvent r9) {
        if (this.touchSlop >= 0) goto L6;
        this.touchSlop = ViewConfiguration.get(r7.getContext()).getScaledTouchSlop();
    L6:
        if (r9.getActionMasked() != 2) goto L20;
        if (this.isBeingDragged == false) goto L20;
        int r0 = this.activePointerId;
        if (r0 != (-1)) goto L12;
        return false;
    L12:
        int r1 = r9.findPointerIndex(r0);
        if (r1 != (-1)) goto L15;
        return false;
    L15:
        int r2 = (int) r9.getY(r1);
        if (Math.abs(r2 - this.lastMotionY) <= this.touchSlop) goto L20;
        this.lastMotionY = r2;
        return true;
    L20:
        if (r9.getActionMasked() != 0) goto L35;
        this.activePointerId = -1;
        int r3 = (int) r9.getX();
        int r4 = (int) r9.getY();
        if (canDragView(r8) == true) goto L24;
    L26:
        boolean r10 = false;
    L27:
        this.isBeingDragged = r10;
        if (r10 == false) goto L35;
        this.lastMotionY = r4;
        this.activePointerId = r9.getPointerId(0);
        ensureVelocityTracker();
        OverScroller r11 = this.scroller;
        if (r11 == null) goto L35;
        if (r11.isFinished() == true) goto L35;
        this.scroller.abortAnimation();
        return true;
    L24:
        if (r7.isPointInChildBounds(r8, r3, r4) == false) goto L26;
        r10 = true;
    L35:
        VelocityTracker r6 = this.velocityTracker;
        if (r6 == null) goto L38;
        r6.addMovement(r9);
    L38:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r12, @NonNull V r13, @NonNull MotionEvent r14) {
        int r0 = r14.getActionMasked();
        if (r0 != 1) goto L5;
        VelocityTracker r1 = this.velocityTracker;
        if (r1 == null) goto L24;
        r1.addMovement(r14);
        this.velocityTracker.computeCurrentVelocity(1000);
        fling(r12, r13, -getScrollRangeForDragFling(r13), 0, this.velocityTracker.getYVelocity(this.activePointerId));
        boolean r15 = true;
    L25:
        this.isBeingDragged = false;
        this.activePointerId = -1;
        VelocityTracker r16 = this.velocityTracker;
        if (r16 == null) goto L28;
        r16.recycle();
        this.velocityTracker = null;
    L28:
        VelocityTracker r17 = this.velocityTracker;
        if (r17 == null) goto L32;
        r17.addMovement(r14);
    L32:
        if (this.isBeingDragged == true) goto L37;
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
        int r2 = r14.findPointerIndex(this.activePointerId);
        if (r2 != (-1)) goto L19;
        return false;
    L19:
        int r3 = (int) r14.getY(r2);
        int r7 = this.lastMotionY - r3;
        this.lastMotionY = r3;
        scroll(r12, r13, r7, getMaxDragOffset(r13), 0);
    L20:
        r15 = false;
        goto L28
    L7:
        if (r0 == 3) goto L24;
        if (r0 != 6) goto L20;
        if (r14.getActionIndex() != 0) goto L14;
        int r18 = 1;
    L15:
        this.activePointerId = r14.getPointerId(r18);
        this.lastMotionY = (int) (r14.getY(r18) + 0.5f);
        goto L20
    L14:
        r18 = 0;
        goto L15
    }

    final int scroll(CoordinatorLayout r8, V r9, int r10, int r11, int r12) {
        return setHeaderTopBottomOffset(r8, r9, getTopBottomOffsetForScrollingSibling() - r10, r11, r12);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout r7, V r8, int r9) {
        return setHeaderTopBottomOffset(r7, r8, r9, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout r1, V r2, int r3, int r4, int r5) {
        int r6 = getTopAndBottomOffset();
        if (r4 == 0) goto L9;
        if (r6 < r4) goto L9;
        if (r6 > r5) goto L9;
        int r7 = MathUtils.clamp(r3, r4, r5);
        if (r6 == r7) goto L9;
        setTopAndBottomOffset(r7);
        return r6 - r7;
    L9:
        return 0;
    }
}
