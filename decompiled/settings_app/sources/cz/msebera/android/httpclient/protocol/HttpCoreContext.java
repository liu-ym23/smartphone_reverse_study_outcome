package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class HttpCoreContext implements HttpContext {
    public static final String HTTP_CONNECTION = "http.connection";
    public static final String HTTP_REQUEST = "http.request";
    public static final String HTTP_REQ_SENT = "http.request_sent";
    public static final String HTTP_RESPONSE = "http.response";
    public static final String HTTP_TARGET_HOST = "http.target_host";
    private final HttpContext context;

    public static HttpCoreContext create() {
        return new HttpCoreContext(new BasicHttpContext());
    }

    public static HttpCoreContext adapt(HttpContext r1) {
        Args.notNull(r1, "HTTP context");
        if ((r1 instanceof HttpCoreContext) == false) goto L6;
        return (HttpCoreContext) r1;
    L6:
        return new HttpCoreContext(r1);
    }

    public HttpCoreContext(HttpContext r1) {
        this.context = r1;
    }

    public HttpCoreContext() {
        this.context = new BasicHttpContext();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String r1) {
        return this.context.getAttribute(r1);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String r1, Object r2) {
        this.context.setAttribute(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String r1) {
        return this.context.removeAttribute(r1);
    }

    public <T> T getAttribute(String r2, Class<T> r3) {
        Args.notNull(r3, "Attribute class");
        Object r1 = getAttribute(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r3.cast(r1);
    }

    public <T extends HttpConnection> T getConnection(Class<T> r2) {
        return (T) getAttribute("http.connection", r2);
    }

    public HttpConnection getConnection() {
        return (HttpConnection) getAttribute("http.connection", HttpConnection.class);
    }

    public HttpRequest getRequest() {
        return (HttpRequest) getAttribute("http.request", HttpRequest.class);
    }

    public boolean isRequestSent() {
        Boolean r2 = (Boolean) getAttribute("http.request_sent", Boolean.class);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public HttpResponse getResponse() {
        return (HttpResponse) getAttribute("http.response", HttpResponse.class);
    }

    public void setTargetHost(HttpHost r2) {
        setAttribute("http.target_host", r2);
    }

    public HttpHost getTargetHost() {
        return (HttpHost) getAttribute("http.target_host", HttpHost.class);
    }
}
