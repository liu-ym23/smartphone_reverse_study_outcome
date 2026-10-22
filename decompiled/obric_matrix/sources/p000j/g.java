package p000j;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import k.h;
import p000j.k0.m.c;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f17746c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<b> f17747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f17748b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b> f17749a;

        public a() {
            this.f17749a = new ArrayList();
        }

        public g a() {
            return new g(new LinkedHashSet(this.f17749a), null);
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f17750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f17751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f17752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final h f17753d;

        boolean a(String r11) {
            if (this.f17750a.startsWith("*.") == false) goto L12;
            int r0 = r11.indexOf(46);
            if (((r11.length() - r0) - 1) != this.f17751b.length()) goto L9;
            String r7 = this.f17751b;
            if (r11.regionMatches(false, r0 + 1, r7, 0, r7.length()) == false) goto L9;
            return true;
        L9:
            return false;
        L12:
            return r11.equals(this.f17751b);
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof b) == false) goto L11;
            b r4 = (b) r3;
            if (this.f17750a.equals(r4.f17750a) == false) goto L11;
            if (this.f17752c.equals(r4.f17752c) == false) goto L11;
            if (this.f17753d.equals(r4.f17753d) == false) goto L11;
            return true;
        L11:
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f17750a.hashCode()) * 31) + this.f17752c.hashCode()) * 31) + this.f17753d.hashCode();
        }

        public String toString() {
            return this.f17752c + this.f17753d.a();
        }
    }

    static {
        f17746c = new a().a();
    }

    g(Set<b> r1, c r2) {
        this.f17747a = r1;
        this.f17748b = r2;
    }

    public static String c(Certificate r2) {
        if ((r2 instanceof X509Certificate) == false) goto L7;
        return "sha256/" + e((X509Certificate) r2).a();
    L7:
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static h d(X509Certificate r0) {
        return h.u(r0.getPublicKey().getEncoded()).A();
    }

    static h e(X509Certificate r0) {
        return h.u(r0.getPublicKey().getEncoded()).B();
    }

    public void a(String r12, List<Certificate> r13) {
        List<b> r0 = b(r12);
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        c r11 = this.f17748b;
        if (r11 == null) goto L8;
        r13 = r11.a(r13, r12);
    L8:
        int r14 = r13.size();
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= r14) goto L30;
        X509Certificate r3 = (X509Certificate) r13.get(r2);
        int r4 = r0.size();
        h r5 = null;
        int r7 = 0;
        h r6 = null;
    L11:
        if (r7 >= r4) goto L29;
        b r8 = r0.get(r7);
        if (r8.f17752c.equals("sha256/") == false) goto L20;
        if (r5 != null) goto L17;
        r5 = e(r3);
    L17:
        if (r8.f17753d.equals(r5) == false) goto L26;
        return;
    L26:
        r7 = r7 + 1;
        goto L11
    L20:
        if (r8.f17752c.equals("sha1/") == false) goto L28;
        if (r6 != null) goto L24;
        r6 = d(r3);
    L24:
        if (r8.f17753d.equals(r6) == false) goto L26;
        return;
    L28:
        throw new AssertionError("unsupported hashAlgorithm: " + r8.f17752c);
    L29:
        r2 = r2 + 1;
        goto L9
    L30:
        StringBuilder r15 = new StringBuilder();
        r15.append("Certificate pinning failure!");
        r15.append("\n  Peer certificate chain:");
        int r9 = r13.size();
        int r10 = 0;
    L32:
        if (r10 >= r9) goto L34;
        X509Certificate r16 = (X509Certificate) r13.get(r10);
        r15.append("\n    ");
        r15.append(c(r16));
        r15.append(": ");
        r15.append(r16.getSubjectDN().getName());
        r10 = r10 + 1;
        goto L32
    L34:
        r15.append("\n  Pinned certificates for ");
        r15.append(r12);
        r15.append(":");
        int r17 = r0.size();
    L35:
        if (r1 >= r17) goto L38;
        b r18 = r0.get(r1);
        r15.append("\n    ");
        r15.append(r18);
        r1 = r1 + 1;
        goto L35
    L38:
        throw new SSLPeerUnverifiedException(r15.toString());
    }

    List<b> b(String r4) {
        List<b> r0 = Collections.emptyList();
        Iterator<b> r3 = this.f17747a.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        b r1 = r3.next();
        if (r1.a(r4) == false) goto L4;
        if (r0.isEmpty() == false) goto L10;
        r0 = new ArrayList();
    L10:
        r0.add(r1);
        goto L4
    L11:
        return r0;
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if ((r4 instanceof g) == false) goto L12;
        g r5 = (g) r4;
        if (p000j.k0.c.q(this.f17748b, r5.f17748b) == false) goto L12;
        if (this.f17747a.equals(r5.f17747a) == false) goto L12;
        return true;
    L12:
        return false;
    }

    g f(c r2) {
        if (p000j.k0.c.q(this.f17748b, r2) == false) goto L6;
        return this;
    L6:
        return new g(this.f17747a, r2);
    }

    public int hashCode() {
        c r0 = this.f17748b;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.f17747a.hashCode();
    L5:
        r1 = 0;
        goto L7
    }
}
