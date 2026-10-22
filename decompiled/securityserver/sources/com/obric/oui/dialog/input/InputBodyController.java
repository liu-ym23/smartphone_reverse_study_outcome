package com.obric.oui.dialog.input;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.StyleController;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class InputBodyController implements StyleController {

    /* JADX INFO: renamed from: com.obric.oui.dialog.input.InputBodyController$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            throw null;
        }
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public final void a(Context r1, FrameLayout r2) {
        Intrinsics.f(r2, "parent");
        new FrameLayout.LayoutParams(-1, -2);
        throw null;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public final void b(OAlertDialog r1) {
        Intrinsics.f(r1, "dialog");
        r1.l = false;
    }
}
