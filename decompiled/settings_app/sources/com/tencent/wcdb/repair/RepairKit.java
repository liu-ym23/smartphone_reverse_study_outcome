package com.tencent.wcdb.repair;

import android.database.Cursor;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;

/* JADX INFO: loaded from: classes5.dex */
public class RepairKit implements CancellationSignal.OnCancelListener {
    public static final int FLAG_ALL_TABLES = 2;
    public static final int FLAG_CHECK_TABLE_COLUMNS = 4;
    public static final int FLAG_NO_CREATE_TABLES = 1;
    private static final int INTEGRITY_DATA = 2;
    private static final int INTEGRITY_HEADER = 1;
    private static final int INTEGRITY_KDF_SALT = 4;
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_IGNORE = 2;
    public static final int RESULT_OK = 0;
    private Callback mCallback;
    private RepairCursor mCurrentCursor;
    private int mIntegrityFlags;
    private MasterInfo mMasterInfo;
    private long mNativePtr;

    /* JADX INFO: renamed from: com.tencent.wcdb.repair.RepairKit$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Callback {
        int onProgress(String r1, int r2, Cursor r3);
    }

    public static class MasterInfo {
        private byte[] mKDFSalt;
        private long mMasterPtr;

        static /* synthetic */ byte[] access$000(MasterInfo r0) {
            return r0.mKDFSalt;
        }

        static /* synthetic */ long access$100(MasterInfo r2) {
            return r2.mMasterPtr;
        }

        private MasterInfo(long r1, byte[] r3) {
            this.mMasterPtr = r1;
            this.mKDFSalt = r3;
        }

        public static MasterInfo make(String[] r4) {
            long r0 = RepairKit.access$300(r4);
            if (r0 == 0) goto L7;
            return new MasterInfo(r0, null);
        L7:
            throw new SQLiteException("Cannot create MasterInfo.");
        }

        public static MasterInfo load(String r3, byte[] r4, String[] r5) {
            if (r3 == null) goto L4;
            byte[] r0 = new byte[16];
            long r6 = RepairKit.access$400(r3, r4, r5, r0);
            if (r6 == 0) goto L10;
            return new MasterInfo(r6, r0);
        L10:
            throw new SQLiteException("Cannot create MasterInfo.");
        L4:
            return make(r5);
        }

        public static boolean save(SQLiteDatabase r3, String r4, byte[] r5) {
            long r0 = r3.acquireNativeConnectionHandle("backupMaster", true, false);
            boolean r6 = RepairKit.access$500(r0, r4, r5);
            r3.releaseNativeConnection(r0, null);
            return r6;
        }

        public void release() {
            long r0 = this.mMasterPtr;
            if (r0 != 0) goto L5;
            return;
        L5:
            RepairKit.access$600(r0);
            this.mMasterPtr = 0;
        }

        protected void finalize() throws Throwable {
            release();
            super.finalize();
        }
    }

    private static class RepairCursor extends AbstractCursor {
        long mPtr;

        private static native byte[] nativeGetBlob(long r0, int r2);

        private static native int nativeGetColumnCount(long r0);

        private static native double nativeGetDouble(long r0, int r2);

        private static native long nativeGetLong(long r0, int r2);

        private static native String nativeGetString(long r0, int r2);

        private static native int nativeGetType(long r0, int r2);

        private RepairCursor() {
        }

        /* synthetic */ RepairCursor(AnonymousClass1 r1) {
            this();
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public int getCount() {
            throw new UnsupportedOperationException();
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public String[] getColumnNames() {
            throw new UnsupportedOperationException();
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public int getColumnCount() {
            return nativeGetColumnCount(this.mPtr);
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public int getType(int r3) {
            return nativeGetType(this.mPtr, r3);
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public String getString(int r3) {
            return nativeGetString(this.mPtr, r3);
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public short getShort(int r1) {
            return (short) getLong(r1);
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public int getInt(int r1) {
            return (int) getLong(r1);
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public long getLong(int r3) {
            return nativeGetLong(this.mPtr, r3);
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public float getFloat(int r1) {
            return (float) getDouble(r1);
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public double getDouble(int r3) {
            return nativeGetDouble(this.mPtr, r3);
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public byte[] getBlob(int r3) {
            return nativeGetBlob(this.mPtr, r3);
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
        public boolean isNull(int r1) {
            if (getType(r1) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static native void nativeCancel(long r0);

    private static native void nativeFini(long r0);

    private static native void nativeFreeMaster(long r0);

    private static native long nativeInit(String r0, byte[] r1, SQLiteCipherSpec r2, byte[] r3);

    private static native int nativeIntegrityFlags(long r0);

    private static native String nativeLastError();

    private static native long nativeLoadMaster(String r0, byte[] r1, String[] r2, byte[] r3);

    private static native long nativeMakeMaster(String[] r0);

    private native int nativeOutput(long r1, long r3, long r5, int r7);

    private static native boolean nativeSaveMaster(long r0, String r2, byte[] r3);

    static /* synthetic */ long access$300(String[] r2) {
        return nativeMakeMaster(r2);
    }

    static /* synthetic */ long access$400(String r0, byte[] r1, String[] r2, byte[] r3) {
        return nativeLoadMaster(r0, r1, r2, r3);
    }

    static /* synthetic */ boolean access$500(long r0, String r2, byte[] r3) {
        return nativeSaveMaster(r0, r2, r3);
    }

    static /* synthetic */ void access$600(long r0) {
        nativeFreeMaster(r0);
    }

    public RepairKit(String r3, byte[] r4, SQLiteCipherSpec r5, MasterInfo r6) {
        if (r3 == null) goto L14;
        if (r6 != null) goto L6;
        byte[] r0 = null;
    L7:
        long r7 = nativeInit(r3, r4, r5, r0);
        this.mNativePtr = r7;
        if (r7 == 0) goto L12;
        this.mIntegrityFlags = nativeIntegrityFlags(r7);
        this.mMasterInfo = r6;
        return;
    L12:
        throw new SQLiteException("Failed initialize RepairKit.");
    L6:
        r0 = MasterInfo.access$000(r6);
        goto L7
    L14:
        throw new IllegalArgumentException();
    }

    public Callback getCallback() {
        return this.mCallback;
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public void release() {
        MasterInfo r0 = this.mMasterInfo;
        if (r0 == null) goto L5;
        r0.release();
        this.mMasterInfo = null;
    L5:
        long r1 = this.mNativePtr;
        if (r1 == 0) goto L9;
        nativeFini(r1);
        this.mNativePtr = 0;
        return;
    }

    public int output(SQLiteDatabase r13, int r14) {
        long r2 = 0;
        if (this.mNativePtr == 0) goto L11;
        MasterInfo r0 = this.mMasterInfo;
        if (r0 == null) goto L8;
        r2 = MasterInfo.access$100(r0);
    L8:
        long r1 = r13.acquireNativeConnectionHandle("repair", false, false);
        long r5 = this.mNativePtr;
        int r15 = nativeOutput(r5, r1, r2, r14);
        r13.releaseNativeConnection(r1, null);
        this.mCurrentCursor = null;
        this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
        return r15;
    L11:
        throw new IllegalArgumentException();
    }

    public int output(SQLiteDatabase r2, int r3, CancellationSignal r4) {
        if (r4.isCanceled() == false) goto L6;
        return 1;
    L6:
        r4.setOnCancelListener(this);
        int r1 = output(r2, r3);
        r4.setOnCancelListener(null);
        return r1;
    }

    @Override // com.tencent.wcdb.support.CancellationSignal.OnCancelListener
    public void onCancel() {
        long r0 = this.mNativePtr;
        if (r0 != 0) goto L5;
        return;
    L5:
        nativeCancel(r0);
    }

    private int onProgress(String r3, int r4, long r5) {
        if (this.mCallback != null) goto L7;
        return 0;
    L7:
        if (this.mCurrentCursor != null) goto L9;
        this.mCurrentCursor = new RepairCursor(null);
    L9:
        this.mCurrentCursor.mPtr = r5;
        return this.mCallback.onProgress(r3, r4, this.mCurrentCursor);
    }

    public boolean isSaltCorrupted() {
        if ((this.mIntegrityFlags & 4) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHeaderCorrupted() {
        if ((this.mIntegrityFlags & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isDataCorrupted() {
        if ((this.mIntegrityFlags & 2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String lastError() {
        return nativeLastError();
    }

    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }
}
