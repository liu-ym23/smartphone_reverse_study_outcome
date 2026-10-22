package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;

/* JADX INFO: loaded from: classes2.dex */
class RadialViewGroup extends ConstraintLayout {
    private static final String SKIP_TAG = "skip";
    private MaterialShapeDrawable background;
    private int radius;
    private final Runnable updateLayoutParametersRunnable;

    public RadialViewGroup(Context r2) {
        this(r2, null);
    }

    public RadialViewGroup(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public RadialViewGroup(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(R.layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, createBackground());
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.RadialViewGroup, r5, 0);
        this.radius = r6.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.updateLayoutParametersRunnable = new AnonymousClass1(this);
        r6.recycle();
    }

    private Drawable createBackground() {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        this.background = r0;
        r0.setCornerSize(new RelativeCornerSize(0.5f));
        this.background.setFillColor(ColorStateList.valueOf(-1));
        return this.background;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.background.setFillColor(ColorStateList.valueOf(r1));
    }

    @Override // android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        super.addView(r1, r2, r3);
        if (r1.getId() != (-1)) goto L5;
        r1.setId(ViewCompat.generateViewId());
    L5:
        updateLayoutParamsAsync();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r1) {
        super.onViewRemoved(r1);
        updateLayoutParamsAsync();
    }

    private void updateLayoutParamsAsync() {
        Handler r0 = getHandler();
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.updateLayoutParametersRunnable);
        r0.post(this.updateLayoutParametersRunnable);
        return;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    protected void updateLayoutParams() {
        int r0 = getChildCount();
        int r1 = 1;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        if (shouldSkipView(getChildAt(r3)) == false) goto L7;
        r1 = r1 + 1;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        ConstraintSet r4 = new ConstraintSet();
        r4.clone(this);
        float r5 = 0.0f;
    L9:
        if (r2 >= r0) goto L17;
        View r6 = getChildAt(r2);
        if (r6.getId() == R.id.circle_center) goto L16;
        if (shouldSkipView(r6) == true) goto L16;
        r4.constrainCircle(r6.getId(), R.id.circle_center, this.radius, r5);
        r5 = r5 + (360.0f / (r0 - r1));
    L16:
        r2 = r2 + 1;
        goto L9
    L17:
        r4.applyTo(this);
    }

    public void setRadius(int r1) {
        this.radius = r1;
        updateLayoutParams();
    }

    public int getRadius() {
        return this.radius;
    }

    private static boolean shouldSkipView(View r1) {
        return SKIP_TAG.equals(r1.getTag());
    }
}
