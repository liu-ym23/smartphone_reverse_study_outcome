package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.Args;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes5.dex */
class Proxies {
    Proxies() {
    }

    public static CloseableHttpResponse enhanceResponse(HttpResponse r4) {
        Args.notNull(r4, "HTTP response");
        if ((r4 instanceof CloseableHttpResponse) == false) goto L7;
        return (CloseableHttpResponse) r4;
    L7:
        return (CloseableHttpResponse) Proxy.newProxyInstance(ResponseProxyHandler.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}, new ResponseProxyHandler(r4));
    }
}
