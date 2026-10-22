package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DBUtil {
    private DBUtil() {
    }

    @Nullable
    public static CancellationSignal createCancellationSignal() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return new CancellationSignal();
    }

    public static void dropFtsSyncTriggers(SupportSQLiteDatabase r4) {
        ArrayList r0 = new ArrayList();
        Cursor r1 = r4.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
    L17:
    L14:
        th = move-exception;
        r1.close();
        throw th;
    L4:
        if (r1.moveToNext() == false) goto L7;
        r0.add(r1.getString(0));     // Catch: Throwable -> L14
        goto L17
    L7:
        r1.close();
        Iterator r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) r2.next();
        if (r3.startsWith("room_fts_content_sync_") == false) goto L9;
        r4.execSQL("DROP TRIGGER IF EXISTS " + r3);
        goto L9
    }

    @NonNull
    @Deprecated
    public static Cursor query(RoomDatabase r1, SupportSQLiteQuery r2, boolean r3) {
        return query(r1, r2, r3, null);
    }

    @NonNull
    public static Cursor query(@NonNull RoomDatabase r2, @NonNull SupportSQLiteQuery r3, boolean r4, @Nullable CancellationSignal r5) {
        Cursor r6 = r2.query(r3, r5);
        if (r4 == true) goto L5;
        return r6;
    L5:
        if ((r6 instanceof AbstractWindowedCursor) == false) goto L16;
        AbstractWindowedCursor r7 = (AbstractWindowedCursor) r6;
        int r8 = r7.getCount();
        if (r7.hasWindow() == false) goto L9;
        int r9 = r7.getWindow().getNumRows();
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r9 < r8) goto L14;
        return r6;
    L14:
        return CursorUtil.copyAndClose(r7);
    L9:
        r9 = r8;
        goto L11
    L16:
        return r6;
    }

    public static int readVersion(@NonNull File r10) {
        FileChannel r1 = null;
        ByteBuffer r2 = ByteBuffer.allocate(4);     // Catch: Throwable -> L11
        FileChannel r3 = new FileInputStream(r10).getChannel();     // Catch: Throwable -> L11
        r3.tryLock(60, 4, true);     // Catch: Throwable -> L11
        r3.position(60);     // Catch: Throwable -> L11
        if (r3.read(r2) != 4) goto L10;
        r2.rewind();     // Catch: Throwable -> L11
        int r11 = r2.getInt();     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        r3.close();
    L8:
        return r11;
    L10:
        throw new IOException("Bad database header, unable to read 4 bytes at offset 60");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (0 == 0) goto L14;
        r1.close();
    L14:
        throw th;
    }
}
