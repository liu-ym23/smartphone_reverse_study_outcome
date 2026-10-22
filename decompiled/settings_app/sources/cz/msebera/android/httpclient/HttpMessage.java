package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.params.HttpParams;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpMessage {
    void addHeader(Header r1);

    void addHeader(String r1, String r2);

    boolean containsHeader(String r1);

    Header[] getAllHeaders();

    Header getFirstHeader(String r1);

    Header[] getHeaders(String r1);

    Header getLastHeader(String r1);

    @Deprecated
    HttpParams getParams();

    ProtocolVersion getProtocolVersion();

    HeaderIterator headerIterator();

    HeaderIterator headerIterator(String r1);

    void removeHeader(Header r1);

    void removeHeaders(String r1);

    void setHeader(Header r1);

    void setHeader(String r1, String r2);

    void setHeaders(Header[] r1);

    @Deprecated
    void setParams(HttpParams r1);
}
