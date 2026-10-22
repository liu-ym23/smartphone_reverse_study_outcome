package com.android.settings.widget;

import android.app.Activity;
import android.content.DialogInterface;
import com.android.settings.R;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;

/* JADX INFO: loaded from: classes.dex */
public class SimplePasswordDialog {

    public interface OnSimplePasswordListener {
        void onSimplePassword();
    }

    public SimplePasswordDialog() {
    }

    public static void showDialog(Activity r2, final OnSimplePasswordListener r3) {
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(r2);
        r0.autoDismiss(false);
        r0.title(R.string.dlg_title_notice);
        r0.message(R.string.reset_password_detail);
        r0.verticalButton();
        r0.positiveButton(r2.getString(R.string.reset_password), new SimplePasswordDialog$$ExternalSyntheticLambda0(r3));
        r0.show();
    }

    static /* synthetic */ void lambda$showDialog$0(OnSimplePasswordListener r0, DialogInterface r1, int r2) {
        if (r1 == null) goto L4;
        r1.dismiss();
    L4:
        if (r0 == null) goto L7;
        r0.onSimplePassword();
        return;
    }
}
