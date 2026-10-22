package com.obric.settingcommon;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class TimeFormatEnabler extends SettingsEnabler {
    private Context mContext;

    public TimeFormatEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        this.mContext = r1;
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mSwitch.setChecked(isTimeFormat24());
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    private boolean isTimeFormat24() {
        return DateFormat.is24HourFormat(this.mContext);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        setFormat24(r2);
        Intent r3 = new Intent("android.intent.action.TIME_SET");
        this.mContext.sendBroadcast(r3);
    }

    private void setFormat24(boolean r3) {
        ContentResolver r2 = this.mContext.getContentResolver();
        if (r3 == false) goto L5;
        String r0 = "24";
    L6:
        Settings.System.putString(r2, "time_12_24", r0);
        TrackerEventUpload.switchEvent("time_12_24", r3);
        return;
    L5:
        r0 = "12";
        goto L6
    }
}
