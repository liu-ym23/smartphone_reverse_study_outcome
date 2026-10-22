package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static String a() {
        String r0 = "";
        BufferedReader r1 = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));     // Catch: Throwable -> L8
        String r2 = r1.readLine();     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        r0 = r2;
    L6:
        r1.close();     // Catch: Throwable -> L8
    L7:
        return r0;
    }

    public static String b(Context r2) {
        String r0 = v5.a(r2);     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r0) == false) goto L14;
        r0 = UUID.randomUUID().toString();     // Catch: Throwable -> L9
        v5.c(r2, r0);     // Catch: Throwable -> L9
        return r0;
    L14:
        return r0;
    L16:
        return r0;
    L7:
        return "";
    }

    private static Date c(String r2) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(r2);
    L5:
        return null;
    }

    public static byte[] d(byte[] r3, byte[] r4) {
        if (r3 != null) goto L4;
    L13:
        return r3;
    L4:
        if (r3.length == 0) goto L13;
        if (r4 == null) goto L13;
        if (r4.length == 0) goto L13;
        int r0 = 0;
    L11:
        if (r0 >= r3.length) goto L13;
        r3[r0] = (byte) ((r3[r0] ^ r4[r0 % r4.length]) ^ (r0 & 255));
        r0 = r0 + 1;
        goto L11
    }

    public static String e() {
        String r0 = "";
        BufferedReader r2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/app").getInputStream()));     // Catch: Throwable -> L15
        String r1 = r2.readLine();     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        String[] r3 = r1.split("\\.");     // Catch: Throwable -> L15
        Date r4 = c(r3[0]);     // Catch: Throwable -> L15
        if (r3[1] == null) goto L8;
        String r5 = r3[1].split("\\+")[0].trim();     // Catch: Throwable -> L15
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r0 = (r4.getTime() / 1000) + "." + g(r5);     // Catch: Throwable -> L15
        goto L13
    L12:
        r0 = String.valueOf(r4.getTime() / 1000);     // Catch: Throwable -> L15
        goto L13
    L8:
        r5 = "";
    L13:
        r2.close();     // Catch: Throwable -> L15
    L14:
        return r0;
    }

    private static String f(String r3) {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L8
        r0.update(r3.getBytes());     // Catch: Throwable -> L8
        byte[] r4 = r0.digest();     // Catch: Throwable -> L8
        StringBuffer r1 = new StringBuffer();     // Catch: Throwable -> L8
        int r2 = 0;
    L4:
        if (r2 >= r4.length) goto L6;
        r1.append(Integer.toHexString(r4[r2] & 255));     // Catch: Throwable -> L8
        r2 = r2 + 1;     // Catch: Throwable -> L8
        goto L4
    L6:
        return r1.toString();
    L8:
        return "";
    }

    private static int g(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L11;
        return Integer.parseInt(r2);
    L11:
        return 0;
    L12:
        return 0;
    }

    public static String h() {
        String r0 = "";
        BufferedReader r2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/").getInputStream()));     // Catch: Throwable -> L15
        String r1 = r2.readLine();     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        String[] r3 = r1.split("\\.");     // Catch: Throwable -> L15
        Date r4 = c(r3[0]);     // Catch: Throwable -> L15
        if (r3[1] == null) goto L8;
        String r5 = r3[1].split("\\+")[0].trim();     // Catch: Throwable -> L15
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r0 = (r4.getTime() / 1000) + "." + g(r5);     // Catch: Throwable -> L15
        goto L13
    L12:
        r0 = String.valueOf(r4.getTime() / 1000);     // Catch: Throwable -> L15
        goto L13
    L8:
        r5 = "";
    L13:
        r2.close();     // Catch: Throwable -> L15
    L14:
        return r0;
    }

    public static String i() {
        String r0 = "";
        BufferedReader r2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/data").getInputStream()));     // Catch: Throwable -> L15
        String r1 = r2.readLine();     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        String[] r3 = r1.split("\\.");     // Catch: Throwable -> L15
        Date r4 = c(r3[0]);     // Catch: Throwable -> L15
        if (r3[1] == null) goto L8;
        String r5 = r3[1].split("\\+")[0].trim();     // Catch: Throwable -> L15
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r0 = (r4.getTime() / 1000) + "." + g(r5);     // Catch: Throwable -> L15
        goto L13
    L12:
        r0 = String.valueOf(r4.getTime() / 1000);     // Catch: Throwable -> L15
        goto L13
    L8:
        r5 = "";
    L13:
        r2.close();     // Catch: Throwable -> L15
    L14:
        return r0;
    }

    public static String j() {
        String r0 = "";
        BufferedReader r2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/app").getInputStream()));     // Catch: Throwable -> L15
        String r1 = r2.readLine();     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        String[] r3 = r1.split("\\.");     // Catch: Throwable -> L15
        Date r4 = c(r3[0]);     // Catch: Throwable -> L15
        if (r3[1] == null) goto L8;
        String r5 = r3[1].split("\\+")[0].trim();     // Catch: Throwable -> L15
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r0 = (r4.getTime() / 1000) + "." + g(r5);     // Catch: Throwable -> L15
        goto L13
    L12:
        r0 = String.valueOf(r4.getTime() / 1000);     // Catch: Throwable -> L15
        goto L13
    L8:
        r5 = "";
    L13:
        r2.close();     // Catch: Throwable -> L15
    L14:
        return r0;
    }

    public static String k() {
        String r0 = "";
        BufferedReader r2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %i /data/data").getInputStream()));     // Catch: Throwable -> L8
        String r1 = r2.readLine();     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        r0 = r1;
    L6:
        r2.close();     // Catch: Throwable -> L8
    L7:
        return r0;
    }

    public static String l() {
        String r0 = "";
        BufferedReader r2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %i /data/app").getInputStream()));     // Catch: Throwable -> L8
        String r1 = r2.readLine();     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        r0 = r1;
    L6:
        r2.close();     // Catch: Throwable -> L8
    L7:
        return r0;
    }

    public static String m() {
        Method r1 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Exception -> L9
        r1.setAccessible(true);     // Catch: Exception -> L9
        String r0 = r1.invoke(null, new Object[]{"net.hostname"}).toString();     // Catch: Exception -> L9
        if (r0 != null) goto L6;
        return r0;
    L6:
        if (r0.equalsIgnoreCase("") == true) goto L13;
        return f(r0);
    L13:
        return r0;
    L14:
        return null;
    }
}
