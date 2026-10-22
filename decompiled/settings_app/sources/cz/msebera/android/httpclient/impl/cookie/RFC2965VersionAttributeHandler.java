package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.cookie.SetCookie2;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RFC2965VersionAttributeHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return "version";
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie r1, CookieOrigin r2) {
        return true;
    }

    public RFC2965VersionAttributeHandler() {
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r1, String r2) throws MalformedCookieException {
        Args.notNull(r1, "Cookie");
        if (r2 == null) goto L13;
        int r0 = Integer.parseInt(r2);     // Catch: NumberFormatException -> L6
    L7:
        if (r0 < 0) goto L11;
        r1.setVersion(r0);
        return;
    L11:
        throw new MalformedCookieException("Invalid cookie version.");
    L6:
        r0 = -1;
        goto L7
    L13:
        throw new MalformedCookieException("Missing value for version attribute");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r1, CookieOrigin r2) throws MalformedCookieException {
        Args.notNull(r1, "Cookie");
        if ((r1 instanceof SetCookie2) == true) goto L5;
        return;
    L5:
        if ((r1 instanceof ClientCookie) == true) goto L7;
        return;
    L7:
        if (((ClientCookie) r1).containsAttribute("version") == false) goto L10;
        return;
    L10:
        throw new CookieRestrictionViolationException("Violates RFC 2965. Version attribute is required.");
    }
}
