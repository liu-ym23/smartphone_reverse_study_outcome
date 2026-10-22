package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.wcdb.support.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractCursor implements CrossProcessCursor {
    private static final String TAG = "Cursor";
    protected boolean mClosed;
    private final ContentObservable mContentObservable;
    protected ContentResolver mContentResolver;

    @Deprecated
    protected Long mCurrentRowID;
    private final DataSetObservable mDataSetObservable;
    private Bundle mExtras;
    private Uri mNotifyUri;
    protected int mPos;

    @Deprecated
    protected int mRowIdColumnIndex;
    private ContentObserver mSelfObserver;
    private final Object mSelfObserverLock;
    private boolean mSelfObserverRegistered;

    @Deprecated
    protected HashMap<Long, Map<String, Object>> mUpdatedRows;

    protected static class SelfContentObserver extends ContentObserver {
        WeakReference<AbstractCursor> mCursor;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        public SelfContentObserver(AbstractCursor r2) {
            super(null);
            this.mCursor = new WeakReference(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            AbstractCursor r0 = this.mCursor.get();
            if (r0 == null) goto L6;
            r0.onChange(false);
            return;
        }
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public abstract String[] getColumnNames();

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public abstract int getCount();

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public abstract double getDouble(int r1);

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public abstract float getFloat(int r1);

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public abstract int getInt(int r1);

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public abstract long getLong(int r1);

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public abstract short getShort(int r1);

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public abstract String getString(int r1);

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public int getType(int r1) {
        return 3;
    }

    @Deprecated
    protected Object getUpdatedField(int r1) {
        return null;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public CursorWindow getWindow() {
        return null;
    }

    @Deprecated
    protected boolean isFieldUpdated(int r1) {
        return false;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public abstract boolean isNull(int r1);

    @Override // com.tencent.wcdb.CrossProcessCursor
    public boolean onMove(int r1, int r2) {
        return true;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public byte[] getBlob(int r1) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public void deactivate() {
        onDeactivateOrClose();
    }

    protected void onDeactivateOrClose() {
        ContentObserver r0 = this.mSelfObserver;
        if (r0 == null) goto L5;
        this.mContentResolver.unregisterContentObserver(r0);
        this.mSelfObserverRegistered = false;
    L5:
        this.mDataSetObservable.notifyInvalidated();
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean requery() {
        ContentObserver r0 = this.mSelfObserver;
        if (r0 != null) goto L5;
    L7:
        this.mDataSetObservable.notifyChanged();
        return true;
    L5:
        if (this.mSelfObserverRegistered == true) goto L7;
        this.mContentResolver.registerContentObserver(this.mNotifyUri, true, r0);
        this.mSelfObserverRegistered = true;
        goto L7
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean isClosed() {
        return this.mClosed;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
        this.mContentObservable.unregisterAll();
        onDeactivateOrClose();
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public void copyStringToBuffer(int r4, CharArrayBuffer r5) {
        String r3 = getString(r4);
        if (r3 == null) goto L12;
        char[] r0 = r5.data;
        if (r0 != null) goto L7;
    L10:
        r5.data = r3.toCharArray();
    L11:
        r5.sizeCopied = r3.length();
        return;
    L7:
        if (r0.length < r3.length()) goto L10;
        r3.getChars(0, r3.length(), r0, 0);
        goto L11
    L12:
        r5.sizeCopied = 0;
    }

    public AbstractCursor() {
        this.mSelfObserverLock = new Object();
        this.mDataSetObservable = new DataSetObservable();
        this.mContentObservable = new ContentObservable();
        this.mExtras = Bundle.EMPTY;
        this.mPos = -1;
        this.mRowIdColumnIndex = -1;
        this.mCurrentRowID = null;
        this.mUpdatedRows = new HashMap();
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final int getPosition() {
        return this.mPos;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean moveToPosition(int r5) {
        int r0 = getCount();
        if (r5 < r0) goto L7;
        this.mPos = r0;
        return false;
    L7:
        if (r5 >= 0) goto L10;
        this.mPos = -1;
        return false;
    L10:
        int r1 = this.mPos;
        if (r5 != r1) goto L14;
        return true;
    L14:
        boolean r2 = onMove(r1, r5);
        if (r2 == true) goto L17;
        this.mPos = -1;
    L20:
        return r2;
    L17:
        this.mPos = r5;
        int r6 = this.mRowIdColumnIndex;
        if (r6 == (-1)) goto L20;
        this.mCurrentRowID = Long.valueOf(getLong(r6));
        goto L20
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public void fillWindow(int r1, CursorWindow r2) {
        DatabaseUtils.cursorFillWindow(this, r1, r2);
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final boolean move(int r2) {
        return moveToPosition(this.mPos + r2);
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final boolean moveToNext() {
        return moveToPosition(this.mPos + 1);
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final boolean moveToPrevious() {
        return moveToPosition(this.mPos - 1);
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final boolean isFirst() {
        if (this.mPos == 0) goto L5;
    L7:
        return false;
    L5:
        if (getCount() == 0) goto L7;
        return true;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final boolean isLast() {
        int r0 = getCount();
        if (this.mPos != (r0 - 1)) goto L6;
        if (r0 == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final boolean isBeforeFirst() {
        if (getCount() != 0) goto L6;
        return true;
    L6:
        if (this.mPos == (-1)) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public final boolean isAfterLast() {
        if (getCount() != 0) goto L6;
        return true;
    L6:
        if (this.mPos == getCount()) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public int getColumnIndex(String r8) {
        int r0 = r8.lastIndexOf(46);
        int r1 = 0;
        if (r0 == (-1)) goto L5;
        Log.e(TAG, "requesting column name with table name -- " + r8, new Object[]{new Exception()});
        r8 = r8.substring(r0 + 1);
    L5:
        String[] r7 = getColumnNames();
        int r2 = r7.length;
    L6:
        if (r1 >= r2) goto L11;
        if (r7[r1].equalsIgnoreCase(r8) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return r1;
    L11:
        return -1;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public int getColumnIndexOrThrow(String r3) {
        int r2 = getColumnIndex(r3);
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("column '" + r3 + "' does not exist");
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public String getColumnName(int r1) {
        return getColumnNames()[r1];
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public void registerContentObserver(ContentObserver r1) {
        this.mContentObservable.registerObserver(r1);
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public void unregisterContentObserver(ContentObserver r2) {
        if (this.mClosed == true) goto L6;
        this.mContentObservable.unregisterObserver(r2);
        return;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver r1) {
        this.mDataSetObservable.registerObserver(r1);
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver r1) {
        this.mDataSetObservable.unregisterObserver(r1);
    }

    protected void onChange(boolean r3) {
        Object r0 = this.mSelfObserverLock;
        monitor-enter(r0);
        this.mContentObservable.dispatchChange(r3);     // Catch: Throwable -> L10
        Uri r1 = this.mNotifyUri;     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        if (r3 == false) goto L8;
        this.mContentResolver.notifyChange(r1, this.mSelfObserver);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public void setNotificationUri(ContentResolver r4, Uri r5) {
        Object r0 = this.mSelfObserverLock;
        monitor-enter(r0);
        this.mNotifyUri = r5;     // Catch: Throwable -> L10
        this.mContentResolver = r4;     // Catch: Throwable -> L10
        ContentObserver r6 = this.mSelfObserver;     // Catch: Throwable -> L10
        if (r6 == null) goto L7;
        r4.unregisterContentObserver(r6);     // Catch: Throwable -> L10
    L7:
        SelfContentObserver r7 = new SelfContentObserver(this);     // Catch: Throwable -> L10
        this.mSelfObserver = r7;     // Catch: Throwable -> L10
        this.mContentResolver.registerContentObserver(this.mNotifyUri, true, r7);     // Catch: Throwable -> L10
        this.mSelfObserverRegistered = true;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return this.mNotifyUri;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle r1) {
        if (r1 != null) goto L4;
        r1 = Bundle.EMPTY;
    L4:
        this.mExtras = r1;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public Bundle respond(Bundle r1) {
        return Bundle.EMPTY;
    }

    protected void checkPosition() {
        if ((-1) == this.mPos) goto L8;
        if (getCount() == this.mPos) goto L8;
        return;
    L8:
        throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
    }

    protected void finalize() {
        ContentObserver r0 = this.mSelfObserver;
        if (r0 != null) goto L5;
    L12:
        if (this.mClosed == true) goto L14;
        close();     // Catch: Exception -> L11
        return;
    L14:
        return;
    L15:
        return;
    L5:
        if (this.mSelfObserverRegistered != true) goto L12;
        this.mContentResolver.unregisterContentObserver(r0);
        goto L12
    }
}
