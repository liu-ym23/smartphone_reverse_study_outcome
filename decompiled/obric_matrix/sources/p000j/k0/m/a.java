package p000j.k0.m;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f18114a;

    public a(e r1) {
        this.f18114a = r1;
    }

    private boolean c(X509Certificate r2, X509Certificate r3) {
        if (r2.getIssuerDN().equals(r3.getSubjectDN()) == true) goto L9;
        return false;
    L9:
        r2.verify(r3.getPublicKey());     // Catch: GeneralSecurityException -> L8
        return true;
    L8:
        return false;
    }

    @Override // p000j.k0.m.c
    public List<Certificate> a(List<Certificate> r7, String r8) {
        ArrayDeque r9 = new ArrayDeque(r7);
        ArrayList r10 = new ArrayList();
        r10.add(r9.removeFirst());
        int r0 = 0;
        boolean r1 = false;
    L4:
        if (r0 >= 9) goto L28;
        X509Certificate r2 = (X509Certificate) r10.get(r10.size() - 1);
        X509Certificate r4 = this.f18114a.a(r2);
        if (r4 != null) goto L8;
        Iterator r3 = r9.iterator();
    L18:
        if (r3.hasNext() == false) goto L23;
        X509Certificate r5 = (X509Certificate) r3.next();
        if (c(r2, r5) == false) goto L18;
        r3.remove();
        r10.add(r5);
    L22:
        r0 = r0 + 1;
        goto L4
    L23:
        if (r1 == false) goto L26;
        return r10;
    L26:
        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + r2);
    L8:
        if (r10.size() <= 1) goto L10;
    L11:
        r10.add(r4);
    L13:
        if (c(r4, r4) == true) goto L14;
        r1 = true;
        goto L22
    L14:
        return r10;
    L10:
        if (r2.equals(r4) == true) goto L13;
    L28:
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + r10);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if ((r3 instanceof a) == true) goto L8;
    L10:
        return false;
    L8:
        if (((a) r3).f18114a.equals(this.f18114a) == false) goto L10;
        return true;
    }

    public int hashCode() {
        return this.f18114a.hashCode();
    }
}
