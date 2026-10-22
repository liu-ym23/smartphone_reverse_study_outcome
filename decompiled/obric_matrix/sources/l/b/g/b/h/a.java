package l.b.g.b.h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient k f22083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<c> f22085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f22086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private u f22087j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<u> f22088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<Integer, LinkedList<u>> f22089l;
    private Stack<u> m;
    private Map<Integer, u> n;
    private int o;
    private boolean p;
    private transient int q;

    a(a r5) {
        this.f22083f = new k(r5.f22083f.d());
        this.f22084g = r5.f22084g;
        this.f22086i = r5.f22086i;
        this.f22087j = r5.f22087j;
        ArrayList r0 = new ArrayList();
        this.f22088k = r0;
        r0.addAll(r5.f22088k);
        this.f22089l = new TreeMap();
        Iterator<Integer> r1 = r5.f22089l.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Integer r2 = r1.next();
        this.f22089l.put(r2, (LinkedList) r5.f22089l.get(r2).clone());
        goto L4
    L6:
        Stack<u> r3 = new Stack();
        this.m = r3;
        r3.addAll(r5.m);
        this.f22085h = new ArrayList();
        Iterator<c> r4 = r5.f22085h.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        this.f22085h.add(r4.next().a());
        goto L8
    L10:
        this.n = new TreeMap(r5.n);
        this.o = r5.o;
        this.q = r5.q;
        this.p = r5.p;
    }

    private a(a r4, l.b.a.o r5) {
        this.f22083f = new k(new m(r5));
        this.f22084g = r4.f22084g;
        this.f22086i = r4.f22086i;
        this.f22087j = r4.f22087j;
        ArrayList r6 = new ArrayList();
        this.f22088k = r6;
        r6.addAll(r4.f22088k);
        this.f22089l = new TreeMap();
        Iterator<Integer> r7 = r4.f22089l.keySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Integer r0 = r7.next();
        this.f22089l.put(r0, (LinkedList) r4.f22089l.get(r0).clone());
        goto L4
    L6:
        Stack<u> r8 = new Stack();
        this.m = r8;
        r8.addAll(r4.m);
        this.f22085h = new ArrayList();
        Iterator<c> r9 = r4.f22085h.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        this.f22085h.add(r9.next().a());
        goto L8
    L10:
        this.n = new TreeMap(r4.n);
        this.o = r4.o;
        this.q = r4.q;
        this.p = r4.p;
        g();
    }

    private a(a r5, byte[] r6, byte[] r7, j r8) {
        this.f22083f = new k(r5.f22083f.d());
        this.f22084g = r5.f22084g;
        this.f22086i = r5.f22086i;
        this.f22087j = r5.f22087j;
        ArrayList r0 = new ArrayList();
        this.f22088k = r0;
        r0.addAll(r5.f22088k);
        this.f22089l = new TreeMap();
        Iterator<Integer> r1 = r5.f22089l.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Integer r2 = r1.next();
        this.f22089l.put(r2, (LinkedList) r5.f22089l.get(r2).clone());
        goto L4
    L6:
        Stack<u> r3 = new Stack();
        this.m = r3;
        r3.addAll(r5.m);
        this.f22085h = new ArrayList();
        Iterator<c> r4 = r5.f22085h.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        this.f22085h.add(r4.next().a());
        goto L8
    L10:
        this.n = new TreeMap(r5.n);
        this.o = r5.o;
        this.q = r5.q;
        this.p = false;
        f(r6, r7, r8);
    }

    private a(k r2, int r3, int r4, int r5) {
        this.f22083f = r2;
        this.f22084g = r3;
        this.q = r5;
        this.f22086i = r4;
        if (r4 > r3) goto L14;
        if (r4 < 2) goto L14;
        int r6 = r3 - r4;
        if ((r6 % 2) != 0) goto L14;
        this.f22088k = new ArrayList();
        this.f22089l = new TreeMap();
        this.m = new Stack();
        this.f22085h = new ArrayList();
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L11;
        this.f22085h.add(new c(r7));
        r7 = r7 + 1;
        goto L9
    L11:
        this.n = new TreeMap();
        this.o = 0;
        this.p = false;
        return;
    L14:
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    a(x r3, int r4, int r5) {
        this(r3.i(), r3.b(), r3.c(), r5);
        this.q = r4;
        this.o = r5;
        this.p = true;
    }

    a(x r5, byte[] r6, byte[] r7, j r8) {
        this(r5.i(), r5.b(), r5.c(), (1 << r5.b()) - 1);
        e(r6, r7, r8);
    }

    a(x r5, byte[] r6, byte[] r7, j r8, int r9) {
        this(r5.i(), r5.b(), r5.c(), (1 << r5.b()) - 1);
        e(r6, r7, r8);
    L4:
        if (this.o >= r9) goto L6;
        f(r6, r7, r8);
        this.p = false;
        goto L4
    }

    private c a() {
        Iterator<c> r4 = this.f22085h.iterator();
        c r0 = null;
    L4:
        if (r4.hasNext() == false) goto L20;
        c r1 = r4.next();
        if (r1.h() == true) goto L4;
        if (r1.i() == false) goto L4;
        if (r0 == null) goto L14;
        if (r1.c() < r0.c()) goto L14;
        if (r1.c() != r0.c()) goto L4;
        if (r1.d() >= r0.d()) goto L4;
    L14:
        r0 = r1;
        goto L4
    L20:
        return r0;
    }

    private void e(byte[] r11, byte[] r12, j r13) {
        Objects.requireNonNull(r13, "otsHashAddress == null");
        i r0 = (i) new i.b().g(r13.b()).h(r13.c()).l();
        g r1 = (g) new g.b().g(r13.b()).h(r13.c()).k();
        int r2 = 0;
    L4:
        if (r2 >= (1 << this.f22084g)) goto L31;
        j.b r3 = new j.b().g(r13.b()).h(r13.c());
        r3.p(r2);
        r3.n(r13.e());
        r3.o(r13.f());
        r13 = (j) r3.f(r13.a()).l();
        k r4 = this.f22083f;
        r4.h(r4.g(r12, r13), r11);
        n r5 = this.f22083f.e(r13);
        i.b r6 = new i.b().g(r0.b()).h(r0.c());
        r6.n(r2);
        r6.o(r0.f());
        r6.p(r0.g());
        r0 = (i) r6.f(r0.a()).l();
        u r7 = v.a(this.f22083f, r5, r0);
        g.b r8 = new g.b().g(r1.b()).h(r1.c());
        r8.n(r2);
        r1 = (g) r8.f(r1.a()).k();
    L7:
        if (this.m.isEmpty() == true) goto L30;
        if (this.m.peek().a() != r7.a()) goto L30;
        int r9 = r2 / (1 << r7.a());
        if (r9 != 1) goto L14;
        this.f22088k.add(r7);
    L14:
        if (r9 == 3) goto L16;
    L18:
        if (r9 < 3) goto L29;
        if ((r9 & 1) != 1) goto L29;
        if (r7.a() < (this.f22084g - this.f22086i)) goto L29;
        if (r7.a() > (this.f22084g - 2)) goto L29;
        if (this.f22089l.get(Integer.valueOf(r7.a())) != null) goto L28;
        LinkedList<u> r10 = new LinkedList();
        r10.add(r7);
        this.f22089l.put(Integer.valueOf(r7.a()), r10);
        goto L29
    L28:
        this.f22089l.get(Integer.valueOf(r7.a())).add(r7);
    L29:
        g.b r14 = new g.b().g(r1.b()).h(r1.c());
        r14.m(r1.e());
        r14.n((r1.f() - 1) / 2);
        g r15 = (g) r14.f(r1.a()).k();
        u r16 = v.b(this.f22083f, this.m.pop(), r7, r15);
        u r17 = new u(r16.a() + 1, r16.b());
        g.b r18 = new g.b().g(r15.b()).h(r15.c());
        r18.m(r15.e() + 1);
        r18.n(r15.f());
        r1 = (g) r18.f(r15.a()).k();
        r7 = r17;
        goto L7
    L16:
        if (r7.a() >= (this.f22084g - this.f22086i)) goto L18;
        this.f22085h.get(r7.a()).j(r7);
    L30:
        this.m.push(r7);
        r2 = r2 + 1;
        goto L4
    L31:
        this.f22087j = this.m.pop();
    }

    private void f(byte[] r12, byte[] r13, j r14) {
        Objects.requireNonNull(r14, "otsHashAddress == null");
        if (this.p == true) goto L38;
        int r0 = this.o;
        if (r0 > (this.q - 1)) goto L36;
        int r1 = a0.b(r0, this.f22084g);
        if (((this.o >> (r1 + 1)) & 1) == 0) goto L9;
    L11:
        i r2 = (i) new i.b().g(r14.b()).h(r14.c()).l();
        g r3 = (g) new g.b().g(r14.b()).h(r14.c()).k();
        int r4 = 0;
        if (r1 != 0) goto L14;
        j.b r5 = new j.b().g(r14.b()).h(r14.c());
        r5.p(this.o);
        r5.n(r14.e());
        r5.o(r14.f());
        r14 = (j) r5.f(r14.a()).l();
        k r6 = this.f22083f;
        r6.h(r6.g(r13, r14), r12);
        n r7 = this.f22083f.e(r14);
        i.b r8 = new i.b().g(r2.b()).h(r2.c());
        r8.n(this.o);
        r8.o(r2.f());
        r8.p(r2.g());
        this.f22088k.set(0, v.a(this.f22083f, r7, (i) r8.f(r2.a()).l()));
    L28:
        if (r4 >= ((this.f22084g - this.f22086i) >> 1)) goto L33;
        c r9 = a();
        if (r9 == null) goto L32;
        r9.k(this.m, this.f22083f, r12, r13, r14);
    L32:
        r4 = r4 + 1;
        goto L28
    L33:
        this.o++;
        return;
    L14:
        g.b r10 = new g.b().g(r3.b()).h(r3.c());
        int r11 = r1 - 1;
        r10.m(r11);
        r10.n(this.o >> r1);
        g r15 = (g) r10.f(r3.a()).k();
        k r16 = this.f22083f;
        r16.h(r16.g(r13, r14), r12);
        u r17 = v.b(this.f22083f, this.f22088k.get(r11), this.n.get(Integer.valueOf(r11)), r15);
        this.f22088k.set(r1, new u(r17.a() + 1, r17.b()));
        this.n.remove(Integer.valueOf(r11));
        int r18 = 0;
    L15:
        if (r18 >= r1) goto L21;
        if (r18 >= (this.f22084g - this.f22086i)) goto L19;
        List<u> r19 = this.f22088k;
        u r20 = this.f22085h.get(r18).e();
    L20:
        r19.set(r18, r20);
        r18 = r18 + 1;
        goto L15
    L19:
        r19 = this.f22088k;
        r20 = this.f22089l.get(Integer.valueOf(r18)).removeFirst();
        goto L20
    L21:
        int r21 = Math.min(r1, this.f22084g - this.f22086i);
        int r22 = 0;
    L22:
        if (r22 >= r21) goto L28;
        int r23 = (this.o + 1) + ((1 << r22) * 3);
        if (r23 >= (1 << this.f22084g)) goto L26;
        this.f22085h.get(r22).f(r23);
    L26:
        r22 = r22 + 1;
        goto L22
    L9:
        if (r1 >= (this.f22084g - 1)) goto L11;
        this.n.put(Integer.valueOf(r1), this.f22088k.get(r1));
        goto L11
    L36:
        throw new IllegalStateException("index out of bounds");
    L38:
        throw new IllegalStateException("index already used");
    }

    private void g() {
        if (this.f22088k == null) goto L26;
        if (this.f22089l == null) goto L24;
        if (this.m == null) goto L22;
        if (this.f22085h == null) goto L20;
        if (this.n == null) goto L18;
        if (a0.l(this.f22084g, this.o) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException("index in BDS state out of bounds");
    L18:
        throw new IllegalStateException("keep == null");
    L20:
        throw new IllegalStateException("treeHashInstances == null");
    L22:
        throw new IllegalStateException("stack == null");
    L24:
        throw new IllegalStateException("retain == null");
    L26:
        throw new IllegalStateException("authenticationPath == null");
    }

    protected int b() {
        return this.o;
    }

    public int c() {
        return this.q;
    }

    public a d(byte[] r2, byte[] r3, j r4) {
        return new a(this, r2, r3, r4);
    }

    public a h(l.b.a.o r2) {
        return new a(this, r2);
    }
}
