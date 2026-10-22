package com.bytedance.common.utility.android;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class ManifestData {
    public ManifestData() {
    }

    private static Object readKey(Context r3, String r4) {
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getPackageManager().getApplicationInfo(r3.getPackageName(), 128).metaData.get(r4);
    L7:
        return null;
    }

    public static String getString(Context r0, String r1) {
        Object r2 = readKey(r0, r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) r2;
    }

    public static int getInt(Context r0, String r1) {
        Object r2 = readKey(r0, r1);
        if (r2 != null) goto L6;
        return -1;
    L6:
        return ((Integer) r2).intValue();
    }

    public static Boolean getBoolean(Context r0, String r1) {
        Object r2 = readKey(r0, r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Boolean) r2;
    }

    public static Object get(Context r0, String r1) {
        return readKey(r0, r1);
    }
}
