package com.obric.settingcommon;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class WifiEnabler extends SettingsEnabler {
    private final WifiManager mWifiManager;

    public WifiEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        this.mWifiManager = (WifiManager) r1.getSystemService("wifi");
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        handleWifiStateChanged(this.mWifiManager.getWifiState());
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (r5 == true) goto L5;
    L8:
        super.onCheckedChanged(r4, r5);
        this.mSwitch.setEnabled(false);
        int r6 = ((Integer) this.mWifiManager.getClass().getDeclaredMethod("getWifiApState", new Class[0]).invoke(this.mWifiManager, new Object[0])).intValue();     // Catch: Exception -> L22
        if (r5 == true) goto L12;
    L16:
        if (r5 == true) goto L18;
    L20:
        this.mSwitch.setEnabled(false);     // Catch: Exception -> L22
        changeWifiState(r5);     // Catch: Exception -> L22
        return;
    L18:
        if (isMiracastOn() == false) goto L20;
        showTntExitConfirmDialog(r5, null, this.mContext.getString(R.string.wifi));     // Catch: Exception -> L22
        return;
    L12:
        if (r6 != 12) goto L14;
    L15:
        this.mWifiManager.stopSoftAp();     // Catch: Exception -> L22
        goto L16
    L14:
        if (r6 != 13) goto L16;
    L22:
        e = move-exception;
        Log.e("WifiEnabler", "onCheckedChanged error\n", e);
        return;
    L5:
        if (isRadioAllowed(this.mContext, "wifi") == true) goto L8;
        r4.setChecked(false);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    public void doConfirm(boolean r1) {
        super.doConfirm(r1);
        changeWifiState(r1);
        TrackerEventUpload.switchEvent("wifi", r1);
    }

    private void changeWifiState(boolean r3) {
        this.mSwitch.setEnabled(false);
        if (this.mWifiManager.setWifiEnabled(r3) == true) goto L5;
        this.mSwitch.setEnabled(true);
    L5:
        TrackerEventUpload.switchEvent("wifi", r3);
    }

    private void handleWifiStateChanged(int r4) {
        if (r4 != 0) goto L5;
        this.mSwitch.setEnabled(false);
        return;
    L5:
        if (r4 != 1) goto L7;
        this.mSwitch.setChecked(false);
        this.mSwitch.setEnabled(true);
        return;
    L7:
        if (r4 != 2) goto L9;
        this.mSwitch.setEnabled(false);
        return;
    L9:
        if (r4 == 3) goto L11;
        this.mSwitch.setChecked(false);
        this.mSwitch.setEnabled(true);
        return;
    L11:
        this.mSwitch.setChecked(true);
        this.mSwitch.setEnabled(true);
    }

    public static boolean isAirplaneModeOn(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isRadioAllowed(Context r2, String r3) {
        if (isAirplaneModeOn(r2) == true) goto L5;
        return true;
    L5:
        String r4 = Settings.Global.getString(r2.getContentResolver(), "airplane_mode_toggleable_radios");
        if (r4 != null) goto L8;
    L10:
        return false;
    L8:
        if (r4.contains(r3) == false) goto L10;
        return true;
    }
}
