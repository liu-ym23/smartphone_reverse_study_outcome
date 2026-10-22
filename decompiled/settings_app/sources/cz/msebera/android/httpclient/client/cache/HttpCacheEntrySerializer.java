package cz.msebera.android.httpclient.client.cache;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpCacheEntrySerializer {
    HttpCacheEntry readFrom(InputStream r1) throws IOException;

    void writeTo(HttpCacheEntry r1, OutputStream r2) throws IOException;
}
