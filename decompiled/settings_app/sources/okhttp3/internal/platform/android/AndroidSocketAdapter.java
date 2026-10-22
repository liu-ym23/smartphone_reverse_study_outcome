package okhttp3.internal.platform.android;

import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.search.IndexDatabaseHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: AndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "(Ljava/lang/Class;)V", "getAlpnSelectedProtocol", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "setAlpnProtocols", "setHostname", "setUseSessionTickets", "configureTlsExtensions", "", "sslSocket", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AndroidSocketAdapter implements SocketAdapter {
    public static final Companion Companion = null;
    private static final DeferredSocketAdapter.Factory playProviderFactory = null;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    /* JADX INFO: compiled from: AndroidSocketAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000b0\nH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter$Companion;", "", "()V", "playProviderFactory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getPlayProviderFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", IndexDatabaseHelper.MetaColumns.BUILD, "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "actualSSLSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "factory", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ AndroidSocketAdapter access$build(Companion r0, Class r1) {
            return r0.build(r1);
        }

        public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.access$getPlayProviderFactory$cp();
        }

        private final AndroidSocketAdapter build(Class<? super SSLSocket> r3) {
            Class<? super SSLSocket> r2 = r3;
        L3:
            if (r2 == null) goto L11;
            if (Intrinsics.areEqual(r2.getSimpleName(), "OpenSSLSocketImpl") == true) goto L11;
            r2 = r2.getSuperclass();
            if (r2 != null) goto L3;
            throw new AssertionError(Intrinsics.stringPlus("No OpenSSLSocketImpl superclass of socket of type ", r3));
        L11:
            Intrinsics.checkNotNull(r2);
            return new AndroidSocketAdapter(r2);
        }

        public final DeferredSocketAdapter.Factory factory(final String r1) {
            Intrinsics.checkNotNullParameter(r1, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
            return new AndroidSocketAdapter$Companion$factory$1(r1);
        }
    }

    public AndroidSocketAdapter(Class<? super SSLSocket> r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocketClass");
        this.sslSocketClass = r5;
        Method r1 = r5.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        Intrinsics.checkNotNullExpressionValue(r1, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = r1;
        this.setHostname = r5.getMethod("setHostname", new Class[]{String.class});
        this.getAlpnSelectedProtocol = r5.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.setAlpnProtocols = r5.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public static final /* synthetic */ DeferredSocketAdapter.Factory access$getPlayProviderFactory$cp() {
        return playProviderFactory;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory r1) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, r1);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory r1) {
        return SocketAdapter.DefaultImpls.trustManager(this, r1);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket r2) {
        Intrinsics.checkNotNullParameter(r2, "sslSocket");
        return this.sslSocketClass.isInstance(r2);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(SSLSocket r6, String r7, List<? extends Protocol> r8) {
        Intrinsics.checkNotNullParameter(r6, "sslSocket");
        Intrinsics.checkNotNullParameter(r8, "protocols");
        if (matchesSocket(r6) == true) goto L16;
        return;
    L16:
        this.setUseSessionTickets.invoke(r6, new Object[]{true});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        if (r7 == null) goto L7;
        this.setHostname.invoke(r6, new Object[]{r7});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
    L7:
        this.setAlpnProtocols.invoke(r6, new Object[]{Platform.Companion.concatLengthPrefixed(r8)});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
    L18:
        return;
    L12:
        e = move-exception;
        throw new AssertionError(e);
    L9:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket r3) {
        Intrinsics.checkNotNullParameter(r3, "sslSocket");
        if (matchesSocket(r3) == true) goto L22;
        return null;
    L22:
        byte[] r2 = (byte[]) this.getAlpnSelectedProtocol.invoke(r3, new Object[0]);     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L19
        if (r2 == null) goto L24;
    L25:
        return new String(r2, Charsets.UTF_8);
    L24:
        return null;
    L19:
        e = move-exception;
        throw new AssertionError(e);
    L10:
        e = move-exception;
        Throwable r4 = e.getCause();
        if ((r4 instanceof NullPointerException) == false) goto L18;
        if (Intrinsics.areEqual(((NullPointerException) r4).getMessage(), "ssl == null") == false) goto L18;
        String r5 = (String) null;
        return null;
    L18:
        throw new AssertionError(e);
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        playProviderFactory = r0.factory("com.google.android.gms.org.conscrypt");
    }
}
