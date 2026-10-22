package u9;

import ai.i0;
import ai.o;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements bi.f, ai.n, o {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f22295i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ICronetClient f22296j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HttpURLConnection f22297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s9.b f22298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22299c;
    public Request d;
    public boolean e;
    public i0 f;
    public volatile long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22300h;

    @Override // bi.f
    public final boolean a(long r5) {
        this.g = r5;
        HttpURLConnection r10 = this.f22297a;
        if (r10 != null) goto L11;
        return true;
    L11:
        Reflect.on(r10).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r5)});     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // bi.f
    public final void cancel() {
        HttpURLConnection r5 = this.f22297a;
        if (r5 == null) goto L11;
        r5.disconnect();
        Request r10 = this.d;
        if (r10.isResponseStreaming() == true) goto L7;
    L9:
        this.e = true;
        return;
    L7:
        if (this.e == true) goto L9;
        doCollect();
        String r11 = l.h(this.f22300h);
        s9.b r12 = this.f22298b;
        r12.f21876x = r11;
        System.currentTimeMillis();
        r10.getUrl();
        sj.d r13 = s9.h.f21879a;
        m r14 = m.a();
        String r15 = r10.getUrl();
        r14.b(r12.f21864k, r15, r12.f21865l, r12.f21876x, r12.f21868o);
        goto L9
    }

    @Override // ai.n
    public final void doCollect() {
        l.k(this.f22297a, this.f22298b, this.f);
    }

    @Override // bi.f
    public final bi.e execute() {
        s9.b r5 = this.f22298b;
        i0 r10 = this.f;
        if (r10 == null) goto L5;
        r10.f221i = System.currentTimeMillis();
    L5:
        Request r11 = this.d;
        String r12 = r11.getUrl();
        if (this.e == true) goto L111;
        fi.i r13 = null;
        l.a(null);
        int r14 = 0;
    L37:
        e = move-exception;
    L83:
        th = th;
        r14 = 1;
    L102:
        if (r11.isResponseStreaming() == false) goto L104;
        if (r14 != 0) goto L104;
    L108:
        r11.isResponseStreaming();
        throw th;
    L104:
        HttpURLConnection r15 = this.f22297a;
        if (r15 == null) goto L108;
        r15.disconnect();
        goto L108
    L78:
        if ((e instanceof HttpResponseException) == false) goto L86;
        HttpResponseException r16 = (HttpResponseException) e;     // Catch: Throwable -> L83
        if (r16.getStatusCode() != 304) goto L86;
        throw r16;     // Catch: Throwable -> L83
    L86:
        if ((e instanceof IOException) == false) goto L92;
        if ("request canceled".equals(e.getMessage()) == false) goto L92;
        throw e;     // Catch: Throwable -> L83
    L92:
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(e.getClass().getName()) == false) goto L95;
        doCollect();     // Catch: Throwable -> L83
        r14 = l.f22316b.getCronetInternalErrorCode(this.f22297a);     // Catch: Throwable -> L83
    L95:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(e.getClass().getName()) == false) goto L97;
    L98:
        r14 = l.f22316b.getCronetInternalErrorCode(this.f22297a);     // Catch: Throwable -> L83
    L99:
        l.o(r12, this.f22298b, e, this.f22297a, this.f);     // Catch: Throwable -> L83
        l.a(e.getMessage());     // Catch: Throwable -> L83
        throw new CronetIOException(e, r5, this.f22299c, r14);     // Catch: Throwable -> L83
    L97:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(e.getClass().getName()) == false) goto L99;
    L35:
        th = th;
        goto L102
    L9:
        if (r11.isResponseStreaming() == true) goto L13;
        sj.d r17 = s9.h.f21879a;     // Catch: Throwable -> L35 Exception -> L37
        if (r17 == null) goto L13;
        r17.i(r12);     // Catch: Throwable -> L35 Exception -> L37
    L13:
        HttpURLConnection r18 = this.f22297a;     // Catch: Throwable -> L35 Exception -> L37
        if (r18 != null) goto L17;
        int r19 = -1;
    L16:
        int r110 = r19;
        l.r(this.f22297a, r5, r110);     // Catch: Throwable -> L35 Exception -> L37
        if (r5.f21872t == false) goto L24;
        f22295i = true;     // Catch: Throwable -> L35 Exception -> L37
    L24:
        System.currentTimeMillis();     // Catch: Throwable -> L35 Exception -> L37
        HttpURLConnection r20 = this.f22297a;     // Catch: Throwable -> L35 Exception -> L37
        if (r20 != null) goto L27;
        String r21 = null;
    L28:
        this.f22299c = r21;     // Catch: Throwable -> L35 Exception -> L37
        this.f22300h = l.i(this.f22297a, "Content-Type");     // Catch: Throwable -> L35 Exception -> L37
        if (r11.isResponseStreaming() == false) goto L66;
        boolean r22 = "gzip".equalsIgnoreCase(l.i(this.f22297a, "Content-Encoding"));     // Catch: Throwable -> L35 Exception -> L37
        ICronetClient r23 = f22296j;     // Catch: Throwable -> L35 Exception -> L37
        if (r23 == null) goto L40;
        if (r23.isCronetHttpURLConnection(this.f22297a) == false) goto L40;
        r22 = false;
    L40:
        if (r110 >= 200) goto L42;
    L51:
        String r111 = this.f22297a.getResponseMessage();     // Catch: Throwable -> L35 Exception -> L37
        int r24 = r11.getMaxLength();     // Catch: Throwable -> L55
        InputStream r25 = this.f22297a.getInputStream();     // Catch: Throwable -> L55 Exception -> L57
    L54:
        InputStream r26 = r25;
        this.f22297a.getHeaderFields();     // Catch: Throwable -> L55
        l.p(r22, r24, r26, this.f22300h, r12, this.f);     // Catch: Throwable -> L55
    L64:
        this.f22297a.disconnect();     // Catch: Throwable -> L35 Exception -> L37
        throw new HttpResponseException(r110, r111);     // Catch: Throwable -> L35 Exception -> L37
    L57:
        r25 = this.f22297a.getErrorStream();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L35 Exception -> L37
        StringBuilder r27 = new StringBuilder("reason = ");     // Catch: Throwable -> L35 Exception -> L37
        if (r111 != null) goto L63;
        r111 = "";
    L63:
        r27.append(r111);     // Catch: Throwable -> L35 Exception -> L37
        r27.append("  exception = ");     // Catch: Throwable -> L35 Exception -> L37
        r27.append(th.getMessage());     // Catch: Throwable -> L35 Exception -> L37
        r111 = r27.toString();     // Catch: Throwable -> L35 Exception -> L37
        goto L64
    L42:
        if (r110 >= 300) goto L51;
        HttpURLConnection r28 = this.f22297a;     // Catch: Throwable -> L35 Exception -> L37
        if (r28 != null) goto L47;
    L67:
        bi.e r29 = new bi.e(r12, r110, this.f22297a.getResponseMessage(), l.e(this.f22297a, f22295i), r13);     // Catch: Throwable -> L35 Exception -> L37
        r29.f = r5;     // Catch: Throwable -> L35 Exception -> L37
        if (r11.isResponseStreaming() == true) goto L75;
        HttpURLConnection r112 = this.f22297a;
        if (r112 == null) goto L75;
        r112.disconnect();
    L75:
        r11.isResponseStreaming();
        return r29;
    L47:
        if (r28.getContentLength() != 0) goto L49;
        cancel();     // Catch: Throwable -> L35 Exception -> L37
        goto L67
    L49:
        r13 = new d(this, r28, r22);     // Catch: Throwable -> L35 Exception -> L37
        goto L67
    L66:
        int r30 = r11.getMaxLength();     // Catch: Throwable -> L35 Exception -> L37
        r5.f21876x = l.h(this.f22300h);     // Catch: Throwable -> L35 Exception -> L37
        r13 = new fi.g(this.f22300h, l.q(r12, r30, this.f22297a, this.f22298b, r110, this.f), new String[0]);     // Catch: Throwable -> L35 Exception -> L37
        goto L67
    L27:
        l.j(l.i(r20, "x-net-info.remoteaddr"), r5);     // Catch: Throwable -> L35 Exception -> L37
        r21 = l.i(r20, "X-TT-LOGID");     // Catch: Throwable -> L35 Exception -> L37
        goto L28
    L17:
        fi.j r31 = r11.getBody();     // Catch: Throwable -> L35 Exception -> L37
        if (r31 == null) goto L20;
        r31.writeTo(r18.getOutputStream());     // Catch: Throwable -> L35 Exception -> L37
    L20:
        sj.d r32 = s9.h.f21879a;     // Catch: Throwable -> L35 Exception -> L37
        r19 = r18.getResponseCode();     // Catch: Throwable -> L35 Exception -> L37
        goto L16
    L111:
        throw new IOException("request canceled");
    }

    @Override // ai.o
    public final Object getRequestInfo() {
        return this.f22298b;
    }
}
