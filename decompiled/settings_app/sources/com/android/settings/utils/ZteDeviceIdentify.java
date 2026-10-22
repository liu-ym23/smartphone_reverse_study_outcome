package com.android.settings.utils;

import android.content.Context;
import com.obric.olog.OLog;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
public class ZteDeviceIdentify {
    private static final String TAG = "ZteDeviceIdentify";

    public ZteDeviceIdentify() {
    }

    public static String getOAID(Context r7) {
        Class<?> r0 = Class.forName("android.app.ZteDeviceIdentifyManager");     // Catch: Throwable -> L4
        Constructor<?> r2 = r0.getDeclaredConstructor(new Class[]{Context.class});     // Catch: Throwable -> L4
        r2.setAccessible(true);     // Catch: Throwable -> L4
        Object r3 = r2.newInstance(new Object[]{r7.getApplicationContext()});     // Catch: Throwable -> L4
        return (String) r0.getMethod("getOAID", new Class[]{Context.class}).invoke(r3, new Object[]{r7});
    L4:
        th = move-exception;
        OLog.e(TAG, "getOAID:", th);
        return null;
    }
}
