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
public class BestMatchSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    private final CookieSpec cookieSpec;

    public BestMatchSpecFactory(String[] r2, boolean r3) {
        this.cookieSpec = new BestMatchSpec(r2, r3);
    }

    public BestMatchSpecFactory() {
        this(null, false);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecFactory
    public CookieSpec newInstance(HttpParams r3) {
        if (r3 == null) goto L10;
        Collection r2 = (Collection) r3.getParameter(CookieSpecPNames.DATE_PATTERNS);
        if (r2 == null) goto L6;
        String[] r4 = (String[]) r2.toArray(new String[r2.size()]);
    L8:
        return new BestMatchSpec(r4, r3.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
    L6:
        r4 = null;
        goto L8
    L10:
        return new BestMatchSpec();
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext r1) {
        return this.cookieSpec;
    }
}
