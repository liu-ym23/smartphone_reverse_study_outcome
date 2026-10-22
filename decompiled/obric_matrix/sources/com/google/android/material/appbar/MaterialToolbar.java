package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {
    private static final int DEF_STYLE_RES = 0;

    @Nullable
    private Integer navigationIconTint;
    private boolean subtitleCentered;
    private boolean titleCentered;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Toolbar;
    }

    public MaterialToolbar(@NonNull Context r2) {
        this(r2, null);
    }

    public MaterialToolbar(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.toolbarStyle);
    }

    public MaterialToolbar(@NonNull Context r8, @Nullable AttributeSet r9, int r10) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r8, r9, r10, r4), r9, r10);
        Context r11 = getContext();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r11, r9, R.styleable.MaterialToolbar, r10, r4, new int[0]);
        int r13 = R.styleable.MaterialToolbar_navigationIconTint;
        if (r12.hasValue(r13) == false) goto L5;
        setNavigationIconTint(r12.getColor(r13, -1));
    L5:
        this.titleCentered = r12.getBoolean(R.styleable.MaterialToolbar_titleCentered, false);
        this.subtitleCentered = r12.getBoolean(R.styleable.MaterialToolbar_subtitleCentered, false);
        r12.recycle();
        initBackground(r11);
    }

    private Pair<Integer, Integer> calculateTitleBoundLimits(@Nullable TextView r8, @Nullable TextView r9) {
        int r0 = getMeasuredWidth();
        int r1 = r0 / 2;
        int r2 = getPaddingLeft();
        int r3 = r0 - getPaddingRight();
        int r4 = 0;
    L4:
        if (r4 >= getChildCount()) goto L21;
        View r5 = getChildAt(r4);
        if (r5.getVisibility() == 8) goto L19;
        if (r5 == r8) goto L19;
        if (r5 == r9) goto L19;
        if (r5.getRight() >= r1) goto L15;
        if (r5.getRight() <= r2) goto L15;
        r2 = r5.getRight();
    L15:
        if (r5.getLeft() <= r1) goto L19;
        if (r5.getLeft() >= r3) goto L19;
        r3 = r5.getLeft();
    L19:
        r4 = r4 + 1;
        goto L4
    L21:
        return new Pair(Integer.valueOf(r2), Integer.valueOf(r3));
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

    private void layoutTitleCenteredHorizontally(View r4, Pair<Integer, Integer> r5) {
        int r3 = getMeasuredWidth();
        int r0 = r4.getMeasuredWidth();
        int r6 = (r3 / 2) - (r0 / 2);
        int r1 = r0 + r6;
        int r7 = Math.max(Math.max(((Integer) r5.first).intValue() - r6, 0), Math.max(r1 - ((Integer) r5.second).intValue(), 0));
        if (r7 <= 0) goto L5;
        r6 = r6 + r7;
        r1 = r1 - r7;
        r4.measure(View.MeasureSpec.makeMeasureSpec(r1 - r6, BasicMeasure.EXACTLY), r4.getMeasuredHeightAndState());
    L5:
        r4.layout(r6, r4.getTop(), r1, r4.getBottom());
    }

    private void maybeCenterTitleViews() {
        if (this.titleCentered == false) goto L5;
    L7:
        TextView r0 = ToolbarUtils.getTitleTextView(this);
        TextView r1 = ToolbarUtils.getSubtitleTextView(this);
        if (r0 != null) goto L11;
        if (r1 != null) goto L11;
        return;
    L11:
        Pair<Integer, Integer> r2 = calculateTitleBoundLimits(r0, r1);
        if (this.titleCentered == false) goto L16;
        if (r0 == null) goto L16;
        layoutTitleCenteredHorizontally(r0, r2);
    L16:
        if (this.subtitleCentered == false) goto L20;
        if (r1 == null) goto L21;
        layoutTitleCenteredHorizontally(r1, r2);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (this.subtitleCentered == true) goto L7;
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (this.navigationIconTint == null) goto L8;
        Drawable r3 = DrawableCompat.wrap(r2.mutate());
        DrawableCompat.setTint(r3, this.navigationIconTint.intValue());
        return r3;
    L8:
        return r2;
    }

    @Nullable
    @ColorInt
    public Integer getNavigationIconTint() {
        return this.navigationIconTint;
    }

    public boolean isSubtitleCentered() {
        return this.subtitleCentered;
    }

    public boolean isTitleCentered() {
        return this.titleCentered;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        maybeCenterTitleViews();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable r1) {
        super.setNavigationIcon(maybeTintNavigationIcon(r1));
    }

    public void setNavigationIconTint(@ColorInt int r1) {
        this.navigationIconTint = Integer.valueOf(r1);
        Drawable r2 = getNavigationIcon();
        if (r2 == null) goto L6;
        setNavigationIcon(r2);
        return;
    }

    public void setSubtitleCentered(boolean r2) {
        if (this.subtitleCentered == r2) goto L6;
        this.subtitleCentered = r2;
        requestLayout();
        return;
    }

    public void setTitleCentered(boolean r2) {
        if (this.titleCentered == r2) goto L6;
        this.titleCentered = r2;
        requestLayout();
        return;
    }
}
