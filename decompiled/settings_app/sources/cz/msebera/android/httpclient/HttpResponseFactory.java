package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpResponseFactory {
    HttpResponse newHttpResponse(ProtocolVersion r1, int r2, HttpContext r3);

    HttpResponse newHttpResponse(StatusLine r1, HttpContext r2);
}
