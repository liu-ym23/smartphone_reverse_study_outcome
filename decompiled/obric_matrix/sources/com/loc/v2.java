package com.loc;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class v2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile v2 f7891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Object f7892h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LongSparseArray<a> f7893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LongSparseArray<a> f7894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LongSparseArray<a> f7895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LongSparseArray<a> f7896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f7897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f7898f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f7900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f7901c;

        private a() {
        }

        /* synthetic */ a(byte r1) {
            this();
        }
    }

    static {
        f7892h = new Object();
    }

    private v2() {
        this.f7897e = new Object();
        this.f7898f = new Object();
        this.f7893a = new LongSparseArray();
        this.f7894b = new LongSparseArray();
        this.f7895c = new LongSparseArray();
        this.f7896d = new LongSparseArray();
    }

    public static v2 a() {
        if (f7891g != null) goto L15;
        Object r0 = f7892h;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7891g != null) goto L9;
        f7891g = new v2();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return f7891g;
    }

    private static short c(LongSparseArray<a> r8, long r9) {
        monitor-enter(r8);
        a r10 = r8.get(r9);     // Catch: Throwable -> L14
        if (r10 == null) goto L6;
        short r11 = (short) Math.max(1, Math.min(32767, (f() - r10.f7900b) / 1000));     // Catch: Throwable -> L14
        if (r10.f7901c == true) goto L12;
        r11 = (short) (-r11);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return r11;
    L6:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return 0;
    L14:
        th = move-exception;
        throw th;
    }

    private static void e(List<u2> r10, LongSparseArray<a> r11, LongSparseArray<a> r12) {
        long r0 = f();
        int r2 = r11.size();
        byte r3 = 0;
        Iterator<u2> r13 = r10.iterator();
        if (r2 != 0) goto L9;
    L5:
        if (r13.hasNext() == false) goto L7;
        u2 r14 = r13.next();
        a r4 = new a(r3);
        r4.f7899a = r14.b();
        r4.f7900b = r0;
        r4.f7901c = false;
        r12.put(r14.a(), r4);
        goto L5
    L7:
        return;
    L9:
        if (r13.hasNext() == false) goto L18;
        u2 r5 = r13.next();
        long r6 = r5.a();
        a r7 = r11.get(r6);
        if (r7 != null) goto L15;
        r7 = new a(r3);
    L13:
        r7.f7899a = r5.b();
        r7.f7900b = r0;
        r7.f7901c = true;
    L17:
        r12.put(r6, r7);
        goto L9
    L15:
        if (r7.f7899a == r5.b()) goto L17;
    }

    private static long f() {
        return SystemClock.elapsedRealtime();
    }

    final short b(long r1) {
        return c(this.f7893a, r1);
    }

    final void d(List<u2> r4) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Object r0 = this.f7897e;
        monitor-enter(r0);
        e(r4, this.f7893a, this.f7894b);     // Catch: Throwable -> L10
        LongSparseArray<a> r5 = this.f7893a;     // Catch: Throwable -> L10
        this.f7893a = this.f7894b;     // Catch: Throwable -> L10
        this.f7894b = r5;     // Catch: Throwable -> L10
        r5.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    final short g(long r1) {
        return c(this.f7895c, r1);
    }

    final void h(List<u2> r4) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Object r0 = this.f7898f;
        monitor-enter(r0);
        e(r4, this.f7895c, this.f7896d);     // Catch: Throwable -> L10
        LongSparseArray<a> r5 = this.f7895c;     // Catch: Throwable -> L10
        this.f7895c = this.f7896d;     // Catch: Throwable -> L10
        this.f7896d = r5;     // Catch: Throwable -> L10
        r5.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
