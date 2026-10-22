package okhttp3.internal.platform;

import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes5.dex */
class Android10Platform extends AndroidPlatform {
    Android10Platform(Class<?> r7) {
        super(r7, null, null, null, null);
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r1, String r2, List<Protocol> r3) throws IOException {
        enableSessionTickets(r1);     // Catch: IllegalArgumentException -> L4
        SSLParameters r0 = r1.getSSLParameters();     // Catch: IllegalArgumentException -> L4
        r0.setApplicationProtocols((String[]) Platform.alpnProtocolNames(r3).toArray(new String[0]));     // Catch: IllegalArgumentException -> L4
        r1.setSSLParameters(r0);     // Catch: IllegalArgumentException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException("Android internal error", e);
    }

    private void enableSessionTickets(SSLSocket r1) {
        if (SSLSockets.isSupportedSocket(r1) == false) goto L6;
        SSLSockets.setUseSessionTickets(r1, true);
        return;
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket r1) {
        String r0 = r1.getApplicationProtocol();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == true) goto L10;
        return r0;
    L10:
        return null;
    }

    @Nullable
    public static Platform buildIfSupported() {
        if (Platform.isAndroid() == true) goto L11;
        return null;
    L11:
        if (getSdkInt() < 29) goto L9;
        return new Android10Platform(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
    L9:
        return null;
    }
}
