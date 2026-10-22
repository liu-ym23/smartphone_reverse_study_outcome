package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.librarian.LibrarianImpl;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CursorUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a#\u0010\u0003\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001a/\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"copyAndClose", "Landroid/database/Cursor;", "c", "findColumnIndexBySuffix", "", "cursor", "name", "", "columnNames", "", "([Ljava/lang/String;Ljava/lang/String;)I", "getColumnIndex", "getColumnIndexOrThrow", "wrapMappedColumns", "mapping", "", "(Landroid/database/Cursor;[Ljava/lang/String;[I)Landroid/database/Cursor;", "useCursor", "R", "block", "Lkotlin/Function1;", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CursorUtil {
    private static final int findColumnIndexBySuffix(Cursor r0, String r1) {
        return -1;
    }

    public static final int getColumnIndex(Cursor r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "name");
        int r0 = r2.getColumnIndex(r3);
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = r2.getColumnIndex("`" + r3 + '`');
        if (r1 < 0) goto L9;
        return r1;
    L9:
        return findColumnIndexBySuffix(r2, r3);
    }

    public static final int getColumnIndexOrThrow(Cursor r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "name");
        int r0 = getColumnIndex(r10, r11);
        if (r0 < 0) goto L11;
        return r0;
    L11:
        String[] r12 = r10.getColumnNames();     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r12, "c.columnNames");     // Catch: Exception -> L7
        String r13 = ArraysKt.joinToString$default(r12, null, null, null, 0, null, null, 63, null);     // Catch: Exception -> L7
    L10:
        throw new IllegalArgumentException("column '" + r11 + "' does not exist. Available columns: " + r13);
    L7:
        e = move-exception;
        Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
        r13 = EnvironmentCompat.MEDIA_UNKNOWN;
        goto L10
    }

    public static final int findColumnIndexBySuffix(String[] r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "columnNames");
        Intrinsics.checkNotNullParameter(r13, "name");
        String r0 = LibrarianImpl.Constants.DOT + r13;
        String r1 = LibrarianImpl.Constants.DOT + r13 + '`';
        int r3 = r12.length;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r5 >= r3) goto L15;
        String r7 = r12[r5];
        int r8 = r6 + 1;
        if (r7.length() < (r13.length() + 2)) goto L14;
        if (StringsKt.endsWith$default(r7, r0, false, 2, null) == true) goto L8;
        if (r7.charAt(0) != '`') goto L14;
        if (StringsKt.endsWith$default(r7, r1, false, 2, null) == false) goto L14;
        return r6;
    L8:
        return r6;
    L14:
        r5 = r5 + 1;
        r6 = r8;
        goto L3
    L15:
        return -1;
    }

    public static final <R> R useCursor(Cursor r2, Function1<? super Cursor, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "block");
        Cursor r4 = r2;
        R r5 = r3.invoke(r4);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r4, null);
        InlineMarker.finallyEnd(1);
        return r5;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r4, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final Cursor wrapMappedColumns(final Cursor r2, final String[] r3, final int[] r4) {
        Intrinsics.checkNotNullParameter(r2, "cursor");
        Intrinsics.checkNotNullParameter(r3, "columnNames");
        Intrinsics.checkNotNullParameter(r4, "mapping");
        if (r3.length != r4.length) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return new AnonymousClass2(r2, r3, r4);
    L10:
        throw new IllegalStateException("Expected columnNames.length == mapping.length".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final Cursor copyAndClose(Cursor r9) {
        Intrinsics.checkNotNullParameter(r9, "c");
        Cursor r0 = r9;
        Cursor r1 = r0;     // Catch: Throwable -> L30
        MatrixCursor r2 = new MatrixCursor(r1.getColumnNames(), r1.getCount());     // Catch: Throwable -> L30
    L5:
        if (r1.moveToNext() == false) goto L28;
        Object[] r3 = new Object[r1.getColumnCount()];     // Catch: Throwable -> L30
        int r5 = r9.getColumnCount();     // Catch: Throwable -> L30
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L26;
        int r7 = r1.getType(r6);     // Catch: Throwable -> L30
        if (r7 != 0) goto L11;
        r3[r6] = null;     // Catch: Throwable -> L30
    L25:
        r6 = r6 + 1;     // Catch: Throwable -> L30
        goto L7
    L11:
        if (r7 != 1) goto L13;
        r3[r6] = Long.valueOf(r1.getLong(r6));     // Catch: Throwable -> L30
        goto L25
    L13:
        if (r7 != 2) goto L15;
        r3[r6] = Double.valueOf(r1.getDouble(r6));     // Catch: Throwable -> L30
        goto L25
    L15:
        if (r7 != 3) goto L17;
        r3[r6] = r1.getString(r6);     // Catch: Throwable -> L30
        goto L25
    L17:
        if (r7 != 4) goto L20;
        r3[r6] = r1.getBlob(r6);     // Catch: Throwable -> L30
        goto L25
    L20:
        throw new IllegalStateException();     // Catch: Throwable -> L30
    L26:
        r2.addRow(r3);     // Catch: Throwable -> L30
        goto L5
    L28:
        CloseableKt.closeFinally(r0, null);
        return r2;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }
}
