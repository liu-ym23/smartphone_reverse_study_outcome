package com.bytedance.common.wschannel.channel.c.a.g;

import androidx.annotation.Nullable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.o;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k.h;
import k.q;
import p000j.a0;
import p000j.b0;
import p000j.d0;
import p000j.f0;
import p000j.k0.f.g;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.common.wschannel.channel.c.a.g.b, com.bytedance.common.wschannel.channel.c.a.g.e.a {
    private static final List<b0> x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.c.a.g.c f3442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d0 f3443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Random f3444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f3446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque<h> f3447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque<Object> f3448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f3449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private p000j.e f3450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.c.a.g.e f3451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.c.a.g.f f3452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ScheduledExecutorService f3453l;
    private p000j.k0.n.a m;
    private long n;
    private boolean o;
    private ScheduledFuture<?> p;
    private int q;
    private String r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private boolean w;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.c.a.g.a$a, reason: collision with other inner class name */
    class RunnableC0098a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f3454f;

        RunnableC0098a(a r1) {
            this.f3454f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
        L8:
            if (this.f3454f.x() == true) goto L8;
            return;
        L5:
            e = move-exception;
            this.f3454f.p(e, null);
        }
    }

    class b implements p000j.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d0 f3455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f3456b;

        b(a r1, d0 r2) {
            this.f3456b = r1;
            this.f3455a = r2;
        }

        @Override // p000j.f
        public void onFailure(p000j.e r1, IOException r2) {
            this.f3456b.p(r2, null);
        }

        @Override // p000j.f
        public void onResponse(p000j.e r4, f0 r5) {
            this.f3456b.j(r5);     // Catch: ProtocolException -> L12
            g r6 = p000j.k0.a.f17790a.l(r4);
            r6.j();
            p000j.k0.n.a r0 = r6.d().r(r6);
        L9:
            e = move-exception;
            this.f3456b.p(e, null);
            return;
        L5:
            if (a.h(this.f3456b) == null) goto L7;
            a.h(this.f3456b).f(this.f3456b, r5);     // Catch: Exception -> L9
        L7:
            this.f3456b.q("OkHttp WebSocket " + this.f3455a.k().B(), r0);     // Catch: Exception -> L9
            r6.d().b().setSoTimeout(0);     // Catch: Exception -> L9
            this.f3456b.r();     // Catch: Exception -> L9
            return;
        L12:
            e = move-exception;
            this.f3456b.p(e, r5);
            p000j.k0.c.g(r5);
        }
    }

    final class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f3457f;

        c(a r1) {
            this.f3457f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3457f.i();
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f3458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h f3459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f3460c;

        d(int r1, h r2, long r3) {
            this.f3458a = r1;
            this.f3459b = r2;
            this.f3460c = r3;
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f3461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h f3462b;

        e(int r1, h r2) {
            this.f3461a = r1;
            this.f3462b = r2;
        }
    }

    private final class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f3463f;

        f(a r1) {
            this.f3463f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3463f.y(h.f18266i);
        }
    }

    static {
        x = Collections.singletonList(b0.f17673h);
    }

    public a(d0 r3, long r4, com.bytedance.common.wschannel.channel.c.a.g.c r6, Random r7) {
        this.f3447f = new ArrayDeque();
        this.f3448g = new ArrayDeque();
        this.q = -1;
        if ("GET".equals(r3.f()) == false) goto L7;
        this.f3443b = r3;
        this.f3442a = r6;
        this.f3444c = r7;
        this.f3449h = r4;
        byte[] r5 = new byte[16];
        r7.nextBytes(r5);
        this.f3445d = h.u(r5).a();
        this.f3446e = new RunnableC0098a(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r3.f());
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.c.a.g.c h(a r0) {
        return r0.f3442a;
    }

    public static a o(d0 r7, long r8, com.bytedance.common.wschannel.channel.c.a.g.c r10) {
        return new a(r7, r8, r10, new Random());
    }

    private void s() {
        ScheduledExecutorService r0 = this.f3453l;
        if (r0 == null) goto L6;
        r0.execute(this.f3446e);
        return;
    }

    private synchronized boolean v(h r7, int r8) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.s == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.o == true) goto L17;
        if ((this.n + ((long) r7.size())) <= 16777216) goto L13;
        k(1001, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L13:
        this.n += (long) r7.size();     // Catch: Throwable -> L19
        this.f3448g.add(new e(r8, r7));     // Catch: Throwable -> L19
        s();     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    private d0 w(d0 r4) {
        o.a r3 = o.b();
        if (r3 != null) goto L17;
        return r4;
    L17:
        Map<String, String> r5 = r3.a(r4.k().toString(), r4.d().l());     // Catch: Exception -> L14
        if (r5 != null) goto L8;
        return r4;
    L8:
        d0.a r0 = r4.g();     // Catch: Exception -> L14
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, String> r1 = r6.next();     // Catch: Exception -> L14
        r0.a(r1.getKey(), r1.getValue());     // Catch: Exception -> L14
        goto L10
    L12:
        return r0.b();
    L14:
        e = move-exception;
        Logger.w("tryAddOkWsRequestOpaque failed with exception" + e);
        return r4;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.g.e.a
    public void a(h r2) {
        com.bytedance.common.wschannel.channel.c.a.g.c r0 = this.f3442a;
        if (r0 == null) goto L6;
        r0.e(this, r2);
        return;
    }

    @Override // p000j.j0
    public d0 b() {
        return this.f3443b;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.g.e.a
    public void c(String r2) {
        com.bytedance.common.wschannel.channel.c.a.g.c r0 = this.f3442a;
        if (r0 == null) goto L6;
        r0.d(this, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.g.e.a
    public synchronized void d(h r2) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.s == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.o == true) goto L8;
    L10:
        this.f3447f.add(r2);     // Catch: Throwable -> L15
        s();     // Catch: Throwable -> L15
        this.u++;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        if (this.f3448g.isEmpty() == false) goto L10;
        goto L10
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.g.b
    public void e() {
        ScheduledExecutorService r0 = this.f3453l;
        if (r0 == null) goto L6;
        r0.execute(new f(this));
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.g.e.a
    public synchronized void f(h r2) {
        monitor-enter(this);
        this.v++;     // Catch: Throwable -> L8
        this.w = false;     // Catch: Throwable -> L8
        com.bytedance.common.wschannel.channel.c.a.g.c r0 = this.f3442a;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.g(this, r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.g.e.a
    public void g(int r4, String r5) {
        if (r4 == (-1)) goto L32;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L6:
        if (this.q != (-1)) goto L27;
        this.q = r4;     // Catch: Throwable -> L28
        this.r = r5;     // Catch: Throwable -> L28
        p000j.k0.n.a r1 = null;
        if (this.o == true) goto L10;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L28
        com.bytedance.common.wschannel.channel.c.a.g.c r0 = this.f3442a;     // Catch: Throwable -> L23
        if (r0 == null) goto L21;
        r0.b(this, r4, r5);     // Catch: Throwable -> L23
        if (r1 == null) goto L21;
        this.f3442a.a(this, r4, r5);     // Catch: Throwable -> L23
    L21:
        p000j.k0.c.g(r1);
        return;
    L23:
        th = move-exception;
        p000j.k0.c.g(r1);
        throw th;
    L10:
        if (this.f3448g.isEmpty() == false) goto L15;
        p000j.k0.n.a r2 = this.m;     // Catch: Throwable -> L28
        this.m = null;     // Catch: Throwable -> L28
        ScheduledFuture<?> r3 = this.p;     // Catch: Throwable -> L28
        if (r3 == null) goto L14;
        r3.cancel(false);     // Catch: Throwable -> L28
    L14:
        this.f3453l.shutdown();     // Catch: Throwable -> L28
        r1 = r2;
        goto L15
    L27:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L28
    L32:
        throw new IllegalArgumentException();
    }

    public void i() {
        this.f3450i.cancel();
    }

    void j(f0 r5) {
        if (r5.s() != 101) goto L18;
        String r0 = r5.A("Connection");
        if ("Upgrade".equalsIgnoreCase(r0) == false) goto L16;
        String r1 = r5.A("Upgrade");
        if ("websocket".equalsIgnoreCase(r1) == false) goto L14;
        String r6 = r5.A("Sec-WebSocket-Accept");
        String r4 = h.k(this.f3445d + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").A().a();
        if (r4.equals(r6) == false) goto L12;
        return;
    L12:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r4 + "' but was '" + r6 + "'");
    L14:
        throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r1 + "'");
    L16:
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r0 + "'");
    L18:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r5.s() + " " + r5.N() + "'");
    }

    public boolean k(int r3, String r4) {
        return l(r3, r4, 60000);
    }

    synchronized boolean l(int r6, String r7, long r8) {
        monitor-enter(this);
        com.bytedance.common.wschannel.channel.c.a.g.d.c(r6);     // Catch: Throwable -> L21
        h r0 = null;
        if (r7 == null) goto L11;
        r0 = h.k(r7);     // Catch: Throwable -> L21
        if (r0.size() <= 123) goto L11;
        throw new IllegalArgumentException("reason.size() > 123: " + r7);     // Catch: Throwable -> L21
    L11:
        if (this.s == true) goto L19;
        if (this.o == true) goto L19;
        this.o = true;     // Catch: Throwable -> L21
        this.f3448g.add(new d(r6, r0, r8));     // Catch: Throwable -> L21
        s();     // Catch: Throwable -> L21
        monitor-exit(this);
        return true;
    L19:
        monitor-exit(this);
        return false;
    L21:
        th = move-exception;
        throw th;
    }

    public void m(int r2, String r3) {
        this.f3442a = null;
        k(r2, r3);     // Catch: Throwable -> L5
        return;
    }

    public void n(a0 r4) {
        d0.a r0 = this.f3443b.g();
        r0.d("Upgrade", "websocket");
        r0.d("Connection", "Upgrade");
        r0.d("Sec-WebSocket-Key", this.f3445d);
        r0.d("Sec-WebSocket-Version", "13");
        d0 r1 = w(r0.b());
        p000j.e r5 = p000j.k0.a.f17790a.i(r4, r1);
        this.f3450i = r5;
        r5.s(new b(this, r1));
    }

    public void p(Exception r4, @Nullable f0 r5) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.s == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L7:
        this.s = true;     // Catch: Throwable -> L22
        p000j.k0.n.a r0 = this.m;     // Catch: Throwable -> L22
        this.m = null;     // Catch: Throwable -> L22
        ScheduledFuture<?> r1 = this.p;     // Catch: Throwable -> L22
        if (r1 == null) goto L10;
        r1.cancel(false);     // Catch: Throwable -> L22
    L10:
        ScheduledExecutorService r2 = this.f3453l;     // Catch: Throwable -> L22
        if (r2 == null) goto L13;
        r2.shutdown();     // Catch: Throwable -> L22
    L13:
        monitor-exit(this);     // Catch: Throwable -> L22
        com.bytedance.common.wschannel.channel.c.a.g.c r3 = this.f3442a;     // Catch: Throwable -> L19
        if (r3 == null) goto L17;
        r3.c(this, r4, r5);     // Catch: Throwable -> L19
    L17:
        p000j.k0.c.g(r0);
        return;
    L19:
        th = move-exception;
        p000j.k0.c.g(r0);
        throw th;
    }

    public void q(String r7, p000j.k0.n.a r8) {
        monitor-enter(this);
        this.m = r8;     // Catch: Throwable -> L9
        this.f3452k = new com.bytedance.common.wschannel.channel.c.a.g.f(r8.f18117f, r8.f18119h, this.f3444c);     // Catch: Throwable -> L9
        this.f3453l = new ScheduledThreadPoolExecutor(1, p000j.k0.c.G(r7, false));     // Catch: Throwable -> L9
        if (this.f3448g.isEmpty() == true) goto L6;
        s();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.f3451j = new com.bytedance.common.wschannel.channel.c.a.g.e(r8.f18117f, r8.f18118g, this, this.f3449h);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void r() {
    L3:
        if (this.q != (-1)) goto L5;
        this.f3451j.a();
        goto L3
    }

    public boolean t(String r2) {
        Objects.requireNonNull(r2, "text == null");
        return v(h.k(r2), 1);
    }

    public boolean u(h r2) {
        Objects.requireNonNull(r2, "bytes == null");
        return v(r2, 2);
    }

    boolean x() {
        monitor-enter(this);
    L48:
        th = move-exception;
        throw th;
    L4:
        if (this.s == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L48
        return false;
    L7:
        com.bytedance.common.wschannel.channel.c.a.g.f r0 = this.f3452k;     // Catch: Throwable -> L48
        h r2 = this.f3447f.poll();     // Catch: Throwable -> L48
        int r3 = -1;
        Object r4 = null;
        if (r2 != null) goto L20;
        Object r5 = this.f3448g.poll();     // Catch: Throwable -> L48
        if ((r5 instanceof d) == false) goto L15;
        int r1 = this.q;     // Catch: Throwable -> L48
        String r6 = this.r;     // Catch: Throwable -> L48
        if (r1 == (-1)) goto L14;
        p000j.k0.n.a r7 = this.m;     // Catch: Throwable -> L48
        this.m = null;     // Catch: Throwable -> L48
        this.f3453l.shutdown();     // Catch: Throwable -> L48
        r4 = r5;
        r3 = r1;
        p000j.k0.n.a r8 = r7;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L48
        if (r2 == null) goto L25;
        r0.f(r2);     // Catch: Throwable -> L45
    L41:
        p000j.k0.c.g(r8);
        return true;
    L25:
        if ((r4 instanceof e) == false) goto L35;
        h r9 = ((e) r4).f3462b;     // Catch: Throwable -> L45
        k.f r10 = q.a(r0.a(((e) r4).f3461a, r9.size()));     // Catch: Throwable -> L45
        r10.W(r9);     // Catch: Throwable -> L45
        r10.close();     // Catch: Throwable -> L45
        monitor-enter(this);     // Catch: Throwable -> L45
        this.n -= (long) r9.size();     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L35:
        if ((r4 instanceof d) == false) goto L44;
        d r11 = (d) r4;     // Catch: Throwable -> L45
        r0.b(r11.f3458a, r11.f3459b);     // Catch: Throwable -> L45
        if (r8 == null) goto L41;
        com.bytedance.common.wschannel.channel.c.a.g.c r12 = this.f3442a;     // Catch: Throwable -> L45
        if (r12 == null) goto L41;
        r12.a(this, r3, r6);     // Catch: Throwable -> L45
        goto L41
    L44:
        throw new AssertionError();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        p000j.k0.c.g(r8);
        throw th;
    L14:
        this.p = this.f3453l.schedule(new c(this), ((d) r5).f3460c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L48
        r3 = r1;
        r8 = null;
    L19:
        r4 = r5;
        goto L21
    L15:
        if (r5 != null) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L48
        return false;
    L18:
        r8 = null;
        r6 = null;
        goto L19
    L20:
        r8 = null;
        r6 = null;
        goto L21
    }

    void y(h r6) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.s == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L7:
        com.bytedance.common.wschannel.channel.c.a.g.f r0 = this.f3452k;     // Catch: Throwable -> L23
        if (this.w == false) goto L10;
        int r1 = this.t;     // Catch: Throwable -> L23
    L11:
        this.t++;     // Catch: Throwable -> L23
        this.w = true;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        if (r1 == (-1)) goto L17;
        p(new SocketTimeoutException(WsConstants.PING_NOT_RECEIVE_PONG_MSG), null);
        return;
    L17:
        if (r0 == null) goto L29;
        r0.e(r6);     // Catch: IOException -> L20
        return;
    L20:
        e = move-exception;
        p(e, null);
        return;
    L29:
        return;
    L10:
        r1 = -1;
        goto L11
    }
}
