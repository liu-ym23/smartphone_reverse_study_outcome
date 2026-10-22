package com.obric.search.storage.sqlite;

import android.content.ContentValues;
import android.content.Context;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.search.api.config.SQLCipherConfig;
import com.obric.search.api.config.SQLiteTrace;
import com.obric.search.api.migration.MigrationContainer;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.storage.sqlite.manager.SQLiteDatabaseManager;
import com.obric.search.storage.sqlite.schema.intf.ISQLiteTableSchema;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SQLiteSearchEngine.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J0\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\tJ6\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u001e\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u00170\tJ\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J(\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00050\u00170\t2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J6\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020*0\u00170\t2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\tJJ\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;", "", "context", "Landroid/content/Context;", "databaseName", "", "version", "", "schemaList", "", "Lcom/obric/search/storage/sqlite/schema/intf/ISQLiteTableSchema;", "passPhrase", "sqlCipherConfig", "Lcom/obric/search/api/config/SQLCipherConfig;", "migrationContainer", "Lcom/obric/search/api/migration/MigrationContainer;", "(Landroid/content/Context;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Lcom/obric/search/api/config/SQLCipherConfig;Lcom/obric/search/api/migration/MigrationContainer;)V", "sqliteDatabaseManager", "Lcom/obric/search/storage/sqlite/manager/SQLiteDatabaseManager;", "statementMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/wcdb/database/SQLiteStatement;", "batchDeleteByLongValue", "Lkotlin/Pair;", "", "tableName", "deleteSQL", "arguments", "", "batchInsertStringValue", "insertSQL", "executeDelete", "executeInsert", "getCachedStatement", "sqlString", "getCursor", "Lcom/tencent/wcdb/Cursor;", "querySQL", "matchClause", "queryRowId", "queryRowIdAndAuxiliaryFuncStringResult", "queryRowIdAndStringColumn", "Landroid/content/ContentValues;", "columnList", "recreateSqliteDatabaseManager", "", "setSQLiteDatabaseTraceCallback", "sqliteTrace", "Lcom/obric/search/api/config/SQLiteTrace;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SQLiteSearchEngine {
    public static final Companion Companion = null;
    private static final String TAG = "SQLiteSearchEngine";
    private SQLiteDatabaseManager sqliteDatabaseManager;
    private final ConcurrentHashMap<String, SQLiteStatement> statementMap;

    /* JADX INFO: compiled from: SQLiteSearchEngine.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/storage/sqlite/SQLiteSearchEngine$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SQLiteSearchEngine(Context r11, String r12, int r13, List<? extends ISQLiteTableSchema> r14, String r15, SQLCipherConfig r16, MigrationContainer r17) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "databaseName");
        Intrinsics.checkNotNullParameter(r14, "schemaList");
        this.sqliteDatabaseManager = new SQLiteDatabaseManager(r11, r12, r13, r14, r15, r16, r17);
        this.statementMap = new ConcurrentHashMap();
    }

    public /* synthetic */ SQLiteSearchEngine(Context r11, String r12, int r13, List r14, String r15, SQLCipherConfig r16, MigrationContainer r17, int r18, DefaultConstructorMarker r19) {
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

    private final SQLiteStatement getCachedStatement(String r2) {
        SQLiteStatement r0 = this.statementMap.get(r2);
        if (r0 != null) goto L7;
        SQLiteStatement r1 = this.sqliteDatabaseManager.getDatabase().compileStatement(r2);
        this.statementMap.put(r2, r1);
        Intrinsics.checkNotNullExpressionValue(r1, "{\n            val newSta…   newStatement\n        }");
        return r1;
    L7:
        return r0;
    }

    public final synchronized void recreateSqliteDatabaseManager(Context r11, String r12, int r13, List<? extends ISQLiteTableSchema> r14, String r15, SQLCipherConfig r16, MigrationContainer r17) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "context");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r12, "databaseName");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r14, "schemaList");     // Catch: Throwable -> L7
        this.statementMap.clear();     // Catch: Throwable -> L7
        this.sqliteDatabaseManager = new SQLiteDatabaseManager(r11, r12, r13, r14, r15, r16, r17);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean executeInsert(String r7, String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "tableName");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r8, "insertSQL");     // Catch: Throwable -> L19
        SQLiteStatement r9 = getCachedStatement(r8);     // Catch: Throwable -> L19
        this.sqliteDatabaseManager.getDatabase().beginTransaction();     // Catch: Throwable -> L19
        long r2 = r9.executeInsert();     // Catch: Exception -> L13 Throwable -> L19
        if (r2 != (-1)) goto L9;
        RuntimeLogger.INSTANCE.error(TAG, "executeInsert error! Statement.executeInsert return " + r2 + '.');     // Catch: Exception -> L13 Throwable -> L19
        boolean r10 = true;
    L10:
        if (r10 == true) goto L15;
        this.sqliteDatabaseManager.getDatabase().setTransactionSuccessful();     // Catch: Exception -> L13 Throwable -> L19
    L15:
        this.sqliteDatabaseManager.getDatabase().endTransaction();     // Catch: Throwable -> L19
        boolean r11 = !r10;
        monitor-exit(this);
        return r11;
    L9:
        r10 = false;
    L13:
        e = move-exception;
        RuntimeLogger.INSTANCE.error(TAG, "executeInsert error!\n" + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L19
        r10 = true;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean batchInsertStringValue(String r6, String r7, List<? extends Pair<Long, ? extends List<String>>> r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "tableName");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r7, "insertSQL");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r8, "arguments");     // Catch: Throwable -> L25
        SQLiteStatement r9 = getCachedStatement(r7);     // Catch: Throwable -> L25
        this.sqliteDatabaseManager.getDatabase().beginTransaction();     // Catch: Throwable -> L25
        Iterator<? extends Pair<Long, ? extends List<String>>> r10 = r8.iterator();     // Catch: Exception -> L19 Throwable -> L25
    L7:
        if (r10.hasNext() == false) goto L15;
        Pair<Long, ? extends List<String>> r0 = r10.next();     // Catch: Exception -> L19 Throwable -> L25
        r9.bindLong(1, r0.getFirst().longValue());     // Catch: Exception -> L19 Throwable -> L25
        Iterator<String> r1 = r0.getSecond().iterator();     // Catch: Exception -> L19 Throwable -> L25
        int r2 = 2;
    L10:
        if (r1.hasNext() == false) goto L12;
        r9.bindString(r2, r1.next());     // Catch: Exception -> L19 Throwable -> L25
        r2 = r2 + 1;     // Catch: Exception -> L19 Throwable -> L25
        goto L10
    L12:
        long r3 = r9.executeInsert();     // Catch: Exception -> L19 Throwable -> L25
        if (r3 != (-1)) goto L7;
        RuntimeLogger.INSTANCE.error(TAG, "batchInsertStringValue error! executeInsert return " + r3 + ". (RowID is " + r0.getFirst().longValue() + ')');     // Catch: Exception -> L19 Throwable -> L25
        boolean r11 = true;
    L16:
        if (r11 == true) goto L21;
        this.sqliteDatabaseManager.getDatabase().setTransactionSuccessful();     // Catch: Exception -> L19 Throwable -> L25
    L21:
        this.sqliteDatabaseManager.getDatabase().endTransaction();     // Catch: Throwable -> L25
        boolean r12 = !r11;
        monitor-exit(this);
        return r12;
    L15:
        r11 = false;
    L19:
        e = move-exception;
        RuntimeLogger.INSTANCE.error(TAG, "batchInsertStringValue error!\n" + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L25
        r11 = true;
    L25:
        th = move-exception;
        throw th;
    }

    public final synchronized List<Long> queryRowId(String r7, String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "querySQL");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r8, "matchClause");     // Catch: Throwable -> L19
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L19
        SQLiteDatabase r2 = this.sqliteDatabaseManager.getDatabase();     // Catch: Throwable -> L19
        Object[] r9 = CollectionsKt.listOf(r8).toArray(new String[0]);     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L19
        Cursor r10 = r2.rawQuery(r7, r9);     // Catch: Throwable -> L19
        Cursor r11 = r10;     // Catch: Throwable -> L14
        RuntimeLogger.INSTANCE.debug(TAG, "queryRowId cursor size is " + r11.getCount());     // Catch: Throwable -> L14
    L7:
        if (r11.moveToNext() == false) goto L9;
        r1.add(Long.valueOf(r11.getLong(0)));     // Catch: Throwable -> L14
        goto L7
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L11:
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r1;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized List<Pair<Long, String>> queryRowIdAndAuxiliaryFuncStringResult(String r7, String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "querySQL");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r8, "matchClause");     // Catch: Throwable -> L19
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L19
        SQLiteDatabase r2 = this.sqliteDatabaseManager.getDatabase();     // Catch: Throwable -> L19
        Object[] r9 = CollectionsKt.listOf(r8).toArray(new String[0]);     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L19
        Cursor r10 = r2.rawQuery(r7, r9);     // Catch: Throwable -> L19
        Cursor r11 = r10;     // Catch: Throwable -> L14
        RuntimeLogger.INSTANCE.debug(TAG, "queryRowId cursor size is " + r11.getCount());     // Catch: Throwable -> L14
    L7:
        if (r11.moveToNext() == false) goto L9;
        r1.add(new Pair(Long.valueOf(r11.getLong(0)), r11.getString(1)));     // Catch: Throwable -> L14
        goto L7
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L11:
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r1;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized List<Pair<Long, ContentValues>> queryRowIdAndStringColumn(String r10, String r11, List<String> r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "querySQL");     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(r11, "matchClause");     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(r12, "columnList");     // Catch: Throwable -> L41
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L41
        SQLiteDatabase r2 = this.sqliteDatabaseManager.getDatabase();     // Catch: Throwable -> L41
        Object[] r13 = CollectionsKt.listOf(r11).toArray(new String[0]);     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L41
        Cursor r14 = r2.rawQuery(r10, r13);     // Catch: Throwable -> L41
        Cursor r15 = r14;     // Catch: Throwable -> L36
        RuntimeLogger.INSTANCE.debug(TAG, "queryRowIdAndStringColumn cursor size is " + r15.getCount());     // Catch: Throwable -> L36
        int r0 = r15.getColumnIndex(BaseIconCache.IconDB.COLUMN_ROWID);     // Catch: Throwable -> L36
        if (r0 != (-1)) goto L11;
        RuntimeLogger.INSTANCE.error(TAG, "queryRowIdAndStringColumn ROWID index is -1");     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L41
        monitor-exit(this);
        return r1;
    L11:
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L36
        Iterator<String> r16 = r12.iterator();     // Catch: Throwable -> L36
    L13:
        if (r16.hasNext() == false) goto L22;
        String r5 = r16.next();     // Catch: Throwable -> L36
        int r6 = r15.getColumnIndex(r5);     // Catch: Throwable -> L36
        if (r6 == (-1)) goto L16;
        r4.put(r5, Integer.valueOf(r6));     // Catch: Throwable -> L36
        goto L13
    L16:
        RuntimeLogger.INSTANCE.error(TAG, "queryRowIdAndStringColumn " + r5 + " index is -1");     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L41
        monitor-exit(this);
        return r1;
    L22:
        if (r15.moveToNext() == false) goto L32;
        ContentValues r17 = new ContentValues();     // Catch: Throwable -> L36
        Iterator r3 = r4.entrySet().iterator();     // Catch: Throwable -> L36
    L25:
        if (r3.hasNext() == false) goto L31;
        Map.Entry r7 = (Map.Entry) r3.next();     // Catch: Throwable -> L36
        String r8 = (String) r7.getKey();     // Catch: Throwable -> L36
        int r9 = ((Number) r7.getValue()).intValue();     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r15, "it");     // Catch: Throwable -> L36
        Cursor r18 = r15;     // Catch: Throwable -> L36
        if (r18.isNull(r9) == false) goto L29;
        String r19 = null;
    L30:
        r17.put(r8, r19);     // Catch: Throwable -> L36
        goto L25
    L29:
        r19 = r18.getString(r9);     // Catch: Throwable -> L36
        goto L30
    L31:
        r1.add(new Pair(Long.valueOf(r15.getLong(r0)), r17));     // Catch: Throwable -> L36
        goto L22
    L32:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L41
        monitor-exit(this);
        return r1;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    public final synchronized Cursor getCursor(String r3, String r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "querySQL");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r4, "matchClause");     // Catch: Throwable -> L6
        SQLiteDatabase r0 = this.sqliteDatabaseManager.getDatabase();     // Catch: Throwable -> L6
        Object[] r5 = CollectionsKt.listOf(r4).toArray(new String[0]);     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L6
        Cursor r6 = r0.rawQuery(r3, r5);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r6, "sqliteDatabaseManager.da…chClause).toTypedArray())");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Pair<Boolean, Integer> executeDelete(String r7, String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "tableName");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r8, "deleteSQL");     // Catch: Throwable -> L22
        SQLiteStatement r9 = getCachedStatement(r8);     // Catch: Throwable -> L22
        this.sqliteDatabaseManager.getDatabase().beginTransaction();     // Catch: Throwable -> L22
        boolean r10 = true;
        int r11 = r9.executeUpdateDelete() + 0;
        this.sqliteDatabaseManager.getDatabase().setTransactionSuccessful();     // Catch: Exception -> L10 Throwable -> L22
        boolean r0 = false;
    L15:
        this.sqliteDatabaseManager.getDatabase().endTransaction();     // Catch: Throwable -> L22
        if (r0 == false) goto L19;
        r10 = false;
    L19:
        Pair<Boolean, Integer> r2 = new Pair(Boolean.valueOf(r10), Integer.valueOf(r11));     // Catch: Throwable -> L22
        monitor-exit(this);
        return r2;
    L10:
        e = e;
    L14:
        RuntimeLogger.INSTANCE.error(TAG, "executeDelete error!\n" + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L22
        r0 = true;
    L12:
        e = e;
        r11 = 0;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized Pair<Boolean, Integer> batchDeleteByLongValue(String r6, String r7, List<Long> r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "tableName");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r7, "deleteSQL");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r8, "arguments");     // Catch: Throwable -> L24
        SQLiteStatement r9 = getCachedStatement(r7);     // Catch: Throwable -> L24
        this.sqliteDatabaseManager.getDatabase().beginTransaction();     // Catch: Throwable -> L24
        boolean r10 = true;
        Iterator<Long> r11 = r8.iterator();     // Catch: Exception -> L14 Throwable -> L24
        int r1 = 0;
    L29:
    L12:
        e = e;
    L16:
        RuntimeLogger.INSTANCE.error(TAG, "batchInsertStringValue error!\n" + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L24
        boolean r12 = true;
    L17:
        this.sqliteDatabaseManager.getDatabase().endTransaction();     // Catch: Throwable -> L24
        if (r12 == false) goto L21;
        r10 = false;
    L21:
        Pair<Boolean, Integer> r13 = new Pair(Boolean.valueOf(r10), Integer.valueOf(r1));     // Catch: Throwable -> L24
        monitor-exit(this);
        return r13;
    L8:
        if (r11.hasNext() == false) goto L10;
        r9.bindLong(1, r11.next().longValue());     // Catch: Exception -> L12 Throwable -> L24
        r1 = r1 + r9.executeUpdateDelete();     // Catch: Exception -> L12 Throwable -> L24
        goto L29
    L10:
        this.sqliteDatabaseManager.getDatabase().setTransactionSuccessful();     // Catch: Exception -> L12 Throwable -> L24
        r12 = false;
    L14:
        e = e;
        r1 = 0;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized void setSQLiteDatabaseTraceCallback(final SQLiteTrace r3) {
        monitor-enter(this);
        if (r3 != null) goto L7;
        this.sqliteDatabaseManager.getDatabase().setTraceCallback(null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L7:
        this.sqliteDatabaseManager.getDatabase().setTraceCallback(new AnonymousClass1(r3));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
