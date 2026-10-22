package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;

    @NotNull
    private final OkHttpClient client;

    @Nullable
    private RealConnection connection;
    private final RealConnectionPool connectionPool;

    @Nullable
    private volatile RealConnection connectionToCancel;

    @NotNull
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;

    @Nullable
    private Exchange interceptorScopedExchange;

    @NotNull
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final AnonymousClass1 timeout;
    private boolean timeoutEarlyExit;

    @Metadata
    public final class AsyncCall implements Runnable {

        @NotNull
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(@NotNull RealCall r2, Callback r3) {
            Intrinsics.f(r3, "responseCallback");
            this.this$0 = r2;
            this.responseCallback = r3;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void executeOn(@NotNull ExecutorService r4) {
            Intrinsics.f(r4, "executorService");
            Dispatcher r0 = this.this$0.getClient().dispatcher();
            if (Util.assertionsEnabled == true) goto L5;
        L19:
            r4.execute(this);     // Catch: Throwable -> L11 RejectedExecutionException -> L13
        L22:
            return;
        L11:
            th = move-exception;
            this.this$0.getClient().dispatcher().finished$okhttp(this);
            throw th;
        L13:
            e = move-exception;
            InterruptedIOException r1 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L11
            r1.initCause(e);     // Catch: Throwable -> L11
            this.this$0.noMoreExchanges$okhttp(r1);     // Catch: Throwable -> L11
            this.responseCallback.onFailure(this.this$0, r1);     // Catch: Throwable -> L11
            this.this$0.getClient().dispatcher().finished$okhttp(this);
            return;
        L5:
            if (Thread.holdsLock(r0) == false) goto L19;
            StringBuilder r5 = new StringBuilder("Thread ");
            Thread r2 = Thread.currentThread();
            Intrinsics.e(r2, "Thread.currentThread()");
            r5.append(r2.getName());
            r5.append(" MUST NOT hold lock on ");
            r5.append(r0);
            throw new AssertionError(r5.toString());
        }

        @NotNull
        public final RealCall getCall() {
            return this.this$0;
        }

        @NotNull
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        @NotNull
        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        @NotNull
        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(@NotNull AsyncCall r2) {
            Intrinsics.f(r2, "other");
            this.callsPerHost = r2.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r2 = "OkHttp " + this.this$0.redactedUrl$okhttp();
            Thread r3 = Thread.currentThread();
            Intrinsics.e(r3, "currentThread");
            String r4 = r3.getName();
            r3.setName(r2);
            RealCall.access$getTimeout$p(this.this$0).enter();     // Catch: Throwable -> L11
            boolean r5 = false;
        L41:
            this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain$okhttp());     // Catch: Throwable -> L13 IOException -> L15
            Dispatcher r0 = this.this$0.getClient().dispatcher();     // Catch: Throwable -> L11
        L9:
            r0.finished$okhttp(this);     // Catch: Throwable -> L11
            r3.setName(r4);
            return;
        L15:
            e = e;
            r5 = true;
        L27:
            if (r5 == false) goto L29;
            Platform.Companion.get().log("Callback failure for " + RealCall.access$toLoggableString(this.this$0), 4, e);     // Catch: Throwable -> L24
        L30:
            r0 = this.this$0.getClient().dispatcher();     // Catch: Throwable -> L11
            goto L9
        L29:
            this.responseCallback.onFailure(this.this$0, e);     // Catch: Throwable -> L24
        L13:
            th = th;
            r5 = true;
        L21:
            this.this$0.cancel();     // Catch: Throwable -> L24
            if (r5 == true) goto L26;
            IOException r6 = new IOException("canceled due to " + th);     // Catch: Throwable -> L24
            ExceptionsKt.a(r6, th);     // Catch: Throwable -> L24
            this.responseCallback.onFailure(this.this$0, r6);     // Catch: Throwable -> L24
        L26:
            throw th;     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            this.this$0.getClient().dispatcher().finished$okhttp(this);     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L19:
            e = e;
        L17:
            th = th;
        L11:
            th = move-exception;
            r3.setName(r4);
            throw th;
        }
    }

    @Metadata
    public static final class CallReference extends WeakReference<RealCall> {

        @Nullable
        private final Object callStackTrace;

        public CallReference(@NotNull RealCall r2, @Nullable Object r3) {
            Intrinsics.f(r2, "referent");
            super(r2);
            this.callStackTrace = r3;
        }

        @Nullable
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [okhttp3.internal.connection.RealCall$timeout$1, okio.Timeout] */
    public RealCall(@NotNull OkHttpClient r3, @NotNull Request r4, boolean r5) {
        Intrinsics.f(r3, "client");
        Intrinsics.f(r4, "originalRequest");
        this.client = r3;
        this.originalRequest = r4;
        this.forWebSocket = r5;
        this.connectionPool = r3.connectionPool().getDelegate$okhttp();
        this.eventListener = r3.eventListenerFactory().create(this);
        ?? r6 = new AnonymousClass1(this);
        r6.timeout(r3.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = r6;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    public static final /* synthetic */ AnonymousClass1 access$getTimeout$p(RealCall r0) {
        return r0.timeout;
    }

    public static final /* synthetic */ String access$toLoggableString(RealCall r0) {
        return r0.toLoggableString();
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
    private final <E extends IOException> E callDone(E r4) {
        boolean r0 = Util.assertionsEnabled;
        if (r0 == true) goto L5;
    L9:
        RealConnection r1 = this.connection;
        if (r1 == null) goto L35;
        if (r0 == true) goto L13;
    L17:
        monitor-enter(r1);
        Socket r2 = releaseConnectionNoEvents$okhttp();     // Catch: Throwable -> L32
        monitor-exit(r1);
        if (this.connection != null) goto L25;
        if (r2 == null) goto L24;
        Util.closeQuietly(r2);
    L24:
        this.eventListener.connectionReleased(this, r1);
        goto L35
    L25:
        if (r2 != null) goto L27;
        boolean r3 = true;
    L28:
        if (r3 == true) goto L35;
        throw new IllegalStateException("Check failed.".toString());
    L27:
        r3 = false;
    L32:
        th = move-exception;
        throw th;
    L13:
        if (Thread.holdsLock(r1) == false) goto L17;
        StringBuilder r5 = new StringBuilder("Thread ");
        Thread r6 = Thread.currentThread();
        Intrinsics.e(r6, "Thread.currentThread()");
        r5.append(r6.getName());
        r5.append(" MUST NOT hold lock on ");
        r5.append(r1);
        throw new AssertionError(r5.toString());
    L35:
        E r7 = (E) timeoutExit(r4);
        if (r4 == null) goto L38;
        EventListener r8 = this.eventListener;
        Intrinsics.c(r7);
        r8.callFailed(this, r7);
    L39:
        return r7;
    L38:
        this.eventListener.callEnd(this);
        goto L39
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r9 = new StringBuilder("Thread ");
        Thread r10 = Thread.currentThread();
        Intrinsics.e(r10, "Thread.currentThread()");
        r9.append(r10.getName());
        r9.append(" MUST NOT hold lock on ");
        r9.append(this);
        throw new AssertionError(r9.toString());
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final Address createAddress(HttpUrl r15) {
        if (r15.isHttps() == false) goto L5;
        SSLSocketFactory r0 = this.client.sslSocketFactory();
        SSLSocketFactory r6 = r0;
        HostnameVerifier r7 = this.client.hostnameVerifier();
        CertificatePinner r8 = this.client.certificatePinner();
    L7:
        return new Address(r15.host(), r15.port(), this.client.dns(), this.client.socketFactory(), r6, r7, r8, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    L5:
        r6 = null;
        r7 = null;
        r8 = null;
        goto L7
    }

    private final <E extends IOException> E timeoutExit(E r2) {
        if (this.timeoutEarlyExit == false) goto L6;
        return r2;
    L6:
        if (exit() == true) goto L8;
        return r2;
    L8:
        InterruptedIOException r1 = new InterruptedIOException("timeout");
        if (r2 == null) goto L11;
        r1.initCause(r2);
    L11:
        return r1;
    }

    private final String toLoggableString() {
        StringBuilder r0 = new StringBuilder();
        if (isCanceled() == false) goto L5;
        String r1 = "canceled ";
    L6:
        r0.append(r1);
        if (this.forWebSocket == false) goto L9;
        String r2 = "web socket";
    L10:
        r0.append(r2);
        r0.append(" to ");
        r0.append(redactedUrl$okhttp());
        return r0.toString();
    L9:
        r2 = NotificationCompat.CATEGORY_CALL;
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    public final void acquireConnectionNoEvents(@NotNull RealConnection r4) {
        Intrinsics.f(r4, WsConstants.KEY_CONNECTION);
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(r4) == true) goto L10;
        StringBuilder r0 = new StringBuilder("Thread ");
        Thread r1 = Thread.currentThread();
        Intrinsics.e(r1, "Thread.currentThread()");
        r0.append(r1.getName());
        r0.append(" MUST hold lock on ");
        r0.append(r4);
        throw new AssertionError(r0.toString());
    L10:
        if (this.connection != null) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L17;
        this.connection = r4;
        r4.getCalls().add(new CallReference(this, this.callStackTrace));
        return;
    L17:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r2 = false;
        goto L13
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled == false) goto L5;
        return;
    L5:
        this.canceled = true;
        Exchange r0 = this.exchange;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        RealConnection r1 = this.connectionToCancel;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        this.eventListener.canceled(this);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // okhttp3.Call
    public void enqueue(@NotNull Callback r4) {
        Intrinsics.f(r4, "responseCallback");
        if (this.executed.compareAndSet(false, true) == false) goto L7;
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, r4));
        return;
    L7:
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void enterNetworkInterceptorExchange(@NotNull Request r3, boolean r4) {
        Intrinsics.f(r3, "request");
        if (this.interceptorScopedExchange != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L26;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L9:
        if ((!this.responseBodyOpen) == false) goto L22;
        if ((!this.requestBodyOpen) == false) goto L18;
        monitor-exit(this);
        if (r4 == false) goto L28;
        this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(r3.url()), this, this.eventListener);
        return;
    L28:
        return;
    L18:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L19
    L22:
        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());     // Catch: Throwable -> L19
    L26:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.Call
    @NotNull
    public Response execute() {
        if (this.executed.compareAndSet(false, true) == false) goto L12;
        enter();
        callStart();
        this.client.dispatcher().executed$okhttp(this);     // Catch: Throwable -> L8
        Response r0 = getResponseWithInterceptorChain$okhttp();     // Catch: Throwable -> L8
        this.client.dispatcher().finished$okhttp(this);
        return r0;
    L8:
        th = move-exception;
        this.client.dispatcher().finished$okhttp(this);
        throw th;
    L12:
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean r2) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.expectMoreExchanges == false) goto L13;
        monitor-exit(this);
        if (r2 == false) goto L10;
        Exchange r3 = this.exchange;
        if (r3 == null) goto L10;
        r3.detachWithViolence();
    L10:
        this.interceptorScopedExchange = null;
        return;
    L13:
        throw new IllegalStateException("released".toString());     // Catch: Throwable -> L14
    }

    @NotNull
    public final OkHttpClient getClient() {
        return this.client;
    }

    @Nullable
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Nullable
    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    @Nullable
    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    @NotNull
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    @NotNull
    public final Response getResponseWithInterceptorChain$okhttp() {
        ArrayList r2 = new ArrayList();
        CollectionsKt.d(r2, this.client.interceptors());
        r2.add(new RetryAndFollowUpInterceptor(this.client));
        r2.add(new BridgeInterceptor(this.client.cookieJar()));
        r2.add(new CacheInterceptor(this.client.cache()));
        r2.add(ConnectInterceptor.INSTANCE);
        if (this.forWebSocket == true) goto L5;
        CollectionsKt.d(r2, this.client.networkInterceptors());
    L5:
        r2.add(new CallServerInterceptor(this.forWebSocket));
        boolean r1 = false;
        Response r3 = new RealInterceptorChain(this, r2, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);     // Catch: Throwable -> L12 IOException -> L14
        if (isCanceled() == true) goto L10;
        noMoreExchanges$okhttp(null);
        return r3;
    L10:
        Util.closeQuietly(r3);     // Catch: Throwable -> L12 IOException -> L14
        throw new IOException("Canceled");     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = move-exception;
        IOException r4 = noMoreExchanges$okhttp(e);     // Catch: Throwable -> L20
        if (r4 == null) goto L19;
        throw r4;     // Catch: Throwable -> L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th = th;
        r1 = true;
    L23:
        if (r1 == true) goto L25;
        noMoreExchanges$okhttp(null);
    L25:
        throw th;
    L12:
        th = th;
        goto L23
    }

    @NotNull
    public final Exchange initExchange$okhttp(@NotNull RealInterceptorChain r5) {
        Intrinsics.f(r5, "chain");
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.expectMoreExchanges == false) goto L31;
        if ((!this.responseBodyOpen) == false) goto L29;
        if ((!this.requestBodyOpen) == false) goto L25;
        monitor-exit(this);
        ExchangeFinder r0 = this.exchangeFinder;
        Intrinsics.c(r0);
        Exchange r2 = new Exchange(this, this.eventListener, r0, r0.find(this.client, r5));
        this.interceptorScopedExchange = r2;
        this.exchange = r2;
        monitor-enter(this);
        this.requestBodyOpen = true;     // Catch: Throwable -> L21
        this.responseBodyOpen = true;     // Catch: Throwable -> L21
        monitor-exit(this);
        if (this.canceled == true) goto L20;
        return r2;
    L20:
        throw new IOException("Canceled");
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L26
    L29:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L26
    L31:
        throw new IllegalStateException("released".toString());     // Catch: Throwable -> L26
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    public final <E extends IOException> E messageDone$okhttp(@NotNull Exchange r3, boolean r4, boolean r5, E r6) {
        Intrinsics.f(r3, "exchange");
        boolean r0 = true;
        if ((!r3.equals(this.exchange)) == false) goto L5;
        return r6;
    L5:
        monitor-enter(this);
        boolean r7 = false;
        if (r4 == true) goto L46;
    L13:
        if (r5 == true) goto L15;
    L36:
        r0 = false;
    L37:
        monitor-exit(this);
        if (r7 == false) goto L42;
        this.exchange = null;
        RealConnection r8 = this.connection;
        if (r8 == null) goto L42;
        r8.incrementSuccessCount$okhttp();
    L42:
        if (r0 == true) goto L44;
        return r6;
    L44:
        return (E) callDone(r6);
    L15:
        if (this.responseBodyOpen == false) goto L36;
    L16:
        if (r4 == false) goto L18;
        this.requestBodyOpen = false;     // Catch: Throwable -> L11
    L18:
        if (r5 == false) goto L20;
        this.responseBodyOpen = false;     // Catch: Throwable -> L11
    L20:
        boolean r9 = this.requestBodyOpen;     // Catch: Throwable -> L11
        if (r9 == false) goto L23;
    L25:
        boolean r10 = false;
    L26:
        if (r9 == false) goto L28;
    L32:
        r0 = false;
    L33:
        r7 = r10;
        goto L37
    L28:
        if (this.responseBodyOpen == true) goto L32;
        if (this.expectMoreExchanges == true) goto L32;
    L11:
        th = move-exception;
        throw th;
    L23:
        if (this.responseBodyOpen == true) goto L25;
        r10 = true;
        goto L26
    L46:
        if (this.requestBodyOpen == true) goto L16;
        goto L16
    }

    @Nullable
    public final IOException noMoreExchanges$okhttp(@Nullable IOException r3) {
        monitor-enter(this);
        boolean r1 = false;
        if (this.expectMoreExchanges == false) goto L12;
        this.expectMoreExchanges = false;     // Catch: Throwable -> L10
        if (this.requestBodyOpen == true) goto L12;
        if (this.responseBodyOpen == true) goto L12;
        r1 = true;
    L12:
        monitor-exit(this);
        if (r1 == true) goto L15;
        return r3;
    L15:
        return callDone(r3);
    L10:
        th = move-exception;
        throw th;
    }

    @NotNull
    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Nullable
    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection r0 = this.connection;
        Intrinsics.c(r0);
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        List<Reference<RealCall>> r1 = r0.getCalls();
        Iterator<Reference<RealCall>> r2 = r1.iterator();
        boolean r3 = false;
        int r4 = 0;
    L11:
        if (r2.hasNext() == false) goto L16;
        if (Intrinsics.a(r2.next().get(), this) == true) goto L17;
        r4 = r4 + 1;
    L17:
        if (r4 == (-1)) goto L19;
        r3 = true;
    L19:
        if (r3 == false) goto L28;
        r1.remove(r4);
        this.connection = null;
        if (r1.isEmpty() == false) goto L26;
        r0.setIdleAtNs$okhttp(System.nanoTime());
        if (this.connectionPool.connectionBecameIdle(r0) == false) goto L26;
        return r0.socket();
    L26:
        return null;
    L28:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        r4 = -1;
        goto L17
    L5:
        if (Thread.holdsLock(r0) == true) goto L9;
        StringBuilder r5 = new StringBuilder("Thread ");
        Thread r6 = Thread.currentThread();
        Intrinsics.e(r6, "Thread.currentThread()");
        r5.append(r6.getName());
        r5.append(" MUST hold lock on ");
        r5.append(r0);
        throw new AssertionError(r5.toString());
    }

    @Override // okhttp3.Call
    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder r0 = this.exchangeFinder;
        Intrinsics.c(r0);
        return r0.retryAfterFailure();
    }

    public final void setConnectionToCancel(@Nullable RealConnection r1) {
        this.connectionToCancel = r1;
    }

    @Override // okhttp3.Call
    public /* bridge */ /* synthetic */ Timeout timeout() {
        return timeout();
    }

    public final void timeoutEarlyExit() {
        if ((!this.timeoutEarlyExit) == false) goto L7;
        this.timeoutEarlyExit = true;
        exit();
        return;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    public /* bridge */ /* synthetic */ Call clone() {
        return clone();
    }

    @Override // okhttp3.Call
    @NotNull
    public AsyncTimeout timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    @NotNull
    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
