package l.b.g.b.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map<Integer, x> f22184i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f22185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l.b.a.o f22188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f22190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m f22192h;

    static {
        HashMap r0 = new HashMap();
        Integer r1 = l.b.h.d.a(1);
        l.b.a.o r3 = l.b.a.o2.a.f21649c;
        r0.put(r1, new x(10, r3));
        r0.put(l.b.h.d.a(2), new x(16, r3));
        r0.put(l.b.h.d.a(3), new x(20, r3));
        Integer r2 = l.b.h.d.a(4);
        l.b.a.o r4 = l.b.a.o2.a.f21651e;
        r0.put(r2, new x(10, r4));
        r0.put(l.b.h.d.a(5), new x(16, r4));
        r0.put(l.b.h.d.a(6), new x(20, r4));
        Integer r5 = l.b.h.d.a(7);
        l.b.a.o r6 = l.b.a.o2.a.f21658l;
        r0.put(r5, new x(10, r6));
        r0.put(l.b.h.d.a(8), new x(16, r6));
        r0.put(l.b.h.d.a(9), new x(20, r6));
        Integer r7 = l.b.h.d.a(10);
        l.b.a.o r8 = l.b.a.o2.a.m;
        r0.put(r7, new x(10, r8));
        r0.put(l.b.h.d.a(11), new x(16, r8));
        r0.put(l.b.h.d.a(12), new x(20, r8));
        f22184i = Collections.unmodifiableMap(r0);
    }

    public x(int r4, l.b.a.o r5) {
        if (r4 < 2) goto L7;
        Objects.requireNonNull(r5, "digest == null");
        this.f22186b = r4;
        this.f22187c = a();
        String r0 = f.b(r5);
        this.f22190f = r0;
        this.f22188d = r5;
        m r1 = new m(r5);
        this.f22192h = r1;
        int r6 = r1.c();
        this.f22191g = r6;
        int r2 = r1.d();
        this.f22189e = r2;
        this.f22185a = e.c(r0, r6, r2, r1.a(), r4);
        return;
    L7:
        throw new IllegalArgumentException("height must be >= 2");
    }

    public x(int r1, l.b.b.a r2) {
        this(r1, f.c(r2.e()));
    }

    private int a() {
        int r1 = 2;
    L3:
        int r2 = this.f22186b;
        if (r1 > r2) goto L10;
        if (((r2 - r1) % 2) == 0) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r1;
    L10:
        throw new IllegalStateException("should never happen...");
    }

    public static x k(int r1) {
        return f22184i.get(l.b.h.d.a(r1));
    }

    public int b() {
        return this.f22186b;
    }

    int c() {
        return this.f22187c;
    }

    int d() {
        return this.f22192h.a();
    }

    w e() {
        return this.f22185a;
    }

    String f() {
        return this.f22190f;
    }

    public l.b.a.o g() {
        return this.f22188d;
    }

    public int h() {
        return this.f22191g;
    }

    k i() {
        return new k(this.f22192h);
    }

    int j() {
        return this.f22189e;
    }
}
