package f.a.j.d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends AtomicLong implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f17123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f17124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f17125h;

    static final class a extends Thread {
        a(Runnable r1, String r2) {
            super(r1, r2);
        }
    }

    public f(String r3) {
        this(r3, 5, false);
    }

    public f(String r2, int r3) {
        this(r2, r3, false);
    }

    public f(String r1, int r2, boolean r3) {
        this.f17123f = r1;
        this.f17124g = r2;
        this.f17125h = r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        String r0 = this.f17123f + '-' + incrementAndGet();
        if (this.f17125h == false) goto L5;
        Thread r1 = new a(r4, r0);
    L6:
        r1.setPriority(this.f17124g);
        r1.setDaemon(true);
        return r1;
    L5:
        r1 = new Thread(r4, r0);
        goto L6
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f17123f + "]";
    }
}
