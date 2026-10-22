package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class GhostViewPort extends ViewGroup implements GhostView {

    @Nullable
    private Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    int mReferences;
    ViewGroup mStartParent;
    View mStartView;
    final View mView;

    GhostViewPort(View r2) {
        super(r2.getContext());
        this.mOnPreDrawListener = new AnonymousClass1(this);
        this.mView = r2;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    static GhostViewPort addGhost(View r4, ViewGroup r5, Matrix r6) {
        if ((r4.getParent() instanceof ViewGroup) == false) goto L22;
        GhostViewHolder r0 = GhostViewHolder.getHolder(r5);
        GhostViewPort r1 = getGhostView(r4);
        int r2 = 0;
        if (r1 == null) goto L9;
        GhostViewHolder r3 = (GhostViewHolder) r1.getParent();
        if (r3 == r0) goto L9;
        r2 = r1.mReferences;
        r3.removeView(r1);
        r1 = null;
    L9:
        if (r1 != null) goto L17;
        if (r6 != null) goto L12;
        r6 = new Matrix();
        calculateMatrix(r4, r5, r6);
    L12:
        r1 = new GhostViewPort(r4);
        r1.setMatrix(r6);
        if (r0 != null) goto L15;
        r0 = new GhostViewHolder(r5);
    L16:
        copySize(r5, r0);
        copySize(r5, r1);
        r0.addGhostView(r1);
        r1.mReferences = r2;
    L19:
        r1.mReferences++;
        return r1;
    L15:
        r0.popToOverlayTop();
        goto L16
    L17:
        if (r6 == null) goto L19;
        r1.setMatrix(r6);
        goto L19
    L22:
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void calculateMatrix(View r1, ViewGroup r2, Matrix r3) {
        ViewGroup r4 = (ViewGroup) r1.getParent();
        r3.reset();
        ViewUtils.transformMatrixToGlobal(r4, r3);
        r3.preTranslate(-r4.getScrollX(), -r4.getScrollY());
        ViewUtils.transformMatrixToLocal(r2, r3);
    }

    static void copySize(View r4, View r5) {
        ViewUtils.setLeftTopRightBottom(r5, r5.getLeft(), r5.getTop(), r5.getLeft() + r4.getWidth(), r5.getTop() + r4.getHeight());
    }

    static GhostViewPort getGhostView(View r1) {
        return (GhostViewPort) r1.getTag(R.id.ghost_view);
    }

    static void removeGhost(View r1) {
        GhostViewPort r2 = getGhostView(r1);
        if (r2 == null) goto L8;
        int r0 = r2.mReferences - 1;
        r2.mReferences = r0;
        if (r0 > 0) goto L9;
        ((GhostViewHolder) r2.getParent()).removeView(r2);
        return;
    L9:
        return;
    }

    static void setGhostView(@NonNull View r1, @Nullable GhostViewPort r2) {
        r1.setTag(R.id.ghost_view, r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 4);
        if (this.mView.getParent() == null) goto L6;
        ((View) this.mView.getParent()).invalidate();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        setGhostView(this.mView, null);
        if (this.mView.getParent() == null) goto L5;
        ((View) this.mView.getParent()).invalidate();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r5) {
        CanvasUtils.enableZ(r5, true);
        r5.setMatrix(this.mMatrix);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        ViewUtils.setTransitionVisibility(this.mView, 4);
        drawChild(r5, this.mView, getDrawingTime());
        CanvasUtils.enableZ(r5, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup r1, View r2) {
        this.mStartParent = r1;
        this.mStartView = r2;
    }

    void setMatrix(@NonNull Matrix r1) {
        this.mMatrix = r1;
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (getGhostView(this.mView) != this) goto L9;
        if (r2 != 0) goto L6;
        int r3 = 4;
    L7:
        ViewUtils.setTransitionVisibility(this.mView, r3);
        return;
    L6:
        r3 = 0;
        goto L7
    }
}
