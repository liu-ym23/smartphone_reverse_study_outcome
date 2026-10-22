package p000j.k0.m;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<X500Principal, Set<X509Certificate>> f18115a;

    public b(X509Certificate... r7) {
        this.f18115a = new LinkedHashMap();
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        X509Certificate r2 = r7[r1];
        X500Principal r3 = r2.getSubjectX500Principal();
        Set<X509Certificate> r4 = this.f18115a.get(r3);
        if (r4 != null) goto L7;
        r4 = new LinkedHashSet(1);
        this.f18115a.put(r3, r4);
    L7:
        r4.add(r2);
        r1 = r1 + 1;
        goto L3
    }

    @Override // p000j.k0.m.e
    public X509Certificate a(X509Certificate r4) {
        X500Principal r0 = r4.getIssuerX500Principal();
        Set<X509Certificate> r3 = this.f18115a.get(r0);
        if (r3 != null) goto L5;
        return null;
    L5:
        Iterator<X509Certificate> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        X509Certificate r1 = r5.next();
        r4.verify(r1.getPublicKey());     // Catch: Exception -> L12
        return r1;
    L11:
        return null;
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if ((r3 instanceof b) == true) goto L8;
    L10:
        return false;
    L8:
        if (((b) r3).f18115a.equals(this.f18115a) == false) goto L10;
        return true;
    }

    public int hashCode() {
        return this.f18115a.hashCode();
    }
}
