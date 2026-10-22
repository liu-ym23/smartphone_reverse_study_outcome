package com.android.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LedBrightnessSettings extends BaseActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private static final int DEFAULT = 0;
    private static final String LED_BRIGHTNESS_LEFT = "led_brightness_left";
    private static final String LED_BRIGHTNESS_MID = "led_brightness_middle";
    private static final String LED_BRIGHTNESS_RIGHT = "led_brightness_right";
    private static final int MAX = 120;
    private static final String METHOD_SET_LEFT_LED = "setLedLeftBrightness";
    private static final String METHOD_SET_Mid_LED = "setLedMidBrightness";
    private static final String METHOD_SET_RIGHT_LED = "setLedRightBrightness";
    private PowerManager mPm;
    private Class mPmClass;
    private Button mReset;
    private BrightnessSeekBar mSeekBarLeft;
    private BrightnessSeekBar mSeekBarMid;
    private BrightnessSeekBar mSeekBarRight;

    public void com_android_settings_LedBrightnessSettings__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_LedBrightnessSettings__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r1) {
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r1) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public LedBrightnessSettings() {
    }

    public void com_android_settings_LedBrightnessSettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        if (SettingsFeature.isLEDBrightnessSettingsEnabled() == true) goto L6;
        finish();
        return;
    L6:
        PowerManager r5 = (PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.mPm = r5;
        this.mPmClass = r5.getClass();
        setContentView(R.layout.led_brightness_settings);
        Button r6 = (Button) findViewById(R.id.reset_btn);
        this.mReset = r6;
        r6.setOnClickListener(this);
        this.mSeekBarLeft = (BrightnessSeekBar) findViewById(R.id.seekbar_left);
        this.mSeekBarMid = (BrightnessSeekBar) findViewById(R.id.seekbar_middle);
        this.mSeekBarRight = (BrightnessSeekBar) findViewById(R.id.seekbar_right);
        this.mSeekBarLeft.setMax(120);
        this.mSeekBarMid.setMax(120);
        this.mSeekBarRight.setMax(120);
        this.mSeekBarLeft.setSeekBarTag(LED_BRIGHTNESS_LEFT);
        this.mSeekBarMid.setSeekBarTag(LED_BRIGHTNESS_MID);
        this.mSeekBarRight.setSeekBarTag(LED_BRIGHTNESS_RIGHT);
        this.mSeekBarLeft.setProgress(getProgressByDb(LED_BRIGHTNESS_LEFT));
        this.mSeekBarMid.setProgress(getProgressByDb(LED_BRIGHTNESS_MID));
        this.mSeekBarRight.setProgress(getProgressByDb(LED_BRIGHTNESS_RIGHT));
        setupBackBtnOnTitle();
    }

    private void setLedBrightness(String r6, int r7) {
        OLog.d("", "set   m:" + r6 + "  v:" + r7);
        Method r8 = this.mPmClass.getDeclaredMethod(r6, new Class[]{Integer.TYPE});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9
        r8.setAccessible(true);     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9
        r8.invoke(this.mPm, new Object[]{Integer.valueOf(r7)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9
    L16:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private int getProgressByDb(String r1) {
        return getLedBrightnessSettings(r1) + 60;
    }

    private int getLedBrightnessSettings(String r2) {
        return android.provider.Settings.System.getInt(getContentResolver(), r2, 0);
    }

    private void setLedBrightnessSettings(SeekBar r2) {
        set((String) r2.getTag(), r2.getProgress() - 60);
    }

    private void set(String r2, int r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.equals(LED_BRIGHTNESS_LEFT) == false) goto L8;
        String r4 = METHOD_SET_LEFT_LED;
    L14:
        if (r4 == null) goto L17;
        setLedBrightness(r4, r3);
        return;
    L17:
        return;
    L8:
        if (r2.equals(LED_BRIGHTNESS_MID) == false) goto L11;
        r4 = METHOD_SET_Mid_LED;
        goto L14
    L11:
        if (r2.equals(LED_BRIGHTNESS_RIGHT) == false) goto L13;
        r4 = METHOD_SET_RIGHT_LED;
        goto L14
    L13:
        r4 = null;
        goto L14
    }

    public void com_android_settings_LedBrightnessSettings__onResume$___twin___() {
        super.onResume();
        this.mSeekBarLeft.setOnSeekBarChangeListener(this);
        this.mSeekBarMid.setOnSeekBarChangeListener(this);
        this.mSeekBarRight.setOnSeekBarChangeListener(this);
    }

    public void com_android_settings_LedBrightnessSettings__onPause$___twin___() {
        super.onPause();
        this.mSeekBarLeft.setOnSeekBarChangeListener(null);
        this.mSeekBarMid.setOnSeekBarChangeListener(null);
        this.mSeekBarRight.setOnSeekBarChangeListener(null);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        setLedBrightnessSettings(r1);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        set(LED_BRIGHTNESS_LEFT, 0);
        set(LED_BRIGHTNESS_MID, 0);
        set(LED_BRIGHTNESS_RIGHT, 0);
        this.mSeekBarLeft.setProgress(60);
        this.mSeekBarMid.setProgress(60);
        this.mSeekBarRight.setProgress(60);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LedBrightnessSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LedBrightnessSettings r1) {
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_PrivacyHook_onCreate(LedBrightnessSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LedBrightnessSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_LedBrightnessSettings__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(LedBrightnessSettings r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(LedBrightnessSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        LedBrightnessSettings r5 = r4;
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
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(LedBrightnessSettings r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_LedBrightnessSettings__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(LedBrightnessSettings r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_LedBrightnessSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_PrivacyHook_onResume(LedBrightnessSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LedBrightnessSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_LedBrightnessSettings__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(LedBrightnessSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_PrivacyHook_onPause(LedBrightnessSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LedBrightnessSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_LedBrightnessSettings__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(LedBrightnessSettings r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        LedBrightnessSettings r5 = r3;
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
    public static void com_android_settings_LedBrightnessSettings_com_obric_hook_lancet_PrivacyHook_onStop(LedBrightnessSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LedBrightnessSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_LedBrightnessSettings__onStop$___twin___();
    }
}
