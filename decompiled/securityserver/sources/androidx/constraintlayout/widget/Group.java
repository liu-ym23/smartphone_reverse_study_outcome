package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class Group extends ConstraintHelper {
    public Group(Context r1) {
        super(r1);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout r1) {
        applyLayoutFeatures(r1);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r1) {
        super.init(r1);
        this.mUseViewMeasure = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout r2) {
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r1.widget.setWidth(0);
        r1.widget.setHeight(0);
    }

    public Group(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public Group(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
