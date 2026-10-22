package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class TraceEvent implements AutoCloseable {
    public static final long ATRACE_TAG_APP = 4096;
    public static final long ATRACE_TAG_WEBVIEW = 16;
    private static ATrace sATrace;
    private static volatile boolean sEnabled;
    private static boolean sEventNameFilteringEnabled;
    private static AtomicBoolean sNativeTracingReady;
    private static AtomicBoolean sUiThreadReady;
    private final String mName;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.TraceEvent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ATrace implements MessageQueue.IdleHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String TAG = "ATrace";
        private Method mAsyncTraceBeginMethod;
        private Method mAsyncTraceEndMethod;
        private Method mGetSystemPropertyMethod;
        private boolean mIdleHandlerRegistered;
        private Method mIsTraceTagEnabledMethod;
        private final AtomicBoolean mNativeTracingReady;
        private boolean mShouldWriteToSystemTrace;
        private Class<?> mSystemPropertiesClass;
        private Method mTraceBeginMethod;
        private Class<?> mTraceClass;
        private Method mTraceEndMethod;
        private final long mTraceTag;
        private final AtomicBoolean mTraceTagActive;
        private final AtomicBoolean mUiThreadReady;

        public static class CategoryConfig {
            public String filter;
            public boolean shouldWriteToATrace;

            private CategoryConfig() {
                this.filter = "";
                this.shouldWriteToATrace = true;
            }

            public /* synthetic */ CategoryConfig(AnonymousClass1 r1) {
                this();
            }
        }

        public ATrace(long r7) {
            this.mNativeTracingReady = new AtomicBoolean();
            this.mUiThreadReady = new AtomicBoolean();
            this.mTraceTagActive = new AtomicBoolean();
            Class<?> r1 = Class.forName("android.os.Trace");     // Catch: Exception -> L5
            this.mTraceClass = r1;     // Catch: Exception -> L5
            Class r3 = Long.TYPE;     // Catch: Exception -> L5
            this.mIsTraceTagEnabledMethod = r1.getMethod("isTagEnabled", new Class[]{r3});     // Catch: Exception -> L5
            this.mTraceBeginMethod = this.mTraceClass.getMethod("traceBegin", new Class[]{r3, String.class});     // Catch: Exception -> L5
            this.mTraceEndMethod = this.mTraceClass.getMethod("traceEnd", new Class[]{r3});     // Catch: Exception -> L5
            Class<?> r2 = this.mTraceClass;     // Catch: Exception -> L5
            Class r4 = Integer.TYPE;     // Catch: Exception -> L5
            this.mAsyncTraceBeginMethod = r2.getMethod("asyncTraceBegin", new Class[]{r3, String.class, r4});     // Catch: Exception -> L5
            this.mAsyncTraceEndMethod = this.mTraceClass.getMethod("asyncTraceEnd", new Class[]{r3, String.class, r4});     // Catch: Exception -> L5
            Class<?> r5 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L5
            this.mSystemPropertiesClass = r5;     // Catch: Exception -> L5
            this.mGetSystemPropertyMethod = r5.getMethod("get", new Class[]{String.class});     // Catch: Exception -> L5
        L7:
            this.mTraceTag = r7;
            pollConfig();
            return;
        L5:
            e = move-exception;
            Log.w(TAG, "Reflection error", new Object[]{e});
            this.mIsTraceTagEnabledMethod = null;
            goto L7
        }

        public static /* synthetic */ void a(ATrace r0) {
            r0.lambda$onNativeTracingReady$0();
        }

        public static /* synthetic */ void b(ATrace r0) {
            r0.lambda$onUiThreadReady$1();
        }

        private void disableNativeATrace() {
            TraceEventJni.get().stopATrace();
        }

        private void enableNativeATrace(String r1) {
            TraceEventJni.get().startATrace(r1);
        }

        private CategoryConfig getCategoryConfigFromATrace() {
            CategoryConfig r0 = new CategoryConfig(null);
            Integer r1 = getIntegerSystemProperty("debug.atrace.app_number");
            if (r1 != null) goto L5;
        L30:
            return r0;
        L5:
            if (r1.intValue() <= 0) goto L30;
            if (ContextUtils.getApplicationContext() == null) goto L30;
            String r2 = ContextUtils.getApplicationContext().getPackageName();
            int r4 = 0;
        L10:
            if (r4 >= r1.intValue()) goto L30;
            String r5 = getSystemProperty(a.a.e(r4, "debug.atrace.app_"));
            if (r5 == null) goto L29;
            if (r5.startsWith(r2) == false) goto L29;
            String r6 = r5.substring(r2.length());
            if (r6.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L29;
            String[] r7 = r6.substring(1).split(":");
            int r8 = r7.length;
            int r9 = 0;
        L20:
            if (r9 >= r8) goto L29;
            String r10 = r7[r9];
            if (r10.equals("-atrace") == false) goto L25;
            r0.shouldWriteToATrace = false;
        L28:
            r9 = r9 + 1;
            goto L20
        L25:
            if (r0.filter.length() <= 0) goto L27;
            r0.filter = a.a.o(new StringBuilder(), r0.filter, ",");
        L27:
            r0.filter = a.a.o(new StringBuilder(), r0.filter, r10);
        L29:
            r4 = r4 + 1;
            goto L10
        }

        private Integer getIntegerSystemProperty(String r1) {
            String r0 = getSystemProperty(r1);
            if (r0 != null) goto L8;
            return null;
        L8:
            return Integer.decode(r0);
        L7:
            return null;
        }

        @Nullable
        private String getSystemProperty(String r2) {
            return (String) this.mGetSystemPropertyMethod.invoke(this.mSystemPropertiesClass, new Object[]{r2});
        L4:
            return null;
        }

        private boolean isTraceTagEnabled(long r2) {
            return ((Boolean) this.mIsTraceTagEnabledMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(r2)})).booleanValue();
        L4:
            return false;
        }

        private /* synthetic */ void lambda$onNativeTracingReady$0() {
            pollConfig();
        }

        private /* synthetic */ void lambda$onUiThreadReady$1() {
            startPolling();
        }

        @UiThread
        private boolean pollConfig() {
            boolean r0 = this.mTraceTagActive.get();
            boolean r1 = isTraceTagEnabled(this.mTraceTag);
            if (r0 != r1) goto L5;
            return false;
        L5:
            this.mTraceTagActive.set(r1);
            if (r1 == true) goto L9;
            EarlyTraceEvent.disable();
            disableNativeATrace();
            this.mShouldWriteToSystemTrace = false;
            ThreadUtils.getUiThreadLooper().setMessageLogging(null);
            return true;
        L9:
            CategoryConfig r2 = getCategoryConfigFromATrace();
            this.mShouldWriteToSystemTrace = false;
            if (this.mNativeTracingReady.get() == false) goto L16;
            if (r2.shouldWriteToATrace == false) goto L14;
            enableNativeATrace(r2.filter);
        L20:
            if (r2.shouldWriteToATrace == true) goto L22;
            ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$000());
        L22:
            return true;
        L14:
            setupATraceStartupTrace(r2.filter);
            goto L20
        L16:
            if (r2.shouldWriteToATrace == false) goto L18;
            this.mShouldWriteToSystemTrace = true;
            goto L20
        L18:
            EarlyTraceEvent.enable();
            goto L20
        }

        private void setupATraceStartupTrace(String r1) {
            TraceEventJni.get().setupATraceStartupTrace(r1);
        }

        private void startPolling() {
            ThreadUtils.assertOnUiThread();
            if (this.mIdleHandlerRegistered == true) goto L5;
            Looper.myQueue().addIdleHandler(this);
            this.mIdleHandlerRegistered = true;
        L5:
            pollConfig();
        }

        public void asyncTraceBegin(String r5, int r6) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r5, Integer.valueOf(r6)});     // Catch: Exception -> L7
            return;
        }

        public void asyncTraceEnd(String r5, int r6) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r5, Integer.valueOf(r6)});     // Catch: Exception -> L7
            return;
        }

        public boolean hasActiveSession() {
            return this.mTraceTagActive.get();
        }

        @AnyThread
        public void onNativeTracingReady() {
            this.mNativeTracingReady.set(true);
            this.mTraceTagActive.set(false);
            if (this.mUiThreadReady.get() == false) goto L6;
            ThreadUtils.postOnUiThread(new g(this, 1));
            return;
        }

        @AnyThread
        public void onUiThreadReady() {
            this.mUiThreadReady.set(true);
            if (ThreadUtils.runningOnUiThread() == true) goto L6;
            ThreadUtils.postOnUiThread(new g(this, 0));
            return;
        L6:
            startPolling();
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            pollConfig();
            return true;
        }

        public void traceBegin(String r5) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r5});     // Catch: Exception -> L7
            return;
        }

        public void traceEnd() {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag)});     // Catch: Exception -> L7
            return;
        }
    }

    @VisibleForTesting(otherwise = 2)
    public static class BasicLooperMonitor implements Printer {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @VisibleForTesting(otherwise = 2)
        static final String FILTERED_EVENT_NAME = "Looper.dispatch: EVENT_NAME_FILTERED";

        @VisibleForTesting(otherwise = 2)
        static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        private static final int SHORTEST_LOG_PREFIX_LENGTH = 18;
        private String mCurrentTarget;

        public BasicLooperMonitor() {
        }

        private static String getTarget(String r3) {
            int r0 = r3.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            if (r0 != (-1)) goto L5;
            int r2 = -1;
        L6:
            if (r2 != (-1)) goto L10;
            return "";
        L10:
            return r3.substring(r0 + 1, r2);
        L5:
            r2 = r3.indexOf(41, r0);
            goto L6
        }

        private static String getTargetName(String r3) {
            int r0 = r3.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
            if (r0 != (-1)) goto L5;
            int r2 = -1;
        L6:
            if (r2 != (-1)) goto L8;
            r2 = r3.length();
        L8:
            if (r0 != (-1)) goto L12;
            return "";
        L12:
            return r3.substring(r0 + 2, r2);
        L5:
            r2 = r3.indexOf(58, r0);
            goto L6
        }

        @VisibleForTesting(otherwise = 2)
        public static String getTraceEventName(String r2) {
            if (TraceEvent.access$300() == false) goto L6;
            return FILTERED_EVENT_NAME;
        L6:
            StringBuilder r0 = new StringBuilder(LOOPER_TASK_PREFIX);
            r0.append(getTarget(r2));
            r0.append("(");
            return a.a.o(r0, getTargetName(r2), ")");
        }

        public void beginHandling(String r3) {
            boolean r0 = EarlyTraceEvent.enabled();
            if (TraceEvent.access$200() == true) goto L5;
            if (r0 == true) goto L5;
            return;
        L5:
            this.mCurrentTarget = getTraceEventName(r3);
            if (TraceEvent.access$200() == false) goto L8;
            TraceEventJni.get().beginToplevel(this.mCurrentTarget);
            return;
        L8:
            EarlyTraceEvent.begin(this.mCurrentTarget, true);
        }

        public void endHandling(String r2) {
            boolean r3 = EarlyTraceEvent.enabled();
            if (TraceEvent.access$200() == true) goto L6;
            if (r3 == true) goto L6;
        L11:
            this.mCurrentTarget = null;
            return;
        L6:
            if (this.mCurrentTarget == null) goto L11;
            if (TraceEvent.access$200() == false) goto L10;
            TraceEventJni.get().endToplevel(this.mCurrentTarget);
            goto L11
        L10:
            EarlyTraceEvent.end(this.mCurrentTarget, true);
            goto L11
        }

        @Override // android.util.Printer
        public void println(String r2) {
            if (r2.startsWith(">") == false) goto L5;
            beginHandling(r2);
            return;
        L5:
            endHandling(r2);
        }
    }

    public static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        private static final long FRAME_DURATION_MILLIS = 16;
        private static final String IDLE_EVENT_NAME = "Looper.queueIdle";
        private static final long MIN_INTERESTING_BURST_DURATION_MILLIS = 48;
        private static final long MIN_INTERESTING_DURATION_MILLIS = 16;
        private static final String TAG = "TraceEvent_LooperMonitor";
        private boolean mIdleMonitorAttached;
        private long mLastIdleStartedAt;
        private long mLastWorkStartedAt;
        private int mNumIdlesSeen;
        private int mNumTasksSeen;
        private int mNumTasksSinceLastIdle;

        private IdleTracingLooperMonitor() {
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.access$200() == false) goto L8;
            if (this.mIdleMonitorAttached == true) goto L8;
            this.mLastIdleStartedAt = TimeUtils.elapsedRealtimeMillis();
            Looper.myQueue().addIdleHandler(this);
            this.mIdleMonitorAttached = true;
            android.util.Log.v(TAG, "attached idle handler");
            return;
        L8:
            if (this.mIdleMonitorAttached == true) goto L10;
            return;
        L10:
            if (TraceEvent.access$200() == true) goto L15;
            Looper.myQueue().removeIdleHandler(this);
            this.mIdleMonitorAttached = false;
            android.util.Log.v(TAG, "detached idle handler");
            return;
        }

        private static void traceAndLog(int r1, String r2) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", r2);
            android.util.Log.println(r1, TAG, r2);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void beginHandling(String r3) {
            if (this.mNumTasksSinceLastIdle != 0) goto L5;
            TraceEvent.end(IDLE_EVENT_NAME);
        L5:
            this.mLastWorkStartedAt = TimeUtils.elapsedRealtimeMillis();
            syncIdleMonitoring();
            super.beginHandling(r3);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void endHandling(String r5) {
            long r0 = TimeUtils.elapsedRealtimeMillis() - this.mLastWorkStartedAt;
            if (r0 <= 16) goto L5;
            traceAndLog(5, "observed a task that took " + r0 + "ms: " + r5);
        L5:
            super.endHandling(r5);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r0 = TimeUtils.elapsedRealtimeMillis();
            if (this.mLastIdleStartedAt != 0) goto L5;
            this.mLastIdleStartedAt = r0;
        L5:
            long r2 = r0 - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (r2 <= MIN_INTERESTING_BURST_DURATION_MILLIS) goto L8;
            traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + r2 + "ms elapsed since last idle");
        L8:
            this.mLastIdleStartedAt = r0;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }

        public /* synthetic */ IdleTracingLooperMonitor(AnonymousClass1 r1) {
            this();
        }
    }

    public static final class LooperMonitorHolder {
        private static final BasicLooperMonitor sInstance = null;

        static {
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_IDLE_TRACING) == false) goto L5;
            BasicLooperMonitor r0 = new IdleTracingLooperMonitor(null);
        L6:
            sInstance = r0;
            return;
        L5:
            r0 = new BasicLooperMonitor();
            goto L6
        }

        private LooperMonitorHolder() {
        }

        public static /* synthetic */ BasicLooperMonitor access$000() {
            return sInstance;
        }
    }

    public interface Natives {
        void addViewDump(int r1, int r2, boolean r3, boolean r4, String r5, String r6, long r7);

        void begin(String r1, String r2);

        void beginToplevel(String r1);

        void end(String r1, String r2);

        void endToplevel(String r1);

        void finishAsync(String r1, long r2);

        void initViewHierarchyDump();

        void instant(String r1, String r2);

        void instantAndroidIPC(String r1, long r2);

        void registerEnabledObserver();

        void setupATraceStartupTrace(String r1);

        void startATrace(String r1);

        long startActivityDump(String r1, long r2);

        void startAsync(String r1, long r2);

        void stopATrace();

        boolean viewHierarchyDumpEnabled();
    }

    public static final class ViewHierarchyDumper implements MessageQueue.IdleHandler {
        private static final String EVENT_NAME = "TraceEvent.ViewHierarchyDumper";
        private static final long MIN_VIEW_DUMP_INTERVAL_MILLIS = 1000;
        private static boolean sEnabled;
        private static ViewHierarchyDumper sInstance;
        private long mLastDumpTs;

        private ViewHierarchyDumper() {
        }

        public static /* synthetic */ void a() {
            lambda$updateEnabledState$0();
        }

        public static /* synthetic */ void access$500(int r0, View r1, long r2) {
            dumpView(r0, r1, r2);
        }

        private static void disable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled == false) goto L6;
            Looper.myQueue().removeIdleHandler(sInstance);
            sEnabled = false;
            return;
        }

        private static void dumpView(int r10, View r11, long r12) {
            ThreadUtils.assertOnUiThread();
            int r9 = r11.getId();
        L10:
            String r0 = "__name_not_found__";
        L9:
            String r6 = r0;
            TraceEventJni.get().addViewDump(r9, r10, r11.isShown(), r11.isDirty(), r11.getClass().getSimpleName(), r6, r12);
            if ((r11 instanceof ViewGroup) == false) goto L17;
            ViewGroup r13 = (ViewGroup) r11;
            int r14 = 0;
        L15:
            if (r14 >= r13.getChildCount()) goto L21;
            dumpView(r9, r13.getChildAt(r14), r12);
            r14 = r14 + 1;
            goto L15
        L21:
            return;
        L17:
            return;
        L4:
            if (r11.getResources() == null) goto L8;
            if (r9 == 0) goto L7;
            r0 = r11.getResources().getResourceName(r9);     // Catch: Resources.NotFoundException -> L10
            goto L9
        L7:
            r0 = "__no_id__";
            goto L9
        L8:
            r0 = "__no_resources__";
            goto L9
        }

        private static void enable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled == true) goto L6;
            Looper.myQueue().addIdleHandler(sInstance);
            sEnabled = true;
            return;
        }

        private static /* synthetic */ void lambda$updateEnabledState$0() {
            updateEnabledState();
        }

        public static void updateEnabledState() {
            if (ThreadUtils.runningOnUiThread() == true) goto L7;
            ThreadUtils.postOnUiThread(new h());
            return;
        L7:
            if (TraceEventJni.get().viewHierarchyDumpEnabled() == false) goto L13;
            if (sInstance != null) goto L11;
            sInstance = new ViewHierarchyDumper();
        L11:
            enable();
            return;
        L13:
            if (sInstance == null) goto L17;
            disable();
            return;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r0 = TimeUtils.elapsedRealtimeMillis();
            long r2 = this.mLastDumpTs;
            if (r2 != 0) goto L5;
        L6:
            this.mLastDumpTs = r0;
            TraceEventJni.get().initViewHierarchyDump();
            return true;
        L5:
            if ((r0 - r2) > 1000) goto L6;
            return true;
        }
    }

    static {
        sNativeTracingReady = new AtomicBoolean();
        sUiThreadReady = new AtomicBoolean();
    }

    private TraceEvent(String r1, String r2) {
        this.mName = r1;
        begin(r1, r2);
    }

    public static /* synthetic */ boolean access$200() {
        return sEnabled;
    }

    public static /* synthetic */ boolean access$300() {
        return sEventNameFilteringEnabled;
    }

    public static void begin(String r1) {
        begin(r1, null);
    }

    @CalledByNative
    public static void dumpViewHierarchy(long r5) {
        if (ApplicationStatus.isInitialized() == true) goto L5;
        return;
    L5:
        Iterator<Activity> r0 = ApplicationStatus.getRunningActivities().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Activity r1 = r0.next();
        long r2 = TraceEventJni.get().startActivityDump(r1.getClass().getName(), r5);
        ViewHierarchyDumper.access$500(0, r1.getWindow().getDecorView().getRootView(), r2);
        goto L7
    }

    public static boolean enabled() {
        return sEnabled;
    }

    public static void end(String r1) {
        end(r1, null);
    }

    public static boolean eventNameFilteringEnabled() {
        return sEventNameFilteringEnabled;
    }

    public static void finishAsync(String r1, long r2) {
        EarlyTraceEvent.finishAsync(r1, r2);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().finishAsync(r1, r2);
        return;
    L5:
        ATrace r0 = sATrace;
        if (r0 == null) goto L10;
        r0.asyncTraceEnd(r1, (int) r2);
        return;
    }

    public static void instant(String r2) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r2, null);
        return;
    }

    public static void instantAndroidIPC(String r1, long r2) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instantAndroidIPC(r1, r2);
        return;
    }

    public static void maybeEnableEarlyTracing(long r2, boolean r4) {
        if (r4 == false) goto L5;
        EarlyTraceEvent.maybeEnableInBrowserProcess();
    L5:
        if (r2 == 0) goto L13;
        sATrace = new ATrace(r2);
        if (sNativeTracingReady.get() == false) goto L10;
        sATrace.onNativeTracingReady();
    L10:
        if (sUiThreadReady.get() == false) goto L13;
        sATrace.onUiThreadReady();
    L13:
        if (EarlyTraceEvent.enabled() == false) goto L20;
        ATrace r3 = sATrace;
        if (r3 != null) goto L17;
    L18:
        ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$000());
        return;
    L17:
        if (r3.hasActiveSession() == false) goto L18;
        return;
    }

    public static void onNativeTracingReady() {
        sNativeTracingReady.set(true);
        TraceEventJni.get().registerEnabledObserver();
        ATrace r0 = sATrace;
        if (r0 == null) goto L6;
        r0.onNativeTracingReady();
        return;
    }

    public static void onUiThreadReady() {
        sUiThreadReady.set(true);
        ATrace r0 = sATrace;
        if (r0 == null) goto L6;
        r0.onUiThreadReady();
    L6:
        if (sEnabled == false) goto L9;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    public static TraceEvent scoped(String r1, String r2) {
        if (EarlyTraceEvent.enabled() == true) goto L9;
        if (enabled() == true) goto L9;
        return null;
    L9:
        return new TraceEvent(r1, r2);
    }

    @CalledByNative
    public static void setEnabled(boolean r1) {
        if (r1 == false) goto L5;
        EarlyTraceEvent.disable();
    L5:
        if (sEnabled == r1) goto L16;
        sEnabled = r1;
        ATrace r0 = sATrace;
        if (r0 != null) goto L9;
    L10:
        Looper r2 = ThreadUtils.getUiThreadLooper();
        if (r1 == false) goto L13;
        BasicLooperMonitor r3 = LooperMonitorHolder.access$000();
    L14:
        r2.setMessageLogging(r3);
        goto L16
    L13:
        r3 = null;
        goto L14
    L9:
        if (r0.hasActiveSession() == false) goto L10;
    L16:
        if (sUiThreadReady.get() == false) goto L19;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    @CalledByNative
    public static void setEventNameFilteringEnabled(boolean r0) {
        sEventNameFilteringEnabled = r0;
    }

    public static void startAsync(String r1, long r2) {
        EarlyTraceEvent.startAsync(r1, r2);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().startAsync(r1, r2);
        return;
    L5:
        ATrace r0 = sATrace;
        if (r0 == null) goto L10;
        r0.asyncTraceBegin(r1, (int) r2);
        return;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }

    public static void begin(String r1, String r2) {
        EarlyTraceEvent.begin(r1, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().begin(r1, r2);
        return;
    L5:
        ATrace r3 = sATrace;
        if (r3 == null) goto L10;
        r3.traceBegin(r1);
        return;
    }

    public static void end(String r1, String r2) {
        EarlyTraceEvent.end(r1, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().end(r1, r2);
        return;
    L5:
        ATrace r3 = sATrace;
        if (r3 == null) goto L10;
        r3.traceEnd();
        return;
    }

    public static void instant(String r1, String r2) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r1, r2);
        return;
    }

    public static TraceEvent scoped(String r1) {
        return scoped(r1, null);
    }
}
