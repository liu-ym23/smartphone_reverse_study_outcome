package com.loc;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile b2 f7153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Object f7154g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z1 f7155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c2 f7156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h3 f7157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private w1 f7158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h3 f7159e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h3 f7160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<i3> f7161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f7163d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7164e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f7165f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f7166g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f7167h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<a3> f7168i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f7169j;

        public a() {
        }
    }

    static {
        f7154g = new Object();
    }

    private b2() {
        this.f7159e = new h3();
        this.f7155a = new z1();
        this.f7156b = new c2();
        this.f7158d = new w1();
    }

    public static b2 a() {
        if (f7153f != null) goto L15;
        Object r0 = f7154g;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7153f != null) goto L9;
        f7153f = new b2();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return f7153f;
    }

    public final d2 b(a r20) {
        d2 r2 = null;
        if (r20 != null) goto L5;
        return null;
    L5:
        long r11 = System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        h3 r3 = this.f7157c;
        if (r3 != null) goto L8;
    L9:
        z1.a r15 = this.f7155a.a(r20.f7160a, r20.f7169j, r20.f7166g, r20.f7167h, r20.f7168i);
        List<i3> r18 = this.f7156b.a(r20.f7160a, r20.f7161b, r20.f7164e, r20.f7163d, r11);
        if (r15 != null) goto L12;
        if (r18 != null) goto L12;
    L13:
        this.f7157c = r20.f7160a;
    L14:
        return r2;
    L12:
        y2.a(this.f7159e, r20.f7160a, r20.f7165f, r11);
        r2 = new d2(0, this.f7158d.f(this.f7159e, r15, r20.f7162c, r18));
        goto L13
    L8:
        if (r20.f7160a.a(r3) < 10.0d) goto L14;
        goto L9
    }
}
