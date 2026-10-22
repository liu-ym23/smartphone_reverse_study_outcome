package com.android.settings.sensor;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.qualcomm.qti.usta.core.AccelCalibrationJNI;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ProximityCalibrationActivity extends BaseActivity implements View.OnClickListener {
    private static final String CALIBRATION_FILE = "/mnt/vendor/persist/sensors/registry/registry/stk3x3x_0_platform.ps.fac_cal";
    private static final int PSENSOR_RESULT = 1;
    private boolean isError;
    private boolean isHandling;
    private boolean isSucceeded;
    private OButton mButtonCalibrate;
    private Handler mHandler;
    private ProgressBar mProgressBar;
    private Sensor mProximitySensor;
    private SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;
    private TextView mTextView;
    private TextView mTipsView;
    private TextView mTvCaliberationResult;

    private class PSensorThread extends Thread {
        int resultCode;
        final /* synthetic */ ProximityCalibrationActivity this$0;

        private PSensorThread(ProximityCalibrationActivity r1) {
            this.this$0 = r1;
            this.resultCode = -1;
        }

        /* synthetic */ PSensorThread(ProximityCalibrationActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int r0 = ProximityCalibrationActivity.access$200(this.this$0);
            Message r1 = Message.obtain();
            r1.what = 1;
            r1.obj = Integer.valueOf(r0);
            ProximityCalibrationActivity.access$300(this.this$0).sendMessage(r1);
        }
    }

    public void com_android_settings_sensor_ProximityCalibrationActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_sensor_ProximityCalibrationActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ProximityCalibrationActivity() {
        this.isSucceeded = false;
        this.isError = false;
        this.isHandling = false;
        this.mSensorEventListener = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass2(this);
    }

    static /* synthetic */ TextView access$100(ProximityCalibrationActivity r0) {
        return r0.mTvCaliberationResult;
    }

    static /* synthetic */ int access$200(ProximityCalibrationActivity r0) {
        return r0.psensorCalibration();
    }

    static /* synthetic */ Handler access$300(ProximityCalibrationActivity r0) {
        return r0.mHandler;
    }

    public void com_android_settings_sensor_ProximityCalibrationActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        setContentView(R.layout.proximity_sensor_calibration_layout);
        this.mTitle = (OFloatingTitleBar) NullSafe.nonNull(findViewById(R.id.view_title));
        this.mProgressBar = (ProgressBar) NullSafe.nonNull(findViewById(R.id.sensor_calibration_progress));
        FrameLayout r3 = (FrameLayout) NullSafe.nonNull(findViewById(R.id.sensor_calibration_logo));
        this.mTextView = (TextView) NullSafe.nonNull(findViewById(R.id.sensor_calibration_text));
        r3.setBackgroundResource(R.drawable.sensor_calibration_logo);
        this.mTextView.setText(R.string.sensor_calibrate_init_text);
        OButton r4 = (OButton) NullSafe.nonNull(findViewById(R.id.sensor_calibrate_button));
        this.mButtonCalibrate = r4;
        r4.setOnClickListener(this);
        this.mTvCaliberationResult = (TextView) NullSafe.nonNull(findViewById(R.id.psensor_calibration_result));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2.getId() != R.id.sensor_calibrate_button) goto L7;
        new PSensorThread(this, null).start();
        return;
    }

    public void com_android_settings_sensor_ProximityCalibrationActivity__onPause$___twin___() {
        SensorManager r0 = this.mSensorManager;
        if (r0 == null) goto L5;
        r0.unregisterListener(this.mSensorEventListener);
    L5:
        super.onPause();
    }

    public void com_android_settings_sensor_ProximityCalibrationActivity__onResume$___twin___() {
        super.onResume();
        SensorManager r0 = this.mSensorManager;
        if (r0 == null) goto L8;
        Sensor r1 = this.mProximitySensor;
        if (r1 == null) goto L9;
        r0.registerListener(this.mSensorEventListener, r1, 3);
        return;
    L9:
        return;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L10;
        if (this.isHandling == true) goto L11;
        finish();
        return true;
    L11:
        return true;
    L10:
        return super.onKeyDown(r2, r3);
    }

    private int psensorCalibration() {
        if (SettingsFeature.isSupportPSensorCalibration() == true) goto L5;
        OLog.d(this.TAG, "unsupported type");
        return -1;
    L5:
        return AccelCalibrationJNI.prxCalibrateOnlyCT();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ProximityCalibrationActivity r1) {
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ProximityCalibrationActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProximityCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_sensor_ProximityCalibrationActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ProximityCalibrationActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ProximityCalibrationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ProximityCalibrationActivity r5 = r4;
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
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ProximityCalibrationActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_sensor_ProximityCalibrationActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ProximityCalibrationActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_sensor_ProximityCalibrationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onResume(ProximityCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProximityCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_sensor_ProximityCalibrationActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ProximityCalibrationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onPause(ProximityCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProximityCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_sensor_ProximityCalibrationActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ProximityCalibrationActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ProximityCalibrationActivity r5 = r3;
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
    public static void com_android_settings_sensor_ProximityCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onStop(ProximityCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProximityCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_sensor_ProximityCalibrationActivity__onStop$___twin___();
    }
}
