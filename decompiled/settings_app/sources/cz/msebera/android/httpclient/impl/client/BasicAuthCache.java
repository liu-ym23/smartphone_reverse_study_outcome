package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.DefaultSchemePortResolver;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class BasicAuthCache implements AuthCache {
    public HttpClientAndroidLog log;
    private final Map<HttpHost, byte[]> map;
    private final SchemePortResolver schemePortResolver;

    public BasicAuthCache(SchemePortResolver r3) {
        this.log = new HttpClientAndroidLog(getClass());
        this.map = new ConcurrentHashMap();
        if (r3 != null) goto L6;
        r3 = DefaultSchemePortResolver.INSTANCE;
    L6:
        this.schemePortResolver = r3;
    }

    public BasicAuthCache() {
        this(null);
    }

    protected HttpHost getKey(HttpHost r3) {
        if (r3.getPort() <= 0) goto L9;
    L7:
        return r3;
    L9:
        int r2 = this.schemePortResolver.resolve(r3);     // Catch: UnsupportedSchemeException -> L8
        return new HttpHost(r3.getHostName(), r2, r3.getSchemeName());
    }

    @Override // cz.msebera.android.httpclient.client.AuthCache
    public void put(HttpHost r3, AuthScheme r4) {
        Args.notNull(r3, "HTTP host");
        if (r4 != null) goto L6;
        return;
    L6:
        if ((r4 instanceof Serializable) == false) goto L14;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: IOException -> L9
        ObjectOutputStream r1 = new ObjectOutputStream(r0);     // Catch: IOException -> L9
        r1.writeObject(r4);     // Catch: IOException -> L9
        r1.close();     // Catch: IOException -> L9
        this.map.put(getKey(r3), r0.toByteArray());     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        if (this.log.isWarnEnabled() == false) goto L19;
        this.log.warn("Unexpected I/O error while serializing auth scheme", e);
        return;
    L19:
        return;
    L14:
        if (this.log.isDebugEnabled() == false) goto L21;
        this.log.debug("Auth scheme " + r4.getClass() + " is not serializable");
        return;
    }

    @Override // cz.msebera.android.httpclient.client.AuthCache
    public AuthScheme get(HttpHost r3) {
        Args.notNull(r3, "HTTP host");
        byte[] r4 = this.map.get(getKey(r3));
        if (r4 != null) goto L16;
    L15:
        return null;
    L16:
        ObjectInputStream r5 = new ObjectInputStream(new ByteArrayInputStream(r4));     // Catch: ClassNotFoundException -> L6 IOException -> L11
        AuthScheme r1 = (AuthScheme) r5.readObject();     // Catch: ClassNotFoundException -> L6 IOException -> L11
        r5.close();     // Catch: ClassNotFoundException -> L6 IOException -> L11
        return r1;
    L11:
        e = move-exception;
        if (this.log.isWarnEnabled() == false) goto L15;
        this.log.warn("Unexpected I/O error while de-serializing auth scheme", e);
    L6:
        e = move-exception;
        if (this.log.isWarnEnabled() == false) goto L10;
        this.log.warn("Unexpected error while de-serializing auth scheme", e);
    L10:
        return null;
    }

    @Override // cz.msebera.android.httpclient.client.AuthCache
    public void remove(HttpHost r2) {
        Args.notNull(r2, "HTTP host");
        this.map.remove(getKey(r2));
    }

    @Override // cz.msebera.android.httpclient.client.AuthCache
    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }
}
