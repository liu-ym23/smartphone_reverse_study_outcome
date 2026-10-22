package tmsdk.fg.module.spacemanager.impl.duplicatefile;

import java.util.List;
import tmsdk.common.TMSDKContext;
import tmsdkobf.l8;

/* JADX INFO: loaded from: classes5.dex */
public class DuplicateFileScanner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f78a;

    static {
        l8.a(TMSDKContext.getApplicaionContext(), "duplicate_file_scanner-1.0.1");
    }

    public DuplicateFileScanner() {
        this.f78a = nativeCreateScanner();
    }

    private static native void nativeAddFileTypes(long r0, String[] r2);

    private static native void nativeAddWhiteListDirectories(long r0, String[] r2);

    private static native void nativeCancelScan(long r0);

    private static native void nativeClearFileSizeFilter(long r0);

    private static native void nativeClearFileTypeFilter(long r0);

    private static native void nativeClearWhiteList(long r0);

    private static native long nativeCreateScanner();

    private static native String nativeGetChecksumType(long r0);

    private static native void nativeReleaseScanner(long r0);

    private static native DuplicateFileGroup[] nativeScanDuplicateFiles(long r0, String r2, int r3);

    private static native void nativeSetBytesToRead(long r0, int r2);

    private static native void nativeSetChecksumType(long r0, String r2);

    private static native void nativeSetFileSizeRange(long r0, String r2);

    private static native void nativeSetLogEnabled(long r0, boolean r2);

    public void addFileSizeRange(String r5) {
        long r0 = this.f78a;
        if (r0 == 0) goto L6;
        nativeSetFileSizeRange(r0, r5);
        return;
    }

    public void addFileTypes(List<String> r5) {
        if (this.f78a == 0) goto L9;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L11;
        String[] r6 = (String[]) r5.toArray(new String[0]);
        nativeAddFileTypes(this.f78a, r6);
        return;
    L11:
        return;
    }

    public void addWhiteListDirectories(List<String> r5) {
        if (this.f78a == 0) goto L9;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L11;
        String[] r6 = (String[]) r5.toArray(new String[0]);
        nativeAddWhiteListDirectories(this.f78a, r6);
        return;
    L11:
        return;
    }

    public void cancelScan() {
        long r0 = this.f78a;
        if (r0 == 0) goto L6;
        nativeCancelScan(r0);
        return;
    }

    public void clearFileSizeFilter() {
        long r0 = this.f78a;
        if (r0 == 0) goto L6;
        nativeClearFileSizeFilter(r0);
        return;
    }

    public void clearFileTypeFilter() {
        long r0 = this.f78a;
        if (r0 == 0) goto L6;
        nativeClearFileTypeFilter(r0);
        return;
    }

    public void clearWhiteList() {
        long r0 = this.f78a;
        if (r0 == 0) goto L6;
        nativeClearWhiteList(r0);
        return;
    }

    protected void finalize() {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.f78a == 0) goto L5;
        release();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    public String getChecksumType() {
        long r0 = this.f78a;
        if (r0 != 0) goto L5;
        return "xxhash";
    L5:
        return nativeGetChecksumType(r0);
    }

    public boolean isValid() {
        if (this.f78a == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void release() {
        long r0 = this.f78a;
        if (r0 == 0) goto L6;
        nativeReleaseScanner(r0);
        this.f78a = 0;
        return;
    }

    public DuplicateFileGroup[] scanDuplicateFiles(String r5, int r6) {
        if (this.f78a == 0) goto L11;
        if (r5 == null) goto L11;
        if (r5.isEmpty() == true) goto L11;
        return nativeScanDuplicateFiles(this.f78a, r5, r6);
    L11:
        return new DuplicateFileGroup[0];
    }

    public void setBytesToRead(int r5) {
        long r0 = this.f78a;
        if (r0 == 0) goto L6;
        nativeSetBytesToRead(r0, r5);
        return;
    }

    public void setChecksumType(String r5) {
        if (this.f78a == 0) goto L9;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L11;
        nativeSetChecksumType(this.f78a, r5);
        return;
    L11:
        return;
    }

    public void setLogEnabled(boolean r5) {
        long r0 = this.f78a;
        if (r0 == 0) goto L6;
        nativeSetLogEnabled(r0, r5);
        return;
    }
}
