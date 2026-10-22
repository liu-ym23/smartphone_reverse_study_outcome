package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: classes4.dex */
public final class ManifestUtils {
    public ManifestUtils() {
    }

    public static boolean isServiceSingleUser(Context r4, Class<?> r5) {
        ServiceInfo r6 = r4.getPackageManager().getServiceInfo(new ComponentName(r4, r5), 0);     // Catch: Throwable -> L13
        int r7 = ServiceInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: NoSuchFieldException -> L7 Throwable -> L13 Throwable -> L13
    L8:
        if ((r6.flags & r7) == 0) goto L18;
        return true;
    L18:
        return false;
    L7:
        r7 = ComponentInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: Throwable -> L13 Throwable -> L13
    L19:
        return false;
    }
}
