package com.obric.settingcommon;

import android.content.Context;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.android.settings.intelligent.GlobalAssistantFragment;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class ClickWakeScreenEnabler extends SettingsEnabler {
    public ClickWakeScreenEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setChecked(isClickWakeScreenEnable());
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        super.onCheckedChanged(r1, r2);
        setClickWakeScreen(r2);
    }

    private boolean isClickWakeScreenEnable() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "click_enable_screen_on", 0) == 1) goto L5;
        return false;
    L5:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), GlobalAssistantFragment.DOUBLECLICK_ENABLE_ASSIST_ON, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setClickWakeScreen(boolean r3) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "click_enable_screen_on", r3 ? 1 : 0);
        Settings.Global.putInt(this.mContext.getContentResolver(), GlobalAssistantFragment.DOUBLECLICK_ENABLE_ASSIST_ON, r3 ? 1 : 0);
    }
}
