package com.obric.settingcommon;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import bytedanceos.app.settings.search.SwitchItemValue;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class PowerButtonEndsCallEnabler extends DefaultSettingsEnabler {
    public PowerButtonEndsCallEnabler(Context r1, OSwitch r2, SwitchItemValue r3) {
        super(r1, r2, r3);
    }

    @Override // com.obric.settingcommon.DefaultSettingsEnabler, com.obric.settingcommon.SettingsEnabler
    protected boolean isEnabled() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "incall_power_button_behavior", 1) == 2) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.settingcommon.DefaultSettingsEnabler, com.obric.settingcommon.SettingsEnabler
    protected void setEnabled(boolean r3) {
        ContentResolver r2 = this.mContext.getContentResolver();
        if (r3 == false) goto L5;
        int r0 = 2;
    L6:
        Settings.Secure.putInt(r2, "incall_power_button_behavior", r0);
        TrackerEventUpload.switchEvent("incall_power_button_behavior", r3);
        return;
    L5:
        r0 = 1;
        goto L6
    }
}
