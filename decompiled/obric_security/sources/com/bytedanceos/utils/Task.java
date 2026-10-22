package com.bytedanceos.utils;

import android.os.Looper;
import android.os.Message;
import com.obric.olog.OLog;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class Task<T> implements Runnable, WeakHandler.IHandler {
    private static final int ACTION = 100001;
    private ITaskCallback<T> mCallback;
    private Executor mExecutor;
    private WeakHandler mMainHandler;
    private T mResult;
    private ITaskRunnable<T> mRunnable;
    public String taskName;

    public static <T> void execute(ITaskRunnable<T> runnable, ITaskCallback<T> callback, String taskName) {
        if (runnable == null) goto L5;
        Task r0 = new Task(runnable, callback, ExecutorFactory.getDefaultExecutor());
        r0.taskName = taskName;
        r0.start();
        return;
    }

    public static <T> void execute(ITaskRunnable<T> runnable, ITaskCallback<T> callback, Executor executor) {
        if (runnable == null) goto L5;
        new Task(runnable, callback, executor).start();
        return;
    }

    private Task(ITaskRunnable<T> runnable, ITaskCallback<T> callback, Executor executor) {
        this.mRunnable = runnable;
        this.mCallback = callback;
        this.mMainHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mExecutor = executor;
    }

    @Override // java.lang.Runnable
    public void run() {
        ITaskRunnable<T> r0 = this.mRunnable;
        if (r0 != null) goto L13;
    L8:
        T r1 = null;
    L9:
        OLog.d("com.obric.utils.Task", "taskname:" + this.taskName);
        this.mResult = r1;
        if (this.mMainHandler == null) goto L15;
        Message r2 = Message.obtain();
        r2.what = ACTION;
        r2.obj = this;
        this.mMainHandler.sendMessage(r2);
        return;
    L15:
        return;
    L13:
        r1 = r0.onRun();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void start() {
        this.mExecutor.execute(this);
    }

    @Override // com.bytedanceos.utils.WeakHandler.IHandler
    public void handleMsg(Message msg) {
        if ((msg.obj instanceof Task) == true) goto L5;
        return;
    L5:
        Task r1 = (Task) msg.obj;
        if (msg.what != ACTION) goto L18;
        ITaskCallback<T> r2 = r1.mCallback;
        if (r2 == null) goto L17;
        r2.onCallback(r1.mResult);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        return;
    }
}
