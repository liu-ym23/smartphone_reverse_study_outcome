package androidx.sqlite.db;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    @Nullable
    private final Object[] mBindArgs;
    private final String mQuery;

    public SimpleSQLiteQuery(String r2) {
        this(r2, null);
    }

    public SimpleSQLiteQuery(String r1, @Nullable Object[] r2) {
        this.mQuery = r1;
        this.mBindArgs = r2;
    }

    private static void bind(SupportSQLiteProgram r2, int r3, Object r4) {
        if (r4 != null) goto L5;
        r2.bindNull(r3);
        return;
    L5:
        if ((r4 instanceof byte[]) == false) goto L8;
        r2.bindBlob(r3, (byte[]) r4);
        return;
    L8:
        if ((r4 instanceof Float) == false) goto L12;
        double r0 = ((Float) r4).floatValue();
    L10:
        r2.bindDouble(r3, r0);
        return;
    L12:
        if ((r4 instanceof Double) == false) goto L15;
        r0 = ((Double) r4).doubleValue();
        goto L10
    L15:
        if ((r4 instanceof Long) == false) goto L19;
        long r1 = ((Long) r4).longValue();
    L17:
        r2.bindLong(r3, r1);
        return;
    L19:
        if ((r4 instanceof Integer) == false) goto L23;
        int r5 = ((Integer) r4).intValue();
    L21:
        r1 = r5;
        goto L17
    L23:
        if ((r4 instanceof Short) == false) goto L26;
        r5 = ((Short) r4).shortValue();
        goto L21
    L26:
        if ((r4 instanceof Byte) == false) goto L29;
        r5 = ((Byte) r4).byteValue();
        goto L21
    L29:
        if ((r4 instanceof String) == false) goto L32;
        r2.bindString(r3, (String) r4);
        return;
    L32:
        if ((r4 instanceof Boolean) == false) goto L39;
        if (((Boolean) r4).booleanValue() == false) goto L36;
        r1 = 1;
        goto L17
    L36:
        r1 = 0;
        goto L17
    L39:
        throw new IllegalArgumentException("Cannot bind " + r4 + " at index " + r3 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }

    public static void bind(SupportSQLiteProgram r3, Object[] r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        Object r2 = r4[r1];
        r1 = r1 + 1;
        bind(r3, r1, r2);
        goto L5
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r1) {
        bind(r1, this.mBindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] r0 = this.mBindArgs;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }
}
