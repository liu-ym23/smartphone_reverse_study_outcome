package com.bytedanceos.powerusage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.widget.CompoundButton;
import bytedanceos.api.PackageManagerSmt;
import bytedanceos.api.PowerManagerSmt;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.utils.Constants;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.security.R;
import com.obric.security.battertpower.BatteryPowerActivity;

/* JADX INFO: loaded from: classes2.dex */
public class PowerSaveModeActivity extends BaseActivity {
    private static final String ON_HAND_IN_HAND_KEY = "on_hand_in_hand";
    public static final int REQ_VERIFY_LAUNCHER_PASSWORD = 11;
    private static final String SCREEN_RECORDER_STATUS = "screen_recorder_status";
    private CompoundButton.OnCheckedChangeListener mFeatureModeChangeListener;
    OListItemSwitch mFeaturePhoneMode;
    private ContentObserver mFeaturePhoneModeObserver;
    private ContentObserver mHandInHandObserver;
    boolean mIsFeaturePhoneMode;
    OListItemSettings mLowBatteryMode;
    private ContentObserver mLowBatteryModeObserver;
    PowerManager mPowerManager;
    private ContentObserver mRecordScreenObserver;

    public PowerSaveModeActivity() {
        final Handler r1 = new Handler();
        this.mFeaturePhoneModeObserver = new AnonymousClass2(this, r1);
        final Handler r2 = new Handler();
        this.mLowBatteryModeObserver = new AnonymousClass3(this, r2);
        this.mFeatureModeChangeListener = new AnonymousClass4(this);
        final Handler r3 = new Handler();
        this.mRecordScreenObserver = new AnonymousClass5(this, r3);
        final Handler r4 = new Handler();
        this.mHandInHandObserver = new AnonymousClass6(this, r4);
    }

    static /* synthetic */ void access$000(PowerSaveModeActivity r0) {
        r0.setChecked();
    }

    static /* synthetic */ void access$100(PowerSaveModeActivity r0) {
        r0.updateLowBatterySubTitle();
    }

    static /* synthetic */ boolean access$200(PowerSaveModeActivity r0, PackageManager r1, String r2) {
        return r0.isPackageLocked(r1, r2);
    }

    static /* synthetic */ void access$300(PowerSaveModeActivity r0) {
        r0.forceStopApp();
    }

    static /* synthetic */ void access$400(PowerSaveModeActivity r0) {
        r0.initFeaturePhoneSwitchEnable();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, BatteryPowerActivity.class));
        finish();
        setContentView(R.layout.power_usage_mode_activity);
        this.mPowerManager = (PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        initTitleBar(false);
        initView();
        updateViewWidth(R.id.ll_container);
    }

    private void initView() {
        this.mLowBatteryMode = (OListItemSettings) findViewById(R.id.power_usage_low_battery_mode);
        this.mFeaturePhoneMode = (OListItemSwitch) findViewById(R.id.power_usage_feature_phone_mode);
        OListItemSettings r0 = this.mLowBatteryMode;
        if (r0 == null) goto L6;
        r0.setOnClickListener(new AnonymousClass1(this));
        return;
    }

    public static boolean isFeaturePhoneMode(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), Constants.FEATURE_PHONE_MODE, 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isLowBatteryMode(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "low_power", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setChecked() {
        this.mFeaturePhoneMode.setOnCheckedChangeListener(null);
        this.mFeaturePhoneMode.setChecked(this.mIsFeaturePhoneMode);
        this.mFeaturePhoneMode.setOnCheckedChangeListener(this.mFeatureModeChangeListener);
    }

    public boolean isRecordScreen(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), SCREEN_RECORDER_STATUS, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public boolean isHandInHand() {
        int r3 = Settings.System.getInt(getContentResolver(), ON_HAND_IN_HAND_KEY, 0);
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L9;
        if (r3 == 101) goto L9;
        return false;
    L9:
        return true;
    }

    private void initFeaturePhoneSwitchEnable() {
        if (isRecordScreen(this) == false) goto L5;
    L8:
        this.mFeaturePhoneMode.setEnabled(false);
        return;
    L5:
        if (isHandInHand() == true) goto L8;
        this.mFeaturePhoneMode.setEnabled(true);
    }

    private boolean isPackageLocked(PackageManager pm, String pkg) {
        return PackageManagerSmt.getInstance().isPackageLocked(pm, pkg);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsFeaturePhoneMode = PowerManagerSmt.getInstance().isFeaturePhoneMode(this.mPowerManager);
        updateLowBatterySubTitle();
        setChecked();
        getContentResolver().registerContentObserver(Settings.Global.getUriFor(Constants.FEATURE_PHONE_MODE), true, this.mFeaturePhoneModeObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("low_power"), true, this.mLowBatteryModeObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor(SCREEN_RECORDER_STATUS), true, this.mRecordScreenObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(ON_HAND_IN_HAND_KEY), true, this.mHandInHandObserver);
        initFeaturePhoneSwitchEnable();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        getContentResolver().unregisterContentObserver(this.mFeaturePhoneModeObserver);
        getContentResolver().unregisterContentObserver(this.mLowBatteryModeObserver);
        getContentResolver().unregisterContentObserver(this.mRecordScreenObserver);
        getContentResolver().unregisterContentObserver(this.mHandInHandObserver);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) goto L5;
        return;
    L5:
        if (resultCode != (-1)) goto L9;
        MultiSdkAdapter.setPowerSaveMode(this.mPowerManager, true);
        forceStopApp();
        return;
    }

    private void updateLowBatterySubTitle() {
        if (isLowBatteryMode(this) == false) goto L5;
        int r0 = R.string.settings_state_on;
    L6:
        String r1 = getString(r0);
        this.mLowBatteryMode.setTrailingText(r1);
        return;
    L5:
        r0 = R.string.settings_state_off;
        goto L6
    }

    private void forceStopApp() {
        new Thread(new AnonymousClass7(this), "PowerSaveModeActivity-forceStopApp").start();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }
}
