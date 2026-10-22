package okhttp3.internal.platform;

import com.bytedance.common.wschannel.WsConstants;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class Platform {
    public static final Companion Companion = null;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger = null;
    private static volatile Platform platform;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Platform access$findPlatform(Companion r0) {
            return r0.findPlatform();
        }

        private final Platform findAndroidPlatform() {
            AndroidLog.INSTANCE.enable();
            Platform r0 = Android10Platform.Companion.buildIfSupported();
            if (r0 != null) goto L7;
            Platform r1 = AndroidPlatform.Companion.buildIfSupported();
            Intrinsics.c(r1);
            return r1;
        L7:
            return r0;
        }

        private final Platform findJvmPlatform() {
            if (isConscryptPreferred() == false) goto L8;
            ConscryptPlatform r0 = ConscryptPlatform.Companion.buildIfSupported();
            if (r0 == null) goto L8;
            return r0;
        L8:
            if (isBouncyCastlePreferred() == false) goto L13;
            BouncyCastlePlatform r1 = BouncyCastlePlatform.Companion.buildIfSupported();
            if (r1 == null) goto L13;
            return r1;
        L13:
            if (isOpenJSSEPreferred() == false) goto L17;
            OpenJSSEPlatform r2 = OpenJSSEPlatform.Companion.buildIfSupported();
            if (r2 == null) goto L17;
            return r2;
        L17:
            Jdk9Platform r3 = Jdk9Platform.Companion.buildIfSupported();
            if (r3 == null) goto L20;
            return r3;
        L20:
            Platform r4 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            if (r4 == null) goto L24;
            return r4;
        L24:
            return new Platform();
        }

        private final Platform findPlatform() {
            if (isAndroid() == false) goto L6;
            return findAndroidPlatform();
        L6:
            return findJvmPlatform();
        }

        private final boolean isBouncyCastlePreferred() {
            Provider r1 = Security.getProviders()[0];
            Intrinsics.e(r1, "Security.getProviders()[0]");
            return "BC".equals(r1.getName());
        }

        private final boolean isConscryptPreferred() {
            Provider r1 = Security.getProviders()[0];
            Intrinsics.e(r1, "Security.getProviders()[0]");
            return "Conscrypt".equals(r1.getName());
        }

        private final boolean isOpenJSSEPreferred() {
            Provider r1 = Security.getProviders()[0];
            Intrinsics.e(r1, "Security.getProviders()[0]");
            return "OpenJSSE".equals(r1.getName());
        }

        public static /* synthetic */ void resetForTests$default(Companion r0, Platform r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = r0.findPlatform();
        L5:
            r0.resetForTests(r1);
        }

        @NotNull
        public final List<String> alpnProtocolNames(@NotNull List<? extends Protocol> r4) {
            Intrinsics.f(r4, "protocols");
            ArrayList r3 = new ArrayList();
            Iterator<T> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            Object r0 = r5.next();
            if (((Protocol) r0) == Protocol.HTTP_1_0) goto L4;
            r3.add(r0);
            goto L4
        L8:
            ArrayList r6 = new ArrayList(CollectionsKt.e(r3, 10));
            Iterator r7 = r3.iterator();
        L10:
            if (r7.hasNext() == false) goto L12;
            r6.add(((Protocol) r7.next()).toString());
            goto L10
        L12:
            return r6;
        }

        @NotNull
        public final byte[] concatLengthPrefixed(@NotNull List<? extends Protocol> r3) {
            Intrinsics.f(r3, "protocols");
            Buffer r0 = new Buffer();
            Iterator<String> r2 = alpnProtocolNames(r3).iterator();
        L4:
            if (r2.hasNext() == false) goto L7;
            String r4 = r2.next();
            r0.writeByte(r4.length());
            r0.writeUtf8(r4);
            goto L4
        L7:
            return r0.readByteArray();
        }

        @JvmStatic
        @NotNull
        public final Platform get() {
            return Platform.access$getPlatform$cp();
        }

        public final boolean isAndroid() {
            return "Dalvik".equals(System.getProperty("java.vm.name"));
        }

        public final void resetForTests(@NotNull Platform r1) {
            Intrinsics.f(r1, WsConstants.KEY_PLATFORM);
            Platform.access$setPlatform$cp(r1);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        platform = Companion.access$findPlatform(r0);
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public Platform() {
    }

    public static final /* synthetic */ Platform access$getPlatform$cp() {
        return platform;
    }

    public static final /* synthetic */ void access$setPlatform$cp(Platform r0) {
        platform = r0;
    }

    @JvmStatic
    @NotNull
    public static final Platform get() {
        return Companion.get();
    }

    public static /* synthetic */ void log$default(Platform r1, String r2, int r3, Throwable r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = 4;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.log(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void afterHandshake(@NotNull SSLSocket r1) {
        Intrinsics.f(r1, "sslSocket");
    }

    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager r2) {
        Intrinsics.f(r2, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(r2));
    }

    @NotNull
    public TrustRootIndex buildTrustRootIndex(@NotNull X509TrustManager r2) {
        Intrinsics.f(r2, "trustManager");
        X509Certificate[] r3 = r2.getAcceptedIssuers();
        Intrinsics.e(r3, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(r3, r3.length));
    }

    public void configureTlsExtensions(@NotNull SSLSocket r1, @Nullable String r2, @NotNull List<Protocol> r3) {
        Intrinsics.f(r1, "sslSocket");
        Intrinsics.f(r3, "protocols");
    }

    public void connectSocket(@NotNull Socket r1, @NotNull InetSocketAddress r2, int r3) {
        Intrinsics.f(r1, "socket");
        Intrinsics.f(r2, "address");
        r1.connect(r2, r3);
    }

    @NotNull
    public final String getPrefix() {
        return "OkHttp";
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r1) {
        Intrinsics.f(r1, "sslSocket");
        return null;
    }

    @Nullable
    public Object getStackTraceForCloseable(@NotNull String r2) {
        Intrinsics.f(r2, "closer");
        if (logger.isLoggable(Level.FINE) == true) goto L7;
        return null;
    L7:
        return new Throwable(r2);
    }

    public boolean isCleartextTrafficPermitted(@NotNull String r1) {
        Intrinsics.f(r1, "hostname");
        return true;
    }

    public void log(@NotNull String r1, int r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "message");
        if (r2 != 5) goto L5;
        Level r0 = Level.WARNING;
    L6:
        logger.log(r0, r1, r3);
        return;
    L5:
        r0 = Level.INFO;
        goto L6
    }

    public void logCloseableLeak(@NotNull String r2, @Nullable Object r3) {
        Intrinsics.f(r2, "message");
        if (r3 != null) goto L5;
        r2 = r2.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
    L5:
        log(r2, 5, (Throwable) r3);
    }

    @NotNull
    public SSLContext newSSLContext() {
        SSLContext r1 = SSLContext.getInstance("TLS");
        Intrinsics.e(r1, "SSLContext.getInstance(\"TLS\")");
        return r1;
    }

    @NotNull
    public SSLSocketFactory newSslSocketFactory(@NotNull X509TrustManager r3) {
        Intrinsics.f(r3, "trustManager");
        SSLContext r2 = newSSLContext();     // Catch: GeneralSecurityException -> L5
        r2.init(null, new TrustManager[]{r3}, null);     // Catch: GeneralSecurityException -> L5
        SSLSocketFactory r4 = r2.getSocketFactory();     // Catch: GeneralSecurityException -> L5
        Intrinsics.e(r4, "newSSLContext().apply {\n…ll)\n      }.socketFactory");     // Catch: GeneralSecurityException -> L5
        return r4;
    L5:
        e = move-exception;
        throw new AssertionError("No System TLS: " + e, e);
    }

    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory r3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r3.init(null);
        TrustManager[] r4 = r3.getTrustManagers();
        Intrinsics.c(r4);
        boolean r2 = true;
        if (r4.length == 1) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == false) goto L15;
        TrustManager r5 = r4[0];
        if (r5 == null) goto L14;
        return (X509TrustManager) r5;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    L15:
        String r6 = Arrays.toString(r4);
        Intrinsics.e(r6, "java.util.Arrays.toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(r6).toString());
    L5:
        if ((r4[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName();
    }

    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory r3) {
        Intrinsics.f(r3, "sslSocketFactory");
        Object r4 = Util.readFieldOrNull(r3, Class.forName("sun.security.ssl.SSLContextImpl"), "context");     // Catch: RuntimeException -> L7 ClassNotFoundException -> L15
        if (r4 == null) goto L9;
        goto L19
    L14:
        return (X509TrustManager) Util.readFieldOrNull(r4, X509TrustManager.class, "trustManager");
    L9:
        return null;
    L7:
        e = move-exception;
        if ((!e.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) == false) goto L18;
        throw e;
    L18:
        return null;
    L19:
        return null;
    }
}
