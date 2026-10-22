package com.bytedance.apm.trace.model.wrapper;

import android.os.Looper;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingSpanAbility;
import com.bytedance.apm.trace.api.ITracingWindowSpan;
import com.bytedance.apm.trace.api.TracingContext;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class ParallelTracingWrapper extends AbsTracingWrapper {
    private AtomicBoolean isStartTrace;
    protected TracingWrapperRecord record;
    private ThreadLocal<Map<String, Deque<ITracingSpan>>> spanCacheMap;
    private ThreadLocal<Map<String, Deque<ITracingWindowSpan>>> windowSpanCacheMap;

    public ParallelTracingWrapper(TracingContext r2) {
        super(r2);
        this.isStartTrace = new AtomicBoolean(false);
        ThreadLocal<Map<String, Deque<ITracingSpan>>> r3 = new ThreadLocal();
        this.spanCacheMap = r3;
        r3.set(new LinkedHashMap());
        ThreadLocal<Map<String, Deque<ITracingWindowSpan>>> r4 = new ThreadLocal();
        this.windowSpanCacheMap = r4;
        r4.set(new LinkedHashMap());
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
    public void end() {
        if (this.isStartTrace.get() == true) goto L5;
        return;
    L5:
        this.isStartTrace.set(false);
        super.end();
        this.record.endTrace();
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

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void cancel() {
        if (this.isStartTrace.get() == true) goto L5;
        return;
    L5:
        this.isStartTrace.set(false);
        super.cancel();
        this.record.endTrace();
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void addTracingTag(String r2, String r3) {
        if (this.isStartTrace.get() == true) goto L5;
        return;
    L5:
        super.addTracingTag(r2, r3);
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public ITracingWindowSpan createWindowSpan(String r3) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r3 + " is start after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return null;
    L6:
        ITracingWindowSpan r0 = this.tracingContext.createWindowSpan(r3);
        if (r0 == null) goto L15;
        Map<String, Deque<ITracingWindowSpan>> r1 = this.windowSpanCacheMap.get();
        if (r1 != null) goto L11;
        r1 = new LinkedHashMap();
        this.windowSpanCacheMap.set(r1);
    L11:
        Deque<ITracingWindowSpan> r2 = r1.get(r3);
        if (r2 != null) goto L14;
        r2 = new LinkedList();
        r1.put(r3, r2);
    L14:
        r2.push(r0);
    L15:
        return r0;
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void endWindowSpan(String r3, long r4, long r6) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r3 + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return;
    L6:
        Map<String, Deque<ITracingWindowSpan>> r0 = this.windowSpanCacheMap.get();
        if (r0 != null) goto L9;
        r0 = new LinkedHashMap();
        this.windowSpanCacheMap.set(r0);
    L9:
        Deque<ITracingWindowSpan> r5 = r0.get(r3);
        if (r5 != null) goto L12;
    L14:
        ITracingWindowSpan r7 = null;
    L15:
        if (r7 == null) goto L18;
        buildWindowSpanGraph(r7);
        r7.endWindowSpan(r4, r6);
        return;
    L18:
        return;
    L12:
        if (r5.isEmpty() == true) goto L14;
        r7 = r5.pop();
        goto L15
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void createAndEndWindowSpan(String r2, long r3, long r5) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r2 + " is create after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return;
    L6:
        ITracingWindowSpan r4 = this.tracingContext.createWindowSpan(r2);
        if (r4 == null) goto L10;
        buildWindowSpanGraph(r4);
        r4.endWindowSpan(r3, r5);
        return;
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public ITracingSpan startSpan(String r4) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r4 + " is start after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return null;
    L6:
        ITracingSpan r0 = this.tracingContext.createSpan(r4);
        if (r0 == null) goto L23;
        Map<String, Deque<ITracingSpan>> r1 = this.spanCacheMap.get();
        if (r1 != null) goto L11;
        r1 = new LinkedHashMap();
        this.spanCacheMap.set(r1);
    L11:
        Deque<ITracingSpan> r2 = r1.get(r4);
        if (r2 != null) goto L14;
        r2 = new LinkedList();
        r1.put(r4, r2);
    L14:
        r2.push(r0);
        if (isInvokeInMainThread() == false) goto L17;
        this.record.startSpan(r0);
        r0.startSpan();
        goto L23
    L17:
        ITracingSpanAbility r5 = this.record.getCurrentTopSpan();
        if (r5 != null) goto L20;
        r5 = this.record.getCurrentPopSpan();
    L20:
        if (r5 == null) goto L22;
        r0.setParentId(r5.getSpanId());
    L22:
        r0.startSpan();
    L23:
        return r0;
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void endSpan(String r3) {
        if (this.isStartTrace.get() == true) goto L6;
        LaunchAnalysisContext.getInstance().logE(r3 + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return;
    L6:
        Map<String, Deque<ITracingSpan>> r0 = this.spanCacheMap.get();
        if (r0 != null) goto L9;
        r0 = new LinkedHashMap();
        this.spanCacheMap.set(r0);
    L9:
        Deque<ITracingSpan> r4 = r0.get(r3);
        if (r4 != null) goto L12;
    L14:
        ITracingSpan r5 = null;
    L15:
        if (r5 == null) goto L20;
        r5.endSpan();
        if (isInvokeInMainThread() == false) goto L21;
        this.record.endSpan();
        return;
    L21:
        return;
    L20:
        return;
    L12:
        if (r4.isEmpty() == true) goto L14;
        r5 = r4.pop();
        goto L15
    }

    private boolean isInvokeInMainThread() {
        if (Looper.myLooper() != null) goto L5;
    L7:
        return false;
    L5:
        if (Looper.getMainLooper().equals(Looper.myLooper()) == false) goto L7;
        return true;
    }

    private void buildWindowSpanGraph(ITracingWindowSpan r5) {
        if (r5.getParentId() == 0) goto L5;
        return;
    L5:
        ITracingSpanAbility r0 = this.record.getCurrentTopSpan();
        if (r0 != null) goto L8;
        r0 = this.record.getCurrentPopSpan();
    L8:
        if (r0 == null) goto L11;
        r5.setParentId(r0.getSpanId());
        return;
    }
}
