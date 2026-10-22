package com.bytedance.ttnet.s;

import d.b.h.a.a.h.s.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f6617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f6618b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f6619c = true;

    public interface a {
        void a(String r1, com.bytedance.ttnet.m.b r2);
    }

    public interface b {
        void a(String r1, String r2, int r3, boolean r4, JSONObject r5);

        void b(String r1, String r2, String r3, com.bytedance.ttnet.m.b r4);
    }

    static {
    }

    public static void a(String r1, String r2, String r3, com.bytedance.ttnet.m.b r4) {
        b r0 = f6617a;
        if (r0 == null) goto L6;
        r0.b(r1, r2, r3, r4);
        return;
    }

    public static a b() {
        return f6618b;
    }

    public static b c() {
        return f6617a;
    }

    public static void d(String r6, String r7, int r8, boolean r9, JSONObject r10) {
        b r0 = f6617a;
        if (r0 == null) goto L6;
        r0.a(r6, r7, r8, r9, r10);
        return;
    }

    public static void e(boolean r0) {
        f6619c = r0;
    }

    public static void f(b r0) {
        f6617a = r0;
    }

    public static String g(String r4) {
        if (f6619c == true) goto L11;
        return null;
    L11:
        if (j.b(r4).getHost().endsWith(com.bytedance.ttnet.c.a()) == false) goto L9;
        return String.valueOf(System.currentTimeMillis());
    L9:
        return null;
    }
}
