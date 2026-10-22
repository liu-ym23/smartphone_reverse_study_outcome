package okhttp3.internal.connection;

import android.icu.text.PluralRules;
import android.security.bytedance.guard.BDSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
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
import kotlin.Unit;
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

/* JADX INFO: compiled from: RealCall.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\u0018\u00002\u00020\u0001:\u0002deB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u000fJ!\u00103\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u00106\u001a\u0002H4H\u0002¢\u0006\u0002\u00107J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0016J\b\u0010:\u001a\u00020\u0000H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020AH\u0016J\u0016\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0007J\b\u0010E\u001a\u00020FH\u0016J\u0015\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\u0007H\u0000¢\u0006\u0002\bIJ\r\u0010J\u001a\u00020FH\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020NH\u0000¢\u0006\u0002\bOJ\b\u0010P\u001a\u00020\u0007H\u0016J\b\u0010Q\u001a\u00020\u0007H\u0016J;\u0010R\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u00106\u001a\u0002H4H\u0000¢\u0006\u0004\bU\u0010VJ\u0019\u0010W\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\b[J\u000f\u0010\\\u001a\u0004\u0018\u00010]H\u0000¢\u0006\u0002\b^J\b\u0010C\u001a\u00020\u0005H\u0016J\u0006\u0010_\u001a\u00020\u0007J\b\u0010-\u001a\u00020`H\u0016J\u0006\u00100\u001a\u000202J!\u0010a\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u0010b\u001a\u0002H4H\u0002¢\u0006\u0002\u00107J\b\u0010c\u001a\u00020ZH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001e@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", DeviceInfoProvider.CLIENT, "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "callStackTrace", "", "canceled", "getClient", "()Lokhttp3/OkHttpClient;", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", WsConstants.KEY_CONNECTION, "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionToCancel", "getConnectionToCancel", "setConnectionToCancel", "(Lokhttp3/internal/connection/RealConnection;)V", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "expectMoreExchanges", "getForWebSocket", "()Z", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getOriginalRequest", "()Lokhttp3/Request;", "requestBodyOpen", "responseBodyOpen", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "callDone", "E", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "callStart", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "clone", "createAddress", "Lokhttp3/Address;", "url", "Lokhttp3/HttpUrl;", "enqueue", "responseCallback", "Lokhttp3/Callback;", "enterNetworkInterceptorExchange", Ext.KEY_REQUEST, "newExchangeFinder", "execute", "Lokhttp3/Response;", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "initExchange", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "initExchange$okhttp", "isCanceled", "isExecuted", "messageDone", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "noMoreExchanges$okhttp", "redactedUrl", "", "redactedUrl$okhttp", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "retryAfterFailure", "Lokio/AsyncTimeout;", "timeoutExit", "cause", "toLoggableString", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private volatile RealConnection connectionToCancel;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final AnonymousClass1 timeout;
    private boolean timeoutEarlyExit;

    /* JADX INFO: compiled from: RealCall.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0000R\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "getCall", "()Lokhttp3/internal/connection/RealCall;", "<set-?>", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", WifiAuthorizeUtils.AUTO_LOGIN_HOST, "", "getHost", "()Ljava/lang/String;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "executeOn", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "reuseCallsPerHostFrom", PluralRules.KEYWORD_OTHER, "run", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall r2, Callback r3) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "responseCallback");
            this.this$0 = r2;
            this.responseCallback = r3;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final void reuseCallsPerHostFrom(AsyncCall r2) {
            Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
            this.callsPerHost = r2.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final void executeOn(ExecutorService r3) {
            Intrinsics.checkNotNullParameter(r3, "executorService");
            Dispatcher r0 = this.this$0.getClient().dispatcher();
            if (Util.assertionsEnabled == true) goto L5;
        L19:
            r3.execute(this);     // Catch: Throwable -> L11 RejectedExecutionException -> L13
        L22:
            return;
        L13:
            e = move-exception;
            InterruptedIOException r1 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L11
            r1.initCause(e);     // Catch: Throwable -> L11
            this.this$0.noMoreExchanges$okhttp(r1);     // Catch: Throwable -> L11
            this.responseCallback.onFailure(this.this$0, r1);     // Catch: Throwable -> L11
            this.this$0.getClient().dispatcher().finished$okhttp(this);
            return;
        L11:
            th = move-exception;
            this.this$0.getClient().dispatcher().finished$okhttp(this);
            throw th;
        L5:
            if (Thread.holdsLock(r0) == false) goto L19;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }

        @Override // java.lang.Runnable
        public void run() {
            String r0 = Intrinsics.stringPlus("OkHttp ", this.this$0.redactedUrl$okhttp());
            RealCall r1 = this.this$0;
            Thread r2 = Thread.currentThread();
            String r3 = r2.getName();
            r2.setName(r0);
            RealCall.access$getTimeout$p(r1).enter();     // Catch: Throwable -> L34
            boolean r4 = true;
            this.responseCallback.onResponse(r1, r1.getResponseWithInterceptorChain$okhttp());     // Catch: Throwable -> L11 IOException -> L13
            Dispatcher r5 = r1.getClient().dispatcher();     // Catch: Throwable -> L34
        L9:
            r5.finished$okhttp(this);     // Catch: Throwable -> L34
            r2.setName(r3);
            return;
        L13:
            IOException e = e;
        L25:
            if (r4 == false) goto L27;
            Platform.Companion.get().log(Intrinsics.stringPlus("Callback failure for ", RealCall.access$toLoggableString(r1)), 4, e);     // Catch: Throwable -> L21
        L28:
            r5 = r1.getClient().dispatcher();     // Catch: Throwable -> L34
            goto L9
        L27:
            this.responseCallback.onFailure(r1, e);     // Catch: Throwable -> L21
        L11:
            Throwable th = th;
        L17:
            r1.cancel();     // Catch: Throwable -> L21
            if (r4 == true) goto L20;
            IOException r6 = new IOException(Intrinsics.stringPlus("canceled due to ", th));     // Catch: Throwable -> L21
            ExceptionsKt.addSuppressed(r6, th);     // Catch: Throwable -> L21
            this.responseCallback.onFailure(r1, r6);     // Catch: Throwable -> L21
        L20:
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            r1.getClient().dispatcher().finished$okhttp(this);     // Catch: Throwable -> L34
            throw th;     // Catch: Throwable -> L34
        L23:
            e = move-exception;
            r4 = false;
            e = e;
        L15:
            th = move-exception;
            r4 = false;
            th = th;
        L34:
            th = move-exception;
            r2.setName(r3);
            throw th;
        }
    }

    /* JADX INFO: compiled from: RealCall.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }

        public CallReference(RealCall r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "referent");
            super(r2);
            this.callStackTrace = r3;
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(OkHttpClient r2, Request r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, DeviceInfoProvider.CLIENT);
        Intrinsics.checkNotNullParameter(r3, "originalRequest");
        this.client = r2;
        this.originalRequest = r3;
        this.forWebSocket = r4;
        this.connectionPool = r2.connectionPool().getDelegate$okhttp();
        this.eventListener = r2.eventListenerFactory().create(this);
        ?? r5 = new AnonymousClass1(this);
        r5.timeout(getClient().callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = r5;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    public static final /* synthetic */ AnonymousClass1 access$getTimeout$p(RealCall r0) {
        return r0.timeout;
    }

    public static final /* synthetic */ String access$toLoggableString(RealCall r0) {
        return r0.toLoggableString();
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // okhttp3.Call
    public /* bridge */ /* synthetic */ Call clone() {
        return clone();
    }

    @Override // okhttp3.Call
    public /* bridge */ /* synthetic */ Timeout timeout() {
        return timeout();
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    public final void setConnectionToCancel(RealConnection r1) {
        this.connectionToCancel = r1;
    }

    @Override // okhttp3.Call
    public AsyncTimeout timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled == false) goto L5;
        return;
    L5:
        this.canceled = true;
        Exchange r0 = this.exchange;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        RealConnection r1 = this.connectionToCancel;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        this.eventListener.canceled(this);
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // okhttp3.Call
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

    @Override // okhttp3.Call
    public void enqueue(Callback r4) {
        Intrinsics.checkNotNullParameter(r4, "responseCallback");
        if (this.executed.compareAndSet(false, true) == false) goto L7;
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, r4));
        return;
    L7:
        throw new IllegalStateException("Already Executed".toString());
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        ArrayList r3 = new ArrayList();
        ArrayList r0 = r3;
        CollectionsKt.addAll(r0, this.client.interceptors());
        r0.add(new RetryAndFollowUpInterceptor(this.client));
        r0.add(new BridgeInterceptor(this.client.cookieJar()));
        r0.add(new CacheInterceptor(this.client.cache()));
        r0.add(ConnectInterceptor.INSTANCE);
        if (this.forWebSocket == true) goto L5;
        CollectionsKt.addAll(r0, this.client.networkInterceptors());
    L5:
        r0.add(new CallServerInterceptor(this.forWebSocket));
        RealInterceptorChain r1 = new RealInterceptorChain(this, r3, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        Response r2 = r1.proceed(this.originalRequest);     // Catch: Throwable -> L12 IOException -> L14
        if (isCanceled() == true) goto L10;
        noMoreExchanges$okhttp(null);
        return r2;
    L10:
        Util.closeQuietly(r2);     // Catch: Throwable -> L12 IOException -> L14
        throw new IOException("Canceled");     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = move-exception;
        IOException r4 = noMoreExchanges$okhttp(e);     // Catch: Throwable -> L12
        if (r4 != null) goto L21;
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L12
    L21:
        throw r4;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (0 != 0) goto L24;
        noMoreExchanges$okhttp(null);
    L24:
        throw th;
    }

    public final void enterNetworkInterceptorExchange(Request r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        if (this.interceptorScopedExchange != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L25;
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L9:
        if ((!this.responseBodyOpen) == false) goto L20;
        if ((!this.requestBodyOpen) == false) goto L18;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        if (r4 == false) goto L27;
        this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(r3.url()), this, this.eventListener);
        return;
    L27:
        return;
    L18:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());     // Catch: Throwable -> L21
    L25:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain r5) {
        Intrinsics.checkNotNullParameter(r5, "chain");
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (this.expectMoreExchanges == false) goto L29;
        if ((!this.responseBodyOpen) == false) goto L27;
        if ((!this.requestBodyOpen) == false) goto L25;
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(this);
        ExchangeFinder r1 = this.exchangeFinder;
        Intrinsics.checkNotNull(r1);
        Exchange r2 = new Exchange(this, this.eventListener, r1, r1.find(this.client, r5));
        this.interceptorScopedExchange = r2;
        this.exchange = r2;
        monitor-enter(this);
        this.requestBodyOpen = true;     // Catch: Throwable -> L21
        this.responseBodyOpen = true;     // Catch: Throwable -> L21
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        if (this.canceled == true) goto L20;
        return r2;
    L20:
        throw new IOException("Canceled");
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L30
    L27:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("released".toString());     // Catch: Throwable -> L30
    }

    public final <E extends IOException> E messageDone$okhttp(Exchange r2, boolean r3, boolean r4, E r5) {
        Intrinsics.checkNotNullParameter(r2, "exchange");
        if (Intrinsics.areEqual(r2, this.exchange) == true) goto L5;
        return r5;
    L5:
        monitor-enter(this);
        boolean r6 = false;
        if (r3 == true) goto L47;
    L13:
        if (r4 == true) goto L15;
    L33:
        boolean r7 = false;
    L34:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        if (r6 == false) goto L41;
        this.exchange = null;
        RealConnection r9 = this.connection;
        if (r9 == null) goto L41;
        r9.incrementSuccessCount$okhttp();
    L41:
        if (r7 == true) goto L43;
        return r5;
    L43:
        return (E) callDone(r5);
    L11:
        th = move-exception;
        throw th;
    L15:
        if (this.responseBodyOpen == false) goto L33;
    L16:
        if (r3 == false) goto L18;
        this.requestBodyOpen = false;     // Catch: Throwable -> L11
    L18:
        if (r4 == false) goto L20;
        this.responseBodyOpen = false;     // Catch: Throwable -> L11
    L20:
        boolean r10 = this.requestBodyOpen;     // Catch: Throwable -> L11
        if (r10 == false) goto L23;
    L25:
        boolean r0 = false;
    L26:
        if (r10 == false) goto L28;
    L32:
        r7 = r6;
        r6 = r0;
        goto L34
    L28:
        if (this.responseBodyOpen == true) goto L32;
        if (this.expectMoreExchanges == true) goto L32;
        r6 = true;
        goto L32
    L23:
        if (this.responseBodyOpen == true) goto L25;
        r0 = true;
        goto L26
    L47:
        if (this.requestBodyOpen == true) goto L16;
        goto L16
    }

    public final IOException noMoreExchanges$okhttp(IOException r3) {
        monitor-enter(this);
        boolean r1 = false;
        if (this.expectMoreExchanges == false) goto L10;
        this.expectMoreExchanges = false;     // Catch: Throwable -> L16
        if (this.requestBodyOpen == true) goto L10;
        if (this.responseBodyOpen == true) goto L10;
        r1 = true;
    L10:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        if (r1 == true) goto L14;
        return r3;
    L14:
        return callDone(r3);
    L16:
        th = move-exception;
        throw th;
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection r0 = this.connection;
        Intrinsics.checkNotNull(r0);
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        List<Reference<RealCall>> r1 = r0.getCalls();
        Iterator<Reference<RealCall>> r2 = r1.iterator();
        boolean r3 = false;
        int r4 = 0;
    L11:
        if (r2.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(r2.next().get(), this) == true) goto L17;
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
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r0);
    }

    private final <E extends IOException> E timeoutExit(E r2) {
        if (this.timeoutEarlyExit == false) goto L6;
        return r2;
    L6:
        if (exit() == true) goto L8;
        return r2;
    L8:
        InterruptedIOException r1 = new InterruptedIOException("timeout");
        if (r2 == null) goto L12;
        r1.initCause(r2);
    L12:
        return r1;
    }

    public final void timeoutEarlyExit() {
        if ((!this.timeoutEarlyExit) == false) goto L7;
        this.timeoutEarlyExit = true;
        exit();
        return;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean r2) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.expectMoreExchanges == false) goto L15;
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        if (r2 == false) goto L12;
        Exchange r3 = this.exchange;
        if (r3 == null) goto L12;
        r3.detachWithViolence();
    L12:
        this.interceptorScopedExchange = null;
        return;
    L15:
        throw new IllegalStateException("released".toString());     // Catch: Throwable -> L16
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

    public final boolean retryAfterFailure() {
        ExchangeFinder r0 = this.exchangeFinder;
        Intrinsics.checkNotNull(r0);
        return r0.retryAfterFailure();
    }

    private final String toLoggableString() {
        StringBuilder r0 = new StringBuilder();
        if (isCanceled() == false) goto L5;
        String r1 = "canceled ";
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.forWebSocket == false) goto L9;
        String r3 = "web socket";
    L11:
        return r2.append(r3).append(" to ").append(redactedUrl$okhttp()).toString();
    L9:
        r3 = NotificationCompat.CATEGORY_CALL;
        goto L11
    L5:
        r1 = "";
        goto L6
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    public final void acquireConnectionNoEvents(RealConnection r3) {
        Intrinsics.checkNotNullParameter(r3, WsConstants.KEY_CONNECTION);
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(r3) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r3);
    L10:
        if (this.connection != null) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L17;
        this.connection = r3;
        r3.getCalls().add(new CallReference(this, this.callStackTrace));
        return;
    L17:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r0 = false;
        goto L13
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
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        RealConnection r0 = this.connection;
        if (r0 != null) goto L12;
    L37:
        E r1 = (E) timeoutExit(r4);
        if (r4 == null) goto L40;
        Intrinsics.checkNotNull(r1);
        this.eventListener.callFailed(this, r1);
    L41:
        return r1;
    L40:
        this.eventListener.callEnd(this);
        goto L41
    L12:
        if (Util.assertionsEnabled == true) goto L14;
    L18:
        monitor-enter(r0);
        Socket r2 = releaseConnectionNoEvents$okhttp();     // Catch: Throwable -> L34
        monitor-exit(r0);
        if (this.connection != null) goto L27;
        if (r2 == null) goto L26;
        Util.closeQuietly(r2);
    L26:
        this.eventListener.connectionReleased(this, r0);
        goto L37
    L27:
        if (r2 != null) goto L29;
        boolean r3 = true;
    L30:
        if (r3 == true) goto L37;
        throw new IllegalStateException("Check failed.".toString());
    L29:
        r3 = false;
    L34:
        th = move-exception;
        throw th;
    L14:
        if (Thread.holdsLock(r0) == false) goto L18;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
