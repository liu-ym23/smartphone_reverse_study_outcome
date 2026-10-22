package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", DeviceInfoProvider.CLIENT, "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", "method", "", "followUpRequest", "exchange", "Lokhttp3/internal/connection/Exchange;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", "", "e", "Ljava/io/IOException;", "requestSendStarted", "recover", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "userRequest", "requestIsOneShot", "retryAfter", "", "defaultDelay", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = null;
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    /* JADX INFO: compiled from: RetryAndFollowUpInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "()V", "MAX_FOLLOW_UPS", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RetryAndFollowUpInterceptor(OkHttpClient r2) {
        Intrinsics.checkNotNullParameter(r2, DeviceInfoProvider.CLIENT);
        this.client = r2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "chain");
        RealInterceptorChain r12 = (RealInterceptorChain) r11;
        Request r0 = r12.getRequest$okhttp();
        RealCall r1 = r12.getCall$okhttp();
        List r2 = CollectionsKt.emptyList();
        int r8 = 0;
        Response r7 = null;
    L3:
        boolean r6 = true;
    L4:
        r1.enterNetworkInterceptorExchange(r0, r6);
    L52:
        th = move-exception;
        r1.exitNetworkInterceptorExchange$okhttp(true);
        throw th;
    L6:
        if (r1.isCanceled() == true) goto L51;
        Response r3 = r12.proceed(r0);     // Catch: IOException -> L33 RouteException -> L43 Throwable -> L52
    L8:
        if (r7 == null) goto L10;
        r3 = r3.newBuilder().priorResponse(r7.newBuilder().body(null).build()).build();     // Catch: Throwable -> L52
    L10:
        r7 = r3;
        Exchange r4 = r1.getInterceptorScopedExchange$okhttp();     // Catch: Throwable -> L52
        Request r9 = followUpRequest(r7, r4);     // Catch: Throwable -> L52
        if (r9 == null) goto L12;
        RequestBody r5 = r9.body();     // Catch: Throwable -> L52
        if (r5 != null) goto L21;
    L24:
        ResponseBody r10 = r7.body();     // Catch: Throwable -> L52
        if (r10 == null) goto L28;
        Util.closeQuietly(r10);     // Catch: Throwable -> L52
    L28:
        r8 = r8 + 1;
        if (r8 > 20) goto L32;
        r1.exitNetworkInterceptorExchange$okhttp(true);
        r0 = r9;
        goto L3
    L32:
        throw new ProtocolException(Intrinsics.stringPlus("Too many follow-up requests: ", Integer.valueOf(r8)));     // Catch: Throwable -> L52
    L21:
        if (r5.isOneShot() == false) goto L24;
        r1.exitNetworkInterceptorExchange$okhttp(false);
        return r7;
    L12:
        if (r4 != null) goto L14;
    L16:
        r1.exitNetworkInterceptorExchange$okhttp(false);
        return r7;
    L14:
        if (r4.isDuplex$okhttp() == false) goto L16;
        r1.timeoutEarlyExit();     // Catch: Throwable -> L52
    L33:
        e = move-exception;
        if ((e instanceof ConnectionShutdownException) == true) goto L37;
        boolean r13 = true;
    L39:
        if (recover(e, r1, r0, r13) == false) goto L42;
        r2 = CollectionsKt.plus(r2, e);     // Catch: Throwable -> L52
    L47:
        r1.exitNetworkInterceptorExchange$okhttp(true);
        r6 = false;
        goto L4
    L42:
        throw Util.withSuppressed(e, r2);     // Catch: Throwable -> L52
    L37:
        r13 = false;
    L43:
        e = move-exception;
        if (recover(e.getLastConnectException(), r1, r0, false) == false) goto L49;
        r2 = CollectionsKt.plus(r2, e.getFirstConnectException());     // Catch: Throwable -> L52
        goto L47
    L49:
        throw Util.withSuppressed(e.getFirstConnectException(), r2);     // Catch: Throwable -> L52
    L51:
        throw new IOException("Canceled");     // Catch: Throwable -> L52
    }

    private final boolean recover(IOException r3, RealCall r4, Request r5, boolean r6) {
        if (this.client.retryOnConnectionFailure() == true) goto L5;
        return false;
    L5:
        if (r6 == false) goto L10;
        if (requestIsOneShot(r3, r5) == false) goto L10;
        return false;
    L10:
        if (isRecoverable(r3, r6) == true) goto L13;
        return false;
    L13:
        if (r4.retryAfterFailure() == true) goto L15;
        return false;
    L15:
        return true;
    }

    private final boolean requestIsOneShot(IOException r1, Request r2) {
        RequestBody r0 = r2.body();
        if (r0 == null) goto L7;
        if (r0.isOneShot() == false) goto L7;
    L8:
        return true;
    L7:
        if ((r1 instanceof FileNotFoundException) == true) goto L8;
        return false;
    }

    private final boolean isRecoverable(IOException r3, boolean r4) {
        if ((r3 instanceof ProtocolException) == false) goto L6;
        return false;
    L6:
        if ((r3 instanceof InterruptedIOException) == false) goto L13;
        if ((r3 instanceof SocketTimeoutException) == false) goto L21;
        if (r4 == false) goto L11;
        return false;
    L11:
        return true;
    L21:
        return false;
    L13:
        if ((r3 instanceof SSLHandshakeException) == false) goto L18;
        if ((r3.getCause() instanceof CertificateException) == false) goto L18;
        return false;
    L18:
        if ((r3 instanceof SSLPeerUnverifiedException) == false) goto L20;
        return false;
    L20:
        return true;
    }

    private final Request followUpRequest(Response r6, Exchange r7) throws IOException {
        if (r7 != null) goto L5;
    L4:
        Route r1 = null;
    L9:
        int r2 = r6.code();
        String r3 = r6.request().method();
        if (r2 == 307) goto L74;
        if (r2 == 308) goto L74;
        if (r2 == 401) goto L72;
        if (r2 != 421) goto L18;
        RequestBody r5 = r6.request().body();
        if (r5 != null) goto L62;
    L64:
        if (r7 != null) goto L66;
    L70:
        return null;
    L66:
        if (r7.isCoalescedConnection$okhttp() == false) goto L70;
        r7.getConnection$okhttp().noCoalescedConnections$okhttp();
        return r6.request();
    L62:
        if (r5.isOneShot() == false) goto L64;
        return null;
    L18:
        if (r2 != 503) goto L20;
        Response r4 = r6.priorResponse();
        if (r4 == null) goto L55;
        if (r4.code() != 503) goto L55;
        return null;
    L55:
        if (retryAfter(r6, Integer.MAX_VALUE) == 0) goto L57;
        return null;
    L57:
        return r6.request();
    L20:
        if (r2 != 407) goto L22;
        Intrinsics.checkNotNull(r1);
        if (r1.proxy().type() != Proxy.Type.HTTP) goto L48;
        return this.client.proxyAuthenticator().authenticate(r1, r6);
    L48:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L22:
        if (r2 == 408) goto L26;
        switch(r2) {
            case 300: goto L74;
            case 301: goto L74;
            case 302: goto L74;
            case 303: goto L74;
            default: goto L24;
        };
    L24:
        return null;
    L26:
        if (this.client.retryOnConnectionFailure() == true) goto L28;
        return null;
    L28:
        RequestBody r8 = r6.request().body();
        if (r8 != null) goto L31;
    L33:
        Response r9 = r6.priorResponse();
        if (r9 == null) goto L39;
        if (r9.code() != 408) goto L39;
        return null;
    L39:
        if (retryAfter(r6, 0) <= 0) goto L42;
        return null;
    L42:
        return r6.request();
    L31:
        if (r8.isOneShot() == false) goto L33;
        return null;
    L72:
        return this.client.authenticator().authenticate(r1, r6);
    L74:
        return buildRedirectRequest(r6, r3);
    L5:
        RealConnection r10 = r7.getConnection$okhttp();
        if (r10 == null) goto L4;
        r1 = r10.route();
        goto L9
    }

    private final Request buildRedirectRequest(Response r8, String r9) {
        RequestBody r1 = null;
        if (this.client.followRedirects() == true) goto L5;
        return null;
    L5:
        String r0 = Response.header$default(r8, "Location", null, 2, null);
        if (r0 != null) goto L8;
        return null;
    L8:
        HttpUrl r2 = r8.request().url().resolve(r0);
        if (r2 != null) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r2.scheme(), r8.request().url().scheme()) == false) goto L14;
    L16:
        Request.Builder r7 = r8.request().newBuilder();
        if (HttpMethod.permitsRequestBody(r9) == false) goto L36;
        int r3 = r8.code();
        if (HttpMethod.INSTANCE.redirectsWithBody(r9) == true) goto L24;
        if (r3 == 308) goto L24;
        if (r3 == 307) goto L24;
        boolean r4 = false;
    L26:
        if (HttpMethod.INSTANCE.redirectsToGet(r9) == false) goto L30;
        if (r3 == 308) goto L30;
        if (r3 == 307) goto L30;
        r7.method("GET", null);
    L33:
        if (r4 == true) goto L36;
        r7.removeHeader("Transfer-Encoding");
        r7.removeHeader("Content-Length");
        r7.removeHeader("Content-Type");
    L30:
        if (r4 == false) goto L32;
        r1 = r8.request().body();
    L32:
        r7.method(r9, r1);
    L24:
        r4 = true;
    L36:
        if (Util.canReuseConnectionFor(r8.request().url(), r2) == true) goto L39;
        r7.removeHeader("Authorization");
    L39:
        return r7.url(r2).build();
    L14:
        if (this.client.followSslRedirects() == true) goto L16;
        return null;
    }

    private final int retryAfter(Response r3, int r4) {
        String r2 = Response.header$default(r3, "Retry-After", null, 2, null);
        if (r2 != null) goto L5;
        return r4;
    L5:
        Regex r5 = new Regex("\\d+");
        if (r5.matches(r2) == false) goto L9;
        Integer r6 = Integer.valueOf(r2);
        Intrinsics.checkNotNullExpressionValue(r6, "valueOf(header)");
        return r6.intValue();
    L9:
        return Integer.MAX_VALUE;
    }
}
