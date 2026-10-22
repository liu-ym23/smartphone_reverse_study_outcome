package d.g.a.a.i;

import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<a, d.g.a.a.h.b> f16723a;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f16724f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f16725g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f16726h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f16727i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f16728j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f16729k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f16730l = null;
        public static final a m = null;
        public static final a n = null;
        private static final /* synthetic */ a[] o = null;

        static {
            a r0 = new a("MSG", 0);
            f16724f = r0;
            a r1 = new a("JSON", 1);
            f16725g = r1;
            a r3 = new a("BUNDLE", 2);
            f16726h = r3;
            a r5 = new a("INTENT", 3);
            f16727i = r5;
            a r7 = new a("THROWABLE", 4);
            f16728j = r7;
            a r9 = new a("BORDER", 5);
            f16729k = r9;
            a r11 = new a("STACKTRACE", 6);
            f16730l = r11;
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
        ConcurrentHashMap<a, d.g.a.a.h.b> r0 = new ConcurrentHashMap();
        f16723a = r0;
        r0.put(a.f16724f, new d.g.a.a.h.d.a());
        f16723a.put(a.f16725g, new d.g.a.a.h.d.b.a());
        f16723a.put(a.f16726h, new d.g.a.a.h.d.c.a());
        f16723a.put(a.f16727i, new d.g.a.a.h.d.c.b());
        f16723a.put(a.f16729k, new d.g.a.a.h.c.a());
        f16723a.put(a.f16730l, new d.g.a.a.h.e.a());
        f16723a.put(a.m, new d.g.a.a.h.f.a());
        f16723a.put(a.f16728j, new d.g.a.a.h.d.d.a());
    }

    public static String a(a r1, Intent r2) {
        return ((d.g.a.a.h.d.c.b) f16723a.get(r1)).b(r2);
    }

    public static String b(a r1, Bundle r2) {
        return ((d.g.a.a.h.d.c.a) f16723a.get(r1)).b(r2);
    }

    public static String c(a r2, String r3) {
        d.g.a.a.h.b r0 = f16723a.get(r2);
        if (r0 != null) goto L5;
        return r3;
    L5:
        if (r2 != a.f16729k) goto L9;
        return r0.a(new String[]{r3});
    L9:
        return r0.a(r3);
    }

    public static String d(a r1, Thread r2) {
        return f16723a.get(r1).a(r2);
    }

    public static String e(a r1, Throwable r2) {
        return f16723a.get(r1).a(r2);
    }

    public static String f(a r1, StackTraceElement[] r2) {
        return f16723a.get(r1).a(r2);
    }
}
