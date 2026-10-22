package com.android.settings.applications;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.INotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.net.NetworkPolicyManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ServiceManager;
import android.webkit.IWebViewUpdateService;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class ResetAppsHelper implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    private static final String EXTRA_RESET_DIALOG = "resetDialog";
    private final AppOpsManager mAom;
    private final Context mContext;
    private final IPackageManager mIPm;
    private final INotificationManager mNm;
    private final NetworkPolicyManager mNpm;
    private final PackageManager mPm;
    private AlertDialog mResetDialog;
    private final IWebViewUpdateService mWvus;

    static /* synthetic */ PackageManager access$000(ResetAppsHelper r0) {
        return r0.mPm;
    }

    static /* synthetic */ INotificationManager access$100(ResetAppsHelper r0) {
        return r0.mNm;
    }

    static /* synthetic */ boolean access$200(ResetAppsHelper r0, String r1) {
        return r0.isNonEnableableFallback(r1);
    }

    static /* synthetic */ IPackageManager access$300(ResetAppsHelper r0) {
        return r0.mIPm;
    }

    static /* synthetic */ AppOpsManager access$400(ResetAppsHelper r0) {
        return r0.mAom;
    }

    static /* synthetic */ NetworkPolicyManager access$500(ResetAppsHelper r0) {
        return r0.mNpm;
    }

    public ResetAppsHelper(Context r2) {
        this.mContext = r2;
        this.mPm = r2.getPackageManager();
        this.mIPm = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
        this.mNm = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        this.mWvus = IWebViewUpdateService.Stub.asInterface(ServiceManager.getService("webviewupdate"));
        this.mNpm = NetworkPolicyManager.from(r2);
        this.mAom = (AppOpsManager) r2.getSystemService("appops");
    }

    public void onRestoreInstanceState(Bundle r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getBoolean(EXTRA_RESET_DIALOG) == false) goto L8;
        buildResetDialog();
        return;
    }

    public void onSaveInstanceState(Bundle r2) {
        if (this.mResetDialog == null) goto L6;
        r2.putBoolean(EXTRA_RESET_DIALOG, true);
        return;
    }

    public void stop() {
        AlertDialog r0 = this.mResetDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mResetDialog = null;
        return;
    }

    void buildResetDialog() {
        if (this.mResetDialog != null) goto L6;
        this.mResetDialog = new AlertDialog.Builder(this.mContext).setTitle(R.string.reset_app_preferences_title).setMessage(R.string.reset_app_preferences_desc).setPositiveButton(R.string.reset_app_preferences_button, this).setNegativeButton(R.string.cancel, null).setOnDismissListener(this).show();
        return;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r2) {
        if (this.mResetDialog != r2) goto L6;
        this.mResetDialog = null;
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (this.mResetDialog == r1) goto L5;
        return;
    L5:
        AsyncTask.execute(new AnonymousClass1(this));
    }

    private boolean isNonEnableableFallback(String r1) {
        return MultiSDKAdapterNew.isFallbackPackage(this.mWvus, r1);
    }
}
