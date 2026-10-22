package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
class HttpResponseProxy implements CloseableHttpResponse {
    private final ConnectionHolder connHolder;
    private final HttpResponse original;

    public HttpResponseProxy(HttpResponse r1, ConnectionHolder r2) {
        this.original = r1;
        this.connHolder = r2;
        ResponseEntityProxy.enchance(r1, r2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ConnectionHolder r0 = this.connHolder;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public StatusLine getStatusLine() {
        return this.original.getStatusLine();
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(StatusLine r1) {
        this.original.setStatusLine(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(ProtocolVersion r1, int r2) {
        this.original.setStatusLine(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(ProtocolVersion r1, int r2, String r3) {
        this.original.setStatusLine(r1, r2, r3);
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusCode(int r1) throws IllegalStateException {
        this.original.setStatusCode(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setReasonPhrase(String r1) throws IllegalStateException {
        this.original.setReasonPhrase(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public HttpEntity getEntity() {
        return this.original.getEntity();
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setEntity(HttpEntity r1) {
        this.original.setEntity(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public Locale getLocale() {
        return this.original.getLocale();
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setLocale(Locale r1) {
        this.original.setLocale(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return this.original.getProtocolVersion();
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public boolean containsHeader(String r1) {
        return this.original.containsHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public Header[] getHeaders(String r1) {
        return this.original.getHeaders(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public Header getFirstHeader(String r1) {
        return this.original.getFirstHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public Header getLastHeader(String r1) {
        return this.original.getLastHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public Header[] getAllHeaders() {
        return this.original.getAllHeaders();
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void addHeader(Header r1) {
        this.original.addHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void addHeader(String r1, String r2) {
        this.original.addHeader(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void setHeader(Header r1) {
        this.original.setHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void setHeader(String r1, String r2) {
        this.original.setHeader(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void setHeaders(Header[] r1) {
        this.original.setHeaders(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void removeHeader(Header r1) {
        this.original.removeHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void removeHeaders(String r1) {
        this.original.removeHeaders(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public HeaderIterator headerIterator() {
        return this.original.headerIterator();
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public HeaderIterator headerIterator(String r1) {
        return this.original.headerIterator(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public HttpParams getParams() {
        return this.original.getParams();
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void setParams(HttpParams r1) {
        this.original.setParams(r1);
    }

    public String toString() {
        return "HttpResponseProxy{" + this.original + '}';
    }
}
