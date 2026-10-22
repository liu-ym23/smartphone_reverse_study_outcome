package okhttp3.internal.connection;

import android.security.bytedance.guard.BDSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: Exchange.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002CDB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ7\u0010\u001e\u001a\u0002H\u001f\"\n\b\u0000\u0010\u001f*\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u0002H\u001f¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020(J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0016J\u0006\u0010.\u001a\u00020(J\u0006\u0010/\u001a\u00020(J\u0006\u00100\u001a\u00020(J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020(J\u0006\u00104\u001a\u00020(J\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u0016J\u000e\u0010<\u001a\u00020(2\u0006\u00107\u001a\u000208J\u0006\u0010=\u001a\u00020(J\u0010\u0010>\u001a\u00020(2\u0006\u0010%\u001a\u00020 H\u0002J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020(J\u000e\u0010B\u001a\u00020(2\u0006\u0010+\u001a\u00020,R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019¨\u0006E"}, d2 = {"Lokhttp3/internal/connection/Exchange;", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "finder", "Lokhttp3/internal/connection/ExchangeFinder;", "codec", "Lokhttp3/internal/http/ExchangeCodec;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "<set-?>", "", "hasFailure", "getHasFailure$okhttp", "()Z", "isCoalescedConnection", "isCoalescedConnection$okhttp", "isDuplex", "isDuplex$okhttp", "bodyComplete", "E", "Ljava/io/IOException;", "bytesRead", "", "responseDone", "requestDone", "e", "(JZZLjava/io/IOException;)Ljava/io/IOException;", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "createRequestBody", "Lokio/Sink;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "duplex", "detachWithViolence", "finishRequest", "flushRequest", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "noNewExchangesOnConnection", "noRequestBody", "openResponseBody", "Lokhttp3/ResponseBody;", ApmTrafficStats.TTNET_RESPONSE, "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "responseHeadersEnd", "responseHeadersStart", "trackFailure", "trailers", "Lokhttp3/Headers;", "webSocketUpgradeFailed", "writeRequestHeaders", "RequestBodySink", "ResponseBodySource", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    /* JADX INFO: compiled from: Exchange.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000eH\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/connection/Exchange$RequestBodySink;", "Lokio/ForwardingSink;", "delegate", "Lokio/Sink;", "contentLength", "", "(Lokhttp3/internal/connection/Exchange;Lokio/Sink;J)V", "bytesReceived", "closed", "", "completed", "close", "", "complete", "E", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        public RequestBodySink(Exchange r2, Sink r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "delegate");
            this.this$0 = r2;
            super(r3);
            this.contentLength = r4;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer r5, long r6) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "source");
            if ((!this.closed) == false) goto L17;
            long r0 = this.contentLength;
            if (r0 != (-1)) goto L7;
        L18:
            super.write(r5, r6);     // Catch: IOException -> L13
            this.bytesReceived += r6;     // Catch: IOException -> L13
            return;
        L13:
            e = move-exception;
            throw complete(e);
        L7:
            if ((this.bytesReceived + r6) <= r0) goto L18;
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + r6));
        L17:
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            super.flush();     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw complete(e);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            long r0 = this.contentLength;
            if (r0 != (-1)) goto L8;
        L17:
            super.close();     // Catch: IOException -> L14
            complete(null);     // Catch: IOException -> L14
            return;
        L14:
            e = move-exception;
            throw complete(e);
        L8:
            if (this.bytesReceived == r0) goto L17;
            throw new ProtocolException("unexpected end of stream");
        }

        private final <E extends IOException> E complete(E r8) {
            if (this.completed == false) goto L5;
            return r8;
        L5:
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, r8);
        }
    }

    /* JADX INFO: compiled from: Exchange.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u001f\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u0002H\u000f¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "contentLength", "", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;J)V", "bytesReceived", "closed", "", "completed", "invokeStartEvent", "close", "", "complete", "E", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        final /* synthetic */ Exchange this$0;

        public ResponseBodySource(Exchange r2, Source r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "delegate");
            this.this$0 = r2;
            super(r3);
            this.contentLength = r4;
            this.invokeStartEvent = true;
            if (r4 != 0) goto L6;
            complete(null);
            return;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer r9, long r10) throws IOException {
            Intrinsics.checkNotNullParameter(r9, "sink");
            if ((!this.closed) == false) goto L26;
            long r11 = delegate().read(r9, r10);     // Catch: IOException -> L22
            if (this.invokeStartEvent == false) goto L8;
            this.invokeStartEvent = false;     // Catch: IOException -> L22
            this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());     // Catch: IOException -> L22
        L8:
            if (r11 != (-1)) goto L11;
            complete(null);     // Catch: IOException -> L22
            return -1;
        L11:
            long r4 = this.bytesReceived + r11;     // Catch: IOException -> L22
            long r6 = this.contentLength;     // Catch: IOException -> L22
            if (r6 != (-1)) goto L14;
        L18:
            this.bytesReceived = r4;     // Catch: IOException -> L22
            if (r4 != r6) goto L21;
            complete(null);     // Catch: IOException -> L22
        L21:
            return r11;
        L14:
            if (r4 <= r6) goto L18;
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + r4);     // Catch: IOException -> L22
        L22:
            e = move-exception;
            throw complete(e);
        L26:
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            super.close();     // Catch: IOException -> L8
            complete(null);     // Catch: IOException -> L8
            return;
        L8:
            e = move-exception;
            throw complete(e);
        }

        public final <E extends IOException> E complete(E r9) {
            if (this.completed == false) goto L5;
            return r9;
        L5:
            this.completed = true;
            if (r9 != null) goto L11;
            if (this.invokeStartEvent == false) goto L11;
            this.invokeStartEvent = false;
            this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
        L11:
            return (E) this.this$0.bodyComplete(this.bytesReceived, true, false, r9);
        }
    }

    public Exchange(RealCall r2, EventListener r3, ExchangeFinder r4, ExchangeCodec r5) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r3, "eventListener");
        Intrinsics.checkNotNullParameter(r4, "finder");
        Intrinsics.checkNotNullParameter(r5, "codec");
        this.call = r2;
        this.eventListener = r3;
        this.finder = r4;
        this.codec = r5;
        this.connection = r5.getConnection();
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.areEqual(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final void writeRequestHeaders(Request r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        this.eventListener.requestHeadersStart(this.call);     // Catch: IOException -> L5
        this.codec.writeRequestHeaders(r3);     // Catch: IOException -> L5
        this.eventListener.requestHeadersEnd(this.call, r3);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        this.eventListener.requestFailed(this.call, e);
        trackFailure(e);
        throw e;
    }

    public final Sink createRequestBody(Request r4, boolean r5) throws IOException {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        this.isDuplex = r5;
        RequestBody r6 = r4.body();
        Intrinsics.checkNotNull(r6);
        long r0 = r6.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(r4, r0), r0);
    }

    public final void flushRequest() throws IOException {
        this.codec.flushRequest();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.eventListener.requestFailed(this.call, e);
        trackFailure(e);
        throw e;
    }

    public final void finishRequest() throws IOException {
        this.codec.finishRequest();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.eventListener.requestFailed(this.call, e);
        trackFailure(e);
        throw e;
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Response.Builder readResponseHeaders(boolean r3) throws IOException {
        Response.Builder r4 = this.codec.readResponseHeaders(r3);     // Catch: IOException -> L7
        if (r4 == null) goto L6;
        r4.initExchange$okhttp(this);     // Catch: IOException -> L7
    L6:
        return r4;
    L7:
        e = move-exception;
        this.eventListener.responseFailed(this.call, e);
        trackFailure(e);
        throw e;
    }

    public final void responseHeadersEnd(Response r2) {
        Intrinsics.checkNotNullParameter(r2, ApmTrafficStats.TTNET_RESPONSE);
        this.eventListener.responseHeadersEnd(this.call, r2);
    }

    public final ResponseBody openResponseBody(Response r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, ApmTrafficStats.TTNET_RESPONSE);
        String r0 = Response.header$default(r5, "Content-Type", null, 2, null);     // Catch: IOException -> L5
        long r1 = this.codec.reportedContentLength(r5);     // Catch: IOException -> L5
        return new RealResponseBody(r0, r1, Okio.buffer(new ResponseBodySource(this, this.codec.openResponseBodySource(r5), r1)));
    L5:
        e = move-exception;
        this.eventListener.responseFailed(this.call, e);
        trackFailure(e);
        throw e;
    }

    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1, true, true, null);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    private final void trackFailure(IOException r2) {
        this.hasFailure = true;
        this.finder.trackFailure(r2);
        this.codec.getConnection().trackFailure$okhttp(this.call, r2);
    }

    public final <E extends IOException> E bodyComplete(long r3, boolean r5, boolean r6, E r7) {
        if (r7 == null) goto L4;
        trackFailure(r7);
    L4:
        if (r6 == false) goto L8;
        if (r7 == null) goto L7;
        this.eventListener.requestFailed(this.call, r7);
        goto L8
    L7:
        this.eventListener.requestBodyEnd(this.call, r3);
    L8:
        if (r5 == false) goto L13;
        if (r7 == null) goto L11;
        this.eventListener.responseFailed(this.call, r7);
        goto L13
    L11:
        this.eventListener.responseBodyEnd(this.call, r3);
    L13:
        return (E) this.call.messageDone$okhttp(this, r6, r5, r7);
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }
}
