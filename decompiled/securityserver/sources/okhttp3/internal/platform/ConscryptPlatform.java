package okhttp3.internal.platform;

import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ConscryptPlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final Provider provider;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ boolean atLeastVersion$default(Companion r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r5 & 4) == 0) goto L9;
            r4 = 0;
        L9:
            return r1.atLeastVersion(r2, r3, r4);
        }

        public final boolean atLeastVersion(int r4, int r5, int r6) {
            Conscrypt.Version r3 = Conscrypt.version();
            if (r3.major() == r4) goto L9;
            if (r3.major() > r4) goto L7;
            return false;
        L7:
            return true;
        L9:
            if (r3.minor() == r5) goto L15;
            if (r3.minor() > r5) goto L13;
            return false;
        L13:
            return true;
        L15:
            if (r3.patch() >= r6) goto L17;
            return false;
        L17:
            return true;
        }

        @Nullable
        public final ConscryptPlatform buildIfSupported() {
            DefaultConstructorMarker r0 = null;
            if (isSupported() == true) goto L5;
            return null;
        L5:
            return new ConscryptPlatform(r0);
        }

        public final boolean isSupported() {
            return ConscryptPlatform.access$isSupported$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {
        public static final DisabledHostnameVerifier INSTANCE = null;

        static {
            INSTANCE = new DisabledHostnameVerifier();
        }

        private DisabledHostnameVerifier() {
        }

        public final boolean verify(@Nullable String r1, @Nullable SSLSession r2) {
            return true;
        }

        public boolean verify(@Nullable X509Certificate[] r1, @Nullable String r2, @Nullable SSLSession r3) {
            return true;
        }
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        boolean r1 = false;
        Class.forName("org.conscrypt.Conscrypt$Version", false, r0.getClass().getClassLoader());     // Catch: Throwable -> L10
        if (Conscrypt.isAvailable() == false) goto L8;
        if (r0.atLeastVersion(2, 1, 0) == false) goto L8;
        r1 = true;
    L8:
        isSupported = r1;
    }

    private ConscryptPlatform() {
        Provider r0 = Conscrypt.newProvider();
        Intrinsics.e(r0, "Conscrypt.newProvider()");
        this.provider = r0;
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket r2, @Nullable String r3, @NotNull List<Protocol> r4) {
        Intrinsics.f(r2, "sslSocket");
        Intrinsics.f(r4, "protocols");
        if (Conscrypt.isConscrypt(r2) == false) goto L9;
        Conscrypt.setUseSessionTickets(r2, true);
        Object[] r1 = Platform.Companion.alpnProtocolNames(r4).toArray(new String[0]);
        if (r1 == null) goto L8;
        Conscrypt.setApplicationProtocols(r2, (String[]) r1);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        super.configureTlsExtensions(r2, r3, r4);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r2) {
        Intrinsics.f(r2, "sslSocket");
        if (Conscrypt.isConscrypt(r2) == false) goto L6;
        return Conscrypt.getApplicationProtocol(r2);
    L6:
        return super.getSelectedProtocol(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    @NotNull
    public SSLContext newSSLContext() {
        SSLContext r1 = SSLContext.getInstance("TLS", this.provider);
        Intrinsics.e(r1, "SSLContext.getInstance(\"TLS\", provider)");
        return r1;
    }

    @Override // okhttp3.internal.platform.Platform
    @NotNull
    public SSLSocketFactory newSslSocketFactory(@NotNull X509TrustManager r4) {
        Intrinsics.f(r4, "trustManager");
        SSLContext r3 = newSSLContext();
        r3.init(null, new TrustManager[]{r4}, null);
        SSLSocketFactory r5 = r3.getSocketFactory();
        Intrinsics.e(r5, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return r5;
    }

    @Override // okhttp3.internal.platform.Platform
    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory r3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r3.init(null);
        TrustManager[] r4 = r3.getTrustManagers();
        Intrinsics.c(r4);
        boolean r2 = true;
        if (r4.length == 1) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == false) goto L15;
        TrustManager r5 = r4[0];
        if (r5 == null) goto L14;
        X509TrustManager r6 = (X509TrustManager) r5;
        Conscrypt.setHostnameVerifier(r6, DisabledHostnameVerifier.INSTANCE);
        return r6;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    L15:
        String r7 = Arrays.toString(r4);
        Intrinsics.e(r7, "java.util.Arrays.toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(r7).toString());
    L5:
        if ((r4[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory r1) {
        Intrinsics.f(r1, "sslSocketFactory");
        return null;
    }

    public /* synthetic */ ConscryptPlatform(DefaultConstructorMarker r1) {
        this();
    }
}
