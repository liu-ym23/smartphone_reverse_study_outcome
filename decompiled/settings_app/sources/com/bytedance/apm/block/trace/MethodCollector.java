package com.bytedance.apm.block.trace;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.monitor.collector.AbsLooperDispatchListener;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.perf.collector.TraceDataUtils;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class MethodCollector {
    public static final int DEFAULT_STACK_DEPTH = 5;
    public static final int METHOD_ID_DISPATCH = 1048574;
    private static final int METHOD_ID_MAX = 1048575;
    private static final int STATUS_DEFAULT = Integer.MAX_VALUE;
    private static final int STATUS_EXPIRED_START = -2;
    private static final int STATUS_NO_PERMIT = -4;
    private static final int STATUS_OUT_RELEASE = -3;
    private static final int STATUS_READY = 1;
    private static final int STATUS_STARTED = 2;
    private static final int STATUS_STOPPED = -1;
    private static final String TAG = "MethodCollector";
    private static boolean assertIn;
    private static Runnable checkStartExpiredRunnable;
    private static boolean isPauseUpdateTime;
    private static AbsLooperDispatchListener looperMonitorListener;
    private static long[] sBuffer;
    private static volatile long sCurrentDiffTime;
    private static volatile long sDiffTime;
    private static volatile boolean sDontRecord;
    private static Handler sHandler;
    private static int sIndex;
    private static IndexRecord sIndexRecordHead;
    private static IndexRecord sIndexRecordTail;
    private static MethodCollector sInstance;
    private static int sLastIndex;
    private static Thread sMainThread;
    private static volatile Runnable sReleaseOnMainThread;
    private static HandlerThread sTimerUpdateThread;
    private static Runnable sUpdateDiffTimeRunnable;
    private static volatile int status;
    private static final Object statusLock = null;
    private static Object updateTimeLock;

    public static final class IndexRecord {
        int endIndex;
        public int index;
        boolean isValid;
        private IndexRecord next;
        private IndexRecord pre;
        public String source;
        private long timestamp;

        static /* synthetic */ IndexRecord access$1600(IndexRecord r0) {
            return r0.pre;
        }

        static /* synthetic */ IndexRecord access$1602(IndexRecord r0, IndexRecord r1) {
            r0.pre = r1;
            return r1;
        }

        static /* synthetic */ IndexRecord access$1700(IndexRecord r0) {
            return r0.next;
        }

        static /* synthetic */ IndexRecord access$1702(IndexRecord r0, IndexRecord r1) {
            r0.next = r1;
            return r1;
        }

        static /* synthetic */ long access$1800(IndexRecord r2) {
            return r2.timestamp;
        }

        static /* synthetic */ long access$1802(IndexRecord r0, long r1) {
            r0.timestamp = r1;
            return r1;
        }

        public IndexRecord(int r2) {
            this.isValid = true;
            this.index = r2;
        }

        public String toString() {
            return "index:" + this.index + ",\tisValid:" + this.isValid + " source:" + this.source;
        }
    }

    private static long getTime(long r2) {
        return r2 & 8796093022207L;
    }

    public MethodCollector() {
    }

    static /* synthetic */ Runnable access$000() {
        return sReleaseOnMainThread;
    }

    static /* synthetic */ Runnable access$002(Runnable r0) {
        sReleaseOnMainThread = r0;
        return r0;
    }

    static /* synthetic */ int access$100() {
        return status;
    }

    static /* synthetic */ Handler access$1000() {
        return sHandler;
    }

    static /* synthetic */ int access$102(int r0) {
        status = r0;
        return r0;
    }

    static /* synthetic */ AbsLooperDispatchListener access$1100() {
        return looperMonitorListener;
    }

    static /* synthetic */ HandlerThread access$1200() {
        return sTimerUpdateThread;
    }

    static /* synthetic */ long[] access$1302(long[] r0) {
        sBuffer = r0;
        return r0;
    }

    static /* synthetic */ Object access$1400() {
        return statusLock;
    }

    static /* synthetic */ boolean access$1502(boolean r0) {
        sDontRecord = r0;
        return r0;
    }

    static /* synthetic */ void access$200() {
        dispatchBegin();
    }

    static /* synthetic */ void access$300() {
        dispatchEnd();
    }

    static /* synthetic */ boolean access$400() {
        return isPauseUpdateTime;
    }

    static /* synthetic */ long access$500() {
        return sCurrentDiffTime;
    }

    static /* synthetic */ long access$502(long r0) {
        sCurrentDiffTime = r0;
        return r0;
    }

    static /* synthetic */ long access$600() {
        return getCurrentTime();
    }

    static /* synthetic */ long access$700() {
        return sDiffTime;
    }

    static /* synthetic */ Object access$800() {
        return updateTimeLock;
    }

    static /* synthetic */ void access$900() {
        realRelease();
    }

    static {
        sInstance = new MethodCollector();
        status = Integer.MAX_VALUE;
        sDontRecord = false;
        Object r2 = new Object();
        statusLock = r2;
        sBuffer = null;
        sIndex = 0;
        sLastIndex = -1;
        assertIn = false;
        sCurrentDiffTime = getCurrentTime();
        sDiffTime = sCurrentDiffTime;
        sMainThread = Looper.getMainLooper().getThread();
        sReleaseOnMainThread = null;
        sTimerUpdateThread = getTimerUpdateThread();
        sHandler = new Handler(sTimerUpdateThread.getLooper());
        updateTimeLock = new Object();
        isPauseUpdateTime = false;
        checkStartExpiredRunnable = null;
        looperMonitorListener = new AnonymousClass1();
        sUpdateDiffTimeRunnable = new AnonymousClass2();
        sBuffer = new long[600000];
        if (status != Integer.MAX_VALUE) goto L13;
        monitor-enter(r2);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (status != Integer.MAX_VALUE) goto L8;
        realExecute();     // Catch: Throwable -> L10
        status = 1;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r2);     // Catch: Throwable -> L10
    L13:
        i(METHOD_ID_DISPATCH, 0);
        maskIndex("EvilMethodTracer#message_0", AbsLooperDispatchListener.uptime);
        sHandler.postDelayed(new AnonymousClass3(), 15000);
    }

    private static HandlerThread getTimerUpdateThread() {
        HandlerThread r0 = new HandlerThread("trace_time_update_thread");
        r0.start();
        return r0;
    }

    public static MethodCollector getInstance() {
        return sInstance;
    }

    public void onStart() {
        Object r3 = statusLock;
        monitor-enter(r3);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (status < 2) goto L7;
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L15
        return;
    L7:
        if (status < (-2)) goto L13;
        sHandler.removeCallbacks(checkStartExpiredRunnable);     // Catch: Throwable -> L15
        if (sBuffer == null) goto L12;
        status = 2;     // Catch: Throwable -> L15
        sDontRecord = false;     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("MethodCollector sBuffer == null");     // Catch: Throwable -> L15
    }

    public void onStop() {
        Object r2 = statusLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (status != 2) goto L7;
        status = -1;     // Catch: Throwable -> L9
        sDontRecord = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r2);     // Catch: Throwable -> L9
    }

    public boolean isAlive() {
        if (status < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isRealTrace() {
        if (status >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static void realRelease() {
        Object r0 = statusLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (status != Integer.MAX_VALUE) goto L7;
    L8:
        status = -3;     // Catch: Throwable -> L11
        sDontRecord = true;     // Catch: Throwable -> L11
        sReleaseOnMainThread = new AnonymousClass4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (status != (-4)) goto L9;
        goto L8
    }

    public static void releaseForOpt() {
        Object r0 = statusLock;
        monitor-enter(r0);
        status = -3;     // Catch: Throwable -> L8
        sDontRecord = true;     // Catch: Throwable -> L8
        sReleaseOnMainThread = new AnonymousClass5();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static long getCurrentTime() {
        return SystemClock.uptimeMillis();
    }

    public static long getCurrentDiffTime() {
        return sCurrentDiffTime;
    }

    private static void realExecute() {
        sCurrentDiffTime = getCurrentTime() - sDiffTime;
        sHandler.removeCallbacksAndMessages(null);
        sHandler.postDelayed(sUpdateDiffTimeRunnable, 5);
        Handler r0 = sHandler;
        Runnable r1 = new AnonymousClass6();
        checkStartExpiredRunnable = r1;
        r0.postDelayed(r1, 15000);
        LooperMonitor.register(looperMonitorListener);
    }

    public static void unRegisterListener() {
        LooperMonitor.unregister(looperMonitorListener);
    }

    private static void dispatchBegin() {
        sCurrentDiffTime = AbsLooperDispatchListener.uptime - sDiffTime;
        isPauseUpdateTime = false;
        Object r0 = updateTimeLock;
        monitor-enter(r0);
        updateTimeLock.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void dispatchEnd() {
        isPauseUpdateTime = true;
    }

    public static void i(int r3, long r4) {
        if (sDontRecord == false) goto L6;
        return;
    L6:
        if (r3 < METHOD_ID_MAX) goto L9;
        return;
    L9:
        if (Thread.currentThread() == sMainThread) goto L11;
        return;
    L11:
        if (assertIn == false) goto L13;
        return;
    L13:
        assertIn = true;
        if (r4 == 0) goto L16;
        sCurrentDiffTime = r4 - sDiffTime;
        sCurrentDiffTime &= 8796093022207L;
    L16:
        long r5 = ((((long) r3) << 43) | Long.MIN_VALUE) | sCurrentDiffTime;
        long[] r6 = sBuffer;
        int r1 = sIndex;
        r6[r1] = r5;
        int r2 = r1 + 1;
        sIndex = r2;
        if (r2 != 600000) goto L19;
        sIndex = 0;
    L19:
        assertIn = false;
        IndexRecord r7 = sIndexRecordTail;
        if (r7 != null) goto L23;
        return;
    L23:
        if (r7.index != sIndex) goto L30;
        IndexRecord r8 = IndexRecord.access$1600(sIndexRecordTail);
        sIndexRecordTail = r8;
        if (r8 == null) goto L27;
        IndexRecord.access$1702(r8, null);
        return;
    L27:
        sIndexRecordHead = null;
        return;
    }

    public static void o(int r4, long r5) {
        if (sDontRecord == false) goto L6;
        return;
    L6:
        if (r4 < METHOD_ID_MAX) goto L9;
        return;
    L9:
        if (Thread.currentThread() == sMainThread) goto L11;
        return;
    L11:
        if (r5 == 0) goto L13;
        sCurrentDiffTime = r5 - sDiffTime;
        sCurrentDiffTime &= 8796093022207L;
    L13:
        long r6 = ((((long) r4) << 43) | 0) | sCurrentDiffTime;
        long[] r7 = sBuffer;
        int r0 = sIndex;
        r7[r0] = r6;
        int r1 = r0 + 1;
        sIndex = r1;
        if (r1 != 600000) goto L16;
        sIndex = 0;
    L16:
        IndexRecord r8 = sIndexRecordTail;
        if (r8 != null) goto L19;
        return;
    L19:
        if (r8.index != sIndex) goto L27;
        IndexRecord r9 = IndexRecord.access$1600(sIndexRecordTail);
        sIndexRecordTail = r9;
        if (r9 == null) goto L23;
        IndexRecord.access$1702(r9, null);
        return;
    L23:
        sIndexRecordHead = null;
        return;
    }

    public static String getVisibleScene() {
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }

    public static IndexRecord maskIndex(String r4, long r5) {
        if (sIndexRecordHead != null) goto L9;
        IndexRecord r0 = new IndexRecord(sIndex);
        sIndexRecordHead = r0;
        if (r5 > 0) goto L7;
        r5 = SystemClock.uptimeMillis();
    L7:
        IndexRecord.access$1802(r0, r5);
        sIndexRecordHead.source = r4;
        IndexRecord r6 = sIndexRecordHead;
        sIndexRecordTail = r6;
        return r6;
    L9:
        IndexRecord r1 = new IndexRecord(sIndex);
        if (r5 > 0) goto L12;
        r5 = SystemClock.uptimeMillis();
    L12:
        IndexRecord.access$1802(r1, r5);
        r1.source = r4;
        IndexRecord.access$1702(r1, sIndexRecordHead);
        sIndexRecordHead.endIndex = r1.index - 1;
        IndexRecord.access$1602(sIndexRecordHead, r1);
        sIndexRecordHead = r1;
        return r1;
    }

    public IndexRecord getCurrentMethodIndex(String r3) {
        int r2 = sIndex - 1;
        IndexRecord r0 = new IndexRecord(r2);
        r0.source = r3;
        if (r2 < 0) goto L7;
        long[] r4 = sBuffer;
        if (r2 >= r4.length) goto L7;
        IndexRecord.access$1802(r0, getTime(r4[r2]));
    L7:
        return r0;
    }

    public static int getLastMethodIndex() {
        return sIndex - 1;
    }

    public long[] copyData(IndexRecord r3) {
        return copyData(r3, new IndexRecord(sIndex - 1));
    }

    public long[] copyData(IndexRecord r3, IndexRecord r4) {
        if (status != (-3)) goto L6;
        return null;
    L6:
        long[] r0 = new long[0];
        if (r3.isValid == false) goto L13;
        if (r4.isValid == false) goto L13;
        return copyData(r3.index - 1, r4.index);
    L13:
        return r0;
    }

    public long[] copyAllData() {
        IndexRecord r1 = sIndexRecordHead;     // Catch: Throwable -> L16
        if (r1 == null) goto L15;
        IndexRecord r2 = sIndexRecordTail;     // Catch: Throwable -> L16
        if (r2 == null) goto L15;
        if (r1 == r2) goto L15;
        if (r1.endIndex != 0) goto L12;
        int r3 = sIndex - 1;     // Catch: Throwable -> L16
    L13:
        return copyData(sIndexRecordTail.index, r3);
    L12:
        r3 = sIndexRecordHead.endIndex;     // Catch: Throwable -> L16
    L15:
        return null;
    }

    private long[] copyData(long r5, long r7) {
        IndexRecord r0 = sIndexRecordHead;
        if (r0 == null) goto L20;
        IndexRecord r1 = sIndexRecordTail;
        if (r1 == null) goto L29;
    L7:
        if (r0 == r1) goto L15;
        if (IndexRecord.access$1800(IndexRecord.access$1700(r0)) > r7) goto L10;
        if (IndexRecord.access$1800(IndexRecord.access$1600(r1)) >= r5) goto L15;
        r1 = IndexRecord.access$1600(r1);
        goto L7
    L10:
        r0 = IndexRecord.access$1700(r0);
    L15:
        if (r0.endIndex != 0) goto L17;
        int r6 = sIndex - 1;
    L19:
        return copyData(r1.index, r6);
    L17:
        r6 = r0.endIndex;
        goto L19
    L29:
        return null;
    L20:
        return null;
    }

    public long[] copyData(int r4, int r5) {
        long[] r0 = new long[0];
        int r6 = Math.max(0, r4);
        int r7 = Math.max(0, r5);
        if (r7 <= r6) goto L5;
        int r8 = (r7 - r6) + 1;
        long[] r1 = new long[r8];
        System.arraycopy(sBuffer, r6, r1, 0, r8);
        return r1;
    L5:
        if (r7 >= r6) goto L9;
        int r9 = r7 + 1;
        long[] r2 = sBuffer;
        long[] r3 = new long[(r2.length - r6) + r9];
        System.arraycopy(r2, r6, r3, 0, r2.length - r6);
        long[] r10 = sBuffer;
        System.arraycopy(r10, 0, r3, r10.length - r6, r9);
        return r3;
    L9:
        return r0;
    }

    public static long getDiffTime() {
        return sDiffTime;
    }

    public static long getLastMethodTime() {
        return getTime(sBuffer[sIndex - 1]);
    }

    public String getEvilMethod(long r3, long r5) {
        long r0 = SystemClock.uptimeMillis();
        return evilMethodString(copyData(r3, r5), r0);
    }

    public String evilMethodString(long[] r2, long r3) {
        if (r2 != null) goto L5;
        return "";
    L5:
        LinkedList r1 = new LinkedList();
        TraceDataUtils.structuredDataToStack(r2, r1, true, r3);
        TraceDataUtils.trimStack(r1, 1);
        StringBuilder r4 = new StringBuilder();
        TraceDataUtils.stackToString(r1, r4);
        return r4.toString();
    }
}
