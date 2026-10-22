package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
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
public abstract class HeaderBehavior<V extends View> extends com.obric.oui.titlebar.behavior.a<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Runnable f11570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OverScroller f11571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private VelocityTracker f11576j;

    /* JADX WARN: Field signature parse error: g
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TV at position 1 ('V'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:161)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:37)
     */
    private class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final CoordinatorLayout f11577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final View f11578g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ HeaderBehavior f11579h;

        a(HeaderBehavior r1, CoordinatorLayout r2, V r3) {
            this.f11579h = r1;
            this.f11577f = r2;
            this.f11578g = r3;
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
            if (this.f11578g != null) goto L5;
            return;
        L5:
            if (this.f11579h.f11571e == null) goto L12;
            Log.i("djd ", "FlingRunnable: " + this.f11578g.getClass().getName() + "  scroller.getCurrY：" + this.f11579h.f11571e.getCurrY());
            if (this.f11579h.f11571e.computeScrollOffset() == false) goto L9;
            HeaderBehavior r0 = this.f11579h;
            r0.setHeaderTopBottomOffset(this.f11577f, this.f11578g, r0.f11571e.getCurrY());
            ViewCompat.postOnAnimation(this.f11578g, this);
            return;
        L9:
            this.f11579h.onFlingFinished(this.f11577f, this.f11578g);
            return;
        }
    }

    public HeaderBehavior() {
        this.f11573g = -1;
        this.f11575i = -1;
    }

    public HeaderBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f11573g = -1;
        this.f11575i = -1;
    }

    private void ensureVelocityTracker() {
        if (this.f11576j != null) goto L6;
        this.f11576j = VelocityTracker.obtain();
        return;
    }

    protected void a() {
        OverScroller r0 = this.f11571e;
        if (r0 == null) goto L6;
        r0.abortAnimation();
        return;
    }

    public boolean canDragView(V r1) {
        return false;
    }

    public boolean fling(CoordinatorLayout r14, @NonNull V r15, int r16, int r17, float r18) {
        Runnable r2 = this.f11570d;
        if (r2 == null) goto L6;
        r15.removeCallbacks(r2);
        this.f11570d = null;
    L6:
        if (this.f11571e != null) goto L8;
        this.f11571e = new OverScroller(r15.getContext());
    L8:
        this.f11571e.fling(0, getTopAndBottomOffset(), 0, Math.round(r18), 0, 0, r16, r17);
        if (this.f11571e.computeScrollOffset() == false) goto L12;
        a r3 = new a(this, r14, r15);
        this.f11570d = r3;
        ViewCompat.postOnAnimation(r15, r3);
        return true;
    L12:
        onFlingFinished(r14, r15);
        return false;
    }

    public int getMaxDragOffset(@NonNull V r1) {
        return -r1.getHeight();
    }

    public int getScrollRangeForDragFling(@NonNull V r1) {
        return r1.getHeight();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void onFlingFinished(CoordinatorLayout r1, V r2) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r7, @NonNull V r8, @NonNull MotionEvent r9) {
        if (this.f11575i >= 0) goto L6;
        this.f11575i = ViewConfiguration.get(r7.getContext()).getScaledTouchSlop();
    L6:
        if (r9.getActionMasked() != 2) goto L20;
        if (this.f11572f == false) goto L20;
        int r0 = this.f11573g;
        if (r0 != (-1)) goto L12;
        return false;
    L12:
        int r1 = r9.findPointerIndex(r0);
        if (r1 != (-1)) goto L15;
        return false;
    L15:
        int r2 = (int) r9.getY(r1);
        if (Math.abs(r2 - this.f11574h) <= this.f11575i) goto L20;
        this.f11574h = r2;
        return true;
    L20:
        if (r9.getActionMasked() != 0) goto L35;
        this.f11573g = -1;
        int r3 = (int) r9.getX();
        int r4 = (int) r9.getY();
        if (canDragView(r8) == true) goto L24;
    L26:
        boolean r10 = false;
    L27:
        this.f11572f = r10;
        if (r10 == false) goto L35;
        this.f11574h = r4;
        this.f11573g = r9.getPointerId(0);
        ensureVelocityTracker();
        OverScroller r11 = this.f11571e;
        if (r11 == null) goto L35;
        if (r11.isFinished() == true) goto L35;
        this.f11571e.abortAnimation();
        return true;
    L24:
        if (r7.isPointInChildBounds(r8, r3, r4) == false) goto L26;
        r10 = true;
    L35:
        VelocityTracker r6 = this.f11576j;
        if (r6 == null) goto L38;
        r6.addMovement(r9);
    L38:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r12, @NonNull V r13, @NonNull MotionEvent r14) {
        int r0 = r14.getActionMasked();
        if (r0 != 1) goto L5;
        VelocityTracker r1 = this.f11576j;
        if (r1 == null) goto L24;
        r1.addMovement(r14);
        this.f11576j.computeCurrentVelocity(1000);
        fling(r12, r13, -getScrollRangeForDragFling(r13), 0, this.f11576j.getYVelocity(this.f11573g));
        boolean r15 = true;
    L25:
        this.f11572f = false;
        this.f11573g = -1;
        VelocityTracker r16 = this.f11576j;
        if (r16 == null) goto L28;
        r16.recycle();
        this.f11576j = null;
    L28:
        VelocityTracker r17 = this.f11576j;
        if (r17 == null) goto L32;
        r17.addMovement(r14);
    L32:
        if (this.f11572f == true) goto L37;
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
        int r2 = r14.findPointerIndex(this.f11573g);
        if (r2 != (-1)) goto L19;
        return false;
    L19:
        int r3 = (int) r14.getY(r2);
        int r7 = this.f11574h - r3;
        this.f11574h = r3;
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
        this.f11573g = r14.getPointerId(r18);
        this.f11574h = (int) (r14.getY(r18) + 0.5f);
        goto L20
    L14:
        r18 = 0;
        goto L15
    }

    public int scroll(CoordinatorLayout r8, V r9, int r10, int r11, int r12) {
        return setHeaderTopBottomOffset(r8, r9, getTopBottomOffsetForScrollingSibling() - r10, r11, r12);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r7, V r8, int r9) {
        return setHeaderTopBottomOffset(r7, r8, r9, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r1, V r2, int r3, int r4, int r5) {
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
