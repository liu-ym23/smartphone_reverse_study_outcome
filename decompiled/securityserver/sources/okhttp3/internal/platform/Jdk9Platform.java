package okhttp3.internal.platform;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class Jdk9Platform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isAvailable = false;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Jdk9Platform buildIfSupported() {
            if (isAvailable() == true) goto L7;
            return null;
        L7:
            return new Jdk9Platform();
        }

        public final boolean isAvailable() {
            return Jdk9Platform.access$isAvailable$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        String r0 = System.getProperty("java.specification.version");
        if (r0 == null) goto L5;
        Integer r1 = StringsKt.I(r0);
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
        SSLSocket.class.getMethod("getApplicationProtocol", null);     // Catch: NoSuchMethodException -> L15
    L10:
        r2 = true;
    L13:
        isAvailable = r2;
        return;
    L9:
        if (r1.intValue() < 9) goto L13;
    L5:
        r1 = null;
        goto L6
    }

    public Jdk9Platform() {
    }

    public static final /* synthetic */ boolean access$isAvailable$cp() {
        return isAvailable;
    }

    @Override // okhttp3.internal.platform.Platform
    @SuppressSignatureCheck
    public void configureTlsExtensions(@NotNull SSLSocket r1, @Nullable String r2, @NotNull List<Protocol> r3) {
        Intrinsics.f(r1, "sslSocket");
        Intrinsics.f(r3, "protocols");
        SSLParameters r0 = r1.getSSLParameters();
        List<String> r4 = Platform.Companion.alpnProtocolNames(r3);
        Intrinsics.e(r0, "sslParameters");
        Object[] r5 = r4.toArray(new String[0]);
        if (r5 == null) goto L7;
        r0.setApplicationProtocols((String[]) r5);
        r1.setSSLParameters(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // okhttp3.internal.platform.Platform
    @SuppressSignatureCheck
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r2) {
        Intrinsics.f(r2, "sslSocket");
        String r3 = r2.getApplicationProtocol();     // Catch: UnsupportedOperationException -> L14
        if (r3 != null) goto L7;
        return null;
    L7:
        if (r3.hashCode() != 0) goto L13;
        if (r3.equals("") == false) goto L13;
        return null;
    L13:
        return r3;
    L19:
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory r1) {
        Intrinsics.f(r1, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
