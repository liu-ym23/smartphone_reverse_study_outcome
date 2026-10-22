package com.tencent.wcdb.database;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteCustomFunction {
    public final SQLiteDatabase.CustomFunction callback;
    public final String name;
    public final int numArgs;

    public SQLiteCustomFunction(String r1, int r2, SQLiteDatabase.CustomFunction r3) {
        if (r1 == null) goto L7;
        this.name = r1;
        this.numArgs = r2;
        this.callback = r3;
        return;
    L7:
        throw new IllegalArgumentException("name must not be null.");
    }

    private void dispatchCallback(String[] r1) {
        this.callback.callback(r1);
    }
}
