package androidx.room.util;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TableInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0006\u0014\u0015\u0016\u0017\u0018\u0019B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/util/TableInfo;", "", "name", "", "columns", "", "Landroidx/room/util/TableInfo$Column;", "foreignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;)V", "indices", "Landroidx/room/util/TableInfo$Index;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Column", "Companion", "CreatedFrom", "ForeignKey", "ForeignKeyWithSequence", "Index", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public static final Companion Companion = null;
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    /* JADX INFO: compiled from: TableInfo.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0010\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/util/TableInfo$Column;", "", "name", "", "type", "notNull", "", "primaryKeyPosition", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "defaultValue", "createdFrom", "(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V", "affinity", "getAffinity$annotations", "()V", "isPrimaryKey", "()Z", "equals", "other", "findAffinity", "hashCode", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Column {
        public static final Companion Companion = null;
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        /* JADX INFO: compiled from: TableInfo.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\t"}, d2 = {"Landroidx/room/util/TableInfo$Column$Companion;", "", "()V", "containsSurroundingParenthesis", "", PerfConsts.KEY_CURRENT_GALVANIC, "", "defaultValueEquals", "other", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final boolean defaultValueEquals(String r3, String r4) {
                Intrinsics.checkNotNullParameter(r3, PerfConsts.KEY_CURRENT_GALVANIC);
                if (Intrinsics.areEqual(r3, r4) == false) goto L6;
                return true;
            L6:
                if (containsSurroundingParenthesis(r3) == false) goto L9;
                String r2 = r3.substring(1, r3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String…ing(startIndex, endIndex)");
                return Intrinsics.areEqual(StringsKt.trim(r2).toString(), r4);
            L9:
                return false;
            }

            private final boolean containsSurroundingParenthesis(String r9) {
                String r8 = r9;
                if (r8.length() != 0) goto L5;
                boolean r0 = true;
            L6:
                if (r0 == false) goto L8;
                return false;
            L8:
                int r1 = 0;
                int r3 = 0;
                int r4 = 0;
            L10:
                if (r1 >= r8.length()) goto L25;
                char r5 = r8.charAt(r1);
                int r6 = r4 + 1;
                if (r4 != 0) goto L15;
                if (r5 == '(') goto L15;
                return false;
            L15:
                if (r5 != '(') goto L18;
                r3 = r3 + 1;
            L24:
                r1 = r1 + 1;
                r4 = r6;
                goto L10
            L18:
                if (r5 != ')') goto L24;
                r3 = r3 - 1;
                if (r3 != 0) goto L24;
                if (r4 == (r9.length() - 1)) goto L24;
                return false;
            L25:
                if (r3 != 0) goto L28;
                return true;
            L28:
                return false;
            L5:
                r0 = false;
                goto L6
            }
        }

        static {
            Companion = new Companion(null);
        }

        @JvmStatic
        public static final boolean defaultValueEquals(String r1, String r2) {
            return Companion.defaultValueEquals(r1, r2);
        }

        public static /* synthetic */ void getAffinity$annotations() {
        }

        public Column(String r2, String r3, boolean r4, int r5, String r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "type");
            this.name = r2;
            this.type = r3;
            this.notNull = r4;
            this.primaryKeyPosition = r5;
            this.defaultValue = r6;
            this.createdFrom = r7;
            this.affinity = findAffinity(r3);
        }

        @Deprecated(message = "Use {@link Column#Column(String, String, boolean, int, String, int)} instead.")
        public Column(String r9, String r10, boolean r11, int r12) {
            Intrinsics.checkNotNullParameter(r9, "name");
            Intrinsics.checkNotNullParameter(r10, "type");
            this(r9, r10, r11, r12, null, 0);
        }

        private final int findAffinity(String r5) {
            if (r5 != null) goto L5;
            return 5;
        L5:
            Locale r0 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r0, "US");
            String r6 = r5.toUpperCase(r0);
            Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toUpperCase(locale)");
            String r7 = r6;
            if (StringsKt.contains$default(r7, "INT", false, 2, null) == false) goto L10;
            return 3;
        L10:
            if (StringsKt.contains$default(r7, "CHAR", false, 2, null) == false) goto L12;
        L30:
            return 2;
        L12:
            if (StringsKt.contains$default(r7, "CLOB", false, 2, null) == true) goto L30;
            if (StringsKt.contains$default(r7, "TEXT", false, 2, null) == true) goto L30;
            if (StringsKt.contains$default(r7, "BLOB", false, 2, null) == false) goto L20;
            return 5;
        L20:
            if (StringsKt.contains$default(r7, "REAL", false, 2, null) == false) goto L22;
            return 4;
        L22:
            if (StringsKt.contains$default(r7, "FLOA", false, 2, null) == false) goto L24;
            return 4;
        L24:
            if (StringsKt.contains$default(r7, "DOUB", false, 2, null) == true) goto L32;
            return 1;
        L32:
            return 4;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if ((r7 instanceof Column) == true) goto L9;
            return false;
        L9:
            if (this.primaryKeyPosition == ((Column) r7).primaryKeyPosition) goto L11;
            return false;
        L11:
            Column r8 = (Column) r7;
            if (Intrinsics.areEqual(this.name, r8.name) == true) goto L15;
            return false;
        L15:
            if (this.notNull == r8.notNull) goto L18;
            return false;
        L18:
            if (this.createdFrom != 1) goto L27;
            if (r8.createdFrom != 2) goto L27;
            String r1 = this.defaultValue;
            if (r1 == null) goto L27;
            if (Companion.defaultValueEquals(r1, r8.defaultValue) == true) goto L27;
            return false;
        L27:
            if (this.createdFrom == 2) goto L29;
        L35:
            int r2 = this.createdFrom;
            if (r2 == 0) goto L51;
            if (r2 != r8.createdFrom) goto L51;
            String r3 = this.defaultValue;
            if (r3 == null) goto L45;
            if (Companion.defaultValueEquals(r3, r8.defaultValue) == false) goto L46;
        L47:
            boolean r4 = false;
        L48:
            if (r4 == false) goto L51;
            return false;
        L46:
            r4 = true;
            goto L48
        L45:
            if (r8.defaultValue == null) goto L47;
        L51:
            if (this.affinity != r8.affinity) goto L54;
            return true;
        L54:
            return false;
        L29:
            if (r8.createdFrom != 1) goto L35;
            String r5 = r8.defaultValue;
            if (r5 == null) goto L35;
            if (Companion.defaultValueEquals(r5, this.defaultValue) == true) goto L35;
            return false;
        }

        public final boolean isPrimaryKey() {
            if (this.primaryKeyPosition <= 0) goto L5;
            return true;
        L5:
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

        public String toString() {
            StringBuilder r0 = new StringBuilder("Column{name='").append(this.name).append("', type='").append(this.type).append("', affinity='").append(this.affinity).append("', notNull=").append(this.notNull).append(", primaryKeyPosition=").append(this.primaryKeyPosition).append(", defaultValue='");
            String r2 = this.defaultValue;
            if (r2 != null) goto L6;
            r2 = "undefined";
        L6:
            return r0.append(r2).append("'}").toString();
        }
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/util/TableInfo$Companion;", "", "()V", "CREATED_FROM_DATABASE", "", "CREATED_FROM_ENTITY", "CREATED_FROM_UNKNOWN", ProviderConstants.Sms.READ, "Landroidx/room/util/TableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TableInfo read(SupportSQLiteDatabase r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "database");
            Intrinsics.checkNotNullParameter(r2, "tableName");
            return TableInfoKt.readTableInfo(r1, r2);
        }
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/util/TableInfo$CreatedFrom;", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CreatedFrom {
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKey;", "", "referenceTable", "", "onDelete", "onUpdate", "columnNames", "", "referenceColumnNames", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "equals", "", "other", "hashCode", "", "toString", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String r2, String r3, String r4, List<String> r5, List<String> r6) {
            Intrinsics.checkNotNullParameter(r2, "referenceTable");
            Intrinsics.checkNotNullParameter(r3, "onDelete");
            Intrinsics.checkNotNullParameter(r4, "onUpdate");
            Intrinsics.checkNotNullParameter(r5, "columnNames");
            Intrinsics.checkNotNullParameter(r6, "referenceColumnNames");
            this.referenceTable = r2;
            this.onDelete = r3;
            this.onUpdate = r4;
            this.columnNames = r5;
            this.referenceColumnNames = r6;
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof ForeignKey) == true) goto L8;
            return false;
        L8:
            ForeignKey r5 = (ForeignKey) r4;
            if (Intrinsics.areEqual(this.referenceTable, r5.referenceTable) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.onDelete, r5.onDelete) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.onUpdate, r5.onUpdate) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.columnNames, r5.columnNames) == true) goto L21;
            return false;
        L21:
            return Intrinsics.areEqual(this.referenceColumnNames, r5.referenceColumnNames);
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "", SlardarConfigConsts.CONFIG_ID, "", "sequence", "from", "", "to", "(IILjava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getId", "()I", "getSequence", "getTo", "compareTo", "other", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        private final String from;
        private final int id;
        private final int sequence;
        private final String to;

        public ForeignKeyWithSequence(int r2, int r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "from");
            Intrinsics.checkNotNullParameter(r5, "to");
            this.id = r2;
            this.sequence = r3;
            this.from = r4;
            this.to = r5;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ForeignKeyWithSequence r1) {
            return compareTo2(r1);
        }

        public final int getId() {
            return this.id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        public final String getFrom() {
            return this.from;
        }

        public final String getTo() {
            return this.to;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ForeignKeyWithSequence r3) {
            Intrinsics.checkNotNullParameter(r3, "other");
            int r0 = this.id - r3.id;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return this.sequence - r3.sequence;
        }
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$Index;", "", "name", "", "unique", "", "columns", "", "(Ljava/lang/String;ZLjava/util/List;)V", "orders", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "equals", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Index {
        public static final Companion Companion = null;
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        /* JADX INFO: compiled from: TableInfo.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/util/TableInfo$Index$Companion;", "", "()V", "DEFAULT_PREFIX", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        public Index(String r2, boolean r3, List<String> r4, List<String> r5) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r4, "columns");
            Intrinsics.checkNotNullParameter(r5, "orders");
            this.name = r2;
            this.unique = r3;
            this.columns = r4;
            this.orders = r5;
            ArrayList r6 = r5;
            if (r6.isEmpty() == false) goto L8;
            int r7 = r4.size();
            ArrayList r8 = new ArrayList(r7);
            int r9 = 0;
        L5:
            if (r9 >= r7) goto L7;
            r8.add(androidx.room.Index.Order.ASC.name());
            r9 = r9 + 1;
            goto L5
        L7:
            r6 = r8;
        L8:
            this.orders = r6;
        }

        @Deprecated(message = "Use {@link #Index(String, boolean, List, List)}")
        public Index(String r5, boolean r6, List<String> r7) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r7, "columns");
            int r0 = r7.size();
            ArrayList r1 = new ArrayList(r0);
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r1.add(androidx.room.Index.Order.ASC.name());
            r2 = r2 + 1;
            goto L3
        L5:
            this(r5, r6, r7, r1);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof Index) == true) goto L8;
            return false;
        L8:
            Index r7 = (Index) r6;
            if (this.unique == r7.unique) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.columns, r7.columns) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.orders, r7.orders) == true) goto L18;
            return false;
        L18:
            if (StringsKt.startsWith$default(this.name, DEFAULT_PREFIX, false, 2, null) == false) goto L21;
            return StringsKt.startsWith$default(r7.name, DEFAULT_PREFIX, false, 2, null);
        L21:
            return Intrinsics.areEqual(this.name, r7.name);
        }

        public int hashCode() {
            if (StringsKt.startsWith$default(this.name, DEFAULT_PREFIX, false, 2, null) == false) goto L5;
            int r0 = -1184239155;
        L7:
            return (((((r0 * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode()) * 31) + this.orders.hashCode();
        L5:
            r0 = this.name.hashCode();
            goto L7
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final TableInfo read(SupportSQLiteDatabase r1, String r2) {
        return Companion.read(r1, r2);
    }

    public TableInfo(String r2, Map<String, Column> r3, Set<ForeignKey> r4, Set<Index> r5) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "columns");
        Intrinsics.checkNotNullParameter(r4, "foreignKeys");
        this.name = r2;
        this.columns = r3;
        this.foreignKeys = r4;
        this.indices = r5;
    }

    public /* synthetic */ TableInfo(String r1, Map r2, Set r3, Set r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public TableInfo(String r2, Map<String, Column> r3, Set<ForeignKey> r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "columns");
        Intrinsics.checkNotNullParameter(r4, "foreignKeys");
        this(r2, r3, r4, SetsKt.emptySet());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TableInfo) == true) goto L8;
        return false;
    L8:
        TableInfo r6 = (TableInfo) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.columns, r6.columns) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.foreignKeys, r6.foreignKeys) == true) goto L17;
        return false;
    L17:
        Set<Index> r4 = this.indices;
        if (r4 == null) goto L24;
        Set<Index> r7 = r6.indices;
        if (r7 != null) goto L23;
        return true;
    L23:
        return Intrinsics.areEqual(r4, r7);
    L24:
        return true;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.foreignKeys.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }
}
