package com.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private y f7215f;

    static {
    }

    public c0(Context r3, String r4, y r5) {
        super(r3, r4, null, 1);
        this.f7215f = r5;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r1) {
        this.f7215f.a(r1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
    }
}
