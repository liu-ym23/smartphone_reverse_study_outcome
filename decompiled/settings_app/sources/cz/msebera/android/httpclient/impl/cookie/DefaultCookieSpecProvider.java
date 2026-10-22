package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcher;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultCookieSpecProvider implements CookieSpecProvider {
    private final CompatibilityLevel compatibilityLevel;
    private volatile CookieSpec cookieSpec;
    private final String[] datepatterns;
    private final boolean oneHeader;
    private final PublicSuffixMatcher publicSuffixMatcher;

    public static final enum CompatibilityLevel extends Enum<CompatibilityLevel> {
        private static final /* synthetic */ CompatibilityLevel[] $VALUES = null;
        public static final CompatibilityLevel DEFAULT = null;
        public static final CompatibilityLevel IE_MEDIUM_SECURITY = null;

        private CompatibilityLevel(String r1, int r2) {
            super(r1, r2);
        }

        public static CompatibilityLevel valueOf(String r1) {
            return (CompatibilityLevel) Enum.valueOf(CompatibilityLevel.class, r1);
        }

        public static CompatibilityLevel[] values() {
            return (CompatibilityLevel[]) $VALUES.clone();
        }

        static {
            CompatibilityLevel r0 = new CompatibilityLevel("DEFAULT", 0);
            DEFAULT = r0;
            CompatibilityLevel r1 = new CompatibilityLevel("IE_MEDIUM_SECURITY", 1);
            IE_MEDIUM_SECURITY = r1;
            $VALUES = new CompatibilityLevel[]{r0, r1};
        }
    }

    public DefaultCookieSpecProvider(CompatibilityLevel r1, PublicSuffixMatcher r2, String[] r3, boolean r4) {
        if (r1 != null) goto L6;
        r1 = CompatibilityLevel.DEFAULT;
    L6:
        this.compatibilityLevel = r1;
        this.publicSuffixMatcher = r2;
        this.datepatterns = r3;
        this.oneHeader = r4;
    }

    public DefaultCookieSpecProvider(CompatibilityLevel r3, PublicSuffixMatcher r4) {
        this(r3, r4, null, false);
    }

    public DefaultCookieSpecProvider(PublicSuffixMatcher r4) {
        this(CompatibilityLevel.DEFAULT, r4, null, false);
    }

    public DefaultCookieSpecProvider() {
        this(CompatibilityLevel.DEFAULT, null, null, false);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext r12) {
        if (this.cookieSpec != null) goto L22;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (this.cookieSpec != null) goto L16;
        RFC2965Spec r13 = new RFC2965Spec(this.oneHeader, new CommonCookieAttributeHandler[]{new RFC2965VersionAttributeHandler(), new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new RFC2965DomainAttributeHandler(), this.publicSuffixMatcher), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler()});     // Catch: Throwable -> L18
        RFC2109Spec r0 = new RFC2109Spec(this.oneHeader, new CommonCookieAttributeHandler[]{new RFC2109VersionHandler(), new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new RFC2109DomainHandler(), this.publicSuffixMatcher), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler()});     // Catch: Throwable -> L18
        CommonCookieAttributeHandler[] r2 = new CommonCookieAttributeHandler[5];     // Catch: Throwable -> L18
        r2[0] = PublicSuffixDomainFilter.decorate(new BasicDomainHandler(), this.publicSuffixMatcher);     // Catch: Throwable -> L18
        if (this.compatibilityLevel != CompatibilityLevel.IE_MEDIUM_SECURITY) goto L10;
        BasicPathHandler r3 = new AnonymousClass1(this);     // Catch: Throwable -> L18
    L11:
        r2[1] = r3;     // Catch: Throwable -> L18
        r2[2] = new BasicSecureHandler();     // Catch: Throwable -> L18
        r2[3] = new BasicCommentHandler();     // Catch: Throwable -> L18
        String[] r4 = this.datepatterns;     // Catch: Throwable -> L18
        if (r4 == null) goto L14;
        String[] r5 = (String[]) r4.clone();     // Catch: Throwable -> L18
    L15:
        r2[4] = new BasicExpiresHandler(r5);     // Catch: Throwable -> L18
        this.cookieSpec = new DefaultCookieSpec(r13, r0, new NetscapeDraftSpec(r2));     // Catch: Throwable -> L18
        goto L16
    L14:
        r5 = new String[]{"EEE, dd-MMM-yy HH:mm:ss z"};     // Catch: Throwable -> L18
        goto L15
    L10:
        r3 = new BasicPathHandler();     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
    L22:
        return this.cookieSpec;
    }
}
