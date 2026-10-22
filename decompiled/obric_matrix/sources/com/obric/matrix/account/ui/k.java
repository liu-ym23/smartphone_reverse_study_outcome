package com.obric.matrix.account.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"Lcom/obric/matrix/account/ui/AccountDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k extends Dialog {
    public k(Context r2) {
        kotlin.n0.d.o.f(r2, "context");
        super(r2);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        requestWindowFeature(1);
        setContentView(com.obric.matrix.account.h.f8490e);
        setCancelable(false);
        Window r2 = getWindow();
        if (r2 == null) goto L5;
        WindowManager.LayoutParams r0 = r2.getAttributes();
    L6:
        if (r0 == null) goto L8;
        r0.width = -1;
        r0.height = -1;
        r0.gravity = 17;
    L8:
        if (r2 == null) goto L12;
        View r1 = r2.getDecorView();
        if (r1 == null) goto L12;
        r1.setPadding(0, 0, 0, 0);
    L12:
        if (r2 == null) goto L14;
        r2.setBackgroundDrawable(new ColorDrawable(0));
    L14:
        if (r2 == null) goto L17;
        r2.setDimAmount(0.2f);
        return;
    L17:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
