package d.c.i.g;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class k implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f16113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f16114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f16115i;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f16116f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k f16117g;

        a(k r1, Runnable r2) {
            this.f16117g = r1;
            this.f16116f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(k.a(this.f16117g));     // Catch: Throwable -> L5
        L3:
            this.f16116f.run();
        }
    }

    public k(int r3, String r4, boolean r5) {
        this.f16115i = new AtomicInteger(1);
        this.f16112f = r3;
        this.f16113g = r4;
        this.f16114h = r5;
    }

    static /* synthetic */ int a(k r0) {
        return r0.f16112f;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        a r0 = new a(this, r3);
        if (this.f16114h == false) goto L5;
        String r2 = this.f16113g + "-" + this.f16115i.getAndIncrement();
    L7:
        return new Thread(r0, r2);
    L5:
        r2 = this.f16113g;
        goto L7
    }
}
