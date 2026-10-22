package okhttp3.internal;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class Internal {
    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder r1, @NotNull String r2) {
        Intrinsics.f(r1, "builder");
        Intrinsics.f(r2, "line");
        return r1.addLenient$okhttp(r2);
    }

    public static final void applyConnectionSpec(@NotNull ConnectionSpec r1, @NotNull SSLSocket r2, boolean r3) {
        Intrinsics.f(r1, "connectionSpec");
        Intrinsics.f(r2, "sslSocket");
        r1.apply$okhttp(r2, r3);
    }

    @Nullable
    public static final Response cacheGet(@NotNull Cache r1, @NotNull Request r2) {
        Intrinsics.f(r1, "cache");
        Intrinsics.f(r2, "request");
        return r1.get$okhttp(r2);
    }

    @NotNull
    public static final String cookieToString(@NotNull Cookie r1, boolean r2) {
        Intrinsics.f(r1, BaseHttpRequestInfo.KEY_COOKIE);
        return r1.toString$okhttp(r2);
    }

    @Nullable
    public static final Cookie parseCookie(long r1, @NotNull HttpUrl r3, @NotNull String r4) {
        Intrinsics.f(r3, "url");
        Intrinsics.f(r4, "setCookie");
        return Cookie.Companion.parse$okhttp(r1, r3, r4);
    }

    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder r1, @NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r1, "builder");
        Intrinsics.f(r2, "name");
        Intrinsics.f(r3, "value");
        return r1.addLenient$okhttp(r2, r3);
    }
}
