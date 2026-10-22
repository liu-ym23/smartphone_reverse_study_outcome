package p000j.k0.j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import p000j.b0;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
final class d extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Method f18091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Method f18092d;

    d(Method r1, Method r2) {
        this.f18091c = r1;
        this.f18092d = r2;
    }

    public static d x() {
        return new d(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
    L4:
        return null;
    }

    @Override // p000j.k0.j.g
    public void h(SSLSocket r4, String r5, List<b0> r6) {
        SSLParameters r7 = r4.getSSLParameters();     // Catch: Throwable -> L4
        List<String> r8 = g.b(r6);     // Catch: Throwable -> L4
        this.f18091c.invoke(r7, new Object[]{r8.toArray(new String[r8.size()])});     // Catch: Throwable -> L4
        r4.setSSLParameters(r7);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw c.b("unable to set ssl parameters", e);
    }

    @Override // p000j.k0.j.g
    public String o(SSLSocket r4) {
        String r3 = (String) this.f18092d.invoke(r4, new Object[0]);     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L13
        if (r3 == null) goto L9;
        if (r3.equals("") == true) goto L9;
        return r3;
    L9:
        return null;
    L10:
        e = move-exception;
        throw c.b("failed to get ALPN selected protocol", e);
    L13:
        e = move-exception;
        if ((e.getCause() instanceof UnsupportedOperationException) == false) goto L18;
        return null;
    L18:
        throw c.b("failed to get ALPN selected protocol", e);
    }

    @Override // p000j.k0.j.g
    public X509TrustManager w(SSLSocketFactory r1) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
