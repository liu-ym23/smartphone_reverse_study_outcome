package com.android.settings.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.GlobalProxyLancet;
import com.android.settings.AdaptWifi;
import com.android.settings.HotspotPreference;
import com.android.settings.R;
import com.android.settings.datausage.DataSaverBackend;

/* JADX INFO: loaded from: classes.dex */
public class WifiApEnabler {
    private static final String ACTION_EXTRA = "choice";
    private static final String ACTION_HOTSPOT_POST_CONFIGURE = "Hotspot_PostConfigure";
    public static final int TETHERING_WIFI = 0;
    ConnectivityManager mCm;
    private final Context mContext;
    private final DataSaverBackend mDataSaverBackend;
    private boolean mEnabling;
    private final IntentFilter mIntentFilter;
    private final CharSequence mOriginalSummary;
    private final BroadcastReceiver mReceiver;
    private final Preference mSwitch;
    private WifiManager mWifiManager;
    private String[] mWifiRegexs;

    static /* synthetic */ void access$000(WifiApEnabler r0, int r1, int r2) {
        r0.handleWifiApStateChanged(r1, r2);
    }

    static /* synthetic */ void access$100(WifiApEnabler r0, Object[] r1, Object[] r2, Object[] r3) {
        r0.updateTetherState(r1, r2, r3);
    }

    static /* synthetic */ void access$200(WifiApEnabler r0) {
        r0.enableWifiSwitch();
    }

    public WifiApEnabler(Context r3, DataSaverBackend r4, Preference r5) {
        this.mEnabling = false;
        this.mReceiver = new AnonymousClass1(this);
        this.mContext = r3;
        this.mDataSaverBackend = r4;
        this.mSwitch = r5;
        this.mOriginalSummary = r5.getSummary();
        r5.setPersistent(false);
        this.mWifiManager = (WifiManager) r3.getSystemService("wifi");
        ConnectivityManager r6 = (ConnectivityManager) r3.getSystemService("connectivity");
        this.mCm = r6;
        this.mWifiRegexs = r6.getTetherableWifiRegexs();
        IntentFilter r7 = new IntentFilter("android.net.wifi.WIFI_AP_STATE_CHANGED");
        this.mIntentFilter = r7;
        r7.addAction("android.net.conn.TETHER_STATE_CHANGED");
        r7.addAction("android.intent.action.AIRPLANE_MODE");
    }

    public void resume() {
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, this.mIntentFilter, 2);
        enableWifiSwitch();
    }

    public void pause() {
        this.mContext.unregisterReceiver(this.mReceiver);
    }

    private void enableWifiSwitch() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        this.mSwitch.setEnabled(!this.mDataSaverBackend.isDataSaverEnabled());
        return;
    L8:
        this.mSwitch.setSummary(this.mOriginalSummary);
        this.mSwitch.setEnabled(false);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setChecked(boolean r1) {
        ((HotspotPreference) this.mSwitch).setChecked(r1);
    }

    public void updateConfigSummary(WifiConfiguration r4) {
        String r0 = AdaptWifi.getWifiTetherConfigureSSIDDefault(this.mContext);
        Preference r1 = this.mSwitch;
        String r3 = this.mContext.getString(R.string.wifi_tether_enabled_subtext);
        Object[] r2 = new Object[1];
        if (r4 == null) goto L6;
        r0 = r4.SSID;
    L6:
        r2[0] = r0;
        r1.setSummary(String.format(r3, r2));
    }

    private void updateTetherState(Object[] r10, Object[] r11, Object[] r12) {
        int r13 = r11.length;
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r13) goto L12;
        String r4 = (String) r11[r1];
        String[] r5 = this.mWifiRegexs;
        int r6 = r5.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L11;
        if (r4.matches(r5[r7]) == false) goto L10;
        r2 = true;
    L10:
        r7 = r7 + 1;
        goto L6
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        int r14 = r12.length;
        int r15 = 0;
        boolean r3 = false;
    L13:
        if (r15 >= r14) goto L21;
        String r8 = (String) r12[r15];
        String[] r9 = this.mWifiRegexs;
        int r16 = r9.length;
        int r17 = 0;
    L15:
        if (r17 >= r16) goto L20;
        if (r8.matches(r9[r17]) == false) goto L19;
        r3 = true;
    L19:
        r17 = r17 + 1;
        goto L15
    L20:
        r15 = r15 + 1;
        goto L13
    L21:
        if (r2 == false) goto L23;
        updateConfigSummary(this.mWifiManager.getWifiApConfiguration());
        return;
    L23:
        if (r3 == false) goto L35;
        this.mSwitch.setSummary(R.string.wifi_error);
        return;
    }

    private void handleWifiApStateChanged(int r8, int r9) {
        if (this.mContext.getResources().getBoolean(R.bool.show_wifi_hotspot_settings) == false) goto L15;
        HotspotPreference r0 = (HotspotPreference) this.mSwitch;
        switch(r8) {
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L9;
            default: goto L6;
        };
    L6:
        r0.setChecked(false);
        if (r9 != 1) goto L13;
        r0.setSummary(R.string.wifi_sap_no_channel_error);
    L14:
        enableWifiSwitch();
        return;
    L13:
        r0.setSummary(R.string.wifi_error);
        goto L14
    L9:
        postTurnOn(this.mContext, 0);
        r0.setChecked(true);
        r0.setEnabled(!this.mDataSaverBackend.isDataSaverEnabled());
        return;
    L10:
        r0.setSummary(R.string.wifi_tether_starting);
        r0.setEnabled(false);
        return;
    L11:
        r0.setChecked(false);
        r0.setSummary(this.mOriginalSummary);
        enableWifiSwitch();
        return;
    L12:
        r0.setSummary(R.string.wifi_tether_stopping);
        r0.setChecked(false);
        r0.setEnabled(false);
        return;
    L15:
        SwitchPreference r1 = (SwitchPreference) this.mSwitch;
        switch(r8) {
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            default: goto L17;
        };
    L17:
        r1.setChecked(false);
        if (r9 != 1) goto L24;
        r1.setSummary(R.string.wifi_sap_no_channel_error);
    L25:
        enableWifiSwitch();
        return;
    L24:
        r1.setSummary(R.string.wifi_error);
        goto L25
    L20:
        r1.setChecked(true);
        r1.setEnabled(!this.mDataSaverBackend.isDataSaverEnabled());
        return;
    L21:
        r1.setSummary(R.string.wifi_tether_starting);
        r1.setEnabled(false);
        return;
    L22:
        r1.setChecked(false);
        r1.setSummary(this.mOriginalSummary);
        enableWifiSwitch();
        return;
    L23:
        r1.setSummary(R.string.wifi_tether_stopping);
        r1.setChecked(false);
        r1.setEnabled(false);
    }

    private boolean postTurnOn(Context r3, int r4) {
        if (this.mEnabling == true) goto L5;
        return true;
    L5:
        if (r3.getResources().getBoolean(R.bool.tethering_show_help_for_first_using) == false) goto L10;
        Intent r0 = new Intent(ACTION_HOTSPOT_POST_CONFIGURE);
        r0.putExtra(ACTION_EXTRA, r4);
        r3.startActivity(r0);
        this.mEnabling = false;
        return true;
    L10:
        return true;
    }
}
