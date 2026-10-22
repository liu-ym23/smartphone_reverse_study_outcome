package com.android.settings.sensor;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import bytedanceos.util.Features;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.qualcomm.qti.usta.core.AccelCalibrationJNI;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SensorsCalibrationActivity extends BaseActivity implements View.OnClickListener {
    private static final String BMI_NODE = "/sys/class/sensors/bmi160-accel/self_test";
    private static final int CALIBRATION_ERROR = 3;
    private static final int CALIBRATION_FAILED = 2;
    private static final int CALIBRATION_OK = 1;
    private static final String CMD_SH = "./system/bin/qcom.sensorscal.sh";
    private static final String MPU_NODE = "/sys/class/sensors/MPU6050-accel/self_test";
    private static final int PSENSOR_RESULT = 4;
    private static final int PSENSOR_VALUE_FAR_1 = 30;
    private static final int PSENSOR_VALUE_FAR_2 = 20;
    private static final int PSENSOR_VALUE_LOW_NOISE = 0;
    private static final int PSENSOR_VALUE_NEAR = 80;
    private static final int SENSOR_TYPE_ACCEL = 1;
    private static final int SENSOR_TYPE_GSENSOR_X = 6;
    private static final int SENSOR_TYPE_GSENSOR_Y = 7;
    private static final int SENSOR_TYPE_GSENSOR_Z = 8;
    private static final int SENSOR_TYPE_GYRO = 3;
    private static final int SENSOR_TYPE_LIGHT = 4;
    private static final int SENSOR_TYPE_MAG = 2;
    private static final int SENSOR_TYPE_PRESSURE = 5;
    private static final int SENSOR_TYPE_PSENSOR_FAR = 7;
    private static final int SENSOR_TYPE_PSENSOR_LOW_NOISE = 5;
    private static final int SENSOR_TYPE_PSENSOR_NEAR = 6;
    private static final int SENSOR_TYPE_PSENSOR_READ_RESULT = 8;
    private static final String TASK_TYPE = "ro.sys.gyro_sensor_cal";
    private boolean isError;
    private boolean isHandling;
    private boolean isMultiTaskNeeded;
    private boolean isSucceeded;
    private Sensor mAcceleromererSensor;
    private OButton mButtonCalibrate;
    private TextView mFarThreshold;
    private int mGsensorX;
    private int mGsensorY;
    private int mGsensorZ;
    private Handler mHandler;
    private TextView mLowNoise;
    private TextView mNearThreshold;
    private QcnvApi mNv;
    private OButton mPSensorButtonCalibrate;
    private int mPSensorCheckStep;
    private boolean mPSensorIsSuccess;
    private ProgressBar mProgressBar;
    private SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;
    private TextView mTextView;
    private TextView mTipsView;

    private class CalibrationThread extends Thread {
        final /* synthetic */ SensorsCalibrationActivity this$0;

        private CalibrationThread(SensorsCalibrationActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CalibrationThread(SensorsCalibrationActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AccelCalibrationJNI.startCalibration();
            boolean r0 = checkResult(AccelCalibrationJNI.getAccelCalFromNative());
            AccelCalibrationJNI.stopCalibration();
            Message r1 = Message.obtain();
            if (r0 == false) goto L5;
            int r2 = 1;
        L6:
            r1.what = r2;
            SensorsCalibrationActivity.access$1500(this.this$0).sendMessage(r1);
            return;
        L5:
            r2 = 2;
            goto L6
        }

        private boolean checkResult(String r5) {
            if (TextUtils.isEmpty(r5) == false) goto L5;
            return false;
        L5:
            OLog.d(this.this$0.TAG, "parse result " + r5);
            String[] r6 = r5.split("\n");
            if (r6 != null) goto L8;
            return false;
        L8:
            if (r6.length < 4) goto L14;
            int r7 = Integer.valueOf(r6[3].split("=")[1]).intValue();
            OLog.d(this.this$0.TAG, "retCode " + r7);
            if (1 == r7) goto L12;
            return false;
        L12:
            return true;
        L14:
            return false;
        }
    }

    private class CommandThread extends Thread {
        final /* synthetic */ SensorsCalibrationActivity this$0;

        private CommandThread(SensorsCalibrationActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CommandThread(SensorsCalibrationActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SensorsCalibrationActivity.access$502(this.this$0, false);
            SensorsCalibrationActivity.access$802(this.this$0, false);
            if (SensorsCalibrationActivity.access$1000(this.this$0) == true) goto L5;
            checkResult(CommandUtils.execute(SensorsCalibrationActivity.access$1100(this.this$0, 1), false, true));
            return;
        L5:
            if (checkResult(CommandUtils.execute(SensorsCalibrationActivity.access$1100(this.this$0, 1), false, true), 1) == true) goto L13;
            return;
        L13:
            sleep(100);     // Catch: InterruptedException -> L9
            readGsensorValue(CommandUtils.execute(SensorsCalibrationActivity.access$1100(this.this$0, 6), false, true), 6);     // Catch: InterruptedException -> L9
            readGsensorValue(CommandUtils.execute(SensorsCalibrationActivity.access$1100(this.this$0, 7), false, true), 7);     // Catch: InterruptedException -> L9
            readGsensorValue(CommandUtils.execute(SensorsCalibrationActivity.access$1100(this.this$0, 8), false, true), 8);     // Catch: InterruptedException -> L9
            writeGsensorValue(SensorsCalibrationActivity.access$1200(this.this$0), SensorsCalibrationActivity.access$1300(this.this$0), SensorsCalibrationActivity.access$1400(this.this$0));     // Catch: InterruptedException -> L9
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
        }

        private void checkResult(CommandUtils.ShellResult r4) {
            Message r0 = Message.obtain();
            if (r4.result == 0) goto L5;
            r0.what = 3;
        L13:
            SensorsCalibrationActivity.access$1500(this.this$0).sendMessage(r0);
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

        private boolean checkResult(CommandUtils.ShellResult r7, int r8) {
            Message r0 = Message.obtain();
            if (r7.result == 0) goto L5;
            r0.what = 3;
            SensorsCalibrationActivity.access$1500(this.this$0).sendMessage(r0);
            return false;
        L5:
            if (r8 == 1) goto L16;
            if (r8 == 3) goto L9;
        L22:
            r0.what = 2;
            SensorsCalibrationActivity.access$1500(this.this$0).sendMessage(r0);
            return false;
        L9:
            if (r7.successMsg == null) goto L22;
            if ("0".equals(r7.successMsg) == false) goto L13;
        L14:
            return true;
        L13:
            if ("pass".equals(r7.successMsg) == false) goto L22;
        L16:
            if (r7.successMsg == null) goto L22;
            if ("0".equals(r7.successMsg) == false) goto L20;
        L21:
            return true;
        L20:
            if ("pass".equals(r7.successMsg) == false) goto L22;
            goto L21
        }

        private void readGsensorValue(CommandUtils.ShellResult r2, int r3) {
            if (r2.result == 0) goto L5;
        L16:
            Message r4 = Message.obtain();
            r4.what = 3;
            SensorsCalibrationActivity.access$1500(this.this$0).sendMessage(r4);
            return;
        L5:
            if (TextUtils.isEmpty(r2.successMsg) == true) goto L16;
            if (r3 != 6) goto L9;
            SensorsCalibrationActivity.access$1202(this.this$0, Integer.parseInt(r2.successMsg));
            return;
        L9:
            if (r3 != 7) goto L11;
            SensorsCalibrationActivity.access$1302(this.this$0, Integer.parseInt(r2.successMsg));
            return;
        L11:
            if (r3 != 8) goto L21;
            SensorsCalibrationActivity.access$1402(this.this$0, Integer.parseInt(r2.successMsg));
            return;
        }

        private void writeGsensorValue(int r7, int r8, int r9) {
            Message r0 = Message.obtain();
            File r1 = new File(SensorsCalibrationActivity.MPU_NODE);
            File r2 = new File(SensorsCalibrationActivity.BMI_NODE);
            if (r1.exists() == false) goto L14;
            if (Math.abs(r7) <= 250) goto L7;
        L12:
            r0.what = 2;
            goto L14
        L7:
            if (Math.abs(r8) > 250) goto L12;
            SensorsCalibrationActivity.access$1600(this.this$0).set_g_sensor(r7, r8, r9);     // Catch: Exception -> L11
            r0.what = 1;     // Catch: Exception -> L11
        L11:
            r0.what = 2;
        L14:
            if (r2.exists() == true) goto L16;
        L30:
            SensorsCalibrationActivity.access$1500(this.this$0).sendMessage(r0);
            return;
        L16:
            if (r7 > 128) goto L18;
            int r3 = r7;
        L19:
            if (r8 > 128) goto L21;
            int r4 = r8;
        L23:
            if (Math.abs(r3) < 15) goto L25;
        L29:
            r0.what = 2;
            goto L30
        L25:
            if (Math.abs(r4) >= 15) goto L29;
            SensorsCalibrationActivity.access$1600(this.this$0).set_g_sensor(r7, r8, r9);     // Catch: Exception -> L28
            r0.what = 1;     // Catch: Exception -> L28
        L28:
            r0.what = 2;
            goto L30
        L21:
            r4 = -(255 - r8);
            goto L23
        L18:
            r3 = -(255 - r7);
            goto L19
        }
    }

    private class PSensorThread extends Thread {
        final /* synthetic */ SensorsCalibrationActivity this$0;

        private PSensorThread(SensorsCalibrationActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PSensorThread(SensorsCalibrationActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (SensorsCalibrationActivity.access$1700(this.this$0) == false) goto L10;
            int r0 = SensorsCalibrationActivity.access$1800(this.this$0);
            if (r0 == 5) goto L9;
            if (r0 == 6) goto L8;
            SensorsCalibrationActivity.access$1802(this.this$0, 5);
            goto L10
        L8:
            SensorsCalibrationActivity.access$1802(this.this$0, 7);
            goto L10
        L9:
            SensorsCalibrationActivity.access$1802(this.this$0, 6);
        L10:
            SensorsCalibrationActivity.access$1702(this.this$0, false);
            boolean r1 = psensorCalibration(SensorsCalibrationActivity.access$1800(this.this$0));
            Message r2 = Message.obtain();
            r2.what = 4;
            r2.obj = Boolean.valueOf(r1);
            SensorsCalibrationActivity.access$1500(this.this$0).sendMessage(r2);
        }

        private boolean psensorCalibration(int r2) {
            if (SettingsFeature.isSupportPSensorCalibration() == false) goto L7;
            return psensorCalibrationJni(r2);
        L7:
            return psensorCalibrationCmd(r2);
        }

        private boolean psensorCalibrationJni(int r5) {
            if (r5 != 5) goto L5;
            int r0 = AccelCalibrationJNI.prxCalibrateCT();
        L12:
            OLog.d(this.this$0.TAG, "psensorCalibrationJni execute type " + r5 + " return " + r0);
            if (r0 != (-1)) goto L16;
            return false;
        L16:
            if (r0 == 1) goto L18;
            return false;
        L18:
            return true;
        L5:
            if (r5 != 6) goto L7;
            r0 = AccelCalibrationJNI.prxCalibrateNear();
            goto L12
        L7:
            if (r5 == 7) goto L9;
            r0 = -1;
            goto L12
        L9:
            r0 = AccelCalibrationJNI.prxCalibrateFar();
            goto L12
        }

        private boolean psensorCalibrationCmd(int r3) {
            return checkResult(CommandUtils.execute(SensorsCalibrationActivity.access$1100(this.this$0, r3), false, true));
        }

        private boolean checkResult(CommandUtils.ShellResult r4) {
            if (r4.result == 0) goto L5;
            return false;
        L5:
            if (r4.successMsg != null) goto L7;
            return false;
        L7:
            if ("0".equals(r4.successMsg) == true) goto L11;
            if ("pass".equals(r4.successMsg) == true) goto L11;
            return false;
        L11:
            return checkResultPass(CommandUtils.execute(SensorsCalibrationActivity.access$1100(this.this$0, 8), false, true).successMsg);
        }

        private boolean checkResultPass(String r6) {
            String[] r7 = r6.split(HanziToPinyin.Token.SEPARATOR);
            int r1 = Integer.parseInt(r7[0]);
            int r3 = Integer.parseInt(r7[1]);
            int r8 = Integer.parseInt(r7[2]);
            int r5 = SensorsCalibrationActivity.access$1800(this.this$0);
            if (r5 != 5) goto L5;
            if (r1 <= 0) goto L12;
            return true;
        L12:
            if (r3 <= (r1 + 80)) goto L15;
            return true;
        L15:
            if (r8 > (r1 + 30)) goto L17;
        L19:
            return false;
        L17:
            if (r8 >= (r3 - 20)) goto L19;
            return true;
        L5:
            if (r5 == 6) goto L12;
            if (r5 == 7) goto L15;
            goto L19
        }
    }

    public void com_android_settings_sensor_SensorsCalibrationActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_sensor_SensorsCalibrationActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SensorsCalibrationActivity() {
        this.isSucceeded = false;
        this.isError = false;
        this.isHandling = false;
        this.isMultiTaskNeeded = false;
        this.mPSensorCheckStep = 5;
        this.mPSensorIsSuccess = false;
        this.mSensorEventListener = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass2(this);
    }

    static /* synthetic */ boolean access$1000(SensorsCalibrationActivity r0) {
        return r0.isMultiTaskNeeded;
    }

    static /* synthetic */ String access$1100(SensorsCalibrationActivity r0, int r1) {
        return r0.getCommand(r1);
    }

    static /* synthetic */ int access$1200(SensorsCalibrationActivity r0) {
        return r0.mGsensorX;
    }

    static /* synthetic */ int access$1202(SensorsCalibrationActivity r0, int r1) {
        r0.mGsensorX = r1;
        return r1;
    }

    static /* synthetic */ int access$1300(SensorsCalibrationActivity r0) {
        return r0.mGsensorY;
    }

    static /* synthetic */ int access$1302(SensorsCalibrationActivity r0, int r1) {
        r0.mGsensorY = r1;
        return r1;
    }

    static /* synthetic */ int access$1400(SensorsCalibrationActivity r0) {
        return r0.mGsensorZ;
    }

    static /* synthetic */ int access$1402(SensorsCalibrationActivity r0, int r1) {
        r0.mGsensorZ = r1;
        return r1;
    }

    static /* synthetic */ Handler access$1500(SensorsCalibrationActivity r0) {
        return r0.mHandler;
    }

    static /* synthetic */ QcnvApi access$1600(SensorsCalibrationActivity r0) {
        return r0.mNv;
    }

    static /* synthetic */ boolean access$1700(SensorsCalibrationActivity r0) {
        return r0.mPSensorIsSuccess;
    }

    static /* synthetic */ boolean access$1702(SensorsCalibrationActivity r0, boolean r1) {
        r0.mPSensorIsSuccess = r1;
        return r1;
    }

    static /* synthetic */ int access$1800(SensorsCalibrationActivity r0) {
        return r0.mPSensorCheckStep;
    }

    static /* synthetic */ int access$1802(SensorsCalibrationActivity r0, int r1) {
        r0.mPSensorCheckStep = r1;
        return r1;
    }

    static /* synthetic */ ProgressBar access$300(SensorsCalibrationActivity r0) {
        return r0.mProgressBar;
    }

    static /* synthetic */ boolean access$402(SensorsCalibrationActivity r0, boolean r1) {
        r0.isHandling = r1;
        return r1;
    }

    static /* synthetic */ boolean access$502(SensorsCalibrationActivity r0, boolean r1) {
        r0.isSucceeded = r1;
        return r1;
    }

    static /* synthetic */ TextView access$600(SensorsCalibrationActivity r0) {
        return r0.mTextView;
    }

    static /* synthetic */ OButton access$700(SensorsCalibrationActivity r0) {
        return r0.mButtonCalibrate;
    }

    static /* synthetic */ boolean access$802(SensorsCalibrationActivity r0, boolean r1) {
        r0.isError = r1;
        return r1;
    }

    static /* synthetic */ void access$900(SensorsCalibrationActivity r0, boolean r1) {
        r0.showPSensorResult(r1);
    }

    public void com_android_settings_sensor_SensorsCalibrationActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.sensor_calibration_layout);
        this.isMultiTaskNeeded = getResources().getBoolean(R.bool.config_complex_sensorcal_enable);
        this.mNv = new QcnvApi(getApplicationContext());
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.mProgressBar = (ProgressBar) findViewById(R.id.sensor_calibration_progress);
        FrameLayout r8 = (FrameLayout) findViewById(R.id.sensor_calibration_logo);
        this.mTipsView = (TextView) findViewById(R.id.sensor_calibration_tips);
        this.mTextView = (TextView) findViewById(R.id.sensor_calibration_text);
        if (this.isMultiTaskNeeded == false) goto L5;
        this.mTitle.setCenterTitle(getString(R.string.sensor_calibration_title_multi));
        this.mTipsView.setText(getString(R.string.sensor_calibration_tips_content, new Object[]{getString(R.string.sensor_calibration_tips_item)}), TextView.BufferType.NORMAL);
        SensorManager r0 = (SensorManager) getSystemService("sensor");
        this.mSensorManager = r0;
        this.mAcceleromererSensor = r0.getDefaultSensor(1);
    L6:
        r8.setBackgroundResource(R.drawable.sensor_calibration_logo);
        this.mTextView.setText(R.string.sensor_calibrate_init_text);
        this.mButtonCalibrate = (OButton) findViewById(R.id.sensor_calibrate_button);
        this.mPSensorButtonCalibrate = (OButton) findViewById(R.id.psensor_calibrate_button);
        this.mLowNoise = (TextView) findViewById(R.id.psensor_low_noise);
        this.mNearThreshold = (TextView) findViewById(R.id.psensor_near);
        this.mFarThreshold = (TextView) findViewById(R.id.psensor_far);
        this.mButtonCalibrate.setOnClickListener(this);
        this.mPSensorButtonCalibrate.setOnClickListener(this);
        if (Features.isUltrasonicSensor(this).booleanValue() == false) goto L10;
        this.mPSensorButtonCalibrate.setVisibility(8);
        this.mLowNoise.setVisibility(8);
        this.mNearThreshold.setVisibility(8);
        this.mFarThreshold.setVisibility(8);
        return;
    L10:
        return;
    L5:
        this.mTitle.setCenterTitle(getString(R.string.sensor_calibration_title_single));
        this.mTipsView.setText(getString(R.string.sensor_calibration_tips_content, new Object[]{""}), TextView.BufferType.NORMAL);
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        int r6 = r5.getId();
        AnonymousClass1 r2 = null;
        if (r6 != R.id.psensor_calibrate_button) goto L5;
        this.mPSensorButtonCalibrate.setEnabled(false);
        this.mPSensorButtonCalibrate.setAlpha(0.3f);
        this.mPSensorButtonCalibrate.setText(R.string.psensor_wait);
        new PSensorThread(this, r2).start();
        return;
    L5:
        if (r6 == R.id.sensor_calibrate_button) goto L8;
        return;
    L8:
        if (this.isSucceeded == false) goto L10;
    L17:
        Intent r7 = new Intent("android.intent.action.REBOOT");
        r7.putExtra("nowait", 1);
        r7.putExtra("interval", 1);
        r7.putExtra("window", 0);
        sendBroadcast(r7);
        return;
    L10:
        if (this.isError == true) goto L17;
        this.isHandling = true;
        this.mButtonCalibrate.setEnabled(false);
        this.mButtonCalibrate.setAlpha(0.3f);
        if (SettingsFeature.isSupportNewCalibration() == false) goto L15;
        new CalibrationThread(this, r2).start();
    L16:
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(0);
        return;
    L15:
        new CommandThread(this, r2).start();
        goto L16
    }

    public void com_android_settings_sensor_SensorsCalibrationActivity__onPause$___twin___() {
        SensorManager r0 = this.mSensorManager;
        if (r0 == null) goto L5;
        r0.unregisterListener(this.mSensorEventListener);
    L5:
        super.onPause();
    }

    public void com_android_settings_sensor_SensorsCalibrationActivity__onResume$___twin___() {
        super.onResume();
        SensorManager r0 = this.mSensorManager;
        if (r0 == null) goto L8;
        Sensor r1 = this.mAcceleromererSensor;
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

    private void showPSensorResult(boolean r7) {
        this.mPSensorIsSuccess = r7;
        if (r7 == false) goto L5;
        int r0 = -16711936;
    L6:
        int r1 = this.mPSensorCheckStep;
        int r3 = R.string.psensor_near_threshold_tip;
        int r4 = R.string.psensor_low_noise_tip;
        if (r1 != 5) goto L9;
        this.mLowNoise.setTextColor(r0);
        if (r7 == true) goto L25;
        r3 = R.string.psensor_low_noise_tip;
    L25:
        int r8 = r3;
    L26:
        enablePSensorButton(r8);
        return;
    L9:
        if (r1 != 6) goto L11;
        this.mNearThreshold.setTextColor(r0);
        if (r7 == false) goto L25;
        r3 = R.string.psensor_far_threshold_tip;
        goto L25
    L11:
        if (r1 == 7) goto L13;
        r8 = 0;
        goto L26
    L13:
        this.mFarThreshold.setTextColor(r0);
        if (r7 == true) goto L17;
        r4 = R.string.psensor_far_threshold_tip;
    L17:
        r8 = r4;
        goto L26
    L5:
        r0 = SupportMenu.CATEGORY_MASK;
        goto L6
    }

    private void enablePSensorButton(int r3) {
        this.mPSensorButtonCalibrate.setEnabled(true);
        this.mPSensorButtonCalibrate.setAlpha(1.0f);
        this.mPSensorButtonCalibrate.setText(r3);
    }

    private String getCommand(int r2) {
        return "./system/bin/qcom.sensorscal.sh " + r2;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SensorsCalibrationActivity r1) {
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(SensorsCalibrationActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SensorsCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_sensor_SensorsCalibrationActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(SensorsCalibrationActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SensorsCalibrationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SensorsCalibrationActivity r5 = r4;
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
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SensorsCalibrationActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_sensor_SensorsCalibrationActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(SensorsCalibrationActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_sensor_SensorsCalibrationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onResume(SensorsCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SensorsCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_sensor_SensorsCalibrationActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SensorsCalibrationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onPause(SensorsCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SensorsCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_sensor_SensorsCalibrationActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SensorsCalibrationActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SensorsCalibrationActivity r5 = r3;
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
    public static void com_android_settings_sensor_SensorsCalibrationActivity_com_obric_hook_lancet_PrivacyHook_onStop(SensorsCalibrationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SensorsCalibrationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_sensor_SensorsCalibrationActivity__onStop$___twin___();
    }
}
