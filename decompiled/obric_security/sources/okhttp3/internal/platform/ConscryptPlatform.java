package okhttp3.internal.platform;

import java.io.IOException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes5.dex */
public class ConscryptPlatform extends Platform {
    private ConscryptPlatform() {
    }

    private Provider getProvider() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(SSLSocketFactory r2) {
        if (Conscrypt.isConscrypt(r2) == false) goto L5;
        Object r1 = readFieldOrNull(r2, Object.class, "sslParameters");     // Catch: Exception -> L12
        if (r1 == null) goto L10;
        return (X509TrustManager) readFieldOrNull(r1, X509TrustManager.class, "x509TrustManager");
    L10:
        return null;
    L12:
        e = move-exception;
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
    L5:
        return super.trustManager(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r2, String r3, List<Protocol> r4) throws IOException {
        if (Conscrypt.isConscrypt(r2) == false) goto L7;
        if (r3 == null) goto L6;
        Conscrypt.setUseSessionTickets(r2, true);
        Conscrypt.setHostname(r2, r3);
    L6:
        Conscrypt.setApplicationProtocols(r2, (String[]) Platform.alpnProtocolNames(r4).toArray(new String[0]));
        return;
    L7:
        super.configureTlsExtensions(r2, r3, r4);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket r2) {
        if (Conscrypt.isConscrypt(r2) == false) goto L7;
        return Conscrypt.getApplicationProtocol(r2);
    L7:
        return super.getSelectedProtocol(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext getSSLContext() {
        return SSLContext.getInstance("TLSv1.3", getProvider());
    L4:
        e = move-exception;
        return SSLContext.getInstance("TLS", getProvider());
    L8:
        throw new IllegalStateException("No TLS provider", e);
    }

    public static ConscryptPlatform buildIfSupported() {
        Class.forName("org.conscrypt.Conscrypt");     // Catch: ClassNotFoundException -> L8
        if (Conscrypt.isAvailable() == true) goto L6;
        return null;
    L6:
        return new ConscryptPlatform();
    L8:
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureSslSocketFactory(SSLSocketFactory r1) {
        if (Conscrypt.isConscrypt(r1) == false) goto L6;
        Conscrypt.setUseEngineSocket(r1, true);
        return;
    }
}
