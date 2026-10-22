package okhttp3.internal.platform;

import java.security.KeyStore;
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
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* JADX INFO: compiled from: BouncyCastlePlatform.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokhttp3/internal/platform/BouncyCastlePlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "platformTrustManager", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BouncyCastlePlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final Provider provider;

    /* JADX INFO: compiled from: BouncyCastlePlatform.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/BouncyCastlePlatform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/BouncyCastlePlatform;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean isSupported() {
            return BouncyCastlePlatform.access$isSupported$cp();
        }

        public final BouncyCastlePlatform buildIfSupported() {
            DefaultConstructorMarker r0 = null;
            if (isSupported() == true) goto L5;
            return null;
        L5:
            return new BouncyCastlePlatform(r0);
        }
    }

    public /* synthetic */ BouncyCastlePlatform(DefaultConstructorMarker r1) {
        this();
    }

    private BouncyCastlePlatform() {
        this.provider = new BouncyCastleJsseProvider();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext newSSLContext() {
        SSLContext r1 = SSLContext.getInstance("TLS", this.provider);
        Intrinsics.checkNotNullExpressionValue(r1, "getInstance(\"TLS\", provider)");
        return r1;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory r3 = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        KeyStore r1 = (KeyStore) null;
        r3.init(null);
        TrustManager[] r4 = r3.getTrustManagers();
        Intrinsics.checkNotNull(r4);
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
        Intrinsics.checkNotNullExpressionValue(r6, "toString(this)");
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected default trust managers: ", r6).toString());
    L5:
        if ((r4[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r1) {
        Intrinsics.checkNotNullParameter(r1, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r2, String r3, List<Protocol> r4) {
        Intrinsics.checkNotNullParameter(r2, "sslSocket");
        Intrinsics.checkNotNullParameter(r4, "protocols");
        if ((r2 instanceof BCSSLSocket) == false) goto L9;
        BCSSLSocket r5 = (BCSSLSocket) r2;
        BCSSLParameters r1 = r5.getParameters();
        Object[] r6 = Platform.Companion.alpnProtocolNames(r4).toArray(new String[0]);
        if (r6 == null) goto L8;
        r1.setApplicationProtocols((String[]) r6);
        r5.setParameters(r1);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L9:
        super.configureTlsExtensions(r2, r3, r4);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r2) {
        Intrinsics.checkNotNullParameter(r2, "sslSocket");
        if ((r2 instanceof BCSSLSocket) == false) goto L11;
        String r1 = ((BCSSLSocket) r2).getApplicationProtocol();
        if (r1 != null) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L12;
        return null;
    L12:
        return r1;
    L7:
        r3 = Intrinsics.areEqual(r1, "");
        goto L8
    L11:
        return super.getSelectedProtocol(r2);
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        boolean r1 = false;
        Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, r0.getClass().getClassLoader());     // Catch: ClassNotFoundException -> L7
        r1 = true;
    L5:
        isSupported = r1;
    }
}
