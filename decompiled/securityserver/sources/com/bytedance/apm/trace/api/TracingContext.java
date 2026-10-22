package com.bytedance.apm.trace.api;

import androidx.annotation.Nullable;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.model.AbsTracing;
import com.bytedance.apm.trace.model.BatchTracing;
import com.bytedance.apm.trace.model.cross.NativeSpan;
import com.bytedance.apm.trace.model.cross.TracingCrossManager;
import com.bytedance.tracing.internal.utils.RandomUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TracingContext {
    private final boolean forceTrace;
    private boolean isEnd;
    private boolean isStart;
    private boolean isWithCross;
    private final String service;
    private long startTs;
    private final long traceId;
    private AbsTracing tracing;
    private final TracingMode tracingMode;

    /* JADX INFO: renamed from: com.bytedance.apm.trace.api.TracingContext$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$apm$trace$api$TracingMode = null;

        static {
            int[] r0 = new int[TracingMode.values().length];
            $SwitchMap$com$bytedance$apm$trace$api$TracingMode = r0;
            r0[TracingMode.BATCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public TracingContext(String r2, TracingMode r3) {
        this(r2, r3, false);
    }

    public static /* synthetic */ AbsTracing access$000(TracingContext r0) {
        return r0.tracing;
    }

    public static /* synthetic */ AbsTracing access$002(TracingContext r0, AbsTracing r1) {
        r0.tracing = r1;
        return r1;
    }

    private AbsTracing parseTracingMode(TracingMode r2) {
        if (AnonymousClass3.$SwitchMap$com$bytedance$apm$trace$api$TracingMode[r2.ordinal()] == 1) goto L7;
        return null;
    L7:
        return new BatchTracing(this);
    }

    private void rawStart(boolean r4) {
        this.tracing = parseTracingMode(this.tracingMode);
        long r0 = System.currentTimeMillis();
        this.startTs = r0;
        this.tracing.startTrace(r0);
        this.isStart = true;
        if (r4 == false) goto L6;
        TracingCrossManager.registerCross(this.traceId, this);
        return;
    }

    public synchronized void addTracingTag(String r2, String r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L13;
        this.tracing.addTag(r2, r3);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void assembleAsChild(String r6, ArrayList<NativeSpan> r7) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L23:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L23;
        Iterator<NativeSpan> r8 = r7.iterator();     // Catch: Throwable -> L17
        boolean r0 = true;
    L9:
        if (r8.hasNext() == false) goto L21;
        NativeSpan r1 = r8.next();     // Catch: Throwable -> L17
        if (r1 == null) goto L9;
        ITracingWindowSpan r2 = r1.parseToSpan(this.tracing);     // Catch: Throwable -> L17
        if (r0 == false) goto L19;
        r2.setParentId(Long.parseLong(r6));     // Catch: Throwable -> L17
    L19:
        r2.endWindowSpan(r1.getStartTime(), r1.getFinishTime());     // Catch: Throwable -> L17
        r0 = false;
        goto L9
    L21:
        monitor-exit(this);
    }

    public synchronized void assembleAsReference(String r6, ArrayList<NativeSpan> r7) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L23:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L23;
        Iterator<NativeSpan> r8 = r7.iterator();     // Catch: Throwable -> L17
        boolean r0 = true;
    L9:
        if (r8.hasNext() == false) goto L21;
        NativeSpan r1 = r8.next();     // Catch: Throwable -> L17
        if (r1 == null) goto L9;
        ITracingWindowSpan r2 = r1.parseToSpan(this.tracing);     // Catch: Throwable -> L17
        if (r0 == false) goto L19;
        r2.setReferenceId(Long.parseLong(r6));     // Catch: Throwable -> L17
    L19:
        r2.endWindowSpan(r1.getStartTime(), r1.getFinishTime());     // Catch: Throwable -> L17
        r0 = false;
        goto L9
    L21:
        monitor-exit(this);
    }

    public synchronized void cancel() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L16:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L16;
        this.tracing.cancelTrace();     // Catch: Throwable -> L12
        this.tracing = null;     // Catch: Throwable -> L12
        this.isEnd = true;     // Catch: Throwable -> L12
        if (this.isWithCross == false) goto L14;
        TracingCrossManager.unRegisterCross(this.traceId);     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
    }

    @Nullable
    public synchronized ITracingSpan createSpan(String r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L13:
        LaunchAnalysisContext.getInstance().logE(r3 + " is start after Trace finish or before Trace begin, it will be ignore!!!!");     // Catch: Throwable -> L11
        monitor-exit(this);
        return null;
    L6:
        if (this.isStart == false) goto L13;
        ITracingSpan r4 = this.tracing.createSpan(r3);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    }

    @Nullable
    public synchronized ITracingWindowSpan createWindowSpan(String r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L13:
        LaunchAnalysisContext.getInstance().logE(r3 + " is start after Trace finish or before Trace begin, it will be ignore!!!!");     // Catch: Throwable -> L11
        monitor-exit(this);
        return null;
    L6:
        if (this.isStart == false) goto L13;
        ITracingWindowSpan r4 = this.tracing.createWindowSpan(r3);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    }

    public synchronized void end() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L16:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L16;
        final long r0 = System.currentTimeMillis();     // Catch: Throwable -> L12
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r0));     // Catch: Throwable -> L12
        this.isEnd = true;     // Catch: Throwable -> L12
        if (this.isWithCross == false) goto L14;
        TracingCrossManager.unRegisterCross(this.traceId);     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
    }

    public String getService() {
        return this.service;
    }

    public long getTraceId() {
        return this.traceId;
    }

    public boolean isForceTrace() {
        return this.forceTrace;
    }

    public synchronized void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        rawStart(false);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void startWithCross() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isWithCross = true;     // Catch: Throwable -> L11
        rawStart(true);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public TracingContext(String r3, TracingMode r4, boolean r5) {
        this.service = r3;
        this.traceId = RandomUtil.uniqueId();
        this.tracingMode = r4;
        this.forceTrace = r5;
    }

    public synchronized void end(long r5) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L19:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L19;
        final long r0 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if ((r0 - this.startTs) <= r5) goto L13;
        cancel();     // Catch: Throwable -> L11
    L14:
        this.isEnd = true;     // Catch: Throwable -> L11
        if (this.isWithCross == false) goto L17;
        TracingCrossManager.unRegisterCross(this.traceId);     // Catch: Throwable -> L11
    L17:
        monitor-exit(this);
        return;
    L13:
        AsyncEventManager.getInstance().post(new AnonymousClass2(this, r0));     // Catch: Throwable -> L11
        goto L14
    }
}
