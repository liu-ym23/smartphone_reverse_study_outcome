package com.bytedance.apm.trace.model.wrapper;

import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingWindowSpan;
import com.bytedance.apm.trace.api.TracingContext;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class SerialTracingWrapper extends AbsTracingWrapper {
    private AtomicBoolean isStartTrace;
    protected TracingWrapperRecord record;
    private Map<String, Deque<ITracingSpan>> spanCacheMap;
    private Map<String, Deque<ITracingWindowSpan>> windowSpanCacheMap;

    public SerialTracingWrapper(TracingContext r2) {
        super(r2);
        this.isStartTrace = new AtomicBoolean(false);
        this.spanCacheMap = new LinkedHashMap();
        this.windowSpanCacheMap = new LinkedHashMap();
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void addTracingTag(String r2, String r3) {
        if (this.isStartTrace.get() == true) goto L5;
        return;
    L5:
        super.addTracingTag(r2, r3);
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void cancel() {
        if (this.isStartTrace.get() == true) goto L5;
        return;
    L5:
        this.isStartTrace.set(false);
        super.cancel();
        this.record.endTrace();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void createAndEndWindowSpan(String r3, long r4, long r6) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r3 + " is create after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return;
    L6:
        checkInvokeThread(this.currentThreadId);
        ITracingWindowSpan r5 = this.tracingContext.createWindowSpan(r3);
        if (r5 == null) goto L10;
        this.record.startSpan(r5);
        r5.endWindowSpan(r4, r6);
        this.record.endSpan();
        return;
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public ITracingWindowSpan createWindowSpan(String r3) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r3 + " is start after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return null;
    L6:
        checkInvokeThread(this.currentThreadId);
        ITracingWindowSpan r0 = this.tracingContext.createWindowSpan(r3);
        if (r0 == null) goto L12;
        Deque<ITracingWindowSpan> r1 = this.windowSpanCacheMap.get(r3);
        if (r1 != null) goto L11;
        r1 = new LinkedList();
        this.windowSpanCacheMap.put(r3, r1);
    L11:
        r1.push(r0);
    L12:
        return r0;
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void end() {
        if (this.isStartTrace.get() == true) goto L5;
        return;
    L5:
        this.isStartTrace.set(false);
        super.end();
        this.record.endTrace();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void endSpan(String r3) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r3 + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return;
    L6:
        checkInvokeThread(this.currentThreadId);
        Deque<ITracingSpan> r4 = this.spanCacheMap.get(r3);
        if (r4 != null) goto L9;
    L11:
        ITracingSpan r5 = null;
    L12:
        if (r5 == null) goto L15;
        r5.endSpan();
        this.record.endSpan();
        return;
    L15:
        return;
    L9:
        if (r4.isEmpty() == true) goto L11;
        r5 = r4.pop();
        goto L12
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void endWindowSpan(String r3, long r4, long r6) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r3 + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return;
    L6:
        checkInvokeThread(this.currentThreadId);
        Deque<ITracingWindowSpan> r5 = this.windowSpanCacheMap.get(r3);
        if (r5 != null) goto L9;
    L11:
        ITracingWindowSpan r7 = null;
    L12:
        if (r7 == null) goto L15;
        this.record.startSpan(r7);
        r7.endWindowSpan(r4, r6);
        this.record.endSpan();
        return;
    L15:
        return;
    L9:
        if (r5.isEmpty() == true) goto L11;
        r7 = r5.pop();
        goto L12
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void start() {
        if (this.isStartTrace.get() == false) goto L5;
        return;
    L5:
        super.start();
        TracingWrapperRecord r0 = new TracingWrapperRecord();
        this.record = r0;
        r0.startTrace();
        this.isStartTrace.set(true);
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public ITracingSpan startSpan(String r4) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r4 + " is start after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return null;
    L6:
        checkInvokeThread(this.currentThreadId);
        ITracingSpan r0 = this.tracingContext.createSpan(r4);
        if (r0 == null) goto L12;
        Deque<ITracingSpan> r1 = this.spanCacheMap.get(r4);
        if (r1 != null) goto L11;
        r1 = new LinkedList();
        this.spanCacheMap.put(r4, r1);
    L11:
        r1.push(r0);
        this.record.startSpan(r0);
        r0.startSpan();
    L12:
        return r0;
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void startWithCross() {
        if (this.isStartTrace.get() == false) goto L5;
        return;
    L5:
        super.startWithCross();
        TracingWrapperRecord r0 = new TracingWrapperRecord();
        this.record = r0;
        r0.startTrace();
        this.isStartTrace.set(true);
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void end(long r3) {
        if (this.isStartTrace.get() == true) goto L5;
        return;
    L5:
        this.isStartTrace.set(false);
        super.end(r3);
        this.record.endTrace();
    }
}
