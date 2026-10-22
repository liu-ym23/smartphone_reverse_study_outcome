package com.bytedanceos.security;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class AgreementDialog extends AlertDialog {
    private Activity mActivity;
    private OAlertDialog mPermissionDialog;
    private DialogInterface.OnClickListener mPositiveListener;

    static /* synthetic */ Activity access$000(AgreementDialog r0) {
        return r0.mActivity;
    }

    static /* synthetic */ OAlertDialog access$100(AgreementDialog r0) {
        return r0.mPermissionDialog;
    }

    public AgreementDialog(Activity activity, DialogInterface.OnClickListener positiveListener) {
        super(activity);
        this.mActivity = activity;
        this.mPositiveListener = positiveListener;
        initDialog(positiveListener);
    }

    private void initDialog(final DialogInterface.OnClickListener positiveListener) {
        OAlertDialog r5 = new OAlertDialogBuilder(this.mActivity).autoDismiss(false).title(R.string.first_launch_dialog_title).message(R.string.first_launch_dialog_msg).negativeButton(R.string.first_launch_dialog_negative, new AnonymousClass2(this)).positiveButton(R.string.first_launch_dialog_possitive, new AnonymousClass1(this, positiveListener)).build();
        this.mPermissionDialog = r5;
        r5.setOnKeyListener(new AnonymousClass3(this));
        this.mPermissionDialog.setCancelable(false);
    }

    @Override // android.app.Dialog
    public void show() {
        OAlertDialog r0 = this.mPermissionDialog;
        if (r0 == null) goto L6;
        r0.show();
        return;
    }
}
