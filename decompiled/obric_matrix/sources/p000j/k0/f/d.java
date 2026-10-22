package p000j.k0.f;

import java.util.LinkedHashSet;
import java.util.Set;
import p000j.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<h0> f17842a;

    public d() {
        this.f17842a = new LinkedHashSet();
    }

    public synchronized void a(h0 r2) {
        monitor-enter(this);
        this.f17842a.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void b(h0 r2) {
        monitor-enter(this);
        this.f17842a.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean c(h0 r2) {
        monitor-enter(this);
        boolean r3 = this.f17842a.contains(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }
}
