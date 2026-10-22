package d.b.w.a.b.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.w.a.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<List<Long>> f15195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<List<Long>> f15196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f15198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15199e;

    public a() {
        this.f15195a = new ArrayList();
        this.f15196b = new ArrayList();
        this.f15197c = 0;
        this.f15198d = 0;
        this.f15199e = 0;
    }

    public void a(d.b.w.a.c.b r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        long r0 = e() - ((a) r7).e();
        this.f15198d = r0;
        if (this.f15199e != 0) goto L8;
        this.f15199e = r0;
        return;
    }

    public void b(d.b.w.a.c.b r12) {
        if (r12 != null) goto L5;
        this.f15196b.addAll(this.f15195a);
        return;
    L5:
        List<List<Long>> r13 = ((a) r12).c();
        if (r13.isEmpty() == false) goto L8;
        return;
    L8:
        int r0 = this.f15195a.size();
        if (r0 == r13.size()) goto L12;
        d.b.w.a.d.b.g("calculate cpu idle time delta size error1");
        return;
    L12:
        this.f15196b.clear();
        int r2 = 0;
    L13:
        if (r2 >= r0) goto L32;
        List<Long> r3 = this.f15195a.get(r2);
        List<Long> r4 = r13.get(r2);
        ArrayList r5 = new ArrayList();
        if (r3 == null) goto L25;
        if (r4 == null) goto L25;
        if (r3.size() != r4.size()) goto L25;
        int r6 = 0;
    L22:
        if (r6 >= r3.size()) goto L24;
        r5.add(Long.valueOf(r3.get(r6).longValue() - r4.get(r6).longValue()));
        r6 = r6 + 1;
        goto L22
    L24:
        this.f15196b.add(r5);
        r2 = r2 + 1;
    L25:
        d.b.w.a.d.b.g("calculate cpu idle time delta size error2");
        return;
    }

    public List<List<Long>> c() {
        return this.f15195a;
    }

    public long d() {
        return this.f15198d;
    }

    public long e() {
        if (this.f15197c != 0) goto L14;
        if (this.f15195a.isEmpty() == true) goto L14;
        Iterator<List<Long>> r0 = this.f15195a.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Iterator<Long> r1 = r0.next().iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        this.f15197c += r1.next().longValue();
    L14:
        return this.f15197c;
    }

    public void f(List<Long> r1) {
        if (r1 == null) goto L5;
        this.f15195a.add(r1);
        return;
    }

    public String toString() {
        return "CpuIdleTimeStatInfo{stateTimeLists=" + this.f15195a + ", stateDeltaTimeLists=" + this.f15196b + ", totalCpuIdleTime=" + this.f15197c + ", deltaCpuIdleTime=" + this.f15198d + ", mergedDeltaCpuIdleTime=" + this.f15199e + '}';
    }
}
