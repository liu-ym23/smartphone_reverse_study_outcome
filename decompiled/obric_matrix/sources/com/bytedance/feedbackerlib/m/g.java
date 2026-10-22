package com.bytedance.feedbackerlib.m;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p000j.a0;
import p000j.d0;
import p000j.f0;
import p000j.g0;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a0 f4265a;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4266f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f4267g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Map f4268h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e f4269i;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.m.g$a$a, reason: collision with other inner class name */
        class RunnableC0127a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f4270f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ StringBuffer f4271g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ a f4272h;

            RunnableC0127a(a r1, String r2, StringBuffer r3) {
                this.f4272h = r1;
                this.f4270f = r2;
                this.f4271g = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4272h.f4269i.a(this.f4270f, this.f4271g.toString());
            }
        }

        a(String r1, Map r2, Map r3, e r4) {
            this.f4266f = r1;
            this.f4267g = r2;
            this.f4268h = r3;
            this.f4269i = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuffer r0 = new StringBuffer();
            String r1 = g.e(this.f4266f, this.f4267g, this.f4268h, r0, null);
            com.bytedance.feedbackerlib.m.c.b("HttpUtils", "httpGetFinished: \n\turl: " + this.f4266f + "\n\theaders: " + this.f4267g + "\n\tqueryParams: " + this.f4268h + "\n\tresult: " + r1 + "\n\terrDetail: " + r0);
            t.a(new RunnableC0127a(this, r1, r0));
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f4273f;

        class a implements Callable<String> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ StringBuffer f4274f;

            a(b r1, StringBuffer r2) {
                this.f4274f = r2;
            }

            public String a() {
                return g.e("https://app-alpha.bytedance.net/ping", null, null, this.f4274f, null);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ String call() {
                return a();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.m.g$b$b, reason: collision with other inner class name */
        class RunnableC0128b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f4275f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ StringBuffer f4276g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ b f4277h;

            RunnableC0128b(b r1, String r2, StringBuffer r3) {
                this.f4277h = r1;
                this.f4275f = r2;
                this.f4276g = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4277h.f4273f.a(this.f4275f, this.f4276g.toString());
            }
        }

        b(e r1) {
            this.f4273f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuffer r0 = new StringBuffer();
            String r1 = (String) t.d().submit(new a(this, r0)).get(1000, TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L5 InterruptedException -> L7 ExecutionException -> L9
        L12:
            com.bytedance.feedbackerlib.m.c.b("HttpUtils", "httpGetFinished: \n\turl: https://app-alpha.bytedance.net/ping\n\tresult: " + r1 + "\n\terrDetail: " + r0);
            t.a(new RunnableC0128b(this, r1, r0));
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        L11:
            r1 = null;
        L9:
            e = move-exception;
            e.printStackTrace();
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L11
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4278f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f4279g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Map f4280h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.bytedance.feedbackerlib.m.f f4281i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f4282j;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f4283f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ StringBuffer f4284g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ c f4285h;

            a(c r1, String r2, StringBuffer r3) {
                this.f4285h = r1;
                this.f4283f = r2;
                this.f4284g = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4285h.f4282j.a(this.f4283f, this.f4284g.toString());
            }
        }

        c(String r1, Map r2, Map r3, com.bytedance.feedbackerlib.m.f r4, e r5) {
            this.f4278f = r1;
            this.f4279g = r2;
            this.f4280h = r3;
            this.f4281i = r4;
            this.f4282j = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuffer r0 = new StringBuffer();
            String r1 = g.e(this.f4278f, this.f4279g, this.f4280h, r0, this.f4281i);
            com.bytedance.feedbackerlib.m.c.b("HttpUtils", "httpGetFinished: \n\turl: " + this.f4278f + "\n\theaders: " + this.f4279g + "\n\tqueryParams: " + this.f4280h + "\n\tresult: " + r1 + "\n\terrDetail: " + r0);
            t.a(new a(this, r1, r0));
        }
    }

    public static class d extends SSLSocketFactory {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f4286b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String[] f4287c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SSLSocketFactory f4288a;

        static {
            f4286b = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"};
            f4287c = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
        }

        public d(SSLSocketFactory r1) {
            this.f4288a = r1;
        }

        private Socket a(Socket r2) {
            if ((r2 instanceof SSLSocket) == true) goto L5;
        L8:
            return r2;
        L5:
            if (Build.VERSION.SDK_INT < 29) goto L7;
            ((SSLSocket) r2).setEnabledProtocols(f4286b);
            goto L8
        L7:
            ((SSLSocket) r2).setEnabledProtocols(f4287c);
            goto L8
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String r2, int r3) {
            Socket r4 = this.f4288a.createSocket(r2, r3);
            a(r4);
            return r4;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String r2, int r3, InetAddress r4, int r5) {
            Socket r6 = this.f4288a.createSocket(r2, r3, r4, r5);
            a(r6);
            return r6;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress r2, int r3) {
            Socket r4 = this.f4288a.createSocket(r2, r3);
            a(r4);
            return r4;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress r2, int r3, InetAddress r4, int r5) {
            Socket r6 = this.f4288a.createSocket(r2, r3, r4, r5);
            a(r6);
            return r6;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket r2, String r3, int r4, boolean r5) {
            Socket r6 = this.f4288a.createSocket(r2, r3, r4, r5);
            a(r6);
            return r6;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return this.f4288a.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return this.f4288a.getSupportedCipherSuites();
        }
    }

    public interface e {
        void a(@Nullable String r1, @NonNull String r2);
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f4289a = "https://starling.snssdk.com/text/";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f4290b = "https://app-alpha.bytedance.com/";

        static {
        }

        public static boolean a() {
            if (f4290b == "https://app-alpha-boe.bytedance.net/") goto L5;
        L7:
            return false;
        L5:
            if (f4289a != "https://starling.snssdk.com/text_test/") goto L7;
            return true;
        }

        public static void b() {
            f4290b = "https://app-alpha-boe.bytedance.net/";
            f4289a = "https://starling.snssdk.com/text_test/";
            com.bytedance.feedbackerlib.j.e.e().j();
        }

        public static void c() {
            f4290b = "https://app-alpha.bytedance.com/";
            f4289a = "https://starling.snssdk.com/text/";
            com.bytedance.feedbackerlib.j.e.e().j();
        }
    }

    public g() {
    }

    public static void a(@NonNull e r2) {
        com.bytedance.feedbackerlib.m.c.b("HttpUtils", "start checkNetworkStateAsync, \n\turl: https://app-alpha.bytedance.net/ping");
        t.c(new b(r2));
    }

    private static a0 b(com.bytedance.feedbackerlib.m.f r4) {
        if (r4 != null) goto L4;
        r4 = com.bytedance.feedbackerlib.m.f.f4261d;
    L4:
        a0.b r0 = new a0.b();
        long r1 = r4.f4262a;
        TimeUnit r3 = TimeUnit.MILLISECONDS;
        r0.d(r1, r3);
        r0.n(r4.f4263b, r3);
        r0.s(r4.f4264c, r3);
        r0.o(true);
        r0.j(true);
        g(r0);
        return r0.c();
    }

    public static void c(@NonNull String r2, @Nullable Map<String, String> r3, @Nullable Map<String, String> r4, @NonNull e r5) {
        com.bytedance.feedbackerlib.m.c.b("HttpUtils", "start doHttpGetAsync, \n\turl: " + r2 + "\n\theaders: " + r3 + "\n\tqueryParams: " + r4);
        t.c(new a(r2, r3, r4, r5));
    }

    public static void d(@NonNull String r8, @Nullable Map<String, String> r9, @Nullable Map<String, String> r10, @NonNull e r11, @Nullable com.bytedance.feedbackerlib.m.f r12) {
        com.bytedance.feedbackerlib.m.c.b("HttpUtils", "start doHttpGetAsync, \n\turl: " + r8 + "\n\theaders: " + r9 + "\n\tqueryParams: " + r10);
        t.c(new c(r8, r9, r10, r12, r11));
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [j.d0, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2, types: [j.a0, java.io.Closeable] */
    @Nullable
    public static String e(@NonNull String r7, @Nullable Map<String, String> r8, @Nullable Map<String, String> r9, @Nullable StringBuffer r10, @Nullable com.bytedance.feedbackerlib.m.f r11) {
        d0.a r3 = new d0.a();
        if (r8 == null) goto L12;
        Iterator<Map.Entry<String, String>> r12 = r8.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<String, String> r4 = r12.next();
        String r5 = r4.getKey();
        String r6 = r4.getValue();
        if (r5 == null) goto L6;
        if (r6 == null) goto L6;
        r3.a(r4.getKey(), r4.getValue());
    L12:
        j.w.a r13 = p000j.w.r(r7).p();
        if (r9 == null) goto L22;
        Iterator<Map.Entry<String, String>> r14 = r9.entrySet().iterator();
    L16:
        if (r14.hasNext() == false) goto L22;
        Map.Entry<String, String> r15 = r14.next();
        String r16 = r15.getKey();
        String r17 = r15.getValue();
        if (r16 == null) goto L16;
        if (r17 == null) goto L16;
        r13.a(r16, r17);
    L22:
        r3.l(r13.b());
        ?? r18 = r3.b();
        if (r11 != null) goto L25;
        ?? r19 = h();
    L68:
        f0 r20 = r19.w(r18).execute();     // Catch: Throwable -> L40 Throwable -> L53
        g0 r21 = r20.a();     // Catch: Throwable -> L36 Throwable -> L38
        String r22 = r21.C();     // Catch: Throwable -> L32 Throwable -> L34
        s.a(r21);
        s.a(r20);
        return r22;
    L34:
        e = e;
    L55:
        com.bytedance.feedbackerlib.model.e.b.d().a(e.toString());     // Catch: Throwable -> L65
        if (r10 == null) goto L59;
        r10.append("execute http get failed: ");     // Catch: Throwable -> L65
        r10.append(e.toString());     // Catch: Throwable -> L65
    L59:
        if (r7.contains("sdk/sso/token") == false) goto L62;
        com.bytedance.feedbackerlib.model.e.a.d(15001);     // Catch: Throwable -> L65
    L51:
        s.a(r21);
        s.a(r20);
        return null;
    L62:
        if (r7.contains("sdk/profile") == false) goto L51;
        com.bytedance.feedbackerlib.model.e.a.d(15011);     // Catch: Throwable -> L65
    L32:
        th = th;
    L42:
        com.bytedance.feedbackerlib.model.e.b.d().a(th.toString());     // Catch: Throwable -> L65
        if (r10 == null) goto L46;
        r10.append("execute http get failed: ");     // Catch: Throwable -> L65
        r10.append(th.toString());     // Catch: Throwable -> L65
    L46:
        if (r7.contains("sdk/sso/token") == false) goto L49;
        com.bytedance.feedbackerlib.model.e.a.d(15004);     // Catch: Throwable -> L65
        goto L51
    L49:
        if (r7.contains("sdk/profile") == false) goto L51;
        com.bytedance.feedbackerlib.model.e.a.d(15014);     // Catch: Throwable -> L65
        goto L51
    L38:
        e = e;
        r21 = null;
    L36:
        th = th;
        r21 = null;
        goto L42
    L65:
        th = move-exception;
        s.a(r19);
        s.a(r18);
        throw th;
    L53:
        e = e;
        r20 = null;
        r21 = null;
    L40:
        th = th;
        r20 = null;
        r21 = null;
        goto L42
    L25:
        r19 = b(r11);
        goto L68
    }

    private static void f() {
        if (f4265a == null) goto L5;
        return;
    L5:
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4265a != null) goto L9;
        a0.b r1 = new a0.b();     // Catch: Throwable -> L11
        TimeUnit r2 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L11
        r1.d(30000, r2);     // Catch: Throwable -> L11
        r1.n(30000, r2);     // Catch: Throwable -> L11
        r1.s(30000, r2);     // Catch: Throwable -> L11
        r1.o(true);     // Catch: Throwable -> L11
        r1.j(true);     // Catch: Throwable -> L11
        g(r1);     // Catch: Throwable -> L11
        f4265a = r1.c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    }

    private static a0.b g(a0.b r4) {
        SSLContext r0 = SSLContext.getInstance("TLS");     // Catch: Exception -> L10
        r0.init(null, null, null);     // Catch: Exception -> L10
        TrustManagerFactory r2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: Exception -> L10
        r2.init(null);     // Catch: Exception -> L10
        TrustManager[] r1 = r2.getTrustManagers();     // Catch: Exception -> L10
        if (r1.length != 1) goto L8;
        if ((r1[0] instanceof X509TrustManager) == false) goto L8;
        r4.q(new d(r0.getSocketFactory()), (X509TrustManager) r1[0]);     // Catch: Exception -> L10
        p000j.l r3 = new j.l.a(p000j.l.f18124i).a();     // Catch: Exception -> L10
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L10
        r5.add(r3);     // Catch: Exception -> L10
        r5.add(p000j.l.f18125j);     // Catch: Exception -> L10
        r5.add(p000j.l.f18126k);     // Catch: Exception -> L10
        r4.f(r5);     // Catch: Exception -> L10
    L8:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));     // Catch: Exception -> L10
    L9:
        return r4;
    }

    public static a0 h() {
        f();
        return f4265a;
    }
}
