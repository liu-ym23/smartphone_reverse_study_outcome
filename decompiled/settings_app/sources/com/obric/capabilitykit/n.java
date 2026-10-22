package com.obric.capabilitykit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.capabilitykit.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fJ&\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f0\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fJ\u000e\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001bJ\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010#\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0014H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityDBHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", CloudControlInf.DB, "Landroid/database/sqlite/SQLiteDatabase;", "kotlin.jvm.PlatformType", "convertActionType", "Lcom/obric/capabilitykit/entity/ActionType;", "value", "", "deleteBulkEntityHistory", "", "indexIds", "", "", "deleteEarliestEntityHistory", "entityId", "entityType", "", "actionType", "deleteEntityHistory", "indexId", "deleteMatchedEntityHistory", "", "getEarliestEntityHistory", "Lcom/obric/capabilitykit/entity/EntityHistoryDao;", "getUnprocessedEntityHistory", "insertBulkEntityHistory", "Lkotlin/Pair;", "daoList", "insertEntityHistory", "dao", "onCreate", "onUpgrade", "oldVersion", "newVersion", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class n extends SQLiteOpenHelper {
    public static final a b = null;
    private static final String c = "EntityDBHelper";
    private static final String d = "EntityHistory.db";
    private static final int e = 1;
    private static final String f = "EntityHistory";
    private static final String g = "id";
    private static final String h = "entity_id";
    private static final String i = "entity_data";
    private static final String j = "entity_type";
    private static final String k = "entity_action";
    private static n l;
    private final SQLiteDatabase a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityDBHelper$Companion;", "", "()V", "COLUMN_ACTION", "", "COLUMN_ENTITY_DATA", "COLUMN_ENTITY_ID", "COLUMN_ENTITY_TYPE", "COLUMN_ID", "DATABASE_NAME", "DATABASE_VERSION", "", "TABLE_NAME", "TAG", "instance", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "getInstance", "context", "Landroid/content/Context;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final n a(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            n r0 = n.a();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = n.a();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new n(r3, null);     // Catch: Throwable -> L10
            a r4 = n.b;     // Catch: Throwable -> L10
            n.a(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        b = new a(null);
    }

    private n(Context r4) {
        super(r4, d, null, 1);
        this.a = getWritableDatabase();
    }

    public /* synthetic */ n(Context r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private final m a(String r1) {
        return m.b.a(r1);
    }

    public static final /* synthetic */ n a() {
        return l;
    }

    public static final /* synthetic */ void a(n r0) {
        l = r0;
    }

    private final boolean a(long r6) {
        int r5 = this.a.delete(f, "id = ?", new String[]{String.valueOf(r6)});
        if (r5 > 0) goto L5;
        Logger.INSTANCE.e(c, "delete error: " + r6);
    L5:
        if (r5 <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    private final o b(String r22, int r23, String r24) {
        Cursor r1 = this.a.query(f, new String[]{"id", h, i, "entity_type", k}, "entity_id = ? AND entity_type = ? AND entity_action = ?", new String[]{r22, String.valueOf(r23), r24}, null, null, "id ASC", "1");
        if (r1.moveToFirst() == false) goto L7;
        String r2 = r1.getString(r1.getColumnIndexOrThrow(k));
        Intrinsics.checkNotNullExpressionValue(r2, "cursor.getString(cursor.…UMN_ACTION\n            ))");
        m r20 = a(r2);
        if (r20 == null) goto L7;
        long r15 = r1.getLong(r1.getColumnIndexOrThrow("id"));
        String r3 = r1.getString(r1.getColumnIndexOrThrow(h));
        Intrinsics.checkNotNullExpressionValue(r3, "cursor.getString(cursor.…rThrow(COLUMN_ENTITY_ID))");
        String r4 = r1.getString(r1.getColumnIndexOrThrow(i));
        Intrinsics.checkNotNullExpressionValue(r4, "cursor.getString(cursor.…hrow(COLUMN_ENTITY_DATA))");
        o r0 = new o(r15, r3, r4, r1.getInt(r1.getColumnIndexOrThrow("entity_type")), r20);
    L8:
        r1.close();
        return r0;
    L7:
        r0 = null;
        goto L8
    }

    public final void a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        this.a.delete(f, "entity_id = ? AND entity_type = ?", new String[]{r3, String.valueOf(r4)});
    }

    public final boolean a(o r5) {
        Intrinsics.checkNotNullParameter(r5, "dao");
        SQLiteDatabase r4 = getWritableDatabase();
        ContentValues r0 = new ContentValues();
        r0.put(h, r5.h());
        r0.put(i, r5.g());
        r0.put("entity_type", Integer.valueOf(r5.j()));
        r0.put(k, r5.f().b());
        long r1 = r4.insert(f, null, r0);
        if (r1 != (-1)) goto L5;
        Logger.INSTANCE.e(c, "insert error: " + r5);
    L5:
        if (r1 == (-1)) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean a(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        Intrinsics.checkNotNullParameter(r5, "actionType");
        o r6 = b(r3, r4, r5);
        if (r6 == null) goto L5;
        this.a.delete(f, "id = ?", new String[]{String.valueOf(r6.i())});
    L5:
        return true;
    }

    public final boolean a(List<Long> r5) {
        Intrinsics.checkNotNullParameter(r5, "indexIds");
        this.a.beginTransaction();
        Iterator<T> r6 = r5.iterator();     // Catch: Throwable -> L16
    L4:
        boolean r1 = true;
    L6:
        if (r6.hasNext() == false) goto L13;
        long r2 = ((Number) r6.next()).longValue();     // Catch: Throwable -> L16
        if (r1 == false) goto L12;
        if (a(r2) == true) goto L4;
    L12:
        r1 = false;
        goto L6
    L13:
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L16
        this.a.endTransaction();
        return r1;
    L16:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final List<o> b() {
        String r3 = "EntityHistory clear failed";
        ArrayList r6 = new ArrayList();
        Long r0 = null;
    L3:
        boolean r17 = false;
        if (r0 == null) goto L6;
        String[] r12 = {String.valueOf(r0.longValue())};
        String r11 = "id < ?";
    L7:
        SQLiteDatabase r8 = this.a;
        String[] r16 = {"id", h, i, "entity_type", k};
        String r22 = "entity_type";
        String r23 = i;
        String r18 = r3;
        Cursor r9 = r8.query(f, r16, r11, r12, null, null, "id DESC", "300");
        Long r10 = null;
    L44:
        if (r9.moveToNext() == false) goto L16;
        String r13 = r9.getString(r9.getColumnIndexOrThrow(k));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        Intrinsics.checkNotNullExpressionValue(r13, "cursor.getString(\n      …                        )");     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        m r30 = a(r13);     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        r10 = Long.valueOf(r9.getLong(r9.getColumnIndexOrThrow("id")));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        if (r30 == null) goto L14;
        long r25 = r10.longValue();     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        String r14 = r9.getString(r9.getColumnIndexOrThrow(h));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        Intrinsics.checkNotNullExpressionValue(r14, "cursor.getString(cursor.…rThrow(COLUMN_ENTITY_ID))");     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        String r15 = r23;
        String r19 = r9.getString(r9.getColumnIndexOrThrow(r15));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        Intrinsics.checkNotNullExpressionValue(r19, "cursor.getString(cursor.…hrow(COLUMN_ENTITY_DATA))");     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        String r110 = r22;
        r6.add(new o(r25, r14, r19, r9.getInt(r9.getColumnIndexOrThrow(r110)), r30));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
    L15:
        r23 = r15;
        r22 = r110;
        goto L44
    L14:
        r110 = r22;
        r15 = r23;
        goto L15
    L16:
        r9.close();
        r0 = r10;
        String r7 = r18;
    L32:
        if (r17 == true) goto L36;
        if (r0 == null) goto L36;
        r3 = r7;
    L36:
        return CollectionsKt.reversed(r6);
    L17:
        th = move-exception;
        r9.close();
        throw th;
    L19:
        e = move-exception;
        Logger r4 = Logger.INSTANCE;     // Catch: Throwable -> L17
        r4.w(c, "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L17
        Log.w(c, "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L17
        int r1 = this.a.delete(f, null, null);     // Catch: Throwable -> L17 Exception -> L25
        r4.w(c, "EntityHistory cleared, deleted=" + r1);     // Catch: Throwable -> L17 Exception -> L25
        Log.w(c, "EntityHistory cleared, deleted=" + r1);     // Catch: Throwable -> L17 Exception -> L25
        r7 = r18;
    L30:
        r6.clear();     // Catch: Throwable -> L17
        r9.close();
        r0 = r10;
        r17 = true;
    L25:
        e = e;
    L29:
        r7 = r18;
        Logger.INSTANCE.w(c, r7, e);     // Catch: Throwable -> L17
        Log.w(c, r7, e);     // Catch: Throwable -> L17
    L27:
        e = e;
        goto L29
    L6:
        r11 = null;
        r12 = null;
        goto L7
    }

    public final Pair<Boolean, List<o>> b(List<o> r7) {
        Intrinsics.checkNotNullParameter(r7, "daoList");
        ArrayList r0 = new ArrayList();
        this.a.beginTransaction();
        Iterator<T> r8 = r7.iterator();     // Catch: Throwable -> L20
    L5:
        if (r8.hasNext() == false) goto L17;
        o r1 = (o) r8.next();     // Catch: Throwable -> L20
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L20
        r2.put(h, r1.h());     // Catch: Throwable -> L20
        r2.put(i, r1.g());     // Catch: Throwable -> L20
        r2.put("entity_type", Integer.valueOf(r1.j()));     // Catch: Throwable -> L20
        r2.put(k, r1.f().b());     // Catch: Throwable -> L20
        if (this.a.insert(f, null, r2) == (-1)) goto L5;
        r0.add(r1);     // Catch: Throwable -> L20
        goto L5
    L17:
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L20
        this.a.endTransaction();
        return new Pair(Boolean.valueOf(!r0.isEmpty()), r0);
    L20:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        r1.execSQL(StringsKt.trimIndent("\n            CREATE TABLE EntityHistory (\n                id INTEGER PRIMARY KEY AUTOINCREMENT,\n                entity_id TEXT,\n                entity_data TEXT,\n                entity_type INTEGER,\n                entity_action TEXT\n            )\n        "));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, CloudControlInf.DB);
        Logger.INSTANCE.i(c, "oldVersion: " + r5 + "  newVersion:" + r6);
        if (r5 != r6) goto L5;
        return;
    L5:
        int r3 = r5;
    L6:
        if (r3 >= r6) goto L8;
        Logger.INSTANCE.i(c, "upgrade database form version " + r5 + " to version " + r6);
        r3 = r3 + 1;
        goto L6
    }
}
