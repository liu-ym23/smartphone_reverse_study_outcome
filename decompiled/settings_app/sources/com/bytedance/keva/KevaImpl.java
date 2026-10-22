package com.bytedance.keva;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
abstract class KevaImpl extends Keva {
    static final Executor sExecutor = null;
    static final KevaMonitor sMonitor = null;
    private static final String sPortedSpRepoName = null;
    private static final HashMap<String, Keva> sRepoMap = null;
    private static final File sSharedPrefsDir = null;
    private final List<Keva.OnChangeListener> mChangeListeners;
    private List<KevaValueWrapper> mDuplicatedOldWrappers;
    volatile long mHandle;
    private final boolean mIsMultiProcess;
    private final int mMode;
    private final String mName;
    final HashMap<String, KevaValueWrapper> mValueMap;

    static class KevaValueWrapper {
        volatile boolean loaded;
        volatile long offset;
        volatile int type;
        volatile Object value;

        KevaValueWrapper() {
        }
    }

    private static class PortedSpRepoHolder {
        private static final KevaImpl sInstance = null;
        private static final Map<String, ?> sPortedSpMap = null;

        private PortedSpRepoHolder() {
        }

        static /* synthetic */ KevaImpl access$100() {
            return sInstance;
        }

        static /* synthetic */ Map access$300() {
            return sPortedSpMap;
        }

        static {
            KevaMultiProcessImpl r0 = new KevaMultiProcessImpl(KevaImpl.access$000(), 1);
            sInstance = r0;
            r0.init(true);
            sPortedSpMap = r0.buildNewMap(new HashMap());
        }
    }

    protected interface PrivateConstants {
        public static final int BLOCK_TYPE_BYTES = 0;
        public static final int BLOCK_TYPE_OBJECT = 4;
        public static final int BLOCK_TYPE_STRING_ARRAY = 3;
        public static final int BLOCK_TYPE_STRING_UTF16 = 2;
        public static final int BLOCK_TYPE_STRING_UTF8 = 1;
        public static final String EMPTY_STRING = "";
        public static final int EXT_TYPE_BYTES = 7;
        public static final int EXT_TYPE_OBJECT = 71;
        public static final int EXT_TYPE_STRING_ARRAY = 55;
        public static final int EXT_TYPE_STRING_UTF16 = 39;
        public static final int EXT_TYPE_STRING_UTF8 = 23;
        public static final String FILES_DIR_NAME = "files";
        public static final String KEVA = "keva";
        public static final String LIB_NAME = "keva";
        public static final String PORTED_SP = "keva_porting_sp";
        public static final int REPORT_VALUE_SIZE_THRESHOLD = 10000;
        public static final String SP_DIR_NAME = "shared_prefs";
        public static final int TYPE_BOOL = 2;
        public static final int TYPE_BYTES = 7;
        public static final int TYPE_DOUBLE = 5;
        public static final int TYPE_FLOAT = 4;
        public static final int TYPE_INT = 1;
        public static final int TYPE_INVALID = 0;
        public static final int TYPE_LONG = 3;
        public static final int TYPE_STRING = 6;
    }

    static native void checkReportException(long r0);

    private static native void clear(long r0);

    private static native boolean delete(String r0);

    private native void dump(long r1);

    private native void erase(long r1, String r3, long r4);

    private native void eraseUnusedChunk(long r1, long r3);

    private static native void initialize(String r0);

    private native long loadRepo(String r1, int r2, boolean r3);

    private native int protectPortingInterProcess(String r1, boolean r2, int r3);

    private native long storeBoolean(long r1, String r3, long r4, boolean r6);

    private native long storeBytes(long r1, String r3, long r4, byte[] r6, int r7);

    private native long storeDouble(long r1, String r3, long r4, double r6);

    private native long storeFloat(long r1, String r3, long r4, float r6);

    private native long storeInt(long r1, String r3, long r4, int r6);

    private native long storeLong(long r1, String r3, long r4, long r6);

    private native long storeString(long r1, String r3, long r4, String r6);

    private native long storeStringArray(long r1, String r3, long r4, String[] r6, int r7);

    native boolean contains(long r1, String r3, long r4);

    native boolean fetchBoolean(long r1, String r3, long r4, boolean r6);

    protected abstract boolean fetchBoolean(String r1, boolean r2);

    native byte[] fetchBytes(long r1, String r3, long r4, byte[] r6, int r7);

    protected abstract byte[] fetchBytes(String r1, byte[] r2, int r3, boolean r4);

    native double fetchDouble(long r1, String r3, long r4, double r6);

    protected abstract double fetchDouble(String r1, double r2);

    native float fetchFloat(long r1, String r3, long r4, float r6);

    protected abstract float fetchFloat(String r1, float r2);

    native int fetchInt(long r1, String r3, long r4, int r6);

    protected abstract int fetchInt(String r1, int r2);

    native long fetchLong(long r1, String r3, long r4, long r6);

    protected abstract long fetchLong(String r1, long r2);

    native String fetchString(long r1, String r3, long r4, String r6);

    protected abstract String fetchString(String r1, String r2, boolean r3);

    native String[] fetchStringArray(long r1, String r3, long r4, String[] r6, int r7);

    protected abstract String[] fetchStringArray(String r1, String[] r2, boolean r3);

    native void rebuildValueMap(long r1);

    static /* synthetic */ String access$000() {
        return sPortedSpRepoName;
    }

    static /* synthetic */ void access$200(KevaImpl r0, Context r1) {
        r0.doPortingFromSp(r1);
    }

    static /* synthetic */ String access$400(KevaImpl r0) {
        return r0.mName;
    }

    private static Keva getPortedSpRepo() {
        return PortedSpRepoHolder.access$100();
    }

    static {
        KevaBuilder r0 = KevaBuilder.getInstance();
        KevaBuilder.clearInstance();
        sRepoMap = new HashMap();
        Executor r1 = r0.mExecutor;
        if (r1 == null) goto L5;
        sExecutor = r1;
    L6:
        String r2 = r0.mPortedRepoName;
        if (r2 != null) goto L10;
        r2 = PrivateConstants.PORTED_SP;
    L10:
        sPortedSpRepoName = r2;
        Context r3 = r0.mContext;
        File r4 = r3.getFilesDir();
        if (r4 != null) goto L14;
        r4 = new File(r3.getApplicationInfo().dataDir, PrivateConstants.FILES_DIR_NAME);
    L14:
        if (r4.exists() == true) goto L16;
        r4.mkdirs();
    L16:
        File r5 = r0.mWorkDir;
        if (r5 != null) goto L19;
        r5 = new File(r4, "keva");
    L19:
        sSharedPrefsDir = new File(r4.getParent(), PrivateConstants.SP_DIR_NAME);
        KevaMonitor r6 = r0.mMonitor;
        if (r6 != null) goto L23;
        r6 = new KevaMonitor();
    L23:
        sMonitor = r6;
        r6.logDebug("Keva version: 1.6.9.SHARED");
        if (r5.exists() == false) goto L26;
    L33:
        r6.loadLibrary("keva");     // Catch: Throwable -> L30
        initialize(r5.getAbsolutePath());     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
        KevaMonitor r7 = sMonitor;
        r7.logDebug("fail to load so and init");
        r7.reportThrowable(1, null, null, null, th);
        return;
    L26:
        if (r5.mkdirs() == true) goto L33;
        r6.reportThrowable(1, null, null, null, new IllegalStateException("fail to create work dir " + r5.getPath()));
        goto L33
    L5:
        int r8 = Math.max(Runtime.getRuntime().availableProcessors() * 2, 6);
        ThreadPoolExecutor r9 = new ThreadPoolExecutor(r8, r8, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        r9.allowCoreThreadTimeOut(true);
        sExecutor = r9;
        goto L6
    }

    static void forceInitImpl() {
        Log.println(4, KevaConstants.TAG, "force initializing Keva");
    }

    KevaImpl(String r2, int r3) {
        this.mValueMap = new HashMap();
        this.mChangeListeners = new ArrayList();
        this.mDuplicatedOldWrappers = new ArrayList();
        this.mName = r2;
        this.mMode = r3;
        boolean r4 = true;
        if ((r3 & 1) != 0) goto L6;
        r4 = false;
    L6:
        this.mIsMultiProcess = r4;
    }

    void init(boolean r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mHandle == 0) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        doLoadRepo(r5);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    private void cleanUpAfterLoadRepo() {
        if (this.mHandle != 0) goto L14;
        sMonitor.reportWarning(1, this.mName, null, null, "free space is " + Environment.getDataDirectory().getFreeSpace());
        return;
    L14:
        Iterator<KevaValueWrapper> r0 = this.mDuplicatedOldWrappers.iterator();     // Catch: Throwable -> L11
    L7:
        if (r0.hasNext() == false) goto L9;
        eraseUnusedChunk(this.mHandle, r0.next().offset);     // Catch: Throwable -> L11
        goto L7
    L9:
        this.mDuplicatedOldWrappers = null;     // Catch: Throwable -> L11
        checkReportException(this.mHandle);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    public static Keva getRepo(String r1, int r2) {
        return getRepoImpl(r1, r2, false);
    }

    public static Keva getRepoSync(String r1, int r2) {
        return getRepoImpl(r1, r2, true);
    }

    private static Keva getRepoImpl(final String r4, final int r5, boolean r6) {
        HashMap<String, Keva> r0 = sRepoMap;
        monitor-enter(r0);
        Keva r1 = r0.get(r4);     // Catch: Throwable -> L24
        if (r1 != null) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L14;
        if (r6 == false) goto L12;
        Keva r7 = getEmptyRepoImpl(r4, r5);     // Catch: Throwable -> L24
    L11:
        r1 = r7;
        r0.put(r4, r1);     // Catch: Throwable -> L24
        goto L14
    L12:
        r7 = new KevaFuture(r4, r5, new AnonymousClass1(r4, r5));     // Catch: Throwable -> L24
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L24
        if (r3 == false) goto L20;
        if ((r1 instanceof KevaFuture) == true) goto L23;
        ((KevaImpl) r1).init(false);
    L23:
        return r1;
    L20:
        if ((r1 instanceof KevaFuture) == true) goto L22;
        ((KevaImpl) r1).checkMode(r5);
        goto L23
    L22:
        ((KevaFuture) r1).checkMode(r5);
        goto L23
    L7:
        r3 = false;
    L24:
        th = move-exception;
        throw th;
    }

    static KevaImpl getEmptyRepoImpl(String r7, int r8) {
        if (r8 >= 0) goto L4;
    L5:
        sMonitor.reportThrowable(1, r7, null, null, new IllegalArgumentException("mode is not valid! " + r8));
    L7:
        if ((r8 & 1) != 0) goto L10;
        return new KevaPrivateImpl(r7, r8);
    L10:
        return new KevaMultiProcessImpl(r7, r8);
    L4:
        if (r8 < 2) goto L7;
        goto L5
    }

    void checkMode(int r9) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (this.mMode == r9) goto L9;
        sMonitor.reportThrowable(1, this.mName, null, null, new IllegalStateException("mode is different: " + this.mMode + " != " + r9));
        return;
    }

    public static Keva getRepoFromSp(Context r1, String r2, int r3) {
        return getRepoFromSpImpl(r1, r2, r3, false);
    }

    public static Keva getRepoFromSpSync(Context r1, String r2, int r3) {
        return getRepoFromSpImpl(r1, r2, r3, true);
    }

    private static Keva getRepoFromSpImpl(final Context r9, final String r10, final int r11, boolean r12) {
        if (isRepoPorted(r10) == true) goto L5;
        boolean r1 = true;
        if (existSharedPrefs(r10) == true) goto L10;
        getPortedSpRepo().storeBoolean(r10, true);
        return getRepo(r10, r11);
    L10:
        sMonitor.logDebug("do poring from sp: " + r10);
        HashMap<String, Keva> r0 = sRepoMap;
        monitor-enter(r0);
        Keva r2 = r0.get(r10);     // Catch: Throwable -> L35
        if (r2 == null) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L22;
        if (r12 == false) goto L20;
        Keva r13 = getEmptyRepoImpl(r10, r11);     // Catch: Throwable -> L35
    L19:
        r2 = r13;
        r0.put(r10, r2);     // Catch: Throwable -> L35
        goto L22
    L20:
        r13 = new KevaFuture(r10, r11, new AnonymousClass2(r10, r11, r9));     // Catch: Throwable -> L35
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L35
        if (r1 == false) goto L31;
        if ((r2 instanceof KevaImpl) == true) goto L40;
    L34:
        return r2;
    L40:
        ((KevaImpl) r2).doPortingFromSp(r9);     // Catch: UnsatisfiedLinkError -> L28
    L28:
        e = move-exception;
        sMonitor.reportThrowable(1, r10, null, null, e);
        goto L34
    L31:
        if ((r2 instanceof KevaImpl) == false) goto L33;
        ((KevaImpl) r2).checkMode(r11);
        goto L34
    L33:
        ((KevaFuture) r2).checkMode(r11);
    L35:
        th = move-exception;
        throw th;
    L5:
        return getRepo(r10, r11);
    }

    private static boolean existSharedPrefs(String r3) {
        return new File(sSharedPrefsDir, r3 + ".xml").exists();
    }

    private void doPortingFromSp(Context r20) {
        monitor-enter(this);
    L79:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandle == 0) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L79
        return;
    L8:
        boolean r10 = this instanceof KevaMultiProcessImpl;     // Catch: Throwable -> L79
        int r3 = -1;
        if (r10 == false) goto L15;
        r3 = protectPortingInterProcess(this.mName, true, -1);     // Catch: Throwable -> L79
        if (isRepoPorted(this.mName) == false) goto L15;
        doLoadRepo(false);     // Catch: Throwable -> L79
        protectPortingInterProcess(this.mName, false, r3);     // Catch: Throwable -> L79
        monitor-exit(this);     // Catch: Throwable -> L79
        return;
    L15:
        int r13 = r3;
        if (r10 == false) goto L18;
    L20:
        boolean r4 = false;
    L21:
        KevaMonitor r5 = sMonitor;     // Catch: Throwable -> L79
        r5.logDebug("poring load empty repo >> " + this.mName);     // Catch: Throwable -> L79
        doLoadRepo(false);     // Catch: Throwable -> L79
        if (this.mHandle != 0) goto L25;
        monitor-exit(this);     // Catch: Throwable -> L79
        return;
    L25:
        if (r4 == true) goto L27;
        clear();     // Catch: Throwable -> L79
    L27:
        SharedPreferences r2 = r20.getSharedPreferences(this.mName, 0);     // Catch: Throwable -> L79
        r5.logDebug("poring get sp >> " + this.mName);     // Catch: Throwable -> L79
        Map<String, ?> r1 = r2.getAll();     // Catch: Throwable -> L79
        r5.logDebug("poring get all value >> " + this.mName);     // Catch: Throwable -> L79
        Iterator<Map.Entry<String, ?>> r14 = r1.entrySet().iterator();     // Catch: Throwable -> L79
    L29:
        if (r14.hasNext() == false) goto L73;
        Map.Entry<String, ?> r0 = r14.next();     // Catch: Throwable -> L79
        String r6 = r0.getKey();     // Catch: Throwable -> L79
        Object r15 = r0.getValue();     // Catch: Throwable -> L79
        if (r15 == null) goto L29;
        if ("".equals(r6) == false) goto L36;
        r6 = null;
    L36:
        String r8 = r6;
        KevaMonitor r7 = sMonitor;     // Catch: Throwable -> L79
        r7.logDebug("poring process key: " + r8 + ", value: " + r15 + " >> " + this.mName);     // Catch: Throwable -> L79
        KevaValueWrapper r9 = new KevaValueWrapper();     // Catch: Throwable -> L79
        this.mValueMap.put(r8, r9);     // Catch: Throwable -> L79
    L68:
        th = th;
        String r18 = r8;
    L70:
        Throwable r11 = th;
    L71:
        sMonitor.reportThrowable(3, this.mName, r18, r15, r11);     // Catch: Throwable -> L79
        goto L29
    L38:
        if ((r15 instanceof Boolean) == false) goto L44;
        r9.offset = storeBoolean(this.mHandle, r8, r9.offset, ((Boolean) r15).booleanValue());     // Catch: Throwable -> L41
        r9.value = r15;     // Catch: Throwable -> L41
    L40:
        r18 = r8;
    L87:
        if (this.mIsMultiProcess == true) goto L29;
        r9.loaded = true;     // Catch: Throwable -> L66
    L66:
        th = th;
    L41:
        th = move-exception;
        r11 = th;
        r18 = r8;
        goto L71
    L44:
        if ((r15 instanceof Integer) == false) goto L48;
        r9.offset = storeInt(this.mHandle, r8, r9.offset, ((Integer) r15).intValue());     // Catch: Throwable -> L41
        r9.value = r15;     // Catch: Throwable -> L41
        goto L40
    L48:
        if ((r15 instanceof Long) == false) goto L52;
        r18 = r8;
        r9.offset = storeLong(this.mHandle, r8, r9.offset, ((Long) r15).longValue());     // Catch: Throwable -> L66
        r9.value = r15;     // Catch: Throwable -> L66
        goto L87
    L52:
        r18 = r8;
        if ((r15 instanceof Float) == false) goto L56;
        r9.offset = storeFloat(this.mHandle, r18, r9.offset, ((Float) r15).floatValue());     // Catch: Throwable -> L66
        r9.value = r15;     // Catch: Throwable -> L66
        goto L87
    L56:
        if ((r15 instanceof String) == false) goto L59;
        r9.offset = storeString(this.mHandle, r18, r9.offset, (String) r15);     // Catch: Throwable -> L66
        r9.value = r15;     // Catch: Throwable -> L66
        goto L87
    L59:
        if ((r15 instanceof Set) == false) goto L61;
        Set r12 = (Set) r15;     // Catch: Throwable -> L66
        String[] r16 = new String[r12.size()];     // Catch: Throwable -> L66
        r12.toArray(r16);     // Catch: Throwable -> L66
        r9.offset = storeStringArray(this.mHandle, r18, r9.offset, r16, 3);     // Catch: Throwable -> L66
        r9.value = r16;     // Catch: Throwable -> L66
        goto L87
    L61:
        r7.reportThrowable(1, this.mName, r18, r15, new IllegalStateException("do not support type: " + r15.getClass()));     // Catch: Throwable -> L66
        goto L87
    L73:
        getPortedSpRepo().storeBoolean(this.mName, true);     // Catch: Throwable -> L79
        if (r10 == false) goto L76;
        protectPortingInterProcess(this.mName, false, r13);     // Catch: Throwable -> L79
    L76:
        monitor-exit(this);     // Catch: Throwable -> L79
        sMonitor.logDebug("poring set ported repo >> " + this.mName);
        return;
    L18:
        if (delete(this.mName) == false) goto L20;
        r4 = true;
        goto L21
    }

    private void doLoadRepo(boolean r7) {
        this.mHandle = loadRepo(this.mName, this.mMode, r7);     // Catch: Throwable -> L6
        cleanUpAfterLoadRepo();     // Catch: Throwable -> L6
        if (r7 == true) goto L11;
        sMonitor.onLoadRepo(this.mName, this.mMode);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    public static boolean isRepoPorted(String r2) {
        if (PortedSpRepoHolder.access$300().get(r2) == null) goto L7;
        return true;
    L7:
        return getPortedSpRepo().getBoolean(r2, false);
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.mName;
    }

    private void addMapObjectWhenLoading(String r2, Object r3, long r4, int r6) {
        if ("".equals(r2) == false) goto L5;
        r2 = null;
    L5:
        KevaValueWrapper r0 = new KevaValueWrapper();
        r0.value = r3;
        r0.offset = r4;
        r0.type = r6;
        if (this.mIsMultiProcess == true) goto L8;
        r0.loaded = true;
    L8:
        KevaValueWrapper r5 = this.mValueMap.put(r2, r0);
        if (r5 == null) goto L14;
        List<KevaValueWrapper> r1 = this.mDuplicatedOldWrappers;
        if (r1 == null) goto L15;
        r1.add(r5);
        return;
    L15:
        return;
    }

    void addMapOffsetWhenLoading(String r2, long r3, int r5) {
        if ("".equals(r2) == false) goto L5;
        r2 = null;
    L5:
        KevaValueWrapper r0 = new KevaValueWrapper();
        r0.offset = r3;
        r0.type = r5;
        KevaValueWrapper r4 = this.mValueMap.put(r2, r0);
        if (r4 == null) goto L11;
        List<KevaValueWrapper> r1 = this.mDuplicatedOldWrappers;
        if (r1 == null) goto L12;
        r1.add(r4);
        return;
    L12:
        return;
    }

    void addMapIntWhenLoading(String r7, int r8, long r9) {
        addMapObjectWhenLoading(r7, Integer.valueOf(r8), r9, 1);
    }

    void addMapBoolWhenLoading(String r7, boolean r8, long r9) {
        addMapObjectWhenLoading(r7, Boolean.valueOf(r8), r9, 2);
    }

    void addMapFloatWhenLoading(String r7, float r8, long r9) {
        addMapObjectWhenLoading(r7, Float.valueOf(r8), r9, 4);
    }

    void addMapDoubleWhenLoading(String r7, double r8, long r10) {
        addMapObjectWhenLoading(r7, Double.valueOf(r8), r10, 5);
    }

    void addMapLongWhenLoading(String r7, long r8, long r10) {
        addMapObjectWhenLoading(r7, Long.valueOf(r8), r10, 3);
    }

    static void passWarning(int r6, String r7, String r8, Object r9, String r10) {
        sMonitor.reportWarning(r6, r7, r8, r9, r10);
    }

    private KevaValueWrapper obtainWrapperLocked(String r2) {
        KevaValueWrapper r0 = this.mValueMap.get(r2);
        if (r0 != null) goto L6;
        KevaValueWrapper r1 = new KevaValueWrapper();
        this.mValueMap.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    private void reportBigValue(final String r3, final Object r4, final int r5) {
        if (r5 <= 10000) goto L6;
        sExecutor.execute(new AnonymousClass3(this, r3, r4, r5));
        return;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r12) {
        monitor-enter(this);
        Iterator<Map.Entry<String, KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L44
    L5:
        if (r0.hasNext() == false) goto L42;
        Map.Entry<String, KevaValueWrapper> r1 = r0.next();     // Catch: Throwable -> L44
        KevaValueWrapper r2 = r1.getValue();     // Catch: Throwable -> L44
        if (r2.offset == 0) goto L5;
        String r3 = r1.getKey();     // Catch: Throwable -> L44
    L39:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Long.valueOf(r2.offset), th);     // Catch: Throwable -> L44
        goto L5
    L11:
        if (r2.loaded == true) goto L37;
        int r4 = r2.type;     // Catch: Throwable -> L39
        if (r4 != 6) goto L15;
        r2.value = fetchString(this.mHandle, r3, r2.offset, null);     // Catch: Throwable -> L39
    L35:
        if (this.mIsMultiProcess == true) goto L37;
        r2.loaded = true;     // Catch: Throwable -> L39
        goto L37
    L15:
        if (r4 != 7) goto L17;
        r2.value = fetchBytes(this.mHandle, r3, r2.offset, null, 0);     // Catch: Throwable -> L39
        goto L35
    L17:
        if (r4 == 23) goto L31;
        if (r4 == 39) goto L31;
        if (r4 != 55) goto L23;
        r2.value = fetchStringArray(this.mHandle, r3, r2.offset, null, 3);     // Catch: Throwable -> L39
        goto L35
    L23:
        if (this.mIsMultiProcess == false) goto L28;
        if (r2.type <= 5) goto L35;
    L28:
        throw new UnsupportedOperationException("keva has not implemented type " + r2.type);     // Catch: Throwable -> L39
    L31:
        throw new UnsupportedOperationException("keva has not implemented type " + r2.type);     // Catch: Throwable -> L39
    L37:
        r12.put(r3, r2.value);     // Catch: Throwable -> L39
        goto L5
    L42:
        monitor-exit(this);     // Catch: Throwable -> L44
        return r12;
    L44:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r7, byte[] r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        byte[] r9 = fetchBytes(r3, r8, 0, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r7, String r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        String r9 = fetchString(r3, r8, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r7, Set<String> r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        Set<String> r9 = fetchStringSet(r3, r8, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r7, String[] r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        String[] r9 = fetchStringArray(r3, r8, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r7, byte[] r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        byte[] r9 = fetchBytes(r3, r8, 0, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r7, String r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        String r9 = fetchString(r3, r8, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r7, Set<String> r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        Set<String> r9 = fetchStringSet(r3, r8, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r7, String[] r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        String[] r9 = fetchStringArray(r3, r8, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r7, int r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        int r9 = fetchInt(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Integer.valueOf(r8), th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r7, long r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        long r9 = fetchLong(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Long.valueOf(r8), th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r7, double r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        double r9 = fetchDouble(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Double.valueOf(r8), th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r7, float r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        float r9 = fetchFloat(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Float.valueOf(r8), th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r7, boolean r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        boolean r9 = fetchBoolean(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, null, th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r9, float r10) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r7 = obtainWrapperLocked(r9);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r9;
        r7.offset = storeFloat(this.mHandle, r3, r7.offset, r10);     // Catch: Throwable -> L21
        r7.value = Float.valueOf(r10);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r7.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r9);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r9;
        sMonitor.reportThrowable(3, this.mName, r4, Float.valueOf(r10), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r7.loaded == false) goto L29;
        if (r7.value == null) goto L29;
        if (r7.value.equals(Float.valueOf(r10)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r9, int r10) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r7 = obtainWrapperLocked(r9);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r9;
        r7.offset = storeInt(this.mHandle, r3, r7.offset, r10);     // Catch: Throwable -> L21
        r7.value = Integer.valueOf(r10);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r7.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r9);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r9;
        sMonitor.reportThrowable(3, this.mName, r4, Integer.valueOf(r10), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r7.loaded == false) goto L29;
        if (r7.value == null) goto L29;
        if (r7.value.equals(Integer.valueOf(r10)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r9, boolean r10) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r7 = obtainWrapperLocked(r9);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r9;
        r7.offset = storeBoolean(this.mHandle, r3, r7.offset, r10);     // Catch: Throwable -> L21
        r7.value = Boolean.valueOf(r10);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r7.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r9);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r9;
        sMonitor.reportThrowable(3, this.mName, r4, Boolean.valueOf(r10), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r7.loaded == false) goto L29;
        if (r7.value == null) goto L29;
        if (r7.value.equals(Boolean.valueOf(r10)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r10, long r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r10;
        r8.offset = storeLong(this.mHandle, r3, r8.offset, r11);     // Catch: Throwable -> L21
        r8.value = Long.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r8.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r10;
        sMonitor.reportThrowable(3, this.mName, r4, Long.valueOf(r11), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r8.loaded == false) goto L29;
        if (r8.value == null) goto L29;
        if (r8.value.equals(Long.valueOf(r11)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r10, double r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r10;
        r8.offset = storeDouble(this.mHandle, r3, r8.offset, r11);     // Catch: Throwable -> L21
        r8.value = Double.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r8.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r10;
        sMonitor.reportThrowable(3, this.mName, r4, Double.valueOf(r11), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r8.loaded == false) goto L29;
        if (r8.value == null) goto L29;
        if (r8.value.equals(Double.valueOf(r11)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    private void storeString(final String r10, final String r11, boolean r12) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r10);     // Catch: Throwable -> L33
        if (this.mIsMultiProcess == false) goto L9;
    L36:
        r0.offset = storeString(this.mHandle, r10, r0.offset, r11);     // Catch: Throwable -> L24
        r0.type = 6;     // Catch: Throwable -> L24
        if (r12 == true) goto L21;
        r0.value = r11;     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L22;
        r0.loaded = true;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r11 == null) goto L39;
        final int r13 = r11.length();
        if (r13 <= 10000) goto L40;
        sExecutor.execute(new AnonymousClass4(this, r10, r11, r13));
        return;
    L40:
        return;
    L39:
        return;
    L21:
        r0.value = null;     // Catch: Throwable -> L24
        r0.loaded = false;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r10, r11, th);     // Catch: Throwable -> L33
        goto L27
    L9:
        if (r0.loaded == false) goto L36;
        if (r0.value == null) goto L36;
        if (r0.value.equals(r11) == false) goto L36;
        monitor-exit(this);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    }

    private void storeBytes(final String r11, byte[] r12, int r13, boolean r14) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r0.offset = storeBytes(this.mHandle, r11, r0.offset, r12, r13);     // Catch: Throwable -> L15
        r0.type = (r13 << 4) | 7;     // Catch: Throwable -> L15
        if (r14 == true) goto L12;
        r0.value = r12;     // Catch: Throwable -> L15
        if (this.mIsMultiProcess == true) goto L13;
        r0.loaded = true;     // Catch: Throwable -> L15
    L13:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L15
    L18:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r12 == null) goto L31;
        final int r15 = r12.length;
        if (r15 <= 10000) goto L32;
        sExecutor.execute(new AnonymousClass5(this, r11, r15));
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r0.value = null;     // Catch: Throwable -> L15
        r0.loaded = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, r12, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private void storeStringSet(String r2, Set<String> r3, boolean r4) {
        if (r3 == null) goto L4;
        String[] r0 = new String[r3.size()];
        r3.toArray(r0);
    L5:
        storeStringArray(r2, r0, r4);
        return;
    L4:
        r0 = null;
        goto L5
    }

    private void storeStringArray(final String r11, String[] r12, boolean r13) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r0.offset = storeStringArray(this.mHandle, r11, r0.offset, r12, 3);     // Catch: Throwable -> L15
        r0.type = 55;     // Catch: Throwable -> L15
        if (r13 == true) goto L12;
        r0.value = r12;     // Catch: Throwable -> L15
        if (this.mIsMultiProcess == true) goto L13;
        r0.loaded = true;     // Catch: Throwable -> L15
    L13:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L15
    L18:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r12 == null) goto L31;
        final String r14 = Arrays.toString(r12);
        final int r15 = r14.length();
        if (r15 <= 10000) goto L32;
        sExecutor.execute(new AnonymousClass6(this, r11, r14, r15));
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r0.value = null;     // Catch: Throwable -> L15
        r0.loaded = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, null, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r2, String r3) {
        storeString(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r2, Set<String> r3) {
        storeStringSet(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r2, String[] r3) {
        storeStringArray(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r2, byte[] r3) {
        storeBytes(r2, r3, 0, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r2, String r3) {
        storeString(r2, r3, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r2, Set<String> r3) {
        storeStringSet(r2, r3, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r2, String[] r3) {
        storeStringArray(r2, r3, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r3, byte[] r4) {
        storeBytes(r3, r4, 0, true);
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r9) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r9);     // Catch: Throwable -> L10
        erase(this.mHandle, r9, r0.offset);     // Catch: Throwable -> L10
        r0.value = null;     // Catch: Throwable -> L10
        r0.offset = 0;     // Catch: Throwable -> L10
        if (this.mIsMultiProcess == true) goto L13;
        r0.loaded = true;     // Catch: Throwable -> L10
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, r9, null, th);     // Catch: Throwable -> L15
        goto L13
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        monitor-enter(this);
        this.mValueMap.clear();     // Catch: Throwable -> L5
        clear(this.mHandle);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L5:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, null, null, th);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.bytedance.keva.Keva
    public void dump() {
        monitor-enter(this);
        sMonitor.logDebug("start dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L11
        Iterator<Map.Entry<String, KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<String, KevaValueWrapper> r1 = r0.next();     // Catch: Throwable -> L11
        KevaValueWrapper r2 = r1.getValue();     // Catch: Throwable -> L11
        sMonitor.logDebug("key: " + r1.getKey() + ", value: " + r2.value + ", offset: " + r2.offset + ", loaded: " + r2.loaded);     // Catch: Throwable -> L11
        goto L6
    L8:
        sMonitor.logDebug("finish dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void dumpNative() {
        monitor-enter(this);
        dump(this.mHandle);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mChangeListeners.contains(r2) == true) goto L6;
        this.mChangeListeners.add(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r2) {
        monitor-enter(this);
        this.mChangeListeners.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void notifyChangeListeners(Keva r2, String r3) {
        if (this.mChangeListeners.size() != 0) goto L5;
        return;
    L5:
        Iterator<Keva.OnChangeListener> r1 = this.mChangeListeners.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().onChanged(r2, r3);
        goto L7
    }

    private Set<String> fetchStringSet(String r3, Set<String> r4, boolean r5) {
        if (r4 == null) goto L5;
        String[] r6 = (String[]) r4.toArray(new String[0]);
    L6:
        String[] r2 = fetchStringArray(r3, r6, r5);
        if (r2 != null) goto L9;
        return null;
    L9:
        return new HashSet(Arrays.asList(r2));
    L5:
        r6 = null;
        goto L6
    }
}
