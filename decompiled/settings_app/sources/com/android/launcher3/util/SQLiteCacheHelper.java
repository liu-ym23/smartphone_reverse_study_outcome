package com.android.launcher3.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class SQLiteCacheHelper {
    private static final boolean IN_MEMORY_CACHE = false;
    private static final String TAG = "SQLiteCacheHelper";
    private boolean mIgnoreWrites;
    private final MySQLiteOpenHelper mOpenHelper;
    private final String mTableName;

    private class MySQLiteOpenHelper extends NoLocaleSQLiteHelper {
        final /* synthetic */ SQLiteCacheHelper this$0;

        static /* synthetic */ void access$000(MySQLiteOpenHelper r0, SQLiteDatabase r1) {
            r0.clearDB(r1);
        }

        public MySQLiteOpenHelper(SQLiteCacheHelper r1, Context r2, String r3, int r4) {
            this.this$0 = r1;
            super(r2, r3, r4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r1) {
            this.this$0.onCreateTable(r1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
            if (r2 == r3) goto L5;
            clearDB(r1);
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
            if (r2 == r3) goto L5;
            clearDB(r1);
            return;
        }

        private void clearDB(SQLiteDatabase r3) {
            r3.execSQL("DROP TABLE IF EXISTS " + SQLiteCacheHelper.access$100(this.this$0));
            onCreate(r3);
        }
    }

    protected abstract void onCreateTable(SQLiteDatabase r1);

    static /* synthetic */ String access$100(SQLiteCacheHelper r0) {
        return r0.mTableName;
    }

    public SQLiteCacheHelper(Context r1, String r2, int r3, String r4) {
        this.mTableName = r4;
        this.mOpenHelper = new MySQLiteOpenHelper(this, r1, r2, r3);
        this.mIgnoreWrites = false;
    }

    public void delete(String r3, String[] r4) {
        if (this.mIgnoreWrites == false) goto L12;
        return;
    L12:
        this.mOpenHelper.getWritableDatabase().delete(this.mTableName, r3, r4);     // Catch: SQLiteException -> L7 SQLiteFullException -> L9
    L15:
        return;
    L9:
        e = move-exception;
        onDiskFull(e);
        return;
    L7:
        e = move-exception;
        Log.d(TAG, "Ignoring sqlite exception", e);
    }

    public void insertOrReplace(ContentValues r5) {
        if (this.mIgnoreWrites == false) goto L12;
        return;
    L12:
        this.mOpenHelper.getWritableDatabase().insertWithOnConflict(this.mTableName, null, r5, 5);     // Catch: SQLiteException -> L7 SQLiteFullException -> L9
    L15:
        return;
    L9:
        e = move-exception;
        onDiskFull(e);
        return;
    L7:
        e = move-exception;
        Log.d(TAG, "Ignoring sqlite exception", e);
    }

    private void onDiskFull(SQLiteFullException r3) {
        Log.e(TAG, "Disk full, all write operations will be ignored", r3);
        this.mIgnoreWrites = true;
    }

    public Cursor query(String[] r10, String r11, String[] r12) {
        return this.mOpenHelper.getReadableDatabase().query(this.mTableName, r10, r11, r12, null, null, null);
    }

    public void clear() {
        MySQLiteOpenHelper r1 = this.mOpenHelper;
        MySQLiteOpenHelper.access$000(r1, r1.getWritableDatabase());
    }

    public void close() {
        this.mOpenHelper.close();
    }
}
