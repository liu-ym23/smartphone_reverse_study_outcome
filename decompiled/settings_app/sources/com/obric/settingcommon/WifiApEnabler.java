package com.obric.settingcommon;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class WifiApEnabler extends SettingsEnabler {
    private WifiManager mWifiManager;

    public WifiApEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        this.mWifiManager = (WifiManager) r1.getSystemService("wifi");
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mWifiManager.isWifiApEnabled();
        int r0 = this.mWifiManager.getWifiApState();
        OSwitch r1 = this.mSwitch;
        if (r0 != 12) goto L5;
    L8:
        boolean r2 = true;
    L9:
        r1.setChecked(r2);
        this.mSwitch.setOnCheckedChangeListener(this);
        return;
    L5:
        if (r0 == 13) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        this.mSwitch.setChecked(r3);
        if (r3 == false) goto L5;
        this.mWifiManager.setWifiApConfiguration(null);
        this.mWifiManager.startSoftAp(null);
    L6:
        TrackerEventUpload.switchEvent("wifi_ap", r3);
        return;
    L5:
        this.mWifiManager.stopSoftAp();
        goto L6
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }
}
