package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.StrictMode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace("base::android")
@MainDex
public class SysUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANDROID_LOW_MEMORY_DEVICE_THRESHOLD_MB = 512;
    private static final int ANDROID_O_LOW_MEMORY_DEVICE_THRESHOLD_MB = 1024;
    private static final int BYTES_PER_GIGABYTE = 1073741824;
    private static final long HIGH_END_DEVICE_DISK_CAPACITY_GB = 24;
    private static final String TAG = "SysUtils";
    private static Integer sAmountOfPhysicalMemoryKB;
    private static Boolean sHighEndDiskDevice;
    private static Boolean sLowEndDevice;

    interface Natives {
        void logPageFaultCountToTracing();
    }

    static {
    }

    private SysUtils() {
    }

    private static int detectAmountOfPhysicalMemoryKB() {
        Pattern r1 = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy r2 = StrictMode.allowThreadDiskReads();
        FileReader r3 = new FileReader("/proc/meminfo");     // Catch: Throwable -> L27 Exception -> L29
        BufferedReader r4 = new BufferedReader(r3);     // Catch: Throwable -> L24
    L36:
        String r5 = r4.readLine();     // Catch: Throwable -> L21
        if (r5 == null) goto L7;
        Matcher r6 = r1.matcher(r5);     // Catch: Throwable -> L21
        if (r6.find() == false) goto L36;
        int r7 = Integer.parseInt(r6.group(1));     // Catch: Throwable -> L21
        if (r7 > 1024) goto L17;
        android.util.Log.w(TAG, "Invalid /proc/meminfo total size in kB: " + r6.group(1));     // Catch: Throwable -> L21
    L14:
        r4.close();     // Catch: Throwable -> L24
        r3.close();     // Catch: Throwable -> L27 Exception -> L29
    L31:
        StrictMode.setThreadPolicy(r2);
        return 0;
    L17:
        r4.close();     // Catch: Throwable -> L24
        r3.close();     // Catch: Throwable -> L27 Exception -> L29
        StrictMode.setThreadPolicy(r2);
        return r7;
    L7:
        android.util.Log.w(TAG, "/proc/meminfo lacks a MemTotal entry?");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L27 Exception -> L29
        throw th;     // Catch: Throwable -> L27 Exception -> L29
    L27:
        th = move-exception;
        StrictMode.setThreadPolicy(r2);
        throw th;
    L29:
        e = move-exception;
        android.util.Log.w(TAG, "Cannot get total physical size from /proc/meminfo", e);     // Catch: Throwable -> L27
        goto L31
    }

    public static boolean isLowEndDevice() {
        if (sLowEndDevice != null) goto L6;
        sLowEndDevice = Boolean.valueOf(detectLowEndDevice());
    L6:
        return sLowEndDevice.booleanValue();
    }

    public static int amountOfPhysicalMemoryKB() {
        if (sAmountOfPhysicalMemoryKB != null) goto L6;
        sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
    L6:
        return sAmountOfPhysicalMemoryKB.intValue();
    }

    public static boolean isCurrentlyLowMemory() {
        ActivityManager r0 = (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r0.getMemoryInfo(r1);
        return r1.lowMemory;
    }

    public static void resetForTesting() {
        sLowEndDevice = null;
        sAmountOfPhysicalMemoryKB = null;
    }

    public static boolean hasCamera(Context r1) {
        PackageManager r2 = r1.getPackageManager();
        if (r2.hasSystemFeature("android.hardware.camera") == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.hasSystemFeature("android.hardware.camera.any") == true) goto L8;
        return false;
    }

    private static boolean detectLowEndDevice() {
        boolean r1 = true;
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_LOW_END_DEVICE_MODE) == false) goto L6;
        return true;
    L6:
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.DISABLE_LOW_END_DEVICE_MODE) == false) goto L8;
        return false;
    L8:
        Integer r0 = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
        sAmountOfPhysicalMemoryKB = r0;
        if (r0.intValue() > 0) goto L12;
    L10:
        boolean r2 = false;
    L15:
        if (ContextUtils.getApplicationContext() == null) goto L17;
        boolean r3 = ((ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity")).isLowRamDevice();
    L18:
        if (r2 == r3) goto L21;
        r1 = false;
    L21:
        RecordHistogram.recordBooleanHistogram("Android.SysUtilsLowEndMatches", r1);
        return r2;
    L17:
        r3 = false;
        goto L18
    L12:
        if ((sAmountOfPhysicalMemoryKB.intValue() / 1024) > 1024) goto L10;
        r2 = true;
        goto L15
    }

    public static void logPageFaultCountToTracing() {
        SysUtilsJni.get().logPageFaultCountToTracing();
    }

    public static boolean isHighEndDiskDevice() {
        if (sHighEndDiskDevice != null) goto L6;
        sHighEndDiskDevice = Boolean.valueOf(detectHighEndDiskDevice());
    L6:
        return sHighEndDiskDevice.booleanValue();
    }

    private static boolean detectHighEndDiskDevice() {
        StrictModeContext r1 = StrictModeContext.allowDiskReads();     // Catch: IllegalArgumentException -> L19
    L6:
        if ((new StatFs(Environment.getDataDirectory().getAbsolutePath()).getTotalBytes() / org.apache.commons.io.FileUtils.ONE_GB) < HIGH_END_DEVICE_DISK_CAPACITY_GB) goto L8;
        boolean r2 = true;
    L9:
        if (r1 == null) goto L11;
        r1.close();     // Catch: IllegalArgumentException -> L19
    L11:
        return r2;
    L8:
        r2 = false;
    L12:
        th = move-exception;
        if (r1 != null) goto L22;
    L18:
        throw th;     // Catch: IllegalArgumentException -> L19
    L22:
        r1.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalArgumentException -> L19
    L19:
        e = move-exception;
        android.util.Log.v(TAG, "Cannot get disk data capacity", e);
        return false;
    }

    public static void setAmountOfPhysicalMemoryKBForTesting(int r0) {
        sAmountOfPhysicalMemoryKB = Integer.valueOf(r0);
    }

    public static boolean isAndroidGo() {
        if (isLowEndDevice() == false) goto L5;
        return true;
    L5:
        return false;
    }
}
