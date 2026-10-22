package com.tencent.wcdb.database;

import com.tencent.wcdb.Cursor;

/* JADX INFO: loaded from: classes5.dex */
public interface SQLiteCursorDriver {
    void cursorClosed();

    void cursorDeactivated();

    void cursorRequeried(Cursor r1);

    Cursor query(SQLiteDatabase.CursorFactory r1, Object[] r2);

    void setBindArguments(String[] r1);
}
