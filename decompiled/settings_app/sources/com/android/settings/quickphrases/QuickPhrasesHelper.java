package com.android.settings.quickphrases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.settings.textboom.db.OcrAppInfoColumn;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class QuickPhrasesHelper extends SQLiteOpenHelper {
    private static final String DB_CREATE = "create table quickphrases (_id INTEGER PRIMARY KEY AUTOINCREMENT,phrase TEXT,pos INTEGER,dirty INTEGER DEFAULT 1,deleted INTEGER DEFAULT 0,sync_id TEXT , encrypt INTEGER DEFAULT 0 )";
    private static final String DB_CREATE_ENCRYPT = "create table encrypt (_id INTEGER PRIMARY KEY AUTOINCREMENT,pwd TEXT NOT NULL,time TEXT  )";
    public static final String DB_NAME = "quickphrases.db";
    public static final String DB_SHM = "quickphrases.db-shm";
    private static final int DB_VERSION = 4;
    public static final String DB_WAL = "quickphrases.db-wal";
    public static final String TABLE_NAME = "quickphrases";
    public static final String TABLE_NAME_ENCRYPT = "encrypt";
    private static final String TAG = "QuickPhrase";

    public QuickPhrasesHelper(Context r4) {
        super(r4, DB_NAME, null, 4);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r2) {
        OLog.d(TAG, "databasehelper created");
        r2.execSQL(DB_CREATE);
        r2.execSQL(DB_CREATE_ENCRYPT);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r4, int r5, int r6) {
        if (r5 != 1) goto L15;
        OLog.d(TAG, "databasehelper onUpgrade from 1 to " + r6);
        r4.beginTransaction();
        upgradeDatabaseToVersion2(r4);     // Catch: Throwable -> L8
        upgradeDatabaseToVersion3(r4);     // Catch: Throwable -> L8
        upgradeDatabaseToVersion4(r4);     // Catch: Throwable -> L8
        r4.setTransactionSuccessful();     // Catch: Throwable -> L8
        r4.endTransaction();
        return;
    L8:
        th = move-exception;
        OLog.e(TAG, th.getMessage(), th);     // Catch: Throwable -> L11
        r4.endTransaction();
    L11:
        th = move-exception;
        r4.endTransaction();
        throw th;
    L15:
        if (r5 != 2) goto L27;
        OLog.d(TAG, "databasehelper onUpgrade from 2 to " + r6);
        r4.beginTransaction();
        upgradeDatabaseToVersion3(r4);     // Catch: Throwable -> L20
        upgradeDatabaseToVersion4(r4);     // Catch: Throwable -> L20
        r4.setTransactionSuccessful();     // Catch: Throwable -> L20
        r4.endTransaction();
        return;
    L20:
        th = move-exception;
        OLog.e(TAG, th.getMessage(), th);     // Catch: Throwable -> L23
        r4.endTransaction();
    L23:
        th = move-exception;
        r4.endTransaction();
        throw th;
    L27:
        if (r5 != 3) goto L38;
        OLog.d(TAG, "databasehelper onUpgrade from 3 to " + r6);
        r4.beginTransaction();
        upgradeDatabaseToVersion4(r4);     // Catch: Throwable -> L32
        r4.setTransactionSuccessful();     // Catch: Throwable -> L32
        r4.endTransaction();
        return;
    L32:
        th = move-exception;
        OLog.e(TAG, th.getMessage(), th);     // Catch: Throwable -> L35
        r4.endTransaction();
    L35:
        th = move-exception;
        r4.endTransaction();
        throw th;
    L38:
        r4.execSQL("drop table if exists quickphrases");
        r4.execSQL(DB_CREATE);
        r4.execSQL(DB_CREATE_ENCRYPT);
    }

    private boolean isColumExists(SQLiteDatabase r2, String r3, String r4) {
        Object[] r1 = {r4, r3};
        Cursor r5 = null;
        r5 = r2.rawQuery(String.format("select %s from %s;", r1), null);     // Catch: Throwable -> L13 Exception -> L17
        if (r5 == null) goto L10;
        if (r5.moveToFirst() == false) goto L10;
        if (r5 == null) goto L9;
        r5.close();
    L9:
        return true;
    L10:
        if (r5 == null) goto L12;
        r5.close();
    L12:
        return false;
    L17:
        if (r5 == null) goto L19;
        r5.close();
    L19:
        return false;
    L13:
        th = move-exception;
        if (r5 == null) goto L16;
        r5.close();
    L16:
        throw th;
    }

    void upgradeDatabaseToVersion2(SQLiteDatabase r3) {
        if (isColumExists(r3, TABLE_NAME, OcrAppInfoColumn.ItemsRecord.COLUMN_DIRTY) == true) goto L6;
        r3.execSQL("ALTER TABLE quickphrases ADD COLUMN dirty INTEGER DEFAULT 1");
    L6:
        if (isColumExists(r3, TABLE_NAME, OcrAppInfoColumn.ItemsRecord.COLUMN_DELETED) == true) goto L9;
        r3.execSQL("ALTER TABLE quickphrases ADD COLUMN deleted INTEGER DEFAULT 0");
    L9:
        if (isColumExists(r3, TABLE_NAME, OcrAppInfoColumn.ItemsRecord.COLUMN_SYNC_ID) == true) goto L12;
        r3.execSQL("ALTER TABLE quickphrases ADD COLUMN sync_id TEXT");
        return;
    }

    void upgradeDatabaseToVersion3(SQLiteDatabase r1) {
        r1.execSQL("ALTER TABLE quickphrases RENAME TO table_tmp");
        r1.execSQL(DB_CREATE);
        r1.execSQL("INSERT INTO quickphrases SELECT _id,phrase,pos,dirty,deleted,sync_id FROM table_tmp;");
        r1.execSQL("DROP TABLE table_tmp");
    }

    void upgradeDatabaseToVersion4(SQLiteDatabase r3) {
        if (isColumExists(r3, TABLE_NAME, TABLE_NAME_ENCRYPT) == true) goto L5;
        r3.execSQL("ALTER TABLE quickphrases ADD COLUMN encrypt INTEGER DEFAULT 0");
    L5:
        r3.execSQL(DB_CREATE_ENCRYPT);
    }
}
