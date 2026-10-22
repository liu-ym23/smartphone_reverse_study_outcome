package cz.msebera.android.httpclient.cookie;

/* JADX INFO: loaded from: classes5.dex */
public interface CookieAttributeHandler {
    boolean match(Cookie r1, CookieOrigin r2);

    void parse(SetCookie r1, String r2) throws MalformedCookieException;

    void validate(Cookie r1, CookieOrigin r2) throws MalformedCookieException;
}
