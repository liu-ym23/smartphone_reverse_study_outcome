package com.android.settings.bluetooth;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;
import com.android.settings.R;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class RequestPermissionHelperActivity extends AlertActivity implements DialogInterface.OnClickListener {
    public static final String ACTION_INTERNAL_REQUEST_BT_ON = "com.android.settings.bluetooth.ACTION_INTERNAL_REQUEST_BT_ON";
    public static final String ACTION_INTERNAL_REQUEST_BT_ON_AND_DISCOVERABLE = "com.android.settings.bluetooth.ACTION_INTERNAL_REQUEST_BT_ON_AND_DISCOVERABLE";
    private static final String TAG = "RequestPermissionHelperActivity";
    private boolean mEnableOnly;
    private LocalBluetoothAdapter mLocalAdapter;
    private int mTimeout;

    public RequestPermissionHelperActivity() {
    }

    protected void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (parseIntent() == false) goto L6;
        finish();
        return;
    L6:
        createDialog();
        if (getResources().getBoolean(R.bool.auto_confirm_bluetooth_activation_dialog) != true) goto L10;
        onClick(null, -1);
        dismiss();
        return;
    }

    void createDialog() {
        AlertController.AlertParams r0 = this.mAlertParams;
        if (this.mEnableOnly == false) goto L5;
        r0.mMessage = getString(R.string.bluetooth_ask_enablement);
    L9:
        r0.mPositiveButtonText = getString(R.string.allow);
        r0.mPositiveButtonListener = this;
        r0.mNegativeButtonText = getString(R.string.deny);
        r0.mNegativeButtonListener = this;
        setupAlert();
        return;
    L5:
        int r1 = this.mTimeout;
        if (r1 != 0) goto L8;
        r0.mMessage = getString(R.string.bluetooth_ask_enablement_and_lasting_discovery);
        goto L9
    L8:
        r0.mMessage = getString(R.string.bluetooth_ask_enablement_and_discovery, new Object[]{Integer.valueOf(r1)});
        goto L9
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r5, int r6) {
        int r0 = 0;
        if (r6 != (-2)) goto L5;
    L20:
        setResult(r0);
        return;
    L5:
        if (r6 == (-1)) goto L7;
        return;
    L7:
        int r7 = 30;
        int r1 = 0;
    L23:
        r1 = this.mLocalAdapter.getBluetoothState();     // Catch: InterruptedException -> L22
        Thread.sleep(100);     // Catch: InterruptedException -> L22
        if (r1 != 13) goto L14;
        r7 = r7 - 1;
        if (r7 > 0) goto L23;
    L14:
        if (r1 != 11) goto L16;
    L19:
        r0 = 1;
        goto L20
    L16:
        if (r1 == 12) goto L19;
        if (this.mLocalAdapter.enable() == false) goto L20;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean parseIntent() {
        Intent r0 = getIntent();
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
    L17:
        setResult(0);
        return true;
    L9:
        if (r0.getAction().equals(ACTION_INTERNAL_REQUEST_BT_ON_AND_DISCOVERABLE) == false) goto L17;
        this.mEnableOnly = false;
        this.mTimeout = r0.getIntExtra("android.bluetooth.adapter.extra.DISCOVERABLE_DURATION", 120);
    L11:
        LocalBluetoothManager r1 = LocalBluetoothManager.getInstance(this);
        if (r1 != null) goto L15;
        OLog.e(TAG, "Error: there's a problem starting Bluetooth");
        setResult(0);
        return true;
    L15:
        this.mLocalAdapter = r1.getBluetoothAdapter();
        return false;
    L5:
        if (r0.getAction().equals(ACTION_INTERNAL_REQUEST_BT_ON) == false) goto L7;
        this.mEnableOnly = true;
        goto L11
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }
}
