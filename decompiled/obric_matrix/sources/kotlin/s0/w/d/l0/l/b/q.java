package kotlin.s0.w.d.l0.l.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.h0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q extends p {
    private final kotlin.s0.w.d.l0.f.z.a m;
    private final kotlin.s0.w.d.l0.l.b.g0.f n;
    private final kotlin.s0.w.d.l0.f.z.d o;
    private final y p;
    private kotlin.s0.w.d.l0.f.m q;
    private kotlin.s0.w.d.l0.k.w.h r;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.b, a1> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ q f20856f;

        a(q r1) {
            this.f20856f = r1;
            super(1);
        }

        public final a1 a(kotlin.s0.w.d.l0.g.b r2) {
            kotlin.n0.d.o.f(r2, "it");
            kotlin.s0.w.d.l0.l.b.g0.f r1 = q.N0(this.f20856f);
            if (r1 != null) goto L7;
            a1 r3 = a1.f18847a;
            kotlin.n0.d.o.e(r3, "NO_SOURCE");
            return r3;
        L7:
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ a1 invoke(kotlin.s0.w.d.l0.g.b r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<Collection<? extends kotlin.s0.w.d.l0.g.f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ q f20857f;

        b(q r1) {
            this.f20857f = r1;
            super(0);
        }

        public final Collection<kotlin.s0.w.d.l0.g.f> a() {
            Collection<kotlin.s0.w.d.l0.g.b> r4 = this.f20857f.O0().b();
            ArrayList r0 = new ArrayList();
            Iterator<T> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L13;
            Object r1 = r5.next();
            kotlin.s0.w.d.l0.g.b r2 = (kotlin.s0.w.d.l0.g.b) r1;
            if (r2.l() == false) goto L8;
        L10:
            boolean r3 = false;
        L11:
            if (r3 == false) goto L4;
            r0.add(r1);
            goto L4
        L8:
            if (i.f20820c.a().contains(r2) == true) goto L10;
            r3 = true;
            goto L11
        L13:
            ArrayList r6 = new ArrayList(kotlin.i0.r.q(r0, 10));
            Iterator r7 = r0.iterator();
        L15:
            if (r7.hasNext() == false) goto L17;
            r6.add(((kotlin.s0.w.d.l0.g.b) r7.next()).j());
            goto L15
        L17:
            return r6;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Collection<? extends kotlin.s0.w.d.l0.g.f> invoke() {
            return a();
        }
    }

    public q(kotlin.s0.w.d.l0.g.c r2, kotlin.s0.w.d.l0.m.n r3, h0 r4, kotlin.s0.w.d.l0.f.m r5, kotlin.s0.w.d.l0.f.z.a r6, kotlin.s0.w.d.l0.l.b.g0.f r7) {
        kotlin.n0.d.o.f(r2, "fqName");
        kotlin.n0.d.o.f(r3, "storageManager");
        kotlin.n0.d.o.f(r4, "module");
        kotlin.n0.d.o.f(r5, "proto");
        kotlin.n0.d.o.f(r6, "metadataVersion");
        super(r2, r3, r4);
        this.m = r6;
        this.n = r7;
        kotlin.s0.w.d.l0.f.p r8 = r5.O();
        kotlin.n0.d.o.e(r8, "proto.strings");
        kotlin.s0.w.d.l0.f.o r9 = r5.N();
        kotlin.n0.d.o.e(r9, "proto.qualifiedNames");
        kotlin.s0.w.d.l0.f.z.d r10 = new kotlin.s0.w.d.l0.f.z.d(r8, r9);
        this.o = r10;
        this.p = new y(r5, r10, r6, new a(this));
        this.q = r5;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.l.b.g0.f N0(q r0) {
        return r0.n;
    }

    @Override // kotlin.s0.w.d.l0.l.b.p
    public /* bridge */ /* synthetic */ h F0() {
        return O0();
    }

    @Override // kotlin.s0.w.d.l0.l.b.p
    public void M0(k r12) {
        kotlin.n0.d.o.f(r12, "components");
        kotlin.s0.w.d.l0.f.m r0 = this.q;
        if (r0 == null) goto L7;
        this.q = null;
        kotlin.s0.w.d.l0.f.l r4 = r0.M();
        kotlin.n0.d.o.e(r4, "proto.`package`");
        this.r = new kotlin.s0.w.d.l0.l.b.g0.i(this, r4, this.o, this.m, this.n, r12, "scope of " + this, new b(this));
        return;
    L7:
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    public y O0() {
        return this.p;
    }

    @Override // kotlin.s0.w.d.l0.c.l0
    public kotlin.s0.w.d.l0.k.w.h q() {
        kotlin.s0.w.d.l0.k.w.h r0 = this.r;
        if (r0 == null) goto L5;
        return r0;
    L5:
        kotlin.n0.d.o.v("_memberScope");
        throw null;
    }
}
