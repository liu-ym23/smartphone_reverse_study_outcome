package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FtsTableInfo {
    private static final String[] FTS_OPTIONS = null;
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    static {
        FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    }

    public FtsTableInfo(String r1, Set<String> r2, String r3) {
        this.name = r1;
        this.columns = r2;
        this.options = parseOptions(r3);
    }

    public FtsTableInfo(String r1, Set<String> r2, Set<String> r3) {
        this.name = r1;
        this.columns = r2;
        this.options = r3;
    }

    @VisibleForTesting
    static Set<String> parseOptions(String r8) {
        if (r8.isEmpty() == true) goto L5;
        String r9 = r8.substring(r8.indexOf(40) + 1, r8.lastIndexOf(41));
        ArrayList r0 = new ArrayList();
        ArrayDeque r1 = new ArrayDeque();
        int r2 = -1;
        int r4 = 0;
    L8:
        if (r4 >= r9.length()) goto L40;
        char r5 = r9.charAt(r4);
        if (r5 == '\"') goto L34;
        if (r5 == '\'') goto L34;
        if (r5 == ',') goto L31;
        if (r5 == '[') goto L28;
        if (r5 == ']') goto L23;
        if (r5 == '`') goto L34;
    L39:
        r4 = r4 + 1;
        goto L8
    L23:
        if (r1.isEmpty() == true) goto L39;
        if (((Character) r1.peek()).charValue() != '[') goto L39;
    L38:
        r1.pop();
        goto L39
    L28:
        if (r1.isEmpty() == false) goto L39;
    L35:
        r1.push(Character.valueOf(r5));
        goto L39
    L31:
        if (r1.isEmpty() == false) goto L39;
        r0.add(r9.substring(r2 + 1, r4).trim());
        r2 = r4;
    L34:
        if (r1.isEmpty() == true) goto L35;
        if (((Character) r1.peek()).charValue() != r5) goto L39;
    L40:
        r0.add(r9.substring(r2 + 1).trim());
        HashSet r10 = new HashSet();
        Iterator r3 = r0.iterator();
    L42:
        if (r3.hasNext() == false) goto L49;
        String r6 = (String) r3.next();
        String[] r7 = FTS_OPTIONS;
        int r11 = r7.length;
        int r12 = 0;
    L44:
        if (r12 >= r11) goto L42;
        if (r6.startsWith(r7[r12]) == false) goto L48;
        r10.add(r6);
    L48:
        r12 = r12 + 1;
        goto L44
    L49:
        return r10;
    L5:
        return new HashSet();
    }

    public static FtsTableInfo read(SupportSQLiteDatabase r2, String r3) {
        return new FtsTableInfo(r3, readColumns(r2, r3), readOptions(r2, r3));
    }

    private static Set<String> readColumns(SupportSQLiteDatabase r2, String r3) {
        Cursor r4 = r2.query("PRAGMA table_info(`" + r3 + "`)");
        HashSet r5 = new HashSet();
    L12:
        th = move-exception;
        r4.close();
        throw th;
    L4:
        if (r4.getColumnCount() <= 0) goto L10;
        int r0 = r4.getColumnIndex("name");     // Catch: Throwable -> L12
    L7:
        if (r4.moveToNext() == false) goto L10;
        r5.add(r4.getString(r0));     // Catch: Throwable -> L12
    L10:
        r4.close();
        return r5;
    }

    private static Set<String> readOptions(SupportSQLiteDatabase r2, String r3) {
        Cursor r4 = r2.query("SELECT * FROM sqlite_master WHERE `name` = '" + r3 + "'");
    L10:
        th = move-exception;
        r4.close();
        throw th;
    L4:
        if (r4.moveToFirst() == false) goto L7;
        String r5 = r4.getString(r4.getColumnIndexOrThrow("sql"));     // Catch: Throwable -> L10
    L8:
        r4.close();
        return parseOptions(r5);
    L7:
        r5 = "";
        goto L8
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L34:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L34;
        FtsTableInfo r6 = (FtsTableInfo) r5;
        String r2 = this.name;
        if (r2 == null) goto L16;
        if (r2.equals(r6.name) == false) goto L17;
    L18:
        Set<String> r3 = this.columns;
        if (r3 == null) goto L24;
        if (r3.equals(r6.columns) == false) goto L25;
    L26:
        Set<String> r4 = this.options;
        if (r4 == null) goto L30;
        return r4.equals(r6.options);
    L30:
        if (r6.options != null) goto L33;
        return true;
    L33:
        return false;
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
        Set<String> r4 = this.columns;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Set<String> r7 = this.options;
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
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + '}';
    }
}
