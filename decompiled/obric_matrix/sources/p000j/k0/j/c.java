package p000j.k0.j;

import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import p000j.b0;

/* JADX INFO: loaded from: classes2.dex */
public class c extends g {
    private c() {
    }

    public static c x() {
        Class.forName("org.conscrypt.Conscrypt");     // Catch: ClassNotFoundException -> L8
        if (Conscrypt.isAvailable() == true) goto L6;
        return null;
    L6:
        return new c();
    L8:
        return null;
    }

    private Provider y() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // p000j.k0.j.g
    public void g(SSLSocketFactory r1) {
        if (Conscrypt.isConscrypt(r1) == false) goto L6;
        Conscrypt.setUseEngineSocket(r1, true);
        return;
    }

    @Override // p000j.k0.j.g
    public void h(SSLSocket r2, String r3, List<b0> r4) {
        if (Conscrypt.isConscrypt(r2) == false) goto L7;
        if (r3 == null) goto L6;
        Conscrypt.setUseSessionTickets(r2, true);
        Conscrypt.setHostname(r2, r3);
    L6:
        Conscrypt.setApplicationProtocols(r2, (String[]) g.b(r4).toArray(new String[0]));
        return;
    L7:
        super.h(r2, r3, r4);
    }

    @Override // p000j.k0.j.g
    public SSLContext n() {
        return SSLContext.getInstance("TLSv1.3", y());
    L4:
        e = move-exception;
        return SSLContext.getInstance("TLS", y());
    L8:
        throw new IllegalStateException("No TLS provider", e);
    }

    @Override // p000j.k0.j.g
    public String o(SSLSocket r2) {
        if (Conscrypt.isConscrypt(r2) == false) goto L7;
        return Conscrypt.getApplicationProtocol(r2);
    L7:
        return super.o(r2);
    }

    @Override // p000j.k0.j.g
    public X509TrustManager w(SSLSocketFactory r2) {
        if (Conscrypt.isConscrypt(r2) == false) goto L5;
        Object r1 = g.v(r2, Object.class, "sslParameters");     // Catch: Exception -> L12
        if (r1 == null) goto L10;
        return (X509TrustManager) g.v(r1, X509TrustManager.class, "x509TrustManager");
    L10:
        return null;
    L12:
        e = move-exception;
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
    L5:
        return super.w(r2);
    }
}
