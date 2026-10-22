package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.RedirectException;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.net.URI;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RedirectExec implements ClientExecChain {
    public HttpClientAndroidLog log;
    private final RedirectStrategy redirectStrategy;
    private final ClientExecChain requestExecutor;
    private final HttpRoutePlanner routePlanner;

    public RedirectExec(ClientExecChain r3, HttpRoutePlanner r4, RedirectStrategy r5) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "HTTP client request executor");
        Args.notNull(r4, "HTTP route planner");
        Args.notNull(r5, "HTTP redirect strategy");
        this.requestExecutor = r3;
        this.routePlanner = r4;
        this.redirectStrategy = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [cz.msebera.android.httpclient.client.methods.HttpRequestWrapper] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r4v0, types: [cz.msebera.android.httpclient.impl.execchain.ClientExecChain] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute r10, HttpRequestWrapper r11, HttpClientContext r12, HttpExecutionAware r13) throws IOException, HttpException {
        Args.notNull(r10, "HTTP route");
        Args.notNull(r11, "HTTP request");
        Args.notNull(r12, "HTTP context");
        List<URI> r0 = r12.getRedirectLocations();
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        RequestConfig r1 = r12.getRequestConfig();
        if (r1.getMaxRedirects() <= 0) goto L8;
        int r2 = r1.getMaxRedirects();
    L9:
        int r3 = 0;
        ?? r4 = r11;
    L10:
        CloseableHttpResponse r5 = this.requestExecutor.execute(r10, r4, r12, r13);
    L43:
        e = move-exception;
        EntityUtils.consume(r5.getEntity());     // Catch: Throwable -> L46 IOException -> L48
    L45:
        r5.close();
        throw e;
    L48:
        e = move-exception;
        this.log.debug("I/O error while releasing connection", e);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        r5.close();
        throw th;
    L54:
        e = move-exception;
        r5.close();
        throw e;
    L57:
        e = move-exception;
        r5.close();
        throw e;
    L12:
        if (r1.isRedirectsEnabled() == false) goto L42;
        if (this.redirectStrategy.isRedirected(r4.getOriginal(), r5, r12) == false) goto L42;
        if (r3 >= r2) goto L41;
        r3 = r3 + 1;     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        HttpUriRequest r6 = this.redirectStrategy.getRedirect(r4.getOriginal(), r5, r12);     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        if (r6.headerIterator().hasNext() == true) goto L19;
        r6.setHeaders(r11.getOriginal().getAllHeaders());     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
    L19:
        HttpUriRequest r7 = HttpRequestWrapper.wrap(r6);     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        if ((r7 instanceof HttpEntityEnclosingRequest) == false) goto L22;
        RequestEntityProxy.enhance((HttpEntityEnclosingRequest) r7);     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
    L22:
        URI r8 = r7.getURI();     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        HttpHost r9 = URIUtils.extractHost(r8);     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        if (r9 == null) goto L39;
        if (r10.getTargetHost().equals(r9) == true) goto L34;
        AuthState r14 = r12.getTargetAuthState();     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        if (r14 == null) goto L29;
        this.log.debug("Resetting target auth state");     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        r14.reset();     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
    L29:
        AuthState r15 = r12.getProxyAuthState();     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        if (r15 == null) goto L34;
        if (r15.isConnectionBased() == false) goto L34;
        this.log.debug("Resetting proxy auth state");     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        r15.reset();     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
    L34:
        r10 = this.routePlanner.determineRoute(r9, r7, r12);     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        if (this.log.isDebugEnabled() == false) goto L37;
        this.log.debug("Redirecting to '" + r8 + "' via " + r10);     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
    L37:
        EntityUtils.consume(r5.getEntity());     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        r5.close();     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
        r4 = r7;
        goto L10
    L39:
        throw new ProtocolException("Redirect URI does not specify a valid host name: " + r8);     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
    L41:
        throw new RedirectException("Maximum redirects (" + r2 + ") exceeded");     // Catch: HttpException -> L43 IOException -> L54 RuntimeException -> L57
    L42:
        return r5;
    L8:
        r2 = 50;
        goto L9
    }
}
