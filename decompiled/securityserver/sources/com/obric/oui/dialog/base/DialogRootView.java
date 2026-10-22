package com.obric.oui.dialog.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DialogRootView extends RadiusLayout {
    @JvmOverloads
    public DialogRootView(@NotNull Context r2, @Nullable AttributeSet r3) {
        Intrinsics.f(r2, "context");
        super(r2, r3, 0);
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r7, int r8) {
        Context r0 = getContext();
        Intrinsics.e(r0, "context");
        int r1 = (int) (((double) OUnitExtensionKt.b(r0)) * 0.9d);
        int r2 = View.MeasureSpec.getSize(r8);
        int r9 = View.MeasureSpec.getMode(r8);
        if (r9 == Integer.MIN_VALUE) goto L7;
        if (r9 == 0) goto L6;
        int r10 = View.MeasureSpec.makeMeasureSpec(Math.min(r2, r1), BasicMeasure.EXACTLY);
    L9:
        if (View.MeasureSpec.getMode(r7) != Integer.MIN_VALUE) goto L11;
        Context r11 = getContext();
        Intrinsics.e(r11, "context");
        r7 = View.MeasureSpec.makeMeasureSpec(OUnitExtensionKt.c(r11), BasicMeasure.EXACTLY);
    L11:
        super.onMeasure(r7, r10);
        return;
    L6:
        r10 = View.MeasureSpec.makeMeasureSpec(r1, Integer.MIN_VALUE);
        goto L9
    L7:
        r10 = View.MeasureSpec.makeMeasureSpec(Math.min(r2, r1), Integer.MIN_VALUE);
        goto L9
    }
}
