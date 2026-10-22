package d.b.h.a.a.d;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class e implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f13254f;

    static {
    }

    public e(String r3) {
        this.f13254f = "ttnet-" + r3;
    }

    private /* synthetic */ void a(Runnable r1) {
        Process.setThreadPriority(10);
        r1.run();     // Catch: Throwable -> L5
        return;
    }

    public /* synthetic */ void b(Runnable r1) {
        a(r1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r3) {
        return new Thread(new a(this, r3), this.f13254f);
    }
}
