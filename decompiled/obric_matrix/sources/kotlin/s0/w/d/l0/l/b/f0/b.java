package kotlin.s0.w.d.l0.l.b.f0;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.l;
import kotlin.n0.d.o;
import kotlin.s0.f;
import kotlin.s0.w.d.l0.b.k;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.k0;
import kotlin.s0.w.d.l0.c.m0;
import kotlin.s0.w.d.l0.c.n0;
import kotlin.s0.w.d.l0.l.b.j;
import kotlin.s0.w.d.l0.l.b.s;
import kotlin.s0.w.d.l0.l.b.v;
import kotlin.s0.w.d.l0.m.n;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements kotlin.s0.w.d.l0.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f20724b;

    /* synthetic */ class a extends l implements kotlin.n0.c.l<String, InputStream> {
        a(Object r2) {
            super(1, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "loadResource";
        }

        @Override // kotlin.n0.d.c
        public final f getOwner() {
            return e0.b(d.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ InputStream invoke(String r1) {
            return m(r1);
        }

        public final InputStream m(String r2) {
            o.f(r2, "p0");
            return ((d) this.receiver).a(r2);
        }
    }

    public b() {
        this.f20724b = new d();
    }

    @Override // kotlin.s0.w.d.l0.b.a
    public m0 a(n r11, h0 r12, Iterable<? extends kotlin.s0.w.d.l0.c.p1.b> r13, kotlin.s0.w.d.l0.c.p1.c r14, kotlin.s0.w.d.l0.c.p1.a r15, boolean r16) {
        o.f(r11, "storageManager");
        o.f(r12, "builtInsModule");
        o.f(r13, "classDescriptorFactories");
        o.f(r14, "platformDependentDeclarationFilter");
        o.f(r15, "additionalClassPartsProvider");
        return b(r11, r12, k.p, r13, r14, r15, r16, new a(this.f20724b));
    }

    public final m0 b(n r27, h0 r28, Set<kotlin.s0.w.d.l0.g.c> r29, Iterable<? extends kotlin.s0.w.d.l0.c.p1.b> r30, kotlin.s0.w.d.l0.c.p1.c r31, kotlin.s0.w.d.l0.c.p1.a r32, boolean r33, kotlin.n0.c.l<? super String, ? extends InputStream> r34) {
        o.f(r27, "storageManager");
        o.f(r28, "module");
        o.f(r29, "packageFqNames");
        o.f(r30, "classDescriptorFactories");
        o.f(r31, "platformDependentDeclarationFilter");
        o.f(r32, "additionalClassPartsProvider");
        o.f(r34, "loadResource");
        ArrayList r9 = new ArrayList(r.q(r29, 10));
        Iterator<T> r7 = r29.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        kotlin.s0.w.d.l0.g.c r1 = (kotlin.s0.w.d.l0.g.c) r7.next();
        String r0 = kotlin.s0.w.d.l0.l.b.f0.a.m.n(r1);
        InputStream r4 = r34.invoke(r0);
        if (r4 == null) goto L9;
        r9.add(c.s.a(r1, r27, r28, r4, r33));
        goto L4
    L9:
        throw new IllegalStateException("Resource not found in classpath: " + r0);
    L10:
        n0 r2 = new n0(r9);
        k0 r3 = new k0(r27, r28);
        kotlin.s0.w.d.l0.l.b.l.a r5 = kotlin.s0.w.d.l0.l.b.l.a.f20842a;
        kotlin.s0.w.d.l0.l.b.o r6 = new kotlin.s0.w.d.l0.l.b.o(r2);
        kotlin.s0.w.d.l0.l.b.f0.a r8 = kotlin.s0.w.d.l0.l.b.f0.a.m;
        kotlin.s0.w.d.l0.l.b.d r10 = new kotlin.s0.w.d.l0.l.b.d(r28, r3, r8);
        v.a r11 = v.a.f20864a;
        kotlin.s0.w.d.l0.l.b.r r12 = kotlin.s0.w.d.l0.l.b.r.f20858a;
        o.e(r12, "DO_NOTHING");
        kotlin.s0.w.d.l0.l.b.k r13 = new kotlin.s0.w.d.l0.l.b.k(r27, r28, r5, r6, r10, r2, r11, r12, kotlin.s0.w.d.l0.d.b.c.a.f19185a, s.a.f20859a, r30, r3, j.f20827a.a(), r32, r31, r8.e(), null, new kotlin.s0.w.d.l0.k.v.b(r27, r.g()), null, null, 851968, null);
        Iterator r14 = r9.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        ((c) r14.next()).M0(r13);
        goto L12
    L14:
        return r2;
    }
}
