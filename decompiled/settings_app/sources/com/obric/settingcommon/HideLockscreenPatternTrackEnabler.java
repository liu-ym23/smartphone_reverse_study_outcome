package com.obric.settingcommon;

import android.content.Context;
import android.widget.CompoundButton;
import bytedanceos.app.settings.search.SettingsEnableUtils;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class HideLockscreenPatternTrackEnabler extends SettingsEnabler {
    public HideLockscreenPatternTrackEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        super.onCheckedChanged(r3, r4);
        Context r5 = r3.getContext();
        boolean r0 = LockPatternUtilsApi.isSecure(getLockPatternUtils());
        if (SettingsEnabler.sHasConfirm == true) goto L7;
        if (r0 == false) goto L7;
        SettingsEnableUtils.launchConfirmPassword(r5, this.mSearchResultItem);
        return;
    L7:
        LockPatternUtilsApi.setVisiblePatternEnabled(getLockPatternUtils(), !r4);
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.HIDE_LOCK_PATTERN_TRACK, r4);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected boolean isEnabled() {
        return !LockPatternUtilsApi.isVisiblePatternEnabled(getLockPatternUtils());
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void setEnabled(boolean r2) {
        LockPatternUtilsApi.setVisiblePatternEnabled(getLockPatternUtils(), !r2);
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.HIDE_LOCK_PATTERN_TRACK, r2);
    }
}
