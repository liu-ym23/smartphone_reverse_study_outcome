package com.bytedance.bdturing.t;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a extends SQLiteOpenHelper {
    static {
    }

    public a(Context r4) {
        super(r4, "verifystorage.db", null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        o.g(r1, "db");
        r1.execSQL("CREATE TABLE IF NOT EXISTS h5_storage (\n    id INTEGER PRIMARY KEY AUTOINCREMENT,\n    primary_key TEXT,\n    time_stamp LONG, \n    content TEXT\n    )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
        o.g(r1, "db");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        o.g(r1, "db");
        r1.execSQL("DROP TABLE h5_storage");
        onCreate(r1);
    }
}
