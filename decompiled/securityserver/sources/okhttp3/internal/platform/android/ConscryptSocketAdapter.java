package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.Platform;
import org.conscrypt.Conscrypt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ConscryptSocketAdapter implements SocketAdapter {
    public static final Companion Companion = null;

    @NotNull
    private static final DeferredSocketAdapter.Factory factory = null;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DeferredSocketAdapter.Factory getFactory() {
            return ConscryptSocketAdapter.access$getFactory$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        factory = new ConscryptSocketAdapter$Companion$factory$1();
    }

    public ConscryptSocketAdapter() {
    }

    public static final /* synthetic */ DeferredSocketAdapter.Factory access$getFactory$cp() {
        return factory;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@NotNull SSLSocket r1, @Nullable String r2, @NotNull List<? extends Protocol> r3) {
        Intrinsics.f(r1, "sslSocket");
        Intrinsics.f(r3, "protocols");
        if (matchesSocket(r1) == false) goto L9;
        Conscrypt.setUseSessionTickets(r1, true);
        Object[] r0 = Platform.Companion.alpnProtocolNames(r3).toArray(new String[0]);
        if (r0 == null) goto L8;
        Conscrypt.setApplicationProtocols(r1, (String[]) r0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r2) {
        Intrinsics.f(r2, "sslSocket");
        if (matchesSocket(r2) == true) goto L7;
        return null;
    L7:
        return Conscrypt.getApplicationProtocol(r2);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return ConscryptPlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket r1) {
        Intrinsics.f(r1, "sslSocket");
        return Conscrypt.isConscrypt(r1);
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
