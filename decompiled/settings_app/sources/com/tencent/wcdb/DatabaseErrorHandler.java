package com.tencent.wcdb;

import com.tencent.wcdb.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
public interface DatabaseErrorHandler {
    void onCorruption(SQLiteDatabase r1);
}
