package com.obric.settingcommon;

import android.app.UiModeManager;
import android.content.Context;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class AutoDarkModeEnabler extends SettingsEnabler {
    public AutoDarkModeEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        this.mContext = r1;
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        int r0 = ((UiModeManager) this.mContext.getSystemService(UiModeManager.class)).getNightMode();
        if (r0 != 0) goto L5;
    L8:
        boolean r1 = true;
    L9:
        this.mSwitch.setChecked(r1);
        this.mSwitch.setOnCheckedChangeListener(this);
        return;
    L5:
        if (r0 == 3) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        super.onCheckedChanged(r3, r4);
        UiModeManager r5 = (UiModeManager) this.mContext.getSystemService(UiModeManager.class);
        int r0 = r5.getNightMode();
        boolean r1 = false;
        if (r4 == true) goto L5;
        int r2 = 1;
        if ((this.mContext.getResources().getConfiguration().uiMode & 32) == 0) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L13;
        r2 = 2;
    L13:
        r5.setNightMode(r2);
    L14:
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.AUTO_DARK_MODE, r4);
        return;
    L5:
        if (r0 == 3) goto L14;
        if (r0 == 0) goto L14;
        r5.setNightMode(0);
        goto L14
    }
}
