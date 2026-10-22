package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RFC2109VersionHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return "version";
    }

    public RFC2109VersionHandler() {
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r2, String r3) throws MalformedCookieException {
        Args.notNull(r2, "Cookie");
        if (r3 == null) goto L14;
        if (r3.trim().isEmpty() == true) goto L12;
        r2.setVersion(Integer.parseInt(r3));     // Catch: NumberFormatException -> L8
        return;
    L8:
        e = move-exception;
        throw new MalformedCookieException("Invalid version: " + e.getMessage());
    L12:
        throw new MalformedCookieException("Blank value for version attribute");
    L14:
        throw new MalformedCookieException("Missing value for version attribute");
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.AbstractCookieAttributeHandler, cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r1, CookieOrigin r2) throws MalformedCookieException {
        Args.notNull(r1, "Cookie");
        if (r1.getVersion() < 0) goto L6;
        return;
    L6:
        throw new CookieRestrictionViolationException("Cookie version may not be negative");
    }
}
