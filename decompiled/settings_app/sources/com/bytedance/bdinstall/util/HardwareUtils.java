package com.bytedance.bdinstall.util;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes3.dex */
public class HardwareUtils {
    public HardwareUtils() {
    }

    public static String getSecureAndroidId(Context r1) {
        return Settings.Secure.getString(r1.getContentResolver(), "android_id");
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
