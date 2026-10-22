package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.Platform;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BouncyCastleSocketAdapter implements SocketAdapter {
    public static final Companion Companion = null;

    @NotNull
    private static final DeferredSocketAdapter.Factory factory = null;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DeferredSocketAdapter.Factory getFactory() {
            return BouncyCastleSocketAdapter.access$getFactory$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        factory = new BouncyCastleSocketAdapter$Companion$factory$1();
    }

    public BouncyCastleSocketAdapter() {
    }

    public static final /* synthetic */ DeferredSocketAdapter.Factory access$getFactory$cp() {
        return factory;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@NotNull SSLSocket r1, @Nullable String r2, @NotNull List<? extends Protocol> r3) {
        Intrinsics.f(r1, "sslSocket");
        Intrinsics.f(r3, "protocols");
        if (matchesSocket(r1) == false) goto L9;
        BCSSLSocket r4 = (BCSSLSocket) r1;
        BCSSLParameters r0 = r4.getParameters();
        Intrinsics.e(r0, "sslParameters");
        Object[] r5 = Platform.Companion.alpnProtocolNames(r3).toArray(new String[0]);
        if (r5 == null) goto L8;
        r0.setApplicationProtocols((String[]) r5);
        r4.setParameters(r0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r1) {
        Intrinsics.f(r1, "sslSocket");
        String r0 = ((BCSSLSocket) r1).getApplicationProtocol();
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
        return BouncyCastlePlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket r1) {
        Intrinsics.f(r1, "sslSocket");
        return false;
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
