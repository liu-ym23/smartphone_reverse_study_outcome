package t2;

import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import ym.h;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends ThreadPoolExecutor {
    public e(int r10, int r11, long r12, LinkedBlockingQueue r13, d r14) {
        super(r10, r11, r12, TimeUnit.SECONDS, r13, r14);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r5, Throwable r10) {
        super.afterExecute(r5, r10);
        h.g(r5, r10);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r5, TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        Logger.throwException(new Throwable("Trying to call awaitTermination() in a persist pool"));
        return true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
        Logger.throwException(new Throwable("Trying to call shutdown() in a persist pool"));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        Logger.throwException(new Throwable("Trying to call shutdownNow() in a persist pool"));
        return new ArrayList();
    }

    public e(int r10, int r11, BlockingQueue r12, d r13, e8.a r14) {
        super(r10, r11, 30, TimeUnit.SECONDS, r12, r13, r14);
    }
}
