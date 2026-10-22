package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcher;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public class RFC6265CookieSpecProvider implements CookieSpecProvider {
    private final CompatibilityLevel compatibilityLevel;
    private volatile CookieSpec cookieSpec;
    private final PublicSuffixMatcher publicSuffixMatcher;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.impl.cookie.RFC6265CookieSpecProvider$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$impl$cookie$RFC6265CookieSpecProvider$CompatibilityLevel = null;

        static {
            int[] r0 = new int[CompatibilityLevel.values().length];
            $SwitchMap$cz$msebera$android$httpclient$impl$cookie$RFC6265CookieSpecProvider$CompatibilityLevel = r0;
            r0[CompatibilityLevel.STRICT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$cz$msebera$android$httpclient$impl$cookie$RFC6265CookieSpecProvider$CompatibilityLevel[CompatibilityLevel.IE_MEDIUM_SECURITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum CompatibilityLevel extends Enum<CompatibilityLevel> {
        private static final /* synthetic */ CompatibilityLevel[] $VALUES = null;
        public static final CompatibilityLevel IE_MEDIUM_SECURITY = null;
        public static final CompatibilityLevel RELAXED = null;
        public static final CompatibilityLevel STRICT = null;

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
            CompatibilityLevel r0 = new CompatibilityLevel("STRICT", 0);
            STRICT = r0;
            CompatibilityLevel r1 = new CompatibilityLevel("RELAXED", 1);
            RELAXED = r1;
            CompatibilityLevel r3 = new CompatibilityLevel("IE_MEDIUM_SECURITY", 2);
            IE_MEDIUM_SECURITY = r3;
            $VALUES = new CompatibilityLevel[]{r0, r1, r3};
        }
    }

    public RFC6265CookieSpecProvider(CompatibilityLevel r1, PublicSuffixMatcher r2) {
        if (r1 != null) goto L6;
        r1 = CompatibilityLevel.RELAXED;
    L6:
        this.compatibilityLevel = r1;
        this.publicSuffixMatcher = r2;
    }

    public RFC6265CookieSpecProvider(PublicSuffixMatcher r2) {
        this(CompatibilityLevel.RELAXED, r2);
    }

    public RFC6265CookieSpecProvider() {
        this(CompatibilityLevel.RELAXED, null);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext r8) {
        if (this.cookieSpec != null) goto L19;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.cookieSpec != null) goto L13;
        int r9 = AnonymousClass2.$SwitchMap$cz$msebera$android$httpclient$impl$cookie$RFC6265CookieSpecProvider$CompatibilityLevel[this.compatibilityLevel.ordinal()];     // Catch: Throwable -> L15
        if (r9 == 1) goto L12;
        if (r9 == 2) goto L11;
        this.cookieSpec = new RFC6265LaxSpec(new CommonCookieAttributeHandler[]{new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new BasicDomainHandler(), this.publicSuffixMatcher), new LaxMaxAgeHandler(), new BasicSecureHandler(), new LaxExpiresHandler()});     // Catch: Throwable -> L15
        goto L13
    L11:
        this.cookieSpec = new RFC6265LaxSpec(new CommonCookieAttributeHandler[]{new AnonymousClass1(this), PublicSuffixDomainFilter.decorate(new BasicDomainHandler(), this.publicSuffixMatcher), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicExpiresHandler(RFC6265StrictSpec.DATE_PATTERNS)});     // Catch: Throwable -> L15
        goto L13
    L12:
        this.cookieSpec = new RFC6265StrictSpec(new CommonCookieAttributeHandler[]{new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new BasicDomainHandler(), this.publicSuffixMatcher), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicExpiresHandler(RFC6265StrictSpec.DATE_PATTERNS)});     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    L19:
        return this.cookieSpec;
    }
}
