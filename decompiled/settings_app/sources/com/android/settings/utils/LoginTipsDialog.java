package com.android.settings.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.accounts.OAccountHelper;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class LoginTipsDialog {
    private static final String TAG = "LoginTipsDialog";

    public LoginTipsDialog() {
    }

    public static OAlertDialog showDialog(final Activity r3, final Intent r4) {
        OAlertDialog r5 = new OAlertDialogBuilder(r3).autoDismiss(false).title(R.string.system_account_logout_dialog_login_title).message(R.string.system_account_logout_dialog_login_message).horizontalButton().negativeButton(R.string.system_account_logout_dialog_login_btn_cancel, new LoginTipsDialog$$ExternalSyntheticLambda0()).positiveButton(R.string.system_account_logout_dialog_login_btn_confirm, new LoginTipsDialog$$ExternalSyntheticLambda1(r3, r4)).build();
        r5.show();
        return r5;
    }

    static /* synthetic */ void lambda$showDialog$0(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    static /* synthetic */ void lambda$showDialog$1(Activity r0, Intent r1, DialogInterface r2, int r3) {
        systemAccountLogin(r0, r1);
        r2.dismiss();
    }

    private static void systemAccountLogin(Activity r1, Intent r2) {
        OAccountHelper.prepareAccountLaunchIntent(r1, r2);     // Catch: Exception -> L4
        Utils.startActivity(r1, r2, 0, 0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "start account app error:" + e);
    }
}
