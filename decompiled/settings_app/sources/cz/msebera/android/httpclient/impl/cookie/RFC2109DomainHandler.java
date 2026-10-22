package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class RFC2109DomainHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.DOMAIN_ATTR;
    }

    public RFC2109DomainHandler() {
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r1, String r2) throws MalformedCookieException {
        Args.notNull(r1, "Cookie");
        if (r2 == null) goto L11;
        if (r2.trim().isEmpty() == true) goto L9;
        r1.setDomain(r2);
        return;
    L9:
        throw new MalformedCookieException("Blank value for domain attribute");
    L11:
        throw new MalformedCookieException("Missing value for domain attribute");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r7, CookieOrigin r8) throws MalformedCookieException {
        Args.notNull(r7, "Cookie");
        Args.notNull(r8, "Cookie origin");
        String r6 = r8.getHost();
        String r9 = r7.getDomain();
        if (r9 == null) goto L31;
        if (r9.equals(r6) == false) goto L7;
        return;
    L7:
        if (r9.indexOf(46) == (-1)) goto L28;
        if (r9.startsWith(".") == false) goto L26;
        int r4 = r9.indexOf(46, 1);
        if (r4 < 0) goto L24;
        if (r4 == (r9.length() - 1)) goto L24;
        String r10 = r6.toLowerCase(Locale.ROOT);
        if (r10.endsWith(r9) == false) goto L22;
        if (r10.substring(0, r10.length() - r9.length()).indexOf(46) != (-1)) goto L20;
        return;
    L20:
        throw new CookieRestrictionViolationException("Domain attribute \"" + r9 + "\" violates RFC 2109: host minus domain may not contain any dots");
    L22:
        throw new CookieRestrictionViolationException("Illegal domain attribute \"" + r9 + "\". Domain of origin: \"" + r10 + "\"");
    L24:
        throw new CookieRestrictionViolationException("Domain attribute \"" + r9 + "\" violates RFC 2109: domain must contain an embedded dot");
    L26:
        throw new CookieRestrictionViolationException("Domain attribute \"" + r9 + "\" violates RFC 2109: domain must start with a dot");
    L28:
        throw new CookieRestrictionViolationException("Domain attribute \"" + r9 + "\" does not match the host \"" + r6 + "\"");
    L31:
        throw new CookieRestrictionViolationException("Cookie domain may not be null");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie r2, CookieOrigin r3) {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        String r1 = r3.getHost();
        String r4 = r2.getDomain();
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r1.equals(r4) == false) goto L8;
    L11:
        return true;
    L8:
        if (r4.startsWith(".") == true) goto L10;
        return false;
    L10:
        if (r1.endsWith(r4) == true) goto L11;
        return false;
    }
}
