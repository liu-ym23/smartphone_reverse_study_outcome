package com.tencent.wcdb.database;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface SQLiteTrace {

    public static class TraceInfo<T> {
        public final T info;
        public final int tid;
        public final long time;

        TraceInfo(T r1, long r2, int r4) {
            this.info = r1;
            this.time = r2;
            this.tid = r4;
        }
    }

    void onConnectionObtained(SQLiteDatabase r1, String r2, long r3, boolean r5);

    void onConnectionPoolBusy(SQLiteDatabase r1, String r2, long r3, boolean r5, List<TraceInfo<String>> r6, List<TraceInfo<StackTraceElement[]>> r7);

    void onDatabaseCorrupted(SQLiteDatabase r1);

    void onSQLExecuted(SQLiteDatabase r1, String r2, int r3, long r4);
}
