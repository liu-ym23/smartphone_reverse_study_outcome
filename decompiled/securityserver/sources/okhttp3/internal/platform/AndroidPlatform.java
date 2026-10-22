package okhttp3.internal.platform;

import android.security.NetworkSecurityPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@SuppressSignatureCheck
@Metadata
public final class AndroidPlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final CloseGuard closeGuard;
    private final List<SocketAdapter> socketAdapters;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Platform buildIfSupported() {
            if (isSupported() == true) goto L7;
            return null;
        L7:
            return new AndroidPlatform();
        }

        public final boolean isSupported() {
            return AndroidPlatform.access$isSupported$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class CustomTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        public CustomTrustRootIndex(@NotNull X509TrustManager r2, @NotNull Method r3) {
            Intrinsics.f(r2, "trustManager");
            Intrinsics.f(r3, "findByIssuerAndSignatureMethod");
            this.trustManager = r2;
            this.findByIssuerAndSignatureMethod = r3;
        }

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        public static /* synthetic */ CustomTrustRootIndex copy$default(CustomTrustRootIndex r0, X509TrustManager r1, Method r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.trustManager;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.findByIssuerAndSignatureMethod;
        L9:
            return r0.copy(r1, r2);
        }

        @NotNull
        public final CustomTrustRootIndex copy(@NotNull X509TrustManager r1, @NotNull Method r2) {
            Intrinsics.f(r1, "trustManager");
            Intrinsics.f(r2, "findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(r1, r2);
        }

        public boolean equals(@Nullable Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof CustomTrustRootIndex) == false) goto L10;
            CustomTrustRootIndex r4 = (CustomTrustRootIndex) r3;
            if (Intrinsics.a(this.trustManager, r4.trustManager) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.a(this.findByIssuerAndSignatureMethod, r4.findByIssuerAndSignatureMethod) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        @Nullable
        public X509Certificate findByIssuerAndSignature(@NotNull X509Certificate r2) {
            Intrinsics.f(r2, "cert");
            Object r1 = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[]{r2});     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L10
            if (r1 == null) goto L9;
            return ((TrustAnchor) r1).getTrustedCert();
        L9:
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L10
        L6:
            e = move-exception;
            throw new AssertionError("unable to get issues and signature", e);
        L10:
            return null;
        }

        public int hashCode() {
            X509TrustManager r0 = this.trustManager;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Method r4 = this.findByIssuerAndSignatureMethod;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        @NotNull
        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ")";
        }
    }

    static {
        Companion = new Companion(null);
        Platform.Companion.isAndroid();
        isSupported = false;
    }

    public AndroidPlatform() {
        int r7 = 0;
        SocketAdapter[] r6 = {StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, null, 1, null), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())};
        ArrayList r0 = new ArrayList();
    L3:
        if (r7 >= 4) goto L8;
        SocketAdapter r1 = r6[r7];
        if (r1 == null) goto L7;
        r0.add(r1);
    L7:
        r7 = r7 + 1;
        goto L3
    L8:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r3.next();
        if (((SocketAdapter) r4).isSupported() == false) goto L10;
        r2.add(r4);
        goto L10
    L14:
        this.socketAdapters = r2;
        this.closeGuard = CloseGuard.Companion.get();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager r2) {
        Intrinsics.f(r2, "trustManager");
        AndroidCertificateChainCleaner r0 = AndroidCertificateChainCleaner.Companion.buildIfSupported(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.buildCertificateChainCleaner(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    @NotNull
    public TrustRootIndex buildTrustRootIndex(@NotNull X509TrustManager r4) {
        Intrinsics.f(r4, "trustManager");
        Method r0 = r4.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L5
        Intrinsics.e(r0, "method");     // Catch: NoSuchMethodException -> L5
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L5
        return new CustomTrustRootIndex(r4, r0);
    L6:
        return super.buildTrustRootIndex(r4);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket r3, @Nullable String r4, @NotNull List<Protocol> r5) {
        Intrinsics.f(r3, "sslSocket");
        Intrinsics.f(r5, "protocols");
        Iterator<T> r2 = this.socketAdapters.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r0 = r2.next();
        if (((SocketAdapter) r0).matchesSocket(r3) == false) goto L4;
    L9:
        SocketAdapter r1 = (SocketAdapter) r0;
        if (r1 == null) goto L16;
        r1.configureTlsExtensions(r3, r4, r5);
        return;
    L16:
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(@NotNull Socket r1, @NotNull InetSocketAddress r2, int r3) {
        Intrinsics.f(r1, "socket");
        Intrinsics.f(r2, "address");
        r1.connect(r2, r3);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r4) {
        Intrinsics.f(r4, "sslSocket");
        Iterator<T> r3 = this.socketAdapters.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r0 = r3.next();
        if (((SocketAdapter) r0).matchesSocket(r4) == false) goto L4;
    L9:
        SocketAdapter r1 = (SocketAdapter) r0;
        if (r1 != null) goto L12;
        return null;
    L12:
        return r1.getSelectedProtocol(r4);
    L8:
        r0 = null;
        goto L9
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public Object getStackTraceForCloseable(@NotNull String r2) {
        Intrinsics.f(r2, "closer");
        return this.closeGuard.createAndOpen(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(@NotNull String r1) {
        Intrinsics.f(r1, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r1);
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(@NotNull String r7, @Nullable Object r8) {
        Intrinsics.f(r7, "message");
        if (this.closeGuard.warnIfOpen(r8) == true) goto L6;
        Platform.log$default(this, r7, 5, null, 4, null);
        return;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory r4) {
        Intrinsics.f(r4, "sslSocketFactory");
        Iterator<T> r3 = this.socketAdapters.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r0 = r3.next();
        if (((SocketAdapter) r0).matchesSocketFactory(r4) == false) goto L4;
    L9:
        SocketAdapter r1 = (SocketAdapter) r0;
        if (r1 != null) goto L12;
        return null;
    L12:
        return r1.trustManager(r4);
    L8:
        r0 = null;
        goto L9
    }
}
