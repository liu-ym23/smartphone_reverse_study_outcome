package com.tencent.wcdb;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements IBinder.DeathRecipient {
    private static final String TAG = "Cursor";
    private CrossProcessCursor mCursor;
    private CursorWindow mFilledWindow;
    private final Object mLock;
    private ContentObserverProxy mObserver;
    private final String mProviderName;

    private static final class ContentObserverProxy extends ContentObserver {
        protected IContentObserver mRemote;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        public ContentObserverProxy(IContentObserver r2, IBinder.DeathRecipient r3) {
            super(null);
            this.mRemote = r2;
            r2.asBinder().linkToDeath(r3, 0);     // Catch: RemoteException -> L5
            return;
        }

        public boolean unlinkToDeath(IBinder.DeathRecipient r2) {
            return this.mRemote.asBinder().unlinkToDeath(r2, 0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1, Uri r2) {
            this.mRemote.onChange(r1, r2);     // Catch: RemoteException -> L4
            return;
        }
    }

    public CursorToBulkCursorAdaptor(Cursor r3, IContentObserver r4, String r5) {
        Object r0 = new Object();
        this.mLock = r0;
        if ((r3 instanceof CrossProcessCursor) == false) goto L5;
        this.mCursor = (CrossProcessCursor) r3;
    L6:
        this.mProviderName = r5;
        monitor-enter(r0);
        createAndRegisterObserverProxyLocked(r4);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        this.mCursor = new CrossProcessCursorWrapper(r3);
        goto L6
    }

    private void closeFilledWindowLocked() {
        CursorWindow r0 = this.mFilledWindow;
        if (r0 == null) goto L6;
        r0.close();
        this.mFilledWindow = null;
        return;
    }

    private void disposeLocked() {
        if (this.mCursor == null) goto L5;
        unregisterObserverProxyLocked();
        this.mCursor.close();
        this.mCursor = null;
    L5:
        closeFilledWindowLocked();
    }

    private void throwIfCursorIsClosed() {
        if (this.mCursor == null) goto L6;
        return;
    L6:
        throw new StaleDataException("Attempted to access a cursor after it has been closed.");
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        disposeLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public BulkCursorDescriptor getBulkCursorDescriptor() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfCursorIsClosed();     // Catch: Throwable -> L9
        BulkCursorDescriptor r1 = new BulkCursorDescriptor();     // Catch: Throwable -> L9
        r1.cursor = this;     // Catch: Throwable -> L9
        r1.columnNames = this.mCursor.getColumnNames();     // Catch: Throwable -> L9
        r1.wantsAllOnMoveCalls = this.mCursor.getWantsAllOnMoveCalls();     // Catch: Throwable -> L9
        r1.count = this.mCursor.getCount();     // Catch: Throwable -> L9
        r1.window = this.mCursor.getWindow();     // Catch: Throwable -> L9
        if (r1.window == null) goto L7;
        r1.window.acquireReference();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public CursorWindow getWindow(int r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfCursorIsClosed();     // Catch: Throwable -> L26
        if (this.mCursor.moveToPosition(r5) == true) goto L10;
        closeFilledWindowLocked();     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return null;
    L10:
        CursorWindow r1 = this.mCursor.getWindow();     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        closeFilledWindowLocked();     // Catch: Throwable -> L26
    L22:
        if (r1 == null) goto L24;
        r1.acquireReference();     // Catch: Throwable -> L26
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r1;
    L13:
        r1 = this.mFilledWindow;     // Catch: Throwable -> L26
        if (r1 != null) goto L17;
        r1 = new CursorWindow(this.mProviderName);     // Catch: Throwable -> L26
        this.mFilledWindow = r1;     // Catch: Throwable -> L26
    L21:
        this.mCursor.fillWindow(r5, r1);     // Catch: Throwable -> L26
        goto L22
    L17:
        if (r5 >= r1.getStartPosition()) goto L19;
    L20:
        r1.clear();     // Catch: Throwable -> L26
        goto L21
    L19:
        if (r5 < (r1.getStartPosition() + r1.getNumRows())) goto L21;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public void onMove(int r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfCursorIsClosed();     // Catch: Throwable -> L7
        CrossProcessCursor r2 = this.mCursor;     // Catch: Throwable -> L7
        r2.onMove(r2.getPosition(), r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public void deactivate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mCursor == null) goto L7;
        unregisterObserverProxyLocked();     // Catch: Throwable -> L10
        this.mCursor.deactivate();     // Catch: Throwable -> L10
    L7:
        closeFilledWindowLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        disposeLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public int requery(IContentObserver r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfCursorIsClosed();     // Catch: Throwable -> L16
        closeFilledWindowLocked();     // Catch: Throwable -> L16
        if (this.mCursor.requery() == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return -1;
    L10:
        unregisterObserverProxyLocked();     // Catch: Throwable -> L16
        createAndRegisterObserverProxyLocked(r5);     // Catch: Throwable -> L16
        int r4 = this.mCursor.getCount();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r4;
    L13:
        e = move-exception;
        throw new IllegalStateException(this.mProviderName + " Requery misuse db, mCursor isClosed:" + this.mCursor.isClosed(), e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private void createAndRegisterObserverProxyLocked(IContentObserver r2) {
        if (this.mObserver != null) goto L7;
        ContentObserverProxy r0 = new ContentObserverProxy(r2, this);
        this.mObserver = r0;
        this.mCursor.registerContentObserver(r0);
        return;
    L7:
        throw new IllegalStateException("an observer is already registered");
    }

    private void unregisterObserverProxyLocked() {
        ContentObserverProxy r0 = this.mObserver;
        if (r0 == null) goto L6;
        this.mCursor.unregisterContentObserver(r0);
        this.mObserver.unlinkToDeath(this);
        this.mObserver = null;
        return;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public Bundle getExtras() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfCursorIsClosed();     // Catch: Throwable -> L7
        Bundle r1 = this.mCursor.getExtras();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public Bundle respond(Bundle r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfCursorIsClosed();     // Catch: Throwable -> L7
        Bundle r1 = this.mCursor.respond(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
