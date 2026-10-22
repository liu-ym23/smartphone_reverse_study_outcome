package obric.time;

import android.os.Handler;
import android.os.Looper;
import com.obric.olog.OLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: TimeProvider.java */
/* JADX INFO: loaded from: classes5.dex */
class TimeProviderImpl extends TimeProvider {
    private static final int CORE_POOL_SIZE = 1;
    private static final int KEEP_ALIVE_SECONDS = 5;
    private static final int MAXIMUM_POOL_SIZE = 1;
    private static final int MSG_FETCH_TIME_DONE = 0;
    private static final int MSG_FETCH_TIME_RETRY = 1;
    private static final Executor THREAD_POOL_EXECUTOR = null;
    private static final int[] sRetryDelayTimes = null;
    private static final ThreadFactory sThreadFactory = null;
    private FutureTask<ReferenceTime> mCurFetchTask;
    private AtomicBoolean mFetching;
    private Handler mHandler;
    private WeakReference<TimeProvider.OnTimeFetchedListener> mListenerRef;
    private NetWorkMonitor mNetworkMonitor;
    private ReferenceTime mRefTime;
    private TimeFetcher mTimeFetcher;
    private int mTryTimes;

    TimeProviderImpl() {
        this.mFetching = new AtomicBoolean(false);
        this.mTryTimes = 0;
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass2(this, r1);
    }

    static /* synthetic */ boolean access$000(TimeProviderImpl r0) {
        return r0.internalSyncTime();
    }

    static /* synthetic */ void access$100(TimeProviderImpl r0, ReferenceTime r1) {
        r0.onTimeFetchedDone(r1);
    }

    static /* synthetic */ AtomicBoolean access$200(TimeProviderImpl r0) {
        return r0.mFetching;
    }

    static /* synthetic */ void access$300(TimeProviderImpl r0) {
        r0.stopFetchingTask();
    }

    static /* synthetic */ TimeFetcher access$400(TimeProviderImpl r0) {
        return r0.mTimeFetcher;
    }

    static /* synthetic */ int access$500(TimeProviderImpl r0) {
        return r0.mTryTimes;
    }

    static /* synthetic */ int[] access$600() {
        return sRetryDelayTimes;
    }

    static /* synthetic */ void access$700(TimeProviderImpl r0) {
        r0.retryInternalSyncTime();
    }

    static /* synthetic */ Handler access$800(TimeProviderImpl r0) {
        return r0.mHandler;
    }

    static {
        sRetryDelayTimes = new int[]{0, 1, 4, 4, 8, 16, 32, 64};
        ThreadFactory r8 = new AnonymousClass1();
        sThreadFactory = r8;
        ThreadPoolExecutor r0 = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new SynchronousQueue(), r8);
        r0.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = r0;
    }

    private void onTimeFetchedDone(ReferenceTime r2) {
        ReferenceTime r0 = this.mRefTime;
        if (r0 != null) goto L5;
    L6:
        if (r2 == null) goto L8;
        this.mRefTime = r2;
    L8:
        clean();
        notifyListener();
        return;
    L5:
        if (r0.isValidNetworkTime() == true) goto L8;
        goto L6
    }

    private void notifyListener() {
        WeakReference<TimeProvider.OnTimeFetchedListener> r0 = this.mListenerRef;
        if (r0 == null) goto L14;
        TimeProvider.OnTimeFetchedListener r1 = r0.get();
        if (r1 == null) goto L15;
        ReferenceTime r2 = this.mRefTime;
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        r1.onTimeFetched(r3);
        return;
    L9:
        if (r2.isValidNetworkTime() == false) goto L11;
        r3 = true;
        goto L12
    L15:
        return;
    }

    private void registerNetworkCallback() {
        if (this.mNetworkMonitor == null) goto L6;
        OLog.d("TimeProvider", "Network monitor has been monitoring.");
        return;
    L6:
        this.mNetworkMonitor = new NetWorkMonitor(this.mContext, new AnonymousClass3(this));
    }

    private boolean checkSelfPermission() {
        if (this.mContext.checkSelfPermission("android.permission.INTERNET") == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) goto L7;
        return true;
    }

    @Override // obric.time.TimeProvider
    public synchronized boolean startSyncTime(TimeProvider.OnTimeFetchedListener r4) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (checkSelfPermission() == true) goto L9;
        OLog.e("TimeProvider", "Permission android.permission.INTERNET & android.permission.ACCESS_NETWORK_STATE must be needed.");     // Catch: Throwable -> L21
        monitor-exit(this);
        return false;
    L9:
        if (this.mFetching.getAndSet(true) == false) goto L13;
        OLog.d("TimeProvider", "Time is being fetching, you should cancel before starting a new.");     // Catch: Throwable -> L21
        monitor-exit(this);
        return false;
    L13:
        this.mTimeFetcher = new HttpHeadTimeFetcher();     // Catch: Throwable -> L21
        this.mListenerRef = new WeakReference(r4);     // Catch: Throwable -> L21
        registerNetworkCallback();     // Catch: Throwable -> L21
        if (this.mNetworkMonitor.isNetworkAvailable() == true) goto L18;
        this.mFetching.set(false);     // Catch: Throwable -> L21
        OLog.i("TimeProvider", "No available network to use and the fetcher will work once the network is connected unless you cancel the sync");     // Catch: Throwable -> L21
        monitor-exit(this);
        return true;
    L18:
        boolean r5 = internalSyncTime();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r5;
    }

    private synchronized boolean internalSyncTime() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mTimeFetcher != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        final TimeFetcher r1 = this.mTimeFetcher;     // Catch: Throwable -> L11
        FutureTask<ReferenceTime> r0 = new AnonymousClass4(this, r1);     // Catch: Throwable -> L11
        this.mCurFetchTask = r0;     // Catch: Throwable -> L11
        THREAD_POOL_EXECUTOR.execute(r0);     // Catch: Throwable -> L11
        this.mTryTimes++;     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    }

    private synchronized void retryInternalSyncTime() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mTimeFetcher == null) goto L14;
        FutureTask<ReferenceTime> r1 = this.mCurFetchTask;     // Catch: Throwable -> L16
        if (r1 == null) goto L14;
        if (r1.isCancelled() == true) goto L14;
        StringBuilder r2 = new StringBuilder("After ");     // Catch: Throwable -> L16
        int[] r0 = sRetryDelayTimes;     // Catch: Throwable -> L16
        OLog.d("TimeProvider", r2.append(r0[this.mTryTimes]).append("s, will retry to fetch time again").toString());     // Catch: Throwable -> L16
        this.mHandler.sendEmptyMessageDelayed(1, r0[this.mTryTimes] * 1000);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L14:
        monitor-exit(this);
    }

    @Override // obric.time.TimeProvider
    public synchronized void cancelSyncTime() {
        monitor-enter(this);
        stopFetchingTask();     // Catch: Throwable -> L6
        clean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // obric.time.TimeProvider
    public long getNetworkTimeMillis() {
        if (this.mFetching.get() == false) goto L6;
        return -2;
    L6:
        ReferenceTime r2 = this.mRefTime;
        if (r2 != null) goto L9;
        return -1;
    L9:
        return r2.getNetworkTimeMillis();
    }

    @Override // obric.time.TimeProvider
    public long getCurrentTimeMillis() {
        long r0 = getNetworkTimeMillis();
        if (r0 <= (-1)) goto L5;
        return r0;
    L5:
        return System.currentTimeMillis();
    }

    private synchronized void stopFetchingTask() {
        monitor-enter(this);
        FutureTask<ReferenceTime> r0 = this.mCurFetchTask;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.cancel(true);     // Catch: Throwable -> L9
    L6:
        this.mCurFetchTask = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private synchronized void clean() {
        monitor-enter(this);
        NetWorkMonitor r0 = this.mNetworkMonitor;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.destroy();     // Catch: Throwable -> L9
        this.mNetworkMonitor = null;     // Catch: Throwable -> L9
    L6:
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L9
        this.mTimeFetcher = null;     // Catch: Throwable -> L9
        this.mTryTimes = 0;     // Catch: Throwable -> L9
        this.mFetching.set(false);     // Catch: Throwable -> L9
        this.mCurFetchTask = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
