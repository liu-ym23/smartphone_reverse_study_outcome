package p000j.k0.j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p000j.b0;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
class e extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f18093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f18094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f18095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f18096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Class<?> f18097g;

    private static class a implements InvocationHandler {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<String> f18098f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f18099g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f18100h;

        a(List<String> r1) {
            this.f18098f = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r6, Method r7, Object[] r8) {
            String r9 = r7.getName();
            Class<?> r0 = r7.getReturnType();
            if (r8 != null) goto L6;
            r8 = c.f17793b;
        L6:
            if (r9.equals("supports") == false) goto L12;
            if (Boolean.TYPE != r0) goto L12;
            return Boolean.TRUE;
        L12:
            if (r9.equals("unsupported") == false) goto L18;
            if (Void.TYPE != r0) goto L18;
            this.f18099g = true;
            return null;
        L18:
            if (r9.equals("protocols") == false) goto L24;
            if (r8.length != 0) goto L24;
            return this.f18098f;
        L24:
            if (r9.equals("selectProtocol") == true) goto L28;
            if (r9.equals("select") == true) goto L28;
        L43:
            if (r9.equals("protocolSelected") == true) goto L47;
            if (r9.equals("selected") == true) goto L47;
        L51:
            return r7.invoke(this, r8);
        L47:
            if (r8.length != 1) goto L51;
            this.f18100h = (String) r8[0];
            return null;
        L28:
            if (String.class != r0) goto L43;
            if (r8.length != 1) goto L43;
            if ((r8[0] instanceof List) == false) goto L43;
            List r10 = (List) r8[0];
            int r11 = r10.size();
            int r12 = 0;
        L34:
            if (r12 >= r11) goto L41;
            if (this.f18098f.contains(r10.get(r12)) == true) goto L37;
            r12 = r12 + 1;
            goto L34
        L37:
            Object r13 = r10.get(r12);
        L38:
            String r14 = (String) r13;
            this.f18100h = r14;
            return r14;
        L41:
            r13 = this.f18098f.get(0);
            goto L38
        }
    }

    e(Method r1, Method r2, Method r3, Class<?> r4, Class<?> r5) {
        this.f18093c = r1;
        this.f18094d = r2;
        this.f18095e = r3;
        this.f18096f = r4;
        this.f18097g = r5;
    }

    public static g x() {
        Class<?> r1 = Class.forName("org.eclipse.jetty.alpn.ALPN");     // Catch: Throwable -> L6 Throwable -> L6
        Class<?> r2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");     // Catch: Throwable -> L6 Throwable -> L6
        return new e(r1.getMethod("put", new Class[]{SSLSocket.class, r2}), r1.getMethod("get", new Class[]{SSLSocket.class}), r1.getMethod("remove", new Class[]{SSLSocket.class}), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
    L6:
        return null;
    }

    @Override // p000j.k0.j.g
    public void a(SSLSocket r4) {
        this.f18095e.invoke(null, new Object[]{r4});     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw c.b("unable to remove alpn", e);
    }

    @Override // p000j.k0.j.g
    public void h(SSLSocket r6, String r7, List<b0> r8) {
        List<String> r9 = g.b(r8);
        Object r10 = Proxy.newProxyInstance(g.class.getClassLoader(), new Class[]{this.f18096f, this.f18097g}, new a(r9));     // Catch: Throwable -> L5
        this.f18093c.invoke(null, new Object[]{r6, r10});     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw c.b("unable to set alpn", e);
    }

    @Override // p000j.k0.j.g
    public String o(SSLSocket r3) {
        a r2 = (a) Proxy.getInvocationHandler(this.f18094d.invoke(null, new Object[]{r3}));     // Catch: Throwable -> L12
        boolean r0 = r2.f18099g;     // Catch: Throwable -> L12
        if (r0 == false) goto L5;
    L8:
        if (r0 == false) goto L11;
        return null;
    L11:
        return r2.f18100h;
    L5:
        if (r2.f18100h != null) goto L8;
        g.m().t(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);     // Catch: Throwable -> L12
        return null;
    L12:
        e = move-exception;
        throw c.b("unable to get selected protocol", e);
    }
}
