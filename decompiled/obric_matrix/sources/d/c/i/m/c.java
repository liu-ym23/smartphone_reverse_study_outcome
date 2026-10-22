package d.c.i.m;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<d> f16192a;

    public c(Set<d> r3) {
        this.f16192a = new ArrayList(r3.size());
        Iterator<d> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        d r0 = r4.next();
        if (r0 == null) goto L4;
        this.f16192a.add(r0);
        goto L4
    }

    public c(d... r5) {
        this.f16192a = new ArrayList(r5.length);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        d r2 = r5[r1];
        if (r2 == null) goto L7;
        this.f16192a.add(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private void o(String r1, Throwable r2) {
        d.c.c.e.a.k("ForwardingRequestListener", r1, r2);
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void a(d.c.i.q.b r5, Object r6, String r7, boolean r8) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).a(r5, r6, r7, r8);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onRequestStart", e);
        goto L9
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void b(String r5, String r6) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).b(r5, r6);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onProducerStart", e);
        goto L9
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void c(d.c.i.q.b r5, String r6, boolean r7) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).c(r5, r6, r7);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onRequestSuccess", e);
        goto L9
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void d(String r5, String r6, Map<String, String> r7) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).d(r5, r6, r7);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onProducerFinishWithCancellation", e);
        goto L9
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void e(String r5, String r6, boolean r7) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).e(r5, r6, r7);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onProducerFinishWithSuccess", e);
        goto L9
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public boolean f(String r5) {
        int r0 = this.f16192a.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (this.f16192a.get(r2).f(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void g(d.c.i.q.b r5, String r6, Throwable r7, boolean r8) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).g(r5, r6, r7, r8);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onRequestFailure", e);
        goto L9
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void h(String r5, String r6, String r7) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).h(r5, r6, r7);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onIntermediateChunkStart", e);
        goto L9
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void i(String r5, String r6, Map<String, String> r7) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).i(r5, r6, r7);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onProducerFinishWithSuccess", e);
        goto L9
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void j(String r5, String r6, Throwable r7, Map<String, String> r8) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).j(r5, r6, r7, r8);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onProducerFinishWithFailure", e);
        goto L9
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void k(String r5) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        this.f16192a.get(r1).k(r5);     // Catch: Exception -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        o("InternalListener exception in onRequestCancellation", e);
        goto L9
    }

    @Override // d.c.i.m.b
    public void l(d.c.i.q.b r5, String r6, boolean r7) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        d r2 = this.f16192a.get(r1);
    L9:
        e = move-exception;
        o("InternalListener exception in onRequestIntermediateResult", e);
    L11:
        r1 = r1 + 1;
        goto L3
    L6:
        if ((r2 instanceof b) == false) goto L11;
        ((b) r2).l(r5, r6, r7);     // Catch: Exception -> L9
        goto L11
    }

    public void m(d r1) {
        this.f16192a.add(r1);
    }

    public byte[] n(InputStream r4) {
        int r0 = this.f16192a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if ((this.f16192a.get(r1) instanceof a) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return ((a) this.f16192a.get(r1)).l(r4);
    L9:
        return null;
    }
}
