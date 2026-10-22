package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.tracing.internal.TracingConstants;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.capabilitykit.common.Ext;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001*BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0010\rJ\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u001fJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b!J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u0004\u0018\u00010\u0001J#\u0010$\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u0002H%0\f¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0005H\u0016J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b)R\u0015\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0017R$\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001a¨\u0006+"}, d2 = {"Lokhttp3/Request;", "", "url", "Lokhttp3/HttpUrl;", "method", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", TracingConstants.KEY_TAGS, "", "Ljava/lang/Class;", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "()Lokhttp3/RequestBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Headers;", "isHttps", "", "()Z", "lazyCacheControl", "()Ljava/lang/String;", "getTags$okhttp", "()Ljava/util/Map;", "()Lokhttp3/HttpUrl;", "-deprecated_body", "-deprecated_cacheControl", "header", "name", "-deprecated_headers", "", "-deprecated_method", "newBuilder", "Lokhttp3/Request$Builder;", "tag", ExifInterface.GPS_DIRECTION_TRUE, "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "-deprecated_url", "Builder", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    /* JADX INFO: compiled from: Request.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H\u0016J\u0014\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010,\u001a\u00020\u0000H\u0016J\b\u0010-\u001a\u00020\u0000H\u0016J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020/H\u0016J\u001a\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00101\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0013H\u0016J-\u00104\u001a\u00020\u0000\"\u0004\b\u0000\u001052\u000e\u00106\u001a\n\u0012\u0006\b\u0000\u0012\u0002H50\u001a2\b\u00104\u001a\u0004\u0018\u0001H5H\u0016¢\u0006\u0002\u00107J\u0012\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u000208H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a\u0012\u0004\u0012\u00020\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00069"}, d2 = {"Lokhttp3/Request$Builder;", "", "()V", Ext.KEY_REQUEST, "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "body", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "method", "", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", TracingConstants.KEY_TAGS, "", "Ljava/lang/Class;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "url", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "addHeader", "name", "value", IndexDatabaseHelper.MetaColumns.BUILD, "cacheControl", "Lokhttp3/CacheControl;", "delete", "get", "head", "header", "Lokhttp3/Headers;", CloudControlInf.PATCH, CozeCloudExt.API_KEY_HTTP_POST_METHOD, "put", "removeHeader", "tag", ExifInterface.GPS_DIRECTION_TRUE, "type", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private HttpUrl url;

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public final void setUrl$okhttp(HttpUrl r1) {
            this.url = r1;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final void setMethod$okhttp(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.method = r2;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final void setHeaders$okhttp(Headers.Builder r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.headers = r2;
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final void setBody$okhttp(RequestBody r1) {
            this.body = r1;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.tags = r2;
        }

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder(Request r2) {
            Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
            this.tags = new LinkedHashMap();
            this.url = r2.url();
            this.method = r2.method();
            this.body = r2.body();
            if (r2.getTags$okhttp().isEmpty() == false) goto L5;
            LinkedHashMap r0 = new LinkedHashMap();
        L6:
            this.tags = r0;
            this.headers = r2.headers().newBuilder();
            return;
        L5:
            r0 = MapsKt.toMutableMap(r2.getTags$okhttp());
            goto L6
        }

        public Builder url(HttpUrl r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            setUrl$okhttp(r2);
            return this;
        }

        public Builder url(String r4) {
            Intrinsics.checkNotNullParameter(r4, "url");
            if (StringsKt.startsWith(r4, "ws:", true) == false) goto L6;
            String r5 = r4.substring(3);
            Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).substring(startIndex)");
            r4 = Intrinsics.stringPlus("http:", r5);
        L9:
            return url(HttpUrl.Companion.get(r4));
        L6:
            if (StringsKt.startsWith(r4, "wss:", true) == false) goto L9;
            String r6 = r4.substring(4);
            Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).substring(startIndex)");
            r4 = Intrinsics.stringPlus("https:", r6);
            goto L9
        }

        public Builder url(URL r3) {
            Intrinsics.checkNotNullParameter(r3, "url");
            HttpUrl.Companion r0 = HttpUrl.Companion;
            String r4 = r3.toString();
            Intrinsics.checkNotNullExpressionValue(r4, "url.toString()");
            return url(r0.get(r4));
        }

        public Builder header(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            getHeaders$okhttp().set(r2, r3);
            return this;
        }

        public Builder addHeader(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            getHeaders$okhttp().add(r2, r3);
            return this;
        }

        public Builder removeHeader(String r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
            getHeaders$okhttp().removeAll(r2);
            return this;
        }

        public Builder headers(Headers r2) {
            Intrinsics.checkNotNullParameter(r2, "headers");
            setHeaders$okhttp(r2.newBuilder());
            return this;
        }

        public Builder cacheControl(CacheControl r3) {
            Intrinsics.checkNotNullParameter(r3, "cacheControl");
            String r4 = r3.toString();
            if (r4.length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L10;
            return removeHeader("Cache-Control");
        L10:
            return header("Cache-Control", r4);
        L5:
            r0 = false;
            goto L7
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder post(RequestBody r2) {
            Intrinsics.checkNotNullParameter(r2, "body");
            return method("POST", r2);
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

        public Builder delete(RequestBody r2) {
            return method("DELETE", r2);
        }

        public Builder put(RequestBody r2) {
            Intrinsics.checkNotNullParameter(r2, "body");
            return method("PUT", r2);
        }

        public Builder patch(RequestBody r2) {
            Intrinsics.checkNotNullParameter(r2, "body");
            return method("PATCH", r2);
        }

        public Builder method(String r4, RequestBody r5) {
            Intrinsics.checkNotNullParameter(r4, "method");
            if (r4.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L21;
            if (r5 != null) goto L15;
            if ((true ^ HttpMethod.requiresRequestBody(r4)) == false) goto L13;
        L16:
            setMethod$okhttp(r4);
            setBody$okhttp(r5);
            return this;
        L13:
            throw new IllegalArgumentException(("method " + r4 + " must have a request body.").toString());
        L15:
            if (HttpMethod.permitsRequestBody(r4) == true) goto L16;
            throw new IllegalArgumentException(("method " + r4 + " must not have a request body.").toString());
        L21:
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        L5:
            r0 = false;
            goto L6
        }

        public Builder tag(Object r2) {
            return tag(Object.class, r2);
        }

        public <T> Builder tag(Class<? super T> r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            if (r3 != null) goto L6;
            getTags$okhttp().remove(r2);
        L9:
            return this;
        L6:
            if (getTags$okhttp().isEmpty() == false) goto L8;
            setTags$okhttp(new LinkedHashMap());
        L8:
            Map<Class<?>, Object> r0 = getTags$okhttp();
            T r4 = r2.cast(r3);
            Intrinsics.checkNotNull(r4);
            r0.put(r2, r4);
            goto L9
        }

        public Request build() {
            HttpUrl r1 = this.url;
            if (r1 == null) goto L7;
            return new Request(r1, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
        L7:
            throw new IllegalStateException("url == null".toString());
        }
    }

    public Request(HttpUrl r2, String r3, Headers r4, RequestBody r5, Map<Class<?>, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "headers");
        Intrinsics.checkNotNullParameter(r6, TracingConstants.KEY_TAGS);
        this.url = r2;
        this.method = r3;
        this.headers = r4;
        this.body = r5;
        this.tags = r6;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final String method() {
        return this.method;
    }

    public final Headers headers() {
        return this.headers;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String header(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.headers.get(r2);
    }

    public final List<String> headers(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.headers.values(r2);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public final <T> T tag(Class<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return r2.cast(this.tags.get(r2));
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final CacheControl cacheControl() {
        CacheControl r0 = this.lazyCacheControl;
        if (r0 != null) goto L6;
        CacheControl r1 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = r1;
        return r1;
    L6:
        return r0;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m3203deprecated_url() {
        return this.url;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "method", imports = {}))
    /* JADX INFO: renamed from: -deprecated_method, reason: not valid java name */
    public final String m3202deprecated_method() {
        return this.method;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m3201deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m3199deprecated_body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m3200deprecated_cacheControl() {
        return cacheControl();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Request{method=");
        r0.append(method());
        r0.append(", url=");
        r0.append(url());
        if (headers().size() == 0) goto L16;
        r0.append(", headers=[");
        Iterator<Pair<? extends String, ? extends String>> r1 = headers().iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L14;
        Pair<? extends String, ? extends String> r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Pair<? extends String, ? extends String> r5 = r3;
        String r6 = r5.component1();
        String r7 = r5.component2();
        if (r2 <= 0) goto L13;
        r0.append(", ");
    L13:
        r0.append(r6);
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        r0.append(r7);
        r2 = r4;
        goto L6
    L14:
        r0.append(']');
    L16:
        if ((!getTags$okhttp().isEmpty()) == false) goto L18;
        r0.append(", tags=");
        r0.append(getTags$okhttp());
    L18:
        r0.append('}');
        String r8 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "StringBuilder().apply(builderAction).toString()");
        return r8;
    }
}
