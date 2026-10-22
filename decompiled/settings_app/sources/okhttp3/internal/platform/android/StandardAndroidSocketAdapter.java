package okhttp3.internal.platform.android;

import com.android.settings.NotificationDisplayDetailsActivity;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: StandardAndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB1\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter;", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketFactoryClass", "Ljavax/net/ssl/SSLSocketFactory;", "paramClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "matchesSocketFactory", "", "sslSocketFactory", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = null;
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    /* JADX INFO: compiled from: StandardAndroidSocketAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = "com.android.org.conscrypt";
        L6:
            return r0.buildIfSupported(r1);
        }

        public final SocketAdapter buildIfSupported(String r4) {
            Intrinsics.checkNotNullParameter(r4, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
            Class<?> r3 = Class.forName(Intrinsics.stringPlus(r4, ".OpenSSLSocketImpl"));     // Catch: Exception -> L12
            if (r3 == null) goto L11;
            Class<?> r0 = Class.forName(Intrinsics.stringPlus(r4, ".OpenSSLSocketFactoryImpl"));     // Catch: Exception -> L12
            if (r0 == null) goto L9;
            Class<?> r5 = Class.forName(Intrinsics.stringPlus(r4, ".SSLParametersImpl"));     // Catch: Exception -> L12
            Intrinsics.checkNotNullExpressionValue(r5, "paramsClass");     // Catch: Exception -> L12
            return new StandardAndroidSocketAdapter(r3, r0, r5);
        L9:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");     // Catch: Exception -> L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");     // Catch: Exception -> L12
        L12:
            e = move-exception;
            Platform.Companion.get().log("unable to load android socket classes", 5, e);
            SocketAdapter r6 = (SocketAdapter) null;
            return null;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StandardAndroidSocketAdapter(Class<? super SSLSocket> r2, Class<? super SSLSocketFactory> r3, Class<?> r4) {
        Intrinsics.checkNotNullParameter(r2, "sslSocketClass");
        Intrinsics.checkNotNullParameter(r3, "sslSocketFactoryClass");
        Intrinsics.checkNotNullParameter(r4, "paramClass");
        super(r2);
        this.sslSocketFactoryClass = r3;
        this.paramClass = r4;
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(r2);
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "sslSocketFactory");
        Object r1 = Util.readFieldOrNull(r2, this.paramClass, "sslParameters");
        Intrinsics.checkNotNull(r1);
        X509TrustManager r3 = (X509TrustManager) Util.readFieldOrNull(r1, X509TrustManager.class, "x509TrustManager");
        if (r3 == null) goto L5;
        return r3;
    L5:
        return (X509TrustManager) Util.readFieldOrNull(r1, X509TrustManager.class, "trustManager");
    }
}
