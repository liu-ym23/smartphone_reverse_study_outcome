package com.obric.oui.indicator;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IndicatorExternalsKt {
    public static final void a(RadiusLayout r6, int r7) {
        Intrinsics.f(r6, "$this$setMarginBottom");
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L24;
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        int r4 = 0;
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        int r5 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r3);
    L11:
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        r2 = r8;
    L15:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r2;
        if (r9 == null) goto L18;
        int r10 = r9.topMargin;
    L19:
        ViewGroup.LayoutParams r11 = r6.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        r4 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r11);
    L22:
        r1.setMargins(r5, r10, r4, r7);
        r6.requestLayout();
        return;
    L18:
        r10 = 0;
        goto L19
    L10:
        r5 = 0;
        goto L11
    }

    public static final void b(View r1, int r2) {
        Intrinsics.f(r1, "$this$setWidth");
        r1.getLayoutParams().width = r2;
        r1.requestLayout();
    }
}
