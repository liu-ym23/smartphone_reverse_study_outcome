package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes5.dex */
public final class Response implements Closeable {

    @Nullable
    final ResponseBody body;

    @Nullable
    private volatile CacheControl cacheControl;

    @Nullable
    final Response cacheResponse;
    final int code;

    @Nullable
    final Handshake handshake;
    final Headers headers;
    final String message;

    @Nullable
    final Response networkResponse;

    @Nullable
    final Response priorResponse;
    final Protocol protocol;
    final long receivedResponseAtMillis;
    final Request request;
    final long sentRequestAtMillis;

    public static class Builder {

        @Nullable
        ResponseBody body;

        @Nullable
        Response cacheResponse;
        int code;

        @Nullable
        Handshake handshake;
        Headers.Builder headers;
        String message;

        @Nullable
        Response networkResponse;

        @Nullable
        Response priorResponse;

        @Nullable
        Protocol protocol;
        long receivedResponseAtMillis;

        @Nullable
        Request request;
        long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        Builder(Response r3) {
            this.code = -1;
            this.request = r3.request;
            this.protocol = r3.protocol;
            this.code = r3.code;
            this.message = r3.message;
            this.handshake = r3.handshake;
            this.headers = r3.headers.newBuilder();
            this.body = r3.body;
            this.networkResponse = r3.networkResponse;
            this.cacheResponse = r3.cacheResponse;
            this.priorResponse = r3.priorResponse;
            this.sentRequestAtMillis = r3.sentRequestAtMillis;
            this.receivedResponseAtMillis = r3.receivedResponseAtMillis;
        }

        public Builder request(Request r1) {
            this.request = r1;
            return this;
        }

        public Builder protocol(Protocol r1) {
            this.protocol = r1;
            return this;
        }

        public Builder code(int r1) {
            this.code = r1;
            return this;
        }

        public Builder message(String r1) {
            this.message = r1;
            return this;
        }

        public Builder handshake(@Nullable Handshake r1) {
            this.handshake = r1;
            return this;
        }

        public Builder header(String r2, String r3) {
            this.headers.set(r2, r3);
            return this;
        }

        public Builder addHeader(String r2, String r3) {
            this.headers.add(r2, r3);
            return this;
        }

        public Builder removeHeader(String r2) {
            this.headers.removeAll(r2);
            return this;
        }

        public Builder headers(Headers r1) {
            this.headers = r1.newBuilder();
            return this;
        }

        public Builder body(@Nullable ResponseBody r1) {
            this.body = r1;
            return this;
        }

        public Builder networkResponse(@Nullable Response r2) {
            if (r2 == null) goto L4;
            checkSupportResponse("networkResponse", r2);
        L4:
            this.networkResponse = r2;
            return this;
        }

        public Builder cacheResponse(@Nullable Response r2) {
            if (r2 == null) goto L4;
            checkSupportResponse("cacheResponse", r2);
        L4:
            this.cacheResponse = r2;
            return this;
        }

        private void checkSupportResponse(String r1, Response r2) {
            if (r2.body != null) goto L18;
            if (r2.networkResponse != null) goto L16;
            if (r2.cacheResponse != null) goto L14;
            if (r2.priorResponse != null) goto L12;
            return;
        L12:
            throw new IllegalArgumentException(r1 + ".priorResponse != null");
        L14:
            throw new IllegalArgumentException(r1 + ".cacheResponse != null");
        L16:
            throw new IllegalArgumentException(r1 + ".networkResponse != null");
        L18:
            throw new IllegalArgumentException(r1 + ".body != null");
        }

        public Builder priorResponse(@Nullable Response r1) {
            if (r1 == null) goto L4;
            checkPriorResponse(r1);
        L4:
            this.priorResponse = r1;
            return this;
        }

        private void checkPriorResponse(Response r1) {
            if (r1.body != null) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        public Builder sentRequestAtMillis(long r1) {
            this.sentRequestAtMillis = r1;
            return this;
        }

        public Builder receivedResponseAtMillis(long r1) {
            this.receivedResponseAtMillis = r1;
            return this;
        }

        public Response build() {
            if (this.request == null) goto L19;
            if (this.protocol == null) goto L17;
            if (this.code < 0) goto L15;
            if (this.message == null) goto L13;
            return new Response(this);
        L13:
            throw new IllegalStateException("message == null");
        L15:
            throw new IllegalStateException("code < 0: " + this.code);
        L17:
            throw new IllegalStateException("protocol == null");
        L19:
            throw new IllegalStateException("request == null");
        }
    }

    Response(Builder r3) {
        this.request = r3.request;
        this.protocol = r3.protocol;
        this.code = r3.code;
        this.message = r3.message;
        this.handshake = r3.handshake;
        this.headers = r3.headers.build();
        this.body = r3.body;
        this.networkResponse = r3.networkResponse;
        this.cacheResponse = r3.cacheResponse;
        this.priorResponse = r3.priorResponse;
        this.sentRequestAtMillis = r3.sentRequestAtMillis;
        this.receivedResponseAtMillis = r3.receivedResponseAtMillis;
    }

    public Request request() {
        return this.request;
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public int code() {
        return this.code;
    }

    public boolean isSuccessful() {
        int r1 = this.code;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public Handshake handshake() {
        return this.handshake;
    }

    public List<String> headers(String r1) {
        return this.headers.values(r1);
    }

    @Nullable
    public String header(String r2) {
        return header(r2, null);
    }

    @Nullable
    public String header(String r1, @Nullable String r2) {
        String r0 = this.headers.get(r1);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0;
    }

    public Headers headers() {
        return this.headers;
    }

    public ResponseBody peekBody(long r4) throws IOException {
        BufferedSource r0 = this.body.source();
        r0.request(r4);
        Buffer r1 = r0.buffer().m2340clone();
        if (r1.size() <= r4) goto L6;
        Buffer r2 = new Buffer();
        r2.write(r1, r4);
        r1.clear();
        r1 = r2;
    L6:
        return ResponseBody.create(this.body.contentType(), r1.size(), r1);
    }

    @Nullable
    public ResponseBody body() {
        return this.body;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public boolean isRedirect() {
        int r1 = this.code;
        if (r1 != 307) goto L5;
        return true;
    L5:
        if (r1 == 308) goto L11;
        switch(r1) {
            case 300: goto L12;
            case 301: goto L12;
            case 302: goto L12;
            case 303: goto L12;
            default: goto L7;
        };
    L7:
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    @Nullable
    public Response networkResponse() {
        return this.networkResponse;
    }

    @Nullable
    public Response cacheResponse() {
        return this.cacheResponse;
    }

    @Nullable
    public Response priorResponse() {
        return this.priorResponse;
    }

    public List<Challenge> challenges() {
        int r0 = this.code;
        if (r0 != 401) goto L6;
        String r1 = "WWW-Authenticate";
    L9:
        return HttpHeaders.parseChallenges(headers(), r1);
    L6:
        if (r0 != 407) goto L11;
        r1 = "Proxy-Authenticate";
        goto L9
    L11:
        return Collections.emptyList();
    }

    public CacheControl cacheControl() {
        CacheControl r0 = this.cacheControl;
        if (r0 != null) goto L7;
        CacheControl r1 = CacheControl.parse(this.headers);
        this.cacheControl = r1;
        return r1;
    L7:
        return r0;
    }

    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody r1 = this.body;
        if (r1 == null) goto L7;
        r1.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }
}
