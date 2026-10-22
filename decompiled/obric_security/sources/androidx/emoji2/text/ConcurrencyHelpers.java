package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class ConcurrencyHelpers {
    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper r0) {
            return Handler.createAsync(r0);
        }
    }

    public static /* synthetic */ boolean $r8$lambda$xMC8M6LLEeW997bBmO6BCC6GGAM(Handler r0, Runnable r1) {
        return r0.post(r1);
    }

    private ConcurrencyHelpers() {
    }

    static ThreadPoolExecutor createBackgroundPriorityExecutor(final String r8) {
        ThreadFactory r7 = new ConcurrencyHelpers$$ExternalSyntheticLambda0(r8);
        ThreadPoolExecutor r9 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r7);
        r9.allowCoreThreadTimeOut(true);
        return r9;
    }

    static /* synthetic */ Thread lambda$createBackgroundPriorityExecutor$0(String r1, Runnable r2) {
        Thread r0 = new Thread(r2, r1);
        r0.setPriority(10);
        return r0;
    }

    static Handler mainHandlerAsync() {
        return Handler28Impl.createAsync(Looper.getMainLooper());
    }

    @Deprecated
    static Executor convertHandlerToExecutor(final Handler r1) {
        Objects.requireNonNull(r1);
        return new ConcurrencyHelpers$$ExternalSyntheticLambda1(r1);
    }
}
