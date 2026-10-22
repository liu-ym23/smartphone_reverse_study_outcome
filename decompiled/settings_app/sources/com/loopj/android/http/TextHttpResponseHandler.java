package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TextHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "TextHttpRH";

    public abstract void onFailure(int r1, Header[] r2, String r3, Throwable r4);

    public abstract void onSuccess(int r1, Header[] r2, String r3);

    public TextHttpResponseHandler() {
        this("UTF-8");
    }

    public TextHttpResponseHandler(String r1) {
        setCharset(r1);
    }

    public static String getResponseString(byte[] r3, String r4) {
        if (r3 != null) goto L15;
        String r1 = null;
    L6:
        if (r1 != null) goto L8;
    L11:
        return r1;
    L8:
        if (r1.startsWith(AsyncHttpResponseHandler.UTF8_BOM) == false) goto L11;
        return r1.substring(1);
    L12:
        e = move-exception;
        AsyncHttpClient.log.e(LOG_TAG, "Encoding response into string failed", e);
        return null;
    L15:
        r1 = new String(r3, r4);     // Catch: UnsupportedEncodingException -> L12
        goto L6
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onSuccess(int r2, Header[] r3, byte[] r4) {
        onSuccess(r2, r3, getResponseString(r4, getCharset()));
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onFailure(int r2, Header[] r3, byte[] r4, Throwable r5) {
        onFailure(r2, r3, getResponseString(r4, getCharset()), r5);
    }
}
