package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpRequestHandler {
    void handle(HttpRequest r1, HttpResponse r2, HttpContext r3) throws HttpException, IOException;
}
