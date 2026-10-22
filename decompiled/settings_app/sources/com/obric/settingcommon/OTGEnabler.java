package com.obric.settingcommon;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class OTGEnabler extends SettingsEnabler {
    public static final String OTG_FUNC_SWITCH_DISABLE = "otg_current_state";
    public static final String OTG_STATE = "otg_settings_state";
    public static final int OTG_STATE_CLOSE_AND_DISABLE = 3;
    public static final int OTG_STATE_CLOSE_AND_ENABLE = 0;
    public static final int OTG_STATE_OPEN_AND_DISABLE = 2;
    public static final int OTG_STATE_OPEN_AND_ENABLE = 1;

    static /* synthetic */ int access$000(OTGEnabler r0) {
        return r0.getOTGEnabled();
    }

    static /* synthetic */ void access$100(OTGEnabler r0, int r1) {
        r0.updateOTAView(r1);
    }

    static /* synthetic */ void access$200(OTGEnabler r0, int r1) {
        r0.setOTGState(r1);
    }

    public OTGEnabler(Context r2, OSwitch r3) {
        super(r2, r3);
        updateView();
        final Handler r0 = new Handler();
        ContentObserver r4 = new AnonymousClass1(this, r0);
        r2.getContentResolver().registerContentObserver(Settings.Global.getUriFor("otg_current_state"), true, r4);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        updateOTAView(getOTGEnabled());
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        super.onCheckedChanged(r1, r2);
        setOTGState(r2 ? 1 : 0);
    }

    private int getOTGEnabled() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), "otg_current_state", 0);
    }

    private void setOTGState(int r2) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "otg_settings_state", r2);
        boolean r1 = true;
        if (r2 == 1) goto L6;
        r1 = false;
    L6:
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.OTG, r1);
    }

    private void updateOTAView(int r4) {
        if (r4 == 0) goto L13;
        if (r4 != 1) goto L6;
        this.mSwitch.setEnabled(true);
        this.mSwitch.setChecked(true);
        return;
    L6:
        if (r4 != 2) goto L8;
        this.mSwitch.setEnabled(false);
        this.mSwitch.setChecked(true);
        return;
    L8:
        if (r4 != 3) goto L18;
        this.mSwitch.setEnabled(false);
        this.mSwitch.setChecked(false);
        return;
    L18:
        return;
    L13:
        this.mSwitch.setEnabled(true);
        this.mSwitch.setChecked(false);
    }
}
