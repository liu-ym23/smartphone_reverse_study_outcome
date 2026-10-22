package com.facebook.imagepipeline.memory;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
class b0<V> extends f<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LinkedList<d.c.c.h.b<V>> f6678f;

    public b0(int r2, int r3, int r4) {
        super(r2, r3, r4, false);
        this.f6678f = new LinkedList();
    }

    @Override // com.facebook.imagepipeline.memory.f
    void a(V r2) {
        d.c.c.h.b<V> r0 = this.f6678f.poll();
        if (r0 != null) goto L5;
        r0 = new d.c.c.h.b();
    L5:
        r0.c(r2);
        this.f6714c.add(r0);
    }

    @Override // com.facebook.imagepipeline.memory.f
    public V h() {
        d.c.c.h.b<V> r0 = (d.c.c.h.b) this.f6714c.poll();
        V r1 = r0.b();
        r0.a();
        this.f6678f.add(r0);
        return r1;
    }
}
