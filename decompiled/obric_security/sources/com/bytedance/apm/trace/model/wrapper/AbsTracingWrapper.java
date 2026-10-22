package com.bytedance.apm.trace.model.wrapper;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.apm.trace.api.wrapper.ITracingWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsTracingWrapper implements ITracingWrapper {
    protected long currentThreadId;
    private long startThreadId;
    protected final TracingContext tracingContext;

    public AbsTracingWrapper(TracingContext r1) {
        this.tracingContext = r1;
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void start() {
        long r0 = Thread.currentThread().getId();
        this.currentThreadId = r0;
        this.startThreadId = r0;
        this.tracingContext.start();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void startWithCross() {
        long r0 = Thread.currentThread().getId();
        this.currentThreadId = r0;
        this.startThreadId = r0;
        this.tracingContext.startWithCross();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void end() {
        checkInvokeThread(this.startThreadId);
        this.tracingContext.end();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void end(long r3) {
        checkInvokeThread(this.startThreadId);
        this.tracingContext.end(r3);
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void cancel() {
        checkInvokeThread(this.startThreadId);
        this.tracingContext.cancel();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void addTracingTag(String r1, String r2) {
        this.tracingContext.addTracingTag(r1, r2);
    }

    protected void checkInvokeThread(long r3) {
        if (ApmContext.isDebugMode() == true) goto L5;
        return;
    L5:
        if (Thread.currentThread().getId() != r3) goto L8;
        return;
    L8:
        throw new IllegalStateException("ITracingWrapper start() should invoke in same thread as end()");
    }
}
