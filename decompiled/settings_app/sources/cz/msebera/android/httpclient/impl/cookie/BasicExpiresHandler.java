package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class BasicExpiresHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    private final String[] datepatterns;

    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.EXPIRES_ATTR;
    }

    public BasicExpiresHandler(String[] r2) {
        Args.notNull(r2, "Array of date patterns");
        this.datepatterns = r2;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r2, String r3) throws MalformedCookieException {
        Args.notNull(r2, "Cookie");
        if (r3 == null) goto L11;
        Date r1 = cz.msebera.android.httpclient.client.utils.DateUtils.parseDate(r3, this.datepatterns);
        if (r1 == null) goto L9;
        r2.setExpiryDate(r1);
        return;
    L9:
        throw new MalformedCookieException("Invalid 'expires' attribute: " + r3);
    L11:
        throw new MalformedCookieException("Missing value for 'expires' attribute");
    }
}
