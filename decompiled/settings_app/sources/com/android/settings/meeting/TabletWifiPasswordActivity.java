package com.android.settings.meeting;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.AccessPoint;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class TabletWifiPasswordActivity extends LifeHookActivity2 implements View.OnClickListener {
    public static final String INTENT_EXTRA_SETUP_ACCESS_POINT = "access_point";
    public static final String INTENT_EXTRA_SETUP_EDIT = "edit";
    public static final String INTENT_EXTRA_SETUP_INVALID_NETWORK = "invalid_network";
    public static final String INTENT_EXTRA_SETUP_TEXT_IS_SELECTABLE = "text_is_selectable";
    private AccessPoint mAccessPoint;
    private int mAccessPointSecurity;
    private Button mBtnBack;
    private Button mBtnContinue;
    private WifiManager.ActionListener mConnectListener;
    private FrameLayout mLayoutParent;
    private WifiManager.ActionListener mSaveListener;
    private CheckBox mShowPwd;
    private WifiManager mWifiManager;
    private EditText mWifiPwd;
    private int scanCount;

    public void com_android_settings_meeting_TabletWifiPasswordActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_meeting_TabletWifiPasswordActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_meeting_TabletWifiPasswordActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_meeting_TabletWifiPasswordActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public TabletWifiPasswordActivity() {
        this.mAccessPoint = null;
    }

    static /* synthetic */ EditText access$000(TabletWifiPasswordActivity r0) {
        return r0.mWifiPwd;
    }

    public void com_android_settings_meeting_TabletWifiPasswordActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        setContentView(R.layout.revone_wifi_input_password);
        initViews();
        initialize();
    }

    private void initViews() {
        this.mLayoutParent = (FrameLayout) findViewById(R.id.layout_parent);
        this.mBtnBack = (Button) findViewById(R.id.btn_back);
        this.mBtnContinue = (Button) findViewById(R.id.btn_continue);
        this.mWifiPwd = (EditText) findViewById(R.id.wifi_pwd);
        this.mShowPwd = (CheckBox) findViewById(R.id.checkbox_show_pwd);
        this.mBtnBack.setOnClickListener(this);
        this.mBtnContinue.setOnClickListener(this);
        this.mShowPwd.setOnCheckedChangeListener(new AnonymousClass1(this));
    }

    private void initialize() {
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        Bundle r0 = getIntent().getExtras();
        Bundle r1 = r0.getBundle("access_point");
        int r2 = 0;
        if (r1 == null) goto L7;
        this.mAccessPoint = new AccessPoint(this, r1);
        if (r0.getBoolean(INTENT_EXTRA_SETUP_INVALID_NETWORK, false) == false) goto L7;
        this.mAccessPoint.networkId = -1;
    L7:
        AccessPoint r3 = this.mAccessPoint;
        if (r3 == null) goto L11;
        r2 = r3.security;
    L11:
        this.mAccessPointSecurity = r2;
        this.mConnectListener = new AnonymousClass2(this);
        this.mSaveListener = new AnonymousClass3(this);
    }

    private WifiConfiguration getConfig() {
        AccessPoint r0 = this.mAccessPoint;
        if (r0 != null) goto L5;
    L7:
        WifiConfiguration r1 = new WifiConfiguration();
        AccessPoint r3 = this.mAccessPoint;
        if (r3 != null) goto L11;
        r1.hiddenSSID = true;
    L16:
        int r2 = this.mAccessPointSecurity;
        if (r2 != 0) goto L19;
        r1.allowedKeyManagement.set(0);
    L28:
        return r1;
    L19:
        if (r2 == 2) goto L21;
        return null;
    L21:
        r1.allowedKeyManagement.set(1);
        if (this.mWifiPwd.getText().length() == 0) goto L28;
        String r5 = this.mWifiPwd.getText().toString();
        if (r5.matches("[0-9A-Fa-f]{64}") == false) goto L26;
        r1.preSharedKey = r5;
        goto L28
    L26:
        r1.preSharedKey = "\"" + r5 + '\"';
        goto L28
    L11:
        if (r3.networkId != (-1)) goto L15;
        r1.SSID = AccessPoint.convertToQuotedString(this.mAccessPoint.ssid);
        if (this.mAccessPoint.getConfig() == null) goto L16;
        r1.hiddenSSID = this.mAccessPoint.getConfig().hiddenSSID;
        goto L16
    L15:
        r1.networkId = this.mAccessPoint.networkId;
        goto L16
    L5:
        if (r0.networkId == (-1)) goto L7;
        return null;
    }

    private void submit() {
        WifiConfiguration r0 = getConfig();
        if (this.mAccessPoint == null) goto L5;
        this.mWifiManager.connect(r0, this.mConnectListener);
        finish();
        return;
    L5:
        this.mWifiManager.save(r0, this.mSaveListener);
        this.scanCount = 3;
        forceScan();
    }

    private void forceScan() {
        Thread.sleep(1000);     // Catch: Exception -> L5
    L7:
        this.mWifiManager.startScan();
        return;
    L5:
        e = move-exception;
        OLog.e("TabletWifiPasswordActivity", "Exception:" + e.toString());
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 != R.id.btn_back) goto L5;
        finish();
        return;
    L5:
        if (r3 != R.id.btn_continue) goto L11;
        submit();
        return;
    }

    public void com_android_settings_meeting_TabletWifiPasswordActivity__finish$___twin___() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(TabletWifiPasswordActivity r1) {
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(TabletWifiPasswordActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPasswordActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_meeting_TabletWifiPasswordActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(TabletWifiPasswordActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(TabletWifiPasswordActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        TabletWifiPasswordActivity r5 = r4;
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
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(TabletWifiPasswordActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_meeting_TabletWifiPasswordActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(TabletWifiPasswordActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_meeting_TabletWifiPasswordActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(TabletWifiPasswordActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPasswordActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_meeting_TabletWifiPasswordActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(TabletWifiPasswordActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(TabletWifiPasswordActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPasswordActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_meeting_TabletWifiPasswordActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(TabletWifiPasswordActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        TabletWifiPasswordActivity r5 = r3;
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
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(TabletWifiPasswordActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPasswordActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_meeting_TabletWifiPasswordActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_meeting_TabletWifiPasswordActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(TabletWifiPasswordActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPasswordActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_meeting_TabletWifiPasswordActivity__finish$___twin___();
    }
}
