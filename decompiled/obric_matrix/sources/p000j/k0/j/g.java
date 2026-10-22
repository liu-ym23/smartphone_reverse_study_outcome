package p000j.k0.j;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import k.e;
import p000j.a0;
import p000j.b0;
import p000j.k0.m.a;
import p000j.k0.m.b;
import p000j.k0.m.c;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f18104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f18105b = null;

    static {
        f18104a = l();
        f18105b = Logger.getLogger(a0.class.getName());
    }

    public g() {
    }

    public static List<String> b(List<b0> r5) {
        ArrayList r0 = new ArrayList(r5.size());
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        b0 r3 = r5.get(r2);
        if (r3 == b0.f17672g) goto L8;
        r0.add(r3.toString());
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return r0;
    }

    static byte[] f(List<b0> r5) {
        e r0 = new e();
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        b0 r3 = r5.get(r2);
        if (r3 == b0.f17672g) goto L8;
        r0.s0(r3.toString().length());
        r0.B0(r3.toString());
    L8:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0.t();
    }

    private static g j() {
        g r0 = a.z();
        if (r0 == null) goto L5;
        return r0;
    L5:
        g r1 = b.z();
        Objects.requireNonNull(r1, "No platform found on Android");
        return r1;
    }

    private static g k() {
        if (s() == false) goto L7;
        c r0 = c.x();
        if (r0 == null) goto L7;
        return r0;
    L7:
        d r1 = d.x();
        if (r1 == null) goto L10;
        return r1;
    L10:
        g r2 = e.x();
        if (r2 == null) goto L14;
        return r2;
    L14:
        return new g();
    }

    private static g l() {
        if (q() == false) goto L7;
        return j();
    L7:
        return k();
    }

    public static g m() {
        return f18104a;
    }

    public static boolean q() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean s() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform")) == false) goto L7;
        return true;
    L7:
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    static <T> T v(Object r5, Class<T> r6, String r7) {
        Class<?> r1 = r5.getClass();
    L4:
        if (r1 == Object.class) goto L17;
        Field r3 = r1.getDeclaredField(r7);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        r3.setAccessible(true);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        Object r4 = r3.get(r5);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        if (r4 == null) goto L12;
        if (r6.isInstance(r4) == false) goto L12;
        goto L14
    L11:
        return r6.cast(r4);
    L12:
        return null;
    L15:
        r1 = r1.getSuperclass();
    L14:
        throw new AssertionError();
    L17:
        if (r7.equals("delegate") == true) goto L22;
        Object r8 = v(r5, Object.class, "delegate");
        if (r8 == null) goto L22;
        return (T) v(r8, r6, r7);
    L22:
        return null;
    }

    public void a(SSLSocket r1) {
    }

    public c c(SSLSocketFactory r3) {
        X509TrustManager r0 = w(r3);
        if (r0 == null) goto L7;
        return d(r0);
    L7:
        throw new IllegalStateException("Unable to extract the trust manager on " + m() + ", sslSocketFactory is " + r3.getClass());
    }

    public c d(X509TrustManager r2) {
        return new a(e(r2));
    }

    public p000j.k0.m.e e(X509TrustManager r1) {
        return new b(r1.getAcceptedIssuers());
    }

    public void g(SSLSocketFactory r1) {
    }

    public void h(SSLSocket r1, String r2, List<b0> r3) {
    }

    public void i(Socket r1, InetSocketAddress r2, int r3) {
        r1.connect(r2, r3);
    }

    public SSLContext n() {
        if ("1.7".equals(System.getProperty("java.specification.version")) == false) goto L14;
        return SSLContext.getInstance("TLSv1.2");
    L14:
        return SSLContext.getInstance("TLS");
    L8:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    public String o(SSLSocket r1) {
        return null;
    }

    public Object p(String r2) {
        if (f18105b.isLoggable(Level.FINE) == true) goto L5;
        return null;
    L5:
        return new Throwable(r2);
    }

    public boolean r(String r1) {
        return true;
    }

    public void t(int r1, String r2, Throwable r3) {
        if (r1 != 5) goto L5;
        Level r0 = Level.WARNING;
    L6:
        f18105b.log(r0, r2, r3);
        return;
    L5:
        r0 = Level.INFO;
        goto L6
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void u(String r2, Object r3) {
        if (r3 != null) goto L4;
        r2 = r2 + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    L4:
        t(5, r2, (Throwable) r3);
    }

    protected X509TrustManager w(SSLSocketFactory r3) {
        Object r4 = v(r3, Class.forName("sun.security.ssl.SSLContextImpl"), "context");     // Catch: ClassNotFoundException -> L8
        if (r4 != null) goto L6;
        return null;
    L6:
        return (X509TrustManager) v(r4, X509TrustManager.class, "trustManager");
    L8:
        return null;
    }
}
