package u9;

import ai.i0;
import ai.j0;
import ai.o;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest$Priority;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements bi.f, ai.n, o, WeakHandler.IHandler {
    public static boolean A;
    public static final Class B = null;
    public static boolean C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final HandlerThread f22271z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f22272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f22273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22274c;
    public volatile boolean d;
    public final Request e;
    public String f;
    public final long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s9.b f22275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f22277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f22278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f22279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile AtomicInteger f22280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList f22281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f22282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile HttpURLConnection f22283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile HttpURLConnection f22284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList f22285r;
    public volatile int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final CountDownLatch f22286t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final WeakHandler f22287u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f22288v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f22289w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f22290x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f22291y;

    static {
        f22271z = new HandlerThread("Concurrent-Handler");
        C = false;
        B = Class.forName("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl");     // Catch: ClassNotFoundException -> L5
    L7:
        f22271z.start();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public c(Request r12, f r13) {
        this.f22273b = 0;
        this.d = false;
        this.f22275h = s9.b.f21857y.mo98create();
        this.f22278k = new ArrayList();
        this.f22279l = new Object();
        this.f22280m = new AtomicInteger(0);
        this.f22281n = new CopyOnWriteArrayList();
        this.f22282o = false;
        this.f22283p = null;
        this.f22284q = null;
        this.f22285r = new CopyOnWriteArrayList();
        this.s = 0;
        this.f22286t = new CountDownLatch(1);
        this.f22287u = new WeakHandler(f22271z.getLooper(), this);
        Logger.d("c", "Request url: " + r12.getUrl());
        this.e = r12;
        this.f22272a = r12.getMetrics();
        String r5 = r12.getUrl();
        this.f = r5;
        Uri r10 = Uri.parse(r5);
        String r11 = r10.getScheme();
        String r14 = j0.D(r11, "://", r10.getHost());
        String r15 = r10.getQuery();
        Iterator r16 = r13.f22302b.iterator();
        int r17 = 0;
    L4:
        if (r16.hasNext() == false) goto L15;
        String r18 = this.f.replaceFirst(r14, j0.D(r11, "://", (String) r16.next()));
        if (TextUtils.isEmpty(r15) == true) goto L14;
        if (r15.contains("concurrent=") == true) goto L10;
        r18 = r18 + "&concurrent=" + r17;
    L10:
        if (r17 <= 0) goto L14;
        if (r15.contains("is_retry=") == true) goto L14;
        r18 = j0.j(r18, "&is_retry=1");
    L14:
        r17 = r17 + 1;
        this.f22278k.add(r18);
        goto L4
    L15:
        String r19 = UUID.randomUUID().toString();
        this.f22276i = r19;
        this.f22277j = r13.f22305i;
        long r20 = r13.f22309m;
        this.f22288v = r20;
        A = r13.f22310n;
        this.f22289w = r13.f22311o;
        sj.d r110 = s9.h.f21879a;
        this.f22290x = 30000;
        if ((r12.getExtraInfo() instanceof vj.b) == false) goto L18;
        ((vj.b) r12.getExtraInfo()).getClass();
    L18:
        this.f22290x += 1000;
        Logger.d("c", "Request max wait time milliseconds: " + this.f22290x + ", connect interval milliseconds: " + r20);
        i0 r111 = this.f22272a;
        if (r111 == null) goto L21;
        r111.f219c = r19;
        r111.d = true;
        this.f22275h.getClass();
        s9.b r112 = this.f22275h;
        long r21 = this.f22272a.g;
        r112.getClass();
    L21:
        this.g = System.currentTimeMillis();
        this.f22275h.getClass();
        this.f22275h.f21866m = 0;
        if (this.e.isResponseStreaming() == false) goto L24;
        this.f22275h.f21870q = true;
    L26:
        if ((r12.getExtraInfo() instanceof vj.b) == false) goto L34;
        this.f22275h.f21859b = (vj.b) r12.getExtraInfo();
        this.f22275h.f21859b.getClass();
        return;
    L34:
        return;
    L24:
        this.f22275h.f21870q = false;
        goto L26
    }

    @Override // bi.f
    public final boolean a(long r5) {
        this.f22273b = r5;
        if (this.f22283p != null) goto L11;
        return true;
    L11:
        Reflect.on(this.f22283p).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r5)});     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public final void b() {
        this.f22287u.removeCallbacksAndMessages(null);
        Object r5 = this.f22279l;
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f22282o == false) goto L10;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator r10 = this.f22281n.iterator();     // Catch: Throwable -> L8
    L12:
        if (r10.hasNext() == false) goto L22;
        HttpURLConnection r11 = (HttpURLConnection) r10.next();     // Catch: Throwable -> L8
        if (r11 == null) goto L12;
        Iterator r12 = this.f22285r.iterator();     // Catch: Throwable -> L8
    L17:
        if (r12.hasNext() == false) goto L21;
        b r13 = (b) r12.next();     // Catch: Throwable -> L8
        if (r13.f22268a != r11.hashCode()) goto L17;
        r13.d = System.currentTimeMillis();     // Catch: Throwable -> L8
        r13.e = -999;     // Catch: Throwable -> L8
        r13.g = new IOException("cleanupMessagesAndPendingConnections");     // Catch: Throwable -> L8
    L21:
        r11.disconnect();     // Catch: Throwable -> L8
        this.f22281n.remove(r11);     // Catch: Throwable -> L8
        goto L12
    L22:
        i0 r14 = this.f22272a;     // Catch: Throwable -> L8
        r14.f218b = e();     // Catch: Throwable -> L8
        this.f22282o = true;     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
    }

    public final void c() {
        IRequest$Priority r5 = IRequest$Priority.IMMEDIATE;
        com.obric.oui.lisitem.a r10 = new com.obric.oui.lisitem.a(this, 27);
        boolean r11 = this.f22275h.f21870q;
        r9.a r12 = new r9.a(r5, 0, r10);
        r9.c r13 = r9.c.h();
        monitor-enter(r13);
        r9.b.f.a(r12);     // Catch: Throwable -> L8
        monitor-exit(r13);
        Message r14 = Message.obtain();
        r14.what = 0;
        r14.obj = this;
        this.f22287u.sendMessageDelayed(r14, this.f22288v);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // bi.f
    public final void cancel() {
        Logger.d("c", "cancel countdown.");
        Object r5 = this.f22279l;
        monitor-enter(r5);
        this.f22286t.countDown();     // Catch: Throwable -> L11
        b();     // Catch: Throwable -> L11
        if (this.f22283p == null) goto L13;
        this.f22283p.disconnect();     // Catch: Throwable -> L11
        if (this.e.isResponseStreaming() == false) goto L13;
        if (this.d == true) goto L13;
        doCollect();     // Catch: Throwable -> L11
        s9.b r10 = this.f22275h;     // Catch: Throwable -> L11
        r10.f21876x = l.h(this.f22291y);     // Catch: Throwable -> L11
        s9.b r11 = this.f22275h;     // Catch: Throwable -> L11
        System.currentTimeMillis();     // Catch: Throwable -> L11
        r11.getClass();     // Catch: Throwable -> L11
        vj.b r12 = this.f22275h.f21859b;     // Catch: Throwable -> L11
        this.e.getUrl();     // Catch: Throwable -> L11
        sj.d r13 = s9.h.f21879a;     // Catch: Throwable -> L11
        m r14 = m.a();     // Catch: Throwable -> L11
        String r15 = this.e.getUrl();     // Catch: Throwable -> L11
        s9.b r16 = this.f22275h;     // Catch: Throwable -> L11
        r14.b(r16.f21864k, r15, r16.f21865l, r16.f21876x, r16.f21868o);     // Catch: Throwable -> L11
    L13:
        this.d = true;     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final IOException d(Exception r5, String r10, HttpURLConnection r11, boolean r12) {
        s9.b r13 = this.f22275h;
        if ((r5 instanceof IOException) == false) goto L11;
        if (r5.getMessage() == null) goto L11;
        if (r5.getMessage().startsWith("request canceled") == false) goto L11;
        return (IOException) r5;
    L11:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r5.getClass().getName()) == false) goto L13;
    L16:
        int r14 = l.f22316b.getCronetInternalErrorCode(r11);
    L18:
        if (TextUtils.isEmpty(r10) == false) goto L20;
        r10 = this.f;
    L20:
        if (r12 == false) goto L22;
        l.o(r10, r13, r5, r11, this.f22272a);
    L30:
        l.a(r5.getMessage());     // Catch: NetworkNotAvailabeException -> L28
        return new CronetIOException(r5, r13, this.f22274c, r14);
    L28:
        e = move-exception;
        return e;
    L22:
        if (r11 == null) goto L30;
        r11.disconnect();
        goto L30
    L13:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r5.getClass().getName()) == true) goto L16;
        r14 = 0;
        goto L18
    }

    @Override // ai.n
    public final void doCollect() {
        l.k(this.f22283p, this.f22275h, this.f22272a);
    }

    public final JSONObject e() {
        CopyOnWriteArrayList r5 = this.f22285r;
        JSONObject r10 = new JSONObject();
        r10.put("concurrent", r5.size() - 1);     // Catch: JSONException -> L7
        r10.put("duration", System.currentTimeMillis() - this.g);     // Catch: JSONException -> L7
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L7
        Iterator r12 = r5.iterator();     // Catch: JSONException -> L7
    L5:
        if (r12.hasNext() == false) goto L9;
        r11.put(((b) r12.next()).a());     // Catch: JSONException -> L7
        goto L5
    L9:
        r10.put("tasks", r11);     // Catch: JSONException -> L7
    L12:
        return r10;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    @Override // bi.f
    public final bi.e execute() {
        i0 r5 = this.f22272a;
        if (r5 == null) goto L6;
        r5.f221i = System.currentTimeMillis();
    L6:
        if (this.d == true) goto L103;
        Logger.d("c", "Execute url: " + this.f);
        fi.i r10 = null;
        l.a(null);
        c();
        boolean r11 = true;
        this.f22286t.await(this.f22290x, TimeUnit.MILLISECONDS);     // Catch: Exception -> L93
        this.f22286t.countDown();     // Catch: Exception -> L93
        Object r12 = this.f22279l;     // Catch: Exception -> L93
        monitor-enter(r12);     // Catch: Exception -> L93
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L93
    L11:
        if (this.d == true) goto L90;
        if (this.f22283p != null) goto L24;
        g.a().b(this.f22277j, false);     // Catch: Throwable -> L20
        if (this.f22285r.size() <= 0) goto L23;
        if (((b) this.f22285r.get(0)).g == null) goto L23;
        throw ((b) this.f22285r.get(0)).g;     // Catch: Throwable -> L20
    L23:
        throw d(new IOException("All urls have been tried and timed out by max wait time."), this.f, this.f22283p, false);     // Catch: Throwable -> L20
    L24:
        this.f22281n.remove(this.f22283p);     // Catch: Throwable -> L20
        monitor-exit(r12);     // Catch: Throwable -> L20
        b();
        g.a().b(this.f22277j, true);     // Catch: Throwable -> L49 Exception -> L51
        int r13 = this.f22283p.getResponseCode();     // Catch: Throwable -> L49 Exception -> L51
        l.r(this.f22283p, this.f22275h, r13);     // Catch: Throwable -> L49 Exception -> L51
        if (this.f22275h.f21872t == false) goto L30;
        C = true;     // Catch: Throwable -> L49 Exception -> L51
    L30:
        System.currentTimeMillis();     // Catch: Throwable -> L49 Exception -> L51
        this.f22275h.getClass();     // Catch: Throwable -> L49 Exception -> L51
        HttpURLConnection r14 = this.f22283p;     // Catch: Throwable -> L49 Exception -> L51
        s9.b r15 = this.f22275h;     // Catch: Throwable -> L49 Exception -> L51
        if (r14 != null) goto L33;
        String r16 = null;
    L34:
        this.f22274c = r16;     // Catch: Throwable -> L49 Exception -> L51
        this.f22291y = l.i(this.f22283p, "Content-Type");     // Catch: Throwable -> L49 Exception -> L51
        if (this.e.isResponseStreaming() == true) goto L37;
        int r17 = this.e.getMaxLength();     // Catch: Throwable -> L49 Exception -> L51
        this.f22275h.f21876x = l.h(this.f22291y);     // Catch: Throwable -> L49 Exception -> L51
        r10 = new fi.g(this.f22291y, l.q(this.f, r17, this.f22283p, this.f22275h, r13, this.f22272a), new String[0]);     // Catch: Throwable -> L49 Exception -> L51
    L69:
        bi.e r18 = new bi.e(this.f, r13, this.f22283p.getResponseMessage(), l.e(this.f22283p, C), r10);     // Catch: Throwable -> L49 Exception -> L51
        r18.f = this.f22275h;     // Catch: Throwable -> L49 Exception -> L51
        if (this.e.isResponseStreaming() == true) goto L77;
        HttpURLConnection r19 = this.f22283p;
        if (r19 == null) goto L77;
        r19.disconnect();
    L77:
        return r18;
    L37:
        if (r13 >= 200) goto L39;
    L53:
        String r20 = this.f22283p.getResponseMessage();     // Catch: Throwable -> L49 Exception -> L51
        int r21 = this.e.getMaxLength();     // Catch: Throwable -> L57
        InputStream r22 = this.f22283p.getInputStream();     // Catch: Throwable -> L57 Exception -> L59
    L56:
        InputStream r23 = r22;
        this.f22283p.getHeaderFields();     // Catch: Throwable -> L57
        l.p(false, r21, r23, this.f22291y, this.f, this.f22272a);     // Catch: Throwable -> L57
    L66:
        this.f22283p.disconnect();     // Catch: Throwable -> L49 Exception -> L51
        throw new HttpResponseException(r13, r20);     // Catch: Throwable -> L49 Exception -> L51
    L59:
        r22 = this.f22283p.getErrorStream();     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L49 Exception -> L51
        StringBuilder r24 = new StringBuilder("reason = ");     // Catch: Throwable -> L49 Exception -> L51
        if (r20 != null) goto L65;
        r20 = "";
    L65:
        r24.append(r20);     // Catch: Throwable -> L49 Exception -> L51
        r24.append("  exception = ");     // Catch: Throwable -> L49 Exception -> L51
        r24.append(th.getMessage());     // Catch: Throwable -> L49 Exception -> L51
        r20 = r24.toString();     // Catch: Throwable -> L49 Exception -> L51
        goto L66
    L39:
        if (r13 >= 300) goto L53;
        HttpURLConnection r25 = this.f22283p;     // Catch: Throwable -> L49 Exception -> L51
        if (r25 == null) goto L69;
        if (r25.getContentLength() != 0) goto L46;
        cancel();     // Catch: Throwable -> L49 Exception -> L51
        goto L69
    L46:
        r10 = new a(this, r25);     // Catch: Throwable -> L49 Exception -> L51
        goto L69
    L33:
        l.j(l.i(r14, "x-net-info.remoteaddr"), r15);     // Catch: Throwable -> L49 Exception -> L51
        r16 = l.i(r14, "X-TT-LOGID");     // Catch: Throwable -> L49 Exception -> L51
    L51:
        e = move-exception;
    L80:
        th = th;
    L82:
        if (this.e.isResponseStreaming() == false) goto L84;
        if (r11 == true) goto L84;
    L88:
        throw th;
    L84:
        HttpURLConnection r110 = this.f22283p;
        if (r110 == null) goto L88;
        r110.disconnect();
        goto L88
    L79:
        throw d(e, this.f, this.f22283p, true);     // Catch: Throwable -> L80
    L49:
        th = th;
        r11 = false;
        goto L82
    L90:
        throw new IOException("request canceled");     // Catch: Throwable -> L20
    L93:
        e = move-exception;
        b();
        if (this.f22283p != null) goto L101;
        if (this.f22284q == null) goto L101;
        throw d(e, this.f, this.f22284q, true);
    L101:
        throw d(e, this.f, this.f22283p, true);
    L103:
        throw new IOException("request canceled");
    }

    @Override // ai.o
    public final Object getRequestInfo() {
        return this.f22275h;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r5) {
        if (r5 == null) goto L24;
        Object r10 = r5.obj;
        if ((r10 instanceof c) == false) goto L25;
        int r11 = r5.what;     // Catch: Throwable -> L14
        if (r11 != 0) goto L9;
        ((c) r10).c();     // Catch: Throwable -> L14
    L20:
        return;
    L9:
        if (r11 != 1) goto L20;
        c r12 = (c) r10;     // Catch: Throwable -> L14
        WeakHandler r13 = r12.f22287u;     // Catch: Throwable -> L14
        if (r13.obtainMessage(0) == null) goto L20;
        r13.removeMessages(0);     // Catch: Throwable -> L14
        r12.c();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L25:
        return;
    }
}
