package com.obric.settingcommon;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class NetworkAvoidBadWifiEnabler extends SettingsEnabler {
    public NetworkAvoidBadWifiEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        String r0 = Settings.Global.getString(this.mContext.getContentResolver(), SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI);
        this.mSwitch.setChecked("1".equals(r0));
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        super.onCheckedChanged(r2, r3);
        ContentResolver r1 = this.mContext.getContentResolver();
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        Settings.Global.putString(r1, SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI, r4);
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI, r3);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
