package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class Schedulers {

    @NonNull
    static final Scheduler COMPUTATION = null;

    @NonNull
    static final Scheduler IO = null;

    @NonNull
    static final Scheduler NEW_THREAD = null;

    @NonNull
    static final Scheduler SINGLE = null;

    @NonNull
    static final Scheduler TRAMPOLINE = null;

    public static final class ComputationHolder {
        static final Scheduler DEFAULT = null;

        static {
            DEFAULT = new ComputationScheduler();
        }

        public ComputationHolder() {
        }
    }

    public static final class ComputationTask implements Callable<Scheduler> {
        public ComputationTask() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Scheduler call() {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return ComputationHolder.DEFAULT;
        }
    }

    public static final class IOTask implements Callable<Scheduler> {
        public IOTask() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Scheduler call() {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return IoHolder.DEFAULT;
        }
    }

    public static final class IoHolder {
        static final Scheduler DEFAULT = null;

        static {
            DEFAULT = new IoScheduler();
        }

        public IoHolder() {
        }
    }

    public static final class NewThreadHolder {
        static final Scheduler DEFAULT = null;

        static {
            DEFAULT = new NewThreadScheduler();
        }

        public NewThreadHolder() {
        }
    }

    public static final class NewThreadTask implements Callable<Scheduler> {
        public NewThreadTask() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Scheduler call() {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return NewThreadHolder.DEFAULT;
        }
    }

    public static final class SingleHolder {
        static final Scheduler DEFAULT = null;

        static {
            DEFAULT = new SingleScheduler();
        }

        public SingleHolder() {
        }
    }

    public static final class SingleTask implements Callable<Scheduler> {
        public SingleTask() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Scheduler call() {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return SingleHolder.DEFAULT;
        }
    }

    static {
        SINGLE = RxJavaPlugins.initSingleScheduler(new SingleTask());
        COMPUTATION = RxJavaPlugins.initComputationScheduler(new ComputationTask());
        IO = RxJavaPlugins.initIoScheduler(new IOTask());
        TRAMPOLINE = TrampolineScheduler.instance();
        NEW_THREAD = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(COMPUTATION);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor r2) {
        return new ExecutorScheduler(r2, false);
    }

    @NonNull
    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(IO);
    }

    @NonNull
    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(NEW_THREAD);
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        SchedulerPoolFactory.shutdown();
    }

    @NonNull
    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(SINGLE);
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
        SchedulerPoolFactory.start();
    }

    @NonNull
    public static Scheduler trampoline() {
        return TRAMPOLINE;
    }

    @Experimental
    @NonNull
    public static Scheduler from(@NonNull Executor r1, boolean r2) {
        return new ExecutorScheduler(r1, r2);
    }
}
