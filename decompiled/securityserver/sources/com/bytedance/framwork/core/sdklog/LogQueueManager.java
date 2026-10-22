package com.bytedance.framwork.core.sdklog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
class LogQueueManager {
    static final String[] QUEUE_COLS = null;
    private static final String WHERE_ID = "_id = ?";
    private static LogQueueManager sInstance;
    private SQLiteDatabase mDb;

    static {
        QUEUE_COLS = new String[]{"_id", "value", "type", "timestamp", DBHelper.COL_RETRY_COUNT, DBHelper.COL_RETRY_TIME};
    }

    private LogQueueManager(Context r1) {
        if (r1 != null) goto L8;
        return;
    L8:
        this.mDb = DBHelper.getInstance(r1).getWritableDatabase();     // Catch: Throwable -> L7
        return;
    }

    public static LogQueueManager getInstance(Context r2) {
        if (sInstance != null) goto L16;
        monitor-enter(LogQueueManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new LogQueueManager(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(LogQueueManager.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public static void safeCloseCursor(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public synchronized void cleanExpireLog(String r7, int r8, long r9) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r3 = System.currentTimeMillis() - r9;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r7) == false) goto L13;
        String r10 = "timestamp <= ? ";
        String[] r11 = {String.valueOf(r3)};     // Catch: Throwable -> L11
    L25:
        this.mDb.delete(DBHelper.TABLE_QUEUE, r10, r11);     // Catch: Throwable -> L11 Exception -> L17
    L19:
        monitor-exit(this);
        return;
    L17:
        e = move-exception;
        LogQueue.log("delete expire log error:" + e);     // Catch: Throwable -> L11
        goto L19
    L13:
        String r12 = "(timestamp <= ? OR retry_count > " + r8 + ") and type = ?";     // Catch: Throwable -> L11
        r11 = new String[]{String.valueOf(r3), r7};     // Catch: Throwable -> L11
        r10 = r12;
        goto L25
    }

    public synchronized void closeDatabase() {
        monitor-enter(this);
    L8:
        th = move-exception;
        LogQueue.log("closeDatabase error: " + th);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == false) goto L10;
        this.mDb.close();     // Catch: Throwable -> L8
        this.mDb = null;     // Catch: Throwable -> L8
        goto L10
    }

    public synchronized long getEventCount(String r7) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        long r2 = 0;
        if (isOpen() == true) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        Cursor r1 = null;
        String r4 = "select count(*) from queue";
        if (TextUtils.isEmpty(r7) == true) goto L13;
        r4 = "select count(*) from queue " + r7;     // Catch: Throwable -> L24
    L13:
        r1 = this.mDb.rawQuery(r4, null);     // Catch: Throwable -> L24
        if (r1.moveToNext() == false) goto L16;
        r2 = r1.getLong(0);     // Catch: Throwable -> L24
    L16:
        safeCloseCursor(r1);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r2;
    }

    public synchronized LogItem getLog(long r13) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        Cursor r2 = null;
        LogItem r3 = null;
        r2 = null;
        if (isOpen() == true) goto L41;
        monitor-exit(this);
        return null;
    L41:
        Cursor r14 = this.mDb.query(DBHelper.TABLE_QUEUE, QUEUE_COLS, "_id > ?", new String[]{String.valueOf(r13)}, null, null, "_id ASC", "1");     // Catch: Throwable -> L26 Exception -> L28
    L20:
        e = e;
        LogItem r15 = null;
    L19:
        r2 = r14;
    L30:
        LogQueue.log("getLog exception " + e);     // Catch: Throwable -> L26
        safeCloseCursor(r2);     // Catch: Throwable -> L24
        r3 = r15;
    L33:
        monitor-exit(this);
        return r3;
    L16:
        th = th;
        r2 = r14;
    L35:
        safeCloseCursor(r2);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L11:
        if (r14.moveToNext() == false) goto L22;
        r15 = new LogItem();     // Catch: Throwable -> L16 Exception -> L20
        r15.id = r14.getLong(0);     // Catch: Throwable -> L16 Exception -> L18
        r15.value = r14.getBlob(1);     // Catch: Throwable -> L16 Exception -> L18
        r15.type = r14.getString(2);     // Catch: Throwable -> L16 Exception -> L18
        r15.timestamp = r14.getLong(3);     // Catch: Throwable -> L16 Exception -> L18
        r15.retryCount = r14.getInt(4);     // Catch: Throwable -> L16 Exception -> L18
        r15.retryTime = r14.getLong(5);     // Catch: Throwable -> L16 Exception -> L18
        r3 = r15;
        goto L22
    L18:
        e = e;
    L22:
        safeCloseCursor(r14);     // Catch: Throwable -> L24
    L28:
        e = e;
        r15 = null;
    L26:
        th = th;
        goto L35
    }

    public synchronized long insertLog(String r4, byte[] r5) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (isOpen() == false) goto L14;
        if (r5 == null) goto L14;
        if (r5.length <= 0) goto L14;
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L12
        r0.put("value", r5);     // Catch: Throwable -> L12
        r0.put("type", r4);     // Catch: Throwable -> L12
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L12
        r0.put(DBHelper.COL_RETRY_COUNT, 0);     // Catch: Throwable -> L12
        r0.put(DBHelper.COL_RETRY_TIME, 0L);     // Catch: Throwable -> L12
        long r6 = this.mDb.insert(DBHelper.TABLE_QUEUE, null, r0);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r6;
    L14:
        monitor-exit(this);
        return -1;
    }

    public synchronized boolean isOpen() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.mDb;     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
    L13:
        LogQueue.log("db not establish and open");     // Catch: Throwable -> L11
        monitor-exit(this);
        return false;
    L6:
        if (r0.isOpen() == false) goto L13;
        monitor-exit(this);
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized boolean onLogSent(long r17, boolean r19, long r20, int r22) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == true) goto L7;
    L43:
        monitor-exit(this);
        return false;
    L7:
        if (r17 <= 0) goto L43;
        String[] r5 = {String.valueOf(r17)};     // Catch: Throwable -> L17
        if (r19 == true) goto L51;
        Cursor r15 = null;
        r15 = this.mDb.query(DBHelper.TABLE_QUEUE, new String[]{"timestamp", DBHelper.COL_RETRY_COUNT}, WHERE_ID, r5, null, null, null);     // Catch: Throwable -> L27 Exception -> L29
        if (r15.moveToNext() == true) goto L19;
        safeCloseCursor(r15);     // Catch: Throwable -> L17
        monitor-exit(this);
        return false;
    L19:
        long r7 = r15.getLong(0);     // Catch: Throwable -> L27 Exception -> L29
        int r10 = r15.getInt(1);     // Catch: Throwable -> L27 Exception -> L29
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L27 Exception -> L29
        if ((r11 - r7) < r20) goto L22;
    L31:
        safeCloseCursor(r15);     // Catch: Throwable -> L17
        goto L51
    L22:
        if (r10 >= r22) goto L31;
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L27 Exception -> L29
        r0.put(DBHelper.COL_RETRY_COUNT, Integer.valueOf(r10 + 1));     // Catch: Throwable -> L27 Exception -> L29
        r0.put(DBHelper.COL_RETRY_TIME, Long.valueOf(r11));     // Catch: Throwable -> L27 Exception -> L29
        this.mDb.update(DBHelper.TABLE_QUEUE, r0, WHERE_ID, r5);     // Catch: Throwable -> L27 Exception -> L29
        safeCloseCursor(r15);     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L27:
        th = move-exception;
        safeCloseCursor(r15);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L29:
        e = move-exception;
        LogQueue.log("onLogSent exception: " + e);     // Catch: Throwable -> L27
        safeCloseCursor(r15);     // Catch: Throwable -> L17
        return false;
    L51:
        this.mDb.delete(DBHelper.TABLE_QUEUE, WHERE_ID, r5);     // Catch: Throwable -> L47
    L40:
        LogQueue.log("delete app_log: " + r17);     // Catch: Throwable -> L17
        monitor-exit(this);
        return false;
    }

    public synchronized void recreateTableQueue() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        this.mDb.execSQL("DROP TABLE IF EXISTS queue");     // Catch: Throwable -> L10 Exception -> L12
        this.mDb.execSQL(DBHelper.CREATE_TABLE_QUEUE);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        monitor-exit(this);
        return;
    L12:
        e = move-exception;
        LogQueue.log("recreateTableQueue db exception " + e);     // Catch: Throwable -> L10
        goto L14
    }
}
