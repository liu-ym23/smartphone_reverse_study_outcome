package com.bytedanceos.securitycenter.appBgBatteryControl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;

/* JADX INFO: loaded from: classes2.dex */
public class AppBgBatteryControlDataHelper extends SQLiteOpenHelper {
    static final String AUTHORITY = "com.bytedanceos.security.appBgBatteryControl";
    public static final Uri CONTENT_ID_URI_BASE = null;
    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.com.bytedanceos.security.appBgBatteryControl";
    static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.com.bytedanceos.security.appBgBatteryControl";
    public static final Uri CONTENT_URI = null;
    private static final String DB_CREATE = "create table appBgBatteryControl (_id integer primary key autoincrement,packageName text not null,uid integer,userid text,installed integer,version text,param integer,reason text,enable integer);";
    private static final String DB_NAME = "app_bg_battery_control.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "appBgBatteryControl";
    private Context mContext;

    public static class ItemColumns implements BaseColumns {
        public static final String ENABLE = "enable";
        public static final String INSTALL = "installed";
        public static final int INSTALLED = 1;
        public static final int NOT_OPTIMIZATION = 0;
        public static final int OPTIMIZATION = 1;
        public static final String PACKAGE_NAME = "packageName";
        public static final String PARAM = "param";
        public static final String REASON = "reason";
        public static final String UID = "uid";
        public static final int UNINSTALLED = 0;
        public static final String USERID = "userid";
        public static final String VERSION = "version";

        public ItemColumns() {
        }
    }

    private void initData(SQLiteDatabase db) {
    }

    static {
        CONTENT_URI = Uri.parse("content://com.bytedanceos.security.appBgBatteryControl/appBgBatteryControl");
        CONTENT_ID_URI_BASE = Uri.parse("content://com.bytedanceos.security.appBgBatteryControl/appBgBatteryControl/");
    }

    public AppBgBatteryControlDataHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.mContext = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
        initData(db);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS appBgBatteryControl");
        onCreate(db);
    }
}
