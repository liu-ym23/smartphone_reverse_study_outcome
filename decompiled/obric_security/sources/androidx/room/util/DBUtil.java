package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: DBUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"createCancellationSignal", "Landroid/os/CancellationSignal;", "dropFtsSyncTriggers", "", CloudControlInf.DB, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "foreignKeyCheck", "tableName", "", "processForeignKeyCheckFailure", "cursor", "Landroid/database/Cursor;", "query", "Landroidx/room/RoomDatabase;", "sqLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "maybeCopy", "", "signal", "readVersion", "", "databaseFile", "Ljava/io/File;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DBUtil {
    @Deprecated(message = "This is only used in the generated code and shouldn't be called directly.")
    public static final Cursor query(RoomDatabase r1, SupportSQLiteQuery r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        Intrinsics.checkNotNullParameter(r2, "sqLiteQuery");
        return query(r1, r2, r3, null);
    }

    public static final Cursor query(RoomDatabase r1, SupportSQLiteQuery r2, boolean r3, CancellationSignal r4) {
        Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        Intrinsics.checkNotNullParameter(r2, "sqLiteQuery");
        Cursor r5 = r1.query(r2, r4);
        if (r3 == true) goto L5;
        return r5;
    L5:
        if ((r5 instanceof AbstractWindowedCursor) == false) goto L14;
        AbstractWindowedCursor r6 = (AbstractWindowedCursor) r5;
        int r7 = r6.getCount();
        if (r6.hasWindow() == false) goto L9;
        int r8 = r6.getWindow().getNumRows();
    L10:
        if (r8 < r7) goto L12;
        return r5;
    L12:
        return CursorUtil.copyAndClose(r5);
    L9:
        r8 = r7;
        goto L10
    L14:
        return r5;
    }

    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase r6) {
        Intrinsics.checkNotNullParameter(r6, CloudControlInf.DB);
        List r0 = CollectionsKt.createListBuilder();
        Cursor r1 = r6.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        Cursor r2 = r1;     // Catch: Throwable -> L15
    L5:
        if (r2.moveToNext() == false) goto L7;
        r0.add(r2.getString(0));     // Catch: Throwable -> L15
        goto L5
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r1, null);
        Iterator r4 = CollectionsKt.build(r0).iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        String r5 = (String) r4.next();
        Intrinsics.checkNotNullExpressionValue(r5, "triggerName");
        if (StringsKt.startsWith$default(r5, "room_fts_content_sync_", false, 2, null) == false) goto L10;
        r6.execSQL("DROP TRIGGER IF EXISTS " + r5);
        goto L10
    L14:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    public static final void foreignKeyCheck(SupportSQLiteDatabase r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
        Intrinsics.checkNotNullParameter(r3, "tableName");
        Cursor r4 = r2.query("PRAGMA foreign_key_check(`" + r3 + "`)");
        Cursor r5 = r4;     // Catch: Throwable -> L10
        if (r5.getCount() > 0) goto L9;
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r4, null);
        return;
    L9:
        throw new SQLiteConstraintException(processForeignKeyCheckFailure(r5));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    public static final int readVersion(File r9) throws IOException {
        Intrinsics.checkNotNullParameter(r9, "databaseFile");
        FileChannel r10 = new FileInputStream(r9).getChannel();
        FileChannel r6 = r10;     // Catch: Throwable -> L10
        ByteBuffer r8 = ByteBuffer.allocate(4);     // Catch: Throwable -> L10
        r6.tryLock(60, 4, true);     // Catch: Throwable -> L10
        r6.position(60);     // Catch: Throwable -> L10
        if (r6.read(r8) != 4) goto L9;
        r8.rewind();     // Catch: Throwable -> L10
        int r0 = r8.getInt();     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r10, null);
        return r0;
    L9:
        throw new IOException("Bad database header, unable to read 4 bytes at offset 60");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    public static final CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    private static final String processForeignKeyCheckFailure(Cursor r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.getCount();
        LinkedHashMap r2 = new LinkedHashMap();
    L4:
        if (r6.moveToNext() == false) goto L11;
        if (r6.isFirst() == false) goto L8;
        r0.append("Foreign key violation(s) detected in '");
        r0.append(r6.getString(0)).append("'.\n");
    L8:
        String r3 = r6.getString(3);
        if (r2.containsKey(r3) == true) goto L4;
        Intrinsics.checkNotNullExpressionValue(r3, "constraintIndex");
        String r4 = r6.getString(2);
        Intrinsics.checkNotNullExpressionValue(r4, "cursor.getString(2)");
        r2.put(r3, r4);
        goto L4
    L11:
        r0.append("Number of different violations discovered: ");
        r0.append(r2.keySet().size()).append("\nNumber of rows in violation: ");
        r0.append(r1).append("\nViolation(s) detected in the following constraint(s):\n");
        Iterator r7 = r2.entrySet().iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r5 = (Map.Entry) r7.next();
        String r8 = (String) r5.getKey();
        String r9 = (String) r5.getValue();
        r0.append("\tParent Table = ");
        r0.append(r9);
        r0.append(", Foreign Key Constraint Index = ");
        r0.append(r8).append(IOUtils.LINE_SEPARATOR_UNIX);
        goto L13
    L15:
        String r10 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "StringBuilder().apply(builderAction).toString()");
        return r10;
    }
}
