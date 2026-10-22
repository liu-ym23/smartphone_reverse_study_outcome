package okhttp3.internal.http;

import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RequestLine {
    public static final RequestLine INSTANCE = null;

    static {
        INSTANCE = new RequestLine();
    }

    private RequestLine() {
    }

    private final boolean includeAuthorityInRequestLine(Request r1, Proxy.Type r2) {
        if (r1.isHttps() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2 != Proxy.Type.HTTP) goto L7;
        return true;
    }

    @NotNull
    public final String get(@NotNull Request r2, @NotNull Proxy.Type r3) {
        Intrinsics.f(r2, "request");
        Intrinsics.f(r3, "proxyType");
        StringBuilder r1 = new StringBuilder();
        r1.append(r2.method());
        r1.append(' ');
        RequestLine r0 = INSTANCE;
        if (r0.includeAuthorityInRequestLine(r2, r3) == false) goto L5;
        r1.append(r2.url());
    L6:
        r1.append(" HTTP/1.1");
        String r4 = r1.toString();
        Intrinsics.e(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    L5:
        r1.append(r0.requestPath(r2.url()));
        goto L6
    }

    @NotNull
    public final String requestPath(@NotNull HttpUrl r2) {
        Intrinsics.f(r2, "url");
        String r1 = r2.encodedPath();
        String r3 = r2.encodedQuery();
        if (r3 != null) goto L5;
        return r1;
    L5:
        return r1 + '?' + r3;
    }
}
