package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface RequestDirector {
    HttpResponse execute(HttpHost r1, HttpRequest r2, HttpContext r3) throws HttpException, IOException;
}
