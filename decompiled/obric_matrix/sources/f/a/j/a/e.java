package f.a.j.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements f.a.g.b, b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    List<f.a.g.b> f17056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f17057g;

    public e() {
    }

    @Override // f.a.j.a.b
    public boolean a(f.a.g.b r1) {
        if (c(r1) == false) goto L6;
        r1.dispose();
        return true;
    L6:
        return false;
    }

    @Override // f.a.j.a.b
    public boolean b(f.a.g.b r2) {
        f.a.j.b.b.c(r2, "d is null");
        if (this.f17057g == true) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.f17057g == true) goto L13;
        List r0 = this.f17056f;     // Catch: Throwable -> L15
        if (r0 != null) goto L10;
        r0 = new LinkedList();     // Catch: Throwable -> L15
        this.f17056f = r0;     // Catch: Throwable -> L15
    L10:
        r0.add(r2);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    L18:
        r2.dispose();
        return false;
    }

    @Override // f.a.j.a.b
    public boolean c(f.a.g.b r3) {
        f.a.j.b.b.c(r3, "Disposable item is null");
        if (this.f17057g == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f17057g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L10:
        List<f.a.g.b> r0 = this.f17056f;     // Catch: Throwable -> L20
        if (r0 != null) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L13:
        if (r0.remove(r3) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    }

    void d(List<f.a.g.b> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ArrayList r1 = null;
        Iterator<f.a.g.b> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        r3.next().dispose();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        f.a.h.b.a(th);
        if (r1 != null) goto L14;
        r1 = new ArrayList();
    L14:
        r1.add(th);
        goto L6
    L15:
        if (r1 != null) goto L17;
        return;
    L17:
        if (r1.size() != 1) goto L21;
        throw f.a.j.e.a.a((Throwable) r1.get(0));
    L21:
        throw new f.a.h.a(r1);
    }

    @Override // f.a.g.b
    public void dispose() {
        if (this.f17057g == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f17057g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        this.f17057g = true;     // Catch: Throwable -> L14
        List<f.a.g.b> r0 = this.f17056f;     // Catch: Throwable -> L14
        this.f17056f = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        d(r0);
    }
}
