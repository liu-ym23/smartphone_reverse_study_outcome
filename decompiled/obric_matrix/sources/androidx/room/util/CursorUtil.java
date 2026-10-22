package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CursorUtil {
    private CursorUtil() {
    }

    @NonNull
    public static Cursor copyAndClose(@NonNull Cursor r5) {
        MatrixCursor r0 = new MatrixCursor(r5.getColumnNames(), r5.getCount());     // Catch: Throwable -> L30
    L4:
        if (r5.moveToNext() == false) goto L28;
        Object[] r1 = new Object[r5.getColumnCount()];     // Catch: Throwable -> L30
        int r2 = 0;
    L7:
        if (r2 >= r5.getColumnCount()) goto L26;
        int r3 = r5.getType(r2);     // Catch: Throwable -> L30
        if (r3 != 0) goto L11;
        r1[r2] = null;     // Catch: Throwable -> L30
    L25:
        r2 = r2 + 1;     // Catch: Throwable -> L30
        goto L7
    L11:
        if (r3 != 1) goto L13;
        r1[r2] = Long.valueOf(r5.getLong(r2));     // Catch: Throwable -> L30
        goto L25
    L13:
        if (r3 != 2) goto L15;
        r1[r2] = Double.valueOf(r5.getDouble(r2));     // Catch: Throwable -> L30
        goto L25
    L15:
        if (r3 != 3) goto L17;
        r1[r2] = r5.getString(r2);     // Catch: Throwable -> L30
        goto L25
    L17:
        if (r3 != 4) goto L20;
        r1[r2] = r5.getBlob(r2);     // Catch: Throwable -> L30
        goto L25
    L20:
        throw new IllegalStateException();     // Catch: Throwable -> L30
    L26:
        r0.addRow(r1);     // Catch: Throwable -> L30
        goto L4
    L28:
        r5.close();
        return r0;
    L30:
        th = move-exception;
        r5.close();
        throw th;
    }

    public static int getColumnIndex(@NonNull Cursor r2, @NonNull String r3) {
        int r0 = r2.getColumnIndex(r3);
        if (r0 < 0) goto L6;
        return r0;
    L6:
        return r2.getColumnIndex("`" + r3 + "`");
    }

    public static int getColumnIndexOrThrow(@NonNull Cursor r2, @NonNull String r3) {
        int r0 = r2.getColumnIndex(r3);
        if (r0 < 0) goto L6;
        return r0;
    L6:
        return r2.getColumnIndexOrThrow("`" + r3 + "`");
    }
}
