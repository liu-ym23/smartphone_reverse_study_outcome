package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public class WorkForegroundRunnable implements Runnable {
    static final String TAG = null;
    final Context mContext;
    final ForegroundUpdater mForegroundUpdater;
    final SettableFuture<Void> mFuture;
    final TaskExecutor mTaskExecutor;
    final WorkSpec mWorkSpec;
    final ListenableWorker mWorker;

    static {
        TAG = Logger.tagWithPrefix("WorkForegroundRunnable");
    }

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker worker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor) {
        this.mFuture = SettableFuture.create();
        this.mContext = context;
        this.mWorkSpec = workSpec;
        this.mWorker = worker;
        this.mForegroundUpdater = foregroundUpdater;
        this.mTaskExecutor = taskExecutor;
    }

    public ListenableFuture<Void> getFuture() {
        return this.mFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mWorkSpec.expedited == true) goto L5;
    L9:
        this.mFuture.set(null);
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 31) goto L9;
        final SettableFuture r0 = SettableFuture.create();
        this.mTaskExecutor.getMainThreadExecutor().execute(new WorkForegroundRunnable$$ExternalSyntheticLambda0(this, r0));
        r0.addListener(new AnonymousClass1(this, r0), this.mTaskExecutor.getMainThreadExecutor());
    }

    /* JADX INFO: renamed from: lambda$run$0$androidx-work-impl-utils-WorkForegroundRunnable, reason: not valid java name */
    /* synthetic */ void m66lambda$run$0$androidxworkimplutilsWorkForegroundRunnable(SettableFuture r2) {
        if (this.mFuture.isCancelled() == true) goto L5;
        r2.setFuture(this.mWorker.getForegroundInfoAsync());
        return;
    L5:
        r2.cancel(true);
    }
}
