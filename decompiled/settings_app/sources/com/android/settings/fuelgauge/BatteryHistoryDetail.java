package com.android.settings.fuelgauge;

import android.R;
import android.content.Intent;
import android.os.BatteryStats;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.graph.UsageView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryHistoryDetail extends SettingsPreferenceFragment {
    public static final String EXTRA_BROADCAST = "broadcast";
    public static final String EXTRA_STATS = "stats";
    private Intent mBatteryBroadcast;
    private BatteryFlagParser mCameraParser;
    private BatteryFlagParser mChargingParser;
    private BatteryFlagParser mCpuParser;
    private BatteryFlagParser mFlashlightParser;
    private BatteryFlagParser mGpsParser;
    private BatteryCellParser mPhoneParser;
    private BatteryFlagParser mScreenOn;
    private BatteryStats mStats;
    private BatteryWifiParser mWifiParser;

    public void com_android_settings_fuelgauge_BatteryHistoryDetail__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_BatteryHistoryDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fuelgauge_BatteryHistoryDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public BatteryHistoryDetail() {
    }

    public void com_android_settings_fuelgauge_BatteryHistoryDetail__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        getArguments().getString(EXTRA_STATS);
        this.mBatteryBroadcast = (Intent) getArguments().getParcelable(EXTRA_BROADCAST);
        TypedValue r6 = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.colorAccent, r6, true);
        int r7 = getContext().getColor(r6.resourceId);
        this.mChargingParser = new BatteryFlagParser(r7, false, 524288);
        this.mScreenOn = new BatteryFlagParser(r7, false, 1048576);
        this.mGpsParser = new BatteryFlagParser(r7, false, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        this.mFlashlightParser = new BatteryFlagParser(r7, true, VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS);
        this.mCameraParser = new BatteryFlagParser(r7, true, 2097152);
        this.mWifiParser = new BatteryWifiParser(r7);
        this.mCpuParser = new BatteryFlagParser(r7, false, Integer.MIN_VALUE);
        this.mPhoneParser = new BatteryCellParser();
        setHasOptionsMenu(true);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return r1.inflate(com.android.settings.R.layout.battery_history_detail, r2, false);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        updateEverything();
    }

    private void updateEverything() {
        BatteryInfo r0 = BatteryInfo.getBatteryInfo(getContext(), this.mBatteryBroadcast, this.mStats, SystemClock.elapsedRealtime() * 1000);
        View r1 = getView();
        r0.bindHistory((UsageView) r1.findViewById(com.android.settings.R.id.battery_usage), new BatteryInfo.BatteryDataParser[]{this.mChargingParser, this.mScreenOn, this.mGpsParser, this.mFlashlightParser, this.mCameraParser, this.mWifiParser, this.mCpuParser, this.mPhoneParser});
        ((TextView) r1.findViewById(com.android.settings.R.id.charge)).setText(r0.batteryPercentString);
        ((TextView) r1.findViewById(com.android.settings.R.id.estimation)).setText(r0.remainingLabel);
        bindData(this.mChargingParser, com.android.settings.R.string.battery_stats_charging_label, com.android.settings.R.id.charging_group);
        bindData(this.mScreenOn, com.android.settings.R.string.battery_stats_screen_on_label, com.android.settings.R.id.screen_on_group);
        bindData(this.mGpsParser, com.android.settings.R.string.battery_stats_gps_on_label, com.android.settings.R.id.gps_group);
        bindData(this.mFlashlightParser, com.android.settings.R.string.battery_stats_flashlight_on_label, com.android.settings.R.id.flashlight_group);
        bindData(this.mCameraParser, com.android.settings.R.string.battery_stats_camera_on_label, com.android.settings.R.id.camera_group);
        bindData(this.mWifiParser, com.android.settings.R.string.battery_stats_wifi_running_label, com.android.settings.R.id.wifi_group);
        bindData(this.mCpuParser, com.android.settings.R.string.battery_stats_wake_lock_label, com.android.settings.R.id.cpu_group);
        bindData(this.mPhoneParser, com.android.settings.R.string.battery_stats_phone_signal_label, com.android.settings.R.id.cell_network_group);
    }

    private void bindData(BatteryActiveView.BatteryActiveProvider r1, int r2, int r3) {
        View r0 = getView().findViewById(r3);
        if (r1.hasData() == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        ((TextView) r0.findViewById(R.id.title)).setText(r2);
        ((BatteryActiveView) r0.findViewById(com.android.settings.R.id.battery_active)).setProvider(r1);
        return;
    L5:
        r4 = 8;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_BatteryHistoryDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BatteryHistoryDetail r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_BatteryHistoryDetail__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_BatteryHistoryDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BatteryHistoryDetail r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fuelgauge_BatteryHistoryDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_BatteryHistoryDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BatteryHistoryDetail r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_BatteryHistoryDetail__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
