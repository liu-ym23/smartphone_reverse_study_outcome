package com.monitor.cloudmessage.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.util.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class SystemUtils {
    public SystemUtils() {
    }

    public static long getUseMemory() {
        return (Runtime.getRuntime().totalMemory() / 1024) / 1024;
    }

    public static long getTotalMemory() {
        return (Runtime.getRuntime().maxMemory() / 1024) / 1024;
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

    public static String[] getVersion() {
        String[] r0 = {"null", "null", "null", "null"};
        BufferedReader r3 = null;
        FileReader r4 = new FileReader("/proc/version");     // Catch: Throwable -> L12 IOException -> L16
    L23:
        BufferedReader r1 = new BufferedReader(r4, 8192);     // Catch: Throwable -> L10 IOException -> L20
        goto L17
    L25:
        r0[0] = r1.readLine().split("\\s+")[2];     // Catch: Throwable -> L7 IOException -> L9
        IOUtils.closeQuietly(r1);
    L18:
        IOUtils.closeQuietly(r4);
        r0[1] = Build.VERSION.RELEASE;
        r0[2] = Build.MODEL;
        r0[3] = Build.DISPLAY;
        return r0;
    L9:
        r3 = r1;
    L7:
        th = th;
        r3 = r1;
    L14:
        IOUtils.closeQuietly(r3);
        IOUtils.closeQuietly(r4);
        throw th;
    L10:
        th = th;
    L17:
        IOUtils.closeQuietly(r3);
    L16:
        r4 = null;
    L12:
        th = th;
        r4 = null;
        goto L14
    }

    public static String[] getCpuInfo() {
        String[] r2 = {"", ""};
        BufferedReader r3 = null;
        FileReader r4 = new FileReader("/proc/cpuinfo");     // Catch: Throwable -> L16 IOException -> L20
    L27:
        BufferedReader r1 = new BufferedReader(r4, 8192);     // Catch: Throwable -> L14 IOException -> L24
        goto L21
    L29:
        String[] r5 = r1.readLine().split("\\s+");     // Catch: Throwable -> L11 IOException -> L13
        int r6 = 2;
    L7:
        if (r6 >= r5.length) goto L9;
        r2[0] = r2[0] + r5[r6] + HanziToPinyin.Token.SEPARATOR;     // Catch: Throwable -> L11 IOException -> L13
        r6 = r6 + 1;     // Catch: Throwable -> L11 IOException -> L13
        goto L7
    L9:
        r2[1] = r2[1] + r1.readLine().split("\\s+")[2];     // Catch: Throwable -> L11 IOException -> L13
        IOUtils.closeQuietly(r1);
    L22:
        IOUtils.closeQuietly(r4);
        return r2;
    L13:
        r3 = r1;
    L11:
        th = th;
        r3 = r1;
    L18:
        IOUtils.closeQuietly(r3);
        IOUtils.closeQuietly(r4);
        throw th;
    L14:
        th = th;
    L21:
        IOUtils.closeQuietly(r3);
    L20:
        r4 = null;
    L16:
        th = th;
        r4 = null;
        goto L18
    }
}
