package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndeterminateAnimationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* bridge */ /* synthetic */ BaseProgressIndicatorSpec createSpec(Context r1, AttributeSet r2) {
        return createSpec(r1, r2);
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_LinearProgressIndicator;
    }

    public LinearProgressIndicator(Context r2) {
        this(r2, null);
    }

    public LinearProgressIndicator(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4, DEF_STYLE_RES);
        initializeDrawables();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    LinearProgressIndicatorSpec createSpec(Context r1, AttributeSet r2) {
        return new LinearProgressIndicatorSpec(r1, r2);
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        LinearProgressIndicatorSpec r6 = (LinearProgressIndicatorSpec) this.spec;
        boolean r7 = true;
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection != 1) goto L5;
    L14:
        r6.drawHorizontallyInverse = r7;
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) goto L14;
    L9:
        if (ViewCompat.getLayoutDirection(this) == 0) goto L11;
    L13:
        r7 = false;
        goto L14
    L11:
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection != 3) goto L13;
        goto L13
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        int r5 = r1 - (getPaddingLeft() + getPaddingRight());
        int r6 = r2 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable r7 = getIndeterminateDrawable();
        if (r7 == null) goto L5;
        r7.setBounds(0, 0, r5, r6);
    L5:
        DeterminateDrawable r0 = getProgressDrawable();
        if (r0 == null) goto L9;
        r0.setBounds(0, 0, r5, r6);
        return;
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... r1) {
        super.setIndicatorColor(r1);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int r1) {
        super.setTrackCornerRadius(r1);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public void setIndeterminateAnimationType(int r4) {
        if (((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType != r4) goto L6;
        return;
    L6:
        if (visibleToUser() == true) goto L8;
    L12:
        ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType = r4;
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        if (r4 != 0) goto L15;
        getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.spec));
    L16:
        invalidate();
        return;
    L15:
        getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.spec));
        goto L16
    L8:
        if (isIndeterminate() == false) goto L12;
        throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    public void setIndicatorDirection(int r5) {
        ((LinearProgressIndicatorSpec) this.spec).indicatorDirection = r5;
        LinearProgressIndicatorSpec r0 = (LinearProgressIndicatorSpec) this.spec;
        boolean r1 = true;
        if (r5 != 1) goto L5;
    L14:
        r0.drawHorizontallyInverse = r1;
        invalidate();
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) goto L14;
    L9:
        if (ViewCompat.getLayoutDirection(this) == 0) goto L11;
    L13:
        r1 = false;
        goto L14
    L11:
        if (r5 != 3) goto L13;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int r2, boolean r3) {
        if (this.spec != 0) goto L5;
    L9:
        super.setProgressCompat(r2, r3);
        return;
    L5:
        if (((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType != 0) goto L9;
        if (isIndeterminate() == false) goto L9;
    }
}
