package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES = null;

    @JvmField
    @NotNull
    public static final ConnectionSpec CLEARTEXT = null;

    @JvmField
    @NotNull
    public static final ConnectionSpec COMPATIBLE_TLS = null;
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final ConnectionSpec MODERN_TLS = null;
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES = null;

    @JvmField
    @NotNull
    public static final ConnectionSpec RESTRICTED_TLS = null;
    private final String[] cipherSuitesAsString;
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    private final String[] tlsVersionsAsString;

    @Metadata
    public static final class Builder {

        @Nullable
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;

        @Nullable
        private String[] tlsVersions;

        public Builder(boolean r1) {
            this.tls = r1;
        }

        @NotNull
        public final Builder allEnabledCipherSuites() {
            if (this.tls == false) goto L7;
            this.cipherSuites = null;
            return this;
        L7:
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        @NotNull
        public final Builder allEnabledTlsVersions() {
            if (this.tls == false) goto L7;
            this.tlsVersions = null;
            return this;
        L7:
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        @NotNull
        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        @NotNull
        public final Builder cipherSuites(@NotNull CipherSuite... r6) {
            Intrinsics.f(r6, "cipherSuites");
            if (this.tls == false) goto L14;
            ArrayList r0 = new ArrayList(r6.length);
            int r1 = r6.length;
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L7;
            r0.add(r6[r3].javaName());
            r3 = r3 + 1;
            goto L5
        L7:
            Object[] r7 = r0.toArray(new String[0]);
            if (r7 == null) goto L12;
            String[] r8 = (String[]) r7;
            return cipherSuites((String[]) Arrays.copyOf(r8, r8.length));
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L14:
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        @Nullable
        public final String[] getCipherSuites$okhttp() {
            return this.cipherSuites;
        }

        public final boolean getSupportsTlsExtensions$okhttp() {
            return this.supportsTlsExtensions;
        }

        public final boolean getTls$okhttp() {
            return this.tls;
        }

        @Nullable
        public final String[] getTlsVersions$okhttp() {
            return this.tlsVersions;
        }

        public final void setCipherSuites$okhttp(@Nullable String[] r1) {
            this.cipherSuites = r1;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean r1) {
            this.supportsTlsExtensions = r1;
        }

        public final void setTls$okhttp(boolean r1) {
            this.tls = r1;
        }

        public final void setTlsVersions$okhttp(@Nullable String[] r1) {
            this.tlsVersions = r1;
        }

        @Deprecated
        @NotNull
        public final Builder supportsTlsExtensions(boolean r2) {
            if (this.tls == false) goto L7;
            this.supportsTlsExtensions = r2;
            return this;
        L7:
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        @NotNull
        public final Builder tlsVersions(@NotNull TlsVersion... r6) {
            Intrinsics.f(r6, "tlsVersions");
            if (this.tls == false) goto L14;
            ArrayList r0 = new ArrayList(r6.length);
            int r1 = r6.length;
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L7;
            r0.add(r6[r3].javaName());
            r3 = r3 + 1;
            goto L5
        L7:
            Object[] r7 = r0.toArray(new String[0]);
            if (r7 == null) goto L12;
            String[] r8 = (String[]) r7;
            return tlsVersions((String[]) Arrays.copyOf(r8, r8.length));
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L14:
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public Builder(@NotNull ConnectionSpec r2) {
            Intrinsics.f(r2, "connectionSpec");
            this.tls = r2.isTls();
            this.cipherSuites = ConnectionSpec.access$getCipherSuitesAsString$p(r2);
            this.tlsVersions = ConnectionSpec.access$getTlsVersionsAsString$p(r2);
            this.supportsTlsExtensions = r2.supportsTlsExtensions();
        }

        @NotNull
        public final Builder cipherSuites(@NotNull String... r3) {
            Intrinsics.f(r3, "cipherSuites");
            if (this.tls == false) goto L19;
            if (r3.length != 0) goto L7;
            boolean r0 = true;
        L9:
            if ((!r0) == false) goto L17;
            Object r4 = r3.clone();
            if (r4 == null) goto L15;
            this.cipherSuites = (String[]) r4;
            return this;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        L17:
            throw new IllegalArgumentException("At least one cipher suite is required".toString());
        L7:
            r0 = false;
            goto L9
        L19:
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        @NotNull
        public final Builder tlsVersions(@NotNull String... r3) {
            Intrinsics.f(r3, "tlsVersions");
            if (this.tls == false) goto L19;
            if (r3.length != 0) goto L7;
            boolean r0 = true;
        L9:
            if ((!r0) == false) goto L17;
            Object r4 = r3.clone();
            if (r4 == null) goto L15;
            this.tlsVersions = (String[]) r4;
            return this;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        L17:
            throw new IllegalArgumentException("At least one TLS version is required".toString());
        L7:
            r0 = false;
            goto L9
        L19:
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        CipherSuite r0 = CipherSuite.TLS_AES_128_GCM_SHA256;
        CipherSuite r1 = CipherSuite.TLS_AES_256_GCM_SHA384;
        CipherSuite r11 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        CipherSuite r12 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        CipherSuite r13 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        CipherSuite r14 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        CipherSuite r15 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        CipherSuite r16 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite r17 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite[] r10 = {r0, r1, r11, r12, r13, r14, r15, r16, r17};
        RESTRICTED_CIPHER_SUITES = r10;
        CipherSuite[] r2 = {r0, r1, r11, r12, r13, r14, r15, r16, r17, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        APPROVED_CIPHER_SUITES = r2;
        Builder r3 = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(r10, r10.length));
        TlsVersion r4 = TlsVersion.TLS_1_3;
        TlsVersion r5 = TlsVersion.TLS_1_2;
        RESTRICTED_TLS = r3.tlsVersions(new TlsVersion[]{r4, r5}).supportsTlsExtensions(true).build();
        MODERN_TLS = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(r2, r2.length)).tlsVersions(new TlsVersion[]{r4, r5}).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(r2, r2.length)).tlsVersions(new TlsVersion[]{r4, r5, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0}).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    public ConnectionSpec(boolean r1, boolean r2, @Nullable String[] r3, @Nullable String[] r4) {
        this.isTls = r1;
        this.supportsTlsExtensions = r2;
        this.cipherSuitesAsString = r3;
        this.tlsVersionsAsString = r4;
    }

    public static final /* synthetic */ String[] access$getCipherSuitesAsString$p(ConnectionSpec r0) {
        return r0.cipherSuitesAsString;
    }

    public static final /* synthetic */ String[] access$getTlsVersionsAsString$p(ConnectionSpec r0) {
        return r0.tlsVersionsAsString;
    }

    private final ConnectionSpec supportedSpec(SSLSocket r5, boolean r6) {
        if (this.cipherSuitesAsString == null) goto L5;
        String[] r0 = r5.getEnabledCipherSuites();
        Intrinsics.e(r0, "sslSocket.enabledCipherSuites");
        String[] r1 = Util.intersect(r0, this.cipherSuitesAsString, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
    L7:
        if (this.tlsVersionsAsString == null) goto L9;
        String[] r2 = r5.getEnabledProtocols();
        Intrinsics.e(r2, "sslSocket.enabledProtocols");
        String[] r3 = Util.intersect(r2, this.tlsVersionsAsString, ComparisonsKt.a());
    L10:
        String[] r7 = r5.getSupportedCipherSuites();
        Intrinsics.e(r7, "supportedCipherSuites");
        int r4 = Util.indexOf(r7, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        if (r6 == true) goto L13;
    L15:
        Builder r8 = new Builder(this);
        Intrinsics.e(r1, "cipherSuitesIntersection");
        Builder r9 = r8.cipherSuites((String[]) Arrays.copyOf(r1, r1.length));
        Intrinsics.e(r3, "tlsVersionsIntersection");
        return r9.tlsVersions((String[]) Arrays.copyOf(r3, r3.length)).build();
    L13:
        if (r4 == (-1)) goto L15;
        Intrinsics.e(r1, "cipherSuitesIntersection");
        String r10 = r7[r4];
        Intrinsics.e(r10, "supportedCipherSuites[indexOfFallbackScsv]");
        r1 = Util.concat(r1, r10);
        goto L15
    L9:
        r3 = r5.getEnabledProtocols();
        goto L10
    L5:
        r1 = r5.getEnabledCipherSuites();
        goto L7
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_cipherSuites, reason: not valid java name */
    public final List<CipherSuite> m72deprecated_cipherSuites() {
        return cipherSuites();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_supportsTlsExtensions, reason: not valid java name */
    public final boolean m73deprecated_supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_tlsVersions, reason: not valid java name */
    public final List<TlsVersion> m74deprecated_tlsVersions() {
        return tlsVersions();
    }

    public final void apply$okhttp(@NotNull SSLSocket r2, boolean r3) {
        Intrinsics.f(r2, "sslSocket");
        ConnectionSpec r1 = supportedSpec(r2, r3);
        if (r1.tlsVersions() == null) goto L6;
        r2.setEnabledProtocols(r1.tlsVersionsAsString);
    L6:
        if (r1.cipherSuites() == null) goto L9;
        r2.setEnabledCipherSuites(r1.cipherSuitesAsString);
        return;
    }

    @JvmName
    @Nullable
    public final List<CipherSuite> cipherSuites() {
        String[] r5 = this.cipherSuitesAsString;
        if (r5 == null) goto L8;
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        String r3 = r5[r2];
        r0.add(CipherSuite.Companion.forJavaName(r3));
        r2 = r2 + 1;
        goto L5
    L11:
        return CollectionsKt.q(r0);
    L8:
        return null;
    }

    public boolean equals(@Nullable Object r5) {
        if ((r5 instanceof ConnectionSpec) == true) goto L6;
        return false;
    L6:
        if (r5 != this) goto L8;
        return true;
    L8:
        boolean r2 = this.isTls;
        ConnectionSpec r6 = (ConnectionSpec) r5;
        if (r2 == r6.isTls) goto L11;
        return false;
    L11:
        if (r2 == true) goto L13;
    L21:
        return true;
    L13:
        if (Arrays.equals(this.cipherSuitesAsString, r6.cipherSuitesAsString) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.tlsVersionsAsString, r6.tlsVersionsAsString) == true) goto L19;
        return false;
    L19:
        if (this.supportsTlsExtensions == r6.supportsTlsExtensions) goto L21;
        return false;
    }

    public int hashCode() {
        if (this.isTls == false) goto L12;
        String[] r0 = this.cipherSuitesAsString;
        int r1 = 0;
        if (r0 == null) goto L7;
        int r2 = Arrays.hashCode(r0);
    L8:
        int r3 = (527 + r2) * 31;
        String[] r4 = this.tlsVersionsAsString;
        if (r4 == null) goto L14;
        r1 = Arrays.hashCode(r4);
    L14:
        return ((r3 + r1) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
    L7:
        r2 = 0;
        goto L8
    L12:
        return 17;
    }

    public final boolean isCompatible(@NotNull SSLSocket r5) {
        Intrinsics.f(r5, "socket");
        if (this.isTls == true) goto L5;
        return false;
    L5:
        String[] r0 = this.tlsVersionsAsString;
        if (r0 != null) goto L8;
    L10:
        String[] r4 = this.cipherSuitesAsString;
        if (r4 != null) goto L13;
        return true;
    L13:
        if (Util.hasIntersection(r4, r5.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp()) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (Util.hasIntersection(r0, r5.getEnabledProtocols(), ComparisonsKt.a()) == true) goto L10;
        return false;
    }

    @JvmName
    public final boolean isTls() {
        return this.isTls;
    }

    @JvmName
    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @JvmName
    @Nullable
    public final List<TlsVersion> tlsVersions() {
        String[] r5 = this.tlsVersionsAsString;
        if (r5 == null) goto L8;
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        String r3 = r5[r2];
        r0.add(TlsVersion.Companion.forJavaName(r3));
        r2 = r2 + 1;
        goto L5
    L11:
        return CollectionsKt.q(r0);
    L8:
        return null;
    }

    @NotNull
    public String toString() {
        if (this.isTls == true) goto L7;
        return "ConnectionSpec()";
    L7:
        return "ConnectionSpec(cipherSuites=" + Objects.toString(cipherSuites(), "[all enabled]") + ", tlsVersions=" + Objects.toString(tlsVersions(), "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }
}
