package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FtsTableInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/util/FtsTableInfo;", "", "name", "", "columns", "", "createSql", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V", "options", "(Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FtsTableInfo {
    public static final Companion Companion = null;
    private static final String[] FTS_OPTIONS = null;
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    /* JADX INFO: compiled from: FtsTableInfo.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/util/FtsTableInfo$Companion;", "", "()V", "FTS_OPTIONS", "", "", "[Ljava/lang/String;", "parseOptions", "", "createStatement", ProviderConstants.Sms.READ, "Landroidx/room/util/FtsTableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readColumns", "readOptions", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FtsTableInfo read(SupportSQLiteDatabase r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "database");
            Intrinsics.checkNotNullParameter(r3, "tableName");
            return new FtsTableInfo(r3, readColumns(r2, r3), readOptions(r2, r3));
        }

        private final Set<String> readColumns(SupportSQLiteDatabase r4, String r5) {
            Set r3 = SetsKt.createSetBuilder();
            Cursor r6 = r4.query("PRAGMA table_info(`" + r5 + "`)");
            Cursor r7 = r6;     // Catch: Throwable -> L12
            if (r7.getColumnCount() <= 0) goto L9;
            int r0 = r7.getColumnIndex("name");     // Catch: Throwable -> L12
        L7:
            if (r7.moveToNext() == false) goto L9;
            String r1 = r7.getString(r0);     // Catch: Throwable -> L12
            Intrinsics.checkNotNullExpressionValue(r1, "cursor.getString(nameIndex)");     // Catch: Throwable -> L12
            r3.add(r1);     // Catch: Throwable -> L12
        L9:
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L12
            CloseableKt.closeFinally(r6, null);
            return SetsKt.build(r3);
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            CloseableKt.closeFinally(r6, th);
            throw th;
        }

        private final Set<String> readOptions(SupportSQLiteDatabase r3, String r4) {
            Cursor r5 = r3.query("SELECT * FROM sqlite_master WHERE `name` = '" + r4 + '\'');
            Cursor r6 = r5;     // Catch: Throwable -> L10
            if (r6.moveToFirst() == false) goto L7;
            String r7 = r6.getString(r6.getColumnIndexOrThrow("sql"));     // Catch: Throwable -> L10
        L8:
            CloseableKt.closeFinally(r5, null);
            Intrinsics.checkNotNullExpressionValue(r7, "sql");
            return parseOptions(r7);
        L7:
            r7 = "";
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r5, th);
            throw th;
        }

        @JvmStatic
        public final Set<String> parseOptions(String r15) {
            Intrinsics.checkNotNullParameter(r15, "createStatement");
            String r14 = r15;
            if (r14.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            String r16 = r15.substring(StringsKt.indexOf$default(r14, '(', 0, false, 6, null) + 1, StringsKt.lastIndexOf$default(r14, ')', 0, false, 6, null));
            Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String…ing(startIndex, endIndex)");
            ArrayList r1 = new ArrayList();
            ArrayDeque r2 = new ArrayDeque();
            String r3 = r16;
            int r4 = -1;
            int r5 = 0;
            int r6 = 0;
        L11:
            if (r5 >= r3.length()) goto L72;
            char r8 = r3.charAt(r5);
            int r9 = r6 + 1;
            if (r8 != '\'') goto L16;
        L14:
            boolean r10 = true;
        L19:
            if (r10 == false) goto L22;
        L20:
            boolean r11 = true;
        L25:
            if (r11 == false) goto L36;
            if (r2.isEmpty() == false) goto L29;
            r2.push(Character.valueOf(r8));
        L71:
            r5 = r5 + 1;
            r6 = r9;
            goto L11
        L29:
            Character r7 = (Character) r2.peek();
            if (r7 == null) goto L71;
            if (r7.charValue() != r8) goto L71;
            r2.pop();
            goto L71
        L36:
            if (r8 != '[') goto L41;
            if (r2.isEmpty() == false) goto L71;
            r2.push(Character.valueOf(r8));
            goto L71
        L41:
            if (r8 != ']') goto L51;
            if (r2.isEmpty() == true) goto L71;
            Character r12 = (Character) r2.peek();
            if (r12 == null) goto L71;
            if (r12.charValue() != '[') goto L71;
            r2.pop();
            goto L71
        L51:
            if (r8 != ',') goto L71;
            if (r2.isEmpty() == false) goto L71;
            String r13 = r16.substring(r4 + 1, r6);
            Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
            String r17 = r13;
            int r18 = r17.length() - 1;
            int r19 = 0;
            boolean r110 = false;
        L55:
            if (r19 > r18) goto L70;
            if (r110 == true) goto L58;
            int r111 = r19;
        L60:
            if (Intrinsics.compare(r17.charAt(r111), 32) > 0) goto L62;
            boolean r112 = true;
        L63:
            if (r110 == false) goto L64;
            if (r112 == false) goto L70;
            r18 = r18 - 1;
            goto L55
        L64:
            if (r112 == false) goto L65;
            r19 = r19 + 1;
            goto L55
        L65:
            r110 = true;
            goto L55
        L62:
            r112 = false;
            goto L63
        L58:
            r111 = r18;
        L70:
            r1.add(r17.subSequence(r19, r18 + 1).toString());
            r4 = r6;
            goto L71
        L22:
            if (r8 == '`') goto L20;
            r11 = false;
            goto L25
        L16:
            if (r8 == '\"') goto L14;
            r10 = false;
            goto L19
        L72:
            String r113 = r16.substring(r4 + 1);
            Intrinsics.checkNotNullExpressionValue(r113, "this as java.lang.String).substring(startIndex)");
            r1.add(StringsKt.trim(r113).toString());
            ArrayList r114 = new ArrayList();
            Iterator r115 = r1.iterator();
        L74:
            if (r115.hasNext() == false) goto L85;
            Object r20 = r115.next();
            String r21 = (String) r20;
            String[] r22 = FtsTableInfo.access$getFTS_OPTIONS$cp();
            int r23 = r22.length;
            int r24 = 0;
        L76:
            if (r24 >= r23) goto L81;
            if (StringsKt.startsWith$default(r21, r22[r24], false, 2, null) == true) goto L79;
            r24 = r24 + 1;
            goto L76
        L79:
            boolean r25 = true;
        L82:
            if (r25 == false) goto L74;
            r114.add(r20);
            goto L74
        L81:
            r25 = false;
            goto L82
        L85:
            return CollectionsKt.toSet(r114);
        L8:
            return SetsKt.emptySet();
        L5:
            r0 = false;
            goto L6
        }
    }

    @JvmStatic
    public static final Set<String> parseOptions(String r1) {
        return Companion.parseOptions(r1);
    }

    @JvmStatic
    public static final FtsTableInfo read(SupportSQLiteDatabase r1, String r2) {
        return Companion.read(r1, r2);
    }

    public FtsTableInfo(String r2, Set<String> r3, Set<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "columns");
        Intrinsics.checkNotNullParameter(r4, "options");
        this.name = r2;
        this.columns = r3;
        this.options = r4;
    }

    public static final /* synthetic */ String[] access$getFTS_OPTIONS$cp() {
        return FTS_OPTIONS;
    }

    public FtsTableInfo(String r2, Set<String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "columns");
        Intrinsics.checkNotNullParameter(r4, "createSql");
        this(r2, r3, Companion.parseOptions(r4));
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof FtsTableInfo) == true) goto L8;
        return false;
    L8:
        FtsTableInfo r5 = (FtsTableInfo) r4;
        if (Intrinsics.areEqual(this.name, r5.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.columns, r5.columns) == true) goto L15;
        return false;
    L15:
        return Intrinsics.areEqual(this.options, r5.options);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    static {
        Companion = new Companion(null);
        FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    }
}
