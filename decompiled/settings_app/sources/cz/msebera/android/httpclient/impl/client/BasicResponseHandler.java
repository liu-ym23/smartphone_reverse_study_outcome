package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpResponseException;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class BasicResponseHandler extends AbstractResponseHandler<String> {
    @Override // cz.msebera.android.httpclient.impl.client.AbstractResponseHandler
    public /* bridge */ /* synthetic */ String handleEntity(HttpEntity r1) throws IOException {
        return handleEntity2(r1);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractResponseHandler, cz.msebera.android.httpclient.client.ResponseHandler
    public /* bridge */ /* synthetic */ Object handleResponse(HttpResponse r1) throws HttpResponseException, IOException {
        return handleResponse(r1);
    }

    public BasicResponseHandler() {
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractResponseHandler
    /* JADX INFO: renamed from: handleEntity, reason: avoid collision after fix types in other method */
    public String handleEntity2(HttpEntity r1) throws IOException {
        return EntityUtils.toString(r1);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractResponseHandler, cz.msebera.android.httpclient.client.ResponseHandler
    public String handleResponse(HttpResponse r1) throws HttpResponseException, IOException {
        return (String) super.handleResponse(r1);
    }
}
