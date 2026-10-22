package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.IOException;
import java.net.ProtocolException;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Exchange {

    @NotNull
    private final RealCall call;
    private final ExchangeCodec codec;

    @NotNull
    private final RealConnection connection;

    @NotNull
    private final EventListener eventListener;

    @NotNull
    private final ExchangeFinder finder;
    private boolean isDuplex;

    @Metadata
    public final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        public RequestBodySink(@NotNull Exchange r2, Sink r3, long r4) {
            Intrinsics.f(r3, "delegate");
            this.this$0 = r2;
            super(r3);
            this.contentLength = r4;
        }

        private final <E extends IOException> E complete(E r8) {
            if (this.completed == false) goto L5;
            return r8;
        L5:
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, r8);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
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

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() {
            super.flush();     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw complete(e);
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(@NotNull Buffer r5, long r6) {
            Intrinsics.f(r5, DBHelper.BATTERY_COL_SOURCE);
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
    }

    @Metadata
    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        final /* synthetic */ Exchange this$0;

        public ResponseBodySource(@NotNull Exchange r2, Source r3, long r4) {
            Intrinsics.f(r3, "delegate");
            this.this$0 = r2;
            super(r3);
            this.contentLength = r4;
            this.invokeStartEvent = true;
            if (r4 != 0) goto L6;
            complete(null);
            return;
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
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

        @Override // okio.ForwardingSource, okio.Source
        public long read(@NotNull Buffer r9, long r10) {
            Intrinsics.f(r9, "sink");
            if ((!this.closed) == false) goto L27;
            long r11 = delegate().read(r9, r10);     // Catch: IOException -> L7
            if (this.invokeStartEvent == false) goto L10;
            this.invokeStartEvent = false;     // Catch: IOException -> L7
            this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());     // Catch: IOException -> L7
        L10:
            if (r11 != (-1)) goto L13;
            complete(null);     // Catch: IOException -> L7
            return -1;
        L13:
            long r4 = this.bytesReceived + r11;     // Catch: IOException -> L7
            long r6 = this.contentLength;     // Catch: IOException -> L7
            if (r6 != (-1)) goto L16;
        L20:
            this.bytesReceived = r4;     // Catch: IOException -> L7
            if (r4 != r6) goto L23;
            complete(null);     // Catch: IOException -> L7
        L23:
            return r11;
        L16:
            if (r4 <= r6) goto L20;
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + r4);     // Catch: IOException -> L7
        L7:
            e = move-exception;
            throw complete(e);
        L27:
            throw new IllegalStateException("closed".toString());
        }
    }

    public Exchange(@NotNull RealCall r2, @NotNull EventListener r3, @NotNull ExchangeFinder r4, @NotNull ExchangeCodec r5) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r3, "eventListener");
        Intrinsics.f(r4, "finder");
        Intrinsics.f(r5, "codec");
        this.call = r2;
        this.eventListener = r3;
        this.finder = r4;
        this.codec = r5;
        this.connection = r5.getConnection();
    }

    private final void trackFailure(IOException r2) {
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

    public final void cancel() {
        this.codec.cancel();
    }

    @NotNull
    public final Sink createRequestBody(@NotNull Request r4, boolean r5) {
        Intrinsics.f(r4, "request");
        this.isDuplex = r5;
        RequestBody r6 = r4.body();
        Intrinsics.c(r6);
        long r0 = r6.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(r4, r0), r0);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() {
        this.codec.finishRequest();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.eventListener.requestFailed(this.call, e);
        trackFailure(e);
        throw e;
    }

    public final void flushRequest() {
        this.codec.flushRequest();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.eventListener.requestFailed(this.call, e);
        trackFailure(e);
        throw e;
    }

    @NotNull
    public final RealCall getCall$okhttp() {
        return this.call;
    }

    @NotNull
    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    @NotNull
    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.a(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    @NotNull
    public final RealWebSocket.Streams newWebSocketStreams() {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    @NotNull
    public final ResponseBody openResponseBody(@NotNull Response r5) {
        Intrinsics.f(r5, ApmTrafficStats.TTNET_RESPONSE);
        String r0 = Response.header$default(r5, "Content-Type", null, 2, null);     // Catch: IOException -> L5
        long r1 = this.codec.reportedContentLength(r5);     // Catch: IOException -> L5
        return new RealResponseBody(r0, r1, Okio.buffer(new ResponseBodySource(this, this.codec.openResponseBodySource(r5), r1)));
    L5:
        e = move-exception;
        this.eventListener.responseFailed(this.call, e);
        trackFailure(e);
        throw e;
    }

    @Nullable
    public final Response.Builder readResponseHeaders(boolean r3) {
        Response.Builder r4 = this.codec.readResponseHeaders(r3);     // Catch: IOException -> L6
        if (r4 == null) goto L8;
        r4.initExchange$okhttp(this);     // Catch: IOException -> L6
    L8:
        return r4;
    L6:
        e = move-exception;
        this.eventListener.responseFailed(this.call, e);
        trackFailure(e);
        throw e;
    }

    public final void responseHeadersEnd(@NotNull Response r2) {
        Intrinsics.f(r2, ApmTrafficStats.TTNET_RESPONSE);
        this.eventListener.responseHeadersEnd(this.call, r2);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    @NotNull
    public final Headers trailers() {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1, true, true, null);
    }

    public final void writeRequestHeaders(@NotNull Request r3) {
        Intrinsics.f(r3, "request");
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
}
