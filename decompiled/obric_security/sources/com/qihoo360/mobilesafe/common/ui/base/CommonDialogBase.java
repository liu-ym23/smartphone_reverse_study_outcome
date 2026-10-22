package com.qihoo360.mobilesafe.common.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class CommonDialogBase extends Dialog {
    public CommonDialogBase(Context r1) {
        super(r1);
    }

    public CommonDialogBase(Context r1, int r2) {
        super(r1, r2);
    }

    @Override // android.app.Dialog
    public void show() {
        Context r0 = getContext();     // Catch: Throwable -> L14
        if (r0 == null) goto L10;
        if ((r0 instanceof Activity) == false) goto L10;
        if (((Activity) r0).isFinishing() == false) goto L10;
        return;
    L10:
        if (isShowing() == false) goto L12;
        return;
    L12:
        super.show();     // Catch: Throwable -> L14
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Context r0 = getContext();     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        if ((r0 instanceof Activity) == false) goto L10;
        if (((Activity) r0).isFinishing() == false) goto L10;
        return;
    L10:
        if (isShowing() == false) goto L16;
        super.dismiss();     // Catch: Throwable -> L13
        return;
    L16:
        return;
    }
}
