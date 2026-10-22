package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.wcdb.support.Log;

/* JADX INFO: loaded from: classes5.dex */
public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private static final String TAG = "BulkCursor";
    private IBulkCursor mBulkCursor;
    private String[] mColumns;
    private int mCount;
    private AbstractCursor.SelfContentObserver mObserverBridge;
    private boolean mWantsAllOnMoveCalls;

    @Override // com.tencent.wcdb.AbstractWindowedCursor, com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void copyStringToBuffer(int r1, CharArrayBuffer r2) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void registerContentObserver(ContentObserver r1) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver r1) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void unregisterContentObserver(ContentObserver r1) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver r1) {
    }

    public BulkCursorToCursorAdaptor() {
        this.mObserverBridge = new AbstractCursor.SelfContentObserver(this);
    }

    public void initialize(BulkCursorDescriptor r2) {
        this.mBulkCursor = r2.cursor;
        String[] r0 = r2.columnNames;
        this.mColumns = r0;
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(r0);
        this.mWantsAllOnMoveCalls = r2.wantsAllOnMoveCalls;
        this.mCount = r2.count;
        if (r2.window == null) goto L6;
        setWindow(r2.window);
        return;
    }

    public IContentObserver getObserver() {
        return (IContentObserver) this.mObserverBridge.getClass().getMethod("getContentObserver", new Class[0]).invoke(this.mObserverBridge, new Object[0]);
    L4:
        return null;
    }

    private void throwIfCursorIsClosed() {
        if (this.mBulkCursor == null) goto L6;
        return;
    L6:
        throw new StaleDataException("Attempted to access a cursor after it has been closed.");
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getCount() {
        throwIfCursorIsClosed();
        return this.mCount;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.CrossProcessCursor
    public boolean onMove(int r3, int r4) {
        throwIfCursorIsClosed();
    L19:
        Log.e(TAG, "Unable to get window because the remote process is dead");
        return false;
    L4:
        if (this.mWindow != null) goto L6;
    L13:
        setWindow(this.mBulkCursor.getWindow(r4));     // Catch: RemoteException -> L19
    L15:
        if (this.mWindow != null) goto L17;
        return false;
    L17:
        return true;
    L6:
        if (r4 < this.mWindow.getStartPosition()) goto L13;
        if (r4 >= (this.mWindow.getStartPosition() + this.mWindow.getNumRows())) goto L13;
        if (this.mWantsAllOnMoveCalls == false) goto L15;
        this.mBulkCursor.onMove(r4);     // Catch: RemoteException -> L19
        goto L15
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        IBulkCursor r1 = this.mBulkCursor;
        if (r1 == null) goto L10;
        r1.deactivate();     // Catch: RemoteException -> L6
        return;
    L6:
        Log.w(TAG, "Remote process exception when deactivating");
        return;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        IBulkCursor r0 = this.mBulkCursor;
        if (r0 != null) goto L14;
        return;
    L14:
        r0.close();     // Catch: Throwable -> L7 RemoteException -> L9
    L6:
        this.mBulkCursor = null;
        return;
    L9:
        Log.w(TAG, "Remote process exception when closing");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        this.mBulkCursor = null;
        throw th;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean requery() {
        throwIfCursorIsClosed();
        int r1 = this.mBulkCursor.requery(getObserver());     // Catch: Exception -> L9
        this.mCount = r1;     // Catch: Exception -> L9
        if (r1 == (-1)) goto L7;
        this.mPos = -1;     // Catch: Exception -> L9
        closeWindow();     // Catch: Exception -> L9
        super.requery();     // Catch: Exception -> L9
        return true;
    L7:
        deactivate();     // Catch: Exception -> L9
        return false;
    L9:
        e = move-exception;
        Log.e(TAG, "Unable to requery because the remote process exception " + e.getMessage());
        deactivate();
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String[] getColumnNames() {
        throwIfCursorIsClosed();
        return this.mColumns;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public Bundle getExtras() {
        throwIfCursorIsClosed();
        return this.mBulkCursor.getExtras();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public Bundle respond(Bundle r2) {
        throwIfCursorIsClosed();
        return this.mBulkCursor.respond(r2);
    L5:
        e = move-exception;
        Log.w(TAG, "respond() threw RemoteException, returning an empty bundle.", new Object[]{e});
        return Bundle.EMPTY;
    }
}
