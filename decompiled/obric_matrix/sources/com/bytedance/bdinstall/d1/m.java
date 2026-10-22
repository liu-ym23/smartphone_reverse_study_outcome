package com.bytedance.bdinstall.d1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdinstall.f0;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.t0;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final n<String> f2736a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final n<String> f2737b = null;

    class a extends n<String> {
        a() {
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ String a(Object[] r1) {
            return c(r1);
        }

        protected String c(Object... r2) {
            return m.a((Context) r2[0], (i0) r2[1]);
        }
    }

    class b extends n<String> {
        b() {
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ String a(Object[] r1) {
            return c(r1);
        }

        protected String c(Object... r2) {
            if (l.p() == true) goto L5;
        L8:
            f0 r1 = t0.b();
            if (r1 != null) goto L11;
            return null;
        L11:
            return r1.c((Context) r2[0]);
        L5:
            if (l.A((Context) r2[0]) == false) goto L8;
            return "";
        }
    }

    static {
        f2736a = new a();
        f2737b = new b();
    }

    static /* synthetic */ String a(Context r0, i0 r1) {
        return c(r0, r1);
    }

    private static JSONObject b(String r2, int r3, String r4) {
        JSONObject r0 = new JSONObject();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r0.put("id", r2);
        r0.put("slot_index", r3);
        r0.put(WsConstants.KEY_CONNECTION_TYPE, r4);
    L5:
        return r0;
    }

    @SuppressLint({"HardwareIds"})
    private static String c(Context r1, i0 r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 == null) goto L9;
        if (r2.O() == true) goto L9;
    L11:
        f0 r3 = t0.b();
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.f(r1);
    L9:
        if (g.b(r1) == true) goto L11;
        return null;
    }

    public static String d(Context r3, i0 r4) {
        return f2736a.b(new Object[]{r3, r4});
    }

    @SuppressLint({"HardwareIds"})
    public static String e(Context r3) {
        return f2737b.b(new Object[]{r3});
    }

    @NonNull
    public static JSONArray f(Context r9, i0 r10) {
        JSONArray r4 = new JSONArray();
        if (r10 == null) goto L7;
        if (r10.O() == true) goto L7;
    L68:
    L61:
        th = move-exception;
        if ((th instanceof SecurityException) == false) goto L65;
        com.bytedance.bdinstall.q.c("读取imei没有权限");
    L65:
        return r4;
    L10:
        String r8 = null;
        if (Build.VERSION.SDK_INT >= 26) goto L69;
        f0 r11 = t0.b();     // Catch: Throwable -> L61
        if (r11 != null) goto L54;
        String r0 = null;
    L55:
        r4.put(b(r0, 0, EnvironmentCompat.MEDIA_UNKNOWN));     // Catch: Throwable -> L61
        if (r11 == null) goto L59;
        r8 = r11.e(r9, 1);     // Catch: Throwable -> L61
    L59:
        r4.put(b(r8, 1, EnvironmentCompat.MEDIA_UNKNOWN));     // Catch: Throwable -> L61
        goto L65
    L54:
        r0 = r11.e(r9, 0);     // Catch: Throwable -> L61
        goto L55
    L69:
        f0 r12 = t0.b();     // Catch: Exception -> L18 Throwable -> L61
        if (r12 == null) goto L15;
        String r13 = r12.b(r9, 0);     // Catch: Exception -> L18 Throwable -> L61
    L16:
        r4.put(b(r13, 0, "meid"));     // Catch: Exception -> L18 Throwable -> L61
    L71:
        f0 r14 = t0.b();     // Catch: Exception -> L28 Throwable -> L61
        if (r14 == null) goto L25;
        String r15 = r14.b(r9, 1);     // Catch: Exception -> L28 Throwable -> L61
    L26:
        r4.put(b(r15, 1, "meid"));     // Catch: Exception -> L28 Throwable -> L61
    L73:
        f0 r16 = t0.b();     // Catch: Exception -> L38 Throwable -> L61
        if (r16 == null) goto L35;
        String r17 = r16.a(r9, 0);     // Catch: Exception -> L38 Throwable -> L61
    L36:
        r4.put(b(r17, 0, "imei"));     // Catch: Exception -> L38 Throwable -> L61
    L66:
        f0 r18 = t0.b();     // Catch: Exception -> L47 Throwable -> L61
        if (r18 == null) goto L45;
        r8 = r18.a(r9, 1);     // Catch: Exception -> L47 Throwable -> L61
    L45:
        r4.put(b(r8, 1, "imei"));     // Catch: Exception -> L47 Throwable -> L61
    L47:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L65;
        com.bytedance.bdinstall.q.c("读取imei没有权限");     // Catch: Throwable -> L61
        goto L65
    L35:
        r17 = null;
    L38:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L66;
        com.bytedance.bdinstall.q.c("读取imei没有权限");     // Catch: Throwable -> L61
        goto L66
    L25:
        r15 = null;
    L28:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L73;
        com.bytedance.bdinstall.q.c("读取imei没有权限");     // Catch: Throwable -> L61
        goto L73
    L15:
        r13 = null;
    L18:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L71;
        com.bytedance.bdinstall.q.c("读取imei没有权限");     // Catch: Throwable -> L61
    L7:
        if (g.b(r9) == true) goto L68;
        return r4;
    }

    @SuppressLint({"HardwareIds", "MissingPermission", "NewApi"})
    public static String g(Context r3, i0 r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L16;
        if (r3.getApplicationInfo().targetSdkVersion < 26) goto L16;
        if (r4 == null) goto L13;
        if (r4.O() == false) goto L16;
    L13:
        if (g.b(r3) == true) goto L16;
        return null;
    L16:
        return t0.b().g(r3);
    }

    @SuppressLint({"HardwareIds"})
    public static String[] h(Context r2, i0 r3) {
        if (r2 == null) goto L20;
        if (l.q() == true) goto L20;
        if (r3 == null) goto L10;
        if (r3.O() == true) goto L10;
    L12:
        f0 r4 = t0.b();
        if (r4 == null) goto L18;
        String[] r5 = r4.d(r2);
        if (r5 == null) goto L18;
        return r5;
    L18:
        return new String[0];
    L10:
        if (g.b(r2) == true) goto L12;
    L20:
        return new String[0];
    }
}
