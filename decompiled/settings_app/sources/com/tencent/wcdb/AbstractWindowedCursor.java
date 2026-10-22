package com.tencent.wcdb;

import android.database.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    public AbstractWindowedCursor() {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public byte[] getBlob(int r2) {
        checkPosition();
        return this.mWindow.getBlob(this.mPos, r2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String getString(int r2) {
        checkPosition();
        return this.mWindow.getString(this.mPos, r2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void copyStringToBuffer(int r2, CharArrayBuffer r3) {
        checkPosition();
        this.mWindow.copyStringToBuffer(this.mPos, r2, r3);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public short getShort(int r2) {
        checkPosition();
        return this.mWindow.getShort(this.mPos, r2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getInt(int r2) {
        checkPosition();
        return this.mWindow.getInt(this.mPos, r2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public long getLong(int r2) {
        checkPosition();
        return this.mWindow.getLong(this.mPos, r2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public float getFloat(int r2) {
        checkPosition();
        return this.mWindow.getFloat(this.mPos, r2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public double getDouble(int r2) {
        checkPosition();
        return this.mWindow.getDouble(this.mPos, r2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean isNull(int r2) {
        checkPosition();
        if (this.mWindow.getType(this.mPos, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public boolean isBlob(int r1) {
        if (getType(r1) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public boolean isString(int r1) {
        if (getType(r1) != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public boolean isLong(int r1) {
        if (getType(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Deprecated
    public boolean isFloat(int r1) {
        if (getType(r1) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getType(int r2) {
        checkPosition();
        return this.mWindow.getType(this.mPos, r2);
    }

    @Override // com.tencent.wcdb.AbstractCursor
    protected void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) goto L6;
        return;
    L6:
        throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.mWindow;
    }

    public void setWindow(CursorWindow r2) {
        if (r2 == this.mWindow) goto L6;
        closeWindow();
        this.mWindow = r2;
        return;
    }

    public boolean hasWindow() {
        if (this.mWindow == null) goto L5;
        return true;
    L5:
        return false;
    }

    protected void closeWindow() {
        CursorWindow r0 = this.mWindow;
        if (r0 == null) goto L6;
        r0.close();
        this.mWindow = null;
        return;
    }

    protected void clearOrCreateWindow(String r2) {
        CursorWindow r0 = this.mWindow;
        if (r0 != null) goto L5;
        this.mWindow = new CursorWindow(r2);
        return;
    L5:
        r0.clear();
    }

    @Override // com.tencent.wcdb.AbstractCursor
    protected void onDeactivateOrClose() {
        super.onDeactivateOrClose();
        closeWindow();
    }
}
