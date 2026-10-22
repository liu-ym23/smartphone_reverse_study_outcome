package com.obric.settingcommon;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class AirplaneModeEnablerSearch extends SettingsEnabler {
    private ContentObserver mObserver;

    public AirplaneModeEnablerSearch(Context r1, OSwitch r2) {
        super(r1, r2);
        final Handler r3 = null;
        this.mObserver = new AnonymousClass1(this, r3);
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mSwitch.setChecked(isAirplaneModeOn(this.mContext));
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        super.onCheckedChanged(r2, r3);
        if (Boolean.parseBoolean(SystemProperties.get("ril.cdma.inecmmode")) == true) goto L16;
        if (r3 == true) goto L7;
    L13:
        setAirplaneModeOn(r3);
        return;
    L7:
        if (isWirelessBostonOn() == false) goto L9;
    L12:
        showTntExitConfirmDialog(r3, null, this.mContext.getString(R.string.airplane_mode));
        return;
    L9:
        if (isMiracastOn() == true) goto L12;
        if (isLeboConnected() == false) goto L13;
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    public void doConfirm(boolean r1) {
        super.doConfirm(r1);
        setAirplaneModeOn(r1);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    public void onTntConfirmDialogDismiss() {
        super.onTntConfirmDialogDismiss();
        this.mContext.getContentResolver().unregisterContentObserver(this.mObserver);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    public void onTntConfirmDialogShow() {
        super.onTntConfirmDialogShow();
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("airplane_mode_on"), true, this.mObserver);
    }

    public static boolean isAirplaneModeOn(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setAirplaneModeOn(boolean r4) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "airplane_mode_on", r4 ? 1 : 0);
        Intent r0 = new Intent("android.intent.action.AIRPLANE_MODE");
        r0.putExtra("state", r4);
        this.mContext.sendBroadcastAsUser(r0, UserHandle.ALL);
        TrackerEventUpload.switchEvent("airplane_mode_on", r4);
    }
}
