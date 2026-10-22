package com.obric.settingcommon;

import android.content.Context;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.widget.CompoundButton;
import com.android.settings.MultiSimAdapter;
import com.obric.oui.oswitch.OSwitch;
import java.lang.reflect.Method;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class PhoneMobileDataEnabler extends SettingsEnabler {
    public PhoneMobileDataEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        if (getDataState(this.mContext) == true) goto L5;
    L9:
        this.mSwitch.setChecked(false);
    L10:
        this.mSwitch.setOnCheckedChangeListener(this);
        this.mSwitch.setEnabled(!isAirplaneModeOn(this.mContext));
        return;
    L5:
        if (isSimExists(this.mContext) == false) goto L9;
        if (isAirplaneModeOn(this.mContext) == true) goto L9;
        this.mSwitch.setChecked(true);
        goto L10
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r6, boolean r7) {
        super.onCheckedChanged(r6, r7);
        TelephonyManager r5 = (TelephonyManager) this.mContext.getSystemService(MultiSimAdapter.PHONE_KEY);     // Catch: Exception -> L5
        Method r8 = ReflectionUtils.getMethod("android.telephony.TelephonyManager", "setDataEnabled", new Class[]{Boolean.TYPE});     // Catch: Exception -> L5
        r8.setAccessible(true);     // Catch: Exception -> L5
        r8.invoke(r5, new Object[]{Boolean.valueOf(r7)});     // Catch: Exception -> L5
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.PHONE_MOBILE_DATA_SWITCH, r7);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean getDataState(Context r1) {
        return ((ConnectivityManager) r1.getSystemService("connectivity")).getMobileDataEnabled();
    }

    public static boolean isAirplaneModeOn(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isSimExists(Context r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (((TelephonyManager) r2.getSystemService(MultiSimAdapter.PHONE_KEY)).getSimState() != 5) goto L9;
        return true;
    L9:
        return false;
    }
}
