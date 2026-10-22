package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.client.BasicCredentialsProvider;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes5.dex */
public class ProtocolExec implements ClientExecChain {
    private final HttpProcessor httpProcessor;
    public HttpClientAndroidLog log;
    private final ClientExecChain requestExecutor;

    public ProtocolExec(ClientExecChain r3, HttpProcessor r4) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "HTTP client request executor");
        Args.notNull(r4, "HTTP protocol processor");
        this.requestExecutor = r3;
        this.httpProcessor = r4;
    }

    void rewriteRequestURI(HttpRequestWrapper r2, HttpRoute r3, boolean r4) throws ProtocolException {
        URI r1 = r2.getURI();
        if (r1 != null) goto L10;
        return;
    L10:
        r2.setURI(URIUtils.rewriteURIForRoute(r1, r3, r4));     // Catch: URISyntaxException -> L6
        return;
    L6:
        e = move-exception;
        throw new ProtocolException("Invalid URI: " + r1, e);
    }

    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute r7, HttpRequestWrapper r8, HttpClientContext r9, HttpExecutionAware r10) throws IOException, HttpException {
        Args.notNull(r7, "HTTP route");
        Args.notNull(r8, "HTTP request");
        Args.notNull(r9, "HTTP context");
        HttpRequest r0 = r8.getOriginal();
        HttpHost r2 = null;
        if ((r0 instanceof HttpUriRequest) == false) goto L5;
        URI r1 = ((HttpUriRequest) r0).getURI();
    L13:
        r8.setURI(r1);
        rewriteRequestURI(r8, r7, r9.getRequestConfig().isNormalizeUri());
        HttpHost r3 = (HttpHost) r8.getParams().getParameter(ClientPNames.VIRTUAL_HOST);
        if (r3 != null) goto L16;
    L23:
        if (r3 == null) goto L25;
        r2 = r3;
    L31:
        if (r2 != null) goto L33;
        r2 = r8.getTarget();
    L33:
        if (r2 != null) goto L35;
        r2 = r7.getTargetHost();
    L35:
        if (r1 == null) goto L42;
        String r4 = r1.getUserInfo();
        if (r4 == null) goto L42;
        CredentialsProvider r5 = r9.getCredentialsProvider();
        if (r5 != null) goto L41;
        r5 = new BasicCredentialsProvider();
        r9.setCredentialsProvider(r5);
    L41:
        r5.setCredentials(new AuthScope(r2), new UsernamePasswordCredentials(r4));
    L42:
        r9.setAttribute("http.target_host", r2);
        r9.setAttribute("http.route", r7);
        r9.setAttribute("http.request", r8);
        this.httpProcessor.process(r8, r9);
        CloseableHttpResponse r11 = this.requestExecutor.execute(r7, r8, r9, r10);
        r9.setAttribute("http.response", r11);     // Catch: HttpException -> L45 IOException -> L48 RuntimeException -> L51
        this.httpProcessor.process(r11, r9);     // Catch: HttpException -> L45 IOException -> L48 RuntimeException -> L51
        return r11;
    L45:
        e = move-exception;
        r11.close();
        throw e;
    L48:
        e = move-exception;
        r11.close();
        throw e;
    L51:
        e = move-exception;
        r11.close();
        throw e;
    L25:
        if (r1 == null) goto L31;
        if (r1.isAbsolute() == false) goto L31;
        if (r1.getHost() == null) goto L31;
        r2 = new HttpHost(r1.getHost(), r1.getPort(), r1.getScheme());
        goto L31
    L16:
        if (r3.getPort() != (-1)) goto L23;
        int r6 = r7.getTargetHost().getPort();
        if (r6 == (-1)) goto L21;
        r3 = new HttpHost(r3.getHostName(), r6, r3.getSchemeName());
    L21:
        if (this.log.isDebugEnabled() == false) goto L23;
        this.log.debug("Using virtual host" + r3);
        goto L23
    L5:
        String r12 = r0.getRequestLine().getUri();
        r1 = URI.create(r12);     // Catch: IllegalArgumentException -> L8
    L8:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L12;
        this.log.debug("Unable to parse '" + r12 + "' as a valid URI; request URI and Host header may be inconsistent", e);
    L12:
        r1 = null;
        goto L13
    }
}
