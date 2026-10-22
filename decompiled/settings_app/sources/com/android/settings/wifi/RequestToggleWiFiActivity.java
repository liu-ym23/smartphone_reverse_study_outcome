package com.android.settings.wifi;

import android.app.ActivityManager;
import android.app.Application;
import android.app.IActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.StatusDialogUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class RequestToggleWiFiActivity extends LifeHookActivity2 implements DialogInterface.OnClickListener {
    private static final String EXTRA_CALLING_APP_NAME = "com.obric.intent.extra.CALLING_APP_NAME";
    private static final String LOG_TAG = "RequestToggleWiFiActivity";
    private static final int STATE_DISABLE = 3;
    private static final int STATE_DISABLING = 4;
    private static final int STATE_ENABLE = 1;
    private static final int STATE_ENABLING = 2;
    private static final int STATE_UNKNOWN = -1;
    private static final long TOGGLE_TIMEOUT_MILLIS = 10000;
    protected IActivityManager mActivityManager;
    private CharSequence mAppLabel;
    private int mLastUpdateState;
    private StatusDialog mLoadingDialog;
    private final StateChangeReceiver mReceiver;
    private OAlertDialog mRequestDialog;
    private int mState;
    private final Runnable mTimeoutCommand;
    private WifiManager mWiFiManager;

    private final class StateChangeReceiver extends BroadcastReceiver {
        private final IntentFilter mFilter;
        final /* synthetic */ RequestToggleWiFiActivity this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_wifi_RequestToggleWiFiActivity$StateChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private StateChangeReceiver(RequestToggleWiFiActivity r2) {
            this.this$0 = r2;
            this.mFilter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        }

        /* synthetic */ StateChangeReceiver(RequestToggleWiFiActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void register() {
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.this$0, this, this.mFilter, 2);
        }

        public void unregister() {
            this.this$0.unregisterReceiver(this);
        }

        public void com_android_settings_wifi_RequestToggleWiFiActivity$StateChangeReceiver__onReceive$___twin___(Context r1, Intent r2) {
            RequestToggleWiFiActivity r3 = this.this$0;
            if (r3.isFinishing() == false) goto L5;
            return;
        L5:
            if (r3.isDestroyed() == true) goto L25;
            int r4 = RequestToggleWiFiActivity.access$100(this.this$0).getWifiState();
            if (r4 == 1) goto L13;
            if (r4 == 3) goto L13;
            return;
        L13:
            if (RequestToggleWiFiActivity.access$200(this.this$0) != 2) goto L15;
        L16:
            this.this$0.setResult(-1);
            if (RequestToggleWiFiActivity.access$300(this.this$0) != null) goto L19;
        L21:
            this.this$0.finish();
            return;
        L19:
            if (RequestToggleWiFiActivity.access$300(this.this$0).isShowing() == false) goto L21;
            RequestToggleWiFiActivity.access$300(this.this$0).dismiss();
            RequestToggleWiFiActivity.access$302(this.this$0, null);
            goto L21
        L15:
            if (RequestToggleWiFiActivity.access$200(this.this$0) == 4) goto L16;
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_wifi_RequestToggleWiFiActivity$StateChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(StateChangeReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            StateChangeReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_wifi_RequestToggleWiFiActivity$StateChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_wifi_RequestToggleWiFiActivity$StateChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_wifi_RequestToggleWiFiActivity$StateChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_wifi_RequestToggleWiFiActivity$StateChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    public void com_android_settings_wifi_RequestToggleWiFiActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_wifi_RequestToggleWiFiActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_wifi_RequestToggleWiFiActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStart(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public RequestToggleWiFiActivity() {
        this.mReceiver = new StateChangeReceiver(this, null);
        this.mTimeoutCommand = new RequestToggleWiFiActivity$$ExternalSyntheticLambda0(this);
        this.mActivityManager = ActivityManager.getService();
        this.mState = -1;
        this.mLastUpdateState = -1;
    }

    static /* synthetic */ WifiManager access$100(RequestToggleWiFiActivity r0) {
        return r0.mWiFiManager;
    }

    static /* synthetic */ int access$200(RequestToggleWiFiActivity r0) {
        return r0.mState;
    }

    static /* synthetic */ StatusDialog access$300(RequestToggleWiFiActivity r0) {
        return r0.mLoadingDialog;
    }

    static /* synthetic */ StatusDialog access$302(RequestToggleWiFiActivity r0, StatusDialog r1) {
        r0.mLoadingDialog = r1;
        return r1;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-wifi-RequestToggleWiFiActivity, reason: not valid java name */
    /* synthetic */ void m675lambda$new$0$comandroidsettingswifiRequestToggleWiFiActivity() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L9;
        finish();
        return;
    }

    public void com_android_settings_wifi_RequestToggleWiFiActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        getWindow().addSystemFlags(524288);
        this.mWiFiManager = (WifiManager) getSystemService(WifiManager.class);
        setResult(0);
        this.mAppLabel = getAppLabel();
        if (getIntent().getStringExtra(EXTRA_CALLING_APP_NAME) == null) goto L6;
        this.mAppLabel = getIntent().getStringExtra(EXTRA_CALLING_APP_NAME);
    L6:
        if (TextUtils.isEmpty(this.mAppLabel) == false) goto L9;
        finish();
        return;
    L9:
        String r3 = getIntent().getAction();
        r3.hashCode();
        if (r3.equals("android.net.wifi.action.REQUEST_ENABLE") == false) goto L12;
        this.mState = 1;
    L16:
        this.mReceiver.register();
        return;
    L12:
        if (r3.equals("android.net.wifi.action.REQUEST_DISABLE") == true) goto L14;
        finish();
        goto L16
    L14:
        this.mState = 3;
        goto L16
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (r2 != (-2)) goto L5;
        finish();
        return;
    L5:
        if (r2 != (-1)) goto L18;
        int r3 = this.mState;
        if (r3 != 1) goto L10;
        this.mWiFiManager.setWifiEnabled(true);
        this.mState = 2;
        scheduleToggleTimeout();
        updateUi();
        return;
    L10:
        if (r3 != 3) goto L19;
        this.mWiFiManager.setWifiEnabled(false);
        this.mState = 4;
        scheduleToggleTimeout();
        updateUi();
        return;
    L19:
        return;
    }

    public void com_android_settings_wifi_RequestToggleWiFiActivity__onStart$___twin___() {
        super.onStart();
        int r0 = this.mWiFiManager.getWifiState();
        int r1 = this.mState;
        if (r1 == 1) goto L33;
        if (r1 != 2) goto L6;
        if (r0 == 0) goto L32;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L31;
        if (r0 != 3) goto L39;
        setResult(-1);
        finish();
        return;
    L39:
        updateUi();
        return;
    L31:
        scheduleToggleTimeout();
    L32:
        this.mState = 1;
        goto L39
    L6:
        if (r1 == 3) goto L18;
        if (r1 != 4) goto L39;
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        if (r0 != 3) goto L39;
    L14:
        this.mState = 3;
        goto L39
    L15:
        setResult(-1);
        finish();
        return;
    L17:
        scheduleToggleTimeout();
        goto L39
    L18:
        if (r0 == 1) goto L22;
        if (r0 != 2) goto L39;
        this.mState = 4;
        scheduleToggleTimeout();
        goto L39
    L22:
        setResult(-1);
        finish();
        return;
    L33:
        if (r0 == 2) goto L38;
        if (r0 != 3) goto L39;
        setResult(-1);
        finish();
        return;
    L38:
        this.mState = 2;
        scheduleToggleTimeout();
        goto L39
    }

    public void com_android_settings_wifi_RequestToggleWiFiActivity__onStop$___twin___() {
        super.onStop();
    }

    protected CharSequence getAppLabel() {
        String r2 = this.mActivityManager.getLaunchedFromPackage(getActivityToken());     // Catch: RemoteException -> L11
        if (TextUtils.isEmpty(r2) == false) goto L15;
        OLog.d(LOG_TAG, "Package name is null");     // Catch: RemoteException -> L11
        return null;
    L15:
        return getPackageManager().getApplicationInfo(r2, 0).loadSafeLabel(getPackageManager(), 1000.0f, 5);
    L9:
        OLog.e(LOG_TAG, "Couldn't find app with package name " + r2);
        return null;
    L11:
        OLog.e(LOG_TAG, "Can not get the package from activity manager");
        return null;
    }

    private void updateUi() {
        int r0 = this.mLastUpdateState;
        int r1 = this.mState;
        if (r0 != r1) goto L5;
        return;
    L5:
        this.mLastUpdateState = r1;
        OAlertDialogBuilder r2 = new OAlertDialogBuilder(this);
        int r3 = this.mState;
        if (r3 != 1) goto L8;
        r2.positiveButton(getString(R.string.allow), this);
        r2.negativeButton(getString(R.string.prohibit), this);
        r2.title(getString(R.string.wifi_ask_enable, new Object[]{this.mAppLabel}), true);
        r2.horizontalButton(false);
        OAlertDialog r4 = r2.build();
        this.mRequestDialog = r4;
        r4.setOnShowListener(new RequestToggleWiFiActivity$$ExternalSyntheticLambda1(this));
        this.mRequestDialog.show();
        return;
    L8:
        if (r3 != 2) goto L10;
        StatusDialog r5 = this.mLoadingDialog;
        if (r5 != null) goto L28;
    L30:
        this.mLoadingDialog = StatusDialogUtils.createStatusDialog(this, ResourceUtils.getString(R.string.wifi_starting));
        OAlertDialog r6 = this.mRequestDialog;
        if (r6 != null) goto L33;
    L35:
        this.mLoadingDialog.show();
        return;
    L33:
        if (r6.isShowing() == false) goto L35;
        this.mRequestDialog.dismiss();
        goto L35
    L28:
        if (r5.isShowing() == false) goto L30;
        return;
    L10:
        if (r3 != 3) goto L12;
        r2.positiveButton(getString(R.string.allow), this);
        r2.negativeButton(getString(R.string.prohibit), this);
        r2.title(getString(R.string.wifi_ask_disable, new Object[]{this.mAppLabel}), false);
        r2.horizontalButton(false);
        OAlertDialog r7 = r2.build();
        this.mRequestDialog = r7;
        r7.setOnShowListener(new RequestToggleWiFiActivity$$ExternalSyntheticLambda2(this));
        this.mRequestDialog.show();
        return;
    L12:
        if (r3 != 4) goto L43;
        StatusDialog r8 = this.mLoadingDialog;
        if (r8 != null) goto L17;
    L19:
        StatusDialog r9 = StatusDialogUtils.createStatusDialog(this, ResourceUtils.getString(R.string.wifi_stopping));
        this.mLoadingDialog = r9;
        r9.show();
        OAlertDialog r10 = this.mRequestDialog;
        if (r10 != null) goto L22;
        return;
    L22:
        if (r10.isShowing() == false) goto L39;
        this.mRequestDialog.dismiss();
        return;
    L39:
        return;
    L17:
        if (r8.isShowing() == false) goto L19;
        return;
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [com.android.settings.wifi.RequestToggleWiFiActivity$1] */
    /* JADX INFO: renamed from: lambda$updateUi$1$com-android-settings-wifi-RequestToggleWiFiActivity, reason: not valid java name */
    /* synthetic */ void m676x1cca6392(DialogInterface r8) {
        if ((this.mRequestDialog.getNegativeButton() instanceof TextView) == false) goto L5;
        TextView r9 = (TextView) this.mRequestDialog.getNegativeButton();
    L6:
        final TextView r6 = r9;
        final long r2 = TOGGLE_TIMEOUT_MILLIS;
        final long r4 = 1000;
        new AnonymousClass1(this, r2, r4, r6).start();
        return;
    L5:
        r9 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [com.android.settings.wifi.RequestToggleWiFiActivity$2] */
    /* JADX INFO: renamed from: lambda$updateUi$2$com-android-settings-wifi-RequestToggleWiFiActivity, reason: not valid java name */
    /* synthetic */ void m677xaa051513(DialogInterface r8) {
        if ((this.mRequestDialog.getNegativeButton() instanceof TextView) == false) goto L5;
        TextView r9 = (TextView) this.mRequestDialog.getNegativeButton();
    L6:
        final TextView r6 = r9;
        final long r2 = TOGGLE_TIMEOUT_MILLIS;
        final long r4 = 1000;
        new AnonymousClass2(this, r2, r4, r6).start();
        return;
    L5:
        r9 = null;
        goto L6
    }

    public void com_android_settings_wifi_RequestToggleWiFiActivity__onDestroy$___twin___() {
        super.onDestroy();
        this.mReceiver.unregister();
        unscheduleToggleTimeout();
        StatusDialog r0 = this.mLoadingDialog;
        if (r0 != null) goto L5;
    L7:
        OAlertDialog r1 = this.mRequestDialog;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isShowing() == false) goto L14;
        this.mRequestDialog.dismiss();
        this.mRequestDialog = null;
        return;
    L14:
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mLoadingDialog.dismiss();
        this.mLoadingDialog = null;
        goto L7
    }

    public void com_android_settings_wifi_RequestToggleWiFiActivity__finish$___twin___() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    private void scheduleToggleTimeout() {
        getWindow().getDecorView().postDelayed(this.mTimeoutCommand, TOGGLE_TIMEOUT_MILLIS);
    }

    private void unscheduleToggleTimeout() {
        getWindow().getDecorView().removeCallbacks(this.mTimeoutCommand);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RequestToggleWiFiActivity r1) {
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(RequestToggleWiFiActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestToggleWiFiActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_wifi_RequestToggleWiFiActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(RequestToggleWiFiActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(RequestToggleWiFiActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        RequestToggleWiFiActivity r5 = r4;
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
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(RequestToggleWiFiActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_RequestToggleWiFiActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(RequestToggleWiFiActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_RequestToggleWiFiActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onStart")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStart(RequestToggleWiFiActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestToggleWiFiActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_wifi_RequestToggleWiFiActivity__onStart$___twin___();
    }

    @Insert("onResume")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(RequestToggleWiFiActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestToggleWiFiActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_wifi_RequestToggleWiFiActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(RequestToggleWiFiActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(RequestToggleWiFiActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestToggleWiFiActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_wifi_RequestToggleWiFiActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(RequestToggleWiFiActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        RequestToggleWiFiActivity r5 = r3;
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
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(RequestToggleWiFiActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestToggleWiFiActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_wifi_RequestToggleWiFiActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(RequestToggleWiFiActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestToggleWiFiActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_wifi_RequestToggleWiFiActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_wifi_RequestToggleWiFiActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(RequestToggleWiFiActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestToggleWiFiActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_wifi_RequestToggleWiFiActivity__finish$___twin___();
    }
}
