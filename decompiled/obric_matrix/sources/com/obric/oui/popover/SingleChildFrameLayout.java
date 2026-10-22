package com.obric.oui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/popover/SingleChildFrameLayout;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Lkotlin/f0;", "onMeasure", "(II)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class SingleChildFrameLayout extends OUIFrameLayout {
    public SingleChildFrameLayout(Context r9, AttributeSet r10) {
        o.f(r9, "context");
        super(r9, r10, 0, null, 12, null);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        View r0 = getChildAt(0);
        if (r0 == null) goto L14;
        int r1 = View.MeasureSpec.getMode(r6);
        int r8 = View.MeasureSpec.getSize(r6);
        int r2 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        int r3 = (r0.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
        int r4 = (r0.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom();
        if (r1 != Integer.MIN_VALUE) goto L8;
        if (r2 != Integer.MIN_VALUE) goto L8;
        setMeasuredDimension(r3, r4);
        return;
    L8:
        if (r1 != Integer.MIN_VALUE) goto L10;
        setMeasuredDimension(r3, r9);
        return;
    L10:
        if (r2 != Integer.MIN_VALUE) goto L12;
        setMeasuredDimension(r8, r4);
        return;
    L12:
        setMeasuredDimension(r8, r9);
        return;
    }
}
