package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import d.b.s.a.q.j.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<T>] */
/* JADX INFO: loaded from: classes.dex */
class i<T extends d.b.s.a.q.j.b> implements WeakHandler.IHandler, d.b.s.a.q.f {
    static final com.ss.android.i.l.a n0 = null;
    static final com.ss.android.i.l.a o0 = null;
    static final com.ss.android.i.l.a p0 = null;
    static final com.ss.android.i.l.a q0 = null;
    static final com.ss.android.i.l.a r0 = null;
    static final com.ss.android.i.l.a s0 = null;
    static final com.ss.android.i.l.a t0 = null;
    static final com.ss.android.i.l.a u0 = null;
    static final com.ss.android.i.l.a v0 = null;
    static final com.ss.android.i.l.a w0 = null;
    public static com.ss.android.i.l.a[] x0;
    private static volatile i y0;
    private static final List<f1> z0 = null;
    private final d.b.s.a.l0.j<Integer> A;
    private final d.b.s.a.l0.j<Integer> B;
    private final d.b.s.a.l0.j<Integer> C;
    private final d.b.s.a.l0.j<String> D;
    private final d.b.s.a.l0.j<String> E;
    private final d.b.s.a.l0.j<String> F;
    private final d.b.s.a.l0.j<String> G;
    private final d.b.s.a.l0.j<Long> H;
    private final d.b.s.a.l0.j<Integer> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final d.b.s.a.l0.j<String> f5548J;
    private final d.b.s.a.l0.j<Boolean> K;
    private final d.b.s.a.l0.j<String> L;
    private final d.b.s.a.l0.j<String> M;
    private final d.b.s.a.l0.j<String> N;
    private final d.b.s.a.l0.j<Integer> O;
    private final d.b.s.a.l0.j<Boolean> P;
    private final d.b.s.a.l0.j<Boolean> Q;
    private final d.b.s.a.l0.j<Boolean> R;
    private final d.b.s.a.l0.j<Long> S;
    private final d.b.s.a.l0.j<String> T;
    private final d.b.s.a.l0.j<String> U;
    private final d.b.s.a.l0.j<Integer> V;
    private final d.b.s.a.l0.j<Integer> W;
    private final d.b.s.a.l0.j<Integer> X;
    private final d.b.s.a.l0.j<Integer> Y;
    private final d.b.s.a.l0.j<Boolean> Z;
    private final d.b.s.a.l0.j<d.b.s.a.k0.a> a0;
    private final d.b.s.a.l0.j<Set<String>> b0;
    private final d.b.s.a.l0.j<Boolean> c0;
    private final d.b.s.a.l0.j<JSONObject> d0;
    private final d.b.s.a.l0.j<JSONObject> e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected d.b.s.a.l0.j<d.b.s.a.q.h> f5549f;
    private final d.b.s.a.l0.j<com.ss.android.i.l.a[]> f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f5550g;
    private final d.b.s.a.l0.j<String> g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f5551h;
    private final d.b.s.a.l0.j<Boolean> h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d.b.s.a.l0.j<String> f5552i;
    private final d.b.s.a.l0.j<Integer> i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.b.s.a.l0.j<String> f5553j;
    Context j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d.b.s.a.l0.j<String> f5554k;
    SharedPreferences k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final d.b.s.a.l0.j<String> f5555l;
    protected final WeakHandler l0;
    private final d.b.s.a.l0.j<Integer> m;
    private final Set<d.b.s.a.q.c> m0;
    private final d.b.s.a.l0.j<String> n;
    private final d.b.s.a.l0.j<String> o;
    private final d.b.s.a.l0.j<Integer> p;
    private final d.b.s.a.l0.j<String> q;
    private final d.b.s.a.l0.j<Integer> r;
    private final d.b.s.a.l0.j<Integer> s;
    private final d.b.s.a.l0.j<Boolean> t;
    private final d.b.s.a.l0.j<Boolean> u;
    private final d.b.s.a.l0.j<Long> v;
    private final d.b.s.a.l0.j<String> w;
    private final d.b.s.a.l0.j<String> x;
    private final d.b.s.a.l0.j<String> y;
    private final d.b.s.a.l0.j<String> z;

    class a extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5556d;

        a(i r1) {
            this.f5556d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5556d.k0.getInt("user_gender", 0));
        }
    }

    class a0 extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5557d;

        a0(i r1) {
            this.f5557d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5557d.k0.getInt("country_code", 0));
        }
    }

    class a1 extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5558d;

        a1(i r1) {
            this.f5558d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5558d.k0.getString("bg_img_url", "");
        }
    }

    class b extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5559d;

        b(i r1) {
            this.f5559d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5559d.k0.getString("user_industry", "");
        }
    }

    class b0 extends d.b.s.a.l0.j<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5560d;

        b0(i r1) {
            this.f5560d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(this.f5560d.k0.getBoolean("is_new_user", false));
        }
    }

    class b1 extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5561d;

        b1(i r1) {
            this.f5561d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5561d.k0.getString("user_birthday", "");
        }
    }

    class c extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5562d;

        c(i r1) {
            this.f5562d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5562d.k0.getInt("is_blocked", 0));
        }
    }

    class c0 extends d.b.s.a.l0.j<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5563d;

        c0(i r1) {
            this.f5563d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(this.f5563d.k0.getBoolean("is_login", false));
        }
    }

    class c1 extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5564d;

        c1(i r1) {
            this.f5564d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5564d.k0.getInt("can_be_found_by_phone", 1));
        }
    }

    class d extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5565d;

        d(i r1) {
            this.f5565d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5565d.k0.getInt("is_blocking", 0));
        }
    }

    class d0 extends d.b.s.a.l0.j<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5566d;

        d0(i r1) {
            this.f5566d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(this.f5566d.k0.getBoolean("user_has_pwd", false));
        }
    }

    class d1 extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5567d;

        d1(i r1) {
            this.f5567d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5567d.k0.getString("user_description", "");
        }
    }

    class e extends d.b.s.a.l0.j<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5568d;

        e(i r1) {
            this.f5568d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(this.f5568d.k0.getBoolean("is_recommend_allowed", false));
        }
    }

    class e0 extends d.b.s.a.l0.j<Long> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5569d;

        e0(i r1) {
            this.f5569d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Long b() {
            return e();
        }

        @NonNull
        protected Long e() {
            return Long.valueOf(this.f5569d.k0.getLong("pgc_mediaid", 0));
        }
    }

    class e1 extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5570d;

        e1(i r1) {
            this.f5570d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5570d.k0.getString("user_email", "");
        }
    }

    class f extends d.b.s.a.l0.j<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5571d;

        f(i r1) {
            this.f5571d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(this.f5571d.k0.getBoolean("is_toutiao", false));
        }
    }

    class f0 extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5572d;

        f0(i r1) {
            this.f5572d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5572d.k0.getString("area", "");
        }
    }

    private interface f1 {
        void a(d.b.s.a.q.j.b r1, com.bytedance.sdk.account.impl.o r2);
    }

    class g extends d.b.s.a.l0.j<Long> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5573d;

        g(i r1) {
            this.f5573d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Long b() {
            return e();
        }

        @NonNull
        protected Long e() {
            return Long.valueOf(this.f5573d.k0.getLong("media_id", 0));
        }
    }

    class g0 extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5574d;

        g0(i r1) {
            this.f5574d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5574d.k0.getString("pgc_avatar_url", "");
        }
    }

    private static class g1 implements f1 {
        private g1() {
        }

        /* synthetic */ g1(k r1) {
            this();
        }

        @Override // com.bytedance.sdk.account.impl.i.f1
        public void a(d.b.s.a.q.j.b r5, com.bytedance.sdk.account.impl.o r6) {
            if (r5.o == 10001) goto L5;
            return;
        L5:
            if (r5.f14887c == false) goto L13;
            d.b.s.a.q.f r4 = com.bytedance.sdk.account.impl.g.d(com.ss.android.i.j.k().e());
            Long r0 = Long.valueOf(r4.getUserId());
            r4.x(false);
            com.ss.android.token.o.w(r0, 0L, com.ss.android.token.o.b(r5.f14888d), "logout");
            if ((r5 instanceof d.b.s.a.q.j.d) == false) goto L9;
            String r7 = ((d.b.s.a.q.j.d) r5).p;
        L10:
            i.B(r4, r7, r6);
            return;
        L9:
            r7 = "";
            goto L10
        }
    }

    class h extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5575d;

        h(i r1) {
            this.f5575d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5575d.k0.getString("user_mobile", "");
        }
    }

    class h0 extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5576d;

        h0(i r1) {
            this.f5576d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5576d.k0.getString("pgc_name", "");
        }
    }

    private static class h1 implements f1 {
        private h1() {
        }

        /* synthetic */ h1(k r1) {
            this();
        }

        @Override // com.bytedance.sdk.account.impl.i.f1
        public void a(d.b.s.a.q.j.b r7, com.bytedance.sdk.account.impl.o r8) {
            Context r6 = com.ss.android.i.j.k().e();
            if ((r7 instanceof d.b.s.a.q.j.f) == false) goto L17;
            d.b.s.a.q.j.f r9 = (d.b.s.a.q.j.f) r7;
            if (r7.f14887c == false) goto L7;
            Bundle r0 = new Bundle();
            r0.putString("access_token", r9.r);
            r0.putLong("expires_in", r9.s);
            r0.putLong("refresh_time", r9.x);
            r0.putString("open_id", r9.t);
            r0.putString("scopes", r9.w);
            d.b.s.a.a0.a.a("BDAccountManager", "ThirdTokenHandler.handle: api=" + r7.o + ", updatePlatformInfo. resp=" + r9.b());
            i.F(i.S(r6), r9.p, r9.q, r0);
            return;
        L7:
            int r1 = r9.f14891g;
            if (r1 != 1058) goto L10;
        L11:
            d.b.s.a.a0.a.a("BDAccountManager", "ThirdTokenHandler.handle: api=" + r7.o + ", clearPlatformInfoInner. errCode=" + r9.f14891g);
            i r10 = i.S(r6);
            String r11 = r9.p;
            int r2 = r9.q;
            if (r9.f14891g != 1058) goto L14;
            boolean r12 = true;
        L15:
            i.z(r10, r11, r2, r12);
            return;
        L14:
            r12 = false;
            goto L15
        L10:
            if (r1 == 1059) goto L11;
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.account.impl.i$i, reason: collision with other inner class name */
    class C0177i extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5577d;

        C0177i(i r1) {
            this.f5577d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5577d.k0.getString("user_name", "");
        }
    }

    class i0 extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5578d;

        i0(i r1) {
            this.f5578d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5578d.k0.getInt("display_ocr_entrance", 0));
        }
    }

    private static class i1 implements f1 {
        private i1() {
        }

        /* synthetic */ i1(k r1) {
            this();
        }

        private void b(d.b.s.a.q.j.b r7, com.bytedance.sdk.account.impl.o r8, d.b.s.a.k0.a r9) {
            d.b.s.a.q.j.a<T> r6 = r8.f5627a;
            if (r6 == null) goto L5;
            Map<String, String> r10 = r6.d(r7);
        L6:
            Map<String, String> r4 = r10;
            StringBuilder r11 = new StringBuilder();
            List<com.ss.android.f> r12 = r7.f14896l;
            String r0 = "";
            if (r12 != null) goto L9;
        L28:
            String r13 = "";
        L29:
            i.C().d0(r9, true, !TextUtils.isEmpty(r0), r4, r7);
            i.E(i.C(), r13);
            if (TextUtils.isEmpty(r13) == true) goto L32;
            return;
        L32:
            if (com.bytedance.sdk.account.settings.f.a.p() == false) goto L50;
            com.ss.android.token.o.n(r7.f14888d, r7.f14885a, r9.f14835h, r11.toString(), r9.f14828a);
            return;
        L50:
            return;
        L9:
            if (r12.isEmpty() == true) goto L28;
            Iterator<com.ss.android.f> r14 = r12.iterator();
            String r1 = "";
        L12:
            if (r14.hasNext() == false) goto L27;
            com.ss.android.f r2 = r14.next();
            if (r2 == null) goto L12;
            if (TextUtils.isEmpty(r2.a()) == true) goto L12;
            if (TextUtils.isEmpty(r2.b()) == true) goto L12;
            String r3 = r2.a().toLowerCase();
            r11.append(r3);
            r11.append(",");
            r3.hashCode();
            if (r3.equals("x-tt-token") == false) goto L23;
            r1 = r2.b();
            goto L12
        L23:
            if (r3.equals("x-tt-passport-session-id") == false) goto L12;
            r0 = r2.b();
            goto L12
        L27:
            r13 = r0;
            r0 = r1;
            goto L29
        L5:
            r10 = null;
            goto L6
        }

        @Override // com.bytedance.sdk.account.impl.i.f1
        public void a(d.b.s.a.q.j.b r5, com.bytedance.sdk.account.impl.o r6) {
            d.b.s.a.k0.a r1 = null;
            if ((r5 instanceof d.b.s.a.q.j.g) == false) goto L6;
            r1 = ((d.b.s.a.q.j.g) r5).p;
        L13:
            if (r1 == null) goto L16;
            long r2 = i.C().getUserId();
            b(r5, r6, r1);
            i.D(r2, r1, r5);
            return;
        L16:
            return;
        L6:
            if ((r5 instanceof d.b.s.a.q.j.e) == false) goto L11;
            T r0 = ((d.b.s.a.q.j.e) r5).p;
            if ((r0 instanceof d.b.s.a.b0.a.a) == false) goto L13;
            r1 = ((d.b.s.a.b0.a.a) r0).a();
            goto L13
        L11:
            if ((r5 instanceof d.b.s.a.q.m.e) == false) goto L13;
            r1 = ((d.b.s.a.q.m.e) r5).p;
            goto L13
        }
    }

    class j extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5579d;

        j(i r1) {
            this.f5579d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5579d.k0.getString("screen_name", "");
        }
    }

    class j0 extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5580d;

        j0(i r1) {
            this.f5580d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5580d.k0.getInt("following_count", 0));
        }
    }

    class k extends d.b.s.a.l0.j<d.b.s.a.q.h> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5581d;

        k(i r1) {
            this.f5581d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ d.b.s.a.q.h b() {
            return e();
        }

        @NonNull
        protected d.b.s.a.q.h e() {
            return com.bytedance.sdk.account.impl.e.b(this.f5581d.j0);
        }
    }

    class k0 extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5582d;

        k0(i r1) {
            this.f5582d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5582d.k0.getInt("followers_count", 0));
        }
    }

    class l extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5583d;

        l(i r1) {
            this.f5583d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5583d.k0.getString("recommend_hint_message", "");
        }
    }

    class l0 extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5584d;

        l0(i r1) {
            this.f5584d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5584d.k0.getInt("visitors_count", 0));
        }
    }

    class m extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5585d;

        m(i r1) {
            this.f5585d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5585d.k0.getInt("can_sync_share", 0));
        }
    }

    class m0 extends d.b.s.a.l0.j<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5586d;

        m0(i r1) {
            this.f5586d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(this.f5586d.k0.getBoolean("is_visitor_account", false));
        }
    }

    class n extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5587d;

        n(i r1) {
            this.f5587d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5587d.k0.getInt("user_privacy_extend", 0));
        }
    }

    class n0 extends d.b.s.a.l0.j<d.b.s.a.k0.a> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5588d;

        n0(i r1) {
            this.f5588d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ d.b.s.a.k0.a b() {
            return e();
        }

        @NonNull
        protected d.b.s.a.k0.a e() {
            return this.f5588d.M();
        }
    }

    class o extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5589d;

        o(i r1) {
            this.f5589d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5589d.k0.getInt("user_privacy_extend_value", 2147483646));
        }
    }

    class o0 extends d.b.s.a.l0.j<Set<String>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5590d;

        o0(i r1) {
            this.f5590d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Set<String> b() {
            return e();
        }

        @NonNull
        protected Set<String> e() {
            return this.f5590d.k0.getStringSet("has_update_sec_uids", new HashSet());
        }
    }

    class p extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5591d;

        p(i r1) {
            this.f5591d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5591d.k0.getString("multi_sids", "");
        }
    }

    class p0 extends d.b.s.a.l0.j<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5592d;

        p0(i r1) {
            this.f5592d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(this.f5592d.k0.getBoolean("is_kids_mode", false));
        }
    }

    class q extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5593d;

        q(i r1) {
            this.f5593d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @Override // d.b.s.a.l0.j
        public /* bridge */ /* synthetic */ void c(String r1) {
            f(r1);
        }

        @NonNull
        protected String e() {
            return this.f5593d.k0.getString("sec_multi_sids", "");
        }

        public void f(String r2) {
            super.c(r2);
            this.f5593d.k0.edit().putString("sec_multi_sids", r2).apply();
        }
    }

    class q0 extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5594d;

        q0(i r1) {
            this.f5594d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5594d.k0.getString("avatar_url", "");
        }
    }

    class r extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5595d;

        r(i r1) {
            this.f5595d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5595d.k0.getString("user_auth_info", "");
        }
    }

    class r0 extends d.b.s.a.l0.j<JSONObject> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5596d;

        r0(i r1) {
            this.f5596d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ JSONObject b() {
            return e();
        }

        @NonNull
        protected JSONObject e() {
            return new JSONObject(this.f5596d.k0.getString("expend_attrs", "{}"));
        L5:
            return new JSONObject();
        }
    }

    class s extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5597d;

        s(i r1) {
            this.f5597d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5597d.k0.getString("user_decoration", "");
        }
    }

    class s0 extends d.b.s.a.l0.j<JSONObject> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5598d;

        s0(i r1) {
            this.f5598d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ JSONObject b() {
            return e();
        }

        @NonNull
        protected JSONObject e() {
            return new JSONObject(this.f5598d.k0.getString("raw_json", "{}"));
        L5:
            return new JSONObject();
        }
    }

    class t extends d.b.s.a.l0.j<Long> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5599d;

        t(i r1) {
            this.f5599d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Long b() {
            return e();
        }

        @NonNull
        protected Long e() {
            long r2 = 0;
            long r0 = this.f5599d.k0.getLong("user_id", 0);
            if (((Boolean) i.A(this.f5599d).a()).booleanValue() == false) goto L9;
            if (r0 > 0) goto L9;
            i.A(this.f5599d).c(Boolean.FALSE);
        L7:
            i.G(this.f5599d).c("");
            i.H(this.f5599d).c(0);
        L15:
            return Long.valueOf(r2);
        L9:
            if (((Boolean) i.A(this.f5599d).a()).booleanValue() == false) goto L11;
        L13:
            r2 = r0;
            goto L15
        L11:
            if (r0 <= 0) goto L13;
            goto L13
        }
    }

    class t0 extends d.b.s.a.l0.j<com.ss.android.i.l.a[]> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5600d;

        t0(i r1) {
            this.f5600d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ com.ss.android.i.l.a[] b() {
            return e();
        }

        @NonNull
        protected com.ss.android.i.l.a[] e() {
            Class.forName("com.bytedance.sdk.account.impl.BDAccountManagerAdapter").getMethod("init", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L4
        L6:
            com.ss.android.i.l.a[] r0 = i.x0;
            i.I(this.f5600d, r0);
            return r0;
        L4:
            e = move-exception;
            d.b.s.a.a0.a.c("BDAccountManager", "try init BDAccountManagerAdapter fail", e);
            goto L6
        }
    }

    class u extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5601d;

        u(i r1) {
            this.f5601d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5601d.k0.getInt("odin_user_type", 0));
        }
    }

    class u0 extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5602d;

        u0(i r1) {
            this.f5602d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5602d.k0.getString("header_session_id", "");
        }
    }

    class v extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5603d;

        v(i r1) {
            this.f5603d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5603d.k0.getString("sec_user_id", "");
        }
    }

    class v0 extends d.b.s.a.l0.j<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5604d;

        v0(i r1) {
            this.f5604d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(this.f5604d.k0.getBoolean("use_hm_region", false));
        }
    }

    class w extends d.b.s.a.l0.j<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5605d;

        w(i r1) {
            this.f5605d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean b() {
            return e();
        }

        @NonNull
        protected Boolean e() {
            return Boolean.valueOf(this.f5605d.k0.getBoolean("user_verified", false));
        }
    }

    class w0 extends d.b.s.a.l0.j<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5606d;

        w0(i r1) {
            this.f5606d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ Integer b() {
            return e();
        }

        @NonNull
        protected Integer e() {
            return Integer.valueOf(this.f5606d.k0.getInt("hm_region", 0));
        }
    }

    class x extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5607d;

        x(i r1) {
            this.f5607d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5607d.k0.getString("verified_content", "");
        }
    }

    class x0 implements com.ss.android.token.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f5608a;

        x0(i r1) {
            this.f5608a = r1;
        }

        @Override // com.ss.android.token.e
        public void a() {
            if (((Long) i.J(this.f5608a).a()).longValue() <= 0) goto L6;
            i r0 = this.f5608a;
            r0.l0(((Long) i.J(r0).a()).longValue(), this.f5608a.getSessionKey());
            return;
        }
    }

    class y extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5609d;

        y(i r1) {
            this.f5609d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5609d.k0.getString("session_key", "");
        }
    }

    class y0 extends d.b.s.a.q.k.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f5610c;

        y0(i r1) {
            this.f5610c = r1;
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
            i.K(this.f5610c);
        }

        public void n(d.b.s.a.q.m.d r1) {
            i.K(this.f5610c);
        }
    }

    class z extends d.b.s.a.l0.j<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f5611d;

        z(i r1) {
            this.f5611d = r1;
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ String b() {
            return e();
        }

        @NonNull
        protected String e() {
            return this.f5611d.k0.getString("session_sign", "");
        }
    }

    class z0 implements d.b.s.a.f0.e.b {
        z0(i r1) {
        }

        @Override // d.b.s.a.f0.e.b
        public void a(int r2, String r3) {
            d.b.s.a.a0.a.a("BDAccountManager", "SaveService.saveLoginInfo error: code=" + r2 + " msg=" + r3);
        }

        @Override // d.b.s.a.f0.e.b
        public void onSuccess() {
            d.b.s.a.a0.a.a("BDAccountManager", "SaveService.saveLoginInfo success");
        }
    }

    static {
        com.ss.android.i.l.a r1 = new com.ss.android.i.l.a("mobile");
        n0 = r1;
        com.ss.android.i.l.a r2 = new com.ss.android.i.l.a(NotificationCompat.CATEGORY_EMAIL);
        o0 = r2;
        com.ss.android.i.l.a r3 = new com.ss.android.i.l.a("google");
        p0 = r3;
        com.ss.android.i.l.a r4 = new com.ss.android.i.l.a("facebook");
        q0 = r4;
        com.ss.android.i.l.a r5 = new com.ss.android.i.l.a("twitter");
        r0 = r5;
        com.ss.android.i.l.a r6 = new com.ss.android.i.l.a("instagram");
        s0 = r6;
        com.ss.android.i.l.a r7 = new com.ss.android.i.l.a("line");
        t0 = r7;
        com.ss.android.i.l.a r8 = new com.ss.android.i.l.a("kakaotalk");
        u0 = r8;
        com.ss.android.i.l.a r9 = new com.ss.android.i.l.a("vk");
        v0 = r9;
        com.ss.android.i.l.a r10 = new com.ss.android.i.l.a("tiktok");
        w0 = r10;
        x0 = new com.ss.android.i.l.a[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        ArrayList r11 = new ArrayList();
        z0 = r11;
        k r12 = null;
        r11.add(new i1(r12));
        r11.add(new g1(r12));
        r11.add(new h1(r12));
    }

    private i(Context r3) {
        this.f5549f = new k(this);
        this.f5551h = "";
        this.f5552i = new f0(this);
        this.f5553j = new q0(this);
        this.f5554k = new a1(this);
        this.f5555l = new b1(this);
        this.m = new c1(this);
        this.n = new d1(this);
        this.o = new e1(this);
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.t = new e(this);
        this.u = new f(this);
        this.v = new g(this);
        this.w = new h(this);
        this.x = new C0177i(this);
        this.y = new j(this);
        this.z = new l(this);
        this.A = new m(this);
        this.B = new n(this);
        this.C = new o(this);
        this.D = new p(this);
        this.E = new q(this);
        this.F = new r(this);
        this.G = new s(this);
        this.H = new t(this);
        this.I = new u(this);
        this.f5548J = new v(this);
        this.K = new w(this);
        this.L = new x(this);
        this.M = new y(this);
        this.N = new z(this);
        this.O = new a0(this);
        this.P = new b0(this);
        this.Q = new c0(this);
        this.R = new d0(this);
        this.S = new e0(this);
        this.T = new g0(this);
        this.U = new h0(this);
        this.V = new i0(this);
        this.W = new j0(this);
        this.X = new k0(this);
        this.Y = new l0(this);
        this.Z = new m0(this);
        this.a0 = new n0(this);
        this.b0 = new o0(this);
        this.c0 = new p0(this);
        this.d0 = new r0(this);
        this.e0 = new s0(this);
        this.f0 = new t0(this);
        this.g0 = new u0(this);
        this.h0 = new v0(this);
        this.i0 = new w0(this);
        this.l0 = new WeakHandler(Looper.getMainLooper(), this);
        this.m0 = new HashSet();
        Context r4 = r3.getApplicationContext();
        this.j0 = r4;
        this.k0 = y(r4, "com.bytedance.sdk.account_setting", 0);
        W();
        com.ss.android.token.n.a(new x0(this));
    }

    static /* synthetic */ d.b.s.a.l0.j A(i r1) {
        return r1.Q;
    }

    static /* synthetic */ void B(d.b.s.a.q.f r1, String r2, com.bytedance.sdk.account.impl.o r3) {
        Z(r1, r2, r3);
    }

    static /* synthetic */ i C() {
        return y0;
    }

    static /* synthetic */ void D(long r1, d.b.s.a.k0.a r2, d.b.s.a.q.j.b r3) {
        Y(r1, r2, r3);
    }

    static /* synthetic */ void E(i r1, String r2) {
        r1.c0(r2);
    }

    static /* synthetic */ void F(i r1, String r2, int r3, Bundle r4) {
        r1.r0(r2, r3, r4);
    }

    static /* synthetic */ d.b.s.a.l0.j G(i r1) {
        return r1.f5548J;
    }

    static /* synthetic */ d.b.s.a.l0.j H(i r1) {
        return r1.I;
    }

    static /* synthetic */ void I(i r1, com.ss.android.i.l.a[] r2) {
        r1.U(r2);
    }

    static /* synthetic */ d.b.s.a.l0.j J(i r1) {
        return r1.H;
    }

    static /* synthetic */ void K(i r1) {
        r1.k0();
    }

    private void L(String r7, int r8, boolean r9) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        if (r8 != (-1)) goto L7;
        return;
    L7:
        if (this.Q.a().booleanValue() == true) goto L9;
        return;
    L9:
        if (this.e0.a() != null) goto L11;
        return;
    L11:
        if (this.a0.a() == null) goto L45;
        if (r9 == false) goto L29;
        com.ss.android.i.l.a r10 = new com.ss.android.i.l.a(r7);
        r10.q = r8;
        JSONArray r2 = this.e0.a().optJSONObject("data").optJSONArray("connects");     // Catch: Exception -> L34
        int r3 = 0;
    L17:
        if (r3 >= r2.length()) goto L24;
        JSONObject r4 = r2.getJSONObject(r3);     // Catch: Exception -> L34
        if (TextUtils.equals(r4.optString(WsConstants.KEY_PLATFORM), r7) == false) goto L23;
        if (r4.optInt("platform_app_id") != r8) goto L23;
        this.e0.a().optJSONObject("data").put("connects", d.b.s.a.l0.s.g(r2, r3));     // Catch: Exception -> L34
        this.a0.a().q(this.e0.a());     // Catch: Exception -> L34
    L23:
        r3 = r3 + 1;     // Catch: Exception -> L34
    L24:
        this.a0.a().d().put(r7, r10);     // Catch: Exception -> L34
        Map<String, com.ss.android.i.l.a> r11 = this.a0.a().m().get(r7);     // Catch: Exception -> L34
        if (r11 == null) goto L27;
        r11.put(String.valueOf(r8), r10);     // Catch: Exception -> L34
    L27:
        SharedPreferences.Editor r12 = this.k0.edit();     // Catch: Exception -> L34
        h0(r12);     // Catch: Exception -> L34
        i0(r12);     // Catch: Exception -> L34
        j0();     // Catch: Exception -> L34
        X("clearPlatformInfoInner");     // Catch: Exception -> L34
        return;
    L47:
        return;
    L29:
        Bundle r13 = new Bundle();
        r13.putString("access_token", "");
        if (com.bytedance.sdk.account.settings.f.a.h() != 0) goto L32;
        r13.putString("open_id", "");
    L32:
        r13.putString("scopes", "");
        r13.putLong("expires_in", 0);
        r13.putLong("refresh_time", 0);
        r0(r7, r8, r13);
        return;
    }

    @Nullable
    private JSONObject O(com.ss.android.i.l.a r4) {
        JSONObject r3 = new JSONObject();
        r3.put("mName", r4.f11907f);     // Catch: Exception -> L5
        r3.put("mPlatformId", r4.q);     // Catch: Exception -> L5
        r3.put("mNickname", r4.f11909h);     // Catch: Exception -> L5
        r3.put("mAvatar", r4.f11910i);     // Catch: Exception -> L5
        r3.put("mPlatformUid", r4.f11911j);     // Catch: Exception -> L5
        r3.put("mExpire", r4.n);     // Catch: Exception -> L5
        r3.put("mExpireIn", r4.o);     // Catch: Exception -> L5
        r3.put("isLogin", r4.f11908g);     // Catch: Exception -> L5
        r3.put("mUserId", r4.p);     // Catch: Exception -> L5
        r3.put("mModifyTime", r4.m);     // Catch: Exception -> L5
        r3.put("mSecPlatformUid", r4.f11912k);     // Catch: Exception -> L5
        r3.put("mAccessToken", r4.r);     // Catch: Exception -> L5
        r3.put("mOpenId", r4.s);     // Catch: Exception -> L5
        r3.put("mScope", r4.t);     // Catch: Exception -> L5
        r3.put("refreshAt", r4.v);     // Catch: Exception -> L5
        r3.put("refreshTime", r4.w);     // Catch: Exception -> L5
        return r3;
    L5:
        return null;
    }

    private void R(d.b.s.a.q.j.b r2, com.bytedance.sdk.account.impl.o<T> r3) {
        Iterator<f1> r1 = z0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().a(r2, r3);
        goto L4
    }

    static i S(Context r2) {
        if (y0 != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (y0 != null) goto L9;
        y0 = new i(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        if (y0.j0 != null) goto L20;
        if (r2.getApplicationContext() == null) goto L20;
        i r1 = y0;
        r1.j0 = r2.getApplicationContext();
    L20:
        return y0;
    }

    private void T(com.bytedance.sdk.account.impl.o<T> r1) {
        d.b.s.a.q.j.a<T> r2 = r1.f5627a;
        if (r2 == null) goto L8;
        r2.a(r1.f5628b);
        d.b.s.a.q.l.a r3 = r2.f5521a;
        if (r3 == null) goto L9;
        r3.g();
        return;
    L9:
        return;
    }

    private void U(com.ss.android.i.l.a[] r7) {
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L14;
        r7[r1].f11908g = false;
        com.ss.android.i.l.a r2 = r7[r1];
        if (TextUtils.isEmpty(r2.f11907f) == true) goto L13;
        String r3 = this.k0.getString("_platform_" + r2.f11907f, null);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r3) == true) goto L13;
        V(new JSONObject(r3), r2);     // Catch: Exception -> L15
    L13:
        r1 = r1 + 1;
        goto L4
    }

    @Nullable
    private com.ss.android.i.l.a V(JSONObject r7, @Nullable com.ss.android.i.l.a r8) {
        if (r7 != null) goto L4;
        return r8;
    L4:
        String r6 = r7.optString("mName", "");
        if (TextUtils.isEmpty(r6) == false) goto L7;
        return r8;
    L7:
        if (r8 != null) goto L10;
        r8 = new com.ss.android.i.l.a(r6);
    L10:
        if (TextUtils.equals(r6, r8.f11907f) == true) goto L13;
        return r8;
    L13:
        if (r7.has("mPlatformId") == false) goto L16;
        r8.q = r7.optLong("mPlatformId", 0);
    L16:
        if (r7.has("mNickname") == false) goto L19;
        r8.f11909h = r7.optString("mNickname", "");
    L19:
        if (r7.has("mAvatar") == false) goto L22;
        r8.f11910i = r7.optString("mAvatar", "");
    L22:
        if (r7.has("mPlatformUid") == false) goto L25;
        r8.f11911j = r7.optString("mPlatformUid", "");
    L25:
        if (r7.has("mExpire") == false) goto L28;
        r8.n = r7.optLong("mExpire", r8.n);
    L28:
        if (r7.has("mExpireIn") == false) goto L31;
        r8.o = r7.optLong("mExpireIn", r8.o);
    L31:
        if (r7.has("isLogin") == false) goto L34;
        r8.f11908g = r7.optBoolean("isLogin", false);
    L34:
        if (r7.has("mUserId") == false) goto L37;
        r8.p = r7.optLong("mUserId", 0);
    L37:
        if (r7.has("mModifyTime") == false) goto L40;
        r8.m = r7.optLong("mModifyTime");
    L40:
        if (r7.has("mSecPlatformUid") == false) goto L43;
        r8.f11912k = r7.optString("mSecPlatformUid");
    L43:
        if (r7.has("mAccessToken") == false) goto L46;
        r8.r = r7.optString("mAccessToken");
    L46:
        if (r7.has("mOpenId") == false) goto L49;
        r8.s = r7.optString("mOpenId");
    L49:
        if (r7.has("mScope") == false) goto L52;
        r8.t = r7.optString("mScope");
    L52:
        if (r7.has("refreshAt") == false) goto L55;
        r8.v = r7.optLong("refreshAt", r8.v);
    L55:
        if (r7.has("refreshTime") == false) goto L57;
        r8.w = r7.optLong("refreshTime", r8.w);
    L57:
        return r8;
    }

    private void W() {
        this.H.a();
    }

    private void X(String r8) {
        if (this.a0.a() != null) goto L6;
        d.b.s.a.a0.a.a("BDAccountManager", "mUserInfo == null");
        return;
    L6:
        d.b.s.a.a0.a.a("BDAccountManager", String.format("%s: bind map entities", new Object[]{r8}));
        d.b.s.a.a0.a.a("BDAccountManager", "isLogin==" + this.Q);
        Iterator<com.ss.android.i.l.a> r2 = this.a0.a().f14830c.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        d.b.s.a.a0.a.a("BDAccountManager", String.format("%1s: bind map entity = %2s", new Object[]{r8, r2.next().d()}));
        goto L8
    L10:
        d.b.s.a.a0.a.a("BDAccountManager", String.format("%s: third platform entities", new Object[]{r8}));
        Iterator<Map<String, com.ss.android.i.l.a>> r7 = this.a0.a().f14831d.values().iterator();
    L12:
        if (r7.hasNext() == false) goto L17;
        Iterator<com.ss.android.i.l.a> r3 = r7.next().values().iterator();
    L15:
        if (r3.hasNext() == false) goto L12;
        d.b.s.a.a0.a.a("BDAccountManager", String.format("%1s: third platform entity = %2s", new Object[]{r8, r3.next().d()}));
        goto L15
    }

    private static void Y(long r2, d.b.s.a.k0.a r4, d.b.s.a.q.j.b r5) {
        if (r4 == null) goto L4;
        long r1 = r4.o();
    L6:
        if (r2 == r1) goto L9;
        com.ss.android.token.o.w(Long.valueOf(r2), Long.valueOf(r1), com.ss.android.token.o.b(r5.f14888d), "api");
        return;
    L9:
        return;
    L4:
        r1 = 0;
        goto L6
    }

    private static void Z(d.b.s.a.q.f r2, String r3, com.bytedance.sdk.account.impl.o r4) {
        d.b.s.a.q.b r1 = new d.b.s.a.q.b(1);
        r1.f14880b = d.b.s.a.q.b.a(r3);
        if (r4 == null) goto L7;
        d.b.s.a.q.j.a<T> r5 = r4.f5627a;
        if (r5 == null) goto L7;
        r1.f14883e = r5.d(r4.f5628b);
    L7:
        r2.l(r1);
    }

    private void a0(boolean r3, JSONObject r4, Map<String, String> r5, d.b.s.a.q.j.b r6) {
        if (r3 == false) goto L5;
        d.b.s.a.q.b r7 = new d.b.s.a.q.e(0);
    L6:
        r7.f14883e = r5;
        d.b.s.a.a0.a.d("BDAccountManager", "notifyUserInfoChange(), extra=" + r5);
        Set<d.b.s.a.q.c> r8 = this.m0;
        monitor-enter(r8);
        Iterator<d.b.s.a.q.c> r2 = this.m0.iterator();     // Catch: Throwable -> L14
    L10:
        if (r2.hasNext() == false) goto L12;
        d.b.s.a.q.c r9 = r2.next();     // Catch: Throwable -> L14
        d.b.s.a.a0.a.d("BDAccountManager", "notifyUserInfoChange(), listener=" + r9.getClass().getName());     // Catch: Throwable -> L14
        r9.F(r7);     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L5:
        r7 = new d.b.s.a.q.b(0);
        goto L6
    }

    private void b0() {
        d.b.s.a.q.b r1 = new d.b.s.a.q.b(2);
        if (com.bytedance.sdk.account.impl.p.b() == null) goto L7;
        com.bytedance.sdk.account.impl.q r2 = com.bytedance.sdk.account.impl.p.b().d();
        if (r2 == null) goto L7;
        r1.f14881c = r2.c();
        r1.f14882d = r2.b();
    L7:
        Set<d.b.s.a.q.c> r3 = this.m0;
        monitor-enter(r3);
        Iterator<d.b.s.a.q.c> r4 = this.m0.iterator();     // Catch: Throwable -> L15
    L11:
        if (r4.hasNext() == false) goto L13;
        r4.next().F(r1);     // Catch: Throwable -> L15
        goto L11
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void c0(String r3) {
        if (TextUtils.equals(r3, this.g0.a()) == true) goto L6;
        this.g0.c(r3);
        g0();
        l0(this.H.a().longValue(), getSessionKey());
        return;
    }

    private boolean e0(d.b.s.a.k0.a r8) {
        com.ss.android.i.l.a[] r7 = this.f0.a();
        int r1 = r7.length;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L17;
        com.ss.android.i.l.a r4 = r7[r2];
        com.ss.android.i.l.a r5 = r8.d().get(r4.f11907f);
        if (r5 != null) goto L11;
        if (r4.f11908g == false) goto L9;
        r3 = true;
    L9:
        r4.f();
    L16:
        r2 = r2 + 1;
        goto L3
    L11:
        if (r4.f11908g == true) goto L13;
        r4.f11908g = true;
        r3 = true;
    L13:
        r4.q = r5.q;
        r4.n = r5.n;
        r4.o = r5.o;
        r4.f11909h = r5.f11909h;
        r4.f11910i = r5.f11910i;
        r4.f11911j = r5.f11911j;
        r4.p = r5.p;
        r4.m = r5.m;
        r4.f11912k = r5.f11912k;
        r4.u = r5.u;
        if (com.bytedance.sdk.account.settings.f.a.h() == 0) goto L16;
        r4.s = r5.s;
        goto L16
    L17:
        return r3;
    }

    private void g0() {
        SharedPreferences.Editor r1 = this.k0.edit();
        r1.putString("header_session_id", this.g0.a());
        com.bytedance.common.utility.o.a.a(r1);
    }

    private void h0(SharedPreferences.Editor r3) {
        if (this.e0.a() != null) goto L5;
        String r2 = "";
    L6:
        r3.putString("raw_json", r2);
        r3.apply();
        return;
    L5:
        r2 = this.e0.toString();
        goto L6
    }

    private void i0(SharedPreferences.Editor r8) {
        com.ss.android.i.l.a[] r1 = this.f0.a();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        com.ss.android.i.l.a r4 = r1[r3];
        if (this.Q.a().booleanValue() == true) goto L8;
        String r5 = "_platform_" + r4.f11907f;
        String r6 = "";
    L7:
        r8.putString(r5, r6);
    L11:
        r3 = r3 + 1;
        goto L3
    L8:
        JSONObject r7 = O(r4);
        if (r7 == null) goto L11;
        r5 = "_platform_" + r4.f11907f;
        r6 = r7.toString();
        goto L7
    L12:
        r8.apply();
    }

    private void j0() {
        if (this.a0.a() != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.k0.edit();
        Set<String> r2 = this.k0.getStringSet("store_key_saved_platform_app_id", null);
        if (r2 == null) goto L24;
        Iterator<String> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L24;
        String r4 = r3.next();
        String r5 = P(r4);
        String r6 = this.k0.getString(r5, null);
        if (TextUtils.isEmpty(r6) == true) goto L12;
        String r7 = new JSONObject(r6).optString("mName");     // Catch: Exception -> L46
        Map<String, com.ss.android.i.l.a> r8 = this.a0.a().m().get(r7);     // Catch: Exception -> L46
        if (r8 == null) goto L22;
        if (r8.isEmpty() == true) goto L22;
        com.ss.android.i.l.a r9 = r8.get(r4);     // Catch: Exception -> L46
        if (r9 == null) goto L22;
        if (r9.f11908g == true) goto L9;
    L22:
        r1.remove(r5);     // Catch: Exception -> L46
        goto L9
    L12:
        r1.remove(r5);
    L24:
        HashSet r10 = new HashSet();
        Iterator<Map<String, com.ss.android.i.l.a>> r11 = this.a0.a().f14831d.values().iterator();
    L26:
        if (r11.hasNext() == false) goto L44;
        Map<String, com.ss.android.i.l.a> r12 = r11.next();
        if (r12 == null) goto L26;
        if (r12.isEmpty() == true) goto L26;
        Iterator<String> r13 = r12.keySet().iterator();
    L34:
        if (r13.hasNext() == false) goto L26;
        String r14 = r13.next();
        com.ss.android.i.l.a r15 = r12.get(r14);
        if (r15 == null) goto L34;
        if (r15.f11908g == false) goto L34;
        JSONObject r16 = O(r15);
        if (r16 == null) goto L34;
        r1.putString(P(r14), r16.toString());
        r10.add(r14);
        goto L34
    L44:
        r1.putStringSet("store_key_saved_platform_app_id", r10);
        r1.apply();
    }

    private void k0() {
        if (this.l0 != null) goto L5;
        return;
    L5:
        if (com.ss.android.i.j.m() != null) goto L7;
        this.l0.sendEmptyMessageDelayed(1000, 600000);
        return;
    L7:
        com.ss.android.i.j.m().d();
        throw null;
    }

    private void r0(String r18, int r19, Bundle r20) {
        if (TextUtils.isEmpty(r18) == false) goto L5;
        return;
    L5:
        if (r19 == (-1)) goto L52;
        if (r20 != null) goto L8;
        return;
    L8:
        if (r20.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.Q.a().booleanValue() == true) goto L12;
        return;
    L12:
        if (this.a0.a() == null) goto L56;
        String r4 = String.valueOf(r19);
        Map<String, com.ss.android.i.l.a> r5 = this.a0.a().f14831d.get(r18);
        if (r5 != null) goto L17;
        r5 = new HashMap();
        this.a0.a().f14831d.put(r18, r5);
    L17:
        com.ss.android.i.l.a r6 = r5.get(r4);
        if (r6 != null) goto L20;
        r6 = new com.ss.android.i.l.a(r18);
        r6.q = r19;
        r6.f11908g = true;
        r6.p = this.H.a().longValue();
        r5.put(r4, r6);
    L20:
        com.ss.android.i.l.a r2 = this.a0.a().f14830c.get(r18);
        if (r2 != null) goto L24;
        this.a0.a().f14830c.put(r18, r6);
        r2 = r6;
    L24:
        if (r20.containsKey("access_token") == false) goto L27;
        String r1 = r20.getString("access_token", null);
        r2.r = r1;
        r6.r = r1;
    L27:
        if (r20.containsKey("expires_in") == false) goto L33;
        long r11 = r20.getLong("expires_in", 0);
        if (r11 == 0) goto L31;
        long r13 = System.currentTimeMillis() + (r11 * 1000);
    L32:
        r2.o = r11;
        r2.n = r13;
        r6.o = r11;
        r6.n = r13;
    L35:
        if (r20.containsKey("open_id") == false) goto L38;
        String r3 = r20.getString("open_id", null);
        r2.s = r3;
        r6.s = r3;
    L38:
        if (r20.containsKey("scopes") == false) goto L41;
        String r7 = r20.getString("scopes", null);
        r2.t = r7;
        r6.t = r7;
    L41:
        if (r20.containsKey(WsConstants.KEY_EXTRA) == false) goto L44;
        String r8 = r20.getString(WsConstants.KEY_EXTRA, null);
        r2.u = r8;
        r6.u = r8;
    L44:
        if (r20.containsKey("refresh_time") == false) goto L49;
        long r9 = r20.getLong("refresh_time", 0);
        long r10 = r6.n;
        if (r11 <= r9) goto L48;
        r10 = r10 - (1000 * r9);
    L48:
        r2.w = r9;
        r2.v = r10;
        r6.w = r9;
        r6.v = r10;
    L49:
        m0((HashMap) this.a0.a().f14830c);
        i0(this.k0.edit());
        j0();
        X("updatePlatformInfo");
        return;
    L31:
        r13 = 0;
        goto L32
    L33:
        r11 = 0;
        goto L35
    L56:
        return;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences y(Context r1, String r2, int r3) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r2, r3);
    }

    static /* synthetic */ void z(i r1, String r2, int r3, boolean r4) {
        r1.L(r2, r3, r4);
    }

    public com.ss.android.i.e M() {
        com.ss.android.i.e r1 = new com.ss.android.i.e(this.e0.a());
        r1.f14828a = this.H.a().longValue();
        r1.f14829b = this.I.a().intValue();
        r1.f14834g = this.P.a().booleanValue();
        r1.f14835h = this.M.a();
        r1.t = this.x.a();
        r1.P = this.p.a().intValue();
        r1.w = this.y.a();
        r1.x = this.L.a();
        r1.v = this.f5553j.a();
        r1.S = this.f5555l.a();
        r1.R = this.K.a().booleanValue();
        r1.T = this.f5552i.a();
        r1.U = this.q.a();
        r1.D = this.G.a();
        r1.u = this.n.a();
        r1.B = this.t.a().booleanValue();
        r1.C = this.z.a();
        r1.F = this.m.a().intValue();
        r1.G = this.A.a().intValue();
        r1.N = this.f5554k.a();
        this.W.a().intValue();
        this.X.a().intValue();
        this.Y.a().intValue();
        r1.M = this.v.a().longValue();
        r1.f14837j = this.o.a();
        r1.E = this.F.a();
        r1.O = this.V.a().intValue();
        r1.I = this.C.a().intValue();
        r1.H = this.B.a().intValue();
        r1.W = this.r.a().intValue();
        r1.V = this.s.a().intValue();
        r1.X = this.u.a().booleanValue();
        this.R.a().booleanValue();
        r1.z = this.T.a();
        r1.y = this.v.a().longValue();
        r1.A = this.U.a();
        r1.f14833f = this.O.a().intValue();
        r1.f14838k = this.f5548J.a();
        r1.m = this.Z.a().booleanValue();
        r1.n = this.c0.a().booleanValue();
        r1.a0 = this.d0.a();
        com.ss.android.i.l.a[] r2 = this.f0.a();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L12;
        com.ss.android.i.l.a r5 = r2[r4];
        if (TextUtils.isEmpty(r5.f11907f) == true) goto L11;
        if (r5.f11908g == false) goto L11;
        r1.d().put(r5.f11907f, r5);
    L11:
        r4 = r4 + 1;
        goto L3
    L12:
        r1.b0 = this.i0.a().intValue();
        r1.c0 = this.h0.a().booleanValue();
        return r1;
    }

    Handler N() {
        return this.l0;
    }

    String P(@NonNull String r2) {
        return "_platform_" + r2;
    }

    public void Q(com.bytedance.sdk.account.impl.o<T> r2) {
        T r1 = r2.f5628b;
        if (r1 == null) goto L6;
        R(r1, r2);
        T(r2);
        return;
    }

    @Override // d.b.s.a.q.f
    public d.b.s.a.k0.a a() {
        return this.a0.a();
    }

    @Override // d.b.s.a.q.f
    public void b(d.b.s.a.q.c r4) {
        if (r4 != null) goto L5;
        d.b.s.a.a0.a.b("BDAccountManager", "addListener(), listener is null, " + Log.getStackTraceString(new Throwable()));
        return;
    L5:
        d.b.s.a.a0.a.d("BDAccountManager", "addListener(), " + r4.getClass().getName());
        Set<d.b.s.a.q.c> r1 = this.m0;
        monitor-enter(r1);
        this.m0.add(r4);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // d.b.s.a.q.f
    public void c(String r1) {
        com.bytedance.sdk.account.impl.p.c(this).h(r1);
    }

    @Override // d.b.s.a.q.f
    public void d() {
        this.E.c("");
    }

    public void d0(d.b.s.a.k0.a r14, boolean r15, boolean r16, Map<String, String> r17, d.b.s.a.q.j.b r18) {
        Boolean r2 = Boolean.TRUE;
        if (r14 != null) goto L5;
        return;
    L5:
        long r3 = r14.o();
        int r5 = r14.h();
        boolean r6 = false;
        boolean r7 = true;
        if (r5 != 0) goto L8;
    L10:
        boolean r8 = false;
    L12:
        if (r3 <= 0) goto L14;
        this.a0.c(r14);
        if (this.Q.a().booleanValue() == true) goto L24;
        this.Q.c(r2);
        d.b.s.a.l0.s.b();
        r8 = true;
    L24:
        if (r14.f14834g == false) goto L27;
        this.P.c(r2);
    L27:
        if (this.H.a().longValue() == r3) goto L30;
        this.H.c(Long.valueOf(r3));
        r8 = true;
        r6 = true;
    L30:
        if (com.bytedance.common.utility.k.b(this.f5548J.a(), r14.f14838k) == true) goto L33;
        this.f5548J.c(r14.f14838k);
        d.b.s.a.f0.b.d(this.j0, r14.o() + "", r14.k(), null);
        r8 = true;
    L33:
        if (com.bytedance.common.utility.k.b(this.M.a(), r14.l()) == true) goto L36;
        this.M.c(r14.l());
        r8 = true;
        r6 = true;
    L36:
        if (com.bytedance.common.utility.k.b(this.w.a(), r14.g()) == true) goto L39;
        this.w.c(r14.g());
        r8 = true;
    L39:
        if (com.bytedance.common.utility.k.b(this.o.a(), r14.f()) == true) goto L41;
        this.o.c(r14.f());
        r8 = true;
    L41:
        boolean r4 = this.R.a().booleanValue();
        boolean r9 = r14.f14839l;
        if (r4 == r9) goto L44;
        this.R.c(Boolean.valueOf(r9));
        r8 = true;
    L44:
        int r10 = this.O.a().intValue();
        int r11 = r14.f14833f;
        if (r10 == r11) goto L47;
        this.O.c(Integer.valueOf(r11));
        r8 = true;
    L47:
        boolean r12 = this.Z.a().booleanValue();
        boolean r13 = r14.m;
        if (r12 == r13) goto L50;
        this.Z.c(Boolean.valueOf(r13));
        r8 = true;
    L50:
        boolean r19 = this.c0.a().booleanValue();
        boolean r20 = r14.n;
        if (r19 == r20) goto L54;
        this.c0.c(Boolean.valueOf(r20));
        r8 = true;
    L54:
        if (e0(r14) == false) goto L57;
        r8 = true;
    L57:
        if (this.e0.a() != null) goto L59;
    L70:
        this.e0.c(r14.j());
        if ((r14 instanceof com.ss.android.i.e) == false) goto L171;
        com.ss.android.i.e r21 = (com.ss.android.i.e) r14;
        if (com.bytedance.common.utility.k.b(this.x.a(), r21.t) == true) goto L76;
        this.x.c(r21.t);
        r8 = true;
    L76:
        if (com.bytedance.common.utility.k.b(this.y.a(), r21.w) == true) goto L79;
        this.y.c(r21.w);
        r8 = true;
    L79:
        if (com.bytedance.common.utility.k.b(this.L.a(), r21.x) == true) goto L81;
        this.L.c(r21.x);
        r8 = true;
    L81:
        int r22 = this.p.a().intValue();
        int r23 = r21.P;
        if (r22 == r23) goto L85;
        this.p.c(Integer.valueOf(r23));
        r8 = true;
    L85:
        if (com.bytedance.common.utility.k.b(this.n.a(), r21.u) == true) goto L88;
        this.n.c(r21.u);
        r8 = true;
    L88:
        if (com.bytedance.common.utility.k.b(this.f5553j.a(), r21.v) == true) goto L90;
        this.f5553j.c(r21.v);
        r8 = true;
    L90:
        boolean r24 = this.K.a().booleanValue();
        boolean r25 = r21.R;
        if (r24 == r25) goto L94;
        this.K.c(Boolean.valueOf(r25));
        r8 = true;
    L94:
        if (com.bytedance.common.utility.k.b(this.f5555l.a(), r21.S) == true) goto L97;
        this.f5555l.c(r21.S);
        r8 = true;
    L97:
        if (com.bytedance.common.utility.k.b(this.f5552i.a(), r21.T) == true) goto L100;
        this.f5552i.c(r21.T);
        r8 = true;
    L100:
        if (com.bytedance.common.utility.k.b(this.q.a(), r21.U) == true) goto L102;
        this.q.c(r21.U);
        r8 = true;
    L102:
        boolean r26 = this.u.a().booleanValue();
        boolean r27 = r21.X;
        if (r26 == r27) goto L105;
        this.u.c(Boolean.valueOf(r27));
        r8 = true;
    L105:
        int r28 = this.s.a().intValue();
        int r29 = r21.V;
        if (r28 == r29) goto L108;
        this.s.c(Integer.valueOf(r29));
        r8 = true;
    L108:
        int r30 = this.r.a().intValue();
        int r31 = r21.W;
        if (r30 == r31) goto L111;
        this.r.c(Integer.valueOf(r31));
        r8 = true;
    L111:
        boolean r32 = this.t.a().booleanValue();
        boolean r33 = r21.B;
        if (r32 == r33) goto L115;
        this.t.c(Boolean.valueOf(r33));
        r8 = true;
    L115:
        if (com.bytedance.common.utility.k.b(this.z.a(), r21.C) == true) goto L117;
        this.z.c(r21.C);
        r8 = true;
    L117:
        int r34 = this.m.a().intValue();
        int r35 = r21.F;
        if (r34 == r35) goto L120;
        this.m.c(Integer.valueOf(r35));
        r8 = true;
    L120:
        int r36 = this.B.a().intValue();
        int r37 = r21.H;
        if (r36 == r37) goto L123;
        this.B.c(Integer.valueOf(r37));
        r8 = true;
    L123:
        int r38 = this.C.a().intValue();
        int r39 = r21.I;
        if (r38 == r39) goto L126;
        this.C.c(Integer.valueOf(r39));
        r8 = true;
    L126:
        int r40 = this.A.a().intValue();
        int r41 = r21.G;
        if (r40 == r41) goto L130;
        this.A.c(Integer.valueOf(r41));
        r8 = true;
    L130:
        if (com.bytedance.common.utility.k.b(this.G.a(), r21.D) == true) goto L132;
        this.G.c(r21.D);
        r8 = true;
    L132:
        long r42 = this.v.a().longValue();
        long r110 = r21.M;
        if (r42 == r110) goto L136;
        this.v.c(Long.valueOf(r110));
        r8 = true;
    L136:
        if (com.bytedance.common.utility.k.b(this.T.a(), r21.z) == true) goto L139;
        this.T.c(r21.z);
        r8 = true;
    L139:
        if (com.bytedance.common.utility.k.b(this.U.a(), r21.A) == true) goto L141;
        this.U.c(r21.A);
        r8 = true;
    L141:
        long r43 = this.S.a().longValue();
        long r111 = r21.y;
        if (r43 == r111) goto L145;
        this.S.c(Long.valueOf(r111));
        r8 = true;
    L145:
        if (TextUtils.isEmpty(this.f5554k.a()) == true) goto L151;
        if (TextUtils.isEmpty(r21.N) == true) goto L151;
        if (com.bytedance.common.utility.k.b(this.f5554k.a(), r21.N) == true) goto L151;
    L158:
        this.f5554k.c(r21.N);
        r8 = true;
    L159:
        int r44 = this.V.a().intValue();
        int r45 = r21.O;
        if (r44 == r45) goto L163;
        this.V.c(Integer.valueOf(r45));
        r8 = true;
    L163:
        if (com.bytedance.common.utility.k.b(this.F.a(), r21.E) == true) goto L165;
        this.F.c(r21.E);
        r8 = true;
    L165:
        this.d0.c(r21.a0);
        int r46 = this.i0.a().intValue();
        int r47 = r21.b0;
        if (r46 == r47) goto L168;
        this.i0.c(Integer.valueOf(r47));
        r8 = true;
    L168:
        boolean r48 = this.h0.a().booleanValue();
        boolean r49 = r21.c0;
        if (r48 == r49) goto L171;
        this.h0.c(Boolean.valueOf(r49));
        r8 = true;
    L151:
        if (TextUtils.isEmpty(this.f5554k.a()) == false) goto L155;
        if (TextUtils.isEmpty(r21.N) == false) goto L158;
    L155:
        if (TextUtils.isEmpty(this.f5554k.a()) == true) goto L159;
        if (TextUtils.isEmpty(r21.N) == false) goto L159;
    L171:
        this.Q.c(r2);
        boolean r50 = r6;
        r6 = true;
        r7 = r8;
    L172:
        if (r7 == false) goto L174;
        f0();
    L174:
        if (r7 == true) goto L176;
        if (r16 == true) goto L176;
    L178:
        if (r7 == false) goto L182;
        d.b.s.a.f0.g.c r1 = d.b.s.a.f0.b.b(r14);
        if (r1 == null) goto L182;
        d.b.s.a.f0.b.c(r1, new z0(this));
    L182:
        if (r50 == false) goto L189;
        l0(this.H.a().longValue(), getSessionKey());
        n0("");
        return;
    L189:
        return;
    L176:
        if (r15 == false) goto L178;
        a0(r6, r14.j(), r17, r18);
        goto L178
    L59:
        if (r14.i() == null) goto L70;
        JSONObject r51 = this.e0.a().optJSONObject("data");
        JSONObject r52 = r14.i();
        List<String> r53 = this.f5550g;
        if (r53 == null) goto L70;
        if (r51 == null) goto L70;
        if (r52 == null) goto L70;
        Iterator<String> r54 = r53.iterator();
    L66:
        if (r54.hasNext() == false) goto L70;
        String r55 = r54.next();
        if (d.b.s.a.l0.s.a(r51.opt(r55), r52.opt(r55)) == true) goto L66;
        r8 = true;
        goto L70
    L14:
        if (this.Q.a().booleanValue() == false) goto L18;
        d.b.s.a.l0.j<Boolean> r56 = this.P;
        Boolean r57 = Boolean.FALSE;
        r56.c(r57);
        this.Q.c(r57);
        this.H.c(0L);
        this.f5548J.c("");
        this.I.c(0);
        this.x.c("");
        this.p.c(0);
        this.y.c("");
        this.L.c("");
        this.f5553j.c("");
        this.f5555l.c("");
        this.f5552i.c("");
        this.q.c("");
        this.G.c("");
        this.n.c("");
        this.K.c(r57);
        this.t.c(r57);
        this.M.c("");
        this.W.c(0);
        this.X.c(0);
        this.Y.c(0);
        this.r.c(0);
        this.s.c(0);
        this.u.c(r57);
        this.R.c(r57);
        this.v.c(0L);
        this.f5554k.c("");
        this.V.c(0);
        this.T.c("");
        this.S.c(0L);
        this.U.c("");
        this.F.c("");
        this.Z.c(r57);
        this.i0.c(0);
        this.h0.c(r57);
        this.e0.c(null);
        this.d0.c(null);
        this.a0.c(null);
        com.ss.android.i.l.a[] r58 = this.f0.a();
        int r59 = r58.length;
        int r60 = 0;
    L16:
        if (r60 >= r59) goto L19;
        r58[r60].f();
        r60 = r60 + 1;
    L19:
        r50 = false;
        goto L172
    L18:
        r7 = r8;
        goto L19
    L8:
        if (r5 == this.I.a().intValue()) goto L10;
        this.I.c(Integer.valueOf(r5));
        r8 = true;
        goto L12
    }

    @Override // d.b.s.a.q.f
    public String e() {
        return this.x.a();
    }

    @Override // d.b.s.a.q.f
    public int f() {
        return this.O.a().intValue();
    }

    public void f0() {
        SharedPreferences.Editor r1 = this.k0.edit();
        i0(r1);
        j0();
        r1.remove("session");
        r1.putBoolean("is_login", this.Q.a().booleanValue());
        r1.putLong("user_id", this.H.a().longValue());
        r1.putInt("odin_user_type", this.I.a().intValue());
        r1.putString("sec_user_id", this.f5548J.a());
        r1.putString("session_key", this.M.a());
        r1.putString("session_sign", this.N.a());
        r1.putString("user_name", this.x.a());
        r1.putString("verified_content", this.L.a());
        r1.putInt("user_gender", this.p.a().intValue());
        r1.putString("screen_name", this.y.a());
        r1.putBoolean("user_verified", this.K.a().booleanValue());
        r1.putString("avatar_url", this.f5553j.a());
        r1.putBoolean("is_new_user", this.P.a().booleanValue());
        r1.putString("user_email", this.o.a());
        r1.putString("user_mobile", this.w.a());
        r1.putInt("is_blocked", this.r.a().intValue());
        r1.putInt("is_blocking", this.s.a().intValue());
        r1.putBoolean("is_toutiao", this.u.a().booleanValue());
        r1.putBoolean("user_has_pwd", this.R.a().booleanValue());
        r1.putInt("country_code", this.O.a().intValue());
        r1.putString("area", this.f5552i.a());
        r1.putString("user_industry", this.q.a());
        r1.putString("user_decoration", this.G.a());
        r1.putString("user_birthday", this.f5555l.a());
        r1.putLong("pgc_mediaid", this.S.a().longValue());
        r1.putString("pgc_avatar_url", this.T.a());
        r1.putString("pgc_name", this.U.a());
        r1.putString("user_description", this.n.a());
        r1.putBoolean("is_recommend_allowed", this.t.a().booleanValue());
        r1.putString("recommend_hint_message", this.z.a());
        r1.putInt("can_be_found_by_phone", this.m.a().intValue());
        r1.putInt("can_sync_share", this.A.a().intValue());
        r1.putInt("following_count", this.W.a().intValue());
        r1.putInt("followers_count", this.X.a().intValue());
        r1.putInt("visitors_count", this.Y.a().intValue());
        r1.putLong("media_id", this.v.a().longValue());
        r1.putString("bg_img_url", this.f5554k.a());
        r1.putInt("display_ocr_entrance", this.V.a().intValue());
        r1.putString("user_auth_info", this.F.a());
        r1.putInt("user_privacy_extend", this.B.a().intValue());
        r1.putInt("user_privacy_extend_value", this.C.a().intValue());
        r1.putBoolean("is_visitor_account", this.Z.a().booleanValue());
        r1.putBoolean("is_kids_mode", this.c0.a().booleanValue());
        h0(r1);
        if (this.d0.a() != null) goto L5;
        r1.putString("expend_attrs", "");
    L6:
        r1.putBoolean("use_hm_region", this.h0.a().booleanValue());
        r1.putInt("hm_region", this.i0.a().intValue());
        if (this.e0.a() != null) goto L9;
        r1.putString("raw_json", "");
    L10:
        com.bytedance.common.utility.o.a.a(r1);
        X("saveData");
        return;
    L9:
        r1.putString("raw_json", this.e0.a().toString());
        goto L10
    L5:
        r1.putString("expend_attrs", this.d0.toString());
        goto L6
    }

    @Override // d.b.s.a.q.f
    public int g() {
        return this.I.a().intValue();
    }

    @Override // d.b.s.a.q.f
    public String getSessionKey() {
        if (com.bytedance.sdk.account.settings.f.a.p() == false) goto L7;
        d.b.s.a.l0.j<String> r1 = this.g0;
    L6:
        return r1.a();
    L7:
        r1 = this.M;
        goto L6
    }

    @Override // d.b.s.a.q.f
    public long getUserId() {
        return this.H.a().longValue();
    }

    @Override // d.b.s.a.q.f
    public void h(d.b.s.a.q.c r4) {
        if (r4 == null) goto L4;
        d.b.s.a.a0.a.d("BDAccountManager", "removeListener(), " + r4.getClass().getName());
    L4:
        Set<d.b.s.a.q.c> r1 = this.m0;
        monitor-enter(r1);
        this.m0.remove(r4);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r3) {
        if (r3.what != 100) goto L8;
        Object r1 = r3.obj;
        if ((r1 instanceof com.bytedance.sdk.account.impl.o) == false) goto L8;
        Q((com.bytedance.sdk.account.impl.o) r1);
    L8:
        if (r3.what != 1000) goto L11;
        this.l0.removeMessages(1000);
        p0("polling");
        return;
    }

    @Override // d.b.s.a.q.f
    public void i() {
        this.D.c("");
        this.k0.edit().putString("multi_sids", "").apply();
    }

    @Override // d.b.s.a.q.f
    public String j() {
        return this.w.a();
    }

    @Override // d.b.s.a.q.f
    public String k() {
        return this.f5548J.a();
    }

    @Override // d.b.s.a.q.f
    public void l(d.b.s.a.q.b r3) {
        Set<d.b.s.a.q.c> r1 = this.m0;
        monitor-enter(r1);
        Iterator<d.b.s.a.q.c> r2 = this.m0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L10;
        d.b.s.a.q.c r4 = r2.next();     // Catch: Throwable -> L12
        if (r4 == null) goto L6;
        r4.F(r3);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void l0(long r1, String r3) {
        d.b.s.a.l0.h r2 = com.ss.android.i.j.k().b();     // Catch: Exception -> L6
        if (r2 == null) goto L9;
        r2.a(r1, r3);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    @Override // d.b.s.a.q.f
    public boolean m() {
        return this.Q.a().booleanValue();
    }

    public void m0(HashMap<String, com.ss.android.i.l.a> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L19;
        com.ss.android.i.l.a[] r7 = this.f0.a();
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L20;
        com.ss.android.i.l.a r3 = r7[r2];
        r3.f11908g = false;
        com.ss.android.i.l.a r4 = r8.get(r3.f11907f);
        if (r4 != null) goto L11;
        r3.f();
    L14:
        r2 = r2 + 1;
        goto L6
    L11:
        if (r3.f11908g == true) goto L13;
        r3.f11908g = true;
    L13:
        r3.q = r4.q;
        r3.n = r4.n;
        r3.o = r4.o;
        r3.f11909h = r4.f11909h;
        r3.f11910i = r4.f11910i;
        r3.f11911j = r4.f11911j;
        r3.p = r4.p;
        r3.m = r4.m;
        r3.r = r4.r;
        r3.s = r4.s;
        r3.t = r4.t;
        r3.w = r4.w;
        r3.v = r4.v;
        r3.u = r4.u;
        goto L14
    L20:
        return;
    }

    @Override // d.b.s.a.q.f
    public String n() {
        return this.o.a();
    }

    public boolean n0(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L8;
        this.f5551h = "";
        String r5 = "setVerifyPortraitFlag empty";
    L5:
        d.b.s.a.a0.a.d("BDAccountManager", r5);
        return true;
    L8:
        if (r6.contains(".") == false) goto L11;
        d.b.s.a.a0.a.d("BDAccountManager", "verify portrait flag contains '.'");
        return false;
    L11:
        this.f5551h = UUID.randomUUID() + "." + r6;
        StringBuilder r7 = new StringBuilder();
        r7.append("setVerifyPortraitFlag ");
        r7.append(this.f5551h);
        r5 = r7.toString();
        goto L5
    }

    @Override // d.b.s.a.q.f
    public String o() {
        return this.f5551h;
    }

    public void o0(String r2) {
        this.N.c(r2);
        this.k0.edit().putString("session_sign", r2).apply();
    }

    @Override // d.b.s.a.q.f
    public String p() {
        return this.f5553j.a();
    }

    public void p0(String r3) {
        if (m() == true) goto L7;
        k0();
        return;
    L7:
        if (this.f5549f.a() == null) goto L10;
        this.f5549f.a().d(r3, new y0(this));
        return;
    }

    @Override // d.b.s.a.q.f
    public String q() {
        return this.E.a();
    }

    public void q0(String r2) {
        this.D.c(r2);
        this.k0.edit().putString("multi_sids", r2).apply();
    }

    @Override // d.b.s.a.q.f
    public int r() {
        return this.p.a().intValue();
    }

    @Override // d.b.s.a.q.f
    public void s(String r3) {
        if (this.b0.a() != null) goto L5;
        this.b0.c(new HashSet());
    L5:
        this.b0.a().add(r3);
        this.k0.edit().putStringSet("has_update_sec_uids", this.b0.a()).apply();
    }

    public void s0(String r1) {
        this.E.c(r1);
    }

    @Override // d.b.s.a.q.f
    public boolean t() {
        return this.R.a().booleanValue();
    }

    @Override // d.b.s.a.q.f
    public void u(d.b.s.a.k0.a r7, boolean r8) {
        d0(r7, r8, false, null, null);
    }

    @Override // d.b.s.a.q.f
    public String v() {
        return this.D.a();
    }

    @Override // d.b.s.a.q.f
    public String w() {
        return this.y.a();
    }

    @Override // d.b.s.a.q.f
    public void x(boolean r9) {
        Boolean r1 = Boolean.FALSE;
        d.b.s.a.a0.a.d("BDAccountManager", "invalidateSession(), isLogin=" + this.Q.a() + " notifyListeners=" + r9);
        if (this.Q.a().booleanValue() == false) goto L15;
        this.P.c(r1);
        this.Q.c(r1);
        this.H.c(0L);
        this.M.c("");
        this.I.c(0);
        this.N.c("");
        this.f5548J.c("");
        l0(this.H.a().longValue(), "");
        this.x.c("");
        this.p.c(0);
        this.y.c("");
        this.L.c("");
        this.n.c("");
        this.f5552i.c("");
        this.q.c("");
        this.r.c(0);
        this.s.c(0);
        this.G.c("");
        this.f5555l.c("");
        this.K.c(r1);
        this.t.c(r1);
        this.u.c(r1);
        this.O.c(0);
        this.W.c(0);
        this.X.c(0);
        this.Y.c(0);
        this.R.c(r1);
        this.v.c(0L);
        this.f5554k.c("");
        this.o.c("");
        this.w.c("");
        this.V.c(0);
        this.T.c("");
        this.S.c(0L);
        this.U.c("");
        this.F.c("");
        this.Z.c(r1);
        com.ss.android.i.l.a[] r2 = this.f0.a();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        r2[r4].f();
        r4 = r4 + 1;
        goto L5
    L7:
        Iterator<Map<String, com.ss.android.i.l.a>> r5 = this.a0.a().f14831d.values().iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        Iterator<com.ss.android.i.l.a> r6 = r5.next().values().iterator();
    L12:
        if (r6.hasNext() == false) goto L9;
        r6.next().f();
        goto L12
    L14:
        this.i0.c(0);
        this.h0.c(r1);
        f0();
        this.g0.c("");
        g0();
    L15:
        if (r9 == false) goto L21;
        b0();
        return;
    }
}
