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
public class RFC2965DomainAttributeHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.DOMAIN_ATTR;
    }

    public RFC2965DomainAttributeHandler() {
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r2, String r3) throws MalformedCookieException {
        Args.notNull(r2, "Cookie");
        if (r3 == null) goto L14;
        if (r3.trim().isEmpty() == true) goto L12;
        String r1 = r3.toLowerCase(Locale.ROOT);
        if (r3.startsWith(".") == true) goto L9;
        r1 = "." + r1;
    L9:
        r2.setDomain(r1);
        return;
    L12:
        throw new MalformedCookieException("Blank value for domain attribute");
    L14:
        throw new MalformedCookieException("Missing value for domain attribute");
    }

    public boolean domainMatch(String r1, String r2) {
        if (r1.equals(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2.startsWith(".") == true) goto L7;
    L9:
        return false;
    L7:
        if (r1.endsWith(r2) == false) goto L9;
        goto L9
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r7, CookieOrigin r8) throws MalformedCookieException {
        Args.notNull(r7, "Cookie");
        Args.notNull(r8, "Cookie origin");
        String r9 = r8.getHost().toLowerCase(Locale.ROOT);
        if (r7.getDomain() == null) goto L35;
        String r0 = r7.getDomain().toLowerCase(Locale.ROOT);
        if ((r7 instanceof ClientCookie) == false) goto L30;
        if (((ClientCookie) r7).containsAttribute(ClientCookie.DOMAIN_ATTR) == false) goto L30;
        if (r0.startsWith(".") == false) goto L28;
        int r4 = r0.indexOf(46, 1);
        if (r4 < 0) goto L15;
        if (r4 == (r0.length() - 1)) goto L15;
    L17:
        if (domainMatch(r9, r0) == false) goto L24;
        if (r9.substring(0, r9.length() - r0.length()).indexOf(46) != (-1)) goto L22;
        return;
    L22:
        throw new CookieRestrictionViolationException("Domain attribute \"" + r7.getDomain() + "\" violates RFC 2965: effective host minus domain may not contain any dots");
    L24:
        throw new CookieRestrictionViolationException("Domain attribute \"" + r7.getDomain() + "\" violates RFC 2965: effective host name does not domain-match domain attribute.");
    L15:
        if (r0.equals(".local") == true) goto L17;
        throw new CookieRestrictionViolationException("Domain attribute \"" + r7.getDomain() + "\" violates RFC 2965: the value contains no embedded dots and the value is not .local");
    L28:
        throw new CookieRestrictionViolationException("Domain attribute \"" + r7.getDomain() + "\" violates RFC 2109: domain must start with a dot");
    L30:
        if (r7.getDomain().equals(r9) == false) goto L33;
        return;
    L33:
        throw new CookieRestrictionViolationException("Illegal domain attribute: \"" + r7.getDomain() + "\".Domain of origin: \"" + r9 + "\"");
    L35:
        throw new CookieRestrictionViolationException("Invalid cookie state: domain not specified");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie r2, CookieOrigin r3) {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        String r4 = r3.getHost().toLowerCase(Locale.ROOT);
        String r5 = r2.getDomain();
        if (domainMatch(r4, r5) == true) goto L6;
        return false;
    L6:
        if (r4.substring(0, r4.length() - r5.length()).indexOf(46) != (-1)) goto L9;
        return true;
    L9:
        return false;
    }
}
