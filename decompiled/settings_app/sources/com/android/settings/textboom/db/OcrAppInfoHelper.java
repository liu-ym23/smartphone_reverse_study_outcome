package com.android.settings.textboom.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class OcrAppInfoHelper extends SQLiteOpenHelper {
    private static final String DB_CREATE = "create table apps (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_name TEXT UNIQUE,can_boom INTEGER DEFAULT 1,dirty INTEGER DEFAULT 1,deleted INTEGER DEFAULT 0,sync_id TEXT )";
    public static final String DB_NAME = "ocrapp.db";
    public static final String DB_SHM = "ocrapp.db-shm";
    private static final int DB_VERSION = 1;
    public static final String DB_WAL = "ocrapp.db-wal";
    private static final String TAG = "OcrAppInfoHelper";

    public OcrAppInfoHelper(Context r4) {
        super(r4, DB_NAME, null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r2) {
        OLog.d(TAG, "OcrAppInfoHelper created");
        r2.execSQL(DB_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        OLog.d(TAG, "OcrAppInfoHelper onUpgrade from " + r2 + " to " + r3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
        OLog.d(TAG, "OcrAppInfoHelper onDowngrade from " + r2 + " to " + r3);
    }
}
