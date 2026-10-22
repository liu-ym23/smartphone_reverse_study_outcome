package com.obric.oui.push;

import a.a;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OPush$Builder$buildLayout$8 implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        Intrinsics.f(r5, BaseSwitches.V);
        Intrinsics.e(null, "contentView");
        float r4 = 80;
        int r2 = a.d("Resources.getSystem()", 1, r4);
        Resources r3 = Resources.getSystem();
        Intrinsics.e(r3, "Resources.getSystem()");
        int r6 = MathKt.a(TypedValue.applyDimension(1, r4, r3.getDisplayMetrics()));
        Intrinsics.e(null, "actionText");
        Intrinsics.e(null, "actionImage");
        ViewExtensionsKt.c(null, r2, r6, new View[]{null, null});
        throw null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        Intrinsics.f(r1, BaseSwitches.V);
    }
}
