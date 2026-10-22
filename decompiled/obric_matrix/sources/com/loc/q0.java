package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f7607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile List<String> f7608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f7609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Random f7610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f7611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static List<z0> f7612f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f7614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f7615c;

        private a() {
        }

        /* synthetic */ a(byte r1) {
            this();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        u0 f7616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f7617b;

        private b() {
        }

        /* synthetic */ b(byte r1) {
            this();
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<String, List<a>> f7618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<String, String> f7619b;

        private c() {
            this.f7618a = new HashMap(8);
            this.f7619b = new HashMap(8);
        }

        /* synthetic */ c(byte r1) {
            this();
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L15:
            return false;
        L8:
            if (c.class != r5.getClass()) goto L15;
            c r6 = (c) r5;
            if (this.f7618a.equals(r6.f7618a) == false) goto L15;
            if (this.f7619b.equals(r6.f7619b) == false) goto L15;
            return true;
        }

        public final int hashCode() {
            Map<String, List<a>> r0 = this.f7618a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            Map<String, String> r3 = this.f7619b;
            if (r3 == null) goto L10;
            r1 = r3.hashCode();
        L10:
            return r2 + r1;
        L5:
            r2 = 0;
            goto L6
        }
    }

    static {
        f7607a = new ConcurrentHashMap(8);
        f7608b = Collections.synchronizedList(new ArrayList(8));
        f7609c = new ConcurrentHashMap(8);
        f7610d = new Random();
        f7611e = new ConcurrentHashMap(8);
        f7612f = Collections.synchronizedList(new ArrayList(16));
    }

    public static synchronized String a(String r4, String r5) {
        monitor-enter(q0.class);
        System.currentTimeMillis();     // Catch: Throwable -> L49 h5 -> L53
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L47:
        monitor-exit(q0.class);
        return r4;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L47;
        Context r1 = j5.f7428g;     // Catch: Throwable -> L49 h5 -> L53
    L23:
        th = move-exception;
        s.e(th, "hlUtil", "llhl");     // Catch: Throwable -> L49 h5 -> L53
    L26:
        if (f7607a != null) goto L28;
    L45:
        monitor-exit(q0.class);
        return r4;
    L28:
        if (f7607a.size() <= 0) goto L45;
        if (f7607a.containsKey(r5) == true) goto L34;
        monitor-exit(q0.class);
        return r4;
    L34:
        c r2 = f7607a.get(r5);     // Catch: Throwable -> L49 h5 -> L53
        if (r2 != null) goto L39;
        monitor-exit(q0.class);
        return r4;
    L39:
        if (m(r4, r2, r5) == true) goto L44;
        String r6 = p(r4, r2, r5);     // Catch: Throwable -> L49 h5 -> L53
        monitor-exit(q0.class);
        return r6;
    L44:
        throw new h5("服务QPS超限");     // Catch: Throwable -> L49 h5 -> L53
    L11:
        if (f7608b != null) goto L13;
        f7608b = Collections.synchronizedList(new ArrayList(8));     // Catch: Throwable -> L23
    L13:
        if (r1 == null) goto L26;
        if (f7608b.contains(r5) == true) goto L26;
        f7608b.add(r5);     // Catch: Throwable -> L23
        String r3 = d0.e(r1, "Yb3Blbl9odHRwX2NvbnRyb2w", r5);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r3) == true) goto L26;
        h(r5, new JSONObject(r3));     // Catch: Throwable -> L23
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    L53:
        e = move-exception;
        throw e;     // Catch: Throwable -> L55
    L49:
        th = move-exception;
        s.e(th, "hlUtil", "pcr");     // Catch: Throwable -> L55
        return r4;
    }

    public static void b() {
        Context r0 = j5.f7428g;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        a1.e(q(), r0);     // Catch: Throwable -> L7
        return;
    }

    private static void c(c r12, JSONObject r13) {
        JSONArray r14 = r13.optJSONArray("block");     // Catch: Throwable -> L32
        if (r14 != null) goto L6;
        return;
    L6:
        HashMap r1 = new HashMap(8);     // Catch: Throwable -> L32
        byte r2 = 0;
        int r3 = 0;
    L8:
        if (r3 >= r14.length()) goto L30;
        JSONObject r4 = r14.optJSONObject(r3);     // Catch: Throwable -> L32
        if (r4 == null) goto L29;
        String r5 = r4.optString("api");     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r5) == true) goto L29;
        if (r5.startsWith("/") == true) goto L17;
        r5 = "/".concat(String.valueOf(r5));     // Catch: Throwable -> L32
    L17:
        if (r5.endsWith("/") == false) goto L19;
        r5 = r5.substring(0, r5.length() - 1);     // Catch: Throwable -> L32
    L19:
        JSONArray r6 = r4.optJSONArray("periods");     // Catch: Throwable -> L32
        if (r14 == null) goto L29;
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L32
        int r8 = 0;
    L23:
        if (r8 >= r6.length()) goto L28;
        JSONObject r9 = r6.optJSONObject(r8);     // Catch: Throwable -> L32
        if (r9 == null) goto L27;
        a r10 = new a(r2);     // Catch: Throwable -> L32
        r10.f7613a = r9.optString("begin");     // Catch: Throwable -> L32
        r10.f7614b = r9.optInt(TypedValues.TransitionType.S_DURATION);     // Catch: Throwable -> L32
        r10.f7615c = r9.optDouble("percent");     // Catch: Throwable -> L32
        r7.add(r10);     // Catch: Throwable -> L32
    L27:
        r8 = r8 + 1;     // Catch: Throwable -> L32
        goto L23
    L28:
        r1.put(r5, r7);     // Catch: Throwable -> L32
    L29:
        r3 = r3 + 1;     // Catch: Throwable -> L32
        goto L8
    L30:
        r12.f7618a = r1;     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        s.e(th, "hlUtil", "pbr");
    }

    public static synchronized void d(t5 r4, JSONObject r5) {
        monitor-enter(q0.class);
        if (r4 != null) goto L30;
        monitor-exit(q0.class);
        return;
    L30:
        String r6 = r4.a();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r6) == false) goto L11;
        monitor-exit(q0.class);
        return;
    L11:
        if (r5 != null) goto L14;
        e(r6);     // Catch: Throwable -> L21
    L14:
        if (j5.v(r5.optString("able", null), false) == true) goto L18;
        e(r6);     // Catch: Throwable -> L21
        monitor-exit(q0.class);
        return;
    L18:
        d0.f(j5.f7428g, "Yb3Blbl9odHRwX2NvbnRyb2w", r6, r5.toString());     // Catch: Throwable -> L21
        h(r6, r5);     // Catch: Throwable -> L21
        monitor-exit(q0.class);
        return;
    L21:
        th = move-exception;
        s.e(th, "hlUtil", "par");     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    private static synchronized void e(String r3) {
        monitor-enter(q0.class);
    L10:
        th = move-exception;
        s.e(th, "hlUtil", "rc");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f7607a.containsKey(r3) == false) goto L7;
        f7607a.remove(r3);     // Catch: Throwable -> L10
    L7:
        SharedPreferences.Editor r1 = d0.d(j5.f7428g, "Yb3Blbl9odHRwX2NvbnRyb2w");     // Catch: Throwable -> L10
        d0.h(r1, r3);     // Catch: Throwable -> L10
        d0.g(r1);     // Catch: Throwable -> L10
        monitor-exit(q0.class);
    }

    private static void f(String r2, c r3) {
    L7:
        th = move-exception;
        s.e(th, "hlUtil", "ucr");
        return;
    L3:
        if (f7607a != null) goto L5;
        f7607a = new ConcurrentHashMap(8);     // Catch: Throwable -> L7
    L5:
        f7607a.put(r2, r3);     // Catch: Throwable -> L7
    }

    private static void g(String r5, String r6, String r7) {
        Context r0 = j5.f7428g;     // Catch: Throwable -> L27
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return;
    L8:
        if (f7611e != null) goto L10;
        f7611e = new ConcurrentHashMap(8);     // Catch: Throwable -> L27
    L10:
        ConcurrentHashMap<String, String> r1 = f7611e;     // Catch: Throwable -> L27
        monitor-enter(r1);     // Catch: Throwable -> L27
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L13:
        if (f7611e.containsKey(r6) == false) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L16:
        f7611e.put(r6, r7);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L27
        r2.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L27
        r2.put(WsConstants.KEY_CONNECTION_TYPE, g.f7313l);     // Catch: Throwable -> L27
        r2.put("name", r5);     // Catch: Throwable -> L27
        r2.put("version", g.a(r5));     // Catch: Throwable -> L27
        r2.put("hostname", r6 + "#" + r7);     // Catch: Throwable -> L27
        String r8 = r2.toString();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r8) == false) goto L21;
        return;
    L21:
        z0 r9 = new z0(r0, "core", "2.0", "O005");     // Catch: Throwable -> L27
        r9.a(r8);     // Catch: Throwable -> L27
        a1.d(r9, r0);     // Catch: Throwable -> L27
        return;
    }

    private static void h(String r2, JSONObject r3) {
        c r0 = new c(0);     // Catch: Throwable -> L10
        c(r0, r3);     // Catch: Throwable -> L10
        r(r0, r3);     // Catch: Throwable -> L10
        if (r0.f7619b == null) goto L5;
    L8:
        f(r2, r0);     // Catch: Throwable -> L10
        return;
    L5:
        if (r0.f7618a != null) goto L8;
        e(r2);     // Catch: Throwable -> L10
        return;
    }

    public static void i(URL r11, u0 r12) {
        if (f7609c != null) goto L6;
        f7609c = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L6:
        Map<String, List<String>> r1 = r12.f7857b;     // Catch: Throwable -> L29
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.containsKey("nb") == false) goto L32;
        List<String> r0 = r12.f7857b.get("nb");     // Catch: Throwable -> L29
        if (r0 != null) goto L13;
        return;
    L13:
        if (r0.size() <= 0) goto L34;
        byte r2 = 0;
        String[] r3 = r0.get(0).split("#");     // Catch: Throwable -> L29
        if (r3.length >= 2) goto L18;
        return;
    L18:
        int r4 = Integer.parseInt(r3[0]);     // Catch: Throwable -> L29
        long r5 = Integer.parseInt(r3[1]);     // Catch: Throwable -> L29
        b r6 = new b(r2);     // Catch: Throwable -> L29
        r6.f7616a = r12;     // Catch: Throwable -> L29
        if (r5 > 0) goto L21;
        r5 = 30;
    L21:
        r6.f7617b = SystemClock.elapsedRealtime() + (r5 * 1000);     // Catch: Throwable -> L29
        if (r4 != 1) goto L25;
        f7609c.put("app", r6);     // Catch: Throwable -> L29
        return;
    L25:
        if (r4 != 2) goto L35;
        if (r11 == null) goto L36;
        f7609c.put(r11.getPath(), r6);     // Catch: Throwable -> L29
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L32:
        return;
    }

    public static void j(boolean r5, String r6) {
        Context r0 = j5.f7428g;     // Catch: Throwable -> L15
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L19;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L15
        r1.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L15
        if (r5 == false) goto L12;
        Integer r7 = g.f7310i;     // Catch: Throwable -> L15
    L11:
        r1.put(WsConstants.KEY_CONNECTION_TYPE, r7);     // Catch: Throwable -> L15
        r1.put("name", r6);     // Catch: Throwable -> L15
        r1.put("version", g.a(r6));     // Catch: Throwable -> L15
        String r8 = r1.toString();     // Catch: Throwable -> L15
        z0 r9 = new z0(r0, "core", "2.0", "O005");     // Catch: Throwable -> L15
        r9.a(r8);     // Catch: Throwable -> L15
        a1.d(r9, r0);     // Catch: Throwable -> L15
        return;
    L12:
        r7 = g.f7309h;     // Catch: Throwable -> L15
        goto L11
    L19:
        return;
    }

    private static void k(boolean r5, String r6, String r7, int r8) {
        Context r0 = j5.f7428g;     // Catch: Throwable -> L31
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L37;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L31
        r1.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L31
        String r2 = g.a(r6);     // Catch: Throwable -> L31
        if (r5 == false) goto L13;
        String r9 = WsConstants.KEY_CONNECTION_TYPE;
        Integer r3 = g.f7312k;     // Catch: Throwable -> L31
    L12:
        r1.put(r9, r3);     // Catch: Throwable -> L31
        r1.put("name", r6);     // Catch: Throwable -> L31
        r1.put("version", r2);     // Catch: Throwable -> L31
        r1.put("uri", Uri.parse(r7).getPath());     // Catch: Throwable -> L31
        r1.put("blockLevel", r8);     // Catch: Throwable -> L31
        String r10 = r1.toString();     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r10) == false) goto L17;
        return;
    L17:
        z0 r11 = new z0(r0, "core", "2.0", "O005");     // Catch: Throwable -> L31
        r11.a(r10);     // Catch: Throwable -> L31
        if (f7612f != null) goto L20;
        f7612f = Collections.synchronizedList(new ArrayList(16));     // Catch: Throwable -> L31
    L20:
        List<z0> r12 = f7612f;     // Catch: Throwable -> L31
        monitor-enter(r12);     // Catch: Throwable -> L31
        f7612f.add(r11);     // Catch: Throwable -> L27
        if (f7612f.size() < 15) goto L25;
        b();     // Catch: Throwable -> L27
    L25:
        monitor-exit(r12);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
        goto L38
    L13:
        r9 = WsConstants.KEY_CONNECTION_TYPE;
        r3 = g.f7311j;     // Catch: Throwable -> L31
        goto L12
    L37:
        return;
    }

    private static boolean l(a r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r7.f7615c != 1.0d) goto L8;
        return false;
    L8:
        long r1 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r7.f7613a) == false) goto L11;
    L25:
        return false;
    L11:
        if (r7.f7614b <= 0) goto L25;
        long r3 = r1 - u5.h(r7.f7613a, "HH:mm:ss").getTimeInMillis();
        if (r3 <= 0) goto L25;
        if (r3 >= (r7.f7614b * 1000)) goto L25;
        if (r7.f7615c != 0.0d) goto L20;
        return true;
    L20:
        if (f7610d != null) goto L22;
        f7610d = new Random();
    L22:
        f7610d.setSeed(((long) UUID.randomUUID().hashCode()) + r1);
        if (f7610d.nextDouble() <= r7.f7615c) goto L25;
        return true;
    }

    private static boolean m(String r4, c r5, String r6) {
        Map<String, List<a>> r7 = r5.f7618a;     // Catch: Throwable -> L24
        if (r7 != null) goto L6;
    L23:
        return false;
    L6:
        if (r7.size() <= 0) goto L23;
        if (r7.containsKey("*") == false) goto L17;
        Iterator<Map.Entry<String, List<a>>> r8 = r7.entrySet().iterator();     // Catch: Throwable -> L24
    L12:
        if (r8.hasNext() == false) goto L26;
        if (n(r8.next().getValue()) == false) goto L12;
        k(false, r6, r4, 1);     // Catch: Throwable -> L24
        return true;
    L26:
        return false;
    L17:
        String r1 = Uri.parse(r4).getPath();     // Catch: Throwable -> L24
        if (r7.containsKey(r1) == false) goto L26;
        if (n(r7.get(r1)) == false) goto L26;
        k(false, r6, r4, 2);     // Catch: Throwable -> L24
        return true;
    L24:
        th = move-exception;
        s.e(th, "hlUtil", "inb");
        goto L26
    }

    private static boolean n(List<a> r2) {
        if (r2 != null) goto L5;
    L14:
        return false;
    L5:
        if (r2.size() <= 0) goto L14;
        Iterator<a> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        if (l(r3.next()) == false) goto L9;
        return true;
    }

    public static u0 o(String r9, String r10) {
        String r0 = "app";
        if (f7609c != null) goto L7;
        return null;
    L7:
        if (f7609c.containsKey("app") == false) goto L17;
        b r2 = f7609c.get("app");     // Catch: Throwable -> L31
        if (SystemClock.elapsedRealtime() > r2.f7617b) goto L15;
        u0 r1 = r2.f7616a;     // Catch: Throwable -> L31
        if (r1 == null) goto L13;
        r1.f7860e = false;     // Catch: Throwable -> L31
    L13:
        k(true, r10, r9, 1);     // Catch: Throwable -> L31
        return r1;
    L15:
        f7609c.remove(r0);     // Catch: Throwable -> L31
        goto L30
    L17:
        if (TextUtils.isEmpty(r9) == false) goto L19;
        return null;
    L19:
        Uri r3 = Uri.parse(r9);     // Catch: Throwable -> L31
        if (r3 == null) goto L30;
        r0 = r3.getPath();     // Catch: Throwable -> L31
        if (f7609c.containsKey(r0) == false) goto L30;
        b r4 = f7609c.get(r0);     // Catch: Throwable -> L31
        if (SystemClock.elapsedRealtime() > r4.f7617b) goto L15;
        u0 r5 = r4.f7616a;     // Catch: Throwable -> L31
        if (r5 == null) goto L28;
        r5.f7860e = false;     // Catch: Throwable -> L31
    L28:
        k(true, r10, r9, 2);     // Catch: Throwable -> L31
        return r5;
    L30:
        return null;
    }

    private static String p(String r3, c r4, String r5) {
        Map<String, String> r6 = r4.f7619b;     // Catch: Throwable -> L12
        if (r6 != null) goto L5;
    L11:
        return r3;
    L5:
        if (r6.size() <= 0) goto L11;
        Uri r0 = Uri.parse(r3);     // Catch: Throwable -> L12
        String r1 = r0.getAuthority();     // Catch: Throwable -> L12
        if (r6.containsKey(r1) == false) goto L17;
        String r7 = r6.get(r1);     // Catch: Throwable -> L12
        r3 = r0.buildUpon().authority(r7).toString();     // Catch: Throwable -> L12
        g(r5, r1, r7);     // Catch: Throwable -> L12
        return r3;
    L17:
        return r3;
    L12:
        th = move-exception;
        s.e(th, "hlUtil", "pdr");
        return r3;
    }

    public static List<z0> q() {
        ArrayList r0 = null;
        List<z0> r1 = f7612f;     // Catch: Throwable -> L22
        monitor-enter(r1);     // Catch: Throwable -> L22
        List<z0> r2 = f7612f;     // Catch: Throwable -> L14
        if (r2 != null) goto L8;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r0;
    L8:
        if (r2.size() <= 0) goto L12;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L14
        r3.addAll(f7612f);     // Catch: Throwable -> L19
        f7612f.clear();     // Catch: Throwable -> L19
        r0 = r3;
        goto L12
    L31:
        Throwable th = th;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L18
    L21:
        return r3;
    L19:
        th = th;
    L14:
        th = move-exception;
        r3 = r0;
        th = th;
    L34:
        return null;
    }

    private static void r(c r6, JSONObject r7) {
        JSONObject r8 = r7.optJSONObject("domainMap");     // Catch: Throwable -> L13
        if (r8 != null) goto L5;
        return;
    L5:
        JSONArray r0 = r8.names();     // Catch: Throwable -> L13
        if (r0 != null) goto L8;
        return;
    L8:
        HashMap r1 = new HashMap(8);     // Catch: Throwable -> L13
        int r2 = r0.length();     // Catch: Throwable -> L13
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        String r4 = r0.optString(r3);     // Catch: Throwable -> L13
        r1.put(r4, r8.optString(r4));     // Catch: Throwable -> L13
        r3 = r3 + 1;     // Catch: Throwable -> L13
        goto L9
    L11:
        r6.f7619b = r1;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        s.e(th, "hlUtil", "pdr");
    }
}
