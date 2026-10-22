package com.obric.settingcommon;

import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.view.IWindowManager;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public final class AutoRotationEnablerSearch extends SettingsEnabler {
    public AutoRotationEnablerSearch(Context r1, OSwitch r2) {
        super(r1, r2);
        this.mContext = r1;
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        boolean r2 = false;
        if (Settings.System.getInt(this.mContext.getContentResolver(), "accelerometer_rotation", 0) == 0) goto L5;
        r2 = true;
    L5:
        this.mSwitch.setChecked(r2);
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    public void setAutoRotation(boolean r2) {
        IWindowManager r0 = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));     // Catch: RemoteException -> L7
        if (r2 == false) goto L5;
        r0.thawRotation(this.mContext.getPackageName());     // Catch: RemoteException -> L7
    L8:
        return;
    L5:
        r0.freezeRotation(0, this.mContext.getPackageName());     // Catch: RemoteException -> L7
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        super.onCheckedChanged(r1, r2);
        setAutoRotation(r2);
        TrackerEventUpload.switchEvent("rotation", r2);
    }
}
