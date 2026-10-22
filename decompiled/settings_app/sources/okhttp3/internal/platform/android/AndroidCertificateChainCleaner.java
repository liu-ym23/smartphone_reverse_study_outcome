package okhttp3.internal.platform.android;

import android.icu.text.PluralRules;
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
import okhttp3.internal.tls.CertificateChainCleaner;

/* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManagerExtensions", "Landroid/net/http/X509TrustManagerExtensions;", "(Ljavax/net/ssl/X509TrustManager;Landroid/net/http/X509TrustManagerExtensions;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = null;
    private final X509TrustManager trustManager;
    private final X509TrustManagerExtensions x509TrustManagerExtensions;

    /* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final AndroidCertificateChainCleaner buildIfSupported(X509TrustManager r2) {
            Intrinsics.checkNotNullParameter(r2, "trustManager");
            X509TrustManagerExtensions r0 = new X509TrustManagerExtensions(r2);     // Catch: IllegalArgumentException -> L5
        L6:
            if (r0 != null) goto L8;
            return null;
        L8:
            return new AndroidCertificateChainCleaner(r2, r0);
        L5:
            X509TrustManagerExtensions r1 = (X509TrustManagerExtensions) null;
            r0 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AndroidCertificateChainCleaner(X509TrustManager r2, X509TrustManagerExtensions r3) {
        Intrinsics.checkNotNullParameter(r2, "trustManager");
        Intrinsics.checkNotNullParameter(r3, "x509TrustManagerExtensions");
        this.trustManager = r2;
        this.x509TrustManagerExtensions = r3;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public List<Certificate> clean(List<? extends Certificate> r2, String r3) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(r2, "chain");
        Intrinsics.checkNotNullParameter(r3, "hostname");
        Object[] r4 = r2.toArray(new X509Certificate[0]);
        if (r4 == null) goto L11;
        X509Certificate[] r5 = (X509Certificate[]) r4;
        List<X509Certificate> r1 = this.x509TrustManagerExtensions.checkServerTrusted(r5, "RSA", r3);     // Catch: CertificateException -> L7
        Intrinsics.checkNotNullExpressionValue(r1, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");     // Catch: CertificateException -> L7
        return r1;
    L7:
        e = move-exception;
        SSLPeerUnverifiedException r6 = new SSLPeerUnverifiedException(e.getMessage());
        r6.initCause(e);
        throw r6;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public boolean equals(Object r2) {
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
