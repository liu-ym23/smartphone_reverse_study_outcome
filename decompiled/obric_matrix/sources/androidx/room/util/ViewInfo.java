package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewInfo {
    public final String name;
    public final String sql;

    public ViewInfo(String r1, String r2) {
        this.name = r1;
        this.sql = r2;
    }

    public static ViewInfo read(SupportSQLiteDatabase r2, String r3) {
        Cursor r4 = r2.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + r3 + "'");
    L11:
        th = move-exception;
        r4.close();
        throw th;
    L4:
        if (r4.moveToFirst() == false) goto L8;
        ViewInfo r5 = new ViewInfo(r4.getString(0), r4.getString(1));     // Catch: Throwable -> L11
        r4.close();
        return r5;
    L8:
        ViewInfo r0 = new ViewInfo(r3, null);     // Catch: Throwable -> L11
        r4.close();
        return r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L27:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L27;
        ViewInfo r6 = (ViewInfo) r5;
        String r2 = this.name;
        if (r2 == null) goto L16;
        if (r2.equals(r6.name) == false) goto L26;
    L17:
        String r4 = this.sql;
        if (r4 == null) goto L23;
        if (r4.equals(r6.sql) == false) goto L26;
        return true;
    L23:
        if (r6.sql != null) goto L26;
        return true;
    L26:
        return false;
    L16:
        if (r6.name != null) goto L26;
        goto L17
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.sql;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }
}
