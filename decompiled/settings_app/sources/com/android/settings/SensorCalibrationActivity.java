package com.android.settings;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.zte.board.engine.IBoardEngine;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SensorCalibrationActivity extends BaseActivity {
    private static final String TAG = "SensorCalibration";
    private IBoardEngine mBoardEngine;
    private ServiceConnection mBoardEngineServiceConnection;
    private Handler mHandler;
    private int mSensorType;
    private OButton mStartButton;

    public void com_android_settings_SensorCalibrationActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_SensorCalibrationActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_SensorCalibrationActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_SensorCalibrationActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SensorCalibrationActivity() {
        this.mSensorType = 1;
        this.mHandler = new Handler();
        this.mBoardEngineServiceConnection = new AnonymousClass1(this);
    }

    static /* synthetic */ IBoardEngine access$000(SensorCalibrationActivity r0) {
        return r0.mBoardEngine;
    }

    static /* synthetic */ IBoardEngine access$002(SensorCalibrationActivity r0, IBoardEngine r1) {
        r0.mBoardEngine = r1;
        return r1;
    }

    static /* synthetic */ void access$100(SensorCalibrationActivity r0) {
        r0.startCalibration();
    }

    static /* synthetic */ int access$200(SensorCalibrationActivity r0) {
        return r0.mSensorType;
    }

    static /* synthetic */ void access$300(SensorCalibrationActivity r0) {
        r0.resetButtonState();
    }

    static /* synthetic */ void access$400(SensorCalibrationActivity r0) {
        r0.showFailureDialog();
    }

    static /* synthetic */ Handler access$500(SensorCalibrationActivity r0) {
        return r0.mHandler;
    }

    public void com_android_settings_SensorCalibrationActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.sensor_calibration_activity);
        ((FrameLayout) findViewById(R.id.frame_layout)).addView(UIUtils.buildNoScaledView(this, R.layout.view_banner_sensor_calibration));
        if (getIntent() == null) goto L5;
        this.mSensorType = getIntent().getIntExtra("sensor_type", 1);
    L5:
        OFloatingTitleBar r6 = (OFloatingTitleBar) findViewById(R.id.view_title);
        if (r6 != null) goto L8;
    L12:
        OButton r7 = (OButton) findViewById(R.id.btn_start_calibration);
        this.mStartButton = r7;
        if (r7 == null) goto L15;
        r7.setOnClickListener(new AnonymousClass3(this));
    L15:
        Intent r8 = new Intent();
        r8.setAction(IBoardEngine.DESCRIPTOR);
        r8.setComponent(new ComponentName("com.zte.board.engine", "com.zte.board.engine.BoardEngineService"));
        if (bindService(r8, this.mBoardEngineServiceConnection, 1) == true) goto L19;
        OLog.e(TAG, "Failed to bind to board_engine service");
        return;
    L19:
        return;
    L8:
        if (this.mSensorType != 1) goto L10;
        int r1 = R.string.accelerometer_calibration;
    L11:
        r6.setCenterTitle(getString(r1));
        r6.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new AnonymousClass2(this));
        goto L12
    L10:
        r1 = R.string.gyroscope_calibration;
        goto L11
    }

    public void com_android_settings_SensorCalibrationActivity__onDestroy$___twin___() {
        super.onDestroy();
        unbindService(this.mBoardEngineServiceConnection);
    }

    private void startCalibration() {
        OButton r0 = this.mStartButton;
        if (r0 == null) goto L5;
        r0.setEnabled(false);
        this.mStartButton.setText(getString(R.string.calibration_in_progress));
        this.mStartButton.invalidate();
    L5:
        new Thread(new AnonymousClass4(this)).start();
    }

    private void resetButtonState() {
        OButton r0 = this.mStartButton;
        if (r0 == null) goto L6;
        r0.setEnabled(true);
        this.mStartButton.setText(getString(R.string.calibration_start));
        return;
    }

    private void showFailureDialog() {
        resetButtonState();
        if (this.mSensorType != 1) goto L5;
        int r0 = R.string.accelerometer_calibration_failed;
    L6:
        OAlertDialogBuilder r3 = new OAlertDialogBuilder(this).title(r0).positiveButton(R.string.calibration_retry, new AnonymousClass5(this));
        DialogInterface.OnClickListener r2 = (DialogInterface.OnClickListener) null;
        OAlertDialog r4 = r3.negativeButton(R.string.calibration_cancel, null).build();
        r4.setTitle(r0);
        r4.show();
        return;
    L5:
        r0 = R.string.gyroscope_calibration_failed;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SensorCalibrationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SensorCalibrationActivity r1) {
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(SensorCalibrationActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SensorCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_SensorCalibrationActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(SensorCalibrationActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SensorCalibrationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SensorCalibrationActivity r5 = r4;
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
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SensorCalibrationActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_SensorCalibrationActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(SensorCalibrationActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_SensorCalibrationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onResume(SensorCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SensorCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_SensorCalibrationActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SensorCalibrationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onPause(SensorCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SensorCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_SensorCalibrationActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SensorCalibrationActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SensorCalibrationActivity r5 = r3;
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
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onStop(SensorCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SensorCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_SensorCalibrationActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_SensorCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(SensorCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SensorCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_SensorCalibrationActivity__onDestroy$___twin___();
    }
}
