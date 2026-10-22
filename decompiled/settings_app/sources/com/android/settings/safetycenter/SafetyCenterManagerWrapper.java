package com.android.settings.safetycenter;

import android.content.Context;
import android.safetycenter.SafetyCenterManager;
import android.safetycenter.SafetyEvent;
import android.safetycenter.SafetySourceData;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class SafetyCenterManagerWrapper {
    private static final String TAG = "SafetyCenterManagerWrap";
    public static SafetyCenterManagerWrapper sInstance;

    private SafetyCenterManagerWrapper() {
    }

    public static SafetyCenterManagerWrapper get() {
        if (sInstance != null) goto L6;
        sInstance = new SafetyCenterManagerWrapper();
    L6:
        return sInstance;
    }

    public void setSafetySourceData(Context r1, String r2, SafetySourceData r3, SafetyEvent r4) {
        SafetyCenterManager r0 = (SafetyCenterManager) r1.getSystemService(SafetyCenterManager.class);
        if (r0 != null) goto L11;
        OLog.e(TAG, "System service SAFETY_CENTER_SERVICE (SafetyCenterManager) is null");
        return;
    L11:
        r0.setSafetySourceData(r2, r3, r4);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        OLog.e(TAG, "Failed to send SafetySourceData", e);
    }

    public boolean isEnabled(Context r3) {
        if (r3 != null) goto L6;
        OLog.e(TAG, "Context is null at SafetyCenterManagerWrapper#isEnabled");
        return false;
    L6:
        SafetyCenterManager r4 = (SafetyCenterManager) r3.getSystemService(SafetyCenterManager.class);
        if (r4 != null) goto L15;
        OLog.w(TAG, "System service SAFETY_CENTER_SERVICE (SafetyCenterManager) is null");
        return false;
    L15:
        return r4.isSafetyCenterEnabled();
    L12:
        e = move-exception;
        OLog.e(TAG, "Calling isSafetyCenterEnabled failed.", e);
        return false;
    }
}
