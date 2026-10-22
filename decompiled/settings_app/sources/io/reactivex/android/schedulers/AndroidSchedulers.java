package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = null;

    private static final class MainHolder {
        static final Scheduler DEFAULT = null;

        private MainHolder() {
        }

        static {
            DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);
        }
    }

    static {
        MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new AnonymousClass1());
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
    }

    public static Scheduler from(Looper r1) {
        return from(r1, false);
    }

    public static Scheduler from(Looper r2, boolean r3) {
        if (r2 == null) goto L6;
        return new HandlerScheduler(new Handler(r2), r3);
    L6:
        throw new NullPointerException("looper == null");
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }
}
