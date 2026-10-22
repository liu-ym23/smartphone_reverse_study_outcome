package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialRadioButton extends AppCompatRadioButton {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;

    @Nullable
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;
        ENABLED_CHECKED_STATES = new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public MaterialRadioButton(@NonNull Context r2) {
        this(r2, null);
    }

    public MaterialRadioButton(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.radioButtonStyle);
    }

    public MaterialRadioButton(@NonNull Context r8, @Nullable AttributeSet r9, int r10) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r8, r9, r10, r4), r9, r10);
        Context r11 = getContext();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r11, r9, R.styleable.MaterialRadioButton, r10, r4, new int[0]);
        int r13 = R.styleable.MaterialRadioButton_buttonTint;
        if (r12.hasValue(r13) == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, MaterialResources.getColorStateList(r11, r12, r13));
    L5:
        this.useMaterialThemeColors = r12.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
        r12.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList != null) goto L6;
        int r0 = MaterialColors.getColor(this, R.attr.colorControlActivated);
        int r1 = MaterialColors.getColor(this, R.attr.colorOnSurface);
        int r2 = MaterialColors.getColor(this, R.attr.colorSurface);
        int[][] r3 = ENABLED_CHECKED_STATES;
        int[] r4 = new int[r3.length];
        r4[0] = MaterialColors.layer(r2, r0, 1.0f);
        r4[1] = MaterialColors.layer(r2, r1, 0.54f);
        r4[2] = MaterialColors.layer(r2, r1, 0.38f);
        r4[3] = MaterialColors.layer(r2, r1, 0.38f);
        this.materialThemeColorsTintList = new ColorStateList(r3, r4);
    L6:
        return this.materialThemeColorsTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
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
        ColorStateList r2 = getMaterialThemeColorsTintList();
    L6:
        CompoundButtonCompat.setButtonTintList(this, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
