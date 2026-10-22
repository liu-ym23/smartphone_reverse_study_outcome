package com.android.settings.vpn2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
class AppDialog extends AlertDialog implements DialogInterface.OnClickListener {
    private final String mLabel;
    private final Listener mListener;
    private final PackageInfo mPackageInfo;

    public interface Listener {
        void onForget(DialogInterface r1);
    }

    AppDialog(Context r1, Listener r2, PackageInfo r3, String r4) {
        super(r1);
        this.mListener = r2;
        this.mPackageInfo = r3;
        this.mLabel = r4;
    }

    public final PackageInfo getPackageInfo() {
        return this.mPackageInfo;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle r5) {
        setTitle(this.mLabel);
        setMessage(getContext().getString(R.string.vpn_version, new Object[]{this.mPackageInfo.versionName}));
        createButtons();
        super.onCreate(r5);
    }

    protected void createButtons() {
        Context r0 = getContext();
        setButton(-2, r0.getString(R.string.vpn_forget), this);
        setButton(-1, r0.getString(R.string.vpn_done), this);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r2, int r3) {
        if (r3 != (-2)) goto L5;
        this.mListener.onForget(r2);
    L5:
        dismiss();
    }
}
