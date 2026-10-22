package com.bytedance.android.standard.tools.storage;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String TAG = "StorageUtils";

    private StorageUtils() {
    }

    public static File getCacheDirectory(Context r1) {
        return getCacheDirectory(r1, true);
    }

    public static File getCacheDirectory(Context r1, boolean r2) {
        String r0 = Environment.getExternalStorageState();     // Catch: NullPointerException -> L4
    L5:
        if (r2 == true) goto L7;
    L11:
        File r3 = null;
    L12:
        if (r3 != null) goto L14;
        r3 = r1.getCacheDir();
    L14:
        if (r3 != null) goto L19;
        String r4 = "/data/data/" + r1.getPackageName() + "/cache/";
        Log.w("StorageUtils", String.format("Can't define system cache directory! '%s' will be used.", new Object[]{r4}));
        return new File(r4);
    L19:
        return r3;
    L7:
        if ("mounted".equals(r0) == false) goto L11;
        if (hasExternalStoragePermission(r1) == false) goto L11;
        r3 = getExternalCacheDir(r1);
    L4:
        r0 = "";
        goto L5
    }

    public static File getIndividualCacheDirectory(Context r1, String r2) {
        File r3 = getCacheDirectory(r1);
        File r0 = new File(r3, r2);
        if (r0.exists() == true) goto L8;
        if (r0.mkdir() == true) goto L8;
        return r3;
    L8:
        return r0;
    }

    public static File getOwnCacheDirectory(Context r2, String r3) {
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L5;
    L7:
        File r0 = null;
    L8:
        if (r0 == null) goto L14;
        if (r0.exists() == false) goto L12;
        return r0;
    L12:
        if (r0.mkdirs() == false) goto L14;
        return r0;
    L14:
        return r2.getCacheDir();
    L5:
        if (hasExternalStoragePermission(r2) == false) goto L7;
        r0 = new File(Environment.getExternalStorageDirectory(), r3);
        goto L8
    }

    private static File getExternalCacheDir(Context r4) {
        File r1 = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), r4.getPackageName()), "cache");
        if (r1.exists() == false) goto L5;
    L11:
        return r1;
    L5:
        if (r1.mkdirs() == true) goto L12;
        Log.w("StorageUtils", "Unable to create external cache directory");
        return null;
    L12:
        new File(r1, ".nomedia").createNewFile();     // Catch: IOException -> L10
    L10:
        Log.i("StorageUtils", "Can't create \".nomedia\" file in application external cache directory");
        goto L11
    }

    private static boolean hasExternalStoragePermission(Context r1) {
        if (r1.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
