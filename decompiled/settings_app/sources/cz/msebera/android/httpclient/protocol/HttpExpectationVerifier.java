package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpExpectationVerifier {
    void verify(HttpRequest r1, HttpResponse r2, HttpContext r3) throws HttpException;
}
