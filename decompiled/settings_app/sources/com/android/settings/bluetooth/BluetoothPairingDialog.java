package com.android.settings.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.android.internal.app.AlertActivity;
import com.android.settings.AdaptBluetoothDevice;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import java.util.Locale;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothPairingDialog extends AlertActivity implements CompoundButton.OnCheckedChangeListener, DialogInterface.OnClickListener, TextWatcher, View.OnClickListener {
    private static final int BLUETOOTH_PASSKEY_MAX_LENGTH = 6;
    private static final int BLUETOOTH_PIN_MAX_LENGTH = 16;
    private static final String EXTRA_DIALOG_DISMISS_REASON = "reason";
    private static final String HOME_KEY = "homekey";
    private static final String TAG = "BluetoothPairingDialog";
    private OAlertDialog mAlertDialog;
    private BluetoothDevice mDevice;
    private boolean mFinishingFromDialog;
    private boolean mIsButtonPressed;
    private boolean mNeedUnregister;
    private View mOkButton;
    private String mPairingKey;
    private EditText mPairingView;
    private final BroadcastReceiver mReceiver;
    private int mType;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public BluetoothPairingDialog() {
        this.mNeedUnregister = false;
        this.mReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(BluetoothPairingDialog r0) {
        r0.dismissDialogAndFinish();
    }

    static /* synthetic */ BluetoothDevice access$100(BluetoothPairingDialog r0) {
        return r0.mDevice;
    }

    static /* synthetic */ void access$200(BluetoothPairingDialog r0) {
        r0.onCancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle r9) {
        super.onCreate(r9);
        getWindow().addFlags(MultiSDKAdapterNew.getOverlayWindowsFlag());
        this.mIsButtonPressed = false;
        Intent r0 = getIntent();
        if ("android.bluetooth.device.action.PAIRING_REQUEST".equals(r0.getAction()) == true) goto L6;
        OLog.e(TAG, "Error: this activity may be started only with intent android.bluetooth.device.action.PAIRING_REQUEST");
        finish();
        return;
    L6:
        LocalBluetoothManager r1 = LocalBluetoothManager.getInstance(this);
        if (r1 != null) goto L10;
        OLog.e(TAG, "Error: BluetoothAdapter not supported by system");
        finish();
        return;
    L10:
        CachedBluetoothDeviceManager r2 = r1.getCachedDeviceManager();
        this.mDevice = (BluetoothDevice) r0.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        this.mType = r0.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", Integer.MIN_VALUE);
        setFinishOnTouchOutside(false);
        switch(this.mType) {
            case 0: goto L28;
            case 1: goto L28;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L22;
            case 7: goto L28;
            default: goto L12;
        };
    L12:
        OLog.e(TAG, "Incorrect pairing type received, not showing any dialog");
    L29:
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.bluetooth.device.action.PAIRING_CANCEL");
        r10.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        r10.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        registerReceiver(this.mReceiver, r10, 2);
        this.mNeedUnregister = true;
        return;
    L13:
        int r3 = r0.getIntExtra("android.bluetooth.device.extra.PAIRING_KEY", Integer.MIN_VALUE);
        if (r3 != Integer.MIN_VALUE) goto L18;
        OLog.e(TAG, "Invalid Confirmation Passkey or PIN received, not showing any dialog");
        return;
    L18:
        if (this.mType != 4) goto L20;
        this.mPairingKey = String.format("%06d", new Object[]{Integer.valueOf(r3)});
    L21:
        createDisplayPasskeyOrPinDialog(r2);
        goto L29
    L20:
        this.mPairingKey = String.format("%04d", new Object[]{Integer.valueOf(r3)});
        goto L21
    L22:
        createConsentDialog(r2);
        goto L29
    L23:
        int r4 = r0.getIntExtra("android.bluetooth.device.extra.PAIRING_KEY", Integer.MIN_VALUE);
        if (r4 != Integer.MIN_VALUE) goto L27;
        OLog.e(TAG, "Invalid Confirmation Passkey received, not showing any dialog");
        return;
    L27:
        this.mPairingKey = String.format(Locale.US, "%06d", new Object[]{Integer.valueOf(r4)});
        createConfirmationDialog(r2);
        goto L29
    L28:
        createUserEntryDialog(r2);
        goto L29
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createUserEntryDialog(final CachedBluetoothDeviceManager r4) {
        OViewStyleController r0 = new OViewStyleController(new BluetoothPairingDialog$$ExternalSyntheticLambda1(this, r4));
        OAlertDialog r5 = new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.bluetooth_pairing_request).body(r0).positiveButton(R.string.bluetooth_pairing_accept, this).negativeButton(R.string.bluetooth_pairing_decline, this).build();
        View r1 = r5.getPositiveButton();
        this.mOkButton = r1;
        r1.setEnabled(false);
        showDialog(r5);
        this.mPairingView.requestFocus();
        r5.getWindow().setSoftInputMode(5);
    }

    /* JADX INFO: renamed from: lambda$createUserEntryDialog$0$com-android-settings-bluetooth-BluetoothPairingDialog, reason: not valid java name */
    /* synthetic */ Unit m352x8eb4933f(CachedBluetoothDeviceManager r2, DialogContainer r3) {
        View r1 = createPinEntryView(r2.getName(this.mDevice));
        r3.getBodySlot().addView(r1);
        return null;
    }

    private View createPinEntryView(String r10) {
        View r0 = getLayoutInflater().inflate(R.layout.bluetooth_pin_entry, null);
        TextView r1 = (TextView) r0.findViewById(R.id.message);
        TextView r3 = (TextView) r0.findViewById(R.id.pin_values_hint);
        OEditText r4 = ((OInputLayout) r0.findViewById(R.id.text)).getVInput();
        this.mPairingView = r4;
        r4.addTextChangedListener(this);
        int r5 = this.mType;
        int r6 = 16;
        int r7 = R.string.bluetooth_enter_pin_msg_hs;
        int r8 = R.string.bluetooth_pin_values_hint;
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L6;
        r7 = R.string.bluetooth_enter_passkey_msg;
        r6 = 6;
        goto L11
    L6:
        if (r5 == 7) goto L9;
        OLog.e(TAG, "Incorrect pairing type for createPinEntryView: " + this.mType);
        return null;
    L9:
        r8 = R.string.bluetooth_pin_values_hint_16_digits;
    L11:
        r3.setText(r8);
        r1.setText(getString(r7, new Object[]{r10}));
        this.mPairingView.setInputType(1);
        this.mPairingView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(r6)});
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View createView(CachedBluetoothDeviceManager r9) {
        View r0 = getLayoutInflater().inflate(R.layout.bluetooth_pin_confirm_passkey, null);
        r0.setPadding(r0.getPaddingLeft(), r0.getPaddingTop(), r0.getPaddingRight(), r0.getPaddingBottom() + com.android.settings.Utils.dp2Pixels(this, 16.0f));
        String r10 = r9.getName(this.mDevice);
        TextView r1 = (TextView) r0.findViewById(R.id.message1);
        TextView r3 = (TextView) r0.findViewById(R.id.message2);
        TextView r4 = (TextView) r0.findViewById(R.id.message3);
        TextView r5 = (TextView) r0.findViewById(R.id.message4);
        int r6 = this.mType;
        if (r6 != 2) goto L5;
        r1.setText(getString(R.string.bluetooth_confirm_passkey_msg1));
        r3.setText(r10);
        r4.setText(getString(R.string.bluetooth_confirm_passkey_msg2));
        r5.setText(this.mPairingKey);
    L17:
        return r0;
    L5:
        if (r6 != 3) goto L7;
    L15:
        r1.setText(getString(R.string.bluetooth_incoming_pairing_msg_1));
        r3.setText(r10);
        r4.setText(getString(R.string.bluetooth_incoming_pairing_msg_2));
        r5.setVisibility(8);
        goto L17
    L7:
        if (r6 != 4) goto L9;
    L14:
        r1.setText(getString(R.string.bluetooth_display_passkey_pin_msg_1));
        r3.setText(r10);
        r4.setText(getString(R.string.bluetooth_display_passkey_pin_msg_2));
        r5.setText(this.mPairingKey);
        goto L17
    L9:
        if (r6 == 5) goto L14;
        if (r6 == 6) goto L15;
        OLog.e(TAG, "Incorrect pairing type received, not creating view");
        return null;
    }

    private View createConfirmView(CachedBluetoothDeviceManager r7) {
        View r0 = getLayoutInflater().inflate(R.layout.bluetooth_pin_confirm_passkey, null);
        String r8 = r7.getName(this.mDevice);
        TextView r1 = (TextView) r0.findViewById(R.id.message1);
        TextView r2 = (TextView) r0.findViewById(R.id.message2);
        TextView r3 = (TextView) r0.findViewById(R.id.message3);
        TextView r4 = (TextView) r0.findViewById(R.id.message4);
        r1.setText(getString(R.string.bluetooth_confirm_passkey_msg1));
        r2.setText(r8);
        r3.setText(getString(R.string.bluetooth_confirm_passkey_msg2));
        r4.setText(this.mPairingKey);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createConfirmationDialog(final CachedBluetoothDeviceManager r3) {
        OViewStyleController r0 = new OViewStyleController(new BluetoothPairingDialog$$ExternalSyntheticLambda2(this, r3));
        showDialog(new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.bluetooth_pairing_request).body(r0).positiveButton(R.string.bluetooth_pairing_accept, this).negativeButton(R.string.bluetooth_pairing_decline, this).build());
    }

    /* JADX INFO: renamed from: lambda$createConfirmationDialog$1$com-android-settings-bluetooth-BluetoothPairingDialog, reason: not valid java name */
    /* synthetic */ Unit m349x41d0e0(CachedBluetoothDeviceManager r1, DialogContainer r2) {
        View r0 = createConfirmView(r1);
        r2.getBodySlot().addView(r0);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createConsentDialog(final CachedBluetoothDeviceManager r3) {
        OViewStyleController r0 = new OViewStyleController(new BluetoothPairingDialog$$ExternalSyntheticLambda4(this, r3));
        showDialog(new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.bluetooth_pairing_request).body(r0).positiveButton(R.string.bluetooth_pairing_accept, this).negativeButton(R.string.bluetooth_pairing_decline, this).build());
    }

    /* JADX INFO: renamed from: lambda$createConsentDialog$2$com-android-settings-bluetooth-BluetoothPairingDialog, reason: not valid java name */
    /* synthetic */ Unit m350x137648f4(CachedBluetoothDeviceManager r1, DialogContainer r2) {
        View r0 = createView(r1);
        r2.getBodySlot().addView(r0);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createDisplayPasskeyOrPinDialog(final CachedBluetoothDeviceManager r3) {
        OViewStyleController r0 = new OViewStyleController(new BluetoothPairingDialog$$ExternalSyntheticLambda3(this, r3));
        showDialog(new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.bluetooth_pairing_request).body(r0).negativeButton(R.string.bluetooth_pairing_decline, this).build());
        int r4 = this.mType;
        if (r4 != 4) goto L6;
        this.mDevice.setPairingConfirmation(true);
        return;
    L6:
        if (r4 != 5) goto L12;
        byte[] r5 = BluetoothDevice.convertPinToBytes(this.mPairingKey);
        if (r5 == null) goto L13;
        this.mDevice.setPin(r5);
        return;
    L13:
        return;
    }

    /* JADX INFO: renamed from: lambda$createDisplayPasskeyOrPinDialog$3$com-android-settings-bluetooth-BluetoothPairingDialog, reason: not valid java name */
    /* synthetic */ Unit m351x21fcc521(CachedBluetoothDeviceManager r1, DialogContainer r2) {
        View r0 = createView(r1);
        r2.getBodySlot().addView(r0);
        return null;
    }

    private void showDialog(OAlertDialog r2) {
        this.mAlertDialog = r2;
        if (r2 == null) goto L6;
        r2.setOnDismissListener(new BluetoothPairingDialog$$ExternalSyntheticLambda0(this));
        this.mAlertDialog.show();
        return;
    }

    /* JADX INFO: renamed from: lambda$showDialog$4$com-android-settings-bluetooth-BluetoothPairingDialog, reason: not valid java name */
    /* synthetic */ void m353x20b61e0f(DialogInterface r1) {
        if (this.mFinishingFromDialog == true) goto L5;
        return;
    L5:
        if (isFinishing() == true) goto L9;
        finish();
        return;
    }

    private void dismissDialogAndFinish() {
        if (this.mFinishingFromDialog == false) goto L5;
        return;
    L5:
        this.mFinishingFromDialog = true;
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 == null) goto L11;
        if (r0.isShowing() == false) goto L11;
        this.mAlertDialog.dismiss();
        return;
    L11:
        if (isFinishing() == true) goto L15;
        finish();
        return;
    }

    protected void onDestroy() {
        super.onDestroy();
        BroadcastReceiver r0 = this.mReceiver;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mNeedUnregister == false) goto L9;
        unregisterReceiver(r0);
        return;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        if (this.mOkButton != null) goto L5;
        return;
    L5:
        if (r2.length() > 0) goto L7;
    L9:
        this.mOkButton.setEnabled(false);
        return;
    L7:
        if (r2.length() > 16) goto L9;
        this.mOkButton.setEnabled(true);
    }

    private void onPair(String r3) {
        int r0 = this.mType;
        if (r0 != 0) goto L5;
    L16:
        byte[] r4 = BluetoothDevice.convertPinToBytes(r3);
        if (r4 != null) goto L19;
        return;
    L19:
        this.mDevice.setPin(r4);
        return;
    L5:
        if (r0 == 7) goto L16;
        if (r0 != 2) goto L9;
    L15:
        this.mDevice.setPairingConfirmation(true);
        return;
    L9:
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return;
    L13:
        if (r0 == 5) goto L22;
        OLog.e(TAG, "Incorrect pairing type received");
        return;
    }

    private void onCancel() {
        AdaptBluetoothDevice.cancel(this.mDevice);
    }

    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L6;
        onCancel();
    L6:
        return super.onKeyDown(r2, r3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (this.mIsButtonPressed == false) goto L6;
        OLog.e(TAG, "button already pressed");
        return;
    L6:
        int r4 = r3.getId();
        if (r4 != R.id.btn_negative) goto L9;
        this.mIsButtonPressed = true;
    L17:
        onCancel();
    L18:
        dismissDialogAndFinish();
        return;
    L9:
        if (r4 != R.id.btn_positive) goto L17;
        EditText r5 = this.mPairingView;
        if (r5 == null) goto L14;
        onPair(r5.getText().toString());
    L15:
        this.mIsButtonPressed = true;
        goto L18
    L14:
        onPair(null);
        goto L15
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r2, int r3) {
        if (this.mIsButtonPressed == false) goto L7;
        OLog.e(TAG, "button already pressed");
        return;
    L7:
        if (r3 != (-2)) goto L9;
        this.mIsButtonPressed = true;
    L17:
        onCancel();
    L18:
        dismissDialogAndFinish();
        return;
    L9:
        if (r3 != (-1)) goto L17;
        EditText r4 = this.mPairingView;
        if (r4 == null) goto L14;
        onPair(r4.getText().toString());
    L15:
        this.mIsButtonPressed = true;
        goto L18
    L14:
        onPair(null);
        goto L15
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        if (r2 == false) goto L4;
        this.mPairingView.setInputType(1);
        return;
    L4:
        this.mPairingView.setInputType(2);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.pop_up_in, R.anim.fake_anim);
    }
}
