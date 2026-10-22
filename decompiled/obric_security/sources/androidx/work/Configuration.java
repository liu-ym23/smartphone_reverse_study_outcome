package androidx.work;

import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class Configuration {
    public static final int MIN_SCHEDULER_LIMIT = 20;
    final String mDefaultProcessName;
    final Consumer<Throwable> mExceptionHandler;
    final Executor mExecutor;
    final InputMergerFactory mInputMergerFactory;
    private final boolean mIsUsingDefaultTaskExecutor;
    final int mLoggingLevel;
    final int mMaxJobSchedulerId;
    final int mMaxSchedulerLimit;
    final int mMinJobSchedulerId;
    final RunnableScheduler mRunnableScheduler;
    final Consumer<Throwable> mSchedulingExceptionHandler;
    final Executor mTaskExecutor;
    final WorkerFactory mWorkerFactory;

    public static final class Builder {
        String mDefaultProcessName;
        Consumer<Throwable> mExceptionHandler;
        Executor mExecutor;
        InputMergerFactory mInputMergerFactory;
        int mLoggingLevel;
        int mMaxJobSchedulerId;
        int mMaxSchedulerLimit;
        int mMinJobSchedulerId;
        RunnableScheduler mRunnableScheduler;
        Consumer<Throwable> mSchedulingExceptionHandler;
        Executor mTaskExecutor;
        WorkerFactory mWorkerFactory;

        public Builder() {
            this.mLoggingLevel = 4;
            this.mMinJobSchedulerId = 0;
            this.mMaxJobSchedulerId = Integer.MAX_VALUE;
            this.mMaxSchedulerLimit = 20;
        }

        public Builder(Configuration configuration) {
            this.mExecutor = configuration.mExecutor;
            this.mWorkerFactory = configuration.mWorkerFactory;
            this.mInputMergerFactory = configuration.mInputMergerFactory;
            this.mTaskExecutor = configuration.mTaskExecutor;
            this.mLoggingLevel = configuration.mLoggingLevel;
            this.mMinJobSchedulerId = configuration.mMinJobSchedulerId;
            this.mMaxJobSchedulerId = configuration.mMaxJobSchedulerId;
            this.mMaxSchedulerLimit = configuration.mMaxSchedulerLimit;
            this.mRunnableScheduler = configuration.mRunnableScheduler;
            this.mExceptionHandler = configuration.mExceptionHandler;
            this.mSchedulingExceptionHandler = configuration.mSchedulingExceptionHandler;
            this.mDefaultProcessName = configuration.mDefaultProcessName;
        }

        public Builder setWorkerFactory(WorkerFactory workerFactory) {
            this.mWorkerFactory = workerFactory;
            return this;
        }

        public Builder setInputMergerFactory(InputMergerFactory inputMergerFactory) {
            this.mInputMergerFactory = inputMergerFactory;
            return this;
        }

        public Builder setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        public Builder setTaskExecutor(Executor taskExecutor) {
            this.mTaskExecutor = taskExecutor;
            return this;
        }

        public Builder setJobSchedulerJobIdRange(int minJobSchedulerId, int maxJobSchedulerId) {
            if ((maxJobSchedulerId - minJobSchedulerId) < 1000) goto L7;
            this.mMinJobSchedulerId = minJobSchedulerId;
            this.mMaxJobSchedulerId = maxJobSchedulerId;
            return this;
        L7:
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }

        public Builder setMaxSchedulerLimit(int maxSchedulerLimit) {
            if (maxSchedulerLimit < 20) goto L7;
            this.mMaxSchedulerLimit = Math.min(maxSchedulerLimit, 50);
            return this;
        L7:
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        public Builder setMinimumLoggingLevel(int loggingLevel) {
            this.mLoggingLevel = loggingLevel;
            return this;
        }

        public Builder setRunnableScheduler(RunnableScheduler runnableScheduler) {
            this.mRunnableScheduler = runnableScheduler;
            return this;
        }

        public Builder setInitializationExceptionHandler(final InitializationExceptionHandler exceptionHandler) {
            Objects.requireNonNull(exceptionHandler);
            this.mExceptionHandler = new Configuration$Builder$$ExternalSyntheticLambda0(exceptionHandler);
            return this;
        }

        public Builder setInitializationExceptionHandler(Consumer<Throwable> exceptionHandler) {
            this.mExceptionHandler = exceptionHandler;
            return this;
        }

        public Builder setSchedulingExceptionHandler(Consumer<Throwable> schedulingExceptionHandler) {
            this.mSchedulingExceptionHandler = schedulingExceptionHandler;
            return this;
        }

        public Builder setDefaultProcessName(String processName) {
            this.mDefaultProcessName = processName;
            return this;
        }

        public Configuration build() {
            return new Configuration(this);
        }
    }

    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    Configuration(Builder builder) {
        if (builder.mExecutor != null) goto L5;
        this.mExecutor = createDefaultExecutor(false);
    L7:
        if (builder.mTaskExecutor != null) goto L9;
        this.mIsUsingDefaultTaskExecutor = true;
        this.mTaskExecutor = createDefaultExecutor(true);
    L11:
        if (builder.mWorkerFactory != null) goto L13;
        this.mWorkerFactory = WorkerFactory.getDefaultWorkerFactory();
    L15:
        if (builder.mInputMergerFactory != null) goto L17;
        this.mInputMergerFactory = InputMergerFactory.getDefaultInputMergerFactory();
    L19:
        if (builder.mRunnableScheduler != null) goto L21;
        this.mRunnableScheduler = new DefaultRunnableScheduler();
    L22:
        this.mLoggingLevel = builder.mLoggingLevel;
        this.mMinJobSchedulerId = builder.mMinJobSchedulerId;
        this.mMaxJobSchedulerId = builder.mMaxJobSchedulerId;
        this.mMaxSchedulerLimit = builder.mMaxSchedulerLimit;
        this.mExceptionHandler = builder.mExceptionHandler;
        this.mSchedulingExceptionHandler = builder.mSchedulingExceptionHandler;
        this.mDefaultProcessName = builder.mDefaultProcessName;
        return;
    L21:
        this.mRunnableScheduler = builder.mRunnableScheduler;
        goto L22
    L17:
        this.mInputMergerFactory = builder.mInputMergerFactory;
        goto L19
    L13:
        this.mWorkerFactory = builder.mWorkerFactory;
        goto L15
    L9:
        this.mIsUsingDefaultTaskExecutor = false;
        this.mTaskExecutor = builder.mTaskExecutor;
        goto L11
    L5:
        this.mExecutor = builder.mExecutor;
        goto L7
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public Executor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }

    public InputMergerFactory getInputMergerFactory() {
        return this.mInputMergerFactory;
    }

    public RunnableScheduler getRunnableScheduler() {
        return this.mRunnableScheduler;
    }

    public int getMinimumLoggingLevel() {
        return this.mLoggingLevel;
    }

    public int getMinJobSchedulerId() {
        return this.mMinJobSchedulerId;
    }

    public int getMaxJobSchedulerId() {
        return this.mMaxJobSchedulerId;
    }

    public String getDefaultProcessName() {
        return this.mDefaultProcessName;
    }

    public int getMaxSchedulerLimit() {
        return this.mMaxSchedulerLimit;
    }

    public boolean isUsingDefaultTaskExecutor() {
        return this.mIsUsingDefaultTaskExecutor;
    }

    public Consumer<Throwable> getInitializationExceptionHandler() {
        return this.mExceptionHandler;
    }

    public Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.mSchedulingExceptionHandler;
    }

    private Executor createDefaultExecutor(boolean isTaskExecutor) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), createDefaultThreadFactory(isTaskExecutor));
    }

    private ThreadFactory createDefaultThreadFactory(final boolean isTaskExecutor) {
        return new AnonymousClass1(this, isTaskExecutor);
    }
}
