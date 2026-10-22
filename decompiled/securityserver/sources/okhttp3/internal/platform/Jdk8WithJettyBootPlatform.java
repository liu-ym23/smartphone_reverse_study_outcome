package okhttp3.internal.platform;

import androidx.core.os.EnvironmentCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = null;
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    @Metadata
    public static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;

        @Nullable
        private String selected;
        private boolean unsupported;

        public AlpnProvider(@NotNull List<String> r2) {
            Intrinsics.f(r2, "protocols");
            this.protocols = r2;
        }

        @Nullable
        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(@NotNull Object r7, @NotNull Method r8, @Nullable Object[] r9) {
            Intrinsics.f(r7, "proxy");
            Intrinsics.f(r8, "method");
            if (r9 != null) goto L6;
            r9 = new Object[0];
        L6:
            String r0 = r8.getName();
            Class<?> r1 = r8.getReturnType();
            if (Intrinsics.a(r0, "supports") == false) goto L13;
            if (Intrinsics.a(Boolean.TYPE, r1) == false) goto L13;
            return Boolean.TRUE;
        L13:
            if (Intrinsics.a(r0, "unsupported") == false) goto L19;
            if (Intrinsics.a(Void.TYPE, r1) == false) goto L19;
            this.unsupported = true;
            return null;
        L19:
            if (Intrinsics.a(r0, "protocols") == false) goto L25;
            if (r9.length != 0) goto L25;
            return this.protocols;
        L25:
            if (Intrinsics.a(r0, "selectProtocol") == true) goto L29;
            if (Intrinsics.a(r0, "select") == true) goto L29;
        L53:
            if (Intrinsics.a(r0, "protocolSelected") == true) goto L57;
            if (Intrinsics.a(r0, "selected") == true) goto L57;
        L65:
            return r8.invoke(this, Arrays.copyOf(r9, r9.length));
        L57:
            if (r9.length != 1) goto L65;
            Object r10 = r9[0];
            if (r10 == null) goto L63;
            this.selected = (String) r10;
            return null;
        L63:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L29:
            if (String.class.equals(r1) == false) goto L53;
            if (r9.length != 1) goto L53;
            Object r2 = r9[0];
            if ((r2 instanceof List) == false) goto L53;
            if (r2 == null) goto L51;
            List r3 = (List) r2;
            int r11 = r3.size();
            if (r11 < 0) goto L48;
            int r12 = 0;
        L38:
            Object r4 = r3.get(r12);
            if (r4 == null) goto L47;
            String r5 = (String) r4;
            if (this.protocols.contains(r5) == true) goto L42;
            if (r12 == r11) goto L48;
            r12 = r12 + 1;
            goto L38
        L42:
            this.selected = r5;
            return r5;
        L47:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L48:
            String r13 = this.protocols.get(0);
            this.selected = r13;
            return r13;
        L51:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
        }

        public final void setSelected(@Nullable String r1) {
            this.selected = r1;
        }

        public final void setUnsupported(boolean r1) {
            this.unsupported = r1;
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Platform buildIfSupported() {
            String r0 = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
            Intrinsics.e(r0, "jvmVersion");     // Catch: NumberFormatException -> L11
            if (Integer.parseInt(r0) < 9) goto L12;
            return null;
        L12:
            Class<?> r1 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);     // Catch: Throwable -> L10
            Class<?> r3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);     // Catch: Throwable -> L10
            Class<?> r9 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);     // Catch: Throwable -> L10
            Class<?> r10 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);     // Catch: Throwable -> L10
            Method r6 = r1.getMethod("put", new Class[]{SSLSocket.class, r3});     // Catch: Throwable -> L10
            Method r7 = r1.getMethod("get", new Class[]{SSLSocket.class});     // Catch: Throwable -> L10
            Method r8 = r1.getMethod("remove", new Class[]{SSLSocket.class});     // Catch: Throwable -> L10
            Intrinsics.e(r6, "putMethod");     // Catch: Throwable -> L10
            Intrinsics.e(r7, "getMethod");     // Catch: Throwable -> L10
            Intrinsics.e(r8, "removeMethod");     // Catch: Throwable -> L10
            Intrinsics.e(r9, "clientProviderClass");     // Catch: Throwable -> L10
            Intrinsics.e(r10, "serverProviderClass");     // Catch: Throwable -> L10
            return new Jdk8WithJettyBootPlatform(r6, r7, r8, r9, r10);
        L10:
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Jdk8WithJettyBootPlatform(@NotNull Method r2, @NotNull Method r3, @NotNull Method r4, @NotNull Class<?> r5, @NotNull Class<?> r6) {
        Intrinsics.f(r2, "putMethod");
        Intrinsics.f(r3, "getMethod");
        Intrinsics.f(r4, "removeMethod");
        Intrinsics.f(r5, "clientProviderClass");
        Intrinsics.f(r6, "serverProviderClass");
        this.putMethod = r2;
        this.getMethod = r3;
        this.removeMethod = r4;
        this.clientProviderClass = r5;
        this.serverProviderClass = r6;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(@NotNull SSLSocket r3) {
        Intrinsics.f(r3, "sslSocket");
        this.removeMethod.invoke(null, new Object[]{r3});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
        return;
    L7:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", e);
    L5:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", e);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket r4, @Nullable String r5, @NotNull List<? extends Protocol> r6) {
        Intrinsics.f(r4, "sslSocket");
        Intrinsics.f(r6, "protocols");
        List<String> r7 = Platform.Companion.alpnProtocolNames(r6);
        Object r8 = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(r7));     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7
        this.putMethod.invoke(null, new Object[]{r4, r8});     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7
        return;
    L5:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", e);
    L7:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", e);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r10) {
        Intrinsics.f(r10, "sslSocket");
        InvocationHandler r11 = Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[]{r10}));     // Catch: IllegalAccessException -> L11 InvocationTargetException -> L13
        if (r11 == null) goto L21;
        AlpnProvider r12 = (AlpnProvider) r11;     // Catch: IllegalAccessException -> L11 InvocationTargetException -> L13
        if (r12.getUnsupported() == true) goto L16;
        if (r12.getSelected() != null) goto L16;
        Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);     // Catch: IllegalAccessException -> L11 InvocationTargetException -> L13
        return null;
    L16:
        if (r12.getUnsupported() == false) goto L19;
        return null;
    L19:
        return r12.getSelected();
    L21:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");     // Catch: IllegalAccessException -> L11 InvocationTargetException -> L13
    L11:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", e);
    L13:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", e);
    }
}
