package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseJsonHttpResponseHandler<JSON_TYPE> extends TextHttpResponseHandler {
    private static final String LOG_TAG = "BaseJsonHttpRH";

    public abstract void onFailure(int r1, Header[] r2, Throwable r3, String r4, JSON_TYPE r5);

    public abstract void onSuccess(int r1, Header[] r2, String r3, JSON_TYPE r4);

    protected abstract JSON_TYPE parseResponse(String r1, boolean r2) throws Throwable;

    public BaseJsonHttpResponseHandler() {
        this("UTF-8");
    }

    public BaseJsonHttpResponseHandler(String r1) {
        super(r1);
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler
    public final void onSuccess(final int r2, final Header[] r3, final String r4) {
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
        onSuccess(r2, r3, null, null);
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler
    public final void onFailure(final int r8, final Header[] r9, final String r10, final Throwable r11) {
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
        onFailure(r8, r9, r11, null, null);
    }
}
