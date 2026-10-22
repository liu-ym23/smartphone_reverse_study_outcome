package okhttp3.internal.http;

import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = null;
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RetryAndFollowUpInterceptor(@NotNull OkHttpClient r2) {
        Intrinsics.f(r2, "client");
        this.client = r2;
    }

    private final Request buildRedirectRequest(Response r8, String r9) {
        RequestBody r1 = null;
        if (this.client.followRedirects() == true) goto L5;
        return null;
    L5:
        String r0 = Response.header$default(r8, "Location", null, 2, null);
        if (r0 == null) goto L38;
        HttpUrl r2 = r8.request().url().resolve(r0);
        if (r2 == null) goto L38;
        if (Intrinsics.a(r2.scheme(), r8.request().url().scheme()) == false) goto L12;
    L14:
        Request.Builder r7 = r8.request().newBuilder();
        if (HttpMethod.permitsRequestBody(r9) == false) goto L34;
        int r3 = r8.code();
        HttpMethod r4 = HttpMethod.INSTANCE;
        if (r4.redirectsWithBody(r9) == true) goto L22;
        if (r3 == 308) goto L22;
        if (r3 == 307) goto L22;
        boolean r5 = false;
    L24:
        if (r4.redirectsToGet(r9) == false) goto L28;
        if (r3 == 308) goto L28;
        if (r3 == 307) goto L28;
        r7.method(HttpMethodContrants.GET, null);
    L31:
        if (r5 == true) goto L34;
        r7.removeHeader(HTTP.TRANSFER_ENCODING);
        r7.removeHeader(HTTP.CONTENT_LEN);
        r7.removeHeader("Content-Type");
    L28:
        if (r5 == false) goto L30;
        r1 = r8.request().body();
    L30:
        r7.method(r9, r1);
    L22:
        r5 = true;
    L34:
        if (Util.canReuseConnectionFor(r8.request().url(), r2) == true) goto L37;
        r7.removeHeader("Authorization");
    L37:
        return r7.url(r2).build();
    L12:
        if (this.client.followSslRedirects() == true) goto L14;
        return null;
    L38:
        return null;
    }

    private final Request followUpRequest(Response r6, Exchange r7) {
        if (r7 == null) goto L7;
        RealConnection r1 = r7.getConnection$okhttp();
        if (r1 == null) goto L7;
        Route r2 = r1.route();
    L8:
        int r3 = r6.code();
        String r4 = r6.request().method();
        if (r3 == 307) goto L73;
        if (r3 == 308) goto L73;
        if (r3 == 401) goto L71;
        if (r3 != 421) goto L17;
        RequestBody r5 = r6.request().body();
        if (r5 != null) goto L61;
    L63:
        if (r7 != null) goto L65;
    L69:
        return null;
    L65:
        if (r7.isCoalescedConnection$okhttp() == false) goto L69;
        r7.getConnection$okhttp().noCoalescedConnections$okhttp();
        return r6.request();
    L61:
        if (r5.isOneShot() == false) goto L63;
        return null;
    L17:
        if (r3 != 503) goto L19;
        Response r8 = r6.priorResponse();
        if (r8 == null) goto L54;
        if (r8.code() != 503) goto L54;
        return null;
    L54:
        if (retryAfter(r6, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) == 0) goto L56;
        return null;
    L56:
        return r6.request();
    L19:
        if (r3 != 407) goto L21;
        Intrinsics.c(r2);
        if (r2.proxy().type() != Proxy.Type.HTTP) goto L47;
        return this.client.proxyAuthenticator().authenticate(r2, r6);
    L47:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L21:
        if (r3 == 408) goto L25;
        switch(r3) {
            case 300: goto L73;
            case 301: goto L73;
            case 302: goto L73;
            case 303: goto L73;
            default: goto L23;
        };
    L23:
        return null;
    L25:
        if (this.client.retryOnConnectionFailure() == true) goto L27;
        return null;
    L27:
        RequestBody r9 = r6.request().body();
        if (r9 != null) goto L30;
    L32:
        Response r10 = r6.priorResponse();
        if (r10 == null) goto L38;
        if (r10.code() != 408) goto L38;
        return null;
    L38:
        if (retryAfter(r6, 0) <= 0) goto L41;
        return null;
    L41:
        return r6.request();
    L30:
        if (r9.isOneShot() == false) goto L32;
        return null;
    L71:
        return this.client.authenticator().authenticate(r2, r6);
    L73:
        return buildRedirectRequest(r6, r4);
    L7:
        r2 = null;
        goto L8
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

    private final int retryAfter(Response r3, int r4) {
        String r2 = Response.header$default(r3, "Retry-After", null, 2, null);
        if (r2 != null) goto L5;
        return r4;
    L5:
        if (new Regex("\\d+").b(r2) == false) goto L8;
        Integer r5 = Integer.valueOf(r2);
        Intrinsics.e(r5, "Integer.valueOf(header)");
        return r5.intValue();
    L8:
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain r12) {
        Intrinsics.f(r12, "chain");
        RealInterceptorChain r13 = (RealInterceptorChain) r12;
        Request r0 = r13.getRequest$okhttp();
        RealCall r1 = r13.getCall$okhttp();
        List r2 = EmptyList.b;
        int r8 = 0;
        Response r7 = null;
    L3:
        boolean r6 = true;
    L4:
        r1.enterNetworkInterceptorExchange(r0, r6);
    L11:
        th = move-exception;
        r1.exitNetworkInterceptorExchange$okhttp(true);
        throw th;
    L6:
        if (r1.isCanceled() == true) goto L49;
        Response r3 = r13.proceed(r0);     // Catch: Throwable -> L11 IOException -> L35 RouteException -> L42
    L8:
        if (r7 == null) goto L10;
        r3 = r3.newBuilder().priorResponse(r7.newBuilder().body(null).build()).build();     // Catch: Throwable -> L11
    L10:
        r7 = r3;
        Exchange r4 = r1.getInterceptorScopedExchange$okhttp();     // Catch: Throwable -> L11
        Request r9 = followUpRequest(r7, r4);     // Catch: Throwable -> L11
        if (r9 == null) goto L15;
        RequestBody r5 = r9.body();     // Catch: Throwable -> L11
        if (r5 != null) goto L24;
    L27:
        ResponseBody r10 = r7.body();     // Catch: Throwable -> L11
        if (r10 == null) goto L30;
        Util.closeQuietly(r10);     // Catch: Throwable -> L11
    L30:
        r8 = r8 + 1;
        if (r8 > 20) goto L34;
        r1.exitNetworkInterceptorExchange$okhttp(true);
        r0 = r9;
        goto L3
    L34:
        throw new ProtocolException("Too many follow-up requests: " + r8);     // Catch: Throwable -> L11
    L24:
        if (r5.isOneShot() == false) goto L27;
        r1.exitNetworkInterceptorExchange$okhttp(false);
        return r7;
    L15:
        if (r4 != null) goto L17;
    L19:
        r1.exitNetworkInterceptorExchange$okhttp(false);
        return r7;
    L17:
        if (r4.isDuplex$okhttp() == false) goto L19;
        r1.timeoutEarlyExit();     // Catch: Throwable -> L11
    L35:
        e = move-exception;
        if (recover(e, r1, r0, !(e instanceof ConnectionShutdownException)) == false) goto L41;
        ArrayList r11 = new ArrayList(r2.size() + 1);     // Catch: Throwable -> L11
        r11.addAll(r2);     // Catch: Throwable -> L11
        r11.add(e);     // Catch: Throwable -> L11
    L39:
        r1.exitNetworkInterceptorExchange$okhttp(true);
        r6 = false;
        r2 = r11;
        goto L4
    L41:
        throw Util.withSuppressed(e, r2);     // Catch: Throwable -> L11
    L42:
        e = move-exception;
        if (recover(e.getLastConnectException(), r1, r0, false) == false) goto L47;
        IOException r14 = e.getFirstConnectException();     // Catch: Throwable -> L11
        r11 = new ArrayList(r2.size() + 1);     // Catch: Throwable -> L11
        r11.addAll(r2);     // Catch: Throwable -> L11
        r11.add(r14);     // Catch: Throwable -> L11
        goto L39
    L47:
        throw Util.withSuppressed(e.getFirstConnectException(), r2);     // Catch: Throwable -> L11
    L49:
        throw new IOException("Canceled");     // Catch: Throwable -> L11
    }
}
