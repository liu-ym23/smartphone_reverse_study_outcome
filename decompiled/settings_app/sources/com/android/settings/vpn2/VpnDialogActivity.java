package com.android.settings.vpn2;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.VpnManager;
import android.os.Bundle;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;
import com.android.internal.net.VpnProfile;
import com.android.settings.R;
import com.android.settings.ToastUtils;

/* JADX INFO: loaded from: classes2.dex */
public class VpnDialogActivity extends AlertActivity implements DialogInterface.OnClickListener {
    private static final String TAG = "VpnDialogActivity";
    private static String VPN_CONFIG = "com.android.server.connectivity.VPN_CONFIG";
    private BroadcastReceiver mIntentReceiver;
    private AlertController.AlertParams mPara;
    private VpnProfile mProfile;
    private VpnManager mVpnManager;

    static {
    }

    public VpnDialogActivity() {
        this.mProfile = null;
        this.mIntentReceiver = null;
    }

    static /* synthetic */ String access$000() {
        return VPN_CONFIG;
    }

    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        Intent r4 = getIntent();
        this.mVpnManager = (VpnManager) getSystemService("vpn_management");
        this.mProfile = r4.getParcelableExtra("vpnProfile");     // Catch: Exception -> L6
        this.mIntentReceiver = new AnonymousClass1(this);
        IntentFilter r5 = new IntentFilter();
        r5.addAction(VPN_CONFIG);
        registerReceiver(this.mIntentReceiver, r5, 2);
        AlertController.AlertParams r6 = this.mAlertParams;
        this.mPara = r6;
        r6.mTitle = getString(R.string.vpn_status_disconnect_title);
        AlertController.AlertParams r7 = this.mPara;
        r7.mMessage = getString(R.string.vpn_status_disconnect_msg);
        AlertController.AlertParams r8 = this.mPara;
        r8.mPositiveButtonText = getString(R.string.ok);
        this.mPara.mPositiveButtonListener = this;
        AlertController.AlertParams r9 = this.mPara;
        r9.mNegativeButtonText = getString(R.string.cancel);
        this.mPara.mNegativeButtonListener = this;
        setupAlert();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (r2 == (-1)) goto L11;
    L9:
        finish();
        return;
    L11:
        connect(this.mProfile);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void connect(VpnProfile r2) throws Exception {
        this.mVpnManager.startLegacyVpn(r2);     // Catch: IllegalStateException -> L4
        return;
    L4:
        ToastUtils.show(this, R.string.vpn_no_network);
    }

    protected void onDestroy() {
        super.onDestroy();
        BroadcastReceiver r0 = this.mIntentReceiver;
        if (r0 == null) goto L6;
        unregisterReceiver(r0);
        this.mIntentReceiver = null;
        return;
    }

    public void finish() {
        super.finish();
        if (getIntent() == null) goto L8;
        int[] r0 = getIntent().getIntArrayExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID");
        if (r0 == null) goto L9;
        overridePendingTransition(r0[0], r0[1]);
        return;
    L9:
        return;
    }
}
