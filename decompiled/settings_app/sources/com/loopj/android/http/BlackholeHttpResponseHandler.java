package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;

/* JADX INFO: loaded from: classes4.dex */
public class BlackholeHttpResponseHandler extends AsyncHttpResponseHandler {
    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onCancel() {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onFailure(int r1, Header[] r2, byte[] r3, Throwable r4) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onFinish() {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler, com.loopj.android.http.ResponseHandlerInterface
    public void onPostProcessResponse(ResponseHandlerInterface r1, HttpResponse r2) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler, com.loopj.android.http.ResponseHandlerInterface
    public void onPreProcessResponse(ResponseHandlerInterface r1, HttpResponse r2) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onProgress(long r1, long r3) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onRetry(int r1) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onStart() {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onSuccess(int r1, Header[] r2, byte[] r3) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onUserException(Throwable r1) {
    }

    public BlackholeHttpResponseHandler() {
    }
}
