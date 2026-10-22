package tmsdkobf;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class ka extends rk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f303a;
    public final boolean b;

    public ka(boolean r3) {
        this.f303a = new AtomicReference(null);
        this.b = r3;
    }

    public String toString() {
        AtomicReference r0 = this.f303a;
        monitor-enter(r0);
        String r1 = (String) this.f303a.get();     // Catch: Throwable -> L12
        if (r1 == null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L16:
        this.f303a.wait(2000);     // Catch: InterruptedException -> L15 Throwable -> L12
    L9:
        String r4 = (String) this.f303a.get();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L12:
        th = move-exception;
        throw th;
    }
}
