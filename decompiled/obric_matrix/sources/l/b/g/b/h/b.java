package l.b.g.b.h;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Integer, a> f22093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient long f22094g;

    b(long r2) {
        this.f22093f = new TreeMap();
        this.f22094g = r2;
    }

    b(b r6, long r7) {
        this.f22093f = new TreeMap();
        Iterator<Integer> r0 = r6.f22093f.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Integer r1 = r0.next();
        this.f22093f.put(r1, new a(r6.f22093f.get(r1)));
        goto L4
    L6:
        this.f22094g = r7;
    }

    b(r r12, long r13, byte[] r15, byte[] r16) {
        this.f22093f = new TreeMap();
        this.f22094g = (1 << r12.a()) - 1;
        long r9 = 0;
    L4:
        if (r9 >= r13) goto L6;
        e(r12, r9, r15, r16);
        r9 = r9 + 1;
        goto L4
    }

    a a(int r1) {
        return this.f22093f.get(l.b.h.d.a(r1));
    }

    public long b() {
        return this.f22094g;
    }

    void c(int r1, a r2) {
        this.f22093f.put(l.b.h.d.a(r1), r2);
    }

    a d(int r3, byte[] r4, byte[] r5, j r6) {
        return this.f22093f.put(l.b.h.d.a(r3), this.f22093f.get(l.b.h.d.a(r3)).d(r4, r5, r6));
    }

    void e(r r17, long r18, byte[] r20, byte[] r21) {
        x r5 = r17.h();
        int r6 = r5.b();
        long r7 = a0.j(r18, r6);
        int r9 = a0.i(r18, r6);
        j.b r10 = new j.b().h(r7);
        r10.p(r9);
        j r11 = (j) r10.l();
        int r12 = 1;
        int r13 = (1 << r6) - 1;
        if (r9 >= r13) goto L10;
        if (a(0) == null) goto L7;
        if (r9 == 0) goto L7;
    L8:
        d(0, r20, r21, r11);
    L7:
        c(0, new a(r5, r20, r21, r11));
    L10:
        if (r12 >= r17.b()) goto L21;
        int r14 = a0.i(r7, r6);
        r7 = a0.j(r7, r6);
        j.b r15 = new j.b().g(r12).h(r7);
        r15.p(r14);
        j r16 = (j) r15.l();
        if (this.f22093f.get(Integer.valueOf(r12)) != null) goto L14;
    L15:
        this.f22093f.put(Integer.valueOf(r12), new a(r5, r20, r21, r16));
    L16:
        if (r14 >= r13) goto L20;
        if (a0.m(r18, r6, r12) == false) goto L20;
        d(r12, r20, r21, r16);
    L20:
        r12 = r12 + 1;
        goto L10
    L14:
        if (a0.n(r18, r6, r12) == false) goto L16;
    }

    public b f(l.b.a.o r6) {
        b r0 = new b(this.f22094g);
        Iterator<Integer> r1 = this.f22093f.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Integer r2 = r1.next();
        r0.f22093f.put(r2, this.f22093f.get(r2).h(r6));
        goto L4
    L6:
        return r0;
    }
}
