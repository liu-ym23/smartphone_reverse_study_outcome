package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class ConcurrencyHelpers {
    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    @RequiresApi(28)
    static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler createAsync(Looper r0) {
            return Handler.createAsync(r0);
        }
    }

    private ConcurrencyHelpers() {
    }

    static /* synthetic */ Thread a(String r1, Runnable r2) {
        Thread r0 = new Thread(r2, r1);
        r0.setPriority(10);
        return r0;
    }

    @NonNull
    @Deprecated
    static Executor convertHandlerToExecutor(@NonNull final Handler r1) {
        Objects.requireNonNull(r1);
        return new e(r1);
    }

    static ThreadPoolExecutor createBackgroundPriorityExecutor(@NonNull final String r8) {
        ThreadFactory r7 = new b(r8);
        ThreadPoolExecutor r9 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r7);
        r9.allowCoreThreadTimeOut(true);
        return r9;
    }

    static Handler mainHandlerAsync() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Handler28Impl.createAsync(Looper.getMainLooper());
    L7:
        return new Handler(Looper.getMainLooper());
    }
}
