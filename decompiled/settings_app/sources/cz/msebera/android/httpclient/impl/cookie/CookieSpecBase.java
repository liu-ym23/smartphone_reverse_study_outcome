package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.util.Args;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CookieSpecBase extends AbstractCookieSpec {
    public CookieSpecBase() {
    }

    protected CookieSpecBase(HashMap<String, CookieAttributeHandler> r1) {
        super(r1);
    }

    protected CookieSpecBase(CommonCookieAttributeHandler... r1) {
        super(r1);
    }

    protected static String getDefaultPath(CookieOrigin r2) {
        String r3 = r2.getPath();
        int r0 = r3.lastIndexOf(47);
        if (r0 < 0) goto L8;
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        return r3.substring(0, r0);
    L8:
        return r3;
    }

    protected static String getDefaultDomain(CookieOrigin r0) {
        return r0.getHost();
    }

    protected List<Cookie> parse(HeaderElement[] r10, CookieOrigin r11) throws MalformedCookieException {
        ArrayList r0 = new ArrayList(r10.length);
        int r1 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L17;
        HeaderElement r3 = r10[r2];
        String r4 = r3.getName();
        String r5 = r3.getValue();
        if (r4 == null) goto L16;
        if (r4.isEmpty() == true) goto L16;
        BasicClientCookie r6 = new BasicClientCookie(r4, r5);
        r6.setPath(getDefaultPath(r11));
        r6.setDomain(getDefaultDomain(r11));
        NameValuePair[] r7 = r3.getParameters();
        int r8 = r7.length - 1;
    L10:
        if (r8 < 0) goto L15;
        NameValuePair r9 = r7[r8];
        String r12 = r9.getName().toLowerCase(Locale.ROOT);
        r6.setAttribute(r12, r9.getValue());
        CookieAttributeHandler r13 = findAttribHandler(r12);
        if (r13 == null) goto L14;
        r13.parse(r6, r9.getValue());
    L14:
        r8 = r8 - 1;
        goto L10
    L15:
        r0.add(r6);
    L16:
        r2 = r2 + 1;
        goto L3
    L17:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public void validate(Cookie r2, CookieOrigin r3) throws MalformedCookieException {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        Iterator<CookieAttributeHandler> r1 = getAttribHandlers().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().validate(r2, r3);
        goto L4
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public boolean match(Cookie r2, CookieOrigin r3) {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        Iterator<CookieAttributeHandler> r1 = getAttribHandlers().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().match(r2, r3) == true) goto L4;
        return false;
    L9:
        return true;
    }
}
