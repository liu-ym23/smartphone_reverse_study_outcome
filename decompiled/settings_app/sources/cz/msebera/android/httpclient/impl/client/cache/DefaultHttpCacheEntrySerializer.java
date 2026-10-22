package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializationException;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpCacheEntrySerializer implements HttpCacheEntrySerializer {
    public DefaultHttpCacheEntrySerializer() {
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer
    public void writeTo(HttpCacheEntry r1, OutputStream r2) throws IOException {
        ObjectOutputStream r0 = new ObjectOutputStream(r2);
        r0.writeObject(r1);     // Catch: Throwable -> L6
        r0.close();
        return;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer
    public HttpCacheEntry readFrom(InputStream r4) throws IOException {
        ObjectInputStream r0 = new ObjectInputStream(r4);
        HttpCacheEntry r5 = (HttpCacheEntry) r0.readObject();     // Catch: Throwable -> L6 ClassNotFoundException -> L8
        r0.close();
        return r5;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        e = move-exception;
        throw new HttpCacheEntrySerializationException("Class not found: " + e.getMessage(), e);     // Catch: Throwable -> L6
    }
}
