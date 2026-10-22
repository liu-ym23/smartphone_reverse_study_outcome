package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class BaselineLayout extends ViewGroup {
    private int baseline;

    public BaselineLayout(Context r3) {
        super(r3, null, 0);
        this.baseline = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.baseline;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        int r12 = getChildCount();
        int r13 = getPaddingLeft();
        int r14 = ((r10 - r8) - getPaddingRight()) - r13;
        int r15 = getPaddingTop();
        int r16 = 0;
    L3:
        if (r16 >= r12) goto L15;
        View r0 = getChildAt(r16);
        if (r0.getVisibility() == 8) goto L14;
        int r1 = r0.getMeasuredWidth();
        int r2 = r0.getMeasuredHeight();
        int r3 = ((r14 - r1) / 2) + r13;
        if (this.baseline != (-1)) goto L10;
    L12:
        int r4 = r15;
    L13:
        r0.layout(r3, r4, r1 + r3, r2 + r4);
        goto L14
    L10:
        if (r0.getBaseline() == (-1)) goto L12;
        r4 = (this.baseline + r15) - r0.getBaseline();
    L14:
        r16 = r16 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r12, int r13) {
        int r0 = getChildCount();
        int r1 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = -1;
        int r7 = -1;
    L3:
        if (r1 >= r0) goto L12;
        View r8 = getChildAt(r1);
        if (r8.getVisibility() == 8) goto L11;
        measureChild(r8, r12, r13);
        int r9 = r8.getBaseline();
        if (r9 == (-1)) goto L10;
        r6 = Math.max(r6, r9);
        r7 = Math.max(r7, r8.getMeasuredHeight() - r9);
    L10:
        r4 = Math.max(r4, r8.getMeasuredWidth());
        r3 = Math.max(r3, r8.getMeasuredHeight());
        r5 = View.combineMeasuredStates(r5, r8.getMeasuredState());
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        if (r6 == (-1)) goto L14;
        r3 = Math.max(r3, Math.max(r7, getPaddingBottom()) + r6);
        this.baseline = r6;
    L14:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r4, getSuggestedMinimumWidth()), r12, r5), View.resolveSizeAndState(Math.max(r3, getSuggestedMinimumHeight()), r13, r5 << 16));
    }

    public BaselineLayout(Context r2, AttributeSet r3) {
        super(r2, r3, 0);
        this.baseline = -1;
    }

    public BaselineLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.baseline = -1;
    }
}
