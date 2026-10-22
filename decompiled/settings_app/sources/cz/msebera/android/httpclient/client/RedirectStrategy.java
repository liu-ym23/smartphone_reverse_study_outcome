package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface RedirectStrategy {
    HttpUriRequest getRedirect(HttpRequest r1, HttpResponse r2, HttpContext r3) throws ProtocolException;

    boolean isRedirected(HttpRequest r1, HttpResponse r2, HttpContext r3) throws ProtocolException;
}
