package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.conn.util.PublicSuffixList;
import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcher;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class PublicSuffixDomainFilter implements CommonCookieAttributeHandler {
    private final CommonCookieAttributeHandler handler;
    private final Map<String, Boolean> localDomainMap;
    private final PublicSuffixMatcher publicSuffixMatcher;

    private static Map<String, Boolean> createLocalDomainMap() {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        r0.put(".localhost.", Boolean.TRUE);
        r0.put(".test.", Boolean.TRUE);
        r0.put(".local.", Boolean.TRUE);
        r0.put(".local", Boolean.TRUE);
        r0.put(".localdomain", Boolean.TRUE);
        return r0;
    }

    public PublicSuffixDomainFilter(CommonCookieAttributeHandler r2, PublicSuffixMatcher r3) {
        this.handler = (CommonCookieAttributeHandler) Args.notNull(r2, "Cookie handler");
        this.publicSuffixMatcher = (PublicSuffixMatcher) Args.notNull(r3, "Public suffix matcher");
        this.localDomainMap = createLocalDomainMap();
    }

    public PublicSuffixDomainFilter(CommonCookieAttributeHandler r2, PublicSuffixList r3) {
        Args.notNull(r2, "Cookie handler");
        Args.notNull(r3, "Public suffix list");
        this.handler = r2;
        this.publicSuffixMatcher = new PublicSuffixMatcher(r3.getRules(), r3.getExceptions());
        this.localDomainMap = createLocalDomainMap();
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie r5, CookieOrigin r6) {
        String r0 = r5.getDomain();
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = r0.indexOf(46);
        if (r2 < 0) goto L13;
        String r3 = r0.substring(r2);
        if (this.localDomainMap.containsKey(r3) == true) goto L18;
        if (this.publicSuffixMatcher.matches(r0) == false) goto L18;
        return false;
    L18:
        return this.handler.match(r5, r6);
    L13:
        if (r0.equalsIgnoreCase(r6.getHost()) == true) goto L18;
        if (this.publicSuffixMatcher.matches(r0) == false) goto L18;
        return false;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r1, String r2) throws MalformedCookieException {
        this.handler.parse(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r1, CookieOrigin r2) throws MalformedCookieException {
        this.handler.validate(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return this.handler.getAttributeName();
    }

    public static CommonCookieAttributeHandler decorate(CommonCookieAttributeHandler r1, PublicSuffixMatcher r2) {
        Args.notNull(r1, "Cookie attribute handler");
        if (r2 != null) goto L5;
        return r1;
    L5:
        return new PublicSuffixDomainFilter(r1, r2);
    }
}
