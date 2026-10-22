package com.bytedance.framwork.core.sdklib;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.framwork.core.sdkmonitor.MonitorHelper;

/* JADX INFO: loaded from: classes.dex */
public class DBHelper extends SQLiteOpenHelper {
    public static final String COL_AID = "aid";
    public static final String COL_DATA = "data";
    public static final String COL_DATA2 = "data2";
    public static final String COL_DATA3 = "data3";
    public static final String COL_ID = "_id";
    public static final String COL_RETRY_COUNT = "retry_count";
    public static final String COL_RETRY_TIME = "retry_time";
    public static final String COL_TIME = "time";
    public static final String COL_TIMESTAMP = "timestamp";
    public static final String COL_TYPE = "type";
    public static final String COL_TYPE2 = "type2";
    public static final String COL_VALUE = "value";
    public static final String CREATE_TABLE_QUEUE = "CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )";
    public static final String DB_NAME_SUFFIX = "sdkmon_v2.db";
    public static final int DB_VERSION = 1;
    public static final String SQL_CREATE_LOCAL_MONITOR_TABLE = "CREATE TABLE monitor_log ( _id Integer PRIMARY KEY AUTOINCREMENT, aid Integer, type VARCHAR, type2 VARCHAR, time Integer, data TEXT, data2 TEXT, data3 TEXT  )";
    public static final String TABLE_QUEUE = "queue";
    private static final String TAG = "DBHelper";
    public static final String T_LOCAL_LOG = "monitor_log";
    private static DBHelper instance;

    public DBHelper(Context r3, String r4) {
        super(r3, r4, null, 1);
    }

    public static DBHelper getInstance(Context r4) {
        if (instance != null) goto L16;
        monitor-enter(DBHelper.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L11;
        instance = new DBHelper(r4, MonitorHelper.getShortProcessName(r4) + DB_NAME_SUFFIX);     // Catch: Throwable -> L9
    L11:
        monitor-exit(DBHelper.class);     // Catch: Throwable -> L9
    L16:
        return instance;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        r1.execSQL(SQL_CREATE_LOCAL_MONITOR_TABLE);     // Catch: Exception -> L4
        r1.execSQL(CREATE_TABLE_QUEUE);     // Catch: Exception -> L4
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
    }
}
