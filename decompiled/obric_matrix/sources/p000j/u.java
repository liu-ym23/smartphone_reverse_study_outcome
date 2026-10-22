package p000j;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i0 f18193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f18194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Certificate> f18195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Certificate> f18196d;

    private u(i0 r1, i r2, List<Certificate> r3, List<Certificate> r4) {
        this.f18193a = r1;
        this.f18194b = r2;
        this.f18195c = r3;
        this.f18196d = r4;
    }

    public static u b(SSLSession r4) {
        String r0 = r4.getCipherSuite();
        if (r0 == null) goto L30;
        if ("SSL_NULL_WITH_NULL_NULL".equals(r0) == true) goto L28;
        i r1 = i.a(r0);
        String r2 = r4.getProtocol();
        if (r2 == null) goto L26;
        if ("NONE".equals(r2) == true) goto L24;
        i0 r3 = i0.a(r2);
        Certificate[] r5 = r4.getPeerCertificates();     // Catch: SSLPeerUnverifiedException -> L13
    L14:
        if (r5 == null) goto L16;
        List r6 = c.u(r5);
    L17:
        Certificate[] r7 = r4.getLocalCertificates();
        if (r7 == null) goto L20;
        List r8 = c.u(r7);
    L22:
        return new u(r3, r1, r6, r8);
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

    public i a() {
        return this.f18194b;
    }

    public List<Certificate> c() {
        return this.f18195c;
    }

    public i0 d() {
        return this.f18193a;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof u) == true) goto L5;
        return false;
    L5:
        u r5 = (u) r4;
        if (this.f18193a.equals(r5.f18193a) == true) goto L8;
        return false;
    L8:
        if (this.f18194b.equals(r5.f18194b) == true) goto L10;
        return false;
    L10:
        if (this.f18195c.equals(r5.f18195c) == true) goto L12;
        return false;
    L12:
        if (this.f18196d.equals(r5.f18196d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f18193a.hashCode()) * 31) + this.f18194b.hashCode()) * 31) + this.f18195c.hashCode()) * 31) + this.f18196d.hashCode();
    }
}
