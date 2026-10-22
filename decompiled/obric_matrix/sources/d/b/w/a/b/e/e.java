package d.b.w.a.b.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements d.b.w.a.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f15223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f15224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f15225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Integer> f15227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f15229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f15230h;

    public e() {
        this.f15223a = new ArrayList();
        this.f15224b = new ArrayList();
        this.f15225c = new ArrayList();
        this.f15226d = false;
        this.f15228f = 0;
        this.f15229g = 0;
        this.f15230h = 0;
    }

    private long i(List<LinkedHashMap<Long, Long>> r7) {
        if (this.f15226d == true) goto L5;
        this.f15227e = d.b.w.a.d.a.a();
        this.f15226d = true;
    L5:
        long r0 = 0;
        if (r7 != null) goto L8;
    L18:
        return r0;
    L8:
        if (r7.isEmpty() == true) goto L18;
        int r2 = r7.size();
        if (r2 != this.f15227e.size()) goto L18;
        int r6 = 0;
    L12:
        if (r6 >= r2) goto L18;
        Iterator<Map.Entry<Long, Long>> r3 = r7.get(r6).entrySet().iterator();
    L15:
        if (r3.hasNext() == false) goto L17;
        r0 = r0 + r3.next().getValue().longValue();
        goto L15
    L17:
        r6 = r6 + 1;
        goto L12
    }

    public void a(LinkedHashMap<Long, Long> r1) {
        if (r1 == null) goto L5;
        this.f15223a.add(r1);
        return;
    }

    public void b(d.b.w.a.c.b r12) {
        if (r12 != null) goto L5;
        this.f15224b.addAll(this.f15223a);
        return;
    L5:
        List<LinkedHashMap<Long, Long>> r13 = ((e) r12).e();
        if (r13.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f15223a.size() == r13.size()) goto L12;
        d.b.w.a.d.b.g("calculate proc freqTime delta size error");
        return;
    L12:
        this.f15224b.clear();
        int r0 = 0;
    L14:
        if (r0 >= this.f15223a.size()) goto L23;
        LinkedHashMap<Long, Long> r1 = this.f15223a.get(r0);
        LinkedHashMap<Long, Long> r2 = r13.get(r0);
        LinkedHashMap<Long, Long> r3 = new LinkedHashMap();
        Iterator<Map.Entry<Long, Long>> r4 = r1.entrySet().iterator();
    L17:
        if (r4.hasNext() == false) goto L22;
        Map.Entry<Long, Long> r5 = r4.next();
        Long r6 = r5.getKey();
        Long r7 = r5.getValue();
        Long r8 = r2.get(r6);
        if (r8 != null) goto L20;
        d.b.w.a.d.b.c("calculate proc freqTime delta not found " + r6);
        goto L17
    L20:
        r3.put(r6, Long.valueOf(r7.longValue() - r8.longValue()));
        goto L17
    L22:
        this.f15224b.add(r3);
        r0 = r0 + 1;
        goto L14
    }

    public List<LinkedHashMap<Long, Long>> c() {
        return this.f15224b;
    }

    public List<LinkedHashMap<Long, Long>> d() {
        return this.f15225c;
    }

    public List<LinkedHashMap<Long, Long>> e() {
        return this.f15223a;
    }

    public long f() {
        if (this.f15228f != 0) goto L6;
        this.f15228f = i(this.f15223a);
    L6:
        return this.f15228f;
    }

    public long g() {
        if (this.f15229g != 0) goto L6;
        this.f15229g = i(this.f15224b);
    L6:
        return this.f15229g;
    }

    public long h() {
        if (this.f15230h != 0) goto L6;
        this.f15230h = i(this.f15225c);
    L6:
        return this.f15230h;
    }

    public void j(d.b.w.a.c.b r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        e r15 = (e) r14;
        List<LinkedHashMap<Long, Long>> r0 = r15.e();
        List<LinkedHashMap<Long, Long>> r16 = r15.c();
        if (r16.isEmpty() == true) goto L9;
        r0 = r16;
    L9:
        if (this.f15225c.isEmpty() == false) goto L12;
        this.f15225c.addAll(r0);
        return;
    L12:
        int r17 = this.f15225c.size();
        if (r17 == r0.size()) goto L16;
        d.b.w.a.d.b.g("merge freqTime size error");
        return;
    L16:
        ArrayList r1 = new ArrayList();
        int r2 = 0;
    L17:
        if (r2 >= r17) goto L26;
        LinkedHashMap<Long, Long> r3 = this.f15225c.get(r2);
        LinkedHashMap<Long, Long> r4 = r0.get(r2);
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<Map.Entry<Long, Long>> r6 = r3.entrySet().iterator();
    L20:
        if (r6.hasNext() == false) goto L25;
        Map.Entry<Long, Long> r7 = r6.next();
        Long r8 = r7.getKey();
        Long r9 = r7.getValue();
        Long r10 = r4.get(r8);
        if (r10 != null) goto L23;
        d.b.w.a.d.b.g("merge freqTimeDetla freq not found " + r8);
        goto L20
    L23:
        r5.put(r8, Long.valueOf(r9.longValue() + r10.longValue()));
        goto L20
    L25:
        r1.add(r5);
        r2 = r2 + 1;
        goto L17
    L26:
        this.f15225c = r1;
    }

    public String toString() {
        return "ProcTimeInStateInfo{freqTimeMapList=" + this.f15223a + ", freqDeltaTimeMapList=" + this.f15224b + ", totalCpuTime=" + f() + ", totalDeltaCpuTime=" + g() + ", totalMergeCpuTime=" + h() + '}';
    }
}
