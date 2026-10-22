package kotlin.s0.w.d.l0.m;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public class d implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lock f20909b;

    public d(Lock r2) {
        o.f(r2, "lock");
        this.f20909b = r2;
    }

    public /* synthetic */ d(Lock r1, int r2, kotlin.n0.d.g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ReentrantLock();
    L5:
        this(r1);
    }

    @Override // kotlin.s0.w.d.l0.m.k
    public void a() {
        this.f20909b.unlock();
    }

    @Override // kotlin.s0.w.d.l0.m.k
    public void b() {
        this.f20909b.lock();
    }

    protected final Lock c() {
        return this.f20909b;
    }
}
