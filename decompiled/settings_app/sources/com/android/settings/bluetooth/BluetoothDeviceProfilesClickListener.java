package com.android.settings.bluetooth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothDeviceProfilesClickListener implements View.OnClickListener {
    private static final String TAG = "com.android.settings.bluetooth.BluetoothDeviceProfilesClickListener";
    private int extraBackBtnTextRes;

    static {
    }

    public BluetoothDeviceProfilesClickListener(int r1) {
        this.extraBackBtnTextRes = r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if ((r5.getTag() instanceof CachedBluetoothDevice) == false) goto L5;
        CachedBluetoothDevice r0 = (CachedBluetoothDevice) r5.getTag();
        OLog.i(TAG, "onClick() called for CachedBluetoothDevice: " + r0.getName());
        Bundle r1 = new Bundle(1);
        r1.putParcelable("device", r0.getDevice());
        Context r6 = r5.getContext();
        Intent r2 = new Intent(r6, DeviceProfilesSettingsSmtActivity.class);
        r2.putExtra("device", r1);
        r2.putExtra("back_text_id", this.extraBackBtnTextRes);
        com.android.settings.Utils.startActivity(r6, r2);
        return;
    L5:
        OLog.w(TAG, "onClick() called for other View: " + r5);
    }
}
