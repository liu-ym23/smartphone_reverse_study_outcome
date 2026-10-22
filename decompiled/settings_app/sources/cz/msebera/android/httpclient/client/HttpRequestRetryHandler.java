package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpRequestRetryHandler {
    boolean retryRequest(IOException r1, int r2, HttpContext r3);
}
