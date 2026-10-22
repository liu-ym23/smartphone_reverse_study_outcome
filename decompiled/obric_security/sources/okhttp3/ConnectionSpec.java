package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;
import okhttp3.ttnet.TTConfigManager;

/* JADX INFO: loaded from: classes5.dex */
public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES = null;
    public static final ConnectionSpec CLEARTEXT = null;
    public static final ConnectionSpec COMPATIBLE_TLS = null;
    public static final ConnectionSpec MODERN_TLS = null;
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES = null;
    public static final ConnectionSpec RESTRICTED_TLS = null;
    private static final TlsVersion[] tlsVersionsAll = null;
    private static final TlsVersion[] tlsVersionsWithout1_1 = null;

    @Nullable
    final String[] cipherSuites;
    final boolean supportsTlsExtensions;
    final boolean tls;

    @Nullable
    final String[] tlsVersions;

    public static final class Builder {

        @Nullable
        String[] cipherSuites;
        boolean supportsTlsExtensions;
        boolean tls;

        @Nullable
        String[] tlsVersions;

        Builder(boolean r1) {
            this.tls = r1;
        }

        public Builder(ConnectionSpec r2) {
            this.tls = r2.tls;
            this.cipherSuites = r2.cipherSuites;
            this.tlsVersions = r2.tlsVersions;
            this.supportsTlsExtensions = r2.supportsTlsExtensions;
        }

        public Builder allEnabledCipherSuites() {
            if (this.tls == false) goto L7;
            this.cipherSuites = null;
            return this;
        L7:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder cipherSuites(CipherSuite... r4) {
            if (this.tls == false) goto L11;
            String[] r0 = new String[r4.length];
            int r1 = 0;
        L6:
            if (r1 >= r4.length) goto L9;
            r0[r1] = r4[r1].javaName;
            r1 = r1 + 1;
            goto L6
        L9:
            return cipherSuites(r0);
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder cipherSuites(String... r2) {
            if (this.tls == false) goto L11;
            if (r2.length == 0) goto L9;
            this.cipherSuites = (String[]) r2.clone();
            return this;
        L9:
            throw new IllegalArgumentException("At least one cipher suite is required");
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder allEnabledTlsVersions() {
            if (this.tls == false) goto L7;
            this.tlsVersions = null;
            return this;
        L7:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder tlsVersions(TlsVersion... r4) {
            if (this.tls == false) goto L11;
            String[] r0 = new String[r4.length];
            int r1 = 0;
        L6:
            if (r1 >= r4.length) goto L9;
            r0[r1] = r4[r1].javaName;
            r1 = r1 + 1;
            goto L6
        L9:
            return tlsVersions(r0);
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder tlsVersions(String... r2) {
            if (this.tls == false) goto L11;
            if (r2.length == 0) goto L9;
            this.tlsVersions = (String[]) r2.clone();
            return this;
        L9:
            throw new IllegalArgumentException("At least one TLS version is required");
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder supportsTlsExtensions(boolean r2) {
            if (this.tls == false) goto L7;
            this.supportsTlsExtensions = r2;
            return this;
        L7:
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }
    }

    static {
        CipherSuite[] r1 = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};
        RESTRICTED_CIPHER_SUITES = r1;
        CipherSuite[] r2 = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        APPROVED_CIPHER_SUITES = r2;
        RESTRICTED_TLS = new Builder(true).cipherSuites(r1).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2}).supportsTlsExtensions(true).build();
        TlsVersion[] r0 = {TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0};
        tlsVersionsAll = r0;
        TlsVersion[] r3 = {TlsVersion.TLS_1_3, TlsVersion.TLS_1_2};
        tlsVersionsWithout1_1 = r3;
        Builder r5 = new Builder(true).cipherSuites(r2);
        if (TTConfigManager.inst().enableTls1_1() == true) goto L6;
        r0 = r3;
    L6:
        MODERN_TLS = r5.tlsVersions(r0).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = new Builder(true).cipherSuites(r2).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_0}).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    ConnectionSpec(Builder r2) {
        this.tls = r2.tls;
        this.cipherSuites = r2.cipherSuites;
        this.tlsVersions = r2.tlsVersions;
        this.supportsTlsExtensions = r2.supportsTlsExtensions;
    }

    public boolean isTls() {
        return this.tls;
    }

    @Nullable
    public List<CipherSuite> cipherSuites() {
        String[] r0 = this.cipherSuites;
        if (r0 != null) goto L7;
        return null;
    L7:
        return CipherSuite.forJavaNames(r0);
    }

    @Nullable
    public List<TlsVersion> tlsVersions() {
        String[] r0 = this.tlsVersions;
        if (r0 != null) goto L7;
        return null;
    L7:
        return TlsVersion.forJavaNames(r0);
    }

    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    void apply(SSLSocket r1, boolean r2) {
        ConnectionSpec r0 = supportedSpec(r1, r2);
        String[] r3 = r0.tlsVersions;
        if (r3 == null) goto L5;
        r1.setEnabledProtocols(r3);
    L5:
        String[] r4 = r0.cipherSuites;
        if (r4 == null) goto L9;
        r1.setEnabledCipherSuites(r4);
        return;
    }

    private ConnectionSpec supportedSpec(SSLSocket r5, boolean r6) {
        if (this.cipherSuites == null) goto L5;
        String[] r0 = Util.intersect(CipherSuite.ORDER_BY_NAME, r5.getEnabledCipherSuites(), this.cipherSuites);
    L7:
        if (this.tlsVersions == null) goto L9;
        String[] r1 = Util.intersect(Util.NATURAL_ORDER, r5.getEnabledProtocols(), this.tlsVersions);
    L10:
        String[] r7 = r5.getSupportedCipherSuites();
        int r2 = Util.indexOf(CipherSuite.ORDER_BY_NAME, r7, "TLS_FALLBACK_SCSV");
        if (r6 == false) goto L16;
        if (r2 == (-1)) goto L16;
        r0 = Util.concat(r0, r7[r2]);
    L16:
        return new Builder(this).cipherSuites(r0).tlsVersions(r1).build();
    L9:
        r1 = r5.getEnabledProtocols();
        goto L10
    L5:
        r0 = r5.getEnabledCipherSuites();
        goto L7
    }

    public boolean isCompatible(SSLSocket r5) {
        if (this.tls == true) goto L6;
        return false;
    L6:
        if (this.tlsVersions == null) goto L11;
        if (Util.nonEmptyIntersection(Util.NATURAL_ORDER, this.tlsVersions, r5.getEnabledProtocols()) == true) goto L11;
        return false;
    L11:
        if (this.cipherSuites != null) goto L13;
        return true;
    L13:
        if (Util.nonEmptyIntersection(CipherSuite.ORDER_BY_NAME, this.cipherSuites, r5.getEnabledCipherSuites()) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public boolean equals(@Nullable Object r5) {
        if ((r5 instanceof ConnectionSpec) == true) goto L6;
        return false;
    L6:
        if (r5 != this) goto L8;
        return true;
    L8:
        ConnectionSpec r6 = (ConnectionSpec) r5;
        boolean r2 = this.tls;
        if (r2 == r6.tls) goto L11;
        return false;
    L11:
        if (r2 == true) goto L13;
    L21:
        return true;
    L13:
        if (Arrays.equals(this.cipherSuites, r6.cipherSuites) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.tlsVersions, r6.tlsVersions) == true) goto L19;
        return false;
    L19:
        if (this.supportsTlsExtensions == r6.supportsTlsExtensions) goto L21;
        return false;
    }

    public int hashCode() {
        if (this.tls == true) goto L7;
        return 17;
    L7:
        return ((((527 + Arrays.hashCode(this.cipherSuites)) * 31) + Arrays.hashCode(this.tlsVersions)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
    }

    public String toString() {
        if (this.tls == true) goto L6;
        return "ConnectionSpec()";
    L6:
        String r1 = "[all enabled]";
        if (this.cipherSuites == null) goto L9;
        String r0 = cipherSuites().toString();
    L11:
        if (this.tlsVersions == null) goto L14;
        r1 = tlsVersions().toString();
    L14:
        return "ConnectionSpec(cipherSuites=" + r0 + ", tlsVersions=" + r1 + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
    L9:
        r0 = "[all enabled]";
        goto L11
    }
}
