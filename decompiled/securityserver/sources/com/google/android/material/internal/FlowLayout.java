package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(@NonNull Context r2) {
        this(r2, null);
    }

    private static int getMeasuredDimension(int r1, int r2, int r3) {
        if (r2 == Integer.MIN_VALUE) goto L9;
        if (r2 == 1073741824) goto L7;
        return r3;
    L7:
        return r1;
    L9:
        return Math.min(r3, r1);
    }

    private void loadFromAttributes(@NonNull Context r3, @Nullable AttributeSet r4) {
        TypedArray r5 = r3.getTheme().obtainStyledAttributes(r4, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = r5.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = r5.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        r5.recycle();
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(@NonNull View r1) {
        Object r0 = r1.getTag(R.id.row_index_key);
        if ((r0 instanceof Integer) == true) goto L7;
        return -1;
    L7:
        return ((Integer) r0).intValue();
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (getChildCount() != 0) goto L6;
        this.rowCount = 0;
        return;
    L6:
        this.rowCount = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L12;
        int r0 = getPaddingRight();
    L13:
        if (r15 == false) goto L15;
        int r1 = getPaddingLeft();
    L16:
        int r2 = getPaddingTop();
        int r16 = (r13 - r11) - r1;
        int r3 = 0;
        int r4 = r0;
        int r17 = r2;
    L18:
        if (r3 >= getChildCount()) goto L36;
        View r5 = getChildAt(r3);
        if (r5.getVisibility() != 8) goto L22;
        r5.setTag(R.id.row_index_key, -1);
    L35:
        r3 = r3 + 1;
        goto L18
    L22:
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        int r8 = MarginLayoutParamsCompat.getMarginStart(r7);
        int r9 = MarginLayoutParamsCompat.getMarginEnd(r7);
    L26:
        int r18 = r5.getMeasuredWidth() + (r4 + r8);
        if (this.singleLine == true) goto L30;
        if (r18 <= r16) goto L30;
        r17 = this.lineSpacing + r2;
        this.rowCount++;
        r4 = r0;
    L30:
        r5.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
        int r19 = r4 + r8;
        int r20 = r5.getMeasuredWidth() + r19;
        int r21 = r5.getMeasuredHeight() + r17;
        if (r15 == false) goto L33;
        r5.layout(r16 - r20, r17, (r16 - r4) - r8, r21);
    L34:
        r4 = r4 + ((r5.getMeasuredWidth() + (r8 + r9)) + this.itemSpacing);
        r2 = r21;
        goto L35
    L33:
        r5.layout(r19, r17, r20, r21);
        goto L34
    L25:
        r9 = 0;
        r8 = 0;
        goto L26
    L36:
        return;
    L15:
        r1 = getPaddingRight();
        goto L16
    L12:
        r0 = getPaddingLeft();
        goto L13
    L9:
        r15 = false;
        goto L10
    }

    @Override // android.view.View
    public void onMeasure(int r20, int r21) {
        int r1 = View.MeasureSpec.getSize(r20);
        int r2 = View.MeasureSpec.getMode(r20);
        int r3 = View.MeasureSpec.getSize(r21);
        int r4 = View.MeasureSpec.getMode(r21);
        if (r2 != Integer.MIN_VALUE) goto L5;
    L8:
        int r5 = r1;
    L9:
        int r6 = getPaddingLeft();
        int r7 = getPaddingTop();
        int r8 = r5 - getPaddingRight();
        int r9 = r7;
        int r10 = 0;
        int r11 = 0;
    L11:
        if (r10 >= getChildCount()) goto L33;
        View r12 = getChildAt(r10);
        if (r12.getVisibility() == 8) goto L32;
        measureChild(r12, r20, r21);
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        int r13 = r16.leftMargin;
        int r17 = r16.rightMargin;
    L19:
        int r18 = r6;
        if ((r12.getMeasuredWidth() + (r6 + r13)) > r8) goto L22;
    L24:
        int r14 = r18;
    L25:
        int r19 = r12.getMeasuredWidth() + (r14 + r13);
        int r110 = r12.getMeasuredHeight() + r9;
        if (r19 <= r11) goto L28;
        r11 = r19;
    L28:
        int r22 = ((r12.getMeasuredWidth() + (r13 + r17)) + this.itemSpacing) + r14;
        if (r10 != (getChildCount() - 1)) goto L31;
        r11 = r11 + r17;
    L31:
        r6 = r22;
        r7 = r110;
        goto L32
    L22:
        if (isSingleLine() == true) goto L24;
        r14 = getPaddingLeft();
        r9 = this.lineSpacing + r7;
        goto L25
    L18:
        r13 = 0;
        r17 = 0;
    L32:
        r10 = r10 + 1;
        goto L11
    L33:
        setMeasuredDimension(getMeasuredDimension(r1, r2, getPaddingRight() + r11), getMeasuredDimension(r3, r4, getPaddingBottom() + r7));
        return;
    L5:
        if (r2 == 1073741824) goto L8;
        r5 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        goto L9
    }

    public void setItemSpacing(int r1) {
        this.itemSpacing = r1;
    }

    public void setLineSpacing(int r1) {
        this.lineSpacing = r1;
    }

    public void setSingleLine(boolean r1) {
        this.singleLine = r1;
    }

    public FlowLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FlowLayout(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.singleLine = false;
        loadFromAttributes(r1, r2);
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context r1, @Nullable AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.singleLine = false;
        loadFromAttributes(r1, r2);
    }
}
