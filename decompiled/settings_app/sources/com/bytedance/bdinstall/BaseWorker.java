package com.bytedance.bdinstall;

import android.content.Context;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.bdinstall.util.NetUtils;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseWorker {
    private static final long NEXT_CHECK_NET = 60000;
    private static final long NEXT_CHECK_SILENCE = 60000;
    final Context mApp;
    private int mFailCount;
    private long mLastTime;
    private InstallDispatcher.NetworkObserver.OnNetworkReadyListener mNetListener;
    private boolean mStop;

    @interface Error {
        public static final int ERR_NETWORK = 1;
        public static final int ERR_REQUEST_FAILED = 3;
        public static final int ERR_TIME_NOT_READY = 2;
        public static final int UNKNOWN = 0;
    }

    static class WorkResult {
        int errReason;
        long nextDelay;
        boolean success;

        WorkResult() {
            this.success = false;
            this.errReason = 0;
            this.nextDelay = 0;
        }
    }

    protected abstract boolean doWork() throws JSONException;

    protected abstract String getName();

    protected abstract long[] getRetryIntervals();

    public abstract boolean needListenNetChange();

    protected abstract boolean needNet();

    protected abstract long nextInterval();

    long silenceCheckInterval() {
        return 60000;
    }

    protected BaseWorker(Context r2) {
        this.mFailCount = 0;
        this.mApp = r2;
    }

    protected BaseWorker(Context r2, long r3) {
        this.mFailCount = 0;
        this.mApp = r2;
        this.mLastTime = r3;
    }

    protected void stop() {
        this.mStop = true;
    }

    boolean isStop() {
        return this.mStop;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final WorkResult work() {
        boolean r1 = true;
        int r2 = 1;
        int r3 = 0;
        boolean r4 = false;
        r4 = false;
        if (needNet() == true) goto L5;
    L8:
        Object[] r0 = true;
    L9:
        if (r0 == true) goto L11;
        DrLog.e("network not ready. delay 60000 ms do " + getName());
        long r5 = 60000;
    L22:
        WorkResult r10 = new WorkResult();
        r10.errReason = r2;
        r10.success = r4;
        r10.nextDelay = r5;
        return r10;
    L11:
        long r6 = this.mLastTime + nextInterval();
        long r7 = System.currentTimeMillis();
        if (r6 <= (1000 + r7)) goto L24;
        r5 = r6 - r7;
        DrLog.d("time not ready. need " + r5);
        r2 = 2;
        goto L22
    L24:
        boolean r8 = doWork();     // Catch: Exception -> L15
    L17:
        if (r8 == false) goto L19;
        this.mFailCount = 0;
        this.mLastTime = System.currentTimeMillis();
        r5 = nextInterval();
    L20:
        DrLog.i(getName() + " worked:" + r8 + HanziToPinyin.Token.SEPARATOR + r5, null);
        int r9 = r3;
        r4 = r1;
        r2 = r9;
        goto L22
    L19:
        long[] r11 = getRetryIntervals();
        int r12 = this.mFailCount;
        this.mFailCount = r12 + 1;
        r5 = r11[r12 % r11.length];
        r3 = 3;
        r1 = false;
    L15:
        e = move-exception;
        DrLog.ysnp(e);
        r8 = false;
        goto L17
    L5:
        if (NetUtils.isNetReady(this.mApp) == true) goto L8;
        r0 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseWorker> T setImmediately() {
        this.mLastTime = 0;
        return this;
    }

    public void setNetObserver(InstallDispatcher.NetworkObserver.OnNetworkReadyListener r1) {
        this.mNetListener = r1;
    }

    public InstallDispatcher.NetworkObserver.OnNetworkReadyListener getNetObserver() {
        return this.mNetListener;
    }
}
