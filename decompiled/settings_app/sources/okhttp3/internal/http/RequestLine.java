package okhttp3.internal.http;

import com.obric.capabilitykit.common.Ext;
import cz.msebera.android.httpclient.message.TokenParser;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* JADX INFO: compiled from: RequestLine.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http/RequestLine;", "", "()V", "get", "", Ext.KEY_REQUEST, "Lokhttp3/Request;", "proxyType", "Ljava/net/Proxy$Type;", "includeAuthorityInRequestLine", "", "requestPath", "url", "Lokhttp3/HttpUrl;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestLine {
    public static final RequestLine INSTANCE = null;

    static {
        INSTANCE = new RequestLine();
    }

    private RequestLine() {
    }

    public final String get(Request r2, Proxy.Type r3) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r3, "proxyType");
        StringBuilder r1 = new StringBuilder();
        r1.append(r2.method());
        r1.append(TokenParser.SP);
        RequestLine r0 = INSTANCE;
        if (r0.includeAuthorityInRequestLine(r2, r3) == false) goto L5;
        r1.append(r2.url());
    L6:
        r1.append(" HTTP/1.1");
        String r4 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    L5:
        r1.append(r0.requestPath(r2.url()));
        goto L6
    }

    private final boolean includeAuthorityInRequestLine(Request r1, Proxy.Type r2) {
        if (r1.isHttps() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2 != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public final String requestPath(HttpUrl r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        String r1 = r2.encodedPath();
        String r3 = r2.encodedQuery();
        if (r3 != null) goto L5;
        return r1;
    L5:
        return r1 + '?' + r3;
    }
}
