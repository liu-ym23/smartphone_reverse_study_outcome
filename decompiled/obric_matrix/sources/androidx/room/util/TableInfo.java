package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.ColumnInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;

    @Nullable
    public final Set<Index> indices;
    public final String name;

    public static class Column {

        @ColumnInfo.SQLiteTypeAffinity
        public final int affinity;
        public final String defaultValue;
        private final int mCreatedFrom;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        @Deprecated
        public Column(String r8, String r9, boolean r10, int r11) {
            this(r8, r9, r10, r11, null, 0);
        }

        public Column(String r1, String r2, boolean r3, int r4, String r5, int r6) {
            this.name = r1;
            this.type = r2;
            this.notNull = r3;
            this.primaryKeyPosition = r4;
            this.affinity = findAffinity(r2);
            this.defaultValue = r5;
            this.mCreatedFrom = r6;
        }

        @ColumnInfo.SQLiteTypeAffinity
        private static int findAffinity(@Nullable String r2) {
            if (r2 != null) goto L5;
            return 5;
        L5:
            String r3 = r2.toUpperCase(Locale.US);
            if (r3.contains("INT") == false) goto L10;
            return 3;
        L10:
            if (r3.contains("CHAR") == false) goto L12;
            return 2;
        L12:
            if (r3.contains("CLOB") == false) goto L14;
            return 2;
        L14:
            if (r3.contains("TEXT") == false) goto L17;
            return 2;
        L17:
            if (r3.contains("BLOB") == false) goto L20;
            return 5;
        L20:
            if (r3.contains("REAL") == false) goto L22;
            return 4;
        L22:
            if (r3.contains("FLOA") == false) goto L24;
            return 4;
        L24:
            if (r3.contains("DOUB") == true) goto L33;
            return 1;
        L33:
            return 4;
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if (r6 != null) goto L8;
        L59:
            return false;
        L8:
            if (getClass() != r6.getClass()) goto L59;
            Column r7 = (Column) r6;
            if (Build.VERSION.SDK_INT < 20) goto L16;
            if (this.primaryKeyPosition == r7.primaryKeyPosition) goto L19;
            return false;
        L19:
            if (this.name.equals(r7.name) == true) goto L22;
            return false;
        L22:
            if (this.notNull == r7.notNull) goto L25;
            return false;
        L25:
            if (this.mCreatedFrom != 1) goto L34;
            if (r7.mCreatedFrom != 2) goto L34;
            String r2 = this.defaultValue;
            if (r2 == null) goto L34;
            if (r2.equals(r7.defaultValue) == true) goto L34;
            return false;
        L34:
            if (this.mCreatedFrom == 2) goto L36;
        L42:
            int r3 = this.mCreatedFrom;
            if (r3 == 0) goto L55;
            if (r3 != r7.mCreatedFrom) goto L55;
            String r4 = this.defaultValue;
            if (r4 == null) goto L52;
            if (r4.equals(r7.defaultValue) == true) goto L55;
        L53:
            return false;
        L52:
            if (r7.defaultValue != null) goto L53;
        L55:
            if (this.affinity != r7.affinity) goto L58;
            return true;
        L58:
            return false;
        L36:
            if (r7.mCreatedFrom != 1) goto L42;
            String r5 = r7.defaultValue;
            if (r5 == null) goto L42;
            if (r5.equals(this.defaultValue) == true) goto L42;
            return false;
        L16:
            if (isPrimaryKey() == r7.isPrimaryKey()) goto L19;
            return false;
        }

        public int hashCode() {
            int r0 = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.primaryKeyPosition;
        L5:
            r1 = 1237;
            goto L7
        }

        public boolean isPrimaryKey() {
            if (this.primaryKeyPosition <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "Column{name='" + this.name + "', type='" + this.type + "', affinity='" + this.affinity + "', notNull=" + this.notNull + ", primaryKeyPosition=" + this.primaryKeyPosition + ", defaultValue='" + this.defaultValue + "'}";
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ForeignKey {

        @NonNull
        public final List<String> columnNames;

        @NonNull
        public final String onDelete;

        @NonNull
        public final String onUpdate;

        @NonNull
        public final List<String> referenceColumnNames;

        @NonNull
        public final String referenceTable;

        public ForeignKey(@NonNull String r1, @NonNull String r2, @NonNull String r3, @NonNull List<String> r4, @NonNull List<String> r5) {
            this.referenceTable = r1;
            this.onDelete = r2;
            this.onUpdate = r3;
            this.columnNames = Collections.unmodifiableList(r4);
            this.referenceColumnNames = Collections.unmodifiableList(r5);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if (r4 != null) goto L8;
        L24:
            return false;
        L8:
            if (getClass() != r4.getClass()) goto L24;
            ForeignKey r5 = (ForeignKey) r4;
            if (this.referenceTable.equals(r5.referenceTable) == true) goto L14;
            return false;
        L14:
            if (this.onDelete.equals(r5.onDelete) == true) goto L17;
            return false;
        L17:
            if (this.onUpdate.equals(r5.onUpdate) == true) goto L20;
            return false;
        L20:
            if (this.columnNames.equals(r5.columnNames) == true) goto L23;
            return false;
        L23:
            return this.referenceColumnNames.equals(r5.referenceColumnNames);
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + "', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        final String mFrom;
        final int mId;
        final int mSequence;
        final String mTo;

        ForeignKeyWithSequence(int r1, int r2, String r3, String r4) {
            this.mId = r1;
            this.mSequence = r2;
            this.mFrom = r3;
            this.mTo = r4;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(@NonNull ForeignKeyWithSequence r3) {
            int r0 = this.mId - r3.mId;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return this.mSequence - r3.mSequence;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(@NonNull ForeignKeyWithSequence r1) {
            return compareTo2(r1);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class Index {
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public final boolean unique;

        public Index(String r1, boolean r2, List<String> r3) {
            this.name = r1;
            this.unique = r2;
            this.columns = r3;
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if (r4 != null) goto L8;
        L22:
            return false;
        L8:
            if (getClass() != r4.getClass()) goto L22;
            Index r5 = (Index) r4;
            if (this.unique == r5.unique) goto L14;
            return false;
        L14:
            if (this.columns.equals(r5.columns) == true) goto L17;
            return false;
        L17:
            if (this.name.startsWith(DEFAULT_PREFIX) == false) goto L21;
            return r5.name.startsWith(DEFAULT_PREFIX);
        L21:
            return this.name.equals(r5.name);
        }

        public int hashCode() {
            if (this.name.startsWith(DEFAULT_PREFIX) == false) goto L5;
            int r0 = -1184239155;
        L7:
            return (((r0 * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode();
        L5:
            r0 = this.name.hashCode();
            goto L7
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + '}';
        }
    }

    public TableInfo(String r2, Map<String, Column> r3, Set<ForeignKey> r4) {
        this(r2, r3, r4, Collections.emptySet());
    }

    public TableInfo(String r1, Map<String, Column> r2, Set<ForeignKey> r3, Set<Index> r4) {
        this.name = r1;
        this.columns = Collections.unmodifiableMap(r2);
        this.foreignKeys = Collections.unmodifiableSet(r3);
        if (r4 != null) goto L5;
        Set<Index> r5 = null;
    L6:
        this.indices = r5;
        return;
    L5:
        r5 = Collections.unmodifiableSet(r4);
        goto L6
    }

    public static TableInfo read(SupportSQLiteDatabase r3, String r4) {
        return new TableInfo(r4, readColumns(r3, r4), readForeignKeys(r3, r4), readIndices(r3, r4));
    }

    private static Map<String, Column> readColumns(SupportSQLiteDatabase r14, String r15) {
        Cursor r16 = r14.query("PRAGMA table_info(`" + r15 + "`)");
        HashMap r17 = new HashMap();
    L16:
        th = move-exception;
        r16.close();
        throw th;
    L4:
        if (r16.getColumnCount() <= 0) goto L14;
        int r0 = r16.getColumnIndex("name");     // Catch: Throwable -> L16
        int r1 = r16.getColumnIndex(WsConstants.KEY_CONNECTION_TYPE);     // Catch: Throwable -> L16
        int r2 = r16.getColumnIndex("notnull");     // Catch: Throwable -> L16
        int r3 = r16.getColumnIndex("pk");     // Catch: Throwable -> L16
        int r4 = r16.getColumnIndex("dflt_value");     // Catch: Throwable -> L16
    L7:
        if (r16.moveToNext() == false) goto L14;
        String r5 = r16.getString(r0);     // Catch: Throwable -> L16
        String r8 = r16.getString(r1);     // Catch: Throwable -> L16
        if (r16.getInt(r2) == 0) goto L11;
        boolean r6 = true;
    L12:
        r17.put(r5, new Column(r5, r8, r6, r16.getInt(r3), r16.getString(r4), 2));     // Catch: Throwable -> L16
        goto L7
    L11:
        r6 = false;
    L14:
        r16.close();
        return r17;
    }

    private static List<ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor r12) {
        int r0 = r12.getColumnIndex("id");
        int r1 = r12.getColumnIndex("seq");
        int r2 = r12.getColumnIndex(TypedValues.TransitionType.S_FROM);
        int r3 = r12.getColumnIndex(TypedValues.TransitionType.S_TO);
        int r4 = r12.getCount();
        ArrayList r5 = new ArrayList();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L5;
        r12.moveToPosition(r6);
        r5.add(new ForeignKeyWithSequence(r12.getInt(r0), r12.getInt(r1), r12.getString(r2), r12.getString(r3)));
        r6 = r6 + 1;
        goto L3
    L5:
        Collections.sort(r5);
        return r5;
    }

    private static Set<ForeignKey> readForeignKeys(SupportSQLiteDatabase r18, String r19) {
        HashSet r0 = new HashSet();
        Cursor r1 = r18.query("PRAGMA foreign_key_list(`" + r19 + "`)");
        int r2 = r1.getColumnIndex("id");     // Catch: Throwable -> L18
        int r3 = r1.getColumnIndex("seq");     // Catch: Throwable -> L18
        int r4 = r1.getColumnIndex("table");     // Catch: Throwable -> L18
        int r5 = r1.getColumnIndex("on_delete");     // Catch: Throwable -> L18
        int r6 = r1.getColumnIndex("on_update");     // Catch: Throwable -> L18
        List<ForeignKeyWithSequence> r7 = readForeignKeyFieldMappings(r1);     // Catch: Throwable -> L18
        int r8 = r1.getCount();     // Catch: Throwable -> L18
        int r9 = 0;
    L4:
        if (r9 >= r8) goto L16;
        r1.moveToPosition(r9);     // Catch: Throwable -> L18
        if (r1.getInt(r3) != 0) goto L15;
        int r10 = r1.getInt(r2);     // Catch: Throwable -> L18
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L18
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<ForeignKeyWithSequence> r11 = r7.iterator();     // Catch: Throwable -> L18
    L10:
        if (r11.hasNext() == false) goto L14;
        ForeignKeyWithSequence r12 = r11.next();     // Catch: Throwable -> L18
        if (r12.mId != r10) goto L10;
        r15.add(r12.mFrom);     // Catch: Throwable -> L18
        r14.add(r12.mTo);     // Catch: Throwable -> L18
        goto L10
    L14:
        r0.add(new ForeignKey(r1.getString(r4), r1.getString(r5), r1.getString(r6), r15, r14));     // Catch: Throwable -> L18
    L15:
        r9 = r9 + 1;
        goto L4
    L16:
        r1.close();
        return r0;
    L18:
        th = move-exception;
        r1.close();
        throw th;
    }

    @Nullable
    private static Index readIndex(SupportSQLiteDatabase r6, String r7, boolean r8) {
        Cursor r9 = r6.query("PRAGMA index_xinfo(`" + r7 + "`)");
        int r0 = r9.getColumnIndex("seqno");     // Catch: Throwable -> L20
        int r1 = r9.getColumnIndex("cid");     // Catch: Throwable -> L20
        int r2 = r9.getColumnIndex("name");     // Catch: Throwable -> L20
        if (r0 == (-1)) goto L18;
        if (r1 == (-1)) goto L18;
        if (r2 == (-1)) goto L18;
        TreeMap r3 = new TreeMap();     // Catch: Throwable -> L20
    L10:
        if (r9.moveToNext() == false) goto L15;
        if (r9.getInt(r1) < 0) goto L10;
        int r4 = r9.getInt(r0);     // Catch: Throwable -> L20
        r3.put(Integer.valueOf(r4), r9.getString(r2));     // Catch: Throwable -> L20
        goto L10
    L15:
        ArrayList r5 = new ArrayList(r3.size());     // Catch: Throwable -> L20
        r5.addAll(r3.values());     // Catch: Throwable -> L20
        Index r10 = new Index(r7, r8, r5);     // Catch: Throwable -> L20
        r9.close();
        return r10;
    L18:
        r9.close();
        return null;
    L20:
        th = move-exception;
        r9.close();
        throw th;
    }

    @Nullable
    private static Set<Index> readIndices(SupportSQLiteDatabase r8, String r9) {
        Cursor r10 = r8.query("PRAGMA index_list(`" + r9 + "`)");
        int r0 = r10.getColumnIndex("name");     // Catch: Throwable -> L28
        int r1 = r10.getColumnIndex("origin");     // Catch: Throwable -> L28
        int r2 = r10.getColumnIndex("unique");     // Catch: Throwable -> L28
        if (r0 == (-1)) goto L26;
        if (r1 == (-1)) goto L26;
        if (r2 == (-1)) goto L26;
        HashSet r4 = new HashSet();     // Catch: Throwable -> L28
    L10:
        if (r10.moveToNext() == false) goto L24;
        if ("c".equals(r10.getString(r1)) == false) goto L10;
        String r5 = r10.getString(r0);     // Catch: Throwable -> L28
        boolean r7 = true;
        if (r10.getInt(r2) == 1) goto L18;
        r7 = false;
    L18:
        Index r6 = readIndex(r8, r5, r7);     // Catch: Throwable -> L28
        if (r6 == null) goto L20;
        r4.add(r6);     // Catch: Throwable -> L28
        goto L10
    L20:
        r10.close();
        return null;
    L24:
        r10.close();
        return r4;
    L26:
        r10.close();
        return null;
    L28:
        th = move-exception;
        r10.close();
        throw th;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L42:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L42;
        TableInfo r6 = (TableInfo) r5;
        String r2 = this.name;
        if (r2 == null) goto L16;
        if (r2.equals(r6.name) == false) goto L17;
    L18:
        Map<String, Column> r3 = this.columns;
        if (r3 == null) goto L24;
        if (r3.equals(r6.columns) == false) goto L25;
    L26:
        Set<ForeignKey> r4 = this.foreignKeys;
        if (r4 == null) goto L32;
        if (r4.equals(r6.foreignKeys) == false) goto L33;
    L34:
        Set<Index> r7 = this.indices;
        if (r7 == null) goto L41;
        Set<Index> r8 = r6.indices;
        if (r8 == null) goto L41;
        return r7.equals(r8);
    L41:
        return true;
    L33:
        return false;
    L32:
        if (r6.foreignKeys == null) goto L34;
    L25:
        return false;
    L24:
        if (r6.columns == null) goto L26;
    L17:
        return false;
    L16:
        if (r6.name == null) goto L18;
        goto L17
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Column> r4 = this.columns;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Set<ForeignKey> r7 = this.foreignKeys;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }
}
