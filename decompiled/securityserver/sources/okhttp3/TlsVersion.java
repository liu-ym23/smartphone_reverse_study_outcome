package okhttp3;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum TlsVersion extends Enum<TlsVersion> {
    private static final /* synthetic */ TlsVersion[] $VALUES = null;
    public static final Companion Companion = null;
    public static final TlsVersion SSL_3_0 = null;
    public static final TlsVersion TLS_1_0 = null;
    public static final TlsVersion TLS_1_1 = null;
    public static final TlsVersion TLS_1_2 = null;
    public static final TlsVersion TLS_1_3 = null;

    @NotNull
    private final String javaName;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final TlsVersion forJavaName(@NotNull String r2) {
            Intrinsics.f(r2, "javaName");
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
            throw new IllegalArgumentException("Unexpected TLS version: ".concat(r2));
        L18:
            if (r2.equals("TLSv1") == false) goto L25;
            return TlsVersion.TLS_1_0;
        L21:
            if (r2.equals("SSLv3") == false) goto L25;
            return TlsVersion.SSL_3_0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        TlsVersion r0 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        TLS_1_3 = r0;
        TlsVersion r1 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        TLS_1_2 = r1;
        TlsVersion r2 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        TLS_1_1 = r2;
        TlsVersion r3 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        TLS_1_0 = r3;
        TlsVersion r4 = new TlsVersion("SSL_3_0", 4, "SSLv3");
        SSL_3_0 = r4;
        $VALUES = new TlsVersion[]{r0, r1, r2, r3, r4};
        Companion = new Companion(null);
    }

    private TlsVersion(String r1, int r2, String r3) {
        super(r1, r2);
        this.javaName = r3;
    }

    @JvmStatic
    @NotNull
    public static final TlsVersion forJavaName(@NotNull String r1) {
        return Companion.forJavaName(r1);
    }

    public static TlsVersion valueOf(String r1) {
        return (TlsVersion) Enum.valueOf(TlsVersion.class, r1);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) $VALUES.clone();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m178deprecated_javaName() {
        return this.javaName;
    }

    @JvmName
    @NotNull
    public final String javaName() {
        return this.javaName;
    }
}
