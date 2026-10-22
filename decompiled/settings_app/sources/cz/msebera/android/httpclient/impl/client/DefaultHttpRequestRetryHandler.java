package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
    public static final DefaultHttpRequestRetryHandler INSTANCE = null;
    private final Set<Class<? extends IOException>> nonRetriableClasses;
    private final boolean requestSentRetryEnabled;
    private final int retryCount;

    static {
        INSTANCE = new DefaultHttpRequestRetryHandler();
    }

    protected DefaultHttpRequestRetryHandler(int r1, boolean r2, Collection<Class<? extends IOException>> r3) {
        this.retryCount = r1;
        this.requestSentRetryEnabled = r2;
        this.nonRetriableClasses = new HashSet();
        Iterator<Class<? extends IOException>> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Class<? extends IOException> r5 = r4.next();
        this.nonRetriableClasses.add(r5);
        goto L4
    }

    public DefaultHttpRequestRetryHandler(int r4, boolean r5) {
        this(r4, r5, Arrays.asList(new Class[]{InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class}));
    }

    public DefaultHttpRequestRetryHandler() {
        this(3, false);
    }

    @Override // cz.msebera.android.httpclient.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException r3, int r4, HttpContext r5) {
        Args.notNull(r3, "Exception parameter");
        Args.notNull(r5, "HTTP context");
        if (r4 <= this.retryCount) goto L6;
        return false;
    L6:
        if (this.nonRetriableClasses.contains(r3.getClass()) == false) goto L8;
        return false;
    L8:
        Iterator<Class<? extends IOException>> r6 = this.nonRetriableClasses.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        if (r6.next().isInstance(r3) == false) goto L10;
        return false;
    L14:
        HttpClientContext r7 = HttpClientContext.adapt(r5);
        HttpRequest r8 = r7.getRequest();
        if (requestIsAborted(r8) == false) goto L18;
        return false;
    L18:
        if (handleAsIdempotent(r8) == false) goto L21;
        return true;
    L21:
        if (r7.isRequestSent() == true) goto L23;
    L26:
        return true;
    L23:
        if (this.requestSentRetryEnabled == true) goto L26;
        return false;
    }

    public boolean isRequestSentRetryEnabled() {
        return this.requestSentRetryEnabled;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    protected boolean handleAsIdempotent(HttpRequest r1) {
        return !(r1 instanceof HttpEntityEnclosingRequest);
    }

    @Deprecated
    protected boolean requestIsAborted(HttpRequest r1) {
        if ((r1 instanceof RequestWrapper) == false) goto L6;
        r1 = ((RequestWrapper) r1).getOriginal();
    L6:
        if ((r1 instanceof HttpUriRequest) == true) goto L8;
    L10:
        return false;
    L8:
        if (((HttpUriRequest) r1).isAborted() == false) goto L10;
        return true;
    }
}
