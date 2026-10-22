package com.bytedance.networkstackapplib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.ProxyInfo;
import android.os.Build;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class TTNetworkStackUtils {
    public static long BAD_DNS_QUERY_TIME = 5000;
    private static InetAddress[] addr;

    public TTNetworkStackUtils() {
    }

    public static /* synthetic */ InetAddress[] access$000() {
        return addr;
    }

    public static /* synthetic */ InetAddress[] access$002(InetAddress[] r0) {
        addr = r0;
        return r0;
    }

    public static int checkLinkProxy(Context r15) {
        final ProxyInfo r16 = getProxyInfo(r15);
        if (r16 != null) goto L5;
        return 1;
    L5:
        final int[] r3 = {0, 0};
        final URL r4 = new URL("https://search3-search-hl.toutiaoapi.com/search/");     // Catch: Exception -> L28
        long r5 = System.currentTimeMillis();     // Catch: Exception -> L28
        new MyTimeoutTask().startTask(3000, new AnonymousClass4(r4, r3));     // Catch: Exception -> L28
        int r7 = r3[0];     // Catch: Exception -> L28
        if (r7 < 200) goto L11;
        if (r7 >= 500) goto L11;
        boolean r8 = true;
    L38:
        long r11 = System.currentTimeMillis() - r5;     // Catch: Exception -> L26
        long r6 = System.currentTimeMillis();     // Catch: Exception -> L26
        new MyTimeoutTask().startTask(3000, new AnonymousClass5(r4, r16, r3));     // Catch: Exception -> L26
        int r17 = r3[1];     // Catch: Exception -> L26
        if (r17 < 200) goto L16;
        if (r17 >= 500) goto L16;
        boolean r18 = true;
    L40:
        long r9 = System.currentTimeMillis() - r6;     // Catch: Exception -> L24
        PrintStream r10 = System.out;     // Catch: Exception -> L24
        r10.println("checkLinkProxy code1=" + r3[0] + ",cost1=" + r11 + ",code2=" + r3[1] + ",cost2=" + r9);     // Catch: Exception -> L24
        if (r18 == false) goto L31;
        if (r8 == false) goto L31;
        if (r9 <= (r11 * 2)) goto L31;
        r10.println("checkLinkProxy maybe you can cancel Proxy.");     // Catch: Exception -> L24
        return 0;
    L31:
        if (r8 == false) goto L35;
        if (r18 == true) goto L35;
        System.out.println("TTNetworkStackUtils you must cancel Proxy.");
        return 0;
    L35:
        return 1;
    L24:
        e = e;
    L30:
        e.printStackTrace();
    L16:
        r18 = false;
    L26:
        e = e;
        r18 = false;
    L11:
        r8 = false;
    L28:
        e = e;
        r18 = false;
        r8 = false;
        goto L30
    }

    public static long checkPrivateDns(Context r4) {
        PrintStream r1 = System.out;
        r1.println("TTNetworkStackUtils checkPrivateDns current version = " + Build.VERSION.SDK_INT);
        ConnectivityManager r5 = (ConnectivityManager) r4.getSystemService("connectivity");
        Network r2 = r5.getActiveNetwork();
        if (r2 == null) goto L28;
        LinkProperties r6 = r5.getLinkProperties(r2);
        if (r6 != null) goto L7;
        return 1;
    L7:
        if (r6.getPrivateDnsServerName() == null) goto L30;
        System.currentTimeMillis();
        addr = null;     // Catch: Exception -> L14
        long r3 = new MyTimeoutTask().startTask(5000, new AnonymousClass6());     // Catch: Exception -> L14
        r1.println("phph MyTimeoutTask costtime = " + r3);     // Catch: Exception -> L14
        InetAddress[] r7 = addr;     // Catch: Exception -> L14
        if (r7 != null) goto L12;
    L16:
        r3 = r3 + BAD_DNS_QUERY_TIME;
    L19:
        if (r3 >= 10) goto L22;
        return 2;
    L22:
        return r3;
    L12:
        if (r7.length != 0) goto L19;
    L14:
        e = move-exception;
        e.printStackTrace();
        return 1;
    L30:
        return 1;
    L28:
        return 1;
    }

    public static long getDnsAndTcpProbeTime(int r8) {
        final boolean[] r2 = {false};
        long r3 = 0;
        final String r5 = getProbeDnsName();     // Catch: Exception -> L6
        r3 = new MyTimeoutTask().startTwoTasksNeedOneFinished(r8, new AnonymousClass2(r5, r2), new AnonymousClass3(r2));     // Catch: Exception -> L6
        if (r2[0] == true) goto L12;
        return r3;
    L12:
        return r8 + 1;
    L6:
        e = move-exception;
        e.printStackTrace();
        return r3;
    }

    public static long getDnsProbeTime(int r3) {
        final String r0 = getProbeDnsName();     // Catch: Exception -> L4
        return new MyTimeoutTask().startTask(r3, new AnonymousClass1(r0));
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static String getIpAvailableType(Context r7) {
        ConnectivityManager r8 = (ConnectivityManager) r7.getSystemService("connectivity");     // Catch: Exception -> L6
        LinkProperties r9 = r8.getLinkProperties(r8.getActiveNetwork());     // Catch: Exception -> L6
        if (r9 != null) goto L8;
        return "EmptyLp";
    L8:
        Class<?> r0 = Class.forName("android.net.LinkProperties");     // Catch: Exception -> L6
        Method r1 = r0.getDeclaredMethod("hasIpv4Address", null);     // Catch: Exception -> L6
        Method r3 = r0.getDeclaredMethod("hasIpv4DefaultRoute", null);     // Catch: Exception -> L6
        Method r4 = r0.getDeclaredMethod("hasGlobalIpv6Address", null);     // Catch: Exception -> L6
        Method r2 = r0.getDeclaredMethod("hasIpv6DefaultRoute", null);     // Catch: Exception -> L6
        boolean r5 = true;
        r1.setAccessible(true);     // Catch: Exception -> L6
        r3.setAccessible(true);     // Catch: Exception -> L6
        r4.setAccessible(true);     // Catch: Exception -> L6
        r2.setAccessible(true);     // Catch: Exception -> L6
        if (((Boolean) r1.invoke(r9, null)).booleanValue() == true) goto L11;
    L13:
        boolean r6 = false;
    L15:
        if (((Boolean) r4.invoke(r9, null)).booleanValue() == false) goto L19;
        if (((Boolean) r2.invoke(r9, null)).booleanValue() == false) goto L19;
    L20:
        if (r6 == false) goto L24;
        if (r5 == false) goto L24;
        return "Ipv4Ipv6";
    L24:
        if (r6 == false) goto L28;
        if (r5 == true) goto L28;
        return "Ipv4Only";
    L28:
        if (r6 == true) goto L32;
        if (r5 == false) goto L38;
        return "Ipv6Only";
    L38:
        return "NoV4V6";
    L32:
        return "NoV4V6";
    L19:
        r5 = false;
        goto L20
    L11:
        if (((Boolean) r3.invoke(r9, null)).booleanValue() == false) goto L13;
        r6 = true;
    L6:
        e = move-exception;
        e.printStackTrace();
        return NetworkStackConstant.UNKNOWN_TYPE;
    }

    public static Network getMobileNetwok(Context r7) {
        ConnectivityManager r8 = (ConnectivityManager) r7.getSystemService("connectivity");     // Catch: Exception -> L9
        Network[] r0 = r8.getAllNetworks();     // Catch: Exception -> L9
        int r1 = r0.length;     // Catch: Exception -> L9
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L21;
        Network r4 = r0[r3];     // Catch: Exception -> L9
        NetworkCapabilities r5 = r8.getNetworkCapabilities(r4);     // Catch: Exception -> L9
        if (r5.hasTransport(0) == false) goto L11;
        if (r5.hasCapability(12) == false) goto L11;
        return r4;
    L11:
        r3 = r3 + 1;
        goto L3
    L21:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getProbeDnsName() {
        return UUID.randomUUID().toString().substring(0, 8) + "-dnsotls-ds.metric.gstatic.com";
    L4:
        e = move-exception;
        e.printStackTrace();
        return "aabbccdd-dnsotls-ds.metric.gstatic.com";
    }

    public static ProxyInfo getProxyInfo(Context r1) {
        return ((ConnectivityManager) r1.getSystemService("connectivity")).getDefaultProxy();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static byte[] getRandonData(int r6) {
        byte[] r0 = new byte[r6];
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        r0[r1] = (byte) ((System.currentTimeMillis() % ((long) (r1 + 100))) + 1);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }
}
