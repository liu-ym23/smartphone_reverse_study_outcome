package okhttp3.internal.http;

import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: loaded from: classes5.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    static final class CountingSink extends ForwardingSink {
        long successfulCount;

        CountingSink(Sink r1) {
            super(r1);
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer r3, long r4) throws IOException {
            super.write(r3, r4);
            this.successfulCount += r4;
        }
    }

    public CallServerInterceptor(boolean r1) {
        this.forWebSocket = r1;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r12) throws IOException {
        RealInterceptorChain r13 = (RealInterceptorChain) r12;
        HttpCodec r0 = r13.httpStream();
        StreamAllocation r1 = r13.streamAllocation();
        RealConnection r2 = (RealConnection) r13.connection();
        Request r3 = r13.request();
        long r4 = System.currentTimeMillis();
        r13.eventListener().requestHeadersStart(r13.call());
        r0.writeRequestHeaders(r3);
        r13.eventListener().requestHeadersEnd(r13.call(), r3);
        Response.Builder r7 = null;
        if (HttpMethod.permitsRequestBody(r3.method()) == true) goto L5;
    L14:
        r0.finishRequest();
        if (r7 != null) goto L17;
        r13.eventListener().responseHeadersStart(r13.call());
        r7 = r0.readResponseHeaders(false);
    L17:
        Response r6 = r7.request(r3).handshake(r1.connection().handshake()).sentRequestAtMillis(r4).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int r8 = r6.code();
        if (r8 != 100) goto L20;
        r6 = r0.readResponseHeaders(false).request(r3).handshake(r1.connection().handshake()).sentRequestAtMillis(r4).receivedResponseAtMillis(System.currentTimeMillis()).build();
        r8 = r6.code();
    L20:
        r13.eventListener().responseHeadersEnd(r13.call(), r6);
        if (this.forWebSocket == true) goto L23;
    L25:
        Response r11 = r6.newBuilder().body(r0.openResponseBody(r6)).build();
    L27:
        if ("close".equalsIgnoreCase(r11.request().header(HTTP.CONN_DIRECTIVE)) == false) goto L29;
    L30:
        r1.noNewStreams();
    L32:
        if (r8 == 204) goto L36;
        if (r8 == 205) goto L36;
    L37:
        return r11;
    L36:
        if (r11.body().contentLength() <= 0) goto L37;
        throw new ProtocolException("HTTP " + r8 + " had non-zero Content-Length: " + r11.body().contentLength());
    L29:
        if ("close".equalsIgnoreCase(r11.header(HTTP.CONN_DIRECTIVE)) == false) goto L32;
    L23:
        if (r8 != 101) goto L25;
        r11 = r6.newBuilder().body(Util.EMPTY_RESPONSE).build();
        goto L27
    L5:
        if (r3.body() == null) goto L14;
        if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(r3.header(HTTP.EXPECT_DIRECTIVE)) == false) goto L9;
        r0.flushRequest();
        r13.eventListener().responseHeadersStart(r13.call());
        r7 = r0.readResponseHeaders(true);
    L9:
        if (r7 != null) goto L12;
        r13.eventListener().requestBodyStart(r13.call());
        CountingSink r5 = new CountingSink(r0.createRequestBody(r3, r3.body().contentLength()));
        BufferedSink r9 = Okio.buffer(r5);
        r3.body().writeTo(r9);
        r9.close();
        r13.eventListener().requestBodyEnd(r13.call(), r5.successfulCount);
        goto L14
    L12:
        if (r2.isMultiplexed() == true) goto L14;
        r1.noNewStreams();
        goto L14
    }
}
