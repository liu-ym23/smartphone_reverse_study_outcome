package okhttp3.internal.platform;

import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
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

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J-\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u0011H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u000fJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020+H\u0016¨\u00060"}, d2 = {"Lokhttp3/internal/platform/Platform;", "", "()V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getPrefix", "getSelectedProtocol", "getStackTraceForCloseable", "closer", "isCleartextTrafficPermitted", "", "log", "message", "level", "t", "", "logCloseableLeak", "stackTrace", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "newSslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "platformTrustManager", "toString", "sslSocketFactory", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class Platform {
    public static final Companion Companion = null;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger = null;
    private static volatile Platform platform;

    /* JADX INFO: compiled from: Platform.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokhttp3/internal/platform/Platform$Companion;", "", "()V", "INFO", "", "WARN", "isAndroid", "", "()Z", "isBouncyCastlePreferred", "isConscryptPreferred", "isOpenJSSEPreferred", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", WsConstants.KEY_PLATFORM, "Lokhttp3/internal/platform/Platform;", "alpnProtocolNames", "", "", "protocols", "Lokhttp3/Protocol;", "concatLengthPrefixed", "", "findAndroidPlatform", "findJvmPlatform", "findPlatform", "get", "resetForTests", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ Platform access$findPlatform(Companion r0) {
            return r0.findPlatform();
        }

        @JvmStatic
        public final Platform get() {
            return Platform.access$getPlatform$cp();
        }

        public static /* synthetic */ void resetForTests$default(Companion r0, Platform r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = r0.findPlatform();
        L5:
            r0.resetForTests(r1);
        }

        public final void resetForTests(Platform r1) {
            Intrinsics.checkNotNullParameter(r1, WsConstants.KEY_PLATFORM);
            Platform.access$setPlatform$cp(r1);
        }

        public final List<String> alpnProtocolNames(List<? extends Protocol> r4) {
            Intrinsics.checkNotNullParameter(r4, "protocols");
            ArrayList r3 = new ArrayList();
            Iterator<T> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L11;
            Object r0 = r5.next();
            if (((Protocol) r0) == Protocol.HTTP_1_0) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == false) goto L4;
            r3.add(r0);
            goto L4
        L8:
            r1 = false;
            goto L9
        L11:
            ArrayList r6 = r3;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator r8 = r6.iterator();
        L13:
            if (r8.hasNext() == false) goto L16;
            r7.add(((Protocol) r8.next()).toString());
            goto L13
        L16:
            return r7;
        }

        public final boolean isAndroid() {
            return Intrinsics.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }

        private final boolean isConscryptPreferred() {
            return Intrinsics.areEqual("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean isOpenJSSEPreferred() {
            return Intrinsics.areEqual("OpenJSSE", Security.getProviders()[0].getName());
        }

        private final boolean isBouncyCastlePreferred() {
            return Intrinsics.areEqual("BC", Security.getProviders()[0].getName());
        }

        private final Platform findPlatform() {
            if (isAndroid() == false) goto L6;
            return findAndroidPlatform();
        L6:
            return findJvmPlatform();
        }

        private final Platform findAndroidPlatform() {
            AndroidLog.INSTANCE.enable();
            Platform r0 = Android10Platform.Companion.buildIfSupported();
            if (r0 != null) goto L6;
            Platform r1 = AndroidPlatform.Companion.buildIfSupported();
            Intrinsics.checkNotNull(r1);
            return r1;
        L6:
            return r0;
        }

        private final Platform findJvmPlatform() {
            if (isConscryptPreferred() == false) goto L9;
            ConscryptPlatform r0 = ConscryptPlatform.Companion.buildIfSupported();
            if (r0 == null) goto L9;
            return r0;
        L9:
            if (isBouncyCastlePreferred() == false) goto L15;
            BouncyCastlePlatform r1 = BouncyCastlePlatform.Companion.buildIfSupported();
            if (r1 == null) goto L15;
            return r1;
        L15:
            if (isOpenJSSEPreferred() == false) goto L20;
            OpenJSSEPlatform r2 = OpenJSSEPlatform.Companion.buildIfSupported();
            if (r2 == null) goto L20;
            return r2;
        L20:
            Jdk9Platform r3 = Jdk9Platform.Companion.buildIfSupported();
            if (r3 != null) goto L23;
            Platform r4 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            if (r4 == null) goto L28;
            return r4;
        L28:
            return new Platform();
        L23:
            return r3;
        }

        public final byte[] concatLengthPrefixed(List<? extends Protocol> r3) {
            Intrinsics.checkNotNullParameter(r3, "protocols");
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
    }

    @JvmStatic
    public static final Platform get() {
        return Companion.get();
    }

    public void afterHandshake(SSLSocket r1) {
        Intrinsics.checkNotNullParameter(r1, "sslSocket");
    }

    public void configureTlsExtensions(SSLSocket r1, String r2, List<Protocol> r3) {
        Intrinsics.checkNotNullParameter(r1, "sslSocket");
        Intrinsics.checkNotNullParameter(r3, "protocols");
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket r1) {
        Intrinsics.checkNotNullParameter(r1, "sslSocket");
        return null;
    }

    public boolean isCleartextTrafficPermitted(String r1) {
        Intrinsics.checkNotNullParameter(r1, "hostname");
        return true;
    }

    public Platform() {
    }

    public static final /* synthetic */ Platform access$getPlatform$cp() {
        return platform;
    }

    public static final /* synthetic */ void access$setPlatform$cp(Platform r0) {
        platform = r0;
    }

    public SSLContext newSSLContext() {
        SSLContext r1 = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(r1, "getInstance(\"TLS\")");
        return r1;
    }

    public X509TrustManager platformTrustManager() {
        TrustManagerFactory r3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyStore r1 = (KeyStore) null;
        r3.init(null);
        TrustManager[] r4 = r3.getTrustManagers();
        Intrinsics.checkNotNull(r4);
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
        Intrinsics.checkNotNullExpressionValue(r6, "toString(this)");
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected default trust managers: ", r6).toString());
    L5:
        if ((r4[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    public X509TrustManager trustManager(SSLSocketFactory r3) {
        Intrinsics.checkNotNullParameter(r3, "sslSocketFactory");
        Class<?> r0 = Class.forName("sun.security.ssl.SSLContextImpl");     // Catch: RuntimeException -> L8 ClassNotFoundException -> L13
        Intrinsics.checkNotNullExpressionValue(r0, "sslContextClass");     // Catch: RuntimeException -> L8 ClassNotFoundException -> L13
        Object r4 = Util.readFieldOrNull(r3, r0, "context");     // Catch: RuntimeException -> L8 ClassNotFoundException -> L13
        if (r4 != null) goto L6;
        return null;
    L6:
    L17:
        return (X509TrustManager) Util.readFieldOrNull(r4, X509TrustManager.class, "trustManager");
    L13:
        X509TrustManager r5 = (X509TrustManager) null;
        return null;
    L8:
        e = move-exception;
        if (Intrinsics.areEqual(e.getClass().getName(), "java.lang.reflect.InaccessibleObjectException") == false) goto L12;
        X509TrustManager r6 = (X509TrustManager) null;
        return null;
    L12:
        throw e;
    }

    public void connectSocket(Socket r1, InetSocketAddress r2, int r3) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "socket");
        Intrinsics.checkNotNullParameter(r2, "address");
        r1.connect(r2, r3);
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

    public void log(String r1, int r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "message");
        if (r2 != 5) goto L5;
        Level r0 = Level.WARNING;
    L6:
        logger.log(r0, r1, r3);
        return;
    L5:
        r0 = Level.INFO;
        goto L6
    }

    public Object getStackTraceForCloseable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "closer");
        if (logger.isLoggable(Level.FINE) == true) goto L7;
        return null;
    L7:
        return new Throwable(r2);
    }

    public void logCloseableLeak(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (r3 != null) goto L5;
        r2 = Intrinsics.stringPlus(r2, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
    L5:
        log(r2, 5, (Throwable) r3);
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager r2) {
        Intrinsics.checkNotNullParameter(r2, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(r2));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager r2) {
        Intrinsics.checkNotNullParameter(r2, "trustManager");
        X509Certificate[] r3 = r2.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(r3, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(r3, r3.length));
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager r3) {
        Intrinsics.checkNotNullParameter(r3, "trustManager");
        SSLContext r2 = newSSLContext();     // Catch: GeneralSecurityException -> L5
        r2.init(null, new TrustManager[]{r3}, null);     // Catch: GeneralSecurityException -> L5
        SSLSocketFactory r4 = r2.getSocketFactory();     // Catch: GeneralSecurityException -> L5
        Intrinsics.checkNotNullExpressionValue(r4, "newSSLContext().apply {\n…ll)\n      }.socketFactory");     // Catch: GeneralSecurityException -> L5
        return r4;
    L5:
        e = move-exception;
        throw new AssertionError(Intrinsics.stringPlus("No System TLS: ", e), e);
    }

    public String toString() {
        String r1 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r1, "javaClass.simpleName");
        return r1;
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        platform = Companion.access$findPlatform(r0);
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }
}
