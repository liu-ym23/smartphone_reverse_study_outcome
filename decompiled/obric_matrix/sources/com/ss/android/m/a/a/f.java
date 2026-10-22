package com.ss.android.m.a.a;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f12133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f12134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ExecutorService f12135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile ExecutorService f12136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile ExecutorService f12137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile ScheduledExecutorService f12138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile ExecutorService f12139g;

    static class a implements c {
        a() {
        }

        @Override // com.ss.android.m.a.a.c
        public boolean a() {
            return false;
        }

        @Override // com.ss.android.m.a.a.c
        public boolean b() {
            return false;
        }

        @Override // com.ss.android.m.a.a.c
        public void c(JSONObject r1) {
        }

        @Override // com.ss.android.m.a.a.c
        public boolean d() {
            return false;
        }

        @Override // com.ss.android.m.a.a.c
        public void e(JSONObject r1) {
        }

        @Override // com.ss.android.m.a.a.c
        public void f(JSONObject r1) {
        }

        @Override // com.ss.android.m.a.a.c
        public boolean g() {
            return false;
        }

        @Override // com.ss.android.m.a.a.c
        public void h(JSONObject r1) {
        }
    }

    static {
        f12133a = g.g().g();
        f12134b = new a();
    }

    public f() {
    }

    public static ExecutorService a(h r2) {
        k r0 = r2.f12152a;
        if (r0 == k.f12171f) goto L11;
        if (r0 == k.f12172g) goto L11;
        if (r0 == k.f12173h) goto L11;
        return i.b().a(r2, false);
    L11:
        throw new IllegalArgumentException();
    }

    public static ExecutorService b() {
        if (f12137e != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12137e != null) goto L9;
        f12137e = i.b().a(h.a(k.f12173h).h(), true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f12137e;
    }

    public static g c() {
        return f12133a;
    }

    public static ExecutorService d() {
        if (f12136d != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12136d != null) goto L9;
        f12136d = i.b().a(h.a(k.f12172g).h(), true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f12136d;
    }

    public static ExecutorService e() {
        if (f12135c != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12135c != null) goto L9;
        f12135c = i.b().a(h.a(k.f12171f).h(), true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f12135c;
    }

    public static ScheduledExecutorService f() {
        if (f12138f != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12138f != null) goto L9;
        i r1 = i.b();     // Catch: Throwable -> L11
        h.b r2 = h.a(k.f12174i);     // Catch: Throwable -> L11
        r2.i(1);     // Catch: Throwable -> L11
        f12138f = (ScheduledExecutorService) r1.a(r2.h(), true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f12138f;
    }

    public static ExecutorService g() {
        if (f12139g != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12139g != null) goto L9;
        f12139g = i.b().a(h.a(k.f12175j).h(), true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f12139g;
    }

    public static c h() {
        return f12134b;
    }

    static boolean i(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Iterator<String> r0 = f12133a.b().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        if (r3.contains(r0.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public static boolean j(ExecutorService r1) {
        if (r1 != e()) goto L5;
    L14:
        return true;
    L5:
        if (r1 == d()) goto L14;
        if (r1 == b()) goto L14;
        if (r1 == f()) goto L14;
        if (r1 == g()) goto L14;
        return false;
    }
}
