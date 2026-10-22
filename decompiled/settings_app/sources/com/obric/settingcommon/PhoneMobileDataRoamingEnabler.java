package com.obric.settingcommon;

import android.content.Context;
import android.os.ServiceManager;
import android.widget.CompoundButton;
import bytedanceos.util.MultiSimAdapter;
import com.android.internal.telephony.ITelephony;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class PhoneMobileDataRoamingEnabler extends SettingsEnabler {
    public PhoneMobileDataRoamingEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        boolean r0 = isDataRoamingEnabler(this.mContext);
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mSwitch.setChecked(r0);
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        super.onCheckedChanged(r1, r2);
        int r0 = MultiSimAdapter.getDefaultDataSlot();     // Catch: Throwable -> L5
        ITelephony.Stub.asInterface(ServiceManager.checkService(com.android.settings.MultiSimAdapter.PHONE_KEY)).setDataRoamingEnabled(r0, r2);     // Catch: Throwable -> L5
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.PHONE_MOBILE_DATA_ROAMING_SWITCH, r2);     // Catch: Throwable -> L5
        return;
    }

    public static boolean isDataRoamingEnabler(Context r1) {
        int r2 = MultiSimAdapter.getDefaultDataSlot();     // Catch: Throwable -> L4
        return ITelephony.Stub.asInterface(ServiceManager.checkService(com.android.settings.MultiSimAdapter.PHONE_KEY)).isDataRoamingEnabled(r2);
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
