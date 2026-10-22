package com.tencent.wcdb.database;

import android.icu.text.DateFormat;
import android.os.Process;
import android.util.Pair;
import android.util.Printer;
import com.android.settings.utils.HanziToPinyin;
import com.android.vcard.VCardConstants;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.extension.SQLiteExtension;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.LruCache;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteConnection implements CancellationSignal.OnCancelListener {
    private static final boolean DEBUG = false;
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static final String[] HMAC_ALGO_MAPPING = null;
    private static final String[] PBKDF2_ALGO_MAPPING = null;
    private static final String TAG = "WCDB.SQLiteConnection";
    private static final Pattern TRIM_SQL_PATTERN = null;
    private StackTraceElement[] mAcquiredStack;
    private Thread mAcquiredThread;
    private int mAcquiredTid;
    private long mAcquiredTimestamp;
    private int mCancellationSignalAttachCount;
    private SQLiteCipherSpec mCipher;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final int mConnectionId;
    private long mConnectionPtr;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private int mNativeHandleCount;
    private Operation mNativeOperation;
    private boolean mOnlyAllowReadOnlyOperations;
    private byte[] mPassword;
    private final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    private final OperationLog mRecentOperations;

    /* JADX INFO: renamed from: com.tencent.wcdb.database.SQLiteConnection$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Operation {
        private static final SimpleDateFormat sDateFormat = null;
        ArrayList<Object> mBindArgs;
        int mCookie;
        long mEndTime;
        Exception mException;
        boolean mFinished;
        String mKind;
        String mSql;
        long mStartTime;
        int mTid;
        int mType;

        private Operation() {
        }

        /* synthetic */ Operation(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ String access$2000(Operation r0) {
            return r0.getFormattedStartTime();
        }

        static {
            sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        public void describe(StringBuilder r6, boolean r7) {
            r6.append(this.mKind);
            if (this.mFinished == false) goto L5;
            r6.append(" took ").append(this.mEndTime - this.mStartTime).append(DateFormat.MINUTE_SECOND);
        L6:
            r6.append(" - ").append(getStatus());
            if (this.mSql == null) goto L10;
            r6.append(", sql=\"").append(SQLiteConnection.access$1500(this.mSql)).append("\"");
        L10:
            if (this.mTid <= 0) goto L12;
            r6.append(", tid=").append(this.mTid);
        L12:
            if (r7 == false) goto L33;
            ArrayList<Object> r8 = this.mBindArgs;
            if (r8 == null) goto L33;
            if (r8.size() == 0) goto L33;
            r6.append(", bindArgs=[");
            int r9 = this.mBindArgs.size();
            int r0 = 0;
        L18:
            if (r0 >= r9) goto L32;
            Object r2 = this.mBindArgs.get(r0);
            if (r0 == 0) goto L22;
            r6.append(", ");
        L22:
            if (r2 != null) goto L25;
            r6.append("null");
        L31:
            r0 = r0 + 1;
            goto L18
        L25:
            if ((r2 instanceof byte[]) == false) goto L28;
            r6.append("<byte[]>");
            goto L31
        L28:
            if ((r2 instanceof String) == false) goto L30;
            r6.append("\"").append((String) r2).append("\"");
            goto L31
        L30:
            r6.append(r2);
            goto L31
        L32:
            r6.append("]");
        L33:
            Exception r10 = this.mException;
            if (r10 != null) goto L36;
            return;
        L36:
            if (r10.getMessage() == null) goto L45;
            r6.append(", exception=\"").append(this.mException.getMessage()).append("\"");
            return;
        L45:
            return;
        L5:
            r6.append(" started ").append(System.currentTimeMillis() - this.mStartTime).append("ms ago");
            goto L6
        }

        JSONObject dumpJSON(boolean r5) throws JSONException {
            JSONObject r6 = new JSONObject().put("start", this.mStartTime).put("kind", this.mKind);
            if (this.mFinished == false) goto L5;
            long r0 = this.mEndTime;
        L6:
            JSONObject r7 = r6.put("duration", r0 - this.mStartTime).put("status", getStatus()).putOpt("sql", this.mSql);
            int r1 = this.mTid;
            if (r1 <= 0) goto L9;
            Integer r2 = Integer.valueOf(r1);
        L11:
            return r7.putOpt("tid", r2).putOpt("exception", this.mException);
        L9:
            r2 = null;
            goto L11
        L5:
            r0 = System.currentTimeMillis();
            goto L6
        }

        private String getStatus() {
            if (this.mFinished == true) goto L7;
            return "running";
        L7:
            if (this.mException == null) goto L9;
            return "failed";
        L9:
            return "succeeded";
        }

        private String getFormattedStartTime() {
            return sDateFormat.format(new Date(this.mStartTime));
        }
    }

    private final class OperationLog {
        private static final int COOKIE_GENERATION_SHIFT = 8;
        private static final int COOKIE_INDEX_MASK = 255;
        private static final int MAX_RECENT_OPERATIONS = 20;
        private int mGeneration;
        private int mIndex;
        private final Operation[] mOperations;
        final /* synthetic */ SQLiteConnection this$0;

        private OperationLog(SQLiteConnection r1) {
            this.this$0 = r1;
            this.mOperations = new Operation[20];
        }

        /* synthetic */ OperationLog(SQLiteConnection r1, AnonymousClass1 r2) {
            this(r1);
        }

        Operation beginOperation(String r8, String r9, Object[] r10) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            int r1 = (this.mIndex + 1) % 20;     // Catch: Throwable -> L28
            Operation r2 = this.mOperations[r1];     // Catch: Throwable -> L28
            AnonymousClass1 r3 = null;
            int r4 = 0;
            if (r2 != null) goto L7;
            r2 = new Operation(r3);     // Catch: Throwable -> L28
            this.mOperations[r1] = r2;     // Catch: Throwable -> L28
        L10:
            r2.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L28
            r2.mKind = r8;     // Catch: Throwable -> L28
            r2.mSql = r9;     // Catch: Throwable -> L28
            if (r10 != null) goto L13;
        L25:
            r2.mCookie = newOperationCookieLocked(r1);     // Catch: Throwable -> L28
            r2.mTid = SQLiteConnection.access$1800(this.this$0);     // Catch: Throwable -> L28
            this.mIndex = r1;     // Catch: Throwable -> L28
            monitor-exit(r0);     // Catch: Throwable -> L28
            return r2;
        L13:
            if (r2.mBindArgs != null) goto L15;
            r2.mBindArgs = new ArrayList();     // Catch: Throwable -> L28
        L17:
            if (r4 >= r10.length) goto L25;
            Object r11 = r10[r4];     // Catch: Throwable -> L28
            if (r11 != null) goto L21;
        L23:
            r2.mBindArgs.add(r11);     // Catch: Throwable -> L28
        L24:
            r4 = r4 + 1;     // Catch: Throwable -> L28
            goto L17
        L21:
            if ((r11 instanceof byte[]) == false) goto L23;
            r2.mBindArgs.add(SQLiteConnection.access$1700());     // Catch: Throwable -> L28
            goto L24
        L15:
            r2.mBindArgs.clear();     // Catch: Throwable -> L28
            goto L17
        L7:
            r2.mFinished = false;     // Catch: Throwable -> L28
            r2.mException = null;     // Catch: Throwable -> L28
            if (r2.mBindArgs == null) goto L10;
            r2.mBindArgs.clear();     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        }

        void failOperation(int r2, Exception r3) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            Operation r1 = getOperationLocked(r2);     // Catch: Throwable -> L9
            if (r1 == null) goto L7;
            r1.mException = r3;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        void endOperation(int r9) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            Operation r10 = getOperationLocked(r9);     // Catch: Throwable -> L13
            if (endOperationDeferLogLocked(r10) == false) goto L7;
            logOperationLocked(r10, null);     // Catch: Throwable -> L13
        L7:
            String r1 = r10.mSql;     // Catch: Throwable -> L13
            String r2 = r10.mKind;     // Catch: Throwable -> L13
            int r3 = r10.mType;     // Catch: Throwable -> L13
            long r4 = r10.mEndTime - r10.mStartTime;     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            if ("prepare".equals(r2) == true) goto L18;
            SQLiteConnection.access$1900(this.this$0).traceExecute(r1, r3, r4);
            return;
        L18:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        boolean endOperationDeferLog(int r10) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            Operation r11 = getOperationLocked(r10);     // Catch: Throwable -> L15
            if (r11 != null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L15
            return false;
        L9:
            boolean r1 = endOperationDeferLogLocked(r11);     // Catch: Throwable -> L15
            String r2 = r11.mSql;     // Catch: Throwable -> L15
            String r3 = r11.mKind;     // Catch: Throwable -> L15
            int r4 = r11.mType;     // Catch: Throwable -> L15
            long r5 = r11.mEndTime - r11.mStartTime;     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            if ("prepare".equals(r3) == true) goto L14;
            SQLiteConnection.access$1900(this.this$0).traceExecute(r2, r4, r5);
        L14:
            return r1;
        L15:
            th = move-exception;
            throw th;
        }

        void logOperation(int r2, String r3) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            Operation r4 = getOperationLocked(r2);     // Catch: Throwable -> L9
            if (r4 == null) goto L7;
            logOperationLocked(r4, r3);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private boolean endOperationDeferLogLocked(Operation r3) {
            if (r3 == null) goto L10;
            r3.mEndTime = System.currentTimeMillis();
            r3.mFinished = true;
            if (r3.mException == null) goto L9;
            if (r3.mException.getMessage() == null) goto L9;
            return true;
        L9:
            return SQLiteDebug.shouldLogSlowQuery(r3.mEndTime - r3.mStartTime);
        L10:
            return false;
        }

        private void logOperationLocked(Operation r2, String r3) {
            StringBuilder r1 = new StringBuilder();
            r2.describe(r1, false);
            if (r3 == null) goto L5;
            r1.append(", ").append(r3);
        L5:
            Log.i(SQLiteConnection.TAG, r1.toString());
        }

        private int newOperationCookieLocked(int r3) {
            int r0 = this.mGeneration;
            this.mGeneration = r0 + 1;
            return (r0 << 8) | r3;
        }

        private Operation getOperationLocked(int r2) {
            Operation[] r1 = this.mOperations;
            Operation r3 = r1[r2 & 255];
            if (r3.mCookie == r2) goto L7;
            return null;
        L7:
            return r3;
        }

        String describeCurrentOperation() {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            Operation r3 = this.mOperations[this.mIndex];     // Catch: Throwable -> L14
            if (r3 != null) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return null;
        L7:
            if (r3.mFinished == true) goto L11;
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L14
            r3.describe(r1, false);     // Catch: Throwable -> L14
            String r4 = r1.toString();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return r4;
        L14:
            th = move-exception;
            throw th;
        }

        SQLiteTrace.TraceInfo<String> traceCurrentOperation() {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            Operation r5 = this.mOperations[this.mIndex];     // Catch: Throwable -> L14
            if (r5 != null) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return null;
        L7:
            if (r5.mFinished == true) goto L11;
            SQLiteTrace.TraceInfo<String> r1 = new SQLiteTrace.TraceInfo(r5.mSql, r5.mStartTime, r5.mTid);     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return r1;
        L14:
            th = move-exception;
            throw th;
        }

        void dump(Printer r8, boolean r9) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            r8.println("  Most recently executed operations:");     // Catch: Throwable -> L19
            int r1 = this.mIndex;     // Catch: Throwable -> L19
            Operation r2 = this.mOperations[r1];     // Catch: Throwable -> L19
            if (r2 == null) goto L16;
            int r3 = 0;
        L7:
            StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L19
            r4.append("    ").append(r3).append(": [");     // Catch: Throwable -> L19
            r4.append(Operation.access$2000(r2));     // Catch: Throwable -> L19
            r4.append("] ");     // Catch: Throwable -> L19
            r2.describe(r4, r9);     // Catch: Throwable -> L19
            r8.println(r4.toString());     // Catch: Throwable -> L19
            if (r1 <= 0) goto L10;
            r1 = r1 - 1;     // Catch: Throwable -> L19
        L11:
            r3 = r3 + 1;     // Catch: Throwable -> L19
            r2 = this.mOperations[r1];     // Catch: Throwable -> L19
            if (r2 == null) goto L17;
            if (r3 < 20) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L10:
            r1 = 19;
            goto L11
        L16:
            r8.println("    <none>");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }

        JSONArray dumpJSON(boolean r8) throws JSONException {
            JSONArray r0 = new JSONArray();
            Operation[] r1 = this.mOperations;
            monitor-enter(r1);
            int r2 = this.mIndex;     // Catch: Throwable -> L16
            int r3 = 0;
        L5:
            Operation r4 = this.mOperations[r2];     // Catch: Throwable -> L16
            if (r4 == null) goto L14;
            int r5 = r3 + 1;     // Catch: Throwable -> L16
            if (r3 >= 20) goto L14;
            r0.put(r4.dumpJSON(r8));     // Catch: Throwable -> L16
            if (r2 <= 0) goto L12;
            r2 = r2 - 1;     // Catch: Throwable -> L16
        L13:
            r3 = r5;
            goto L5
        L12:
            r2 = 19;
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L16
            return r0;
        L16:
            th = move-exception;
            throw th;
        }
    }

    static final class PreparedStatement {
        private WeakReference<SQLiteConnection> mConnection;
        private boolean mInCache;
        private boolean mInUse;
        private int mNumParameters;
        private Operation mOperation;
        private PreparedStatement mPoolNext;
        private boolean mReadOnly;
        private String mSql;
        private long mStatementPtr;
        private int mType;

        static /* synthetic */ int access$100(PreparedStatement r0) {
            return r0.mType;
        }

        static /* synthetic */ int access$102(PreparedStatement r0, int r1) {
            r0.mType = r1;
            return r1;
        }

        static /* synthetic */ int access$200(PreparedStatement r0) {
            return r0.mNumParameters;
        }

        static /* synthetic */ int access$202(PreparedStatement r0, int r1) {
            r0.mNumParameters = r1;
            return r1;
        }

        static /* synthetic */ boolean access$300(PreparedStatement r0) {
            return r0.mReadOnly;
        }

        static /* synthetic */ boolean access$302(PreparedStatement r0, boolean r1) {
            r0.mReadOnly = r1;
            return r1;
        }

        static /* synthetic */ boolean access$400(PreparedStatement r0) {
            return r0.mInUse;
        }

        static /* synthetic */ boolean access$402(PreparedStatement r0, boolean r1) {
            r0.mInUse = r1;
            return r1;
        }

        static /* synthetic */ boolean access$500(PreparedStatement r0) {
            return r0.mInCache;
        }

        static /* synthetic */ boolean access$502(PreparedStatement r0, boolean r1) {
            r0.mInCache = r1;
            return r1;
        }

        static /* synthetic */ String access$600(PreparedStatement r0) {
            return r0.mSql;
        }

        static /* synthetic */ String access$602(PreparedStatement r0, String r1) {
            r0.mSql = r1;
            return r1;
        }

        static /* synthetic */ PreparedStatement access$700(PreparedStatement r0) {
            return r0.mPoolNext;
        }

        static /* synthetic */ PreparedStatement access$702(PreparedStatement r0, PreparedStatement r1) {
            r0.mPoolNext = r1;
            return r1;
        }

        static /* synthetic */ long access$802(PreparedStatement r0, long r1) {
            r0.mStatementPtr = r1;
            return r1;
        }

        PreparedStatement(SQLiteConnection r2) {
            this.mConnection = new WeakReference(r2);
        }

        public void bindArguments(Object[] r2) {
            SQLiteConnection r0 = this.mConnection.get();
            if (r0 != null) goto L5;
            return;
        L5:
            SQLiteConnection.access$900(r0, this, r2);
        }

        public void reset(boolean r2) {
            SQLiteConnection r0 = this.mConnection.get();
            if (r0 != null) goto L5;
            return;
        L5:
            SQLiteConnection.access$1000(r0, this, r2);
        }

        public long getPtr() {
            return this.mStatementPtr;
        }

        public String getSQL() {
            return this.mSql;
        }

        public boolean isReadOnly() {
            return this.mReadOnly;
        }

        public int getType() {
            return this.mType;
        }

        public void attachCancellationSignal(CancellationSignal r1) {
            SQLiteConnection r0 = this.mConnection.get();
            if (r0 != null) goto L5;
            return;
        L5:
            SQLiteConnection.access$1100(r0, r1);
        }

        public void detachCancellationSignal(CancellationSignal r1) {
            SQLiteConnection r0 = this.mConnection.get();
            if (r0 != null) goto L5;
            return;
        L5:
            SQLiteConnection.access$1200(r0, r1);
        }

        public void beginOperation(String r3, Object[] r4) {
            SQLiteConnection r0 = this.mConnection.get();
            if (r0 != null) goto L5;
            return;
        L5:
            Operation r5 = SQLiteConnection.access$1300(r0).beginOperation(r3, this.mSql, r4);
            this.mOperation = r5;
            r5.mType = this.mType;
        }

        public void failOperation(Exception r2) {
            if (this.mOperation != null) goto L5;
            return;
        L5:
            SQLiteConnection r0 = this.mConnection.get();
            if (r0 != null) goto L8;
            return;
        L8:
            SQLiteConnection.access$1300(r0).failOperation(this.mOperation.mCookie, r2);
        }

        public void endOperation(String r4) {
            if (this.mOperation != null) goto L5;
            return;
        L5:
            SQLiteConnection r0 = this.mConnection.get();
            if (r0 != null) goto L9;
            return;
        L9:
            if (SQLiteConnection.access$1300(r0).endOperationDeferLog(this.mOperation.mCookie) == false) goto L11;
            SQLiteConnection.access$1300(r0).logOperation(this.mOperation.mCookie, r4);
        L11:
            this.mOperation = null;
        }
    }

    private final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        final /* synthetic */ SQLiteConnection this$0;

        @Override // com.tencent.wcdb.support.LruCache
        protected /* bridge */ /* synthetic */ void entryRemoved(boolean r1, String r2, PreparedStatement r3, PreparedStatement r4) {
            entryRemoved2(r1, r2, r3, r4);
        }

        public PreparedStatementCache(SQLiteConnection r1, int r2) {
            this.this$0 = r1;
            super(r2);
        }

        /* JADX INFO: renamed from: entryRemoved, reason: avoid collision after fix types in other method */
        protected void entryRemoved2(boolean r1, String r2, PreparedStatement r3, PreparedStatement r4) {
            PreparedStatement.access$502(r3, false);
            if (PreparedStatement.access$400(r3) == true) goto L6;
            SQLiteConnection.access$1400(this.this$0, r3);
            return;
        }

        public void dump(Printer r7) {
            r7.println("  Prepared statement cache:");
            Map<String, PreparedStatement> r6 = snapshot();
            if (r6.isEmpty() == true) goto L11;
            Iterator<Map.Entry<String, PreparedStatement>> r8 = r6.entrySet().iterator();
            int r0 = 0;
        L6:
            if (r8.hasNext() == false) goto L16;
            Map.Entry<String, PreparedStatement> r1 = r8.next();
            PreparedStatement r2 = r1.getValue();
            if (PreparedStatement.access$500(r2) == false) goto L10;
            r7.println("    " + r0 + ": statementPtr=0x" + Long.toHexString(r2.getPtr()) + ", numParameters=" + PreparedStatement.access$200(r2) + ", type=" + PreparedStatement.access$100(r2) + ", readOnly=" + PreparedStatement.access$300(r2) + ", sql=\"" + SQLiteConnection.access$1500(r1.getKey()) + "\"");
        L10:
            r0 = r0 + 1;
            goto L6
        L16:
            return;
        L11:
            r7.println("    <none>");
        }
    }

    private void applyBlockGuardPolicy(PreparedStatement r1) {
    }

    private static boolean isCacheable(int r2) {
        if (r2 == 2) goto L8;
        if (r2 == 1) goto L8;
        return false;
    L8:
        return true;
    }

    private static native void nativeBindBlob(long r0, long r2, int r4, byte[] r5);

    private static native void nativeBindDouble(long r0, long r2, int r4, double r5);

    private static native void nativeBindLong(long r0, long r2, int r4, long r5);

    private static native void nativeBindNull(long r0, long r2, int r4);

    private static native void nativeBindString(long r0, long r2, int r4, String r5);

    private static native void nativeCancel(long r0);

    private static native void nativeClose(long r0);

    private static native void nativeExecute(long r0, long r2);

    private static native int nativeExecuteForChangedRowCount(long r0, long r2);

    private static native long nativeExecuteForCursorWindow(long r0, long r2, long r4, int r6, int r7, boolean r8);

    private static native long nativeExecuteForLastInsertedRowId(long r0, long r2);

    private static native long nativeExecuteForLong(long r0, long r2);

    private static native String nativeExecuteForString(long r0, long r2);

    private static native void nativeFinalizeStatement(long r0, long r2);

    private static native int nativeGetColumnCount(long r0, long r2);

    private static native String nativeGetColumnName(long r0, long r2, int r4);

    private static native int nativeGetDbLookaside(long r0);

    private static native int nativeGetParameterCount(long r0, long r2);

    private static native boolean nativeIsReadOnly(long r0, long r2);

    private native long nativeOpen(String r1, int r2, String r3);

    private static native long nativePrepareStatement(long r0, String r2);

    private static native void nativeRegisterCustomFunction(long r0, SQLiteCustomFunction r2);

    private static native void nativeRegisterLocalizedCollators(long r0, String r2);

    private static native void nativeResetCancel(long r0, boolean r2);

    private static native void nativeResetStatement(long r0, long r2, boolean r4);

    private static native long nativeSQLiteHandle(long r0, boolean r2);

    private static native void nativeSetKey(long r0, byte[] r2);

    private static native void nativeSetUpdateNotification(long r0, boolean r2, boolean r3);

    private static native void nativeSetWalHook(long r0);

    private static native long nativeWalCheckpoint(long r0, String r2);

    static /* synthetic */ void access$1000(SQLiteConnection r0, PreparedStatement r1, boolean r2) {
        r0.resetStatement(r1, r2);
    }

    static /* synthetic */ void access$1100(SQLiteConnection r0, CancellationSignal r1) {
        r0.attachCancellationSignal(r1);
    }

    static /* synthetic */ void access$1200(SQLiteConnection r0, CancellationSignal r1) {
        r0.detachCancellationSignal(r1);
    }

    static /* synthetic */ OperationLog access$1300(SQLiteConnection r0) {
        return r0.mRecentOperations;
    }

    static /* synthetic */ void access$1400(SQLiteConnection r0, PreparedStatement r1) {
        r0.finalizePreparedStatement(r1);
    }

    static /* synthetic */ String access$1500(String r0) {
        return trimSqlForDisplay(r0);
    }

    static /* synthetic */ byte[] access$1700() {
        return EMPTY_BYTE_ARRAY;
    }

    static /* synthetic */ int access$1800(SQLiteConnection r0) {
        return r0.mAcquiredTid;
    }

    static /* synthetic */ SQLiteConnectionPool access$1900(SQLiteConnection r0) {
        return r0.mPool;
    }

    static /* synthetic */ void access$900(SQLiteConnection r0, PreparedStatement r1, Object[] r2) {
        r0.bindArguments(r1, r2);
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
        EMPTY_BYTE_ARRAY = new byte[0];
        TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
        HMAC_ALGO_MAPPING = new String[]{"HMAC_SHA1", "HMAC_SHA256", "HMAC_SHA512"};
        PBKDF2_ALGO_MAPPING = new String[]{"PBKDF2_HMAC_SHA1", "PBKDF2_HMAC_SHA256", "PBKDF2_HMAC_SHA512"};
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SQLiteConnection(SQLiteConnectionPool r3, SQLiteDatabaseConfiguration r4, int r5, boolean r6, byte[] r7, SQLiteCipherSpec r8) {
        SQLiteCipherSpec r1 = null;
        this.mRecentOperations = new OperationLog(this, 0 == true ? 1 : 0);
        this.mPassword = r7;
        if (r8 == null) goto L6;
        r1 = new SQLiteCipherSpec(r8);
    L6:
        this.mCipher = r1;
        this.mPool = r3;
        SQLiteDatabaseConfiguration r9 = new SQLiteDatabaseConfiguration(r4);
        this.mConfiguration = r9;
        this.mConnectionId = r5;
        this.mIsPrimaryConnection = r6;
        boolean r10 = true;
        if ((r4.openFlags & 1) != 0) goto L10;
        r10 = false;
    L10:
        this.mIsReadOnlyConnection = r10;
        this.mPreparedStatementCache = new PreparedStatementCache(this, r9.maxSqlCacheSize);
    }

    long getNativeHandle(String r5) {
        if (this.mConnectionPtr != 0) goto L5;
        return 0;
    L5:
        if (r5 != null) goto L7;
    L9:
        this.mNativeHandleCount++;
        return nativeSQLiteHandle(this.mConnectionPtr, true);
    L7:
        if (this.mNativeOperation != null) goto L9;
        Operation r6 = this.mRecentOperations.beginOperation(r5, null, null);
        this.mNativeOperation = r6;
        r6.mType = 99;
        goto L9
    }

    void endNativeHandle(Exception r4) {
        int r0 = this.mNativeHandleCount - 1;
        this.mNativeHandleCount = r0;
        if (r0 == 0) goto L5;
        return;
    L5:
        if (this.mNativeOperation == null) goto L13;
        nativeSQLiteHandle(this.mConnectionPtr, false);
        if (r4 != null) goto L9;
        this.mRecentOperations.endOperationDeferLog(this.mNativeOperation.mCookie);
    L10:
        this.mNativeOperation = null;
        return;
    L9:
        this.mRecentOperations.failOperation(this.mNativeOperation.mCookie, r4);
        goto L10
    }

    protected void finalize() throws Throwable {
        SQLiteConnectionPool r0 = this.mPool;     // Catch: Throwable -> L10
        if (r0 != null) goto L5;
    L7:
        dispose(true);     // Catch: Throwable -> L10
        super.finalize();
        return;
    L5:
        if (this.mConnectionPtr == 0) goto L7;
        r0.onConnectionLeaked();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        super.finalize();
        throw th;
    }

    static SQLiteConnection open(SQLiteConnectionPool r8, SQLiteDatabaseConfiguration r9, int r10, boolean r11, byte[] r12, SQLiteCipherSpec r13) {
        SQLiteConnection r7 = new SQLiteConnection(r8, r9, r10, r11, r12, r13);
        r7.open();     // Catch: SQLiteException -> L5
        return r7;
    L5:
        e = move-exception;
        SQLiteDebug.collectLastIOTraceStats(r7);
        r7.dispose(false);
        throw e;
    }

    void close() {
        dispose(false);
    }

    private void open() {
        long r0 = nativeOpen(this.mConfiguration.path, this.mConfiguration.openFlags, this.mConfiguration.vfsName);
        this.mConnectionPtr = r0;
        byte[] r2 = this.mPassword;
        if (r2 != null) goto L5;
    L7:
        byte[] r3 = this.mPassword;
        if (r3 == null) goto L10;
        nativeSetKey(r0, r3);
        setCipherSpec();
    L10:
        setPageSize();
        setReadOnlyFromConfiguration();
        setForeignKeyModeFromConfiguration();
        setWalModeFromConfiguration();
        setSyncModeFromConfiguration();
        setJournalSizeLimit();
        setCheckpointStrategy();
        setLocaleFromConfiguration();
        long r1 = WCDBInitializationProbe.apiEnv;
        long r4 = nativeSQLiteHandle(this.mConnectionPtr, true);
        Iterator<SQLiteExtension> r5 = this.mConfiguration.extensions.iterator();     // Catch: Throwable -> L18
    L13:
        if (r5.hasNext() == false) goto L16;
        r5.next().initialize(r4, r1);     // Catch: Throwable -> L18
        goto L13
    L16:
        nativeSQLiteHandle(this.mConnectionPtr, false);
        setUpdateNotificationFromConfiguration();
        return;
    L18:
        th = move-exception;
        nativeSQLiteHandle(this.mConnectionPtr, false);
        throw th;
    L5:
        if (r2.length != 0) goto L7;
        this.mPassword = null;
        goto L7
    }

    private void dispose(boolean r5) {
        if (this.mConnectionPtr == 0) goto L10;
        int r6 = this.mRecentOperations.beginOperation("close", null, null).mCookie;
        this.mPreparedStatementCache.evictAll();     // Catch: Throwable -> L7
        nativeClose(this.mConnectionPtr);     // Catch: Throwable -> L7
        this.mConnectionPtr = 0;     // Catch: Throwable -> L7
        this.mRecentOperations.endOperation(r6);
        return;
    L7:
        th = move-exception;
        this.mRecentOperations.endOperation(r6);
        throw th;
    }

    private void setPageSize() {
        if (this.mConfiguration.isInMemoryDb() == false) goto L5;
        return;
    L5:
        if (this.mPassword == null) goto L14;
        SQLiteCipherSpec r0 = this.mCipher;
        if (r0 != null) goto L9;
    L12:
        int r1 = SQLiteGlobal.defaultPageSize;
    L13:
        long r2 = r1;
        String r3 = "PRAGMA cipher_page_size";
    L16:
        if (executeForLong(r3, null, null) == r2) goto L20;
        execute(r3 + "=" + r2, null, null);
        return;
    L20:
        return;
    L9:
        if (r0.pageSize <= 0) goto L12;
        r1 = this.mCipher.pageSize;
        goto L13
    L14:
        r2 = SQLiteGlobal.defaultPageSize;
        r3 = "PRAGMA page_size";
        goto L16
    }

    private void setCipherSpec() {
        SQLiteCipherSpec r0 = this.mCipher;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.kdfIteration == 0) goto L7;
        execute("PRAGMA kdf_iter=" + this.mCipher.kdfIteration, null, null);
    L7:
        execute("PRAGMA cipher_use_hmac=" + this.mCipher.hmacEnabled, null, null);
        if (this.mCipher.hmacAlgorithm == (-1)) goto L11;
        execute("PRAGMA cipher_hmac_algorithm=" + HMAC_ALGO_MAPPING[this.mCipher.hmacAlgorithm], null, null);
    L11:
        if (this.mCipher.kdfAlgorithm == (-1)) goto L15;
        execute("PRAGMA cipher_kdf_algorithm=" + PBKDF2_ALGO_MAPPING[this.mCipher.kdfAlgorithm], null, null);
        return;
    }

    private void notifyCheckpoint(String r1, int r2) {
        this.mPool.notifyCheckpoint(r1, r2);
    }

    private void setCheckpointStrategy() {
        if (this.mConfiguration.isInMemoryDb() == false) goto L5;
        return;
    L5:
        if (this.mIsReadOnlyConnection == false) goto L7;
        return;
    L7:
        if (this.mConfiguration.customWALHookEnabled == false) goto L10;
        nativeSetWalHook(this.mConnectionPtr);
        return;
    L10:
        if (executeForLong("PRAGMA wal_autocheckpoint", null, null) == 100) goto L16;
        executeForLong("PRAGMA wal_autocheckpoint=100", null, null);
        return;
    }

    private void setJournalSizeLimit() {
        if (this.mConfiguration.isInMemoryDb() == false) goto L5;
        return;
    L5:
        if (this.mIsReadOnlyConnection == false) goto L7;
        return;
    L7:
        if (executeForLong("PRAGMA journal_size_limit", null, null) == 524288) goto L12;
        executeForLong("PRAGMA journal_size_limit=524288", null, null);
        return;
    }

    private void setForeignKeyModeFromConfiguration() {
        if (this.mIsReadOnlyConnection == false) goto L5;
        return;
    L5:
        if (this.mConfiguration.foreignKeyConstraintsEnabled == false) goto L7;
        long r0 = 1;
    L9:
        if (executeForLong("PRAGMA foreign_keys", null, null) == r0) goto L13;
        execute("PRAGMA foreign_keys=" + r0, null, null);
        return;
    L13:
        return;
    L7:
        r0 = 0;
        goto L9
    }

    private void setWalModeFromConfiguration() {
        if (this.mConfiguration.isInMemoryDb() == false) goto L5;
        return;
    L5:
        if (this.mIsReadOnlyConnection == false) goto L7;
        return;
    L7:
        if ((this.mConfiguration.openFlags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L9;
        String r0 = "WAL";
    L10:
        setJournalMode(r0);
        return;
    L9:
        r0 = SQLiteGlobal.defaultJournalMode;
        goto L10
    }

    private void setSyncModeFromConfiguration() {
        execute("PRAGMA synchronous=" + this.mConfiguration.synchronousMode, null, null);
    }

    private void setJournalMode(String r5) {
        String r1 = executeForString("PRAGMA journal_mode", null, null);
        if (r1.equalsIgnoreCase(r5) == true) goto L12;
        if (executeForString("PRAGMA journal_mode=" + r5, null, null).equalsIgnoreCase(r5) == false) goto L7;
        return;
    L7:
        Log.w(TAG, "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + r1 + "' to '" + r5 + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        return;
    }

    private void setLocaleFromConfiguration() {
        this.mConfiguration.openFlags |= 16;
        if ((this.mConfiguration.openFlags & 16) == 0) goto L5;
        return;
    L5:
        String r0 = this.mConfiguration.locale.toString();
        nativeRegisterLocalizedCollators(this.mConnectionPtr, r0);
        if (this.mIsReadOnlyConnection == false) goto L25;
        return;
    L25:
        execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);     // Catch: RuntimeException -> L20
        String r1 = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);     // Catch: RuntimeException -> L20
        if (r1 != null) goto L11;
    L13:
        execute(VCardConstants.PROPERTY_BEGIN, null, null);     // Catch: RuntimeException -> L20
        execute("DELETE FROM android_metadata", null, null);     // Catch: Throwable -> L17
        execute("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{r0}, null);     // Catch: Throwable -> L17
        execute("REINDEX LOCALIZED", null, null);     // Catch: Throwable -> L17
        execute("COMMIT", null, null);     // Catch: RuntimeException -> L20
        return;
    L17:
        th = move-exception;
        execute("ROLLBACK", null, null);     // Catch: RuntimeException -> L20
        throw th;     // Catch: RuntimeException -> L20
    L11:
        if (r1.equals(r0) == false) goto L13;
        return;
    L20:
        e = move-exception;
        throw new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + r0 + "'.", e);
    }

    private void setReadOnlyFromConfiguration() {
        if (this.mIsReadOnlyConnection == false) goto L6;
        execute("PRAGMA query_only = 1", null, null);
        return;
    }

    private void notifyChange(String r7, String r8, long[] r9, long[] r10, long[] r11) {
        this.mPool.notifyChanges(r7, r8, r9, r10, r11);
    }

    private void setUpdateNotificationFromConfiguration() {
        nativeSetUpdateNotification(this.mConnectionPtr, this.mConfiguration.updateNotificationEnabled, this.mConfiguration.updateNotificationRowID);
    }

    void reconfigure(SQLiteDatabaseConfiguration r10) {
        boolean r0 = false;
        this.mOnlyAllowReadOnlyOperations = false;
        long r1 = WCDBInitializationProbe.apiEnv;
        long r3 = nativeSQLiteHandle(this.mConnectionPtr, true);
        Iterator<SQLiteExtension> r6 = r10.extensions.iterator();     // Catch: Throwable -> L45
    L5:
        if (r6.hasNext() == false) goto L10;
        SQLiteExtension r7 = r6.next();     // Catch: Throwable -> L45
        if (this.mConfiguration.extensions.contains(r7) == true) goto L5;
        r7.initialize(r3, r1);     // Catch: Throwable -> L45
        goto L5
    L10:
        nativeSQLiteHandle(this.mConnectionPtr, false);
        if (((r10.openFlags ^ this.mConfiguration.openFlags) & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L13;
        boolean r2 = true;
    L15:
        if (r10.foreignKeyConstraintsEnabled == this.mConfiguration.foreignKeyConstraintsEnabled) goto L17;
        boolean r4 = true;
    L18:
        boolean r5 = !r10.locale.equals(this.mConfiguration.locale);
        if (r10.customWALHookEnabled == this.mConfiguration.customWALHookEnabled) goto L21;
        boolean r8 = true;
    L23:
        if (r10.synchronousMode == this.mConfiguration.synchronousMode) goto L25;
        boolean r9 = true;
    L27:
        if (r10.updateNotificationEnabled == this.mConfiguration.updateNotificationEnabled) goto L29;
    L30:
        r0 = true;
    L31:
        this.mConfiguration.updateParametersFrom(r10);
        this.mPreparedStatementCache.resize(r10.maxSqlCacheSize);
        if (r4 == false) goto L34;
        setForeignKeyModeFromConfiguration();
    L34:
        if (r2 == false) goto L36;
        setWalModeFromConfiguration();
    L36:
        if (r9 == false) goto L38;
        setSyncModeFromConfiguration();
    L38:
        if (r8 == false) goto L40;
        setCheckpointStrategy();
    L40:
        if (r5 == false) goto L42;
        setLocaleFromConfiguration();
    L42:
        if (r0 == false) goto L55;
        setUpdateNotificationFromConfiguration();
        return;
    L55:
        return;
    L29:
        if (r10.updateNotificationRowID == this.mConfiguration.updateNotificationRowID) goto L31;
    L25:
        r9 = false;
        goto L27
    L21:
        r8 = false;
        goto L23
    L17:
        r4 = false;
        goto L18
    L13:
        r2 = false;
    L45:
        th = move-exception;
        nativeSQLiteHandle(this.mConnectionPtr, false);
        throw th;
    }

    void setOnlyAllowReadOnlyOperations(boolean r1) {
        this.mOnlyAllowReadOnlyOperations = r1;
    }

    void setAcquisitionState(boolean r4, boolean r5) {
        if (r4 == false) goto L8;
        this.mAcquiredThread = Thread.currentThread();
        this.mAcquiredTid = Process.myTid();
        if (r5 == false) goto L7;
        this.mAcquiredStack = this.mAcquiredThread.getStackTrace();
        this.mAcquiredTimestamp = System.currentTimeMillis();
        return;
    L7:
        this.mAcquiredStack = null;
        this.mAcquiredTimestamp = 0;
        return;
    L8:
        this.mAcquiredThread = null;
        this.mAcquiredTid = 0;
        this.mAcquiredStack = null;
        this.mAcquiredTimestamp = 0;
    }

    boolean isPreparedStatementInCache(String r1) {
        if (this.mPreparedStatementCache.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int getConnectionId() {
        return this.mConnectionId;
    }

    public boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    public void prepare(String r9, SQLiteStatementInfo r10) {
        if (r9 == null) goto L27;
        Operation r0 = this.mRecentOperations.beginOperation("prepare", r9, null);
        int r1 = r0.mCookie;
        PreparedStatement r11 = acquirePreparedStatement(r9);     // Catch: Throwable -> L19 RuntimeException -> L21
        r0.mType = PreparedStatement.access$100(r11);     // Catch: Throwable -> L19 RuntimeException -> L21
        if (r10 != null) goto L30;
    L16:
        releasePreparedStatement(r11);     // Catch: Throwable -> L19 RuntimeException -> L21
        this.mRecentOperations.endOperation(r1);
        return;
    L30:
        r10.numParameters = PreparedStatement.access$200(r11);     // Catch: Throwable -> L13
        r10.readOnly = PreparedStatement.access$300(r11);     // Catch: Throwable -> L13
        int r2 = nativeGetColumnCount(this.mConnectionPtr, r11.getPtr());     // Catch: Throwable -> L13
        if (r2 != 0) goto L9;
        r10.columnNames = EMPTY_STRING_ARRAY;     // Catch: Throwable -> L13
        goto L16
    L9:
        r10.columnNames = new String[r2];     // Catch: Throwable -> L13
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L16;
        r10.columnNames[r3] = nativeGetColumnName(this.mConnectionPtr, r11.getPtr(), r3);     // Catch: Throwable -> L13
        r3 = r3 + 1;
    L13:
        th = move-exception;
        releasePreparedStatement(r11);     // Catch: Throwable -> L19 RuntimeException -> L21
        throw th;     // Catch: Throwable -> L19 RuntimeException -> L21
    L21:
        e = move-exception;
        this.mRecentOperations.failOperation(r1, e);     // Catch: Throwable -> L19
        throw e;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.mRecentOperations.endOperation(r1);
        throw th;
    L27:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public void execute(String r7, Object[] r8, CancellationSignal r9) {
        if (r7 == null) goto L25;
        Operation r0 = this.mRecentOperations.beginOperation("execute", r7, r8);
        int r1 = r0.mCookie;
        PreparedStatement r10 = acquirePreparedStatement(r7);     // Catch: Throwable -> L17 RuntimeException -> L19
        r0.mType = PreparedStatement.access$100(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throwIfStatementForbidden(r10);     // Catch: Throwable -> L14
        bindArguments(r10, r8);     // Catch: Throwable -> L14
        applyBlockGuardPolicy(r10);     // Catch: Throwable -> L14
        attachCancellationSignal(r9);     // Catch: Throwable -> L14
        nativeExecute(this.mConnectionPtr, r10.getPtr());     // Catch: Throwable -> L11
        detachCancellationSignal(r9);     // Catch: Throwable -> L14
        releasePreparedStatement(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mRecentOperations.endOperation(r1);
        return;
    L11:
        th = move-exception;
        detachCancellationSignal(r9);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        releasePreparedStatement(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.mRecentOperations.endOperation(r1);
        throw th;
    L19:
        e = move-exception;
        this.mRecentOperations.failOperation(r1, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long executeForLong(String r7, Object[] r8, CancellationSignal r9) {
        if (r7 == null) goto L25;
        Operation r0 = this.mRecentOperations.beginOperation("executeForLong", r7, r8);
        int r1 = r0.mCookie;
        PreparedStatement r10 = acquirePreparedStatement(r7);     // Catch: Throwable -> L17 RuntimeException -> L19
        r0.mType = PreparedStatement.access$100(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throwIfStatementForbidden(r10);     // Catch: Throwable -> L14
        bindArguments(r10, r8);     // Catch: Throwable -> L14
        applyBlockGuardPolicy(r10);     // Catch: Throwable -> L14
        attachCancellationSignal(r9);     // Catch: Throwable -> L14
        long r2 = nativeExecuteForLong(this.mConnectionPtr, r10.getPtr());     // Catch: Throwable -> L11
        detachCancellationSignal(r9);     // Catch: Throwable -> L14
        releasePreparedStatement(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mRecentOperations.endOperation(r1);
        return r2;
    L11:
        th = move-exception;
        detachCancellationSignal(r9);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        releasePreparedStatement(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.mRecentOperations.endOperation(r1);
        throw th;
    L19:
        e = move-exception;
        this.mRecentOperations.failOperation(r1, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public String executeForString(String r7, Object[] r8, CancellationSignal r9) {
        if (r7 == null) goto L25;
        Operation r0 = this.mRecentOperations.beginOperation("executeForString", r7, r8);
        int r1 = r0.mCookie;
        PreparedStatement r10 = acquirePreparedStatement(r7);     // Catch: Throwable -> L17 RuntimeException -> L19
        r0.mType = PreparedStatement.access$100(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throwIfStatementForbidden(r10);     // Catch: Throwable -> L14
        bindArguments(r10, r8);     // Catch: Throwable -> L14
        applyBlockGuardPolicy(r10);     // Catch: Throwable -> L14
        attachCancellationSignal(r9);     // Catch: Throwable -> L14
        String r11 = nativeExecuteForString(this.mConnectionPtr, r10.getPtr());     // Catch: Throwable -> L11
        detachCancellationSignal(r9);     // Catch: Throwable -> L14
        releasePreparedStatement(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mRecentOperations.endOperation(r1);
        return r11;
    L11:
        th = move-exception;
        detachCancellationSignal(r9);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        releasePreparedStatement(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.mRecentOperations.endOperation(r1);
        throw th;
    L19:
        e = move-exception;
        this.mRecentOperations.failOperation(r1, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public int executeForChangedRowCount(String r9, Object[] r10, CancellationSignal r11) {
        if (r9 == null) goto L30;
        Operation r1 = this.mRecentOperations.beginOperation("executeForChangedRowCount", r9, r10);
        int r2 = r1.mCookie;
        PreparedStatement r12 = acquirePreparedStatement(r9);     // Catch: Throwable -> L20 RuntimeException -> L22
        r1.mType = PreparedStatement.access$100(r12);     // Catch: Throwable -> L20 RuntimeException -> L22
        throwIfStatementForbidden(r12);     // Catch: Throwable -> L17
        bindArguments(r12, r10);     // Catch: Throwable -> L17
        applyBlockGuardPolicy(r12);     // Catch: Throwable -> L17
        attachCancellationSignal(r11);     // Catch: Throwable -> L17
        int r3 = nativeExecuteForChangedRowCount(this.mConnectionPtr, r12.getPtr());     // Catch: Throwable -> L14
        detachCancellationSignal(r11);     // Catch: Throwable -> L17
        releasePreparedStatement(r12);     // Catch: Throwable -> L20 RuntimeException -> L22
        if (this.mRecentOperations.endOperationDeferLog(r2) == false) goto L13;
        this.mRecentOperations.logOperation(r2, "changedRows=" + r3);
    L13:
        return r3;
    L14:
        th = move-exception;
        detachCancellationSignal(r11);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        releasePreparedStatement(r12);     // Catch: Throwable -> L20 RuntimeException -> L22
        throw th;     // Catch: Throwable -> L20 RuntimeException -> L22
    L20:
        th = move-exception;
        if (this.mRecentOperations.endOperationDeferLog(r2) == false) goto L28;
        this.mRecentOperations.logOperation(r2, "changedRows=0");
    L28:
        throw th;
    L22:
        e = move-exception;
        this.mRecentOperations.failOperation(r2, e);     // Catch: Throwable -> L20
        throw e;     // Catch: Throwable -> L20
    L30:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long executeForLastInsertedRowId(String r7, Object[] r8, CancellationSignal r9) {
        if (r7 == null) goto L25;
        Operation r0 = this.mRecentOperations.beginOperation("executeForLastInsertedRowId", r7, r8);
        int r1 = r0.mCookie;
        PreparedStatement r10 = acquirePreparedStatement(r7);     // Catch: Throwable -> L17 RuntimeException -> L19
        r0.mType = PreparedStatement.access$100(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throwIfStatementForbidden(r10);     // Catch: Throwable -> L14
        bindArguments(r10, r8);     // Catch: Throwable -> L14
        applyBlockGuardPolicy(r10);     // Catch: Throwable -> L14
        attachCancellationSignal(r9);     // Catch: Throwable -> L14
        long r2 = nativeExecuteForLastInsertedRowId(this.mConnectionPtr, r10.getPtr());     // Catch: Throwable -> L11
        detachCancellationSignal(r9);     // Catch: Throwable -> L14
        releasePreparedStatement(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mRecentOperations.endOperation(r1);
        return r2;
    L11:
        th = move-exception;
        detachCancellationSignal(r9);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        releasePreparedStatement(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.mRecentOperations.endOperation(r1);
        throw th;
    L19:
        e = move-exception;
        this.mRecentOperations.failOperation(r1, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public int executeForCursorWindow(String r25, Object[] r26, CursorWindow r27, int r28, int r29, boolean r30, CancellationSignal r31) {
        if (r25 == null) goto L71;
        if (r27 == null) goto L69;
        r27.acquireReference();
        Operation r4 = this.mRecentOperations.beginOperation("executeForCursorWindow", r25, r26);     // Catch: Throwable -> L65
        int r9 = r4.mCookie;     // Catch: Throwable -> L65
        int r16 = -1;
        PreparedStatement r6 = acquirePreparedStatement(r25);     // Catch: Throwable -> L53 RuntimeException -> L55
        r4.mType = PreparedStatement.access$100(r6);     // Catch: Throwable -> L53 RuntimeException -> L55
        throwIfStatementForbidden(r6);     // Catch: Throwable -> L47
        bindArguments(r6, r26);     // Catch: Throwable -> L47
        applyBlockGuardPolicy(r6);     // Catch: Throwable -> L47
        attachCancellationSignal(r31);     // Catch: Throwable -> L47
        PreparedStatement r2 = r6;
        String r12 = "window='";
        String r11 = ", countedRows=";
        int r15 = r9;
        String r7 = "', startPos=";
        String r10 = ", actualPos=";
        String r13 = ", filledRows=";
        long r5 = nativeExecuteForCursorWindow(this.mConnectionPtr, r6.getPtr(), r27.mWindowPtr, r28, r29, r30);     // Catch: Throwable -> L36
        int r8 = (int) (r5 >> 32);
        int r14 = (int) r5;
        int r17 = r27.getNumRows();     // Catch: Throwable -> L33
        r27.setStartPosition(r8);     // Catch: Throwable -> L31
        detachCancellationSignal(r31);     // Catch: Throwable -> L29
        releasePreparedStatement(r2);     // Catch: Throwable -> L25 RuntimeException -> L27
    L21:
        if (this.mRecentOperations.endOperationDeferLog(r15) == false) goto L23;
        this.mRecentOperations.logOperation(r15, r12 + r27 + r7 + r28 + r10 + r8 + r13 + r17 + r11 + r14);     // Catch: Throwable -> L65
    L23:
        r27.releaseReference();
        return r14;
    L27:
        e = e;
        r28 = r28;
        r12 = r12;
        r11 = r11;
        r7 = r7;
        r10 = r10;
        r13 = r13;
        r16 = r8;
    L57:
        this.mRecentOperations.failOperation(r15, e);     // Catch: Throwable -> L59
        throw e;     // Catch: Throwable -> L59
    L59:
        th = th;
        r8 = r16;
    L62:
        if (this.mRecentOperations.endOperationDeferLog(r15) == false) goto L64;
        this.mRecentOperations.logOperation(r15, r12 + r27 + r7 + r28 + r10 + r8 + r13 + r17 + r11 + r14);     // Catch: Throwable -> L65
    L64:
        throw th;     // Catch: Throwable -> L65
    L25:
        th = th;
        r28 = r28;
        r12 = r12;
        r11 = r11;
        r7 = r7;
        r10 = r10;
        r13 = r13;
    L29:
        th = th;
        r28 = r28;
        r12 = r12;
        r11 = r11;
        r7 = r7;
        r10 = r10;
        r13 = r13;
        r16 = r8;
    L74:
        releasePreparedStatement(r2);     // Catch: RuntimeException -> L51 Throwable -> L59
        throw th;     // Catch: RuntimeException -> L51 Throwable -> L59
    L51:
        e = e;
    L31:
        th = th;
    L35:
        r16 = r8;
    L82:
        detachCancellationSignal(r31);     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L45:
        th = th;
    L33:
        th = th;
        r17 = -1;
    L36:
        th = th;
        r28 = r28;
        r12 = r12;
        r11 = r11;
        r7 = r7;
        r10 = r10;
        r13 = r13;
    L42:
        r14 = -1;
        r17 = -1;
    L38:
        th = th;
        r7 = "', startPos=";
        r10 = ", actualPos=";
        r13 = ", filledRows=";
        r28 = r28;
        r11 = ", countedRows=";
        r15 = r9;
        r12 = "window='";
        r2 = r6;
    L40:
        th = th;
        r2 = r6;
        r7 = "', startPos=";
        r13 = ", filledRows=";
        r12 = "window='";
        r28 = r28;
        r15 = r9;
        r10 = ", actualPos=";
        r11 = ", countedRows=";
    L47:
        th = th;
        r2 = r6;
        r7 = "', startPos=";
        r13 = ", filledRows=";
        r12 = "window='";
        r28 = r28;
        r15 = r9;
        r10 = ", actualPos=";
        r11 = ", countedRows=";
        r14 = -1;
        r17 = -1;
        goto L74
    L55:
        e = e;
        r7 = "', startPos=";
        r13 = ", filledRows=";
        r12 = "window='";
        r28 = r28;
        r15 = r9;
        r10 = ", actualPos=";
        r11 = ", countedRows=";
        r14 = -1;
        r17 = -1;
    L53:
        th = th;
        r7 = "', startPos=";
        r13 = ", filledRows=";
        r12 = "window='";
        r28 = r28;
        r15 = r9;
        r10 = ", actualPos=";
        r11 = ", countedRows=";
        r14 = -1;
        r17 = -1;
        r8 = -1;
    L65:
        th = move-exception;
        r27.releaseReference();
        throw th;
    L69:
        throw new IllegalArgumentException("window must not be null.");
    L71:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public Pair<Integer, Integer> walCheckpoint(String r4) {
        if (r4 != null) goto L4;
    L5:
        r4 = "main";
    L6:
        long r3 = nativeWalCheckpoint(this.mConnectionPtr, r4);
        int r0 = (int) (r3 >> 32);
        return new Pair(Integer.valueOf(r0), Integer.valueOf((int) (r3 & 4294967295L)));
    L4:
        if (r4.isEmpty() == false) goto L6;
        goto L5
    }

    PreparedStatement acquirePreparedStatement(String r14) {
        PreparedStatement r0 = this.mPreparedStatementCache.get(r14);
        if (r0 != null) goto L5;
        boolean r2 = false;
    L10:
        long r3 = nativePrepareStatement(this.mConnectionPtr, r14);
        int r9 = nativeGetParameterCount(this.mConnectionPtr, r3);     // Catch: RuntimeException -> L18
        int r12 = DatabaseUtils.getSqlStatementType(r14);     // Catch: RuntimeException -> L18
        r0 = obtainPreparedStatement(r14, r3, r9, r12, nativeIsReadOnly(this.mConnectionPtr, r3));     // Catch: RuntimeException -> L18
        if (r2 == false) goto L14;
    L16:
        PreparedStatement.access$402(r0, true);
        return r0;
    L14:
        if (isCacheable(r12) == false) goto L16;
        this.mPreparedStatementCache.put(r14, r0);     // Catch: RuntimeException -> L18
        PreparedStatement.access$502(r0, true);     // Catch: RuntimeException -> L18
    L18:
        e = move-exception;
        if (r0 != null) goto L21;
    L22:
        nativeFinalizeStatement(this.mConnectionPtr, r3);
    L23:
        throw e;
    L21:
        if (PreparedStatement.access$500(r0) == true) goto L23;
    L5:
        if (PreparedStatement.access$400(r0) == true) goto L8;
        PreparedStatement.access$402(r0, true);
        return r0;
    L8:
        r2 = true;
        goto L10
    }

    void releasePreparedStatement(PreparedStatement r2) {
        PreparedStatement.access$402(r2, false);
        if (PreparedStatement.access$500(r2) == true) goto L10;
        finalizePreparedStatement(r2);
        return;
    L10:
        resetStatement(r2, true);     // Catch: SQLiteException -> L7
        return;
    L7:
        this.mPreparedStatementCache.remove(PreparedStatement.access$600(r2));
    }

    private void finalizePreparedStatement(PreparedStatement r5) {
        nativeFinalizeStatement(this.mConnectionPtr, r5.getPtr());
        recyclePreparedStatement(r5);
    }

    private void attachCancellationSignal(CancellationSignal r5) {
        if (r5 == null) goto L7;
        r5.throwIfCanceled();
        int r0 = this.mCancellationSignalAttachCount + 1;
        this.mCancellationSignalAttachCount = r0;
        if (r0 != 1) goto L8;
        nativeResetCancel(this.mConnectionPtr, true);
        r5.setOnCancelListener(this);
        return;
    L8:
        return;
    }

    private void detachCancellationSignal(CancellationSignal r2) {
        if (r2 == null) goto L7;
        int r0 = this.mCancellationSignalAttachCount - 1;
        this.mCancellationSignalAttachCount = r0;
        if (r0 != 0) goto L8;
        r2.setOnCancelListener(null);
        nativeResetCancel(this.mConnectionPtr, false);
        return;
    L8:
        return;
    }

    @Override // com.tencent.wcdb.support.CancellationSignal.OnCancelListener
    public void onCancel() {
        nativeCancel(this.mConnectionPtr);
    }

    private void bindArguments(PreparedStatement r13, Object[] r14) {
        int r0 = 0;
        if (r14 == null) goto L5;
        int r1 = r14.length;
    L7:
        if (r1 != PreparedStatement.access$200(r13)) goto L35;
        if (r1 != 0) goto L10;
        return;
    L10:
        long r10 = r13.getPtr();
    L11:
        if (r0 >= r1) goto L33;
        Object r15 = r14[r0];
        int r2 = DatabaseUtils.getTypeOfObject(r15);
        if (r2 != 0) goto L15;
        nativeBindNull(this.mConnectionPtr, r10, r0 + 1);
    L32:
        r0 = r0 + 1;
        goto L11
    L15:
        if (r2 != 1) goto L17;
        nativeBindLong(this.mConnectionPtr, r10, r0 + 1, ((Number) r15).longValue());
        goto L32
    L17:
        if (r2 != 2) goto L19;
        nativeBindDouble(this.mConnectionPtr, r10, r0 + 1, ((Number) r15).doubleValue());
        goto L32
    L19:
        if (r2 != 4) goto L21;
        nativeBindBlob(this.mConnectionPtr, r10, r0 + 1, (byte[]) r15);
        goto L32
    L21:
        if ((r15 instanceof Boolean) == false) goto L27;
        long r3 = this.mConnectionPtr;
        int r7 = r0 + 1;
        if (((Boolean) r15).booleanValue() == false) goto L25;
        long r5 = 1;
    L26:
        nativeBindLong(r3, r10, r7, r5);
        goto L32
    L25:
        r5 = 0;
        goto L26
    L27:
        nativeBindString(this.mConnectionPtr, r10, r0 + 1, r15.toString());
        goto L32
    L33:
        return;
    L35:
        throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + PreparedStatement.access$200(r13) + " bind arguments but " + r1 + " were provided.");
    L5:
        r1 = 0;
        goto L7
    }

    private void resetStatement(PreparedStatement r3, boolean r4) {
        nativeResetStatement(this.mConnectionPtr, r3.getPtr(), r4);
    }

    private void throwIfStatementForbidden(PreparedStatement r1) {
        if (this.mOnlyAllowReadOnlyOperations == true) goto L5;
        return;
    L5:
        if (PreparedStatement.access$300(r1) == false) goto L8;
        return;
    L8:
        throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
    }

    void dump(Printer r4, boolean r5) {
        r4.println("Connection #" + this.mConnectionId + ":");
        if (r5 == false) goto L5;
        r4.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
    L5:
        r4.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
        r4.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        if (this.mAcquiredThread == null) goto L8;
        r4.println("  acquiredThread: " + this.mAcquiredThread + " (tid: " + this.mAcquiredTid + ")");
    L8:
        this.mRecentOperations.dump(r4, r5);
        if (r5 == false) goto L12;
        this.mPreparedStatementCache.dump(r4);
        return;
    }

    JSONObject dumpJSON(boolean r5) throws JSONException {
        JSONObject r0 = new JSONObject().put("id", this.mConnectionId).put("ptr", Long.toHexString(this.mConnectionPtr)).put("primary", this.mIsPrimaryConnection).put("readOnly", this.mOnlyAllowReadOnlyOperations);
        Thread r1 = this.mAcquiredThread;
        Integer r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        JSONObject r4 = r0.putOpt("thread", r3);
        int r6 = this.mAcquiredTid;
        if (r6 <= 0) goto L10;
        r2 = Integer.valueOf(r6);
    L10:
        return r4.putOpt("tid", r2).put("operations", this.mRecentOperations.dumpJSON(r5));
    L5:
        r3 = null;
        goto L6
    }

    String describeCurrentOperationUnsafe() {
        return this.mRecentOperations.describeCurrentOperation();
    }

    SQLiteTrace.TraceInfo<String> traceCurrentOperationUnsafe() {
        return this.mRecentOperations.traceCurrentOperation();
    }

    SQLiteTrace.TraceInfo<StackTraceElement[]> tracePersistAcquisitionUnsafe() {
        StackTraceElement[] r0 = this.mAcquiredStack;
        if (r0 != null) goto L6;
        return null;
    L6:
        return new SQLiteTrace.TraceInfo(r0, this.mAcquiredTimestamp, this.mAcquiredTid);
    }

    void collectDbStats(ArrayList<SQLiteDebug.DbStats> r26) {
        int r2 = nativeGetDbLookaside(this.mConnectionPtr);
        long r3 = executeForLong("PRAGMA page_count;", null, null);     // Catch: SQLiteException -> L6
        long r5 = executeForLong("PRAGMA page_size;", null, null);     // Catch: SQLiteException -> L30
    L8:
        r26.add(getMainDbStatsUnsafe(r2, r3, r5));
        CursorWindow r14 = new CursorWindow("collectDbStats");
        executeForCursorWindow("PRAGMA database_list;", null, r14, 0, 0, false, null);     // Catch: Throwable -> L23 SQLiteException -> L29
        int r4 = 1;
    L10:
        if (r4 >= r14.getNumRows()) goto L26;
        String r6 = r14.getString(r4, 1);     // Catch: Throwable -> L23 SQLiteException -> L29
        String r7 = r14.getString(r4, 2);     // Catch: Throwable -> L23 SQLiteException -> L29
        long r8 = executeForLong("PRAGMA " + r6 + ".page_count;", null, null);     // Catch: SQLiteException -> L16 Throwable -> L23
        long r17 = r8;
        long r19 = executeForLong("PRAGMA " + r6 + ".page_size;", null, null);     // Catch: SQLiteException -> L28 Throwable -> L23
    L18:
        String r9 = "  (attached) " + r6;     // Catch: Throwable -> L23 SQLiteException -> L29
        if (r7.length() == 0) goto L21;
        r9 = r9 + ": " + r7;     // Catch: Throwable -> L23 SQLiteException -> L29
    L21:
        r26.add(new SQLiteDebug.DbStats(r9, r17, r19, 0, 0, 0, 0));     // Catch: Throwable -> L23 SQLiteException -> L29
        r4 = r4 + 1;
    L17:
        r17 = r8;
        r19 = 0;
    L16:
        r8 = 0;
        goto L17
    L23:
        th = move-exception;
        r14.close();
        throw th;
    L26:
        r14.close();
        return;
    L7:
        r5 = 0;
    L6:
        r3 = 0;
        goto L7
    }

    void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> r7) {
        r7.add(getMainDbStatsUnsafe(0, 0, 0));
    }

    private SQLiteDebug.DbStats getMainDbStatsUnsafe(int r13, long r14, long r16) {
        String r1 = this.mConfiguration.path;
        if (this.mIsPrimaryConnection == true) goto L6;
        r1 = r1 + " (" + this.mConnectionId + ")";
    L6:
        return new SQLiteDebug.DbStats(r1, r14, r16, r13, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
    }

    public String toString() {
        return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
    }

    private PreparedStatement obtainPreparedStatement(String r3, long r4, int r6, int r7, boolean r8) {
        PreparedStatement r0 = this.mPreparedStatementPool;
        if (r0 == null) goto L5;
        this.mPreparedStatementPool = PreparedStatement.access$700(r0);
        PreparedStatement.access$702(r0, null);
        PreparedStatement.access$502(r0, false);
    L6:
        PreparedStatement.access$602(r0, r3);
        PreparedStatement.access$802(r0, r4);
        PreparedStatement.access$202(r0, r6);
        PreparedStatement.access$102(r0, r7);
        PreparedStatement.access$302(r0, r8);
        return r0;
    L5:
        r0 = new PreparedStatement(this);
        goto L6
    }

    private void recyclePreparedStatement(PreparedStatement r2) {
        PreparedStatement.access$602(r2, null);
        PreparedStatement.access$702(r2, this.mPreparedStatementPool);
        this.mPreparedStatementPool = r2;
    }

    private static String trimSqlForDisplay(String r1) {
        return TRIM_SQL_PATTERN.matcher(r1).replaceAll(HanziToPinyin.Token.SEPARATOR);
    }
}
