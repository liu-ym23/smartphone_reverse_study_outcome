package tmsdkobf;

import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes5.dex */
public class ml {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f358a;
    private LinkedHashSet b;

    public ml(int r2) {
        this.f358a = -1;
        this.b = new LinkedHashSet();
        this.f358a = r2;
    }

    public synchronized boolean a(Object r2) {
        monitor-enter(this);
        boolean r3 = this.b.contains(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void b(Object r3) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.b.size() < this.f358a) goto L6;
        a();     // Catch: Throwable -> L9
    L6:
        this.b.add(r3);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    public synchronized Object a() {
        monitor-enter(this);
        LinkedHashSet r0 = this.b;     // Catch: Throwable -> L15
        if (r0 == null) goto L12;
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();     // Catch: Throwable -> L15
        this.b.remove(r2);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r2;
    L12:
        monitor-exit(this);
        return null;
    L15:
        th = move-exception;
        throw th;
    }
}
