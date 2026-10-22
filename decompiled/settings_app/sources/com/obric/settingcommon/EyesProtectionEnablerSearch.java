package com.obric.settingcommon;

import android.content.Context;
import android.hardware.display.ColorDisplayManager;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class EyesProtectionEnablerSearch extends SettingsEnabler {
    private ColorDisplayManager mColorDisplayManager;

    public EyesProtectionEnablerSearch(Context r1, OSwitch r2) {
        super(r1, r2);
        this.mContext = r1;
        this.mColorDisplayManager = (ColorDisplayManager) r1.getSystemService(ColorDisplayManager.class);
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        boolean r0 = this.mColorDisplayManager.isNightDisplayActivated();
        this.mSwitch.setChecked(r0);
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        super.onCheckedChanged(r1, r2);
        this.mColorDisplayManager.setNightDisplayActivated(r2);
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.EYES_PROTECTION_ENABLE, r2);
    }
}
