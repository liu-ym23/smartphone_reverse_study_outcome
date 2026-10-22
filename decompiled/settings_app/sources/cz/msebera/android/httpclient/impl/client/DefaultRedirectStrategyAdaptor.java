package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class DefaultRedirectStrategyAdaptor implements RedirectStrategy {
    private final RedirectHandler handler;

    public DefaultRedirectStrategyAdaptor(RedirectHandler r1) {
        this.handler = r1;
    }

    @Override // cz.msebera.android.httpclient.client.RedirectStrategy
    public boolean isRedirected(HttpRequest r1, HttpResponse r2, HttpContext r3) throws ProtocolException {
        return this.handler.isRedirectRequested(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.client.RedirectStrategy
    public HttpUriRequest getRedirect(HttpRequest r1, HttpResponse r2, HttpContext r3) throws ProtocolException {
        URI r0 = this.handler.getLocationURI(r2, r3);
        if (r1.getRequestLine().getMethod().equalsIgnoreCase("HEAD") == false) goto L7;
        return new HttpHead(r0);
    L7:
        return new HttpGet(r0);
    }

    public RedirectHandler getHandler() {
        return this.handler;
    }
}
