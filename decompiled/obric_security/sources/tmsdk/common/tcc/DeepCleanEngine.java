package tmsdk.common.tcc;

/* JADX INFO: loaded from: classes5.dex */
public class DeepCleanEngine implements IDeepCleanEngine {
    public static final int DEFAULT_TASK_COUNT = 5;
    public static final int INIT_FOR_DEEPCLEAN = 0;
    public static final int INIT_FOR_SPACE_MGR = 1;
    public static final int INIT_FOR_SPACE_MGR_VISIT_ALL = 2;
    public static final boolean SYSTEM_SCAN = false;
    private Callback mCallback;
    private final Object mLock;
    private volatile long mNativePtr;

    public interface Callback {
        String getDetailRule(String r1);

        void onDirectoryChange(String r1, int r2);

        void onFoundComRubbish(String r1, String r2, long r3);

        void onFoundEmptyDir(String r1, long r2);

        void onFoundKeySoftRubbish(String r1, String[] r2, long r3);

        void onFoundSoftRubbish(String r1, String r2, String r3, long r4);

        void onProcessChange(int r1);

        void onVisit(QFile r1);
    }

    public DeepCleanEngine(Callback r2) {
        this.mLock = new Object();
        this.mCallback = r2;
    }

    private native void cancel(long r1);

    private native long create(int r1);

    private native void release(long r1);

    private native void scanPath(long r1, String r3, String r4, int r5);

    private native void setComRubRule(long r1, String[] r3);

    private native void setOtherFilterRule(long r1, String[] r3);

    private native void setRootPaths(long r1, String[] r3);

    private native void setWhitePaths(long r1, String[] r3);

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void cancel() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mNativePtr;     // Catch: Throwable -> L9
        if (0 == r1) goto L7;
        cancel(r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public native String[] findMatchDir(String r1, String r2);

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public String getDetailRule(String r1) {
        Callback r0 = this.mCallback;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getDetailRule(r1);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public boolean init() {
        return init(0);
    }

    public native boolean isMatchComRule(String r1, String r2, String r3);

    public native boolean isMatchFile(String r1, String r2);

    public native boolean isMatchFileSize(long r1, String r3);

    public native int isMatchPath(String r1, String r2);

    public native boolean isMatchTime(long r1, String r3);

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onDirectoryChange(String r1, int r2) {
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onDirectoryChange(r1, r2);
        return;
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onFoundComRubbish(String r1, String r2, long r3) {
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onFoundComRubbish(r1, r2, r3);
        return;
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onFoundEmptyDir(String r1, long r2) {
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onFoundEmptyDir(r1, r2);
        return;
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onFoundKeySoftRubbish(String r1, String[] r2, long r3) {
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onFoundKeySoftRubbish(r1, r2, r3);
        return;
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onFoundSoftRubbish(String r7, String r8, String r9, long r10) {
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onFoundSoftRubbish(r7, r8, r9, r10);
        return;
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onProcessChange(int r1) {
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onProcessChange(r1);
        return;
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onVisit(String r2, boolean r3, long r4, long r6, long r8, long r10) {
        if (this.mCallback == null) goto L10;
        QFile r0 = new QFile(r2);
        if (r3 == false) goto L7;
        int r5 = 4;
    L8:
        r0.type = r5;
        r0.size = r4;
        r0.createTime = r6;
        r0.modifyTime = r8;
        r0.accessTime = r10;
        this.mCallback.onVisit(r0);
        return;
    L7:
        r5 = 0;
        goto L8
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void release() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mNativePtr;     // Catch: Throwable -> L9
        if (r1 == 0) goto L7;
        release(r1);     // Catch: Throwable -> L9
        this.mNativePtr = 0;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void scanPath(String r2, String r3) {
        scanPath(r2, r3, 5);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setComRubRule(String[] r3) {
        setComRubRule(this.mNativePtr, r3);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setOtherFilterRule(String[] r3) {
        setOtherFilterRule(this.mNativePtr, r3);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setRootPaths(String[] r3) {
        setRootPaths(this.mNativePtr, r3);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setUninstallFilterSuffix(String[] r1) {
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setWhitePaths(String[] r3) {
        setWhitePaths(this.mNativePtr, r3);
    }

    public boolean init(int r5) {
        this.mNativePtr = create(r5);     // Catch: Throwable -> L5
    L7:
        if (this.mNativePtr == 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        this.mNativePtr = 0;
        goto L7
    }

    public void scanPath(String r7, String r8, int r9) {
        scanPath(this.mNativePtr, r7, r8, r9);
    }
}
