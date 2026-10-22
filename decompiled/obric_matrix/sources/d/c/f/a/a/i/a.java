package d.c.f.a.a.i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f15509a;

    public a(b... r3) {
        ArrayList r0 = new ArrayList(r3.length);
        this.f15509a = r0;
        Collections.addAll(r0, r3);
    }

    @Override // d.c.f.a.a.i.b
    public synchronized void a(String r6, int r7, boolean r8) {
        monitor-enter(this);
        int r0 = this.f15509a.size();     // Catch: Throwable -> L14
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L12;
        b r2 = this.f15509a.get(r1);     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
        r2.a(r6, r7, r8);     // Catch: Exception -> L9 Throwable -> L14
    L9:
        e = move-exception;
        d.c.c.e.a.k("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);     // Catch: Throwable -> L14
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void b(b r2) {
        monitor-enter(this);
        this.f15509a.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void c(b r2) {
        monitor-enter(this);
        this.f15509a.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
