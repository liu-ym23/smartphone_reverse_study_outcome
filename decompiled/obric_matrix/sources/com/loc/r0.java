package com.loc;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 {
    private static SoftReference<SSLContext> o;
    private static SoftReference<s0> p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLContext f7690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Proxy f7691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private o0.a f7693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d f7694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f7697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7700l;
    private String m;
    private f n;

    public static class a implements Cloneable, Comparable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7701f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f7702g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f7703h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f7704i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f7705j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7706k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7707l;
        public int m;
        public long n;
        public volatile AtomicInteger o;

        public a(c r3) {
            this.f7702g = r3.f7712h;
            this.f7703h = r3.f7714j;
            this.f7705j = r3.f7713i;
            this.f7706k = r3.r;
            this.f7707l = r3.s;
            this.m = r3.f7711g.a();
            this.f7704i = r3.f7710f;
            this.n = r3.f7715k;
            this.o = new AtomicInteger(1);
            if (this.f7706k != 10) goto L6;
            this.f7701f = 0;
            return;
        }

        public final a a() {
            return (a) super.clone();
        L4:
            return null;
        }

        public final String c() {
            String r1 = this.f7706k + "#";     // Catch: Exception -> L26
            if (TextUtils.isEmpty(this.f7705j) == true) goto L8;
            StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L26
            r2.append(r1);     // Catch: Exception -> L26
            r2.append(this.f7705j);     // Catch: Exception -> L26
            r2.append("#");     // Catch: Exception -> L26
        L9:
            String r3 = (r2.toString() + this.m + "#") + this.o + "#";     // Catch: Exception -> L26
            if (TextUtils.isEmpty(this.f7702g) == true) goto L13;
            StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L26
            r4.append(r3);     // Catch: Exception -> L26
            r4.append(this.f7702g);     // Catch: Exception -> L26
            r4.append("#");     // Catch: Exception -> L26
        L12:
            String r5 = r4.toString();     // Catch: Exception -> L26
            if (this.f7706k != 1) goto L18;
            StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L26
            r6.append(r5);     // Catch: Exception -> L26
            r6.append(this.f7704i);     // Catch: Exception -> L26
            r6.append("#");     // Catch: Exception -> L26
        L17:
            String r7 = r6.toString();     // Catch: Exception -> L26
            if (this.f7706k != 1) goto L23;
            StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L26
            r8.append(r7);     // Catch: Exception -> L26
            r8.append(this.n);     // Catch: Exception -> L26
            r8.append("#");     // Catch: Exception -> L26
        L24:
            String r9 = (r8.toString() + this.f7703h + "#") + this.f7707l;     // Catch: Exception -> L26
            String r0 = m5.f(k0.a(r9.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));     // Catch: Exception -> L26
            StringBuilder r10 = new StringBuilder("上报异常数据");     // Catch: Exception -> L26
            r10.append(r9);     // Catch: Exception -> L26
            r10.append("加密后：");     // Catch: Exception -> L26
            r10.append(r0);     // Catch: Exception -> L26
            r0.g();     // Catch: Exception -> L26
            return r0;
        L23:
            r8 = new StringBuilder();     // Catch: Exception -> L26
            r8.append(r7);     // Catch: Exception -> L26
            r8.append("-#");     // Catch: Exception -> L26
            goto L24
        L18:
            r6 = new StringBuilder();     // Catch: Exception -> L26
            r6.append(r5);     // Catch: Exception -> L26
            r6.append("-#");     // Catch: Exception -> L26
            goto L17
        L13:
            r4 = new StringBuilder();     // Catch: Exception -> L26
            r4.append(r3);     // Catch: Exception -> L26
            r4.append("-#");     // Catch: Exception -> L26
            goto L12
        L8:
            r2 = new StringBuilder();     // Catch: Exception -> L26
            r2.append(r1);     // Catch: Exception -> L26
            r2.append("-#");     // Catch: Exception -> L26
        L26:
            return null;
        }

        public final /* synthetic */ Object clone() {
            return a();
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object r1) {
            return this.f7701f - ((a) r1).f7701f;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HttpURLConnection f7708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7709b;

        public b(HttpURLConnection r1) {
            this.f7708a = r1;
            this.f7709b = this.f7709b;
        }
    }

    public static class c implements Cloneable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f7710f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public t0.b f7711g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f7712h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f7713i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f7714j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f7715k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f7716l;
        public long m;
        public long n;
        public long o;
        public String p;
        public String q;
        public int r;
        public int s;

        public c() {
            this.f7710f = "";
            this.f7711g = t0.b.f7807g;
            this.f7712h = "";
            this.f7713i = "";
            this.f7714j = "";
            this.f7715k = 0;
            this.f7716l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = "-";
            this.q = "-";
            this.r = 0;
            this.s = 0;
        }

        protected final c a() {
            return (c) super.clone();
        L4:
            return null;
        }

        protected final String c() {
            if (TextUtils.isEmpty(this.f7712h) == true) goto L5;
            String r0 = this.f7712h + "#";
        L7:
            if (TextUtils.isEmpty(this.f7713i) == true) goto L9;
            String r1 = r0 + this.f7713i + "#";
        L10:
            String r5 = (((r1 + this.f7711g.a() + "#") + this.m + "#") + this.o + "#") + this.f7715k;
            String r2 = m5.f(k0.a(r5.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            StringBuilder r3 = new StringBuilder("上报耗时数据");
            r3.append(r5);
            r3.append("加密后：");
            r3.append(r2);
            r0.g();
            return r2;
        L9:
            r1 = r0 + "-#";
            goto L10
        L5:
            r0 = "-#";
            goto L7
        }

        protected final /* synthetic */ Object clone() {
            return a();
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f7710f + "', degradeType=" + this.f7711g + ", serverIp='" + this.f7712h + "', path='" + this.f7713i + "', hostname='" + this.f7714j + "', totalTime=" + this.f7715k + ", DNSTime=" + this.f7716l + ", connectionTime=" + this.m + ", writeTime=" + this.n + ", readTime=" + this.o + ", serverTime='" + this.p + "', datasize='" + this.q + "', errorcode=" + this.r + ", errorcodeSub=" + this.s + '}';
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Vector<e> f7717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile e f7718b;

        private d() {
            this.f7717a = new Vector();
            this.f7718b = new e(0);
        }

        /* synthetic */ d(byte r1) {
            this();
        }

        public final e a(String r5) {
            if (TextUtils.isEmpty(r5) == true) goto L5;
            byte r0 = 0;
            int r1 = 0;
        L8:
            if (r1 >= this.f7717a.size()) goto L15;
            e r2 = this.f7717a.get(r1);
            if (r2 == null) goto L14;
            if (r2.a().equals(r5) == false) goto L14;
            return r2;
        L14:
            r1 = r1 + 1;
            goto L8
        L15:
            e r3 = new e(r0);
            r3.c(r5);
            this.f7717a.add(r3);
            return r3;
        L5:
            return this.f7718b;
        }
    }

    private static class e implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7720b;

        private e() {
        }

        /* synthetic */ e(byte r1) {
            this();
        }

        public final String a() {
            return this.f7720b;
        }

        public final void b(String r3) {
            if (TextUtils.isEmpty(this.f7719a) == false) goto L5;
        L12:
            this.f7719a = r3;
            return;
        L5:
            if (r3.contains(":") == false) goto L12;
            String[] r0 = r3.split(":");
            if (r0 == null) goto L12;
            if (r0.length <= 0) goto L12;
            this.f7719a = r0[0];
        }

        public final void c(String r1) {
            this.f7720b = r1;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String r3, SSLSession r4) {
            HostnameVerifier r0 = HttpsURLConnection.getDefaultHostnameVerifier();
            if (TextUtils.isEmpty(this.f7719a) == true) goto L7;
            return this.f7719a.equals(r3);
        L7:
            if (TextUtils.isEmpty(this.f7720b) == true) goto L11;
            return r0.verify(this.f7720b, r4);
        L11:
            return r0.verify(r3, r4);
        }
    }

    class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f7721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f7722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c f7723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a f7724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c f7725e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f7726f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        URL f7727g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ r0 f7728h;

        f(r0 r3) {
            this.f7728h = r3;
            this.f7721a = 0;
            this.f7722b = 0;
            this.f7723c = new c();
        }

        public final void a() {
            c r0 = this.f7723c;
            r0.m = SystemClock.elapsedRealtime() - this.f7722b;
        }

        public final void b(int r6) {
            "----errorcode-----".concat(String.valueOf(r6));
            r0.g();
            c r0 = this.f7723c;     // Catch: Throwable -> L21
            r0.f7715k = SystemClock.elapsedRealtime() - this.f7721a;     // Catch: Throwable -> L21
            c r1 = this.f7723c;     // Catch: Throwable -> L21
            r1.r = r6;     // Catch: Throwable -> L21
            if (r1.f7711g.j() == false) goto L6;
            j5.s(false, this.f7723c.f7714j);     // Catch: Throwable -> L21
        L6:
            boolean r7 = r0.i(this.f7728h, this.f7723c.f7714j);     // Catch: Throwable -> L21
            if (r7 == true) goto L9;
        L19:
            j5.q(this.f7727g.toString(), this.f7723c.f7711g.c(), true, r7);     // Catch: Throwable -> L21
            new StringBuilder("!!!error-").append(this.f7723c.toString());     // Catch: Throwable -> L21
            r0.g();     // Catch: Throwable -> L21
            return;
        L9:
            if (r0.o(this.f7728h) == false) goto L16;
            if (TextUtils.isEmpty(r0.d(this.f7728h)) == true) goto L16;
            if (this.f7723c.f7711g.b() == false) goto L16;
            j5.J();     // Catch: Throwable -> L21
        L16:
            if (this.f7723c.f7711g.c() == false) goto L18;
            j5.s(this.f7723c.f7711g.c(), this.f7723c.f7714j);     // Catch: Throwable -> L21
        L18:
            j5.H(this.f7725e);     // Catch: Throwable -> L21
            j5.r(false, this.f7724d);     // Catch: Throwable -> L21
            j5.C(this.f7723c);     // Catch: Throwable -> L21
        }

        public final void c(long r3) {
            DecimalFormat r0 = new DecimalFormat("0.00");
            this.f7723c.q = r0.format(r3 / 1024.0f);
        }

        public final void d(t0 r4, URL r5) {
            this.f7727g = r5;
            c r0 = this.f7723c;
            r0.f7713i = r5.getPath();
            c r1 = this.f7723c;
            r1.f7714j = r5.getHost();
            if (TextUtils.isEmpty(r0.d(this.f7728h)) == true) goto L8;
            if (r4.D().b() == false) goto L8;
            c r6 = this.f7723c;
            r6.f7712h = r6.f7714j.replace("[", "").replace("]", "");
            c r7 = this.f7723c;
            r7.f7714j = r0.d(this.f7728h);
        L8:
            if (r4.D().b() == false) goto L11;
            r4.g(this.f7723c.f7714j);
        L11:
            if (r4.D().g() == false) goto L14;
            this.f7726f = r4.G();
            return;
        }

        public final void e(u0 r8) {
            this.f7723c.f7715k = SystemClock.elapsedRealtime() - this.f7721a;     // Catch: Throwable -> L22
            if (r8 == null) goto L6;
            r8.f7861f = this.f7723c.f7711g.c();     // Catch: Throwable -> L22
        L6:
            if (this.f7723c.f7711g.b() == false) goto L11;
            c r9 = this.f7723c;     // Catch: Throwable -> L22
            if (r9.f7715k <= BDLocationConfig.sScanBleMaxInterval) goto L11;
            j5.s(false, r9.f7714j);     // Catch: Throwable -> L22
        L11:
            if (this.f7723c.f7711g.g() == false) goto L13;
            j5.s(false, this.f7726f);     // Catch: Throwable -> L22
        L13:
            boolean r10 = r0.i(this.f7728h, this.f7723c.f7714j);     // Catch: Throwable -> L22
            if (r10 == false) goto L20;
            j5.H(this.f7723c);     // Catch: Throwable -> L22
            j5.r(true, this.f7724d);     // Catch: Throwable -> L22
            c r1 = this.f7723c;     // Catch: Throwable -> L22
            if (r1.f7715k <= j5.s) goto L20;
            c r2 = r1.a();     // Catch: Throwable -> L22
            if (r2 == null) goto L20;
            r2.r = 1;     // Catch: Throwable -> L22
            j5.C(r2);     // Catch: Throwable -> L22
            new StringBuilder("!!!finish&error-").append(r2.toString());     // Catch: Throwable -> L22
            r0.g();     // Catch: Throwable -> L22
        L20:
            j5.q(this.f7727g.toString(), this.f7723c.f7711g.c(), false, r10);     // Catch: Throwable -> L22
            new StringBuilder("!!!finish-").append(this.f7723c.toString());     // Catch: Throwable -> L22
            r0.g();     // Catch: Throwable -> L22
            return;
        }

        public final void f() {
            c r0 = this.f7723c;
            r0.n = SystemClock.elapsedRealtime() - this.f7722b;
        }

        public final void g(int r1) {
            this.f7723c.s = r1;
        }

        public final void h() {
            c r0 = this.f7723c;
            r0.o = SystemClock.elapsedRealtime() - this.f7722b;
        }

        public final void i() {
            c r0 = this.f7723c.a();
            if (this.f7723c.f7715k <= j5.s) goto L5;
            r0.r = 1;
        L5:
            j5.l(r0);
        }
    }

    static {
    }

    r0() {
        this.f7695g = "";
        this.f7699k = false;
        this.f7700l = false;
        this.m = "";
        this.n = new f(this);
        j5.M();
        this.f7692d = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        s.e(th, "ht", "ic");
    }

    private static int a(Exception r1) {
        if ((r1 instanceof SSLHandshakeException) == false) goto L7;
        return 4101;
    L7:
        if ((r1 instanceof SSLKeyException) == false) goto L11;
        return 4102;
    L11:
        if ((r1 instanceof SSLProtocolException) == false) goto L15;
        return 4103;
    L15:
        if ((r1 instanceof SSLPeerUnverifiedException) == false) goto L19;
        return 4104;
    L19:
        if ((r1 instanceof ConnectException) == false) goto L23;
        return 6101;
    L23:
        if ((r1 instanceof SocketException) == false) goto L27;
        return 6102;
    L27:
        if ((r1 instanceof ConnectTimeoutException) == false) goto L31;
        return 2101;
    L31:
        if ((r1 instanceof SocketTimeoutException) == false) goto L34;
        return 2102;
    L34:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private u0 b(b r14) {
        String r2 = "";
        ByteArrayOutputStream r3 = null;
        InputStream r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r3 = null;
        r3 = null;
        q0.b();     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        HttpURLConnection r15 = r14.f7708a;     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        Map<String, List<String>> r5 = r15.getHeaderFields();     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        int r6 = r15.getResponseCode();     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        if (r5 == null) goto L39;
        List<String> r9 = r5.get("gsid");     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        if (r9 != null) goto L8;
    L10:
        this.n.f7723c.p = m(r5);     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        if (TextUtils.isEmpty(this.f7695g) == true) goto L39;
        if (this.f7699k == true) goto L16;
        boolean r10 = k(r5, true);     // Catch: Throwable -> L146
        char r11 = 2;
    L20:
        if (r10 == true) goto L22;
        if (r11 != 1) goto L39;
        q0.j(false, this.f7695g);     // Catch: Throwable -> L146
        goto L39
    L22:
        if (this.f7695g.equals("loc") == false) goto L31;
        String r12 = this.m;     // Catch: Throwable -> L146
        if (TextUtils.isEmpty(r12) == false) goto L26;
        r12 = r15.getURL().getHost();     // Catch: Throwable -> L146
    L26:
        String r13 = this.f7695g;     // Catch: Throwable -> L146
        if (r11 != 2) goto L29;
        boolean r16 = true;
    L30:
        j5.p(r13, r16, r12, r12, this.f7698j);     // Catch: Throwable -> L146
        goto L39
    L29:
        r16 = false;
        goto L30
    L31:
        String r17 = this.f7695g;     // Catch: Throwable -> L146
        if (r11 != 2) goto L34;
        boolean r18 = true;
    L35:
        j5.D(r17, r18);     // Catch: Throwable -> L146
        goto L39
    L34:
        r18 = false;
        goto L35
    L16:
        if (r5.containsKey("sc") == false) goto L18;
        r10 = k(r5, false);     // Catch: Throwable -> L146
        r11 = 1;
        goto L20
    L18:
        j5.O(this.f7695g);     // Catch: Throwable -> L146
        r10 = false;
        r11 = 0;
        goto L20
    L8:
        if (r9.size() <= 0) goto L10;
        r2 = r9.get(0);     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
    L39:
        if (r6 != 200) goto L100;
        ByteArrayOutputStream r7 = new ByteArrayOutputStream();     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        this.n.f7722b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L88 IOException -> L91 SocketTimeoutException -> L94 ConnectTimeoutException -> L97
        InputStream r19 = r15.getInputStream();     // Catch: Throwable -> L88 IOException -> L91 SocketTimeoutException -> L94 ConnectTimeoutException -> L97
        PushbackInputStream r110 = new PushbackInputStream(r19, 2);     // Catch: Throwable -> L80 IOException -> L82 SocketTimeoutException -> L84 ConnectTimeoutException -> L86
    L168:
        byte[] r8 = new byte[2];     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        r110.read(r8);     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        r110.unread(r8);     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        if (r8[0] == 31) goto L46;
    L48:
        r4 = r110;
    L49:
        byte[] r20 = new byte[1024];     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
    L50:
        int r21 = r4.read(r20);     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        if (r21 == (-1)) goto L53;
        r7.write(r20, 0, r21);     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        goto L50
    L53:
        this.n.h();     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        v.n();     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        u0 r22 = new u0();     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        r22.f7856a = r7.toByteArray();     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        r22.f7857b = r5;     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        r22.f7858c = this.f7692d;     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        r22.f7859d = r2;     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        q0.i(r15.getURL(), r22);     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        this.n.c(r22.f7856a.length);     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
        r7.close();     // Catch: Throwable -> L56
    L58:
        if (r19 != null) goto L163;
    L147:
        r110.close();     // Catch: Throwable -> L65
    L150:
        r4.close();     // Catch: Throwable -> L69
    L71:
        return r22;
    L69:
        th = move-exception;
        s.e(th, "ht", "par");
    L65:
        th = move-exception;
        s.e(th, "ht", "par");
        goto L150
    L163:
        r19.close();     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        s.e(th, "ht", "par");
    L56:
        th = move-exception;
        s.e(th, "ht", "par");
        goto L58
    L46:
        if (r8[1] != (-117)) goto L48;
        r4 = new GZIPInputStream(r110);     // Catch: Throwable -> L72 IOException -> L74 SocketTimeoutException -> L76 ConnectTimeoutException -> L78
    L76:
        e = e;
    L178:
        throw e;     // Catch: Throwable -> L123
    L78:
        e = e;
    L175:
        throw e;     // Catch: Throwable -> L123
    L74:
        e = e;
        InputStream r23 = r4;
    L93:
        r3 = r7;
        ?? r24 = r23;
    L149:
    L115:
        th = th;
    L125:
        if (r3 != null) goto L153;
    L130:
        if (r19 != null) goto L155;
    L135:
        if (r110 != null) goto L157;
    L140:
        if (r24 == 0) goto L176;
        r24.close();     // Catch: Throwable -> L143
        throw th;
    L143:
        th = move-exception;
        s.e(th, "ht", "par");
        throw th;
    L176:
        throw th;
    L157:
        r110.close();     // Catch: Throwable -> L138
    L138:
        th = move-exception;
        s.e(th, "ht", "par");
        goto L140
    L155:
        r19.close();     // Catch: Throwable -> L133
    L133:
        th = move-exception;
        s.e(th, "ht", "par");
        goto L135
    L153:
        r3.close();     // Catch: Throwable -> L128
    L128:
        th = move-exception;
        s.e(th, "ht", "par");
        goto L130
    L107:
        if ((e instanceof InterruptedIOException) == false) goto L114;
        h5 r25 = new h5("IO 操作异常 - IOException", r2, this.f7692d);     // Catch: Throwable -> L115
        if (TextUtils.isEmpty(e.getMessage()) == false) goto L111;
        throw r25;     // Catch: Throwable -> L115
    L111:
        if (e.getMessage().equals("thread interrupted") == false) goto L174;
        r25.l();     // Catch: Throwable -> L115
        throw r25;     // Catch: Throwable -> L115
    L174:
        throw r25;     // Catch: Throwable -> L115
    L114:
        throw e;     // Catch: Throwable -> L115
    L72:
        th = th;
        r24 = r4;
    L90:
        r3 = r7;
    L84:
        e = e;
    L86:
        e = e;
    L82:
        e = e;
        r23 = null;
        r110 = null;
    L80:
        th = th;
        r24 = 0;
        r110 = null;
        goto L90
    L94:
        e = e;
    L97:
        e = e;
    L91:
        e = e;
        r23 = null;
        r19 = null;
        r110 = null;
    L88:
        th = th;
        r24 = 0;
        r19 = null;
        r110 = null;
        goto L90
    L100:
        h5 r26 = new h5("网络异常原因：" + r15.getResponseMessage() + " 网络异常状态码：" + r6 + "  " + r2 + " " + this.f7692d, r2, this.f7692d);     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        r26.b(r15.getResponseMessage());     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        r26.c(r5);     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        this.n.g(r6);     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        this.n.b(10);     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        r26.j();     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
        throw r26;     // Catch: Throwable -> L102 IOException -> L104 SocketTimeoutException -> L117 ConnectTimeoutException -> L120
    L123:
        th = th;
        r24 = r14;
    L117:
        e = move-exception;
        throw e;     // Catch: Throwable -> L123
    L120:
        e = move-exception;
        throw e;     // Catch: Throwable -> L123
    L104:
        e = e;
        r24 = 0;
        r19 = null;
        r110 = null;
    L102:
        th = th;
        r24 = 0;
        r19 = null;
        r110 = null;
        goto L125
    }

    static /* synthetic */ String d(r0 r0) {
        return r0.f7698j;
    }

    private static String e(String r4, String r5) {
        String r0 = Build.MANUFACTURER;
        Context r1 = j5.f7428g;
        if (r1 == null) goto L5;
        String r2 = u5.d(r1);
    L7:
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", new Object[]{r4, r5, r0, r2});
    L5:
        r2 = "";
        goto L7
    }

    static String f(Map<String, String> r4) {
        if (r4 == null) goto L15;
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L5:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, String> r1 = r5.next();
        String r2 = r1.getKey();
        String r3 = r1.getValue();
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append("&");
    L12:
        r0.append(URLEncoder.encode(r2));
        r0.append("=");
        r0.append(URLEncoder.encode(r3));
        goto L5
    L14:
        return r0.toString();
    L15:
        return null;
    }

    public static void g() {
    }

    private void h(Map<String, String> r5, HttpURLConnection r6) {
        if (r5 != null) goto L46;
    L7:
        HashMap<String, String> r7 = o0.f7584d;     // Catch: Throwable -> L43
        if (r7 == null) goto L14;
        Iterator<String> r8 = r7.keySet().iterator();     // Catch: Throwable -> L43
    L11:
        if (r8.hasNext() == false) goto L14;
        String r0 = r8.next();     // Catch: Throwable -> L43
        r6.addRequestProperty(r0, o0.f7584d.get(r0));     // Catch: Throwable -> L43
    L14:
        String r1 = "";
        if (this.f7697i.contains("/v3/iasdkauth") == false) goto L17;
    L25:
        r6.addRequestProperty("csid", this.f7692d);     // Catch: Throwable -> L43
        if (j(this.n.f7723c.f7714j) == false) goto L50;
        f r9 = this.n;     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r9.f7723c.f7712h) == true) goto L32;
        r1 = m5.f(k0.a(r9.f7723c.f7712h.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));     // Catch: Throwable -> L43
        StringBuilder r2 = new StringBuilder("上报本次请求serverIp:");     // Catch: Throwable -> L43
        r2.append(r9.f7723c.f7712h);     // Catch: Throwable -> L43
        r2.append("加密后：");     // Catch: Throwable -> L43
        r2.append(r1);     // Catch: Throwable -> L43
    L32:
        if (TextUtils.isEmpty(r1) == true) goto L35;
        r6.addRequestProperty("sip", r1);     // Catch: Throwable -> L43
    L35:
        if (j5.z == false) goto L39;
        c r10 = j5.R();     // Catch: Throwable -> L43
        if (r10 == null) goto L39;
        r6.addRequestProperty("nls", r10.c());     // Catch: Throwable -> L43
        this.n.f7725e = r10;     // Catch: Throwable -> L43
    L39:
        a r11 = j5.P();     // Catch: Throwable -> L43
        if (r11 == null) goto L51;
        r6.addRequestProperty("nlf", r11.c());     // Catch: Throwable -> L43
        this.n.f7724d = r11;     // Catch: Throwable -> L43
        return;
    L43:
        th = move-exception;
        s.e(th, "ht", "adh");
        return;
    L51:
        return;
    L50:
        return;
    L17:
        if (TextUtils.isEmpty(this.f7695g) == true) goto L25;
        if (j5.L(this.f7695g) == false) goto L25;
        this.f7699k = true;     // Catch: Throwable -> L43
        j5.h r12 = j5.Q(this.f7695g);     // Catch: Throwable -> L43
        r6.addRequestProperty("lct", String.valueOf(r12.f7459a));     // Catch: Throwable -> L43
        r6.addRequestProperty("lct-info", r12.f7460b);     // Catch: Throwable -> L43
        r6.addRequestProperty("aks", j5.F(j5.d(this.f7695g)));     // Catch: Throwable -> L43
        if (j5.y(this.f7695g) == null) goto L23;
        String r13 = j5.y(this.f7695g).e();     // Catch: Throwable -> L43
    L24:
        r6.addRequestProperty("lct-args", e(r13, this.f7695g));     // Catch: Throwable -> L43
        goto L25
    L23:
        r13 = "";
        goto L24
    L46:
        Iterator<String> r3 = r5.keySet().iterator();     // Catch: Throwable -> L43
    L5:
        if (r3.hasNext() == false) goto L7;
        String r4 = r3.next();     // Catch: Throwable -> L43
        r6.addRequestProperty(r4, r5.get(r4));     // Catch: Throwable -> L43
        goto L5
    }

    static /* synthetic */ boolean i(r0 r0, String r1) {
        return r0.j(r1);
    }

    private boolean j(String r3) {
        if (this.f7696h == false) goto L5;
        return true;
    L5:
        if (TextUtils.isEmpty(this.f7698j) == true) goto L11;
        if (this.f7698j.contains("rest") == false) goto L9;
        return true;
    L9:
        if (this.f7698j.contains("apilocate") == false) goto L11;
        return true;
    L11:
        if (p(r3) == true) goto L19;
        return false;
    L19:
        return true;
    }

    private boolean k(Map<String, List<String>> r7, boolean r8) {
        List<String> r4 = r7.get("sc");     // Catch: Throwable -> L31
        if (r4 != null) goto L6;
    L17:
        boolean r0 = false;
    L18:
        if (r0 == true) goto L20;
        return false;
    L20:
        if (r8 == true) goto L22;
        return true;
    L22:
        if (r7.containsKey("lct") == false) goto L30;
        List<String> r9 = r7.get("lct");     // Catch: Throwable -> L31
        if (r9 == null) goto L30;
        if (r9.size() <= 0) goto L30;
        return j5.u(this.f7695g, j5.a(r9));
    L6:
        if (r4.size() <= 0) goto L17;
        String r5 = r4.get(0);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r5) == true) goto L17;
        if (r5.contains("#") == true) goto L12;
    L11:
        r0 = true;
        goto L18
    L12:
        String[] r1 = r5.split("#");     // Catch: Throwable -> L31
        if (r1.length <= 1) goto L17;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r1[1]) == false) goto L17;
    L30:
        return false;
    }

    private s0 l() {
        SoftReference<s0> r1 = p;     // Catch: Throwable -> L15
        if (r1 != null) goto L6;
    L7:
        p = new SoftReference(new s0(j5.f7428g, this.f7690b));     // Catch: Throwable -> L15
    L9:
        if (o == null) goto L11;
        s0 r2 = p.get();     // Catch: Throwable -> L15
    L12:
        if (r2 != null) goto L20;
        return new s0(j5.f7428g, this.f7690b);
    L20:
        return r2;
    L11:
        r2 = null;
        goto L12
    L6:
        if (r1.get() != null) goto L9;
    L15:
        th = move-exception;
        v.m(th, "ht", "gsf");
        return null;
    }

    private static String m(Map<String, List<String>> r4) {
        List<String> r5 = r4.get("sc");     // Catch: Throwable -> L17
        if (r5 != null) goto L6;
        return "";
    L6:
        if (r5.size() <= 0) goto L20;
        String r6 = r5.get(0);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r6) == false) goto L10;
        return "";
    L10:
        if (r6.contains("#") == false) goto L22;
        String[] r7 = r6.split("#");     // Catch: Throwable -> L17
        if (r7.length <= 1) goto L23;
        r6 = r7[0];     // Catch: Throwable -> L17
    L23:
        return "";
    L22:
        return r6;
    L20:
        return "";
    L24:
        return "";
    }

    private void n(t0 r3) {
        this.f7694f = new d(0);
        this.f7700l = r3.H();
        this.f7691c = r3.x();
        this.f7693e = r3.C();
        this.f7696h = r3.z();
        this.f7695g = r3.I();
        this.f7689a = n5.a().e(r3.B());
        if (r3.D().b() == false) goto L5;
        String r0 = r3.v();
    L6:
        this.f7697i = r0;
        this.f7697i = q0.a(r0, this.f7695g);
        this.f7698j = r3.s();
        if ("loc".equals(this.f7695g) == false) goto L24;
        String r1 = r3.u();
        String r4 = r3.v();
        if (TextUtils.isEmpty(r1) == true) goto L12;
        new URL(r1).getHost();     // Catch: Exception -> L18
    L12:
        if (TextUtils.isEmpty(r4) == true) goto L25;
        if (TextUtils.isEmpty(this.f7698j) == true) goto L16;
        return;
    L16:
        new URL(r4).getHost();     // Catch: Exception -> L19
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r0 = r3.u();
        goto L6
    }

    static /* synthetic */ boolean o(r0 r0) {
        return r0.f7700l;
    }

    private static boolean p(String r1) {
        if (r1.contains("rest") == false) goto L5;
        return true;
    L5:
        if (r1.contains("apilocate") == true) goto L11;
        return false;
    L11:
        return true;
    }

    private b q(t0 r15) {
        f r1 = this.n;
        t0.b r2 = r15.D();
        c r3 = r1.f7723c;
        r3.f7710f = r1.f7728h.f7692d;
        r3.f7711g = r2;
        r1.f7721a = SystemClock.elapsedRealtime();
        Map<String, String> r4 = r15.b();
        if (r4 != null) goto L5;
        r4 = new HashMap();
    L5:
        e r5 = this.f7694f.a(this.f7698j);
        int r6 = o0.f7581a;
        String r7 = this.f7697i;
        Uri r8 = Uri.parse(r7);
        String r9 = r8.getHost();
        if (r6 != 1) goto L8;
        String r10 = o0.f7582b;
    L10:
        boolean r11 = true;
    L18:
        if (TextUtils.isEmpty(r10) == true) goto L27;
        r15.F();
        r7 = r8.buildUpon().encodedAuthority(r10).build().toString();
        if (r11 == false) goto L23;
        if (r4 == null) goto L23;
        r4.put("targetHost", r9);
        this.m = r9;
    L23:
        if (r11 == false) goto L27;
        if (this.f7689a == false) goto L27;
        r5.b(r10);
    L27:
        this.f7697i = r7;
        URL r12 = new URL(this.f7697i);
        this.n.d(r15, r12);
        if (p(r12.getHost()) == false) goto L88;
        if (r15.t() == false) goto L88;
        t0.b r13 = r15.D();
        String r14 = this.n.f7723c.f7714j;
        if (j(r14) == true) goto L34;
    L43:
        boolean r16 = false;
    L44:
        if (r16 == false) goto L88;
        this.n.f7722b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L132
        InetAddress[] r17 = InetAddress.getAllByName(this.n.f7723c.f7714j);     // Catch: Throwable -> L132
        if (r17 != null) goto L49;
    L80:
        String r18 = "";
    L81:
        f r19 = this.n;     // Catch: Throwable -> L132
        "---onDNSEnd---ip=".concat(String.valueOf(r18));     // Catch: Throwable -> L132
        r19.f7723c.f7712h = r18.replace("[", "").replace("]", "");     // Catch: Throwable -> L132
        r19.f7723c.f7716l = SystemClock.elapsedRealtime() - r19.f7722b;     // Catch: Throwable -> L132
        if (TextUtils.isEmpty(r18) == true) goto L88;
        Uri r20 = Uri.parse(this.f7697i);     // Catch: Throwable -> L132
        String r21 = r20.getHost();     // Catch: Throwable -> L132
        Uri r22 = r20.buildUpon().encodedAuthority(r18).build();     // Catch: Throwable -> L132
        this.f7698j = r21;     // Catch: Throwable -> L132
        r4.put("host", r21);     // Catch: Throwable -> L132
        if (this.f7689a == false) goto L86;
        r5.c(r21);     // Catch: Throwable -> L132
    L86:
        this.f7697i = r22.toString();     // Catch: Throwable -> L132
        goto L88
    L49:
        if (r17.length <= 0) goto L80;
        if (r17[0] == null) goto L80;
        if (j5.t() == true) goto L55;
    L57:
        boolean r23 = false;
    L58:
        "---canUseIpv6---".concat(String.valueOf(r23));     // Catch: Throwable -> L132
        if (r23 == false) goto L67;
        int r24 = 0;
    L62:
        if (r24 >= r17.length) goto L74;
        if ((r17[r24] instanceof Inet6Address) == true) goto L65;
        r24 = r24 + 1;     // Catch: Throwable -> L132
        goto L62
    L65:
        r18 = "[" + r17[r24].getHostAddress() + "]";     // Catch: Throwable -> L132
    L76:
        if (TextUtils.isEmpty(r18) == false) goto L81;
        InetAddress r25 = r17[0];     // Catch: Throwable -> L132
        r18 = r25.getHostAddress();     // Catch: Throwable -> L132
        if ((r25 instanceof Inet6Address) == false) goto L81;
        r18 = "[" + r18 + "]";     // Catch: Throwable -> L132
    L74:
        r18 = "";
        goto L76
    L67:
        int r26 = 0;
    L69:
        if (r26 >= r17.length) goto L74;
        if ((r17[r26] instanceof Inet4Address) == true) goto L72;
        r26 = r26 + 1;     // Catch: Throwable -> L132
        goto L69
    L72:
        r18 = r17[r26].getHostAddress();     // Catch: Throwable -> L132
        goto L76
    L55:
        if (j5.I() == false) goto L57;
        r23 = true;
        goto L58
    L34:
        if (r13.b() == false) goto L39;
        if (j5.u == false) goto L39;
    L37:
        r16 = true;
    L39:
        if (r13.c() == false) goto L43;
        if (j5.U(r14) == false) goto L43;
    L88:
        if (this.f7689a == false) goto L90;
        this.f7697i = n5.b(this.f7697i);
    L90:
        StringBuilder r27 = new StringBuilder("是否降级=");
        r27.append(r15.D());
        r27.append("-最终url=");
        r27.append(this.f7697i);
        URL r28 = new URL(this.f7697i);
        o0.a r29 = this.f7693e;
        if (r29 == null) goto L93;
        URLConnection r30 = r29.a();
    L94:
        if (r30 != null) goto L100;
        Proxy r31 = this.f7691c;
        if (r31 == null) goto L98;
        r30 = r28.openConnection(r31);
        goto L100
    L98:
        r30 = r28.openConnection();
    L100:
        if (this.f7689a == true) goto L136;
        HttpURLConnection r32 = (HttpURLConnection) r30;
    L126:
        if (Build.VERSION.SDK != null) goto L128;
    L130:
        int r110 = (int) (((long) r15.E()) - (this.n.f7723c.f7716l / 1000));
        h(r4, r32);
        r32.setConnectTimeout(r110);
        r32.setReadTimeout(r110);
        r32.setRequestMethod("POST");
        r32.setUseCaches(false);
        r32.setDoInput(true);
        r32.setDoOutput(true);
        return new b(r32);
    L128:
        if (Build.VERSION.SDK_INT <= 13) goto L130;
        r32.setRequestProperty("Connection", "close");
        goto L130
    L136:
        SoftReference<SSLContext> r33 = o;     // Catch: Throwable -> L133
        if (r33 != null) goto L104;
    L105:
        o = new SoftReference(SSLContext.getInstance("TLS"));     // Catch: Throwable -> L133
    L106:
        SoftReference<SSLContext> r34 = o;     // Catch: Throwable -> L133
        if (r34 == null) goto L110;
        SSLContext r35 = r34.get();     // Catch: Throwable -> L133
    L111:
        if (r35 == null) goto L134;
    L113:
        r35.init(null, null, null);     // Catch: Throwable -> L115
        this.f7690b = r35;     // Catch: Throwable -> L115
    L117:
        HttpsURLConnection r36 = (HttpsURLConnection) r30;
        if (j5.g.f7453a == false) goto L122;
        s0 r0 = l();
        if (r0 == null) goto L122;
        r36.setSSLSocketFactory(r0);
        r0.b();
    L123:
        r36.setHostnameVerifier(r5);
        r32 = r36;
    L122:
        r36.setSSLSocketFactory(this.f7690b.getSocketFactory());
    L115:
        th = move-exception;
        s.e(th, "ht", "ne");
        goto L117
    L134:
        r35 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L115
        goto L113
    L104:
        if (r33.get() != null) goto L106;
    L110:
        r35 = null;
        goto L111
    L93:
        r30 = null;
        goto L94
    L8:
        if (r6 == 2) goto L11;
        r10 = "";
        goto L10
    L11:
        HashMap<String, String> r37 = o0.f7583c;
        if (r37 == null) goto L14;
        r10 = r37.get(r9);
    L15:
        r11 = false;
        goto L18
    L14:
        r10 = "";
        goto L15
    }

    final u0 c(t0 r14) {
        HttpURLConnection r7 = null;
        n(r14);     // Catch: Throwable -> L71 h5 -> L74 IOException -> L82 InterruptedIOException -> L116 SocketTimeoutException -> L87 SocketException -> L90 UnknownHostException -> L93 MalformedURLException -> L96 ConnectTimeoutException -> L99 ConnectException -> L102 SSLException -> L105
        u0 r8 = q0.o(this.f7697i, this.f7695g);     // Catch: Throwable -> L71 h5 -> L74 IOException -> L82 InterruptedIOException -> L116 SocketTimeoutException -> L87 SocketException -> L90 UnknownHostException -> L93 MalformedURLException -> L96 ConnectTimeoutException -> L99 ConnectException -> L102 SSLException -> L105
        if (r8 == null) goto L7;
        this.n.i();
        return r8;
    L7:
        b r9 = q(r14);     // Catch: Throwable -> L71 h5 -> L74 IOException -> L82 InterruptedIOException -> L116 SocketTimeoutException -> L87 SocketException -> L90 UnknownHostException -> L93 MalformedURLException -> L96 ConnectTimeoutException -> L99 ConnectException -> L102 SSLException -> L105
        HttpURLConnection r10 = r9.f7708a;     // Catch: Throwable -> L71 h5 -> L74 IOException -> L82 InterruptedIOException -> L116 SocketTimeoutException -> L87 SocketException -> L90 UnknownHostException -> L93 MalformedURLException -> L96 ConnectTimeoutException -> L99 ConnectException -> L102 SSLException -> L105
        this.n.f7722b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        r10.connect();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        this.n.a();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        byte[] r11 = r14.q();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (r11 != null) goto L11;
    L12:
        Map<String, String> r15 = r14.r();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        HashMap<String, String> r12 = o0.f7585e;     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (r12 == null) goto L17;
        if (r15 == null) goto L16;
        r15.putAll(r12);     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        goto L17
    L16:
        r15 = r12;
    L17:
        String r16 = f(r15);     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (TextUtils.isEmpty(r16) == true) goto L20;
        r11 = u5.o(r16);     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L20:
        if (r11 != null) goto L22;
    L42:
        u0 r17 = b(r9);     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        this.n.e(r17);     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (r10 != null) goto L117;
    L48:
        this.n.i();
        return r17;
    L117:
        r10.disconnect();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        s.e(th, "ht", "mPt");
        goto L48
    L22:
        if (r11.length <= 0) goto L42;
        this.n.f7722b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L34
        OutputStream r18 = r10.getOutputStream();     // Catch: Throwable -> L34
        DataOutputStream r13 = new DataOutputStream(r18);     // Catch: Throwable -> L32
        r13.write(r11);     // Catch: Throwable -> L30
        r13.close();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (r18 == null) goto L29;
        r18.close();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L29:
        this.n.f();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L30:
        Throwable th = th;
    L36:
        if (r13 == null) goto L38;
        r13.close();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L38:
        if (r18 == null) goto L40;
        r18.close();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L40:
        this.n.f();     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        throw th;     // Catch: Throwable -> L50 h5 -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L32:
        th = move-exception;
        r13 = null;
        th = th;
    L34:
        th = move-exception;
        r13 = null;
        th = th;
        r18 = null;
        goto L36
    L11:
        if (r11.length != 0) goto L20;
    L52:
        e = e;
    L76:
        if (e.k() == false) goto L78;
    L80:
        s.e(e, "ht", "mPt");     // Catch: Throwable -> L108
        throw e;     // Catch: Throwable -> L108
    L78:
        if (e.i() == 10) goto L80;
        this.n.b(e.i());     // Catch: Throwable -> L108
    L67:
        e = e;
    L103:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.n.g(a(e));     // Catch: Throwable -> L108
        this.n.b(6);     // Catch: Throwable -> L108
        throw new h5("http连接失败 - ConnectionException");     // Catch: Throwable -> L108
    L63:
        e = e;
    L97:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.n.b(8);     // Catch: Throwable -> L108
        throw new h5("url异常 - MalformedURLException");     // Catch: Throwable -> L108
    L59:
        e = e;
    L91:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.n.g(a(e));     // Catch: Throwable -> L108
        this.n.b(6);     // Catch: Throwable -> L108
        throw new h5("socket 连接异常 - SocketException");     // Catch: Throwable -> L108
    L57:
        e = e;
    L88:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.n.g(a(e));     // Catch: Throwable -> L108
        this.n.b(2);     // Catch: Throwable -> L108
        throw new h5("socket 连接超时 - SocketTimeoutException");     // Catch: Throwable -> L108
    L61:
        e = e;
    L94:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.n.b(5);     // Catch: Throwable -> L108
        throw new h5("未知主机 - UnKnowHostException");     // Catch: Throwable -> L108
    L69:
        e = e;
    L106:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.n.g(a(e));     // Catch: Throwable -> L108
        this.n.b(4);     // Catch: Throwable -> L108
        throw new h5("IO 操作异常 - IOException");     // Catch: Throwable -> L108
    L65:
        e = e;
    L100:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.n.g(a(e));     // Catch: Throwable -> L108
        this.n.b(2);     // Catch: Throwable -> L108
        throw new h5("IO 操作异常 - IOException");     // Catch: Throwable -> L108
    L54:
        e = e;
    L83:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.n.b(7);     // Catch: Throwable -> L108
        throw new h5("IO 操作异常 - IOException");     // Catch: Throwable -> L108
    L50:
        th = th;
    L72:
        s.e(th, "ht", "mPt");     // Catch: Throwable -> L108
        this.n.b(9);     // Catch: Throwable -> L108
        throw new h5("未知的错误");     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        if (0 != 0) goto L126;
    L114:
        this.n.i();
        throw th;
    L126:
        r7.disconnect();     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        s.e(th, "ht", "mPt");
    L74:
        e = e;
    L102:
        e = e;
    L96:
        e = e;
    L90:
        e = e;
    L87:
        e = e;
    L93:
        e = e;
    L105:
        e = e;
    L99:
        e = e;
    L82:
        e = e;
    L71:
        th = th;
    L85:
        this.n.g(7101);     // Catch: Throwable -> L108
        this.n.b(7);     // Catch: Throwable -> L108
        throw new h5("未知的错误");     // Catch: Throwable -> L108
    }
}
