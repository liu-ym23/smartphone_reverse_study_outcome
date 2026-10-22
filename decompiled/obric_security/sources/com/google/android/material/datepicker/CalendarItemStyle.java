package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
final class CalendarItemStyle {
    private final ColorStateList backgroundColor;
    private final Rect insets;
    private final ShapeAppearanceModel itemShape;
    private final ColorStateList strokeColor;
    private final int strokeWidth;
    private final ColorStateList textColor;

    private CalendarItemStyle(ColorStateList r2, ColorStateList r3, ColorStateList r4, int r5, ShapeAppearanceModel r6, Rect r7) {
        Preconditions.checkArgumentNonnegative(r7.left);
        Preconditions.checkArgumentNonnegative(r7.top);
        Preconditions.checkArgumentNonnegative(r7.right);
        Preconditions.checkArgumentNonnegative(r7.bottom);
        this.insets = r7;
        this.textColor = r3;
        this.backgroundColor = r2;
        this.strokeColor = r4;
        this.strokeWidth = r5;
        this.itemShape = r6;
    }

    static CalendarItemStyle create(Context r12, int r13) {
        if (r13 == 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray r14 = r12.obtainStyledAttributes(r13, R.styleable.MaterialCalendarItem);
        Rect r11 = new Rect(r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList r6 = MaterialResources.getColorStateList(r12, r14, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList r7 = MaterialResources.getColorStateList(r12, r14, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList r8 = MaterialResources.getColorStateList(r12, r14, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int r9 = r14.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ShapeAppearanceModel r10 = ShapeAppearanceModel.builder(r12, r14.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), r14.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        r14.recycle();
        return new CalendarItemStyle(r6, r7, r8, r9, r10, r11);
    L5:
        r1 = false;
        goto L6
    }

    void styleItem(TextView r10) {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        MaterialShapeDrawable r1 = new MaterialShapeDrawable();
        r0.setShapeAppearanceModel(this.itemShape);
        r1.setShapeAppearanceModel(this.itemShape);
        r0.setFillColor(this.backgroundColor);
        r0.setStroke(this.strokeWidth, this.strokeColor);
        r10.setTextColor(this.textColor);
        ViewCompat.setBackground(r10, new InsetDrawable(new RippleDrawable(this.textColor.withAlpha(30), r0, r1), this.insets.left, this.insets.top, this.insets.right, this.insets.bottom));
    }

    int getLeftInset() {
        return this.insets.left;
    }

    int getRightInset() {
        return this.insets.right;
    }

    int getTopInset() {
        return this.insets.top;
    }

    int getBottomInset() {
        return this.insets.bottom;
    }
}
