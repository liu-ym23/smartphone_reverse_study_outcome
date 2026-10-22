package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import com.android.internal.widget.LockPatternUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CryptKeeperHelper {
    private DevicePolicyManager dpm;

    public CryptKeeperHelper(Context r2) {
        this.dpm = (DevicePolicyManager) r2.getSystemService("device_policy");
    }

    public boolean isDeviceEncrypted() {
        return LockPatternUtils.isDeviceEncryptionEnabled();
    }
}
