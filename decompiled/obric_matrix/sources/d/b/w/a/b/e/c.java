package d.b.w.a.b.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements d.b.w.a.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f15210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f15211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f15213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f15215f;

    public c() {
        this.f15210a = new ArrayList();
        this.f15211b = new ArrayList();
        this.f15212c = 0;
        this.f15213d = 0;
        this.f15214e = 0;
        this.f15215f = 0.0d;
    }

    public void a(d.b.w.a.c.b r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        long r0 = e() - ((c) r7).e();
        this.f15213d = r0;
        if (this.f15214e != 0) goto L8;
        this.f15214e = r0;
        return;
    }

    public void b(d.b.w.a.c.b r12) {
        if (r12 != null) goto L5;
        this.f15211b.addAll(this.f15210a);
        return;
    L5:
        List<LinkedHashMap<Long, Long>> r13 = ((c) r12).d();
        if (r13.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f15210a.size() == r13.size()) goto L12;
        d.b.w.a.d.b.g("calculate cpu freqTime delta size error");
        return;
    L12:
        this.f15211b.clear();
        int r0 = 0;
    L14:
        if (r0 >= this.f15210a.size()) goto L23;
        LinkedHashMap<Long, Long> r1 = this.f15210a.get(r0);
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
        d.b.w.a.d.b.c("calculate cpu freqTime delta not found " + r6);
        goto L17
    L20:
        r3.put(r6, Long.valueOf(r7.longValue() - r8.longValue()));
        goto L17
    L22:
        this.f15211b.add(r3);
        r0 = r0 + 1;
        goto L14
    }

    public long c() {
        return this.f15213d;
    }

    public List<LinkedHashMap<Long, Long>> d() {
        return this.f15210a;
    }

    public long e() {
        if (this.f15212c != 0) goto L14;
        if (this.f15210a.isEmpty() == true) goto L14;
        Iterator<LinkedHashMap<Long, Long>> r0 = this.f15210a.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Iterator<Map.Entry<Long, Long>> r1 = r0.next().entrySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        this.f15212c += r1.next().getValue().longValue();
    L14:
        return this.f15212c;
    }

    public void f(LinkedHashMap<Long, Long> r1) {
        this.f15210a.add(r1);
    }

    public void g(long r5) {
        if (this.f15213d >= 0) goto L5;
        return;
    L5:
        if (this.f15212c <= 0) goto L9;
        this.f15215f = 1.0d - (r5 / c());
        return;
    }

    public String toString() {
        return "cputime:{deltaTime:" + c() + " usage:" + this.f15215f + " totaltime:" + e() + "}";
    }
}
