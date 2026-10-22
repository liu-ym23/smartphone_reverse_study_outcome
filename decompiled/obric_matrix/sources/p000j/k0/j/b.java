package p000j.k0.j;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import p000j.b0;
import p000j.k0.m.e;

/* JADX INFO: loaded from: classes2.dex */
class b extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<?> f18078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f<Socket> f18079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f<Socket> f18080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f<Socket> f18081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f<Socket> f18082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c f18083h;

    static final class a extends p000j.k0.m.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f18084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f18085b;

        a(Object r1, Method r2) {
            this.f18084a = r1;
            this.f18085b = r2;
        }

        @Override // p000j.k0.m.c
        public List<Certificate> a(List<Certificate> r4, String r5) {
            X509Certificate[] r6 = (X509Certificate[]) r4.toArray(new X509Certificate[r4.size()]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7
            return (List) this.f18085b.invoke(this.f18084a, new Object[]{r6, "RSA", r5});
        L4:
            e = move-exception;
            throw new AssertionError(e);
        L7:
            e = move-exception;
            SSLPeerUnverifiedException r7 = new SSLPeerUnverifiedException(e.getMessage());
            r7.initCause(e);
            throw r7;
        }

        public boolean equals(Object r1) {
            return r1 instanceof a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: j.k0.j.b$b, reason: collision with other inner class name */
    static final class C0469b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f18086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f18087b;

        C0469b(X509TrustManager r1, Method r2) {
            this.f18087b = r2;
            this.f18086a = r1;
        }

        @Override // p000j.k0.m.e
        public X509Certificate a(X509Certificate r5) {
            TrustAnchor r4 = (TrustAnchor) this.f18087b.invoke(this.f18086a, new Object[]{r5});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L7
            if (r4 == null) goto L13;
            return r4.getTrustedCert();
            goto L14
        L13:
            return null;
        L7:
            e = move-exception;
            throw p000j.k0.c.b("unable to get issues and signature", e);
        L14:
            return null;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0469b) == true) goto L8;
            return false;
        L8:
            C0469b r6 = (C0469b) r5;
            if (this.f18086a.equals(r6.f18086a) == false) goto L14;
            if (this.f18087b.equals(r6.f18087b) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return this.f18086a.hashCode() + (this.f18087b.hashCode() * 31);
        }
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f18089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f18090c;

        c(Method r1, Method r2, Method r3) {
            this.f18088a = r1;
            this.f18089b = r2;
            this.f18090c = r3;
        }

        static c b() {
            Method r0 = null;
            Class<?> r1 = Class.forName("dalvik.system.CloseGuard");     // Catch: Exception -> L5
            Method r2 = r1.getMethod("get", new Class[0]);     // Catch: Exception -> L5
            Method r4 = r1.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L5
            Method r3 = r1.getMethod("warnIfOpen", new Class[0]);     // Catch: Exception -> L5
            r0 = r2;
        L7:
            return new c(r0, r4, r3);
        L5:
            r3 = null;
            r4 = null;
            goto L7
        }

        Object a(String r5) {
            Method r0 = this.f18088a;
            if (r0 != null) goto L9;
        L7:
            return null;
        L9:
            Object r1 = r0.invoke(null, new Object[0]);     // Catch: Exception -> L8
            this.f18089b.invoke(r1, new Object[]{r5});     // Catch: Exception -> L8
            return r1;
        }

        boolean c(Object r3) {
            if (r3 == null) goto L10;
            this.f18090c.invoke(r3, new Object[0]);     // Catch: Exception -> L7
            return true;
        L11:
            return false;
        L10:
            return false;
        }
    }

    b(Class<?> r2, f<Socket> r3, f<Socket> r4, f<Socket> r5, f<Socket> r6) {
        this.f18083h = c.b();
        this.f18078c = r2;
        this.f18079d = r3;
        this.f18080e = r4;
        this.f18081f = r5;
        this.f18082g = r6;
    }

    static int A() {
        return Build.VERSION.SDK_INT;
    L4:
        return 0;
    }

    private static boolean B() {
        if (Security.getProvider("GMSCore_OpenSSL") == null) goto L9;
        return true;
    L9:
        Class.forName("android.net.Network");     // Catch: ClassNotFoundException -> L7
        return true;
    L7:
        return false;
    }

    private boolean x(String r4, Class<?> r5, Object r6) {
        return ((Boolean) r5.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(r6, new Object[0])).booleanValue();
    L5:
        return super.r(r4);
    }

    private boolean y(String r6, Class<?> r7, Object r8) {
        return ((Boolean) r7.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(r8, new Object[]{r6})).booleanValue();
    L5:
        return x(r6, r7, r8);
    }

    public static g z() {
        if (g.q() == true) goto L15;
        return null;
    L15:
        Class<?> r1 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");     // Catch: ClassNotFoundException -> L7
    L6:
        Class<?> r4 = r1;
        f r5 = new f(null, "setUseSessionTickets", new Class[]{Boolean.TYPE});     // Catch: ClassNotFoundException -> L14
        f r6 = new f(null, "setHostname", new Class[]{String.class});     // Catch: ClassNotFoundException -> L14
        if (B() == false) goto L11;
        f r2 = new f(byte[].class, "getAlpnSelectedProtocol", new Class[0]);     // Catch: ClassNotFoundException -> L14
        f r8 = new f(null, "setAlpnProtocols", new Class[]{byte[].class});     // Catch: ClassNotFoundException -> L14
        f r7 = r2;
    L12:
        return new b(r4, r5, r6, r7, r8);
    L11:
        r7 = null;
        r8 = null;
        goto L12
    L7:
        r1 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");     // Catch: ClassNotFoundException -> L14
    L14:
        return null;
    }

    @Override // p000j.k0.j.g
    public p000j.k0.m.c d(X509TrustManager r9) {
        Class<?> r1 = Class.forName("android.net.http.X509TrustManagerExtensions");     // Catch: Exception -> L5
        return new a(r1.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{r9}), r1.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
    L6:
        return super.d(r9);
    }

    @Override // p000j.k0.j.g
    public e e(X509TrustManager r7) {
        Method r0 = r7.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L4
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L4
        return new C0469b(r7, r0);
    L5:
        return super.e(r7);
    }

    @Override // p000j.k0.j.g
    public void h(SSLSocket r6, String r7, List<b0> r8) {
        if (r7 == null) goto L5;
        this.f18079d.e(r6, new Object[]{Boolean.TRUE});
        this.f18080e.e(r6, new Object[]{r7});
    L5:
        f<Socket> r9 = this.f18082g;
        if (r9 != null) goto L8;
        return;
    L8:
        if (r9.g(r6) == false) goto L12;
        this.f18082g.f(r6, new Object[]{g.f(r8)});
        return;
    }

    @Override // p000j.k0.j.g
    public void i(Socket r1, InetSocketAddress r2, int r3) {
        r1.connect(r2, r3);     // Catch: ClassCastException -> L5 SecurityException -> L11 AssertionError -> L14
        return;
    L14:
        e = move-exception;
        if (p000j.k0.c.A(e) == true) goto L18;
        throw e;
    L18:
        throw new IOException(e);
    L5:
        e = move-exception;
        if (Build.VERSION.SDK_INT != 26) goto L10;
        IOException r4 = new IOException("Exception in connect");
        r4.initCause(e);
        throw r4;
    L10:
        throw e;
    L11:
        e = move-exception;
        IOException r5 = new IOException("Exception in connect");
        r5.initCause(e);
        throw r5;
    }

    @Override // p000j.k0.j.g
    public SSLContext n() {
        boolean r2 = true;
        int r0 = Build.VERSION.SDK_INT;     // Catch: NoClassDefFoundError -> L18
        if (r0 >= 16) goto L7;
    L9:
        r2 = false;
        goto L10
    L7:
        if (r0 >= 22) goto L9;
    L10:
        if (r2 == false) goto L24;
        return SSLContext.getInstance("TLSv1.2");
    L24:
        return SSLContext.getInstance("TLS");
    L15:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    @Override // p000j.k0.j.g
    public String o(SSLSocket r3) {
        f<Socket> r0 = this.f18081f;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.g(r3) == true) goto L8;
        return null;
    L8:
        byte[] r2 = (byte[]) this.f18081f.f(r3, new Object[0]);
        if (r2 != null) goto L11;
        return null;
    L11:
        return new String(r2, p000j.k0.c.f17800i);
    }

    @Override // p000j.k0.j.g
    public Object p(String r1) {
        return this.f18083h.a(r1);
    }

    @Override // p000j.k0.j.g
    public boolean r(String r5) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Class<?> r0 = Class.forName("android.security.NetworkSecurityPolicy");     // Catch: Throwable -> L8 Throwable -> L11
        return y(r5, r0, r0.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
    L8:
        e = move-exception;
        throw p000j.k0.c.b("unable to determine cleartext support", e);
    L12:
        return super.r(r5);
    L5:
        return super.r(r5);
    }

    @Override // p000j.k0.j.g
    public void t(int r5, String r6, Throwable r7) {
        int r4 = 5;
        if (r5 == 5) goto L7;
        r4 = 3;
    L7:
        if (r7 == null) goto L9;
        r6 = r6 + '\n' + Log.getStackTraceString(r7);
    L9:
        int r8 = 0;
        int r0 = r6.length();
    L10:
        if (r8 >= r0) goto L19;
        int r1 = r6.indexOf(10, r8);
        if (r1 != (-1)) goto L15;
        r1 = r0;
    L15:
        int r2 = Math.min(r1, r8 + 4000);
        Log.println(r4, "OkHttp", r6.substring(r8, r2));
        if (r2 >= r1) goto L17;
        r8 = r2;
        goto L15
    L17:
        r8 = r2 + 1;
        goto L10
    }

    @Override // p000j.k0.j.g
    public void u(String r2, Object r3) {
        if (this.f18083h.c(r3) == true) goto L6;
        t(5, r2, null);
        return;
    }

    @Override // p000j.k0.j.g
    protected X509TrustManager w(SSLSocketFactory r5) {
        Object r0 = g.v(r5, this.f18078c, "sslParameters");
        if (r0 == null) goto L13;
    L8:
        X509TrustManager r4 = (X509TrustManager) g.v(r0, X509TrustManager.class, "x509TrustManager");
        if (r4 == null) goto L12;
        return r4;
    L12:
        return (X509TrustManager) g.v(r0, X509TrustManager.class, "trustManager");
    L13:
        r0 = g.v(r5, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, r5.getClass().getClassLoader()), "sslParameters");     // Catch: ClassNotFoundException -> L6
    L7:
        return super.w(r5);
    }
}
