package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.security.NetworkSecurityPolicy;
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
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@SuppressSignatureCheck
@Metadata
public final class Android10Platform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
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
            return new Android10Platform();
        }

        public final boolean isSupported() {
            return Android10Platform.access$isSupported$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        isSupported = Platform.Companion.isAndroid();
    }

    public Android10Platform() {
        int r6 = 0;
        SocketAdapter[] r5 = {Android10SocketAdapter.Companion.buildIfSupported(), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())};
        ArrayList r1 = new ArrayList();
    L3:
        if (r6 >= 4) goto L8;
        SocketAdapter r2 = r5[r6];
        if (r2 == null) goto L7;
        r1.add(r2);
    L7:
        r6 = r6 + 1;
        goto L3
    L8:
        ArrayList r0 = new ArrayList();
        Iterator r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r3.next();
        if (((SocketAdapter) r4).isSupported() == false) goto L10;
        r0.add(r4);
        goto L10
    L14:
        this.socketAdapters = r0;
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
    public void configureTlsExtensions(@NotNull SSLSocket r3, @Nullable String r4, @NotNull List<? extends Protocol> r5) {
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
    @SuppressLint({"NewApi"})
    public boolean isCleartextTrafficPermitted(@NotNull String r1) {
        Intrinsics.f(r1, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r1);
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
