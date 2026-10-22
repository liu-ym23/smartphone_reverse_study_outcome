package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BasicTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(@NotNull X509Certificate... r7) {
        Intrinsics.f(r7, "caCerts");
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        X509Certificate r3 = r7[r2];
        X500Principal r4 = r3.getSubjectX500Principal();
        Intrinsics.e(r4, "caCert.subjectX500Principal");
        Object r5 = r0.get(r4);
        if (r5 != null) goto L7;
        r5 = new LinkedHashSet();
        r0.put(r4, r5);
    L7:
        ((Set) r5).add(r3);
        r2 = r2 + 1;
        goto L3
    L8:
        this.subjectToCaCerts = r0;
    }

    public boolean equals(@Nullable Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof BasicTrustRootIndex) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.a(((BasicTrustRootIndex) r2).subjectToCaCerts, this.subjectToCaCerts) == false) goto L8;
        goto L8
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    @Nullable
    public X509Certificate findByIssuerAndSignature(@NotNull X509Certificate r4) {
        Intrinsics.f(r4, "cert");
        X500Principal r0 = r4.getIssuerX500Principal();
        Set<X509Certificate> r3 = this.subjectToCaCerts.get(r0);
        Object r1 = null;
        if (r3 == null) goto L17;
        Iterator<T> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        Object r2 = r5.next();
        r4.verify(((X509Certificate) r2).getPublicKey());     // Catch: Exception -> L12
        r1 = r2;
    L11:
        return (X509Certificate) r1;
    L17:
        return null;
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
