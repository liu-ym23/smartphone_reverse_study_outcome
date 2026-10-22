package com.obric.settingcommon;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class MultiWifiEnabler extends SettingsEnabler {
    private final WifiManager mWifiManager;

    public MultiWifiEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        this.mWifiManager = (WifiManager) r1.getSystemService("wifi");
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        int r0 = this.mWifiManager.getStaConcurrencyForMultiInternetMode();
        OSwitch r1 = this.mSwitch;
        if (r0 != 2) goto L5;
        boolean r2 = true;
    L6:
        r1.setChecked(r2);
        this.mSwitch.setOnCheckedChangeListener(this);
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        WifiManager r0 = this.mWifiManager;
        if (r2 == false) goto L5;
        int r3 = 2;
    L6:
        r0.setStaConcurrencyForMultiInternetMode(r3);
        TrackerEventUpload.switchEvent("multi_wifi", r2);
        return;
    L5:
        r3 = 0;
        goto L6
    }
}
