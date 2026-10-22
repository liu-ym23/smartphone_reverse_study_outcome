package com.android.settings.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemProperties;
import android.widget.CompoundButton;
import androidx.preference.Preference;
import com.GlobalProxyLancet;
import com.android.settings.SettingsTracker;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.olog.OLog;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothDiscoverableEnabler implements Preference.OnPreferenceClickListener, CompoundButton.OnCheckedChangeListener {
    static final int DEFAULT_DISCOVERABLE_TIMEOUT = 120;
    private static final int DISCOVERABLE_TIMEOUT_FIVE_MINUTES = 300;
    static final int DISCOVERABLE_TIMEOUT_NEVER = 0;
    private static final int DISCOVERABLE_TIMEOUT_ONE_HOUR = 3600;
    private static final int DISCOVERABLE_TIMEOUT_TWO_MINUTES = 120;
    private static final String KEY_DISCOVERABLE_TIMEOUT = "bt_discoverable_timeout";
    private static final String SYSTEM_PROPERTY_DISCOVERABLE_TIMEOUT = "debug.bt.discoverable_time";
    private static final String TAG = "BluetoothDiscoverableEnabler";
    private static final String VALUE_DISCOVERABLE_TIMEOUT_FIVE_MINUTES = "fivemin";
    private static final String VALUE_DISCOVERABLE_TIMEOUT_NEVER = "never";
    private static final String VALUE_DISCOVERABLE_TIMEOUT_ONE_HOUR = "onehour";
    private static final String VALUE_DISCOVERABLE_TIMEOUT_TWO_MINUTES = "twomin";
    private final Context mContext;
    private boolean mDiscoverable;
    private final LocalBluetoothAdapter mLocalAdapter;
    private int mNumberOfPairedDevices;
    private final BroadcastReceiver mReceiver;
    private OSwitch mSwitchEx;
    private int mTimeoutSecs;
    private final Runnable mUpdateCountdownSummaryRunnable;

    private void setSummaryNotDiscoverable() {
    }

    static /* synthetic */ void access$000(BluetoothDiscoverableEnabler r0) {
        r0.updateCountdownSummary();
    }

    BluetoothDiscoverableEnabler(Context r2, LocalBluetoothAdapter r3, Preference r4) {
        this.mTimeoutSecs = -1;
        this.mReceiver = new AnonymousClass1(this);
        this.mUpdateCountdownSummaryRunnable = new AnonymousClass2(this);
        this.mContext = r2;
        this.mLocalAdapter = r3;
        r4.setPersistent(false);
    }

    BluetoothDiscoverableEnabler(Context r2, LocalBluetoothAdapter r3, OSwitch r4) {
        this.mTimeoutSecs = -1;
        this.mReceiver = new AnonymousClass1(this);
        this.mUpdateCountdownSummaryRunnable = new AnonymousClass2(this);
        this.mContext = r2;
        this.mLocalAdapter = r3;
        this.mSwitchEx = r4;
        r4.setOnCheckedChangeListener(this);
    }

    public void resume() {
        if (this.mLocalAdapter != null) goto L5;
        return;
    L5:
        IntentFilter r0 = new IntentFilter("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, r0, 2);
        handleModeChanged(this.mLocalAdapter.getScanMode());
    }

    public void pause() {
        if (this.mLocalAdapter != null) goto L5;
        return;
    L5:
        this.mContext.unregisterReceiver(this.mReceiver);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        setEnabled(r2);
        this.mDiscoverable = !this.mDiscoverable;
        SettingsTracker.onSwitcherClick(504, r2);
        SettingsTracker.onSwitchStatus("A131003", "other_search", r2);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r2) {
        boolean r3 = !this.mDiscoverable;
        this.mDiscoverable = r3;
        setEnabled(r3);
        return true;
    }

    private void setEnabled(boolean r2) {
        if (r2 == false) goto L4;
        this.mLocalAdapter.setScanMode(23, 0);
        return;
    L4:
        this.mLocalAdapter.setScanMode(21);
    }

    private void updateTimerDisplay(int r1) {
        if (getDiscoverableTimeout() == 0) goto L7;
        formatTimeRemaining(r1);
        return;
    }

    private static String formatTimeRemaining(int r4) {
        StringBuilder r0 = new StringBuilder(6);
        int r1 = r4 / 60;
        r0.append(r1).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        int r5 = r4 - (r1 * 60);
        if (r5 >= 10) goto L5;
        r0.append('0');
    L5:
        r0.append(r5);
        return r0.toString();
    }

    void setDiscoverableTimeout(int r3) {
        if (r3 != 1) goto L5;
        this.mTimeoutSecs = 300;
    L12:
        setEnabled(true);
        return;
    L5:
        if (r3 != 2) goto L7;
        this.mTimeoutSecs = 3600;
        goto L12
    L7:
        if (r3 == 3) goto L9;
        this.mTimeoutSecs = 120;
        goto L12
    L9:
        this.mTimeoutSecs = 0;
        goto L12
    }

    private int getDiscoverableTimeout() {
        int r0 = this.mTimeoutSecs;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = SystemProperties.getInt(SYSTEM_PROPERTY_DISCOVERABLE_TIMEOUT, -1);
        this.mTimeoutSecs = r1;
        return r1;
    }

    int getDiscoverableTimeoutIndex() {
        int r1 = getDiscoverableTimeout();
        if (r1 != 0) goto L5;
        return 3;
    L5:
        if (r1 != 300) goto L7;
        return 1;
    L7:
        if (r1 == 3600) goto L10;
        return 0;
    L10:
        return 2;
    }

    void setNumberOfPairedDevices(int r1) {
        this.mNumberOfPairedDevices = r1;
        handleModeChanged(this.mLocalAdapter.getScanMode());
    }

    void handleModeChanged(int r3) {
        OLog.d(TAG, "handleModeChanged(): mode = " + r3);
        if (r3 != 23) goto L5;
        this.mDiscoverable = true;
    L6:
        this.mSwitchEx.setChecked(this.mDiscoverable);
        return;
    L5:
        this.mDiscoverable = false;
        goto L6
    }

    private void updateCountdownSummary() {
        if (this.mLocalAdapter.getScanMode() == 23) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        long r2 = LocalBluetoothPreferences.getDiscoverableEndTimestamp(this.mContext);
        if (r0 <= r2) goto L9;
        updateTimerDisplay(0);
        return;
    L9:
        updateTimerDisplay((int) ((r2 - r0) / 1000));
        monitor-enter(this);
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
