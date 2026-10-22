package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int DEF_STYLE_RES = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    @ColorInt
    private int color;

    @NonNull
    private Drawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int orientation;
    private final Rect tempRect;
    private int thickness;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;
    }

    public MaterialDividerItemDecoration(@NonNull Context r2, int r3) {
        this(r2, null, r3);
    }

    public MaterialDividerItemDecoration(@NonNull Context r2, @Nullable AttributeSet r3, int r4) {
        this(r2, r3, R.attr.materialDividerStyle, r4);
    }

    public MaterialDividerItemDecoration(@NonNull Context r8, @Nullable AttributeSet r9, int r10, int r11) {
        this.tempRect = new Rect();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r8, r9, R.styleable.MaterialDivider, r10, DEF_STYLE_RES, new int[0]);
        this.color = MaterialResources.getColorStateList(r8, r12, R.styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.thickness = r12.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, r8.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.insetStart = r12.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = r12.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        r12.recycle();
        this.dividerDrawable = new ShapeDrawable();
        setDividerColor(this.color);
        setOrientation(r11);
    }

    private void drawForHorizontalOrientation(@NonNull Canvas r8, @NonNull RecyclerView r9) {
        r8.save();
        int r1 = 0;
        if (r9.getClipToPadding() == false) goto L5;
        int r0 = r9.getPaddingTop();
        int r2 = r9.getHeight() - r9.getPaddingBottom();
        r8.clipRect(r9.getPaddingLeft(), r0, r9.getWidth() - r9.getPaddingRight(), r2);
    L6:
        int r3 = r0 + this.insetStart;
        int r4 = r2 - this.insetEnd;
        int r5 = r9.getChildCount();
    L7:
        if (r1 >= r5) goto L9;
        View r6 = r9.getChildAt(r1);
        r9.getLayoutManager().getDecoratedBoundsWithMargins(r6, this.tempRect);
        int r7 = this.tempRect.right + Math.round(r6.getTranslationX());
        this.dividerDrawable.setBounds((r7 - this.dividerDrawable.getIntrinsicWidth()) - this.thickness, r3, r7, r4);
        this.dividerDrawable.draw(r8);
        r1 = r1 + 1;
        goto L7
    L9:
        r8.restore();
        return;
    L5:
        r2 = r9.getHeight();
        r0 = 0;
        goto L6
    }

    private void drawForVerticalOrientation(@NonNull Canvas r8, @NonNull RecyclerView r9) {
        r8.save();
        int r1 = 0;
        if (r9.getClipToPadding() == false) goto L5;
        int r0 = r9.getPaddingLeft();
        int r2 = r9.getWidth() - r9.getPaddingRight();
        r8.clipRect(r0, r9.getPaddingTop(), r2, r9.getHeight() - r9.getPaddingBottom());
    L6:
        boolean r4 = true;
        if (ViewCompat.getLayoutDirection(r9) == 1) goto L10;
        r4 = false;
    L10:
        if (r4 == false) goto L12;
        int r3 = this.insetEnd;
    L13:
        int r5 = r0 + r3;
        if (r4 == false) goto L16;
        int r6 = this.insetStart;
    L17:
        int r7 = r2 - r6;
        int r10 = r9.getChildCount();
    L18:
        if (r1 >= r10) goto L20;
        View r11 = r9.getChildAt(r1);
        r9.getDecoratedBoundsWithMargins(r11, this.tempRect);
        int r12 = this.tempRect.bottom + Math.round(r11.getTranslationY());
        this.dividerDrawable.setBounds(r5, (r12 - this.dividerDrawable.getIntrinsicHeight()) - this.thickness, r7, r12);
        this.dividerDrawable.draw(r8);
        r1 = r1 + 1;
        goto L18
    L20:
        r8.restore();
        return;
    L16:
        r6 = this.insetEnd;
        goto L17
    L12:
        r3 = this.insetStart;
        goto L13
    L5:
        r2 = r9.getWidth();
        r0 = 0;
        goto L6
    }

    @ColorInt
    public int getDividerColor() {
        return this.color;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    @Px
    public int getDividerThickness() {
        return this.thickness;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect r1, @NonNull View r2, @NonNull RecyclerView r3, @NonNull RecyclerView.State r4) {
        r1.set(0, 0, 0, 0);
        if (this.orientation != 1) goto L5;
        r1.bottom = this.dividerDrawable.getIntrinsicHeight() + this.thickness;
        return;
    L5:
        r1.right = this.dividerDrawable.getIntrinsicWidth() + this.thickness;
    }

    public int getOrientation() {
        return this.orientation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas r2, @NonNull RecyclerView r3, @NonNull RecyclerView.State r4) {
        if (r3.getLayoutManager() != null) goto L6;
        return;
    L6:
        if (this.orientation != 1) goto L8;
        drawForVerticalOrientation(r2, r3);
        return;
    L8:
        drawForHorizontalOrientation(r2, r3);
    }

    public void setDividerColor(@ColorInt int r2) {
        this.color = r2;
        Drawable r0 = DrawableCompat.wrap(this.dividerDrawable);
        this.dividerDrawable = r0;
        DrawableCompat.setTint(r0, r2);
    }

    public void setDividerColorResource(@NonNull Context r1, @ColorRes int r2) {
        setDividerColor(ContextCompat.getColor(r1, r2));
    }

    public void setDividerInsetEnd(@Px int r1) {
        this.insetEnd = r1;
    }

    public void setDividerInsetEndResource(@NonNull Context r1, @DimenRes int r2) {
        setDividerInsetEnd(r1.getResources().getDimensionPixelOffset(r2));
    }

    public void setDividerInsetStart(@Px int r1) {
        this.insetStart = r1;
    }

    public void setDividerInsetStartResource(@NonNull Context r1, @DimenRes int r2) {
        setDividerInsetStart(r1.getResources().getDimensionPixelOffset(r2));
    }

    public void setDividerThickness(@Px int r1) {
        this.thickness = r1;
    }

    public void setDividerThicknessResource(@NonNull Context r1, @DimenRes int r2) {
        setDividerThickness(r1.getResources().getDimensionPixelSize(r2));
    }

    public void setOrientation(int r3) {
        if (r3 != 0) goto L4;
    L8:
        this.orientation = r3;
        return;
    L4:
        if (r3 == 1) goto L8;
        throw new IllegalArgumentException("Invalid orientation: " + r3 + ". It should be either HORIZONTAL or VERTICAL");
    }
}
