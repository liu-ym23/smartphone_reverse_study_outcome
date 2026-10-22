package d.b.k.a.z;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class b implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f14081f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f14082a = null;

        static {
            f14082a = new b();
        }

        static /* synthetic */ b a() {
            return f14082a;
        }
    }

    public b() {
        this.f14081f = new Handler(Looper.getMainLooper());
    }

    public static b a() {
        return a.a();
    }

    private boolean b() {
        if (Thread.currentThread() != this.f14081f.getLooper().getThread()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r2) {
        if (b() == false) goto L5;
        r2.run();
        return;
    L5:
        this.f14081f.post(r2);
    }
}
