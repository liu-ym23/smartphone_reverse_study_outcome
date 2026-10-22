package kotlin.s0.w.d.l0.e.a;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.i0.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f0 f19656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f0 f19657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.g.c, f0> f19658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.h f19659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f19660e;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<String[]> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y f19661f;

        a(y r1) {
            this.f19661f = r1;
            super(0);
        }

        public final String[] a() {
            y r4 = this.f19661f;
            List r0 = kotlin.i0.r.c();
            r0.add(r4.a().b());
            f0 r1 = r4.b();
            if (r1 == null) goto L5;
            r0.add("under-migration:" + r1.b());
        L5:
            Iterator<Map.Entry<kotlin.s0.w.d.l0.g.c, f0>> r5 = r4.c().entrySet().iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            Map.Entry<kotlin.s0.w.d.l0.g.c, f0> r2 = r5.next();
            r0.add('@' + r2.getKey() + ':' + r2.getValue().b());
            goto L7
        L9:
            Object[] r6 = kotlin.i0.r.a(r0).toArray(new String[0]);
            kotlin.n0.d.o.d(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (String[]) r6;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String[] invoke() {
            return a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(f0 r2, f0 r3, Map<kotlin.s0.w.d.l0.g.c, ? extends f0> r4) {
        kotlin.n0.d.o.f(r2, "globalLevel");
        kotlin.n0.d.o.f(r4, "userDefinedLevelForSpecificAnnotation");
        this.f19656a = r2;
        this.f19657b = r3;
        this.f19658c = r4;
        this.f19659d = kotlin.i.b(new a(this));
        f0 r0 = f0.f19253g;
        if (r2 != r0) goto L8;
        if (r3 != r0) goto L8;
        if (r4.isEmpty() == false) goto L8;
        boolean r5 = true;
    L9:
        this.f19660e = r5;
        return;
    L8:
        r5 = false;
        goto L9
    }

    public /* synthetic */ y(f0 r1, f0 r2, Map r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = m0.h();
    L8:
        this(r1, r2, r3);
    }

    public final f0 a() {
        return this.f19656a;
    }

    public final f0 b() {
        return this.f19657b;
    }

    public final Map<kotlin.s0.w.d.l0.g.c, f0> c() {
        return this.f19658c;
    }

    public final boolean d() {
        return this.f19660e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
        if (this.f19656a == r6.f19656a) goto L12;
        return false;
    L12:
        if (this.f19657b == r6.f19657b) goto L15;
        return false;
    L15:
        if (kotlin.n0.d.o.a(this.f19658c, r6.f19658c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f19656a.hashCode() * 31;
        f0 r1 = this.f19657b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.f19658c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f19656a + ", migrationLevel=" + this.f19657b + ", userDefinedLevelForSpecificAnnotation=" + this.f19658c + ')';
    }
}
