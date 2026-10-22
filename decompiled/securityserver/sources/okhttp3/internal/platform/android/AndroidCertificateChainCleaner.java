package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.tls.CertificateChainCleaner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = null;
    private final X509TrustManager trustManager;
    private final X509TrustManagerExtensions x509TrustManagerExtensions;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @SuppressSignatureCheck
        @Nullable
        public final AndroidCertificateChainCleaner buildIfSupported(@NotNull X509TrustManager r2) {
            Intrinsics.f(r2, "trustManager");
            X509TrustManagerExtensions r0 = new X509TrustManagerExtensions(r2);     // Catch: IllegalArgumentException -> L5
        L6:
            if (r0 != null) goto L8;
            return null;
        L8:
            return new AndroidCertificateChainCleaner(r2, r0);
        L5:
            r0 = null;
            goto L6
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AndroidCertificateChainCleaner(@NotNull X509TrustManager r2, @NotNull X509TrustManagerExtensions r3) {
        Intrinsics.f(r2, "trustManager");
        Intrinsics.f(r3, "x509TrustManagerExtensions");
        this.trustManager = r2;
        this.x509TrustManagerExtensions = r3;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    @SuppressSignatureCheck
    @NotNull
    public List<Certificate> clean(@NotNull List<? extends Certificate> r2, @NotNull String r3) {
        Intrinsics.f(r2, "chain");
        Intrinsics.f(r3, "hostname");
        Object[] r4 = r2.toArray(new X509Certificate[0]);
        if (r4 == null) goto L11;
        X509Certificate[] r5 = (X509Certificate[]) r4;
        List<X509Certificate> r1 = this.x509TrustManagerExtensions.checkServerTrusted(r5, "RSA", r3);     // Catch: CertificateException -> L7
        Intrinsics.e(r1, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");     // Catch: CertificateException -> L7
        return r1;
    L7:
        e = move-exception;
        SSLPeerUnverifiedException r6 = new SSLPeerUnverifiedException(e.getMessage());
        r6.initCause(e);
        throw r6;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof AndroidCertificateChainCleaner) == true) goto L5;
    L7:
        return false;
    L5:
        if (((AndroidCertificateChainCleaner) r2).trustManager != this.trustManager) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.trustManager);
    }
}
