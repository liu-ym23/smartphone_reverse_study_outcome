package com.obric.oui.titlebar;

import android.view.View;
import android.view.WindowInsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OFloatingTitleBar$initAttrs$$inlined$apply$lambda$1 implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r1, WindowInsets r2) {
        Intrinsics.f(r1, "<anonymous parameter 0>");
        Intrinsics.f(r2, "insets");
        r2.getSystemWindowInsetTop();
        int r0 = OFloatingTitleBar.b;
        throw null;
    }
}
