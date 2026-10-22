package com.obric.oui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SingleChildFrameLayout extends OUIFrameLayout {
    @JvmOverloads
    public SingleChildFrameLayout(@NotNull Context r3, @Nullable AttributeSet r4) {
        Intrinsics.f(r3, "context");
        super(r3, r4, 0, 12);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        View r0 = getChildAt(0);
        if (r0 == null) goto L14;
        int r1 = View.MeasureSpec.getMode(r6);
        int r8 = View.MeasureSpec.getSize(r6);
        int r2 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        int r3 = r0.getMeasuredWidth();
        int r4 = getPaddingLeft() + r3;
        int r5 = getPaddingRight() + r4;
        int r10 = r0.getMeasuredHeight();
        int r11 = getPaddingTop() + r10;
        int r12 = getPaddingBottom() + r11;
        if (r1 != Integer.MIN_VALUE) goto L8;
        if (r2 != Integer.MIN_VALUE) goto L8;
        setMeasuredDimension(r5, r12);
        return;
    L8:
        if (r1 != Integer.MIN_VALUE) goto L10;
        setMeasuredDimension(r5, r9);
        return;
    L10:
        if (r2 != Integer.MIN_VALUE) goto L12;
        setMeasuredDimension(r8, r12);
        return;
    L12:
        setMeasuredDimension(r8, r9);
        return;
    }
}
