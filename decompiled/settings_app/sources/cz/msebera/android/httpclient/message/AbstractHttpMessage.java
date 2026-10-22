package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractHttpMessage implements HttpMessage {
    protected HeaderGroup headergroup;

    @Deprecated
    protected HttpParams params;

    @Deprecated
    protected AbstractHttpMessage(HttpParams r2) {
        this.headergroup = new HeaderGroup();
        this.params = r2;
    }

    protected AbstractHttpMessage() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public boolean containsHeader(String r1) {
        return this.headergroup.containsHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public Header[] getHeaders(String r1) {
        return this.headergroup.getHeaders(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public Header getFirstHeader(String r1) {
        return this.headergroup.getFirstHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public Header getLastHeader(String r1) {
        return this.headergroup.getLastHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public Header[] getAllHeaders() {
        return this.headergroup.getAllHeaders();
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void addHeader(Header r1) {
        this.headergroup.addHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void addHeader(String r2, String r3) {
        Args.notNull(r2, "Header name");
        this.headergroup.addHeader(new BasicHeader(r2, r3));
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void setHeader(Header r1) {
        this.headergroup.updateHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void setHeader(String r2, String r3) {
        Args.notNull(r2, "Header name");
        this.headergroup.updateHeader(new BasicHeader(r2, r3));
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void setHeaders(Header[] r1) {
        this.headergroup.setHeaders(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void removeHeader(Header r1) {
        this.headergroup.removeHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public void removeHeaders(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        HeaderIterator r1 = this.headergroup.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        if (r2.equalsIgnoreCase(r1.nextHeader().getName()) == false) goto L6;
        r1.remove();
        goto L6
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public HeaderIterator headerIterator() {
        return this.headergroup.iterator();
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public HeaderIterator headerIterator(String r1) {
        return this.headergroup.iterator(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    @Deprecated
    public HttpParams getParams() {
        if (this.params != null) goto L6;
        this.params = new BasicHttpParams();
    L6:
        return this.params;
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    @Deprecated
    public void setParams(HttpParams r2) {
        this.params = (HttpParams) Args.notNull(r2, "HTTP parameters");
    }
}
