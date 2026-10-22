package com.android.settings.wifi;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.NullSafe;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class WifiStatusTest extends BaseActivity {
    private static final String TAG = "WifiStatusTest";
    private TextView mBSSID;
    private TextView mHiddenSSID;
    private TextView mHttpClientTest;
    private String mHttpClientTestResult;
    private TextView mIPAddr;
    private TextView mLinkSpeed;
    private TextView mMACAddr;
    private TextView mNetworkId;
    private TextView mNetworkState;
    View.OnClickListener mPingButtonHandler;
    private TextView mPingHostname;
    private String mPingHostnameResult;
    private TextView mRSSI;
    private TextView mSSID;
    private TextView mScanList;
    private TextView mSupplicantState;
    private WifiManager mWifiManager;
    private TextView mWifiState;
    private IntentFilter mWifiStateFilter;
    private final BroadcastReceiver mWifiStateReceiver;
    private Button pingTestButton;
    private Button updateButton;
    View.OnClickListener updateButtonHandler;

    public void com_android_settings_wifi_WifiStatusTest__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_wifi_WifiStatusTest__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public WifiStatusTest() {
        this.mWifiStateReceiver = new AnonymousClass1(this);
        this.mPingButtonHandler = new AnonymousClass3(this);
        this.updateButtonHandler = new AnonymousClass4(this);
    }

    static /* synthetic */ void access$000(WifiStatusTest r0, int r1) {
        r0.handleWifiStateChanged(r1);
    }

    static /* synthetic */ void access$100(WifiStatusTest r0, NetworkInfo r1) {
        r0.handleNetworkStateChanged(r1);
    }

    static /* synthetic */ TextView access$1000(WifiStatusTest r0) {
        return r0.mIPAddr;
    }

    static /* synthetic */ TextView access$1100(WifiStatusTest r0) {
        return r0.mLinkSpeed;
    }

    static /* synthetic */ TextView access$1200(WifiStatusTest r0) {
        return r0.mMACAddr;
    }

    static /* synthetic */ TextView access$1300(WifiStatusTest r0) {
        return r0.mNetworkId;
    }

    static /* synthetic */ TextView access$1400(WifiStatusTest r0) {
        return r0.mRSSI;
    }

    static /* synthetic */ TextView access$1500(WifiStatusTest r0) {
        return r0.mSSID;
    }

    static /* synthetic */ void access$1600(WifiStatusTest r0, SupplicantState r1) {
        r0.setSupplicantStateText(r1);
    }

    static /* synthetic */ String access$1700(WifiStatusTest r0) {
        return r0.mPingHostnameResult;
    }

    static /* synthetic */ TextView access$1800(WifiStatusTest r0) {
        return r0.mPingHostname;
    }

    static /* synthetic */ String access$1900(WifiStatusTest r0) {
        return r0.mHttpClientTestResult;
    }

    static /* synthetic */ void access$200(WifiStatusTest r0) {
        r0.handleScanResultsAvailable();
    }

    static /* synthetic */ TextView access$2000(WifiStatusTest r0) {
        return r0.mHttpClientTest;
    }

    static /* synthetic */ void access$2100(WifiStatusTest r0) {
        r0.pingHostname();
    }

    static /* synthetic */ void access$2200(WifiStatusTest r0) {
        r0.httpClientTest();
    }

    static /* synthetic */ void access$300(WifiStatusTest r0, SupplicantState r1, boolean r2, int r3) {
        r0.handleSupplicantStateChanged(r1, r2, r3);
    }

    static /* synthetic */ void access$400(WifiStatusTest r0, int r1) {
        r0.handleSignalChanged(r1);
    }

    static /* synthetic */ void access$500(WifiStatusTest r0) {
        r0.updatePingState();
    }

    static /* synthetic */ WifiManager access$600(WifiStatusTest r0) {
        return r0.mWifiManager;
    }

    static /* synthetic */ void access$700(WifiStatusTest r0, int r1) {
        r0.setWifiStateText(r1);
    }

    static /* synthetic */ TextView access$800(WifiStatusTest r0) {
        return r0.mBSSID;
    }

    static /* synthetic */ TextView access$900(WifiStatusTest r0) {
        return r0.mHiddenSSID;
    }

    public void com_android_settings_wifi_WifiStatusTest__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        IntentFilter r5 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        this.mWifiStateFilter = r5;
        r5.addAction("android.net.wifi.STATE_CHANGE");
        this.mWifiStateFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.mWifiStateFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        this.mWifiStateFilter.addAction("android.net.wifi.RSSI_CHANGED");
        this.mWifiStateFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mWifiStateReceiver, this.mWifiStateFilter, 2);
        setContentView(R.layout.wifi_status_test);
        this.mBackView = ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass2(this));
        Button r6 = (Button) findViewById(R.id.update);
        this.updateButton = r6;
        r6.setOnClickListener(this.updateButtonHandler);
        this.mWifiState = (TextView) findViewById(R.id.wifi_state);
        this.mNetworkState = (TextView) findViewById(R.id.network_state);
        this.mSupplicantState = (TextView) findViewById(R.id.supplicant_state);
        this.mRSSI = (TextView) findViewById(R.id.rssi);
        this.mBSSID = (TextView) findViewById(R.id.bssid);
        this.mSSID = (TextView) findViewById(R.id.ssid);
        this.mHiddenSSID = (TextView) findViewById(R.id.hidden_ssid);
        this.mIPAddr = (TextView) findViewById(R.id.ipaddr);
        this.mMACAddr = (TextView) findViewById(R.id.macaddr);
        this.mNetworkId = (TextView) findViewById(R.id.networkid);
        this.mLinkSpeed = (TextView) findViewById(R.id.link_speed);
        this.mScanList = (TextView) findViewById(R.id.scan_list);
        this.mPingHostname = (TextView) findViewById(R.id.pingHostname);
        this.mHttpClientTest = (TextView) findViewById(R.id.httpClientTest);
        Button r7 = (Button) NullSafe.nonNull((Button) findViewById(R.id.ping_test));
        this.pingTestButton = r7;
        r7.setOnClickListener(this.mPingButtonHandler);
    }

    public void com_android_settings_wifi_WifiStatusTest__onResume$___twin___() {
        super.onResume();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mWifiStateReceiver, this.mWifiStateFilter);
    }

    public void com_android_settings_wifi_WifiStatusTest__onPause$___twin___() {
        super.onPause();
        unregisterReceiver(this.mWifiStateReceiver);
    }

    private void setSupplicantStateText(SupplicantState r2) {
        if (SupplicantState.FOUR_WAY_HANDSHAKE.equals(r2) == false) goto L6;
        this.mSupplicantState.setText("FOUR WAY HANDSHAKE");
        return;
    L6:
        if (SupplicantState.ASSOCIATED.equals(r2) == false) goto L9;
        this.mSupplicantState.setText("ASSOCIATED");
        return;
    L9:
        if (SupplicantState.ASSOCIATING.equals(r2) == false) goto L12;
        this.mSupplicantState.setText("ASSOCIATING");
        return;
    L12:
        if (SupplicantState.COMPLETED.equals(r2) == false) goto L15;
        this.mSupplicantState.setText("COMPLETED");
        return;
    L15:
        if (SupplicantState.DISCONNECTED.equals(r2) == false) goto L18;
        this.mSupplicantState.setText(NetworkStackConstant.ERR_DISCONNECTED);
        return;
    L18:
        if (SupplicantState.DORMANT.equals(r2) == false) goto L21;
        this.mSupplicantState.setText("DORMANT");
        return;
    L21:
        if (SupplicantState.GROUP_HANDSHAKE.equals(r2) == false) goto L24;
        this.mSupplicantState.setText("GROUP HANDSHAKE");
        return;
    L24:
        if (SupplicantState.INACTIVE.equals(r2) == false) goto L27;
        this.mSupplicantState.setText("INACTIVE");
        return;
    L27:
        if (SupplicantState.INVALID.equals(r2) == false) goto L30;
        this.mSupplicantState.setText("INVALID");
        return;
    L30:
        if (SupplicantState.SCANNING.equals(r2) == false) goto L33;
        this.mSupplicantState.setText("SCANNING");
        return;
    L33:
        if (SupplicantState.UNINITIALIZED.equals(r2) == false) goto L35;
        this.mSupplicantState.setText("UNINITIALIZED");
        return;
    L35:
        this.mSupplicantState.setText("BAD");
        OLog.e(TAG, "supplicant state is bad");
    }

    private void setWifiStateText(int r2) {
        if (r2 != 0) goto L4;
        String r3 = getString(R.string.wifi_state_disabling);
    L17:
        this.mWifiState.setText(r3);
        return;
    L4:
        if (r2 != 1) goto L6;
        r3 = getString(R.string.wifi_state_disabled);
        goto L17
    L6:
        if (r2 != 2) goto L8;
        r3 = getString(R.string.wifi_state_enabling);
        goto L17
    L8:
        if (r2 != 3) goto L10;
        r3 = getString(R.string.wifi_state_enabled);
        goto L17
    L10:
        if (r2 == 4) goto L12;
        OLog.e(TAG, "wifi state is bad");
        r3 = "BAD";
        goto L17
    L12:
        r3 = getString(R.string.wifi_state_unknown);
        goto L17
    }

    private void handleSignalChanged(int r1) {
        this.mRSSI.setText(String.valueOf(r1));
    }

    private void handleWifiStateChanged(int r1) {
        setWifiStateText(r1);
    }

    private void handleScanResultsAvailable() {
        List<ScanResult> r0 = this.mWifiManager.getScanResults();
        StringBuffer r1 = new StringBuffer();
        if (r0 == null) goto L14;
        int r2 = r0.size() - 1;
    L5:
        if (r2 < 0) goto L14;
        ScanResult r3 = r0.get(r2);
        if (r3 == null) goto L13;
        if (TextUtils.isEmpty(r3.SSID) == true) goto L13;
        r1.append(r3.SSID + HanziToPinyin.Token.SEPARATOR);
    L13:
        r2 = r2 - 1;
    L14:
        this.mScanList.setText(r1);
    }

    private void handleSupplicantStateChanged(SupplicantState r1, boolean r2, int r3) {
        if (r2 == false) goto L4;
        this.mSupplicantState.setText("ERROR AUTHENTICATING");
        return;
    L4:
        setSupplicantStateText(r1);
    }

    private void handleNetworkStateChanged(NetworkInfo r4) {
        if (this.mWifiManager.isWifiEnabled() == false) goto L13;
        android.net.wifi.WifiInfo r0 = this.mWifiManager.getConnectionInfo();
        if (r0 != null) goto L7;
        return;
    L7:
        String r1 = r0.getSSID();
        NetworkInfo.DetailedState r5 = r4.getDetailedState();
        if (r0.getNetworkId() != (-1)) goto L10;
        boolean r2 = true;
    L11:
        String r6 = com.android.settingslib.wifi.AccessPoint.getSummary(this, r1, r5, r2, null);
        this.mNetworkState.setText(r6);
        return;
    L10:
        r2 = false;
        goto L11
    }

    private final void updatePingState() {
        final Handler r0 = new Handler();
        this.mPingHostnameResult = getResources().getString(R.string.radioInfo_unknown);
        this.mHttpClientTestResult = getResources().getString(R.string.radioInfo_unknown);
        this.mPingHostname.setText(this.mPingHostnameResult);
        this.mHttpClientTest.setText(this.mHttpClientTestResult);
        final Runnable r1 = new AnonymousClass5(this);
        new AnonymousClass6(this, r0, r1).start();
        new AnonymousClass7(this, r0, r1).start();
    }

    private final void pingHostname() {
    L9:
        this.mPingHostnameResult = "Fail: Unknown Host";
        return;
    L8:
        this.mPingHostnameResult = "Fail: IOException";
        return;
    L7:
        this.mPingHostnameResult = "Fail: InterruptedException";
        return;
    L3:
        if (Runtime.getRuntime().exec("ping -c 1 -w 100 www.google.com").waitFor() != 0) goto L5;
        this.mPingHostnameResult = "Pass";     // Catch: InterruptedException -> L7 IOException -> L8 UnknownHostException -> L9
    L11:
        return;
    L5:
        this.mPingHostnameResult = "Fail: Host unreachable";     // Catch: InterruptedException -> L7 IOException -> L8 UnknownHostException -> L9
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    private void httpClientTest() {
        ?? r1 = 0;
        r1 = 0;
        HttpURLConnection r2 = (HttpURLConnection) new URL("https://www.google.com").openConnection();     // Catch: Throwable -> L13 IOException -> L22
        int r3 = r2.getResponseCode();     // Catch: Throwable -> L10 IOException -> L12
        if (r3 != 200) goto L7;
        this.mHttpClientTestResult = "Pass";     // Catch: Throwable -> L10 IOException -> L12
        r1 = r3;
    L8:
        if (r2 == null) goto L23;
        r2.disconnect();
    L23:
        return;
    L7:
        StringBuilder r4 = new StringBuilder("Fail: Code: ");     // Catch: Throwable -> L10 IOException -> L12
        this.mHttpClientTestResult = r4.append(r2.getResponseMessage()).toString();     // Catch: Throwable -> L10 IOException -> L12
        r1 = r4;
    L12:
        r1 = r2;
    L10:
        th = th;
        r1 = r2;
    L19:
        if (r1 == 0) goto L21;
        r1.disconnect();
    L21:
        throw th;
    L13:
        th = th;
    L15:
        this.mHttpClientTestResult = "Fail: IOException";     // Catch: Throwable -> L13
        if (r1 == 0) goto L23;
        r1.disconnect();
        goto L23
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiStatusTest_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(WifiStatusTest r1) {
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_PrivacyHook_onCreate(WifiStatusTest r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiStatusTest r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_wifi_WifiStatusTest__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_BatchedActivityLancet_onResume(WifiStatusTest r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(WifiStatusTest r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        WifiStatusTest r5 = r4;
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
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(WifiStatusTest r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_WifiStatusTest__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_BatchedActivityLancet_onStop(WifiStatusTest r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_WifiStatusTest_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_PrivacyHook_onResume(WifiStatusTest r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiStatusTest r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_wifi_WifiStatusTest__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(WifiStatusTest r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_PrivacyHook_onPause(WifiStatusTest r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiStatusTest r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_wifi_WifiStatusTest__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(WifiStatusTest r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        WifiStatusTest r5 = r3;
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

    @Insert("onStop")
    public static void com_android_settings_wifi_WifiStatusTest_com_obric_hook_lancet_PrivacyHook_onStop(WifiStatusTest r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiStatusTest r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_wifi_WifiStatusTest__onStop$___twin___();
    }
}
