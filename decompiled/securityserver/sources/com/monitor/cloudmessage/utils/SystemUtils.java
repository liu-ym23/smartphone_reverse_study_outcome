package com.monitor.cloudmessage.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.util.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class SystemUtils {
    public SystemUtils() {
    }

    public static String[] getCpuInfo() {
        String[] r3 = {"", ""};
        BufferedReader r5 = null;
        FileReader r7 = new FileReader("/proc/cpuinfo");     // Catch: Throwable -> L17 IOException -> L19
    L29:
        BufferedReader r1 = new BufferedReader(r7, 8192);     // Catch: Throwable -> L15 IOException -> L24
        String[] r6 = r1.readLine().split("\\s+");     // Catch: Throwable -> L9 IOException -> L11
        int r8 = 2;
    L7:
        if (r8 >= r6.length) goto L12;
        r3[0] = r3[0] + r6[r8] + " ";     // Catch: Throwable -> L9 IOException -> L11
        r8 = r8 + 1;     // Catch: Throwable -> L9 IOException -> L11
        goto L7
    L12:
        r3[1] = r3[1] + r1.readLine().split("\\s+")[2];     // Catch: Throwable -> L9 IOException -> L11
        IOUtils.closeQuietly(r1);
    L14:
        IOUtils.closeQuietly(r7);
        return r3;
    L11:
        r5 = r1;
    L9:
        th = th;
        r5 = r1;
    L20:
        IOUtils.closeQuietly(r5);
        IOUtils.closeQuietly(r7);
        throw th;
    L15:
        th = th;
    L22:
        IOUtils.closeQuietly(r5);
    L19:
        r7 = null;
    L17:
        th = th;
        r7 = null;
        goto L20
    }

    public static long[] getSDCardMemory() {
        long[] r0 = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L8;
        File r1 = com.bytedance.apm.util.FileUtils.getExternalRootDir(ApmContext.getContext());
        if (r1 != null) goto L7;
        return r0;
    L7:
        StatFs r2 = new StatFs(r1.getPath());
        long r3 = r2.getBlockSize();
        long r5 = r2.getBlockCount();
        long r4 = r2.getAvailableBlocks();
        r0[0] = ((r5 * r3) / 1024) / 1024;
        r0[1] = ((r3 * r4) / 1024) / 1024;
    L8:
        return r0;
    }

    public static long getTotalMemory() {
        return (Runtime.getRuntime().maxMemory() / 1024) / 1024;
    }

    public static long getUseMemory() {
        return (Runtime.getRuntime().totalMemory() / 1024) / 1024;
    }

    public static String[] getVersion() {
        String[] r0 = {"null", "null", "null", "null"};
        BufferedReader r6 = null;
        FileReader r7 = new FileReader("/proc/version");     // Catch: Throwable -> L13 IOException -> L15
        BufferedReader r2 = new BufferedReader(r7, 8192);     // Catch: Throwable -> L11 IOException -> L21
        r0[0] = r2.readLine().split("\\s+")[2];     // Catch: Throwable -> L8 IOException -> L10
        IOUtils.closeQuietly(r2);
    L7:
        IOUtils.closeQuietly(r7);
        r0[1] = Build.VERSION.RELEASE;
        r0[2] = Build.MODEL;
        r0[3] = Build.DISPLAY;
        return r0;
    L10:
        r6 = r2;
    L8:
        th = th;
        r6 = r2;
    L16:
        IOUtils.closeQuietly(r6);
        IOUtils.closeQuietly(r7);
        throw th;
    L11:
        th = th;
    L18:
        IOUtils.closeQuietly(r6);
        goto L7
    L15:
        r7 = null;
    L13:
        th = th;
        r7 = null;
        goto L16
    }
}
