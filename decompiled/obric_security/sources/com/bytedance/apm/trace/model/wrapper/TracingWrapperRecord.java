package com.bytedance.apm.trace.model.wrapper;

import com.bytedance.apm.trace.api.ITracingSpanAbility;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TracingWrapperRecord {
    private ITracingSpanAbility currentPopSpan;
    private Deque<ITracingSpanAbility> recordStack;
    private Map<Long, ITracingSpanAbility> subTaskMap;

    public TracingWrapperRecord() {
    }

    public void startTrace() {
        this.recordStack = new LinkedList();
        this.subTaskMap = new LinkedHashMap();
    }

    public void endTrace() {
        this.recordStack.clear();
        this.subTaskMap.clear();
        this.currentPopSpan = null;
    }

    public void startSpan(ITracingSpanAbility r5) {
        if (this.currentPopSpan != null) goto L6;
        this.currentPopSpan = r5;
    L12:
        this.recordStack.push(r5);
        return;
    L6:
        if (this.recordStack.isEmpty() == true) goto L11;
        long r0 = this.recordStack.peek().getSpanId();
        r5.setParentId(r0);
        ITracingSpanAbility r2 = this.subTaskMap.get(Long.valueOf(r0));
        if (r2 == null) goto L10;
        r5.setReferenceId(r2.getSpanId());
    L10:
        this.subTaskMap.put(Long.valueOf(r0), r5);
        goto L12
    L11:
        r5.setReferenceId(this.currentPopSpan.getSpanId());
        goto L12
    }

    public void endSpan() {
        ITracingSpanAbility r0 = this.recordStack.poll();
        if (r0 == null) goto L6;
        this.currentPopSpan = r0;
        this.subTaskMap.remove(Long.valueOf(r0.getSpanId()));
        return;
    }

    public ITracingSpanAbility getCurrentTopSpan() {
        return this.recordStack.peek();
    }

    public ITracingSpanAbility getCurrentPopSpan() {
        return this.currentPopSpan;
    }
}
