package com.bytedance.sliver;

import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class Sliver {
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 19;
    private static final String TAG = "SLIVER";
    private static final Map<Thread, Monitor> cache = null;
    private static final boolean isArt = false;
    private static volatile boolean isInit = false;
    private static final Map<String, Long> mark = null;
    private static final SliverExecutor sDefaultExecutor = null;
    private static final SliverLogger sDefaultLogger = null;
    private static SliverExecutor sExecutor;
    private static SliverLogger sLogger;
    private static boolean sLoggerEnable;
    private static final Field threadPeerField = null;
    private static final Field threadPeerFieldDalvik = null;

    /* JADX INFO: renamed from: com.bytedance.sliver.Sliver$1, reason: invalid class name */
    public static class AnonymousClass1 implements SliverLogger {
        @Override // com.bytedance.sliver.Sliver.SliverLogger
        public final void a(String r1) {
            Log.i(Sliver.TAG, r1);
        }

        @Override // com.bytedance.sliver.Sliver.SliverLogger
        public final void b(String r1, Throwable r2) {
            Log.e(Sliver.TAG, r1, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sliver.Sliver$2, reason: invalid class name */
    public static class AnonymousClass2 implements SliverExecutor {
        @Override // com.bytedance.sliver.Sliver.SliverExecutor
        public final void execute(Runnable r1) {
            AsyncTask.execute(r1);
        }
    }

    public static final enum Mode extends Enum<Mode> {
        public static final Mode b = null;
        public static final Mode c = null;
        public static final /* synthetic */ Mode[] e = null;

        static {
            Mode r0 = new Mode("RING", 0);
            b = r0;
            Mode r1 = new Mode("NORMAL", 1);
            c = r1;
            e = new Mode[]{r0, r1};
        }

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) e.clone();
        }
    }

    public static class Monitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f89a;
        public boolean b;
    }

    public interface SliverExecutor {
        void execute(Runnable r1);
    }

    public interface SliverLogger {
        void a(String r1);

        void b(String r1, Throwable r2);
    }

    public interface ThreadFilter {
        boolean a();
    }

    static {
        cache = new ConcurrentHashMap(16);
        mark = new ConcurrentHashMap(16);
        AnonymousClass1 r0 = new AnonymousClass1();
        sDefaultLogger = r0;
        sLogger = r0;
        sLoggerEnable = false;
        AnonymousClass2 r1 = new AnonymousClass2();
        sDefaultExecutor = r1;
        sExecutor = r1;
        isArt = isArt();
        Field r2 = null;
    L8:
        Field r3 = null;
    L13:
        threadPeerField = r2;
        threadPeerFieldDalvik = r3;
        return;
    L5:
        if (isArt() == false) goto L9;
        Field r4 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L8
    L7:
        Field r5 = r4;
        r3 = r2;
        r2 = r5;
        r2.setAccessible(true);     // Catch: Throwable -> L16
        goto L13
    L9:
        r4 = Thread.class.getDeclaredField("vmThread");     // Catch: Throwable -> L8
        r2 = Class.forName("java.lang.VMThread").getDeclaredField("vmData");     // Catch: Throwable -> L14
        r2.setAccessible(true);     // Catch: Throwable -> L14
    L14:
        r3 = r2;
        r2 = r4;
        goto L13
    }

    public Sliver() {
    }

    public static /* synthetic */ Map access$100() {
        return mark;
    }

    public static /* synthetic */ void access$200(long r0, String r2, long r3) {
        nDump(r0, r2, r3);
    }

    public static /* synthetic */ void access$300(long r0) {
        nClear(r0);
    }

    public static boolean clear() {
        return clear(Thread.currentThread());
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

    public static synchronized boolean dumpAll(String r2) {
        monitor-enter(Sliver.class);
        boolean r3 = dumpAll(r2, false);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    public static void enableLog() {
        sLoggerEnable = true;
    }

    public static synchronized long[] getMethodStackTrace(Thread r6) {
        monitor-enter(Sliver.class);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == true) goto L12;
        long[] r7 = new long[0];     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r7;
    L12:
        long r2 = getThreadPeer(r6);     // Catch: Throwable -> L10
        if (r2 != 0) goto L17;
        long[] r8 = new long[0];     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r8;
    L17:
        long[] r9 = nGetMethodStackTrace(r6, r2);     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r9;
    }

    public static synchronized String getStackTrace(long[] r2) {
        monitor-enter(Sliver.class);
        if (r2 == null) goto L14;
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r2.length == 0) goto L14;
        String r3 = nGetStackTrace(r2);     // Catch: Throwable -> L11
        monitor-exit(Sliver.class);
        return r3;
    L14:
        monitor-exit(Sliver.class);
        return "";
    }

    public static long getThreadPeer(Thread r4) {
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

    public static synchronized boolean init(boolean r4) {
        monitor-enter(Sliver.class);
        onError("not support api : " + Build.VERSION.SDK_INT + ", sliver support 19-31", new Throwable());     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    private static boolean isArt() {
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

    public static int mode2Int(Mode r2) {
        if (r2 != Mode.b) goto L6;
        return 0;
    L6:
        if (r2 != Mode.c) goto L9;
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

    public static void onError(String r1, Throwable r2) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.b(r1, r2);
    }

    public static void onStep(String r1) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.a(r1);
    }

    public static boolean pause() {
        return pause(Thread.currentThread());
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

    public static boolean resume() {
        return resume(Thread.currentThread());
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

    public static void setExecutor(SliverExecutor r0) {
        if (r0 == null) goto L5;
        sExecutor = r0;
        return;
    }

    public static void setLogger(SliverLogger r0) {
        if (r0 == null) goto L5;
        enableLog();
        sLogger = r0;
        return;
    }

    public static boolean start(int r3) {
        return start(Thread.currentThread(), r3, 100000, Mode.b);
    }

    public static boolean startAll(int r3, int r4) {
        return startAll(r3, r4, 50000, Mode.b, null);
    }

    public static boolean stop() {
        return stop(Thread.currentThread());
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

    public static synchronized boolean clear(final Thread r4) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L11;
        onError(r4 + " clear failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L11:
        final Monitor r1 = cache.get(r4);     // Catch: Throwable -> L9
        if (r1 != null) goto L16;
        onError(r4 + " clear failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        sExecutor.execute(new AnonymousClass4(r1, r4));     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean dump(String r1, String r2) {
        return dump(Thread.currentThread(), r1, r2);
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

    public static synchronized boolean pause(Thread r7) {
        monitor-enter(Sliver.class);
        Monitor r1 = cache.get(r7);     // Catch: Throwable -> L9
        if (r1 != null) goto L12;
        onError(r7 + " pause failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L12:
        if (r1.b == true) goto L16;
        onStep(r7 + " already pause");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L16:
        nPause(r1.f89a);     // Catch: Throwable -> L9
        r1.b = false;     // Catch: Throwable -> L9
        onStep(r7 + " pause success");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(Thread r3, int r4) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L11;
        onError(r3 + " reset sampling ms  failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L11:
        Monitor r1 = cache.get(r3);     // Catch: Throwable -> L9
        if (r1 != null) goto L16;
        onError(r3 + " reset sampling ms  failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        nResetSamplingMs(r1.f89a, r4);     // Catch: Throwable -> L9
        onStep(r3 + " reset sampling ms success");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean resume(Thread r6) {
        monitor-enter(Sliver.class);
        Monitor r1 = cache.get(r6);     // Catch: Throwable -> L10
        if (r1 != null) goto L13;
        onError(r6 + " resume failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return false;
    L13:
        if (r1.b == false) goto L17;
        onStep(r6 + " already resume");     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    L17:
        nResume(r1.f89a);     // Catch: Throwable -> L10
        r1.b = true;     // Catch: Throwable -> L10
        onStep(r6 + " resume success");     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean start(Thread r13, int r14, int r15, Mode r16) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (SliverAllThreadSupport.isStart() == false) goto L12;
        onError("sliver start failed , because sliver all thread was started", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L12:
        if (init(false) == true) goto L16;
        onError("sliver start failed , because sliver init failed", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        Map<Thread, Monitor> r9 = cache;     // Catch: Throwable -> L9
        if (r9.containsKey(r13) == false) goto L21;
        onStep(r13 + " already sampling by sliver");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L21:
        long r2 = getThreadPeer(r13);     // Catch: Throwable -> L9
        if (r2 != 0) goto L26;
        onError("sliver start failed , because can't get thread peer", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L26:
        long r1 = nStart(r13, r2, r14, r15, mode2Int(r16));     // Catch: Throwable -> L9
        if (r1 != 0) goto L31;
        onError("sliver start failed , because can't get native peer", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L31:
        Monitor r3 = new Monitor();     // Catch: Throwable -> L9
        r3.f89a = r1;     // Catch: Throwable -> L9
        r3.b = true;     // Catch: Throwable -> L9
        r9.put(r13, r3);     // Catch: Throwable -> L9
        onStep(r13 + " sampling by sliver success");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean startAll(int r3, int r4, int r5, Mode r6, ThreadFilter r7) {
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

    public static synchronized boolean stop(Thread r5) {
        monitor-enter(Sliver.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L12;
        onError(r5 + " stop failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return false;
    L12:
        Monitor r1 = cache.remove(r5);     // Catch: Throwable -> L10
        if (r1 != null) goto L17;
        onError(r5 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    L17:
        nStop(r1.f89a);     // Catch: Throwable -> L10
        onStep(r5 + " stop success");     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean dump(Thread r1, String r2) {
        return dump(r1, r2, false);
    }

    public static boolean dump(Thread r1, String r2, String r3) {
        return dump(r1, r2, false, r3);
    }

    public static synchronized String getStackTrace(Thread r5) {
        monitor-enter(Sliver.class);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == false) goto L8;
        long r1 = getThreadPeer(r5);     // Catch: Throwable -> L10
        if (r1 == 0) goto L15;
        String r6 = nGetStackTrace(r5, r1);     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r6;
    L15:
        monitor-exit(Sliver.class);
        return "";
    L8:
        monitor-exit(Sliver.class);
        return "";
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

    public static synchronized boolean dump(final Thread r9, final String r10, final boolean r11, final String r12) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L11;
        onError(r9 + " dump failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L11:
        final Monitor r5 = cache.get(r9);     // Catch: Throwable -> L9
        if (r5 != null) goto L16;
        onError(r9 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        Runnable r1 = new AnonymousClass3(r12, r5, r10, r9, r11);     // Catch: Throwable -> L9
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L9
        r13.append(r9);     // Catch: Throwable -> L9
        r13.append(" dump ");     // Catch: Throwable -> L9
        if (r11 == false) goto L19;
        String r14 = "sync";
    L20:
        r13.append(r14);     // Catch: Throwable -> L9
        r13.append(" start");     // Catch: Throwable -> L9
        onStep(r13.toString());     // Catch: Throwable -> L9
        if (r11 == false) goto L23;
        r1.run();     // Catch: Throwable -> L9
    L24:
        monitor-exit(Sliver.class);
        return true;
    L23:
        sExecutor.execute(r1);     // Catch: Throwable -> L9
        goto L24
    L19:
        r14 = "async";
        goto L20
    }
}
