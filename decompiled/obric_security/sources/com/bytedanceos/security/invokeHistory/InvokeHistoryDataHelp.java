package com.bytedanceos.security.invokeHistory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;

/* JADX INFO: loaded from: classes2.dex */
public class InvokeHistoryDataHelp extends SQLiteOpenHelper {
    static final String AUTHORITY = "com.bytedanceos.security.invokeHistory";
    static final Uri CONTENT_ID_URI_BASE = null;
    public static final Uri CONTENT_URI = null;
    private static final String DB_CREATE = "create table invokeHistory (_id integer primary key autoincrement,callee text,calleeUid integer,caller text,callerUid integer,type text,className text,action text,time long,allow integer,number integer);";
    private static final String DB_NAME = "invoke_history.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "invokeHistory";

    static class ItemColumns implements BaseColumns {
        static final String ACTION = "action";
        static final String ALLOW = "allow";
        static final String CALLEE = "callee";
        static final String CALLEEUID = "calleeUid";
        static final String CALLER = "caller";
        static final String CALLERUID = "callerUid";
        static final String CLASSNAME = "className";
        static final String NUMBER = "number";
        static final String TIME = "time";
        static final String TYPE = "type";

        ItemColumns() {
        }
    }

    static {
        CONTENT_URI = Uri.parse("content://com.bytedanceos.security.invokeHistory/invokeHistory");
        CONTENT_ID_URI_BASE = Uri.parse("content://com.bytedanceos.security.invokeHistory/invokeHistory/");
    }

    public InvokeHistoryDataHelp(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS invokeHistory");
        onCreate(db);
    }
}
