package com.loopj.android.http;

import android.os.Looper;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpResponseException;
import java.io.IOException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "BinaryHttpRH";
    private String[] mAllowedContentTypes;

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public abstract void onFailure(int r1, Header[] r2, byte[] r3, Throwable r4);

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public abstract void onSuccess(int r1, Header[] r2, byte[] r3);

    public BinaryHttpResponseHandler() {
        this.mAllowedContentTypes = new String[]{"application/octet-stream", coil.util.Utils.MIME_TYPE_JPEG, "image/png", "image/gif"};
    }

    public BinaryHttpResponseHandler(String[] r5) {
        this.mAllowedContentTypes = new String[]{"application/octet-stream", coil.util.Utils.MIME_TYPE_JPEG, "image/png", "image/gif"};
        if (r5 == null) goto L5;
        this.mAllowedContentTypes = r5;
        return;
    L5:
        AsyncHttpClient.log.e(LOG_TAG, "Constructor passed allowedContentTypes was null !");
    }

    public BinaryHttpResponseHandler(String[] r4, Looper r5) {
        super(r5);
        this.mAllowedContentTypes = new String[]{"application/octet-stream", coil.util.Utils.MIME_TYPE_JPEG, "image/png", "image/gif"};
        if (r4 == null) goto L5;
        this.mAllowedContentTypes = r4;
        return;
    L5:
        AsyncHttpClient.log.e(LOG_TAG, "Constructor passed allowedContentTypes was null !");
    }

    public String[] getAllowedContentTypes() {
        return this.mAllowedContentTypes;
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler, com.loopj.android.http.ResponseHandlerInterface
    public final void sendResponseMessage(HttpResponse r14) throws IOException {
        StatusLine r0 = r14.getStatusLine();
        Header[] r1 = r14.getHeaders("Content-Type");
        if (r1.length == 1) goto L6;
        sendFailureMessage(r0.getStatusCode(), r14.getAllHeaders(), null, new HttpResponseException(r0.getStatusCode(), "None, or more than one, Content-Type Header found!"));
        return;
    L6:
        int r2 = 0;
        Header r3 = r1[0];
        String[] r5 = getAllowedContentTypes();
        int r6 = r5.length;
        boolean r7 = false;
    L7:
        if (r2 >= r6) goto L15;
        String r8 = r5[r2];
        if (Pattern.matches(r8, r3.getValue()) == false) goto L14;
        r7 = true;
    L14:
        r2 = r2 + 1;
    L12:
        e = move-exception;
        AsyncHttpClient.log.e(LOG_TAG, "Given pattern is not valid: " + r8, e);
        goto L14
    L15:
        if (r7 == true) goto L18;
        sendFailureMessage(r0.getStatusCode(), r14.getAllHeaders(), null, new HttpResponseException(r0.getStatusCode(), "Content-Type (" + r3.getValue() + ") not allowed!"));
        return;
    L18:
        super.sendResponseMessage(r14);
    }
}
