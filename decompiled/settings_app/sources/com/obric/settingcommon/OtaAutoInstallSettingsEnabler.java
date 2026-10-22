package com.obric.settingcommon;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class OtaAutoInstallSettingsEnabler extends SettingsEnabler {
    private static final String AUTO_ACTION = "com.obric.updater.action.WRITING_AUTO";
    private static final String PARAM = "param";
    private static final String SETTINGS_GLOBAL_AUTO_UPDATE = "ota_enable_auto_download";

    public OtaAutoInstallSettingsEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        updateView();
    }

    private boolean isAutoSwitch() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_AUTO_UPDATE, 0) == 0) goto L6;
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
        Intent r0 = new Intent(AUTO_ACTION);
        r0.setPackage("com.obric.updater");
        r0.putExtra("param", r3);
        this.mContext.sendBroadcast(r0);
    }
}
