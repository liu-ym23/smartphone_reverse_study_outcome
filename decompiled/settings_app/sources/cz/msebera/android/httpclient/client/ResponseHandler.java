package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpResponse;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface ResponseHandler<T> {
    T handleResponse(HttpResponse r1) throws ClientProtocolException, IOException;
}
