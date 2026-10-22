package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Date;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class LaxMaxAgeHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    private static final Pattern MAX_AGE_PATTERN = null;

    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return "max-age";
    }

    static {
        MAX_AGE_PATTERN = Pattern.compile("^\\-?[0-9]+$");
    }

    public LaxMaxAgeHandler() {
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r7, String r8) throws MalformedCookieException {
        Args.notNull(r7, "Cookie");
        if (TextUtils.isBlank(r8) == false) goto L6;
        return;
    L6:
        if (MAX_AGE_PATTERN.matcher(r8).matches() == false) goto L17;
        int r6 = Integer.parseInt(r8);     // Catch: NumberFormatException -> L14
        if (r6 < 0) goto L11;
        Date r9 = new Date(System.currentTimeMillis() + (((long) r6) * 1000));
    L12:
        r7.setExpiryDate(r9);
        return;
    L11:
        r9 = new Date(Long.MIN_VALUE);
    L18:
        return;
    }
}
