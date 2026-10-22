package com.android.settings.bluetooth;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.about.DeviceUtils;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.RegisterUtils;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.forms.OInputView;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothNameDialogFragment extends DialogFragment implements TextWatcher {
    private static final int BLUETOOTH_NAME_MAX_LENGTH_BYTES = 32;
    private static final String KEY_NAME = "device_name";
    private static final String KEY_NAME_EDITED = "device_name_edited";
    static final String TAG = "BluetoothNameDialogFragment";
    private OSimpleFormDialog mAlertDialog;
    private boolean mDeviceNameEdited;
    private boolean mDeviceNameUpdated;
    EditText mDeviceNameView;
    private LocalBluetoothAdapter mLocalAdapter;
    private OButton mOkButton;
    private View.OnClickListener mOnClickListener;
    private final BroadcastReceiver mReceiver;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public void com_android_settings_bluetooth_BluetoothNameDialogFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_BluetoothNameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_bluetooth_BluetoothNameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public BluetoothNameDialogFragment() {
        this.mLocalAdapter = null;
        this.mReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ OSimpleFormDialog access$000(BluetoothNameDialogFragment r0) {
        return r0.mAlertDialog;
    }

    static /* synthetic */ void access$100(BluetoothNameDialogFragment r0, String r1) {
        r0.setDeviceName(r1);
    }

    static /* synthetic */ View.OnClickListener access$200(BluetoothNameDialogFragment r0) {
        return r0.mOnClickListener;
    }

    public void setOnClickListener(View.OnClickListener r1) {
        this.mOnClickListener = r1;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r14) {
        if (getActivity() != null) goto L7;
        return null;
    L7:
        if (this.mLocalAdapter != null) goto L11;
        LocalBluetoothManager r0 = LocalBluetoothManager.getInstance(getActivity());
        if (r0 == null) goto L11;
        this.mLocalAdapter = r0.getBluetoothAdapter();
    L11:
        LocalBluetoothAdapter r1 = this.mLocalAdapter;
        if (r1 == null) goto L14;
        String r2 = r1.getName();
    L16:
        if (r14 == null) goto L18;
        r2 = r14.getString(KEY_NAME, r2);
        this.mDeviceNameEdited = r14.getBoolean(KEY_NAME_EDITED, false);
    L18:
        OSimpleFormDialog r15 = ODialogUtils.INSTANCE.getMiscDialog(getActivity(), getActivity().getString(R.string.device_name_new), "", getActivity().getString(R.string.bluetooth_rename_button), getActivity().getString(R.string.cancel), "", "", false, new AnonymousClass2(this), new AnonymousClass3(this));
        this.mAlertDialog = r15;
        OInputLayout r16 = (OInputLayout) ((ViewGroup) r15.findViewById(R.id.simple_form_input_1_container)).getChildAt(0);
        r16.getVInput().afterTextChanged$OUI_standardRelease(new AnonymousClass4(this));
        r16.showClear(true);
        OEditText r17 = r16.getVInput();
        this.mDeviceNameView = r17;
        r17.setText(r2);
        this.mDeviceNameView.setSelection(0, r2.length());
        this.mDeviceNameView.setFilters(new InputFilter[]{new Utf8ByteLengthFilter(32)});
        this.mAlertDialog.getWindow().setSoftInputMode(5);
        return this.mAlertDialog;
    L14:
        r2 = "";
        goto L16
    }

    private void setDeviceName(String r3) {
        DeviceUtils.INSTANCE.changeDeviceName(r3);
        this.mLocalAdapter.setName(r3);
        SharedPreferences r2 = getActivity().getSharedPreferences(getActivity().getPackageName(), 0);
        if (r2.getBoolean(com.android.settings.Utils.KEY_IF_NEED_READ_DEVICE_NAME_BT, true) == false) goto L6;
        r2.edit().putBoolean(com.android.settings.Utils.KEY_IF_NEED_READ_DEVICE_NAME_BT, false).apply();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        r3.putString(KEY_NAME, this.mDeviceNameView.getText().toString());
        r3.putBoolean(KEY_NAME_EDITED, this.mDeviceNameEdited);
    }

    private View createDialogView(String r7) {
        View r0 = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.dialog_edittext, null);
        OEditText r1 = ((OInputView) r0.findViewById(R.id.edittext)).getVInput();
        this.mDeviceNameView = r1;
        r1.setText(r7);
        this.mDeviceNameView.setSelection(0, r7.length());
        this.mDeviceNameView.setFilters(new InputFilter[]{new Utf8ByteLengthFilter(32)});
        this.mDeviceNameView.addTextChangedListener(this);
        this.mDeviceNameView.setOnEditorActionListener(new AnonymousClass5(this));
        this.mDeviceNameView.setSelectAllOnFocus(true);
        this.mDeviceNameView.requestFocus();
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mAlertDialog = null;
        this.mDeviceNameView = null;
        this.mOkButton = null;
    }

    public void com_android_settings_bluetooth_BluetoothNameDialogFragment__onResume$___twin___() {
        super.onResume();
        OButton r0 = this.mOkButton;
        if (r0 == null) goto L5;
        r0.setEnabled(this.mDeviceNameEdited);
    L5:
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        r1.addAction("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mReceiver, r1, 2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        RegisterUtils.unRegisterBroadcastReceiverSafely(TAG, getActivity(), this.mReceiver);
    }

    void updateDeviceName() {
        LocalBluetoothAdapter r0 = this.mLocalAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEnabled() == false) goto L9;
        this.mDeviceNameUpdated = true;
        this.mDeviceNameEdited = false;
        this.mDeviceNameView.setText(this.mLocalAdapter.getName());
        return;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r4) {
        boolean r1 = false;
        if (this.mDeviceNameUpdated == false) goto L5;
        this.mDeviceNameUpdated = false;
        this.mOkButton.setEnabled(false);
        return;
    L5:
        OButton r0 = this.mOkButton;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r4.length() != 0) goto L10;
    L14:
        r0.setEnabled(r1);
        return;
    L10:
        if (r4.toString().trim().isEmpty() == true) goto L14;
        if (this.mDeviceNameEdited == false) goto L14;
        r1 = true;
        goto L14
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        if (this.mLocalAdapter != null) goto L6;
        return;
    L6:
        if (r1.toString().equals(this.mLocalAdapter.getName()) == false) goto L8;
        this.mDeviceNameEdited = false;
        return;
    L8:
        this.mDeviceNameEdited = true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_BluetoothNameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BluetoothNameDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_BluetoothNameDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_BluetoothNameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BluetoothNameDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_bluetooth_BluetoothNameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_BluetoothNameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BluetoothNameDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_BluetoothNameDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
