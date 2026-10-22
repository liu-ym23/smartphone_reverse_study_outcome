package com.obric.search.storage.sqlite.manager;

import android.content.Context;
import com.obric.search.api.config.SQLCipherConfig;
import com.obric.search.api.migration.MigrationContainer;
import com.obric.search.storage.sqlite.fts5.SQLiteFts5Extension;
import com.obric.search.storage.sqlite.schema.intf.ISQLiteTableSchema;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteOpenHelper;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: SQLiteDatabaseManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/search/storage/sqlite/manager/SQLiteDatabaseManager;", "", "context", "Landroid/content/Context;", "databaseName", "", "version", "", "schemaList", "", "Lcom/obric/search/storage/sqlite/schema/intf/ISQLiteTableSchema;", "passPhrase", "sqlCipherConfig", "Lcom/obric/search/api/config/SQLCipherConfig;", "migrationContainer", "Lcom/obric/search/api/migration/MigrationContainer;", "(Landroid/content/Context;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Lcom/obric/search/api/config/SQLCipherConfig;Lcom/obric/search/api/migration/MigrationContainer;)V", "database", "Lcom/tencent/wcdb/database/SQLiteDatabase;", "getDatabase", "()Lcom/tencent/wcdb/database/SQLiteDatabase;", "database$delegate", "Lkotlin/Lazy;", "sqliteOpenHelper", "Lcom/tencent/wcdb/database/SQLiteOpenHelper;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SQLiteDatabaseManager {
    public static final Companion Companion = null;
    private static final String TAG = "SQLiteDatabaseManager";
    private final Lazy database$delegate;
    private final SQLiteOpenHelper sqliteOpenHelper;

    /* JADX INFO: compiled from: SQLiteDatabaseManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/storage/sqlite/manager/SQLiteDatabaseManager$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public SQLiteDatabaseManager(final Context r12, final String r13, final int r14, final List<? extends ISQLiteTableSchema> r15, String r16, SQLCipherConfig r17, final MigrationContainer r18) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "databaseName");
        Intrinsics.checkNotNullParameter(r15, "schemaList");
        if (r16 == null) goto L5;
        byte[] r1 = r16.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).getBytes(charset)");
        final byte[] r9 = r1;
    L6:
        if (r17 == null) goto L8;
        final SQLiteCipherSpec r10 = r17.toSQLiteCipherSpec$sdk_release();
    L9:
        this.sqliteOpenHelper = new SQLiteDatabaseManager$sqliteOpenHelper$1(r12, r13, r14, r15, r18, r9, r10);
        this.database$delegate = LazyKt.lazy(new SQLiteDatabaseManager$database$2(this));
        return;
    L8:
        r10 = null;
        goto L9
    L5:
        r9 = null;
        goto L6
    }

    public /* synthetic */ SQLiteDatabaseManager(Context r11, String r12, int r13, List r14, String r15, SQLCipherConfig r16, MigrationContainer r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        SQLCipherConfig r8 = null;
    L11:
        if ((r18 & 64) == 0) goto L13;
        MigrationContainer r9 = null;
    L14:
        this(r11, r12, r13, r14, r7, r8, r9);
        return;
    L13:
        r9 = r17;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    public static final /* synthetic */ SQLiteOpenHelper access$getSqliteOpenHelper$p(SQLiteDatabaseManager r0) {
        return r0.sqliteOpenHelper;
    }

    static {
        Companion = new Companion(null);
        SQLiteFts5Extension.INSTANCE.init();
    }

    public final SQLiteDatabase getDatabase() {
        Object r1 = this.database$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-database>(...)");
        return (SQLiteDatabase) r1;
    }
}
