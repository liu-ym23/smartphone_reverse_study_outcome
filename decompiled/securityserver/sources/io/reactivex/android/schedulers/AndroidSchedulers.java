package io.reactivex.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = null;

    public static final class MainHolder {
        static final Scheduler DEFAULT = null;

        static {
            DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);
        }

        private MainHolder() {
        }
    }

    static {
        MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new AnonymousClass1());
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler from(Looper r1) {
        return from(r1, false);
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
    }

    @SuppressLint({"NewApi"})
    public static Scheduler from(Looper r2, boolean r3) {
        if (r2 == null) goto L6;
        return new HandlerScheduler(new Handler(r2), r3);
    L6:
        throw new NullPointerException("looper == null");
    }
}
