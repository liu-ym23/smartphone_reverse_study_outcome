package com.bytedance.sliver;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class Sliver {
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 19;
    private static final String TAG = "SLIVER";
    private static final Map<Thread, f> cache = null;
    private static final boolean isArt = false;
    private static volatile boolean isInit = false;
    private static final Map<String, Long> mark = null;
    private static final g sDefaultExecutor = null;
    private static final h sDefaultLogger = null;
    private static g sExecutor;
    private static h sLogger;
    private static boolean sLoggerEnable;
    private static final Field threadPeerField = null;
    private static final Field threadPeerFieldDalvik = null;

    static class a implements h {
        a() {
        }

        @Override // com.bytedance.sliver.Sliver.h
        public void a(String r1) {
            Log.i(Sliver.TAG, r1);
        }

        @Override // com.bytedance.sliver.Sliver.h
        public void b(String r1, Throwable r2) {
            Log.e(Sliver.TAG, r1, r2);
        }
    }

    static class b implements g {
        b() {
        }

        @Override // com.bytedance.sliver.Sliver.g
        public void execute(Runnable r1) {
            AsyncTask.execute(r1);
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f5825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f5826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f5827h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Thread f5828i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f5829j;

        c(String r1, f r2, String r3, Thread r4, boolean r5) {
            this.f5825f = r1;
            this.f5826g = r2;
            this.f5827h = r3;
            this.f5828i = r4;
            this.f5829j = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f5825f) == true) goto L7;
            Long r0 = (Long) Sliver.access$100().get(this.f5825f);
            if (r0 == null) goto L7;
            long r1 = r0.longValue();
        L8:
            Sliver.access$200(this.f5826g.f5835a, this.f5827h, r1);
            StringBuilder r2 = new StringBuilder();
            r2.append(this.f5828i);
            r2.append(" dump ");
            if (this.f5829j == false) goto L11;
            String r5 = "sync";
        L12:
            r2.append(r5);
            r2.append(" success");
            Sliver.onStep(r2.toString());
            return;
        L11:
            r5 = "async";
        L7:
            r1 = -1;
            goto L8
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f5830f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Thread f5831g;

        d(f r1, Thread r2) {
            this.f5830f = r1;
            this.f5831g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sliver.access$300(this.f5830f.f5835a);
            Sliver.onStep(this.f5831g + " clear success");
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f5832f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f5833g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ e[] f5834h = null;

        static {
            e r0 = new e("RING", 0);
            f5832f = r0;
            e r1 = new e("NORMAL", 1);
            f5833g = r1;
            f5834h = new e[]{r0, r1};
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) f5834h.clone();
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f5835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5836b;

        private f() {
        }

        /* synthetic */ f(a r1) {
            this();
        }
    }

    public interface g {
        void execute(Runnable r1);
    }

    public interface h {
        void a(String r1);

        void b(String r1, Throwable r2);
    }

    public interface i {
        boolean a(Thread r1);
    }

    static {
        cache = new ConcurrentHashMap(16);
        mark = new ConcurrentHashMap(16);
        a r0 = new a();
        sDefaultLogger = r0;
        sLogger = r0;
        sLoggerEnable = false;
        b r1 = new b();
        sDefaultExecutor = r1;
        sExecutor = r1;
        isArt = isArt();
        Field r2 = null;
    L13:
        Field r3 = null;
    L14:
        threadPeerField = r2;
        threadPeerFieldDalvik = r3;
        return;
    L4:
        if (isArt() == false) goto L7;
        Field r4 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L13
    L6:
        Field r5 = r4;
        r3 = r2;
        r2 = r5;
        r2.setAccessible(true);     // Catch: Throwable -> L16
        goto L14
    L7:
        r4 = Thread.class.getDeclaredField("vmThread");     // Catch: Throwable -> L13
        r2 = Class.forName("java.lang.VMThread").getDeclaredField("vmData");     // Catch: Throwable -> L12
        r2.setAccessible(true);     // Catch: Throwable -> L12
    L12:
        r3 = r2;
        r2 = r4;
        goto L14
    }

    public Sliver() {
    }

    static /* synthetic */ Map access$100() {
        return mark;
    }

    static /* synthetic */ void access$200(long r0, String r2, long r3) {
        nDump(r0, r2, r3);
    }

    static /* synthetic */ void access$300(long r0) {
        nClear(r0);
    }

    public static boolean clear() {
        return clear(Thread.currentThread());
    }

    public static synchronized boolean clear(Thread r4) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r4 + " clear failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        f r1 = cache.get(r4);     // Catch: Throwable -> L18
        if (r1 != null) goto L14;
        onError(r4 + " clear failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        sExecutor.execute(new d(r1, r4));     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean clearAll() {
        monitor-enter(Sliver.class);
        boolean r1 = SliverAllThreadSupport.clearAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean dump(String r1) {
        return dump(Thread.currentThread(), r1);
    }

    public static boolean dump(String r1, String r2) {
        return dump(Thread.currentThread(), r1, r2);
    }

    public static boolean dump(Thread r1, String r2) {
        return dump(r1, r2, false);
    }

    public static boolean dump(Thread r1, String r2, String r3) {
        return dump(r1, r2, false, r3);
    }

    public static synchronized boolean dump(Thread r2, String r3, boolean r4) {
        monitor-enter(Sliver.class);
        boolean r5 = dump(r2, r3, r4, null);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r5;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean dump(Thread r9, String r10, boolean r11, String r12) {
        monitor-enter(Sliver.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r9 + " dump failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L25
        monitor-exit(Sliver.class);
        return false;
    L9:
        f r5 = cache.get(r9);     // Catch: Throwable -> L25
        if (r5 != null) goto L14;
        onError(r9 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L25
        monitor-exit(Sliver.class);
        return false;
    L14:
        c r1 = new c(r12, r5, r10, r9, r11);     // Catch: Throwable -> L25
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L25
        r13.append(r9);     // Catch: Throwable -> L25
        r13.append(" dump ");     // Catch: Throwable -> L25
        if (r11 == false) goto L17;
        String r14 = "sync";
    L18:
        r13.append(r14);     // Catch: Throwable -> L25
        r13.append(" start");     // Catch: Throwable -> L25
        onStep(r13.toString());     // Catch: Throwable -> L25
        if (r11 == false) goto L21;
        r1.run();     // Catch: Throwable -> L25
    L23:
        monitor-exit(Sliver.class);
        return true;
    L21:
        sExecutor.execute(r1);     // Catch: Throwable -> L25
        goto L23
    L17:
        r14 = "async";
        goto L18
    }

    public static synchronized boolean dumpAll(String r2) {
        monitor-enter(Sliver.class);
        boolean r3 = dumpAll(r2, false);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean dumpAll(String r1, boolean r2) {
        monitor-enter(Sliver.class);
        boolean r3 = SliverAllThreadSupport.dumpAll(r1, r2);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static void enableLog() {
        sLoggerEnable = true;
    }

    public static synchronized long[] getMethodStackTrace(Thread r6) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == true) goto L10;
        long[] r7 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r7;
    L10:
        long r2 = getThreadPeer(r6);     // Catch: Throwable -> L18
        if (r2 != 0) goto L15;
        long[] r8 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r8;
    L15:
        long[] r9 = nGetMethodStackTrace(r6, r2);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r9;
    }

    public static synchronized String getStackTrace(Thread r5) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == false) goto L8;
        long r1 = getThreadPeer(r5);     // Catch: Throwable -> L18
        if (r1 == 0) goto L13;
        String r6 = nGetStackTrace(r5, r1);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r6;
    L13:
        monitor-exit(Sliver.class);
        return "";
    L8:
        monitor-exit(Sliver.class);
        return "";
    }

    public static synchronized String getStackTrace(long[] r2) {
        monitor-enter(Sliver.class);
        if (r2 == null) goto L12;
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r2.length == 0) goto L12;
        String r3 = nGetStackTrace(r2);     // Catch: Throwable -> L14
        monitor-exit(Sliver.class);
        return r3;
    L12:
        monitor-exit(Sliver.class);
        return "";
    }

    static long getThreadPeer(Thread r4) {
        if (isArt() == false) goto L11;
        Field r0 = threadPeerField;
        if (r0 == null) goto L24;
        Object r5 = r0.get(r4);     // Catch: Throwable -> L21
        if (r5 != null) goto L10;
        return 0;
    L10:
        return ((Long) r5).longValue();
    L24:
        return 0;
    L11:
        Field r1 = threadPeerField;
        if (r1 == null) goto L25;
        Field r3 = threadPeerFieldDalvik;
        if (r3 == null) goto L26;
        Object r6 = r3.get(r1.get(r4));     // Catch: Throwable -> L21
        if (r6 != null) goto L20;
        return 0;
    L20:
        return ((Integer) r6).intValue();
    L26:
        return 0;
    L25:
        return 0;
    L28:
        return 0;
    }

    public static synchronized boolean init(boolean r8) {
        monitor-enter(Sliver.class);
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L30
        if (r1 < 19) goto L27;
        if (r1 > 31) goto L27;
        if (isInit == false) goto L14;
        onStep("sliver already init");     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return true;
    L14:
        if (loadLibrary() == true) goto L17;
        monitor-exit(Sliver.class);
        return false;
    L17:
        Method r2 = null;
        r2 = Looper.class.getMethod("loop", new Class[0]);     // Catch: Throwable -> L33
    L20:
        if (nInit(r1, r2, r8, isArt) == true) goto L24;
        onError("sliver init failed, because native init error", new Throwable());     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return false;
    L24:
        isInit = true;     // Catch: Throwable -> L30
        onStep("sliver init success, protect is " + r8);     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return true;
    L27:
        onError("not support api : " + r1 + ", sliver support 19-31", new Throwable());     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return false;
    L30:
        th = move-exception;
        throw th;
    }

    private static boolean isArt() {
        if (Build.VERSION.SDK_INT >= 21) goto L18;
        String r0 = System.getProperty("java.vm.version");
        if (r0 == null) goto L19;
        Matcher r1 = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(r0);
        if (r1.matches() == false) goto L20;
        int r2 = Integer.parseInt(r1.group(1));     // Catch: Throwable -> L15
        int r3 = Integer.parseInt(r1.group(2));     // Catch: Throwable -> L15
        if (r2 > 2) goto L21;
        if (r2 != 2) goto L14;
        if (r3 < 1) goto L14;
        return true;
    L14:
        return false;
    L21:
        return true;
    L23:
        return true;
    L20:
        return true;
    L19:
        return true;
    L18:
        return true;
    }

    private static boolean loadLibrary() {
        System.loadLibrary("sliver");     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        onError("sliver so load failed", th);
        return false;
    }

    public static void mark(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        mark.put(r3, Long.valueOf(System.nanoTime()));
    }

    static int mode2Int(e r2) {
        if (r2 != e.f5832f) goto L6;
        return 0;
    L6:
        if (r2 != e.f5833g) goto L9;
        return 1;
    L9:
        return 0;
    }

    private static native void nClear(long r0);

    private static native void nDump(long r0, String r2, long r3);

    private static native long[] nGetMethodStackTrace(Thread r0, long r1);

    private static native String nGetStackTrace(Thread r0, long r1);

    private static native String nGetStackTrace(long[] r0);

    private static native boolean nInit(int r0, Method r1, boolean r2, boolean r3);

    private static native void nPause(long r0);

    private static native void nResetSamplingMs(long r0, int r2);

    private static native void nResume(long r0);

    private static native long nStart(Thread r0, long r1, int r3, int r4, int r5);

    private static native void nStop(long r0);

    static void onError(String r1, Throwable r2) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.b(r1, r2);
    }

    static void onStep(String r1) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.a(r1);
    }

    public static boolean pause() {
        return pause(Thread.currentThread());
    }

    public static synchronized boolean pause(Thread r7) {
        monitor-enter(Sliver.class);
        f r1 = cache.get(r7);     // Catch: Throwable -> L17
        if (r1 != null) goto L10;
        onError(r7 + " pause failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (r1.f5836b == true) goto L14;
        onStep(r7 + " already pause");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L14:
        nPause(r1.f5835a);     // Catch: Throwable -> L17
        r1.f5836b = false;     // Catch: Throwable -> L17
        onStep(r7 + " pause success");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L17:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean pauseAll() {
        monitor-enter(Sliver.class);
        boolean r1 = SliverAllThreadSupport.pauseAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(int r2) {
        monitor-enter(Sliver.class);
        boolean r3 = resetSamplingMs(Thread.currentThread(), r2);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(Thread r3, int r4) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r3 + " reset sampling ms  failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        f r1 = cache.get(r3);     // Catch: Throwable -> L18
        if (r1 != null) goto L14;
        onError(r3 + " reset sampling ms  failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        nResetSamplingMs(r1.f5835a, r4);     // Catch: Throwable -> L18
        onStep(r3 + " reset sampling ms success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean resume() {
        return resume(Thread.currentThread());
    }

    public static synchronized boolean resume(Thread r6) {
        monitor-enter(Sliver.class);
        f r1 = cache.get(r6);     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        onError(r6 + " resume failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L11:
        if (r1.f5836b == false) goto L15;
        onStep(r6 + " already resume");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nResume(r1.f5835a);     // Catch: Throwable -> L18
        r1.f5836b = true;     // Catch: Throwable -> L18
        onStep(r6 + " resume success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resumeAll() {
        monitor-enter(Sliver.class);
        boolean r1 = SliverAllThreadSupport.resumeAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setExecutor(g r0) {
        if (r0 == null) goto L5;
        sExecutor = r0;
        return;
    }

    public static void setLogger(h r0) {
        if (r0 == null) goto L5;
        enableLog();
        sLogger = r0;
        return;
    }

    public static boolean start(int r3) {
        return start(Thread.currentThread(), r3, 100000, e.f5832f);
    }

    public static synchronized boolean start(Thread r13, int r14, int r15, e r16) {
        monitor-enter(Sliver.class);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (SliverAllThreadSupport.isStart() == false) goto L10;
        onError("sliver start failed , because sliver all thread was started", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (init(false) == true) goto L14;
        onError("sliver start failed , because sliver init failed", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L14:
        Map<Thread, f> r9 = cache;     // Catch: Throwable -> L32
        if (r9.containsKey(r13) == false) goto L19;
        onStep(r13 + " already sampling by sliver");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    L19:
        long r2 = getThreadPeer(r13);     // Catch: Throwable -> L32
        if (r2 != 0) goto L24;
        onError("sliver start failed , because can't get thread peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L24:
        long r1 = nStart(r13, r2, r14, r15, mode2Int(r16));     // Catch: Throwable -> L32
        if (r1 != 0) goto L29;
        onError("sliver start failed , because can't get native peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L29:
        f r3 = new f(null);     // Catch: Throwable -> L32
        r3.f5835a = r1;     // Catch: Throwable -> L32
        r3.f5836b = true;     // Catch: Throwable -> L32
        r9.put(r13, r3);     // Catch: Throwable -> L32
        onStep(r13 + " sampling by sliver success");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean startAll(int r3, int r4) {
        return startAll(r3, r4, 50000, e.f5832f, null);
    }

    public static synchronized boolean startAll(int r3, int r4, int r5, e r6, i r7) {
        monitor-enter(Sliver.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (cache.isEmpty() == true) goto L10;
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (init(false) == true) goto L13;
        monitor-exit(Sliver.class);
        return false;
    L13:
        boolean r8 = SliverAllThreadSupport.startAll(r3, r4, r5, r6, r7);     // Catch: Throwable -> L16
        monitor-exit(Sliver.class);
        return r8;
    }

    public static boolean stop() {
        return stop(Thread.currentThread());
    }

    public static synchronized boolean stop(Thread r5) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L10;
        onError(r5 + " stop failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L10:
        f r1 = cache.remove(r5);     // Catch: Throwable -> L18
        if (r1 != null) goto L15;
        onError(r5 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nStop(r1.f5835a);     // Catch: Throwable -> L18
        onStep(r5 + " stop success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean stopAll() {
        monitor-enter(Sliver.class);
        boolean r1 = SliverAllThreadSupport.stopAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
