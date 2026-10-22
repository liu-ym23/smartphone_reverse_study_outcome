package com.bytedance.apm.trace;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.launch.DefaultLaunchMode;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.LaunchDataDetector;
import com.bytedance.apm.launch.LaunchModeTrigger;
import com.bytedance.apm.launch.evil.LaunchEvilMethodManager;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.PerfMonitorManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class LaunchTrace {
    private static final int LOCK_STACK_DEFAULT_THRESHOLD_MS = 30;
    private static final String TAG = "AppStartStats";
    private static boolean sCollectEvilMethod = false;
    private static TraceStats sTraceStats;

    public static class LaunchMonitor {
        private boolean isDetectBinder;
        private boolean isDetectLock;
        private boolean isDetectLongSleep;
        private boolean isDetectOneMinLock;

        public static class LaunchMonitorBuilder {
            private boolean isDetectBinder;
            private boolean isDetectLock;
            private boolean isDetectLongSleep;
            private boolean isDetectOneMinLock;

            public LaunchMonitorBuilder() {
            }

            public static /* synthetic */ boolean access$000(LaunchMonitorBuilder r0) {
                return r0.isDetectLongSleep;
            }

            public static /* synthetic */ boolean access$100(LaunchMonitorBuilder r0) {
                return r0.isDetectLock;
            }

            public static /* synthetic */ boolean access$200(LaunchMonitorBuilder r0) {
                return r0.isDetectBinder;
            }

            public static /* synthetic */ boolean access$300(LaunchMonitorBuilder r0) {
                return r0.isDetectOneMinLock;
            }

            public LaunchMonitor build() {
                return new LaunchMonitor(this, null);
            }

            public LaunchMonitorBuilder detectBinder() {
                this.isDetectBinder = true;
                return this;
            }

            public LaunchMonitorBuilder detectLock() {
                this.isDetectLock = true;
                return this;
            }

            public LaunchMonitorBuilder detectLongSleep() {
                this.isDetectLongSleep = true;
                return this;
            }

            public LaunchMonitorBuilder detectOneMinLock() {
                this.isDetectOneMinLock = true;
                return this;
            }
        }

        public /* synthetic */ LaunchMonitor(LaunchMonitorBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        public boolean isDetectBinder() {
            return this.isDetectBinder;
        }

        public boolean isDetectLock() {
            return this.isDetectLock;
        }

        public boolean isDetectLongSleep() {
            return this.isDetectLongSleep;
        }

        public boolean isDetectOneMinLock() {
            return this.isDetectOneMinLock;
        }

        private LaunchMonitor(LaunchMonitorBuilder r2) {
            this.isDetectLongSleep = LaunchMonitorBuilder.access$000(r2);
            this.isDetectLock = LaunchMonitorBuilder.access$100(r2);
            this.isDetectBinder = LaunchMonitorBuilder.access$200(r2);
            this.isDetectOneMinLock = LaunchMonitorBuilder.access$300(r2);
        }
    }

    private LaunchTrace() {
    }

    public static void cancelTrace() {
        if (sCollectEvilMethod == false) goto L5;
        LaunchEvilMethodManager.stopMonitorEvilMethod();
    L5:
        TraceStats r0 = sTraceStats;
        if (r0 == null) goto L9;
        r0.cancelTrace();
        sTraceStats = null;
        return;
    }

    public static void endLockDetect() {
        LockMonitorManager.endLockDetect(new JSONObject());
    }

    public static void endSpan(String r1, String r2) {
        TraceStats r0 = sTraceStats;
        if (r0 == null) goto L6;
        r0.endSpan(r1, r2);
        return;
    }

    @Deprecated
    public static void endTask(String r0) {
    }

    public static void endTrace(int r6, String r7, long r8) {
        endTrace(r6, r7, r8, 0);
    }

    public static Pair<DefaultLaunchMode, Long> getDefaultLaunchMode(String r0) {
        return LaunchModeTrigger.getLaunchMode(r0);
    }

    public static long getTraceStartTime() {
        TraceStats r0 = sTraceStats;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getTraceBeginTimestamp();
    }

    public static void recordSpan(String r1, String r2, long r3) {
        TraceStats r0 = sTraceStats;
        if (r0 == null) goto L6;
        r0.recordSpan(r1, r2, r3);
        return;
    }

    @Deprecated
    public static void setLaunchCollectExtraInfoFlag(int r1) {
        boolean r0 = true;
        if ((r1 & 1) != 0) goto L5;
    L8:
        NetDataPipeline.setLaunchCollectExtraInfoFlag(r0);
        return;
    L5:
        if (LaunchAnalysisContext.getInstance().getConfig().isNeedCollectNetData() == true) goto L8;
        r0 = false;
        goto L8
    }

    @Deprecated
    public static void setLaunchCollectExtraInfoTimeMs(long r0) {
        NetDataPipeline.setLaunchCollectExtraInfoTimeMs(r0);
    }

    @Deprecated
    public static void startAndEndTask(String r0, long r1, long r3) {
    }

    @Deprecated
    public static void startDetect(Context r1, @NonNull LaunchMonitor r2) {
        if (ApmContext.isMainProcessSimple() == false) goto L6;
        LaunchDataDetector.startDetect(r1, r2);
        return;
    }

    public static boolean startLockDetect() {
        return startLockDetect(30);
    }

    public static void startSpan(String r1, String r2) {
        TraceStats r0 = sTraceStats;
        if (r0 == null) goto L6;
        r0.startSpan(r1, r2);
        return;
    }

    @Deprecated
    public static void startTask(String r0) {
    }

    @RequiresApi(api = 18)
    public static void startTrace() {
        TraceStats r0 = new TraceStats("start_trace", TraceStatsConsts.START_STATS_NAME);
        sTraceStats = r0;
        r0.startTrace();
        if (ApmContext.isMainProcessSimple() == false) goto L8;
        boolean r1 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        sCollectEvilMethod = r1;
        if (r1 == false) goto L9;
        LaunchEvilMethodManager.startMonitorEvilMethod();
        return;
    L9:
        return;
    }

    public static synchronized void endLockDetect(JSONObject r1) {
        monitor-enter(LaunchTrace.class);
        LockMonitorManager.endLockDetect(r1);     // Catch: Throwable -> L7
        monitor-exit(LaunchTrace.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void endTrace(int r8, String r9, long r10, long r12) {
        if (sCollectEvilMethod == false) goto L5;
        LaunchEvilMethodManager.stopMonitorEvilMethod();
    L5:
        TraceStats r1 = sTraceStats;
        if (r1 == null) goto L9;
        r1.endTrace(r8, r9, r10, r12);
        return;
    }

    public static synchronized boolean startLockDetect(final long r3) {
        monitor-enter(LaunchTrace.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (ApmBaseContext.getContext() != null) goto L10;
        monitor-exit(LaunchTrace.class);
        return false;
    L10:
        if (PerfMonitorManager.getInstance().hasInited() == true) goto L14;
        AsyncEventManager.getInstance().post(new AnonymousClass1(r3));     // Catch: Throwable -> L12
    L15:
        monitor-exit(LaunchTrace.class);
        return true;
    L14:
        LockMonitorManager.startLockDetect(r3);     // Catch: Throwable -> L12
        goto L15
    }

    public static void startSpan(String r1, String r2, boolean r3) {
        TraceStats r0 = sTraceStats;
        if (r0 == null) goto L6;
        r0.startSpan(r1, r2, r3);
        return;
    }

    public static void endTrace(String r6, String r7, long r8) {
        endTrace(r6, r7, r8, 0);
    }

    public static void endTrace(String r8, String r9, long r10, long r12) {
        if (sCollectEvilMethod == false) goto L5;
        LaunchEvilMethodManager.stopMonitorEvilMethod();
    L5:
        TraceStats r1 = sTraceStats;
        if (r1 == null) goto L9;
        r1.endTrace(r8, r9, r10, r12);
        return;
    }

    public static synchronized boolean startLockDetect(final long r3, final boolean r5) {
        monitor-enter(LaunchTrace.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (ApmBaseContext.getContext() != null) goto L10;
        monitor-exit(LaunchTrace.class);
        return false;
    L10:
        if (PerfMonitorManager.getInstance().hasInited() == true) goto L14;
        AsyncEventManager.getInstance().post(new AnonymousClass2(r3, r5));     // Catch: Throwable -> L12
    L15:
        monitor-exit(LaunchTrace.class);
        return true;
    L14:
        LockMonitorManager.startLockDetect(r3, r5);     // Catch: Throwable -> L12
        goto L15
    }
}
