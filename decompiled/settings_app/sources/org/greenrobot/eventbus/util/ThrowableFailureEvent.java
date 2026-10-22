package org.greenrobot.eventbus.util;

/* JADX INFO: loaded from: classes6.dex */
public class ThrowableFailureEvent implements HasExecutionScope {
    private Object executionContext;
    protected final boolean suppressErrorUi;
    protected final Throwable throwable;

    public ThrowableFailureEvent(Throwable r1) {
        this.throwable = r1;
        this.suppressErrorUi = false;
    }

    public ThrowableFailureEvent(Throwable r1, boolean r2) {
        this.throwable = r1;
        this.suppressErrorUi = r2;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSuppressErrorUi() {
        return this.suppressErrorUi;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public Object getExecutionScope() {
        return this.executionContext;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public void setExecutionScope(Object r1) {
        this.executionContext = r1;
    }
}
