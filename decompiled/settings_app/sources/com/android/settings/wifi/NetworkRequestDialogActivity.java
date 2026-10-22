package com.android.settings.wifi;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.StatusDialogUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class NetworkRequestDialogActivity extends FragmentActivity implements WifiManager.NetworkRequestMatchCallback, NetworkRequestSingleSsidDialogFragment.Callback {
    private static final int DELAY_TIME_STOP_SCAN_MS = 30000;
    static final String EXTRA_APP_NAME = "com.android.settings.wifi.extra.APP_NAME";
    static final String EXTRA_IS_SPECIFIED_SSID = "com.android.settings.wifi.extra.REQUEST_IS_FOR_SINGLE_NETWORK";
    private static final int MESSAGE_STOP_SCAN_WIFI_LIST = 0;
    private static String TAG = "NetworkRequestDialogActivity";
    private String mAppName;
    NetworkRequestDialogFragment mDialogFragment;
    private final Handler mHandler;
    boolean mIsSpecifiedSsid;
    private WifiConfiguration mMatchedConfig;
    Dialog mProgressDialog;
    boolean mShowingErrorDialog;
    NetworkRequestSingleSsidDialogFragment mSingleSsidDialog;
    private WifiManager.NetworkRequestUserSelectionCallback mUserSelectionCallback;

    static {
    }

    public void com_android_settings_wifi_NetworkRequestDialogActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_wifi_NetworkRequestDialogActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public NetworkRequestDialogActivity() {
        this.mAppName = "";
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
    }

    public void com_android_settings_wifi_NetworkRequestDialogActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Intent r4 = getIntent();
        if (r4 == null) goto L6;
        this.mIsSpecifiedSsid = r4.getBooleanExtra(EXTRA_IS_SPECIFIED_SSID, false);
        this.mAppName = r4.getStringExtra(EXTRA_APP_NAME);
    L6:
        if (this.mIsSpecifiedSsid == false) goto L8;
        showProgressDialog(getString(R.string.network_connection_searching_message));
        return;
    L8:
        this.mDialogFragment = NetworkRequestDialogFragment.newInstance();
        Bundle r5 = new Bundle();
        r5.putString("DIALOG_REQUEST_APP_NAME", this.mAppName);
        this.mDialogFragment.setArguments(r5);
        this.mDialogFragment.show();
        getSupportFragmentManager().beginTransaction().add(this.mDialogFragment, TAG).commit();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dismissDialogs();
    }

    private void showProgressDialog(String r1) {
        dismissDialogs();
        StatusDialog r2 = StatusDialogUtils.createStatusDialog(this, r1);
        this.mProgressDialog = r2;
        r2.show();
    }

    private void showSingleSsidRequestDialog(String r3, boolean r4) {
        dismissDialogs();
        this.mSingleSsidDialog = new NetworkRequestSingleSsidDialogFragment();
        Bundle r0 = new Bundle();
        r0.putString(NetworkRequestSingleSsidDialogFragment.EXTRA_SSID, r3);
        r0.putString("DIALOG_REQUEST_APP_NAME", this.mAppName);
        r0.putBoolean(NetworkRequestSingleSsidDialogFragment.EXTRA_TRYAGAIN, r4);
        this.mSingleSsidDialog.setCallback(this);
        this.mSingleSsidDialog.setArguments(r0);
        this.mSingleSsidDialog.show(getSupportFragmentManager(), TAG);
    }

    void dismissDialogs() {
        NetworkRequestDialogFragment r0 = this.mDialogFragment;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mDialogFragment = null;
    L5:
        Dialog r1 = this.mProgressDialog;
        if (r1 == null) goto L9;
        r1.dismiss();
        this.mProgressDialog = null;
        return;
    }

    public void com_android_settings_wifi_NetworkRequestDialogActivity__onResume$___twin___() {
        super.onResume();
        WifiManager r0 = (WifiManager) getSystemService(WifiManager.class);
        if (r0 == null) goto L5;
        r0.registerNetworkRequestMatchCallback(new HandlerExecutor(this.mHandler), this);
    L5:
        this.mHandler.sendEmptyMessageDelayed(0, 30000);
    }

    public void com_android_settings_wifi_NetworkRequestDialogActivity__onPause$___twin___() {
        this.mHandler.removeMessages(0);
        WifiManager r0 = (WifiManager) getSystemService(WifiManager.class);
        if (r0 == null) goto L5;
        r0.unregisterNetworkRequestMatchCallback(this);
    L5:
        super.onPause();
    }

    protected void stopScanningAndPopErrorDialog(NetworkRequestErrorDialogFragment.ERROR_DIALOG_TYPE r5) {
        dismissDialogs();
        FragmentManager r0 = getSupportFragmentManager();
        if (r0.isDestroyed() == false) goto L5;
        return;
    L5:
        if (r0.isStateSaved() == true) goto L10;
        NetworkRequestErrorDialogFragment r1 = NetworkRequestErrorDialogFragment.newInstance();
        r1.setRejectCallback(this.mUserSelectionCallback);
        Bundle r2 = new Bundle();
        r2.putSerializable(NetworkRequestErrorDialogFragment.DIALOG_TYPE, r5);
        r1.setArguments(r2);
        r1.show(r0, TAG);
        this.mShowingErrorDialog = true;
        return;
    }

    public void onUserSelectionCallbackRegistration(WifiManager.NetworkRequestUserSelectionCallback r2) {
        if (this.mIsSpecifiedSsid == false) goto L6;
        this.mUserSelectionCallback = r2;
        return;
    L6:
        NetworkRequestDialogFragment r1 = this.mDialogFragment;
        if (r1 == null) goto L10;
        r1.onUserSelectionCallbackRegistration(r2);
        return;
    }

    public void onAbort() {
        stopScanningAndPopErrorDialog(NetworkRequestErrorDialogFragment.ERROR_DIALOG_TYPE.ABORT);
    }

    public void onMatch(List<ScanResult> r3) {
        if (this.mShowingErrorDialog == false) goto L5;
        return;
    L5:
        this.mHandler.removeMessages(0);
        if (this.mIsSpecifiedSsid == true) goto L8;
        NetworkRequestDialogFragment r2 = this.mDialogFragment;
        if (r2 == null) goto L16;
        r2.onMatch(r3);
        return;
    L16:
        return;
    L8:
        if (this.mMatchedConfig != null) goto L15;
        WifiConfiguration r4 = Utils.getWifiConfig(null, r3.get(0));
        this.mMatchedConfig = r4;
        showSingleSsidRequestDialog(android.net.wifi.WifiInfo.sanitizeSsid(r4.SSID), false);
        return;
    }

    public void onUserSelectionConnectSuccess(WifiConfiguration r1) {
        if (isFinishing() == true) goto L6;
        ToastUtils.show(this, getString(R.string.network_connection_connect_successful));
        setResult(-1);
        finish();
        return;
    }

    public void onUserSelectionConnectFailure(WifiConfiguration r1) {
        if (isFinishing() == true) goto L6;
        ToastUtils.show(this, getString(R.string.network_connection_connect_failure));
        setResult(-1);
        finish();
        return;
    }

    @Override // com.android.settings.wifi.NetworkRequestSingleSsidDialogFragment.Callback
    public void onClickConnectButton() {
        WifiManager.NetworkRequestUserSelectionCallback r0 = this.mUserSelectionCallback;
        if (r0 == null) goto L6;
        r0.select(this.mMatchedConfig);
        showProgressDialog(getString(R.string.network_connection_connecting_message));
        return;
    }

    @Override // com.android.settings.wifi.NetworkRequestSingleSsidDialogFragment.Callback
    public void onFinish() {
        if (isFinishing() == true) goto L6;
        finish();
        return;
    }

    public void onClickRescanButton() {
        this.mHandler.sendEmptyMessageDelayed(0, 30000);
        this.mShowingErrorDialog = false;
        if (this.mIsSpecifiedSsid == false) goto L5;
        this.mMatchedConfig = null;
        showProgressDialog(getString(R.string.network_connection_searching_message));
        return;
    L5:
        this.mDialogFragment = NetworkRequestDialogFragment.newInstance();
        Bundle r0 = new Bundle();
        r0.putString("DIALOG_REQUEST_APP_NAME", this.mAppName);
        this.mDialogFragment.setArguments(r0);
        this.mDialogFragment.show();
    }

    public void onCancel() {
        dismissDialogs();
        WifiManager.NetworkRequestUserSelectionCallback r0 = this.mUserSelectionCallback;
        if (r0 == null) goto L5;
        r0.reject();
    L5:
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_NetworkRequestDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NetworkRequestDialogActivity r1) {
        r1.com_android_settings_wifi_NetworkRequestDialogActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(NetworkRequestDialogActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(NetworkRequestDialogActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_wifi_NetworkRequestDialogActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        NetworkRequestDialogActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(NetworkRequestDialogActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_NetworkRequestDialogActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(NetworkRequestDialogActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_NetworkRequestDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(NetworkRequestDialogActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_wifi_NetworkRequestDialogActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_NetworkRequestDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(NetworkRequestDialogActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_wifi_NetworkRequestDialogActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        NetworkRequestDialogActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }
}
