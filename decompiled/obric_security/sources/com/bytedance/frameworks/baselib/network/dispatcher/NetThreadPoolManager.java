package com.bytedance.frameworks.baselib.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class NetThreadPoolManager implements WeakHandler.IHandler {
    static NetThreadPoolManager INSTANCE = null;
    private static final int MSG_API_DELAY = 0;
    private static final int MSG_DOWNLOAD_DELAY = 1;
    private static AtomicInteger mSequenceGenerator;
    private ThreadPoolExecutor mExecutorDownload;
    private ThreadPoolExecutor mExecutorImmediate;
    private ThreadPoolExecutor mExecutorLocal;
    private ThreadPoolExecutor mExecutorLowest;
    private ThreadPoolExecutor mExecutorNormal;
    private WeakHandler mHandler;

    abstract class AbstractLocalRunnable implements Runnable, Comparable<AbstractLocalRunnable> {
        private IApiTask apiTask;
        final /* synthetic */ NetThreadPoolManager this$0;

        static /* synthetic */ IApiTask access$000(AbstractLocalRunnable r0) {
            return r0.apiTask;
        }

        public AbstractLocalRunnable(NetThreadPoolManager r1, IApiTask r2) {
            this.this$0 = r1;
            this.apiTask = r2;
        }
    }

    static class ApiThreadFactory implements ThreadFactory {
        private final AtomicInteger mCount;
        private String mThreadName;

        ApiThreadFactory(String r3) {
            this.mCount = new AtomicInteger(1);
            this.mThreadName = "ApiExecutor";
            if (TextUtils.isEmpty(r3) == true) goto L6;
            this.mThreadName = r3;
            return;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r3) {
            final String r0 = this.mThreadName + "#" + this.mCount.getAndIncrement();
            Thread r1 = new AnonymousClass1(this, r3, r0);
            r1.setDaemon(false);
            return r1;
        }
    }

    static /* synthetic */ ExecutorService access$100(NetThreadPoolManager r0) {
        return r0.executorImmediateService();
    }

    static /* synthetic */ ExecutorService access$200(NetThreadPoolManager r0) {
        return r0.executorApiService();
    }

    static {
        mSequenceGenerator = new AtomicInteger();
        INSTANCE = new NetThreadPoolManager();
    }

    private static int getSequenceNumber() {
        return mSequenceGenerator.incrementAndGet();
    }

    private NetThreadPoolManager() {
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
    }

    private ThreadPoolConfig getThreadPoolConfig() {
        return RequestQueue.getThreadPoolConfig();
    }

    private synchronized ExecutorService executorImmediateService() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mExecutorImmediate != null) goto L8;
        ThreadPoolExecutor r0 = getThreadPoolConfig().getImmediateThreadPool();     // Catch: Throwable -> L11
        this.mExecutorImmediate = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        this.mExecutorImmediate = new ThreadPoolExecutor(getThreadPoolConfig().getCoreImmediateThreadSize(), Integer.MAX_VALUE, getThreadPoolConfig().getImmediateAliveTime(), TimeUnit.SECONDS, new SynchronousQueue(), new ApiThreadFactory("NetImmediate"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r1 = this.mExecutorImmediate;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    private synchronized ExecutorService executorApiService() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mExecutorNormal != null) goto L8;
        ThreadPoolExecutor r0 = getThreadPoolConfig().getNormalThreadPool();     // Catch: Throwable -> L11
        this.mExecutorNormal = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(getThreadPoolConfig().getCoreApiThreadSize(), getThreadPoolConfig().getMaxApiThreadSize(), getThreadPoolConfig().getApiAliveTime(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ApiThreadFactory("NetNormal"));     // Catch: Throwable -> L11
        this.mExecutorNormal = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(RequestQueue.getThreadPoolConfig().isDynamicAdjust());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.mExecutorNormal;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService executorDownloadService() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mExecutorDownload != null) goto L8;
        ThreadPoolExecutor r0 = getThreadPoolConfig().getDownloadThreadPool();     // Catch: Throwable -> L11
        this.mExecutorDownload = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(getThreadPoolConfig().getCoreDownloadThreadSize(), getThreadPoolConfig().getMaxDownloadThreadSize(), getThreadPoolConfig().getDownloadAliveTime(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ApiThreadFactory("NetDownload"));     // Catch: Throwable -> L11
        this.mExecutorDownload = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(RequestQueue.getThreadPoolConfig().isDynamicAdjust());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.mExecutorDownload;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService executorLowestService() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mExecutorLowest != null) goto L8;
        ThreadPoolExecutor r0 = getThreadPoolConfig().getLowestThreadPool();     // Catch: Throwable -> L11
        this.mExecutorLowest = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(getThreadPoolConfig().getCoreLowestThreadSize(), getThreadPoolConfig().getCoreLowestThreadSize(), getThreadPoolConfig().getLowestAliveTime(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ApiThreadFactory("NetLowest"));     // Catch: Throwable -> L11
        this.mExecutorLowest = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.mExecutorLowest;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService executorLocalService() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mExecutorLocal != null) goto L8;
        ThreadPoolExecutor r0 = getThreadPoolConfig().getLocalThreadPool();     // Catch: Throwable -> L11
        this.mExecutorLocal = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        this.mExecutorLocal = new ThreadPoolExecutor(1, 1, getThreadPoolConfig().getImmediateAliveTime(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ApiThreadFactory("NetLocal"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r1 = this.mExecutorLocal;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    void executeDownload(IApiTask r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isCanceled() == true) goto L21;
        r5.setSequence(getSequenceNumber());
        if (r5.getPriority() != IRequest.Priority.IMMEDIATE) goto L10;
        executorImmediateService().execute(r5);
        return;
    L10:
        if (r5.getPriority() != IRequest.Priority.LOWEST) goto L12;
        executorLowestService().execute(r5);
        return;
    L12:
        long r0 = r5.getDelayTime();
        if (r0 <= 0) goto L15;
        Message r2 = Message.obtain();
        r2.what = 1;
        r2.obj = r5;
        this.mHandler.sendMessageDelayed(r2, r0);
        return;
    L15:
        setBlockingQueueSize(this.mExecutorDownload, r5);
        executorDownloadService().execute(r5);
        return;
    }

    void executeApi(IApiTask r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isCanceled() == true) goto L25;
        r5.setSequence(getSequenceNumber());
        if (r5.needTryLocal() == false) goto L10;
        executorLocalService().execute(getLocalRunnable(r5));
        return;
    L10:
        if (r5.getPriority() != IRequest.Priority.IMMEDIATE) goto L13;
        executorImmediateService().execute(r5);
        return;
    L13:
        if (r5.getPriority() != IRequest.Priority.LOWEST) goto L15;
        executorLowestService().execute(r5);
        return;
    L15:
        long r0 = r5.getDelayTime();
        if (r0 <= 0) goto L18;
        Message r2 = Message.obtain();
        r2.what = 0;
        r2.obj = r5;
        this.mHandler.sendMessageDelayed(r2, r0);
        return;
    L18:
        setBlockingQueueSize(this.mExecutorNormal, r5);
        executorApiService().execute(r5);
        return;
    }

    private AbstractLocalRunnable getLocalRunnable(final IApiTask r2) {
        return new AnonymousClass1(this, r2, r2);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((r3.obj instanceof Runnable) == false) goto L22;
        int r0 = r3.what;     // Catch: Throwable -> L14
        if (r0 != 0) goto L9;
        setBlockingQueueSize(this.mExecutorNormal, (IApiTask) r3.obj);     // Catch: Throwable -> L14
        executorApiService().execute((Runnable) r3.obj);     // Catch: Throwable -> L14
    L17:
        return;
    L9:
        if (r0 != 1) goto L17;
        setBlockingQueueSize(this.mExecutorDownload, (IApiTask) r3.obj);     // Catch: Throwable -> L14
        executorImmediateService().execute((Runnable) r3.obj);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private static void setBlockingQueueSize(ThreadPoolExecutor r1, IApiTask r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if ((r2 instanceof ApiTask) == false) goto L8;
        ((ApiTask) r2).setBlockingQueueSize(r1.getQueue().size());
        return;
    }
}
