package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.cookie.params.CookieSpecPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class NetscapeDraftSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    private final CookieSpec cookieSpec;

    public NetscapeDraftSpecFactory(String[] r2) {
        this.cookieSpec = new NetscapeDraftSpec(r2);
    }

    public NetscapeDraftSpecFactory() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecFactory
    public CookieSpec newInstance(HttpParams r1) {
        if (r1 == null) goto L10;
        Collection r0 = (Collection) r1.getParameter(CookieSpecPNames.DATE_PATTERNS);
        if (r0 == null) goto L6;
        String[] r2 = (String[]) r0.toArray(new String[r0.size()]);
    L8:
        return new NetscapeDraftSpec(r2);
    L6:
        r2 = null;
        goto L8
    L10:
        return new NetscapeDraftSpec();
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext r1) {
        return this.cookieSpec;
    }
}
