package cz.msebera.android.httpclient.client.cache;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class HttpCacheEntrySerializationException extends IOException {
    private static final long serialVersionUID = 9219188365878433519L;

    public HttpCacheEntrySerializationException(String r1) {
    }

    public HttpCacheEntrySerializationException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }
}
