package com.bytedance.badger.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f2554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile j f2555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d f2556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f2557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ServiceConnection f2558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f2559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f2560h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f2561i;

    static {
        f2553a = com.bytedance.badger.j.h.a("G3trcaMrcxsrc6Nxm3ujK5Nxm3ujK5ObK5OzK5M=");
        f2554b = com.bytedance.badger.j.h.a("G3trcaMrcxsrc6Nxm3ujK5Nxm3ujK5ObK5OzK5NxmnujK5OaK5OzSxsr");
        f2555c = null;
        f2556d = null;
        f2557e = false;
        f2558f = new c();
        f2559g = false;
        f2560h = com.bytedance.badger.j.h.a("mnujK5NaK8uao3uTKw==");
    }

    public static String a() {
        if (f2555c.E(0) == true) goto L5;
        f2555c.K(0);
    L5:
        g r0 = f2555c.R(0);
        if (r0 != null) goto L8;
    L28:
        return "";
    L8:
        if (r0.f2563f != 0) goto L28;
        byte[] r1 = r0.f2564g;
        byte[] r4 = new byte[4];
        System.arraycopy(r1, 0, r4, 0, 4);
        int r5 = 0;
        int r6 = 0;
    L11:
        if (r5 >= 4) goto L13;
        r6 = r6 + ((r4[r5] & 255) << (r5 * 8));
        r5 = r5 + 1;
        goto L11
    L13:
        byte[] r7 = new byte[r6];
        if (r1.length >= (r6 + 4)) goto L16;
        return "";
    L16:
        System.arraycopy(r1, 4, r7, 0, r6);
        JSONObject r2 = new JSONObject(new String(r7));
        if (r2.has("pub_key") == false) goto L21;
        return r2.getString("cpu_id");
    L21:
        if (r2.has("certs") == false) goto L23;
        String r3 = r2.getJSONArray("certs").getString(0);
    L24:
        if (r3 != null) goto L27;
        return "";
    L27:
        return new JSONObject(new String(a.b((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r3.getBytes()))))).getString("cpu_id");
    L23:
        r3 = "";
        goto L24
    }

    public static boolean b(Context r4, d r5) {
        f2556d = r5;
        if (f2557e == true) goto L5;
        Intent r6 = new Intent();
        r6.setAction(com.bytedance.badger.j.h.a("G3trcaMrcxsrc6Nxm3ujK5Nxm3ujK5ObK5OzK5NxSpp7oyuTmiuTs0sbKw=="));
        r6.setPackage(f2553a);
        r6.setComponent(new ComponentName(f2553a, f2554b));
        f2557e = r4.bindService(r6, f2558f, 1);
        return f2557e;
    L5:
        if (f2556d == null) goto L7;
        com.bytedance.badger.d.b("DeviceFp1", "已经初始化，直接返回," + Thread.currentThread().getName());
        f2556d.a();
    L7:
        return true;
    }

    static /* synthetic */ boolean c(boolean r0) {
        f2557e = r0;
        return r0;
    }

    public static boolean d() {
        if (f2559g == false) goto L36;
    L19:
        Provider[] r0 = Security.getProviders();
        if (r0 != null) goto L23;
        com.bytedance.badger.d.e("DeviceFp1", "dfp1: no provider supported");
        return false;
    L23:
        int r4 = r0.length;
        int r5 = 0;
    L24:
        if (r5 >= r4) goto L32;
        String r6 = r0[r5].getName();
        if (r6 == null) goto L31;
        if (r6.startsWith(f2560h) == false) goto L31;
        com.bytedance.badger.d.f("DeviceFp1", "dfp1: found provider:" + r6);
        f2561i = r6;
        return true;
    L31:
        r5 = r5 + 1;
        goto L24
    L32:
        com.bytedance.badger.d.f("DeviceFp1", "dfp1: provider not found");
        return false;
    L36:
        Class<?> r1 = Class.forName(com.bytedance.badger.j.h.a("C3Mjk3tLI3GbKxurk0ujy3FbK8ubo3uTK3Gae6Mrk1ory5qje5MrgpN7s0sjK5M="));     // Catch: Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L13 ClassNotFoundException -> L14
        com.bytedance.badger.d.f("DeviceFp1", "dfp1 provider: " + r1);     // Catch: Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L13 ClassNotFoundException -> L14
        Method r2 = r1.getMethod("install", new Class[0]);     // Catch: Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L13 ClassNotFoundException -> L14
        r2.setAccessible(true);     // Catch: Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L13 ClassNotFoundException -> L14
        r2.invoke(null, new Object[0]);     // Catch: Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L13 ClassNotFoundException -> L14
    L16:
        f2559g = true;
        goto L19
    L14:
        String r3 = "dfp1: no DeviceFp1Provider found";
    L11:
        com.bytedance.badger.d.f("DeviceFp1", r3);     // Catch: Throwable -> L8
    L12:
        r3 = "dfp1: cannot access";
    L13:
        r3 = "dfp1: function not found";
    L10:
        r3 = "dfp1: InvocationTargetException";
    L8:
        th = move-exception;
        f2559g = true;
        throw th;
    }
}
