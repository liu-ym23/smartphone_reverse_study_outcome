package com.bytedanceos.cleaner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/* JADX INFO: loaded from: classes2.dex */
public class CleanerDataHelper extends SQLiteOpenHelper {
    private static final String DB_CREATE = "create table uninstalled_pkgs (_id integer primary key autoincrement,package_name text);";
    private static final String DB_NAME = "cleaner.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "uninstalled_pkgs";

    public static class ItemColumns implements BaseColumns {
        public static final String PACKAGE_NAME = "package_name";

        public ItemColumns() {
        }
    }

    public CleanerDataHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS uninstalled_pkgs");
        onCreate(db);
    }
}
