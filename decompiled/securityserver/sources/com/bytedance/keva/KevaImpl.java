package com.bytedance.keva;

import a.a;
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

/* JADX INFO: loaded from: classes.dex */
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

    public static class KevaValueWrapper {
        volatile boolean loaded;
        volatile long offset;
        volatile int type;
        volatile Object value;

        public KevaValueWrapper() {
        }
    }

    public static class PortedSpRepoHolder {
        private static final KevaImpl sInstance = null;
        private static final Map<String, ?> sPortedSpMap = null;

        static {
            KevaMultiProcessImpl r0 = new KevaMultiProcessImpl(KevaImpl.access$000(), 1);
            sInstance = r0;
            r0.init(true);
            sPortedSpMap = r0.buildNewMap(new HashMap());
        }

        private PortedSpRepoHolder() {
        }

        public static /* synthetic */ KevaImpl access$100() {
            return sInstance;
        }

        public static /* synthetic */ Map access$300() {
            return sPortedSpMap;
        }
    }

    public interface PrivateConstants {
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

    public KevaImpl(String r2, int r3) {
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

    public static /* synthetic */ String access$000() {
        return sPortedSpRepoName;
    }

    public static /* synthetic */ void access$200(KevaImpl r0, Context r1) {
        r0.doPortingFromSp(r1);
    }

    public static /* synthetic */ String access$400(KevaImpl r0) {
        return r0.mName;
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

    public static native void checkReportException(long r0);

    private void cleanUpAfterLoadRepo() {
        if (this.mHandle != 0) goto L15;
        sMonitor.reportWarning(1, this.mName, null, null, "free space is " + Environment.getDataDirectory().getFreeSpace());
        return;
    L15:
        Iterator<KevaValueWrapper> r0 = this.mDuplicatedOldWrappers.iterator();     // Catch: Throwable -> L9
    L7:
        if (r0.hasNext() == false) goto L11;
        eraseUnusedChunk(this.mHandle, r0.next().offset);     // Catch: Throwable -> L9
        goto L7
    L11:
        this.mDuplicatedOldWrappers = null;     // Catch: Throwable -> L9
        checkReportException(this.mHandle);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    private static native void clear(long r0);

    private static native boolean delete(String r0);

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

    private void doPortingFromSp(Context r20) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandle == 0) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        boolean r10 = this instanceof KevaMultiProcessImpl;     // Catch: Throwable -> L8
        int r3 = -1;
        if (r10 == false) goto L17;
        r3 = protectPortingInterProcess(this.mName, true, -1);     // Catch: Throwable -> L8
        if (isRepoPorted(this.mName) == false) goto L17;
        doLoadRepo(false);     // Catch: Throwable -> L8
        protectPortingInterProcess(this.mName, false, r3);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L17:
        int r13 = r3;
        if (r10 == false) goto L20;
    L22:
        boolean r4 = false;
    L23:
        KevaMonitor r5 = sMonitor;     // Catch: Throwable -> L8
        r5.logDebug("poring load empty repo >> " + this.mName);     // Catch: Throwable -> L8
        doLoadRepo(false);     // Catch: Throwable -> L8
        if (this.mHandle != 0) goto L27;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L27:
        if (r4 == true) goto L29;
        clear();     // Catch: Throwable -> L8
    L29:
        SharedPreferences r2 = r20.getSharedPreferences(this.mName, 0);     // Catch: Throwable -> L8
        r5.logDebug("poring get sp >> " + this.mName);     // Catch: Throwable -> L8
        Map<String, ?> r1 = r2.getAll();     // Catch: Throwable -> L8
        r5.logDebug("poring get all value >> " + this.mName);     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, ?>> r14 = r1.entrySet().iterator();     // Catch: Throwable -> L8
    L31:
        if (r14.hasNext() == false) goto L74;
        Map.Entry<String, ?> r0 = r14.next();     // Catch: Throwable -> L8
        String r6 = r0.getKey();     // Catch: Throwable -> L8
        Object r15 = r0.getValue();     // Catch: Throwable -> L8
        if (r15 == null) goto L31;
        if ("".equals(r6) == false) goto L38;
        r6 = null;
    L38:
        String r8 = r6;
        KevaMonitor r7 = sMonitor;     // Catch: Throwable -> L8
        r7.logDebug("poring process key: " + r8 + ", value: " + r15 + " >> " + this.mName);     // Catch: Throwable -> L8
        KevaValueWrapper r9 = new KevaValueWrapper();     // Catch: Throwable -> L8
        this.mValueMap.put(r8, r9);     // Catch: Throwable -> L8
    L56:
        th = th;
        String r18 = r8;
    L55:
        Throwable r11 = th;
    L72:
        sMonitor.reportThrowable(3, this.mName, r18, r15, r11);     // Catch: Throwable -> L8
        goto L31
    L40:
        if ((r15 instanceof Boolean) == false) goto L46;
        r9.offset = storeBoolean(this.mHandle, r8, r9.offset, ((Boolean) r15).booleanValue());     // Catch: Throwable -> L43
        r9.value = r15;     // Catch: Throwable -> L43
    L42:
        r18 = r8;
    L82:
        if (this.mIsMultiProcess == true) goto L31;
        r9.loaded = true;     // Catch: Throwable -> L54
    L54:
        th = th;
    L43:
        th = move-exception;
        r11 = th;
        r18 = r8;
        goto L72
    L46:
        if ((r15 instanceof Integer) == false) goto L50;
        r9.offset = storeInt(this.mHandle, r8, r9.offset, ((Integer) r15).intValue());     // Catch: Throwable -> L43
        r9.value = r15;     // Catch: Throwable -> L43
        goto L42
    L50:
        if ((r15 instanceof Long) == false) goto L58;
        r18 = r8;
        r9.offset = storeLong(this.mHandle, r8, r9.offset, ((Long) r15).longValue());     // Catch: Throwable -> L54
        r9.value = r15;     // Catch: Throwable -> L54
        goto L82
    L58:
        r18 = r8;
        if ((r15 instanceof Float) == false) goto L62;
        r9.offset = storeFloat(this.mHandle, r18, r9.offset, ((Float) r15).floatValue());     // Catch: Throwable -> L54
        r9.value = r15;     // Catch: Throwable -> L54
        goto L82
    L62:
        if ((r15 instanceof String) == false) goto L65;
        r9.offset = storeString(this.mHandle, r18, r9.offset, (String) r15);     // Catch: Throwable -> L54
        r9.value = r15;     // Catch: Throwable -> L54
        goto L82
    L65:
        if ((r15 instanceof Set) == false) goto L67;
        Set r12 = (Set) r15;     // Catch: Throwable -> L54
        String[] r16 = new String[r12.size()];     // Catch: Throwable -> L54
        r12.toArray(r16);     // Catch: Throwable -> L54
        r9.offset = storeStringArray(this.mHandle, r18, r9.offset, r16, 3);     // Catch: Throwable -> L54
        r9.value = r16;     // Catch: Throwable -> L54
        goto L82
    L67:
        r7.reportThrowable(1, this.mName, r18, r15, new IllegalStateException("do not support type: " + r15.getClass()));     // Catch: Throwable -> L54
        goto L82
    L74:
        getPortedSpRepo().storeBoolean(this.mName, true);     // Catch: Throwable -> L8
        if (r10 == false) goto L77;
        protectPortingInterProcess(this.mName, false, r13);     // Catch: Throwable -> L8
    L77:
        monitor-exit(this);     // Catch: Throwable -> L8
        sMonitor.logDebug("poring set ported repo >> " + this.mName);
        return;
    L20:
        if (delete(this.mName) == false) goto L22;
        r4 = true;
        goto L23
    }

    private native void dump(long r1);

    private native void erase(long r1, String r3, long r4);

    private native void eraseUnusedChunk(long r1, long r3);

    private static boolean existSharedPrefs(String r3) {
        return new File(sSharedPrefsDir, a.j(r3, ".xml")).exists();
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

    public static void forceInitImpl() {
        Log.println(4, KevaConstants.TAG, "force initializing Keva");
    }

    public static KevaImpl getEmptyRepoImpl(String r7, int r8) {
        if (r8 >= 0) goto L4;
    L5:
        sMonitor.reportThrowable(1, r7, null, null, new IllegalArgumentException(a.e(r8, "mode is not valid! ")));
    L7:
        if ((r8 & 1) != 0) goto L10;
        return new KevaPrivateImpl(r7, r8);
    L10:
        return new KevaMultiProcessImpl(r7, r8);
    L4:
        if (r8 < 2) goto L7;
        goto L5
    }

    private static Keva getPortedSpRepo() {
        return PortedSpRepoHolder.access$100();
    }

    public static Keva getRepo(String r1, int r2) {
        return getRepoImpl(r1, r2, false);
    }

    public static Keva getRepoFromSp(Context r1, String r2, int r3) {
        return getRepoFromSpImpl(r1, r2, r3, false);
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
        Keva r2 = r0.get(r10);     // Catch: Throwable -> L20
        if (r2 == null) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L24;
        if (r12 == false) goto L22;
        Keva r13 = getEmptyRepoImpl(r10, r11);     // Catch: Throwable -> L20
    L19:
        r2 = r13;
        r0.put(r10, r2);     // Catch: Throwable -> L20
        goto L24
    L22:
        r13 = new KevaFuture(r10, r11, new AnonymousClass2(r10, r11, r9));     // Catch: Throwable -> L20
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (r1 == false) goto L33;
        if ((r2 instanceof KevaImpl) == true) goto L39;
    L36:
        return r2;
    L39:
        ((KevaImpl) r2).doPortingFromSp(r9);     // Catch: UnsatisfiedLinkError -> L30
    L30:
        e = move-exception;
        sMonitor.reportThrowable(1, r10, null, null, e);
        goto L36
    L33:
        if ((r2 instanceof KevaImpl) == false) goto L35;
        ((KevaImpl) r2).checkMode(r11);
        goto L36
    L35:
        ((KevaFuture) r2).checkMode(r11);
    L20:
        th = move-exception;
        throw th;
    L5:
        return getRepo(r10, r11);
    }

    public static Keva getRepoFromSpSync(Context r1, String r2, int r3) {
        return getRepoFromSpImpl(r1, r2, r3, true);
    }

    private static Keva getRepoImpl(final String r4, final int r5, boolean r6) {
        HashMap<String, Keva> r0 = sRepoMap;
        monitor-enter(r0);
        Keva r1 = r0.get(r4);     // Catch: Throwable -> L12
        if (r1 != null) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L16;
        if (r6 == false) goto L14;
        Keva r7 = getEmptyRepoImpl(r4, r5);     // Catch: Throwable -> L12
    L11:
        r1 = r7;
        r0.put(r4, r1);     // Catch: Throwable -> L12
        goto L16
    L14:
        r7 = new KevaFuture(r4, r5, new AnonymousClass1(r4, r5));     // Catch: Throwable -> L12
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r3 == false) goto L22;
        if ((r1 instanceof KevaFuture) == true) goto L25;
        ((KevaImpl) r1).init(false);
    L25:
        return r1;
    L22:
        if ((r1 instanceof KevaFuture) == true) goto L24;
        ((KevaImpl) r1).checkMode(r5);
        goto L25
    L24:
        ((KevaFuture) r1).checkMode(r5);
        goto L25
    L7:
        r3 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public static Keva getRepoSync(String r1, int r2) {
        return getRepoImpl(r1, r2, true);
    }

    private static native void initialize(String r0);

    public static boolean isRepoPorted(String r2) {
        if (PortedSpRepoHolder.access$300().get(r2) == null) goto L7;
        return true;
    L7:
        return getPortedSpRepo().getBoolean(r2, false);
    }

    private native long loadRepo(String r1, int r2, boolean r3);

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

    private KevaValueWrapper obtainWrapperLocked(String r2) {
        KevaValueWrapper r0 = this.mValueMap.get(r2);
        if (r0 != null) goto L6;
        KevaValueWrapper r1 = new KevaValueWrapper();
        this.mValueMap.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    public static void passWarning(int r6, String r7, String r8, Object r9, String r10) {
        sMonitor.reportWarning(r6, r7, r8, r9, r10);
    }

    private native int protectPortingInterProcess(String r1, boolean r2, int r3);

    private void reportBigValue(final String r3, final Object r4, final int r5) {
        if (r5 <= 10000) goto L6;
        sExecutor.execute(new AnonymousClass3(this, r3, r4, r5));
        return;
    }

    private native long storeBoolean(long r1, String r3, long r4, boolean r6);

    private native long storeBytes(long r1, String r3, long r4, byte[] r6, int r7);

    private void storeBytes(final String r11, byte[] r12, int r13, boolean r14) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r0.offset = storeBytes(this.mHandle, r11, r0.offset, r12, r13);     // Catch: Throwable -> L12
        r0.type = (r13 << 4) | 7;     // Catch: Throwable -> L12
        if (r14 == true) goto L14;
        r0.value = r12;     // Catch: Throwable -> L12
        if (this.mIsMultiProcess == true) goto L15;
        r0.loaded = true;     // Catch: Throwable -> L12
    L15:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L12
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
    L14:
        r0.value = null;     // Catch: Throwable -> L12
        r0.loaded = false;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, r12, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private native long storeDouble(long r1, String r3, long r4, double r6);

    private native long storeFloat(long r1, String r3, long r4, float r6);

    private native long storeInt(long r1, String r3, long r4, int r6);

    private native long storeLong(long r1, String r3, long r4, long r6);

    private native long storeString(long r1, String r3, long r4, String r6);

    private void storeString(final String r10, final String r11, boolean r12) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r10);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L37:
        r0.offset = storeString(this.mHandle, r10, r0.offset, r11);     // Catch: Throwable -> L23
        r0.type = 6;     // Catch: Throwable -> L23
        if (r12 == true) goto L25;
        r0.value = r11;     // Catch: Throwable -> L23
        if (this.mIsMultiProcess == true) goto L26;
        r0.loaded = true;     // Catch: Throwable -> L23
    L26:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L23
    L29:
        monitor-exit(this);     // Catch: Throwable -> L16
        if (r11 == null) goto L40;
        final int r13 = r11.length();
        if (r13 <= 10000) goto L41;
        sExecutor.execute(new AnonymousClass4(this, r10, r11, r13));
        return;
    L41:
        return;
    L40:
        return;
    L25:
        r0.value = null;     // Catch: Throwable -> L23
        r0.loaded = false;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r10, r11, th);     // Catch: Throwable -> L16
        goto L29
    L9:
        if (r0.loaded == false) goto L37;
        if (r0.value == null) goto L37;
        if (r0.value.equals(r11) == false) goto L37;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private native long storeStringArray(long r1, String r3, long r4, String[] r6, int r7);

    private void storeStringArray(final String r11, String[] r12, boolean r13) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r0.offset = storeStringArray(this.mHandle, r11, r0.offset, r12, 3);     // Catch: Throwable -> L12
        r0.type = 55;     // Catch: Throwable -> L12
        if (r13 == true) goto L14;
        r0.value = r12;     // Catch: Throwable -> L12
        if (this.mIsMultiProcess == true) goto L15;
        r0.loaded = true;     // Catch: Throwable -> L12
    L15:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L12
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
    L14:
        r0.value = null;     // Catch: Throwable -> L12
        r0.loaded = false;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, null, th);     // Catch: Throwable -> L24
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

    public void addMapBoolWhenLoading(String r7, boolean r8, long r9) {
        addMapObjectWhenLoading(r7, Boolean.valueOf(r8), r9, 2);
    }

    public void addMapDoubleWhenLoading(String r7, double r8, long r10) {
        addMapObjectWhenLoading(r7, Double.valueOf(r8), r10, 5);
    }

    public void addMapFloatWhenLoading(String r7, float r8, long r9) {
        addMapObjectWhenLoading(r7, Float.valueOf(r8), r9, 4);
    }

    public void addMapIntWhenLoading(String r7, int r8, long r9) {
        addMapObjectWhenLoading(r7, Integer.valueOf(r8), r9, 1);
    }

    public void addMapLongWhenLoading(String r7, long r8, long r10) {
        addMapObjectWhenLoading(r7, Long.valueOf(r8), r10, 3);
    }

    public void addMapOffsetWhenLoading(String r2, long r3, int r5) {
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

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r12) {
        monitor-enter(this);
        Iterator<Map.Entry<String, KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L42
    L5:
        if (r0.hasNext() == false) goto L44;
        Map.Entry<String, KevaValueWrapper> r1 = r0.next();     // Catch: Throwable -> L42
        KevaValueWrapper r2 = r1.getValue();     // Catch: Throwable -> L42
        if (r2.offset == 0) goto L5;
        String r3 = r1.getKey();     // Catch: Throwable -> L42
    L27:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Long.valueOf(r2.offset), th);     // Catch: Throwable -> L42
        goto L5
    L11:
        if (r2.loaded == true) goto L39;
        int r4 = r2.type;     // Catch: Throwable -> L27
        if (r4 != 6) goto L15;
        r2.value = fetchString(this.mHandle, r3, r2.offset, null);     // Catch: Throwable -> L27
    L37:
        if (this.mIsMultiProcess == true) goto L39;
        r2.loaded = true;     // Catch: Throwable -> L27
        goto L39
    L15:
        if (r4 != 7) goto L17;
        r2.value = fetchBytes(this.mHandle, r3, r2.offset, null, 0);     // Catch: Throwable -> L27
        goto L37
    L17:
        if (r4 == 23) goto L33;
        if (r4 == 39) goto L33;
        if (r4 != 55) goto L23;
        r2.value = fetchStringArray(this.mHandle, r3, r2.offset, null, 3);     // Catch: Throwable -> L27
        goto L37
    L23:
        if (this.mIsMultiProcess == false) goto L30;
        if (r2.type <= 5) goto L37;
    L30:
        throw new UnsupportedOperationException("keva has not implemented type " + r2.type);     // Catch: Throwable -> L27
    L33:
        throw new UnsupportedOperationException("keva has not implemented type " + r2.type);     // Catch: Throwable -> L27
    L39:
        r12.put(r3, r2.value);     // Catch: Throwable -> L27
        goto L5
    L44:
        monitor-exit(this);     // Catch: Throwable -> L42
        return r12;
    L42:
        th = move-exception;
        throw th;
    }

    public void checkMode(int r8) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (this.mMode == r8) goto L9;
        sMonitor.reportThrowable(1, this.mName, null, null, new IllegalStateException("mode is different: " + this.mMode + " != " + r8));
        return;
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

    public native boolean contains(long r1, String r3, long r4);

    @Override // com.bytedance.keva.Keva
    public void dump() {
        monitor-enter(this);
        sMonitor.logDebug("start dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<String, KevaValueWrapper> r1 = r0.next();     // Catch: Throwable -> L8
        KevaValueWrapper r2 = r1.getValue();     // Catch: Throwable -> L8
        String r3 = r1.getKey();     // Catch: Throwable -> L8
        sMonitor.logDebug("key: " + r3 + ", value: " + r2.value + ", offset: " + r2.offset + ", loaded: " + r2.loaded);     // Catch: Throwable -> L8
        goto L6
    L10:
        sMonitor.logDebug("finish dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
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

    public native boolean fetchBoolean(long r1, String r3, long r4, boolean r6);

    public abstract boolean fetchBoolean(String r1, boolean r2);

    public native byte[] fetchBytes(long r1, String r3, long r4, byte[] r6, int r7);

    public abstract byte[] fetchBytes(String r1, byte[] r2, int r3, boolean r4);

    public native double fetchDouble(long r1, String r3, long r4, double r6);

    public abstract double fetchDouble(String r1, double r2);

    public native float fetchFloat(long r1, String r3, long r4, float r6);

    public abstract float fetchFloat(String r1, float r2);

    public native int fetchInt(long r1, String r3, long r4, int r6);

    public abstract int fetchInt(String r1, int r2);

    public native long fetchLong(long r1, String r3, long r4, long r6);

    public abstract long fetchLong(String r1, long r2);

    public native String fetchString(long r1, String r3, long r4, String r6);

    public abstract String fetchString(String r1, String r2, boolean r3);

    public native String[] fetchStringArray(long r1, String r3, long r4, String[] r6, int r7);

    public abstract String[] fetchStringArray(String r1, String[] r2, boolean r3);

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

    public void init(boolean r5) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mHandle == 0) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        doLoadRepo(r5);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.mName;
    }

    public native void rebuildValueMap(long r1);

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r2) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mChangeListeners.contains(r2) == true) goto L8;
        this.mChangeListeners.add(r2);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r9, boolean r10) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r7 = obtainWrapperLocked(r9);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r3 = r9;
        r7.offset = storeBoolean(this.mHandle, r3, r7.offset, r10);     // Catch: Throwable -> L21
        r7.value = Boolean.valueOf(r10);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r7.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r9);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r4 = r9;
        sMonitor.reportThrowable(3, this.mName, r4, Boolean.valueOf(r10), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r7.loaded == false) goto L30;
        if (r7.value == null) goto L30;
        if (r7.value.equals(Boolean.valueOf(r10)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r3, byte[] r4) {
        storeBytes(r3, r4, 0, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r10, double r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r3 = r10;
        r8.offset = storeDouble(this.mHandle, r3, r8.offset, r11);     // Catch: Throwable -> L21
        r8.value = Double.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r8.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r4 = r10;
        sMonitor.reportThrowable(3, this.mName, r4, Double.valueOf(r11), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r8.loaded == false) goto L30;
        if (r8.value == null) goto L30;
        if (r8.value.equals(Double.valueOf(r11)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r9, float r10) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r7 = obtainWrapperLocked(r9);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r3 = r9;
        r7.offset = storeFloat(this.mHandle, r3, r7.offset, r10);     // Catch: Throwable -> L21
        r7.value = Float.valueOf(r10);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r7.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r9);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r4 = r9;
        sMonitor.reportThrowable(3, this.mName, r4, Float.valueOf(r10), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r7.loaded == false) goto L30;
        if (r7.value == null) goto L30;
        if (r7.value.equals(Float.valueOf(r10)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r9, int r10) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r7 = obtainWrapperLocked(r9);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r3 = r9;
        r7.offset = storeInt(this.mHandle, r3, r7.offset, r10);     // Catch: Throwable -> L21
        r7.value = Integer.valueOf(r10);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r7.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r9);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r4 = r9;
        sMonitor.reportThrowable(3, this.mName, r4, Integer.valueOf(r10), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r7.loaded == false) goto L30;
        if (r7.value == null) goto L30;
        if (r7.value.equals(Integer.valueOf(r10)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r10, long r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r3 = r10;
        r8.offset = storeLong(this.mHandle, r3, r8.offset, r11);     // Catch: Throwable -> L21
        r8.value = Long.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r8.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r4 = r10;
        sMonitor.reportThrowable(3, this.mName, r4, Long.valueOf(r11), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r8.loaded == false) goto L30;
        if (r8.value == null) goto L30;
        if (r8.value.equals(Long.valueOf(r11)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r2, String[] r3) {
        storeStringArray(r2, r3, true);
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
    public void unRegisterChangeListener(Keva.OnChangeListener r2) {
        monitor-enter(this);
        this.mChangeListeners.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r2, Set<String> r3) {
        storeStringSet(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r2, byte[] r3) {
        storeBytes(r2, r3, 0, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r2, String[] r3) {
        storeStringArray(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r2, String r3) {
        storeString(r2, r3, false);
    }
}
