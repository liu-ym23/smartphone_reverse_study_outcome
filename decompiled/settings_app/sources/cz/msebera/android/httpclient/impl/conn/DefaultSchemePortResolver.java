package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.util.Args;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultSchemePortResolver implements SchemePortResolver {
    public static final DefaultSchemePortResolver INSTANCE = null;

    public DefaultSchemePortResolver() {
    }

    static {
        INSTANCE = new DefaultSchemePortResolver();
    }

    @Override // cz.msebera.android.httpclient.conn.SchemePortResolver
    public int resolve(HttpHost r2) throws UnsupportedSchemeException {
        Args.notNull(r2, "HTTP host");
        int r1 = r2.getPort();
        if (r1 <= 0) goto L5;
        return r1;
    L5:
        String r3 = r2.getSchemeName();
        if (r3.equalsIgnoreCase("http") == false) goto L10;
        return 80;
    L10:
        if (r3.equalsIgnoreCase(HttpHeadTimeFetcher.FETCHER_TYPE) == false) goto L14;
        return 443;
    L14:
        throw new UnsupportedSchemeException(r3 + " protocol is not supported");
    }
}
