package kotlin.s0.w.d.l0.l.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.m0;
import kotlin.s0.w.d.l0.c.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.c f20894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.a f20895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.n0.c.l<kotlin.s0.w.d.l0.g.b, a1> f20896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.f.c> f20897d;

    /* JADX WARN: Multi-variable type inference failed */
    public y(kotlin.s0.w.d.l0.f.m r2, kotlin.s0.w.d.l0.f.z.c r3, kotlin.s0.w.d.l0.f.z.a r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.b, ? extends a1> r5) {
        kotlin.n0.d.o.f(r2, "proto");
        kotlin.n0.d.o.f(r3, "nameResolver");
        kotlin.n0.d.o.f(r4, "metadataVersion");
        kotlin.n0.d.o.f(r5, "classSource");
        this.f20894a = r3;
        this.f20895b = r4;
        this.f20896c = r5;
        List<kotlin.s0.w.d.l0.f.c> r6 = r2.J();
        kotlin.n0.d.o.e(r6, "proto.class_List");
        LinkedHashMap r7 = new LinkedHashMap(kotlin.r0.e.c(m0.d(kotlin.i0.r.q(r6, 10)), 16));
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Object r9 = r8.next();
        r7.put(x.a(this.f20894a, ((kotlin.s0.w.d.l0.f.c) r9).E0()), r9);
        goto L4
    L6:
        this.f20897d = r7;
    }

    @Override // kotlin.s0.w.d.l0.l.b.h
    public g a(kotlin.s0.w.d.l0.g.b r5) {
        kotlin.n0.d.o.f(r5, "classId");
        kotlin.s0.w.d.l0.f.c r0 = this.f20897d.get(r5);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new g(this.f20894a, r0, this.f20895b, this.f20896c.invoke(r5));
    }

    public final Collection<kotlin.s0.w.d.l0.g.b> b() {
        return this.f20897d.keySet();
    }
}
