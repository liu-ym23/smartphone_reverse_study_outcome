package androidx.sqlite.db;

import com.bytedanceos.security.Utils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleSQLiteQuery.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "", "(Ljava/lang/String;)V", "bindArgs", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "argCount", "", "getArgCount", "()I", "[Ljava/lang/Object;", "sql", "getSql", "()Ljava/lang/String;", "bindTo", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public static final Companion Companion = null;
    private final Object[] bindArgs;
    private final String query;

    /* JADX INFO: compiled from: SimpleSQLiteQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\tJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery$Companion;", "", "()V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "bindArgs", "", "(Landroidx/sqlite/db/SupportSQLiteProgram;[Ljava/lang/Object;)V", Utils.INTENT_KEY_INDEX, "", "arg", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void bind(SupportSQLiteProgram r4, Object[] r5) {
            Intrinsics.checkNotNullParameter(r4, "statement");
            if (r5 != null) goto L5;
            return;
        L5:
            int r0 = r5.length;
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L8;
            Object r2 = r5[r1];
            r1 = r1 + 1;
            bind(r4, r1, r2);
            goto L6
        }

        private final void bind(SupportSQLiteProgram r3, int r4, Object r5) {
            if (r5 != null) goto L5;
            r3.bindNull(r4);
            return;
        L5:
            if ((r5 instanceof byte[]) == false) goto L8;
            r3.bindBlob(r4, (byte[]) r5);
            return;
        L8:
            if ((r5 instanceof Float) == false) goto L11;
            r3.bindDouble(r4, ((Number) r5).floatValue());
            return;
        L11:
            if ((r5 instanceof Double) == false) goto L14;
            r3.bindDouble(r4, ((Number) r5).doubleValue());
            return;
        L14:
            if ((r5 instanceof Long) == false) goto L17;
            r3.bindLong(r4, ((Number) r5).longValue());
            return;
        L17:
            if ((r5 instanceof Integer) == false) goto L20;
            r3.bindLong(r4, ((Number) r5).intValue());
            return;
        L20:
            if ((r5 instanceof Short) == false) goto L23;
            r3.bindLong(r4, ((Number) r5).shortValue());
            return;
        L23:
            if ((r5 instanceof Byte) == false) goto L26;
            r3.bindLong(r4, ((Number) r5).byteValue());
            return;
        L26:
            if ((r5 instanceof String) == false) goto L29;
            r3.bindString(r4, (String) r5);
            return;
        L29:
            if ((r5 instanceof Boolean) == false) goto L37;
            if (((Boolean) r5).booleanValue() == false) goto L33;
            long r0 = 1;
        L34:
            r3.bindLong(r4, r0);
            return;
        L33:
            r0 = 0;
            goto L34
        L37:
            throw new IllegalArgumentException("Cannot bind " + r5 + " at index " + r4 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final void bind(SupportSQLiteProgram r1, Object[] r2) {
        Companion.bind(r1, r2);
    }

    public SimpleSQLiteQuery(String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r2, "query");
        this.query = r2;
        this.bindArgs = r3;
    }

    public SimpleSQLiteQuery(String r2) {
        Intrinsics.checkNotNullParameter(r2, "query");
        this(r2, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.query;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r2) {
        Intrinsics.checkNotNullParameter(r2, "statement");
        Companion.bind(r2, this.bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] r0 = this.bindArgs;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.length;
    }
}
