package com.obric.oui.chip;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.securityserver.R;

/* JADX INFO: loaded from: classes2.dex */
public class FlowLayout extends ViewGroup {
    public int b;
    public int c;
    public boolean e;
    public int f;

    public int getItemSpacing() {
        return this.c;
    }

    public int getLineSpacing() {
        return this.b;
    }

    public int getRowCount() {
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        if (getChildCount() != 0) goto L6;
        this.f = 0;
        return;
    L6:
        this.f = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        boolean r16 = true;
    L10:
        if (r16 == false) goto L12;
        int r0 = getPaddingRight();
    L13:
        if (r16 == false) goto L15;
        int r1 = getPaddingLeft();
    L16:
        int r2 = getPaddingTop();
        int r17 = (r14 - r12) - r1;
        int r3 = 0;
        int r4 = r0;
        int r18 = r2;
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
        int r10 = r5.getMeasuredWidth() + (r4 + r8);
        if (this.e == true) goto L30;
        if (r10 <= r17) goto L30;
        r18 = this.b + r2;
        this.f++;
        r4 = r0;
    L30:
        r5.setTag(R.id.row_index_key, Integer.valueOf(this.f - 1));
        int r19 = r4 + r8;
        int r20 = r5.getMeasuredWidth() + r19;
        int r21 = r5.getMeasuredHeight() + r18;
        if (r16 == false) goto L33;
        r5.layout(r17 - r20, r18, (r17 - r4) - r8, r21);
    L34:
        r4 = r4 + ((r5.getMeasuredWidth() + (r8 + r9)) + this.c);
        r2 = r21;
        goto L35
    L33:
        r5.layout(r19, r18, r20, r21);
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
        r16 = false;
        goto L10
    }

    @Override // android.view.View
    public final void onMeasure(int r20, int r21) {
        int r1 = View.MeasureSpec.getSize(r20);
        int r2 = View.MeasureSpec.getMode(r20);
        int r3 = View.MeasureSpec.getSize(r21);
        int r4 = View.MeasureSpec.getMode(r21);
        if (r2 == Integer.MIN_VALUE) goto L7;
        if (r2 == 1073741824) goto L7;
        int r7 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L8:
        int r8 = getPaddingLeft();
        int r9 = getPaddingTop();
        int r10 = r7 - getPaddingRight();
        int r11 = r9;
        int r12 = 0;
        int r13 = 0;
    L10:
        if (r12 >= getChildCount()) goto L32;
        View r14 = getChildAt(r12);
        if (r14.getVisibility() == 8) goto L31;
        measureChild(r14, r20, r21);
        ViewGroup.LayoutParams r5 = r14.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        int r15 = r6.leftMargin;
        int r16 = r6.rightMargin;
    L18:
        int r18 = r8;
        if ((r14.getMeasuredWidth() + (r8 + r15)) > r10) goto L21;
    L23:
        int r17 = r18;
    L24:
        int r19 = r14.getMeasuredWidth() + (r17 + r15);
        int r110 = r14.getMeasuredHeight() + r11;
        if (r19 <= r13) goto L27;
        r13 = r19;
    L27:
        int r22 = ((r14.getMeasuredWidth() + (r15 + r16)) + this.c) + r17;
        if (r12 != (getChildCount() - 1)) goto L30;
        r13 = r13 + r16;
    L30:
        r8 = r22;
        r9 = r110;
        goto L31
    L21:
        if (this.e == true) goto L23;
        r17 = getPaddingLeft();
        r11 = this.b + r9;
        goto L24
    L17:
        r16 = 0;
        r15 = 0;
    L31:
        r12 = r12 + 1;
        goto L10
    L32:
        int r23 = getPaddingRight() + r13;
        int r24 = getPaddingBottom() + r9;
        if (r2 == Integer.MIN_VALUE) goto L37;
        int r25 = BasicMeasure.EXACTLY;
        if (r2 == 1073741824) goto L38;
        r1 = r23;
    L38:
        if (r4 == Integer.MIN_VALUE) goto L41;
        if (r4 == r25) goto L42;
        r3 = r24;
    L42:
        setMeasuredDimension(r1, r3);
        return;
    L41:
        r3 = Math.min(r24, r3);
        goto L42
    L37:
        r25 = BasicMeasure.EXACTLY;
        r1 = Math.min(r23, r1);
    L7:
        r7 = r1;
        goto L8
    }

    public void setItemSpacing(int r1) {
        this.c = r1;
    }

    public void setLineSpacing(int r1) {
        this.b = r1;
    }

    public void setSingleLine(boolean r1) {
        this.e = r1;
    }
}
