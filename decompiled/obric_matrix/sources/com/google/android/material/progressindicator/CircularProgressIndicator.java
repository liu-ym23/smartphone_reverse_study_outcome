package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = 0;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CircularProgressIndicator;
    }

    public CircularProgressIndicator(@NonNull Context r2) {
        this(r2, null);
    }

    public CircularProgressIndicator(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@NonNull Context r2, @Nullable AttributeSet r3, @AttrRes int r4) {
        super(r2, r3, r4, DEF_STYLE_RES);
        initializeDrawables();
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* bridge */ /* synthetic */ BaseProgressIndicatorSpec createSpec(@NonNull Context r1, @NonNull AttributeSet r2) {
        return createSpec(r1, r2);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    CircularProgressIndicatorSpec createSpec(@NonNull Context r1, @NonNull AttributeSet r2) {
        return new CircularProgressIndicatorSpec(r1, r2);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize;
    }

    public void setIndicatorDirection(int r2) {
        ((CircularProgressIndicatorSpec) this.spec).indicatorDirection = r2;
        invalidate();
    }

    public void setIndicatorInset(@Px int r3) {
        S r0 = this.spec;
        if (((CircularProgressIndicatorSpec) r0).indicatorInset == r3) goto L6;
        ((CircularProgressIndicatorSpec) r0).indicatorInset = r3;
        invalidate();
        return;
    }

    public void setIndicatorSize(@Px int r3) {
        int r4 = Math.max(r3, getTrackThickness() * 2);
        S r0 = this.spec;
        if (((CircularProgressIndicatorSpec) r0).indicatorSize == r4) goto L6;
        ((CircularProgressIndicatorSpec) r0).indicatorSize = r4;
        ((CircularProgressIndicatorSpec) r0).validateSpec();
        invalidate();
        return;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int r1) {
        super.setTrackThickness(r1);
        ((CircularProgressIndicatorSpec) this.spec).validateSpec();
    }
}
