package com.obric.settingcommon;

import android.content.Context;
import android.os.UserHandle;
import android.widget.CompoundButton;
import bytedanceos.app.settings.search.SettingsEnableUtils;
import bytedanceos.app.settings.search.SwitchItemValue;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class PasswordRequirementEnabler extends DefaultSettingsEnabler {
    public PasswordRequirementEnabler(Context r1, OSwitch r2, SwitchItemValue r3) {
        super(r1, r2, r3);
    }

    public PasswordRequirementEnabler(Context r1, OSwitch r2, SwitchItemValue r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.obric.settingcommon.DefaultSettingsEnabler, com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        Context r5 = r3.getContext();
        boolean r0 = getLockPatternUtils().isSecure(UserHandle.myUserId());
        if (sHasConfirm == true) goto L7;
        if (r0 == false) goto L7;
        SettingsEnableUtils.launchConfirmPassword(r5, this.mSearchResultItem);
        return;
    L7:
        setEnabled(r4);
    }

    @Override // com.obric.settingcommon.DefaultSettingsEnabler, com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        if (this.mSwitch == null) goto L6;
        super.updateView();
        return;
    }
}
