package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context r3) {
        this.elevationOverlayEnabled = MaterialAttributes.resolveBoolean(r3, R.attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = MaterialColors.getColor(r3, R.attr.elevationOverlayColor, 0);
        this.colorSurface = MaterialColors.getColor(r3, R.attr.colorSurface, 0);
        this.displayDensity = r3.getResources().getDisplayMetrics().density;
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float r1, View r2) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(r1 + getParentAbsoluteElevation(r2));
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float r2) {
        return compositeOverlayIfNeeded(this.colorSurface, r2);
    }

    public int compositeOverlayIfNeeded(int r1, float r2, View r3) {
        return compositeOverlayIfNeeded(r1, r2 + getParentAbsoluteElevation(r3));
    }

    public int compositeOverlayIfNeeded(int r2, float r3) {
        if (this.elevationOverlayEnabled == true) goto L5;
    L8:
        return r2;
    L5:
        if (isThemeSurfaceColor(r2) == false) goto L8;
        return compositeOverlay(r2, r3);
    }

    public int compositeOverlay(int r1, float r2, View r3) {
        return compositeOverlay(r1, r2 + getParentAbsoluteElevation(r3));
    }

    public int compositeOverlay(int r3, float r4) {
        float r5 = calculateOverlayAlphaFraction(r4);
        int r0 = Color.alpha(r3);
        return ColorUtils.setAlphaComponent(MaterialColors.layer(ColorUtils.setAlphaComponent(r3, 255), this.elevationOverlayColor, r5), r0);
    }

    public int calculateOverlayAlpha(float r1) {
        return Math.round(calculateOverlayAlphaFraction(r1) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float r3) {
        float r2 = this.displayDensity;
        if (r2 > 0.0f) goto L5;
    L9:
        return 0.0f;
    L5:
        if (r3 <= 0.0f) goto L9;
        return Math.min(((((float) Math.log1p(r3 / r2)) * FORMULA_MULTIPLIER) + 2.0f) / 100.0f, 1.0f);
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public float getParentAbsoluteElevation(View r1) {
        return ViewUtils.getParentAbsoluteElevation(r1);
    }

    private boolean isThemeSurfaceColor(int r2) {
        if (ColorUtils.setAlphaComponent(r2, 255) != this.colorSurface) goto L5;
        return true;
    L5:
        return false;
    }
}
