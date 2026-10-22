package com.bytedance.bdinstall;

import android.os.Looper;
import android.text.TextUtils;
import com.obric.oui.texteffects.preset.DimPointEffectTokens;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
class InstallWaitingLock {
    private static volatile boolean sIsOldWayNotWaiting;
    private static final ThreadLocal<Boolean> sIsRequesting = null;
    private static volatile boolean sLoadingOnlineConfig;
    private volatile boolean mHasInstallFinished;
    private final AtomicBoolean mHasRegisterEvent;
    private final Object mLock;

    InstallWaitingLock() {
        this.mLock = new Object();
        this.mHasInstallFinished = false;
        this.mHasRegisterEvent = new AtomicBoolean(false);
    }

    static /* synthetic */ void access$000(InstallWaitingLock r0) {
        r0.notifyInstallFinish();
    }

    static {
        sIsRequesting = new ThreadLocal();
        sIsOldWayNotWaiting = false;
        sLoadingOnlineConfig = false;
    }

    static void setRequestingActive(boolean r1) {
        if (r1 == false) goto L4;
        sIsRequesting.set(Boolean.valueOf(r1));
        return;
    L4:
        sIsRequesting.remove();
    }

    static void setRequestingRegister(boolean r1) {
        sLoadingOnlineConfig = r1;
        if (r1 == false) goto L5;
        sIsRequesting.set(Boolean.valueOf(r1));
        return;
    L5:
        sIsRequesting.remove();
        sIsOldWayNotWaiting = true;
        DrLog.d("tryWaitingForInstallFinishWithOldWay finish because request finished");
    }

    void tryWaitingForInstallFinish(long r4) throws InterruptedException {
        if (sIsRequesting.get() == null) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        tryRegisterInstallEvent();     // Catch: Throwable -> L15
        if (Looper.myLooper() != ExecutorUtil.getLooper()) goto L11;
        DrLog.ysnp(new RuntimeException("did generate at this thread,you shouldn't block this thread"));     // Catch: Throwable -> L15
    L11:
        if (this.mHasInstallFinished == true) goto L13;
        this.mLock.wait(r4);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    void tryWaitingForInstallFinishInOldWay() {
        if (sIsRequesting.get() == null) goto L5;
        return;
    L5:
        DrLog.d("tryWaitingForInstallFinishWithOldWay");
        Object r0 = this.mLock;
        monitor-enter(r0);
        tryRegisterInstallEvent();     // Catch: Throwable -> L27
        if (sIsOldWayNotWaiting == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L12:
        if (Looper.myLooper() != ExecutorUtil.getLooper()) goto L15;
        DrLog.ysnp(new RuntimeException("did generate at this thread,you shouldn't block this thread"));     // Catch: Throwable -> L27
    L15:
        if (sLoadingOnlineConfig == false) goto L17;
        long r1 = 4000;
    L19:
        if (this.mHasInstallFinished == false) goto L30;
    L24:
        sIsOldWayNotWaiting = true;     // Catch: Throwable -> L27
        DrLog.d("tryWaitingForInstallFinishWithOldWay finish");     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L30:
        this.mLock.wait(r1);     // Catch: InterruptedException -> L22 Throwable -> L27
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        goto L24
    L17:
        r1 = DimPointEffectTokens.PendingCycleMs;
    L27:
        th = move-exception;
        throw th;
    }

    private void tryRegisterInstallEvent() {
        if (this.mHasRegisterEvent.compareAndSet(false, true) == false) goto L12;
        DrLog.d("start register install event");
        BDInstall.addInstallListener(false, new AnonymousClass1(this));
        InstallInfo r0 = BDInstall.getInstallInfo();
        if (r0 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r0.getDid()) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r0.getIid()) == true) goto L15;
        notifyInstallFinish();
        return;
    L15:
        return;
    }

    private void notifyInstallFinish() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHasInstallFinished = true;     // Catch: Throwable -> L8
        this.mLock.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void reset() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHasInstallFinished = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
