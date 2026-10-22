package com.obric.oui.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R;

/* JADX INFO: loaded from: classes4.dex */
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(Context r2) {
        this(r2, null);
    }

    public FlowLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FlowLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.singleLine = false;
        loadFromAttributes(r1, r2);
    }

    public FlowLayout(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.singleLine = false;
        loadFromAttributes(r1, r2);
    }

    private void loadFromAttributes(Context r3, AttributeSet r4) {
        TypedArray r5 = r3.getTheme().obtainStyledAttributes(r4, R.styleable.OChipGroup, 0, 0);
        this.lineSpacing = r5.getDimensionPixelSize(R.styleable.OChipGroup_oui_line_space, 0);
        this.itemSpacing = r5.getDimensionPixelSize(R.styleable.OChipGroup_oui_item_space, 0);
        r5.recycle();
    }

    protected int getLineSpacing() {
        return this.lineSpacing;
    }

    protected void setLineSpacing(int r1) {
        this.lineSpacing = r1;
    }

    protected int getItemSpacing() {
        return this.itemSpacing;
    }

    protected void setItemSpacing(int r1) {
        this.itemSpacing = r1;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    public void setSingleLine(boolean r1) {
        this.singleLine = r1;
    }

    @Override // android.view.View
    protected void onMeasure(int r21, int r22) {
        int r1 = View.MeasureSpec.getSize(r21);
        int r2 = View.MeasureSpec.getMode(r21);
        int r3 = View.MeasureSpec.getSize(r22);
        int r4 = View.MeasureSpec.getMode(r22);
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
        measureChild(r12, r21, r22);
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        int r13 = r16.leftMargin + 0;
        int r17 = r16.rightMargin + 0;
    L19:
        int r19 = r6;
        if (((r6 + r13) + r12.getMeasuredWidth()) > r8) goto L22;
    L24:
        int r14 = r19;
    L25:
        int r18 = (r14 + r13) + r12.getMeasuredWidth();
        int r110 = r9 + r12.getMeasuredHeight();
        if (r18 <= r11) goto L28;
        r11 = r18;
    L28:
        r6 = r14 + (((r13 + r17) + r12.getMeasuredWidth()) + this.itemSpacing);
        if (r10 != (getChildCount() - 1)) goto L31;
        r11 = r11 + r17;
    L31:
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
        setMeasuredDimension(getMeasuredDimension(r1, r2, r11 + getPaddingRight()), getMeasuredDimension(r3, r4, r7 + getPaddingBottom()));
        return;
    L5:
        if (r2 == 1073741824) goto L8;
        r5 = Integer.MAX_VALUE;
        goto L9
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
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
        int r18 = (r4 + r8) + r5.getMeasuredWidth();
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
        r4 = r4 + (((r8 + r9) + r5.getMeasuredWidth()) + this.itemSpacing);
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

    protected int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(View r1) {
        Object r0 = r1.getTag(R.id.row_index_key);
        if ((r0 instanceof Integer) == true) goto L7;
        return -1;
    L7:
        return ((Integer) r0).intValue();
    }
}
