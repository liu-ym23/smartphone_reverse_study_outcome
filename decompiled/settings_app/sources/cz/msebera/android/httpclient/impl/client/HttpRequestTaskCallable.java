package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.concurrent.FutureCallback;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
class HttpRequestTaskCallable<V> implements Callable<V> {
    private final FutureCallback<V> callback;
    private final AtomicBoolean cancelled;
    private final HttpContext context;
    private long ended;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics;
    private final HttpUriRequest request;
    private final ResponseHandler<V> responseHandler;
    private final long scheduled;
    private long started;

    HttpRequestTaskCallable(HttpClient r3, HttpUriRequest r4, HttpContext r5, ResponseHandler<V> r6, FutureCallback<V> r7, FutureRequestExecutionMetrics r8) {
        this.cancelled = new AtomicBoolean(false);
        this.scheduled = System.currentTimeMillis();
        this.started = -1;
        this.ended = -1;
        this.httpclient = r3;
        this.responseHandler = r6;
        this.request = r4;
        this.context = r5;
        this.callback = r7;
        this.metrics = r8;
    }

    public long getScheduled() {
        return this.scheduled;
    }

    public long getStarted() {
        return this.started;
    }

    public long getEnded() {
        return this.ended;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.concurrent.Callable
    public V call() throws Exception {
        if (this.cancelled.get() == true) goto L19;
        this.metrics.getActiveConnections().incrementAndGet();     // Catch: Throwable -> L15
        this.started = System.currentTimeMillis();     // Catch: Throwable -> L15
        this.metrics.getScheduledConnections().decrementAndGet();     // Catch: Exception -> L10 Throwable -> L15
        V r0 = (V) this.httpclient.execute(this.request, this.responseHandler, this.context);
        this.ended = System.currentTimeMillis();     // Catch: Exception -> L10 Throwable -> L15
        this.metrics.getSuccessfulConnections().increment(this.started);     // Catch: Exception -> L10 Throwable -> L15
        FutureCallback<V> r1 = this.callback;     // Catch: Exception -> L10 Throwable -> L15
        if (r1 == null) goto L8;
        r1.completed(r0);     // Catch: Exception -> L10 Throwable -> L15
    L8:
        this.metrics.getRequests().increment(this.started);
        this.metrics.getTasks().increment(this.started);
        this.metrics.getActiveConnections().decrementAndGet();
        return r0;
    L10:
        e = move-exception;
        this.metrics.getFailedConnections().increment(this.started);     // Catch: Throwable -> L15
        this.ended = System.currentTimeMillis();     // Catch: Throwable -> L15
        FutureCallback<V> r2 = this.callback;     // Catch: Throwable -> L15
        if (r2 == null) goto L14;
        r2.failed(e);     // Catch: Throwable -> L15
    L14:
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.metrics.getRequests().increment(this.started);
        this.metrics.getTasks().increment(this.started);
        this.metrics.getActiveConnections().decrementAndGet();
        throw th;
    L19:
        throw new IllegalStateException("call has been cancelled for request " + this.request.getURI());
    }

    public void cancel() {
        this.cancelled.set(true);
        FutureCallback<V> r2 = this.callback;
        if (r2 == null) goto L6;
        r2.cancelled();
        return;
    }
}
