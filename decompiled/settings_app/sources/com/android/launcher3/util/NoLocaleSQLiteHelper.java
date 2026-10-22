package com.android.launcher3.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public abstract class NoLocaleSQLiteHelper extends SQLiteOpenHelper {
    private static final boolean ATLEAST_P = false;

    private static class NoLocalContext extends ContextWrapper {
        public NoLocalContext(Context r1) {
            super(r1);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public SQLiteDatabase openOrCreateDatabase(String r1, int r2, SQLiteDatabase.CursorFactory r3, DatabaseErrorHandler r4) {
            return super.openOrCreateDatabase(r1, r2 | 16, r3, r4);
        }
    }

    static {
        ATLEAST_P = true;
    }

    public NoLocaleSQLiteHelper(Context r3, String r4, int r5) {
        boolean r0 = ATLEAST_P;
        if (r0 == true) goto L6;
        r3 = new NoLocalContext(r3);
    L6:
        super(r3, r4, null, r5);
        if (r0 == false) goto L10;
        setOpenParams(new SQLiteDatabase.OpenParams.Builder().addOpenFlags(16).build());
        return;
    }
}
