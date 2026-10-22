package com.tencent.wcdb;

import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.tencent.wcdb.database.SQLiteClosable;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
public class CursorWindow extends SQLiteClosable implements Parcelable {
    public static final Parcelable.Creator<CursorWindow> CREATOR = null;
    private static final String STATS_TAG = "WCDB.CursorWindowStats";
    private static int sCursorWindowSize;
    private final String mName;
    private int mStartPos;
    public long mWindowPtr;

    private static native boolean nativeAllocRow(long r0);

    private static native void nativeClear(long r0);

    private static native void nativeCopyStringToBuffer(long r0, int r2, int r3, CharArrayBuffer r4);

    private static native long nativeCreate(String r0, int r1);

    private static native void nativeDispose(long r0);

    private static native void nativeFreeLastRow(long r0);

    private static native byte[] nativeGetBlob(long r0, int r2, int r3);

    private static native double nativeGetDouble(long r0, int r2, int r3);

    private static native long nativeGetLong(long r0, int r2, int r3);

    private static native int nativeGetNumRows(long r0);

    private static native String nativeGetString(long r0, int r2, int r3);

    private static native int nativeGetType(long r0, int r2, int r3);

    private static native boolean nativePutBlob(long r0, byte[] r2, int r3, int r4);

    private static native boolean nativePutDouble(long r0, double r2, int r4, int r5);

    private static native boolean nativePutLong(long r0, long r2, int r4, int r5);

    private static native boolean nativePutNull(long r0, int r2, int r3);

    private static native boolean nativePutString(long r0, String r2, int r3, int r4);

    private static native boolean nativeSetNumColumns(long r0, int r2);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ CursorWindow(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    static {
        int r0 = Resources.getSystem().getIdentifier("config_cursorWindowSize", "integer", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        if (r0 == 0) goto L5;
        sCursorWindowSize = Resources.getSystem().getInteger(r0) * 1024;
    L6:
        CREATOR = new AnonymousClass1();
        return;
    L5:
        sCursorWindowSize = 2097152;
        goto L6
    }

    public static int windowSize(int r1) {
        int r0 = sCursorWindowSize;
        if (r1 <= 0) goto L5;
        sCursorWindowSize = r1;
    L5:
        return r0;
    }

    public CursorWindow(String r3) {
        this.mStartPos = 0;
        if (r3 != null) goto L5;
    L7:
        r3 = "<unnamed>";
    L8:
        this.mName = r3;
        long r0 = nativeCreate(r3, sCursorWindowSize);
        this.mWindowPtr = r0;
        if (r0 == 0) goto L12;
        return;
    L12:
        throw new CursorWindowAllocationException("Cursor window allocation of " + (sCursorWindowSize / 1024) + " kb failed. ");
    L5:
        if (r3.length() == 0) goto L7;
        goto L7
    }

    @Deprecated
    public CursorWindow(boolean r2) {
        String r0 = (String) null;
        this(null);
    }

    private CursorWindow(Parcel r1) {
        throw new UnsupportedOperationException();
    }

    protected void finalize() throws Throwable {
        dispose();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    private void dispose() {
        long r0 = this.mWindowPtr;
        if (r0 == 0) goto L6;
        nativeDispose(r0);
        this.mWindowPtr = 0;
        return;
    }

    public String getName() {
        return this.mName;
    }

    public void clear() {
        acquireReference();
        this.mStartPos = 0;     // Catch: Throwable -> L6
        nativeClear(this.mWindowPtr);     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public int getStartPosition() {
        return this.mStartPos;
    }

    public void setStartPosition(int r1) {
        this.mStartPos = r1;
    }

    public int getNumRows() {
        acquireReference();
        int r0 = nativeGetNumRows(this.mWindowPtr);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public boolean setNumColumns(int r3) {
        acquireReference();
        boolean r4 = nativeSetNumColumns(this.mWindowPtr, r3);     // Catch: Throwable -> L6
        releaseReference();
        return r4;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public boolean allocRow() {
        acquireReference();
        boolean r0 = nativeAllocRow(this.mWindowPtr);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void freeLastRow() {
        acquireReference();
        nativeFreeLastRow(this.mWindowPtr);     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Deprecated
    public boolean isNull(int r1, int r2) {
        if (getType(r1, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public boolean isBlob(int r1, int r2) {
        int r0 = getType(r1, r2);
        if (r0 == 4) goto L7;
        if (r0 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Deprecated
    public boolean isLong(int r1, int r2) {
        if (getType(r1, r2) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Deprecated
    public boolean isFloat(int r1, int r2) {
        if (getType(r1, r2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public boolean isString(int r1, int r2) {
        int r0 = getType(r1, r2);
        if (r0 == 3) goto L7;
        if (r0 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public int getType(int r4, int r5) {
        acquireReference();
        int r6 = nativeGetType(this.mWindowPtr, r4 - this.mStartPos, r5);     // Catch: Throwable -> L6
        releaseReference();
        return r6;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public byte[] getBlob(int r4, int r5) {
        acquireReference();
        byte[] r6 = nativeGetBlob(this.mWindowPtr, r4 - this.mStartPos, r5);     // Catch: Throwable -> L6
        releaseReference();
        return r6;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public String getString(int r4, int r5) {
        acquireReference();
        String r6 = nativeGetString(this.mWindowPtr, r4 - this.mStartPos, r5);     // Catch: Throwable -> L6
        releaseReference();
        return r6;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void copyStringToBuffer(int r4, int r5, CharArrayBuffer r6) {
        if (r6 == null) goto L11;
        acquireReference();
        nativeCopyStringToBuffer(this.mWindowPtr, r4 - this.mStartPos, r5, r6);     // Catch: Throwable -> L7
        releaseReference();
        return;
    L7:
        th = move-exception;
        releaseReference();
        throw th;
    L11:
        throw new IllegalArgumentException("CharArrayBuffer should not be null");
    }

    public long getLong(int r4, int r5) {
        acquireReference();
        long r6 = nativeGetLong(this.mWindowPtr, r4 - this.mStartPos, r5);     // Catch: Throwable -> L6
        releaseReference();
        return r6;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public double getDouble(int r4, int r5) {
        acquireReference();
        double r6 = nativeGetDouble(this.mWindowPtr, r4 - this.mStartPos, r5);     // Catch: Throwable -> L6
        releaseReference();
        return r6;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public short getShort(int r1, int r2) {
        return (short) getLong(r1, r2);
    }

    public int getInt(int r1, int r2) {
        return (int) getLong(r1, r2);
    }

    public float getFloat(int r1, int r2) {
        return (float) getDouble(r1, r2);
    }

    public boolean putBlob(byte[] r4, int r5, int r6) {
        acquireReference();
        boolean r7 = nativePutBlob(this.mWindowPtr, r4, r5 - this.mStartPos, r6);     // Catch: Throwable -> L6
        releaseReference();
        return r7;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public boolean putString(String r4, int r5, int r6) {
        acquireReference();
        boolean r7 = nativePutString(this.mWindowPtr, r4, r5 - this.mStartPos, r6);     // Catch: Throwable -> L6
        releaseReference();
        return r7;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public boolean putLong(long r7, int r9, int r10) {
        acquireReference();
        boolean r8 = nativePutLong(this.mWindowPtr, r7, r9 - this.mStartPos, r10);     // Catch: Throwable -> L6
        releaseReference();
        return r8;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public boolean putDouble(double r7, int r9, int r10) {
        acquireReference();
        boolean r8 = nativePutDouble(this.mWindowPtr, r7, r9 - this.mStartPos, r10);     // Catch: Throwable -> L6
        releaseReference();
        return r8;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public boolean putNull(int r4, int r5) {
        acquireReference();
        boolean r6 = nativePutNull(this.mWindowPtr, r4 - this.mStartPos, r5);     // Catch: Throwable -> L6
        releaseReference();
        return r6;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public static CursorWindow newFromParcel(Parcel r1) {
        return CREATOR.createFromParcel(r1);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.wcdb.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        dispose();
    }

    public String toString() {
        return getName() + " {" + Long.toHexString(this.mWindowPtr) + VectorFormat.DEFAULT_SUFFIX;
    }
}
