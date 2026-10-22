package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SurnameFlowLayout extends ViewGroup {
    public final ArrayList b;
    public final ArrayList c;

    @Metadata
    public static final class Companion {
    }

    public SurnameFlowLayout(@Nullable Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        Intrinsics.f(r1, "p");
        return new ViewGroup.MarginLayoutParams(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        ArrayList r1 = this.b;
        r1.clear();
        ArrayList r2 = this.c;
        r2.clear();
        int r3 = getWidth();
        ArrayList r4 = new ArrayList();
        int r5 = getChildCount();
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L4:
        if (r7 >= r5) goto L13;
        View r11 = getChildAt(r7);
        Intrinsics.e(r11, "child");
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L12;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        int r10 = r11.getMeasuredWidth();
        int r14 = r11.getMeasuredHeight();
        if ((((r13.leftMargin + r10) + r13.rightMargin) + r9) <= r3) goto L10;
        r2.add(Integer.valueOf(r8));
        r1.add(r4);
        r4 = new ArrayList();
        r9 = 0;
    L10:
        r9 = r9 + ((r10 + r13.leftMargin) + r13.rightMargin);
        r8 = (int) Math.max(r8, (r14 + r13.topMargin) + r13.bottomMargin);
        r4.add(r11);
        r7 = r7 + 1;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        r2.add(Integer.valueOf(r8));
        r1.add(r4);
        int r0 = r1.size();
        int r6 = 0;
        int r15 = 0;
    L14:
        if (r6 >= r0) goto L27;
        List r16 = (List) r1.get(r6);
        int r17 = ((Number) r2.get(r6)).intValue();
        int r23 = r16.size();
        int r24 = 0;
        int r110 = 0;
    L16:
        if (r24 >= r23) goto L26;
        View r111 = (View) r16.get(r24);
        if (r111.getVisibility() == 8) goto L23;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L25;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r114 = r113.leftMargin + r110;
        int r115 = r113.topMargin + r15;
        int r25 = r111.getMeasuredWidth() + r114;
        int r26 = r111.getMeasuredHeight() + r115;
        Log.e("FlowLayout", r111.toString() + " , l = " + r114 + " , t = " + r20 + " , r =" + r25 + " , b = " + r26);
        r111.layout(r114, r115, r25, r26);
        r110 = r110 + ((r111.getMeasuredWidth() + r113.rightMargin) + r113.leftMargin);
        goto L23
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L23:
        r24 = r24 + 1;
        r0 = r0;
        r2 = r2;
        r1 = r1;
        goto L16
    L26:
        r15 = r15 + r17;
        r6 = r6 + 1;
        goto L14
    }

    @Override // android.view.View
    public final void onMeasure(int r18, int r19) {
        super.onMeasure(r18, r19);
        int r1 = View.MeasureSpec.getSize(r18);
        int r2 = View.MeasureSpec.getSize(r19);
        int r3 = View.MeasureSpec.getMode(r18);
        int r4 = View.MeasureSpec.getMode(r19);
        StringBuilder r5 = new StringBuilder();
        r5.append(r1);
        r5.append(',');
        r5.append(r2);
        Log.e("FlowLayout", r5.toString());
        int r6 = getChildCount();
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r7 >= r6) goto L16;
        View r12 = getChildAt(r7);
        measureChild(r12, r18, r19);
        Intrinsics.e(r12, "child");
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if (r14 == null) goto L15;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        int r16 = r2;
        int r17 = (r12.getMeasuredWidth() + r15.leftMargin) + r15.rightMargin;
        int r13 = (r12.getMeasuredHeight() + r15.topMargin) + r15.bottomMargin;
        int r110 = r9 + r17;
        if (r110 <= r1) goto L9;
        r8 = (int) Math.max(r9, r17);
        r11 = r11 + r10;
        r10 = r13;
        r9 = r17;
    L11:
        if (r7 != (r6 - 1)) goto L13;
        r11 = r11 + r10;
        r8 = (int) Math.max(r8, r9);
    L13:
        r7 = r7 + 1;
        r2 = r16;
        goto L3
    L9:
        r10 = (int) Math.max(r10, r13);
        r9 = r110;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        int r111 = r2;
        if (r3 == 1073741824) goto L20;
        r1 = r8;
    L20:
        if (r4 != 1073741824) goto L22;
        int r20 = r111;
    L23:
        setMeasuredDimension(r1, r20);
        return;
    L22:
        r20 = r11;
        goto L23
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        Intrinsics.f(r2, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), r2);
    }
}
