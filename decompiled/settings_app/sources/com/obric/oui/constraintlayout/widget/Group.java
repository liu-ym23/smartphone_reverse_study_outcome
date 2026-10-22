package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes4.dex */
public class Group extends ConstraintHelper {
    public Group(Context r1) {
        super(r1);
    }

    public Group(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public Group(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r1) {
        super.init(r1);
        this.mUseViewMeasure = false;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        applyLayoutFeatures();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout r1) {
        applyLayoutFeatures(r1);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout r2) {
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r1.mWidget.setWidth(0);
        r1.mWidget.setHeight(0);
    }
}
