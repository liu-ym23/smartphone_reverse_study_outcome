package com.obric.oui.dialog.v2.alert;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.bytedance.securityserver.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public class OAlertDialog extends AbstractDialog implements DialogContainer {
    public static final /* synthetic */ int p = 0;

    /* JADX INFO: renamed from: com.obric.oui.dialog.v2.alert.OAlertDialog$onStart$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ OAlertDialog b;

        public AnonymousClass1(OAlertDialog r1) {
            this.b = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OAlertDialog r0 = this.b;
            r0.getClass();
            r0.getClass();
        }
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final int b() {
        return R.layout.o_alert_dialog_v2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ViewPropertySpringAnimator r0 = DialogAnimStyle.e(d(), getWindow(), true, true);
        Function1<ViewPropertySpringAnimator<View>, Unit> r1 = new OAlertDialog$performExitAnimation$$inlined$apply$lambda$1(this);
        ViewPropertySpringAnimator.c(r0, null, new OAlertDialog$performExitAnimation$$inlined$apply$lambda$2(this), r1, 1);
        r0.d();
    }

    public final void g() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        d().post(new OAlertDialog$performEnterAnimation$1(this));
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public final void show() {
        super.show();
        Intrinsics.e(getContext(), "context");
    }
}
