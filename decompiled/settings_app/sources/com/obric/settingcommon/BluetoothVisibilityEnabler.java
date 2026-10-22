package com.obric.settingcommon;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.util.Log;
import android.widget.CompoundButton;
import bytedanceos.app.settings.search.SwitchItemValue;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class BluetoothVisibilityEnabler extends SettingsEnabler {
    private BluetoothAdapter mAdapter;

    public BluetoothVisibilityEnabler(Context r2, OSwitch r3) {
        this(r2, r3, null);
    }

    public BluetoothVisibilityEnabler(Context r1, OSwitch r2, SwitchItemValue r3) {
        super(r1, r2, r3);
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r6, boolean r7) {
        super.onCheckedChanged(r6, r7);
        if (r7 == false) goto L5;
        this.mAdapter.getClass().getDeclaredMethod("setScanMode", new Class[]{Integer.TYPE}).invoke(this.mAdapter, new Object[]{23});     // Catch: Exception -> L8
    L6:
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.BLUETOOTH_VISIBILITY, r7);     // Catch: Exception -> L8
        return;
    L5:
        this.mAdapter.getClass().getDeclaredMethod("setScanMode", new Class[]{Integer.TYPE}).invoke(this.mAdapter, new Object[]{21});     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.e("BluetoothVisibilityEnabler", "onCheckedChanged error!\n", e);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected boolean isEnabled() {
        if (this.mAdapter.getScanMode() != 23) goto L5;
        return true;
    L5:
        return false;
    }
}
