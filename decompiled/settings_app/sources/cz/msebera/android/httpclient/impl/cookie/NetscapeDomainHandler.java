package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class NetscapeDomainHandler extends BasicDomainHandler {
    @Override // cz.msebera.android.httpclient.impl.cookie.BasicDomainHandler, cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.DOMAIN_ATTR;
    }

    public NetscapeDomainHandler() {
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicDomainHandler, cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r1, String r2) throws MalformedCookieException {
        Args.notNull(r1, "Cookie");
        if (TextUtils.isBlank(r2) == true) goto L7;
        r1.setDomain(r2);
        return;
    L7:
        throw new MalformedCookieException("Blank or null value for domain attribute");
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicDomainHandler, cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r3, CookieOrigin r4) throws MalformedCookieException {
        String r2 = r4.getHost();
        String r5 = r3.getDomain();
        if (r2.equals(r5) == true) goto L10;
        if (BasicDomainHandler.domainMatch(r5, r2) == true) goto L10;
        throw new CookieRestrictionViolationException("Illegal domain attribute \"" + r5 + "\". Domain of origin: \"" + r2 + "\"");
    L10:
        if (r2.contains(".") == false) goto L23;
        int r6 = new StringTokenizer(r5, ".").countTokens();
        if (isSpecialDomain(r5) == false) goto L19;
        if (r6 < 2) goto L17;
        return;
    L17:
        throw new CookieRestrictionViolationException("Domain attribute \"" + r5 + "\" violates the Netscape cookie specification for special domains");
    L19:
        if (r6 < 3) goto L22;
        return;
    L22:
        throw new CookieRestrictionViolationException("Domain attribute \"" + r5 + "\" violates the Netscape cookie specification");
    }

    private static boolean isSpecialDomain(String r1) {
        String r2 = r1.toUpperCase(Locale.ROOT);
        if (r2.endsWith(".COM") == false) goto L5;
    L18:
        return true;
    L5:
        if (r2.endsWith(".EDU") == true) goto L18;
        if (r2.endsWith(".NET") == true) goto L18;
        if (r2.endsWith(".GOV") == true) goto L18;
        if (r2.endsWith(".MIL") == true) goto L18;
        if (r2.endsWith(".ORG") == true) goto L18;
        if (r2.endsWith(".INT") == true) goto L18;
        return false;
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicDomainHandler, cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie r1, CookieOrigin r2) {
        Args.notNull(r1, "Cookie");
        Args.notNull(r2, "Cookie origin");
        String r0 = r2.getHost();
        String r3 = r1.getDomain();
        if (r3 != null) goto L7;
        return false;
    L7:
        return r0.endsWith(r3);
    }
}
