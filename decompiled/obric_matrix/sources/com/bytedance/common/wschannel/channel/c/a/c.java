package com.bytedance.common.wschannel.channel.c.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.UiThread;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.o;
import com.squareup.wire.Wire;
import d.b.h.a.a.h.o.b.z.l;
import d.b.h.a.a.h.o.b.z.m;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p000j.a0;
import p000j.b0;
import p000j.d0;
import p000j.f0;
import p000j.i0;
import p000j.j0;
import p000j.w;

/* JADX INFO: loaded from: classes.dex */
class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f3382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f3383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.c.a.d f3384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a0 f3385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d0 f3387k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3388l;
    private Map<String, Object> m;
    private Handler n;
    private com.bytedance.common.wschannel.channel.c.a.g.c o;
    private k p;
    private com.bytedance.common.wschannel.channel.c.a.g.a q;
    private boolean r;
    private com.bytedance.common.wschannel.s.a s;
    private com.bytedance.common.wschannel.s.b t;

    class a implements com.bytedance.common.wschannel.s.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3389a;

        a(c r1) {
            this.f3389a = r1;
        }

        @Override // com.bytedance.common.wschannel.s.c
        public void a() {
            c.u(this.f3389a);
        }

        @Override // com.bytedance.common.wschannel.s.c
        public void b() {
            c.v(this.f3389a);
        }
    }

    class b implements com.bytedance.common.wschannel.s.b.InterfaceC0101b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3390a;

        b(c r1) {
            this.f3390a = r1;
        }

        @Override // com.bytedance.common.wschannel.s.b.InterfaceC0101b
        public void a() {
            c.u(this.f3390a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.c.a.c$c, reason: collision with other inner class name */
    class RunnableC0096c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f3391f;

        RunnableC0096c(c r1) {
            this.f3391f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.x(this.f3391f, true);
            c.y(this.f3391f);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f3392f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f3393g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f3394h;

        d(c r1, Map r2, List r3) {
            this.f3394h = r1;
            this.f3392f = r2;
            this.f3393g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r0 = this.f3394h.I();
            if (r0 != 4) goto L5;
        L11:
            Log.d("WsChannelSdk_ok", "cancel connect :,current state = " + r0);
            return;
        L5:
            if (r0 == 1) goto L11;
            if (r0 == 5) goto L11;
            this.f3394h.d0(this.f3392f);
            c r1 = this.f3394h;
            r1.handleMsg(c.a(r1).obtainMessage(2, this.f3393g));
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f3395f;

        e(c r1) {
            this.f3395f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3395f.g0();
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f3396f;

        f(c r1) {
            this.f3396f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
        L6:
            th = move-exception;
            com.bytedance.common.wschannel.s.f.a.d().b(th);     // Catch: Throwable -> L10
        L5:
            c.d(this.f3396f).c();
            return;
        L10:
            th = move-exception;
            c.d(this.f3396f).c();
            throw th;
        L3:
            if (c.b(this.f3396f) == null) goto L5;
            Logger.d("WsChannelSdk_ok", "send ping");     // Catch: Throwable -> L6
            c.b(this.f3396f).e();     // Catch: Throwable -> L6
            goto L5
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f3397f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f3398g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f3399h;

        g(c r1, Map r2, List r3) {
            this.f3399h = r1;
            this.f3397f = r2;
            this.f3398g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3399h.d0(this.f3397f);
            c r0 = this.f3399h;
            r0.handleMsg(c.a(r0).obtainMessage(7, this.f3398g));
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f3400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f3401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a0 f3402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.bytedance.common.wschannel.channel.c.a.f.b f3403d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.bytedance.common.wschannel.s.a f3404e;

        h(Context r1) {
            this.f3400a = r1;
        }

        public c a() {
            return new c(new i(this.f3400a, this.f3401b, this.f3402c, this.f3403d, this.f3404e), null);
        }

        h b(com.bytedance.common.wschannel.s.a r1) {
            if (r1 == null) goto L4;
            this.f3404e = r1;
        L4:
            return this;
        }

        h c(com.bytedance.common.wschannel.channel.c.a.f.b r1) {
            this.f3403d = r1;
            return this;
        }
    }

    static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f3405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f3406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a0 f3407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.bytedance.common.wschannel.channel.c.a.f.b f3408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.bytedance.common.wschannel.s.a f3409e;

        i(Context r1, List<String> r2, a0 r3, com.bytedance.common.wschannel.channel.c.a.f.b r4, com.bytedance.common.wschannel.s.a r5) {
            this.f3405a = r1;
            this.f3406b = r2;
            this.f3407c = r3;
            this.f3408d = r4;
            this.f3409e = r5;
        }

        static /* synthetic */ Context a(i r0) {
            return r0.f3405a;
        }

        static /* synthetic */ a0 b(i r0) {
            return r0.f3407c;
        }

        static /* synthetic */ com.bytedance.common.wschannel.s.a c(i r0) {
            return r0.f3409e;
        }

        static /* synthetic */ List d(i r0) {
            return r0.f3406b;
        }

        static /* synthetic */ List e(i r0, List r1) {
            r0.f3406b = r1;
            return r1;
        }

        static /* synthetic */ com.bytedance.common.wschannel.channel.c.a.f.b f(i r0) {
            return r0.f3408d;
        }

        public String toString() {
            return "Config{mHeartBeatPolicy=" + this.f3409e + ", mContext=" + this.f3405a + ", wsUrls=" + this.f3406b + ", mOkHttpClient=" + this.f3407c + ", mRetryPolicy=" + this.f3408d + '}';
        }
    }

    private class j extends com.bytedance.common.wschannel.channel.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3410a;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.bytedance.common.wschannel.channel.c.a.g.b f3411f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ f0 f3412g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ j f3413h;

            a(j r1, com.bytedance.common.wschannel.channel.c.a.g.b r2, f0 r3) {
                this.f3413h = r1;
                this.f3411f = r2;
                this.f3412g = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onOpen--------");
                if (c.b(this.f3413h.f3410a) != this.f3411f) goto L8;
                c.e(this.f3413h.f3410a, 4);
                c.f(this.f3413h.f3410a);
                c.d(this.f3413h.f3410a).a(this.f3412g);
                if (c.g(this.f3413h.f3410a) == null) goto L9;
                c.g(this.f3413h.f3410a).c(this.f3412g);
                return;
            L9:
                return;
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ k.h f3414f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ j f3415g;

            b(j r1, k.h r2) {
                this.f3415g = r1;
                this.f3414f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onMessage--------");
                c.i(this.f3415g.f3410a, this.f3414f.E());     // Catch: Throwable -> L5
            L8:
                if (c.g(this.f3415g.f3410a) == null) goto L13;
                c.g(this.f3415g.f3410a).e(this.f3414f);
                return;
            L13:
                return;
            L5:
                th = move-exception;
                th.printStackTrace();
                goto L8
            }
        }

        /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.c.a.c$j$c, reason: collision with other inner class name */
        class RunnableC0097c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f3416f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ j f3417g;

            RunnableC0097c(j r1, String r2) {
                this.f3417g = r1;
                this.f3416f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onMessage--------");
                if (c.g(this.f3417g.f3410a) == null) goto L6;
                c.g(this.f3417g.f3410a).f(this.f3416f);
                return;
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ j f3418f;

            d(j r1) {
                this.f3418f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onClosing--------");
                c.e(this.f3418f.f3410a, 6);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.bytedance.common.wschannel.channel.c.a.g.b f3419f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f3420g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f3421h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f3422i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ j f3423j;

            e(j r1, com.bytedance.common.wschannel.channel.c.a.g.b r2, String r3, int r4, String r5) {
                this.f3423j = r1;
                this.f3419f = r2;
                this.f3420g = r3;
                this.f3421h = r4;
                this.f3422i = r5;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onClosed--------");
                if (c.b(this.f3423j.f3410a) != this.f3419f) goto L15;
                c.e(this.f3423j.f3410a, 3);
                c.c(this.f3423j.f3410a, null);
                c.d(this.f3423j.f3410a).d();
                if (c.g(this.f3423j.f3410a) == null) goto L8;
                c.g(this.f3423j.f3410a).b(this.f3420g, this.f3421h, this.f3422i);
            L8:
                if (c.k(this.f3423j.f3410a) == false) goto L12;
                c.l(this.f3423j.f3410a, false);
                c r5 = this.f3423j.f3410a;
                c.n(r5, c.m(r5).c());
                return;
            L12:
                if (c.w(this.f3423j.f3410a) == true) goto L16;
                Pair<String, Long> r0 = c.m(this.f3423j.f3410a).b(null);
                c.o(this.f3423j.f3410a, ((Long) r0.second).longValue(), (String) r0.first, true);
                return;
            L16:
                return;
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f3424f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f3425g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f3426h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ com.bytedance.common.wschannel.channel.c.a.g.b f3427i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ Pair f3428j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ j f3429k;

            f(j r1, String r2, int r3, String r4, com.bytedance.common.wschannel.channel.c.a.g.b r5, Pair r6) {
                this.f3429k = r1;
                this.f3424f = r2;
                this.f3425g = r3;
                this.f3426h = r4;
                this.f3427i = r5;
                this.f3428j = r6;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onFailure--------");
                if (c.g(this.f3429k.f3410a) == null) goto L6;
                c.g(this.f3429k.f3410a).d(this.f3424f, this.f3425g, this.f3426h);
            L6:
                if (c.k(this.f3429k.f3410a) == false) goto L10;
                c.l(this.f3429k.f3410a, false);
                c r5 = this.f3429k.f3410a;
                c.n(r5, c.m(r5).c());
                return;
            L10:
                if (c.b(this.f3429k.f3410a) == this.f3427i) goto L14;
                Logger.d("WsChannelSdk_ok", "socket is expired");
                return;
            L14:
                if (j.h(this.f3429k, this.f3425g) == false) goto L16;
                c.d(this.f3429k.f3410a).d();
                c.o(this.f3429k.f3410a, ((Long) this.f3428j.second).longValue(), (String) this.f3428j.first, false);
                return;
            L16:
                c.e(this.f3429k.f3410a, 2);
                c.s(this.f3429k.f3410a);
            }
        }

        class g implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.bytedance.common.wschannel.channel.c.a.g.b f3430f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ j f3431g;

            g(j r1, com.bytedance.common.wschannel.channel.c.a.g.b r2) {
                this.f3431g = r1;
                this.f3430f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f3430f == c.b(this.f3431g.f3410a)) goto L5;
                return;
            L5:
                boolean r0 = c.t(this.f3431g.f3410a).d();
                c r2 = this.f3431g.f3410a;
                if (r0 == false) goto L9;
                c.t(r2).e();
                return;
            L9:
                c.d(r2).e();
            }
        }

        private j(c r1) {
            this.f3410a = r1;
        }

        /* synthetic */ j(c r1, a r2) {
            this(r1);
        }

        static /* synthetic */ boolean h(j r0, int r1) {
            return r0.i(r1);
        }

        private boolean i(int r1) {
            if (r1 > 0) goto L4;
        L13:
            return true;
        L4:
            if (r1 == 414) goto L13;
            if (r1 == 511) goto L13;
            if (r1 == 512) goto L13;
            if (r1 == 513) goto L13;
            return false;
        }

        @Override // com.bytedance.common.wschannel.channel.c.a.g.c
        public void a(com.bytedance.common.wschannel.channel.c.a.g.b r9, int r10, String r11) {
            String r4 = c.j(this.f3410a, r9);
            c.h(this.f3410a, new e(this, r9, r4, r10, r11));
        }

        @Override // com.bytedance.common.wschannel.channel.c.a.g.c
        public void b(com.bytedance.common.wschannel.channel.c.a.g.b r1, int r2, String r3) {
            super.b(r1, r2, r3);
            c.h(this.f3410a, new d(this));
        }

        @Override // com.bytedance.common.wschannel.channel.c.a.g.c
        public void c(com.bytedance.common.wschannel.channel.c.a.g.b r9, Throwable r10, f0 r11) {
            String r3 = c.j(this.f3410a, r9);
            int r4 = c.p(this.f3410a, r11);
            String r0 = c.q(this.f3410a, r4);
            if (com.bytedance.common.utility.k.c(r0) == true) goto L5;
            String r5 = r0;
        L10:
            Pair<String, Long> r7 = c.m(this.f3410a).b(r11);
            c.r(this.f3410a, r11);
            c.h(this.f3410a, new f(this, r3, r4, r5, r9, r7));
            return;
        L5:
            if (com.bytedance.common.utility.k.c(r10.getMessage()) == false) goto L7;
            String r12 = Log.getStackTraceString(r10);
        L8:
            r5 = r12;
            goto L10
        L7:
            r12 = r10.getMessage();
            goto L8
        }

        @Override // com.bytedance.common.wschannel.channel.c.a.g.c
        public void d(com.bytedance.common.wschannel.channel.c.a.g.b r2, String r3) {
            c.h(this.f3410a, new RunnableC0097c(this, r3));
        }

        @Override // com.bytedance.common.wschannel.channel.c.a.g.c
        public void e(com.bytedance.common.wschannel.channel.c.a.g.b r2, k.h r3) {
            c.h(this.f3410a, new b(this, r3));
        }

        @Override // com.bytedance.common.wschannel.channel.c.a.g.c
        public void f(com.bytedance.common.wschannel.channel.c.a.g.b r2, f0 r3) {
            a r0 = new a(this, r2, r3);
            c.h(this.f3410a, r0);
        }

        @Override // com.bytedance.common.wschannel.channel.c.a.g.c
        public void g(com.bytedance.common.wschannel.channel.c.a.g.b r2, k.h r3) {
            c.h(this.f3410a, new g(this, r2));
        }
    }

    interface k {
        void a(String r1);

        void b(String r1, int r2, String r3);

        void c(f0 r1);

        void d(String r1, int r2, String r3);

        void e(k.h r1);

        void f(String r1);
    }

    private c(i r3) {
        this.f3386j = 3;
        this.m = new ConcurrentHashMap();
        this.n = new WeakHandler(Looper.myLooper(), this);
        this.o = new j(this, null);
        this.f3383g = r3;
        this.f3382f = i.a(r3);
        this.f3385i = i.b(r3);
        com.bytedance.common.wschannel.s.a r4 = i.c(r3);
        this.s = r4;
        if (r4 != null) goto L5;
        this.s = new com.bytedance.common.wschannel.s.g.b(new com.bytedance.common.wschannel.s.g.a().c());
    L5:
        this.s.f(new a(this), this.n);
        this.t = new com.bytedance.common.wschannel.s.b(new b(this), this.n);
    }

    /* synthetic */ c(i r1, a r2) {
        this(r1);
    }

    private String B(String r9, Map<String, Object> r10) {
        if (TextUtils.isEmpty(r9) == true) goto L44;
        if (r10 == null) goto L44;
        String r0 = com.bytedance.common.wschannel.u.c.o(String.valueOf(r10.get(WsConstants.KEY_FPID)) + String.valueOf(r10.get(WsConstants.KEY_APP_KEY)) + String.valueOf(r10.get(WsConstants.KEY_DEVICE_ID)) + WsConstants.SALT).toLowerCase();
        Uri.Builder r11 = Uri.parse(r9).buildUpon();
        Iterator<Map.Entry<String, Object>> r3 = r10.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L29;
        Map.Entry<String, Object> r4 = r3.next();
        if (r4 == null) goto L8;
        if (TextUtils.isEmpty(r4.getKey()) == true) goto L8;
        if (TextUtils.equals(r4.getKey(), WsConstants.KEY_HEADERS) == true) goto L8;
        if (r4.getValue() != null) goto L20;
        String r6 = "";
    L21:
        String r5 = r4.getKey();
        if (com.bytedance.common.utility.k.b(WsConstants.KEY_APP_KEY, r5) == true) goto L8;
        if (com.bytedance.common.utility.k.b(r5, WsConstants.KEY_EXTRA) == true) goto L8;
        if (com.bytedance.common.utility.k.b(WsConstants.KEY_APP_VERSION, r5) == false) goto L28;
        r5 = "version_code";
    L28:
        r11.appendQueryParameter(r5, r6);
        goto L8
    L20:
        r6 = r4.getValue().toString();
        goto L21
    L29:
        String r12 = (String) r10.get(WsConstants.KEY_EXTRA);
        if (com.bytedance.common.utility.k.c(r12) == true) goto L39;
        String[] r13 = r12.split("&");
        int r1 = r13.length;
        int r7 = 0;
    L32:
        if (r7 >= r1) goto L39;
        String r8 = r13[r7];
        if (TextUtils.isEmpty(r8) == true) goto L38;
        String[] r14 = r8.split("=");
        if (r14.length != 2) goto L38;
        r11.appendQueryParameter(r14[0], Uri.decode(r14[1]));
    L38:
        r7 = r7 + 1;
    L39:
        r11.appendQueryParameter("access_key", r0);
        r11.appendQueryParameter("ne", String.valueOf(O()));
        String r15 = r11.build().toString();
        Logger.d("WsChannelSdk_ok", "origin url: " + r15);
        String r16 = E(r15);     // Catch: Exception -> L42
        Logger.d("WsChannelSdk_ok", "Dispatch final url: " + r16);     // Catch: Exception -> L42
        return r16;
    L42:
        e = move-exception;
        throw e;
    L44:
        return "";
    }

    private boolean D() {
        int r0 = I();
        if (r0 != 3) goto L5;
        return true;
    L5:
        if (r0 != 2) goto L7;
        return true;
    L7:
        if (r0 == 5) goto L23;
        this.s.d();
        com.bytedance.common.wschannel.channel.c.a.g.a r3 = this.q;
        if (r3 == null) goto L22;
        Message r4 = this.n.obtainMessage(6, r3);
        this.n.sendMessageDelayed(r4, 1000);
        if (r0 != 4) goto L15;
        this.q.k(1000, "normal close");
        e0(6);
        return false;
    L15:
        this.q.i();
        e0(3);
        if (r0 == 1) goto L19;
        return true;
    L19:
        return false;
    L22:
        return true;
    L23:
        return true;
    }

    private String E(String r2) {
        if (l.m().n() == true) goto L19;
        m r1 = new m(r2, "GET");
        d.b.h.a.a.h.o.b.z.e r3 = l.m().e(r1);
        if (r3 != null) goto L7;
    L24:
        return r2;
    L7:
        if (r2.equals(r3.f13664a) == true) goto L24;
        if (r3.f13664a.isEmpty() == false) goto L16;
        if (r3.f13665b.isEmpty() == true) goto L16;
        throw new Exception(WsConstants.TTNET_TRAFFIC_CONTROL_DROP);
    L16:
        if (d.b.h.a.a.h.s.l.f(r3.f13664a) == false) goto L24;
        return r3.f13664a;
    L19:
        Logger.d("WsChannelSdk_ok", "fallback to host replace map");
        String r4 = l.m().l(r2);
        if (r2.equals(r4) == true) goto L24;
        if (d.b.h.a.a.h.s.l.f(r4) == false) goto L24;
        return r4;
    }

    private static a0.b F(a0.b r5) {
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 16) goto L5;
    L15:
        return r5;
    L5:
        if (r1 >= 22) goto L15;
        SSLContext r2 = SSLContext.getInstance("TLSv1.2");     // Catch: Exception -> L13
        r2.init(null, null, null);     // Catch: Exception -> L13
        G(r5, r2);     // Catch: Exception -> L9
    L11:
        j.l.a r3 = new j.l.a(p000j.l.f18124i);     // Catch: Exception -> L13
        r3.f(new i0[]{i0.f17776h});     // Catch: Exception -> L13
        p000j.l r4 = r3.a();     // Catch: Exception -> L13
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L13
        r6.add(r4);     // Catch: Exception -> L13
        r6.add(p000j.l.f18125j);     // Catch: Exception -> L13
        r6.add(p000j.l.f18126k);     // Catch: Exception -> L13
        r5.f(r6);     // Catch: Exception -> L13
        goto L15
    L9:
        e = move-exception;
        Log.e("WsChannelSdk_ok", "Error while setting TLS 1.2 with two parameter func", e);     // Catch: Exception -> L13
        r5.p(new com.bytedance.common.wschannel.channel.c.a.b(r2.getSocketFactory()));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("WsChannelSdk_ok", "Error while setting TLS 1.2", e);
        goto L15
    }

    private static a0.b G(a0.b r3, SSLContext r4) {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r0.init(null);
        TrustManager[] r1 = r0.getTrustManagers();
        if (r1.length != 1) goto L9;
        if ((r1[0] instanceof X509TrustManager) == false) goto L9;
        r3.q(new com.bytedance.common.wschannel.channel.c.a.b(r4.getSocketFactory()), (X509TrustManager) r1[0]);
        return r3;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));
    }

    private void H() {
        com.bytedance.common.wschannel.channel.c.a.g.a r2 = this.q;
        if (r2 == null) goto L6;
        r2.m(1000, "normal close");
        return;
    }

    private int J(f0 r1) {
        if (r1 != null) goto L9;
        return -1;
    L9:
        return Integer.parseInt(r1.A("Handshake-Status"));
    L11:
        return -1;
    }

    private String K(int r1) {
        if (r1 != 0) goto L5;
        return "success";
    L5:
        if (r1 != 404) goto L8;
        return "uri not found";
    L8:
        if (r1 != 409) goto L11;
        return "fpid not registered";
    L11:
        if (r1 != 410) goto L14;
        return "invalid device id";
    L14:
        if (r1 != 411) goto L17;
        return "appid not registered";
    L17:
        if (r1 != 412) goto L20;
        return "websocket protocol not support";
    L20:
        if (r1 != 413) goto L23;
        return "the device already connected";
    L23:
        if (r1 != 414) goto L26;
        return "server can't accept more connection,try again later";
    L26:
        if (r1 != 415) goto L29;
        return "device was blocked";
    L29:
        if (r1 != 416) goto L32;
        return "parameter error";
    L32:
        if (r1 != 417) goto L35;
        return "authentication failed";
    L35:
        if (r1 != 510) goto L38;
        return "server internal error";
    L38:
        if (r1 != 511) goto L41;
        return "server is busy，try again later";
    L41:
        if (r1 != 512) goto L44;
        return "server is shutting down";
    L44:
        if (r1 != 513) goto L47;
        return "auth server is error";
    L47:
        if (r1 != 514) goto L49;
        return "auth return error";
    L49:
        return "";
    }

    private void L(String r5) {
        if (this.f3385i != null) goto L5;
        a0.b r0 = new a0.b();
        r0.k(Collections.singletonList(b0.f17673h));
        F(r0);
        this.f3385i = r0.c();
    L5:
        Map<String, Object> r1 = this.m;
        String r6 = B(r5, r1);
        if (r1 == null) goto L8;
        Map r2 = (Map) r1.get(WsConstants.KEY_HEADERS);
    L10:
        if (com.bytedance.common.utility.k.c(r6) == false) goto L13;
        Logger.e("WsChannelSdk_ok", "url is empty,cancel connect");
        return;
    L13:
        H();
        Logger.d("WsChannelSdk_ok", "try tu open socket:" + r6);
        d0 r3 = this.f3387k;
        if (r3 != null) goto L16;
    L17:
        d0.a r4 = new d0.a();
        r4.a("Sec-Websocket-Protocol", "pbbp");
        r4.a("x-support-ack", LocationInfoConst.ALLOW_USE_LOCATION);
        r4.k(r6);
        if (r2 == null) goto L23;
        Iterator r7 = r2.entrySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L23;
        Map.Entry r8 = (Map.Entry) r7.next();
        r4.a((String) r8.getKey(), (String) r8.getValue());
    L23:
        this.f3387k = r4.b();
    L24:
        e0(1);
        com.bytedance.common.wschannel.channel.c.a.g.a r9 = com.bytedance.common.wschannel.channel.c.a.g.a.o(this.f3387k, o.f(this.f3382f).d(), this.o);
        this.q = r9;
        r9.n(this.f3385i);
        this.t.f(this.q);
        k r10 = this.p;
        if (r10 == null) goto L29;
        r10.a(r6);
        return;
    L29:
        return;
    L16:
        if (r6.equals(r3.k().toString()) == true) goto L24;
    L8:
        r2 = null;
        goto L10
    }

    @SuppressLint({"MissingPermission"})
    private boolean N(Context r1) {
        return com.bytedance.common.wschannel.server.j.c(r1);
    }

    private int O() {
        com.bytedance.common.wschannel.server.j.a r2 = com.bytedance.common.wschannel.server.j.b(this.f3382f);
        if (r2 != null) goto L6;
        return 0;
    L6:
        if (r2 != com.bytedance.common.wschannel.server.j.a.f3775f) goto L9;
        return 0;
    L9:
        if (r2 != com.bytedance.common.wschannel.server.j.a.f3779j) goto L13;
        return 1;
    L13:
        if (r2 != com.bytedance.common.wschannel.server.j.a.f3777h) goto L17;
        return 2;
    L17:
        if (r2 != com.bytedance.common.wschannel.server.j.a.f3778i) goto L20;
        return 3;
    L20:
        return 4;
    }

    private void P(String r2, int r3, String r4, boolean r5) {
        e0(2);
        V();
        k r1 = this.p;
        if (r1 == null) goto L7;
        if (r5 == false) goto L8;
        r1.d(r2, r3, r4);
        return;
    L8:
        return;
    }

    private void T() {
        d0 r0 = this.f3387k;
        if (r0 == null) goto L7;
        k r1 = this.p;
        if (r1 == null) goto L7;
        r1.d(r0.k().toString(), 3, "heatbeat timeout");
    L7:
        Pair<String, Long> r2 = this.f3384h.b(null);
        h0();
        H();
        j0(0, (String) r2.first, true);
    }

    private void U() {
        this.n.post(new f(this));
    }

    private void V() {
        com.bytedance.common.wschannel.channel.c.a.d r0 = this.f3384h;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    private void W(Runnable r1) {
        this.n.post(r1);
    }

    private void X(Closeable r1) {
        if (r1 == null) goto L8;
        r1.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    private String Y(j0 r1) {
        if (r1 == null) goto L9;
        d0 r0 = r1.b();
        if (r0 == null) goto L11;
        w r2 = r0.k();
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2.toString();
    L11:
        return "";
    L9:
        return "";
    }

    private boolean Z(Object r3) {
        Logger.d("WsChannelSdk_ok", "send msg : " + r3);
        if (this.q != null) goto L5;
    L12:
        return false;
    L5:
        if (M() == false) goto L12;
        if ((r3 instanceof String) == false) goto L10;
        return this.q.t((String) r3);
    L10:
        if ((r3 instanceof k.h) == false) goto L12;
        return this.q.u((k.h) r3);
    }

    static /* synthetic */ Handler a(c r0) {
        return r0.n;
    }

    private boolean a0(k.h r1) {
        return Z(r1);
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.c.a.g.a b(c r0) {
        return r0.q;
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.c.a.g.a c(c r0, com.bytedance.common.wschannel.channel.c.a.g.a r1) {
        r0.q = r1;
        return r1;
    }

    private void c0(byte[] r9) {
        Logger.d("WsChannelSdk_ok", "enter sendMessageAckIfNeeded");
        Frame r10 = Frame.ADAPTER.decode(r9);
        List r0 = (List) Wire.get(r10.headers, Collections.emptyList());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L41;
        boolean r1 = false;
        String r2 = null;
        Iterator r3 = r0.iterator();
    L9:
        if (r3.hasNext() == false) goto L23;
        Frame.b r4 = (Frame.b) r3.next();
        if (r4.f3567f.equals(WsConstants.KEY_NEED_ACK) == false) goto L16;
        if (r4.f3568g.equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L16;
        r1 = true;
    L16:
        if (r4.f3567f.equals(WsConstants.KEY_FRONTIER_MSGID) == true) goto L18;
    L20:
        if (r1 == false) goto L9;
        if (TextUtils.isEmpty(r2) == true) goto L9;
    L18:
        if (TextUtils.isEmpty(r4.f3568g) == true) goto L20;
        r2 = r4.f3568g;
    L23:
        if (r1 == true) goto L25;
        return;
    L25:
        ArrayList r5 = new ArrayList();
        Frame.b.a r6 = new Frame.b.a();
        r6.b(WsConstants.KEY_IS_ACK);
        r6.c(LocationInfoConst.ALLOW_USE_LOCATION);
        r5.add(r6.a());
        Frame.b.a r7 = new Frame.b.a();
        r7.b(WsConstants.KEY_ACK_ID);
        r7.c((String) Wire.get(r10.logidnew, ""));
        r5.add(r7.a());
        Frame.b.a r8 = new Frame.b.a();
        r8.b(WsConstants.KEY_ACK_CODE);
        r8.c(BDLocationException.ERROR_TIMEOUT);
        r5.add(r8.a());
        if (TextUtils.isEmpty(r2) == true) goto L28;
        Frame.b.a r11 = new Frame.b.a();
        r11.b(WsConstants.KEY_FRONTIER_MSGID);
        r11.c(r2);
        r5.add(r11.a());
    L28:
        Frame.a r12 = new Frame.a();
        r12.j((Long) Wire.get(r10.seqid, Frame.DEFAULT_SEQID));
        r12.c((Long) Wire.get(r10.logid, Frame.DEFAULT_LOGID));
        r12.l((Integer) Wire.get(r10.service, Frame.DEFAULT_SERVICE));
        r12.e((Integer) Wire.get(r10.method, Frame.DEFAULT_METHOD));
        r12.d((String) Wire.get(r10.logidnew, ""));
        r12.b(r5);
        b0(Frame.ADAPTER.encode(r12.a()));
        return;
    }

    static /* synthetic */ com.bytedance.common.wschannel.s.a d(c r0) {
        return r0.s;
    }

    static /* synthetic */ void e(c r0, int r1) {
        r0.e0(r1);
    }

    private synchronized void e0(int r4) {
        monitor-enter(this);
        this.f3386j = r4;     // Catch: Throwable -> L24
        String r0 = "";
        if (r4 != 1) goto L7;
        r0 = "connecting";
    L21:
        Logger.d("WsChannelSdk_ok", "current status is :" + r0);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L7:
        if (r4 != 2) goto L10;
        r0 = "connect failed";
        goto L21
    L10:
        if (r4 != 3) goto L13;
        r0 = "connection close ";
        goto L21
    L13:
        if (r4 != 4) goto L16;
        r0 = "connected";
        goto L21
    L16:
        if (r4 != 5) goto L19;
        r0 = "retry...";
        goto L21
    L19:
        if (r4 != 6) goto L21;
        r0 = "half-close status";
    L24:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void f(c r0) {
        r0.z();
    }

    static /* synthetic */ k g(c r0) {
        return r0.p;
    }

    static /* synthetic */ void h(c r0, Runnable r1) {
        r0.W(r1);
    }

    private void h0() {
        this.n.removeMessages(2);
        this.n.removeMessages(1);
        this.n.removeMessages(3);
        this.n.removeMessages(5);
        z();
        D();
    }

    static /* synthetic */ void i(c r0, byte[] r1) {
        r0.c0(r1);
    }

    @UiThread
    private void i0(String r6) {
        if (N(this.f3382f) == true) goto L6;
        P(r6, 1, "network error", true);
        return;
    L6:
        int r0 = I();
        if (r0 == 4) goto L24;
        if (r0 == 1) goto L25;
        L(r6);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        if (this.p == null) goto L16;
        this.p.d(r6, 4, Log.getStackTraceString(th));
    L16:
        if (WsConstants.TTNET_TRAFFIC_CONTROL_DROP.equals(th.getMessage()) == false) goto L26;
        String r2 = this.f3384h.a();
        if (TextUtils.isEmpty(r2) == true) goto L20;
        Logger.d("WsChannelSdk_ok", th.getMessage() + ":" + r6 + ", try next url:" + r2);
        j0(0, r2, true);
        return;
    L20:
        Logger.d("WsChannelSdk_ok", "All urls are dropped, stop retry.");
        this.f3384h.d();
        return;
    L26:
        return;
    L25:
        return;
    }

    static /* synthetic */ String j(c r0, j0 r1) {
        return r0.Y(r1);
    }

    @UiThread
    private void j0(long r6, String r8, boolean r9) {
        this.n.removeMessages(1);
        if (N(this.f3382f) == true) goto L7;
        P(r8, 1, "network error", r9);
        Logger.d("WsChannelSdk_ok", "network not available，cancel retry");
        return;
    L7:
        if (this.f3388l == false) goto L11;
        Logger.d("WsChannelSdk_ok", "close manually");
        return;
    L11:
        if (r6 != (-1)) goto L13;
    L16:
        Logger.d("WsChannelSdk_ok", "retry finished ---> interval: " + r6 + " , url :" + r8);
        Logger.d("WsChannelSdk_ok", "retry finished，waiting the next time to reconnect");
        Bundle r0 = new Bundle();
        r0.putString("method", "tryReconnect");
        r0.putLong("interval", r6);
        P(r8, 2, "retry failed", r9);
        r8 = this.f3384h.c();
    L17:
        Logger.d("WsChannelSdk_ok", "the next time to reconnect is " + com.bytedance.common.wschannel.u.c.h(System.currentTimeMillis() + r6));
        Message r10 = new Message();
        r10.what = 1;
        r10.obj = r8;
        this.n.sendMessageDelayed(r10, r6);
        return;
    L13:
        if (com.bytedance.common.utility.k.c(r8) == true) goto L16;
        e0(5);
        goto L17
    }

    static /* synthetic */ boolean k(c r0) {
        return r0.r;
    }

    static /* synthetic */ boolean l(c r0, boolean r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.c.a.d m(c r0) {
        return r0.f3384h;
    }

    static /* synthetic */ void n(c r0, String r1) {
        r0.i0(r1);
    }

    static /* synthetic */ void o(c r0, long r1, String r3, boolean r4) {
        r0.j0(r1, r3, r4);
    }

    static /* synthetic */ int p(c r0, f0 r1) {
        return r0.J(r1);
    }

    static /* synthetic */ String q(c r0, int r1) {
        return r0.K(r1);
    }

    static /* synthetic */ void r(c r0, Closeable r1) {
        r0.X(r1);
    }

    static /* synthetic */ void s(c r0) {
        r0.V();
    }

    static /* synthetic */ com.bytedance.common.wschannel.s.b t(c r0) {
        return r0.t;
    }

    static /* synthetic */ void u(c r0) {
        r0.T();
    }

    static /* synthetic */ void v(c r0) {
        r0.U();
    }

    static /* synthetic */ boolean w(c r0) {
        return r0.f3388l;
    }

    static /* synthetic */ boolean x(c r0, boolean r1) {
        r0.f3388l = r1;
        return r1;
    }

    static /* synthetic */ void y(c r0) {
        r0.h0();
    }

    private void z() {
        V();
        this.n.removeMessages(1);
    }

    void A(Map<String, Object> r2, List<String> r3) {
        if (r3.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        W(new d(this, r2, r3));
    }

    void C() {
        this.n.removeMessages(2);
        this.n.removeMessages(1);
        this.n.removeMessages(3);
        this.n.removeMessages(5);
        W(new e(this));
    }

    synchronized int I() {
        monitor-enter(this);
        int r0 = this.f3386j;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    boolean M() {
        if (I() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    void Q(boolean r2) {
        this.n.obtainMessage(5, Boolean.valueOf(r2)).sendToTarget();
    }

    void R(int r2) {
        this.n.obtainMessage(3, Integer.valueOf(r2)).sendToTarget();
    }

    void S(Map<String, Object> r2, List<String> r3) {
        if (r3.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        W(new g(this, r2, r3));
    }

    boolean b0(byte[] r1) {
        return a0(k.h.u(r1));
    }

    void d0(Map<String, Object> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.remove(WsConstants.KEY_CHANNEL_ID);
        this.m.putAll(r2);
    }

    void f0(k r1) {
        this.p = r1;
    }

    void g0() {
        W(new RunnableC0096c(this));
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = r6.what;
        if (r0 != 1) goto L47;
        if (M() == false) goto L9;
        return;
    L9:
        this.n.removeMessages(1);
        this.n.removeMessages(2);
        String r7 = (String) r6.obj;
    L10:
        i0(r7);
        return;
    L47:
        if (r0 != 2) goto L18;
        this.n.removeMessages(2);     // Catch: Throwable -> L15
        this.n.removeMessages(1);     // Catch: Throwable -> L15
        i.e(this.f3383g, (List) r6.obj);     // Catch: Throwable -> L15
        this.f3388l = false;     // Catch: Throwable -> L15
        this.f3384h = new com.bytedance.common.wschannel.channel.c.a.d(i.d(this.f3383g), i.f(this.f3383g));     // Catch: Throwable -> L15
        z();     // Catch: Throwable -> L15
        i0(this.f3384h.c());     // Catch: Throwable -> L15
    L46:
        return;
    L18:
        if (r0 != 3) goto L33;
        this.n.removeMessages(2);
        this.n.removeMessages(1);
        if (M() == false) goto L22;
        return;
    L22:
        z();
        if (N(this.f3382f) == true) goto L25;
        Logger.d("WsChannelSdk_ok", "network changed! but the network is not available，do not retry");
        return;
    L25:
        if (D() == false) goto L30;
        com.bytedance.common.wschannel.channel.c.a.d r8 = this.f3384h;
        if (r8 != null) goto L29;
        return;
    L29:
        r7 = r8.c();
        goto L10
    L30:
        this.r = true;
        return;
    L33:
        if (r0 != 5) goto L40;
        if (((Boolean) r6.obj).booleanValue() == false) goto L37;
        com.bytedance.common.wschannel.s.e.a r9 = com.bytedance.common.wschannel.s.e.a.f3689f;
    L38:
        this.t.g(r9);
        this.s.b(r9);
        return;
    L37:
        r9 = com.bytedance.common.wschannel.s.e.a.f3690g;
        goto L38
    L40:
        if (r0 != 7) goto L54;
        this.n.removeMessages(2);     // Catch: Throwable -> L15
        this.n.removeMessages(1);     // Catch: Throwable -> L15
        i.e(this.f3383g, (List) r6.obj);     // Catch: Throwable -> L15
        this.f3388l = false;     // Catch: Throwable -> L15
        this.f3384h = new com.bytedance.common.wschannel.channel.c.a.d(i.d(this.f3383g), i.f(this.f3383g));     // Catch: Throwable -> L15
        z();     // Catch: Throwable -> L15
        if (D() == false) goto L44;
        i0(this.f3384h.c());     // Catch: Throwable -> L15
        goto L46
    L44:
        this.r = true;     // Catch: Throwable -> L15
        goto L46
    L54:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
    }
}
