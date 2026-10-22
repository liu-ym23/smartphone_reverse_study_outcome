package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7395a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7396b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7397c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f7398d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static String f7399e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static boolean f7400f = false;

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f7401g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f7402h;

        a(Context r1, String r2) {
            this.f7401g = r1;
            this.f7402h = r2;
        }

        @Override // com.loc.s1
        public final void b() {
            FileOutputStream r0 = null;
            File r2 = new File(t.j(this.f7401g, "k.store"));     // Catch: Throwable -> L15
            if (r2.getParentFile().exists() == true) goto L6;
            r2.getParentFile().mkdirs();     // Catch: Throwable -> L15
        L6:
            FileOutputStream r1 = new FileOutputStream(r2);     // Catch: Throwable -> L15
            r1.write(u5.o(this.f7402h));     // Catch: Throwable -> L13
            r1.close();     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        L13:
            th = th;
            r0 = r1;
        L40:
            s.e(th, "AI", "stf");     // Catch: Throwable -> L23
            if (r0 == null) goto L42;
            r0.close();     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            th.printStackTrace();
            return;
        L42:
            return;
        L23:
            th = move-exception;
            if (r0 != null) goto L32;
        L29:
            throw th;
        L32:
            r0.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.printStackTrace();
        L15:
            th = th;
            goto L40
        }
    }

    static {
    }

    public static String a(Context r0) {
        return l(r0);
    L4:
        th = move-exception;
        th.printStackTrace();
        return f7398d;
    }

    static void b(Context r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        f7398d = r3;
        if (r2 == null) goto L9;
        r1.f().d(new a(r2, r3));
        return;
    }

    public static void c(String r0) {
        f7396b = r0;
    }

    static boolean d() {
        if (f7400f == false) goto L7;
        return true;
    L7:
        if (f(f7399e) == false) goto L11;
        f7400f = true;     // Catch: Throwable -> L23
        return true;
    L11:
        if (TextUtils.isEmpty(f7399e) == true) goto L15;
        f7400f = false;     // Catch: Throwable -> L23
        f7399e = null;     // Catch: Throwable -> L23
        return false;
    L15:
        if (f(f7396b) == false) goto L19;
        f7400f = true;     // Catch: Throwable -> L23
        return true;
    L19:
        if (TextUtils.isEmpty(f7396b) == true) goto L22;
        f7400f = false;     // Catch: Throwable -> L23
        f7396b = null;     // Catch: Throwable -> L23
        return false;
    L22:
        return true;
    }

    public static String e(Context r2) {
    L8:
        th = move-exception;
        s.e(th, "AI", "gAN");
    L11:
        return f7395a;
    L3:
        if ("".equals(f7395a) == false) goto L5;
        PackageManager r0 = r2.getPackageManager();     // Catch: Throwable -> L8
        f7395a = (String) r0.getApplicationLabel(r0.getApplicationInfo(r2.getPackageName(), 0));     // Catch: Throwable -> L8
        goto L11
    L5:
        return f7395a;
    }

    private static boolean f(String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L21;
        r6.toCharArray();
        char[] r0 = r6.toCharArray();
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L19;
        char r4 = r0[r3];
        if ('A' > r4) goto L11;
        if (r4 > 'z') goto L11;
    L18:
        r3 = r3 + 1;
    L11:
        if ('0' > r4) goto L15;
        if (r4 <= ':') goto L18;
    L15:
        if (r4 == '.') goto L18;
        v.l(u5.a(), r6, "errorPackage");     // Catch: Throwable -> L22
    L17:
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    public static String g(Context r2) {
        String r0 = f7396b;     // Catch: Throwable -> L12
        if (r0 != null) goto L5;
    L8:
        String r1 = r2.getPackageName();     // Catch: Throwable -> L12
        f7396b = r1;     // Catch: Throwable -> L12
        if (f(r1) == true) goto L15;
        f7396b = r2.getPackageName();     // Catch: Throwable -> L12
    L15:
        return f7396b;
    L5:
        if ("".equals(r0) == true) goto L8;
        return f7396b;
    L12:
        th = move-exception;
        s.e(th, "AI", "gpck");
        goto L15
    }

    public static String h(Context r3) {
    L9:
        th = move-exception;
        s.e(th, "AI", "gAV");
    L11:
        String r4 = f7397c;
        if (r4 != null) goto L14;
        return "";
    L14:
        return r4;
    L4:
        if ("".equals(f7397c) == false) goto L6;
        f7397c = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionName;     // Catch: Throwable -> L9
        goto L11
    L6:
        return f7397c;
    }

    public static String i(Context r7) {
        PackageInfo r0 = r7.getPackageManager().getPackageInfo(r7.getPackageName(), 64);     // Catch: Throwable -> L18
        int r2 = 0;
        byte[] r1 = r0.signatures[0].toByteArray();     // Catch: Throwable -> L18
        byte[] r3 = MessageDigest.getInstance(u5.u("IU0hBMQ")).digest(r1);     // Catch: Throwable -> L18
        StringBuffer r4 = new StringBuffer();     // Catch: Throwable -> L18
    L4:
        if (r2 >= r3.length) goto L9;
        String r5 = Integer.toHexString(r3[r2] & 255).toUpperCase(Locale.US);     // Catch: Throwable -> L18
        if (r5.length() != 1) goto L8;
        r4.append(BDLocationException.ERROR_TIMEOUT);     // Catch: Throwable -> L18
    L8:
        r4.append(r5);     // Catch: Throwable -> L18
        r4.append(":");     // Catch: Throwable -> L18
        r2 = r2 + 1;     // Catch: Throwable -> L18
        goto L4
    L9:
        String r6 = r0.packageName;     // Catch: Throwable -> L18
        if (f(r6) == false) goto L13;
        r6 = r0.packageName;     // Catch: Throwable -> L18
    L13:
        if (TextUtils.isEmpty(f7396b) == true) goto L16;
        r6 = g(r7);     // Catch: Throwable -> L18
    L16:
        r4.append(r6);     // Catch: Throwable -> L18
        String r8 = r4.toString();     // Catch: Throwable -> L18
        f7399e = r8;     // Catch: Throwable -> L18
        return r8;
    L18:
        th = move-exception;
        s.e(th, "AI", "gsp");
        return f7399e;
    }

    public static String j(Context r2) {
        j5.e(r2);     // Catch: Throwable -> L8
    L11:
        return l(r2);
    L5:
        th = move-exception;
        s.e(th, "AI", "gKy");
        return f7398d;
    }

    private static String k(Context r6) {
        File r0 = new File(t.j(r6, "k.store"));
        String r1 = "";
        if (r0.exists() == true) goto L50;
        return "";
    L50:
        FileInputStream r2 = new FileInputStream(r0);     // Catch: Throwable -> L18
        byte[] r7 = new byte[r2.available()];     // Catch: Throwable -> L16
        r2.read(r7);     // Catch: Throwable -> L16
        String r8 = u5.g(r7);     // Catch: Throwable -> L16
        if (r8.length() != 32) goto L42;
        r1 = r8;
    L42:
        r2.close();     // Catch: Throwable -> L13
    L15:
        return r1;
    L13:
        th = move-exception;
        th.printStackTrace();
    L16:
        Throwable th = th;
    L52:
        s.e(th, "AI", "gKe");     // Catch: Throwable -> L33
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
    L27:
        if (r2 != null) goto L48;
    L32:
        return "";
    L48:
        r2.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L32
    L22:
        if (r0.exists() == false) goto L27;
        r0.delete();     // Catch: Throwable -> L25
    L33:
        th = move-exception;
        if (r2 != null) goto L44;
    L39:
        throw th;
    L44:
        r2.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.printStackTrace();
    L18:
        th = move-exception;
        r2 = null;
        th = th;
        goto L52
    }

    private static String l(Context r3) {
        String r0 = f7398d;
        if (r0 != null) goto L5;
    L6:
        ApplicationInfo r1 = r3.getPackageManager().getApplicationInfo(r3.getPackageName(), 128);
        if (r1 == null) goto L17;
        Bundle r2 = r1.metaData;
        if (r2 == null) goto L17;
        String r4 = r2.getString("com.amap.api.v2.apikey");
        f7398d = r4;
        if (r4 != null) goto L15;
        f7398d = k(r3);
    L15:
        return f7398d;
    L17:
        return f7398d;
    L5:
        if (r0.equals("") == false) goto L15;
        goto L6
    }
}
