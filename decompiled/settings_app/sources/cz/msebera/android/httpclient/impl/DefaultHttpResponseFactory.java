package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.ReasonPhraseCatalog;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import cz.msebera.android.httpclient.message.BasicStatusLine;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseFactory implements HttpResponseFactory {
    public static final DefaultHttpResponseFactory INSTANCE = null;
    protected final ReasonPhraseCatalog reasonCatalog;

    static {
        INSTANCE = new DefaultHttpResponseFactory();
    }

    public DefaultHttpResponseFactory(ReasonPhraseCatalog r2) {
        this.reasonCatalog = (ReasonPhraseCatalog) Args.notNull(r2, "Reason phrase catalog");
    }

    public DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
    }

    @Override // cz.msebera.android.httpclient.HttpResponseFactory
    public HttpResponse newHttpResponse(ProtocolVersion r3, int r4, HttpContext r5) {
        Args.notNull(r3, "HTTP version");
        Locale r6 = determineLocale(r5);
        return new BasicHttpResponse(new BasicStatusLine(r3, r4, this.reasonCatalog.getReason(r4, r6)), this.reasonCatalog, r6);
    }

    @Override // cz.msebera.android.httpclient.HttpResponseFactory
    public HttpResponse newHttpResponse(StatusLine r3, HttpContext r4) {
        Args.notNull(r3, "Status line");
        return new BasicHttpResponse(r3, this.reasonCatalog, determineLocale(r4));
    }

    protected Locale determineLocale(HttpContext r1) {
        return Locale.getDefault();
    }
}
