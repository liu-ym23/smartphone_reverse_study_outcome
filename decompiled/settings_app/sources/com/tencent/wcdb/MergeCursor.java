package com.tencent.wcdb;

import android.database.ContentObserver;
import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes5.dex */
public class MergeCursor extends AbstractCursor {
    private Cursor mCursor;
    private Cursor[] mCursors;
    private DataSetObserver mObserver;

    public MergeCursor(Cursor[] r3) {
        this.mObserver = new AnonymousClass1(this);
        this.mCursors = r3;
        int r0 = 0;
        this.mCursor = r3[0];
    L3:
        Cursor[] r4 = this.mCursors;
        if (r0 >= r4.length) goto L10;
        Cursor r5 = r4[r0];
        if (r5 == null) goto L9;
        r5.registerDataSetObserver(this.mObserver);
    L9:
        r0 = r0 + 1;
        goto L3
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getCount() {
        int r0 = this.mCursors.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Cursor r3 = this.mCursors[r1];
        if (r3 == null) goto L7;
        r2 = r2 + r3.getCount();
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.CrossProcessCursor
    public boolean onMove(int r5, int r6) {
        this.mCursor = null;
        int r7 = this.mCursors.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r7) goto L12;
        Cursor r3 = this.mCursors[r1];
        if (r3 == null) goto L11;
        if (r6 < (r3.getCount() + r2)) goto L9;
        r2 = r2 + this.mCursors[r1].getCount();
        goto L11
    L9:
        this.mCursor = this.mCursors[r1];
    L11:
        r1 = r1 + 1;
    L12:
        Cursor r4 = this.mCursor;
        if (r4 != null) goto L15;
        return false;
    L15:
        return r4.moveToPosition(r6 - r2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String getString(int r1) {
        return this.mCursor.getString(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public short getShort(int r1) {
        return this.mCursor.getShort(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getInt(int r1) {
        return this.mCursor.getInt(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public long getLong(int r1) {
        return this.mCursor.getLong(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public float getFloat(int r1) {
        return this.mCursor.getFloat(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public double getDouble(int r1) {
        return this.mCursor.getDouble(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getType(int r1) {
        return this.mCursor.getType(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean isNull(int r1) {
        return this.mCursor.isNull(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public byte[] getBlob(int r1) {
        return this.mCursor.getBlob(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String[] getColumnNames() {
        Cursor r0 = this.mCursor;
        if (r0 == null) goto L7;
        return r0.getColumnNames();
    L7:
        return new String[0];
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void deactivate() {
        int r0 = this.mCursors.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Cursor r2 = this.mCursors[r1];
        if (r2 == null) goto L7;
        r2.deactivate();
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        super.deactivate();
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int r0 = this.mCursors.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Cursor r2 = this.mCursors[r1];
        if (r2 == null) goto L8;
        r2.close();
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        super.close();
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void registerContentObserver(ContentObserver r4) {
        int r0 = this.mCursors.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Cursor r2 = this.mCursors[r1];
        if (r2 == null) goto L7;
        r2.registerContentObserver(r4);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void unregisterContentObserver(ContentObserver r4) {
        int r0 = this.mCursors.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Cursor r2 = this.mCursors[r1];
        if (r2 == null) goto L7;
        r2.unregisterContentObserver(r4);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver r4) {
        int r0 = this.mCursors.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Cursor r2 = this.mCursors[r1];
        if (r2 == null) goto L7;
        r2.registerDataSetObserver(r4);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver r4) {
        int r0 = this.mCursors.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Cursor r2 = this.mCursors[r1];
        if (r2 == null) goto L7;
        r2.unregisterDataSetObserver(r4);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean requery() {
        int r0 = this.mCursors.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        Cursor r3 = this.mCursors[r2];
        if (r3 == null) goto L10;
        if (r3.requery() == true) goto L10;
        return false;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return true;
    }
}
