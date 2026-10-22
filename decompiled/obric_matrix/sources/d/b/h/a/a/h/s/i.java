package d.b.h.a.a.h.s;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class i implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f13763f;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f13764f;

        a(i r1, Runnable r2) {
            this.f13764f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            this.f13764f.run();     // Catch: Throwable -> L5
            return;
        }
    }

    static {
    }

    public i(String r1) {
        this.f13763f = r1;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        Logger.debug();
        return new Thread(new a(this, r3), this.f13763f);
    }
}
