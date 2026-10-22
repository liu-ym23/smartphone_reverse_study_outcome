package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpResponseInterceptor {
    void process(HttpResponse r1, HttpContext r2) throws HttpException, IOException;
}
