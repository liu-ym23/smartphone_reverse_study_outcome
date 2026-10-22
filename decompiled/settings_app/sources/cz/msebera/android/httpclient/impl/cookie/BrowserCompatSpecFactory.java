package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.cookie.params.CookieSpecPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BrowserCompatSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    private final CookieSpec cookieSpec;
    private final SecurityLevel securityLevel;

    public static final enum SecurityLevel extends Enum<SecurityLevel> {
        private static final /* synthetic */ SecurityLevel[] $VALUES = null;
        public static final SecurityLevel SECURITYLEVEL_DEFAULT = null;
        public static final SecurityLevel SECURITYLEVEL_IE_MEDIUM = null;

        private SecurityLevel(String r1, int r2) {
            super(r1, r2);
        }

        public static SecurityLevel valueOf(String r1) {
            return (SecurityLevel) Enum.valueOf(SecurityLevel.class, r1);
        }

        public static SecurityLevel[] values() {
            return (SecurityLevel[]) $VALUES.clone();
        }

        static {
            SecurityLevel r0 = new SecurityLevel("SECURITYLEVEL_DEFAULT", 0);
            SECURITYLEVEL_DEFAULT = r0;
            SecurityLevel r1 = new SecurityLevel("SECURITYLEVEL_IE_MEDIUM", 1);
            SECURITYLEVEL_IE_MEDIUM = r1;
            $VALUES = new SecurityLevel[]{r0, r1};
        }
    }

    public BrowserCompatSpecFactory(String[] r2, SecurityLevel r3) {
        this.securityLevel = r3;
        this.cookieSpec = new BrowserCompatSpec(r2, r3);
    }

    public BrowserCompatSpecFactory(String[] r2) {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecFactory() {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecFactory
    public CookieSpec newInstance(HttpParams r3) {
        String[] r0 = null;
        if (r3 == null) goto L10;
        Collection r4 = (Collection) r3.getParameter(CookieSpecPNames.DATE_PATTERNS);
        if (r4 == null) goto L8;
        r0 = (String[]) r4.toArray(new String[r4.size()]);
    L8:
        return new BrowserCompatSpec(r0, this.securityLevel);
    L10:
        return new BrowserCompatSpec(null, this.securityLevel);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext r1) {
        return this.cookieSpec;
    }
}
