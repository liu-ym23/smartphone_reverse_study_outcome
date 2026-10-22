package l.b.g.b.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<Integer, r> f22153e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f22154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f22155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22157d;

    static {
        HashMap r0 = new HashMap();
        Integer r1 = l.b.h.d.a(1);
        l.b.a.o r3 = l.b.a.o2.a.f21649c;
        r0.put(r1, new r(20, 2, r3));
        r0.put(l.b.h.d.a(2), new r(20, 4, r3));
        r0.put(l.b.h.d.a(3), new r(40, 2, r3));
        r0.put(l.b.h.d.a(4), new r(40, 4, r3));
        r0.put(l.b.h.d.a(5), new r(40, 8, r3));
        r0.put(l.b.h.d.a(6), new r(60, 3, r3));
        r0.put(l.b.h.d.a(7), new r(60, 6, r3));
        r0.put(l.b.h.d.a(8), new r(60, 12, r3));
        Integer r4 = l.b.h.d.a(9);
        l.b.a.o r10 = l.b.a.o2.a.f21651e;
        r0.put(r4, new r(20, 2, r10));
        r0.put(l.b.h.d.a(10), new r(20, 4, r10));
        r0.put(l.b.h.d.a(11), new r(40, 2, r10));
        r0.put(l.b.h.d.a(12), new r(40, 4, r10));
        r0.put(l.b.h.d.a(13), new r(40, 8, r10));
        r0.put(l.b.h.d.a(14), new r(60, 3, r10));
        r0.put(l.b.h.d.a(15), new r(60, 6, r10));
        r0.put(l.b.h.d.a(16), new r(60, 12, r10));
        Integer r5 = l.b.h.d.a(17);
        l.b.a.o r11 = l.b.a.o2.a.f21658l;
        r0.put(r5, new r(20, 2, r11));
        r0.put(l.b.h.d.a(18), new r(20, 4, r11));
        r0.put(l.b.h.d.a(19), new r(40, 2, r11));
        r0.put(l.b.h.d.a(20), new r(40, 4, r11));
        r0.put(l.b.h.d.a(21), new r(40, 8, r11));
        r0.put(l.b.h.d.a(22), new r(60, 3, r11));
        r0.put(l.b.h.d.a(23), new r(60, 6, r11));
        r0.put(l.b.h.d.a(24), new r(60, 12, r11));
        Integer r6 = l.b.h.d.a(25);
        l.b.a.o r12 = l.b.a.o2.a.m;
        r0.put(r6, new r(20, 2, r12));
        r0.put(l.b.h.d.a(26), new r(20, 4, r12));
        r0.put(l.b.h.d.a(27), new r(40, 2, r12));
        r0.put(l.b.h.d.a(28), new r(40, 4, r12));
        r0.put(l.b.h.d.a(29), new r(40, 8, r12));
        r0.put(l.b.h.d.a(30), new r(60, 3, r12));
        r0.put(l.b.h.d.a(31), new r(60, 6, r12));
        r0.put(l.b.h.d.a(32), new r(60, 12, r12));
        f22153e = Collections.unmodifiableMap(r0);
    }

    public r(int r8, int r9, l.b.a.o r10) {
        this.f22156c = r8;
        this.f22157d = r9;
        this.f22155b = new x(j(r8, r9), r10);
        this.f22154a = d.c(e(), f(), g(), c(), a(), r9);
    }

    public r(int r1, int r2, l.b.b.a r3) {
        this(r1, r2, f.c(r3.e()));
    }

    public static r i(int r1) {
        return f22153e.get(l.b.h.d.a(r1));
    }

    private static int j(int r1, int r2) {
        if (r1 < 2) goto L14;
        if ((r1 % r2) != 0) goto L12;
        int r3 = r1 / r2;
        if (r3 == 1) goto L10;
        return r3;
    L10:
        throw new IllegalArgumentException("height / layers must be greater than 1");
    L12:
        throw new IllegalArgumentException("layers must divide totalHeight without remainder");
    L14:
        throw new IllegalArgumentException("totalHeight must be > 1");
    }

    public int a() {
        return this.f22156c;
    }

    public int b() {
        return this.f22157d;
    }

    protected int c() {
        return this.f22155b.d();
    }

    protected w d() {
        return this.f22154a;
    }

    protected String e() {
        return this.f22155b.f();
    }

    public int f() {
        return this.f22155b.h();
    }

    int g() {
        return this.f22155b.j();
    }

    protected x h() {
        return this.f22155b;
    }
}
