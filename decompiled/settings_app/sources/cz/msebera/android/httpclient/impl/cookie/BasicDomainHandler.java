package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class BasicDomainHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.DOMAIN_ATTR;
    }

    public BasicDomainHandler() {
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r2, String r3) throws MalformedCookieException {
        Args.notNull(r2, "Cookie");
        if (TextUtils.isBlank(r3) == true) goto L13;
        if (r3.endsWith(".") == false) goto L8;
        return;
    L8:
        if (r3.startsWith(".") == false) goto L10;
        r3 = r3.substring(1);
    L10:
        r2.setDomain(r3.toLowerCase(Locale.ROOT));
        return;
    L13:
        throw new MalformedCookieException("Blank or null value for domain attribute");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r3, CookieOrigin r4) throws MalformedCookieException {
        Args.notNull(r3, "Cookie");
        Args.notNull(r4, "Cookie origin");
        String r2 = r4.getHost();
        String r5 = r3.getDomain();
        if (r5 == null) goto L13;
        if (r2.equals(r5) == false) goto L7;
        return;
    L7:
        if (domainMatch(r5, r2) == false) goto L10;
        return;
    L10:
        throw new CookieRestrictionViolationException("Illegal 'domain' attribute \"" + r5 + "\". Domain of origin: \"" + r2 + "\"");
    L13:
        throw new CookieRestrictionViolationException("Cookie 'domain' may not be null");
    }

    static boolean domainMatch(String r3, String r4) {
        if (InetAddressUtils.isIPv4Address(r4) == false) goto L5;
    L19:
        return false;
    L5:
        if (InetAddressUtils.isIPv6Address(r4) == true) goto L19;
        if (r3.startsWith(".") == false) goto L11;
        r3 = r3.substring(1);
    L11:
        if (r4.endsWith(r3) == false) goto L19;
        int r0 = r4.length() - r3.length();
        if (r0 != 0) goto L15;
        return true;
    L15:
        if (r0 <= 1) goto L19;
        if (r4.charAt(r0 - 1) != '.') goto L19;
        return true;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie r4, CookieOrigin r5) {
        Args.notNull(r4, "Cookie");
        Args.notNull(r5, "Cookie origin");
        String r3 = r5.getHost();
        String r6 = r4.getDomain();
        if (r6 != null) goto L6;
        return false;
    L6:
        if (r6.startsWith(".") == false) goto L8;
        r6 = r6.substring(1);
    L8:
        String r7 = r6.toLowerCase(Locale.ROOT);
        if (r3.equals(r7) == false) goto L12;
        return true;
    L12:
        if ((r4 instanceof ClientCookie) == true) goto L14;
    L17:
        return false;
    L14:
        if (((ClientCookie) r4).containsAttribute(ClientCookie.DOMAIN_ATTR) == false) goto L17;
        return domainMatch(r7, r3);
    }
}
