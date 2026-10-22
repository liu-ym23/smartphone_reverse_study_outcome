package com.bytedance.android.sdk.bdticketguard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a0 extends f1 {
    static final /* synthetic */ kotlin.s0.l[] p = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.android.sdk.bdticketguard.q1.b<com.bytedance.android.sdk.bdticketguard.g> f641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicBoolean f643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<kotlin.n0.c.q<kotlin.v<com.bytedance.android.sdk.bdticketguard.g>, Integer, Boolean, kotlin.f0>> f644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile String f645i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<String, com.bytedance.android.sdk.bdticketguard.y> f646j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final kotlin.h f647k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final kotlin.h f648l;
    private final kotlin.h m;
    private final kotlin.h n;
    private volatile kotlin.n0.c.l<? super JSONObject, kotlin.f0> o;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.u<? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f649f = null;

        static {
            f649f = new a();
        }

        a() {
            super(0);
        }

        public final kotlin.u<Integer, String> a() {
            return kotlin.a0.a(Integer.valueOf(BadgerResult.ERROR_SDK_NOT_SUPPORT), "doAttestation must be called on a background thread");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.u<? extends Integer, ? extends String> invoke() {
            return a();
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.u<? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.n1.c f650f;

        b(com.bytedance.android.sdk.bdticketguard.n1.c r1) {
            this.f650f = r1;
            super(0);
        }

        public final kotlin.u<Integer, String> a() {
            return kotlin.a0.a(Integer.valueOf(BadgerResult.ERROR_JAVA_EXCEPTION), "REE not init, current state: " + this.f650f);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.u<? extends Integer, ? extends String> invoke() {
            return a();
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.u<? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.n1.c f651f;

        c(com.bytedance.android.sdk.bdticketguard.n1.c r1) {
            this.f651f = r1;
            super(0);
        }

        public final kotlin.u<Integer, String> a() {
            return kotlin.a0.a(Integer.valueOf(BadgerResult.ERROR_JAVA_EXCEPTION), "TEE not init, current state: " + this.f651f);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.u<? extends Integer, ? extends String> invoke() {
            return a();
        }
    }

    public static final class d implements com.bytedance.android.sdk.bdticketguard.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f652a;

        d(CountDownLatch r1) {
            this.f652a = r1;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.p
        public void a(String r4, String r5) {
            s0.f1065a.e("MainTicketGuardManager", "doAttestation requestCert callback, resClientCert=" + r4 + ", resServerCert=" + r5);
            this.f652a.countDown();
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.u<? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f653f = null;

        static {
            f653f = new e();
        }

        e() {
            super(0);
        }

        public final kotlin.u<Integer, String> a() {
            return kotlin.a0.a(-1004, "teeKey is empty");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.u<? extends Integer, ? extends String> invoke() {
            return a();
        }
    }

    static final class f extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.u<? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f654f = null;

        static {
            f654f = new f();
        }

        f() {
            super(0);
        }

        public final kotlin.u<Integer, String> a() {
            return kotlin.a0.a(-1004, "reeKey is empty");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.u<? extends Integer, ? extends String> invoke() {
            return a();
        }
    }

    static final class g extends kotlin.n0.d.q implements kotlin.n0.c.a<com.bytedance.android.sdk.bdticketguard.f> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f655f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.i f656g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.j.f f657h;

        g(a0 r1, com.bytedance.android.sdk.bdticketguard.i r2, com.bytedance.android.sdk.bdticketguard.o1.j.f r3) {
            this.f655f = r1;
            this.f656g = r2;
            this.f657h = r3;
            super(0);
        }

        public final com.bytedance.android.sdk.bdticketguard.f a() {
            return a0.h0(this.f655f, this.f656g, this.f657h);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.f invoke() {
            return a();
        }
    }

    static final class h extends kotlin.n0.d.q implements kotlin.n0.c.a<com.bytedance.android.sdk.bdticketguard.g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f658f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.i f659g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.f f660h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.j.g f661i;

        h(a0 r1, com.bytedance.android.sdk.bdticketguard.i r2, com.bytedance.android.sdk.bdticketguard.f r3, com.bytedance.android.sdk.bdticketguard.o1.j.g r4) {
            this.f658f = r1;
            this.f659g = r2;
            this.f660h = r3;
            this.f661i = r4;
            super(0);
        }

        public final com.bytedance.android.sdk.bdticketguard.g a() {
            return a0.a0(this.f658f, this.f659g, this.f660h, this.f661i);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.g invoke() {
            return a();
        }
    }

    static final class i extends kotlin.n0.d.q implements kotlin.n0.c.l<JSONObject, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f662f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.q f663g;

        i(a0 r1, kotlin.n0.c.q r2) {
            this.f662f = r1;
            this.f663g = r2;
            super(1);
        }

        public final void a(JSONObject r1) {
            a0.i0(this.f662f, this.f663g);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(JSONObject r1) {
            a(r1);
            return kotlin.f0.f18324a;
        }
    }

    static final class j extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f664f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p f665g;

        j(a0 r1, kotlin.n0.c.p r2) {
            this.f664f = r1;
            this.f665g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f664f.N("init", this.f665g);
            this.f664f.M("init", this.f665g);
        }
    }

    static final class k extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f666f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p f667g;

        k(a0 r1, kotlin.n0.c.p r2) {
            this.f666f = r1;
            this.f667g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f666f.O("init", this.f667g);
        }
    }

    static final class l extends kotlin.n0.d.q implements kotlin.n0.c.q<kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g>, Integer, Boolean, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final l f668f = null;

        static {
            f668f = new l();
        }

        l() {
            super(3);
        }

        public final void a(Object r3, int r4, boolean r5) {
            s0.f1065a.e("MainTicketGuardManager", "doInitKeyAttestation result: " + kotlin.v.h(r3) + ", retryCount: " + r4 + ", isLastAttempt: " + r5);
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ kotlin.f0 f(kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g> r1, Integer r2, Boolean r3) {
            a(r1.i(), r2.intValue(), r3.booleanValue());
            return kotlin.f0.f18324a;
        }
    }

    static final class m extends kotlin.n0.d.q implements kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f669f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f670g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p f671h;

        m(a0 r1, String r2, kotlin.n0.c.p r3) {
            this.f669f = r1;
            this.f670g = r2;
            this.f671h = r3;
            super(2);
        }

        public final void a(com.bytedance.android.sdk.bdticketguard.n1.b r2, com.bytedance.android.sdk.bdticketguard.n1.c.f r3) {
            kotlin.n0.d.o.g(r2, "initTask");
            kotlin.n0.d.o.g(r3, "initResult");
            a0.g0(this.f669f, r3, this.f670g, this.f671h);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(com.bytedance.android.sdk.bdticketguard.n1.b r1, com.bytedance.android.sdk.bdticketguard.n1.c.f r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class n extends kotlin.n0.d.q implements kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f672f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f673g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p f674h;

        public static final class a implements com.bytedance.android.sdk.bdticketguard.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.bytedance.android.sdk.bdticketguard.y f675a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n f676b;

            a(com.bytedance.android.sdk.bdticketguard.y r1, n r2) {
                this.f675a = r1;
                this.f676b = r2;
            }

            @Override // com.bytedance.android.sdk.bdticketguard.p
            public void a(String r2, String r3) {
                this.f675a.c(Boolean.valueOf(a0.b0(this.f676b.f672f).z()));
                a0 r4 = this.f676b.f672f;
                Boolean r5 = this.f675a.b();
                if (r5 == null) goto L5;
                boolean r6 = r5.booleanValue();
            L6:
                a0.f0(r4, "encryption", r6, this.f676b.f674h);
                return;
            L5:
                r6 = false;
                goto L6
            }
        }

        n(a0 r1, String r2, kotlin.n0.c.p r3) {
            this.f672f = r1;
            this.f673g = r2;
            this.f674h = r3;
            super(2);
        }

        public final void a(com.bytedance.android.sdk.bdticketguard.n1.b r4, com.bytedance.android.sdk.bdticketguard.n1.c r5) {
            kotlin.n0.d.o.g(r4, "reeInitTask");
            kotlin.n0.d.o.g(r5, "reeInitResult");
            boolean r6 = kotlin.n0.d.o.a(r5, com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b);
            boolean r7 = false;
            if (r6 == false) goto L33;
            com.bytedance.android.sdk.bdticketguard.y r8 = this.f672f.q0().get("encryption");
            if (r8 == null) goto L31;
            com.bytedance.android.sdk.bdticketguard.y r9 = r8;
            Boolean r0 = r9.b();
            Boolean r1 = Boolean.TRUE;
            if ((!kotlin.n0.d.o.a(r0, r1)) == false) goto L29;
            Object r2 = r9.a();
            monitor-enter(r2);
        L26:
            th = move-exception;
            throw th;
        L11:
            if (r9.b() != null) goto L14;
            r9.c(Boolean.valueOf(a0.b0(this.f672f).G()));     // Catch: Throwable -> L26
        L14:
            if (kotlin.n0.d.o.a(r9.b(), r1) == false) goto L16;
        L19:
            a0 r3 = this.f672f;     // Catch: Throwable -> L26
            Boolean r10 = r9.b();     // Catch: Throwable -> L26
            if (r10 == null) goto L22;
            r7 = r10.booleanValue();     // Catch: Throwable -> L26
        L22:
            a0.f0(r3, "encryption", r7, this.f674h);     // Catch: Throwable -> L26
        L23:
            kotlin.f0 r11 = kotlin.f0.f18324a;     // Catch: Throwable -> L26
            monitor-exit(r2);
        L30:
            a0.Y(this.f672f);
            return;
        L16:
            if (kotlin.n0.d.o.a(this.f673g, "ticket_network") == true) goto L19;
            this.f672f.S(new a(r9, this), this.f673g);     // Catch: Throwable -> L26
            goto L23
        L29:
            a0.f0(this.f672f, "encryption", true, this.f674h);
            goto L30
        L31:
            kotlin.n0.d.o.p();
            throw null;
        L33:
            a0.f0(this.f672f, "encryption", false, this.f674h);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(com.bytedance.android.sdk.bdticketguard.n1.b r1, com.bytedance.android.sdk.bdticketguard.n1.c r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class o extends kotlin.n0.d.q implements kotlin.n0.c.l<com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c, com.bytedance.android.sdk.bdticketguard.n1.c.f> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f677f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f678g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.n1.c f679h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f680i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.a0 f681j;

        o(a0 r1, kotlin.n0.d.d0 r2, com.bytedance.android.sdk.bdticketguard.n1.c r3, String r4, kotlin.n0.d.a0 r5) {
            this.f677f = r1;
            this.f678g = r2;
            this.f679h = r3;
            this.f680i = r4;
            this.f681j = r5;
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, com.bytedance.android.sdk.bdticketguard.n1.c$b] */
        /* JADX WARN: Type inference failed for: r1v4, types: [T, com.bytedance.android.sdk.bdticketguard.n1.c$e] */
        /* JADX WARN: Type inference failed for: r1v6, types: [T, com.bytedance.android.sdk.bdticketguard.n1.c$f] */
        /* JADX WARN: Type inference failed for: r4v15, types: [T, com.bytedance.android.sdk.bdticketguard.n1.c$b] */
        public final com.bytedance.android.sdk.bdticketguard.n1.c.f a(com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c r4) {
            kotlin.n0.d.o.g(r4, WsConstants.KEY_CONNECTION_STATE);
            this.f678g.f18431f = r4;
            if ((!kotlin.n0.d.o.a(this.f679h, com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b)) == false) goto L10;
            kotlin.n0.d.d0 r3 = this.f678g;
            ?? r5 = com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;
            r3.f18431f = r5;
            com.bytedance.android.sdk.bdticketguard.n1.c r6 = (com.bytedance.android.sdk.bdticketguard.n1.c) r5;
            if (r6 == null) goto L9;
            return (com.bytedance.android.sdk.bdticketguard.n1.c.f) r6;
        L9:
            throw new kotlin.b0("null cannot be cast to non-null type com.bytedance.android.sdk.bdticketguard.init.InitTaskState.ResultTaskState");
        L10:
            kotlin.n0.d.d0 r7 = this.f678g;
            if ((((com.bytedance.android.sdk.bdticketguard.n1.c) r7.f18431f) instanceof com.bytedance.android.sdk.bdticketguard.n1.c.d) == false) goto L14;
            r7.f18431f = com.bytedance.android.sdk.bdticketguard.n1.c.f875a.b(a0.b0(this.f677f).G());
        L14:
            if ((((com.bytedance.android.sdk.bdticketguard.n1.c) this.f678g.f18431f) instanceof com.bytedance.android.sdk.bdticketguard.n1.c.b) == true) goto L16;
        L19:
            com.bytedance.android.sdk.bdticketguard.n1.c r8 = (com.bytedance.android.sdk.bdticketguard.n1.c) this.f678g.f18431f;
            if ((r8 instanceof com.bytedance.android.sdk.bdticketguard.n1.c.f) == true) goto L22;
            r8 = null;
        L22:
            com.bytedance.android.sdk.bdticketguard.n1.c.f r9 = (com.bytedance.android.sdk.bdticketguard.n1.c.f) r8;
            if (r9 == null) goto L26;
            return r9;
        L26:
            return com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;
        L16:
            if (kotlin.n0.d.o.a(this.f680i, "ticket_network") == false) goto L18;
            this.f678g.f18431f = com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;
            goto L19
        L18:
            this.f678g.f18431f = com.bytedance.android.sdk.bdticketguard.n1.c.e.f881b;
            this.f681j.f18427f = true;
            goto L19
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.n1.c.f invoke(com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c r1) {
            return a(r1);
        }
    }

    static final class p extends kotlin.n0.d.q implements kotlin.n0.c.l<com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c, com.bytedance.android.sdk.bdticketguard.n1.c.f> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f683g;

        p(a0 r1, String r2) {
            this.f682f = r1;
            this.f683g = r2;
            super(1);
        }

        public final com.bytedance.android.sdk.bdticketguard.n1.c.f a(com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c r2) {
            kotlin.n0.d.o.g(r2, "it");
            boolean r1 = a0.b0(this.f682f).q(this.f683g);
            return com.bytedance.android.sdk.bdticketguard.n1.c.f875a.b(r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.n1.c.f invoke(com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c r1) {
            return a(r1);
        }
    }

    static final class q extends kotlin.n0.d.q implements kotlin.n0.c.l<com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c, com.bytedance.android.sdk.bdticketguard.n1.c.f> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f684f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f685g;

        q(a0 r1, String r2) {
            this.f684f = r1;
            this.f685g = r2;
            super(1);
        }

        public final com.bytedance.android.sdk.bdticketguard.n1.c.f a(com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c r7) {
            kotlin.n0.d.o.g(r7, "it");
            boolean r8 = a0.d0(this.f684f).q(this.f685g);
            if (r8 == false) goto L24;
            ArrayList r0 = new ArrayList();
            Iterator r1 = a0.c0(this.f684f).values().iterator();
        L5:
            boolean r3 = true;
            if (r1.hasNext() == false) goto L18;
            w0 r2 = (w0) r1.next();
            String r4 = r2.a();
            if (r4 != null) goto L10;
        L13:
            if (r3 == true) goto L5;
            if (kotlin.n0.d.o.a(a0.d0(this.f684f).z(r4), Boolean.FALSE) == false) goto L5;
            r0.add(r2);
            goto L5
        L10:
            if (r4.length() == 0) goto L13;
            r3 = false;
            goto L13
        L18:
            if ((!r0.isEmpty()) == false) goto L24;
            Iterator r5 = r0.iterator();
        L21:
            if (r5.hasNext() == false) goto L24;
            this.f684f.C0((w0) r5.next());
        L24:
            return com.bytedance.android.sdk.bdticketguard.n1.c.f875a.b(r8);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.n1.c.f invoke(com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c r1) {
            return a(r1);
        }
    }

    static final class r extends kotlin.n0.d.q implements kotlin.n0.c.a<com.bytedance.android.sdk.bdticketguard.o1.d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f686f;

        r(a0 r1) {
            this.f686f = r1;
            super(0);
        }

        public final com.bytedance.android.sdk.bdticketguard.o1.d a() {
            return new com.bytedance.android.sdk.bdticketguard.o1.d(this.f686f.G().e(), "TicketGuardManager");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.d invoke() {
            return a();
        }
    }

    public static final class s implements com.bytedance.android.sdk.bdticketguard.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a0 f687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p f688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.n1.b f689c;

        s(a0 r1, kotlin.n0.c.p r2, com.bytedance.android.sdk.bdticketguard.n1.b r3) {
            this.f687a = r1;
            this.f688b = r2;
            this.f689c = r3;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.p
        public void a(String r6, String r7) {
            boolean r0 = a0.b0(this.f687a).z();
            s0 r1 = s0.f1065a;
            StringBuilder r2 = new StringBuilder();
            r2.append("getCert callback, resClientCert=");
            boolean r3 = true;
            if (r6 == null) goto L5;
            boolean r8 = true;
        L6:
            r2.append(r8);
            r2.append(", resServerCert=");
            if (r7 != null) goto L10;
            r3 = false;
        L10:
            r2.append(r3);
            r2.append(", getCertResult=");
            r2.append(r0);
            r1.a("MainTicketGuardManager", r2.toString());
            com.bytedance.android.sdk.bdticketguard.n1.g r9 = com.bytedance.android.sdk.bdticketguard.n1.g.f895h;
            com.bytedance.android.sdk.bdticketguard.n1.b r10 = com.bytedance.android.sdk.bdticketguard.n1.b.f870i;
            if (r0 == false) goto L13;
            com.bytedance.android.sdk.bdticketguard.n1.c r4 = com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b;
        L14:
            r9.g(r10, r4);
            kotlin.n0.c.p r11 = this.f688b;
            if (r11 == null) goto L22;
            com.bytedance.android.sdk.bdticketguard.n1.b r5 = this.f689c;
            if (r0 == false) goto L19;
            com.bytedance.android.sdk.bdticketguard.n1.c.f r12 = com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b;
        L20:
            kotlin.f0 r13 = (kotlin.f0) r11.invoke(r5, r12);
            return;
        L19:
            r12 = com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;
            goto L20
        L22:
            return;
        L13:
            r4 = com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;
            goto L14
        L5:
            r8 = false;
            goto L6
        }
    }

    static final class t extends kotlin.n0.d.q implements kotlin.n0.c.a<Map<String, w0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f690f;

        t(a0 r1) {
            this.f690f = r1;
            super(0);
        }

        public final Map<String, w0> a() {
            return this.f690f.A0();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Map<String, w0> invoke() {
            return a();
        }
    }

    static final class u extends kotlin.n0.d.q implements kotlin.n0.c.a<SharedPreferences> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f691f;

        u(a0 r1) {
            this.f691f = r1;
            super(0);
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        public final SharedPreferences b() {
            return a(this.f691f.G().e(), "sp_TicketGuardManager", 0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ SharedPreferences invoke() {
            return b();
        }
    }

    static final class v extends kotlin.n0.d.q implements kotlin.n0.c.q<kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g>, Integer, Boolean, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f692f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.q f693g;

        v(a0 r1, boolean r2, w r3, kotlin.n0.c.q r4, boolean r5, long r6, int r8, long r9) {
            this.f692f = r1;
            this.f693g = r4;
            super(3);
        }

        public final void a(Object r2, int r3, boolean r4) {
            a0.e0(this.f692f, r2, r3, r4);
            kotlin.n0.c.q r1 = this.f693g;
            if (r1 == null) goto L6;
            kotlin.f0 r5 = (kotlin.f0) r1.f(kotlin.v.a(r2), Integer.valueOf(r3), Boolean.valueOf(r4));
            return;
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ kotlin.f0 f(kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g> r1, Integer r2, Boolean r3) {
            a(r1.i(), r2.intValue(), r3.booleanValue());
            return kotlin.f0.f18324a;
        }
    }

    static final class w extends kotlin.n0.d.q implements kotlin.n0.c.l<String, kotlin.u<? extends Boolean, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.q f694f;

        w(kotlin.n0.c.q r1) {
            this.f694f = r1;
            super(1);
        }

        public final kotlin.u<Boolean, String> a(String r4) {
            kotlin.n0.d.o.g(r4, "reason");
            s0.f1065a.e("MainTicketGuardManager", "startKeyAttestation fail, reason=" + r4);
            kotlin.n0.c.q r3 = this.f694f;
            if (r3 == null) goto L6;
            kotlin.v.a r0 = kotlin.v.f21457g;
            Object r1 = kotlin.w.a(new IllegalStateException(r4));
            kotlin.v.b(r1);
            kotlin.f0 r5 = (kotlin.f0) r3.f(kotlin.v.a(r1), 0, Boolean.TRUE);
        L6:
            return kotlin.a0.a(Boolean.FALSE, r4);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.u<? extends Boolean, ? extends String> invoke(String r1) {
            return a(r1);
        }
    }

    static final /* synthetic */ class x extends kotlin.n0.d.l implements kotlin.n0.c.l<Integer, com.bytedance.android.sdk.bdticketguard.g> {
        x(a0 r2) {
            super(1, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "doAttestation";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return kotlin.n0.d.e0.b(a0.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "doAttestation(I)Lcom/bytedance/android/sdk/bdticketguard/AttestationResult;";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.g invoke(Integer r1) {
            return m(r1.intValue());
        }

        public final com.bytedance.android.sdk.bdticketguard.g m(int r1) {
            return a0.Z((a0) this.receiver, r1);
        }
    }

    static final class y extends kotlin.n0.d.q implements kotlin.n0.c.a<com.bytedance.android.sdk.bdticketguard.o1.g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f695f;

        y(a0 r1) {
            this.f695f = r1;
            super(0);
        }

        public final com.bytedance.android.sdk.bdticketguard.o1.g a() {
            return new com.bytedance.android.sdk.bdticketguard.o1.g(this.f695f.G().e(), "TicketGuardManager", com.bytedance.android.sdk.bdticketguard.o1.h.b("bd-ticket-guard", "", "", ""));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.g invoke() {
            return a();
        }
    }

    static final class z extends kotlin.n0.d.q implements kotlin.n0.c.l<com.bytedance.android.sdk.bdticketguard.m1.c, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l f696f;

        z(kotlin.n0.c.l r1) {
            this.f696f = r1;
            super(1);
        }

        public final void a(com.bytedance.android.sdk.bdticketguard.m1.c r4) {
            kotlin.n0.d.o.g(r4, "it");
            if ((r4 instanceof com.bytedance.android.sdk.bdticketguard.m1.c.b) == false) goto L6;
            z0.f1102e.j("", (com.bytedance.android.sdk.bdticketguard.m1.c.b) r4);
        L8:
            kotlin.n0.c.l r3 = this.f696f;
            if (r3 == null) goto L12;
            kotlin.f0 r5 = (kotlin.f0) r3.invoke(r4);
            return;
        L12:
            return;
        L6:
            if ((r4 instanceof com.bytedance.android.sdk.bdticketguard.m1.c.d) == false) goto L8;
            z0.f1102e.k("", (com.bytedance.android.sdk.bdticketguard.m1.c.d) r4);
            goto L8
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(com.bytedance.android.sdk.bdticketguard.m1.c r1) {
            a(r1);
            return kotlin.f0.f18324a;
        }
    }

    static {
        p = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a0.class), "sp", "getSp()Landroid/content/SharedPreferences;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a0.class), "teeKeyHelper", "getTeeKeyHelper()Lcom/bytedance/android/sdk/bdticketguard/key/TeeKeyHelper;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a0.class), "reeKeyHelper", "getReeKeyHelper()Lcom/bytedance/android/sdk/bdticketguard/key/ReeKeyHelper;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a0.class), "savedTicketData", "getSavedTicketData()Ljava/util/Map;"))};
    }

    public a0() {
        this.f642f = new AtomicBoolean(false);
        this.f643g = new AtomicBoolean(false);
        this.f644h = new ArrayList();
        this.f646j = kotlin.i0.m0.k(new kotlin.u[]{kotlin.a0.a("ree", new com.bytedance.android.sdk.bdticketguard.y()), kotlin.a0.a("tee", new com.bytedance.android.sdk.bdticketguard.y()), kotlin.a0.a("encryption", new com.bytedance.android.sdk.bdticketguard.y())});
        this.f647k = kotlin.i.b(new u(this));
        this.f648l = kotlin.i.b(new y(this));
        this.m = kotlin.i.b(new r(this));
        this.n = kotlin.i.b(new t(this));
    }

    @RequiresApi(24)
    @SuppressLint({"UseSdkSuppress"})
    private final com.bytedance.android.sdk.bdticketguard.f B0(com.bytedance.android.sdk.bdticketguard.i r22, com.bytedance.android.sdk.bdticketguard.o1.j.f r23) {
        kotlin.v.a r0 = kotlin.v.f21457g;     // Catch: Throwable -> L5
        Object r1 = r23.a().a(r22, r23);     // Catch: Throwable -> L5
        kotlin.v.b(r1);     // Catch: Throwable -> L5
    L7:
        Object r4 = r1;
        i0 r5 = null;
        boolean r6 = true;
        if (this.f645i == null) goto L62;
        String r2 = this.f645i;
        if (r2 == null) goto L12;
        String r12 = r2;
        Throwable r3 = null;
    L25:
        if (kotlin.v.g(r4) == true) goto L27;
        r22.q(kotlin.v.d(r4));
    L31:
        i0 r13 = r5;
        if (r12.length() <= 0) goto L34;
        boolean r7 = true;
    L35:
        if (r7 == true) goto L39;
        if (r13 != null) goto L39;
        boolean r8 = false;
    L40:
        if (r8 == true) goto L45;
        if (r3 == null) goto L44;
        throw r3;
    L44:
        throw new com.bytedance.android.sdk.bdticketguard.c(-1104, "Cert chain is empty without alternate params", null, 4, null);
    L45:
        s0 r9 = s0.f1065a;
        StringBuilder r10 = new StringBuilder();
        r10.append("[Attestation] prepareAttestationRequest, certChain=");
        if (r12.length() <= 0) goto L48;
        boolean r11 = true;
    L49:
        r10.append(r11);
        r10.append(", ");
        r10.append("alternateRequestParams=");
        if (r13 != null) goto L53;
        r6 = false;
    L53:
        r10.append(r6);
        r9.e("MainTicketGuardManager", r10.toString());
        if (r13 == null) goto L56;
        r22.A(kotlin.i0.t0.i(r22.h(), r13.c()));
    L56:
        if (r3 == null) goto L58;
        r22.A(kotlin.i0.t0.i(r22.h(), "cert_chain"));
    L58:
        r22.r(r3);
        return new com.bytedance.android.sdk.bdticketguard.f(r23.e(), r23.c(), r23.b(), r12, r13);
    L48:
        r11 = false;
    L39:
        r8 = true;
        goto L40
    L34:
        r7 = false;
        goto L35
    L27:
        if (kotlin.v.f(r4) == false) goto L29;
        r4 = null;
    L29:
        r5 = (i0) r4;
        goto L31
    L12:
        kotlin.n0.d.o.p();
        throw null;
    L62:
        String r14 = u0().w(r22, r23);     // Catch: Throwable -> L21
        if (r14.length() <= 0) goto L17;
        boolean r15 = true;
    L18:
        if (r15 == false) goto L20;
        this.f645i = r14;     // Catch: Throwable -> L21
    L20:
        r3 = null;
    L23:
        r12 = r14;
        goto L25
    L17:
        r15 = false;
    L21:
        th = move-exception;
        r3 = th;
        r14 = "";
    L5:
        th = move-exception;
        kotlin.v.a r16 = kotlin.v.f21457g;
        r1 = kotlin.w.a(th);
        kotlin.v.b(r1);
        goto L7
    }

    private final void D0(com.bytedance.android.sdk.bdticketguard.n1.b r2, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r3, String r4) {
        S(new s(this, r3, r2), r4);
    }

    private final void E0(com.bytedance.android.sdk.bdticketguard.g r1) {
        com.bytedance.android.sdk.bdticketguard.o1.j.e.f994e.f(r1);
    }

    private final void F0(kotlin.n0.c.q<? super kotlin.v<com.bytedance.android.sdk.bdticketguard.g>, ? super Integer, ? super Boolean, kotlin.f0> r11) {
        com.bytedance.android.sdk.bdticketguard.p1.k r9 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J;
        if (r9.z().b().booleanValue() == false) goto L6;
        s0 r0 = s0.f1065a;
        r0.e("MainTicketGuardManager", "switch changed to true, start key attestation");
        TimeUnit r2 = TimeUnit.SECONDS;
        long r3 = r2.toMillis(r9.I().b().longValue());
        long r5 = r2.toMillis(r9.K().b().longValue());
        int r7 = r9.J().b().intValue();
        r0.e("MainTicketGuardManager", "[AttestationStart] onSettingsChanged, initialDelayMs=" + r3 + ", retryIntervalMs=" + r5 + ", maxAttempts=" + r7);
        j(false, false, r3, r5, r7, r11);
        r9.e(this.o);
        this.o = null;
        return;
    }

    public static final /* synthetic */ void Y(a0 r0) {
        r0.j0();
    }

    public static final /* synthetic */ com.bytedance.android.sdk.bdticketguard.g Z(a0 r0, int r1) {
        return r0.m0(r1);
    }

    public static final /* synthetic */ com.bytedance.android.sdk.bdticketguard.g a0(a0 r0, com.bytedance.android.sdk.bdticketguard.i r1, com.bytedance.android.sdk.bdticketguard.f r2, com.bytedance.android.sdk.bdticketguard.o1.j.g r3) {
        return r0.n0(r1, r2, r3);
    }

    public static final /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.d b0(a0 r0) {
        return r0.r0();
    }

    public static final /* synthetic */ Map c0(a0 r0) {
        return r0.s0();
    }

    public static final /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.g d0(a0 r0) {
        return r0.u0();
    }

    public static final /* synthetic */ void e0(a0 r0, Object r1, int r2, boolean r3) {
        r0.v0(r1, r2, r3);
    }

    public static final /* synthetic */ void f0(a0 r0, String r1, boolean r2, kotlin.n0.c.p r3) {
        r0.w0(r1, r2, r3);
    }

    public static final /* synthetic */ void g0(a0 r0, com.bytedance.android.sdk.bdticketguard.n1.c r1, String r2, kotlin.n0.c.p r3) {
        r0.z0(r1, r2, r3);
    }

    public static final /* synthetic */ com.bytedance.android.sdk.bdticketguard.f h0(a0 r0, com.bytedance.android.sdk.bdticketguard.i r1, com.bytedance.android.sdk.bdticketguard.o1.j.f r2) {
        return r0.B0(r1, r2);
    }

    public static final /* synthetic */ void i0(a0 r0, kotlin.n0.c.q r1) {
        r0.F0(r1);
    }

    private final void j0() {
        if (com.bytedance.android.sdk.bdticketguard.n1.g.f895h.d() == true) goto L25;
        Collection<com.bytedance.android.sdk.bdticketguard.y> r3 = this.f646j.values();
        boolean r1 = false;
        if ((r3 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        if (((com.bytedance.android.sdk.bdticketguard.y) r4.next()).b() == null) goto L15;
        boolean r0 = true;
    L16:
        if (r0 == true) goto L11;
    L17:
        if (r1 == false) goto L26;
        com.bytedance.android.sdk.bdticketguard.n1.g.f895h.f();
        return;
    L26:
        return;
    L15:
        r0 = false;
    L8:
        r1 = true;
        goto L17
    L7:
        if (r3.isEmpty() == false) goto L9;
    }

    @RequiresApi(24)
    @SuppressLint({"UseSdkSuppress"})
    private final com.bytedance.android.sdk.bdticketguard.g m0(int r40) {
        s0 r1 = s0.f1065a;
        r1.e("MainTicketGuardManager", "startKeyAttestation task, retryCount=" + r40);
        com.bytedance.android.sdk.bdticketguard.p1.k r2 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J;
        if (r2.z().b().booleanValue() == false) goto L134;
        if (r2.J().b().intValue() <= 0) goto L134;
        boolean r5 = true;
        com.bytedance.android.sdk.bdticketguard.h.a(!kotlin.n0.d.o.a(Looper.myLooper(), Looper.getMainLooper()), a.f649f);
        if (r2.q().b().booleanValue() == false) goto L9;
        r1.e("MainTicketGuardManager", "doAttestation trigger init");
        O("ticket_network", null);
        N("ticket_network", null);
        M("ticket_network", null);
    L9:
        com.bytedance.android.sdk.bdticketguard.n1.c r3 = y(com.bytedance.android.sdk.bdticketguard.n1.b.f869h);
        com.bytedance.android.sdk.bdticketguard.n1.c.g r4 = com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b;
        com.bytedance.android.sdk.bdticketguard.h.a(kotlin.n0.d.o.a(r3, r4), new b(r3));
        com.bytedance.android.sdk.bdticketguard.n1.c r6 = y(com.bytedance.android.sdk.bdticketguard.n1.b.f868g);
        com.bytedance.android.sdk.bdticketguard.h.a(kotlin.n0.d.o.a(r6, r4), new c(r6));
        com.bytedance.android.sdk.bdticketguard.o1.i r7 = u0().h();
        if (r7 == null) goto L12;
        String r8 = r7.c();
    L13:
        if (r8 != null) goto L15;
    L18:
        boolean r9 = true;
    L19:
        if (r9 == false) goto L22;
        CountDownLatch r10 = new CountDownLatch(1);
        R(new d(r10));
        r10.await(r2.m().b().longValue(), TimeUnit.SECONDS);     // Catch: InterruptedException -> L135
    L22:
        com.bytedance.android.sdk.bdticketguard.o1.i r11 = u0().h();
        com.bytedance.android.sdk.bdticketguard.o1.e r12 = r0().h();
        if (r11 == null) goto L25;
        String r13 = r11.c();
    L26:
        if (r13 != null) goto L28;
    L31:
        boolean r14 = true;
    L32:
        if (r14 == true) goto L132;
        if (r11 == null) goto L36;
        String r15 = r11.f(2);
    L37:
        if (r12 == null) goto L39;
        String r16 = r12.d(2);
    L40:
        com.bytedance.android.sdk.bdticketguard.g r17 = y0();
        if (r15 != null) goto L43;
    L46:
        boolean r18 = true;
    L47:
        com.bytedance.android.sdk.bdticketguard.h.a(!r18, e.f653f);
        if (r16 != null) goto L50;
    L53:
        boolean r19 = true;
    L54:
        com.bytedance.android.sdk.bdticketguard.h.a(!r19, f.f654f);
        if (r17 != null) goto L57;
    L67:
        boolean r20 = false;
    L68:
        if (r17 != null) goto L70;
    L72:
        boolean r21 = false;
    L73:
        if (r17 != null) goto L75;
    L77:
        boolean r22 = false;
    L78:
        if (r21 == true) goto L82;
        if (r22 == true) goto L82;
        boolean r110 = false;
    L91:
        com.bytedance.android.sdk.bdticketguard.o1.j.d r111 = com.bytedance.android.sdk.bdticketguard.o1.j.d.f987d;
        if (r17 == null) goto L94;
        String r112 = r17.a();
    L95:
        com.bytedance.android.sdk.bdticketguard.o1.j.g r113 = r111.b(r112);
        com.bytedance.android.sdk.bdticketguard.o1.j.g r114 = r111.e();
        if ((!kotlin.n0.d.o.a(r113.f(), r114.f())) == true) goto L98;
    L100:
        boolean r23 = false;
    L101:
        if (r20 == false) goto L106;
        if (r110 == true) goto L106;
        if (r23 == true) goto L106;
        boolean r115 = false;
    L107:
        if (r115 == false) goto L129;
        s0 r116 = s0.f1065a;
        r116.e("MainTicketGuardManager", "getAttestationAdapter: " + r114.f());
        com.bytedance.android.sdk.bdticketguard.i r24 = new com.bytedance.android.sdk.bdticketguard.i(false, null, false, 0, null, null, false, false, false, false, false, null, null, null, null, null, null, null, null, null, 1048575, null);
        if (r22 == false) goto L112;
        if (r17 == null) goto L112;
        String r117 = r17.d();
    L113:
        r24.w(r117);
        if (r21 == false) goto L117;
        if (r17 == null) goto L117;
        String r25 = r17.e();
    L118:
        r24.x(r25);
        r24.C(r15);
        r24.z(r16);
        r24.m(r13);
        r24.t(r20);
        r24.j(r114.f());
        r24.v(r113.f());
        r24.B(r21);
        r24.y(r22);
        r24.u(r23);
        if (r20 == false) goto L122;
    L125:
        u0().t(r113, r114);
        r24.n(true);
    L127:
        kotlin.u r26 = com.bytedance.android.sdk.bdticketguard.q1.c.b(new g(this, r24, new com.bytedance.android.sdk.bdticketguard.o1.j.f(r15, r13, r16, r114, r5)));
        com.bytedance.android.sdk.bdticketguard.f r27 = (com.bytedance.android.sdk.bdticketguard.f) r26.a();
        long r118 = ((Number) r26.b()).longValue();
        r116.e("MainTicketGuardManager", "local attestation complete, do request");
        kotlin.u r0 = com.bytedance.android.sdk.bdticketguard.q1.c.b(new h(this, r24, r27, r114));
        com.bytedance.android.sdk.bdticketguard.g r28 = (com.bytedance.android.sdk.bdticketguard.g) r0.a();
        r28.f(new com.bytedance.android.sdk.bdticketguard.g.a(r118, ((Number) r0.b()).longValue(), r24));
        return r28;
    L122:
        if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.o().b().booleanValue() == true) goto L124;
    L126:
        r5 = false;
        goto L127
    L124:
        if (com.bytedance.android.sdk.bdticketguard.o1.f.f959b.k() == true) goto L126;
    L117:
        r25 = null;
    L112:
        r117 = null;
        goto L113
    L129:
        s0.f1065a.e("MainTicketGuardManager", "startKeyAttestation fail, no need for attestation");
        throw new com.bytedance.android.sdk.bdticketguard.b(r17);
    L106:
        r115 = true;
        goto L107
    L98:
        if (r114.h() == false) goto L100;
        r23 = true;
        goto L101
    L94:
        r112 = null;
    L82:
        s0 r119 = s0.f1065a;
        r119.e("MainTicketGuardManager", "startKeyAttestation NEED RE-ATTEST. tee or ree key changed, isTeeChanged=" + r21 + ", isReeChanged=" + r22 + '\n');
        StringBuilder r120 = new StringBuilder();
        r120.append("old tee public key: ");
        if (r17 == null) goto L85;
        String r121 = r17.e();
    L86:
        r120.append(r121);
        r120.append("\n new tee public key: ");
        r120.append(r15);
        r120.append('\n');
        r119.e("MainTicketGuardManager", r120.toString());
        StringBuilder r122 = new StringBuilder();
        r122.append("old ree public key: ");
        if (r17 == null) goto L89;
        String r123 = r17.d();
    L90:
        r122.append(r123);
        r122.append("\n new ree public key: ");
        r122.append(r16);
        r122.append('\n');
        r119.e("MainTicketGuardManager", r122.toString());
        z0.f1102e.g(r21, r22);
        r110 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.F().b().booleanValue();
        goto L91
    L89:
        r123 = null;
        goto L90
    L85:
        r121 = null;
        goto L86
    L75:
        if (com.bytedance.android.sdk.bdticketguard.q1.c.a(r17.d(), r16) == true) goto L77;
        r22 = true;
        goto L78
    L70:
        if (com.bytedance.android.sdk.bdticketguard.q1.c.a(r17.e(), r15) == true) goto L72;
        r21 = true;
        goto L73
    L57:
        if (r17.e().length() <= 0) goto L59;
        boolean r29 = true;
    L60:
        if (r29 == false) goto L67;
        if (r17.d().length() <= 0) goto L64;
        boolean r30 = true;
    L65:
        if (r30 == false) goto L67;
        r20 = true;
        goto L68
    L64:
        r30 = false;
        goto L65
    L59:
        r29 = false;
        goto L60
    L50:
        if (r16.length() == 0) goto L53;
        r19 = false;
        goto L54
    L43:
        if (r15.length() == 0) goto L46;
        r18 = false;
        goto L47
    L39:
        r16 = null;
        goto L40
    L36:
        r15 = null;
        goto L37
    L132:
        throw new com.bytedance.android.sdk.bdticketguard.c(-1003, "clientCert is empty", null, 4, null);
    L28:
        if (r13.length() == 0) goto L31;
        r14 = false;
        goto L32
    L25:
        r13 = null;
        goto L26
    L15:
        if (r8.length() == 0) goto L18;
        r9 = false;
        goto L19
    L12:
        r8 = null;
    L134:
        throw new com.bytedance.android.sdk.bdticketguard.d();
    }

    private final com.bytedance.android.sdk.bdticketguard.g n0(com.bytedance.android.sdk.bdticketguard.i r1, com.bytedance.android.sdk.bdticketguard.f r2, com.bytedance.android.sdk.bdticketguard.o1.j.g r3) {
        return h1.a(r1, r2, r3.f());
    }

    private final com.bytedance.android.sdk.bdticketguard.o1.d r0() {
        kotlin.h r2 = this.m;
        kotlin.s0.l r0 = p[2];
        return (com.bytedance.android.sdk.bdticketguard.o1.d) r2.getValue();
    }

    private final Map<String, w0> s0() {
        kotlin.h r2 = this.n;
        kotlin.s0.l r0 = p[3];
        return (Map) r2.getValue();
    }

    private final SharedPreferences t0() {
        kotlin.h r2 = this.f647k;
        kotlin.s0.l r0 = p[0];
        return (SharedPreferences) r2.getValue();
    }

    private final com.bytedance.android.sdk.bdticketguard.o1.g u0() {
        kotlin.h r2 = this.f648l;
        kotlin.s0.l r0 = p[1];
        return (com.bytedance.android.sdk.bdticketguard.o1.g) r2.getValue();
    }

    private final void v0(Object r7, int r8, boolean r9) {
        s0.f1065a.e("MainTicketGuardManager", "startKeyAttestation callback, result=" + kotlin.v.h(r7) + ", retryCount=" + r8 + ", isLastAttempt=" + r9);
        if ((!this.f644h.isEmpty()) == false) goto L17;
        List<kotlin.n0.c.q<kotlin.v<com.bytedance.android.sdk.bdticketguard.g>, Integer, Boolean, kotlin.f0>> r0 = this.f644h;
        monitor-enter(r0);
        Iterator<T> r1 = this.f644h.iterator();     // Catch: Throwable -> L13
    L8:
        if (r1.hasNext() == false) goto L10;
        ((kotlin.n0.c.q) r1.next()).f(kotlin.v.a(r7), Integer.valueOf(r8), Boolean.valueOf(r9));     // Catch: Throwable -> L13
        goto L8
    L10:
        kotlin.f0 r2 = kotlin.f0.f18324a;     // Catch: Throwable -> L13
        monitor-exit(r0);
    L13:
        th = move-exception;
        throw th;
    L17:
        if ((kotlin.v.d(r7) instanceof com.bytedance.android.sdk.bdticketguard.d) == false) goto L21;
        s0.f1065a.e("MainTicketGuardManager", "Key attestation not enabled");
        return;
    L21:
        if ((kotlin.v.d(r7) instanceof com.bytedance.android.sdk.bdticketguard.b) == false) goto L26;
        s0.f1065a.e("MainTicketGuardManager", "Key attestation failed: " + kotlin.v.d(r7));
        if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.n().b().booleanValue() == true) goto L26;
        return;
    L26:
        if (kotlin.v.g(r7) == false) goto L34;
        s0.f1065a.e("MainTicketGuardManager", "Key attestation succeeded");
        if (kotlin.v.f(r7) == false) goto L30;
        Object r3 = null;
    L31:
        com.bytedance.android.sdk.bdticketguard.g r4 = (com.bytedance.android.sdk.bdticketguard.g) r3;
        if (r4 == null) goto L34;
        E0(r4);
        com.bytedance.android.sdk.bdticketguard.o1.j.c.f980h.h(r4);
        goto L34
    L30:
        r3 = r7;
    L34:
        z0.z(r7, r8, r9);
    }

    private final void w0(String r1, boolean r2, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r3) {
        com.bytedance.android.sdk.bdticketguard.n1.b r0 = com.bytedance.android.sdk.bdticketguard.n1.b.f873l.a(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 != true) goto L7;
        com.bytedance.android.sdk.bdticketguard.n1.c.f r4 = com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b;
    L9:
        if (r3 == null) goto L15;
        kotlin.f0 r5 = r3.invoke(r0, r4);
        return;
    L15:
        return;
    L7:
        if (r2 == true) goto L13;
        r4 = com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;
        goto L9
    L13:
        throw new kotlin.m();
    }

    private final com.bytedance.android.sdk.bdticketguard.g y0() {
        return com.bytedance.android.sdk.bdticketguard.o1.j.e.f994e.b();
    }

    private final void z0(com.bytedance.android.sdk.bdticketguard.n1.c r11, String r12, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r13) {
        kotlin.n0.d.a0 r6 = new kotlin.n0.d.a0();
        r6.f18427f = false;
        kotlin.n0.d.d0 r2 = new kotlin.n0.d.d0();
        com.bytedance.android.sdk.bdticketguard.n1.g r7 = com.bytedance.android.sdk.bdticketguard.n1.g.f895h;
        com.bytedance.android.sdk.bdticketguard.n1.b r8 = com.bytedance.android.sdk.bdticketguard.n1.b.f870i;
        r7.b(r8, r13, new o(this, r2, r11, r12, r6));
        s0.f1065a.a("MainTicketGuardManager", "loadEncryptionInner, shouldRequestCert=" + r6.f18427f);
        if (r6.f18427f == false) goto L6;
        D0(r8, r13, r12);
        return;
    }

    public final Map<String, w0> A0() {
        s0.f1065a.a("MainTicketGuardManager", "load savedTicketData start");
        LinkedHashMap r0 = new LinkedHashMap();
        SharedPreferences.Editor r2 = t0().edit();
        Set<String> r3 = t0().getStringSet("sp_key_saved_ticket_data", null);
        if (r3 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == true) goto L30;
        Iterator<String> r9 = r3.iterator();
        boolean r10 = false;
    L12:
        if (r9.hasNext() == false) goto L28;
        String r11 = r9.next();
        String r12 = t0().getString(r11, null);
        if (r12 != null) goto L16;
    L19:
        boolean r13 = true;
    L20:
        if (r13 == true) goto L12;
        w0 r14 = (w0) x().m(r12, w0.class);     // Catch: Throwable -> L26
        if (r14 == null) goto L12;
        kotlin.n0.d.o.b(r11, WsConstants.KEY_CONNECTION_TYPE);     // Catch: Throwable -> L26
        r0.put(r11, r14);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r9.remove();
        r2.remove(r11);
        String r15 = Log.getStackTraceString(th);
        kotlin.n0.d.o.b(r15, "Log.getStackTraceString(e)");
        z0.I("load_ticket_data", r12, r15);
        r10 = true;
        goto L12
    L16:
        if (r12.length() == 0) goto L19;
        r13 = false;
        goto L20
    L28:
        if (r10 == false) goto L30;
        r2.putStringSet("sp_key_saved_ticket_data", r3);
        r2.apply();
    L30:
        s0.f1065a.a("MainTicketGuardManager", "load savedTicketData finish");
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r8 = false;
        goto L9
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String B() {
        String r0 = r0().f();
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String C() {
        String r0 = u0().f();
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0;
    }

    @VisibleForTesting
    public final void C0(w0 r4) {
        kotlin.n0.d.o.g(r4, "ticketData");
        z0.f1102e.N(r4);
        String r5 = r4.e();
        s0.f1065a.a("MainTicketGuardManager", "remove ticket data, type=" + r5);
        s0().remove(r5);
        SharedPreferences.Editor r0 = t0().edit();
        r0.remove(r5);
        r0.putStringSet("sp_key_saved_ticket_data", s0().keySet());
        r0.apply();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public boolean D() {
        return u0().x();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String E() {
        com.bytedance.android.sdk.bdticketguard.o1.i r1 = u0().h();
        if (r1 == null) goto L7;
        String r2 = r1.f(0);
        if (r2 == null) goto L7;
        return r2;
    L7:
        return "";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public w0 F(String r3) {
        kotlin.n0.d.o.g(r3, "ticket");
        Iterator<w0> r2 = s0().values().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        w0 r0 = r2.next();
        if (kotlin.n0.d.o.a(r0.b(), r3) == false) goto L4;
        s0.f1065a.a("MainTicketGuardManager", "getTicketData success");
        return r0;
    L9:
        return null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void H(kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r6) {
        if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.D().b().booleanValue() == false) goto L20;
        com.bytedance.android.sdk.bdticketguard.n1.b r0 = com.bytedance.android.sdk.bdticketguard.n1.b.f869h;
        com.bytedance.android.sdk.bdticketguard.n1.c r1 = y(r0);
        com.bytedance.android.sdk.bdticketguard.n1.c.g r2 = com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b;
        if ((!kotlin.n0.d.o.a(r1, r2)) == true) goto L13;
        com.bytedance.android.sdk.bdticketguard.n1.b r3 = com.bytedance.android.sdk.bdticketguard.n1.b.f870i;
        if ((!kotlin.n0.d.o.a(y(r3), r2)) == true) goto L13;
        if (r6 == null) goto L11;
        kotlin.f0 r4 = r6.invoke(r0, r2);
    L11:
        if (r6 == null) goto L14;
        kotlin.f0 r5 = r6.invoke(r3, r2);
    L14:
        com.bytedance.android.sdk.bdticketguard.n1.b r7 = com.bytedance.android.sdk.bdticketguard.n1.b.f868g;
        if ((!kotlin.n0.d.o.a(y(r7), r2)) == false) goto L17;
        J(new com.bytedance.android.sdk.bdticketguard.n1.f("initData", new k(this, r6)));
    L19:
        s(l.f668f);
        return;
    L17:
        if (r6 == null) goto L19;
        kotlin.f0 r8 = r6.invoke(r7, r2);
    L13:
        J(new com.bytedance.android.sdk.bdticketguard.n1.e("initData", new j(this, r6)));
        goto L14
    L20:
        V("init", r6);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void J(com.bytedance.android.sdk.bdticketguard.n1.d r2) {
        kotlin.n0.d.o.g(r2, "task");
        if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.D().b().booleanValue() == false) goto L5;
        com.bytedance.android.sdk.bdticketguard.n1.i.f904c.c(r2);
        return;
    L5:
        kotlin.n0.c.a<kotlin.f0> r3 = r2.b();
        Object r4 = r3;
        if (r3 == null) goto L8;
        r4 = new b0(r3);
    L8:
        new Thread((Runnable) r4).start();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    protected void K(String r10) {
        kotlin.n0.d.o.g(r10, "path");
        com.bytedance.android.sdk.bdticketguard.p1.k r2 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J;
        if (r2.G().b().booleanValue() == true) goto L5;
    L13:
        s0 r0 = s0.f1065a;
        StringBuilder r3 = new StringBuilder();
        String r4 = "invalidateAttestsByHeader, switch is off, path: ";
    L14:
        r3.append(r4);
        r3.append(r10);
        r0.e("MainTicketGuardManager", r3.toString());
        return;
    L5:
        if (r2.z().b().booleanValue() == false) goto L13;
        if (this.f642f.compareAndSet(false, true) == false) goto L12;
        s0 r5 = s0.f1065a;
        r5.e("MainTicketGuardManager", "invalidateAttestsByHeader, path: " + r10);
        k0();
        long r6 = TimeUnit.SECONDS.toMillis(r2.K().b().longValue());
        int r7 = r2.J().b().intValue();
        r5.e("MainTicketGuardManager", "invalidateAttestsByHeader, startKeyAttestation. RetryInterval: " + r6 + ", maxAttempts: " + r7);
        if (this.f643g.get() == false) goto L11;
        r5.e("MainTicketGuardManager", "[AttestationStart] invalidateByHeader, path=" + r10 + ", retryIntervalMs=" + r6 + ", maxAttempts=" + r7);
        j(true, false, 0, r6, r7, null);
        return;
    L11:
        r5.e("MainTicketGuardManager", "invalidateAttestsByHeader, startKeyAttestation, isInitAttestationStarted is false, wait for init");
        return;
    L12:
        r0 = s0.f1065a;
        r3 = new StringBuilder();
        r4 = "invalidateAttestsByHeader fail, already invalidated this run, path: ";
        goto L14
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void M(String r2, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r3) {
        kotlin.n0.d.o.g(r2, "scene");
        if (com.bytedance.android.sdk.bdticketguard.n1.g.f895h.d() == false) goto L7;
        kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r0 = new m(this, r2, r3);
    L5:
        N(r2, r0);
        return;
    L7:
        r0 = new n(this, r2, r3);
        goto L5
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void N(String r5, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r6) {
        kotlin.n0.d.o.g(r5, "scene");
        com.bytedance.android.sdk.bdticketguard.n1.g r0 = com.bytedance.android.sdk.bdticketguard.n1.g.f895h;
        if (r0.d() == false) goto L6;
        r0.b(com.bytedance.android.sdk.bdticketguard.n1.b.f869h, r6, new p(this, r5));
        return;
    L6:
        com.bytedance.android.sdk.bdticketguard.y r1 = this.f646j.get("ree");
        if (r1 == null) goto L27;
        com.bytedance.android.sdk.bdticketguard.y r2 = r1;
        Boolean r3 = r2.b();
        Boolean r4 = Boolean.TRUE;
        if ((!kotlin.n0.d.o.a(r3, r4)) == false) goto L21;
        Object r7 = r2.a();
        monitor-enter(r7);
    L18:
        th = move-exception;
        throw th;
    L13:
        if ((!kotlin.n0.d.o.a(r2.b(), r4)) == false) goto L15;
        r2.c(Boolean.valueOf(r0().q(r5)));     // Catch: Throwable -> L18
    L15:
        kotlin.f0 r8 = kotlin.f0.f18324a;     // Catch: Throwable -> L18
        monitor-exit(r7);
    L21:
        j0();
        Boolean r9 = r2.b();
        if (r9 == null) goto L24;
        boolean r10 = r9.booleanValue();
    L25:
        w0("ree", r10, r6);
        return;
    L24:
        r10 = false;
        goto L25
    L27:
        kotlin.n0.d.o.p();
        throw null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void O(String r7, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r8) {
        kotlin.n0.d.o.g(r7, "scene");
        com.bytedance.android.sdk.bdticketguard.n1.g r0 = com.bytedance.android.sdk.bdticketguard.n1.g.f895h;
        if (r0.d() == false) goto L6;
        r0.b(com.bytedance.android.sdk.bdticketguard.n1.b.f868g, r8, new q(this, r7));
        return;
    L6:
        com.bytedance.android.sdk.bdticketguard.y r1 = this.f646j.get("tee");
        if (r1 == null) goto L50;
        com.bytedance.android.sdk.bdticketguard.y r2 = r1;
        Boolean r3 = r2.b();
        Boolean r4 = Boolean.TRUE;
        boolean r5 = false;
        if ((!kotlin.n0.d.o.a(r3, r4)) == false) goto L45;
        Object r6 = r2.a();
        monitor-enter(r6);
    L42:
        th = move-exception;
        throw th;
    L13:
        if ((!kotlin.n0.d.o.a(r2.b(), r4)) == false) goto L39;
        boolean r9 = u0().q(r7);     // Catch: Throwable -> L42
        r2.c(Boolean.valueOf(r9));     // Catch: Throwable -> L42
        w0("tee", r9, r8);     // Catch: Throwable -> L42
        if (kotlin.n0.d.o.a(r2.b(), r4) == false) goto L37;
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L42
        Iterator<w0> r11 = s0().values().iterator();     // Catch: Throwable -> L42
    L18:
        if (r11.hasNext() == false) goto L31;
        w0 r12 = r11.next();     // Catch: Throwable -> L42
        String r13 = r12.a();     // Catch: Throwable -> L42
        if (r13 != null) goto L22;
    L25:
        boolean r14 = true;
    L26:
        if (r14 == true) goto L18;
        if (kotlin.n0.d.o.a(u0().z(r13), Boolean.FALSE) == false) goto L18;
        r10.add(r12);     // Catch: Throwable -> L42
        goto L18
    L22:
        if (r13.length() == 0) goto L25;
        r14 = false;
        goto L26
    L31:
        if ((!r10.isEmpty()) == false) goto L37;
        Iterator r15 = r10.iterator();     // Catch: Throwable -> L42
    L34:
        if (r15.hasNext() == false) goto L37;
        C0((w0) r15.next());     // Catch: Throwable -> L42
    L37:
        monitor-exit(r6);
        return;
    L39:
        kotlin.f0 r16 = kotlin.f0.f18324a;     // Catch: Throwable -> L42
        monitor-exit(r6);
    L45:
        j0();
        Boolean r17 = r2.b();
        if (r17 == null) goto L48;
        r5 = r17.booleanValue();
    L48:
        w0("tee", r5, r8);
        return;
    L50:
        kotlin.n0.d.o.p();
        throw null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void U(String r2) {
        kotlin.n0.d.o.g(r2, "reason");
        u0().s(r2, null);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void X(w0 r4) {
        kotlin.n0.d.o.g(r4, "ticketData");
        s0.f1065a.a("MainTicketGuardManager", "realUpdateTicketData start");
        String r0 = x().v(r4).toString();
        s0().put(r4.e(), r4);
        SharedPreferences.Editor r1 = t0().edit();
        r1.putString(r4.e(), r0);
        r1.putStringSet("sp_key_saved_ticket_data", s0().keySet());
        r1.apply();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public void c(String r4, String r5) {
        s0.f1065a.a("MainTicketGuardManager", "realUpdateLocalCert: resClientCert=" + r4 + ", resServerCert=" + r5);
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        u0().I(r4);
    L11:
        if (r5 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == true) goto L18;
        r0().I(r5);
        return;
    L18:
        return;
    L13:
        if (r5.length() != 0) goto L15;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public String e(String r2, String r3) {
        kotlin.n0.d.o.g(r2, "unsigned");
        kotlin.n0.d.o.g(r3, "path");
        com.bytedance.android.sdk.bdticketguard.o1.d r1 = r0();
        byte[] r4 = r2.getBytes(kotlin.u0.d.f21429a);
        kotlin.n0.d.o.b(r4, "(this as java.lang.String).getBytes(charset)");
        byte[] r5 = r1.F(r4, r3);
        if (r5 != null) goto L5;
        return null;
    L5:
        return Base64.encodeToString(r5, 2);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public com.bytedance.android.sdk.bdticketguard.g f() {
        return com.bytedance.android.sdk.bdticketguard.o1.j.e.f994e.b();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public l0 g() {
        return r0().y();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public void h(kotlin.n0.c.q<? super kotlin.v<com.bytedance.android.sdk.bdticketguard.g>, ? super Integer, ? super Boolean, kotlin.f0> r2) {
        if (r2 == null) goto L11;
        List<kotlin.n0.c.q<kotlin.v<com.bytedance.android.sdk.bdticketguard.g>, Integer, Boolean, kotlin.f0>> r0 = this.f644h;
        monitor-enter(r0);
        this.f644h.add(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public kotlin.u<Boolean, String> j(boolean r16, boolean r17, long r18, long r20, int r22, kotlin.n0.c.q<? super kotlin.v<com.bytedance.android.sdk.bdticketguard.g>, ? super Integer, ? super Boolean, kotlin.f0> r23) {
        s0 r0 = s0.f1065a;
        r0.e("MainTicketGuardManager", "startKeyAttestation");
        w r13 = new w(r23);
        com.bytedance.android.sdk.bdticketguard.p1.k r1 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J;
        if (r1.z().b().booleanValue() == false) goto L59;
        if (r1.J().b().intValue() <= 0) goto L59;
        if (Build.VERSION.SDK_INT < 24) goto L10;
        if (r16 == false) goto L13;
    L16:
        monitor-enter(this);
        if (r16 == false) goto L60;
    L23:
        v r14 = new v(this, r16, r13, r23, r17, r18, r22, r20);     // Catch: Throwable -> L55
        if (r16 == false) goto L51;
        com.bytedance.android.sdk.bdticketguard.q1.b<com.bytedance.android.sdk.bdticketguard.g> r2 = this.f641e;     // Catch: Throwable -> L55
        if (r2 == null) goto L51;
        if (r17 == false) goto L43;
        if (r2 != null) goto L31;
        kotlin.n0.d.o.v("attestationExecutor");     // Catch: Throwable -> L55
        throw null;
    L31:
        if (r2.c() == true) goto L51;
        r0.e("MainTicketGuardManager", "Key attestation is in progress, force restart, shutdown");     // Catch: Throwable -> L55
        com.bytedance.android.sdk.bdticketguard.q1.b<com.bytedance.android.sdk.bdticketguard.g> r3 = this.f641e;     // Catch: Throwable -> L55
        if (r3 != null) goto L35;
        kotlin.n0.d.o.v("attestationExecutor");     // Catch: Throwable -> L55
        throw null;
    L35:
        if (r3.e() == true) goto L51;
        kotlin.u<Boolean, String> r4 = r13.a("Key attestation is already started, please wait for it to complete");     // Catch: Throwable -> L55
        monitor-exit(this);
        return r4;
    L43:
        if (r2 != null) goto L45;
        kotlin.n0.d.o.v("attestationExecutor");     // Catch: Throwable -> L55
        throw null;
    L45:
        if (r2.c() == true) goto L51;
        kotlin.u<Boolean, String> r5 = r13.a("Key attestation is in progress, please wait for it to complete");     // Catch: Throwable -> L55
        monitor-exit(this);
        return r5;
    L51:
        com.bytedance.android.sdk.bdticketguard.q1.b<com.bytedance.android.sdk.bdticketguard.g> r9 = new com.bytedance.android.sdk.bdticketguard.q1.b(r18, r22, r20, new x(this), r14);     // Catch: Throwable -> L55
        r9.f();     // Catch: Throwable -> L55
        this.f641e = r9;     // Catch: Throwable -> L55
        r0.e("MainTicketGuardManager", "Key attestation executor started");     // Catch: Throwable -> L55
        kotlin.f0 r6 = kotlin.f0.f18324a;     // Catch: Throwable -> L55
        monitor-exit(this);
        return kotlin.a0.a(Boolean.TRUE, "");
    L60:
    L55:
        th = move-exception;
        throw th;
    L19:
        if (this.f641e == null) goto L23;
        kotlin.u<Boolean, String> r7 = r13.a("Key attestation is already in progress");     // Catch: Throwable -> L55
        monitor-exit(this);
        return r7;
    L13:
        if (this.f641e == null) goto L16;
        return r13.a("Key attestation is already started");
    L10:
        return r13.a("Key attestation is not supported on this version of Android");
    L59:
        return r13.a("Key attestation is disabled");
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public String k(String r2, String r3) {
        kotlin.n0.d.o.g(r2, "content");
        kotlin.n0.d.o.g(r3, "path");
        com.bytedance.android.sdk.bdticketguard.o1.d r1 = r0();
        byte[] r4 = r2.getBytes(kotlin.u0.d.f21429a);
        kotlin.n0.d.o.b(r4, "(this as java.lang.String).getBytes(charset)");
        byte[] r5 = r1.A(r4, r3);
        if (r5 != null) goto L5;
        return null;
    L5:
        return Base64.encodeToString(r5, 2);
    }

    public void k0() {
        com.bytedance.android.sdk.bdticketguard.o1.j.e.f994e.a();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public void l(String r2, kotlin.n0.c.l<? super com.bytedance.android.sdk.bdticketguard.m1.c, kotlin.f0> r3) {
        kotlin.n0.d.o.g(r2, "secTs");
        com.bytedance.android.sdk.bdticketguard.o1.j.c.f980h.c(new com.bytedance.android.sdk.bdticketguard.m1.a(r2), new z(r3));
    }

    public byte[] l0(byte[] r8) {
        kotlin.n0.d.o.g(r8, "content");
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L8
        byte[] r7 = r0().s(r8);     // Catch: Throwable -> L8
        if (r7 == null) goto L6;
        z0.f1102e.l(null, System.currentTimeMillis() - r2);     // Catch: Throwable -> L8
    L7:
        return r7;
    L6:
        z0.f1102e.l("result is null", 0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        z0 r9 = z0.f1102e;
        r9.l(r9.d(th), 0);
        throw th;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public String m() {
        com.bytedance.android.sdk.bdticketguard.o1.i r0 = u0().h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public String o(String r2, String r3) {
        kotlin.n0.d.o.g(r2, "unsigned");
        kotlin.n0.d.o.g(r3, "path");
        com.bytedance.android.sdk.bdticketguard.o1.g r1 = u0();
        byte[] r4 = r2.getBytes(kotlin.u0.d.f21429a);
        kotlin.n0.d.o.b(r4, "(this as java.lang.String).getBytes(charset)");
        byte[] r5 = r1.H(r4, r3);
        if (r5 != null) goto L5;
        return null;
    L5:
        return Base64.encodeToString(r5, 2);
    }

    public byte[] o0(byte[] r2) {
        kotlin.n0.d.o.g(r2, "content");
        return r0().t(r2);
    }

    public String p0() {
        return r0().v();
    }

    public final Map<String, com.bytedance.android.sdk.bdticketguard.y> q0() {
        return this.f646j;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public kotlin.u<Boolean, String> s(kotlin.n0.c.q<? super kotlin.v<com.bytedance.android.sdk.bdticketguard.g>, ? super Integer, ? super Boolean, kotlin.f0> r12) {
        Boolean r1 = Boolean.FALSE;
        if (this.f643g.compareAndSet(false, true) == true) goto L6;
        s0.f1065a.e("MainTicketGuardManager", "startKeyAttestation fail, already started");
        return kotlin.a0.a(r1, "already started");
    L6:
        s0 r2 = s0.f1065a;
        r2.e("MainTicketGuardManager", "doInitKeyAttestation");
        com.bytedance.android.sdk.bdticketguard.p1.k r4 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J;
        if (r4.z().b().booleanValue() == false) goto L9;
        TimeUnit r3 = TimeUnit.SECONDS;
        long r5 = r3.toMillis(r4.I().b().longValue());
        long r9 = r3.toMillis(r4.K().b().longValue());
        int r7 = r4.J().b().intValue();
        r2.e("MainTicketGuardManager", "[AttestationStart] doInitKeyAttestation, initialDelayMs=" + r5 + ", retryIntervalMs=" + r9 + ", maxAttempts=" + r7);
        return j(false, false, r5, r9, r7, r12);
    L9:
        if (r4.H().b().booleanValue() == false) goto L12;
        r2.e("MainTicketGuardManager", "startKeyAttestation fail, switch is off, wait for settings change enabled");
        i r6 = new i(this, r12);
        r4.a(r6);
        this.o = r6;
        return kotlin.a0.a(r1, "switch is off, wait for settings change");
    L12:
        r2.e("MainTicketGuardManager", "startKeyAttestation fail, switch is off, wait for settings change disabled");
        return kotlin.a0.a(r1, "switch is off");
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String t() {
        com.bytedance.android.sdk.bdticketguard.g r1 = com.bytedance.android.sdk.bdticketguard.o1.j.e.f994e.b();
        if (r1 != null) goto L5;
        return "";
    L5:
        return com.bytedance.android.sdk.bdticketguard.o1.j.d.f987d.b(r1.a()).d();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public com.bytedance.android.sdk.bdticketguard.m1.c u() {
        return com.bytedance.android.sdk.bdticketguard.o1.j.c.f980h.f();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String v() {
        com.bytedance.android.sdk.bdticketguard.o1.e r1 = r0().h();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.d(2);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String w() {
        com.bytedance.android.sdk.bdticketguard.o1.i r0 = u0().h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    public void x0() {
        r0().B();
        z0.f1102e.y();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    protected com.bytedance.android.sdk.bdticketguard.n1.c y(com.bytedance.android.sdk.bdticketguard.n1.b r3) {
        kotlin.n0.d.o.g(r3, WsConstants.KEY_CONNECTION_TYPE);
        com.bytedance.android.sdk.bdticketguard.n1.g r0 = com.bytedance.android.sdk.bdticketguard.n1.g.f895h;
        if (r0.d() == true) goto L5;
        com.bytedance.android.sdk.bdticketguard.y r2 = this.f646j.get(r3.b());
        if (r2 == null) goto L16;
        Boolean r4 = r2.b();
        if (kotlin.n0.d.o.a(r4, Boolean.TRUE) == false) goto L12;
        return com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b;
    L12:
        if (kotlin.n0.d.o.a(r4, Boolean.FALSE) == false) goto L15;
        return com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;
    L15:
        return com.bytedance.android.sdk.bdticketguard.n1.c.d.f880b;
    L16:
        kotlin.n0.d.o.p();
        throw null;
    L5:
        return r0.e(r3);
    }
}
