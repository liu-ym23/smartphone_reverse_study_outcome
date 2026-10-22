package w;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final synchronized Thread newThread(Runnable r5) {
        monitor-enter(this);
        Thread r10 = new Thread(r5, "glide-disk-lru-cache-thread");     // Catch: Throwable -> L6
        r10.setPriority(1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }
}
