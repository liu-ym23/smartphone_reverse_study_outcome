package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcher;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class PublicSuffixFilter implements CookieAttributeHandler {
    private Collection<String> exceptions;
    private PublicSuffixMatcher matcher;
    private Collection<String> suffixes;
    private final CookieAttributeHandler wrapped;

    public PublicSuffixFilter(CookieAttributeHandler r1) {
        this.wrapped = r1;
    }

    public void setPublicSuffixes(Collection<String> r1) {
        this.suffixes = r1;
        this.matcher = null;
    }

    public void setExceptions(Collection<String> r1) {
        this.exceptions = r1;
        this.matcher = null;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie r2, CookieOrigin r3) {
        if (isForPublicSuffix(r2) == false) goto L7;
        return false;
    L7:
        return this.wrapped.match(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r1, String r2) throws MalformedCookieException {
        this.wrapped.parse(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r1, CookieOrigin r2) throws MalformedCookieException {
        this.wrapped.validate(r1, r2);
    }

    private boolean isForPublicSuffix(Cookie r4) {
        if (this.matcher != null) goto L6;
        this.matcher = new PublicSuffixMatcher(this.suffixes, this.exceptions);
    L6:
        return this.matcher.matches(r4.getDomain());
    }
}
