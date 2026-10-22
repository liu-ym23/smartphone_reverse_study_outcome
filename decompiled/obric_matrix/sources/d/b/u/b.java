package d.b.u;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.b.u.w.n f14988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Long, n> f14989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final n.a f14990h;

    public b(n.a r2, d.b.u.w.n r3) {
        this.f14989g = new ConcurrentHashMap();
        this.f14990h = r2;
        this.f14988f = r3;
    }

    public n a(long r1) {
        return this.f14989g.get(Long.valueOf(r1));
    }

    public Collection<n> b() {
        return new ArrayList(this.f14989g.values());
    }

    @WorkerThread
    public d.b.u.w.i c(m r6) {
        monitor-enter(this);
        n r0 = this.f14989g.get(Long.valueOf(r6.f15057a));     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.a(r6.f15059c);     // Catch: Throwable -> L9
        d.b.u.w.i r7 = this.f14989g.get(Long.valueOf(r6.f15057a)).g();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r7;
    L6:
        d.b.u.w.i r1 = this.f14988f.a(Long.valueOf(r6.f15057a));     // Catch: Throwable -> L9
        n r2 = new n(r6, r1, this.f14990h);     // Catch: Throwable -> L9
        r2.a(r6.f15059c);     // Catch: Throwable -> L9
        r2.b(r6.f15060d);     // Catch: Throwable -> L9
        this.f14989g.put(Long.valueOf(r6.f15057a), r2);     // Catch: Throwable -> L9
        r7 = r1;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message r1) {
        return false;
    }
}
