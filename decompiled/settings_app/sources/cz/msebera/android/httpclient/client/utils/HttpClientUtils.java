package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class HttpClientUtils {
    private HttpClientUtils() {
    }

    public static void closeQuietly(HttpResponse r0) {
        if (r0 == null) goto L10;
        HttpEntity r1 = r0.getEntity();
        if (r1 == null) goto L11;
        EntityUtils.consume(r1);     // Catch: IOException -> L7
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void closeQuietly(CloseableHttpResponse r1) {
        if (r1 != null) goto L11;
        return;
    L11:
        EntityUtils.consume(r1.getEntity());     // Catch: Throwable -> L5
        r1.close();     // Catch: IOException -> L9
        return;
    L5:
        th = move-exception;
        r1.close();     // Catch: IOException -> L9
        throw th;     // Catch: IOException -> L9
    }

    public static void closeQuietly(HttpClient r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if ((r1 instanceof Closeable) == false) goto L11;
        ((Closeable) r1).close();     // Catch: IOException -> L7
        return;
    L12:
        return;
    }
}
