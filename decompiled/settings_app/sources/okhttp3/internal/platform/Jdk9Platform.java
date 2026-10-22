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

/* JADX INFO: compiled from: Jdk9Platform.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0011\u0010\t\u001a\r\u0012\t\u0012\u00070\u000b¢\u0006\u0002\b\f0\nH\u0017J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/platform/Jdk9Platform;", "Lokhttp3/internal/platform/Platform;", "()V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class Jdk9Platform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isAvailable = false;

    /* JADX INFO: compiled from: Jdk9Platform.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/Jdk9Platform$Companion;", "", "()V", "isAvailable", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Jdk9Platform;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean isAvailable() {
            return Jdk9Platform.access$isAvailable$cp();
        }

        public final Jdk9Platform buildIfSupported() {
            if (isAvailable() == true) goto L7;
            return null;
        L7:
            return new Jdk9Platform();
        }
    }

    public Jdk9Platform() {
    }

    public static final /* synthetic */ boolean access$isAvailable$cp() {
        return isAvailable;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r1, String r2, List<Protocol> r3) {
        Intrinsics.checkNotNullParameter(r1, "sslSocket");
        Intrinsics.checkNotNullParameter(r3, "protocols");
        SSLParameters r0 = r1.getSSLParameters();
        Object[] r4 = Platform.Companion.alpnProtocolNames(r3).toArray(new String[0]);
        if (r4 == null) goto L7;
        r0.setApplicationProtocols((String[]) r4);
        r1.setSSLParameters(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r2) {
        Intrinsics.checkNotNullParameter(r2, "sslSocket");
        String r3 = r2.getApplicationProtocol();     // Catch: UnsupportedOperationException -> L11
        if (r3 != null) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        return null;
    L10:
        return r3;
    L6:
        r0 = Intrinsics.areEqual(r3, "");     // Catch: UnsupportedOperationException -> L11
    L15:
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r1) {
        Intrinsics.checkNotNullParameter(r1, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Integer r1 = null;
        Companion = new Companion(0 == true ? 1 : 0);
        String r0 = System.getProperty("java.specification.version");
        if (r0 == null) goto L6;
        r1 = StringsKt.toIntOrNull(r0);
    L6:
        boolean r2 = true;
        if (r1 != null) goto L9;
        SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);     // Catch: NoSuchMethodException -> L15
    L13:
        isAvailable = r2;
        return;
    L11:
        r2 = false;
        goto L13
    L9:
        if (r1.intValue() < 9) goto L11;
        goto L11
    }
}
