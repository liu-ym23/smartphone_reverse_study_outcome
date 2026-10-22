package com.android.settings.notification;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.service.notification.Condition;
import android.service.notification.ZenModeConfig;
import android.text.format.DateFormat;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.BaseVoiceSettingsActivity;
import com.android.settings.utils.NullSafe;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ZenModeVoiceActivity extends BaseVoiceSettingsActivity {
    private static final int HOUR_MINUTES = 60;
    private static final long MINUTES_MS = 60000;
    private static final String TAG = "ZenModeVoiceActivity";

    public void com_android_settings_notification_ZenModeVoiceActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_notification_ZenModeVoiceActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_notification_ZenModeVoiceActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_notification_ZenModeVoiceActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_notification_ZenModeVoiceActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.utils.BaseVoiceSettingsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ZenModeVoiceActivity() {
    }

    @Override // com.android.settings.utils.BaseVoiceSettingsActivity
    protected boolean onVoiceSettingInteraction(Intent r6) {
        if (r6.hasExtra("android.settings.extra.do_not_disturb_mode_enabled") == false) goto L14;
        int r1 = r6.getIntExtra("android.settings.extra.do_not_disturb_mode_minutes", -1);
        Condition r0 = null;
        if (r6.getBooleanExtra("android.settings.extra.do_not_disturb_mode_enabled", false) == false) goto L9;
        if (r1 <= 0) goto L8;
        r0 = ZenModeConfig.toTimeCondition(this, r1, UserHandle.myUserId());
    L8:
        int r7 = 3;
    L10:
        setZenModeConfig(r7, r0);
        AudioManager r2 = (AudioManager) getSystemService("audio");
        if (r2 == null) goto L13;
        r2.adjustStreamVolume(5, 0, 1);
    L13:
        notifySuccess(getChangeSummary(r7, r1));
    L15:
        return false;
    L9:
        r7 = 0;
        goto L10
    L14:
        OLog.v(TAG, "Missing extra android.provider.Settings.EXTRA_DO_NOT_DISTURB_MODE_ENABLED");
        finish();
        goto L15
    }

    private void setZenModeConfig(int r2, Condition r3) {
        if (r3 == null) goto L5;
        ((NotificationManager) NullSafe.nonNull(NotificationManager.from(this))).setZenMode(r2, r3.id, TAG);
        return;
    L5:
        ((NotificationManager) NullSafe.nonNull(NotificationManager.from(this))).setZenMode(r2, null, TAG);
    }

    private CharSequence getChangeSummary(int r11, int r12) {
        int r0 = -1;
        if (r11 != 0) goto L5;
        int r2 = -1;
        int r3 = -1;
        r0 = R.string.zen_mode_summary_always;
        int r1 = -1;
    L9:
        if (r12 < 0) goto L27;
        if (r11 == 0) goto L27;
        long r4 = System.currentTimeMillis() + (((long) r12) * 60000);
        if (DateFormat.is24HourFormat(this, UserHandle.myUserId()) == false) goto L15;
        String r13 = android.icu.text.DateFormat.HOUR24_MINUTE;
    L16:
        CharSequence r14 = DateFormat.format(DateFormat.getBestDateTimePattern(Locale.getDefault(), r13), r4);
        Resources r10 = getResources();
        if (r12 >= 60) goto L21;
        return r10.getQuantityString(r1, r12, new Object[]{Integer.valueOf(r12), r14});
    L21:
        if ((r12 % 60) != 0) goto L23;
        int r15 = r12 / 60;
        return r10.getQuantityString(r2, r15, new Object[]{Integer.valueOf(r15), r14});
    L23:
        return r10.getString(r3, new Object[]{r14});
    L15:
        r13 = "hma";
    L27:
        return getString(r0);
    L5:
        if (r11 == 3) goto L7;
        r1 = -1;
        r2 = -1;
        r3 = -1;
        goto L9
    L7:
        r0 = R.string.zen_mode_summary_alarms_only_indefinite;
        r1 = R.plurals.zen_mode_summary_alarms_only_by_minute;
        r2 = R.plurals.zen_mode_summary_alarms_only_by_hour;
        r3 = R.string.zen_mode_summary_alarms_only_by_time;
        goto L9
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ZenModeVoiceActivity r1) {
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(ZenModeVoiceActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ZenModeVoiceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_notification_ZenModeVoiceActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ZenModeVoiceActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ZenModeVoiceActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ZenModeVoiceActivity r5 = r4;
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
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ZenModeVoiceActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_notification_ZenModeVoiceActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ZenModeVoiceActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_notification_ZenModeVoiceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(ZenModeVoiceActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ZenModeVoiceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_notification_ZenModeVoiceActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ZenModeVoiceActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(ZenModeVoiceActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ZenModeVoiceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_notification_ZenModeVoiceActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ZenModeVoiceActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ZenModeVoiceActivity r5 = r3;
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
    public static void com_android_settings_notification_ZenModeVoiceActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(ZenModeVoiceActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ZenModeVoiceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_notification_ZenModeVoiceActivity__onStop$___twin___();
    }
}
