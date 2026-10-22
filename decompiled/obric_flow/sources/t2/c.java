package t2;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import ym.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends ScheduledThreadPoolExecutor {
    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r5, Throwable r10) {
        super.afterExecute(r5, r10);
        h.g(r5, r10);
    }
}
