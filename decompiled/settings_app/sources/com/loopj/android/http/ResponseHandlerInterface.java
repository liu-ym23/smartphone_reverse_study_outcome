package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import java.io.IOException;
import java.net.URI;

/* JADX INFO: loaded from: classes4.dex */
public interface ResponseHandlerInterface {
    Header[] getRequestHeaders();

    URI getRequestURI();

    Object getTag();

    boolean getUsePoolThread();

    boolean getUseSynchronousMode();

    void onPostProcessResponse(ResponseHandlerInterface r1, HttpResponse r2);

    void onPreProcessResponse(ResponseHandlerInterface r1, HttpResponse r2);

    void sendCancelMessage();

    void sendFailureMessage(int r1, Header[] r2, byte[] r3, Throwable r4);

    void sendFinishMessage();

    void sendProgressMessage(long r1, long r3);

    void sendResponseMessage(HttpResponse r1) throws IOException;

    void sendRetryMessage(int r1);

    void sendStartMessage();

    void sendSuccessMessage(int r1, Header[] r2, byte[] r3);

    void setRequestHeaders(Header[] r1);

    void setRequestURI(URI r1);

    void setTag(Object r1);

    void setUsePoolThread(boolean r1);

    void setUseSynchronousMode(boolean r1);
}
