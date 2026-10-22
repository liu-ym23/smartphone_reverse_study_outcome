package d.b.w.a.b.e;

import android.content.Context;
import d.b.w.a.c.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b extends d.b.w.a.b.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f15201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.b.w.a.c.e f15202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f15203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<Long, d.b.w.a.c.e> f15204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<Long, e> f15205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private g f15206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f15207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d.b.w.a.c.c f15208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d f15209l;
    private Map<Long, d.b.w.a.c.d> m;
    private Map<Long, f> n;
    private d.b.w.a.c.f o;
    private a p;

    public b(Context r1, d.b.w.a.a.c r2) {
        super(r1, r2);
        this.f15200c = false;
        this.f15201d = 0;
        this.f15202e = new d.b.w.a.c.e();
        this.f15203f = new e();
        this.f15204g = new HashMap();
        this.f15205h = new HashMap();
        this.f15206i = new g();
        this.f15207j = new c();
        this.f15208k = new d.b.w.a.c.c();
        this.f15209l = new d();
        this.m = new HashMap();
        this.n = new HashMap();
        this.o = new d.b.w.a.c.f();
        this.p = new a();
    }

    private List<List<Integer>> b(List<LinkedHashMap<Long, Long>> r21, long r22) {
        if (r21 == null) goto L27;
        long r2 = 0;
        if (r22 <= 0) goto L37;
        ArrayList r4 = new ArrayList();
        Iterator<LinkedHashMap<Long, Long>> r5 = r21.iterator();
    L9:
        if (r5.hasNext() == false) goto L26;
        LinkedHashMap<Long, Long> r6 = r5.next();
        ArrayList r7 = new ArrayList();
        int r8 = r6.size() / 4;
        Iterator<Map.Entry<Long, Long>> r9 = r6.entrySet().iterator();
        int r10 = 0;
        long r11 = r2;
        long r13 = r11;
        int r12 = 0;
    L12:
        if (r9.hasNext() == false) goto L25;
        Map.Entry<Long, Long> r15 = r9.next();
        Long r18 = r15.getKey();
        Long r16 = r15.getValue();
        if (r18 == null) goto L12;
        if (r16 == null) goto L12;
        r13 = r13 + r16.longValue();
        if (r10 >= 3) goto L22;
        if (r12 >= r8) goto L21;
        r11 = r11 + r16.longValue();
        r12 = r12 + 1;
        goto L12
    L21:
        r7.add(Integer.valueOf((int) ((r11 / r22) * 100.0d)));
        r11 = r16.longValue();
        r10 = r10 + 1;
        r12 = 1;
        goto L12
    L22:
        if (r10 != 3) goto L12;
        r11 = r11 + r16.longValue();
        goto L12
    L25:
        double r14 = r22;
        r7.add(Integer.valueOf((int) ((r11 / r14) * 100.0d)));
        r7.add(Integer.valueOf((int) ((r13 / r14) * 100.0d)));
        r4.add(r7);
        r2 = 0;
        goto L9
    L26:
        return r4;
    L37:
        return null;
    L27:
        return null;
    }

    private d.b.w.a.a.c.b c(List<List<Integer>> r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        boolean r0 = f(r11.size());
        boolean r10 = g(r11.size());
        d.b.w.a.a.c.b r1 = new d.b.w.a.a.c.b();
        Iterator<List<Integer>> r12 = r11.iterator();
        int r3 = 0;
    L7:
        if (r12.hasNext() == false) goto L26;
        List<Integer> r4 = r12.next();
        if (r4 == null) goto L7;
        if (r4.size() < 5) goto L7;
        if (r3 != 0) goto L16;
        r1.f15164a = r4.get(0).intValue();
        r1.f15165b = r4.get(1).intValue();
        r1.f15166c = r4.get(2).intValue();
        r1.f15167d = r4.get(3).intValue();
        float r9 = r4.get(4).intValue();
        r1.f15164a = r9;
        r1.f15168e = r9;
    L16:
        if (r3 != 1) goto L19;
        if (r10 == false) goto L19;
        r1.f15169f = r4.get(0).intValue();
        r1.f15170g = r4.get(1).intValue();
        r1.f15171h = r4.get(2).intValue();
        r1.f15172i = r4.get(3).intValue();
        r1.f15173j = r4.get(4).intValue();
    L19:
        if (r3 != 1) goto L22;
        if (r0 == false) goto L22;
        r1.f15169f = 0.0f;
        r1.f15170g = 0.0f;
        r1.f15171h = 0.0f;
        r1.f15172i = 0.0f;
        r1.f15173j = 0.0f;
        r1.f15174k = r4.get(0).intValue();
        r1.f15175l = r4.get(1).intValue();
        r1.m = r4.get(2).intValue();
        r1.n = r4.get(3).intValue();
        r1.o = r4.get(4).intValue();
    L22:
        if (r3 != 2) goto L25;
        if (r10 == false) goto L25;
        r1.f15174k = r4.get(0).intValue();
        r1.f15175l = r4.get(1).intValue();
        r1.m = r4.get(2).intValue();
        r1.n = r4.get(3).intValue();
        r1.o = r4.get(4).intValue();
    L25:
        r3 = r3 + 1;
        goto L7
    L26:
        return r1;
    }

    private boolean f(int r1) {
        if (r1 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean g(int r1) {
        if (r1 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // d.b.w.a.b.b
    public void a() {
        if (this.f15200c == true) goto L6;
        this.f15200c = true;
        h();
        return;
    }

    public List<List<Integer>> d() {
        if (this.f15184b.getConfig().e() == true) goto L5;
        return null;
    L5:
        return b(this.f15203f.d(), this.f15203f.h());
    }

    public d.b.w.a.a.c.b e() {
        if (this.f15184b.getConfig().e() == true) goto L5;
        return null;
    L5:
        return c(d());
    }

    public void h() {
        if (this.f15200c == false) goto L12;
        long r0 = System.currentTimeMillis();
        if (this.f15184b.getConfig().d() == false) goto L8;
        j(r0);
    L8:
        if (this.f15184b.getConfig().e() == false) goto L10;
        i();
    L10:
        this.f15201d = r0;
        return;
    }

    public void i() {
        e r0 = (e) this.f15202e.b();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(this.f15203f);
        this.f15203f = r0;
        ArrayList<Long> r1 = d.b.w.a.d.d.c();
        HashSet r2 = new HashSet();
        Iterator<Long> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L20;
        long r4 = r3.next().longValue();
        d.b.w.a.c.e r5 = this.f15204g.get(Long.valueOf(r4));
        if (r5 != null) goto L11;
        r5 = new d.b.w.a.c.e((int) r4);
        this.f15204g.put(Long.valueOf(r4), r5);
    L11:
        e r6 = (e) r5.b();
        if (r6 != null) goto L15;
        r2.add(Long.valueOf(r4));
        String r7 = "dead tid found from refresh cpu freq stat: " + r4;
    L14:
        d.b.w.a.d.b.a(r7);
        goto L7
    L15:
        r6.b(this.f15205h.get(Long.valueOf(r4)));
        this.f15205h.put(Long.valueOf(r4), r6);
        if (d.b.w.a.d.d.a() != r4) goto L18;
        d.b.w.a.d.b.a("not merge main thread, id:" + r4);
    L19:
        d.b.w.a.d.b.a("current tid " + r4 + " stat : " + r6);
        r7 = "current tid " + r4 + " delta : " + r6.g();
        goto L14
    L18:
        this.f15203f.j(r6);
        goto L19
    L20:
        Set<Long> r8 = this.f15204g.keySet();
        if (r8 != null) goto L23;
    L30:
        Iterator r9 = r2.iterator();
    L32:
        if (r9.hasNext() == false) goto L34;
        long r10 = ((Long) r9.next()).longValue();
        this.f15204g.remove(Long.valueOf(r10));
        this.f15205h.remove(Long.valueOf(r10));
        goto L32
    L34:
        return;
    L23:
        if (r8.isEmpty() == true) goto L30;
        Iterator<Long> r11 = r8.iterator();
    L26:
        if (r11.hasNext() == false) goto L30;
        Long r12 = r11.next();
        if (r1.contains(r12) == true) goto L26;
        r2.add(r12);
        d.b.w.a.d.b.a("dead tid found from compare last cpu freq stat: " + r12);
        goto L26
    }

    public void j(long r13) {
        c r0 = (c) this.f15206i.b();
        d r1 = (d) this.f15208k.b();
        if (r0 == null) goto L50;
        if (r1 == null) goto L51;
        r0.a(this.f15207j);
        if (this.f15184b.getConfig().f() == false) goto L10;
        r0.b(this.f15207j);
    L10:
        if (this.f15184b.getConfig().g() == false) goto L12;
        a r2 = (a) this.o.b();
        r2.a(this.p);
        r2.b(this.p);
        d.b.w.a.d.b.a("current cpu idle stat : " + r2);
        this.p = r2;
        r0.g(r2.d());
        d.b.w.a.d.b.a("current cpu usage stat : " + r0);
    L12:
        long r3 = r0.c();
        long r14 = r13 - this.f15201d;
        r1.a(this.f15209l);
        r1.f(r3);
        r1.d(r14);
        if (this.f15184b.getConfig().h() == false) goto L39;
        ArrayList<Long> r4 = d.b.w.a.d.d.c();
        HashSet r5 = new HashSet();
        Iterator<Long> r6 = r4.iterator();
    L16:
        if (r6.hasNext() == false) goto L25;
        long r7 = r6.next().longValue();
        d.b.w.a.c.d r9 = this.m.get(Long.valueOf(r7));
        if (r9 != null) goto L20;
        r9 = new d.b.w.a.c.d(r7);
        this.m.put(Long.valueOf(r7), r9);
    L20:
        f r10 = (f) r9.b();
        if (r10 != null) goto L23;
        r5.add(Long.valueOf(r7));
        String r8 = "dead tid found from refresh thread usage: " + r7;
    L24:
        d.b.w.a.d.b.a(r8);
        goto L16
    L23:
        r10.a(this.n.get(Long.valueOf(r7)));
        r10.f(r3);
        r10.d(r14);
        this.n.put(Long.valueOf(r7), r10);
        r8 = "current tid stat : " + r10;
        goto L24
    L25:
        Set<Long> r15 = this.m.keySet();
        if (r15 != null) goto L28;
    L35:
        Iterator r16 = r5.iterator();
    L37:
        if (r16.hasNext() == false) goto L39;
        long r11 = ((Long) r16.next()).longValue();
        this.m.remove(Long.valueOf(r11));
        this.n.remove(Long.valueOf(r11));
        goto L37
    L28:
        if (r15.isEmpty() == true) goto L35;
        Iterator<Long> r17 = r15.iterator();
    L31:
        if (r17.hasNext() == false) goto L35;
        Long r18 = r17.next();
        if (r4.contains(r18) == true) goto L31;
        r5.add(r18);
        d.b.w.a.d.b.a("dead tid found from compare last thread usage: " + r18);
    L39:
        this.f15207j = r0;
        this.f15209l = r1;
        return;
    L51:
        return;
    }
}
