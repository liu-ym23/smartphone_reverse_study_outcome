package com.android.settings.fuelgauge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PowerUsageBase extends SettingsPreferenceFragment23 {
    private static final int MENU_STATS_REFRESH = 2;
    static final int MSG_REFRESH_STATS = 100;
    private BroadcastReceiver mBatteryInfoReceiver;
    private String mBatteryLevel;
    private String mBatteryStatus;
    private final Handler mHandler;
    protected UserManager mUm;

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_PowerUsageBase_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fuelgauge_PowerUsageBase_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    protected void refreshStats() {
    }

    protected void updatePreference(BatteryHistoryPreference r1) {
    }

    public PowerUsageBase() {
        this.mHandler = new AnonymousClass1(this);
        this.mBatteryInfoReceiver = new AnonymousClass2(this);
    }

    static /* synthetic */ Handler access$000(PowerUsageBase r0) {
        return r0.mHandler;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r2) {
        super.onAttach(r2);
        this.mUm = (UserManager) r2.getSystemService(PickApplicationActivity.EXTRA_USER);
    }

    public void com_android_settings_fuelgauge_PowerUsageBase__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setHasOptionsMenu(true);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    public void com_android_settings_fuelgauge_PowerUsageBase__onResume$___twin___() {
        super.onResume();
        if (this.mHandler.hasMessages(100) == false) goto L6;
        this.mHandler.removeMessages(100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mHandler.removeMessages(100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getActivity().isChangingConfigurations();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r2, MenuInflater r3) {
        super.onCreateOptionsMenu(r2, r3);
        r2.add(0, 2, 0, R.string.menu_stats_refresh).setIcon(android.R.drawable.pointer_nodrop).setAlphabeticShortcut('r').setShowAsAction(5);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r3) {
        if (r3.getItemId() != 2) goto L5;
        refreshStats();
        this.mHandler.removeMessages(100);
        return true;
    L5:
        return super.onOptionsItemSelected(r3);
    }

    protected boolean updateBatteryStatus(Intent r3) {
        if (r3 == null) goto L9;
        String r0 = com.android.settings.Utils.getBatteryPercentage(r3);
        String r4 = com.android.settings.Utils.getBatteryStatus(getResources(), r3);
        if (r0.equals(this.mBatteryLevel) == true) goto L6;
    L7:
        this.mBatteryLevel = r0;
        this.mBatteryStatus = r4;
        return true;
    L6:
        if (r4.equals(this.mBatteryStatus) == false) goto L7;
        return false;
    L9:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_PowerUsageBase_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PowerUsageBase r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_PowerUsageBase__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_PowerUsageBase_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PowerUsageBase r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fuelgauge_PowerUsageBase_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_PowerUsageBase_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PowerUsageBase r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_PowerUsageBase__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
