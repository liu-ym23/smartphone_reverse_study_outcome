package com.ss.android.account.group_onekey.d;

import android.content.Context;
import android.os.SystemClock;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.sdk.account.impl.g;
import com.ss.android.account.group_onekey.c.c;
import com.ss.android.i.j;
import com.ss.android.token.d;
import com.ss.android.token.n;
import d.b.s.a.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, com.ss.android.account.group_onekey.c.b> f11768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11769b = null;

    /* JADX INFO: renamed from: com.ss.android.account.group_onekey.d.a$a, reason: collision with other inner class name */
    public static final class C0304a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f11770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f11771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f11772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f11773d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f11774e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f11775f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f11776g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f11777h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ b f11778i;

        /* JADX INFO: renamed from: com.ss.android.account.group_onekey.d.a$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/ss/android/account/group_onekey/d/a$a$a", "Ld/b/s/a/q/j/a;", "Ld/b/s/a/q/m/c;", "response", "Lkotlin/f0;", "g", "(Ld/b/s/a/q/m/c;)V", "account-sdk-group-onekey_release"}, k = 1, mv = {1, 1, 15})
        public static final class C0305a extends d.b.s.a.q.j.a<d.b.s.a.q.m.c> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ C0304a f11779c;

            C0305a(C0304a r1) {
                this.f11779c = r1;
            }

            @Override // d.b.s.a.q.j.a
            public /* bridge */ /* synthetic */ void c(d.b.s.a.q.j.b r1) {
                g((d.b.s.a.q.m.c) r1);
            }

            public void g(d.b.s.a.q.m.c r8) {
                StringBuilder r0 = new StringBuilder();
                r0.append("requestGetToken(), onResponse, clientPkg=");
                r0.append(this.f11779c.f11775f);
                r0.append(", ");
                r0.append("challenge=");
                r0.append(this.f11779c.f11772c);
                r0.append(", success=");
                if (r8 == null) goto L5;
                Boolean r3 = Boolean.valueOf(r8.f14887c);
            L6:
                r0.append(r3);
                r0.append(", ");
                r0.append("error=");
                if (r8 == null) goto L9;
                Integer r1 = Integer.valueOf(r8.f14891g);
            L10:
                r0.append(r1);
                r0.append(", errorMsg=");
                if (r8 == null) goto L13;
                String r2 = r8.f14893i;
            L14:
                r0.append(r2);
                d.b.s.a.a0.a.d("AccountGroupNetworkHelper", r0.toString());
                this.f11779c.f11770a.j(System.currentTimeMillis());
                c r4 = this.f11779c.f11770a;
                r4.n(r4.a() - this.f11779c.f11770a.e());
                this.f11779c.f11770a.m(r8);
                this.f11779c.f11770a.k(0);
                if (r8 == null) goto L17;
                JSONObject r5 = r8.q;
            L19:
                if (r5 != null) goto L26;
                c r6 = this.f11779c.f11770a;
                if (r8 == null) goto L23;
                int r9 = r8.f14891g;
            L24:
                r6.k(r9);
                this.f11779c.f11770a.l("server error:" + this.f11779c.f11770a.b() + ", data is null");
                return;
            L23:
                r9 = -3;
                goto L24
            L26:
                String r7 = r8.q.optString("token");
                if (r7 != null) goto L31;
                r7 = "";
            L31:
                if (r7.length() <= 0) goto L33;
                boolean r10 = true;
            L34:
                if (r10 == false) goto L36;
                c r11 = this.f11779c.f11770a;
                r11.p(true);
                r11.q(r7);
            L45:
                C0304a r12 = this.f11779c;
                b r13 = r12.f11778i;
                if (r13 == null) goto L49;
                b.b(r13, r12.f11770a, false, 2, null);
                return;
            L49:
                return;
            L36:
                c r14 = this.f11779c.f11770a;
                if (r8 == null) goto L39;
                Integer r15 = Integer.valueOf(r8.f14891g);
            L40:
                r14.k(r15.intValue());
                StringBuilder r16 = new StringBuilder();
                r16.append("server error:");
                r16.append(r14.b());
                r16.append(',');
                String r17 = r8.f14893i;
                if (r17 != null) goto L44;
                r17 = EnvironmentCompat.MEDIA_UNKNOWN;
            L44:
                r16.append(r17);
                r14.l(r16.toString());
                goto L45
            L39:
                r15 = null;
                goto L40
            L33:
                r10 = false;
                goto L34
            L17:
                r5 = null;
                goto L19
            L13:
                r2 = null;
                goto L14
            L9:
                r1 = null;
                goto L10
            L5:
                r3 = null;
                goto L6
            }
        }

        C0304a(c r1, long r2, String r4, String r5, String r6, String r7, String r8, String r9, b r10) {
            this.f11770a = r1;
            this.f11771b = r2;
            this.f11772c = r4;
            this.f11773d = r5;
            this.f11774e = r6;
            this.f11775f = r7;
            this.f11776g = r8;
            this.f11777h = r9;
            this.f11778i = r10;
        }

        @Override // com.ss.android.token.d
        public void a(int r6, String r7) {
            c r0 = this.f11770a;
            r0.r(SystemClock.elapsedRealtime() - this.f11771b);
            r0.k(r6);
            if (r7 != null) goto L6;
            r7 = "get request header fail";
        L6:
            r0.l(r7);
            b r8 = this.f11778i;
            if (r8 == null) goto L10;
            b.b(r8, this.f11770a, false, 2, null);
            return;
        }

        @Override // com.ss.android.token.d
        public void b(Map<String, String> r7) {
            this.f11770a.r(SystemClock.elapsedRealtime() - this.f11771b);
            this.f11770a.o(System.currentTimeMillis());
            if (r7 == null) goto L5;
            r7.put("x-uc-bypass-token", LocationInfoConst.ALLOW_USE_LOCATION);
        L5:
            g.a().b(e.j(), r7, m0.k(new u[]{a0.a("local_account_sdk_skip_network_check", LocationInfoConst.ALLOW_USE_LOCATION), a0.a("token_challenge", this.f11772c), a0.a("token_challenge_method", this.f11773d), a0.a("client_aid", this.f11774e), a0.a("client_package", this.f11775f), a0.a("client_signature", this.f11776g), a0.a("login_scene", this.f11777h), a0.a("response_format_type", "app")}), new C0305a(this));
        }
    }

    static {
        f11769b = new a();
        f11768a = new ConcurrentHashMap(4);
    }

    private a() {
    }

    private final void b(String r13, String r14, String r15, String r16, String r17, b r18) {
        String r1 = "";
        if (r17 == null) goto L5;
        String r2 = r17;
    L6:
        c r0 = new c(r2);
        com.ss.android.d r3 = j.l();
        if (r3 != null) goto L12;
        r0.k(-11);
        r0.l("not set TTAccountConfig");
        if (r18 == null) goto L23;
        b.b(r18, r0, false, 2, null);
        return;
    L23:
        return;
    L12:
        Context r6 = r3.e();
        o.b(r6, "ttAccountConfig.applicationContext");
        if (r16.equals(r6.getPackageName()) == false) goto L18;
        r0.k(-8);
        r0.l("clientPkg illegal");
        if (r18 == null) goto L24;
        b.b(r18, r0, false, 2, null);
        return;
    L24:
        return;
    L18:
        String r8 = com.ss.android.account.group_onekey.e.c.b(com.ss.android.account.group_onekey.e.c.a(r3.e(), r16));
        long r4 = SystemClock.elapsedRealtime();
        if (r17 == null) goto L21;
        r1 = r17;
    L21:
        n.g(new C0304a(new c(r1), r4, r13, r14, r15, r16, r8, r17, r18));
        return;
    L5:
        r2 = "";
        goto L6
    }

    public final void a(String r7, String r8, String r9, String r10, String r11, b r12) {
        o.g(r7, "challenge");
        o.g(r8, "challengeMethod");
        o.g(r9, "clientAid");
        o.g(r10, "clientPkg");
        d.b.s.a.a0.a.d("AccountGroupNetworkHelper", "getToken(), start, clientPkg=" + r10 + ", challenge=" + r7 + ", loginScene=" + r11);
        StringBuilder r0 = new StringBuilder();
        r0.append(r10);
        r0.append('_');
        r0.append(r7);
        String r1 = r0.toString();
        Map<String, com.ss.android.account.group_onekey.c.b> r2 = f11768a;
        com.ss.android.account.group_onekey.c.b r3 = r2.get(r1);
        if (r3 == null) goto L18;
        d.b.s.a.a0.a.d("AccountGroupNetworkHelper", "getToken(), had cache, state=" + r3.c() + ", isTokenValid=" + r3.e() + ", hadCallback=" + r3.a());
        if (r3.c() != com.ss.android.account.group_onekey.c.d.f11766f) goto L9;
        r3.f(r12);
        return;
    L9:
        if (r3.e() == false) goto L18;
        if (r12 == null) goto L16;
        c r6 = r3.b();
        if (r6 == null) goto L14;
        r12.a(r6, r3.a());
        goto L16
    L14:
        o.p();
        throw null;
    L16:
        r3.d();
        r2.remove(r1);
        return;
    L18:
        b(r7, r8, r9, r10, r11, r12);
    }
}
