package okhttp3.internal;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.obric.capabilitykit.common.Ext;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: internal.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e\u001a \u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004¨\u0006\u001f"}, d2 = {"addHeaderLenient", "Lokhttp3/Headers$Builder;", "builder", "line", "", "name", "value", "applyConnectionSpec", "", "connectionSpec", "Lokhttp3/ConnectionSpec;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "", "cacheGet", "Lokhttp3/Response;", "cache", "Lokhttp3/Cache;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "cookieToString", BaseHttpRequestInfo.KEY_COOKIE, "Lokhttp3/Cookie;", "forObsoleteRfc2965", "parseCookie", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class Internal {
    public static final Cookie parseCookie(long r1, HttpUrl r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "setCookie");
        return Cookie.Companion.parse$okhttp(r1, r3, r4);
    }

    public static final String cookieToString(Cookie r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, BaseHttpRequestInfo.KEY_COOKIE);
        return r1.toString$okhttp(r2);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "builder");
        Intrinsics.checkNotNullParameter(r2, "line");
        return r1.addLenient$okhttp(r2);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "builder");
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "value");
        return r1.addLenient$okhttp(r2, r3);
    }

    public static final Response cacheGet(Cache r1, Request r2) {
        Intrinsics.checkNotNullParameter(r1, "cache");
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return r1.get$okhttp(r2);
    }

    public static final void applyConnectionSpec(ConnectionSpec r1, SSLSocket r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "connectionSpec");
        Intrinsics.checkNotNullParameter(r2, "sslSocket");
        r1.apply$okhttp(r2, r3);
    }
}
