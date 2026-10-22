package cz.msebera.android.httpclient.client.cache;

/* JADX INFO: loaded from: classes5.dex */
public class HttpCacheUpdateException extends Exception {
    private static final long serialVersionUID = 823573584868632876L;

    public HttpCacheUpdateException(String r1) {
        super(r1);
    }

    public HttpCacheUpdateException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }
}
