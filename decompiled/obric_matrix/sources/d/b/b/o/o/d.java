package d.b.b.o.o;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class d implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f13071f;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f13072f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f13073g;

        a(d r1, Runnable r2) {
            this.f13073g = r1;
            this.f13072f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            this.f13072f.run();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            d.b.b.o.m.b.c("APM-AsyncTask", "SingleThreadFactory error when running in thread " + d.a(this.f13073g), th);
        }
    }

    public d(String r3) {
        this.f13071f = "APM6-" + r3;
    }

    static /* synthetic */ String a(d r0) {
        return r0.f13071f;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        if (d.b.b.o.a.c() == false) goto L6;
        d.b.b.o.m.b.a("APM-AsyncTask", "creating newThread " + this.f13071f);
    L6:
        return new Thread(new a(this, r3), this.f13071f);
    }
}
