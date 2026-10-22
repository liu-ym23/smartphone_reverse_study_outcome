package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    private static final int DEF_STYLE_RES = 0;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Toolbar;
    }

    public MaterialToolbar(@NonNull Context r2) {
        this(r2, null);
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

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    public MaterialToolbar(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.toolbarStyle);
    }

    public MaterialToolbar(@NonNull Context r2, @Nullable AttributeSet r3, int r4) {
        super(MaterialThemeOverlay.wrap(r2, r3, r4, DEF_STYLE_RES), r3, r4);
        initBackground(getContext());
    }
}
