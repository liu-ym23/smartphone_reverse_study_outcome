package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes5.dex */
public final class Handshake {
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final List<Certificate> peerCertificates;
    private final TlsVersion tlsVersion;

    private Handshake(TlsVersion r1, CipherSuite r2, List<Certificate> r3, List<Certificate> r4) {
        this.tlsVersion = r1;
        this.cipherSuite = r2;
        this.peerCertificates = r3;
        this.localCertificates = r4;
    }

    public static Handshake get(SSLSession r4) throws IOException {
        String r0 = r4.getCipherSuite();
        if (r0 == null) goto L30;
        if ("SSL_NULL_WITH_NULL_NULL".equals(r0) == true) goto L28;
        CipherSuite r1 = CipherSuite.forJavaName(r0);
        String r2 = r4.getProtocol();
        if (r2 == null) goto L26;
        if ("NONE".equals(r2) == true) goto L24;
        TlsVersion r3 = TlsVersion.forJavaName(r2);
        Certificate[] r5 = r4.getPeerCertificates();     // Catch: SSLPeerUnverifiedException -> L13
    L14:
        if (r5 == null) goto L16;
        List r6 = Util.immutableList(r5);
    L17:
        Certificate[] r7 = r4.getLocalCertificates();
        if (r7 == null) goto L20;
        List r8 = Util.immutableList(r7);
    L22:
        return new Handshake(r3, r1, r6, r8);
    L20:
        r8 = Collections.emptyList();
        goto L22
    L16:
        r6 = Collections.emptyList();
    L13:
        r5 = null;
        goto L14
    L24:
        throw new IOException("tlsVersion == NONE");
    L26:
        throw new IllegalStateException("tlsVersion == null");
    L28:
        throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    L30:
        throw new IllegalStateException("cipherSuite == null");
    }

    public static Handshake get(TlsVersion r1, CipherSuite r2, List<Certificate> r3, List<Certificate> r4) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L7;
        return new Handshake(r1, r2, Util.immutableList(r3), Util.immutableList(r4));
    L7:
        throw new NullPointerException("cipherSuite == null");
    L9:
        throw new NullPointerException("tlsVersion == null");
    }

    public TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public List<Certificate> peerCertificates() {
        return this.peerCertificates;
    }

    @Nullable
    public Principal peerPrincipal() {
        if (this.peerCertificates.isEmpty() == false) goto L7;
        return null;
    L7:
        return ((X509Certificate) this.peerCertificates.get(0)).getSubjectX500Principal();
    }

    public List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @Nullable
    public Principal localPrincipal() {
        if (this.localCertificates.isEmpty() == false) goto L7;
        return null;
    L7:
        return ((X509Certificate) this.localCertificates.get(0)).getSubjectX500Principal();
    }

    public boolean equals(@Nullable Object r4) {
        if ((r4 instanceof Handshake) == true) goto L5;
        return false;
    L5:
        Handshake r5 = (Handshake) r4;
        if (this.tlsVersion.equals(r5.tlsVersion) == true) goto L8;
        return false;
    L8:
        if (this.cipherSuite.equals(r5.cipherSuite) == true) goto L10;
        return false;
    L10:
        if (this.peerCertificates.equals(r5.peerCertificates) == true) goto L12;
        return false;
    L12:
        if (this.localCertificates.equals(r5.localCertificates) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + this.peerCertificates.hashCode()) * 31) + this.localCertificates.hashCode();
    }
}
