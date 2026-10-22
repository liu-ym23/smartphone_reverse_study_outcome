package com.ttnet.org.chromium.base.task;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.DoNotInline;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AsyncTask<Result> {
    private static final String GET_STATUS_UMA_HISTOGRAM = "Android.Jank.AsyncTaskGetOnUiThreadStatus";
    public static final Executor SERIAL_EXECUTOR = null;
    private static final StealRunnableHandler STEAL_RUNNABLE_HANDLER = null;
    private static final String TAG = "AsyncTask";
    public static final Executor THREAD_POOL_EXECUTOR = null;
    private final AtomicBoolean mCancelled;
    private final AsyncTask<Result>.NamedFutureTask mFuture;
    private volatile int mStatus;
    private final AtomicBoolean mTaskInvoked;
    private final Callable<Result> mWorker;

    public class NamedFutureTask extends FutureTask<Result> {
        final /* synthetic */ AsyncTask this$0;

        public NamedFutureTask(AsyncTask r1, Callable<Result> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            AsyncTask.access$500(this.this$0, get());     // Catch: ExecutionException -> L4 InterruptedException -> L6 CancellationException -> L8
        L16:
            return;
        L6:
            e = move-exception;
            Log.w(AsyncTask.TAG, e.toString(), new Object[0]);
            return;
        L8:
            AsyncTask.access$500(this.this$0, null);
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("An error occurred while executing doInBackground()", e.getCause());
        }

        public Class getBlamedClass() {
            return this.this$0.getClass();
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            TraceEvent r0 = TraceEvent.scoped("AsyncTask.run: ".concat(AsyncTask.access$400(this.this$0).getBlamedClass().getName()));
            super.run();     // Catch: Throwable -> L7
            if (r0 == null) goto L18;
            r0.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (r0 != null) goto L16;
        L13:
            throw th;
        L16:
            r0.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int FINISHED = 2;
        public static final int NUM_ENTRIES = 3;
        public static final int PENDING = 0;
        public static final int RUNNING = 1;
    }

    public static class StealRunnableHandler implements RejectedExecutionHandler {
        private StealRunnableHandler() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r1, ThreadPoolExecutor r2) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(r1);
        }

        public /* synthetic */ StealRunnableHandler(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        THREAD_POOL_EXECUTOR = new a();
        SERIAL_EXECUTOR = new SerialExecutor();
        STEAL_RUNNABLE_HANDLER = new StealRunnableHandler(null);
    }

    public AsyncTask() {
        this.mStatus = 0;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        Callable<Result> r0 = new AnonymousClass1(this);
        this.mWorker = r0;
        this.mFuture = new NamedFutureTask(this, r0);
    }

    public static /* synthetic */ void a(AsyncTask r0, Object r1) {
        r0.lambda$postResult$1(r1);
    }

    public static /* synthetic */ AtomicBoolean access$100(AsyncTask r0) {
        return r0.mTaskInvoked;
    }

    public static /* synthetic */ AtomicBoolean access$200(AsyncTask r0) {
        return r0.mCancelled;
    }

    public static /* synthetic */ void access$300(AsyncTask r0, Object r1) {
        r0.postResult(r1);
    }

    public static /* synthetic */ NamedFutureTask access$400(AsyncTask r0) {
        return r0.mFuture;
    }

    public static /* synthetic */ void access$500(AsyncTask r0, Object r1) {
        r0.postResultIfNotInvoked(r1);
    }

    public static /* synthetic */ void b(Runnable r0) {
        lambda$static$0(r0);
    }

    private void executionPreamble() {
        if (this.mStatus == 0) goto L13;
        int r0 = this.mStatus;
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L13;
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    L12:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
    L13:
        this.mStatus = 1;
        onPreExecute();
    }

    private void finish(Result r2) {
        if (isCancelled() == false) goto L5;
        onCancelled(r2);
    L6:
        this.mStatus = 2;
        return;
    L5:
        onPostExecute(r2);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$postResult$1(Object r1) {
        finish(r1);
    }

    private static /* synthetic */ void lambda$static$0(Runnable r1) {
        PostTask.postTask(TaskTraits.BEST_EFFORT_MAY_BLOCK, r1);
    }

    private void postResult(Result r3) {
        if ((this instanceof BackgroundOnlyAsyncTask) == false) goto L5;
        this.mStatus = 2;
        return;
    L5:
        ThreadUtils.postOnUiThread(new androidx.constraintlayout.motion.widget.a(11, this, r3));
    }

    private void postResultIfNotInvoked(Result r2) {
        if (this.mTaskInvoked.get() == true) goto L6;
        postResult(r2);
        return;
    }

    public static void takeOverAndroidThreadPool() {
        ThreadPoolExecutor r0 = (ThreadPoolExecutor) android.os.AsyncTask.THREAD_POOL_EXECUTOR;
        r0.setRejectedExecutionHandler(STEAL_RUNNABLE_HANDLER);
        r0.shutdown();
    }

    public final boolean cancel(boolean r3) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(r3);
    }

    @WorkerThread
    public abstract Result doInBackground();

    @MainThread
    public final AsyncTask<Result> executeOnExecutor(Executor r2) {
        executionPreamble();
        r2.execute(this.mFuture);
        return this;
    }

    @MainThread
    public final AsyncTask<Result> executeOnTaskRunner(TaskRunner r2) {
        executionPreamble();
        r2.postTask(this.mFuture);
        return this;
    }

    @MainThread
    public final AsyncTask<Result> executeWithTaskTraits(TaskTraits r2) {
        executionPreamble();
        PostTask.postTask(r2, this.mFuture);
        return this;
    }

    @DoNotInline
    public final Result get() {
        int r0 = getUmaStatus();
        if (r0 == 2) goto L22;
        if (ThreadUtils.runningOnUiThread() == false) goto L22;
        RecordHistogram.recordEnumeratedHistogram(GET_STATUS_UMA_HISTOGRAM, r0, 3);
        StackTraceElement[] r1 = new Exception().getStackTrace();
        if (r1.length <= 1) goto L9;
        String r2 = r1[1].getClassName() + '.' + r1[1].getMethodName() + '.';
    L10:
        TraceEvent r3 = TraceEvent.scoped(r2 + "AsyncTask.get");
        Result r4 = this.mFuture.get();     // Catch: Throwable -> L14
        if (r3 == null) goto L27;
        r3.close();
        return r4;
    L27:
        return r4;
    L14:
        th = move-exception;
        if (r3 != null) goto L25;
    L20:
        throw th;
    L25:
        r3.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    L9:
        r2 = "";
    L22:
        return this.mFuture.get();
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public final int getUmaStatus() {
        if (this.mStatus != 1) goto L9;
        if (this.mTaskInvoked.get() == true) goto L9;
        return 0;
    L9:
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    @MainThread
    public void onCancelled() {
    }

    @MainThread
    public abstract void onPostExecute(Result r1);

    @MainThread
    public void onPreExecute() {
    }

    @MainThread
    public void onCancelled(Result r1) {
        onCancelled();
    }

    @DoNotInline
    public final Result get(long r5, TimeUnit r7) {
        int r0 = getUmaStatus();
        if (r0 == 2) goto L22;
        if (ThreadUtils.runningOnUiThread() == false) goto L22;
        RecordHistogram.recordEnumeratedHistogram(GET_STATUS_UMA_HISTOGRAM, r0, 3);
        StackTraceElement[] r1 = new Exception().getStackTrace();
        if (r1.length <= 1) goto L9;
        String r2 = r1[1].getClassName() + '.' + r1[1].getMethodName() + '.';
    L10:
        TraceEvent r3 = TraceEvent.scoped(r2 + "AsyncTask.get");
        Result r4 = this.mFuture.get(r5, r7);     // Catch: Throwable -> L14
        if (r3 == null) goto L27;
        r3.close();
        return r4;
    L27:
        return r4;
    L14:
        th = move-exception;
        if (r3 != null) goto L25;
    L20:
        throw th;
    L25:
        r3.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    L9:
        r2 = "";
    L22:
        return this.mFuture.get(r5, r7);
    }
}
