package okhttp3;

import a.a;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.tracing.internal.TracingConstants;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Request {

    @Nullable
    private final RequestBody body;

    @NotNull
    private final Headers headers;
    private CacheControl lazyCacheControl;

    @NotNull
    private final String method;

    @NotNull
    private final Map<Class<?>, Object> tags;

    @NotNull
    private final HttpUrl url;

    @Metadata
    public static class Builder {

        @Nullable
        private RequestBody body;

        @NotNull
        private Headers.Builder headers;

        @NotNull
        private String method;

        @NotNull
        private Map<Class<?>, Object> tags;

        @Nullable
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = HttpMethodContrants.GET;
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder r0, RequestBody r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L7;
            r1 = Util.EMPTY_REQUEST;
        L7:
            return r0.delete(r1);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        @NotNull
        public Builder addHeader(@NotNull String r2, @NotNull String r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            this.headers.add(r2, r3);
            return this;
        }

        @NotNull
        public Request build() {
            HttpUrl r1 = this.url;
            if (r1 == null) goto L7;
            return new Request(r1, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
        L7:
            throw new IllegalStateException("url == null".toString());
        }

        @NotNull
        public Builder cacheControl(@NotNull CacheControl r3) {
            Intrinsics.f(r3, "cacheControl");
            String r4 = r3.toString();
            if (r4.length() != 0) goto L6;
            return removeHeader("Cache-Control");
        L6:
            return header("Cache-Control", r4);
        }

        @JvmOverloads
        @NotNull
        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        @NotNull
        public Builder get() {
            return method(HttpMethodContrants.GET, null);
        }

        @Nullable
        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        @NotNull
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @NotNull
        public final String getMethod$okhttp() {
            return this.method;
        }

        @NotNull
        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        @Nullable
        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        @NotNull
        public Builder head() {
            return method(HttpMethodContrants.HEAD, null);
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

        @NotNull
        public Builder method(@NotNull String r4, @Nullable RequestBody r5) {
            Intrinsics.f(r4, "method");
            if (r4.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L21;
            if (r5 != null) goto L15;
            if ((true ^ HttpMethod.requiresRequestBody(r4)) == false) goto L13;
        L16:
            this.method = r4;
            this.body = r5;
            return this;
        L13:
            throw new IllegalArgumentException(a.k("method ", r4, " must have a request body.").toString());
        L15:
            if (HttpMethod.permitsRequestBody(r4) == true) goto L16;
            throw new IllegalArgumentException(a.k("method ", r4, " must not have a request body.").toString());
        L21:
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        L5:
            r0 = false;
            goto L6
        }

        @NotNull
        public Builder patch(@NotNull RequestBody r2) {
            Intrinsics.f(r2, "body");
            return method(HttpMethodContrants.PATCH, r2);
        }

        @NotNull
        public Builder post(@NotNull RequestBody r2) {
            Intrinsics.f(r2, "body");
            return method(HttpMethodContrants.POST, r2);
        }

        @NotNull
        public Builder put(@NotNull RequestBody r2) {
            Intrinsics.f(r2, "body");
            return method(HttpMethodContrants.PUT, r2);
        }

        @NotNull
        public Builder removeHeader(@NotNull String r2) {
            Intrinsics.f(r2, "name");
            this.headers.removeAll(r2);
            return this;
        }

        public final void setBody$okhttp(@Nullable RequestBody r1) {
            this.body = r1;
        }

        public final void setHeaders$okhttp(@NotNull Headers.Builder r2) {
            Intrinsics.f(r2, "<set-?>");
            this.headers = r2;
        }

        public final void setMethod$okhttp(@NotNull String r2) {
            Intrinsics.f(r2, "<set-?>");
            this.method = r2;
        }

        public final void setTags$okhttp(@NotNull Map<Class<?>, Object> r2) {
            Intrinsics.f(r2, "<set-?>");
            this.tags = r2;
        }

        public final void setUrl$okhttp(@Nullable HttpUrl r1) {
            this.url = r1;
        }

        @NotNull
        public Builder tag(@Nullable Object r2) {
            return tag(Object.class, r2);
        }

        @NotNull
        public Builder url(@NotNull HttpUrl r2) {
            Intrinsics.f(r2, "url");
            this.url = r2;
            return this;
        }

        @JvmOverloads
        @NotNull
        public Builder delete(@Nullable RequestBody r2) {
            return method(HttpMethodContrants.DELETE, r2);
        }

        @NotNull
        public <T> Builder tag(@NotNull Class<? super T> r2, @Nullable T r3) {
            Intrinsics.f(r2, "type");
            if (r3 != null) goto L6;
            this.tags.remove(r2);
        L9:
            return this;
        L6:
            if (this.tags.isEmpty() == false) goto L8;
            this.tags = new LinkedHashMap();
        L8:
            Map<Class<?>, Object> r0 = this.tags;
            T r4 = r2.cast(r3);
            Intrinsics.c(r4);
            r0.put(r2, r4);
            goto L9
        }

        @NotNull
        public Builder url(@NotNull String r4) {
            Intrinsics.f(r4, "url");
            if (StringsKt.F(r4, "ws:", true) == false) goto L6;
            String r5 = r4.substring(3);
            Intrinsics.e(r5, "(this as java.lang.String).substring(startIndex)");
            r4 = "http:".concat(r5);
        L9:
            return url(HttpUrl.Companion.get(r4));
        L6:
            if (StringsKt.F(r4, "wss:", true) == false) goto L9;
            String r6 = r4.substring(4);
            Intrinsics.e(r6, "(this as java.lang.String).substring(startIndex)");
            r4 = "https:".concat(r6);
            goto L9
        }

        public Builder(@NotNull Request r3) {
            Intrinsics.f(r3, "request");
            this.tags = new LinkedHashMap();
            this.url = r3.url();
            this.method = r3.method();
            this.body = r3.body();
            if (r3.getTags$okhttp().isEmpty() == false) goto L5;
            LinkedHashMap r0 = new LinkedHashMap();
        L6:
            this.tags = r0;
            this.headers = r3.headers().newBuilder();
            return;
        L5:
            Map<Class<?>, Object> r1 = r3.getTags$okhttp();
            Intrinsics.f(r1, "<this>");
            r0 = new LinkedHashMap(r1);
            goto L6
        }

        @NotNull
        public Builder url(@NotNull URL r3) {
            Intrinsics.f(r3, "url");
            HttpUrl.Companion r0 = HttpUrl.Companion;
            String r4 = r3.toString();
            Intrinsics.e(r4, "url.toString()");
            return url(r0.get(r4));
        }
    }

    public Request(@NotNull HttpUrl r2, @NotNull String r3, @NotNull Headers r4, @Nullable RequestBody r5, @NotNull Map<Class<?>, ? extends Object> r6) {
        Intrinsics.f(r2, "url");
        Intrinsics.f(r3, "method");
        Intrinsics.f(r4, "headers");
        Intrinsics.f(r6, TracingConstants.KEY_TAGS);
        this.url = r2;
        this.method = r3;
        this.headers = r4;
        this.body = r5;
        this.tags = r6;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m157deprecated_body() {
        return this.body;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m158deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m159deprecated_headers() {
        return this.headers;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_method, reason: not valid java name */
    public final String m160deprecated_method() {
        return this.method;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m161deprecated_url() {
        return this.url;
    }

    @JvmName
    @Nullable
    public final RequestBody body() {
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

    @NotNull
    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    @Nullable
    public final String header(@NotNull String r2) {
        Intrinsics.f(r2, "name");
        return this.headers.get(r2);
    }

    @JvmName
    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    @JvmName
    @NotNull
    public final String method() {
        return this.method;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public final Object tag() {
        return tag(Object.class);
    }

    @NotNull
    public String toString() {
        StringBuilder r0 = new StringBuilder("Request{method=");
        r0.append(this.method);
        r0.append(", url=");
        r0.append(this.url);
        if (this.headers.size() == 0) goto L17;
        r0.append(", headers=[");
        Iterator<Pair<? extends String, ? extends String>> r1 = this.headers.iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L15;
        Pair<? extends String, ? extends String> r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 < 0) goto L13;
        Pair<? extends String, ? extends String> r5 = r3;
        String r6 = (String) r5.b;
        String r7 = (String) r5.c;
        if (r2 <= 0) goto L12;
        r0.append(", ");
    L12:
        r0.append(r6);
        r0.append(':');
        r0.append(r7);
        r2 = r4;
        goto L6
    L13:
        CollectionsKt.p();
        throw null;
    L15:
        r0.append(']');
    L17:
        if ((!this.tags.isEmpty()) == false) goto L19;
        r0.append(", tags=");
        r0.append(this.tags);
    L19:
        r0.append('}');
        String r8 = r0.toString();
        Intrinsics.e(r8, "StringBuilder().apply(builderAction).toString()");
        return r8;
    }

    @JvmName
    @NotNull
    public final HttpUrl url() {
        return this.url;
    }

    @NotNull
    public final List<String> headers(@NotNull String r2) {
        Intrinsics.f(r2, "name");
        return this.headers.values(r2);
    }

    @Nullable
    public final <T> T tag(@NotNull Class<? extends T> r2) {
        Intrinsics.f(r2, "type");
        return r2.cast(this.tags.get(r2));
    }
}
