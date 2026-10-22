package com.bytedance.framwork.core.sdklib;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.Nullable;
import com.bytedance.framwork.core.sdklib.model.LocalLog;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LogStoreManager {
    private static final String CLAUSE_AID_EQUAL = "aid= ?";
    private static final String ORDER_BY_ID_ASC = "_id ASC ";
    static final String[] SAMPLE_LOG_COLS = null;
    private static String SQL_GET_TOTAL_COUNT = null;
    private static String SQL_GET_TOTAL_COUNT_AID = null;
    private static final String TAG = "LogStoreManager";
    static final int WEED_OUT_ROWS_SINGLE_TIME = 500;
    private static LogStoreManager instance = null;
    static boolean isCheckLegacyDb = false;
    static boolean isCheckedDbSize = false;
    static long sMaxLogSaveCount = 5000;
    private Map<String, Integer> mAidLogCountMap;
    private Context mContext;
    private SQLiteDatabase mDb;
    private int mFastReadSampleTimes;
    String sql;

    static {
        SAMPLE_LOG_COLS = new String[]{"_id", "data"};
        instance = null;
        SQL_GET_TOTAL_COUNT_AID = "SELECT count(*) FROM monitor_log WHERE aid = ?";
        SQL_GET_TOTAL_COUNT = "SELECT count(*) FROM monitor_log";
    }

    private LogStoreManager(Context r3) {
        this.mAidLogCountMap = new HashMap(2);
        this.mFastReadSampleTimes = 0;
        this.sql = "INSERT INTO monitor_log(aid,type,type2,time,data) VALUES ( ?, ?, ?, ?, ?)";
        this.mContext = r3;
        this.mDb = DBHelper.getInstance(r3).getWritableDatabase();
    }

    private void addLogCountBuffer(String r2, int r3) {
        if (this.mAidLogCountMap.containsKey(r2) == true) goto L6;
        if (r3 <= 0) goto L6;
        this.mAidLogCountMap.put(r2, Integer.valueOf(r3));
        return;
    L6:
        int r4 = Math.max(0, this.mAidLogCountMap.get(r2).intValue() + r3);
        this.mAidLogCountMap.put(r2, Integer.valueOf(r4));
    }

    private void deleteDb(String r2) {
        File r1 = this.mContext.getDatabasePath(r2 + ".db");     // Catch: Exception -> L6
        if (r1.exists() == false) goto L9;
        r1.delete();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    private void deleteLegacyDb() {
        deleteDb("psdkmon");
    }

    public static LogStoreManager getInstance(Context r2) {
        if (instance != null) goto L16;
        monitor-enter(DBHelper.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L11;
        instance = new LogStoreManager(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(DBHelper.class);     // Catch: Throwable -> L9
    L16:
        return instance;
    }

    private synchronized int getLogCountFromDb() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.mDb;     // Catch: Throwable -> L16
        int r1 = -1;
        if (r0 != null) goto L6;
    L22:
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L22;
        Cursor r2 = null;
        r2 = this.mDb.rawQuery(SQL_GET_TOTAL_COUNT, null);     // Catch: Throwable -> L13 Exception -> L26
        if (r2.moveToNext() == false) goto L15;
        r1 = r2.getInt(0);     // Catch: Throwable -> L13 Exception -> L26
    L13:
        th = move-exception;
        safeCloseCursor(r2);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L15:
        safeCloseCursor(r2);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    private synchronized int getLogCountFromDbAid(String r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.mDb;     // Catch: Throwable -> L16
        int r1 = -1;
        if (r0 != null) goto L6;
    L22:
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L22;
        Cursor r2 = null;
        r2 = this.mDb.rawQuery(SQL_GET_TOTAL_COUNT_AID, new String[]{r5});     // Catch: Throwable -> L13 Exception -> L26
        if (r2.moveToNext() == false) goto L15;
        r1 = r2.getInt(0);     // Catch: Throwable -> L13 Exception -> L26
    L13:
        th = move-exception;
        safeCloseCursor(r2);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L15:
        safeCloseCursor(r2);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r1;
    L16:
        th = move-exception;
        throw th;
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

    private synchronized void weedOutLogIfNeed() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (isCheckedDbSize == true) goto L11;
        isCheckedDbSize = true;     // Catch: Throwable -> L8
        if (getLogCountFromDb() < sMaxLogSaveCount) goto L11;
        weedOutOldLogs(500);     // Catch: Throwable -> L8
    L11:
        if (isCheckLegacyDb == true) goto L13;
        isCheckLegacyDb = true;     // Catch: Throwable -> L8
        deleteLegacyDb();     // Catch: Throwable -> L8
    L13:
        monitor-exit(this);
    }

    public synchronized int deleteLogs(String r3, long r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mDb != null) goto L6;
    L13:
        monitor-exit(this);
        return -1;
    L6:
        if (r4 < 0) goto L13;
        String[] r5 = {r3, String.valueOf(r4)};     // Catch: Throwable -> L11
        int r6 = this.mDb.delete("monitor_log", "aid = ? AND _id<= ? ", r5);     // Catch: Throwable -> L11
        addLogCountBuffer(r3, r6 * (-1));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r6;
    }

    public synchronized int getLogCount(String r4) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mFastReadSampleTimes <= 10) goto L6;
    L11:
        int r0 = getLogCountFromDbAid(r4);     // Catch: Throwable -> L9
        this.mAidLogCountMap.put(r4, Integer.valueOf(r0));     // Catch: Throwable -> L9
        this.mFastReadSampleTimes = 0;     // Catch: Throwable -> L9
        int r5 = r0;
    L13:
        monitor-exit(this);
        return r5;
    L6:
        if (this.mAidLogCountMap.containsKey(r4) == false) goto L11;
        r5 = this.mAidLogCountMap.get(r4).intValue();     // Catch: Throwable -> L9
        this.mFastReadSampleTimes++;     // Catch: Throwable -> L9
        goto L13
    }

    @Nullable
    public List<LocalLog> getLogsLimit(int r11, int r12) {
        Cursor r0 = null;
        Cursor r10 = this.mDb.query("monitor_log", SAMPLE_LOG_COLS, CLAUSE_AID_EQUAL, new String[]{String.valueOf(r11)}, null, null, ORDER_BY_ID_ASC, r12 + "");     // Catch: Throwable -> L18
    L13:
        r0 = r10;
        goto L16
    L5:
        if (r10.getCount() != 0) goto L8;
        safeCloseCursor(r10);
        return null;
    L8:
        LinkedList r13 = new LinkedList();     // Catch: Throwable -> L13
    L10:
        if (r10.moveToNext() == false) goto L14;
        r13.add(new LocalLog(r10.getLong(r10.getColumnIndex("_id")), r10.getString(r10.getColumnIndex("data"))));     // Catch: Throwable -> L13
        goto L10
    L14:
        safeCloseCursor(r10);
        return r13;
    L16:
        safeCloseCursor(r0);
        return Collections.emptyList();
    }

    public synchronized void insertLocalLogBatch(String r7, List<LocalLog> r8) {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (this.mDb != null) goto L6;
    L39:
        monitor-exit(this);
        return;
    L6:
        if (ListUtils.isEmpty(r8) == true) goto L39;
        weedOutLogIfNeed();     // Catch: Throwable -> L30
        this.mDb.beginTransaction();     // Catch: Throwable -> L30
        SQLiteStatement r0 = this.mDb.compileStatement(this.sql);     // Catch: Throwable -> L15 Exception -> L17
        Iterator<LocalLog> r1 = r8.iterator();     // Catch: Throwable -> L15 Exception -> L17
    L11:
        if (r1.hasNext() == false) goto L26;
        LocalLog r2 = r1.next();     // Catch: Throwable -> L15 Exception -> L17
        r0.bindString(1, String.valueOf(r2.aid));     // Catch: Throwable -> L15 Exception -> L17
        String r3 = r2.type;     // Catch: Throwable -> L15 Exception -> L17
        if (r3 != null) goto L19;
        r3 = "";
    L19:
        r0.bindString(2, r3);     // Catch: Throwable -> L15 Exception -> L17
        String r4 = r2.type2;     // Catch: Throwable -> L15 Exception -> L17
        if (r4 != null) goto L22;
        r4 = "";
    L22:
        r0.bindString(3, r4);     // Catch: Throwable -> L15 Exception -> L17
        r0.bindLong(4, r2.createTime);     // Catch: Throwable -> L15 Exception -> L17
        String r5 = r2.data;     // Catch: Throwable -> L15 Exception -> L17
        if (r5 != null) goto L25;
        r5 = "";
    L25:
        r0.bindString(5, r5);     // Catch: Throwable -> L15 Exception -> L17
        r0.executeInsert();     // Catch: Throwable -> L15 Exception -> L17
        goto L11
    L26:
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L15 Exception -> L17
        addLogCountBuffer(r7, r8.size());     // Catch: Throwable -> L15 Exception -> L17
        SQLiteDatabase r9 = this.mDb;     // Catch: Throwable -> L30
    L28:
        r9.endTransaction();     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        r9 = this.mDb;     // Catch: Throwable -> L30
        goto L28
    L15:
        th = move-exception;
        this.mDb.endTransaction();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    }

    public synchronized boolean isOpen() {
        monitor-enter(this);
        monitor-exit(this);
        return true;
    }

    public synchronized void weedOutOldLogs(long r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mDb != null) goto L7;
    L17:
        monitor-exit(this);
        return;
    L7:
        if (r4 <= 0) goto L17;
        this.mDb.execSQL(" DELETE FROM monitor_log WHERE _id IN (SELECT _id FROM monitor_log ORDER BY _id ASC LIMIT " + r4 + ")");     // Catch: Throwable -> L11 Exception -> L13
    L15:
        monitor-exit(this);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        goto L15
    }
}
