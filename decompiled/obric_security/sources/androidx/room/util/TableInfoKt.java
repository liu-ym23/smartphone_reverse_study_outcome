package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TableInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0000¨\u0006\u0017"}, d2 = {"readColumns", "", "", "Landroidx/room/util/TableInfo$Column;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readForeignKeyFieldMappings", "", "Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "cursor", "Landroid/database/Cursor;", "readForeignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "readIndex", "Landroidx/room/util/TableInfo$Index;", "name", "unique", "", "readIndices", "readTableInfo", "Landroidx/room/util/TableInfo;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TableInfoKt {
    public static final TableInfo readTableInfo(SupportSQLiteDatabase r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "database");
        Intrinsics.checkNotNullParameter(r4, "tableName");
        return new TableInfo(r4, readColumns(r3, r4), readForeignKeys(r3, r4), readIndices(r3, r4));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase r17, String r18) {
        Cursor r1 = r17.query("PRAGMA foreign_key_list(`" + r18 + "`)");
        Cursor r0 = r1;     // Catch: Throwable -> L26
        int r2 = r0.getColumnIndex(SlardarConfigConsts.CONFIG_ID);     // Catch: Throwable -> L26
        int r3 = r0.getColumnIndex("seq");     // Catch: Throwable -> L26
        int r4 = r0.getColumnIndex("table");     // Catch: Throwable -> L26
        int r5 = r0.getColumnIndex("on_delete");     // Catch: Throwable -> L26
        int r6 = r0.getColumnIndex("on_update");     // Catch: Throwable -> L26
        List<TableInfo.ForeignKeyWithSequence> r7 = readForeignKeyFieldMappings(r0);     // Catch: Throwable -> L26
        r0.moveToPosition(-1);     // Catch: Throwable -> L26
        Set r8 = SetsKt.createSetBuilder();     // Catch: Throwable -> L26
    L5:
        if (r0.moveToNext() == false) goto L23;
        if (r0.getInt(r3) != 0) goto L5;
        int r9 = r0.getInt(r2);     // Catch: Throwable -> L26
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L26
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L26
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L26
        Iterator<T> r11 = r7.iterator();     // Catch: Throwable -> L26
    L11:
        if (r11.hasNext() == false) goto L18;
        Object r13 = r11.next();     // Catch: Throwable -> L26
        if (((TableInfo.ForeignKeyWithSequence) r13).getId() != r9) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == false) goto L11;
        r12.add(r13);     // Catch: Throwable -> L26
        goto L11
    L15:
        r14 = false;
        goto L16
    L18:
        Iterator r16 = r12.iterator();     // Catch: Throwable -> L26
    L20:
        if (r16.hasNext() == false) goto L22;
        TableInfo.ForeignKeyWithSequence r19 = (TableInfo.ForeignKeyWithSequence) r16.next();     // Catch: Throwable -> L26
        r15.add(r19.getFrom());     // Catch: Throwable -> L26
        r10.add(r19.getTo());     // Catch: Throwable -> L26
        goto L20
    L22:
        String r110 = r0.getString(r4);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullExpressionValue(r110, "cursor.getString(tableColumnIndex)");     // Catch: Throwable -> L26
        String r111 = r0.getString(r5);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullExpressionValue(r111, "cursor.getString(onDeleteColumnIndex)");     // Catch: Throwable -> L26
        String r112 = r0.getString(r6);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullExpressionValue(r112, "cursor.getString(onUpdateColumnIndex)");     // Catch: Throwable -> L26
        r8.add(new TableInfo.ForeignKey(r110, r111, r112, r15, r10));     // Catch: Throwable -> L26
        goto L5
    L23:
        Set<TableInfo.ForeignKey> r20 = SetsKt.build(r8);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r1, null);
        return r20;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor r11) {
        int r0 = r11.getColumnIndex(SlardarConfigConsts.CONFIG_ID);
        int r1 = r11.getColumnIndex("seq");
        int r2 = r11.getColumnIndex("from");
        int r3 = r11.getColumnIndex("to");
        List r4 = CollectionsKt.createListBuilder();
    L4:
        if (r11.moveToNext() == false) goto L7;
        int r6 = r11.getInt(r0);
        int r7 = r11.getInt(r1);
        String r8 = r11.getString(r2);
        Intrinsics.checkNotNullExpressionValue(r8, "cursor.getString(fromColumnIndex)");
        String r9 = r11.getString(r3);
        Intrinsics.checkNotNullExpressionValue(r9, "cursor.getString(toColumnIndex)");
        r4.add(new TableInfo.ForeignKeyWithSequence(r6, r7, r8, r9));
        goto L4
    L7:
        return CollectionsKt.sorted(CollectionsKt.build(r4));
    }

    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase r19, String r20) {
        Cursor r2 = r19.query("PRAGMA table_info(`" + r20 + "`)");
        Cursor r3 = r2;     // Catch: Throwable -> L19
        if (r3.getColumnCount() > 0) goto L8;
        Map<String, TableInfo.Column> r0 = MapsKt.emptyMap();     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r2, null);
        return r0;
    L8:
        int r4 = r3.getColumnIndex("name");     // Catch: Throwable -> L19
        int r6 = r3.getColumnIndex("type");     // Catch: Throwable -> L19
        int r7 = r3.getColumnIndex("notnull");     // Catch: Throwable -> L19
        int r8 = r3.getColumnIndex("pk");     // Catch: Throwable -> L19
        int r9 = r3.getColumnIndex("dflt_value");     // Catch: Throwable -> L19
        Map r10 = MapsKt.createMapBuilder();     // Catch: Throwable -> L19
    L10:
        if (r3.moveToNext() == false) goto L16;
        String r11 = r3.getString(r4);     // Catch: Throwable -> L19
        String r14 = r3.getString(r6);     // Catch: Throwable -> L19
        if (r3.getInt(r7) == 0) goto L14;
        boolean r12 = true;
    L15:
        int r16 = r3.getInt(r8);     // Catch: Throwable -> L19
        String r17 = r3.getString(r9);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r11, "name");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r14, "type");     // Catch: Throwable -> L19
        r10.put(r11, new TableInfo.Column(r11, r14, r12, r16, r17, 2));     // Catch: Throwable -> L19
        goto L10
    L14:
        r12 = false;
        goto L15
    L16:
        Map<String, TableInfo.Column> r1 = MapsKt.build(r10);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r2, null);
        return r1;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    private static final Set<TableInfo.Index> readIndices(SupportSQLiteDatabase r10, String r11) {
        Cursor r12 = r10.query("PRAGMA index_list(`" + r11 + "`)");
        Cursor r1 = r12;     // Catch: Throwable -> L28
        int r2 = r1.getColumnIndex("name");     // Catch: Throwable -> L28
        int r3 = r1.getColumnIndex("origin");     // Catch: Throwable -> L28
        int r4 = r1.getColumnIndex("unique");     // Catch: Throwable -> L28
        if (r2 == (-1)) goto L26;
        if (r3 == (-1)) goto L26;
        if (r4 == (-1)) goto L26;
        Set r5 = SetsKt.createSetBuilder();     // Catch: Throwable -> L28
    L10:
        if (r1.moveToNext() == false) goto L23;
        if (Intrinsics.areEqual("c", r1.getString(r3)) == false) goto L10;
        String r7 = r1.getString(r2);     // Catch: Throwable -> L28
        boolean r9 = true;
        if (r1.getInt(r4) == 1) goto L18;
        r9 = false;
    L18:
        Intrinsics.checkNotNullExpressionValue(r7, "name");     // Catch: Throwable -> L28
        TableInfo.Index r8 = readIndex(r10, r7, r9);     // Catch: Throwable -> L28
        if (r8 == null) goto L20;
        r5.add(r8);     // Catch: Throwable -> L28
        goto L10
    L20:
        CloseableKt.closeFinally(r12, null);
        return null;
    L23:
        Set<TableInfo.Index> r13 = SetsKt.build(r5);     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r12, null);
        return r13;
    L26:
        CloseableKt.closeFinally(r12, null);
        return null;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    private static final TableInfo.Index readIndex(SupportSQLiteDatabase r16, String r17, boolean r18) {
        Cursor r1 = r16.query("PRAGMA index_xinfo(`" + r17 + "`)");
        Cursor r2 = r1;     // Catch: Throwable -> L25
        int r3 = r2.getColumnIndex("seqno");     // Catch: Throwable -> L25
        int r4 = r2.getColumnIndex("cid");     // Catch: Throwable -> L25
        int r5 = r2.getColumnIndex("name");     // Catch: Throwable -> L25
        int r6 = r2.getColumnIndex("desc");     // Catch: Throwable -> L25
        if (r3 == (-1)) goto L23;
        if (r4 == (-1)) goto L23;
        if (r5 == (-1)) goto L23;
        if (r6 == (-1)) goto L23;
        TreeMap r8 = new TreeMap();     // Catch: Throwable -> L25
        TreeMap r9 = new TreeMap();     // Catch: Throwable -> L25
    L11:
        if (r2.moveToNext() == false) goto L20;
        if (r2.getInt(r4) < 0) goto L11;
        int r10 = r2.getInt(r3);     // Catch: Throwable -> L25
        String r11 = r2.getString(r5);     // Catch: Throwable -> L25
        if (r2.getInt(r6) <= 0) goto L18;
        String r12 = "DESC";
    L19:
        Integer r13 = Integer.valueOf(r10);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r11, "columnName");     // Catch: Throwable -> L25
        r8.put(r13, r11);     // Catch: Throwable -> L25
        r9.put(Integer.valueOf(r10), r12);     // Catch: Throwable -> L25
        goto L11
    L18:
        r12 = "ASC";
        goto L19
    L20:
        Collection r7 = r8.values();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r7, "columnsMap.values");     // Catch: Throwable -> L25
        List r14 = CollectionsKt.toList(r7);     // Catch: Throwable -> L25
        Collection r15 = r9.values();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r15, "ordersMap.values");     // Catch: Throwable -> L25
        TableInfo.Index r19 = new TableInfo.Index(r17, r18, r14, CollectionsKt.toList(r15));     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r1, null);
        return r19;
    L23:
        CloseableKt.closeFinally(r1, null);
        return null;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }
}
