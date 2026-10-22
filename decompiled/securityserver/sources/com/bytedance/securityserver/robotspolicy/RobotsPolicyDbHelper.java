package com.bytedance.securityserver.robotspolicy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public class RobotsPolicyDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "robots_policy.db";
    private static final int DB_VERSION = 1;

    public RobotsPolicyDbHelper(Context r4) {
        super(r4, DB_NAME, null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE policy (package_name TEXT PRIMARY KEY NOT NULL, policy TEXT NOT NULL, version INTEGER DEFAULT 0);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
    }
}
