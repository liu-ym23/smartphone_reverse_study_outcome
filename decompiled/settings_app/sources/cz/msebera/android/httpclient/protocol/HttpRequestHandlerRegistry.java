package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.util.Args;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
    private final UriPatternMatcher<HttpRequestHandler> matcher;

    public HttpRequestHandlerRegistry() {
        this.matcher = new UriPatternMatcher();
    }

    public void register(String r2, HttpRequestHandler r3) {
        Args.notNull(r2, "URI request pattern");
        Args.notNull(r3, "Request handler");
        this.matcher.register(r2, r3);
    }

    public void unregister(String r1) {
        this.matcher.unregister(r1);
    }

    public void setHandlers(Map<String, HttpRequestHandler> r1) {
        this.matcher.setObjects(r1);
    }

    public Map<String, HttpRequestHandler> getHandlers() {
        return this.matcher.getObjects();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestHandlerResolver
    public HttpRequestHandler lookup(String r1) {
        return this.matcher.lookup(r1);
    }
}
