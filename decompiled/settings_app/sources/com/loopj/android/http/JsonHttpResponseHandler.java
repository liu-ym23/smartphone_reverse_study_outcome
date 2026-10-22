package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes4.dex */
public class JsonHttpResponseHandler extends TextHttpResponseHandler {
    private static final String LOG_TAG = "JsonHttpRH";
    private boolean useRFC5179CompatibilityMode;

    static /* synthetic */ boolean access$000(JsonHttpResponseHandler r0) {
        return r0.useRFC5179CompatibilityMode;
    }

    public JsonHttpResponseHandler() {
        super("UTF-8");
        this.useRFC5179CompatibilityMode = true;
    }

    public JsonHttpResponseHandler(String r1) {
        super(r1);
        this.useRFC5179CompatibilityMode = true;
    }

    public JsonHttpResponseHandler(boolean r2) {
        super("UTF-8");
        this.useRFC5179CompatibilityMode = r2;
    }

    public JsonHttpResponseHandler(String r1, boolean r2) {
        super(r1);
        this.useRFC5179CompatibilityMode = r2;
    }

    public void onSuccess(int r1, Header[] r2, JSONObject r3) {
        AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    public void onSuccess(int r1, Header[] r2, JSONArray r3) {
        AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void onFailure(int r1, Header[] r2, Throwable r3, JSONObject r4) {
        AsyncHttpClient.log.w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", r3);
    }

    public void onFailure(int r1, Header[] r2, Throwable r3, JSONArray r4) {
        AsyncHttpClient.log.w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", r3);
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler
    public void onFailure(int r1, Header[] r2, String r3, Throwable r4) {
        AsyncHttpClient.log.w(LOG_TAG, "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", r4);
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler
    public void onSuccess(int r1, Header[] r2, String r3) {
        AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler, com.loopj.android.http.AsyncHttpResponseHandler
    public final void onSuccess(final int r2, final Header[] r3, final byte[] r4) {
        if (r2 == 204) goto L10;
        Runnable r0 = new AnonymousClass1(this, r4, r2, r3);
        if (getUseSynchronousMode() == false) goto L7;
    L9:
        r0.run();
        return;
    L7:
        if (getUsePoolThread() == true) goto L9;
        new Thread(r0).start();
        return;
    L10:
        onSuccess(r2, r3, new JSONObject());
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler, com.loopj.android.http.AsyncHttpResponseHandler
    public final void onFailure(final int r8, final Header[] r9, final byte[] r10, final Throwable r11) {
        if (r10 == null) goto L9;
        Runnable r6 = new AnonymousClass2(this, r10, r8, r9, r11);
        if (getUseSynchronousMode() == false) goto L6;
    L8:
        r6.run();
        return;
    L6:
        if (getUsePoolThread() == true) goto L8;
        new Thread(r6).start();
        return;
    L9:
        AsyncHttpClient.log.v(LOG_TAG, "response body is null, calling onFailure(Throwable, JSONObject)");
        JSONObject r0 = (JSONObject) null;
        onFailure(r8, r9, r11, null);
    }

    protected Object parseResponse(byte[] r4) throws JSONException {
        Object r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        String r5 = getResponseString(r4, getCharset());
        if (r5 == null) goto L28;
        r5 = r5.trim();
        if (this.useRFC5179CompatibilityMode == false) goto L15;
        if (r5.startsWith(VectorFormat.DEFAULT_PREFIX) == false) goto L12;
    L13:
        r0 = new JSONTokener(r5).nextValue();
        goto L28
    L12:
        if (r5.startsWith("[") == false) goto L28;
    L15:
        if (r5.startsWith(VectorFormat.DEFAULT_PREFIX) == false) goto L19;
        if (r5.endsWith(VectorFormat.DEFAULT_SUFFIX) == false) goto L19;
    L22:
        r0 = new JSONTokener(r5).nextValue();
    L19:
        if (r5.startsWith("[") == false) goto L24;
        if (r5.endsWith("]") == true) goto L22;
    L24:
        if (r5.startsWith("\"") == false) goto L28;
        if (r5.endsWith("\"") == false) goto L28;
        r0 = r5.substring(1, r5.length() - 1);
    L28:
        if (r0 != null) goto L31;
        return r5;
    L31:
        return r0;
    }

    public boolean isUseRFC5179CompatibilityMode() {
        return this.useRFC5179CompatibilityMode;
    }

    public void setUseRFC5179CompatibilityMode(boolean r1) {
        this.useRFC5179CompatibilityMode = r1;
    }
}
