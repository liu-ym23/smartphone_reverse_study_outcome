package d.b.u;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f15065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.b.u.w.i f15066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<d.b.u.w.m> f15067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<d.b.u.w.g> f15068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f15069e;

    public interface a {
        void d(long r1);
    }

    public n(m r2, d.b.u.w.i r3, a r4) {
        this.f15067c = new ArrayList();
        this.f15068d = new ArrayList();
        this.f15065a = r2;
        this.f15066b = r3;
        this.f15069e = r4;
    }

    public void a(List<d.b.u.w.m> r6) {
        List<d.b.u.w.m> r0 = this.f15067c;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(r6);     // Catch: Throwable -> L25
        List<d.b.u.w.m> r7 = this.f15067c;     // Catch: Throwable -> L25
        monitor-enter(r7);     // Catch: Throwable -> L25
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L22
        boolean r3 = false;
    L8:
        if (r2.hasNext() == false) goto L15;
        d.b.u.w.m r4 = (d.b.u.w.m) r2.next();     // Catch: Throwable -> L22
        if (r4 == null) goto L8;
        if (this.f15067c.contains(r4) == true) goto L8;
        this.f15067c.add(r4);     // Catch: Throwable -> L22
        r3 = true;
        goto L8
    L15:
        monitor-exit(r7);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L25
        if (r3 == false) goto L39;
        a r8 = this.f15069e;
        if (r8 == null) goto L40;
        r8.d(this.f15065a.f15057a);
        return;
    L40:
        return;
    L39:
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public void b(List<d.b.u.w.g> r5) {
        List<d.b.u.w.g> r0 = this.f15068d;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(r5);     // Catch: Throwable -> L21
        List<d.b.u.w.g> r6 = this.f15068d;     // Catch: Throwable -> L21
        monitor-enter(r6);     // Catch: Throwable -> L21
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L18
    L8:
        if (r2.hasNext() == false) goto L15;
        d.b.u.w.g r3 = (d.b.u.w.g) r2.next();     // Catch: Throwable -> L18
        if (r3 == null) goto L8;
        if (this.f15068d.contains(r3) == true) goto L8;
        this.f15068d.add(r3);     // Catch: Throwable -> L18
        goto L8
    L15:
        monitor-exit(r6);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public Object[] c() {
        List<d.b.u.w.m> r0 = this.f15067c;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f15067c.size() <= 0) goto L7;
        Object[] r2 = this.f15067c.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    public Object[] d() {
        List<d.b.u.w.g> r0 = this.f15068d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f15068d.size() <= 0) goto L7;
        Object[] r2 = this.f15068d.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    public long e() {
        return this.f15065a.f15057a;
    }

    public h f() {
        return this.f15065a.f15058b;
    }

    public d.b.u.w.i g() {
        return this.f15066b;
    }
}
