package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.BasicStatusLine;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
final class OptionsHttp11Response extends AbstractHttpMessage implements HttpResponse {
    private final StatusLine statusLine;
    private final ProtocolVersion version;

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public void addHeader(Header r1) {
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public void addHeader(String r1, String r2) {
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public HttpEntity getEntity() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public Locale getLocale() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public void removeHeader(Header r1) {
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public void removeHeaders(String r1) {
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setEntity(HttpEntity r1) {
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public void setHeader(Header r1) {
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public void setHeader(String r1, String r2) {
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public void setHeaders(Header[] r1) {
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setLocale(Locale r1) {
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public void setParams(HttpParams r1) {
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setReasonPhrase(String r1) throws IllegalStateException {
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusCode(int r1) throws IllegalStateException {
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(ProtocolVersion r1, int r2) {
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(ProtocolVersion r1, int r2, String r3) {
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(StatusLine r1) {
    }

    OptionsHttp11Response() {
        this.statusLine = new BasicStatusLine(HttpVersion.HTTP_1_1, 501, "");
        this.version = HttpVersion.HTTP_1_1;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public StatusLine getStatusLine() {
        return this.statusLine;
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return this.version;
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public boolean containsHeader(String r1) {
        return this.headergroup.containsHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public Header[] getHeaders(String r1) {
        return this.headergroup.getHeaders(r1);
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public Header getFirstHeader(String r1) {
        return this.headergroup.getFirstHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public Header getLastHeader(String r1) {
        return this.headergroup.getLastHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public Header[] getAllHeaders() {
        return this.headergroup.getAllHeaders();
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public HeaderIterator headerIterator() {
        return this.headergroup.iterator();
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public HeaderIterator headerIterator(String r1) {
        return this.headergroup.iterator(r1);
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    public HttpParams getParams() {
        if (this.params != null) goto L6;
        this.params = new BasicHttpParams();
    L6:
        return this.params;
    }
}
