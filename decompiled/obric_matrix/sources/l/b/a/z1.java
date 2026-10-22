package l.b.a;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class z1 extends u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f21819g;

    z1(byte[] r1) {
        this.f21819g = r1;
    }

    private void B() {
        if (this.f21819g == null) goto L11;
        f r0 = new f();
        y1 r1 = new y1(this.f21819g);
    L6:
        if (r1.hasMoreElements() == false) goto L8;
        r0.a((t) r1.nextElement());
        goto L6
    L8:
        this.f21731f = r0.g();
        this.f21819g = null;
        return;
    }

    @Override // l.b.a.u
    e[] A() {
        B();
        return super.A();
    }

    @Override // l.b.a.u, l.b.a.n
    public synchronized int hashCode() {
        monitor-enter(this);
        B();     // Catch: Throwable -> L6
        int r0 = super.hashCode();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // l.b.a.u
    public synchronized Iterator<e> iterator() {
        monitor-enter(this);
        B();     // Catch: Throwable -> L6
        Iterator<e> r0 = super.iterator();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // l.b.a.t
    synchronized void o(r r3, boolean r4) {
        monitor-enter(this);
        byte[] r0 = this.f21819g;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r3.n(r4, 48, r0);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.v().o(r3, r4);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // l.b.a.t
    synchronized int p() {
        monitor-enter(this);
        byte[] r0 = this.f21819g;     // Catch: Throwable -> L12
        if (r0 != null) goto L6;
        int r1 = super.v().p();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r1;
    L6:
        int r2 = (c2.a(r0.length) + 1) + this.f21819g.length;
        monitor-exit(this);
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // l.b.a.u
    public synchronized int size() {
        monitor-enter(this);
        B();     // Catch: Throwable -> L6
        int r0 = super.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // l.b.a.u, l.b.a.t
    synchronized t u() {
        monitor-enter(this);
        B();     // Catch: Throwable -> L6
        t r0 = super.u();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // l.b.a.u, l.b.a.t
    synchronized t v() {
        monitor-enter(this);
        B();     // Catch: Throwable -> L6
        t r0 = super.v();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // l.b.a.u
    public synchronized e y(int r1) {
        monitor-enter(this);
        B();     // Catch: Throwable -> L6
        e r2 = super.y(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // l.b.a.u
    public synchronized Enumeration z() {
        monitor-enter(this);
        byte[] r0 = this.f21819g;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        y1 r1 = new y1(r0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L8:
        Enumeration r2 = super.z();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    L11:
        th = move-exception;
        throw th;
    }
}
