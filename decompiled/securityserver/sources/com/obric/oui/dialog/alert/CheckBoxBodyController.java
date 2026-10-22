package com.obric.oui.dialog.alert;

import android.content.Context;
import android.widget.FrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class CheckBoxBodyController implements StyleController {
    @Override // com.obric.oui.dialog.alert.StyleController
    public final void a(Context r1, FrameLayout r2) {
        Intrinsics.f(r2, "parent");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 1;
        r2.addView(null, r0);
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public final void b(OAlertDialog r1) {
        Intrinsics.f(r1, "dialog");
        r1.l = false;
    }
}
