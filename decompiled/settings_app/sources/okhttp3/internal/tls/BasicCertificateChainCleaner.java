package okhttp3.internal.tls;

import android.icu.text.PluralRules;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "verifySignature", "toVerify", "Ljava/security/cert/X509Certificate;", "signingCert", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = null;
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    /* JADX INFO: compiled from: BasicCertificateChainCleaner.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner$Companion;", "", "()V", "MAX_SIGNERS", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BasicCertificateChainCleaner(TrustRootIndex r2) {
        Intrinsics.checkNotNullParameter(r2, "trustRootIndex");
        this.trustRootIndex = r2;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public List<Certificate> clean(List<? extends Certificate> r7, String r8) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(r7, "chain");
        Intrinsics.checkNotNullParameter(r8, "hostname");
        ArrayDeque r9 = new ArrayDeque(r7);
        ArrayList r10 = new ArrayList();
        Object r0 = r9.removeFirst();
        Intrinsics.checkNotNullExpressionValue(r0, "queue.removeFirst()");
        r10.add(r0);
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= 9) goto L31;
        r1 = r1 + 1;
        X509Certificate r3 = (X509Certificate) r10.get(r10.size() - 1);
        X509Certificate r4 = this.trustRootIndex.findByIssuerAndSignature(r3);
        if (r4 != null) goto L8;
        Iterator r5 = r9.iterator();
        Intrinsics.checkNotNullExpressionValue(r5, "queue.iterator()");
    L18:
        if (r5.hasNext() == false) goto L26;
        Object r6 = r5.next();
        if (r6 == null) goto L25;
        X509Certificate r11 = (X509Certificate) r6;
        if (verifySignature(r3, r11) == false) goto L18;
        r5.remove();
        r10.add(r11);
        goto L4
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L26:
        if (r2 == false) goto L29;
        return r10;
    L29:
        throw new SSLPeerUnverifiedException(Intrinsics.stringPlus("Failed to find a trusted cert that signed ", r3));
    L8:
        if (r10.size() <= 1) goto L10;
    L11:
        r10.add(r4);
    L13:
        if (verifySignature(r4, r4) == true) goto L14;
        r2 = true;
        goto L4
    L14:
        return r10;
    L10:
        if (Intrinsics.areEqual(r3, r4) == true) goto L13;
    L31:
        throw new SSLPeerUnverifiedException(Intrinsics.stringPlus("Certificate chain too long: ", r10));
    }

    private final boolean verifySignature(X509Certificate r2, X509Certificate r3) {
        if (Intrinsics.areEqual(r2.getIssuerDN(), r3.getSubjectDN()) == true) goto L9;
        return false;
    L9:
        r2.verify(r3.getPublicKey());     // Catch: GeneralSecurityException -> L8
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if ((r3 instanceof BasicCertificateChainCleaner) == true) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(((BasicCertificateChainCleaner) r3).trustRootIndex, this.trustRootIndex) == false) goto L10;
        return true;
    }
}
