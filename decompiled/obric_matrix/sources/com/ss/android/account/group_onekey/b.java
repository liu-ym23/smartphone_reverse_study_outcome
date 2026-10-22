package com.ss.android.account.group_onekey;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sdk.account.impl.g;
import com.ss.android.token.n;
import d.b.s.a.q.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.h;
import kotlin.i;
import kotlin.i0.m0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends Activity {
    static final /* synthetic */ l[] x = null;
    private static boolean y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f11730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f11733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f11734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final h f11735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11736l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private long q;
    private boolean r;
    private long s;
    private boolean t;
    private long u;
    private long v;
    private long w;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/ss/android/account/group_onekey/b$a", "Ld/b/s/a/q/j/a;", "Ld/b/s/a/q/m/c;", "response", "Lkotlin/f0;", "g", "(Ld/b/s/a/q/m/c;)V", "account-sdk-group-onekey_release"}, k = 1, mv = {1, 1, 15})
    public static final class a extends d.b.s.a.q.j.a<d.b.s.a.q.m.c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f11737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f11738d;

        a(b r1, long r2) {
            this.f11737c = r1;
            this.f11738d = r2;
        }

        @Override // d.b.s.a.q.j.a
        public /* bridge */ /* synthetic */ void c(d.b.s.a.q.j.b r1) {
            g((d.b.s.a.q.m.c) r1);
        }

        public void g(d.b.s.a.q.m.c r19) {
            String r2 = b.f(this.f11737c);
            StringBuilder r3 = new StringBuilder();
            r3.append("getRequestGetTokenCallback(), onResponse, success=");
            String r4 = null;
            if (r19 == null) goto L5;
            Boolean r5 = Boolean.valueOf(r19.f14887c);
        L6:
            r3.append(r5);
            r3.append(", ");
            r3.append("error=");
            if (r19 == null) goto L9;
            Integer r6 = Integer.valueOf(r19.f14891g);
        L10:
            r3.append(r6);
            r3.append(", errorMsg=");
            if (r19 == null) goto L13;
            r4 = r19.f14893i;
        L13:
            r3.append(r4);
            d.b.s.a.a0.a.d(r2, r3.toString());
            b.g(this.f11737c, System.currentTimeMillis());
            b.h(this.f11737c, SystemClock.elapsedRealtime() - this.f11738d);
            this.f11737c.o();
            if (r19 == null) goto L30;
            boolean r7 = true;
            if (r19.f14887c != true) goto L30;
            JSONObject r8 = r19.q;
            if (r8 == null) goto L30;
            String r1 = r8.optString("token");
            if (r1 != null) goto L23;
            r1 = "";
        L23:
            String r9 = r1;
            if (r9.length() > 0) goto L27;
            r7 = false;
        L27:
            if (r7 == false) goto L29;
            b r10 = this.f11737c;
            int r11 = 0;
            String r12 = null;
            String r13 = null;
            int r14 = 12;
            Object r15 = null;
        L45:
            b.m(r10, r9, r11, r12, r13, r14, r15);
            return;
        L29:
            b.m(this.f11737c, "", -3, "authToken is null", null, 8, null);
            return;
        L30:
            StringBuilder r16 = new StringBuilder();
            r16.append("server error:");
            if (r19 == null) goto L33;
            int r17 = r19.f14891g;
        L34:
            r16.append(r17);
            r16.append(',');
            if (r19 == null) goto L39;
            String r18 = r19.f14893i;
            if (r18 == null) goto L39;
        L40:
            r16.append(r18);
            r12 = r16.toString();
            r10 = this.f11737c;
            if (r19 == null) goto L43;
            int r0 = r19.f14891g;
        L44:
            r11 = r0;
            r13 = null;
            r14 = 8;
            r15 = null;
            r9 = "";
            goto L45
        L43:
            r0 = -3;
        L39:
            r18 = EnvironmentCompat.MEDIA_UNKNOWN;
            goto L40
        L33:
            r17 = -1;
            goto L34
        L9:
            r6 = null;
            goto L10
        L5:
            r5 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.ss.android.account.group_onekey.b$b, reason: collision with other inner class name */
    static final class C0303b extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0303b f11739f = null;

        static {
            f11739f = new C0303b();
        }

        C0303b() {
            super(0);
        }

        public final boolean a() {
            return com.bytedance.sdk.account.settings.f.a.m();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    public static final class c extends com.ss.android.account.group_onekey.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f11741b;

        c(b r1, long r2) {
            this.f11740a = r1;
            this.f11741b = r2;
        }

        @Override // com.ss.android.account.group_onekey.d.b
        public void a(com.ss.android.account.group_onekey.c.c r6, boolean r7) {
            o.g(r6, "result");
            b.j(this.f11740a, SystemClock.elapsedRealtime() - this.f11741b);
            this.f11740a.o();
            if (r7 == false) goto L6;
            this.f11740a.finish();
            return;
        L6:
            b.k(this.f11740a, r6.g());
            b.i(this.f11740a, r6.e());
            b.g(this.f11740a, r6.a());
            b.h(this.f11740a, r6.d());
            if (r6.h() == false) goto L9;
            String r8 = "pre_get_token";
        L10:
            b.a(this.f11740a, r6.f(), r6.b(), r6.c(), r8);
            return;
        L9:
            r8 = "default";
            goto L10
        }
    }

    public static final class d implements com.ss.android.token.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f11743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f11744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f11745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f11746e;

        d(b r1, long r2, String r4, String r5, String r6) {
            this.f11742a = r1;
            this.f11743b = r2;
            this.f11744c = r4;
            this.f11745d = r5;
            this.f11746e = r6;
        }

        @Override // com.ss.android.token.d
        public void a(int r8, String r9) {
            b.m(this.f11742a, "", r8, r9, null, 8, null);
        }

        @Override // com.ss.android.token.d
        public void b(Map<String, String> r7) {
            b.k(this.f11742a, SystemClock.elapsedRealtime() - this.f11743b);
            b.i(this.f11742a, System.currentTimeMillis());
            if (r7 == null) goto L5;
            r7.put("x-uc-bypass-token", LocationInfoConst.ALLOW_USE_LOCATION);
        L5:
            g.a().b(d.b.s.a.e.j(), r7, m0.k(new u[]{a0.a("local_account_sdk_skip_network_check", LocationInfoConst.ALLOW_USE_LOCATION), a0.a("token_challenge", b.b(this.f11742a)), a0.a("token_challenge_method", this.f11744c), a0.a("client_aid", this.f11745d), a0.a("client_package", b.c(this.f11742a)), a0.a("client_signature", this.f11746e), a0.a("login_scene", b.d(this.f11742a)), a0.a("response_format_type", "app")}), b.e(this.f11742a));
        }
    }

    static final class e implements com.ss.android.token.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f11748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f11749c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f11750d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f11751e;

        e(b r1, long r2, String r4, String r5, String r6) {
            this.f11747a = r1;
            this.f11748b = r2;
            this.f11749c = r4;
            this.f11750d = r5;
            this.f11751e = r6;
        }

        @Override // com.ss.android.token.e
        public final void a() {
            b.k(this.f11747a, SystemClock.elapsedRealtime() - this.f11748b);
            b.i(this.f11747a, System.currentTimeMillis());
            if (this.f11747a.r() == true) goto L6;
            b.m(this.f11747a, "", -2, "not login", null, 8, null);
            this.f11747a.o();
            return;
        L6:
            g.a().a(d.b.s.a.e.j(), m0.k(new u[]{a0.a("token_challenge", b.b(this.f11747a)), a0.a("token_challenge_method", this.f11749c), a0.a("client_aid", this.f11750d), a0.a("client_package", b.c(this.f11747a)), a0.a("client_signature", this.f11751e), a0.a("login_scene", b.d(this.f11747a)), a0.a("response_format_type", "app")}), b.e(this.f11747a));
        }
    }

    static {
        x = new l[]{e0.g(new y(e0.b(b.class), "isEnableGroupOneLoginOpt", "isEnableGroupOneLoginOpt()Z"))};
        y = true;
    }

    public b() {
        this.f11730f = "BaseAccountGroupAuthActivity";
        this.f11731g = 1;
        this.f11732h = "";
        this.f11733i = "";
        this.f11734j = "";
        this.f11735k = i.b(C0303b.f11739f);
    }

    public static final /* synthetic */ void a(b r0, String r1, int r2, String r3, String r4) {
        r0.l(r1, r2, r3, r4);
    }

    public static final /* synthetic */ String b(b r0) {
        return r0.f11733i;
    }

    public static final /* synthetic */ String c(b r0) {
        return r0.f11732h;
    }

    public static final /* synthetic */ String d(b r0) {
        return r0.f11734j;
    }

    public static final /* synthetic */ d.b.s.a.q.j.a e(b r0) {
        return r0.n();
    }

    public static final /* synthetic */ String f(b r0) {
        return r0.f11730f;
    }

    public static final /* synthetic */ void g(b r0, long r1) {
        r0.w = r1;
    }

    public static final /* synthetic */ void h(b r0, long r1) {
        r0.q = r1;
    }

    public static final /* synthetic */ void i(b r0, long r1) {
        r0.v = r1;
    }

    public static final /* synthetic */ void j(b r0, long r1) {
        r0.s = r1;
    }

    public static final /* synthetic */ void k(b r0, long r1) {
        r0.p = r1;
    }

    private final void l(String r16, int r17, String r18, String r19) {
        Intent r4 = new Intent();
        if (this.f11731g != 1) goto L5;
        r4.setComponent(new ComponentName(this.f11732h, this.f11732h + ".auth.AccountGroupAuthCallbackActivity"));
    L5:
        r4.putExtra("server_auth_version", 3);
        r4.putExtra("server_app_enable_group_one_login_opt", q() ? 1 : 0);
        r4.putExtra("server_app_auth_activity_on_create_time", this.m);
        if (r16.length() <= 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        r4.putExtra("auth_token", r16);
    L11:
        r4.putExtra("code", r17);
        r4.putExtra("challenge", this.f11733i);
        if (r18 == null) goto L14;
        r4.putExtra("message", r18);
    L14:
        r4.putExtra("server_app_is_cold_launch", this.o ? 1 : 0);
        r4.putExtra("server_app_start_request_get_token_time", this.v);
        r4.putExtra("server_app_end_request_get_token_time", this.w);
        r4.putExtra("server_app_auth_wait_sdk_init_time", this.u);
        r4.putExtra("callback_result_scene", r19);
        r4.putExtra("duration_wait_get_token", this.s);
        r4.putExtra("is_enable_pre_get_token", this.f11736l);
        r4.putExtra("is_cold_boot_landing_page", this.t ? 1 : 0);
        JSONObject r9 = new JSONObject();
        r9.put("is_cold_start", this.o ? 1 : 0);
        r9.put(TypedValues.TransitionType.S_DURATION, SystemClock.elapsedRealtime() - this.m);
        r9.put("duration_from_app_start", this.n);
        r9.put("duration_wait_sdk_init", this.p);
        r9.put("duration_request_get_token", this.q);
        r9.put("is_token_sdk_init", this.r ? 1 : 0);
        r9.put("is_enable_group_one_login_opt", q() ? 1 : 0);
        r9.put("server_auth_version", 3);
        r9.put("client_auth_version", this.f11731g);
        r9.put(WsConstants.KEY_CONNECTION_ERROR, r17);
        if (r18 == null) goto L17;
        String r1 = r18;
    L18:
        r9.put("fail_info", r1);
        r9.put("callback_result_scene", r19);
        r9.put("duration_wait_get_token", this.s);
        r9.put("is_enable_pre_get_token", this.f11736l ? 1 : 0);
        r9.put("is_cold_boot_landing_page", this.t ? 1 : 0);
        com.bytedance.sdk.account.monitor.c.k("uc_share_login_server_app_auth_result", r9);
        if (this.f11731g != 1) goto L21;
        startActivity(r4);
    L22:
        finish();
        return;
    L21:
        setResult(-1, r4);
        goto L22
    L17:
        r1 = "";
        goto L18
    L8:
        r8 = false;
        goto L9
    }

    static /* synthetic */ void m(b r0, String r1, int r2, String r3, String r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 4) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 8) == 0) goto L9;
        r4 = "default";
    L9:
        r0.l(r1, r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callback");
    }

    private final d.b.s.a.q.j.a<d.b.s.a.q.m.c> n() {
        return new a(this, SystemClock.elapsedRealtime());
    }

    private final boolean q() {
        h r2 = this.f11735k;
        l r0 = x[0];
        return ((Boolean) r2.getValue()).booleanValue();
    }

    public abstract void o();

    @Override // android.app.Activity
    protected void onCreate(Bundle r15) {
        super.onCreate(r15);
        if (getIntent() != null) goto L6;
        finish();
        return;
    L6:
        this.m = SystemClock.elapsedRealtime();
        this.n = d.b.s.a.l0.d.h();
        boolean r0 = p();
        this.o = r0;
        boolean r5 = false;
        if (y == true) goto L10;
        if (r0 == false) goto L10;
        this.o = false;
        d.b.s.a.a0.a.h(this.f11730f, "isColdStart=ture but isFirstStart=false");
        JSONObject r1 = new JSONObject();
        r1.put("message", "isColdStart=ture but isFirstStart=false");
        com.bytedance.sdk.account.monitor.c.k("uc_share_login_ensure_not_reach_here", r1);
    L10:
        y = false;
        this.f11731g = getIntent().getIntExtra("client_auth_version", 1);
        String r2 = getIntent().getStringExtra("client_package");
        String r3 = "";
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        this.f11732h = r2;
        String r4 = getIntent().getStringExtra("client_challenge");
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        this.f11733i = r4;
        String r6 = getIntent().getStringExtra("login_scene");
        if (r6 == null) goto L21;
        r3 = r6;
    L21:
        this.f11734j = r3;
        this.f11736l = getIntent().getBooleanExtra("is_enable_pre_get_token", false);
        if (getIntent().getIntExtra("is_cold_boot_landing_page", 0) != 1) goto L24;
        boolean r7 = true;
    L25:
        this.t = r7;
        d.b.s.a.a0.a.d(this.f11730f, "onCreate(), isEnablePreGetToken=" + this.f11736l + ", isColdBootLandingPage=" + this.t + ", isColdStart=" + this.o + ", clientAuthVersion" + this.f11731g + ", clientPkg=" + this.f11732h);
        if (this.f11731g < 2) goto L38;
        String r8 = getCallingPackage();
        if (r8 != null) goto L30;
    L33:
        boolean r9 = true;
    L34:
        if (r9 == false) goto L36;
        d.b.s.a.a0.a.b(this.f11730f, "callingPackage is null, downgrade to clientAuthVersion=1");
        JSONObject r10 = new JSONObject();
        r10.put("message", "callingPackage is null, downgrade to clientAuthVersion=1");
        com.bytedance.sdk.account.monitor.c.k("uc_share_login_ensure_not_reach_here", r10);
        this.f11731g = 1;
        goto L38
    L36:
        this.f11732h = r8;
        goto L38
    L30:
        if (r8.length() == 0) goto L33;
        r9 = false;
    L38:
        if (this.f11731g != 1) goto L58;
        String r11 = this.f11732h;
        if (r11 != null) goto L42;
    L45:
        boolean r12 = true;
    L46:
        if (r12 == true) goto L55;
        String r13 = this.f11733i;
        if (r13 != null) goto L50;
    L53:
        boolean r14 = true;
    L54:
        if (r14 == false) goto L58;
    L50:
        if (r13.length() == 0) goto L53;
        r14 = false;
    L55:
        finish();
        return;
    L42:
        if (r11.length() == 0) goto L45;
        r12 = false;
    L58:
        if (o.a(this.f11732h, getPackageName()) == false) goto L61;
        d.b.s.a.a0.a.b(this.f11730f, "clientPkg should not be same as packageName");
        finish();
        return;
    L61:
        String r16 = getIntent().getStringExtra("client_aid");
        if (r16 != null) goto L64;
    L67:
        boolean r17 = true;
    L68:
        if (r17 == false) goto L71;
        m(this, "", -8, "param invalid,aid is empty", null, 8, null);
        return;
    L71:
        String r18 = getIntent().getStringExtra("client_challenge_method");
        if (r18 != null) goto L74;
    L75:
        r5 = true;
    L76:
        if (r5 == false) goto L80;
        m(this, "", -8, "param invalid,challenge method is empty", null, 8, null);
        return;
    L80:
        if (r() == true) goto L83;
        m(this, "", -2, "not login", null, 8, null);
        return;
    L83:
        String r19 = com.ss.android.account.group_onekey.e.c.b(com.ss.android.account.group_onekey.e.c.a(this, this.f11732h));
        s();
        this.r = n.n();
        long r20 = SystemClock.elapsedRealtime();
        this.u = System.currentTimeMillis();
        d.b.s.a.a0.a.d(this.f11730f, "start get token");
        if (this.f11736l == false) goto L88;
        com.ss.android.account.group_onekey.d.a.f11769b.a(this.f11733i, r18, r16, this.f11732h, this.f11734j, new c(this, SystemClock.elapsedRealtime()));
        return;
    L88:
        if (q() == false) goto L91;
        n.g(new d(this, r20, r18, r16, r19));
        return;
    L91:
        n.a(new e(this, r20, r18, r16, r19));
        return;
    L74:
        if (r18.length() != 0) goto L76;
    L64:
        if (r16.length() == 0) goto L67;
        r17 = false;
        goto L68
    L24:
        r7 = false;
        goto L25
    }

    public boolean p() {
        if (d.b.s.a.l0.d.h() < 15000) goto L5;
    L7:
        return false;
    L5:
        if (d.b.s.a.l0.d.g() > 1) goto L7;
        return true;
    }

    public boolean r() {
        f r1 = g.d(this);
        o.b(r1, "BDAccountDelegateInner.i…AccountGroupAuthActivity)");
        return r1.m();
    }

    public abstract void s();
}
