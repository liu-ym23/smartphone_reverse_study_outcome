package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
public final class ApplicationVersionSignature {
    private static final ConcurrentMap<String, Key> PACKAGE_NAME_TO_KEY = null;
    private static final String TAG = "AppVersionSignature";

    static {
        PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();
    }

    public static Key obtain(Context r3) {
        String r0 = r3.getPackageName();
        ConcurrentMap<String, Key> r1 = PACKAGE_NAME_TO_KEY;
        Key r2 = r1.get(r0);
        if (r2 != null) goto L9;
        Key r4 = obtainVersionSignature(r3);
        Key r5 = r1.putIfAbsent(r0, r4);
        if (r5 != null) goto L8;
        return r4;
    L8:
        return r5;
    L9:
        return r2;
    }

    static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }

    private static Key obtainVersionSignature(Context r1) {
        return new ObjectKey(getVersionCode(getPackageInfo(r1)));
    }

    private static String getVersionCode(PackageInfo r0) {
        if (r0 == null) goto L5;
        return String.valueOf(r0.versionCode);
    L5:
        return UUID.randomUUID().toString();
    }

    private static PackageInfo getPackageInfo(Context r3) {
        return r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0);
    L4:
        e = move-exception;
        Log.e(TAG, "Cannot resolve info for" + r3.getPackageName(), e);
        return null;
    }

    private ApplicationVersionSignature() {
    }
}
