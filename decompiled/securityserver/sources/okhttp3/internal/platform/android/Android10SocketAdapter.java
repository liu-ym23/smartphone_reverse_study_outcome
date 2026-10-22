package okhttp3.internal.platform.android;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@SuppressSignatureCheck
@Metadata
@SuppressLint({"NewApi"})
public final class Android10SocketAdapter implements SocketAdapter {
    public static final Companion Companion = null;

    @SuppressSignatureCheck
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final SocketAdapter buildIfSupported() {
            if (isSupported() == true) goto L7;
            return null;
        L7:
            return new Android10SocketAdapter();
        }

        public final boolean isSupported() {
            return Platform.Companion.isAndroid();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Android10SocketAdapter() {
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(@NotNull SSLSocket r1, @Nullable String r2, @NotNull List<? extends Protocol> r3) {
        Intrinsics.f(r1, "sslSocket");
        Intrinsics.f(r3, "protocols");
        SSLSockets.setUseSessionTickets(r1, true);     // Catch: IllegalArgumentException -> L7
        SSLParameters r0 = r1.getSSLParameters();     // Catch: IllegalArgumentException -> L7
        Intrinsics.e(r0, "sslParameters");     // Catch: IllegalArgumentException -> L7
        Object[] r4 = Platform.Companion.alpnProtocolNames(r3).toArray(new String[0]);     // Catch: IllegalArgumentException -> L7
        if (r4 == null) goto L10;
        r0.setApplicationProtocols((String[]) r4);     // Catch: IllegalArgumentException -> L7
        r1.setSSLParameters(r0);     // Catch: IllegalArgumentException -> L7
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: IllegalArgumentException -> L7
    L7:
        e = move-exception;
        throw new IOException("Android internal error", e);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @SuppressLint({"NewApi"})
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r1) {
        Intrinsics.f(r1, "sslSocket");
        String r0 = r1.getApplicationProtocol();
        if (r0 != null) goto L6;
    L10:
        return null;
    L6:
        if (r0.hashCode() == 0) goto L9;
        return r0;
    L9:
        if (r0.equals("") == true) goto L10;
        return r0;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket r1) {
        Intrinsics.f(r1, "sslSocket");
        return SSLSockets.isSupportedSocket(r1);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@NotNull SSLSocketFactory r2) {
        Intrinsics.f(r2, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, r2);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory r2) {
        Intrinsics.f(r2, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.trustManager(this, r2);
    }
}
