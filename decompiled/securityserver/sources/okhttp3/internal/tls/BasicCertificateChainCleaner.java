package okhttp3.internal.tls;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = null;
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BasicCertificateChainCleaner(@NotNull TrustRootIndex r2) {
        Intrinsics.f(r2, "trustRootIndex");
        this.trustRootIndex = r2;
    }

    private final boolean verifySignature(X509Certificate r3, X509Certificate r4) {
        if ((!Intrinsics.a(r3.getIssuerDN(), r4.getSubjectDN())) == false) goto L9;
        return false;
    L9:
        r3.verify(r4.getPublicKey());     // Catch: GeneralSecurityException -> L7
        return true;
    L8:
        return false;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    @NotNull
    public List<Certificate> clean(@NotNull List<? extends Certificate> r8, @NotNull String r9) {
        Intrinsics.f(r8, "chain");
        Intrinsics.f(r9, "hostname");
        ArrayDeque r10 = new ArrayDeque(r8);
        ArrayList r11 = new ArrayList();
        Object r0 = r10.removeFirst();
        Intrinsics.e(r0, "queue.removeFirst()");
        r11.add(r0);
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= 9) goto L36;
        Object r3 = r11.get(r11.size() - 1);
        if (r3 == null) goto L34;
        X509Certificate r4 = (X509Certificate) r3;
        X509Certificate r5 = this.trustRootIndex.findByIssuerAndSignature(r4);
        if (r5 != null) goto L10;
        Iterator r6 = r10.iterator();
        Intrinsics.e(r6, "queue.iterator()");
    L20:
        if (r6.hasNext() == false) goto L29;
        Object r7 = r6.next();
        if (r7 == null) goto L28;
        X509Certificate r12 = (X509Certificate) r7;
        if (verifySignature(r4, r12) == false) goto L20;
        r6.remove();
        r11.add(r12);
    L26:
        r1 = r1 + 1;
        goto L4
    L28:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L29:
        if (r2 == false) goto L32;
        return r11;
    L32:
        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + r4);
    L10:
        if (r11.size() <= 1) goto L12;
    L13:
        r11.add(r5);
    L15:
        if (verifySignature(r5, r5) == true) goto L16;
        r2 = true;
        goto L26
    L16:
        return r11;
    L12:
        if ((!r4.equals(r5)) == false) goto L15;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L36:
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + r11);
    }

    public boolean equals(@Nullable Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if ((r3 instanceof BasicCertificateChainCleaner) == true) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.a(((BasicCertificateChainCleaner) r3).trustRootIndex, this.trustRootIndex) == false) goto L10;
        return true;
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
