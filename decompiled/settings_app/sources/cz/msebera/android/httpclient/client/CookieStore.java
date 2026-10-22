package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.cookie.Cookie;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface CookieStore {
    void addCookie(Cookie r1);

    void clear();

    boolean clearExpired(Date r1);

    List<Cookie> getCookies();
}
