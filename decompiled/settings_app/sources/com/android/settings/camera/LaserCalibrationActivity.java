package com.android.settings.camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sremlib.LibUtil;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LaserCalibrationActivity extends BaseActivity {
    private static final String BMI_NODE = "x";
    private static final int CALIBRATION_ERROR = 3;
    private static final int CALIBRATION_FAILED = 2;
    private static final int CALIBRATION_OK = 1;
    private static final String CMD_SH = "/system/bin/cal_laser";
    private static final String MPU_NODE = "o";
    private static final String OTH_NODE = "y";
    private static final String TAG = "LaserCalibrationActivity";
    private static final int TYPE_NODE_10 = 0;
    private static final int TYPE_NODE_60 = 1;
    private boolean isError;
    private boolean isHandling;
    private boolean isSucceeded;
    private OButton mButton;
    private OButton mButtonCalibrate10;
    private OButton mButtonCalibrate60;
    private String mCalibrationType;
    private Handler mHandler;
    private TextView mHint;
    private ProgressBar mProgressBar;
    private TextView mTextView;

    private class CommandThread extends Thread {
        final /* synthetic */ LaserCalibrationActivity this$0;

        private CommandThread(LaserCalibrationActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CommandThread(LaserCalibrationActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            LaserCalibrationActivity.access$902(this.this$0, false);
            LaserCalibrationActivity.access$1002(this.this$0, false);
            int r0 = 2;
            LaserCalibrationActivity r1 = this.this$0;     // Catch: Exception -> L8
            if (LibUtil.TCP_Send(LaserCalibrationActivity.access$1100(r1, LaserCalibrationActivity.access$100(r1)), "done").contains("return:1") == true) goto L7;
            if (LaserCalibrationActivity.access$100(this.this$0).compareTo("y") == 0) goto L7;
        L10:
            Message r2 = Message.obtain();
            r2.what = r0;
            LaserCalibrationActivity.access$1200(this.this$0).sendMessage(r2);
            return;
        L7:
            r0 = 1;
        L8:
            e = move-exception;
            e.printStackTrace();
            goto L10
        }

        private void checkResult(CameraCommandUtils.ShellResult r4) {
            Message r0 = Message.obtain();
            if (r4.result == 0) goto L5;
            r0.what = 3;
        L13:
            LaserCalibrationActivity.access$1200(this.this$0).sendMessage(r0);
            return;
        L5:
            if (r4.successMsg != null) goto L7;
        L11:
            r0.what = 2;
            goto L13
        L7:
            if ("0".equals(r4.successMsg) == false) goto L9;
        L10:
            r0.what = 1;
            goto L13
        L9:
            if ("pass".equals(r4.successMsg) == false) goto L11;
            goto L10
        }
    }

    public void com_android_settings_camera_LaserCalibrationActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_camera_LaserCalibrationActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public LaserCalibrationActivity() {
        this.isSucceeded = false;
        this.isError = false;
        this.isHandling = false;
        this.mCalibrationType = null;
        this.mHandler = new AnonymousClass4(this);
    }

    static /* synthetic */ boolean access$002(LaserCalibrationActivity r0, boolean r1) {
        r0.isHandling = r1;
        return r1;
    }

    static /* synthetic */ String access$100(LaserCalibrationActivity r0) {
        return r0.mCalibrationType;
    }

    static /* synthetic */ boolean access$1002(LaserCalibrationActivity r0, boolean r1) {
        r0.isError = r1;
        return r1;
    }

    static /* synthetic */ String access$102(LaserCalibrationActivity r0, String r1) {
        r0.mCalibrationType = r1;
        return r1;
    }

    static /* synthetic */ String access$1100(LaserCalibrationActivity r0, String r1) {
        return r0.getCommand(r1);
    }

    static /* synthetic */ Handler access$1200(LaserCalibrationActivity r0) {
        return r0.mHandler;
    }

    static /* synthetic */ OButton access$200(LaserCalibrationActivity r0) {
        return r0.mButtonCalibrate10;
    }

    static /* synthetic */ OButton access$300(LaserCalibrationActivity r0) {
        return r0.mButtonCalibrate60;
    }

    static /* synthetic */ OButton access$400(LaserCalibrationActivity r0) {
        return r0.mButton;
    }

    static /* synthetic */ TextView access$600(LaserCalibrationActivity r0) {
        return r0.mTextView;
    }

    static /* synthetic */ TextView access$700(LaserCalibrationActivity r0) {
        return r0.mHint;
    }

    static /* synthetic */ ProgressBar access$800(LaserCalibrationActivity r0) {
        return r0.mProgressBar;
    }

    static /* synthetic */ boolean access$902(LaserCalibrationActivity r0, boolean r1) {
        r0.isSucceeded = r1;
        return r1;
    }

    public void com_android_settings_camera_LaserCalibrationActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.laser_calibration_layout);
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.mProgressBar = (ProgressBar) findViewById(R.id.laser_calibration_progress);
        FrameLayout r4 = (FrameLayout) findViewById(R.id.laser_calibration_logo);
        this.mTextView = (TextView) findViewById(R.id.laser_calibration_text);
        this.mHint = (TextView) findViewById(R.id.laser_calibration_hint);
        this.mTitle.setCenterTitle(getString(R.string.laser_calibration_title));
        r4.setBackgroundResource(R.drawable.laser_calibration_logo);
        this.mTextView.setText(R.string.laser_calibrate_init_text);
        OButton r5 = (OButton) findViewById(R.id.laser_calibrate_button_10);
        this.mButtonCalibrate10 = r5;
        r5.setOnClickListener(new AnonymousClass1(this));
        OButton r6 = (OButton) findViewById(R.id.laser_calibrate_button_60);
        this.mButtonCalibrate60 = r6;
        r6.setOnClickListener(new AnonymousClass2(this));
        OButton r7 = (OButton) findViewById(R.id.laser_button);
        this.mButton = r7;
        r7.setOnClickListener(new AnonymousClass3(this));
    }

    public void com_android_settings_camera_LaserCalibrationActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_camera_LaserCalibrationActivity__onResume$___twin___() {
        super.onResume();
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

    private String getCommand(String r2) {
        OLog.d("LaserCalibrationActivity CMD = ", "/system/bin/cal_laser " + r2);
        if (r2.compareTo("y") != 0) goto L7;
        return "d_test-laser 100";
    L7:
        if (r2.compareTo(MPU_NODE) != 0) goto L10;
        return "d_test-laser 10";
    L10:
        return "d_test-laser 60";
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_camera_LaserCalibrationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LaserCalibrationActivity r1) {
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(LaserCalibrationActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LaserCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_camera_LaserCalibrationActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(LaserCalibrationActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(LaserCalibrationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        LaserCalibrationActivity r5 = r4;
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
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(LaserCalibrationActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_camera_LaserCalibrationActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(LaserCalibrationActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_camera_LaserCalibrationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onResume(LaserCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LaserCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_camera_LaserCalibrationActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(LaserCalibrationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onPause(LaserCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LaserCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_camera_LaserCalibrationActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(LaserCalibrationActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        LaserCalibrationActivity r5 = r3;
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
    public static void com_android_settings_camera_LaserCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onStop(LaserCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LaserCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_camera_LaserCalibrationActivity__onStop$___twin___();
    }
}
