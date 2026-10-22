package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes2.dex */
public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    boolean drawHorizontallyInverse;
    public int indeterminateAnimationType;
    public int indicatorDirection;

    public LinearProgressIndicatorSpec(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicatorSpec(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, LinearProgressIndicator.DEF_STYLE_RES);
    }

    public LinearProgressIndicatorSpec(Context r7, AttributeSet r8, int r9, int r10) {
        super(r7, r8, r9, r10);
        boolean r11 = false;
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r7, r8, R.styleable.LinearProgressIndicator, R.attr.linearProgressIndicatorStyle, LinearProgressIndicator.DEF_STYLE_RES, new int[0]);
        this.indeterminateAnimationType = r12.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.indicatorDirection = r12.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        r12.recycle();
        validateSpec();
        if (this.indicatorDirection != 1) goto L5;
        r11 = true;
    L5:
        this.drawHorizontallyInverse = r11;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    void validateSpec() {
        if (this.indeterminateAnimationType == 0) goto L5;
        return;
    L5:
        if (this.trackCornerRadius > 0) goto L12;
        if (this.indicatorColors.length < 3) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
    L12:
        throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
    }
}
