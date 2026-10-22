package okhttp3.internal.platform;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.security.KeyStore;
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

/* JADX INFO: compiled from: ConscryptPlatform.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "newSslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "sslSocketFactory", "Companion", "DisabledHostnameVerifier", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConscryptPlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final Provider provider;

    /* JADX INFO: compiled from: ConscryptPlatform.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "atLeastVersion", "major", "", "minor", CloudControlInf.PATCH, "buildIfSupported", "Lokhttp3/internal/platform/ConscryptPlatform;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean isSupported() {
            return ConscryptPlatform.access$isSupported$cp();
        }

        public final ConscryptPlatform buildIfSupported() {
            DefaultConstructorMarker r0 = null;
            if (isSupported() == true) goto L5;
            return null;
        L5:
            return new ConscryptPlatform(r0);
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
            if (r3.major() == r4) goto L10;
            if (r3.major() <= r4) goto L8;
            return true;
        L8:
            return false;
        L10:
            if (r3.minor() == r5) goto L17;
            if (r3.minor() <= r5) goto L15;
            return true;
        L15:
            return false;
        L17:
            if (r3.patch() < r6) goto L20;
            return true;
        L20:
            return false;
        }
    }

    /* JADX INFO: compiled from: ConscryptPlatform.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$DisabledHostnameVerifier;", "Lorg/conscrypt/ConscryptHostnameVerifier;", "()V", "verify", "", "certs", "", "Ljava/security/cert/X509Certificate;", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {
        public static final DisabledHostnameVerifier INSTANCE = null;

        static {
            INSTANCE = new DisabledHostnameVerifier();
        }

        public final boolean verify(String r1, SSLSession r2) {
            return true;
        }

        public boolean verify(X509Certificate[] r1, String r2, SSLSession r3) {
            return true;
        }

        private DisabledHostnameVerifier() {
        }
    }

    public /* synthetic */ ConscryptPlatform(DefaultConstructorMarker r1) {
        this();
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r1) {
        Intrinsics.checkNotNullParameter(r1, "sslSocketFactory");
        return null;
    }

    private ConscryptPlatform() {
        Provider r0 = Conscrypt.newProvider();
        Intrinsics.checkNotNullExpressionValue(r0, "newProvider()");
        this.provider = r0;
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
        TrustManagerFactory r3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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
        X509TrustManager r6 = (X509TrustManager) r5;
        Conscrypt.setHostnameVerifier(r6, DisabledHostnameVerifier.INSTANCE);
        return r6;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    L15:
        String r7 = Arrays.toString(r4);
        Intrinsics.checkNotNullExpressionValue(r7, "toString(this)");
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected default trust managers: ", r7).toString());
    L5:
        if ((r4[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r2, String r3, List<Protocol> r4) {
        Intrinsics.checkNotNullParameter(r2, "sslSocket");
        Intrinsics.checkNotNullParameter(r4, "protocols");
        if (Conscrypt.isConscrypt(r2) == false) goto L9;
        Conscrypt.setUseSessionTickets(r2, true);
        Object[] r1 = Platform.Companion.alpnProtocolNames(r4).toArray(new String[0]);
        if (r1 == null) goto L8;
        Conscrypt.setApplicationProtocols(r2, (String[]) r1);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L9:
        super.configureTlsExtensions(r2, r3, r4);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r2) {
        Intrinsics.checkNotNullParameter(r2, "sslSocket");
        if (Conscrypt.isConscrypt(r2) == false) goto L6;
        return Conscrypt.getApplicationProtocol(r2);
    L6:
        return super.getSelectedProtocol(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLSocketFactory newSslSocketFactory(X509TrustManager r3) {
        Intrinsics.checkNotNullParameter(r3, "trustManager");
        SSLContext r2 = newSSLContext();
        r2.init(null, new TrustManager[]{r3}, null);
        SSLSocketFactory r4 = r2.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(r4, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return r4;
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
}
