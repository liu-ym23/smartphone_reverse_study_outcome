package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class Layer extends ConstraintHelper {
    private static final String TAG = "Layer";
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;
    protected float mComputedCenterX;
    protected float mComputedCenterY;
    protected float mComputedMaxX;
    protected float mComputedMaxY;
    protected float mComputedMinX;
    protected float mComputedMinY;
    ConstraintLayout mContainer;
    private float mGroupRotateAngle;
    boolean mNeedBounds;
    private float mRotationCenterX;
    private float mRotationCenterY;
    private float mScaleX;
    private float mScaleY;
    private float mShiftX;
    private float mShiftY;
    View[] mViews;

    public Layer(Context context) {
        super(context);
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    public Layer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    public Layer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet attrs) {
        super.init(attrs);
        int r0 = 0;
        this.mUseViewMeasure = false;
        if (attrs == null) goto L19;
        TypedArray r6 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
        int r1 = r6.getIndexCount();
    L5:
        if (r0 >= r1) goto L13;
        int r2 = r6.getIndex(r0);
        if (r2 != R.styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.mApplyVisibilityOnAttach = true;
    L12:
        r0 = r0 + 1;
        goto L5
    L10:
        if (r2 != R.styleable.ConstraintLayout_Layout_android_elevation) goto L12;
        this.mApplyElevationOnAttach = true;
        goto L12
    L13:
        r6.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        if (this.mApplyVisibilityOnAttach == false) goto L5;
    L6:
        int r0 = getVisibility();
        float r1 = getElevation();
        int r2 = 0;
    L8:
        if (r2 >= this.mCount) goto L26;
        int r3 = this.mIds[r2];
        View r4 = this.mContainer.getViewById(r3);
        if (r4 == null) goto L19;
        if (this.mApplyVisibilityOnAttach == false) goto L15;
        r4.setVisibility(r0);
    L15:
        if (this.mApplyElevationOnAttach == false) goto L19;
        if (r1 <= 0.0f) goto L19;
        r4.setTranslationZ(r4.getTranslationZ() + r1);
    L19:
        r2 = r2 + 1;
        goto L8
    L26:
        return;
    L5:
        if (this.mApplyElevationOnAttach == true) goto L6;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout container) {
        this.mContainer = container;
        float r2 = getRotation();
        if (r2 == 0.0f) goto L5;
        this.mGroupRotateAngle = r2;
        return;
    L5:
        if (Float.isNaN(this.mGroupRotateAngle) == true) goto L9;
        this.mGroupRotateAngle = r2;
        return;
    }

    @Override // android.view.View
    public void setRotation(float angle) {
        this.mGroupRotateAngle = angle;
        transform();
    }

    @Override // android.view.View
    public void setScaleX(float scaleX) {
        this.mScaleX = scaleX;
        transform();
    }

    @Override // android.view.View
    public void setScaleY(float scaleY) {
        this.mScaleY = scaleY;
        transform();
    }

    @Override // android.view.View
    public void setPivotX(float pivotX) {
        this.mRotationCenterX = pivotX;
        transform();
    }

    @Override // android.view.View
    public void setPivotY(float pivotY) {
        this.mRotationCenterY = pivotY;
        transform();
    }

    @Override // android.view.View
    public void setTranslationX(float dx) {
        this.mShiftX = dx;
        transform();
    }

    @Override // android.view.View
    public void setTranslationY(float dy) {
        this.mShiftY = dy;
        transform();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout container) {
        reCacheViews();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget r5 = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        r5.setWidth(0);
        r5.setHeight(0);
        calcCenters();
        layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), ((int) this.mComputedMaxX) + getPaddingRight(), ((int) this.mComputedMaxY) + getPaddingBottom());
        transform();
    }

    private void reCacheViews() {
        if (this.mContainer != null) goto L6;
        return;
    L6:
        if (this.mCount != 0) goto L8;
        return;
    L8:
        View[] r0 = this.mViews;
        if (r0 != null) goto L11;
    L12:
        this.mViews = new View[this.mCount];
    L13:
        int r1 = 0;
    L15:
        if (r1 >= this.mCount) goto L17;
        int r2 = this.mIds[r1];
        this.mViews[r1] = this.mContainer.getViewById(r2);
        r1 = r1 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r0.length == this.mCount) goto L13;
        goto L12
    }

    protected void calcCenters() {
        if (this.mContainer != null) goto L6;
        return;
    L6:
        if (this.mNeedBounds == true) goto L13;
        if (Float.isNaN(this.mComputedCenterX) == true) goto L13;
        if (Float.isNaN(this.mComputedCenterY) == true) goto L13;
        return;
    L13:
        if (Float.isNaN(this.mRotationCenterX) == false) goto L15;
    L18:
        View[] r0 = getViews(this.mContainer);
        int r1 = 0;
        int r2 = r0[0].getLeft();
        int r3 = r0[0].getTop();
        int r4 = r0[0].getRight();
        int r5 = r0[0].getBottom();
    L20:
        if (r1 >= this.mCount) goto L22;
        View r6 = r0[r1];
        r2 = Math.min(r2, r6.getLeft());
        r3 = Math.min(r3, r6.getTop());
        r4 = Math.max(r4, r6.getRight());
        r5 = Math.max(r5, r6.getBottom());
        r1 = r1 + 1;
        goto L20
    L22:
        this.mComputedMaxX = r4;
        this.mComputedMaxY = r5;
        this.mComputedMinX = r2;
        this.mComputedMinY = r3;
        if (Float.isNaN(this.mRotationCenterX) == false) goto L25;
        this.mComputedCenterX = (r2 + r4) / 2;
    L27:
        if (Float.isNaN(this.mRotationCenterY) == false) goto L29;
        this.mComputedCenterY = (r3 + r5) / 2;
        return;
    L29:
        this.mComputedCenterY = this.mRotationCenterY;
        return;
    L25:
        this.mComputedCenterX = this.mRotationCenterX;
        goto L27
    L15:
        if (Float.isNaN(this.mRotationCenterY) == true) goto L18;
        this.mComputedCenterY = this.mRotationCenterY;
        this.mComputedCenterX = this.mRotationCenterX;
    }

    private void transform() {
        if (this.mContainer != null) goto L6;
        return;
    L6:
        if (this.mViews != null) goto L8;
        reCacheViews();
    L8:
        calcCenters();
        if (Float.isNaN(this.mGroupRotateAngle) == false) goto L11;
        double r0 = 0.0d;
    L12:
        float r2 = (float) Math.sin(r0);
        float r1 = (float) Math.cos(r0);
        float r3 = this.mScaleX;
        float r4 = r3 * r1;
        float r5 = this.mScaleY;
        float r6 = (-r5) * r2;
        float r7 = r3 * r2;
        float r8 = r5 * r1;
        int r9 = 0;
    L14:
        if (r9 >= this.mCount) goto L19;
        View r10 = this.mViews[r9];
        int r11 = (r10.getLeft() + r10.getRight()) / 2;
        int r12 = (r10.getTop() + r10.getBottom()) / 2;
        float r13 = r11 - this.mComputedCenterX;
        float r14 = r12 - this.mComputedCenterY;
        float r15 = (((r4 * r13) + (r6 * r14)) - r13) + this.mShiftX;
        float r16 = (((r13 * r7) + (r8 * r14)) - r14) + this.mShiftY;
        r10.setTranslationX(r15);
        r10.setTranslationY(r16);
        r10.setScaleY(this.mScaleY);
        r10.setScaleX(this.mScaleX);
        if (Float.isNaN(this.mGroupRotateAngle) == true) goto L18;
        r10.setRotation(this.mGroupRotateAngle);
    L18:
        r9 = r9 + 1;
        goto L14
    L19:
        return;
    L11:
        r0 = Math.toRadians(this.mGroupRotateAngle);
        goto L12
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout container) {
        applyLayoutFeatures(container);
    }
}
