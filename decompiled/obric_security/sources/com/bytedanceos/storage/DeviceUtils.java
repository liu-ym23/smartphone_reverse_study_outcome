package com.bytedanceos.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.StatFs;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.text.format.Formatter;
import bytedanceos.api.StorageManagerSmt;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceUtils {
    private static final String TAG = "DeviceUtils";
    private static int VERSION_MOL_6_6_6 = 680;

    static {
    }

    public DeviceUtils() {
    }

    public static boolean beforeMol6_6_6() {
        if (getVersionNum() >= VERSION_MOL_6_6_6) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSupportSd() {
        if (SystemProperties.getInt("ro.storage.exsdcard", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isSdMounted() {
        if (isSupportSd() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(StorageManagerSmt.getExternalSdcardPath()) == true) goto L7;
        return true;
    }

    public static int getVersionNum() {
        String r1 = SystemProperties.get("ro.os.ota.version", null);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return 0;
    L6:
        String[] r2 = r1.split("-");     // Catch: Exception -> L21
        if (r2 != null) goto L9;
        return 0;
    L9:
        if (r2.length < 1) goto L27;
        String r3 = r2[0];     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r3) == false) goto L14;
        return 0;
    L14:
        String[] r4 = r3.split("_");     // Catch: Exception -> L21
        if (r4 != null) goto L17;
        return 0;
    L17:
        if (r4.length < 1) goto L29;
        return Integer.parseInt(r4[0].replaceAll("\\.", ""));
    L29:
        return 0;
    L27:
        return 0;
    L21:
        e = move-exception;
        OLog.d(TAG, "getVersionNum exception ex=" + e);
        return 0;
    }

    public static long getTotalSize(File file) {
        if (file != null) goto L5;
    L11:
        return 0;
    L5:
        if (file.exists() == false) goto L11;
        return new StatFs(file.getPath()).getTotalBytes();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static long getAvailableSize(File file) {
        if (file != null) goto L5;
    L11:
        return 0;
    L5:
        if (file.exists() == false) goto L11;
        return new StatFs(file.getPath()).getAvailableBytes();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static String formatSize(Context context, long size) {
        return Formatter.formatFileSize(context, size);
    }

    public static void startActivity(Intent intent, Activity activity) {
        startActivity(intent, activity, -1);
    }

    public static void startActivity(Intent intent, Activity activity, int requestCode) {
        if (intent == null) goto L10;
        if (activity == null) goto L11;
        if (requestCode <= 0) goto L7;
        activity.startActivityForResult(intent, requestCode);
    L8:
        TransitionAnimHelper.overrideEnterAnim(activity, TransitionAnimStyle.Standard);
        return;
    L7:
        activity.startActivity(intent);
        goto L8
    L11:
        return;
    }

    public static long getDirectorySize(String path) {
        return getDirectorySize(new File(path));
    }

    public static long getDirectorySize(File file) {
        long r1 = 0;
        if (file.exists() == true) goto L6;
        return 0;
    L6:
        if (file.isDirectory() == false) goto L25;
        DirectoryStream<Path> r5 = Files.newDirectoryStream(file.toPath());     // Catch: Throwable -> L26
        Iterator<Path> r0 = r5.iterator();     // Catch: Throwable -> L16
    L10:
        if (r0.hasNext() == false) goto L13;
        r1 = r1 + getDirectorySize(r0.next().toFile());
        goto L10
    L13:
        if (r5 == null) goto L23;
        r5.close();     // Catch: Throwable -> L26 Throwable -> L26 Throwable -> L26
    L16:
        th = move-exception;
        if (r5 != null) goto L30;
    L22:
        throw th;     // Catch: Throwable -> L26 Throwable -> L26 Throwable -> L26
    L30:
        r5.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L26 Throwable -> L26 Throwable -> L26
    L23:
        return r1;
    L25:
        return file.length();
    }

    public static String formatBytes(Resources res, long sizeBytes) {
        if (sizeBytes >= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        sizeBytes = -sizeBytes;
    L8:
        float r13 = sizeBytes;
        if (r13 <= 900.0f) goto L11;
        r13 = r13 / 1024.0f;
        int r3 = R.string.kilobyteShort;
        long r9 = 1024;
    L13:
        if (r13 <= 900.0f) goto L16;
        r9 = r9 * 1024;
        r13 = r13 / 1024.0f;
        r3 = R.string.megabyteShort;
    L16:
        if (r13 <= 900.0f) goto L19;
        r9 = r9 * 1024;
        r13 = r13 / 1024.0f;
        r3 = R.string.gigabyteShort;
    L19:
        if (r13 <= 900.0f) goto L22;
        r9 = r9 * 1024;
        r13 = r13 / 1024.0f;
        r3 = R.string.terabyteShort;
    L22:
        if (r13 <= 900.0f) goto L24;
        r9 = r9 * 1024;
        r13 = r13 / 1024.0f;
        r3 = R.string.petabyteShort;
    L24:
        String r4 = "%.0f";
        if (r9 != 1) goto L27;
    L35:
        if (r0 == false) goto L38;
        r13 = -r13;
    L38:
        return String.format(r4, new Object[]{Float.valueOf(r13)}) + " " + res.getString(r3);
    L27:
        if (r13 >= 100.0f) goto L35;
        if (r13 >= 1.0f) goto L33;
        r4 = "%.2f";
        goto L35
    L33:
        if (r13 >= 10.0f) goto L35;
        r4 = "%.1f";
        goto L35
    L11:
        r3 = R.string.byteShort;
        r9 = 1;
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}
