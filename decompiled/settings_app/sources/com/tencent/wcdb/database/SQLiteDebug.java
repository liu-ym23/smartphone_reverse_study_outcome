package com.tencent.wcdb.database;

import android.util.Printer;
import com.bytedance.librarian.LibrarianImpl;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteDebug {
    private static final String TAG = "WCDB.SQLiteDebug";
    private static volatile int sLastErrorLine;
    private static volatile ArrayList<IOTraceStats> sLastIOTraceStats;

    public static class DbStats {
        public String cache;
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String r5, long r6, long r8, int r10, int r11, int r12, int r13) {
            this.dbName = r5;
            this.pageSize = r8 / 1024;
            this.dbSize = (r6 * r8) / 1024;
            this.lookaside = r10;
            this.cache = r11 + LibrarianImpl.Constants.SEPARATOR + r12 + LibrarianImpl.Constants.SEPARATOR + r13;
        }
    }

    public static class IOTraceStats {
        public String dbName;
        public String journalMode;
        public long lastJournalReadOffset;
        public byte[] lastJournalReadPage;
        public long lastJournalWriteOffset;
        public byte[] lastJournalWritePage;
        public long lastReadOffset;
        public byte[] lastReadPage;
        public long lastWriteOffset;
        public byte[] lastWritePage;
        public long pageCount;
        public long pageSize;
        public String path;

        public IOTraceStats() {
        }

        public String toString() {
            return String.format("[%s | %s] pageSize: %d, pageCount: %d, journal: %s, lastRead: %d, lastWrite: %d, lastJournalRead: %d, lastJournalWrite: %d", new Object[]{this.dbName, this.path, Long.valueOf(this.pageSize), Long.valueOf(this.pageCount), this.journalMode, Long.valueOf(this.lastReadOffset), Long.valueOf(this.lastWriteOffset), Long.valueOf(this.lastJournalReadOffset), Long.valueOf(this.lastJournalWriteOffset)});
        }
    }

    public static class PagerStats {
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;

        public PagerStats() {
        }
    }

    private static native void nativeGetIOTraceStats(long r0, ArrayList<IOTraceStats> r2);

    private static native int nativeGetLastErrorLine();

    private static native void nativeGetPagerStats(PagerStats r0);

    private static native void nativeSetIOTraceFlags(int r0);

    public static final boolean shouldLogSlowQuery(long r2) {
        if (r2 <= 300) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        SQLiteGlobal.loadLib();
    }

    private SQLiteDebug() {
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats r0 = new PagerStats();
        nativeGetPagerStats(r0);
        r0.dbStats = SQLiteDatabase.getDbStats();
        return r0;
    }

    public static void setIOTraceFlags(int r0) {
        nativeSetIOTraceFlags(r0);
    }

    public static int getLastErrorLine() {
        return sLastErrorLine;
    }

    public static ArrayList<IOTraceStats> getLastIOTraceStats() {
        return sLastIOTraceStats;
    }

    static void collectLastIOTraceStats(SQLiteConnection r6) {
        sLastErrorLine = nativeGetLastErrorLine();     // Catch: RuntimeException -> L7
        ArrayList<IOTraceStats> r0 = new ArrayList();     // Catch: RuntimeException -> L7
        long r2 = r6.getNativeHandle(null);     // Catch: RuntimeException -> L7
        if (r2 == 0) goto L5;
        nativeGetIOTraceStats(r2, r0);     // Catch: RuntimeException -> L7
        r6.endNativeHandle(null);     // Catch: RuntimeException -> L7
    L5:
        sLastIOTraceStats = r0;     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "Cannot collect I/O trace statistics: " + e.getMessage());
    }

    static void collectLastIOTraceStats(SQLiteDatabase r5) {
        sLastErrorLine = nativeGetLastErrorLine();     // Catch: RuntimeException -> L7
        ArrayList<IOTraceStats> r0 = new ArrayList();     // Catch: RuntimeException -> L7
        long r1 = r5.acquireNativeConnectionHandle("collectIoStat", false, false);     // Catch: RuntimeException -> L7
        if (r1 == 0) goto L5;
        nativeGetIOTraceStats(r1, r0);     // Catch: RuntimeException -> L7
    L5:
        r5.releaseNativeConnection(r1, null);     // Catch: RuntimeException -> L7
        sLastIOTraceStats = r0;     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "Cannot collect I/O trace statistics: " + e.getMessage());
    }

    public static void dump(Printer r5, String[] r6) {
        int r0 = r6.length;
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        if (r6[r1].equals("-v") == false) goto L7;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        SQLiteDatabase.dumpAll(r5, r2);
    }
}
