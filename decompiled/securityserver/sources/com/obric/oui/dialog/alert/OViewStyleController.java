package com.obric.oui.dialog.alert;

import android.content.Context;
import android.widget.FrameLayout;
import com.obric.appstore.autoupdate.a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class OViewStyleController implements StyleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f215a;

    public OViewStyleController(a r1) {
        this.f215a = r1;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public final void a(Context r1, FrameLayout r2) {
        Intrinsics.f(r2, "parent");
        this.f215a.invoke(r2);
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public final void b(OAlertDialog r1) {
        Intrinsics.f(r1, "dialog");
    }
}
