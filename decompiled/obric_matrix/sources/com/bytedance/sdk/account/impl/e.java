package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements d.b.s.a.q.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile e f5535b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f5536a;

    class a implements com.ss.android.token.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.token.f f5537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f5538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f5539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.b.s.a.q.j.a f5540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f5541e;

        /* JADX INFO: renamed from: com.bytedance.sdk.account.impl.e$a$a, reason: collision with other inner class name */
        class C0176a extends d.b.s.a.q.j.a<d.b.s.a.q.j.d> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f5542c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f5543d;

            C0176a(a r1, Object r2) {
                this.f5543d = r1;
                this.f5542c = r2;
            }

            @Override // d.b.s.a.q.j.a
            public /* bridge */ /* synthetic */ void c(d.b.s.a.q.j.b r1) {
                g((d.b.s.a.q.j.d) r1);
            }

            public void g(d.b.s.a.q.j.d r3) {
                d.b.s.a.q.j.a r0 = this.f5543d.f5540d;
                if (r0 == null) goto L6;
                r0.a(r3);
            L6:
                if (com.ss.android.token.n.f() == null) goto L9;
                com.ss.android.token.n.f().a(this.f5543d.f5537a, r3, this.f5542c);
                return;
            }
        }

        a(e r1, com.ss.android.token.f r2, Map r3, String r4, d.b.s.a.q.j.a r5) {
            this.f5541e = r1;
            this.f5537a = r2;
            this.f5538b = r3;
            this.f5539c = r4;
            this.f5540d = r5;
        }

        @Override // com.ss.android.token.g.a
        public void a(Map<String, String> r4, Object r5) {
            d.b.s.a.a0.a.d("BDAccountCoreApiImpl", "logout(), scene=" + this.f5537a.a() + ", BeforePassportLogoutCallback onFinish(), start request /passport/user/logout/");
            Map<String, String> r0 = this.f5538b;
            if (r4 != null) goto L5;
        L9:
            r4 = r0;
        L10:
            d.b.s.a.a.J(this.f5541e.f5536a, this.f5539c, r4, new C0176a(this, r5)).D();
            return;
        L5:
            if (r4.isEmpty() == true) goto L9;
            if (r0 == null) goto L10;
            r0.putAll(r4);
            goto L9
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.ss.android.token.g.a f5544f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f5545g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f5546h;

        b(e r1, com.ss.android.token.g.a r2, Map r3, Object r4) {
            this.f5544f = r2;
            this.f5545g = r3;
            this.f5546h = r4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            this.f5544f.a(this.f5545g, this.f5546h);
        }
    }

    private e(Context r2) {
        com.ss.android.d r0 = com.ss.android.i.j.l();
        if (r0 != null) goto L5;
        Context r3 = r2.getApplicationContext();
    L6:
        this.f5536a = r3;
        return;
    L5:
        r3 = r0.e();
        goto L6
    }

    public static d.b.s.a.q.h a() {
        return b(com.ss.android.i.j.k().e());
    }

    static d.b.s.a.q.h b(Context r2) {
        if (f5535b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5535b != null) goto L9;
        f5535b = new e(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f5535b;
    }

    @Override // d.b.s.a.q.h
    public void c(String r11, Map r12, Object r13, com.ss.android.token.f r14, d.b.s.a.q.j.a<d.b.s.a.q.j.d> r15) {
        if (r14 != null) goto L4;
        r14 = new com.ss.android.token.f(r11);
    L4:
        StringBuilder r0 = new StringBuilder();
        r0.append("logout(), scene=");
        r0.append(r14.a());
        r0.append(", sessionMessage is null: ");
        if (r14.b() != null) goto L7;
        boolean r1 = true;
    L8:
        r0.append(r1);
        d.b.s.a.a0.a.d("BDAccountCoreApiImpl", r0.toString());
        a r8 = new a(this, r14, r12, r11, r15);
        if (com.ss.android.token.n.f() == null) goto L12;
        d.b.s.a.a0.a.d("BDAccountCoreApiImpl", "logout(), scene=" + r14.a() + ", wait for LogoutProcessor#beforePassportLogout()");
        com.ss.android.token.n.f().b(r14, r13, r8);
        return;
    L12:
        String r2 = "";
        if ("frontier".equals(r11) == false) goto L15;
    L20:
        q r16 = r14.b();
        if (r16 != null) goto L23;
        r2 = this.f5536a.getString(d.b.s.a.n.f14872e);
        String r17 = this.f5536a.getString(d.b.s.a.n.f14871d);
    L36:
        if (TextUtils.isEmpty(r2) == true) goto L43;
        d.b.s.a.t.c.a r18 = new d.b.s.a.t.c.a();
        r18.d(r2);
        r18.b(new d.b.s.a.t.a(this.f5536a.getString(d.b.s.a.n.f14869b), new b(this, r8, r12, r13)));
        if (TextUtils.isEmpty(r17) == true) goto L40;
        r18.c(r17);
    L40:
        boolean r10 = r18.e();
        d.b.s.a.a0.a.d("BDAccountCoreApiImpl", "logout(), scene=" + r14.a() + ", showDialogResult=" + r10);
        if (r10 == false) goto L43;
        return;
    L43:
        r8.a(r12, r13);
        return;
    L23:
        if (r16.f() == true) goto L25;
        String r19 = this.f5536a.getString(d.b.s.a.n.f14872e);
        if (TextUtils.isEmpty(r16.b()) == false) goto L32;
        String r110 = this.f5536a.getString(d.b.s.a.n.f14871d);
    L33:
        r17 = r110;
        r2 = r19;
        goto L36
    L32:
        r110 = r16.b();
        goto L33
    L25:
        if (TextUtils.isEmpty(r16.b()) == false) goto L27;
        String r111 = this.f5536a.getString(d.b.s.a.n.f14871d);
    L28:
        r2 = r111;
        r17 = "";
        goto L36
    L27:
        r111 = r16.b();
        goto L28
    L15:
        if ("sdk_expired_logout".equals(r11) == true) goto L20;
        if ("device_transfer".equals(r11) == true) goto L20;
        r17 = "";
        goto L36
    L7:
        r1 = false;
        goto L8
    }

    @Override // d.b.s.a.q.h
    public void d(String r1, d.b.s.a.q.k.c r2) {
        d.b.s.a.y.d.J(this.f5536a, r1, r2).D();
    }

    public void e(String r7, Map r8, Object r9, d.b.s.a.q.j.a<d.b.s.a.q.j.d> r10) {
        c(r7, r8, r9, new com.ss.android.token.f(r7), r10);
    }

    @Override // d.b.s.a.q.h
    public void h(String r2, Map r3, d.b.s.a.q.j.a<d.b.s.a.q.j.d> r4) {
        e(r2, r3, null, r4);
    }
}
