package com.tencent.wcdb.support;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;
    private ICancellationSignal mRemote;

    /* JADX INFO: renamed from: com.tencent.wcdb.support.CancellationSignal$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface OnCancelListener {
        void onCancel();
    }

    private static final class Transport extends ICancellationSignal.Stub {
        final CancellationSignal mCancellationSignal;

        private Transport() {
            this.mCancellationSignal = new CancellationSignal();
        }

        /* synthetic */ Transport(AnonymousClass1 r1) {
            this();
        }

        @Override // com.tencent.wcdb.support.ICancellationSignal
        public void cancel() throws RemoteException {
            this.mCancellationSignal.cancel();
        }
    }

    public CancellationSignal() {
    }

    public boolean isCanceled() {
        monitor-enter(this);
        boolean r0 = this.mIsCanceled;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void throwIfCanceled() {
        if (isCanceled() == true) goto L6;
        return;
    L6:
        throw new OperationCanceledException();
    }

    public void cancel() {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsCanceled == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L7:
        this.mIsCanceled = true;     // Catch: Throwable -> L32
        this.mCancelInProgress = true;     // Catch: Throwable -> L32
        OnCancelListener r0 = this.mOnCancelListener;     // Catch: Throwable -> L32
        ICancellationSignal r1 = this.mRemote;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        if (r0 != null) goto L41;
    L15:
        if (r1 != null) goto L43;
    L25:
        monitor-enter(this);
        this.mCancelInProgress = false;     // Catch: Throwable -> L29
        notifyAll();     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L43:
        r1.cancel();     // Catch: Throwable -> L13 RemoteException -> L35
    L13:
        th = move-exception;
        monitor-enter(this);
        this.mCancelInProgress = false;     // Catch: Throwable -> L22
        notifyAll();     // Catch: Throwable -> L22
        throw th;
    L22:
        th = move-exception;
        throw th;
    L41:
        r0.onCancel();     // Catch: Throwable -> L13
        goto L15
    }

    public void setOnCancelListener(OnCancelListener r2) {
        monitor-enter(this);
        waitForCancelFinishedLocked();     // Catch: Throwable -> L16
        if (this.mOnCancelListener != r2) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L7:
        this.mOnCancelListener = r2;     // Catch: Throwable -> L16
        if (this.mIsCanceled == false) goto L14;
        if (r2 == null) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L16
        r2.onCancel();
        return;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void setRemote(ICancellationSignal r2) {
        monitor-enter(this);
        waitForCancelFinishedLocked();     // Catch: Throwable -> L16
        if (this.mRemote != r2) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L7:
        this.mRemote = r2;     // Catch: Throwable -> L16
        if (this.mIsCanceled == false) goto L14;
        if (r2 == null) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L16
        r2.cancel();     // Catch: RemoteException -> L19
        return;
    L23:
        return;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void waitForCancelFinishedLocked() {
    L3:
        if (this.mCancelInProgress == false) goto L6;
        wait();     // Catch: InterruptedException -> L7
        goto L3
    }

    public static ICancellationSignal createTransport() {
        return new Transport(null);
    }

    public static CancellationSignal fromTransport(ICancellationSignal r1) {
        if ((r1 instanceof Transport) == true) goto L5;
        return null;
    L5:
        return ((Transport) r1).mCancellationSignal;
    }
}
