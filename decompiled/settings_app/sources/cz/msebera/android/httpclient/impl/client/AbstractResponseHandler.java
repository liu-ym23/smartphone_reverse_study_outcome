package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpResponseException;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractResponseHandler<T> implements ResponseHandler<T> {
    public abstract T handleEntity(HttpEntity r1) throws IOException;

    public AbstractResponseHandler() {
    }

    @Override // cz.msebera.android.httpclient.client.ResponseHandler
    public T handleResponse(HttpResponse r4) throws HttpResponseException, IOException {
        StatusLine r0 = r4.getStatusLine();
        HttpEntity r5 = r4.getEntity();
        if (r0.getStatusCode() >= 300) goto L8;
        if (r5 != null) goto L7;
        return null;
    L7:
        return handleEntity(r5);
    L8:
        EntityUtils.consume(r5);
        throw new HttpResponseException(r0.getStatusCode(), r0.getReasonPhrase());
    }
}
