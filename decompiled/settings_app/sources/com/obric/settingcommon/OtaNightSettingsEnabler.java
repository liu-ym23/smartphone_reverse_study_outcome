package com.obric.settingcommon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class OtaNightSettingsEnabler extends SettingsEnabler {
    private static final String NIGHT_ACTION = "com.obric.updater.action.WRITING_NIGHT";
    private static final String PARAM = "param";
    private static final String SETTINGS_GLOBAL_NIGHT_REBOOT = "ota_enable_night_reboot";

    public OtaNightSettingsEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
    }

    private boolean isAutoSwitch() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_NIGHT_REBOOT, 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        updateAutoSwitch();
    }

    private void updateAutoSwitch() {
        super.updateView();
        boolean r0 = isAutoSwitch();
        this.mSwitch.setChecked(r0);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        super.onCheckedChanged(r1, r2);
        setSettingsGlobalAutoUpdate(r2);
    }

    private void setSettingsGlobalAutoUpdate(boolean r3) {
        new Bundle().putBoolean("param", r3);
        Intent r4 = new Intent(NIGHT_ACTION);
        r4.setPackage("com.obric.updater");
        this.mContext.sendBroadcast(r4);
    }
}
