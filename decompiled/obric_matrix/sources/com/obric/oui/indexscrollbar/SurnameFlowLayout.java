package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00190\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b¨\u0006$"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup$LayoutParams;", "p", "generateLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;", "Landroid/util/AttributeSet;", "attrs", "(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "", "widthMeasureSpec", "heightMeasureSpec", "Lkotlin/f0;", "onMeasure", "(II)V", "", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "", "g", "Ljava/util/List;", "mLineHeight", "Landroid/view/View;", "f", "mAllViews", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class SurnameFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<List<View>> f11069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<Integer> f11070g;

    static {
    }

    public SurnameFlowLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f11069f = new ArrayList();
        this.f11070g = new ArrayList();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        o.f(r2, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        o.f(r1, "p");
        return new ViewGroup.MarginLayoutParams(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        SurnameFlowLayout r0 = this;
        r0.f11069f.clear();
        r0.f11070g.clear();
        int r1 = getWidth();
        ArrayList r2 = new ArrayList();
        int r3 = getChildCount();
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r5 >= r3) goto L9;
        View r9 = r0.getChildAt(r5);
        o.e(r9, "child");
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        int r8 = r9.getMeasuredWidth();
        int r12 = r9.getMeasuredHeight();
        if ((((r11.leftMargin + r8) + r11.rightMargin) + r7) <= r1) goto L8;
        r0.f11070g.add(Integer.valueOf(r6));
        r0.f11069f.add(r2);
        r2 = new ArrayList();
        r7 = 0;
    L8:
        r7 = r7 + ((r8 + r11.leftMargin) + r11.rightMargin);
        r6 = (int) Math.max(r6, (r12 + r11.topMargin) + r11.bottomMargin);
        r2.add(r9);
        r5 = r5 + 1;
        goto L4
    L9:
        r0.f11070g.add(Integer.valueOf(r6));
        r0.f11069f.add(r2);
        int r4 = r0.f11069f.size();
        int r13 = 0;
        int r14 = 0;
    L10:
        if (r13 >= r4) goto L19;
        List<View> r15 = r0.f11069f.get(r13);
        int r16 = r0.f11070g.get(r13).intValue();
        int r17 = r15.size();
        int r23 = 0;
        int r110 = 0;
    L12:
        if (r23 >= r17) goto L18;
        View r111 = r15.get(r23);
        if (r111.getVisibility() == 8) goto L17;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        Objects.requireNonNull(r112, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r114 = r113.leftMargin + r110;
        int r115 = r113.topMargin + r14;
        int r116 = r111.getMeasuredWidth() + r114;
        int r24 = r115 + r111.getMeasuredHeight();
        Log.e("FlowLayout", r111.toString() + " , l = " + r114 + " , t = " + r20 + " , r =" + r116 + " , b = " + r24);
        r111.layout(r114, r115, r116, r24);
        r110 = r110 + ((r111.getMeasuredWidth() + r113.rightMargin) + r113.leftMargin);
    L17:
        r23 = r23 + 1;
        r4 = r4;
        goto L12
    L18:
        r14 = r14 + r16;
        r13 = r13 + 1;
        r0 = this;
        goto L10
    }

    @Override // android.view.View
    protected void onMeasure(int r18, int r19) {
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
        if (r7 >= r6) goto L12;
        View r12 = getChildAt(r7);
        measureChild(r12, r18, r19);
        o.e(r12, "child");
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        int r16 = r2;
        int r17 = (r12.getMeasuredWidth() + r15.leftMargin) + r15.rightMargin;
        int r13 = (r12.getMeasuredHeight() + r15.topMargin) + r15.bottomMargin;
        int r110 = r9 + r17;
        if (r110 <= r1) goto L7;
        r8 = (int) Math.max(r9, r17);
        r11 = r11 + r10;
        r10 = r13;
        r9 = r17;
    L9:
        if (r7 != (r6 - 1)) goto L11;
        r11 = r11 + r10;
        r8 = (int) Math.max(r8, r9);
    L11:
        r7 = r7 + 1;
        r2 = r16;
        goto L3
    L7:
        r10 = (int) Math.max(r10, r13);
        r9 = r110;
        goto L9
    L12:
        int r111 = r2;
        if (r3 == 1073741824) goto L16;
        r1 = r8;
    L16:
        if (r4 != 1073741824) goto L18;
        int r20 = r111;
    L19:
        setMeasuredDimension(r1, r20);
        return;
    L18:
        r20 = r11;
        goto L19
    }
}
