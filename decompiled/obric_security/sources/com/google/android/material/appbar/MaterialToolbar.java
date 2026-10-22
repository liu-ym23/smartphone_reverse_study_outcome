package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {
    private static final int DEF_STYLE_RES = 0;
    private Integer navigationIconTint;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Toolbar;
    }

    public MaterialToolbar(Context r2) {
        this(r2, null);
    }

    public MaterialToolbar(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.toolbarStyle);
    }

    public MaterialToolbar(Context r7, AttributeSet r8, int r9) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r7, r8, r9, r4), r8, r9);
        Context r10 = getContext();
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(r10, r8, R.styleable.MaterialToolbar, r9, r4, new int[0]);
        if (r11.hasValue(R.styleable.MaterialToolbar_navigationIconTint) == false) goto L5;
        setNavigationIconTint(r11.getColor(R.styleable.MaterialToolbar_navigationIconTint, -1));
    L5:
        r11.recycle();
        initBackground(r10);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable r1) {
        super.setNavigationIcon(maybeTintNavigationIcon(r1));
    }

    public void setNavigationIconTint(int r1) {
        this.navigationIconTint = Integer.valueOf(r1);
        Drawable r2 = getNavigationIcon();
        if (r2 == null) goto L6;
        setNavigationIcon(r2);
        return;
    }

    private void initBackground(Context r3) {
        Drawable r0 = getBackground();
        if (r0 != null) goto L5;
    L7:
        MaterialShapeDrawable r1 = new MaterialShapeDrawable();
        if (r0 == null) goto L10;
        int r2 = ((ColorDrawable) r0).getColor();
    L11:
        r1.setFillColor(ColorStateList.valueOf(r2));
        r1.initializeElevationOverlay(r3);
        r1.setElevation(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, r1);
        return;
    L10:
        r2 = 0;
        goto L11
    L5:
        if ((r0 instanceof ColorDrawable) == true) goto L7;
    }

    private Drawable maybeTintNavigationIcon(Drawable r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (this.navigationIconTint == null) goto L8;
        Drawable r3 = DrawableCompat.wrap(r2);
        DrawableCompat.setTint(r3, this.navigationIconTint.intValue());
        return r3;
    L8:
        return r2;
    }
}
