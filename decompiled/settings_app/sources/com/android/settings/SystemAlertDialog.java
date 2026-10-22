package com.android.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class SystemAlertDialog extends AlertDialog {
    private final Context mContext;

    public SystemAlertDialog(Context r2) {
        this(r2, 5);
    }

    public SystemAlertDialog(Context r1, int r2) {
        super(r1, r2);
        this.mContext = r1;
        applyFlags(this);
        WindowManager.LayoutParams r3 = getWindow().getAttributes();
        r3.setTitle(getClass().getSimpleName());
        getWindow().setAttributes(r3);
    }

    public void setMessage(int r2) {
        setMessage(this.mContext.getString(r2));
    }

    public void setPositiveButton(int r2, DialogInterface.OnClickListener r3) {
        setButton(-1, this.mContext.getString(r2), r3);
    }

    public void setNegativeButton(int r2, DialogInterface.OnClickListener r3) {
        setButton(-2, this.mContext.getString(r2), r3);
    }

    public static void applyFlags(AlertDialog r2) {
        r2.getWindow().setType(2014);
        r2.getWindow().addFlags(655360);
    }
}
