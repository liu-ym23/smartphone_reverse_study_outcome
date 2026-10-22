package com.google.common.util.concurrent;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger logger = null;
    private final Service delegate;

    protected abstract void run() throws Exception;

    protected void shutDown() throws Exception {
    }

    protected void startUp() throws Exception {
    }

    protected void triggerShutdown() {
    }

    static /* synthetic */ Logger access$000() {
        return logger;
    }

    static {
        logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    }

    protected AbstractExecutionThreadService() {
        this.delegate = new AnonymousClass1(this);
    }

    protected Executor executor() {
        return new AnonymousClass2(this);
    }

    public String toString() {
        String r0 = serviceName();
        String r3 = String.valueOf(state());
        return new StringBuilder((String.valueOf(r0).length() + 3) + String.valueOf(r3).length()).append(r0).append(" [").append(r3).append("]").toString();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r1, Executor r2) {
        this.delegate.addListener(r1, r2);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(Duration r1) throws TimeoutException {
        super.awaitRunning(r1);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r1, TimeUnit r3) throws TimeoutException {
        this.delegate.awaitRunning(r1, r3);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(Duration r1) throws TimeoutException {
        super.awaitTerminated(r1);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r1, TimeUnit r3) throws TimeoutException {
        this.delegate.awaitTerminated(r1, r3);
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }
}
