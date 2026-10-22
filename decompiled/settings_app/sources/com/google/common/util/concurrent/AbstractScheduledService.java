package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractScheduledService implements Service {
    private static final Logger logger = null;
    private final AbstractService delegate;

    interface Cancellable {
        void cancel(boolean r1);

        boolean isCancelled();
    }

    public static abstract class CustomScheduler extends Scheduler {

        private final class ReschedulableCallable implements Callable<Void> {

            @CheckForNull
            private SupplantableFuture cancellationDelegate;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock;
            private final AbstractService service;
            final /* synthetic */ CustomScheduler this$0;
            private final Runnable wrappedRunnable;

            @Override // java.util.concurrent.Callable
            @CheckForNull
            public /* bridge */ /* synthetic */ Void call() throws Exception {
                return call2();
            }

            ReschedulableCallable(CustomScheduler r1, AbstractService r2, ScheduledExecutorService r3, Runnable r4) {
                this.this$0 = r1;
                this.lock = new ReentrantLock();
                this.wrappedRunnable = r4;
                this.executor = r3;
                this.service = r2;
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public Void call2() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            public Cancellable reschedule() {
                Schedule r0 = this.this$0.getNextSchedule();     // Catch: Throwable -> L15
                this.lock.lock();
                Cancellable r1 = initializeOrUpdateCancellationDelegate(r0);     // Catch: Throwable -> L6
                this.lock.unlock();
                th = null;
            L9:
                if (th == null) goto L11;
                this.service.notifyFailed(th);
            L11:
                return r1;
            L6:
                th = th;
                r1 = new FutureAsCancellable(Futures.immediateCancelledFuture());     // Catch: Throwable -> L12
                this.lock.unlock();
            L12:
                th = move-exception;
                this.lock.unlock();
                throw th;
            L15:
                th = move-exception;
                this.service.notifyFailed(th);
                return new FutureAsCancellable(Futures.immediateCancelledFuture());
            }

            private Cancellable initializeOrUpdateCancellationDelegate(Schedule r3) {
                SupplantableFuture r0 = this.cancellationDelegate;
                if (r0 != null) goto L7;
                SupplantableFuture r1 = new SupplantableFuture(this.lock, submitToExecutor(r3));
                this.cancellationDelegate = r1;
                return r1;
            L7:
                if (SupplantableFuture.access$800(r0).isCancelled() == true) goto L10;
                SupplantableFuture.access$802(this.cancellationDelegate, submitToExecutor(r3));
            L10:
                return this.cancellationDelegate;
            }

            private ScheduledFuture<Void> submitToExecutor(Schedule r4) {
                return this.executor.schedule(this, Schedule.access$900(r4), Schedule.access$1000(r4));
            }
        }

        protected static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            static /* synthetic */ TimeUnit access$1000(Schedule r0) {
                return r0.unit;
            }

            static /* synthetic */ long access$900(Schedule r2) {
                return r2.delay;
            }

            public Schedule(long r1, TimeUnit r3) {
                this.delay = r1;
                this.unit = (TimeUnit) Preconditions.checkNotNull(r3);
            }
        }

        private static final class SupplantableFuture implements Cancellable {
            private Future<Void> currentFuture;
            private final ReentrantLock lock;

            static /* synthetic */ Future access$800(SupplantableFuture r0) {
                return r0.currentFuture;
            }

            static /* synthetic */ Future access$802(SupplantableFuture r0, Future r1) {
                r0.currentFuture = r1;
                return r1;
            }

            SupplantableFuture(ReentrantLock r1, Future<Void> r2) {
                this.lock = r1;
                this.currentFuture = r2;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public void cancel(boolean r2) {
                this.lock.lock();
                this.currentFuture.cancel(r2);     // Catch: Throwable -> L6
                this.lock.unlock();
                return;
            L6:
                th = move-exception;
                this.lock.unlock();
                throw th;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public boolean isCancelled() {
                this.lock.lock();
                boolean r0 = this.currentFuture.isCancelled();     // Catch: Throwable -> L6
                this.lock.unlock();
                return r0;
            L6:
                th = move-exception;
                this.lock.unlock();
                throw th;
            }
        }

        protected abstract Schedule getNextSchedule() throws Exception;

        public CustomScheduler() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        final Cancellable schedule(AbstractService r2, ScheduledExecutorService r3, Runnable r4) {
            return new ReschedulableCallable(this, r2, r3, r4).reschedule();
        }
    }

    private static final class FutureAsCancellable implements Cancellable {
        private final Future<?> delegate;

        FutureAsCancellable(Future<?> r1) {
            this.delegate = r1;
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public void cancel(boolean r1) {
            this.delegate.cancel(r1);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }
    }

    public static abstract class Scheduler {
        abstract Cancellable schedule(AbstractService r1, ScheduledExecutorService r2, Runnable r3);

        /* synthetic */ Scheduler(AnonymousClass1 r1) {
            this();
        }

        public static Scheduler newFixedDelaySchedule(Duration r3, Duration r4) {
            return newFixedDelaySchedule(Internal.toNanosSaturated(r3), Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
        }

        public static Scheduler newFixedDelaySchedule(final long r8, final long r10, final TimeUnit r12) {
            Preconditions.checkNotNull(r12);
            if (r10 <= 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "delay must be > 0, found %s", r10);
            return new AnonymousClass1(r8, r10, r12);
        L5:
            r0 = false;
            goto L6
        }

        public static Scheduler newFixedRateSchedule(Duration r3, Duration r4) {
            return newFixedRateSchedule(Internal.toNanosSaturated(r3), Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
        }

        public static Scheduler newFixedRateSchedule(final long r8, final long r10, final TimeUnit r12) {
            Preconditions.checkNotNull(r12);
            if (r10 <= 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "period must be > 0, found %s", r10);
            return new AnonymousClass2(r8, r10, r12);
        L5:
            r0 = false;
            goto L6
        }

        private Scheduler() {
        }
    }

    private final class ServiceDelegate extends AbstractService {

        @CheckForNull
        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock;

        @CheckForNull
        private volatile Cancellable runningTask;
        private final Runnable task;
        final /* synthetic */ AbstractScheduledService this$0;

        class Task implements Runnable {
            final /* synthetic */ ServiceDelegate this$1;

            Task(ServiceDelegate r1) {
                this.this$1 = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.access$200(this.this$1).lock();
            L9:
                th = move-exception;
                this.this$1.this$0.shutDown();     // Catch: Throwable -> L12 Exception -> L14
            L16:
                this.this$1.notifyFailed(th);     // Catch: Throwable -> L12
                ((Cancellable) Objects.requireNonNull(ServiceDelegate.access$300(this.this$1))).cancel(false);     // Catch: Throwable -> L12
            L8:
                ServiceDelegate.access$200(this.this$1).unlock();
                return;
            L14:
                e = move-exception;
                AbstractScheduledService.access$400().log(Level.WARNING, "Error while attempting to shut down the service after failure.", e);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                ServiceDelegate.access$200(this.this$1).unlock();
                throw th;
            L4:
                if (((Cancellable) Objects.requireNonNull(ServiceDelegate.access$300(this.this$1))).isCancelled() == false) goto L7;
                ServiceDelegate.access$200(this.this$1).unlock();
                return;
            L7:
                this.this$1.this$0.runOneIteration();     // Catch: Throwable -> L9
                goto L8
            }
        }

        private ServiceDelegate(AbstractScheduledService r1) {
            this.this$0 = r1;
            this.lock = new ReentrantLock();
            this.task = new Task(this);
        }

        /* synthetic */ ServiceDelegate(AbstractScheduledService r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ ReentrantLock access$200(ServiceDelegate r0) {
            return r0.lock;
        }

        static /* synthetic */ Cancellable access$300(ServiceDelegate r0) {
            return r0.runningTask;
        }

        static /* synthetic */ Cancellable access$302(ServiceDelegate r0, Cancellable r1) {
            r0.runningTask = r1;
            return r1;
        }

        static /* synthetic */ ScheduledExecutorService access$600(ServiceDelegate r0) {
            return r0.executorService;
        }

        static /* synthetic */ Runnable access$700(ServiceDelegate r0) {
            return r0.task;
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(this.this$0.executor(), new AnonymousClass1(this));
            this.executorService.execute(new AnonymousClass2(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStop() {
            Objects.requireNonNull(this.runningTask);
            Objects.requireNonNull(this.executorService);
            this.runningTask.cancel(false);
            this.executorService.execute(new AnonymousClass3(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.this$0.toString();
        }
    }

    protected abstract void runOneIteration() throws Exception;

    protected abstract Scheduler scheduler();

    protected void shutDown() throws Exception {
    }

    protected void startUp() throws Exception {
    }

    static /* synthetic */ Logger access$400() {
        return logger;
    }

    static /* synthetic */ AbstractService access$500(AbstractScheduledService r0) {
        return r0.delegate;
    }

    static {
        logger = Logger.getLogger(AbstractScheduledService.class.getName());
    }

    protected AbstractScheduledService() {
        this.delegate = new ServiceDelegate(this, null);
    }

    protected ScheduledExecutorService executor() {
        final ScheduledExecutorService r0 = Executors.newSingleThreadScheduledExecutor(new C1ThreadFactoryImpl(this));
        addListener(new AnonymousClass1(this, r0), MoreExecutors.directExecutor());
        return r0;
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }

    public String toString() {
        String r0 = serviceName();
        String r3 = String.valueOf(state());
        return new StringBuilder((String.valueOf(r0).length() + 3) + String.valueOf(r3).length()).append(r0).append(" [").append(r3).append("]").toString();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r1, Executor r2) {
        this.delegate.addListener(r1, r2);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(Duration r1) throws TimeoutException {
        super.awaitRunning(r1);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r1, TimeUnit r3) throws TimeoutException {
        this.delegate.awaitRunning(r1, r3);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(Duration r1) throws TimeoutException {
        super.awaitTerminated(r1);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r1, TimeUnit r3) throws TimeoutException {
        this.delegate.awaitTerminated(r1, r3);
    }
}
