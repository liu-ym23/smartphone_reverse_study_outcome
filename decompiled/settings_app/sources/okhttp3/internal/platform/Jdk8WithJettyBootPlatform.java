package okhttp3.internal.platform;

import androidx.core.os.EnvironmentCompat;
import com.obric.oui.material.MaterialConfigFormatNames;
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

/* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "putMethod", "Ljava/lang/reflect/Method;", "getMethod", "removeMethod", "clientProviderClass", "Ljava/lang/Class;", "serverProviderClass", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "AlpnProvider", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = null;
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    /* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J0\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "protocols", "", "", "(Ljava/util/List;)V", MaterialConfigFormatNames.SELECTED, "getSelected", "()Ljava/lang/String;", "setSelected", "(Ljava/lang/String;)V", "unsupported", "", "getUnsupported", "()Z", "setUnsupported", "(Z)V", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "protocols");
            this.protocols = r2;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        public final void setUnsupported(boolean r1) {
            this.unsupported = r1;
        }

        public final String getSelected() {
            return this.selected;
        }

        public final void setSelected(String r1) {
            this.selected = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r7, Method r8, Object[] r9) throws Throwable {
            Intrinsics.checkNotNullParameter(r7, "proxy");
            Intrinsics.checkNotNullParameter(r8, "method");
            if (r9 != null) goto L5;
            r9 = new Object[0];
        L5:
            String r0 = r8.getName();
            Class<?> r1 = r8.getReturnType();
            if (Intrinsics.areEqual(r0, "supports") == false) goto L12;
            if (Intrinsics.areEqual(Boolean.TYPE, r1) == false) goto L12;
            return true;
        L12:
            if (Intrinsics.areEqual(r0, "unsupported") == false) goto L18;
            if (Intrinsics.areEqual(Void.TYPE, r1) == false) goto L18;
            this.unsupported = true;
            return null;
        L18:
            if (Intrinsics.areEqual(r0, "protocols") == false) goto L27;
            if (r9.length != 0) goto L22;
            boolean r2 = true;
        L23:
            if (r2 == false) goto L27;
            return this.protocols;
        L22:
            r2 = false;
        L27:
            if (Intrinsics.areEqual(r0, "selectProtocol") == true) goto L31;
            if (Intrinsics.areEqual(r0, "select") == true) goto L31;
        L56:
            if (Intrinsics.areEqual(r0, "protocolSelected") == true) goto L60;
            if (Intrinsics.areEqual(r0, MaterialConfigFormatNames.SELECTED) == true) goto L60;
        L68:
            return r8.invoke(this, Arrays.copyOf(r9, r9.length));
        L60:
            if (r9.length != 1) goto L68;
            Object r10 = r9[0];
            if (r10 == null) goto L66;
            this.selected = (String) r10;
            return null;
        L66:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L31:
            if (Intrinsics.areEqual(String.class, r1) == false) goto L56;
            if (r9.length != 1) goto L56;
            Object r3 = r9[0];
            if ((r3 instanceof List) == false) goto L56;
            if (r3 == null) goto L54;
            List r4 = (List) r3;
            int r11 = r4.size();
            if (r11 < 0) goto L51;
            int r12 = 0;
        L40:
            int r5 = r12 + 1;
            Object r6 = r4.get(r12);
            if (r6 == null) goto L50;
            String r13 = (String) r6;
            if (this.protocols.contains(r13) == true) goto L44;
            if (r12 == r11) goto L51;
            r12 = r5;
            goto L40
        L44:
            this.selected = r13;
            return r13;
        L50:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L51:
            String r14 = this.protocols.get(0);
            this.selected = r14;
            return r14;
        L54:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
        }
    }

    /* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Platform buildIfSupported() {
            String r11 = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
            Intrinsics.checkNotNullExpressionValue(r11, "jvmVersion");     // Catch: NumberFormatException -> L10
            if (Integer.parseInt(r11) < 9) goto L13;
            return null;
        L13:
            Class<?> r2 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);     // Catch: Throwable -> L9
            Class<?> r3 = Class.forName(Intrinsics.stringPlus("org.eclipse.jetty.alpn.ALPN", "$Provider"), true, null);     // Catch: Throwable -> L9
            Class<?> r9 = Class.forName(Intrinsics.stringPlus("org.eclipse.jetty.alpn.ALPN", "$ClientProvider"), true, null);     // Catch: Throwable -> L9
            Class<?> r10 = Class.forName(Intrinsics.stringPlus("org.eclipse.jetty.alpn.ALPN", "$ServerProvider"), true, null);     // Catch: Throwable -> L9
            Method r12 = r2.getMethod("put", new Class[]{SSLSocket.class, r3});     // Catch: Throwable -> L9
            Method r7 = r2.getMethod("get", new Class[]{SSLSocket.class});     // Catch: Throwable -> L9
            Method r8 = r2.getMethod("remove", new Class[]{SSLSocket.class});     // Catch: Throwable -> L9
            Intrinsics.checkNotNullExpressionValue(r12, "putMethod");     // Catch: Throwable -> L9
            Intrinsics.checkNotNullExpressionValue(r7, "getMethod");     // Catch: Throwable -> L9
            Intrinsics.checkNotNullExpressionValue(r8, "removeMethod");     // Catch: Throwable -> L9
            Intrinsics.checkNotNullExpressionValue(r9, "clientProviderClass");     // Catch: Throwable -> L9
            Intrinsics.checkNotNullExpressionValue(r10, "serverProviderClass");     // Catch: Throwable -> L9
            return new Jdk8WithJettyBootPlatform(r12, r7, r8, r9, r10);
        L9:
            return null;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Jdk8WithJettyBootPlatform(Method r2, Method r3, Method r4, Class<?> r5, Class<?> r6) {
        Intrinsics.checkNotNullParameter(r2, "putMethod");
        Intrinsics.checkNotNullParameter(r3, "getMethod");
        Intrinsics.checkNotNullParameter(r4, "removeMethod");
        Intrinsics.checkNotNullParameter(r5, "clientProviderClass");
        Intrinsics.checkNotNullParameter(r6, "serverProviderClass");
        this.putMethod = r2;
        this.getMethod = r3;
        this.removeMethod = r4;
        this.clientProviderClass = r5;
        this.serverProviderClass = r6;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r7, String r8, List<? extends Protocol> r9) {
        Intrinsics.checkNotNullParameter(r7, "sslSocket");
        Intrinsics.checkNotNullParameter(r9, "protocols");
        List<String> r10 = Platform.Companion.alpnProtocolNames(r9);
        Object r11 = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(r10));     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L8
        this.putMethod.invoke(null, new Object[]{r7, r11});     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L8
        return;
    L5:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", e);
    L8:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", e);
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket r4) {
        Intrinsics.checkNotNullParameter(r4, "sslSocket");
        this.removeMethod.invoke(null, new Object[]{r4});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        return;
    L8:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", e);
    L5:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", e);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        InvocationHandler r1 = Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[]{r10}));     // Catch: IllegalAccessException -> L18 InvocationTargetException -> L21
        if (r1 == null) goto L17;
        AlpnProvider r2 = (AlpnProvider) r1;     // Catch: IllegalAccessException -> L18 InvocationTargetException -> L21
        if (r2.getUnsupported() == true) goto L12;
        if (r2.getSelected() != null) goto L12;
        Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);     // Catch: IllegalAccessException -> L18 InvocationTargetException -> L21
        return null;
    L12:
        if (r2.getUnsupported() == false) goto L15;
        return null;
    L15:
        return r2.getSelected();
    L17:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");     // Catch: IllegalAccessException -> L18 InvocationTargetException -> L21
    L18:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", e);
    L21:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", e);
    }
}
