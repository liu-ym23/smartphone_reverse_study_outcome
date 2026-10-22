package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class CertificateChainCleaner {
    public static final Companion Companion = null;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CertificateChainCleaner get(@NotNull X509TrustManager r1) {
            Intrinsics.f(r1, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(r1);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @NotNull
        public final CertificateChainCleaner get(@NotNull X509Certificate... r3) {
            Intrinsics.f(r3, "caCerts");
            return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(r3, r3.length)));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CertificateChainCleaner() {
    }

    @NotNull
    public abstract List<Certificate> clean(@NotNull List<? extends Certificate> r1, @NotNull String r2);
}
