package okhttp3.internal.platform;

import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OpenJSSEPlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final Provider provider;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final OpenJSSEPlatform buildIfSupported() {
            DefaultConstructorMarker r0 = null;
            if (isSupported() == true) goto L5;
            return null;
        L5:
            return new OpenJSSEPlatform(r0);
        }

        public final boolean isSupported() {
            return OpenJSSEPlatform.access$isSupported$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        boolean r1 = false;
        Class.forName("org.openjsse.net.ssl.OpenJSSE", false, r0.getClass().getClassLoader());     // Catch: ClassNotFoundException -> L7
        r1 = true;
    L5:
        isSupported = r1;
    }

    private OpenJSSEPlatform() {
        this.provider = new OpenJSSE();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket r2, @Nullable String r3, @NotNull List<Protocol> r4) {
        Intrinsics.f(r2, "sslSocket");
        Intrinsics.f(r4, "protocols");
        super.configureTlsExtensions(r2, r3, r4);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r2) {
        Intrinsics.f(r2, "sslSocket");
        return super.getSelectedProtocol(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    @NotNull
    public SSLContext newSSLContext() {
        SSLContext r1 = SSLContext.getInstance("TLSv1.3", this.provider);
        Intrinsics.e(r1, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return r1;
    }

    @Override // okhttp3.internal.platform.Platform
    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory r3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.provider);
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
        return (X509TrustManager) r5;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    L15:
        String r6 = Arrays.toString(r4);
        Intrinsics.e(r6, "java.util.Arrays.toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(r6).toString());
    L5:
        if ((r4[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory r1) {
        Intrinsics.f(r1, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }

    public /* synthetic */ OpenJSSEPlatform(DefaultConstructorMarker r1) {
        this();
    }
}
