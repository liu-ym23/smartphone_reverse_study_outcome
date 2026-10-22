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

    public Layer(Context r2) {
        super(r2);
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

    private void reCacheViews() {
        if (this.mContainer != null) goto L5;
        return;
    L5:
        int r0 = this.mCount;
        if (r0 != 0) goto L8;
        return;
    L8:
        View[] r1 = this.mViews;
        if (r1 != null) goto L11;
    L12:
        this.mViews = new View[r0];
    L13:
        int r2 = 0;
    L15:
        if (r2 >= this.mCount) goto L17;
        int r3 = this.mIds[r2];
        this.mViews[r2] = this.mContainer.getViewById(r3);
        r2 = r2 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r1.length == r0) goto L13;
        goto L12
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
        int r11 = (r10.getRight() + r10.getLeft()) / 2;
        int r12 = (r10.getBottom() + r10.getTop()) / 2;
        float r13 = r11 - this.mComputedCenterX;
        float r14 = r12 - this.mComputedCenterY;
        float r15 = (((r6 * r14) + (r4 * r13)) - r13) + this.mShiftX;
        float r16 = (((r8 * r14) + (r13 * r7)) - r14) + this.mShiftY;
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
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout r1) {
        applyLayoutFeatures(r1);
    }

    public void calcCenters() {
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

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r6) {
        super.init(r6);
        int r0 = 0;
        this.mUseViewMeasure = false;
        if (r6 == null) goto L19;
        TypedArray r7 = getContext().obtainStyledAttributes(r6, R.styleable.ConstraintLayout_Layout);
        int r1 = r7.getIndexCount();
    L5:
        if (r0 >= r1) goto L13;
        int r2 = r7.getIndex(r0);
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
        r7.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
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

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setPivotX(float r1) {
        this.mRotationCenterX = r1;
        transform();
    }

    @Override // android.view.View
    public void setPivotY(float r1) {
        this.mRotationCenterY = r1;
        transform();
    }

    @Override // android.view.View
    public void setRotation(float r1) {
        this.mGroupRotateAngle = r1;
        transform();
    }

    @Override // android.view.View
    public void setScaleX(float r1) {
        this.mScaleX = r1;
        transform();
    }

    @Override // android.view.View
    public void setScaleY(float r1) {
        this.mScaleY = r1;
        transform();
    }

    @Override // android.view.View
    public void setTranslationX(float r1) {
        this.mShiftX = r1;
        transform();
    }

    @Override // android.view.View
    public void setTranslationY(float r1) {
        this.mShiftY = r1;
        transform();
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout r5) {
        reCacheViews();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget r6 = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        r6.setWidth(0);
        r6.setHeight(0);
        calcCenters();
        int r7 = ((int) this.mComputedMinX) - getPaddingLeft();
        int r0 = ((int) this.mComputedMinY) - getPaddingTop();
        int r1 = (int) this.mComputedMaxX;
        int r2 = getPaddingRight() + r1;
        int r3 = (int) this.mComputedMaxY;
        layout(r7, r0, r2, getPaddingBottom() + r3);
        transform();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout r2) {
        this.mContainer = r2;
        float r3 = getRotation();
        if (r3 == 0.0f) goto L5;
        this.mGroupRotateAngle = r3;
        return;
    L5:
        if (Float.isNaN(this.mGroupRotateAngle) == true) goto L9;
        this.mGroupRotateAngle = r3;
        return;
    }

    public Layer(Context r1, AttributeSet r2) {
        super(r1, r2);
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

    public Layer(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
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
}
