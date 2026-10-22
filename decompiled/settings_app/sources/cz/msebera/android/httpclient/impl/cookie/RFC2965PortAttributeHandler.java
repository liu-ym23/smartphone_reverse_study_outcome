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
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class RFC2965PortAttributeHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.PORT_ATTR;
    }

    public RFC2965PortAttributeHandler() {
    }

    private static int[] parsePortAttribute(String r3) throws MalformedCookieException {
        StringTokenizer r0 = new StringTokenizer(r3, ",");
        int[] r4 = new int[r0.countTokens()];
        int r1 = 0;
    L14:
    L11:
        e = move-exception;
        throw new MalformedCookieException("Invalid Port attribute: " + e.getMessage());
    L4:
        if (r0.hasMoreTokens() == false) goto L10;
        int r2 = Integer.parseInt(r0.nextToken().trim());     // Catch: NumberFormatException -> L11
        r4[r1] = r2;     // Catch: NumberFormatException -> L11
        if (r2 < 0) goto L9;
        r1 = r1 + 1;     // Catch: NumberFormatException -> L11
        goto L14
    L9:
        throw new MalformedCookieException("Invalid Port attribute.");     // Catch: NumberFormatException -> L11
    L10:
        return r4;
    }

    private static boolean portMatch(int r4, int[] r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r4 == r5[r2]) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r1, String r2) throws MalformedCookieException {
        Args.notNull(r1, "Cookie");
        if ((r1 instanceof SetCookie2) == false) goto L10;
        SetCookie2 r3 = (SetCookie2) r1;
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.trim().isEmpty() == true) goto L12;
        r3.setPorts(parsePortAttribute(r2));
        return;
    L12:
        return;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r2, CookieOrigin r3) throws MalformedCookieException {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        int r1 = r3.getPort();
        if ((r2 instanceof ClientCookie) == true) goto L5;
        return;
    L5:
        if (((ClientCookie) r2).containsAttribute(ClientCookie.PORT_ATTR) == true) goto L7;
        return;
    L7:
        if (portMatch(r1, r2.getPorts()) == false) goto L10;
        return;
    L10:
        throw new CookieRestrictionViolationException("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie r2, CookieOrigin r3) {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        int r1 = r3.getPort();
        if ((r2 instanceof ClientCookie) == true) goto L5;
        return true;
    L5:
        if (((ClientCookie) r2).containsAttribute(ClientCookie.PORT_ATTR) == true) goto L7;
        return true;
    L7:
        if (r2.getPorts() != null) goto L10;
        return false;
    L10:
        if (portMatch(r1, r2.getPorts()) == true) goto L15;
        return false;
    L15:
        return true;
    }
}
