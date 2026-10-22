package com.obric.settingcommon;

import android.content.Context;
import android.provider.Settings;
import android.widget.CompoundButton;
import bytedanceos.app.settings.search.SwitchItemValue;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultSettingsEnabler extends SettingsEnabler {
    public DefaultSettingsEnabler(Context r1, OSwitch r2, SwitchItemValue r3, boolean r4) {
        super(r1, r2, r3);
        setOpposite(r4);
        updateView();
    }

    public DefaultSettingsEnabler(Context r2, OSwitch r3, SwitchItemValue r4) {
        this(r2, r3, r4, false);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        super.onCheckedChanged(r1, r2);
        setEnabled(r2);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mSwitch.setChecked(isEnabled());
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected boolean isEnabled() {
        if (SettingsSwitchKeyUtil.SettingTable.Global.equals(this.mSwitchItemValue.mTable) == false) goto L6;
        int r0 = Settings.Global.getInt(this.mContext.getContentResolver(), this.mSwitchItemValue.mKey, this.mSwitchItemValue.mDefValue);
    L10:
        if (this.mOpposite == true) goto L15;
        if (r0 == 0) goto L14;
        return true;
    L14:
        return false;
    L15:
        if (r0 != 0) goto L18;
        return true;
    L18:
        return false;
    L6:
        if ("secure".equals(this.mSwitchItemValue.mTable) == false) goto L8;
        r0 = Settings.Secure.getInt(this.mContext.getContentResolver(), this.mSwitchItemValue.mKey, this.mSwitchItemValue.mDefValue);
        goto L10
    L8:
        r0 = Settings.System.getInt(this.mContext.getContentResolver(), this.mSwitchItemValue.mKey, this.mSwitchItemValue.mDefValue);
        goto L10
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void setEnabled(boolean r4) {
        int r1 = 0;
        if (this.mOpposite == true) goto L6;
        if (r4 == false) goto L10;
    L8:
        r1 = 1;
    L10:
        if (SettingsSwitchKeyUtil.SettingTable.Global.equals(this.mSwitchItemValue.mTable) == false) goto L13;
        Settings.Global.putInt(this.mContext.getContentResolver(), this.mSwitchItemValue.mKey, r1);
    L17:
        if (this.mSearchResultItem == null) goto L20;
        TrackerEventUpload.switchEvent(this.mSwitchItemValue.mKey, r4);
        return;
    L20:
        return;
    L13:
        if ("secure".equals(this.mSwitchItemValue.mTable) == false) goto L15;
        Settings.Secure.putInt(this.mContext.getContentResolver(), this.mSwitchItemValue.mKey, r1);
        goto L17
    L15:
        Settings.System.putInt(this.mContext.getContentResolver(), this.mSwitchItemValue.mKey, r1);
        goto L17
    L6:
        if (r4 == false) goto L8;
        goto L8
    }
}
