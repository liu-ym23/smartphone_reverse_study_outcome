package a.b.a.a;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g f20f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f21g;

    public e(g r1, CountDownLatch r2) {
        this.f20f = r1;
        this.f21g = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.a(d.u, this.f20f.a());
        this.f21g.countDown();
    }
}
