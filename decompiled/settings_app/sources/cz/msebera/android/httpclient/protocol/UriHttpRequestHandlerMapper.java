package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class UriHttpRequestHandlerMapper implements HttpRequestHandlerMapper {
    private final UriPatternMatcher<HttpRequestHandler> matcher;

    protected UriHttpRequestHandlerMapper(UriPatternMatcher<HttpRequestHandler> r2) {
        this.matcher = (UriPatternMatcher) Args.notNull(r2, "Pattern matcher");
    }

    public UriHttpRequestHandlerMapper() {
        this(new UriPatternMatcher());
    }

    public void register(String r2, HttpRequestHandler r3) {
        Args.notNull(r2, "Pattern");
        Args.notNull(r3, "Handler");
        this.matcher.register(r2, r3);
    }

    public void unregister(String r1) {
        this.matcher.unregister(r1);
    }

    protected String getRequestPath(HttpRequest r3) {
        String r2 = r3.getRequestLine().getUri();
        int r4 = r2.indexOf(63);
        if (r4 != (-1)) goto L9;
        int r5 = r2.indexOf(35);
        if (r5 != (-1)) goto L8;
        return r2;
    L8:
        return r2.substring(0, r5);
    L9:
        return r2.substring(0, r4);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestHandlerMapper
    public HttpRequestHandler lookup(HttpRequest r2) {
        Args.notNull(r2, "HTTP request");
        return this.matcher.lookup(getRequestPath(r2));
    }
}
