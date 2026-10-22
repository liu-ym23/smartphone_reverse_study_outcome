package com.ss.android.token;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.android.sdk.bdticketguard.d0;
import com.bytedance.android.sdk.bdticketguard.e0;
import com.bytedance.android.sdk.bdticketguard.k1;
import com.bytedance.android.sdk.bdticketguard.v0;
import com.bytedance.android.sdk.bdticketguard.x0;
import com.bytedance.android.sdk.bdticketguard.z0;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.ShowDialogActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.f0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p implements WeakHandler.IHandler {
    private static volatile p M;
    private static final List<com.ss.android.token.e> N = null;
    private static volatile boolean O;
    private static final AtomicBoolean P = null;
    private static final d.b.s.a.l0.j<Boolean> Q = null;
    private static volatile boolean R;
    private volatile AuthTokenMultiProcessSharedProvider.c A;
    private volatile u B;
    private volatile boolean C;

    @Nullable
    private volatile Boolean D;
    private final Object E;
    private long F;
    private volatile com.ss.android.i.h G;
    private volatile boolean H;
    private final Object I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final Set<l> f12261J;
    private final AtomicBoolean K;
    private long L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f12262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f12263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f12264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f12265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f12266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    private volatile t f12267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile String f12268l;
    private volatile String m;
    private volatile com.ss.android.token.l n;
    private volatile Context o;
    private volatile Handler p;
    private final AtomicBoolean q;
    private volatile boolean r;
    private volatile boolean s;
    private volatile boolean t;
    protected d.b.s.a.l0.j<d.b.s.a.q.f> u;
    private volatile boolean v;
    private volatile boolean w;
    private volatile boolean x;
    private volatile boolean y;
    private volatile JSONObject z;

    class a extends d.b.s.a.q.k.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f12269c;

        a(p r1, String r2) {
            this.f12269c = r2;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.q.m.d) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.q.m.d) r1);
        }

        public void m(d.b.s.a.q.m.d r7, int r8) {
            d.b.s.a.l0.g.c().g(this.f12269c, null, "whatever", System.currentTimeMillis() + 86400000);
        }

        public void n(d.b.s.a.q.m.d r7) {
        L8:
            e = move-exception;
            e.printStackTrace();
        L10:
            d.b.s.a.l0.g.c().g(this.f12269c, null, "whatever", System.currentTimeMillis() + 86400000);
            return;
        L3:
            if (r7.a() == null) goto L10;
            if (r7.a().o() <= 0) goto L10;
            o.E();     // Catch: Exception -> L8
            goto L10
        }
    }

    class b implements Runnable {
        b(p r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            List r2 = p.k();
            monitor-enter(r2);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (p.k().size() <= 0) goto L11;
            Iterator r0 = p.k().iterator();     // Catch: Throwable -> L13
        L8:
            if (r0.hasNext() == false) goto L10;
            ((com.ss.android.token.e) r0.next()).a();     // Catch: Throwable -> L13
            goto L8
        L10:
            p.k().clear();     // Catch: Throwable -> L13
        L11:
            monitor-exit(r2);     // Catch: Throwable -> L13
        }
    }

    class c extends d.b.s.a.l0.j<d.b.s.a.q.f> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p f12270d;

        c(p r1) {
            this.f12270d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ d.b.s.a.q.f b() {
            return e();
        }

        @NonNull
        protected d.b.s.a.q.f e() {
            return com.bytedance.sdk.account.impl.g.d(p.a(this.f12270d));
        }
    }

    static class d extends d.b.s.a.l0.j<Boolean> {
        d() {
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(com.bytedance.sdk.account.ticketguard.f.j().d());
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f12271f;

        e(p r1) {
            this.f12271f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r6 = p.b(this.f12271f).g();
            String r0 = d.b.s.a.l0.s.e(p.l(this.f12271f).g(), "sessionid");
            String r1 = p.m(this.f12271f).f12309a;
            String r2 = p.m(this.f12271f).f12310b;
            if (TextUtils.isEmpty(r1) == false) goto L5;
        L9:
            boolean r9 = false;
        L10:
            o.a(this.f12271f.u.a().m(), !TextUtils.isEmpty(r0), p.n(this.f12271f), true ^ TextUtils.isEmpty(r2), d.b.s.a.f.e(), r6, this.f12271f.u.a().getUserId(), r9);
            return;
        L5:
            if (TextUtils.isEmpty(r0) == true) goto L9;
            if (r1.contains(r0) == false) goto L9;
            r9 = true;
            goto L10
        }
    }

    class f implements kotlin.n0.c.l<Boolean, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f12272f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p f12273g;

        f(p r1, l r2) {
            this.f12273g = r1;
            this.f12272f = r2;
        }

        public f0 a(Boolean r3) {
            d.b.s.a.a0.a.a("TokenFactory", "ticket init finish");
            p.o(this.f12273g, r3);
            p.p(this.f12273g);
            l r2 = this.f12272f;
            if (r2 == null) goto L6;
            r2.a(true);
        L6:
            return f0.f18324a;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Boolean r1) {
            return a(r1);
        }
    }

    class g implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f12274a;

        g(p r1) {
            this.f12274a = r1;
        }

        @Override // com.ss.android.token.p.l
        public void a(boolean r1) {
            p.q(this.f12274a);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.ss.android.token.d f12275f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p f12276g;

        class a implements l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f12277a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f12278b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f12279c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map f12280d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ h f12281e;

            /* JADX INFO: renamed from: com.ss.android.token.p$h$a$a, reason: collision with other inner class name */
            class RunnableC0319a implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f12282f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ boolean f12283g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f12284h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                final /* synthetic */ boolean f12285i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                final /* synthetic */ a f12286j;

                RunnableC0319a(a r1, boolean r2, boolean r3, boolean r4, boolean r5) {
                    this.f12286j = r1;
                    this.f12282f = r2;
                    this.f12283g = r3;
                    this.f12284h = r4;
                    this.f12285i = r5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a r1 = this.f12286j;
                    String r2 = r1.f12277a;
                    String r3 = r1.f12278b;
                    String r4 = com.ss.android.i.j.k().c();
                    boolean r9 = this.f12282f;
                    com.bytedance.android.sdk.bdticketguard.n r15 = new com.bytedance.android.sdk.bdticketguard.n(r2, r3, r4, "/passport/safe/get_token/", "x-tt-token", !r9, false, r9, this.f12283g, this.f12286j.f12281e.f12276g.I("/passport/safe/get_token/"), this.f12284h, this.f12285i, this.f12286j.f12279c);
                    com.bytedance.android.sdk.bdticketguard.l r5 = this.f12286j.f12281e.f12276g.W(r15);
                    a r6 = this.f12286j;
                    p.c(r6.f12281e.f12276g, r6.f12280d, r15, r5);
                    a r0 = this.f12286j;
                    r0.f12281e.f12275f.b(r0.f12280d);
                }
            }

            a(h r1, String r2, String r3, String r4, Map r5) {
                this.f12281e = r1;
                this.f12277a = r2;
                this.f12278b = r3;
                this.f12279c = r4;
                this.f12280d = r5;
            }

            @Override // com.ss.android.token.p.l
            public void a(boolean r11) {
                int r0 = com.bytedance.sdk.account.ticketguard.f.i("/passport/safe/get_token/");
                if (r0 == 3) goto L7;
                if (r0 == 1) goto L7;
                boolean r6 = false;
            L8:
                if (r0 != 3) goto L10;
            L13:
                boolean r7 = true;
            L15:
                if (com.bytedance.sdk.account.ticketguard.f.q() == true) goto L17;
            L19:
                boolean r8 = false;
            L21:
                if (com.bytedance.sdk.account.ticketguard.f.m() == true) goto L23;
            L25:
                boolean r9 = false;
            L26:
                com.bytedance.common.utility.m.c.c(new RunnableC0319a(this, r6, r7, r8, r9));
                return;
            L23:
                if (com.bytedance.sdk.account.ticketguard.f.y("/passport/safe/get_token/") == false) goto L25;
                r9 = true;
                goto L26
            L17:
                if (com.bytedance.sdk.account.ticketguard.f.z("/passport/safe/get_token/") == false) goto L19;
                r8 = true;
                goto L21
            L10:
                if (r0 == 2) goto L13;
                r7 = false;
            L7:
                r6 = true;
                goto L8
            }
        }

        h(p r1, com.ss.android.token.d r2) {
            this.f12276g = r1;
            this.f12275f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.account.ticketguard.f.s() == true) goto L6;
            this.f12275f.a(-1, "not enable token guard");
            return;
        L6:
            AuthTokenMultiProcessSharedProvider.c r0 = p.r(this.f12276g);
            String r7 = r0.e("X-Tt-Token", "");
            if (TextUtils.isEmpty(r7) == false) goto L10;
            this.f12275f.a(-1, "no token");
            return;
        L10:
            String r6 = r0.e("ts_sign", "");
            if (TextUtils.isEmpty(r6) == false) goto L14;
            this.f12275f.a(-1, "no ts_sign");
            return;
        L14:
            String r8 = r0.e("attest_ts_sign", "");
            if (TextUtils.isEmpty(r8) == false) goto L17;
            d.b.s.a.a0.a.b("TokenFactory", "no attest_ts_sign");
        L17:
            String r1 = r0.e("mfa_token", "");
            HashMap r9 = new HashMap();
            r9.put("X-Tt-Token", r7);
            if (TextUtils.isEmpty(r1) == true) goto L20;
            r9.put("x-tt-passport-mfa-token", r1);
        L20:
            r9.put("sdk-version", p.s(this.f12276g));
            r9.put("passport-sdk-version", String.valueOf(601339));
            this.f12276g.M0("group_one_login", new a(this, r6, r7, r8, r9));
        }
    }

    class i implements com.ss.android.token.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f12287a;

        i(p r1, Runnable r2) {
            this.f12287a = r2;
        }

        @Override // com.ss.android.token.e
        public void a() {
            this.f12287a.run();
        }
    }

    class j extends d.b.s.a.q.k.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f12288c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f12289d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f12290e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f12291f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f12292g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f12293h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ p f12294i;

        j(p r1, String r2, String r3, String r4, String r5, String r6, Object r7) {
            this.f12294i = r1;
            this.f12288c = r2;
            this.f12289d = r3;
            this.f12290e = r4;
            this.f12291f = r5;
            this.f12292g = r6;
            this.f12293h = r7;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.q.m.h) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.q.m.h) r1);
        }

        public void m(d.b.s.a.q.m.h r12, int r13) {
            p.d(this.f12294i, false);     // Catch: Exception -> L23
            p.f(this.f12294i);     // Catch: Exception -> L23
            String r0 = r12.p;     // Catch: Exception -> L23
            String r2 = r12.f14885a;     // Catch: Exception -> L23
            o.a r3 = o.a.f12258f;     // Catch: Exception -> L23
            if ("session_expired".equalsIgnoreCase(r0) == false) goto L9;
            r3 = o.a.f12259g;     // Catch: Exception -> L23
            ArrayList r6 = new ArrayList();     // Catch: Exception -> L23
            if (TextUtils.isEmpty(r2) == true) goto L7;
            r6.add(new m("X-TT-LOGID", r2));     // Catch: Exception -> L23
        L7:
            p r4 = this.f12294i;     // Catch: Exception -> L23
            r4.v0(this.f12292g, r6, true, r4.u.a().m(), this.f12293h, null);     // Catch: Exception -> L23
        L21:
            p.g(this.f12294i, this.f12288c, this.f12289d, this.f12290e, this.f12291f, r3);     // Catch: Exception -> L23
            p.e(this.f12294i).sendEmptyMessageDelayed(1000, p.l(this.f12294i).n());     // Catch: Exception -> L23
            return;
        L9:
            if (r13 != 400) goto L11;
            ShowDialogActivity.d(p.a(this.f12294i), "token sdk status error", "SDK self-check failed:" + r12.f14893i + ";please check network interceptor work fine");     // Catch: Exception -> L23
            goto L21
        L11:
            String r1 = r12.f14894j;     // Catch: Exception -> L23
            if (r1 != null) goto L15;
            r1 = "";
        L15:
            o.r("tt_token_beat", null, r12.f14891g, r1);     // Catch: Exception -> L23
            if (p.h(this.f12294i) != null) goto L19;
            p.i(this.f12294i, new JSONObject());     // Catch: Exception -> L23
            p.h(this.f12294i).put(WsConstants.ERROR_CODE, r13);     // Catch: Exception -> L23
            p.h(this.f12294i).put("error_detail_msg", r1);     // Catch: Exception -> L23
        L19:
            if ("Not Found".equalsIgnoreCase(r1) == false) goto L21;
            p.j(this.f12294i, false);     // Catch: Exception -> L23
        L23:
            e = move-exception;
            o.f(e);
        }

        public void n(d.b.s.a.q.m.h r7) {
            p.d(this.f12294i, false);     // Catch: Exception -> L4
            p.e(this.f12294i).sendEmptyMessageDelayed(1000, p.l(this.f12294i).n());     // Catch: Exception -> L4
            p.f(this.f12294i);     // Catch: Exception -> L4
        L6:
            p.g(this.f12294i, this.f12288c, this.f12289d, this.f12290e, this.f12291f, o.a.f12258f);
            return;
        L4:
            e = move-exception;
            o.f(e);
            goto L6
        }
    }

    class k extends d.b.s.a.q.k.c {
        k(p r1) {
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.q.m.d) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.q.m.d) r1);
        }

        public void m(d.b.s.a.q.m.d r1, int r2) {
        }

        public void n(d.b.s.a.q.m.d r1) {
        }
    }

    private interface l {
        void a(boolean r1);
    }

    static {
        N = new CopyOnWriteArrayList();
        O = false;
        P = new AtomicBoolean(false);
        Q = new d();
    }

    private p() {
        this.f12262f = false;
        this.f12263g = true;
        this.f12264h = false;
        this.f12265i = false;
        this.f12266j = new Object();
        this.f12267k = new t();
        this.f12268l = "";
        this.m = "";
        this.q = new AtomicBoolean(false);
        this.r = true;
        this.t = false;
        this.u = new c(this);
        this.w = true;
        this.C = false;
        this.D = null;
        this.E = new Object();
        this.F = 0;
        this.H = false;
        this.I = new Object();
        this.f12261J = new CopyOnWriteArraySet();
        this.K = new AtomicBoolean(false);
        this.L = 0;
    }

    private void A() {
        X();
        P0(true, false);
        I0();
    }

    private void B(boolean r6) {
        Set<l> r0 = this.f12261J;
        monitor-enter(r0);
        Iterator<l> r1 = this.f12261J.iterator();     // Catch: Throwable -> L15
    L6:
        if (r1.hasNext() == false) goto L12;
        r1.next().a(r6);     // Catch: Exception -> L10 Throwable -> L15
    L10:
        e = move-exception;
        d.b.s.a.a0.a.c("TokenFactory", "callbackTicketInit error", e);     // Catch: Throwable -> L15
        goto L6
    L12:
        this.f12261J.clear();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void D() {
        if (R == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder();
        boolean r1 = com.ss.android.i.j.k().g();
        if (this.u.a() == null) goto L16;
        if (this.u.a().m() == false) goto L16;
        if (this.v == true) goto L16;
        String r2 = this.o.getString(d.b.s.a.n.f14870c);
        if (r1 == true) goto L14;
        o.d("token_beat_not_poll", r2, null);
    L14:
        r0.append(r2);
    L16:
        if (this.w == true) goto L22;
        String r3 = this.o.getString(d.b.s.a.n.f14868a);
        if (r1 == true) goto L20;
        o.d("token_beat_not_config", r3, this.z);
    L20:
        r0.append(r3);
    L22:
        if (com.bytedance.common.utility.i.o(this.o) == false) goto L32;
        if (this.x == true) goto L26;
    L27:
        String r4 = this.o.getString(d.b.s.a.n.f14873f);
        if (r1 == true) goto L30;
        o.d("sdk-version-not-add", r4, null);
    L30:
        r0.append(r4);
        goto L32
    L26:
        if (this.y == false) goto L27;
    L32:
        if (this.n.o() == true) goto L36;
        if (r1 == true) goto L35;
        o.j();
    L35:
        r0.append(this.o.getString(d.b.s.a.n.f14874g));
    L36:
        String r5 = r0.toString();
        if (r1 == false) goto L42;
        if (TextUtils.isEmpty(r5) == true) goto L42;
        ShowDialogActivity.d(this.o, "token sdk status error", r5);
    L42:
        if (R == false) goto L45;
        o.u(this.F);
        return;
    }

    private void D0(String r7, Object r8, com.ss.android.token.f r9, d.b.s.a.q.j.a<d.b.s.a.q.j.d> r10) {
        com.bytedance.sdk.account.impl.e.a().c(r7, null, r8, r9, r10);
    }

    private void E() {
        if (com.bytedance.sdk.account.settings.f.a.o() == false) goto L12;
        String r0 = com.bytedance.sdk.account.settings.f.a.f();
        if (TextUtils.isEmpty(r0) == true) goto L15;
        String[] r1 = r0.split(",");
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L17;
        String r4 = r1[r3];
        if (this.f12267k.f12309a.contains(r4) == false) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        d.b.s.a.a0.a.b("TokenFactory", "loadDataFromSp, token not match rule: " + r4);
        com.bytedance.sdk.account.monitor.c.n(this.f12267k.f12309a);
        return;
    L17:
        return;
    L15:
        return;
    }

    protected static void E0(Context r1, com.ss.android.token.l r2) {
        K().O0(r1, r2);
    }

    private void H(@Nullable kotlin.n0.c.l<com.bytedance.android.sdk.bdticketguard.m1.c, f0> r5) {
        k1 r0 = x0.f1087b.a();
        if (r0 != null) goto L8;
        d.b.s.a.a0.a.b("TokenFactory", "createInitialAttestSign, tgService is null");
        if (r5 == null) goto L16;
        r5.invoke(null);
        return;
    L16:
        return;
    L8:
        com.ss.android.token.j r4 = com.ss.android.token.i.f12216c.b(this.o);
        if (r4 != null) goto L14;
        d.b.s.a.a0.a.b("TokenFactory", "createInitialAttestSign, secTimeStruct is null");
        if (r5 == null) goto L17;
        r5.invoke(null);
        return;
    L17:
        return;
    L14:
        r0.l(r4.b(), r5);
        d.b.s.a.a0.a.d("TokenFactory", "createInitialAttestSign");
    }

    private void I0() {
        this.p.sendEmptyMessageDelayed(2000, 60000);
    }

    private String J(String r3) {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (r3.startsWith("https://") == false) goto L7;
        int r0 = 8;
    L9:
        int r1 = r3.indexOf(47, r0);     // Catch: Throwable -> L15
        if (r1 <= 0) goto L14;
        return r3.substring(r0, r1).toLowerCase();
    L14:
        return r3.substring(r0).toLowerCase();
    L7:
        if (r3.startsWith("http://") == false) goto L19;
        r0 = 7;
        goto L9
    L19:
        return null;
    }

    protected static p K() {
        if (M != null) goto L15;
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (M != null) goto L9;
        M = new p();     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
    L15:
        return M;
    }

    private void N0(String r6, @Nullable l r7) {
        boolean r0 = com.bytedance.sdk.account.ticketguard.f.s();
        if (r0 == true) goto L8;
        d.b.s.a.a0.a.a("TokenFactory", "triggerTicketInitNew from=" + r6 + ", enable=" + r0 + ", hasCallInitTicket=" + P.get());
        s0();
        if (r7 == null) goto L23;
        r7.a(false);
        return;
    L23:
        return;
    L8:
        Boolean r1 = this.D;
        if (r1 == null) goto L13;
        if (r7 == null) goto L24;
        r7.a(r1.booleanValue());
        return;
    L24:
        return;
    L13:
        if (r7 == null) goto L16;
        this.f12261J.add(r7);
    L16:
        if (P.compareAndSet(false, true) == false) goto L18;
        d.b.s.a.a0.a.a("TokenFactory", "triggerTicketInitNew isEnableTokenGuard=true, ticket init start");
        com.bytedance.sdk.account.ticketguard.b.f5771b.b(this.o, new com.ss.android.token.a(this));
        s0();
        return;
    L18:
        Boolean r8 = this.D;
        if (r8 == null) goto L21;
        d.b.s.a.a0.a.a("TokenFactory", "triggerTicketInitNew from=" + r6 + ", ticket is initialzed");
        B(r8.booleanValue());
        return;
    L21:
        d.b.s.a.a0.a.a("TokenFactory", "triggerTicketInitNew isEnableTokenGuard=true, ticket has been inited, waiting for callback");
    }

    public static String O(Object r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        String r4 = r3.toString();
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return "";
    L9:
        if (r4.length() > 10) goto L11;
        return r4;
    L11:
        return r4.substring(0, 9) + "***" + r4.substring(r4.length() - 5);
    }

    private void O0(Context r3, com.ss.android.token.l r4) {
        if (this.H == false) goto L5;
        return;
    L5:
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.tryInitInstance start");
        monitor-enter(p.class);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (this.H == false) goto L11;
        monitor-exit(p.class);     // Catch: Throwable -> L17
        return;
    L11:
        this.n = r4;     // Catch: Throwable -> L17
        this.o = r3.getApplicationContext();     // Catch: Throwable -> L17
        Application r5 = (Application) this.o;     // Catch: Throwable -> L17
        if (r5 == null) goto L14;
        d.b.s.a.l0.d.j(r5);     // Catch: Throwable -> L17
    L14:
        R = w.j(this.o);     // Catch: Throwable -> L17
        this.p = new WeakHandler(Looper.getMainLooper(), this);     // Catch: Throwable -> L17
        P();     // Catch: Throwable -> L17
        this.H = true;     // Catch: Throwable -> L17
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.tryInitInstance finish. isMainProcess: " + R);     // Catch: Throwable -> L17
        monitor-exit(p.class);     // Catch: Throwable -> L17
    }

    private AuthTokenMultiProcessSharedProvider.c P() {
        if (this.A != null) goto L9;
        String r0 = this.n.m();
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = "token_shared_preference";
    L7:
        this.A = AuthTokenMultiProcessSharedProvider.n(this.o, r0, R);
    L9:
        return this.A;
    }

    private d0 Q(String r7, String r8, boolean r9, String r10) {
        k1 r6 = x0.f1087b.a();
        if (r6 != null) goto L7;
        d.b.s.a.a0.a.h("TokenFactory", "getObtainTicketGuardParams, ticket guard service is null, ticketName: " + r10);
        return null;
    L7:
        return r6.i(new e0(r7, r8, false, false, r9));
    }

    private void R0() {
        if (this.s == false) goto L6;
        this.s = false;
        AuthTokenMultiProcessSharedProvider.b r2 = P().b();
        r2.b("first_beat", false);
        r2.a();
        return;
    }

    private String S() {
        return "2";
    }

    private String V(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return null;
    L10:
        return Uri.parse(r2).getPath();
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private void X() {
        String r0 = d.b.s.a.q.d.e("/passport/account/info/v2/") + LocationMonitorConst.CACHE;
        boolean r1 = this.u.a().m();
        d.b.s.a.a0.a.a("TokenFactory", "isLogin = " + r1);
        if (r1 == true) goto L5;
        String r2 = d.b.s.a.l0.g.c().b(r0, null);
        d.b.s.a.a0.a.a("TokenFactory", "cache = " + r2);
        if (TextUtils.isEmpty(r2) == false) goto L13;
        d.b.s.a.a0.a.a("TokenFactory", "do account/info request, un-login");
        com.bytedance.sdk.account.impl.e.a().d("normal", new a(this, r0));
        return;
    L13:
        return;
    L5:
        if (com.bytedance.sdk.account.ticketguard.f.t() == false) goto L11;
        d.b.s.a.a0.a.a("TokenFactory", "do account/info request, login");
        com.bytedance.sdk.account.impl.e.a().d("boot", null);
        return;
    }

    @SuppressLint({"[ByDesign9.6]GetXTTToken"})
    private void Y() {
        if (this.u.a() == null) goto L5;
        long r0 = this.u.a().getUserId();
    L6:
        o.A(r0, U().f12309a);
        com.bytedance.sdk.account.impl.e.a().d("reveal", new k(this));
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private void Z(String r16, String r17, long r18, long r20, String r22, String r23) {
        SimpleDateFormat r1 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        r1.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date r2 = r1.parse(r17);     // Catch: ParseException -> L8
        if (r2 == null) goto L6;
        long r13 = r2.getTime();     // Catch: ParseException -> L8
        d.b.s.a.i0.d.h().e(this.o, r13, r18, r20, true);     // Catch: ParseException -> L8
        d.b.s.a.a0.a.d("TokenFactory", "拦截请求返回时间戳完成，下发值 " + r17 + "，解析转换后 " + r13 + "，当前时间戳 " + r18 + "，时间差 " + (r13 - r18) + "，path " + r22 + "，logid " + r23);     // Catch: ParseException -> L8
    L11:
        return;
    L6:
        d.b.s.a.a0.a.a("TokenFactory", "拦截请求返回时间戳异常，date 解析为空，date=" + r17);     // Catch: ParseException -> L8
    L8:
        e = move-exception;
        d.b.s.a.a0.a.c("TokenFactory", "拦截请求返回时间戳异常", e);
    }

    static /* synthetic */ Context a(p r0) {
        return r0.o;
    }

    static /* synthetic */ com.ss.android.i.h b(p r0) {
        return r0.G;
    }

    private void b0(String r10, String r11, com.ss.android.token.h r12, String r13) {
        if ("/passport/token/beat/v2/".equals(r10) == true) goto L6;
        return;
    L6:
        if (com.bytedance.sdk.account.settings.f.a.s() == true) goto L9;
        return;
    L9:
        if (com.bytedance.sdk.account.settings.f.a.C(r10) == true) goto L11;
        return;
    L11:
        if (r12 == null) goto L45;
        Map<String, String> r0 = r12.f12210a;
        if (r0 == null) goto L48;
        String r5 = r0.get("x-uc-sec-uid");
        String r14 = r12.f12210a.get("X-Tt-Token");
        if (TextUtils.isEmpty(r5) == false) goto L21;
        if (TextUtils.isEmpty(r14) == false) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r13) == false) goto L23;
    L25:
        boolean r1 = TextUtils.isEmpty(r5);
        boolean r8 = TextUtils.isEmpty(r13);
        if (r1 == true) goto L34;
        if (r8 == false) goto L34;
        if (this.u.a() == null) goto L34;
        if (TextUtils.isEmpty(this.u.a().k()) == false) goto L34;
        return;
    L34:
        if (this.u.a() != null) goto L36;
    L38:
        boolean r2 = false;
    L39:
        d.b.s.a.a0.a.b("TokenFactory", "account user uid mixed, logid=" + r11);
        o.z(r10, r11, TextUtils.isEmpty(r14), r13, r5, r2, "old_path");
        if (r8 == false) goto L42;
        return;
    L42:
        if (com.bytedance.sdk.account.settings.f.a.v() == false) goto L47;
        this.p.removeMessages(PathInterpolatorCompat.MAX_NUM_POINTS);
        this.p.sendEmptyMessageDelayed(PathInterpolatorCompat.MAX_NUM_POINTS, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        return;
    L47:
        return;
    L36:
        if (this.u.a().m() == false) goto L38;
        r2 = true;
        goto L39
    L23:
        if (r13.equals(r5) == false) goto L25;
        return;
    L48:
        return;
    }

    static /* synthetic */ void c(p r0, Map r1, com.bytedance.android.sdk.bdticketguard.n r2, com.bytedance.android.sdk.bdticketguard.l r3) {
        r0.y(r1, r2, r3);
    }

    private void c0(Map<String, String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        String r1 = this.u.a().o();
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r2.put("x-tt-passport-verify-portrait", r1);
        return;
    }

    static /* synthetic */ boolean d(p r0, boolean r1) {
        r0.f12262f = r1;
        return r1;
    }

    static /* synthetic */ Handler e(p r0) {
        return r0.p;
    }

    protected static void e0(Context r2, com.ss.android.token.l r3) {
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.initialize start");
        E0(r2, r3);
        p r4 = K();
        r4.n0(false, "TokenFactory.initialize");
        if (r4.r == false) goto L5;
    L9:
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.initialize finish");
        return;
    L5:
        if (R == false) goto L9;
        String r5 = r4.f12267k.f12309a;
        r4.G();
        if (TextUtils.isEmpty(r5) == true) goto L9;
        o.c("token_disabled", r4.f12267k.f12309a);
        goto L9
    }

    static /* synthetic */ void f(p r0) {
        r0.R0();
    }

    static /* synthetic */ void g(p r0, String r1, String r2, String r3, String r4, o.a r5) {
        r0.q0(r1, r2, r3, r4, r5);
    }

    public static boolean g0() {
        return O;
    }

    static /* synthetic */ JSONObject h(p r0) {
        return r0.z;
    }

    static /* synthetic */ JSONObject i(p r0, JSONObject r1) {
        r0.z = r1;
        return r1;
    }

    private boolean i0(String r1) {
        if ("change.token".equals(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L7;
        return true;
    }

    static /* synthetic */ boolean j(p r0, boolean r1) {
        r0.w = r1;
        return r1;
    }

    private /* synthetic */ f0 j0(CountDownLatch r3, AtomicBoolean r4, com.bytedance.android.sdk.bdticketguard.m1.c r5) {
        d.b.s.a.a0.a.d("TokenFactory", "createInitialAttestSign: " + r5);
        r3.countDown();
        if (r4.compareAndSet(false, true) == false) goto L6;
        A();
    L6:
        return f0.f18324a;
    }

    static /* synthetic */ List k() {
        return N;
    }

    static /* synthetic */ com.ss.android.token.l l(p r0) {
        return r0.n;
    }

    private /* synthetic */ f0 l0(Boolean r3) {
        d.b.s.a.a0.a.d("TokenFactory", "triggerTicketInitNew -- ticket init finish");
        this.D = r3;
        B(r3.booleanValue());
        return f0.f18324a;
    }

    static /* synthetic */ t m(p r0) {
        return r0.f12267k;
    }

    static /* synthetic */ boolean n(p r0) {
        return r0.f12264h;
    }

    private void n0(boolean r5, String r6) {
        if (O == false) goto L7;
        if (r5 == true) goto L34;
        z();
        return;
    L34:
        return;
    L7:
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.loadData start, isLazyLoad = " + r5 + " callFrom: " + r6);
        Object r0 = this.I;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L10:
        if (O == false) goto L16;
        if (r5 == true) goto L13;
        z();     // Catch: Throwable -> L30
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L16:
        if (R == true) goto L18;
        this.B = new u(this.o);     // Catch: Throwable -> L30
    L23:
        this.G = com.ss.android.i.h.k(this.o, P(), R);     // Catch: Throwable -> L30
        if (R == false) goto L26;
        com.bytedance.common.utility.m.c.c(new e(this));     // Catch: Throwable -> L30
    L26:
        a0("init");     // Catch: Throwable -> L30
        O = true;     // Catch: Throwable -> L30
        r0();     // Catch: Throwable -> L30
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.loadData finish, isLazyLoad = " + r5 + " callFrom: " + r6);     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        O = true;
        return;
    L18:
        if (TextUtils.isEmpty(this.n.g()) == true) goto L21;
        o0();     // Catch: Throwable -> L30
        goto L23
    L21:
        throw new IllegalStateException("not set beat host");     // Catch: Throwable -> L30
    }

    static /* synthetic */ Boolean o(p r0, Boolean r1) {
        r0.D = r1;
        return r1;
    }

    private void o0() {
        long r0 = System.currentTimeMillis();
        AuthTokenMultiProcessSharedProvider.c r2 = P();
        Object r3 = this.f12266j;
        monitor-enter(r3);
        String r4 = r2.e("X-Tt-Token", "");     // Catch: Throwable -> L11
        String r5 = "";
        String r6 = "";
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r5 = r2.e("ts_sign", "");     // Catch: Throwable -> L11
        r6 = r2.e("attest_ts_sign", "");     // Catch: Throwable -> L11
    L7:
        this.m = r2.e("mfa_token", "");     // Catch: Throwable -> L11
        this.f12267k = new t(r4, r5, r6);     // Catch: Throwable -> L11
        this.F = System.currentTimeMillis() - r0;     // Catch: Throwable -> L11
        this.f12264h = i0(r4);     // Catch: Throwable -> L11
        this.f12268l = r2.e("x-tt-token-last", "");     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        this.s = r2.c("first_beat", true);
        d.b.s.a.a0.a.d("TokenFactory", "loadDataFromSp. token: " + this.f12267k.b() + ", mfaToken: " + d.b.s.a.l0.n.b(this.m) + ", isTokenValid: " + this.f12264h + "loadTokenDuration: " + this.F + "mLastSameUserToken: " + d.b.s.a.l0.n.b(this.f12268l));
        E();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void p(p r0) {
        r0.s0();
    }

    static /* synthetic */ void q(p r0) {
        r0.z();
    }

    private void q0(String r1, String r2, String r3, String r4, o.a r5) {
        if (TextUtils.equals(r1, "frontier") == false) goto L6;
        o.q(r1, r2, r3, r4, r5);
        return;
    }

    static /* synthetic */ AuthTokenMultiProcessSharedProvider.c r(p r0) {
        return r0.P();
    }

    private void r0() {
        this.p.post(new b(this));
    }

    static /* synthetic */ String s(p r0) {
        return r0.S();
    }

    private void s0() {
        Object r0 = this.E;
        monitor-enter(r0);
        this.C = true;     // Catch: Throwable -> L8
        this.E.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    protected static void u(com.ss.android.token.e r1) {
        if (O == false) goto L6;
        r1.a();
        return;
    L6:
        N.add(r1);
    }

    private void v(Map<String, String> r1, d0 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Map<String, String> r0 = d.b.s.a.l0.p.a(r2.a());
        if (r0 == null) goto L8;
        r1.putAll(r0);
        return;
    }

    private String w0(String r3) {
        List<Pair<String, String>> r2 = d.b.s.a.l0.s.k(r3);
        if (r2 != null) goto L5;
    L14:
        return "";
    L5:
        if (r2.isEmpty() == true) goto L14;
        Iterator<Pair<String, String>> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        Pair<String, String> r5 = r4.next();
        if ("sec_user_id".equalsIgnoreCase((String) r5.first) == true) goto L20;
        if ("last_sec_user_id".equalsIgnoreCase((String) r5.first) == false) goto L8;
    L20:
        return (String) r5.second;
    }

    private void x(String r30, String r31, @NonNull t r32, boolean r33, String r34, com.ss.android.token.h r35, StringBuilder r36) {
        if (TextUtils.isEmpty(r31) == false) goto L5;
        return;
    L5:
        long r17 = System.currentTimeMillis();
        if ("/passport/account/info/v2/".equalsIgnoreCase(r31) == false) goto L8;
    L11:
        boolean r5 = true;
    L13:
        if (com.bytedance.sdk.account.ticketguard.f.s() == true) goto L17;
        if (r5 == false) goto L162;
        o.k(r30, r31, "experiment disable");
        return;
    L162:
        return;
    L17:
        Map<String, String> r13 = r35.f12210a;
        StringBuilder r8 = new StringBuilder();
        if (r33 == true) goto L20;
    L22:
        if (r5 == false) goto L24;
        o.k(r30, r31, "not match rules, rules=" + com.bytedance.sdk.account.ticketguard.f.c());
    L24:
        boolean r9 = false;
    L26:
        if (r13.containsKey("X-Tt-Token") == false) goto L33;
        long r3 = System.currentTimeMillis();
        int r10 = com.bytedance.sdk.account.ticketguard.f.i(r31);
        if (r10 == 0) goto L30;
    L32:
        long r20 = System.currentTimeMillis() - r3;
    L36:
        if (r10 != 0) goto L40;
        if (r33 == false) goto L40;
        d.b.s.a.a0.a.d("TokenFactory", "addTicketGuardHeader, token guard type is none for passport request, path: " + r31);
    L40:
        if (com.bytedance.sdk.account.ticketguard.c.c() == false) goto L58;
        if (r33 == false) goto L53;
        r36.append("sec_user_id,");
        d.b.s.a.q.f r0 = this.u.a();
        if (r0 != null) goto L45;
    L50:
        boolean r1 = true;
    L51:
        if (r1 == false) goto L55;
        r8.append("sec_user_id,");
    L55:
        if (com.bytedance.sdk.account.ticketguard.c.d(r31) == false) goto L57;
        boolean r4 = r1;
        boolean r6 = true;
    L60:
        boolean r7 = com.bytedance.sdk.account.ticketguard.f.q();
        if (r7 == true) goto L63;
    L65:
        boolean r22 = false;
    L67:
        if (r8.length() <= 0) goto L70;
        r8.deleteCharAt(r8.length() - 1);
        r13.put("passport-sdk-sign", r8.toString());
    L70:
        if (com.bytedance.sdk.account.ticketguard.f.m() == false) goto L72;
        boolean r23 = com.bytedance.sdk.account.ticketguard.f.y(r31);
        String r24 = r32.f12311c;
    L73:
        if (r9 == true) goto L80;
        if (r4 == true) goto L80;
        if (r10 != 0) goto L80;
        if (r6 == true) goto L80;
        if (r23 == true) goto L80;
        boolean r2 = false;
    L81:
        if (r2 == true) goto L83;
        return;
    L83:
        com.bytedance.sdk.account.ticketguard.b.f5771b.c();
        if (this.C == false) goto L86;
    L106:
        boolean r37 = r7;
        boolean r11 = false;
    L108:
        if (this.C == true) goto L110;
        d.b.s.a.a0.a.h("TokenFactory", "Wait for ticket init failed, path = " + r31);
    L110:
        if (r9 == true) goto L114;
        if (r4 == true) goto L114;
        int r12 = 3;
        d0 r14 = null;
    L123:
        if (r10 == r12) goto L127;
        if (r10 == 1) goto L127;
        boolean r19 = r11;
    L128:
        if (r10 != r12) goto L130;
    L133:
        boolean r25 = true;
    L134:
        if (r6 == false) goto L142;
        String r15 = w0(r34);
        if (r15 != null) goto L138;
        r15 = "";
    L138:
        String r16 = r15;
        String r18 = com.bytedance.sdk.account.ticketguard.h.d(r16);
        if (r18 != null) goto L141;
        r18 = "";
    L141:
        d0 r21 = r14;
        Map<String, String> r28 = r13;
        com.bytedance.android.sdk.bdticketguard.n r26 = new com.bytedance.android.sdk.bdticketguard.n(r18, r16, r30, r31, "sec_user_id", false, false, true, true, I(r31), r22);
    L148:
        if (r26 == null) goto L153;
        com.bytedance.android.sdk.bdticketguard.l r110 = W(r26);
        y(r28, r26, r110);
        if ("x-tt-token".equals(r26.j()) == false) goto L154;
        o.B(r20, System.currentTimeMillis() - r17, r30, r31, r19, r25, "inner");
    L154:
        r35.f12211b = r21;
        r35.f12212c = r110;
        return;
    L153:
        r110 = null;
        goto L154
    L142:
        r21 = r14;
        r28 = r13;
        if (r10 != 0) goto L147;
        if (r23 == true) goto L147;
        r26 = null;
    L147:
        r26 = new com.bytedance.android.sdk.bdticketguard.n(r32.f12310b, r32.f12309a, r30, r31, "x-tt-token", false, false, r19, r25, I(r31), r22, r23, r24);
        goto L148
    L130:
        if (r10 == 2) goto L133;
        r25 = r11;
    L127:
        r19 = true;
    L114:
        if (r4 == false) goto L116;
        String r27 = "sec_user_id";
    L117:
        d0 r29 = Q(r30, r31, r37, r27);
        v(r13, r29);
        if (r29 != null) goto L121;
        if (r5 == false) goto L121;
        o.k(r30, r31, "service null");
    L121:
        r14 = r29;
        r12 = 3;
        goto L123
    L116:
        r27 = "x-tt-token";
        goto L117
    L86:
        if (com.bytedance.sdk.account.ticketguard.f.v() == false) goto L106;
        d.b.s.a.a0.a.a("TokenFactory", String.format("%s start waiting for ticketInitLock", new Object[]{r31}));
        Object r38 = this.E;
        monitor-enter(r38);
    L103:
        th = move-exception;
        throw th;
    L90:
        if (this.C == false) goto L156;
        r37 = r7;
    L101:
        monitor-exit(r38);     // Catch: Throwable -> L103
        r11 = false;
        d.b.s.a.a0.a.a("TokenFactory", String.format("%s request continue, isTicketInited=%s", new Object[]{r31, Boolean.valueOf(this.C)}));
        goto L108
    L156:
        r37 = r7;
        this.E.wait(com.bytedance.sdk.account.ticketguard.f.k());     // Catch: InterruptedException -> L95 Throwable -> L103
    L95:
        e = e;
    L99:
        d.b.s.a.a0.a.a("TokenFactory", "ticketInitLock wait failed, e=" + Log.getStackTraceString(e));     // Catch: Throwable -> L103
    L97:
        e = e;
        r37 = r7;
    L80:
        r2 = true;
        goto L81
    L72:
        r24 = "";
        r23 = false;
        goto L73
    L63:
        if (com.bytedance.sdk.account.ticketguard.f.z(r31) == false) goto L65;
        r22 = true;
        goto L67
    L57:
        r4 = r1;
    L59:
        r6 = false;
        goto L60
    L45:
        if (r0.m() == false) goto L50;
        if (TextUtils.isEmpty(com.bytedance.sdk.account.ticketguard.h.d(r0.k())) == true) goto L50;
        if (r5 == false) goto L50;
        r1 = false;
        goto L51
    L53:
        r1 = false;
        goto L55
    L58:
        r4 = false;
        goto L59
    L30:
        if (r.f12301c.f(r31) == false) goto L32;
        d.b.s.a.a0.a.d("TokenFactory", "addTicketGuardHeader, path in temporary settings, path: " + r31);
        r10 = 3;
        goto L32
    L33:
        if (r33 == false) goto L35;
        d.b.s.a.a0.a.d("TokenFactory", "addTicketGuardHeader, token header does not exist for passport request, path: " + r31);
    L35:
        r20 = 0;
        r10 = 0;
        goto L36
    L20:
        if (com.bytedance.sdk.account.ticketguard.f.x(r30, r31) == false) goto L22;
        r36.append("x-tt-token");
        r36.append(",");
        r8.append("x-tt-token");
        r8.append(",");
        r9 = true;
        goto L26
    L8:
        if ("/passport/token/beat/v2/".equalsIgnoreCase(r31) == true) goto L11;
        r5 = false;
        goto L13
    }

    private void x0(String r3) {
        if (R == true) goto L6;
        return;
    L6:
        if (this.u.a().m() == true) goto L9;
        return;
    L9:
        if (this.f12264h == true) goto L12;
        d.b.s.a.a0.a.h("TokenFactory", "Token lost: " + r3);
    L12:
        if (this.f12265i == false) goto L14;
        return;
    L14:
        if (this.f12264h == true) goto L18;
        this.f12265i = true;
        o.v(r3);
        return;
    }

    private void y(Map<String, String> r6, com.bytedance.android.sdk.bdticketguard.n r7, com.bytedance.android.sdk.bdticketguard.l r8) {
        String r5 = r7.b();
        String r0 = r7.j();
        if (x0.f1087b.a() != null) goto L6;
        d.b.s.a.a0.a.h("TokenFactory", "addUseTicketGuardParams, ticket guard service is null");
        o.t(r7.b(), r0, "-1", "ticket guard service is null");
        return;
    L6:
        boolean r1 = TextUtils.isEmpty(r7.i());
        boolean r3 = !com.bytedance.sdk.account.ticketguard.f.u();
        boolean r9 = TextUtils.isEmpty(r7.l());
        if (r1 == true) goto L23;
        if (r3 == false) goto L11;
        if (r9 == true) goto L23;
    L11:
        if (r9 == false) goto L13;
        d.b.s.a.a0.a.h("TokenFactory", "addUseTicketGuardParams, tsSign is empty, continue sign");
        o.t(r5, r0, "-2", "tsSign is empty, continue sign");
    L13:
        if (r8 != null) goto L15;
    L21:
        o.t(r5, r0, "-3", "TicketGuardHeader is null or empty");
        return;
    L15:
        if (r8.a() == null) goto L21;
        if (r8.a().isEmpty() == true) goto L21;
        r6.putAll(d.b.s.a.l0.p.a(r8.a()));
        return;
    L23:
        if (r1 == false) goto L25;
        String r10 = "target is empty";
    L26:
        d.b.s.a.a0.a.h("TokenFactory", "addUseTicketGuardParams, " + r10);
        o.t(r5, r0, "-2", r10);
        return;
    L25:
        r10 = "tsSign is empty";
        goto L26
    }

    protected static void y0(Context r0, com.ss.android.token.l r1, @NonNull com.ss.android.d r2) {
        E0(r0, r1);
        d.b.s.a.l0.c.a();
        if (com.bytedance.sdk.account.ticketguard.f.j().f() == false) goto L5;
        com.bytedance.sdk.account.ticketguard.b.f5771b.c();
    L5:
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.preInit");
    }

    private void z() {
        if (this.q.compareAndSet(false, true) == false) goto L29;
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.afterInit, sIsMainProcess: " + R);
        r0();
        if (R == false) goto L30;
        q.f12297h.c(this.o);
        boolean r0 = com.bytedance.sdk.account.ticketguard.f.m();
        if (r0 == false) goto L19;
        final AtomicBoolean r4 = new AtomicBoolean(false);
        final CountDownLatch r5 = new CountDownLatch(1);
        H(new com.ss.android.token.b(this, r5, r4));
        boolean r6 = r5.await(1, TimeUnit.SECONDS);     // Catch: InterruptedException -> L16
        if (r6 == false) goto L12;
    L14:
        d.b.s.a.a0.a.d("TokenFactory", "afterInit, createInitialAttestSign isFinished: " + r6);     // Catch: InterruptedException -> L16
    L20:
        if (r0 == false) goto L31;
        com.ss.android.token.c r1 = com.ss.android.token.c.f12205i;
        r1.f(this.o);
        com.ss.android.token.k r2 = com.ss.android.token.k.m;
        r2.i(this.o);
        if (this.u.a().m() == true) goto L24;
        r2.j(false);
        String r9 = "afterInit not login, startUpdateSecTime";
    L25:
        d.b.s.a.a0.a.d("TokenFactory", r9);
        return;
    L24:
        r1.b("boot_login");
        r9 = "afterInit login, checkAndCompensate";
        goto L25
    L31:
        return;
    L12:
        if (r4.compareAndSet(false, true) == false) goto L14;
        A();     // Catch: InterruptedException -> L16
    L16:
        e = move-exception;
        d.b.s.a.a0.a.b("TokenFactory", "afterInit, createInitialAttestSign InterruptedException: " + e.getMessage());
        if (r4.compareAndSet(false, true) == false) goto L20;
    L19:
        A();
        goto L20
    L30:
        return;
    }

    private void z0(String r7, String r8, String r9, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return;
    L6:
        if (R == true) goto L9;
        return;
    L9:
        if (com.bytedance.sdk.account.settings.f.a.k() == true) goto L12;
        return;
    L12:
        if (this.u.a().m() == true) goto L15;
        return;
    L15:
        if (this.t == false) goto L17;
        return;
    L17:
        this.t = true;
        String r4 = new String(Base64.decode(r10, 2), kotlin.u0.d.f21429a);     // Catch: Throwable -> L23
        com.bytedance.sdk.account.impl.q r11 = com.bytedance.sdk.account.impl.q.g(r4);     // Catch: Throwable -> L21
    L26:
        if (r11 != null) goto L28;
        return;
    L28:
        d.b.s.a.a0.a.d("TokenFactory", "processDeviceTransfer, path:" + r8 + ", logId:" + r9 + ", decision:" + r4);
        o.e(r8, r9);
        String r12 = this.f12267k.f12309a;
        G();
        o.c("device_transfer", r12);
        d.b.s.a.q.f r13 = this.u.a();
        Long r0 = Long.valueOf(r13.getUserId());
        r13.x(false);
        o.w(r0, 0L, o.b(r7), "device_transfer");
        r13.i();
        r13.d();
        d.b.s.a.q.b r14 = new d.b.s.a.q.b(2);
        HashMap r1 = new HashMap();
        r1.put("logout_type", "device_transfer");
        r1.put("scene", "device_transfer");
        r14.f14883e = r1;
        r13.l(r14);
        com.ss.android.token.f r15 = new com.ss.android.token.f("device_transfer");
        r15.c(r11);
        D0("device_transfer", null, r15, null);
        return;
    L21:
        Throwable th = th;
    L25:
        d.b.s.a.a0.a.d("TokenFactory", "processDeviceTransfer(), decision base64 decode fail; " + th.getMessage());
        r11 = null;
    L23:
        th = move-exception;
        r4 = r10;
        th = th;
        goto L25
    }

    void A0(String r25, com.ss.android.token.h r26, @Nullable List<m> r27, List<m> r28) {
        if (TextUtils.isEmpty(r25) == false) goto L5;
        return;
    L5:
        String r11 = J(r25);
        if (r27 == null) goto L15;
        Iterator<m> r4 = r27.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        m r6 = r4.next();
        if ("X-Tt-Token".equalsIgnoreCase(r6.a()) == false) goto L9;
        boolean r5 = !TextUtils.isEmpty(r6.b());
    L14:
        String r7 = V(r25);
        o.g(r11, r7, r5);
    L17:
        if (R == true) goto L20;
        return;
    L20:
        if (f0(r25, r11) == true) goto L22;
        return;
    L22:
        if (r7 != null) goto L24;
        r7 = V(r25);
    L24:
        String r13 = r7;
        if (TextUtils.isEmpty(r11) == false) goto L27;
        return;
    L27:
        if (TextUtils.isEmpty(r13) == true) goto L246;
        n0(true, "processResponseHeader");
        boolean r14 = r13.startsWith("/passport/");
        ArrayList r8 = new ArrayList();
        HashMap r9 = new HashMap();
        HashSet r10 = new HashSet();
        if (r28 != null) goto L32;
    L91:
        String r2 = "";
        String r12 = r2;
        String r15 = r12;
        String r16 = r15;
        String r17 = r16;
        String r3 = null;
        boolean r18 = false;
    L93:
        if (com.bytedance.sdk.account.settings.f.a.w() == true) goto L96;
        b0(r13, r17, r26, r3);
    L96:
        if (TextUtils.isEmpty(r2) == false) goto L98;
    L100:
        boolean r19 = false;
    L102:
        if ("/passport/token/beat/v2/".equals(r13) == false) goto L104;
    L107:
        boolean r20 = true;
    L108:
        String r110 = r15;
        if (com.bytedance.sdk.account.ticketguard.f.r() == false) goto L129;
        if (r19 == false) goto L129;
        if (r18 == false) goto L129;
        r r1 = r.f12301c;
        boolean r111 = r1.f(r13);
        if (r111 == false) goto L115;
    L118:
        boolean r21 = true;
    L119:
        StringBuilder r112 = new StringBuilder();
        r112.append("TokenGuardTemporarySettings Token verify fail and require sign, remote error: ");
        r112.append(r2);
        r112.append(" path: ");
        r112.append(r13);
        String r113 = r16;
        r112.append(", requireSignPaths: ");
        r112.append(r10);
        ArrayList r22 = r8;
        r112.append(" isInTemporarySettings: ");
        r112.append(r111);
        r112.append(" isPathInSettings: ");
        r112.append(r21);
        d.b.s.a.a0.a.h("TokenFactory", r112.toString());
        if (r26 != null) goto L122;
    L124:
        boolean r23 = false;
    L125:
        if (r21 == true) goto L127;
        r1.b(r10);
        r1.g(r13, r2, r17, r23);
    L127:
        if (r111 == false) goto L130;
        d.b.s.a.a0.a.b("TokenFactory", "TokenGuardTemporarySettings path in temp config but still failed!!  remote error: " + r2 + " path: " + r13 + ", requireSignPaths: " + r10);
        r1.h(r13, r2, r17, r23);
    L130:
        boolean r0 = com.bytedance.sdk.account.ticketguard.f.m();
        if (TextUtils.isEmpty(r13) == true) goto L187;
        if (com.bytedance.sdk.account.ticketguard.f.s() == false) goto L187;
        k1 r24 = x0.f1087b.a();
        if (r24 == null) goto L185;
        if (r26 == null) goto L138;
        d0 r114 = r26.f12211b;
        com.bytedance.android.sdk.bdticketguard.l r115 = r26.f12212c;
    L139:
        if (r19 == true) goto L143;
        if (r14 == true) goto L143;
        if (r114 != null) goto L143;
        if (r115 != null) goto L143;
    L152:
        if (r14 == false) goto L176;
        if (r114 == null) goto L176;
        ArrayList r29 = r22;
        com.bytedance.android.sdk.bdticketguard.f0 r30 = r24.a(new com.bytedance.android.sdk.bdticketguard.s("", false, r114, r29));
        List<v0> r31 = r30.e();
        if (r0 == true) goto L157;
    L159:
        String r32 = "";
    L160:
        if (r31 != null) goto L162;
    L175:
        r113 = r113;
        String r33 = "";
        r32 = r32;
    L177:
        if (r115 == null) goto L182;
        if (r0 == false) goto L180;
        p this = this;
        com.ss.android.token.k.m.d(this.o, "after_request");
    L181:
        r24.d(new com.bytedance.android.sdk.bdticketguard.r(r115, r29));
    L189:
        if (TextUtils.isEmpty(r113) == false) goto L191;
    L211:
        String r34 = r11;
    L212:
        boolean r116 = false;
    L213:
        if (r116 == true) goto L218;
        if (TextUtils.isEmpty(r32) == true) goto L218;
        t r35 = this.f12267k;
        this.G0(new t(r35.f12309a, r35.f12310b, r32));
    L218:
        if (TextUtils.isEmpty(r110) == true) goto L222;
        String r36 = r110;
        if (TextUtils.equals(r36, this.m) == true) goto L222;
        this.m = r36;
        AuthTokenMultiProcessSharedProvider.b r37 = P().b();
        r37.d("mfa_token", r36);
        r37.a();
        o.h(r34, r13, r17, O(r36));
    L222:
        if (r14 == false) goto L224;
        o.m(r34, r13, r17, r28, com.bytedance.sdk.account.settings.f.c.f5756f.f().b());
    L224:
        this.z0(r25, r13, r17, r12);
        return;
    L191:
        if (P() == null) goto L211;
        r34 = r11;
        if (com.bytedance.sdk.account.settings.f.d.a(r34, r13) == false) goto L210;
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.processResponseHeader: update x-tt-token by host: " + r34 + " , path: " + r13);
        if (TextUtils.equals(r113, this.f12267k.f12309a) == true) goto L197;
    L200:
        if (r33 != null) goto L202;
        r33 = "";
    L202:
        if (r32 != null) goto L204;
        String r38 = "";
    L205:
        if (r20 == true) goto L207;
    L209:
        String r39 = this.f12267k.f12309a;
        t r40 = new t(r113, r33, r38);
        this.G0(r40);
        r12 = r12;
        r110 = r110;
        o.x(r34, r13, r17, r26, r40, r39, r28, "interceptor");
        o.s(r113, r17);
        r32 = r38;
        r116 = true;
        goto L213
    L207:
        if (this.u.a().m() == false) goto L209;
        B0();
        goto L209
    L204:
        r38 = r32;
        goto L205
    L197:
        if (TextUtils.isEmpty(r33) == true) goto L212;
    L210:
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory.processResponseHeader: TokenSaveManager forbids token saving from this host and path: " + r34 + " " + r13);
        goto L212
    L180:
        this = this;
        goto L181
    L182:
        this = this;
        if (r19 == false) goto L189;
        z0.H(r13, r17, r2);
        goto L189
    L162:
        if (r31.isEmpty() == true) goto L175;
        Iterator<v0> r41 = r31.iterator();
        r33 = "";
    L165:
        if (r41.hasNext() == false) goto L174;
        v0 r117 = r41.next();
        StringBuilder r118 = new StringBuilder();
        String r210 = r32;
        r118.append("save ts_sign: ");
        r118.append(O(r117.b()));
        d.b.s.a.a0.a.a("TokenFactory", r118.toString());
        if (TextUtils.isEmpty(r113) == true) goto L171;
        String r119 = r113;
        if (r119.equals(r117.a()) == false) goto L172;
        r33 = r117.b();
    L173:
        r113 = r119;
        r32 = r210;
    L172:
        com.bytedance.sdk.account.ticketguard.h.e(r117.a(), r117.b());
        goto L173
    L171:
        r119 = r113;
        goto L172
    L174:
        r113 = r113;
        goto L177
    L157:
        if (TextUtils.isEmpty(r30.c()) == true) goto L159;
        r32 = r30.c();
    L176:
        r113 = r113;
        r29 = r22;
        r32 = "";
        r33 = r32;
    L143:
        StringBuilder r120 = new StringBuilder();
        r120.append("processResponseHeader, path: ");
        r120.append(r13);
        r120.append(", isVerifyFail: ");
        r120.append(r19);
        r120.append(", verifyResult: ");
        r120.append(r2);
        r120.append(", logid: ");
        r120.append(r17);
        r120.append(", hasProviderRequestContent: ");
        if (r114 == null) goto L146;
        boolean r42 = true;
    L147:
        r120.append(r42);
        r120.append(", hasConsumerRequestContent: ");
        if (r115 == null) goto L150;
        boolean r43 = true;
    L151:
        r120.append(r43);
        d.b.s.a.a0.a.a("TokenFactory", r120.toString());
        goto L152
    L150:
        r43 = false;
        goto L151
    L146:
        r42 = false;
        goto L147
    L138:
        r114 = null;
        r115 = null;
        goto L139
    L185:
        d.b.s.a.a0.a.h("TokenFactory", "processResponseHeader, TicketGuardService is null, path: " + r13 + ", isVerifyFail: " + r19 + ", verifyResult: " + r2 + ", logid: " + r17);
    L187:
        r32 = "";
        r33 = r32;
        goto L189
    L122:
        if (r26.f12212c == null) goto L124;
        r23 = true;
        goto L125
    L115:
        if (com.bytedance.sdk.account.ticketguard.f.i(r13) != 0) goto L118;
        r21 = false;
    L129:
        r22 = r8;
        r20 = r20;
        r11 = r11;
        r113 = r16;
        goto L130
    L104:
        if ("/passport/account/info/v2/".equals(r13) == true) goto L107;
        r20 = false;
        goto L108
    L98:
        if (r2.equals(BDLocationException.ERROR_TIMEOUT) == true) goto L100;
        r19 = true;
        goto L102
    L32:
        if (r28.isEmpty() == true) goto L91;
        Iterator<m> r44 = r28.iterator();
        r17 = "";
        String r121 = r17;
        String r122 = r121;
        String r211 = r122;
        String r212 = r211;
        String r123 = null;
        r18 = false;
    L35:
        if (r44.hasNext() == false) goto L90;
        m r213 = r44.next();
        String r45 = r213.a();
        String r124 = r213.b();
        r8.add(new Pair(r45, r124));
        r9.put(r45, r124);
        String r46 = r45.toLowerCase();
        r46.hashCode();
        switch(r46.hashCode()) {
            case -1976085669: goto L68;
            case -1846329444: goto L64;
            case -1253238716: goto L60;
            case -1177502390: goto L56;
            case -272647289: goto L52;
            case -265255391: goto L48;
            case 1630751484: goto L44;
            case 1972804273: goto L40;
            default: goto L38;
        };
    L38:
        byte r47 = -1;
    L71:
        switch(r47) {
            case 0: goto L88;
            case 1: goto L87;
            case 2: goto L86;
            case 3: goto L85;
            case 4: goto L84;
            case 5: goto L83;
            case 6: goto L75;
            case 7: goto L73;
            default: goto L35;
        };
    L73:
        r211 = r213.b();
        goto L35
    L83:
        r122 = r213.b();
        goto L35
    L84:
        r17 = r213.b();
        goto L35
    L85:
        r212 = r213.b();
        goto L35
    L86:
        r213.b();
        goto L35
    L87:
        r123 = r213.b();
        goto L35
    L88:
        r121 = r213.b();
        goto L35
    L75:
        if (TextUtils.isEmpty(r124) == true) goto L82;
        String[] r48 = r124.split(",");
        int r49 = r48.length;
        int r125 = 0;
    L77:
        if (r125 >= r49) goto L82;
        String r126 = r48[r125];
        String[] r214 = r48;
        if (TextUtils.isEmpty(r126) == true) goto L81;
        r10.add(r126.trim());
    L81:
        r125 = r125 + 1;
        r48 = r214;
    L82:
        r10.add(r13);
        r18 = true;
        goto L35
    L40:
        if (r46.equals("x-tt-passport-mfa-token") == false) goto L38;
        r47 = 7;
        goto L71
    L44:
        if (r46.equals("bd-ticket-guard-need-sign-path") == false) goto L38;
        r47 = 6;
        goto L71
    L48:
        if (r46.equals("x-tt-token") == false) goto L38;
        r47 = 5;
        goto L71
    L52:
        if (r46.equals("x-tt-logid") == false) goto L38;
        r47 = 4;
        goto L71
    L56:
        if (r46.equals("x-tt-passport-device-transfer-decision") == false) goto L38;
        r47 = 3;
        goto L71
    L60:
        if (r46.equals("passport-sdk-sign-check-result") == false) goto L38;
        r47 = 2;
        goto L71
    L64:
        if (r46.equals("d-ticket-sec-uid") == false) goto L38;
        r47 = 1;
        goto L71
    L68:
        if (r46.equals("bd-ticket-guard-result") == false) goto L38;
        r47 = 0;
        goto L71
    L90:
        this.G.q(r13, r9);
        r2 = r121;
        r3 = r123;
        r16 = r122;
        r15 = r211;
        r12 = r212;
        goto L93
    L246:
        return;
    L13:
        r5 = false;
        goto L14
    L15:
        r7 = null;
        goto L17
    }

    void B0() {
        if (com.bytedance.sdk.account.settings.f.a.x() == true) goto L5;
        return;
    L5:
        n0(true, "saveLastToken");
        if (R == false) goto L15;
        Object r0 = this.f12266j;
        monitor-enter(r0);
        d.b.s.a.a0.a.a("TokenFactory", "save last token");     // Catch: Throwable -> L12
        this.f12268l = this.f12267k.f12309a;     // Catch: Throwable -> L12
        AuthTokenMultiProcessSharedProvider.b r1 = P().b();     // Catch: Throwable -> L12
        r1.d("x-tt-token-last", this.f12267k.f12309a);     // Catch: Throwable -> L12
        r1.a();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        this.B.g();
    }

    public void C() {
        d.b.s.a.a0.a.a("TokenFactory", "cancelRevealTokenBeat mBeating=" + this.f12263g);
        if (this.f12263g == true) goto L6;
        return;
    L6:
        if (this.p.hasMessages(1000, 1) == false) goto L9;
        this.p.removeMessages(1000);
        this.p.sendEmptyMessageDelayed(1000, this.n.n());
        d.b.s.a.a0.a.a("TokenFactory", "cancelRevealTokenBeat do remove");
        return;
    }

    public void C0() {
        d.b.s.a.a0.a.a("TokenFactory", "scheduleRevealTokenBeat isUpdateLoading=" + this.f12262f + " mBeating=" + this.f12263g);
        if (this.f12262f == false) goto L5;
        return;
    L5:
        if (this.f12263g == false) goto L10;
        this.p.removeMessages(1000);
        Message r0 = this.p.obtainMessage(1000);
        r0.obj = 1;
        this.p.sendMessageDelayed(r0, BDLocationConfig.sScanBleMaxInterval);
        d.b.s.a.a0.a.a("TokenFactory", "scheduleRevealTokenBeat do send");
        return;
    }

    void F() {
        if (com.bytedance.sdk.account.settings.f.a.x() == true) goto L5;
        return;
    L5:
        n0(true, "clearLastToken");
        if (R == false) goto L15;
        Object r0 = this.f12266j;
        monitor-enter(r0);
        d.b.s.a.a0.a.a("TokenFactory", "clear last token");     // Catch: Throwable -> L12
        this.f12268l = "";     // Catch: Throwable -> L12
        AuthTokenMultiProcessSharedProvider.b r3 = P().b();     // Catch: Throwable -> L12
        r3.d("x-tt-token-last", "");     // Catch: Throwable -> L12
        r3.a();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        this.B.a();
    }

    void F0(boolean r1) {
        this.r = r1;
        if (this.r == false) goto L5;
        return;
    L5:
        if (R == true) goto L7;
        return;
    L7:
        if (O == false) goto L14;
        String r2 = this.f12267k.f12309a;
        G();
        if (TextUtils.isEmpty(r2) == true) goto L15;
        o.c("token_disabled", r2);
        return;
    L15:
        return;
    }

    void G() {
        d.b.s.a.a0.a.a("TokenFactory", "clearToken");
        G0(new t());
    }

    void G0(@NonNull t r5) {
        n0(true, "setTokenObject");
        if (R == false) goto L12;
        Object r0 = this.f12266j;
        monitor-enter(r0);
        this.f12267k = r5;     // Catch: Throwable -> L9
        AuthTokenMultiProcessSharedProvider.b r1 = P().b();     // Catch: Throwable -> L9
        r1.d("X-Tt-Token", r5.f12309a);     // Catch: Throwable -> L9
        r1.d("ts_sign", r5.f12310b);     // Catch: Throwable -> L9
        r1.d("attest_ts_sign", r5.f12311c);     // Catch: Throwable -> L9
        r1.a();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.f12264h = i0(r5.f12309a);
        d.b.s.a.a0.a.a("TokenFactory", "setTokenObject " + r5.b() + " isTokenValid: " + this.f12264h);
    L13:
        z0.f1102e.w("x-tt-token", r5.f12309a, r5.f12310b);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        this.B.h(r5);
        d.b.s.a.a0.a.a("TokenFactory", "setTokenObject in subprocess " + r5.b());
        goto L13
    }

    boolean H0(List<m> r3) {
        if (r3 == null) goto L11;
        Iterator<m> r2 = r3.iterator();
    L5:
        if (r2.hasNext() == false) goto L11;
        m r4 = r2.next();
        if (r4 == null) goto L5;
        if ("x-uc-bypass-token".equalsIgnoreCase(r4.a()) == false) goto L5;
        String r5 = r4.b();
    L13:
        return LocationInfoConst.ALLOW_USE_LOCATION.equals(r5);
    L11:
        r5 = null;
        goto L13
    }

    long I(String r2) {
        return d.b.s.a.i0.d.h().g(this.o, true, true).a();
    }

    void J0() {
        if (R == true) goto L5;
        return;
    L5:
        this.p.sendEmptyMessageDelayed(1000, this.n.n());
    }

    void K0() {
        this.p.removeMessages(PathInterpolatorCompat.MAX_NUM_POINTS);
        this.p.sendEmptyMessageDelayed(PathInterpolatorCompat.MAX_NUM_POINTS, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    String L() {
        if (com.bytedance.sdk.account.settings.f.a.x() == true) goto L6;
        return "";
    L6:
        n0(true, "getLastSameUserToken");
        if (R == false) goto L11;
        return this.f12268l;
    L11:
        return this.B.b();
    }

    public void L0() {
        if (R == true) goto L5;
        return;
    L5:
        this.p.removeMessages(1000);
    }

    com.ss.android.token.g M() {
        if (this.n != null) goto L5;
        return null;
    L5:
        return this.n.j();
    }

    protected void M0(String r4, @Nullable l r5) {
        if (Q.a().booleanValue() == false) goto L6;
        N0(r4, r5);
        return;
    L6:
        boolean r0 = com.bytedance.sdk.account.ticketguard.f.s();
        StringBuilder r1 = new StringBuilder();
        r1.append("triggerTicketInit from=");
        r1.append(r4);
        r1.append(", enable=");
        r1.append(r0);
        r1.append(", hasCallInitTicket=");
        AtomicBoolean r6 = P;
        r1.append(r6.get());
        d.b.s.a.a0.a.a("TokenFactory", r1.toString());
        if (r0 == true) goto L9;
        d.b.s.a.a0.a.a("TokenFactory", "isEnableTokenGuard=false, not to init ticket");
        s0();
        if (r5 == null) goto L20;
    L16:
        r5.a(false);
        return;
    L20:
        return;
    L9:
        if (r6.compareAndSet(false, true) == false) goto L11;
        d.b.s.a.a0.a.a("TokenFactory", "isEnableTokenGuard=true, ticket init start");
        com.bytedance.sdk.account.ticketguard.b.f5771b.b(this.o, new f(this, r5));
        return;
    L11:
        s0();
        if (r5 != null) goto L16;
    }

    public String N() {
        if (R == false) goto L7;
        return this.m;
    L7:
        return P().e("mfa_token", "");
    }

    protected void P0(boolean r9, boolean r10) {
        Q0(r9, r10, null, null, null, null, null);
    }

    protected void Q0(boolean r12, boolean r13, String r14, String r15, String r16, String r17, Object r18) {
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory tryUpdateToken, isBoot=" + r12 + ", isWap=" + r13 + ", scene=" + r14 + ", fromHost=" + r15 + ", fromPath=" + r16 + ", fromLogid=" + r17 + ", isMainProcess=" + R + ", isBeating=" + this.f12263g + ", isUpdateLoading=" + this.f12262f);
        if (R == true) goto L6;
        return;
    L6:
        if (this.f12263g == true) goto L9;
        return;
    L9:
        if (this.f12262f == false) goto L12;
        return;
    L12:
        if (this.u.a().m() == true) goto L15;
        d.b.s.a.a0.a.d("TokenFactory", "TokenFactory tryUpdateToken, not login");
        this.p.sendEmptyMessageDelayed(1000, this.n.n());
        return;
    L15:
        this.f12262f = true;
        this.v = true;
        com.ss.android.token.k.m.k();     // Catch: Throwable -> L18
    L20:
        String r0 = T(r12, r13, r14);
        if (TextUtils.isEmpty(r0) == false) goto L24;
        d.b.s.a.a0.a.h("TokenFactory", "TokenFactory tryUpdateToken, tokenUrl is empty");
        this.f12262f = false;
        return;
    L24:
        d.b.s.a.y.g.O(this.o, r0, new j(this, r14, r15, r16, r17, r0, r18)).D();
        return;
    L18:
        th = move-exception;
        d.b.s.a.a0.a.c("TokenFactory", "tryUpdateToken, stopUpdateSecTime error", th);
        goto L20
    }

    protected void R(com.ss.android.token.d r3) {
        if (this.n != null) goto L6;
        r3.a(-1, "not init TTTokenConfig");
        return;
    L6:
        h r0 = new h(this, r3);
        if (com.ss.android.i.j.l() != null) goto L9;
    L12:
        d.b.s.a.a0.a.d("TokenFactory", "TTAccountConfig or TTTokenConfig is null, wait for init finish");
        u(new i(this, r0));
        return;
    L9:
        if (this.n == null) goto L12;
        r0.run();
    }

    String T(boolean r4, boolean r5, String r6) {
        d.b.s.a.e0.c r1 = new d.b.s.a.e0.c(this.n.g() + "/passport/token/beat/v2/");
        if (r4 == false) goto L5;
        String r7 = "boot";
    L6:
        if (r5 == false) goto L9;
        r7 = "wap_login";
    L9:
        if (TextUtils.isEmpty(r6) == false) goto L12;
        r6 = r7;
    L12:
        r1.f("scene", r6);
        if (this.s == false) goto L15;
        String r3 = "true";
    L16:
        r1.b("first_beat", r3);
        return r1.toString();
    L15:
        r3 = "false";
        goto L16
    L5:
        r7 = "polling";
        goto L6
    }

    @NonNull
    @SuppressLint({"[ByDesign9.6]GetXTTToken"})
    t U() {
        n0(true, "getTokenObject");
        if (R == false) goto L7;
        return this.f12267k;
    L7:
        return this.B.c();
    }

    public com.bytedance.android.sdk.bdticketguard.l W(com.bytedance.android.sdk.bdticketguard.n r1) {
        k1 r0 = x0.f1087b.a();
        if (r0 != null) goto L7;
        d.b.s.a.a0.a.h("TokenFactory", "getUseTicketGuardParams, ticket guard service is null");
        return null;
    L7:
        return r0.n(r1);
    }

    protected void a0(String r2) {
        M0(r2, new g(this));
    }

    protected boolean d0(String r1) {
        if (r1 == null) goto L7;
        com.ss.android.token.l.a r0 = this.n.h();
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.a(r1);
    L7:
        return false;
    }

    protected boolean f0(String r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return false;
    L6:
        if (h0(r4) == true) goto L8;
        return false;
    L8:
        if (d0(r3) == true) goto L12;
        return true;
    L12:
        return false;
    }

    protected boolean h0(String r2) {
        if (this.r == true) goto L5;
    L7:
        return false;
    L5:
        if (w.h(r2, this.n.i()) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r4) {
        int r0 = r4.what;
        if (r0 != 1000) goto L11;
        Object r5 = r4.obj;
        if ((r5 instanceof Integer) == true) goto L7;
    L9:
        this.p.removeMessages(1000);
        P0(false, false);
        return;
    L7:
        if (((Integer) r5).intValue() != 1) goto L9;
        d.b.s.a.a0.a.a("TokenFactory", "handleMsg, obj=reveal");
        goto L9
    L11:
        if (r0 != 2000) goto L14;
        D();
        return;
    L14:
        if (r0 != 3000) goto L19;
        d.b.s.a.a0.a.a("TokenFactory", "handleMsg: MSG_ACCOUNT_INFO");
        Y();
        return;
    }

    public /* synthetic */ f0 k0(CountDownLatch r1, AtomicBoolean r2, com.bytedance.android.sdk.bdticketguard.m1.c r3) {
        return j0(r1, r2, r3);
    }

    public /* synthetic */ f0 m0(Boolean r1) {
        return l0(r1);
    }

    void p0(String r10, List<m> r11, long r12, long r14, long r16) {
        if (com.bytedance.sdk.account.settings.f.a.q() == true) goto L5;
        return;
    L5:
        String r1 = V(r10);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return;
    L8:
        if (com.bytedance.sdk.account.settings.f.a.z(r1) == false) goto L28;
        String r0 = "";
        if (r11 != null) goto L13;
    L20:
        com.bytedance.sdk.account.monitor.c.g(r1, r0, r12, r14, r16);
        return;
    L13:
        if (r11.isEmpty() == true) goto L20;
        Iterator<m> r2 = r11.iterator();
    L16:
        if (r2.hasNext() == false) goto L20;
        m r3 = r2.next();
        if (r3.a().equalsIgnoreCase("x-tt-logid") == false) goto L16;
        r0 = r3.b();
        goto L16
    }

    void t(Collection<String> r2) {
        if (this.n == null) goto L6;
        this.n.f(r2);
        return;
    }

    void t0(String r32, List<m> r33, long r34) {
        long r7 = System.currentTimeMillis();
        long r5 = SystemClock.elapsedRealtime();
        if (com.bytedance.sdk.account.ticketguard.f.w() == false) goto L13;
        if (r34 <= 0) goto L13;
        if (r7 >= r34) goto L9;
    L10:
        StringBuilder r0 = new StringBuilder();
        r0.append("[TokenTimeUtil] 请求到响应的时间大于 600000ms (");
        long r8 = r7 - r34;
        r0.append(r8);
        r0.append(" ms)，可能是设备休眠，不进行时间校准");
        d.b.s.a.a0.a.h("TokenFactory", r0.toString());
        d.b.s.a.i0.e.f14809b.f(r8, "TokenFactory");
        return;
    L9:
        if ((r7 - r34) > 600000) goto L10;
    L13:
        if (com.bytedance.sdk.account.ticketguard.f.s() == false) goto L142;
        String r15 = V(r32);
        String r13 = ", current=";
        boolean r11 = false;
        if (com.bytedance.sdk.account.ticketguard.f.m() == false) goto L70;
        if (this.K.compareAndSet(false, true) == false) goto L70;
        Iterator<m> r16 = r33.iterator();     // Catch: Throwable -> L64
        String r1 = "";
        long r18 = 0;
    L21:
        if (r16.hasNext() == false) goto L42;
        m r20 = r16.next();     // Catch: Throwable -> L64
    L62:
        th = th;
        boolean r9 = false;
    L66:
        this.K.set(r9);
        throw th;
    L24:
        if ("bd-ticket-guard-sec-ts".equalsIgnoreCase(r20.a()) == true) goto L26;
    L28:
        String r12 = r1;
        if ("bd-ticket-guard-ts".equalsIgnoreCase(r20.a()) == false) goto L37;
        if (TextUtils.isEmpty(r20.b()) == true) goto L37;
        r18 = Long.parseLong(r20.b()) * 1000;
        goto L37
    L34:
        e = move-exception;
        d.b.s.a.a0.a.c("TokenFactory", "[TokenTimeUtil] onNewResponseDate parse timestamp error", e);     // Catch: Throwable -> L62
    L37:
        if (TextUtils.isEmpty(r12) == true) goto L41;
        if (r18 <= 0) goto L41;
        r1 = r12;
    L41:
        r1 = r12;
        r11 = false;
        goto L21
    L26:
        if (TextUtils.isEmpty(r20.b()) == true) goto L28;
        r1 = r20.b();     // Catch: Throwable -> L62
    L42:
        long r14 = r18;
        if (TextUtils.isEmpty(r1) == false) goto L45;
    L60:
        long r17 = r5;
        r13 = ", current=";
        String r6 = r15;
        String r19 = ", elapsedRealTime=";
    L61:
        boolean r10 = false;
        this.K.set(false);
    L71:
        long r4 = this.L;
        if (r4 == 0) goto L81;
        if ((r7 - r4) > 600000) goto L81;
        if (r7 <= r4) goto L81;
        if (d.b.s.a.i0.d.h().k() == false) goto L81;
        return;
    L81:
        if ("/passport/token/beat/v2/".equals(r6) == false) goto L83;
    L86:
        boolean r2 = true;
    L87:
        if (r2 == true) goto L89;
        return;
    L89:
        if (this.K.compareAndSet(r10, true) == false) goto L144;
        d.b.s.a.a0.a.d("TokenFactory", "[TokenTimeUtil] onNewResponseDate url=" + r32 + ", requestTime=" + r34 + r13 + r7 + r19 + r17);
        if (r33 != null) goto L127;
    L118:
        boolean r110 = r10;
    L119:
        this.K.set(r110);
        this.L = r7;
        return;
    L127:
    L114:
        th = th;
        r110 = r10;
    L116:
        this.K.set(r110);
        this.L = r7;
        throw th;
    L93:
        if (r33.isEmpty() == true) goto L118;
        Iterator<m> r3 = r33.iterator();     // Catch: Throwable -> L114
        String r21 = null;
        String r22 = null;
    L96:
        if (r3.hasNext() == false) goto L107;
        m r23 = r3.next();     // Catch: Throwable -> L114
        if ("date".equalsIgnoreCase(r23.a()) == false) goto L103;
        if (TextUtils.isEmpty(r23.b()) == true) goto L103;
        r21 = r23.b();     // Catch: Throwable -> L114
    L103:
        if ("x-tt-logid".equalsIgnoreCase(r23.a()) == false) goto L96;
        if (TextUtils.isEmpty(r23.b()) == true) goto L96;
        r22 = r23.b();     // Catch: Throwable -> L114
        goto L96
    L107:
        if (TextUtils.isEmpty(r21) == true) goto L118;
        String r111 = r6;
        long r24 = r17;
        r110 = r10;
        Z(r32, r21, r7, r24, r111, r22);     // Catch: Throwable -> L112
    L112:
        th = th;
        goto L116
    L144:
        return;
    L83:
        if ("/passport/account/info/v2/".equals(r6) == true) goto L86;
        r2 = r10;
        goto L87
    L45:
        if (r14 <= 0) goto L60;
        r13 = ", current=";
        long r112 = com.ss.android.token.i.f12216c.e(this.o, r15, r1, r14, r5, r7);     // Catch: Throwable -> L62
        if (r112 >= 0) goto L49;
    L50:
        k1 r113 = x0.f1087b.a();     // Catch: Throwable -> L62
        if (r113 == null) goto L53;
        r113.l(r1, null);     // Catch: Throwable -> L62
        boolean r114 = true;
    L54:
        StringBuilder r115 = new StringBuilder();     // Catch: Throwable -> L62
        r115.append("[TokenTimeUtil] updateSecTime secTs=");     // Catch: Throwable -> L62
        r115.append(r1);     // Catch: Throwable -> L62
        r115.append(", timestamp=");     // Catch: Throwable -> L62
        r115.append(r14);     // Catch: Throwable -> L62
        r115.append(r13);     // Catch: Throwable -> L62
        r115.append(r7);     // Catch: Throwable -> L62
        r19 = ", elapsedRealTime=";
        r115.append(r19);     // Catch: Throwable -> L62
        r115.append(r5);     // Catch: Throwable -> L62
        r115.append(", path=");     // Catch: Throwable -> L62
        r6 = r15;
        r115.append(r6);     // Catch: Throwable -> L62
        r115.append(", isUpdatedSign=");     // Catch: Throwable -> L62
        r115.append(r114);     // Catch: Throwable -> L62
        d.b.s.a.a0.a.a("TokenFactory", r115.toString());     // Catch: Throwable -> L62
        if (com.bytedance.sdk.account.ticketguard.f.o() == false) goto L59;
        d.b.s.a.i0.d.h().e(this.o, r14, r7, r5, true);     // Catch: Throwable -> L62
        this.L = r7;     // Catch: Throwable -> L62
        this.K.set(false);
        return;
    L59:
        r17 = r5;
    L53:
        r114 = false;
        goto L54
    L49:
        if (r112 < (com.bytedance.sdk.account.ticketguard.f.b() * 1000)) goto L53;
    L64:
        th = th;
        r9 = r11;
    L70:
        r10 = false;
        r17 = r5;
        r6 = r15;
        r19 = ", elapsedRealTime=";
        r7 = r7;
        goto L71
    }

    void u0(String r6, List<m> r7, boolean r8) {
        o.p(r6, r7, r8);
        if (R == true) goto L6;
        return;
    L6:
        if (this.u.a() != null) goto L8;
    L10:
        boolean r9 = false;
    L11:
        d.b.s.a.a0.a.d("TokenFactory", "onSessionDrop(), isLogin=" + r9 + ", url=" + r6 + ", beforeUserWasLogin=" + r8);
        if (r9 == false) goto L24;
        String r10 = this.f12267k.f12309a;
        G();
        o.c("session_drop", r10);
        if (com.bytedance.sdk.account.impl.p.b() == null) goto L18;
        com.bytedance.sdk.account.impl.q r11 = com.bytedance.sdk.account.impl.p.b().e();
        if (r11 == null) goto L18;
    L20:
        if (this.u.a() == null) goto L22;
        Long r2 = Long.valueOf(this.u.a().getUserId());
        this.u.a().x(true);
        o.w(r2, 0L, o.b(r6), "session_drop");
    L22:
        com.ss.android.token.f r12 = new com.ss.android.token.f("frontier");
        r12.c(r11);
        D0("frontier", null, r12, null);
        return;
    L18:
        r11 = null;
        goto L20
    L24:
        return;
    L8:
        if (this.u.a().m() == false) goto L10;
        r9 = true;
        goto L11
    }

    void v0(String r3, List<m> r4, boolean r5, boolean r6, Object r7, d.b.s.a.q.j.a<d.b.s.a.q.j.d> r8) {
        o.p(r3, r4, r6);
        if (R == true) goto L6;
        return;
    L6:
        if (this.u.a() != null) goto L8;
    L10:
        boolean r9 = false;
    L11:
        d.b.s.a.a0.a.d("TokenFactory", "onSessionExpired(), isLogin=" + r9 + ", url=" + r3 + ", beforeUserWasLogin=" + r6 + ", notifyListeners=" + r5);
        if (r9 == false) goto L18;
        String r10 = this.f12267k.f12309a;
        G();
        o.c("session_expired", r10);
        if (this.u.a() == null) goto L16;
        Long r11 = Long.valueOf(this.u.a().getUserId());
        this.u.a().x(r5);
        o.w(r11, 0L, o.b(r3), "session_expired");
    L16:
        D0("sdk_expired_logout", r7, null, r8);
        return;
    L18:
        return;
    L8:
        if (this.u.a().m() == false) goto L10;
        r9 = true;
        goto L11
    }

    com.ss.android.token.h w(String r16, String r17, List<m> r18) {
        if (TextUtils.isEmpty(r16) == false) goto L5;
        return null;
    L5:
        String r2 = J(r16);
        if (f0(r16, r2) == true) goto L10;
        d.b.s.a.a0.a.a("TokenFactory", "not in domain list, host: " + r2 + " url: " + r16);
        o.i(r16, this.n.i());
        return null;
    L10:
        if (r16.startsWith("http://") == true) goto L12;
    L17:
        boolean r6 = false;
    L19:
        if (H0(r18) == false) goto L22;
        d.b.s.a.a0.a.a("TokenFactory", "should bypass token, url: " + r16);
        return null;
    L22:
        n0(true, "addRequestHeader");
        String r7 = V(r16);
        if (TextUtils.isEmpty(r7) == false) goto L25;
    L27:
        boolean r11 = false;
    L28:
        if (r11 == true) goto L30;
    L32:
        if (r11 == false) goto L34;
        d.b.s.a.a0.a.a("TokenFactory", "addRequestHeader for passport request. path: " + r7 + " url: " + r16);
    L34:
        HashMap r12 = new HashMap();
        t r5 = U();
        String r0 = r5.f12309a;
        if (TextUtils.isEmpty(r0) == true) goto L37;
        r12.put("X-Tt-Token", r0);
    L38:
        String r1 = N();
        if (TextUtils.isEmpty(r1) == true) goto L41;
        r12.put("x-tt-passport-mfa-token", r1);
    L41:
        r12.put("sdk-version", S());
        r12.put("passport-sdk-version", String.valueOf(601339));
        if (r11 == false) goto L44;
        c0(r12);
    L44:
        if (r11 == false) goto L49;
        String r3 = d.b.s.a.j0.a.a();
        if (TextUtils.isEmpty(r3) == true) goto L49;
        r12.put("x-tt-passport-trace-id", r3);
    L49:
        if ("/passport/token/beat/v2/".equals(r7) == true) goto L51;
    L55:
        com.ss.android.token.h r13 = new com.ss.android.token.h();
        r13.f12210a = r12;
        r13.f12213d = r6;
        StringBuilder r14 = new StringBuilder();
        x(r2, r7, r5, r11, r17, r13, r14);
        this.G.f(r12);
        if (com.bytedance.sdk.account.settings.f.a.k() == false) goto L59;
        r14.append("device_transfer,");
    L59:
        if (r14.length() <= 0) goto L61;
        r14.deleteCharAt(r14.length() - 1);
        r12.put("passport-sdk-settings", r14.toString());
    L61:
        x0(r16);
        if (this.x == true) goto L64;
    L65:
        if (r11 == false) goto L68;
        this.x = true;
    L71:
        return r13;
    L68:
        if (this.u.a().m() == true) goto L70;
        this.x = true;
    L70:
        this.y = true;
        goto L71
    L64:
        if (this.y == true) goto L71;
    L51:
        if (com.bytedance.sdk.account.settings.f.a.r() == false) goto L53;
    L54:
        r12.put("x-uc-sec-uid", com.ss.android.i.b.M().b());
        goto L55
    L53:
        if (com.bytedance.sdk.account.settings.f.a.s() == false) goto L55;
    L37:
        d.b.s.a.a0.a.d("TokenFactory", "addRequestHeader, token is empty. path: " + r7 + " url: " + r16);
        goto L38
    L30:
        if (r16.contains("is_from_ttaccountsdk=1") == true) goto L32;
        o.l(r7);
        goto L32
    L25:
        if (r7.startsWith("/passport/") == false) goto L27;
        r11 = true;
        goto L28
    L12:
        if (com.bytedance.sdk.account.settings.f.e.c() == false) goto L15;
        return null;
    L15:
        if (com.bytedance.sdk.account.settings.f.e.d() == false) goto L17;
        r6 = true;
        goto L19
    }
}
