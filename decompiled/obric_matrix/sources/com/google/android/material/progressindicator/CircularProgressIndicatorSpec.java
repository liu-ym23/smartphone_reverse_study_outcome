package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public int indicatorDirection;

    @Px
    public int indicatorInset;

    @Px
    public int indicatorSize;

    public CircularProgressIndicatorSpec(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicatorSpec(@NonNull Context r2, @Nullable AttributeSet r3, @AttrRes int r4) {
        this(r2, r3, r4, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public CircularProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        int r0 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int r1 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.CircularProgressIndicator, r12, r13, new int[0]);
        this.indicatorSize = Math.max(MaterialResources.getDimensionPixelSize(r10, r14, R.styleable.CircularProgressIndicator_indicatorSize, r0), this.trackThickness * 2);
        this.indicatorInset = MaterialResources.getDimensionPixelSize(r10, r14, R.styleable.CircularProgressIndicator_indicatorInset, r1);
        this.indicatorDirection = r14.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        r14.recycle();
        validateSpec();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    void validateSpec() {
    }
}
