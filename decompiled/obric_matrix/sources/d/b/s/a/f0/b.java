package d.b.s.a.f0;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.impl.g;
import com.ss.android.i.j;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Integer f14730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f14731b;

    static class a extends d.b.s.a.f0.d.a<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.b.s.a.f0.g.c f14732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.b.s.a.f0.e.b f14733d;

        /* JADX INFO: renamed from: d.b.s.a.f0.b$a$a, reason: collision with other inner class name */
        class C0396a implements d.b.s.a.f0.f.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.b.s.a.f0.f.b f14734a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f14735b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f14736c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f14737d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f14738e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f14739f;

            C0396a(a r1, d.b.s.a.f0.f.b r2, int r3, String r4, long r5, c r7) {
                this.f14739f = r1;
                this.f14734a = r2;
                this.f14735b = r3;
                this.f14736c = r4;
                this.f14737d = r5;
                this.f14738e = r7;
            }

            @Override // d.b.s.a.f0.f.c
            public void a() {
                int r0 = this.f14734a.h();
                int r1 = d.b.s.a.f0.c.a();
                if (r0 <= r1) goto L9;
                int r2 = r0 - r1;
                int r3 = 0;
            L5:
                if (r3 >= r2) goto L7;
                this.f14734a.d();
                r3 = r3 + 1;
                goto L5
            L7:
                r0 = r1;
            L9:
                if (this.f14734a.j(this.f14735b, this.f14736c, this.f14737d) == null) goto L14;
                if (this.f14734a.m(this.f14739f.f14732c) == true) goto L23;
                c r7 = this.f14738e;
                r7.f14744a = -1;
                r7.f14745b = "数据更新失败或者没有此数据";
                return;
            L23:
                return;
            L14:
                if (r0 != r1) goto L19;
                this.f14734a.d();
                if (this.f14734a.g(this.f14739f.f14732c) == true) goto L25;
            L20:
                c r8 = this.f14738e;
                r8.f14744a = -2;
                r8.f14745b = "数据插入失败";
                return;
            L25:
                return;
            L19:
                if (this.f14734a.g(this.f14739f.f14732c) == false) goto L20;
            }

            @Override // d.b.s.a.f0.f.c
            public void b() {
            }
        }

        a(d.b.s.a.f0.g.c r1, d.b.s.a.f0.e.b r2) {
            this.f14732c = r1;
            this.f14733d = r2;
        }

        @Override // d.b.s.a.f0.d.a
        protected /* bridge */ /* synthetic */ c b() {
            return f();
        }

        @Override // d.b.s.a.f0.d.a
        protected /* bridge */ /* synthetic */ void d(c r1) {
            g(r1);
        }

        protected c f() {
            d.b.s.a.f0.g.c r0 = this.f14732c;
            if (r0 == null) goto L5;
            c r1 = new c(0, null);
            int r5 = r0.i();
            String r6 = this.f14732c.c();
            long r7 = this.f14732c.j();
            d.b.s.a.f0.f.b r2 = d.b.s.a.f0.f.b.f();
            r2.k(new C0396a(this, r2, r5, r6, r7, r1));
            return r1;
        L5:
            return new c(-6, "登录数据为空");
        }

        protected void g(c r2) {
            d.b.s.a.f0.e.b r1 = this.f14733d;
            if (r1 != null) goto L5;
            return;
        L5:
            int r0 = r2.f14744a;
            if (r0 != 0) goto L8;
            r1.onSuccess();
            return;
        L8:
            r1.a(r0, r2.f14745b);
        }
    }

    /* JADX INFO: renamed from: d.b.s.a.f0.b$b, reason: collision with other inner class name */
    static class C0397b extends d.b.s.a.f0.d.a<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f14741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f14742e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.b.s.a.f0.e.a f14743f;

        C0397b(String r1, String r2, Context r3, d.b.s.a.f0.e.a r4) {
            this.f14740c = r1;
            this.f14741d = r2;
            this.f14742e = r3;
            this.f14743f = r4;
        }

        @Override // d.b.s.a.f0.d.a
        protected /* bridge */ /* synthetic */ c b() {
            return f();
        }

        @Override // d.b.s.a.f0.d.a
        protected /* bridge */ /* synthetic */ void d(c r1) {
            g(r1);
        }

        protected c f() {
            boolean r0 = d.b.s.a.f0.f.b.f().n(this.f14740c, this.f14741d);
            d.b.s.a.a0.a.a("SaveService", "updateSecUid res = " + r0);
            if (r0 == false) goto L6;
            g.d(this.f14742e).s(this.f14740c);
            return new c(0, null);
        L6:
            return new c(-1, "数据更新失败或者没有此数据");
        }

        protected void g(c r2) {
            d.b.s.a.f0.e.a r1 = this.f14743f;
            if (r1 != null) goto L5;
            return;
        L5:
            int r0 = r2.f14744a;
            if (r0 != 0) goto L8;
            r1.onSuccess();
            return;
        L8:
            r1.a(r0, r2.f14745b);
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f14745b;

        c(int r1, String r2) {
            this.f14744a = r1;
            this.f14745b = r2;
        }
    }

    static {
    }

    public static void a(Integer r0, String r1) {
        f14730a = r0;
        f14731b = r1;
    }

    public static d.b.s.a.f0.g.c b(d.b.s.a.k0.a r6) {
        if (f14730a == null) goto L36;
        d.b.s.a.f0.g.c.a r2 = new d.b.s.a.f0.g.c.a();     // Catch: Exception -> L39
        r2.i(new Date().getTime());     // Catch: Exception -> L39
        if (r6 != null) goto L8;
    L34:
        r2.j(f14730a.intValue());     // Catch: Exception -> L39
        r2.d(f14731b);     // Catch: Exception -> L39
        d.b.s.a.f0.g.c r7 = r2.a();     // Catch: Exception -> L39
    L37:
        f14730a = null;
        f14731b = null;
        return r7;
    L8:
        if (r6.i() == null) goto L34;
        r2.k(r6.o());     // Catch: Exception -> L39
        r2.h(r6.k());     // Catch: Exception -> L39
        String r3 = r6.i().optString("screen_name");     // Catch: Exception -> L39
        String r4 = r6.i().optString("avatar_url");     // Catch: Exception -> L39
        r2.g(r3);     // Catch: Exception -> L39
        r2.b(r4);     // Catch: Exception -> L39
        if (f14730a.intValue() != 6) goto L22;
        Map<String, com.ss.android.i.l.a> r8 = r6.d();     // Catch: Exception -> L39
        if (r8 == null) goto L34;
        Iterator<String> r0 = r8.keySet().iterator();     // Catch: Exception -> L39
    L15:
        if (r0.hasNext() == false) goto L34;
        String r5 = r0.next();     // Catch: Exception -> L39
        if (r5.contains(f14731b) == false) goto L15;
        f14731b = r5;     // Catch: Exception -> L39
        com.ss.android.i.l.a r9 = r8.get(r5);     // Catch: Exception -> L39
        if (r9 == null) goto L15;
        String r10 = r9.f11909h;     // Catch: Exception -> L39
        r2.e(r9.f11910i);     // Catch: Exception -> L39
        r2.f(r10);     // Catch: Exception -> L39
        goto L15
    L22:
        if (f14730a.intValue() != 1) goto L26;
        f14731b = r6.f14836i;     // Catch: Exception -> L39
        int r11 = r6.e();     // Catch: Exception -> L39
    L24:
        r2.c(Integer.valueOf(r11));     // Catch: Exception -> L39
        goto L34
    L26:
        if (f14730a.intValue() != 2) goto L28;
    L29:
        r11 = r6.e();     // Catch: Exception -> L39
        if (TextUtils.isEmpty(f14731b) == true) goto L24;
        if (f14731b.startsWith("+") == false) goto L24;
        f14731b = f14731b.replace("+" + r11, "");     // Catch: Exception -> L39
        goto L24
    L28:
        if (f14730a.intValue() != 3) goto L34;
    L36:
        r7 = null;
        goto L37
    }

    public static void c(d.b.s.a.f0.g.c r2, d.b.s.a.f0.e.b r3) {
        if (j.k().l() == true) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L9:
        new a(r2, r3).c();
        return;
    L7:
        if (r2.i() != 7) goto L9;
    }

    public static void d(Context r1, String r2, String r3, d.b.s.a.f0.e.a r4) {
        new C0397b(r2, r3, r1, r4).c();
    }
}
