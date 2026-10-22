package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SaxAsyncHttpResponseHandler<T extends DefaultHandler> extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "SaxAsyncHttpRH";
    private T handler;

    public abstract void onFailure(int r1, Header[] r2, T r3);

    public abstract void onSuccess(int r1, Header[] r2, T r3);

    public SaxAsyncHttpResponseHandler(T r2) {
        this.handler = null;
        if (r2 == null) goto L7;
        this.handler = r2;
        return;
    L7:
        throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    protected byte[] getResponseData(HttpEntity r6) throws IOException {
        InputStreamReader r2 = null;
        if (r6 == null) goto L35;
        InputStream r7 = r6.getContent();
        if (r7 == null) goto L35;
        XMLReader r3 = SAXParserFactory.newInstance().newSAXParser().getXMLReader();     // Catch: Throwable -> L15 ParserConfigurationException -> L17 SAXException -> L23
        r3.setContentHandler(this.handler);     // Catch: Throwable -> L15 ParserConfigurationException -> L17 SAXException -> L23
        InputStreamReader r4 = new InputStreamReader(r7, getCharset());     // Catch: Throwable -> L15 ParserConfigurationException -> L17 SAXException -> L23
        r3.parse(new InputSource(r4));     // Catch: ParserConfigurationException -> L11 SAXException -> L13 Throwable -> L29
        AsyncHttpClient.silentCloseInputStream(r7);
    L40:
        r4.close();     // Catch: IOException -> L37
        goto L35
    L11:
        e = e;
    L19:
        AsyncHttpClient.log.e(LOG_TAG, "getResponseData exception", e);     // Catch: Throwable -> L29
        AsyncHttpClient.silentCloseInputStream(r7);
        if (r4 == null) goto L35;
    L13:
        e = e;
    L25:
        AsyncHttpClient.log.e(LOG_TAG, "getResponseData exception", e);     // Catch: Throwable -> L29
        AsyncHttpClient.silentCloseInputStream(r7);
        if (r4 == null) goto L35;
    L17:
        e = e;
        r4 = null;
    L23:
        e = e;
        r4 = null;
    L15:
        th = th;
    L31:
        AsyncHttpClient.silentCloseInputStream(r7);
        if (r2 != null) goto L41;
    L34:
        throw th;
    L41:
        r2.close();     // Catch: IOException -> L36
    L29:
        th = th;
        r2 = r4;
    L35:
        return null;
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onSuccess(int r1, Header[] r2, byte[] r3) {
        onSuccess(r1, r2, this.handler);
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onFailure(int r1, Header[] r2, byte[] r3, Throwable r4) {
        onFailure(r1, r2, this.handler);
    }
}
