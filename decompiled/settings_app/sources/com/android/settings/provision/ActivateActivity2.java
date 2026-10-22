package com.android.settings.provision;

import android.app.Dialog;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.SystemProperties;
import com.android.settings.MultiSimAdapter;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.Utils;
import com.android.settings.about.DeviceUtils;
import com.android.settings.activate.ActivateConstants;
import com.android.settings.activate.ActivateService;
import com.android.settings.base.BaseActivity;
import com.android.settings.provision.NextPageRouting.RoutingUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.EventReportUtil;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.time.TimeProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ActivateActivity2 extends BaseActivity implements TimeProvider.OnTimeFetchedListener {
    private static final int CHECK_INTERVAL_MS = 1000;
    private static final boolean DEBUG = false;
    private static final int FETCH_TIME_TIMEOUT = 15000;
    public static final int RESULT_ACTIVATE_CANCELED = 10002;
    public static final int RESULT_ACTIVATE_LOCKED = 10001;
    public static final int RESULT_ACTIVATE_SUCCESS = -1;
    private static final String TAG = "ActivateActivity2";
    private static final int TIMEOUT_MS = 30000;
    private static final String authority = "com.obric.cloudservice.finddeviceprovider";
    private Runnable checkConditionRunnable;
    private Handler handler;
    private Context mContext;
    private Handler mFetchTimeHandler;
    private Runnable mFetchTimeRunnable;
    boolean mIsCell;
    private TimeProvider mTimeProvider;
    private Handler mTimeoutHandler;
    private Runnable mTimeoutRunnable;
    private long startTime;

    public void com_android_settings_provision_ActivateActivity2__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_provision_ActivateActivity2__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_provision_ActivateActivity2__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_provision_ActivateActivity2__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ActivateActivity2() {
        this.mIsCell = false;
        this.mTimeoutHandler = new Handler();
        this.mTimeoutRunnable = new AnonymousClass1(this);
        this.mFetchTimeHandler = new Handler();
        this.mFetchTimeRunnable = new AnonymousClass2(this);
    }

    static /* synthetic */ Runnable access$000(ActivateActivity2 r0) {
        return r0.mTimeoutRunnable;
    }

    static /* synthetic */ Handler access$100(ActivateActivity2 r0) {
        return r0.mTimeoutHandler;
    }

    static /* synthetic */ TimeProvider access$200(ActivateActivity2 r0) {
        return r0.mTimeProvider;
    }

    static /* synthetic */ void access$300(ActivateActivity2 r0) {
        r0.startActivateService();
    }

    static /* synthetic */ void access$400(ActivateActivity2 r0) {
        r0.checkActivation();
    }

    static /* synthetic */ void access$500(ActivateActivity2 r0, String r1) {
        r0.sendCheckLockStatus(r1);
    }

    static /* synthetic */ long access$600(ActivateActivity2 r2) {
        return r2.startTime;
    }

    static /* synthetic */ boolean access$700(long r0) {
        return isTimeoutCondition(r0);
    }

    static /* synthetic */ void access$800(ActivateActivity2 r0, boolean r1) {
        r0.sendResult(r1);
    }

    static /* synthetic */ Handler access$900(ActivateActivity2 r0) {
        return r0.handler;
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        r1 = true;
    L5:
        DEBUG = r1;
    }

    public void com_android_settings_provision_ActivateActivity2__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.activate_activity_2);
        this.mContext = getApplicationContext();
        this.mTimeProvider = TimeProvider.getTimeProvider(this);
        OLog.d(TAG, "onCreate fetchServerTime");
        fetchServerTime();
        registerWizardFinishReceiver();
        Utils.hideNavigationBar(this);
        this.mIsCell = getIntent().getBooleanExtra("isCell", false);
    }

    protected void showFailureDialog() {
        showDialogIfPossible((OAlertDialog) new OAlertDialogBuilder(this).title(R.string.activate_title).message(R.string.activate_failed_wifi).positiveButton(R.string.activate_dlg_positive, new AnonymousClass4(this)).negativeButton(R.string.activate_dlg_negative, new AnonymousClass3(this)).cancelable(false).build());
    }

    public void sendResult(int r3, Intent r4) {
        OLog.e(TAG, "sendResult code: " + r3);
        setResult(r3, r4);
        finish();
    }

    public void com_android_settings_provision_ActivateActivity2__onDestroy$___twin___() {
        super.onDestroy();
        this.mTimeoutHandler.removeCallbacksAndMessages(null);
        unregisterWizardFinishReceiver();
    }

    public void com_android_settings_provision_ActivateActivity2__finish$___twin___() {
        super.finish();
        stopService(new Intent(this.mContext, ActivateService.class));     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void showDialogIfPossible(Dialog r1) {
        if (isFinishing() == true) goto L6;
        r1.show();
        return;
    }

    private void fetchServerTime() {
        this.mFetchTimeHandler.postDelayed(this.mFetchTimeRunnable, 15000);
        this.mTimeProvider.startSyncTime(this);
        EventReportUtil.INSTANCE.reportFetchTimeStart();
    }

    private void startActivateService() {
        checkActivation();
    }

    private void checkActivation() {
        OLog.d(TAG, "startActivateService checkActivation");
        this.handler = new Handler(Looper.getMainLooper());
        this.startTime = System.currentTimeMillis();
        EventReportUtil.INSTANCE.reportCheckActivationStart();
        Runnable r0 = new AnonymousClass5(this);
        this.checkConditionRunnable = r0;
        this.handler.post(r0);
    }

    private void sendCheckLockStatus(final String r10) {
        OLog.i(TAG, "sendCheckLockStatus did: " + r10);
        EventReportUtil.INSTANCE.reportCheckLockStatusStart(r10);
        RequestQueue r1 = Volley.newRequestQueue(this);
        JSONObject r6 = new JSONObject();
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L5
        r3.put("device_id", r10);     // Catch: Exception -> L5
        r3.put("token", "");     // Catch: Exception -> L5
        r3.put(AccountConst.KEY_TICKET, "");     // Catch: Exception -> L5
        r6.put("common_param", r3);     // Catch: Exception -> L5
    L7:
        r1.add(new ActivateRequest(1, "https://find.oceancloudapi.com/api/find/client/get_lock_status", r6, new ActivateActivity2$$ExternalSyntheticLambda0(this), new ActivateActivity2$$ExternalSyntheticLambda1(this, r10)));
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "sendCheckLockStatus jsonBody error: " + e.getMessage());
        goto L7
    }

    /* JADX INFO: renamed from: lambda$sendCheckLockStatus$0$com-android-settings-provision-ActivateActivity2, reason: not valid java name */
    /* synthetic */ void m541xc84a00f0(JSONObject r3) {
        OLog.i(TAG, "sendCheckLockStatus onResponse: " + r3);
        checkLockStatus(r3);
    }

    /* JADX INFO: renamed from: lambda$sendCheckLockStatus$1$com-android-settings-provision-ActivateActivity2, reason: not valid java name */
    /* synthetic */ void m542xb9f3a70f(String r3, VolleyError r4) {
        OLog.e(TAG, "sendCheckLockStatus onErrorResponse: " + r4.getMessage());
        EventReportUtil.INSTANCE.reportCheckLockStatusResult(r3, false, false);
        sendResult(false);
    }

    private void checkLockStatus(JSONObject r10) {
        OLog.i(TAG, "checkLockStatus: " + r10);
        String r2 = SettingsApplication.getDid();
        String r4 = "";
        JSONObject r11 = r10.getJSONObject("data");     // Catch: Exception -> L18
        boolean r6 = r11.getBoolean("lock_status");     // Catch: Exception -> L18
        if (r6 == true) goto L28;
        String r12 = "";
        String r7 = r12;
    L23:
        OLog.i(TAG, "checkLockStatus isLocked: " + r6);
        OLog.i(TAG, "checkLockStatus did: " + r2 + ", contact_info: " + r4 + ", contact_mobile: " + r7);
        if (r6 == false) goto L26;
        setLocked(r12, r4, r7);
        EventReportUtil.INSTANCE.reportCheckLockStatusResult(r2, true, true);
        return;
    L26:
        EventReportUtil.INSTANCE.reportCheckLockStatusResult(r2, false, true);
        requestDeviceActivate(r2);
        return;
    L28:
        OLog.i(TAG, "checkLockStatus locked did: " + r2);     // Catch: Exception -> L15
        String r1 = r11.getString(ActivateConstants.KEY_CONTACT_INFO);     // Catch: Exception -> L15
        r7 = r11.getString(ActivateConstants.KEY_CONTACT_MOBILE);     // Catch: Exception -> L13
    L11:
        e = e;
    L20:
        OLog.e(TAG, "checkLockStatus error: " + e.getMessage());
    L21:
        r12 = "";
    L22:
        r4 = r1;
        goto L23
    L8:
        if (r11.has("token") == false) goto L21;
        r12 = r11.getString("token");     // Catch: Exception -> L11
    L13:
        e = e;
        r7 = "";
    L15:
        e = e;
        r1 = "";
        r7 = r1;
    L18:
        e = e;
        r1 = "";
        r7 = r1;
        r6 = false;
        goto L20
    }

    private void requestDeviceActivate(final String r9) {
        EventReportUtil.INSTANCE.reportActivateDeviceStart(r9);
        String r3 = "https://ocean-ota.oceancloudapi.com/open/v3/activation/device?_nonce=" + System.currentTimeMillis();
        OLog.i(TAG, "requestDeviceActivate url: " + r3);
        RequestQueue r0 = Volley.newRequestQueue(this);
        JSONObject r4 = new JSONObject();
        r4.put("product", "Pacific");     // Catch: Exception -> L5
        r4.put("model", "P0110");     // Catch: Exception -> L5
        r4.put(SstLoader.KEY_UDID, Utils.getDeviceIMEI());     // Catch: Exception -> L5
        r4.put("os_version", DeviceUtils.INSTANCE.getShortOSVersion());     // Catch: Exception -> L5
        r4.put("rom_version", DeviceUtils.INSTANCE.getOSVersion());     // Catch: Exception -> L5
    L7:
        r0.add(new ActivationDeviceRequest(1, r3, r4, new AnonymousClass6(this, r9), new AnonymousClass7(this, r9)));
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "requestDeviceActivate jsonBody error: " + e.getMessage());
        goto L7
    }

    private static boolean isTimeoutCondition(long r2) {
        if ((System.currentTimeMillis() - r2) < 30000) goto L5;
        return true;
    L5:
        return false;
    }

    private void successToNext() {
        OLog.i(TAG, "successToNext");
        RoutingUtils.nextToFace(this);
    }

    private void lockToNext(String r3, String r4, String r5) {
        OLog.i(TAG, "lockToNext");
        lockDevice(this, r3, r4, r5);
    }

    private static boolean lockDevice(Context r6, String r7, String r8, String r9) {
        ContentProviderClient r10 = r6.getContentResolver().acquireUnstableContentProviderClient(authority);
        Bundle r3 = null;
        if (r10 == null) goto L9;
        Bundle r4 = new Bundle();     // Catch: Throwable -> L5 Exception -> L7
        r4.putString("content", r8);     // Catch: Throwable -> L5 Exception -> L7
        r4.putString("token", r7);     // Catch: Throwable -> L5 Exception -> L7
        r4.putString(MultiSimAdapter.PHONE_KEY, r9);     // Catch: Throwable -> L5 Exception -> L7
        r3 = r10.call(authority, "REQUEST_LOCK_FROM_PROVISION", null, r4);     // Catch: Throwable -> L5 Exception -> L7
    L10:
        if (r10 == null) goto L15;
    L11:
        r10.close();
    L15:
        if (r3 != null) goto L17;
    L18:
        return true;
    L17:
        if (r3.getBoolean("result", false) == true) goto L18;
        return false;
    L9:
        OLog.e(TAG, "lockDevice error: client is null");     // Catch: Throwable -> L5 Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        OLog.e(TAG, "lockDevice error: " + e);     // Catch: Throwable -> L5
        if (r10 == null) goto L15;
    L5:
        th = move-exception;
        if (r10 == null) goto L22;
        r10.close();
    L22:
        throw th;
    }

    private void sendResult(boolean r3) {
        OLog.i(TAG, "sendResult success: " + r3);
        if (r3 == false) goto L6;
        successToNext();
        sendResult(-1, null);
        return;
    L6:
        if (this.mIsCell == false) goto L8;
        sendResult(0, null);
        return;
    L8:
        showFailureDialog();
    }

    private void setLocked(String r3, String r4, String r5) {
        OLog.i(TAG, "setLocked");
        lockToNext(r3, r4, r5);
    }

    @Override // obric.time.TimeProvider.OnTimeFetchedListener
    public void onTimeFetched(boolean r4) {
        if (r4 == false) goto L5;
        SystemClock.setCurrentTimeMillis(this.mTimeProvider.getNetworkTimeMillis());
    L6:
        EventReportUtil.INSTANCE.reportFetchTimeResult(r4);
        this.mFetchTimeHandler.removeCallbacks(this.mFetchTimeRunnable);
        OLog.d(TAG, "onTimeFetched startActivateService");
        startActivateService();
        return;
    L5:
        OLog.e(TAG, "fetch time failed.");
        goto L6
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r2) {
        super.onWindowFocusChanged(r2);
        if (Utils.isDeviceSetupComplete(this) == true) goto L6;
        OLog.w(TAG, "onWindowFocusChanged isDeviceSetupComplete false ");
        Utils.hideNavigationBar(this);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_ActivateActivity2_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ActivateActivity2 r1) {
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onCreate(ActivateActivity2 r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity2 r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_provision_ActivateActivity2__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_BatchedActivityLancet_onResume(ActivateActivity2 r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ActivateActivity2 r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ActivateActivity2 r5 = r4;
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
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ActivateActivity2 r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_provision_ActivateActivity2__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_BatchedActivityLancet_onStop(ActivateActivity2 r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_provision_ActivateActivity2_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onResume(ActivateActivity2 r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity2 r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_provision_ActivateActivity2__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ActivateActivity2 r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onPause(ActivateActivity2 r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity2 r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_provision_ActivateActivity2__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ActivateActivity2 r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ActivateActivity2 r5 = r3;
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
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onStop(ActivateActivity2 r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity2 r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_provision_ActivateActivity2__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_onDestroy(ActivateActivity2 r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity2 r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_provision_ActivateActivity2__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_provision_ActivateActivity2_com_obric_hook_lancet_PrivacyHook_finish(ActivateActivity2 r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity2 r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_provision_ActivateActivity2__finish$___twin___();
    }
}
