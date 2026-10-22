package com.android.settings.utils;

import android.content.Context;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.service.oemlock.OemLockManager;
import android.system.Os;
import android.system.OsConstants;
import com.obric.olog.OLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class Enable16kUtils {
    static final String DEV_OPTION_PROPERTY = "ro.product.build.16k_page.enabled";
    private static final long PAGE_SIZE = 0;
    private static final int PAGE_SIZE_16KB = 16384;
    private static final String TAG = "Enable16kUtils";

    public static void showPageAgnosticWarning(Context r0) {
    }

    public Enable16kUtils() {
    }

    static {
        PAGE_SIZE = Os.sysconf(OsConstants._SC_PAGESIZE);
    }

    public static boolean isDeviceOEMUnlocked(Context r4) {
        OemLockManager r0 = (OemLockManager) r4.getSystemService(OemLockManager.class);
        UserManager r5 = (UserManager) r4.getSystemService(UserManager.class);
        if (r0 == null) goto L16;
        if (r5 == null) goto L16;
        if (r0.isDeviceOemUnlocked() == true) goto L11;
        OLog.e(TAG, "Device is not OEM unlocked");
        return false;
    L11:
        if (r5.hasBaseUserRestriction("no_factory_reset", UserHandle.of(UserHandle.myUserId())) == false) goto L14;
        OLog.e(TAG, "Factory reset is not allowed for user.");
        return false;
    L14:
        return true;
    L16:
        OLog.e(TAG, "Required services not found on device to check for OEM unlock state.");
        return false;
    }

    public static boolean isDataExt4() {
        BufferedReader r1 = new BufferedReader(new FileReader("/proc/mounts"));     // Catch: IOException -> L20
    L26:
        String r2 = r1.readLine();     // Catch: Throwable -> L14
        if (r2 == null) goto L12;
        OLog.i(TAG, r2);     // Catch: Throwable -> L14
        String[] r3 = r2.split(HanziToPinyin.Token.SEPARATOR);     // Catch: Throwable -> L14
        String r4 = r3[1];     // Catch: Throwable -> L14
        String r5 = r3[2];     // Catch: Throwable -> L14
        if (r4.equals("/data") == false) goto L26;
        if (r5.equals("ext4") == false) goto L26;
        r1.close();     // Catch: IOException -> L20
        return true;
    L12:
        r1.close();     // Catch: IOException -> L20
        return false;
    L14:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        OLog.e(TAG, "Failed to read /proc/mounts");
        return false;
    }

    public static boolean is16KbToggleAvailable() {
        return SystemProperties.getBoolean(DEV_OPTION_PROPERTY, false);
    }

    public static boolean isPageAgnosticModeOn(Context r1) {
        if (is16KbToggleAvailable() == true) goto L5;
    L9:
        return false;
    L5:
        if (isDeviceOEMUnlocked(r1) == false) goto L9;
        if (isDataExt4() == false) goto L9;
        return true;
    }

    public static boolean isUsing16kbPages() {
        if (PAGE_SIZE != 16384) goto L5;
        return true;
    L5:
        return false;
    }
}
