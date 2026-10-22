package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;

/* JADX INFO: loaded from: classes5.dex */
public class RFC6265StrictSpec extends RFC6265CookieSpecBase {
    static final String[] DATE_PATTERNS = null;

    public String toString() {
        return "rfc6265-strict";
    }

    static {
        DATE_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
    }

    public RFC6265StrictSpec() {
        super(new CommonCookieAttributeHandler[]{new BasicPathHandler(), new BasicDomainHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicExpiresHandler(DATE_PATTERNS)});
    }

    RFC6265StrictSpec(CommonCookieAttributeHandler... r1) {
        super(r1);
    }
}
