package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes5.dex */
final class Jdk9Platform extends Platform {
    final Method getProtocolMethod;
    final Method setProtocolMethod;

    Jdk9Platform(Method r1, Method r2) {
        this.setProtocolMethod = r1;
        this.getProtocolMethod = r2;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r3, String r4, List<Protocol> r5) {
        SSLParameters r6 = r3.getSSLParameters();     // Catch: Throwable -> L4
        List<String> r7 = alpnProtocolNames(r5);     // Catch: Throwable -> L4
        this.setProtocolMethod.invoke(r6, new Object[]{r7.toArray(new String[r7.size()])});     // Catch: Throwable -> L4
        r3.setSSLParameters(r6);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw Util.assertionError("unable to set ssl parameters", e);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket r4) {
        String r3 = (String) this.getProtocolMethod.invoke(r4, new Object[0]);     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L13
        if (r3 == null) goto L9;
        if (r3.equals("") == true) goto L9;
        return r3;
    L9:
        return null;
    L10:
        e = move-exception;
        throw Util.assertionError("failed to get ALPN selected protocol", e);
    L13:
        e = move-exception;
        if ((e.getCause() instanceof UnsupportedOperationException) == false) goto L18;
        return null;
    L18:
        throw Util.assertionError("failed to get ALPN selected protocol", e);
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r1) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    public static Jdk9Platform buildIfSupported() {
        return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
    L4:
        return null;
    }
}
