package com.android.settings.wfd;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.hardware.display.WifiDisplay;
import android.hardware.display.WifiDisplayStatus;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.bluetooth.DeviceRenameDialogFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.RegisterUtils;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class WifiDisplayDetail extends Fragment implements View.OnClickListener {
    public static final String EXTRA_WIFI_DISPLAY = "extra_wifi_display";
    public static final String TAG = "WifiDisplayDetail";
    private DisplayManager mDisplayManager;
    private OButton mForgetBtn;
    private final BroadcastReceiver mReceiver;
    private OListItemSettings mRenameDevice;
    private DeviceRenameDialogFragment mRenameDialog;
    private WifiDisplay mWifiDisplay;
    private WifiDisplayStatus mWifiDisplayStatus;

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wfd_WifiDisplayDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wfd_WifiDisplayDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public WifiDisplayDetail() {
        this.mReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ DeviceRenameDialogFragment access$000(WifiDisplayDetail r0) {
        return r0.mRenameDialog;
    }

    static /* synthetic */ boolean access$100(WifiDisplayDetail r0) {
        return r0.canRename();
    }

    static /* synthetic */ void access$200(WifiDisplayDetail r0, boolean r1) {
        r0.updateRenameButtonState(r1);
    }

    static /* synthetic */ void access$300(WifiDisplayDetail r0, String r1) {
        r0.rename(r1);
    }

    public void com_android_settings_wfd_WifiDisplayDetail__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        WifiDisplay r3 = getActivity().getIntent().getParcelableExtra(EXTRA_WIFI_DISPLAY);
        this.mWifiDisplay = r3;
        if (r3 != null) goto L6;
        getActivity().finish();
        return;
    L6:
        this.mDisplayManager = (DisplayManager) getActivity().getSystemService("display");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.wifi_display_detail_fragment, r3, false);
        this.mRenameDevice = (OListItemSettings) r5.findViewById(R.id.wifi_display_rename);
        String r6 = this.mWifiDisplay.getDeviceAlias();
        OListItemSettings r7 = this.mRenameDevice;
        if (TextUtils.isEmpty(r6) == false) goto L5;
        r6 = this.mWifiDisplay.getDeviceName();
    L5:
        r7.setTrailingTextString(r6);
        this.mForgetBtn = (OButton) r5.findViewById(R.id.forget_btn);
        this.mRenameDevice.setOnClickListener(this);
        this.mForgetBtn.setOnClickListener(this);
        return r5;
    }

    public void com_android_settings_wfd_WifiDisplayDetail__onResume$___twin___() {
        super.onResume();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.hardware.display.action.WIFI_DISPLAY_STATUS_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mReceiver, r0, 2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        RegisterUtils.unRegisterBroadcastReceiverSafely(TAG, getActivity(), this.mReceiver);
    }

    private boolean canRename() {
        WifiDisplayStatus r0 = this.mDisplayManager.getWifiDisplayStatus();
        this.mWifiDisplayStatus = r0;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.getActiveDisplayState() != 1) goto L10;
        return false;
    L10:
        return true;
    }

    private void updateRenameButtonState(boolean r1) {
        DeviceRenameDialogFragment r0 = this.mRenameDialog;
        if (r0 == null) goto L6;
        r0.setRenameButtonState(r1);
        return;
    }

    private void createRenameDialog(CharSequence r2) {
        DeviceRenameDialogFragment r0 = new DeviceRenameDialogFragment(r2);
        this.mRenameDialog = r0;
        r0.setDialogTitle(getString(R.string.rename_device_lable));
        this.mRenameDialog.setPositiveButtonText(getString(R.string.rename));
        this.mRenameDialog.setPositiveButtonClickListener(new AnonymousClass2(this));
        this.mRenameDialog.setRenameButtonState(canRename());
        this.mRenameDialog.show(getParentFragmentManager(), TAG);
    }

    private void rename(String r2) {
        if (r2.isEmpty() == false) goto L5;
        r2 = null;
    L5:
        if (r2 == null) goto L7;
        this.mRenameDevice.setTrailingTextString(r2);
    L7:
        this.mDisplayManager.renameWifiDisplay(this.mWifiDisplay.getDeviceAddress(), r2);
    }

    private void forget() {
        this.mDisplayManager.forgetWifiDisplay(this.mWifiDisplay.getDeviceAddress());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        OListItemSettings r0 = this.mRenameDevice;
        if (r2 != r0) goto L6;
        createRenameDialog(r0.getTrailingTextString());
        return;
    L6:
        if (r2 != this.mForgetBtn) goto L10;
        forget();
        getActivity().finish();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wfd_WifiDisplayDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WifiDisplayDetail r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wfd_WifiDisplayDetail__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wfd_WifiDisplayDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WifiDisplayDetail r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wfd_WifiDisplayDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wfd_WifiDisplayDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WifiDisplayDetail r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wfd_WifiDisplayDetail__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
