package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.os.UserHandle;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class LockPasswordQualityHelper {
    private DevicePolicyManager mDPM;
    private final int mUserId;

    public LockPasswordQualityHelper(Context r2) {
        this(r2, UserHandle.myUserId());
    }

    public LockPasswordQualityHelper(Context r2, int r3) {
        this.mDPM = (DevicePolicyManager) r2.getSystemService("device_policy");
        this.mUserId = r3;
    }

    public int upgradeQuality(int r1) {
        return upgradeQualityForDPM(r1);
    }

    private int upgradeQualityForDPM(int r3) {
        int r2 = this.mDPM.getPasswordQuality(null, this.mUserId);
        OLog.d("LockPassword", "quality:" + r3 + "  dpm minQuality:" + r2);
        if (r3 < r2) goto L5;
        return r3;
    L5:
        return r2;
    }
}
