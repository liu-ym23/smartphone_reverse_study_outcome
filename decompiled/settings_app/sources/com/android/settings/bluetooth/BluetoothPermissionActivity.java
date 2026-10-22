package com.android.settings.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.preference.Preference;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;
import com.android.settings.AdaptBluetoothDevice;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothPermissionActivity extends AlertActivity implements DialogInterface.OnClickListener, Preference.OnPreferenceChangeListener {
    private static final String TAG = "BluetoothPermissionActivity";
    private BluetoothDevice mDevice;
    private Button mOkButton;
    private BroadcastReceiver mReceiver;
    private boolean mReceiverRegistered;
    private int mRequestType;
    private View mView;
    private TextView messageView;

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r1, Object r2) {
        return true;
    }

    public BluetoothPermissionActivity() {
        this.mRequestType = 0;
        this.mReceiver = new AnonymousClass1(this);
        this.mReceiverRegistered = false;
    }

    static /* synthetic */ int access$000(BluetoothPermissionActivity r0) {
        return r0.mRequestType;
    }

    static /* synthetic */ BluetoothDevice access$100(BluetoothPermissionActivity r0) {
        return r0.mDevice;
    }

    static /* synthetic */ void access$200(BluetoothPermissionActivity r0) {
        r0.dismissDialog();
    }

    private void dismissDialog() {
        dismiss();
    }

    protected void onCreate(Bundle r5) {
        super.onCreate(r5);
        getWindow().addFlags(MultiSDKAdapterNew.getOverlayWindowsFlag());
        Intent r6 = getIntent();
        if (r6.getAction().equals("android.bluetooth.device.action.CONNECTION_ACCESS_REQUEST") == true) goto L6;
        OLog.e(TAG, "Error: this activity may be started only with intent ACTION_CONNECTION_ACCESS_REQUEST");
        finish();
        return;
    L6:
        this.mDevice = (BluetoothDevice) r6.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        this.mRequestType = r6.getIntExtra("android.bluetooth.device.extra.ACCESS_REQUEST_TYPE", 2);
        OLog.i(TAG, "onCreate() Request type: " + this.mRequestType);
        int r7 = this.mRequestType;
        if (r7 != 1) goto L9;
        showDialog(getString(R.string.bluetooth_connection_permission_request), this.mRequestType);
    L17:
        registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.device.action.CONNECTION_ACCESS_CANCEL"));
        this.mReceiverRegistered = true;
        return;
    L9:
        if (r7 != 2) goto L12;
        showDialog(getString(R.string.bluetooth_connection_permission_request), this.mRequestType);
        goto L17
    L12:
        if (r7 != 3) goto L15;
        showDialog(getString(R.string.bluetooth_map_request), this.mRequestType);
        goto L17
    L15:
        if (r7 != 4) goto L19;
        showDialog(getString(R.string.bluetooth_sap_request), this.mRequestType);
        goto L17
    L19:
        OLog.e(TAG, "Error: bad request type: " + this.mRequestType);
        finish();
    }

    private void showDialog(String r4, int r5) {
        AlertController.AlertParams r0 = this.mAlertParams;
        OLog.i(TAG, "showDialog() Request type: " + this.mRequestType + " this: " + this);
        boolean r1 = true;
        if (r5 != 1) goto L5;
        View r6 = createConnectionDialogView();
    L11:
        r1 = false;
    L16:
        getDialog(r4, r6, r1).show();
        return;
    L5:
        if (r5 != 2) goto L7;
        r6 = createPhonebookDialogView(getString(R.string.bluetooth_phonebook_request));
        goto L16
    L7:
        if (r5 != 3) goto L9;
        r6 = createMapDialogView();
        goto L11
    L9:
        if (r5 == 4) goto L12;
        r6 = null;
        goto L11
    L12:
        r6 = createSapDialogView();
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    private OAlertDialog getDialog(String r3, final View r4, boolean r5) {
        OViewStyleController r0 = new OViewStyleController(new BluetoothPermissionActivity$$ExternalSyntheticLambda0(r4));
        OAlertDialogBuilder r6 = new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(r3, false).body(r0);
        if (r5 == false) goto L5;
        int r7 = R.string.lockpattern_confirm_button_text;
    L7:
        return r6.positiveButton(r7, this).negativeButton(R.string.bluetooth_pairing_decline, this).build();
    L5:
        r7 = R.string.bluetooth_pairing_accept;
        goto L7
    }

    static /* synthetic */ Unit lambda$getDialog$0(View r0, DialogContainer r1) {
        r1.getBodySlot().addView(r0);
        return null;
    }

    public void onBackPressed() {
        OLog.i(TAG, "Back button pressed! ignoring");
    }

    private String createRemoteName() {
        BluetoothDevice r0 = this.mDevice;
        if (r0 == null) goto L5;
        String r1 = AdaptBluetoothDevice.getDeviceAliasName(r0);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return getString(R.string.unknown);
    L5:
        r1 = null;
        goto L6
    }

    private View createConnectionDialogView() {
        String r0 = createRemoteName();
        View r1 = getLayoutInflater().inflate(R.layout.bluetooth_access_new, null);
        this.mView = r1;
        TextView r2 = (TextView) r1.findViewById(R.id.message);
        this.messageView = r2;
        r2.setText(getString(R.string.bluetooth_connection_dialog_text, new Object[]{r0}));
        return this.mView;
    }

    private View createPhonebookDialogView(String r5) {
        String r0 = createRemoteName();
        View r1 = getLayoutInflater().inflate(R.layout.bluetooth_access_new, null);
        this.mView = r1;
        TextView r2 = (TextView) r1.findViewById(R.id.message);
        this.messageView = r2;
        r2.setText(r5 + ":\n" + getString(R.string.bluetooth_pb_acceptance_dialog_text, new Object[]{r0, r0}));
        return this.mView;
    }

    private View createMapDialogView() {
        String r0 = createRemoteName();
        View r1 = getLayoutInflater().inflate(R.layout.bluetooth_access_new, null);
        this.mView = r1;
        TextView r2 = (TextView) r1.findViewById(R.id.message);
        this.messageView = r2;
        r2.setText(getString(R.string.bluetooth_map_acceptance_dialog_text, new Object[]{r0, r0}));
        return this.mView;
    }

    private View createSapDialogView() {
        String r0 = createRemoteName();
        View r1 = getLayoutInflater().inflate(R.layout.bluetooth_access_new, null);
        this.mView = r1;
        TextView r2 = (TextView) r1.findViewById(R.id.message);
        this.messageView = r2;
        r2.setText(getString(R.string.bluetooth_sap_acceptance_dialog_text, new Object[]{r0, r0}));
        return this.mView;
    }

    private void onPositive() {
        OLog.d(TAG, "onPositive");
        savePermissionChoice(this.mRequestType, 1);
        sendIntentToReceiver("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY", true, "android.bluetooth.device.extra.ALWAYS_ALLOWED", true);
        finish();
    }

    private void onNegative() {
        OLog.d(TAG, "onNegative");
        savePermissionChoice(this.mRequestType, 2);
        sendIntentToReceiver("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY", false, null, false);
        finish();
    }

    private void sendIntentToReceiver(String r3, boolean r4, String r5, boolean r6) {
        Intent r0 = new Intent(r3);
        OLog.i(TAG, "sendIntentToReceiver() Request type: " + this.mRequestType);
        if (r4 == false) goto L5;
        int r7 = 1;
    L6:
        r0.putExtra("android.bluetooth.device.extra.CONNECTION_ACCESS_RESULT", r7);
        if (r5 == null) goto L9;
        r0.putExtra(r5, r6);
    L9:
        r0.putExtra("android.bluetooth.device.extra.DEVICE", this.mDevice);
        r0.putExtra("android.bluetooth.device.extra.ACCESS_REQUEST_TYPE", this.mRequestType);
        sendBroadcast(r0, "android.permission.BLUETOOTH_ADMIN");
        return;
    L5:
        r7 = 2;
        goto L6
    }

    void sendReplyIntentToReceiver(boolean r3, boolean r4) {
        sendIntentToReceiver("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY", r3, "android.bluetooth.device.extra.ALWAYS_ALLOWED", r4);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (r2 != (-2)) goto L5;
        onNegative();
        return;
    L5:
        if (r2 != (-1)) goto L11;
        onPositive();
        return;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mReceiverRegistered == false) goto L6;
        unregisterReceiver(this.mReceiver);
        this.mReceiverRegistered = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void savePermissionChoice(int r6, int r7) {
        LocalBluetoothManager r0 = LocalBluetoothManager.getInstance(this);
        CachedBluetoothDeviceManager r1 = r0.getCachedDeviceManager();
        CachedBluetoothDevice r2 = r1.findDevice(this.mDevice);
        OLog.d(TAG, "savePermissionChoice permissionType: " + r6);
        if (r2 != null) goto L5;
        r2 = r1.addDevice(r0.getBluetoothAdapter(), r0.getProfileManager(), this.mDevice);
    L5:
        if (r2 != null) goto L8;
        return;
    L8:
        if (r6 != 2) goto L11;
        r2.setPhonebookPermissionChoice(r7);
        return;
    L11:
        if (r6 != 3) goto L15;
        r2.setMessagePermissionChoice(r7);
        return;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.pop_up_in, R.anim.fake_anim);
    }
}
