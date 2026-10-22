package com.android.settings.wifi;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class WifiNoInternetDialog extends AlertActivity implements DialogInterface.OnClickListener {
    private static final String TAG = "WifiNoInternetDialog";
    private CheckBox mAlwaysAllow;
    private ConnectivityManager mCM;
    private Network mNetwork;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private String mNetworkName;

    public WifiNoInternetDialog() {
    }

    static /* synthetic */ Network access$000(WifiNoInternetDialog r0) {
        return r0.mNetwork;
    }

    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        Intent r5 = getIntent();
        if (r5 != null) goto L5;
    L28:
        OLog.e(TAG, "Unexpected intent " + r5 + ", exiting");
        finish();
        return;
    L5:
        if (Objects.equals(r5.getAction(), "android.net.action.PROMPT_UNVALIDATED") == false) goto L28;
        if ("netId".equals(r5.getScheme()) == false) goto L28;
        this.mNetwork = new Network(Integer.parseInt(r5.getData().getSchemeSpecificPart()));     // Catch: Throwable -> L11
    L13:
        if (this.mNetwork != null) goto L16;
        OLog.e(TAG, "Can't determine network from '" + r5.getData() + "' , exiting");
        finish();
        return;
    L16:
        NetworkRequest r6 = new NetworkRequest.Builder().clearCapabilities().build();
        this.mNetworkCallback = new AnonymousClass1(this);
        ConnectivityManager r1 = (ConnectivityManager) getSystemService("connectivity");
        this.mCM = r1;
        r1.registerNetworkCallback(r6, this.mNetworkCallback);
        NetworkInfo r7 = this.mCM.getNetworkInfo(this.mNetwork);
        if (r7 != null) goto L19;
    L26:
        OLog.d(TAG, "Network " + this.mNetwork + " is not connected: " + r7);
        finish();
        return;
    L19:
        if (r7.isConnectedOrConnecting() == false) goto L26;
        String r8 = r7.getExtraInfo();
        this.mNetworkName = r8;
        if (r8 == null) goto L24;
        this.mNetworkName = r8.replaceAll("^\"|\"$", "");
    L24:
        createDialog();
        return;
    L11:
        this.mNetwork = null;
        goto L13
    }

    private void createDialog() {
        this.mAlert.setIcon(R.drawable.ic_settings_wireless);
        AlertController.AlertParams r0 = this.mAlertParams;
        r0.mTitle = this.mNetworkName;
        r0.mMessage = getString(R.string.no_internet_access_text);
        r0.mPositiveButtonText = getString(R.string.yes);
        r0.mNegativeButtonText = getString(R.string.no);
        r0.mPositiveButtonListener = this;
        r0.mNegativeButtonListener = this;
        View r1 = LayoutInflater.from(r0.mContext).inflate(android.R.layout.app_error_dialog, null);
        r0.mView = r1;
        CheckBox r2 = (CheckBox) r1.findViewById(android.R.id.alwaysUse);
        this.mAlwaysAllow = r2;
        r2.setText(getString(R.string.no_internet_access_remember));
        setupAlert();
    }

    protected void onDestroy() {
        ConnectivityManager.NetworkCallback r0 = this.mNetworkCallback;
        if (r0 == null) goto L5;
        this.mCM.unregisterNetworkCallback(r0);
        this.mNetworkCallback = null;
    L5:
        super.onDestroy();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r5, int r6) {
        if (r6 != (-1)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r1 = "Connect";
    L9:
        boolean r2 = this.mAlwaysAllow.isChecked();
        if (r6 == (-2)) goto L13;
        if (r6 == (-1)) goto L13;
        return;
    L13:
        this.mCM.setAcceptUnvalidated(this.mNetwork, r0, r2);
        StringBuilder r4 = new StringBuilder().append(r1).append(" network=").append(this.mNetwork);
        if (r2 == false) goto L16;
        String r7 = " and remember";
    L17:
        OLog.d(TAG, r4.append(r7).toString());
        return;
    L16:
        r7 = "";
        goto L17
    L8:
        r1 = "Ignore";
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}
