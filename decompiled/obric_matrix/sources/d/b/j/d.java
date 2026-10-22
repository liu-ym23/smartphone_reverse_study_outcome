package d.b.j;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class d extends UnsatisfiedLinkError {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ArrayList<d> f13959f = null;

    static {
        f13959f = new ArrayList();
    }

    d(String r1) {
        super(r1);
        ArrayList<d> r2 = f13959f;
        monitor-enter(r2);
        r2.add(this);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    d(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
        ArrayList<d> r3 = f13959f;
        monitor-enter(r3);
        r3.add(this);     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
