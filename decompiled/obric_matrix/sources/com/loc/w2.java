package com.loc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class w2 {

    public static class a implements u2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f7934c;

        a(int r1, int r2, int r3) {
            this.f7932a = r1;
            this.f7933b = r2;
            this.f7934c = r3;
        }

        @Override // com.loc.u2
        public final long a() {
            return w2.a(this.f7932a, this.f7933b);
        }

        @Override // com.loc.u2
        public final int b() {
            return this.f7934c;
        }
    }

    public static class b implements u2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f7935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7936b;

        b(long r1, int r3) {
            this.f7935a = r1;
            this.f7936b = r3;
        }

        @Override // com.loc.u2
        public final long a() {
            return this.f7935a;
        }

        @Override // com.loc.u2
        public final int b() {
            return this.f7936b;
        }
    }

    public static long a(int r4, int r5) {
        long r0 = (((long) r4) & 4294967295L) << 32;
        return (((long) r5) & 4294967295L) | r0;
    }

    public static synchronized short b(long r2) {
        monitor-enter(w2.class);
        short r3 = v2.a().b(r2);     // Catch: Throwable -> L7
        monitor-exit(w2.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void c(List<a3> r6) {
        monitor-enter(w2.class);
        if (r6 != null) goto L32;
    L30:
        monitor-exit(w2.class);
        return;
    L32:
    L27:
        th = move-exception;
        throw th;
    L6:
        if (r6.isEmpty() == true) goto L30;
        ArrayList r1 = new ArrayList(r6.size());     // Catch: Throwable -> L27
        Iterator<a3> r7 = r6.iterator();     // Catch: Throwable -> L27
    L10:
        if (r7.hasNext() == false) goto L24;
        a3 r2 = r7.next();     // Catch: Throwable -> L27
        if ((r2 instanceof d3) == true) goto L13;
        if ((r2 instanceof e3) == true) goto L17;
        if ((r2 instanceof f3) == true) goto L20;
        if ((r2 instanceof c3) == false) goto L10;
        c3 r3 = (c3) r2;     // Catch: Throwable -> L27
        a r4 = new a(r3.p, r3.q, r3.f7141h);     // Catch: Throwable -> L27
    L14:
        r1.add(r4);     // Catch: Throwable -> L27
        goto L10
    L20:
        f3 r5 = (f3) r2;     // Catch: Throwable -> L27
        r4 = new a(r5.o, r5.p, r5.f7141h);     // Catch: Throwable -> L27
        goto L14
    L17:
        e3 r8 = (e3) r2;     // Catch: Throwable -> L27
        r4 = new a(r8.o, r8.p, r8.f7141h);     // Catch: Throwable -> L27
        goto L14
    L13:
        d3 r9 = (d3) r2;     // Catch: Throwable -> L27
        r4 = new a(r9.o, r9.p, r9.f7141h);     // Catch: Throwable -> L27
        goto L14
    L24:
        v2.a().d(r1);     // Catch: Throwable -> L27
        monitor-exit(w2.class);
    }

    public static synchronized short d(long r2) {
        monitor-enter(w2.class);
        short r3 = v2.a().g(r2);     // Catch: Throwable -> L7
        monitor-exit(w2.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void e(List<i3> r6) {
        monitor-enter(w2.class);
        if (r6 != null) goto L20;
    L18:
        monitor-exit(w2.class);
        return;
    L20:
    L15:
        th = move-exception;
        throw th;
    L6:
        if (r6.isEmpty() == true) goto L18;
        ArrayList r1 = new ArrayList(r6.size());     // Catch: Throwable -> L15
        Iterator<i3> r7 = r6.iterator();     // Catch: Throwable -> L15
    L10:
        if (r7.hasNext() == false) goto L12;
        i3 r2 = r7.next();     // Catch: Throwable -> L15
        r1.add(new b(r2.f7373a, r2.f7375c));     // Catch: Throwable -> L15
        goto L10
    L12:
        v2.a().h(r1);     // Catch: Throwable -> L15
        monitor-exit(w2.class);
    }
}
