package com.bytedance.apm.battery.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.apm.d;

/* JADX INFO: loaded from: classes.dex */
public class b extends SQLiteOpenHelper {
    public b(Context r3, String r4) {
        super(r3, r4, null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE t_battery ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_id Integer, front Integer, timestamp Integer, type TEXT, status Integer, scene TEXT, accumulation Integer, source TEXT, delete_flag Integer DEFAULT 0, process TEXT, main_process Integer, sid TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )");     // Catch: Exception -> L4
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
        if (d.C() == false) goto L6;
        d.b.b.o.m.b.a("DBHelper", "Updating table from " + r3 + " to " + r4);
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
