package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.CalibrationAnimtedView;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class HeadsetCalibrationFragment extends BaseFragment implements View.OnClickListener {
    private static final String KEY_HEADSET_HOOK = "custom_key_headset_hook";
    private static final String KEY_VOLUME_DOWN = "custom_key_volume_down";
    private static final String KEY_VOLUME_UP = "custom_key_volume_up";
    private static final String TAG = "HeadsetCalibrationFragment";
    private static final String mHeadsetInputDevice = null;
    private OButton btnDone;
    private OButton btnKeyAbsent;
    private OButton btnKeyPressed;
    private boolean isRegistered;
    private CalibrationAnimtedView mCalDownAnimView;
    private CalibrationAnimtedView mCalUpAnimView;
    private TextView mCalibrateDoneTips;
    private TextView mCalibratingTips;
    private IntentFilter mHeadsetFilter;
    private BroadcastReceiver mHeadsetPlugReceiver;
    private HashMap<String, Integer> mScancodeMaps;
    private CalibrationStatus mStatus;
    private int scancode;

    /* JADX INFO: renamed from: com.android.settings.HeadsetCalibrationFragment$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$HeadsetCalibrationFragment$CalibrationStatus = null;

        static {
            int[] r0 = new int[CalibrationStatus.values().length];
            $SwitchMap$com$android$settings$HeadsetCalibrationFragment$CalibrationStatus = r0;
            r0[CalibrationStatus.Initial.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$HeadsetCalibrationFragment$CalibrationStatus[CalibrationStatus.CalibrateUp.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$HeadsetCalibrationFragment$CalibrationStatus[CalibrationStatus.CalibrateDown.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$HeadsetCalibrationFragment$CalibrationStatus[CalibrationStatus.Done.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static final enum CalibrationStatus extends Enum<CalibrationStatus> {
        private static final /* synthetic */ CalibrationStatus[] $VALUES = null;
        public static final CalibrationStatus CalibrateDown = null;
        public static final CalibrationStatus CalibrateUp = null;
        public static final CalibrationStatus Done = null;
        public static final CalibrationStatus Initial = null;
        private String mKey;

        private static /* synthetic */ CalibrationStatus[] $values() {
            return new CalibrationStatus[]{Initial, CalibrateUp, CalibrateDown, Done};
        }

        static /* synthetic */ String access$000(CalibrationStatus r0) {
            return r0.mKey;
        }

        public static CalibrationStatus valueOf(String r1) {
            return (CalibrationStatus) Enum.valueOf(CalibrationStatus.class, r1);
        }

        public static CalibrationStatus[] values() {
            return (CalibrationStatus[]) $VALUES.clone();
        }

        static {
            Initial = new CalibrationStatus("Initial", 0, null);
            CalibrateUp = new CalibrationStatus("CalibrateUp", 1, HeadsetCalibrationFragment.KEY_VOLUME_UP);
            CalibrateDown = new CalibrationStatus("CalibrateDown", 2, HeadsetCalibrationFragment.KEY_VOLUME_DOWN);
            Done = new CalibrationStatus("Done", 3, null);
            $VALUES = $values();
        }

        private CalibrationStatus(String r1, int r2, String r3) {
            super(r1, r2);
            this.mKey = r3;
        }

        public CalibrationStatus nextStatus() {
            CalibrationStatus r0 = Initial;
            int r2 = AnonymousClass2.$SwitchMap$com$android$settings$HeadsetCalibrationFragment$CalibrationStatus[ordinal()];
            if (r2 == 1) goto L12;
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L13;
            return r0;
        L13:
            return Done;
        L14:
            return CalibrateDown;
        L12:
            return CalibrateUp;
        }
    }

    private boolean isHeadsetKeyEvent(KeyEvent r1) {
        return true;
    }

    public void com_android_settings_HeadsetCalibrationFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_HeadsetCalibrationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_HeadsetCalibrationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public HeadsetCalibrationFragment() {
        this.mStatus = CalibrationStatus.Initial;
        this.mScancodeMaps = new HashMap(2);
        this.mHeadsetPlugReceiver = new AnonymousClass1(this);
        this.mHeadsetFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
    }

    static {
        mHeadsetInputDevice = SystemProperties.get("ro.system.headsetinput");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.headset_calibration_layout, r3, false);
        OButton r5 = (OButton) findViewByIdNullable(R.id.none);
        this.btnKeyAbsent = r5;
        r5.setOnClickListener(this);
        OButton r6 = (OButton) findViewByIdNullable(R.id.pressed);
        this.btnKeyPressed = r6;
        r6.setOnClickListener(this);
        OButton r7 = (OButton) findViewByIdNullable(R.id.done);
        this.btnDone = r7;
        r7.setOnClickListener(this);
        this.mCalDownAnimView = (CalibrationAnimtedView) findViewByIdNullable(R.id.cal_down_key);
        this.mCalUpAnimView = (CalibrationAnimtedView) findViewByIdNullable(R.id.cal_up_key);
        this.mCalibrateDoneTips = (TextView) findViewByIdNullable(R.id.calibrate_done_tips);
        this.mCalibratingTips = (TextView) findViewByIdNullable(R.id.calibrating_tips);
        setupButtonGroup(true);
        return this.mRootView;
    }

    public void com_android_settings_HeadsetCalibrationFragment__onResume$___twin___() {
        super.onResume();
        if (Utils.isHeadsetConnected(this.mContext) == false) goto L5;
        registerReceiver(this.mHeadsetPlugReceiver, this.mHeadsetFilter);
        this.isRegistered = true;
        return;
    L5:
        if (getActivity() == null) goto L7;
        ToastUtils.show(getActivity(), R.string.headset_calibration_headset_disconnected);
    L7:
        finish();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.isRegistered == false) goto L6;
        unregisterReceiver(this.mHeadsetPlugReceiver);
        this.isRegistered = false;
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onKeyDown(int r4, KeyEvent r5) {
        if (r5 == null) goto L16;
        if (r4 == 4) goto L16;
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder("event:").append(r5.getAction()).append("  scancode:").append(r5.getScanCode()).append(" device:");
        if (r5.getDevice() == null) goto L8;
        String r2 = r5.getDevice().getName();
    L9:
        OLog.d(r0, r1.append(r2).toString());
        OLog.d(r0, "headsetinput device:" + mHeadsetInputDevice);
        if (r5.getAction() != 0) goto L16;
        if (isHeadsetKeyEvent(r5) == false) goto L16;
        this.scancode = r5.getScanCode();
        setupButtonGroup(true);
        return true;
    L8:
        r2 = "";
    L16:
        return super.onKeyDown(r4, r5);
    }

    private void setupButtonGroup(boolean r4) {
        setupButtonVisibility();
        int r0 = AnonymousClass2.$SwitchMap$com$android$settings$HeadsetCalibrationFragment$CalibrationStatus[this.mStatus.ordinal()];
        if (r0 != 1) goto L5;
        this.btnKeyPressed.setText(R.string.headset_calibration_start);
    L16:
        if (this.mStatus != CalibrationStatus.Done) goto L18;
        r4 = true;
    L18:
        this.btnKeyAbsent.setEnabled(true);
        this.btnKeyPressed.setEnabled(r4);
        this.btnDone.setEnabled(r4);
        setupAnimatedView();
        return;
    L5:
        if (r0 != 2) goto L7;
        this.mCalibratingTips.setText(R.string.headset_calibrating_up_tips);
        adjustCalibratingTipsPosition(this.mCalUpAnimView);
        this.btnKeyAbsent.setText(R.string.headset_calibration_up_key_absent);
        this.btnKeyPressed.setText(R.string.headset_calibration_up_key_pressed);
        goto L16
    L7:
        if (r0 != 3) goto L9;
        this.mCalibratingTips.setText(R.string.headset_calibrating_down_tips);
        adjustCalibratingTipsPosition(this.mCalDownAnimView);
        this.btnKeyAbsent.setText(R.string.headset_calibration_down_key_absent);
        this.btnKeyPressed.setText(R.string.headset_calibration_down_key_pressed);
        goto L16
    L9:
        if (r0 != 4) goto L16;
        this.mCalibrateDoneTips.setVisibility(0);
        this.mCalibratingTips.setVisibility(8);
        this.btnDone.setText(R.string.ok);
        goto L16
    }

    private void adjustCalibratingTipsPosition(CalibrationAnimtedView r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        float r0 = r6.getX() + (r6.getWidth() / 2);
        float r7 = Utils.caculateTextWidth(this.mCalibratingTips) / 2.0f;
        float r1 = r0 - r7;
        OLog.d(TAG, "baseViewCenterX:" + r0 + "  textWidth/2:" + r7 + " paddingLeft:" + r1);
        this.mCalibratingTips.setPadding((int) r1, 0, 0, 0);
    }

    private void setupButtonVisibility() {
        int r0 = AnonymousClass2.$SwitchMap$com$android$settings$HeadsetCalibrationFragment$CalibrationStatus[this.mStatus.ordinal()];
        if (r0 != 1) goto L5;
        this.btnKeyAbsent.setVisibility(8);
        this.btnKeyPressed.setVisibility(0);
        this.btnDone.setVisibility(8);
        return;
    L5:
        if (r0 != 2) goto L7;
    L12:
        this.btnKeyAbsent.setVisibility(0);
        this.btnKeyPressed.setVisibility(0);
        this.btnDone.setVisibility(8);
        return;
    L7:
        if (r0 == 3) goto L12;
        if (r0 != 4) goto L17;
        this.btnKeyAbsent.setVisibility(8);
        this.btnKeyPressed.setVisibility(8);
        this.btnDone.setVisibility(0);
        return;
    }

    private void setupAnimatedView() {
        int r0 = AnonymousClass2.$SwitchMap$com$android$settings$HeadsetCalibrationFragment$CalibrationStatus[this.mStatus.ordinal()];
        if (r0 != 1) goto L5;
        this.mCalUpAnimView.startAnim(0);
        this.mCalDownAnimView.startAnim(0);
        return;
    L5:
        if (r0 != 2) goto L7;
        this.mCalUpAnimView.startAnim(1);
        return;
    L7:
        if (r0 != 3) goto L9;
        this.mCalUpAnimView.startAnim(2);
        this.mCalDownAnimView.startAnim(1);
        return;
    L9:
        if (r0 != 4) goto L19;
        this.mCalDownAnimView.startAnim(2);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != this.btnKeyPressed) goto L9;
        String r6 = TAG;
        OLog.d(r6, "btnKeyPressed clicked");
        if (CalibrationStatus.access$000(this.mStatus) == null) goto L7;
        this.mScancodeMaps.put(CalibrationStatus.access$000(this.mStatus), Integer.valueOf(this.scancode));
        OLog.d(r6, "put scancode:[" + CalibrationStatus.access$000(this.mStatus) + ", " + this.scancode + "]");
    L7:
        this.mStatus = this.mStatus.nextStatus();
        setupButtonGroup(false);
        return;
    L9:
        if (r5 != this.btnKeyAbsent) goto L12;
        OLog.d(TAG, "btnKeyAbsent clicked");
        this.mScancodeMaps.put(CalibrationStatus.access$000(this.mStatus), -1);
        this.mStatus = this.mStatus.nextStatus();
        setupButtonGroup(false);
        return;
    L12:
        if (r5 != this.btnDone) goto L17;
        OLog.d(TAG, "btnDone clicked");
        finish();
        return;
    }

    private void saveCalibration() {
        OLog.d(TAG, "saveCalibration scancode:" + this.mScancodeMaps);
        Set<String> r0 = this.mScancodeMaps.keySet();
        Iterator<String> r1 = r0.iterator();
        int r3 = 0;
    L4:
        if (r3 >= r0.size()) goto L7;
        String r4 = r1.next();
        android.provider.Settings.Global.putInt(getContentResolver(), r4, this.mScancodeMaps.get(r4).intValue());
        r3 = r3 + 1;
        goto L4
    L7:
        if (r0.size() == 2) goto L9;
        return;
    L9:
        if (this.mScancodeMaps.get(KEY_VOLUME_UP).intValue() == (-1)) goto L11;
        return;
    L11:
        if (this.mScancodeMaps.get(KEY_VOLUME_DOWN).intValue() != (-1)) goto L17;
        OLog.d(TAG, "set headset hook");
        android.provider.Settings.Global.putInt(getContentResolver(), KEY_HEADSET_HOOK, 0);
        android.provider.Settings.Global.putInt(getContentResolver(), KEY_HEADSET_HOOK, -1);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void finish() {
        super.finish();
        if (this.mStatus != CalibrationStatus.Done) goto L5;
        saveCalibration();
    L5:
        CalibrationAnimtedView r0 = this.mCalDownAnimView;
        if (r0 == null) goto L8;
        r0.stopAnim();
    L8:
        CalibrationAnimtedView r2 = this.mCalUpAnimView;
        if (r2 == null) goto L12;
        r2.stopAnim();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_HeadsetCalibrationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(HeadsetCalibrationFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_HeadsetCalibrationFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_HeadsetCalibrationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(HeadsetCalibrationFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_HeadsetCalibrationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_HeadsetCalibrationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(HeadsetCalibrationFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_HeadsetCalibrationFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
