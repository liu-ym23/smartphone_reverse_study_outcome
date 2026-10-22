package com.ss.android.agilelogger.h;

import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<a, com.ss.android.agilelogger.g.b> f11852a;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f11853f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f11854g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f11855h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f11856i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f11857j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f11858k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f11859l = null;
        public static final a m = null;
        public static final a n = null;
        private static final /* synthetic */ a[] o = null;

        static {
            a r0 = new a("MSG", 0);
            f11853f = r0;
            a r1 = new a("JSON", 1);
            f11854g = r1;
            a r3 = new a("BUNDLE", 2);
            f11855h = r3;
            a r5 = new a("INTENT", 3);
            f11856i = r5;
            a r7 = new a("THROWABLE", 4);
            f11857j = r7;
            a r9 = new a("BORDER", 5);
            f11858k = r9;
            a r11 = new a("STACKTRACE", 6);
            f11859l = r11;
            a r13 = new a("THREAD", 7);
            m = r13;
            a r15 = new a("STACKTRACE_STR", 8);
            n = r15;
            o = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) o.clone();
        }
    }

    static {
        ConcurrentHashMap<a, com.ss.android.agilelogger.g.b> r0 = new ConcurrentHashMap();
        f11852a = r0;
        r0.put(a.f11853f, new com.ss.android.agilelogger.g.d.a());
        f11852a.put(a.f11854g, new com.ss.android.agilelogger.g.d.b.a());
        f11852a.put(a.f11855h, new com.ss.android.agilelogger.g.d.c.a());
        f11852a.put(a.f11856i, new com.ss.android.agilelogger.g.d.c.b());
        f11852a.put(a.f11858k, new com.ss.android.agilelogger.g.c.a());
        f11852a.put(a.f11859l, new com.ss.android.agilelogger.g.e.a());
        f11852a.put(a.m, new com.ss.android.agilelogger.g.f.a());
        f11852a.put(a.f11857j, new com.ss.android.agilelogger.g.d.d.a());
    }

    public static String a(a r1, Intent r2) {
        return ((com.ss.android.agilelogger.g.d.c.b) f11852a.get(r1)).b(r2);
    }

    public static String b(a r1, Bundle r2) {
        return ((com.ss.android.agilelogger.g.d.c.a) f11852a.get(r1)).b(r2);
    }

    public static String c(a r2, String r3) {
        com.ss.android.agilelogger.g.b r0 = f11852a.get(r2);
        if (r0 != null) goto L5;
        return r3;
    L5:
        if (r2 != a.f11858k) goto L9;
        return r0.a(new String[]{r3});
    L9:
        return r0.a(r3);
    }

    public static String d(a r1, Thread r2) {
        return f11852a.get(r1).a(r2);
    }

    public static String e(a r1, Throwable r2) {
        return f11852a.get(r1).a(r2);
    }

    public static String f(a r1, StackTraceElement[] r2) {
        return f11852a.get(r1).a(r2);
    }
}
