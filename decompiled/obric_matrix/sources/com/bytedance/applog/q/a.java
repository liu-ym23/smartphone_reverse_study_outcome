package com.bytedance.applog.q;

import com.bytedance.applog.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LinkedList<com.bytedance.applog.w.a> f2304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LinkedList<String> f2305b = null;

    static {
        f2304a = new LinkedList();
        f2305b = new LinkedList();
    }

    public static void a(com.bytedance.applog.w.a r4) {
        LinkedList<com.bytedance.applog.w.a> r0 = f2304a;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.size() <= 1000) goto L7;
        com.bytedance.applog.w.a r1 = r0.poll();     // Catch: Throwable -> L10
        com.bytedance.applog.o.b.e(r1, com.bytedance.applog.r.b.d.f2348i);     // Catch: Throwable -> L10
        com.bytedance.applog.o.b.i(com.bytedance.applog.r.b.a.u, com.bytedance.applog.o.b.a(r1));     // Catch: Throwable -> L10
        n.e("AppLogCache overflow1 remove data: " + r1);     // Catch: Throwable -> L10
    L7:
        r0.add(r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public static void b(String[] r4) {
        LinkedList<String> r0 = f2305b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.size() <= 1000) goto L7;
        String r1 = r0.poll();     // Catch: Throwable -> L10
        com.bytedance.applog.w.a r2 = com.bytedance.applog.w.a.f(r1);     // Catch: Throwable -> L10
        com.bytedance.applog.o.b.e(r2, com.bytedance.applog.r.b.d.f2348i);     // Catch: Throwable -> L10
        com.bytedance.applog.o.b.i(com.bytedance.applog.r.b.a.u, com.bytedance.applog.o.b.a(r2));     // Catch: Throwable -> L10
        n.e("AppLogCache overflow2 remove data: " + r1);     // Catch: Throwable -> L10
    L7:
        r0.addAll(Arrays.asList(r4));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public static int c(ArrayList<com.bytedance.applog.w.a> r2) {
        LinkedList<com.bytedance.applog.w.a> r0 = f2304a;
        monitor-enter(r0);
        int r1 = r0.size();     // Catch: Throwable -> L7
        r2.addAll(r0);     // Catch: Throwable -> L7
        r0.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static String[] d() {
        LinkedList<String> r0 = f2305b;
        int r1 = r0.size();
        if (r1 <= 0) goto L5;
        String[] r2 = new String[r1];
        r0.toArray(r2);
        r0.clear();
        return r2;
    L5:
        return null;
    }
}
