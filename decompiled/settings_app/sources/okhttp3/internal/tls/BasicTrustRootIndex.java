package okhttp3.internal.tls;

import android.icu.text.PluralRules;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicTrustRootIndex.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/tls/BasicTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "caCerts", "", "Ljava/security/cert/X509Certificate;", "([Ljava/security/cert/X509Certificate;)V", "subjectToCaCerts", "", "Ljavax/security/auth/x500/X500Principal;", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "findByIssuerAndSignature", "cert", "hashCode", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasicTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(X509Certificate... r7) {
        Intrinsics.checkNotNullParameter(r7, "caCerts");
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        X509Certificate r3 = r7[r2];
        r2 = r2 + 1;
        X500Principal r4 = r3.getSubjectX500Principal();
        Intrinsics.checkNotNullExpressionValue(r4, "caCert.subjectX500Principal");
        Object r5 = r0.get(r4);
        if (r5 != null) goto L7;
        r5 = (Set) new LinkedHashSet();
        r0.put(r4, r5);
    L7:
        ((Set) r5).add(r3);
        goto L3
    L8:
        this.subjectToCaCerts = r0;
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public X509Certificate findByIssuerAndSignature(X509Certificate r4) {
        Intrinsics.checkNotNullParameter(r4, "cert");
        X500Principal r0 = r4.getIssuerX500Principal();
        Set<X509Certificate> r3 = this.subjectToCaCerts.get(r0);
        Object r1 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L15;
        Object r2 = r5.next();
        r4.verify(((X509Certificate) r2).getPublicKey());     // Catch: Exception -> L11
        boolean r6 = true;
    L12:
        if (r6 == false) goto L7;
        r1 = r2;
    L11:
        r6 = false;
    L15:
        return (X509Certificate) r1;
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof BasicTrustRootIndex) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(((BasicTrustRootIndex) r2).subjectToCaCerts, this.subjectToCaCerts) == false) goto L8;
        goto L8
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
