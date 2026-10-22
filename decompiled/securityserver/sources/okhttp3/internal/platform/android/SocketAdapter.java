package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface SocketAdapter {

    @Metadata
    public static final class DefaultImpls {
        public static boolean matchesSocketFactory(@NotNull SocketAdapter r0, @NotNull SSLSocketFactory r1) {
            Intrinsics.f(r1, "sslSocketFactory");
            return false;
        }

        @Nullable
        public static X509TrustManager trustManager(@NotNull SocketAdapter r0, @NotNull SSLSocketFactory r1) {
            Intrinsics.f(r1, "sslSocketFactory");
            return null;
        }
    }

    void configureTlsExtensions(@NotNull SSLSocket r1, @Nullable String r2, @NotNull List<? extends Protocol> r3);

    @Nullable
    String getSelectedProtocol(@NotNull SSLSocket r1);

    boolean isSupported();

    boolean matchesSocket(@NotNull SSLSocket r1);

    boolean matchesSocketFactory(@NotNull SSLSocketFactory r1);

    @Nullable
    X509TrustManager trustManager(@NotNull SSLSocketFactory r1);
}
