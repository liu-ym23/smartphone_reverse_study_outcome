package cz.msebera.android.httpclient.impl.cookie;

import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BasicPathHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return "path";
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void validate(Cookie r1, CookieOrigin r2) throws MalformedCookieException {
    }

    public BasicPathHandler() {
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r1, String r2) throws MalformedCookieException {
        Args.notNull(r1, "Cookie");
        if (TextUtils.isBlank(r2) == false) goto L6;
        r2 = LibrarianImpl.Constants.SEPARATOR;
    L6:
        r1.setPath(r2);
    }

    static boolean pathMatch(String r4, String r5) {
        if (r5 != null) goto L6;
        r5 = LibrarianImpl.Constants.SEPARATOR;
    L6:
        if (r5.length() <= 1) goto L11;
        if (r5.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L11;
        r5 = r5.substring(0, r5.length() - 1);
    L11:
        if (r4.startsWith(r5) == true) goto L13;
    L21:
        return false;
    L13:
        if (r5.equals(LibrarianImpl.Constants.SEPARATOR) == false) goto L16;
        return true;
    L16:
        if (r4.length() != r5.length()) goto L19;
        return true;
    L19:
        if (r4.charAt(r5.length()) != '/') goto L21;
        return true;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public boolean match(Cookie r1, CookieOrigin r2) {
        Args.notNull(r1, "Cookie");
        Args.notNull(r2, "Cookie origin");
        return pathMatch(r2.getPath(), r1.getPath());
    }
}
