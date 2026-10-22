package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.Header;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface CookieSpec {
    List<Header> formatCookies(List<Cookie> r1);

    int getVersion();

    Header getVersionHeader();

    boolean match(Cookie r1, CookieOrigin r2);

    List<Cookie> parse(Header r1, CookieOrigin r2) throws MalformedCookieException;

    void validate(Cookie r1, CookieOrigin r2) throws MalformedCookieException;
}
