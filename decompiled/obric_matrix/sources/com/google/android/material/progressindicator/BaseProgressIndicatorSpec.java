package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseProgressIndicatorSpec {
    public int hideAnimationBehavior;

    @NonNull
    public int[] indicatorColors;
    public int showAnimationBehavior;

    @ColorInt
    public int trackColor;

    @Px
    public int trackCornerRadius;

    @Px
    public int trackThickness;

    protected BaseProgressIndicatorSpec(@NonNull Context r9, @Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        this.indicatorColors = new int[0];
        int r1 = r9.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r9, r10, R.styleable.BaseProgressIndicator, r11, r12, new int[0]);
        this.trackThickness = MaterialResources.getDimensionPixelSize(r9, r13, R.styleable.BaseProgressIndicator_trackThickness, r1);
        this.trackCornerRadius = Math.min(MaterialResources.getDimensionPixelSize(r9, r13, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.trackThickness / 2);
        this.showAnimationBehavior = r13.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.hideAnimationBehavior = r13.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        loadIndicatorColors(r9, r13);
        loadTrackColor(r9, r13);
        r13.recycle();
    }

    private void loadIndicatorColors(@NonNull Context r6, @NonNull TypedArray r7) {
        int r0 = R.styleable.BaseProgressIndicator_indicatorColor;
        if (r7.hasValue(r0) == true) goto L7;
        this.indicatorColors = new int[]{MaterialColors.getColor(r6, R.attr.colorPrimary, -1)};
        return;
    L7:
        if (r7.peekValue(r0).type == 1) goto L10;
        this.indicatorColors = new int[]{r7.getColor(r0, -1)};
        return;
    L10:
        int[] r8 = r6.getResources().getIntArray(r7.getResourceId(r0, -1));
        this.indicatorColors = r8;
        if (r8.length == 0) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    private void loadTrackColor(@NonNull Context r3, @NonNull TypedArray r4) {
        int r0 = R.styleable.BaseProgressIndicator_trackColor;
        if (r4.hasValue(r0) == false) goto L7;
        int r5 = r4.getColor(r0, -1);
    L5:
        this.trackColor = r5;
        return;
    L7:
        this.trackColor = this.indicatorColors[0];
        TypedArray r6 = r3.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float r7 = r6.getFloat(0, 0.2f);
        r6.recycle();
        r5 = MaterialColors.compositeARGBWithAlpha(this.trackColor, (int) (r7 * 255.0f));
        goto L5
    }

    public boolean isHideAnimationEnabled() {
        if (this.hideAnimationBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShowAnimationEnabled() {
        if (this.showAnimationBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    abstract void validateSpec();
}
