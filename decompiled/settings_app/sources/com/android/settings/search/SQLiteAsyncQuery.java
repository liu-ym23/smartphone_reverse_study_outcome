package com.android.settings.search;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SQLiteAsyncQuery<A> {
    protected abstract A performQuery(SQLiteDatabase r1);

    public SQLiteAsyncQuery() {
    }

    public void run(SQLiteDatabase r1, Consumer<A> r2) {
        r2.consume(performQuery(r1));
    }
}
