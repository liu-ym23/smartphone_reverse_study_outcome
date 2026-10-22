package com.bytedance.apm.util;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm.entity.TrafficEntity;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TrafficUtils {
    private static final int DEFAULT_NET_STATS = 0;
    private static volatile String sSubscriberId = null;
    private static volatile int sUId = -1;

    public TrafficUtils() {
    }

    public static boolean canCheck() {
        return false;
    }

    private static int getAppUid(@NonNull Context r2) {
        if (sUId != (-1)) goto L12;
        PackageManager r0 = r2.getApplicationContext().getPackageManager();
        PackageInfo r3 = r0.getPackageInfo(r2.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r3 == null) goto L12;
        sUId = r3.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return sUId;
    }

    @NonNull
    private static TrafficEntity getFormatTrafficEntity(int r36, List<String> r37) {
        TrafficEntity r0 = new TrafficEntity();
        Iterator<String> r1 = r37.iterator();
        long r4 = 0;
        long r6 = 0;
        long r8 = 0;
        long r10 = 0;
        long r12 = 0;
        long r14 = 0;
        long r16 = 0;
        long r18 = 0;
        long r20 = 0;
        long r22 = 0;
    L4:
        if (r1.hasNext() == false) goto L37;
        String[] r2 = r1.next().split(" ");
        r1 = r1;
    L32:
        TrafficEntity r26 = r0;
        long r34 = r12;
    L34:
        r16 = r16;
        r18 = r18;
    L35:
        r12 = r34;
    L36:
        r0 = r26;
        goto L4
    L7:
        if (TextUtils.equals(r2[3], "uid_tag_int") == true) goto L4;
        if (r36 != Integer.parseInt(r2[3])) goto L33;
        long r27 = Long.parseLong(r2[5]);     // Catch: Exception -> L32
        long r29 = Long.parseLong(r2[7]);     // Catch: Exception -> L32
        r26 = r0;
        if (Long.valueOf(r2[4]).longValue() != 0) goto L22;
        r34 = r12;
        r22 = (r27 + r29) + r22;
        if (r2[1].startsWith("rmnet_data") == false) goto L19;
        r6 = r6 + r29;     // Catch: Exception -> L21
        r4 = r4 + r27;     // Catch: Exception -> L21
        goto L35
    L19:
        if (r2[1].startsWith("wlan") == false) goto L35;
        r10 = r10 + r29;
        r8 = r8 + r27;
        goto L35
    L22:
        r34 = r12;
        long r13 = r22;
        r20 = (r27 + r29) + r20;
        if (r2[1].startsWith("rmnet_data") == false) goto L27;
        r14 = r14 + r29;     // Catch: Exception -> L31
        r12 = r34 + r27;     // Catch: Exception -> L31
        r22 = r13;
        goto L36
    L27:
        if (r2[1].startsWith("wlan") == false) goto L29;
        r18 = r18 + r29;
        r16 = r16 + r27;
    L29:
        r22 = r13;
    L31:
        r22 = r13;
        goto L34
    L33:
        r26 = r0;
        r34 = r12;
        goto L35
    L37:
        long r35 = r12;
        TrafficEntity r15 = r0;
        r15.setBackMobileRecBytes(r4);
        r15.setBackMobileSendBytes(r6);
        r15.setBackWifiRecBytes(r8);
        r15.setBackWifiSendBytes(r10);
        r15.setFrontMobileRecBytes(r35);
        r15.setFrontMobileSendBytes(r14);
        r15.setFrontWifiRecBytes(r16);
        r15.setFrontWifiSendBytes(r18);
        r15.setFrontTotalBytes(r20);
        r15.setBackTotalBytes(r22);
        return r15;
    }

    @TargetApi(23)
    public static long getNetStats(@NonNull Context r8, long r9, long r11) {
        return getNetStats(r8, r9, r11, 1) + getNetStats(r8, r9, r11, 0);
    }

    @Nullable
    public static TrafficEntity getTrafficBytes() {
        return null;
    }

    public static List<String> readFile2List(File r6, String r7) {
        if (r6 != null) goto L34;
        return null;
    L34:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L11
        int r2 = 1;
        if (r7 != null) goto L8;
    L13:
        BufferedReader r3 = new BufferedReader(new FileReader(r6));     // Catch: Throwable -> L11
    L32:
        String r8 = r3.readLine();     // Catch: Throwable -> L19
        if (r8 == null) goto L22;
        if (r2 < 0) goto L21;
        r1.add(r8);     // Catch: Throwable -> L19
    L21:
        r2 = r2 + 1;
        goto L32
    L22:
        IoUtil.safeClose(r3);
        return r1;
    L19:
        th = th;
    L30:
        th.printStackTrace();     // Catch: Throwable -> L27
        IoUtil.safeClose(r3);
        return null;
    L27:
        th = move-exception;
        IoUtil.safeClose(r3);
        throw th;
    L8:
        if (r7.trim().length() == 0) goto L13;
        r3 = new BufferedReader(new InputStreamReader(new FileInputStream(r6), r7));     // Catch: Throwable -> L11
    L11:
        th = th;
        r3 = null;
        goto L30
    }

    public static long getNetStats(@NonNull Context r10, long r11, long r13, int r15) {
        long r1 = 0;
        if (canCheck() == true) goto L5;
        return 0;
    L5:
        NetworkStatsManager r3 = (NetworkStatsManager) r10.getApplicationContext().getSystemService("netstats");
        if (r3 != null) goto L8;
        return 0;
    L8:
        NetworkStats.Bucket r0 = new NetworkStats.Bucket();
        NetworkStats r12 = r3.querySummary(r15, null, r11, r13);     // Catch: Exception -> L11
    L10:
        long r14 = 0;
    L13:
        if (r12 == null) goto L19;
        if (r12.hasNextBucket() == false) goto L19;
        r12.getNextBucket(r0);
        if (getAppUid(r10) != r0.getUid()) goto L13;
        long r16 = r0.getRxBytes() + r1;
        r14 = r0.getTxBytes() + r14;
        r1 = r16;
    L19:
        if (r12 == null) goto L22;
        r12.close();
    L22:
        return r1 + r14;
    L11:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L10
    }
}
