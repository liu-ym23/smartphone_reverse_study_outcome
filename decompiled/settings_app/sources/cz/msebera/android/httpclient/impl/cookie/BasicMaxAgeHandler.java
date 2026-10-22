package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class BasicMaxAgeHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return "max-age";
    }

    public BasicMaxAgeHandler() {
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r7, String r8) throws MalformedCookieException {
        Args.notNull(r7, "Cookie");
        if (r8 == null) goto L13;
        int r6 = Integer.parseInt(r8);     // Catch: NumberFormatException -> L10
        if (r6 < 0) goto L9;
        r7.setExpiryDate(new Date(System.currentTimeMillis() + (((long) r6) * 1000)));
        return;
    L9:
        throw new MalformedCookieException("Negative 'max-age' attribute: " + r8);
    L11:
        throw new MalformedCookieException("Invalid 'max-age' attribute: " + r8);
    L13:
        throw new MalformedCookieException("Missing value for 'max-age' attribute");
    }
}
