package com.android.settings;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.icu.lang.UProperty;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserManager;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.GlobalProxyLancet;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class FallbackHome extends Activity {
    private static final int BLOCK_LOGO_STAGE_BOOT_COMPLETE = 15;
    private static final int BLOCK_LOGO_STAGE_HOME_START = 6;
    private static final String TAG = "FallbackHome";
    private final Handler mHandler;
    private int mProgressTimeout;
    private final Runnable mProgressTimeoutRunnable;
    private boolean mProvisioned;
    private final BroadcastReceiver mReceiver;

    public void com_android_settings_FallbackHome__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_FallbackHome__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_FallbackHome_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        com_android_settings_FallbackHome_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        com_android_settings_FallbackHome_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_settings_FallbackHome_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_FallbackHome_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public FallbackHome() {
        this.mProgressTimeoutRunnable = new FallbackHome$$ExternalSyntheticLambda0(this);
        this.mReceiver = new AnonymousClass1(this);
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass2(this, r1);
    }

    static /* synthetic */ Handler access$000(FallbackHome r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$100(FallbackHome r0) {
        r0.maybeFinish();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-FallbackHome, reason: not valid java name */
    /* synthetic */ void m139lambda$new$0$comandroidsettingsFallbackHome() {
        View r0 = getLayoutInflater().inflate(R.layout.fallback_home_finishing_boot, null);
        setContentView(r0);
        r0.setAlpha(0.0f);
        r0.animate().alpha(1.0f).setDuration(500).setInterpolator(AnimationUtils.loadInterpolator(this, 17563661)).start();
    }

    private static void notifyStabdStatus(int r6, int r7) {
        OLog.i(TAG, "notifyStabdStatus:blockStage=" + r6 + ",timeOut=" + r7);
        Parcel r1 = null;
        IBinder r3 = ServiceManager.getService("stabservice");     // Catch: Throwable -> L15 RemoteException -> L17
        if (r3 == null) goto L12;
        Parcel r4 = Parcel.obtain();     // Catch: Throwable -> L15 RemoteException -> L17
        r4.writeInterfaceToken("android.stab.IBStabService");     // Catch: Throwable -> L8 RemoteException -> L10
        r4.writeInt(r6);     // Catch: Throwable -> L8 RemoteException -> L10
        r4.writeInt(r7);     // Catch: Throwable -> L8 RemoteException -> L10
        r3.transact(17, r4, null, 1);     // Catch: Throwable -> L8 RemoteException -> L10
        r1 = r4;
    L13:
        if (r1 == null) goto L21;
    L14:
        r1.recycle();
        return;
    L21:
        return;
    L10:
        e = e;
        r1 = r4;
    L18:
        OLog.i(TAG, "notifyStabdStatus failure:" + e);     // Catch: Throwable -> L15
        if (r1 != null) goto L14;
        return;
    L8:
        th = th;
        r1 = r4;
    L22:
        if (r1 == null) goto L24;
        r1.recycle();
    L24:
        throw th;
    L12:
        OLog.i(TAG, "notifyStabdStatus proxy is null!");     // Catch: Throwable -> L15 RemoteException -> L17
    L15:
        th = th;
    L17:
        e = e;
        goto L18
    }

    public void com_android_settings_FallbackHome__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mProgressTimeout = getResources().getInteger(getResources().getIdentifier("config_progressTimeoutFallbackHome", "integer", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME));
        OLog.d(TAG, "onCreate mProgressTimeout=" + this.mProgressTimeout);
        boolean r0 = false;
        if (this.mProgressTimeout > 0) goto L5;
        this.mProgressTimeout = 0;
    L5:
        notifyStabdStatus(6, 0);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        if (android.provider.Settings.Global.getInt(getContentResolver(), "device_provisioned", 0) != 0) goto L9;
        setTheme(android.R.style.Theme.Black.NoTitleBar.Fullscreen);
    L9:
        if (android.provider.Settings.Global.getInt(getContentResolver(), "device_provisioned", 0) == 0) goto L11;
        r0 = true;
    L11:
        this.mProvisioned = r0;
        getWindow().getDecorView().setSystemUiVisibility(UProperty.JOINING_GROUP);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"), 2);
        maybeFinish();
    }

    public void com_android_settings_FallbackHome__onResume$___twin___() {
        super.onResume();
        PackageManager r0 = getPackageManager();
        if (this.mProvisioned == true) goto L5;
        return;
    L5:
        if (r0.isDeviceUpgrading() == false) goto L9;
        this.mHandler.postDelayed(this.mProgressTimeoutRunnable, this.mProgressTimeout);
        return;
    }

    public void com_android_settings_FallbackHome__onPause$___twin___() {
        super.onPause();
        this.mHandler.removeCallbacks(this.mProgressTimeoutRunnable);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mReceiver);     // Catch: Exception -> L5
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "Error unregistering receiver", e);
    }

    private void maybeFinish() {
        UserManager r0 = (UserManager) getSystemService(UserManager.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isUserUnlocked() == false) goto L18;
        Intent r1 = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
        ResolveInfo r2 = getPackageManager().resolveActivity(r1, 0);
        if (r2 != null) goto L10;
    L16:
        OLog.d(TAG, "User unlocked but no home ResolveInfo; waiting for home to be enabled");
        this.mHandler.sendEmptyMessageDelayed(0, 500);
        return;
    L10:
        if (r2.activityInfo == null) goto L16;
        if (Objects.equals(getPackageName(), r2.activityInfo.packageName) == false) goto L15;
        OLog.d(TAG, "User unlocked but no home; let's hope someone enables one soon?");
        this.mHandler.sendEmptyMessageDelayed(0, 500);
        return;
    L15:
        OLog.d(TAG, "User unlocked and real home found; let's go!");
        notifyStabdStatus(15, 0);
        finish();
        return;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();     // Catch: Exception -> L4
        overridePendingTransition(0, 0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "Error finish fallback home", e);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FallbackHome_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(FallbackHome r1) {
        r1.com_android_settings_FallbackHome__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FallbackHome_com_obric_hook_lancet_BatchedActivityLancet_onResume(FallbackHome r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_FallbackHome_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FallbackHome_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(FallbackHome r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_FallbackHome__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        FallbackHome r5 = r4;
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
    public static void com_android_settings_FallbackHome_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(FallbackHome r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_FallbackHome__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FallbackHome_com_obric_hook_lancet_BatchedActivityLancet_onStop(FallbackHome r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_FallbackHome_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_FallbackHome_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(FallbackHome r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_FallbackHome__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_FallbackHome_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(FallbackHome r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_FallbackHome__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        FallbackHome r5 = r3;
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
