package com.android.settings.fuelgauge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.applications.PickApplicationActivity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PowerUsageBase_ extends SettingsPreferenceFragment {
    private static final int MENU_STATS_REFRESH = 2;
    static final int MSG_REFRESH_STATS = 100;
    private BroadcastReceiver mBatteryInfoReceiver;
    private String mBatteryLevel;
    private String mBatteryStatus;
    private final Handler mHandler;
    protected UserManager mUm;

    protected void refreshStats() {
    }

    public PowerUsageBase_() {
        this.mHandler = new AnonymousClass1(this);
        this.mBatteryInfoReceiver = new AnonymousClass2(this);
    }

    static /* synthetic */ boolean access$000(PowerUsageBase_ r0, Intent r1) {
        return r0.updateBatteryStatus(r1);
    }

    static /* synthetic */ Handler access$100(PowerUsageBase_ r0) {
        return r0.mHandler;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r2) {
        super.onAttach(r2);
        this.mUm = (UserManager) r2.getSystemService(PickApplicationActivity.EXTRA_USER);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        setHasOptionsMenu(true);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateBatteryStatus(GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mBatteryInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2));
        if (this.mHandler.hasMessages(100) == false) goto L6;
        this.mHandler.removeMessages(100);
        return;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.unregisterReceiver(this.mBatteryInfoReceiver);
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mHandler.removeMessages(100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getActivity().isChangingConfigurations();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
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

    private boolean updateBatteryStatus(Intent r3) {
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
}
