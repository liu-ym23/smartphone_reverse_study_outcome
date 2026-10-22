package com.bytedance.apm.battery.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.util.log.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class DBHelper extends SQLiteOpenHelper {
    public static final String BATTERY_COL_ACCUMULATION = "accumulation";
    public static final String BATTERY_COL_MAIN_PROCESS = "main_process";
    public static final String BATTERY_COL_PROCESS_NAME = "process";
    public static final String BATTERY_COL_SCENE = "scene";
    public static final String BATTERY_COL_SOURCE = "source";
    public static final String BATTERY_COL_STATUS = "status";
    public static final String COL_DELETE = "delete_flag";
    public static final String COL_EXTRA1 = "extra1";
    public static final String COL_EXTRA2 = "extra2";
    public static final String COL_EXTRA3 = "extra3";
    public static final String COL_EXTRA4 = "extra4";
    public static final String COL_FRONT = "front";
    public static final String COL_ID = "_id";
    public static final String COL_SID = "sid";
    public static final String COL_TIME = "timestamp";
    public static final String COL_TYPE = "type";
    public static final String COL_VERSION_ID = "version_id";
    public static final String DB_NAME = "apm_monitor_t1.db";
    public static final int DB_VERSION = 2;
    private static final String SQL_CREATE_BATTERY_TABLE = "CREATE TABLE t_battery ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_id Integer, front Integer, timestamp Integer, type TEXT, status Integer, scene TEXT, accumulation Integer, source TEXT, delete_flag Integer DEFAULT 0, process TEXT, main_process Integer, sid TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )";
    private static final String TAG = "DBHelper";
    public static final String T_BATTERY = "t_battery";

    public DBHelper(Context r3, String r4) {
        super(r3, r4, null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        r1.execSQL(SQL_CREATE_BATTERY_TABLE);     // Catch: Exception -> L4
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d(TAG, "Updating table from " + r3 + " to " + r4);
    L6:
        if (r3 >= 2) goto L12;
        r2.execSQL("DROP TABLE IF EXISTS local_monitor_log");     // Catch: Exception -> L9
        r2.execSQL("DROP TABLE IF EXISTS t_apiall");     // Catch: Exception -> L9
        r2.execSQL("DROP TABLE IF EXISTS local_monitor_version");     // Catch: Exception -> L9
        return;
    L13:
        return;
    }
}
