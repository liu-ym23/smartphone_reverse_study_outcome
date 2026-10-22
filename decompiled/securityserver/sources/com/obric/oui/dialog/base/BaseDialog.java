package com.obric.oui.dialog.base;

import android.view.View;
import androidx.annotation.RequiresApi;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public abstract class BaseDialog extends AbstractDialog {

    @Metadata
    public static final class Companion {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ViewPropertySpringAnimator r0 = DialogAnimStyle.e(d(), getWindow(), true, false);
        Function1<ViewPropertySpringAnimator<View>, Unit> r1 = new BaseDialog$performExitAnimation$$inlined$apply$lambda$1(this);
        ViewPropertySpringAnimator.c(r0, null, new BaseDialog$performExitAnimation$$inlined$apply$lambda$2(this), r1, 1);
        r0.d();
    }

    public final void g() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        L.c("BaseDialog", "origin Dismiss exception!", e);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        d().post(new BaseDialog$performEnterAnimation$1(this));
    }
}
