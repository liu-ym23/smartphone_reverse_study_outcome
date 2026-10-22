package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class AndroidSocketAdapter implements SocketAdapter {
    public static final Companion Companion = null;

    @NotNull
    private static final DeferredSocketAdapter.Factory playProviderFactory = null;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ AndroidSocketAdapter access$build(Companion r0, Class r1) {
            return r0.build(r1);
        }

        private final AndroidSocketAdapter build(Class<? super SSLSocket> r3) {
            Class<? super SSLSocket> r2 = r3;
        L3:
            if (r2 == null) goto L11;
            if ((!r2.getSimpleName().equals("OpenSSLSocketImpl")) == false) goto L11;
            r2 = r2.getSuperclass();
            if (r2 != null) goto L3;
            throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + r3);
        L11:
            Intrinsics.c(r2);
            return new AndroidSocketAdapter(r2);
        }

        @NotNull
        public final DeferredSocketAdapter.Factory factory(@NotNull final String r1) {
            Intrinsics.f(r1, "packageName");
            return new AndroidSocketAdapter$Companion$factory$1(r1);
        }

        @NotNull
        public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.access$getPlayProviderFactory$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        playProviderFactory = r0.factory("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(@NotNull Class<? super SSLSocket> r3) {
        Intrinsics.f(r3, "sslSocketClass");
        this.sslSocketClass = r3;
        Method r0 = r3.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        Intrinsics.e(r0, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = r0;
        this.setHostname = r3.getMethod("setHostname", new Class[]{String.class});
        this.getAlpnSelectedProtocol = r3.getMethod("getAlpnSelectedProtocol", null);
        this.setAlpnProtocols = r3.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public static final /* synthetic */ DeferredSocketAdapter.Factory access$getPlayProviderFactory$cp() {
        return playProviderFactory;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@NotNull SSLSocket r3, @Nullable String r4, @NotNull List<? extends Protocol> r5) {
        Intrinsics.f(r3, "sslSocket");
        Intrinsics.f(r5, "protocols");
        if (matchesSocket(r3) == true) goto L18;
        return;
    L18:
        this.setUseSessionTickets.invoke(r3, new Object[]{Boolean.TRUE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r4 == null) goto L11;
        this.setHostname.invoke(r3, new Object[]{r4});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L11:
        this.setAlpnProtocols.invoke(r3, new Object[]{Platform.Companion.concatLengthPrefixed(r5)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L20:
        return;
    L9:
        e = move-exception;
        throw new AssertionError(e);
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r3) {
        Intrinsics.f(r3, "sslSocket");
        if (matchesSocket(r3) == true) goto L23;
        return null;
    L23:
        byte[] r2 = (byte[]) this.getAlpnSelectedProtocol.invoke(r3, null);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NullPointerException -> L13
        if (r2 == null) goto L21;
        Charset r4 = StandardCharsets.UTF_8;     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NullPointerException -> L13
        Intrinsics.e(r4, "StandardCharsets.UTF_8");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NullPointerException -> L13
    L25:
        return new String(r2, r4);
    L21:
        return null;
    L11:
        e = move-exception;
        throw new AssertionError(e);
    L13:
        e = move-exception;
        if (Intrinsics.a(e.getMessage(), "ssl == null") == true) goto L26;
        throw e;
    L26:
        return null;
    L9:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket r2) {
        Intrinsics.f(r2, "sslSocket");
        return this.sslSocketClass.isInstance(r2);
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
