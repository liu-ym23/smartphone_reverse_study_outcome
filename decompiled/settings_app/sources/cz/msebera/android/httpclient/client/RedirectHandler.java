package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface RedirectHandler {
    URI getLocationURI(HttpResponse r1, HttpContext r2) throws ProtocolException;

    boolean isRedirectRequested(HttpResponse r1, HttpContext r2);
}
