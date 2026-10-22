package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = null;
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = "com.android.org.conscrypt";
        L6:
            return r0.buildIfSupported(r1);
        }

        @Nullable
        public final SocketAdapter buildIfSupported(@NotNull String r4) {
            Intrinsics.f(r4, "packageName");
            return new StandardAndroidSocketAdapter(Class.forName(r4.concat(".OpenSSLSocketImpl")), Class.forName(r4.concat(".OpenSSLSocketFactoryImpl")), Class.forName(r4.concat(".SSLParametersImpl")));
        L5:
            e = move-exception;
            Platform.Companion.get().log("unable to load android socket classes", 5, e);
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StandardAndroidSocketAdapter(@NotNull Class<? super SSLSocket> r2, @NotNull Class<? super SSLSocketFactory> r3, @NotNull Class<?> r4) {
        Intrinsics.f(r2, "sslSocketClass");
        Intrinsics.f(r3, "sslSocketFactoryClass");
        Intrinsics.f(r4, "paramClass");
        super(r2);
        this.sslSocketFactoryClass = r3;
        this.paramClass = r4;
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@NotNull SSLSocketFactory r2) {
        Intrinsics.f(r2, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(r2);
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory r2) {
        Intrinsics.f(r2, "sslSocketFactory");
        Object r1 = Util.readFieldOrNull(r2, this.paramClass, "sslParameters");
        Intrinsics.c(r1);
        X509TrustManager r3 = (X509TrustManager) Util.readFieldOrNull(r1, X509TrustManager.class, "x509TrustManager");
        if (r3 == null) goto L6;
        return r3;
    L6:
        return (X509TrustManager) Util.readFieldOrNull(r1, X509TrustManager.class, "trustManager");
    }
}
