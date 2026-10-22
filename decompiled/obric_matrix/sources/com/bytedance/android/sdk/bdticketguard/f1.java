package com.bytedance.android.sdk.bdticketguard;

import android.os.Build;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.Gson;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class f1 implements k1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l[] f723d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.h f724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c1 f725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f726c;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f1 f727f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a f728g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p f729h;

        a(f1 r1, kotlin.n0.c.a r2, kotlin.n0.c.p r3) {
            this.f727f = r1;
            this.f728g = r2;
            this.f729h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            s0 r0 = s0.f1065a;
            r0.a("TicketGuardManager", "commonInit thread start");
            if (f1.p(this.f727f).compareAndSet(false, true) == false) goto L5;
            r0.a("TicketGuardManager", "commonInit init ttnet and monitor launch");
            f1.q(this.f727f);
            z0.P();
        L5:
            this.f728g.invoke();
            this.f727f.H(this.f729h);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f1 f730f;

        b(f1 r1) {
            this.f730f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f730f.O("ticket_network", null);
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f1 f731f;

        c(f1 r1) {
            this.f731f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f731f.N("ticket_network", null);
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f1 f732f;

        d(f1 r1) {
            this.f732f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f732f.M("ticket_network", null);
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f733f = null;

        static {
            f733f = new e();
        }

        e() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    static final class f extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f734f = null;

        static {
            f734f = new f();
        }

        f() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            s0.f1065a.a("TicketGuardManager", "getProviderHeaders: fail");
        }
    }

    static final class g extends kotlin.n0.d.q implements kotlin.n0.c.a<Gson> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final g f735f = null;

        static {
            f735f = new g();
        }

        g() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Gson invoke() {
            com.google.gson.e r0 = new com.google.gson.e();
            r0.e();
            return r0.d();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Gson invoke() {
            return invoke();
        }
    }

    static final class h extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f736f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f1 f737g;

        h(kotlin.n0.d.d0 r1, f1 r2, com.bytedance.android.sdk.bdticketguard.r r3) {
            this.f736f = r1;
            this.f737g = r2;
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(String r2, String r3) {
            kotlin.n0.d.o.g(r2, "header");
            kotlin.n0.d.o.g(r3, "value");
            this.f736f.f18431f = r3;
            if (g1.a().contains((String) this.f736f.f18431f) == false) goto L6;
            this.f737g.U("verify result " + ((String) this.f736f.f18431f));
            return;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class i extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f1 f738f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.r f739g;

        i(f1 r1, com.bytedance.android.sdk.bdticketguard.r r2) {
            this.f738f = r1;
            this.f739g = r2;
            super(2);
        }

        public final void a(String r2, String r3) {
            kotlin.n0.d.o.g(r2, "header");
            kotlin.n0.d.o.g(r3, "value");
            if (kotlin.n0.d.o.a(kotlin.u0.k.G0(r3).toString(), LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L6;
            this.f738f.K(this.f739g.a().b().b());
            return;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class j extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f740f;

        j(kotlin.n0.d.d0 r1) {
            this.f740f = r1;
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(String r2, String r3) {
            kotlin.n0.d.o.g(r2, "header");
            kotlin.n0.d.o.g(r3, "value");
            this.f740f.f18431f = r3;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class k extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f741f;

        k(kotlin.n0.d.d0 r1) {
            this.f741f = r1;
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(String r2, String r3) {
            kotlin.n0.d.o.g(r2, "header");
            kotlin.n0.d.o.g(r3, "value");
            this.f741f.f18431f = r3;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class l extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f742f;

        l(kotlin.n0.d.d0 r1) {
            this.f742f = r1;
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(String r2, String r3) {
            kotlin.n0.d.o.g(r2, "header");
            kotlin.n0.d.o.g(r3, "value");
            this.f742f.f18431f = r3;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class m extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f1 f743f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f744g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f745h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f746i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f747j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f748k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f749l;
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.s m;
        final /* synthetic */ ArrayList n;

        m(f1 r1, kotlin.n0.d.d0 r2, kotlin.n0.d.d0 r3, boolean r4, kotlin.n0.d.d0 r5, kotlin.n0.d.d0 r6, String r7, com.bytedance.android.sdk.bdticketguard.s r8, ArrayList r9) {
            this.f743f = r1;
            this.f744g = r2;
            this.f745h = r3;
            this.f746i = r4;
            this.f747j = r5;
            this.f748k = r6;
            this.f749l = r7;
            this.m = r8;
            this.n = r9;
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v7, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v26, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v4, types: [T, com.bytedance.android.sdk.bdticketguard.m0] */
        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.String] */
        public final void a(String r18, String r19) {
            kotlin.n0.d.o.g(r18, "header");
            kotlin.n0.d.o.g(r19, "value");
            kotlin.n0.d.d0 r2 = this.f744g;
            Charset r3 = kotlin.u0.d.f21429a;
            byte[] r1 = r19.getBytes(r3);
            kotlin.n0.d.o.b(r1, "(this as java.lang.String).getBytes(charset)");
            int r5 = 0;
            byte[] r4 = Base64.decode(r1, 0);
            kotlin.n0.d.o.b(r4, "Base64.decode(value.toByteArray(), Base64.DEFAULT)");
            r2.f18431f = new String(r4, r3);
            this.f745h.f18431f = this.f743f.Q((String) this.f744g.f18431f);
            T r6 = this.f745h.f18431f;
            if ((((m0) r6) instanceof n0) == false) goto L28;
            m0 r7 = (m0) r6;
            if (r7 == null) goto L26;
            n0 r8 = (n0) r7;
            if (this.f746i == false) goto L17;
            this.f747j.f18431f = r8.a();
            if (((String) this.f747j.f18431f).length() <= 0) goto L11;
            r5 = 1;
        L11:
            if (r5 == 0) goto L17;
            String r9 = (String) this.f747j.f18431f;
            if (r9 == null) goto L16;
            byte[] r10 = r9.getBytes(r3);
            kotlin.n0.d.o.b(r10, "(this as java.lang.String).getBytes(charset)");
            this.f748k.f18431f = Base64.encodeToString(r10, 2);
            this.f743f.c((String) this.f747j.f18431f, null);
            goto L17
        L16:
            throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
        L17:
            String r11 = this.f749l + '_' + this.m.e();
            if (r11 == null) goto L24;
            byte[] r12 = r11.getBytes(r3);
            kotlin.n0.d.o.b(r12, "(this as java.lang.String).getBytes(charset)");
            String r13 = Base64.encodeToString(r12, 2);
            kotlin.n0.d.o.b(r13, "saveTypeKey");
            w0 r14 = new w0(r13, r8.b(), r8.c(), null, (String) this.f748k.f18431f);
            if (this.m.d() == false) goto L22;
            this.f743f.X(r14);
        L22:
            this.n.add(r14.f());
            return;
        L24:
            throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
        L26:
            throw new kotlin.b0("null cannot be cast to non-null type com.bytedance.android.sdk.bdticketguard.ServerDataV1");
        L28:
            if ((((m0) r6) instanceof o0) == false) goto L50;
            m0 r15 = (m0) r6;
            if (r15 == null) goto L44;
            ArrayList<o0.a> r16 = ((o0) r15).a();
            if (r16 == null) goto L51;
            int r17 = r16.size();
        L34:
            if (r5 >= r17) goto L52;
            o0.a r20 = r16.get(r5);
            kotlin.n0.d.o.b(r20, "it[i]");
            o0.a r21 = r20;
            String r110 = this.f749l + '_' + this.m.e() + '_' + r5;
            Charset r111 = kotlin.u0.d.f21429a;
            if (r110 == null) goto L42;
            byte[] r112 = r110.getBytes(r111);
            kotlin.n0.d.o.b(r112, "(this as java.lang.String).getBytes(charset)");
            String r113 = Base64.encodeToString(r112, 2);
            kotlin.n0.d.o.b(r113, "saveTypeKey");
            w0 r114 = new w0(r113, r21.a(), r21.b(), r21.c(), null);
            if (this.m.d() == false) goto L40;
            this.f743f.X(r114);
        L40:
            this.n.add(r114.f());
            r5 = r5 + 1;
            goto L34
        L42:
            throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
        L52:
            return;
        L51:
            return;
        L44:
            throw new kotlin.b0("null cannot be cast to non-null type com.bytedance.android.sdk.bdticketguard.ServerDataV2");
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class n extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f1 f750f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f751g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f752h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f753i;

        n(f1 r1, boolean r2, kotlin.n0.d.d0 r3, kotlin.n0.d.d0 r4) {
            this.f750f = r1;
            this.f751g = r2;
            this.f752h = r3;
            this.f753i = r4;
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
        public final void a(String r3, String r4) {
            kotlin.n0.d.o.g(r3, "header");
            kotlin.n0.d.o.g(r4, "value");
            if (this.f751g == true) goto L5;
            return;
        L5:
            if (r4.length() != 0) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            this.f752h.f18431f = r4;
            kotlin.n0.d.d0 r6 = this.f753i;
            byte[] r7 = Base64.decode(r4, 0);
            kotlin.n0.d.o.b(r7, "Base64.decode(currentCert, Base64.DEFAULT)");
            r6.f18431f = new String(r7, kotlin.u0.d.f21429a);
            this.f750f.c((String) this.f753i.f18431f, null);
            return;
        L12:
            return;
        L7:
            r5 = false;
            goto L8
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class o extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f1 f754f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.a0 f755g;

        o(f1 r1, kotlin.n0.d.a0 r2) {
            this.f754f = r1;
            this.f755g = r2;
            super(2);
        }

        public final void a(String r3, String r4) {
            kotlin.n0.d.o.g(r3, "header");
            kotlin.n0.d.o.g(r4, "value");
            kotlin.n0.d.a0 r5 = this.f755g;
            if (r4.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            r5.f18427f = r0;
            f1 r2 = this.f754f;
            byte[] r6 = Base64.decode(r4, 0);
            kotlin.n0.d.o.b(r6, "Base64.decode(value, Base64.DEFAULT)");
            r2.c(null, new String(r6, kotlin.u0.d.f21429a));
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class p extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f756f;

        p(kotlin.n0.d.d0 r1) {
            this.f756f = r1;
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(String r2, String r3) {
            kotlin.n0.d.o.g(r2, "header");
            kotlin.n0.d.o.g(r3, "value");
            this.f756f.f18431f = r3;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    public static final class q implements com.bytedance.android.sdk.bdticketguard.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f1 f757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.p f758b;

        q(f1 r1, com.bytedance.android.sdk.bdticketguard.p r2) {
            this.f757a = r1;
            this.f758b = r2;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.p
        public void a(String r2, String r3) {
            this.f757a.c(r2, r3);
            com.bytedance.android.sdk.bdticketguard.p r1 = this.f758b;
            if (r1 == null) goto L6;
            r1.a(r2, r3);
            return;
        }
    }

    static final class r extends kotlin.n0.d.q implements kotlin.n0.c.l<c1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final r f759f = null;

        static {
            f759f = new r();
        }

        r() {
            super(1);
        }

        public final boolean a(c1 r4) {
            kotlin.n0.d.o.g(r4, "$this$isAccountParam");
            String r3 = r4.getClass().getName();
            kotlin.n0.d.o.b(r3, "this@isAccountParam.javaClass.name");
            return kotlin.u0.k.A(r3, "com.bytedance.sdk.account.ticketguard", false, 2, null);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(c1 r1) {
            return Boolean.valueOf(a(r1));
        }
    }

    static final class s extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final s f760f = null;

        static {
            f760f = new s();
        }

        s() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    static final class t extends kotlin.n0.d.q implements kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f1 f761f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f762g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l f763h;

        t(f1 r1, AtomicInteger r2, kotlin.n0.c.l r3) {
            this.f761f = r1;
            this.f762g = r2;
            this.f763h = r3;
            super(2);
        }

        public final void a(com.bytedance.android.sdk.bdticketguard.n1.b r4, com.bytedance.android.sdk.bdticketguard.n1.c.f r5) {
            kotlin.n0.d.o.g(r4, "initTask");
            kotlin.n0.d.o.g(r5, "initResult");
            if (this.f762g.addAndGet(1) != com.bytedance.android.sdk.bdticketguard.n1.b.values().length) goto L20;
            com.bytedance.android.sdk.bdticketguard.n1.b[] r6 = com.bytedance.android.sdk.bdticketguard.n1.b.values();
            int r7 = r6.length;
            int r0 = 0;
        L5:
            if (r0 >= r7) goto L13;
            com.bytedance.android.sdk.bdticketguard.n1.b r1 = r6[r0];
            if (kotlin.n0.d.o.a(this.f761f.y(r1), com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b) == true) goto L8;
            r0 = r0 + 1;
            goto L5
        L8:
            kotlin.n0.c.l r3 = this.f763h;
            if (r3 == null) goto L19;
            kotlin.f0 r8 = (kotlin.f0) r3.invoke(Boolean.FALSE);
            return;
        L19:
            return;
        L13:
            kotlin.n0.c.l r9 = this.f763h;
            if (r9 == null) goto L21;
            kotlin.f0 r10 = (kotlin.f0) r9.invoke(Boolean.TRUE);
            return;
        L21:
            return;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(com.bytedance.android.sdk.bdticketguard.n1.b r1, com.bytedance.android.sdk.bdticketguard.n1.c.f r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class u extends kotlin.n0.d.q implements kotlin.n0.c.q<kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g>, Integer, Boolean, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final u f764f = null;

        static {
            f764f = new u();
        }

        u() {
            super(3);
        }

        public final void a(Object r3, int r4, boolean r5) {
            s0.f1065a.e("TicketGuardManager", "doInitKeyAttestation result: " + kotlin.v.h(r3) + ", retryCount: " + r4 + ", isLastAttempt: " + r5);
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ kotlin.f0 f(kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g> r1, Integer r2, Boolean r3) {
            a(r1.i(), r2.intValue(), r3.booleanValue());
            return kotlin.f0.f18324a;
        }
    }

    static {
        f723d = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(f1.class), "gson", "getGson()Lcom/google/gson/Gson;"))};
    }

    public f1() {
        this.f724a = kotlin.i.b(g.f735f);
        this.f726c = new AtomicBoolean(false);
    }

    private final List<Pair<String, String>> A(e0 r7, String r8, String r9, String r10) {
        System.currentTimeMillis();
        ArrayList r0 = new ArrayList();
        e r1 = e.f733f;
        f r2 = f.f734f;
        if (r7.e() == true) goto L28;
        boolean r3 = false;
        if (r9 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L23;
        if (r8 != null) goto L14;
    L15:
        r3 = true;
    L16:
        if (r3 == true) goto L26;
        Charset r11 = kotlin.u0.d.f21429a;
        if (r8 == null) goto L21;
        byte[] r12 = r8.getBytes(r11);
        kotlin.n0.d.o.b(r12, "(this as java.lang.String).getBytes(charset)");
        r0.add(new Pair("bd-ticket-guard-client-csr", Base64.encodeToString(r12, 2)));
        goto L26
    L21:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
    L26:
        if (r0.isEmpty() == false) goto L28;
        U("get provider header, csr and cert are empty");
        goto L28
    L14:
        if (r8.length() != 0) goto L16;
    L23:
        if (L(r7.b()) == true) goto L26;
        r0.add(new Pair("bd-ticket-guard-client-cert", r9));
        goto L26
    L7:
        if (r9.length() == 0) goto L10;
        r5 = false;
    L28:
        String r13 = BDLocationException.ERROR_TIMEOUT;
        if (r10 == null) goto L39;
        if (L(r7.b()) == true) goto L34;
        r0.add(new Pair("bd-ticket-guard-ree-public-key", r10));
    L34:
        if (D() == false) goto L36;
        String r14 = LocationInfoConst.ALLOW_USE_LOCATION;
    L37:
        r0.add(new Pair("bd-ticket-guard-tee-status", r14));
        goto L39
    L36:
        r14 = BDLocationException.ERROR_TIMEOUT;
    L39:
        if (r7.d() == false) goto L41;
    L42:
        l0 r6 = g();
        if (r6 == null) goto L47;
        String r15 = r6.c();
        if (r15 == null) goto L47;
        r13 = r15;
    L47:
        r0.add(new Pair("bd-ticket-guard-server-cert-sn", r13));
    L49:
        if ((!r0.isEmpty()) == false) goto L51;
        r0.add(new Pair("bd-ticket-guard-version", "3"));
        r0.add(new Pair("bd-ticket-guard-display-os-version", Build.DISPLAY));
        r0.add(new Pair("bd-ticket-guard-iteration-version", "2"));
        r1.invoke2();
        return r0;
    L51:
        r2.invoke2();
        return null;
    L41:
        if (r7.f() == false) goto L49;
        goto L42
    }

    private final void I(com.bytedance.android.sdk.bdticketguard.n1.d r4) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        s0.f1065a.h("TicketGuardManager", "WARNING: Attempt to init bd_ticket_guard on main thread");
        J(r4);
        return;
    L6:
        com.bytedance.android.sdk.bdticketguard.n1.i.f904c.b(r4);
    }

    private final boolean L(String r1) {
        return kotlin.n0.d.o.a(r1, "/passport/ticket_guard/verify_pub_key/");
    }

    private final void W() {
        Class.forName("com.bytedance.android.sdk.bdticketguard.TicketGuardInjectManager").getMethod("tryInit", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        s0 r0 = s0.f1065a;
        String r3 = e.getMessage();
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0.a("TicketGuardManager", r3);
    }

    public static final /* synthetic */ AtomicBoolean p(f1 r0) {
        return r0.f726c;
    }

    public static final /* synthetic */ void q(f1 r0) {
        r0.W();
    }

    private final void r(c1 r3, kotlin.n0.c.a<kotlin.f0> r4, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r5) {
        Log.i("bd-ticket-guard", "bd-ticket-guard commonInit param: " + r3.getClass().getName());
        T(r3);
        J(new com.bytedance.android.sdk.bdticketguard.n1.a("common_init", new a(this, r4, r5)));
    }

    public abstract String B();

    public abstract String C();

    public abstract boolean D();

    public abstract String E();

    public abstract w0 F(String r1);

    public final c1 G() {
        c1 r0 = this.f725b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        kotlin.n0.d.o.v("ticketGuardInitParam");
        throw null;
    }

    public abstract void H(kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r1);

    public abstract void J(com.bytedance.android.sdk.bdticketguard.n1.d r1);

    protected abstract void K(String r1);

    public abstract void M(String r1, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r2);

    public abstract void N(String r1, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r2);

    public abstract void O(String r1, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r2);

    public final void P(String r2, JSONObject r3) {
        kotlin.n0.d.o.g(r2, NotificationCompat.CATEGORY_EVENT);
        kotlin.n0.d.o.g(r3, "params");
        if (this.f725b == null) goto L9;
        c1 r1 = this.f725b;
        if (r1 == null) goto L7;
        r1.b().onEvent(r2, r3);
        return;
    L7:
        kotlin.n0.d.o.v("ticketGuardInitParam");
        throw null;
    }

    public final m0 Q(String r6) {
        kotlin.n0.d.o.g(r6, "serverData");
        ArrayList<o0.a> r1 = null;
        m0 r2 = (m0) x().m(r6, o0.class);     // Catch: Throwable -> L5
    L8:
        if ((r2 instanceof o0) == true) goto L10;
        m0 r3 = null;
    L11:
        o0 r4 = (o0) r3;
        if (r4 == null) goto L14;
        r1 = r4.a();
    L14:
        if (r1 != null) goto L16;
    L22:
        return (m0) x().m(r6, n0.class);
    L19:
        th = move-exception;
        s0.f1065a.c("TicketGuardManager", "parse v1 server data failed", th);
        return r2;
    L16:
        if (r1.isEmpty() == true) goto L22;
        return r2;
    L10:
        r3 = r2;
    L5:
        th = move-exception;
        s0.f1065a.c("TicketGuardManager", "parse v2 server data failed", th);
        r2 = null;
        goto L8
    }

    public void R(com.bytedance.android.sdk.bdticketguard.p r2) {
        S(r2, "network");
    }

    public final void S(com.bytedance.android.sdk.bdticketguard.p r7, String r8) {
        kotlin.n0.d.o.g(r8, "scene");
        String r0 = m();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (g() != null) goto L12;
        r1 = true;
    L12:
        if (r2 == false) goto L14;
        String r3 = w();
    L15:
        s0.f1065a.a("TicketGuardManager", "requestCert, needClient=" + r2 + ", needServer=" + r1);
        h1.b(r3, r1, new q(this, r7), r8);
        return;
    L14:
        r3 = null;
        goto L15
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public final void T(c1 r5) {
        kotlin.n0.d.o.g(r5, "ticketGuardInitParam");
        r r1 = r.f759f;
        if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.C().b().booleanValue() == true) goto L5;
        this.f725b = r5;
        s0 r4 = s0.f1065a;
        StringBuilder r0 = new StringBuilder();
        String r2 = "enablePersistInitParam is off, ticketGuardInitParam impl class: ";
    L18:
        r0.append(r2);
        r0.append(r5.getClass().getName());
        String r6 = r0.toString();
    L19:
        r4.e("TicketGuardManager", r6);
        return;
    L5:
        if (this.f725b == null) goto L16;
        c1 r3 = this.f725b;
        if (r3 != null) goto L9;
        kotlin.n0.d.o.v("ticketGuardInitParam");
        throw null;
    L9:
        if (r1.a(r3) == false) goto L11;
    L13:
        r4 = s0.f1065a;
        r6 = "ticketGuardInitParam is already initialized, skip";
        goto L19
    L11:
        if (r1.a(r5) == false) goto L13;
    L16:
        this.f725b = r5;
        r4 = s0.f1065a;
        r0 = new StringBuilder();
        r2 = "ticketGuardInitParam impl class: ";
        goto L18
    }

    public abstract void U(String r1);

    protected final void V(String r2, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r3) {
        kotlin.n0.d.o.g(r2, "scene");
        boolean r0 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.x().b().booleanValue();
        N(r2, r3);
        if (r0 == false) goto L5;
        M(r2, r3);
        O(r2, r3);
    L7:
        if (kotlin.n0.d.o.a(r2, "init") == false) goto L10;
        s(u.f764f);
        return;
    L10:
        return;
    L5:
        O(r2, r3);
        M(r2, r3);
        goto L7
    }

    public abstract void X(w0 r1);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.CharSequence, java.lang.String] */
    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public f0 a(com.bytedance.android.sdk.bdticketguard.s r26) {
        kotlin.n0.d.o.g(r26, "handleProviderResponseParams");
        kotlin.n0.d.d0 r12 = new kotlin.n0.d.d0();
        r12.f18431f = "";
        kotlin.n0.d.d0 r13 = new kotlin.n0.d.d0();
        r13.f18431f = "";
        kotlin.n0.d.d0 r14 = new kotlin.n0.d.d0();
        r14.f18431f = null;
        kotlin.n0.d.d0 r15 = new kotlin.n0.d.d0();
        r15.f18431f = "";
        kotlin.n0.d.d0 r9 = new kotlin.n0.d.d0();
        ?? r1 = r26.a().d();
        r9.f18431f = r1;
        if (r1 != 0) goto L5;
    L8:
        boolean r7 = true;
    L9:
        String r17 = r26.a().b().b();
        ArrayList r18 = new ArrayList();
        kotlin.n0.d.a0 r6 = new kotlin.n0.d.a0();
        r6.f18427f = false;
        kotlin.n0.d.d0 r5 = new kotlin.n0.d.d0();
        r5.f18431f = "";
        com.bytedance.android.sdk.bdticketguard.t r4 = new com.bytedance.android.sdk.bdticketguard.t(new kotlin.u[]{kotlin.a0.a("X-Tt-Logid", new l(r12)), kotlin.a0.a("Bd-Ticket-Guard-Server-Data", new m(this, r13, r14, r7, r15, r9, r17, r26, r18)), kotlin.a0.a("bd-ticket-guard-client-cert", new n(this, r7, r9, r15)), kotlin.a0.a("Bd-Ticket-Guard-Server-Cert", new o(this, r6)), kotlin.a0.a("bd-ticket-guard-attestkey-ts-sign", new p(r5))});
        Iterator<Pair<String, String>> r2 = r26.b().iterator();
    L11:
        if (r2.hasNext() == false) goto L23;
        Pair<String, String> r3 = r2.next();
        CharSequence r8 = (CharSequence) r3.second;
        if (r8 != null) goto L15;
    L18:
        boolean r10 = true;
    L19:
        if (r10 == true) goto L11;
        Object r11 = r3.first;
        kotlin.n0.d.o.b(r11, "resHeader.first");
        Object r16 = r3.second;
        kotlin.n0.d.o.b(r16, "resHeader.second");
        r4.c((String) r11, (String) r16);
        goto L11
    L15:
        if (r8.length() == 0) goto L18;
        r10 = false;
        goto L19
    L23:
        if (r6.f18427f == true) goto L25;
        s0 r0 = s0.f1065a;
        String r19 = "handleProviderResponse server cert is empty";
    L26:
        r0.a("TicketGuardManager", r19);
        f0 r20 = new f0(r26, (String) r12.f18431f, (String) r13.f18431f, (m0) r14.f18431f, r18, (String) r15.f18431f, (String) r5.f18431f);
        z0.v(r20, r6.f18427f);
        return r20;
    L25:
        r0 = s0.f1065a;
        r19 = "handleProviderResponse server cert is not empty";
        goto L26
    L5:
        if (r1.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public void b(c1 r5, kotlin.n0.c.l<? super Boolean, kotlin.f0> r6) {
        kotlin.n0.d.o.g(r5, "ticketGuardInitParam");
        AtomicInteger r0 = new AtomicInteger(0);
        s0.f1065a.a("TicketGuardManager", "tryInit start");
        r(r5, s.f760f, new t(this, r0, r6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public void d(com.bytedance.android.sdk.bdticketguard.r r9) {
        kotlin.n0.d.o.g(r9, "handleConsumerResponseParam");
        kotlin.n0.d.d0 r0 = new kotlin.n0.d.d0();
        r0.f18431f = "";
        kotlin.n0.d.d0 r2 = new kotlin.n0.d.d0();
        r2.f18431f = "";
        kotlin.n0.d.d0 r3 = new kotlin.n0.d.d0();
        r3.f18431f = "";
        if (r9.b() != null) goto L5;
        return;
    L5:
        com.bytedance.android.sdk.bdticketguard.t r1 = new com.bytedance.android.sdk.bdticketguard.t(new kotlin.u[]{kotlin.a0.a("X-Tt-Logid", new j(r0)), kotlin.a0.a("bd-ticket-guard-result", new h(r2, this, r9)), kotlin.a0.a("bd-ticket-guard-attestkey-result", new k(r3)), kotlin.a0.a("bd-ticket-guard-attest-invalidate", new i(this, r9))});
        Iterator<Pair<String, String>> r8 = r9.b().iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        Pair<String, String> r4 = r8.next();
        Object r5 = r4.first;
        kotlin.n0.d.o.b(r5, "header.first");
        Object r6 = r4.second;
        kotlin.n0.d.o.b(r6, "header.second");
        r1.c((String) r5, (String) r6);
        goto L7
    L9:
        z0.S(new com.bytedance.android.sdk.bdticketguard.o(r9, (String) r0.f18431f, (String) r2.f18431f, (String) r3.f18431f));
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public d0 i(e0 r5) {
        kotlin.n0.d.o.g(r5, "params");
        V("ticket_network", null);
        String r0 = m();
        return new d0(r0, A(r5, w(), r0, v()), r5);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public com.bytedance.android.sdk.bdticketguard.l n(com.bytedance.android.sdk.bdticketguard.m r28) {
        kotlin.n0.d.o.g(r28, "consumerRequestParam");
        ArrayList r3 = new ArrayList();
        if (r28.f() == false) goto L5;
    L12:
        StringBuilder r4 = new StringBuilder();
        String r0 = r28.i();
        String r5 = r28.b();
        String r7 = null;
        if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.D().b().booleanValue() == true) goto L15;
        V("ticket_network", null);
    L36:
        String r9 = "3";
        r3.add(new Pair("bd-ticket-guard-version", "3"));
        r3.add(new Pair("bd-ticket-guard-display-os-version", Build.DISPLAY));
        if (r28.c() != 0) goto L39;
        long r11 = System.currentTimeMillis();
    L40:
        long r10 = r11 / ((long) 1000);
        String r6 = "ticket=" + r0 + "&path=" + r5 + "&timestamp=" + r10;
        String r17 = "ticket=" + p0.b(r0) + "&path=" + r5 + "&timestamp=" + r10;
        s0 r12 = s0.f1065a;
        r12.a("TicketGuardManager", "contentToSign=" + r6);
        w0 r13 = F(r0);
        com.bytedance.android.sdk.bdticketguard.j r15 = new com.bytedance.android.sdk.bdticketguard.j("ticket,path,timestamp", r17, r10, null, null, null, null, 120, null);
        StringBuilder r14 = new StringBuilder();
        boolean r16 = r28 instanceof com.bytedance.android.sdk.bdticketguard.n;
        if (r16 == false) goto L49;
        r12.e("TicketGuardManager", "is ConsumerRequestWithTsSign");
        String r18 = ((com.bytedance.android.sdk.bdticketguard.n) r28).l();
        r12.e("TicketGuardManager", "input tsSign=" + r18);
        w0.a r1 = (w0.a) x().m(r18, w0.a.class);     // Catch: Throwable -> L45
    L47:
        if (r1 != null) goto L50;
        r1 = new w0.a(r18, null);
    L50:
        s0 r8 = s0.f1065a;
        r8.a("TicketGuardManager", "combineTsSign=" + r1);
        if (r28.h() == false) goto L104;
        if (r13 == null) goto L54;
        String r19 = r13.a();
    L55:
        if (r19 != null) goto L57;
    L60:
        boolean r110 = true;
    L61:
        if (r110 == false) goto L63;
        r19 = m();
    L63:
        if (r1 == null) goto L67;
        String r111 = r1.a();
        if (r111 == null) goto L67;
    L69:
        r7 = r111;
    L70:
        String r112 = o(r6, r5);
        if (r19 != null) goto L73;
    L76:
        boolean r113 = true;
    L77:
        if (r113 == false) goto L80;
        r4.append("tee error: client cert, ");
        r9 = "3";
        boolean r2 = false;
    L84:
        if (r7 != null) goto L86;
    L89:
        boolean r20 = true;
    L90:
        if (r20 == false) goto L92;
        r4.append("tee error: tsSign, ");
        com.bytedance.android.sdk.bdticketguard.j r21 = r15;
        r2 = false;
    L93:
        if (r112 != null) goto L95;
    L98:
        boolean r22 = true;
    L99:
        if (r22 == false) goto L101;
        r4.append("tee error: sign, ");
        r2 = false;
    L102:
        if (r2 == false) goto L105;
        r14.append("tee, ");
    L105:
        String r23 = "2";
        if (r28.g() == true) goto L112;
        if (r28.e() == true) goto L112;
        r23 = "2";
        r8 = r8;
    L203:
        String r24 = r23;
    L204:
        r3.add(new Pair("bd-ticket-guard-iteration-version", r24));
        if (r28.d() == false) goto L239;
        com.bytedance.android.sdk.bdticketguard.m1.c r25 = u();
        if ((r25 instanceof com.bytedance.android.sdk.bdticketguard.m1.c.d) == false) goto L237;
        if (r16 == true) goto L210;
        com.bytedance.android.sdk.bdticketguard.m r26 = null;
    L211:
        com.bytedance.android.sdk.bdticketguard.n r27 = (com.bytedance.android.sdk.bdticketguard.n) r26;
        if (r27 == null) goto L214;
        String r29 = r27.k();
    L215:
        if (r29 != null) goto L217;
    L220:
        boolean r30 = true;
    L221:
        if (r30 == false) goto L223;
        r8.b("TicketGuardManager", "attest error: attestTsSign is empty");
        r4.append("attest error: attestTsSign, ");
    L223:
        String r114 = t();
        String r115 = "";
        if (r29 == null) goto L226;
        String r116 = r29;
    L227:
        com.bytedance.android.sdk.bdticketguard.m1.c.d r31 = (com.bytedance.android.sdk.bdticketguard.m1.c.d) r25;
        String r32 = x().v(new com.bytedance.android.sdk.bdticketguard.a(r114, r116, "sec_ts", r31.c(), r31.e().b()));     // Catch: Exception -> L233
        kotlin.n0.d.o.b(r32, "gson.toJson(attestClientData)");     // Catch: Exception -> L233
        Charset r33 = kotlin.u0.d.f21429a;     // Catch: Exception -> L233
        if (r32 == null) goto L232;
        byte[] r34 = r32.getBytes(r33);     // Catch: Exception -> L233
        kotlin.n0.d.o.b(r34, "(this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L233
        r115 = Base64.encodeToString(r34, 2);     // Catch: Exception -> L233
    L235:
        r3.add(new Pair("bd-ticket-guard-attestkey-client-data", r115));
        goto L239
    L232:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L233
    L233:
        e = move-exception;
        s0.f1065a.c("TicketGuardManager", "Exception serializing client data", e);
        goto L235
    L226:
        r116 = "";
        goto L227
    L217:
        if (r29.length() == 0) goto L220;
        r30 = false;
        goto L221
    L214:
        r29 = null;
        goto L215
    L210:
        r26 = r28;
        goto L211
    L237:
        if ((r25 instanceof com.bytedance.android.sdk.bdticketguard.m1.c.b) == false) goto L239;
        r4.append("attest error: " + ((com.bytedance.android.sdk.bdticketguard.m1.c.b) r25).c().getClass().getName());
    L239:
        String r35 = x().v(r21);
        kotlin.n0.d.o.b(r35, "gson.toJson(clientData)");
        Charset r36 = kotlin.u0.d.f21429a;
        if (r35 == null) goto L244;
        byte[] r37 = r35.getBytes(r36);
        kotlin.n0.d.o.b(r37, "(this as java.lang.String).getBytes(charset)");
        String r38 = Base64.encodeToString(r37, 2);
        r3.add(new Pair("bd-ticket-guard-client-data", r38));
        String r39 = r4.toString();
        kotlin.n0.d.o.b(r39, "errorDesc.toString()");
        String r40 = r14.toString();
        kotlin.n0.d.o.b(r40, "signType.toString()");
        kotlin.n0.d.o.b(r38, "clientDataBase64");
        return new com.bytedance.android.sdk.bdticketguard.l(r28, r3, r39, r40, r21, r38, false, 64, null);
    L244:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
    L112:
        if (r28.f() == false) goto L156;
        String r41 = v();
        if (r1 == null) goto L118;
        String r117 = r1.b();
        if (r117 == null) goto L118;
    L122:
        String r42 = k(r6, r5);
        if (r41 != null) goto L125;
    L128:
        boolean r210 = true;
    L129:
        if (r210 == false) goto L132;
        r4.append("hmac error: public key, ");
        r8 = r8;
        boolean r43 = false;
    L136:
        if (r117 != null) goto L138;
    L141:
        boolean r44 = true;
    L142:
        if (r44 == false) goto L144;
        r4.append("hmac error: tsSignRee, ");
        r43 = false;
    L145:
        if (r42 != null) goto L147;
    L150:
        boolean r45 = true;
    L151:
        if (r45 == false) goto L153;
        r4.append("hmac error: hmac, ");
        r43 = false;
    L154:
        if (r43 == false) goto L158;
        r14.append("hmac, ");
    L158:
        if (r28.f() == false) goto L162;
        if (r43 == false) goto L162;
        r24 = r9;
    L162:
        String r46 = v();
        if (r1 == null) goto L167;
        String r47 = r1.b();
        if (r47 == null) goto L167;
    L170:
        String r48 = e(r6, r5);
        if (r46 != null) goto L173;
    L176:
        boolean r49 = true;
    L177:
        if (r49 == false) goto L180;
        r4.append("ree error: public key, ");
        boolean r50 = false;
    L183:
        if (r47 != null) goto L185;
    L188:
        boolean r51 = true;
    L189:
        if (r51 == false) goto L191;
        r4.append("ree error: tsSignRee, ");
        r50 = false;
    L192:
        if (r48 != null) goto L194;
    L197:
        boolean r52 = true;
    L198:
        if (r52 == false) goto L200;
        r4.append("ree error: sign, ");
        r50 = false;
    L201:
        if (r50 == false) goto L203;
        r14.append("ree, ");
        goto L203
    L200:
        r21.h(r48);
        goto L201
    L194:
        if (r48.length() == 0) goto L197;
        r52 = false;
        goto L198
    L191:
        r21.j(r47);
        goto L192
    L185:
        if (r47.length() == 0) goto L188;
        r51 = false;
        goto L189
    L180:
        if (L(r5) == true) goto L182;
        r3.add(new Pair("bd-ticket-guard-ree-public-key", r46));
    L182:
        r50 = true;
        goto L183
    L173:
        if (r46.length() == 0) goto L176;
        r49 = false;
    L167:
        if (r13 == null) goto L169;
        r47 = r13.d();
        goto L170
    L169:
        r47 = null;
        goto L170
    L153:
        r21.h(r42);
        goto L154
    L147:
        if (r42.length() == 0) goto L150;
        r45 = false;
        goto L151
    L144:
        r21.j(r117);
        goto L145
    L138:
        if (r117.length() == 0) goto L141;
        r44 = false;
        goto L142
    L132:
        if (L(r5) == true) goto L135;
        r3.add(new Pair("bd-ticket-guard-ree-public-key", r41));
    L135:
        r43 = true;
        goto L136
    L125:
        if (r41.length() == 0) goto L128;
        r210 = false;
    L118:
        if (r13 == null) goto L121;
        r117 = r13.d();
        goto L122
    L121:
        r117 = null;
        goto L122
    L156:
        r23 = "2";
        r8 = r8;
        r9 = r23;
        r43 = true;
        goto L158
    L101:
        r21.g(r112);
        goto L102
    L95:
        if (r112.length() == 0) goto L98;
        r22 = false;
        goto L99
    L92:
        r21 = r15;
        r21.i(r7);
        goto L93
    L86:
        if (r7.length() == 0) goto L89;
        r20 = false;
        goto L90
    L80:
        if (L(r5) == true) goto L83;
        r3.add(new Pair("bd-ticket-guard-client-cert", r19));
    L83:
        r2 = true;
        goto L84
    L73:
        if (r19.length() == 0) goto L76;
        r113 = false;
    L67:
        if (r13 == null) goto L70;
        r111 = r13.c();
        goto L69
    L57:
        if (r19.length() == 0) goto L60;
        r110 = false;
        goto L61
    L54:
        r19 = null;
        goto L55
    L104:
        r9 = "3";
        r21 = r15;
    L45:
        th = move-exception;
        String r53 = Log.getStackTraceString(th);
        kotlin.n0.d.o.b(r53, "Log.getStackTraceString(ignore)");
        z0.I("custom_ts_sign", r18, r53);
        r1 = null;
        goto L47
    L49:
        r12.a("TicketGuardManager", "is ConsumerRequest");
        r1 = null;
        goto L50
    L39:
        r11 = r28.c();
        goto L40
    L15:
        if (r28.h() == false) goto L20;
        if ((!kotlin.n0.d.o.a(y(com.bytedance.android.sdk.bdticketguard.n1.b.f868g), com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b)) == false) goto L20;
        I(new com.bytedance.android.sdk.bdticketguard.n1.f("initOnDemand by path: " + r5, new b(this)));
    L20:
        if (r28.g() == true) goto L26;
        if (r28.f() == true) goto L26;
        if (r28.e() == true) goto L26;
    L29:
        if (r28.f() == true) goto L33;
        if (r28.e() == false) goto L36;
    L33:
        if ((!kotlin.n0.d.o.a(y(com.bytedance.android.sdk.bdticketguard.n1.b.f870i), com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b)) == false) goto L36;
        I(new com.bytedance.android.sdk.bdticketguard.n1.e("initOnDemand by path: " + r5, new d(this)));
    L26:
        if ((!kotlin.n0.d.o.a(y(com.bytedance.android.sdk.bdticketguard.n1.b.f869h), com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b)) == false) goto L29;
        I(new com.bytedance.android.sdk.bdticketguard.n1.e("initOnDemand by path: " + r5, new c(this)));
        goto L29
    L5:
        if (r28.h() == true) goto L12;
        if (r28.g() == true) goto L12;
        if (r28.d() == true) goto L12;
        return new com.bytedance.android.sdk.bdticketguard.l(r28, r3, "empty sign type", "", new com.bytedance.android.sdk.bdticketguard.j("", "", 0, null, null, null, null, 120, null), "", false, 64, null);
    }

    public abstract kotlin.u<Boolean, String> s(kotlin.n0.c.q<? super kotlin.v<com.bytedance.android.sdk.bdticketguard.g>, ? super Integer, ? super Boolean, kotlin.f0> r1);

    public abstract String t();

    public abstract com.bytedance.android.sdk.bdticketguard.m1.c u();

    public abstract String v();

    public abstract String w();

    protected final Gson x() {
        kotlin.h r2 = this.f724a;
        kotlin.s0.l r0 = f723d[0];
        return (Gson) r2.getValue();
    }

    protected abstract com.bytedance.android.sdk.bdticketguard.n1.c y(com.bytedance.android.sdk.bdticketguard.n1.b r1);

    public final com.bytedance.android.sdk.bdticketguard.u z() {
        if (this.f725b == null) goto L9;
        c1 r2 = this.f725b;
        if (r2 != null) goto L10;
        kotlin.n0.d.o.v("ticketGuardInitParam");
        throw null;
    L10:
        return r2.a();
    L9:
        return null;
    }
}
