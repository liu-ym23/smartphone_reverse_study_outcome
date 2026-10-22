package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;

    @Nullable
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
        ENABLED_CHECKED_STATES = new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public MaterialCheckBox(Context r2) {
        this(r2, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList != null) goto L6;
        int[][] r0 = ENABLED_CHECKED_STATES;
        int[] r1 = new int[r0.length];
        int r2 = MaterialColors.getColor(this, R.attr.colorControlActivated);
        int r3 = MaterialColors.getColor(this, R.attr.colorSurface);
        int r4 = MaterialColors.getColor(this, R.attr.colorOnSurface);
        r1[0] = MaterialColors.layer(r3, r2, 1.0f);
        r1[1] = MaterialColors.layer(r3, r4, 0.54f);
        r1[2] = MaterialColors.layer(r3, r4, 0.38f);
        r1[3] = MaterialColors.layer(r3, r4, 0.38f);
        this.materialThemeColorsTintList = new ColorStateList(r0, r1);
    L6:
        return this.materialThemeColorsTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors == true) goto L5;
        return;
    L5:
        if (CompoundButtonCompat.getButtonTintList(this) != null) goto L9;
        setUseMaterialThemeColors(true);
        return;
    }

    public void setUseMaterialThemeColors(boolean r1) {
        this.useMaterialThemeColors = r1;
        if (r1 == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        return;
    L5:
        CompoundButtonCompat.setButtonTintList(this, null);
    }

    public MaterialCheckBox(Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.checkboxStyle);
    }

    public MaterialCheckBox(Context r8, @Nullable AttributeSet r9, int r10) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r8, r9, r10, r4), r9, r10);
        Context r11 = getContext();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r11, r9, R.styleable.MaterialCheckBox, r10, r4, new int[0]);
        if (r12.hasValue(R.styleable.MaterialCheckBox_buttonTint) == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, MaterialResources.getColorStateList(r11, r12, R.styleable.MaterialCheckBox_buttonTint));
    L5:
        this.useMaterialThemeColors = r12.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        r12.recycle();
    }
}
