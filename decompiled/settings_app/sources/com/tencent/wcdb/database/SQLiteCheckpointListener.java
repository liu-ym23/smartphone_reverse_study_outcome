package com.tencent.wcdb.database;

/* JADX INFO: loaded from: classes5.dex */
public interface SQLiteCheckpointListener {
    void onAttach(SQLiteDatabase r1);

    void onDetach(SQLiteDatabase r1);

    void onWALCommit(SQLiteDatabase r1, String r2, int r3);
}
