package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class q0 extends f1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l[] f1034k = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, y> f1035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.h f1036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f1038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f1039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1040j;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y f1041f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p f1042g;

        a(y r1, q0 r2, kotlin.n0.c.p r3, String r4) {
            this.f1041f = r1;
            this.f1042g = r3;
            super(2);
        }

        public final void a(com.bytedance.android.sdk.bdticketguard.n1.b r3, com.bytedance.android.sdk.bdticketguard.n1.c.f r4) {
            kotlin.n0.d.o.g(r3, "initTask");
            kotlin.n0.d.o.g(r4, "initResult");
            this.f1041f.c(com.bytedance.android.sdk.bdticketguard.n1.h.a(r4));
            kotlin.n0.c.p r2 = this.f1042g;
            if (r2 == null) goto L6;
            kotlin.f0 r5 = (kotlin.f0) r2.invoke(r3, r4);
            return;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(com.bytedance.android.sdk.bdticketguard.n1.b r1, com.bytedance.android.sdk.bdticketguard.n1.c.f r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y f1043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p f1044g;

        b(y r1, q0 r2, kotlin.n0.c.p r3, String r4) {
            this.f1043f = r1;
            this.f1044g = r3;
            super(2);
        }

        public final void a(com.bytedance.android.sdk.bdticketguard.n1.b r3, com.bytedance.android.sdk.bdticketguard.n1.c.f r4) {
            kotlin.n0.d.o.g(r3, "initTask");
            kotlin.n0.d.o.g(r4, "initResult");
            this.f1043f.c(com.bytedance.android.sdk.bdticketguard.n1.h.a(r4));
            kotlin.n0.c.p r2 = this.f1044g;
            if (r2 == null) goto L6;
            kotlin.f0 r5 = (kotlin.f0) r2.invoke(r3, r4);
            return;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(com.bytedance.android.sdk.bdticketguard.n1.b r1, com.bytedance.android.sdk.bdticketguard.n1.c.f r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y f1045f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p f1046g;

        c(y r1, q0 r2, kotlin.n0.c.p r3, String r4) {
            this.f1045f = r1;
            this.f1046g = r3;
            super(2);
        }

        public final void a(com.bytedance.android.sdk.bdticketguard.n1.b r3, com.bytedance.android.sdk.bdticketguard.n1.c.f r4) {
            kotlin.n0.d.o.g(r3, "initTask");
            kotlin.n0.d.o.g(r4, "initResult");
            this.f1045f.c(com.bytedance.android.sdk.bdticketguard.n1.h.a(r4));
            kotlin.n0.c.p r2 = this.f1046g;
            if (r2 == null) goto L6;
            kotlin.f0 r5 = (kotlin.f0) r2.invoke(r3, r4);
            return;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(com.bytedance.android.sdk.bdticketguard.n1.b r1, com.bytedance.android.sdk.bdticketguard.n1.c.f r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<i1> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ q0 f1047f;

        d(q0 r1) {
            this.f1047f = r1;
            super(0);
        }

        public final i1 a() {
            return new i1(this.f1047f.G().e());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ i1 invoke() {
            return a();
        }
    }

    static {
        f1034k = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(q0.class), "providerHelper", "getProviderHelper()Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProviderHelper;"))};
    }

    public q0() {
        this.f1035e = kotlin.i0.m0.k(new kotlin.u[]{kotlin.a0.a("ree", new y()), kotlin.a0.a("tee", new y()), kotlin.a0.a("encryption", new y())});
        this.f1036f = kotlin.i.b(new d(this));
    }

    private final i1 Y() {
        kotlin.h r2 = this.f1036f;
        kotlin.s0.l r0 = f1034k[0];
        return (i1) r2.getValue();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String B() {
        return Y().j();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String C() {
        return Y().l();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public boolean D() {
        if (this.f1040j == true) goto L6;
        this.f1040j = Y().m();
    L6:
        return this.f1040j;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String E() {
        return Y().n();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public w0 F(String r2) {
        kotlin.n0.d.o.g(r2, "ticket");
        return Y().o(r2);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void H(kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r2) {
        V("init", r2);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void J(com.bytedance.android.sdk.bdticketguard.n1.d r2) {
        kotlin.n0.d.o.g(r2, "task");
        kotlin.n0.c.a<kotlin.f0> r3 = r2.b();
        Object r4 = r3;
        if (r3 == null) goto L5;
        r4 = new r0(r3);
    L5:
        new Thread((Runnable) r4).start();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    protected void K(String r1) {
        kotlin.n0.d.o.g(r1, "path");
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void M(String r4, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r5) {
        kotlin.n0.d.o.g(r4, "scene");
        y r0 = this.f1035e.get("encryption");
        if (r0 == null) goto L11;
        y r1 = r0;
        if (kotlin.n0.d.o.a(r1.b(), Boolean.TRUE) == false) goto L9;
        if (r5 == null) goto L13;
        kotlin.f0 r3 = r5.invoke(com.bytedance.android.sdk.bdticketguard.n1.b.f870i, com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b);
        return;
    L13:
        return;
    L9:
        Y().p(r4, new a(r1, this, r5, r4));
        return;
    L11:
        kotlin.n0.d.o.p();
        throw null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void N(String r4, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r5) {
        kotlin.n0.d.o.g(r4, "scene");
        y r0 = this.f1035e.get("ree");
        if (r0 == null) goto L11;
        y r1 = r0;
        if (kotlin.n0.d.o.a(r1.b(), Boolean.TRUE) == false) goto L9;
        if (r5 == null) goto L13;
        kotlin.f0 r3 = r5.invoke(com.bytedance.android.sdk.bdticketguard.n1.b.f869h, com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b);
        return;
    L13:
        return;
    L9:
        Y().q(r4, new b(r1, this, r5, r4));
        return;
    L11:
        kotlin.n0.d.o.p();
        throw null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void O(String r4, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r5) {
        kotlin.n0.d.o.g(r4, "scene");
        y r0 = this.f1035e.get("tee");
        if (r0 == null) goto L11;
        y r1 = r0;
        if (kotlin.n0.d.o.a(r1.b(), Boolean.TRUE) == false) goto L9;
        if (r5 == null) goto L13;
        kotlin.f0 r3 = r5.invoke(com.bytedance.android.sdk.bdticketguard.n1.b.f868g, com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b);
        return;
    L13:
        return;
    L9:
        Y().r(r4, new c(r1, this, r5, r4));
        return;
    L11:
        kotlin.n0.d.o.p();
        throw null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void U(String r2) {
        kotlin.n0.d.o.g(r2, "reason");
        Y().w(r2);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public void X(w0 r2) {
        kotlin.n0.d.o.g(r2, "ticketData");
        Y().A(r2);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public void c(String r1, String r2) {
        Y().y(r1, r2);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public String e(String r2, String r3) {
        kotlin.n0.d.o.g(r2, "unsigned");
        kotlin.n0.d.o.g(r3, "path");
        return Y().g(r2, r3, "sign_type_ree");
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public g f() {
        return null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public l0 g() {
        return Y().k();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public void h(kotlin.n0.c.q<? super kotlin.v<g>, ? super Integer, ? super Boolean, kotlin.f0> r1) {
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public kotlin.u<Boolean, String> j(boolean r1, boolean r2, long r3, long r5, int r7, kotlin.n0.c.q<? super kotlin.v<g>, ? super Integer, ? super Boolean, kotlin.f0> r8) {
        return kotlin.a0.a(Boolean.FALSE, "Cannot start attestation on sub process");
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public String k(String r2, String r3) {
        kotlin.n0.d.o.g(r2, "content");
        kotlin.n0.d.o.g(r3, "path");
        return Y().e(r2, r3);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public void l(String r2, kotlin.n0.c.l<? super com.bytedance.android.sdk.bdticketguard.m1.c, kotlin.f0> r3) {
        kotlin.n0.d.o.g(r2, "secTs");
        Y().z(r2);
        if (r3 == null) goto L6;
        kotlin.f0 r1 = r3.invoke(new com.bytedance.android.sdk.bdticketguard.m1.c.b("", new IllegalStateException("Callback disabled in sub process")));
        return;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public String m() {
        String r0 = this.f1038h;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        this.f1038h = Y().h();
    L12:
        return this.f1038h;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.sdk.bdticketguard.k1
    public String o(String r2, String r3) {
        kotlin.n0.d.o.g(r2, "unsigned");
        kotlin.n0.d.o.g(r3, "path");
        return Y().g(r2, r3, "sign_type_tee");
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public kotlin.u<Boolean, String> s(kotlin.n0.c.q<? super kotlin.v<g>, ? super Integer, ? super Boolean, kotlin.f0> r1) {
        return kotlin.a0.a(Boolean.FALSE, "Key attestation is not supported in sub process");
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String t() {
        return Y().c();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public com.bytedance.android.sdk.bdticketguard.m1.c u() {
        return Y().d();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String v() {
        String r0 = this.f1039i;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        this.f1039i = Y().f();
    L12:
        return this.f1039i;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    public String w() {
        String r0 = this.f1037g;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        this.f1037g = Y().i();
    L12:
        return this.f1037g;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.sdk.bdticketguard.f1
    protected com.bytedance.android.sdk.bdticketguard.n1.c y(com.bytedance.android.sdk.bdticketguard.n1.b r2) {
        kotlin.n0.d.o.g(r2, WsConstants.KEY_CONNECTION_TYPE);
        y r1 = this.f1035e.get(r2.b());
        if (r1 == null) goto L12;
        Boolean r3 = r1.b();
        if (kotlin.n0.d.o.a(r3, Boolean.TRUE) == false) goto L8;
        return com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b;
    L8:
        if (kotlin.n0.d.o.a(r3, Boolean.FALSE) == false) goto L11;
        return com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;
    L11:
        return com.bytedance.android.sdk.bdticketguard.n1.c.d.f880b;
    L12:
        kotlin.n0.d.o.p();
        throw null;
    }
}
