package com.android.settingslib.notification;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ZenRadioLayout extends LinearLayout {
    public ZenRadioLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r12, int r13) {
        super.onMeasure(r12, r13);
        int r0 = 0;
        ViewGroup r1 = (ViewGroup) getChildAt(0);
        ViewGroup r3 = (ViewGroup) getChildAt(1);
        int r4 = r1.getChildCount();
        if (r4 != r3.getChildCount()) goto L20;
        View r6 = null;
        boolean r5 = false;
    L5:
        if (r0 >= r4) goto L16;
        View r7 = r1.getChildAt(r0);
        View r8 = r3.getChildAt(r0);
        if (r6 == null) goto L9;
        r7.setAccessibilityTraversalAfter(r6.getId());
    L9:
        View r9 = findFirstClickable(r8);
        if (r9 == null) goto L12;
        r9.setAccessibilityTraversalAfter(r7.getId());
    L12:
        r6 = findLastClickable(r8);
        if (r7.getLayoutParams().height == r8.getMeasuredHeight()) goto L15;
        r7.getLayoutParams().height = r8.getMeasuredHeight();
        r5 = true;
    L15:
        r0 = r0 + 1;
        goto L5
    L16:
        if (r5 == false) goto L24;
        super.onMeasure(r12, r13);
        return;
    L24:
        return;
    L20:
        throw new IllegalStateException("Expected matching children");
    }

    private View findFirstClickable(View r3) {
        if (r3.isClickable() == false) goto L6;
        return r3;
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L14;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = 0;
    L9:
        if (r0 >= r4.getChildCount()) goto L18;
        View r1 = findFirstClickable(r4.getChildAt(r0));
        if (r1 != null) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r1;
    L18:
        return null;
    L14:
        return null;
    }

    private View findLastClickable(View r3) {
        if (r3.isClickable() == false) goto L6;
        return r3;
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L13;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount() - 1;
    L8:
        if (r0 < 0) goto L17;
        View r1 = findLastClickable(r4.getChildAt(r0));
        if (r1 != null) goto L11;
        r0 = r0 - 1;
        goto L8
    L11:
        return r1;
    L17:
        return null;
    L13:
        return null;
    }
}
