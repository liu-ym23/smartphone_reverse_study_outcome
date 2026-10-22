package com.android.settings.activate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.widget.ProgressBar;
import com.GlobalProxyLancet;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.WifiSettings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.BytedanceProgressDialog;
import obric.time.TimeProvider;

/* JADX INFO: loaded from: classes2.dex */
public class ActivateActivity extends BaseActivity implements TimeProvider.OnTimeFetchedListener {
    public static final String ACTION_CANCEL_ACTIVATION = "com.bytedanceos.action.CANCEL_ACTIVATION";
    private static final int ACTIVATE_VIA_SMS = 2;
    private static final boolean DEBUG = false;
    private static final int FETCH_TIME_TIMEOUT = 15000;
    private static final String TAG = "SettingsBytedance";
    private int FLAG_HIDE_NAVIGATION_BAR;
    private Context mContext;
    private Handler mFetchTimeHandler;
    private Runnable mFetchTimeRunnable;
    private int mIntentFlag;
    private ProgressBar mLoadingView;
    private BytedanceProgressDialog mProgressView;
    private BroadcastReceiver mReceiver;
    private SmsObserver mSmsObserver;
    private TimeProvider mTimeProvider;
    private Handler mTimeoutHandler;
    private Runnable mTimeoutRunnable;
    private Uri mUriSms;

    private class SmsObserver extends ContentObserver {
        final /* synthetic */ ActivateActivity this$0;

        public SmsObserver(ActivateActivity r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r13, Uri r14) {
            if (ActivateActivity.access$500() == false) goto L5;
            OLog.d(ActivateActivity.TAG, "SmsObserver onChange: " + r14);
        L5:
            Cursor r3 = null;
            Cursor r5 = ActivateActivity.access$400(this.this$0).getContentResolver().query(r14, new String[]{"address, body, type"}, null, null, null);     // Catch: SQLiteException -> L34 Throwable -> L39
            if (r5 != null) goto L46;
        L32:
            if (r5 == null) goto L48;
            r5.close();
            return;
        L48:
            return;
        L46:
        L30:
            e = e;
            r3 = r5;
        L35:
            e.printStackTrace();     // Catch: Throwable -> L39
            OLog.d(ActivateActivity.TAG, "e: " + e.getMessage());     // Catch: Throwable -> L39
            if (r3 == null) goto L50;
            r3.close();
            return;
        L50:
            return;
        L28:
            th = th;
            r3 = r5;
        L40:
            if (r3 == null) goto L42;
            r3.close();
        L42:
            throw th;
        L9:
            if (r5.moveToFirst() == false) goto L32;
            String r6 = r5.getString(0);     // Catch: Throwable -> L28 SQLiteException -> L30
            String r8 = r5.getString(1);     // Catch: Throwable -> L28 SQLiteException -> L30
            int r9 = r5.getInt(2);     // Catch: Throwable -> L28 SQLiteException -> L30
            OLog.d(ActivateActivity.TAG, " address=" + r6 + " , body=" + r8);     // Catch: Throwable -> L28 SQLiteException -> L30
            String r1 = ActivateService.GetSendingGateway();     // Catch: Throwable -> L28 SQLiteException -> L30
            int r10 = ActivateService.mGateWays.indexOf(r1);     // Catch: Throwable -> L28 SQLiteException -> L30
            if (r1.equals(r6) == false) goto L32;
            if (1 != r9) goto L24;
            Bundle r2 = SmsParser.parseSms(r8);     // Catch: Throwable -> L28 SQLiteException -> L30
            if (r2 != null) goto L17;
            int r11 = -1;
        L18:
            if (r11 != (-1)) goto L23;
            Intent r4 = new Intent(this.this$0, ActivateService.class);     // Catch: Throwable -> L28 SQLiteException -> L30
            if (r10 != (ActivateService.mGateWays.size() - 1)) goto L22;
            ActivateActivity r7 = this.this$0;     // Catch: Throwable -> L28 SQLiteException -> L30
            ToastUtils.show(r7, ActivateActivity.access$400(r7).getString(R.string.activate_failed_sms));     // Catch: Throwable -> L28 SQLiteException -> L30
            this.this$0.stopService(r4);     // Catch: Throwable -> L28 SQLiteException -> L30
            goto L24
        L22:
            r4.putExtra("flag", 3);     // Catch: Throwable -> L28 SQLiteException -> L30
            this.this$0.startService(r4);     // Catch: Throwable -> L28 SQLiteException -> L30
            goto L24
        L23:
            Intent r12 = new Intent();     // Catch: Throwable -> L28 SQLiteException -> L30
            r12.putExtra("result", r2);     // Catch: Throwable -> L28 SQLiteException -> L30
            this.this$0.sendResult(-1, r12);     // Catch: Throwable -> L28 SQLiteException -> L30
            goto L24
        L17:
            r11 = r2.getInt("result", -1);     // Catch: Throwable -> L28 SQLiteException -> L30
        L24:
            Uri r15 = Uri.withAppendedPath(ActivateActivity.access$900(this.this$0), r14.getLastPathSegment());     // Catch: Throwable -> L28 SQLiteException -> L30
            OLog.d(ActivateActivity.TAG, "delete uri: " + r15);     // Catch: Throwable -> L28 SQLiteException -> L30
            OLog.d(ActivateActivity.TAG, "delete sms success: " + ActivateActivity.access$400(this.this$0).getContentResolver().delete(r15, null, null));     // Catch: Throwable -> L28 SQLiteException -> L30
            if (r10 != (ActivateService.mGateWays.size() - 1)) goto L32;
            this.this$0.finish();     // Catch: Throwable -> L28 SQLiteException -> L30
        L34:
            e = e;
        L39:
            th = th;
            goto L40
        }
    }

    public void com_android_settings_activate_ActivateActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_activate_ActivateActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_activate_ActivateActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_activate_ActivateActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ActivateActivity() {
        this.mUriSms = Uri.parse("content://sms");
        this.mTimeoutHandler = new Handler();
        this.mTimeoutRunnable = new AnonymousClass1(this);
        this.mFetchTimeHandler = new Handler();
        this.mFetchTimeRunnable = new AnonymousClass2(this);
        this.mReceiver = new AnonymousClass3(this);
        this.FLAG_HIDE_NAVIGATION_BAR = 5378;
    }

    static /* synthetic */ Runnable access$000(ActivateActivity r0) {
        return r0.mTimeoutRunnable;
    }

    static /* synthetic */ Handler access$100(ActivateActivity r0) {
        return r0.mTimeoutHandler;
    }

    static /* synthetic */ TimeProvider access$200(ActivateActivity r0) {
        return r0.mTimeProvider;
    }

    static /* synthetic */ void access$300(ActivateActivity r0) {
        r0.startActivateService();
    }

    static /* synthetic */ Context access$400(ActivateActivity r0) {
        return r0.mContext;
    }

    static /* synthetic */ Context access$402(ActivateActivity r0, Context r1) {
        r0.mContext = r1;
        return r1;
    }

    static /* synthetic */ boolean access$500() {
        return DEBUG;
    }

    static /* synthetic */ int access$600(ActivateActivity r0) {
        return r0.mIntentFlag;
    }

    static /* synthetic */ BytedanceProgressDialog access$700(ActivateActivity r0) {
        return r0.mProgressView;
    }

    static /* synthetic */ void access$800(ActivateActivity r0, Dialog r1) {
        r0.showDialogIfPossible(r1);
    }

    static /* synthetic */ Uri access$900(ActivateActivity r0) {
        return r0.mUriSms;
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        r1 = true;
    L5:
        DEBUG = r1;
    }

    public void com_android_settings_activate_ActivateActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        getWindow().setLayout(-1, -1);
        getWindow().addFlags(Integer.MIN_VALUE);
        this.mContext = getApplicationContext();
        this.mIntentFlag = getIntent().getIntExtra("flag", 0);
        this.mTimeProvider = TimeProvider.getTimeProvider(this);
        if (this.mIntentFlag != 2) goto L5;
        startActivateService();
    L6:
        this.mSmsObserver = new SmsObserver(this, this.mTimeoutHandler);
        getContentResolver().registerContentObserver(this.mUriSms, true, this.mSmsObserver);
        IntentFilter r7 = new IntentFilter();
        r7.addAction(ActivateService.ACTION_ACTIVATE_FINISHED);
        r7.addAction("com.bytedanceos.action.SMS_SENT");
        r7.addAction(WifiSettings.ACTION_WIFI_AUTHORIZATION_START);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, r7);
        BytedanceProgressDialog r8 = new BytedanceProgressDialog(this);
        this.mProgressView = r8;
        r8.setCanceledOnTouchOutside(false);
        this.mProgressView.setOnCancelListener(new AnonymousClass4(this));
        if (this.mIntentFlag != 2) goto L9;
        this.mProgressView.setTitle(R.string.activate_sms);
        this.mProgressView.setMessage(getText(R.string.activate_sms_msg_sending));
    L10:
        showDialogIfPossible(this.mProgressView);
        if (this.mIntentFlag != 2) goto L13;
        this.mTimeoutHandler.postDelayed(this.mTimeoutRunnable, 180000);
    L13:
        registerWizardFinishReceiver();
        return;
    L9:
        this.mProgressView.setMessage(getText(R.string.activate_progress_message));
        goto L10
    L5:
        fetchServerTime();
        goto L6
    }

    protected void showFailureDialog() {
        AlertDialog.Builder r0 = new AlertDialog.Builder(this);
        if (this.mIntentFlag != 0) goto L5;
        int r1 = R.string.activate_failed_wifi;
    L6:
        showDialogIfPossible(r0.setMessage(r1).setPositiveButton(R.string.activate_dlg_positive, new AnonymousClass6(this)).setNegativeButton(R.string.activate_dlg_negative, new AnonymousClass5(this)).setCancelable(false).create());
        return;
    L5:
        r1 = R.string.activate_failed_cellular;
        goto L6
    }

    public void sendResult(int r4, Intent r5) {
        if (r4 != (-1)) goto L5;
        Settings.Global.putInt(getContentResolver(), Constants.DEVICE_ACTIVATION_COMPLETED, 1);
        ActivateService.sendUploadIMEI(this.mContext);
    L5:
        setResult(r4, r5);
        finish();
        overridePendingTransition(0, 0);
    }

    public void com_android_settings_activate_ActivateActivity__onDestroy$___twin___() {
        super.onDestroy();
        this.mTimeoutHandler.removeCallbacksAndMessages(null);
        getContentResolver().unregisterContentObserver(this.mSmsObserver);
        unregisterReceiver(this.mReceiver);
        unregisterWizardFinishReceiver();
    }

    public void com_android_settings_activate_ActivateActivity__finish$___twin___() {
        super.finish();
        stopService(new Intent(this.mContext, ActivateService.class));     // Catch: IllegalStateException -> L5
    L7:
        overridePendingTransition(0, 0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void showDialogIfPossible(Dialog r1) {
        if (isFinishing() == true) goto L6;
        r1.show();
        return;
    }

    private void fetchServerTime() {
        this.mFetchTimeHandler.postDelayed(this.mFetchTimeRunnable, 15000);
        this.mTimeProvider.startSyncTime(this);
    }

    private void startActivateService() {
        Intent r0 = new Intent(this, ActivateService.class);
        r0.putExtra("flag", this.mIntentFlag);
        startService(r0);
    }

    @Override // obric.time.TimeProvider.OnTimeFetchedListener
    public void onTimeFetched(boolean r3) {
        if (r3 == false) goto L4;
        SystemClock.setCurrentTimeMillis(this.mTimeProvider.getNetworkTimeMillis());
    L5:
        this.mFetchTimeHandler.removeCallbacks(this.mFetchTimeRunnable);
        startActivateService();
        return;
    L4:
        OLog.e(TAG, "fetch time failed.");
        goto L5
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_activate_ActivateActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ActivateActivity r1) {
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ActivateActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_activate_ActivateActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ActivateActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ActivateActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ActivateActivity r5 = r4;
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
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ActivateActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_activate_ActivateActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ActivateActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_activate_ActivateActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onResume(ActivateActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_activate_ActivateActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ActivateActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onPause(ActivateActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_activate_ActivateActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ActivateActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ActivateActivity r5 = r3;
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
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onStop(ActivateActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_activate_ActivateActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(ActivateActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_activate_ActivateActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_activate_ActivateActivity_com_obric_hook_lancet_PrivacyHook_finish(ActivateActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ActivateActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_activate_ActivateActivity__finish$___twin___();
    }
}
