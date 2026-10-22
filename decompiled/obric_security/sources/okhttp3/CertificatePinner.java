package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = null;

    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins;

        public Builder() {
            this.pins = new ArrayList();
        }

        public Builder add(String r6, String... r7) {
            if (r6 == null) goto L8;
            int r0 = r7.length;
            int r1 = 0;
        L4:
            if (r1 >= r0) goto L6;
            String r2 = r7[r1];
            this.pins.add(new Pin(r6, r2));
            r1 = r1 + 1;
            goto L4
        L6:
            return this;
        L8:
            throw new NullPointerException("pattern == null");
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), null);
        }
    }

    static final class Pin {
        private static final String WILDCARD = "*.";
        final String canonicalHostname;
        final ByteString hash;
        final String hashAlgorithm;
        final String pattern;

        Pin(String r3, String r4) {
            this.pattern = r3;
            if (r3.startsWith(WILDCARD) == false) goto L5;
            String r5 = HttpUrl.get("http://" + r3.substring(2)).host();
        L6:
            this.canonicalHostname = r5;
            if (r4.startsWith("sha1/") == false) goto L10;
            this.hashAlgorithm = "sha1/";
            this.hash = ByteString.decodeBase64(r4.substring(5));
        L13:
            if (this.hash == null) goto L16;
            return;
        L16:
            throw new IllegalArgumentException("pins must be base64: " + r4);
        L10:
            if (r4.startsWith("sha256/") == false) goto L18;
            this.hashAlgorithm = "sha256/";
            this.hash = ByteString.decodeBase64(r4.substring(7));
            goto L13
        L18:
            throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + r4);
        L5:
            r5 = HttpUrl.get("http://" + r3).host();
            goto L6
        }

        boolean matches(String r11) {
            if (this.pattern.startsWith(WILDCARD) == false) goto L12;
            int r0 = r11.indexOf(46);
            if (((r11.length() - r0) - 1) != this.canonicalHostname.length()) goto L9;
            String r7 = this.canonicalHostname;
            if (r11.regionMatches(false, r0 + 1, r7, 0, r7.length()) == false) goto L9;
            return true;
        L9:
            return false;
        L12:
            return r11.equals(this.canonicalHostname);
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof Pin) == false) goto L11;
            Pin r4 = (Pin) r3;
            if (this.pattern.equals(r4.pattern) == false) goto L11;
            if (this.hashAlgorithm.equals(r4.hashAlgorithm) == false) goto L11;
            if (this.hash.equals(r4.hash) == false) goto L11;
            return true;
        L11:
            return false;
        }

        public int hashCode() {
            return ((((527 + this.pattern.hashCode()) * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    static {
        DEFAULT = new Builder().build();
    }

    CertificatePinner(Set<Pin> r1, @Nullable CertificateChainCleaner r2) {
        this.pins = r1;
        this.certificateChainCleaner = r2;
    }

    public boolean equals(@Nullable Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if ((r4 instanceof CertificatePinner) == false) goto L12;
        CertificatePinner r5 = (CertificatePinner) r4;
        if (Util.equal(this.certificateChainCleaner, r5.certificateChainCleaner) == false) goto L12;
        if (this.pins.equals(r5.pins) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner r0 = this.certificateChainCleaner;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.pins.hashCode();
    L5:
        r1 = 0;
        goto L7
    }

    public void check(String r12, List<Certificate> r13) throws SSLPeerUnverifiedException {
        List<Pin> r0 = findMatchingPins(r12);
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        CertificateChainCleaner r11 = this.certificateChainCleaner;
        if (r11 == null) goto L8;
        r13 = r11.clean(r13, r12);
    L8:
        int r14 = r13.size();
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= r14) goto L30;
        X509Certificate r3 = (X509Certificate) r13.get(r2);
        int r4 = r0.size();
        ByteString r5 = null;
        int r7 = 0;
        ByteString r6 = null;
    L11:
        if (r7 >= r4) goto L29;
        Pin r8 = r0.get(r7);
        if (r8.hashAlgorithm.equals("sha256/") == false) goto L20;
        if (r5 != null) goto L17;
        r5 = sha256(r3);
    L17:
        if (r8.hash.equals(r5) == false) goto L26;
        return;
    L26:
        r7 = r7 + 1;
        goto L11
    L20:
        if (r8.hashAlgorithm.equals("sha1/") == false) goto L28;
        if (r6 != null) goto L24;
        r6 = sha1(r3);
    L24:
        if (r8.hash.equals(r6) == false) goto L26;
        return;
    L28:
        throw new AssertionError("unsupported hashAlgorithm: " + r8.hashAlgorithm);
    L29:
        r2 = r2 + 1;
        goto L9
    L30:
        StringBuilder r15 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int r9 = r13.size();
        int r10 = 0;
    L32:
        if (r10 >= r9) goto L34;
        X509Certificate r16 = (X509Certificate) r13.get(r10);
        r15.append("\n    ").append(pin(r16)).append(": ").append(r16.getSubjectDN().getName());
        r10 = r10 + 1;
        goto L32
    L34:
        r15.append("\n  Pinned certificates for ").append(r12).append(":");
        int r17 = r0.size();
    L35:
        if (r1 >= r17) goto L38;
        r15.append("\n    ").append(r0.get(r1));
        r1 = r1 + 1;
        goto L35
    L38:
        throw new SSLPeerUnverifiedException(r15.toString());
    }

    public void check(String r1, Certificate... r2) throws SSLPeerUnverifiedException {
        check(r1, Arrays.asList(r2));
    }

    List<Pin> findMatchingPins(String r4) {
        List<Pin> r0 = Collections.emptyList();
        Iterator<Pin> r3 = this.pins.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Pin r1 = r3.next();
        if (r1.matches(r4) == false) goto L4;
        if (r0.isEmpty() == false) goto L10;
        r0 = new ArrayList();
    L10:
        r0.add(r1);
        goto L4
    L11:
        return r0;
    }

    CertificatePinner withCertificateChainCleaner(@Nullable CertificateChainCleaner r2) {
        if (Util.equal(this.certificateChainCleaner, r2) == false) goto L6;
        return this;
    L6:
        return new CertificatePinner(this.pins, r2);
    }

    public static String pin(Certificate r2) {
        if ((r2 instanceof X509Certificate) == false) goto L7;
        return "sha256/" + sha256((X509Certificate) r2).base64();
    L7:
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString sha1(X509Certificate r0) {
        return ByteString.of(r0.getPublicKey().getEncoded()).sha1();
    }

    static ByteString sha256(X509Certificate r0) {
        return ByteString.of(r0.getPublicKey().getEncoded()).sha256();
    }
}
