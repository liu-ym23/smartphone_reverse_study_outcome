package com.obric.settingcommon;

import android.content.Context;
import android.widget.CompoundButton;
import bytedanceos.app.settings.search.SettingsEnableUtils;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class HideLockscreenPatternTrackEnablerClient extends SettingsEnablerClient {
    public HideLockscreenPatternTrackEnablerClient(Context r1, OSwitch r2, String r3) {
        super(r1, r2, r3);
    }

    @Override // com.obric.settingcommon.SettingsEnablerClient, com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        Context r0 = r4.getContext();
        boolean r1 = LockPatternUtilsApi.isSecure(getLockPatternUtils());
        if (SettingsEnabler.sHasConfirm == true) goto L7;
        if (r1 == false) goto L7;
        SettingsEnableUtils.launchConfirmPassword(r0, this.mSearchResultItem);
        return;
    L7:
        super.onCheckedChanged(r4, r5);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected boolean isEnabled() {
        SearchService.getInstance(this.mContext);
        return SearchService.isSettingsEnabled(this.mKey);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void setEnabled(boolean r2) {
        SearchService.getInstance(this.mContext);
        SearchService.setSettingsEnabled(this.mKey, r2);
        TrackerEventUpload.switchEvent(this.mKey, r2);
    }
}
