package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ttnet.org.chromium.net.TTNetVersion;
import java.util.Locale;
import org.apache.commons.io.IOUtils;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
public final class UserAgent {
    private static final int VERSION_CODE_UNINITIALIZED = 0;
    private static final Object sLock = null;
    private static int sVersionCode;

    static {
        sLock = new Object();
    }

    private UserAgent() {
    }

    public static String from(Context r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.getPackageName());
        r0.append(IOUtils.DIR_SEPARATOR_UNIX);
        r0.append(versionFromContext(r3));
        r0.append(" (Linux; U; Android ");
        r0.append(Build.VERSION.RELEASE);
        r0.append(VectorFormat.DEFAULT_SEPARATOR);
        r0.append(Locale.getDefault().toString());
        String r1 = Build.MODEL;
        if (r1.length() <= 0) goto L5;
        r0.append(VectorFormat.DEFAULT_SEPARATOR);
        r0.append(r1);
    L5:
        String r4 = Build.ID;
        if (r4.length() <= 0) goto L8;
        r0.append("; Build/");
        r0.append(r4);
    L8:
        r0.append(";");
        appendCronetVersion(r0);
        r0.append(')');
        return r0.toString();
    }

    static String getQuicUserAgentIdFrom(Context r1) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r1.getPackageName());
        appendCronetVersion(r0);
        return r0.toString();
    }

    private static int versionFromContext(Context r3) {
        Object r0 = sLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sVersionCode == 0) goto L16;
    L9:
        int r4 = sVersionCode;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L16:
        sVersionCode = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }

    private static void appendCronetVersion(StringBuilder r1) {
        r1.append(" Cronet/");
        r1.append(TTNetVersion.VERSION);
    }
}
