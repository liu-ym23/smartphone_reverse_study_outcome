package cz.msebera.android.httpclient.client.protocol;

import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RequestAddCookies implements HttpRequestInterceptor {
    public HttpClientAndroidLog log;

    public RequestAddCookies() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r12, HttpContext r13) throws HttpException, IOException {
        Args.notNull(r12, "HTTP request");
        Args.notNull(r13, "HTTP context");
        if (r12.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") == false) goto L5;
        return;
    L5:
        HttpClientContext r0 = HttpClientContext.adapt(r13);
        CookieStore r1 = r0.getCookieStore();
        if (r1 != null) goto L9;
        this.log.debug("Cookie store not specified in HTTP context");
        return;
    L9:
        Lookup<CookieSpecProvider> r2 = r0.getCookieSpecRegistry();
        if (r2 != null) goto L13;
        this.log.debug("CookieSpec registry not specified in HTTP context");
        return;
    L13:
        HttpHost r3 = r0.getTargetHost();
        if (r3 != null) goto L17;
        this.log.debug("Target host not set in the context");
        return;
    L17:
        RouteInfo r4 = r0.getHttpRoute();
        if (r4 != null) goto L21;
        this.log.debug("Connection route not set in the context");
        return;
    L21:
        String r5 = r0.getRequestConfig().getCookieSpec();
        if (r5 != null) goto L25;
        r5 = "default";
    L25:
        if (this.log.isDebugEnabled() == false) goto L27;
        this.log.debug("CookieSpec selected: " + r5);
    L27:
        String r7 = null;
        if ((r12 instanceof HttpUriRequest) == false) goto L82;
        URI r6 = ((HttpUriRequest) r12).getURI();
    L33:
        if (r6 == null) goto L35;
        r7 = r6.getPath();
    L35:
        String r8 = r3.getHostName();
        int r9 = r3.getPort();
        if (r9 >= 0) goto L38;
        r9 = r4.getTargetHost().getPort();
    L38:
        boolean r10 = false;
        if (r9 >= 0) goto L43;
        r9 = 0;
    L43:
        if (TextUtils.isEmpty(r7) == false) goto L46;
        r7 = LibrarianImpl.Constants.SEPARATOR;
    L46:
        CookieOrigin r11 = new CookieOrigin(r8, r9, r7, r4.isSecure());
        CookieSpecProvider r14 = r2.lookup(r5);
        if (r14 == null) goto L49;
        CookieSpec r15 = r14.create(r0);
        List<Cookie> r16 = r1.getCookies();
        ArrayList r17 = new ArrayList();
        Date r18 = new Date();
        Iterator<Cookie> r19 = r16.iterator();
    L54:
        if (r19.hasNext() == false) goto L67;
        Cookie r20 = r19.next();
        if (r20.isExpired(r18) == false) goto L58;
        if (this.log.isDebugEnabled() == false) goto L66;
        this.log.debug("Cookie " + r20 + " expired");
    L66:
        r10 = true;
        goto L54
    L58:
        if (r15.match(r20, r11) == false) goto L54;
        if (this.log.isDebugEnabled() == false) goto L62;
        this.log.debug("Cookie " + r20 + " match " + r11);
    L62:
        r17.add(r20);
        goto L54
    L67:
        if (r10 == false) goto L70;
        r1.clearExpired(r18);
    L70:
        if (r17.isEmpty() == true) goto L76;
        Iterator<Header> r110 = r15.formatCookies(r17).iterator();
    L73:
        if (r110.hasNext() == false) goto L76;
        r12.addHeader(r110.next());
    L76:
        if (r15.getVersion() <= 0) goto L80;
        Header r111 = r15.getVersionHeader();
        if (r111 == null) goto L80;
        r12.addHeader(r111);
    L80:
        r13.setAttribute("http.cookie-spec", r15);
        r13.setAttribute("http.cookie-origin", r11);
        return;
    L49:
        if (this.log.isDebugEnabled() == false) goto L93;
        this.log.debug("Unsupported cookie policy: " + r5);
        return;
    L93:
        return;
    L82:
        r6 = new URI(r12.getRequestLine().getUri());     // Catch: URISyntaxException -> L32
    L32:
        r6 = null;
        goto L33
    }
}
