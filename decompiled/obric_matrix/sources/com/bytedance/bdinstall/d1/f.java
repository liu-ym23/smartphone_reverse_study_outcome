package com.bytedance.bdinstall.d1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class f {
    @SuppressLint({"HardwareIds"})
    public static String a(Context r1) {
        return Settings.Secure.getString(r1.getContentResolver(), "android_id");
    L4:
        return null;
    }
}
