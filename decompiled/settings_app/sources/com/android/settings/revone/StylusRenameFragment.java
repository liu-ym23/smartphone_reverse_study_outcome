package com.android.settings.revone;

import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.Constants;
import com.android.settings.GpsEnabler;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.Utf8ByteLengthFilter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.SettingItemButton;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class StylusRenameFragment extends BaseFragment implements View.OnClickListener {
    private static final int STYLUS_NAME_MAX_LENGTH_BYTES = 32;
    private static final String TAG = "StylusRenameFragment";
    private SettingItemButton mBtnUnpair;
    private BluetoothDevice mDevice;
    private EditText mEditor;
    private final BroadcastReceiver mGattUpdateReceiver;
    private GpsEnabler mGpsEnabler;
    private final ContentObserver mGpsObserver;
    private SettingItemText mItemRename;
    private boolean mLocationState;
    private AlertDialog mRenameDialog;
    private HashMap mStylusNameMap;
    private AlertDialog mUnpairDialog;

    public void com_android_settings_revone_StylusRenameFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_StylusRenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_StylusRenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(StylusRenameFragment r0) {
        r0.closeDialog();
    }

    static /* synthetic */ GpsEnabler access$100(StylusRenameFragment r0) {
        return r0.mGpsEnabler;
    }

    static /* synthetic */ boolean access$200(StylusRenameFragment r0) {
        return r0.mLocationState;
    }

    static /* synthetic */ boolean access$202(StylusRenameFragment r0, boolean r1) {
        r0.mLocationState = r1;
        return r1;
    }

    static /* synthetic */ EditText access$300(StylusRenameFragment r0) {
        return r0.mEditor;
    }

    static /* synthetic */ HashMap access$400(StylusRenameFragment r0) {
        return r0.mStylusNameMap;
    }

    static /* synthetic */ HashMap access$402(StylusRenameFragment r0, HashMap r1) {
        r0.mStylusNameMap = r1;
        return r1;
    }

    static /* synthetic */ BluetoothDevice access$500(StylusRenameFragment r0) {
        return r0.mDevice;
    }

    static /* synthetic */ SettingItemText access$600(StylusRenameFragment r0) {
        return r0.mItemRename;
    }

    static /* synthetic */ AlertDialog access$700(StylusRenameFragment r0) {
        return r0.mRenameDialog;
    }

    static /* synthetic */ AlertDialog access$802(StylusRenameFragment r0, AlertDialog r1) {
        r0.mUnpairDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$900(StylusRenameFragment r0, String r1, BluetoothDevice r2) {
        r0.sendDisconnectBroadcast(r1, r2);
    }

    public StylusRenameFragment() {
        super(R.layout.revone_fragment_stylus_rename);
        this.mLocationState = false;
        this.mGattUpdateReceiver = new AnonymousClass1(this);
        final Handler r1 = new Handler();
        this.mGpsObserver = new AnonymousClass2(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mItemRename = (SettingItemText) findViewByIdNullable(R.id.stylus_rename);
        this.mBtnUnpair = (SettingItemButton) findViewByIdNullable(R.id.btn_unpair);
        this.mItemRename.setOnClickListener(this);
        this.mBtnUnpair.setOnClickListener(this);
        BluetoothDevice r4 = (BluetoothDevice) getArguments().getParcelable(Constants.EXTRA_BLE_DEVICE);
        this.mDevice = r4;
        if (r4 == null) goto L5;
        this.mItemRename.setSubTitle(Utils.getStylusName(r4, this.mContext));
    L5:
        GpsEnabler r5 = new GpsEnabler(this.mContext, this.mGpsObserver);
        this.mGpsEnabler = r5;
        this.mLocationState = r5.getGpsSwitchState();
    }

    public void com_android_settings_revone_StylusRenameFragment__onResume$___twin___() {
        super.onResume();
        registerReceiver(this.mGattUpdateReceiver, new IntentFilter(Constants.ACTION_GATT_DISCONNECTED));
        GpsEnabler r3 = this.mGpsEnabler;
        if (r3 == null) goto L6;
        r3.resume();
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mGattUpdateReceiver);
        GpsEnabler r1 = this.mGpsEnabler;
        if (r1 == null) goto L6;
        r1.pause();
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mItemRename) goto L8;
        BluetoothDevice r3 = this.mDevice;
        if (r3 == null) goto L11;
        showEditDialog(Utils.getStylusName(r3, this.mContext));
        return;
    L11:
        return;
    L8:
        if (r2 != this.mBtnUnpair) goto L13;
        showUnpairDialog();
        return;
    }

    private void showEditDialog(String r4) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(TAG, "showEditDialog, activity is null, return");
        return;
    L6:
        AlertDialog.Builder r1 = new AlertDialog.Builder(r0, 5);
        r1.setTitle(getString(R.string.bluetooth_rename_device)).setView(createDialogView(r4)).setPositiveButton(R.string.ok, new AnonymousClass3(this)).setNegativeButton(R.string.cancel, null);
        AlertDialog r5 = r1.create();
        this.mRenameDialog = r5;
        r5.getWindow().setSoftInputMode(37);
        this.mRenameDialog.show();
    }

    private View createDialogView(String r6) {
        View r0 = ((LayoutInflater) NullSafe.nonNull(this.mContext.getSystemService("layout_inflater"))).inflate(R.layout.dlg_pattern_edittext_layout, null);
        EditText r1 = (EditText) NullSafe.nonNull(r0.findViewById(R.id.et_custom_key));
        this.mEditor = r1;
        r1.setFilters(new InputFilter[]{new Utf8ByteLengthFilter(32)});
        this.mEditor.addTextChangedListener(new AnonymousClass4(this));
        this.mEditor.setSingleLine();
        this.mEditor.setText(r6);
        EditText r5 = this.mEditor;
        if (r6 != null) goto L5;
        int r7 = 0;
    L6:
        r5.setSelection(0, r7);
        return r0;
    L5:
        r7 = r6.length();
        goto L6
    }

    private void showUnpairDialog() {
        AlertDialog r0 = this.mUnpairDialog;
        if (r0 != null) goto L5;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(TAG, "showUnpairDialog, activity is null, return");
        return;
    L11:
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setTitle(R.string.stylus_unpair).setNegativeButton(android.R.string.cancel, null).setPositiveButton(R.string.stylus_disconnect, new AnonymousClass6(this)).setCancelable(false).setOnDismissListener(new AnonymousClass5(this));
        r2.setMessage(getString(R.string.stylus_unpair_message, new Object[]{Utils.getStylusName(this.mDevice, this.mContext)}));
        AlertDialog r3 = r2.create();
        this.mUnpairDialog = r3;
        r3.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void sendDisconnectBroadcast(String r2, BluetoothDevice r3) {
        Intent r0 = new Intent(r2);
        r0.putExtra(Constants.EXTRA_BLE_DEVICE, r3);
        sendBroadcast(r0);
    }

    private void closeDialog() {
        AlertDialog r0 = this.mRenameDialog;
        if (r0 != null) goto L5;
    L7:
        AlertDialog r1 = this.mUnpairDialog;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isShowing() == false) goto L14;
        this.mUnpairDialog.dismiss();
        return;
    L14:
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mRenameDialog.getWindow().setSoftInputMode(2);
        this.mRenameDialog.dismiss();
        goto L7
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_StylusRenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(StylusRenameFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_StylusRenameFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_StylusRenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(StylusRenameFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_StylusRenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_StylusRenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(StylusRenameFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_StylusRenameFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
