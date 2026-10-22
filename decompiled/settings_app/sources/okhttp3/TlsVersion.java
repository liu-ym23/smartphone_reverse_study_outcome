package okhttp3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TlsVersion.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0006R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lokhttp3/TlsVersion;", "", "javaName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum TlsVersion extends Enum<TlsVersion> {
    private static final /* synthetic */ TlsVersion[] $VALUES = null;
    public static final Companion Companion = null;
    public static final TlsVersion SSL_3_0 = null;
    public static final TlsVersion TLS_1_0 = null;
    public static final TlsVersion TLS_1_1 = null;
    public static final TlsVersion TLS_1_2 = null;
    public static final TlsVersion TLS_1_3 = null;
    private final String javaName;

    /* JADX INFO: compiled from: TlsVersion.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lokhttp3/TlsVersion$Companion;", "", "()V", "forJavaName", "Lokhttp3/TlsVersion;", "javaName", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TlsVersion forJavaName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "javaName");
            int r1 = r2.hashCode();
            if (r1 == 79201641) goto L21;
            if (r1 == 79923350) goto L18;
            switch(r1) {
                case -503070503: goto L15;
                case -503070502: goto L12;
                case -503070501: goto L9;
                default: goto L25;
            };
        L9:
            if (r2.equals("TLSv1.3") == false) goto L25;
            return TlsVersion.TLS_1_3;
        L12:
            if (r2.equals("TLSv1.2") == false) goto L25;
            return TlsVersion.TLS_1_2;
        L15:
            if (r2.equals("TLSv1.1") == false) goto L25;
            return TlsVersion.TLS_1_1;
        L25:
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected TLS version: ", r2));
        L18:
            if (r2.equals("TLSv1") == false) goto L25;
            return TlsVersion.TLS_1_0;
        L21:
            if (r2.equals("SSLv3") == false) goto L25;
            return TlsVersion.SSL_3_0;
        }
    }

    private static final /* synthetic */ TlsVersion[] $values() {
        return new TlsVersion[]{TLS_1_3, TLS_1_2, TLS_1_1, TLS_1_0, SSL_3_0};
    }

    @JvmStatic
    public static final TlsVersion forJavaName(String r1) {
        return Companion.forJavaName(r1);
    }

    public static TlsVersion valueOf(String r1) {
        return (TlsVersion) Enum.valueOf(TlsVersion.class, r1);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) $VALUES.clone();
    }

    private TlsVersion(String r1, int r2, String r3) {
        super(r1, r2);
        this.javaName = r3;
    }

    public final String javaName() {
        return this.javaName;
    }

    static {
        TLS_1_3 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        TLS_1_2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        TLS_1_1 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        TLS_1_0 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        SSL_3_0 = new TlsVersion("SSL_3_0", 4, "SSLv3");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}))
    /* JADX INFO: renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m3220deprecated_javaName() {
        return this.javaName;
    }
}
