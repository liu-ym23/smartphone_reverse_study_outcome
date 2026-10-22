package com.obric.settingcommon;

import android.content.Context;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class SettingsEnablerClient extends SettingsEnabler {
    protected final String mKey;

    public SettingsEnablerClient(Context r1, OSwitch r2, String r3) {
        super(r1, r2);
        this.mKey = r3;
        updateView();
        setObserverAndReceiver();
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        SearchService.getInstance(this.mContext);
        SearchService.setSettingsEnabled(this.mKey, r2);
        TrackerEventUpload.switchEvent(this.mKey, r2);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    public void updateView() {
        if (this.mSwitch != null) goto L5;
        return;
    L5:
        this.mSwitch.setOnCheckedChangeListener(null);
        SearchService.getInstance(this.mContext);
        boolean r0 = SearchService.isSettingsEnabled(this.mKey);
        this.mSwitch.setChecked(r0);
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    public void setObserverAndReceiver() {
        SearchService.getInstance(this.mContext);
        SearchService.setOnUpdateViewListener(this.mKey, new AnonymousClass1(this));
    }
}
