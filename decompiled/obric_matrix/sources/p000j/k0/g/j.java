package p000j.k0.g;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.matrix.common_api.INetworkApi;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000j.a;
import p000j.a0;
import p000j.d0;
import p000j.e;
import p000j.e0;
import p000j.f0;
import p000j.h0;
import p000j.k0.c;
import p000j.k0.f.g;
import p000j.l0.d;
import p000j.l0.f;
import p000j.s;
import p000j.w;
import p000j.x;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements x {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<String> f17894g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a0 f17895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile g f17896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f17897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f17898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f17899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f17900f;

    static {
        f17894g = c.u(new String[]{"Accept", "Accept-Charset", "Accept-Encoding", "Accept-Language", "Authorization", "Cache-Control", "Connection", "Content-Length", INetworkApi.CONTENT_TYPE, "Host", "If-Match", "If-Modified-Since", "If-None-Match", "If-Range", "If-Unmodified-Since", "Origin", "Pragma", "Proxy-Authorization", "Proxy-Connection", "Range", "Referer", "Transfer-Encoding", "User-Agent"});
    }

    public j(a0 r1, boolean r2) {
        this.f17899e = f.f18161a;
        this.f17900f = false;
        this.f17895a = r1;
    }

    private a d(w r19) {
        if (r19.n() == false) goto L5;
        SSLSocketFactory r2 = this.f17895a.J();
        HostnameVerifier r10 = this.f17895a.q();
        SSLSocketFactory r9 = r2;
        p000j.g r11 = this.f17895a.d();
    L7:
        return new a(r19.m(), r19.y(), this.f17895a.k(), this.f17895a.I(), r9, r10, r11, this.f17895a.E(), this.f17895a.D(), this.f17895a.C(), this.f17895a.h(), this.f17895a.F(), this.f17895a.K());
    L5:
        r9 = null;
        r10 = null;
        r11 = null;
        goto L7
    }

    private d0 e(f0 r12, h0 r13, e r14, s r15) {
        if (r12 == null) goto L85;
        int r0 = r12.s();
        String r1 = r12.Y().f();
        boolean r3 = false;
        e0 r4 = null;
        if (r0 == 307) goto L49;
        if (r0 == 308) goto L49;
        if (r0 == 401) goto L47;
        if (r0 == 503) goto L37;
        if (r0 == 407) goto L31;
        if (r0 == 408) goto L18;
        switch(r0) {
            case 300: goto L49;
            case 301: goto L49;
            case 302: goto L49;
            case 303: goto L49;
            default: goto L16;
        };
    L16:
        return null;
    L18:
        if (this.f17895a.H() == true) goto L20;
        return null;
    L20:
        r12.Y().a();
        if (r12.S() == null) goto L26;
        if (r12.S().s() != 408) goto L26;
        return null;
    L26:
        if (o(r12, 0) <= 0) goto L29;
        return null;
    L29:
        return r12.Y();
    L31:
        if (r13.c().type() != Proxy.Type.HTTP) goto L35;
        return this.f17895a.E().a(r13, r12);
    L35:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L37:
        if (r12.S() == null) goto L42;
        if (r12.S().s() != 503) goto L42;
        return null;
    L42:
        if (o(r12, Integer.MAX_VALUE) == 0) goto L44;
        return null;
    L44:
        return r12.Y();
    L47:
        return this.f17895a.a().a(r13, r12);
    L49:
        if (this.f17895a.o() == true) goto L51;
        return null;
    L51:
        String r16 = r12.A("Location");
        if (r16 != null) goto L54;
        return null;
    L54:
        w r17 = r12.Y().k().C(r16);
        if (r17 != null) goto L58;
        return null;
    L58:
        if (r17.D().equals(r12.Y().k().D()) == false) goto L60;
    L62:
        d0.a r2 = r12.Y().g();
        if (f.b(r1) == false) goto L80;
        if (f.d(r1) == false) goto L67;
    L68:
        r3 = true;
    L70:
        if (k(r0) == false) goto L72;
    L74:
        if (r3 == false) goto L76;
        r4 = r12.Y().a();
    L76:
        r2.f(r1, r4);
    L77:
        if (r3 == true) goto L80;
        r2.h("Transfer-Encoding");
        r2.h("Content-Length");
        r2.h(INetworkApi.CONTENT_TYPE);
        goto L80
    L72:
        if (f.c(r1) == false) goto L74;
        r2.f("GET", null);
        goto L77
    L67:
        if (k(r0) == false) goto L70;
    L80:
        if (p(r12, r17) == true) goto L82;
        r2.h("Authorization");
    L82:
        f(r14, r12.Y(), r17, r2, r15);
        r2.l(r17);
        return r2.b();
    L60:
        if (this.f17895a.p() == true) goto L62;
        return null;
    L85:
        throw new IllegalStateException();
    }

    private void f(e r9, d0 r10, w r11, d0.a r12, s r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11.m()) == false) goto L6;
        return;
    L6:
        if (this.f17895a.m() == false) goto L9;
        return;
    L9:
        if (r10.e() == true) goto L13;
        if (r10.h().n() == true) goto L13;
    L15:
        boolean r0 = false;
    L16:
        if (r0 == false) goto L21;
        u(r9, r10, r11, true, r12, r13);
        if (p000j.l0.a.h(r11.m()) == false) goto L35;
        r12.a("x-metasec-ok-bypass-downgrade-cookie", LocationInfoConst.ALLOW_USE_LOCATION);
        return;
    L35:
        return;
    L21:
        if (p000j.l0.a.j().f().f18152f.get() == false) goto L23;
        return;
    L23:
        if (r10.k().m().equals(r11.m()) == false) goto L25;
        return;
    L25:
        if (r10.h() == null) goto L30;
        if (r11.m().equals(r10.h().m()) == false) goto L30;
        return;
    L30:
        if (i(r11.m()) == true) goto L39;
        u(r9, r10, r11, false, r12, r13);
        return;
    L39:
        return;
    L13:
        if (r11.n() == true) goto L15;
        r0 = true;
        goto L16
    }

    private boolean h(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        Iterator<String> r5 = p000j.l0.a.j().f().f18150d.iterator();
    L7:
        if (r5.hasNext() == false) goto L17;
        String r1 = r5.next();
        if (r6.equals(r1) == true) goto L10;
        if (r1.startsWith(".") == true) goto L15;
        r1 = "." + r1;
    L15:
        if (r6.toLowerCase().endsWith(r1.toLowerCase()) == false) goto L7;
        return true;
    L10:
        return true;
    L17:
        return false;
    }

    private boolean i(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return false;
    L6:
        Iterator<String> r4 = p000j.l0.a.j().f().f18148b.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        String r0 = r4.next();
        if (r5.equals(r0) == true) goto L11;
        if (r0.startsWith(".") == true) goto L16;
        r0 = "." + r0;
    L16:
        if (r5.toLowerCase().endsWith(r0.toLowerCase()) == false) goto L8;
        return true;
    L11:
        return true;
    L18:
        p000j.l0.a.j();
        return p000j.l0.a.h(r5);
    }

    private boolean j(IOException r3, boolean r4) {
        if ((r3 instanceof ProtocolException) == false) goto L6;
        return false;
    L6:
        if ((r3 instanceof InterruptedIOException) == false) goto L13;
        if ((r3 instanceof SocketTimeoutException) == false) goto L21;
        if (r4 == false) goto L11;
        return false;
    L11:
        return true;
    L21:
        return false;
    L13:
        if ((r3 instanceof SSLHandshakeException) == false) goto L18;
        if ((r3.getCause() instanceof CertificateException) == false) goto L18;
        return false;
    L18:
        if ((r3 instanceof SSLPeerUnverifiedException) == false) goto L20;
        return false;
    L20:
        return true;
    }

    private boolean k(int r1) {
        if (r1 != 308) goto L5;
        return true;
    L5:
        if (r1 == 307) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean l(IOException r2, g r3, boolean r4, d0 r5) {
        r3.r(r2);
        if (this.f17895a.H() == true) goto L5;
        return false;
    L5:
        if (r4 == false) goto L10;
        if (n(r2, r5) == false) goto L10;
        return false;
    L10:
        if (j(r2, r4) == true) goto L14;
        return r(r2, r5);
    L14:
        if (t().h() == false) goto L16;
        return true;
    L16:
        return r(r2, r5);
    }

    private void m(e r5, d0 r6, w r7, s r8, boolean r9, boolean r10, List<String> r11, p000j.l0.a.C0470a r12) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L16
        r0.put("src", "ttok");     // Catch: JSONException -> L16
        if (r12.f18153g.get() == false) goto L6;
        r0.put("origin_url", r6.k());     // Catch: JSONException -> L16
        r0.put("rect_url", r7.F());     // Catch: JSONException -> L16
    L6:
        r0.put("origin_host", r6.k().D() + "://" + r6.k().m());     // Catch: JSONException -> L16
        r0.put("rect_host", r7.D() + "://" + r7.m());     // Catch: JSONException -> L16
        r0.put("origin_path", r6.k().h());     // Catch: JSONException -> L16
        r0.put("rect_path", r7.h());     // Catch: JSONException -> L16
        JSONArray r4 = new JSONArray();     // Catch: JSONException -> L16
        Iterator<String> r13 = r11.iterator();     // Catch: JSONException -> L16
    L8:
        if (r13.hasNext() == false) goto L10;
        r4.put(r13.next());     // Catch: JSONException -> L16
        goto L8
    L10:
        r0.put("scy_headers", r4);     // Catch: JSONException -> L16
        r0.put("remove_scy_header", r9);     // Catch: JSONException -> L16
        r0.put("downgrade", r10);     // Catch: JSONException -> L16
        if (r12.f18154h.get() == false) goto L13;
        r0.put("ctl_ver", "v2");     // Catch: JSONException -> L16
    L13:
        if (r8 == null) goto L22;
        r8.c(r5, r0);     // Catch: JSONException -> L16
        return;
    L22:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean n(IOException r1, d0 r2) {
        r2.a();
        if ((r1 instanceof FileNotFoundException) == false) goto L5;
        return true;
    L5:
        return false;
    }

    private int o(f0 r1, int r2) {
        String r0 = r1.A("Retry-After");
        if (r0 != null) goto L6;
        return r2;
    L6:
        if (r0.matches("\\d+") == true) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return Integer.valueOf(r0).intValue();
    }

    private boolean p(f0 r2, w r3) {
        w r1 = r2.Y().k();
        if (r1.m().equals(r3.m()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.y() != r3.y()) goto L9;
        if (r1.D().equals(r3.D()) == false) goto L9;
        return true;
    }

    private boolean r(IOException r5, d0 r6) {
        if (this.f17900f == false) goto L5;
        return false;
    L5:
        this.f17900f = true;
        int r2 = p000j.l0.e.c(r5);
        if (p000j.l0.a.j().s(r5, r6, r2) == false) goto L9;
        this.f17896b.o(r2);
        d.a().b(r6, true);
        return true;
    L9:
        return false;
    }

    private void u(e r10, d0 r11, w r12, boolean r13, d0.a r14, s r15) {
        p000j.l0.a.C0470a r8 = p000j.l0.a.j().f();
        ArrayList r7 = new ArrayList();
        boolean r3 = true;
        if (r8.f18154h.get() == false) goto L5;
        Iterator<Map.Entry<String, List<String>>> r1 = r11.d().l().entrySet().iterator();
    L30:
        if (r1.hasNext() == false) goto L36;
        String r4 = r1.next().getKey();
        if (s(r4, r8.f18155i, r8.f18156j) == true) goto L30;
        r7.add(r4);
    L36:
        if (r7.isEmpty() == false) goto L38;
        return;
    L38:
        boolean r5 = r3 | r13;
        if (r5 == false) goto L45;
        Iterator<String> r2 = r7.iterator();
    L42:
        if (r2.hasNext() == false) goto L45;
        r14.h(r2.next());
    L45:
        if (r8.f18151e.get() == false) goto L47;
        return;
    L47:
        m(r10, r11, r12, r15, r5, r13, r7, r8);
        return;
    L5:
        if (r8.f18149c.get() == true) goto L11;
        if (h(r12.m()) == true) goto L11;
        r3 = false;
    L11:
        if (TextUtils.isEmpty(r11.c("x-tt-token")) == true) goto L14;
        r7.add("x-tt-token");
    L14:
        if (TextUtils.isEmpty(r11.c("Cookie")) == true) goto L17;
        r7.add("Cookie");
    L17:
        if (TextUtils.isEmpty(r11.c("Cookie2")) == true) goto L20;
        r7.add("Cookie2");
    L20:
        if (TextUtils.isEmpty(r11.c(CronetHttpURLConnection.SS_COOKIE)) == true) goto L22;
        r7.add(CronetHttpURLConnection.SS_COOKIE);
    L22:
        Iterator<String> r6 = r8.f18147a.iterator();
    L24:
        if (r6.hasNext() == false) goto L36;
        String r9 = r6.next();
        if (TextUtils.isEmpty(r11.c(r9)) == true) goto L24;
        r7.add(r9);
        goto L24
    }

    @Override // p000j.x
    public f0 a(x.a r15) {
        d0 r0 = r15.b();
        g r16 = (g) r15;
        e r7 = r16.g();
        s r8 = r16.h();
        g r9 = new g(this.f17895a.f(), d(r0.k()), r7, r8, this.f17897c);
        this.f17896b = r9;
        int r2 = 0;
        f0 r1 = null;
    L4:
        if (this.f17898d == true) goto L46;
        f0 r3 = r16.j(r0, r9, null, null);     // Catch: Throwable -> L27 IOException -> L29 p000j.k0.f.e -> L38
    L6:
        if (r1 == null) goto L49;
        f0.a r4 = r3.Q();
        f0.a r5 = r1.Q();
        r5.b(null);
        r4.m(r5.c());
        r3 = r4.c();
    L49:
        d0 r12 = e(r3, r9.p(), r7, r8);     // Catch: IOException -> L24
        if (r12 == null) goto L10;
        c.g(r3.a());
        int r13 = r2 + 1;
        if (r13 > 20) goto L22;
        r12.a();
        if (p(r3, r12.k()) == true) goto L18;
        r9.k();
        r9 = new g(this.f17895a.f(), d(r12.k()), r7, r8, this.f17897c);
        this.f17896b = r9;
    L19:
        r1 = r3;
        r0 = r12;
        r2 = r13;
        goto L4
    L18:
        if (r9.c() == null) goto L19;
        throw new IllegalStateException("Closing the body of " + r3 + " didn't close its backing stream. Bad interceptor?");
    L22:
        r9.k();
        throw new ProtocolException("Too many follow-up requests: " + r13);
    L10:
        r9.k();
        return r3;
    L24:
        e = move-exception;
        r9.k();
        throw e;
    L27:
        th = move-exception;
        r9.r(null);
        r9.k();
        throw th;
    L38:
        e = move-exception;
        if (l(e.c(), r9, false, r0) == true) goto L4;
        throw e.b();     // Catch: Throwable -> L27
    L29:
        e = move-exception;
        if ((e instanceof p000j.k0.i.a) == true) goto L33;
        boolean r6 = true;
    L35:
        if (l(e, r9, r6, r0) == true) goto L4;
        throw e;     // Catch: Throwable -> L27
    L33:
        r6 = false;
        goto L35
    L46:
        r9.k();
        throw new IOException("Canceled#Reason=" + this.f17899e);
    }

    public void b(int r2) {
        this.f17899e = r2;
        this.f17898d = true;
        g r1 = this.f17896b;
        if (r1 == null) goto L6;
        r1.b(r2);
        return;
    }

    public boolean c() {
        return this.f17898d;
    }

    public boolean g() {
        return this.f17898d;
    }

    public void q(Object r1) {
        this.f17897c = r1;
    }

    boolean s(String r2, List<String> r3, List<String> r4) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return true;
    L5:
        Iterator<String> r1 = r3.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        if (r2.equalsIgnoreCase(r1.next()) == false) goto L7;
        return true;
    L11:
        Iterator<String> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        if (r2.equalsIgnoreCase(r5.next()) == false) goto L13;
        return false;
    L17:
        Iterator<String> r6 = f17894g.iterator();
    L19:
        if (r6.hasNext() == false) goto L23;
        if (r2.equalsIgnoreCase(r6.next()) == false) goto L19;
        return true;
    L23:
        return false;
    }

    public g t() {
        return this.f17896b;
    }
}
