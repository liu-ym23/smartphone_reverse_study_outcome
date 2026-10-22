package tmsdkobf;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public class pl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TreeMap f424a;

    public pl(Comparator r2) {
        this.f424a = null;
        this.f424a = new TreeMap(r2);
    }

    private LinkedList c() {
        return new LinkedList();
    }

    public synchronized void a(Object r3) {
        monitor-enter(this);
        LinkedList r0 = (LinkedList) this.f424a.get(r3);     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        r0 = c();     // Catch: Throwable -> L9
        this.f424a.put(r3, r0);     // Catch: Throwable -> L9
    L6:
        r0.addLast(r3);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized boolean b() {
        monitor-enter(this);
        boolean r0 = this.f424a.isEmpty();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Object d() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (b() == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Object r0 = this.f424a.firstKey();     // Catch: Throwable -> L13
        LinkedList r1 = (LinkedList) this.f424a.get(r0);     // Catch: Throwable -> L13
        Object r2 = r1.poll();     // Catch: Throwable -> L13
        if (r1.size() > 0) goto L11;
        this.f424a.remove(r0);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r2;
    }

    public synchronized void a() {
        monitor-enter(this);
        this.f424a.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
