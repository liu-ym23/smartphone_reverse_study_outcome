package okhttp3;

import a.a;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.Closeable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Response implements Closeable {

    @Nullable
    private final ResponseBody body;

    @Nullable
    private final Response cacheResponse;
    private final int code;

    @Nullable
    private final Exchange exchange;

    @Nullable
    private final Handshake handshake;

    @NotNull
    private final Headers headers;
    private CacheControl lazyCacheControl;

    @NotNull
    private final String message;

    @Nullable
    private final Response networkResponse;

    @Nullable
    private final Response priorResponse;

    @NotNull
    private final Protocol protocol;
    private final long receivedResponseAtMillis;

    @NotNull
    private final Request request;
    private final long sentRequestAtMillis;

    @Metadata
    public static class Builder {

        @Nullable
        private ResponseBody body;

        @Nullable
        private Response cacheResponse;
        private int code;

        @Nullable
        private Exchange exchange;

        @Nullable
        private Handshake handshake;

        @NotNull
        private Headers.Builder headers;

        @Nullable
        private String message;

        @Nullable
        private Response networkResponse;

        @Nullable
        private Response priorResponse;

        @Nullable
        private Protocol protocol;
        private long receivedResponseAtMillis;

        @Nullable
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response r1) {
            if (r1 != null) goto L4;
            return;
        L4:
            if (r1.body() != null) goto L6;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L10;
            return;
        L10:
            throw new IllegalArgumentException("priorResponse.body != null".toString());
        L6:
            r0 = false;
            goto L7
        }

        private final void checkSupportResponse(String r3, Response r4) {
            if (r4 == null) goto L31;
            boolean r0 = false;
            if (r4.body() != null) goto L6;
            boolean r2 = true;
        L7:
            if (r2 == false) goto L30;
            if (r4.networkResponse() != null) goto L11;
            boolean r5 = true;
        L12:
            if (r5 == false) goto L28;
            if (r4.cacheResponse() != null) goto L16;
            boolean r6 = true;
        L17:
            if (r6 == false) goto L26;
            if (r4.priorResponse() != null) goto L21;
            r0 = true;
        L21:
            if (r0 == false) goto L24;
            return;
        L24:
            throw new IllegalArgumentException(a.j(r3, ".priorResponse != null").toString());
        L26:
            throw new IllegalArgumentException(a.j(r3, ".cacheResponse != null").toString());
        L16:
            r6 = false;
            goto L17
        L28:
            throw new IllegalArgumentException(a.j(r3, ".networkResponse != null").toString());
        L11:
            r5 = false;
            goto L12
        L30:
            throw new IllegalArgumentException(a.j(r3, ".body != null").toString());
        L6:
            r2 = false;
            goto L7
        }

        @NotNull
        public Builder addHeader(@NotNull String r2, @NotNull String r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            this.headers.add(r2, r3);
            return this;
        }

        @NotNull
        public Builder body(@Nullable ResponseBody r1) {
            this.body = r1;
            return this;
        }

        @NotNull
        public Response build() {
            int r4 = this.code;
            if (r4 < 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L22;
            Request r2 = this.request;
            if (r2 == null) goto L20;
            Protocol r3 = this.protocol;
            if (r3 == null) goto L18;
            String r5 = this.message;
            if (r5 == null) goto L16;
            return new Response(r2, r3, r5, r4, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
        L16:
            throw new IllegalStateException("message == null".toString());
        L18:
            throw new IllegalStateException("protocol == null".toString());
        L20:
            throw new IllegalStateException("request == null".toString());
        L22:
            throw new IllegalStateException(("code < 0: " + this.code).toString());
        L5:
            r1 = false;
            goto L6
        }

        @NotNull
        public Builder cacheResponse(@Nullable Response r2) {
            checkSupportResponse("cacheResponse", r2);
            this.cacheResponse = r2;
            return this;
        }

        @NotNull
        public Builder code(int r1) {
            this.code = r1;
            return this;
        }

        @Nullable
        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        @Nullable
        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        @Nullable
        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        @Nullable
        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        @NotNull
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @Nullable
        public final String getMessage$okhttp() {
            return this.message;
        }

        @Nullable
        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        @Nullable
        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        @Nullable
        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        @Nullable
        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        @NotNull
        public Builder handshake(@Nullable Handshake r1) {
            this.handshake = r1;
            return this;
        }

        @NotNull
        public Builder header(@NotNull String r2, @NotNull String r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            this.headers.set(r2, r3);
            return this;
        }

        @NotNull
        public Builder headers(@NotNull Headers r2) {
            Intrinsics.f(r2, "headers");
            this.headers = r2.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(@NotNull Exchange r2) {
            Intrinsics.f(r2, "deferredTrailers");
            this.exchange = r2;
        }

        @NotNull
        public Builder message(@NotNull String r2) {
            Intrinsics.f(r2, "message");
            this.message = r2;
            return this;
        }

        @NotNull
        public Builder networkResponse(@Nullable Response r2) {
            checkSupportResponse("networkResponse", r2);
            this.networkResponse = r2;
            return this;
        }

        @NotNull
        public Builder priorResponse(@Nullable Response r1) {
            checkPriorResponse(r1);
            this.priorResponse = r1;
            return this;
        }

        @NotNull
        public Builder protocol(@NotNull Protocol r2) {
            Intrinsics.f(r2, "protocol");
            this.protocol = r2;
            return this;
        }

        @NotNull
        public Builder receivedResponseAtMillis(long r1) {
            this.receivedResponseAtMillis = r1;
            return this;
        }

        @NotNull
        public Builder removeHeader(@NotNull String r2) {
            Intrinsics.f(r2, "name");
            this.headers.removeAll(r2);
            return this;
        }

        @NotNull
        public Builder request(@NotNull Request r2) {
            Intrinsics.f(r2, "request");
            this.request = r2;
            return this;
        }

        @NotNull
        public Builder sentRequestAtMillis(long r1) {
            this.sentRequestAtMillis = r1;
            return this;
        }

        public final void setBody$okhttp(@Nullable ResponseBody r1) {
            this.body = r1;
        }

        public final void setCacheResponse$okhttp(@Nullable Response r1) {
            this.cacheResponse = r1;
        }

        public final void setCode$okhttp(int r1) {
            this.code = r1;
        }

        public final void setExchange$okhttp(@Nullable Exchange r1) {
            this.exchange = r1;
        }

        public final void setHandshake$okhttp(@Nullable Handshake r1) {
            this.handshake = r1;
        }

        public final void setHeaders$okhttp(@NotNull Headers.Builder r2) {
            Intrinsics.f(r2, "<set-?>");
            this.headers = r2;
        }

        public final void setMessage$okhttp(@Nullable String r1) {
            this.message = r1;
        }

        public final void setNetworkResponse$okhttp(@Nullable Response r1) {
            this.networkResponse = r1;
        }

        public final void setPriorResponse$okhttp(@Nullable Response r1) {
            this.priorResponse = r1;
        }

        public final void setProtocol$okhttp(@Nullable Protocol r1) {
            this.protocol = r1;
        }

        public final void setReceivedResponseAtMillis$okhttp(long r1) {
            this.receivedResponseAtMillis = r1;
        }

        public final void setRequest$okhttp(@Nullable Request r1) {
            this.request = r1;
        }

        public final void setSentRequestAtMillis$okhttp(long r1) {
            this.sentRequestAtMillis = r1;
        }

        public Builder(@NotNull Response r3) {
            Intrinsics.f(r3, ApmTrafficStats.TTNET_RESPONSE);
            this.code = -1;
            this.request = r3.request();
            this.protocol = r3.protocol();
            this.code = r3.code();
            this.message = r3.message();
            this.handshake = r3.handshake();
            this.headers = r3.headers().newBuilder();
            this.body = r3.body();
            this.networkResponse = r3.networkResponse();
            this.cacheResponse = r3.cacheResponse();
            this.priorResponse = r3.priorResponse();
            this.sentRequestAtMillis = r3.sentRequestAtMillis();
            this.receivedResponseAtMillis = r3.receivedResponseAtMillis();
            this.exchange = r3.exchange();
        }
    }

    public Response(@NotNull Request r7, @NotNull Protocol r8, @NotNull String r9, int r10, @Nullable Handshake r11, @NotNull Headers r12, @Nullable ResponseBody r13, @Nullable Response r14, @Nullable Response r15, @Nullable Response r16, long r17, long r19, @Nullable Exchange r21) {
        Intrinsics.f(r7, "request");
        Intrinsics.f(r8, "protocol");
        Intrinsics.f(r9, "message");
        Intrinsics.f(r12, "headers");
        this.request = r7;
        this.protocol = r8;
        this.message = r9;
        this.code = r10;
        this.handshake = r11;
        this.headers = r12;
        this.body = r13;
        this.networkResponse = r14;
        this.cacheResponse = r15;
        this.priorResponse = r16;
        this.sentRequestAtMillis = r17;
        this.receivedResponseAtMillis = r19;
        this.exchange = r21;
    }

    public static /* synthetic */ String header$default(Response r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.header(r1, r2);
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final ResponseBody m162deprecated_body() {
        return this.body;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m163deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_cacheResponse, reason: not valid java name */
    public final Response m164deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_code, reason: not valid java name */
    public final int m165deprecated_code() {
        return this.code;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_handshake, reason: not valid java name */
    public final Handshake m166deprecated_handshake() {
        return this.handshake;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m167deprecated_headers() {
        return this.headers;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_message, reason: not valid java name */
    public final String m168deprecated_message() {
        return this.message;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_networkResponse, reason: not valid java name */
    public final Response m169deprecated_networkResponse() {
        return this.networkResponse;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_priorResponse, reason: not valid java name */
    public final Response m170deprecated_priorResponse() {
        return this.priorResponse;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_protocol, reason: not valid java name */
    public final Protocol m171deprecated_protocol() {
        return this.protocol;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_receivedResponseAtMillis, reason: not valid java name */
    public final long m172deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_request, reason: not valid java name */
    public final Request m173deprecated_request() {
        return this.request;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_sentRequestAtMillis, reason: not valid java name */
    public final long m174deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @JvmName
    @Nullable
    public final ResponseBody body() {
        return this.body;
    }

    @JvmName
    @NotNull
    public final CacheControl cacheControl() {
        CacheControl r0 = this.lazyCacheControl;
        if (r0 != null) goto L6;
        CacheControl r1 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = r1;
        return r1;
    L6:
        return r0;
    }

    @JvmName
    @Nullable
    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    @NotNull
    public final List<Challenge> challenges() {
        Headers r0 = this.headers;
        int r2 = this.code;
        if (r2 != 401) goto L5;
        String r3 = "WWW-Authenticate";
    L11:
        return HttpHeaders.parseChallenges(r0, r3);
    L5:
        if (r2 != 407) goto L7;
        r3 = "Proxy-Authenticate";
        goto L11
    L7:
        return EmptyList.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody r1 = this.body;
        if (r1 == null) goto L7;
        r1.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    @JvmName
    public final int code() {
        return this.code;
    }

    @JvmName
    @Nullable
    public final Exchange exchange() {
        return this.exchange;
    }

    @JvmName
    @Nullable
    public final Handshake handshake() {
        return this.handshake;
    }

    @JvmOverloads
    @Nullable
    public final String header(@NotNull String r3) {
        return header$default(this, r3, null, 2, null);
    }

    @JvmName
    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int r1 = this.code;
        if (r1 != 307) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 308) goto L8;
        switch(r1) {
            case 300: goto L8;
            case 301: goto L8;
            case 302: goto L8;
            case 303: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    }

    public final boolean isSuccessful() {
        int r1 = this.code;
        if (200 <= r1) goto L6;
    L8:
        return false;
    L6:
        if (299 < r1) goto L8;
        return true;
    }

    @JvmName
    @NotNull
    public final String message() {
        return this.message;
    }

    @JvmName
    @Nullable
    public final Response networkResponse() {
        return this.networkResponse;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @NotNull
    public final ResponseBody peekBody(long r5) {
        ResponseBody r0 = this.body;
        Intrinsics.c(r0);
        BufferedSource r1 = r0.source().peek();
        Buffer r2 = new Buffer();
        r1.request(r5);
        r2.write(r1, Math.min(r5, r1.getBuffer().size()));
        return ResponseBody.Companion.create(r2, this.body.contentType(), r2.size());
    }

    @JvmName
    @Nullable
    public final Response priorResponse() {
        return this.priorResponse;
    }

    @JvmName
    @NotNull
    public final Protocol protocol() {
        return this.protocol;
    }

    @JvmName
    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @JvmName
    @NotNull
    public final Request request() {
        return this.request;
    }

    @JvmName
    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @NotNull
    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    @NotNull
    public final Headers trailers() {
        Exchange r1 = this.exchange;
        if (r1 == null) goto L7;
        return r1.trailers();
    L7:
        throw new IllegalStateException("trailers not available".toString());
    }

    @JvmOverloads
    @Nullable
    public final String header(@NotNull String r2, @Nullable String r3) {
        Intrinsics.f(r2, "name");
        String r1 = this.headers.get(r2);
        if (r1 != null) goto L5;
        return r3;
    L5:
        return r1;
    }

    @NotNull
    public final List<String> headers(@NotNull String r2) {
        Intrinsics.f(r2, "name");
        return this.headers.values(r2);
    }
}
