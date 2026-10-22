package com.tencent.wcdb;

import android.util.Pair;
import com.bytedance.librarian.LibrarianImpl;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseConfiguration;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private static final String[] SUFFIX_TO_BACKUP = null;
    private static final String TAG = "WCDB.DefaultDatabaseErrorHandler";
    private final boolean mNoCorruptionBackup;

    public DefaultDatabaseErrorHandler() {
        this.mNoCorruptionBackup = false;
    }

    public DefaultDatabaseErrorHandler(boolean r1) {
        this.mNoCorruptionBackup = r1;
    }

    @Override // com.tencent.wcdb.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase r3) {
        Log.e(TAG, "Corruption reported by sqlite on database: " + r3.getPath());
        if (r3.isOpen() == true) goto L33;
        deleteDatabaseFile(r3.getPath());
        return;
    L33:
        List<Pair<String, String>> r0 = r3.getAttachedDbs();     // Catch: SQLiteException -> L8
    L9:
        SQLiteTrace r1 = r3.getTraceCallback();
        if (r1 == null) goto L35;
        r1.onDatabaseCorrupted(r3);
    L35:
        r3.close();     // Catch: Throwable -> L19 SQLiteException -> L27
        if (r0 == null) goto L18;
        Iterator<Pair<String, String>> r4 = r0.iterator();
    L16:
        if (r4.hasNext() == false) goto L40;
        deleteDatabaseFile((String) r4.next().second);
        goto L16
    L40:
        return;
    L18:
        deleteDatabaseFile(r3.getPath());
        return;
    L27:
        if (r0 == null) goto L18;
        Iterator<Pair<String, String>> r5 = r0.iterator();
    L30:
        if (r5.hasNext() == false) goto L41;
        deleteDatabaseFile((String) r5.next().second);
        goto L30
    L41:
        return;
    L19:
        th = move-exception;
        if (r0 == null) goto L25;
        Iterator<Pair<String, String>> r6 = r0.iterator();
    L23:
        if (r6.hasNext() == false) goto L26;
        deleteDatabaseFile((String) r6.next().second);
    L26:
        throw th;
    L25:
        deleteDatabaseFile(r3.getPath());
    L8:
        r0 = null;
        goto L9
    }

    static {
        SUFFIX_TO_BACKUP = new String[]{"", "-journal", "-wal", ".sm", ".bak", "-vfslog", "-vfslo1"};
    }

    private void deleteDatabaseFile(String r7) {
        if (r7.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH) == false) goto L5;
        return;
    L5:
        if (r7.trim().length() == 0) goto L21;
        Log.e(TAG, "Remove database file: " + r7);
        int r0 = 0;
        if (this.mNoCorruptionBackup == true) goto L15;
        File r6 = new File(r7);
        File r2 = new File(r6.getParentFile(), "corrupted");
        if (r2.mkdirs() == true) goto L12;
        Log.e(TAG, "Could not create directory for corrupted database. Corruption backup may be unavailable.");
    L12:
        String r8 = r2.getPath() + LibrarianImpl.Constants.SEPARATOR + r6.getName();
        String[] r1 = SUFFIX_TO_BACKUP;
        int r3 = r1.length;
    L13:
        if (r0 >= r3) goto L22;
        String r4 = r1[r0];
        moveOrDeleteFile(r7 + r4, r8 + r4);
        r0 = r0 + 1;
        goto L13
    L22:
        return;
    L15:
        String[] r9 = SUFFIX_TO_BACKUP;
        int r5 = r9.length;
    L16:
        if (r0 >= r5) goto L23;
        deleteFile(r7 + r9[r0]);
        r0 = r0 + 1;
        goto L16
    L23:
        return;
    }

    private static boolean moveOrDeleteFile(String r1, String r2) {
        File r0 = new File(r1);
        boolean r3 = r0.renameTo(new File(r2));
        if (r3 == true) goto L5;
        r0.delete();
    L5:
        return r3;
    }

    private static boolean deleteFile(String r1) {
        return new File(r1).delete();
    }
}
