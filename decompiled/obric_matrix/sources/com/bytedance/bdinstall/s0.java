package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class s0 extends j {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final long[] f2867l = null;
    private static final long[] m = null;
    private static final long[] n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bytedance.bdinstall.w0.b f2868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final r f2869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bytedance.bdinstall.x0.f f2870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bytedance.bdinstall.b1.a f2871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bytedance.bdinstall.z0.k f2872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final i0 f2873k;

    static {
        f2867l = new long[]{WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME};
        m = new long[]{WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME};
        n = new long[]{WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME};
    }

    s0(i0 r4, com.bytedance.bdinstall.z0.k r5, r r6, com.bytedance.bdinstall.w0.b r7) {
        super(r4.t(), q(r4.t(), r5, r6));
        this.f2872j = r5;
        this.f2873k = r4;
        this.f2868f = r7;
        this.f2869g = r6;
        this.f2870h = r5;
        this.f2871i = (com.bytedance.bdinstall.b1.a) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.a.class);
    }

    private void p(long r2) {
        this.f2869g.c(this.f2808a).edit().putLong("register_time", r2).apply();
    }

    private static long q(Context r5, com.bytedance.bdinstall.z0.k r6, r r7) {
        SharedPreferences r8 = r7.c(r5);
        long r2 = r8.getLong("register_time", 0);
        h0 r9 = r6.l();
        if (r9 == null) goto L9;
        if (v0.a(r9.c()) == false) goto L9;
        if (v0.a(r9.d()) == false) goto L9;
    L12:
        return r2;
    L9:
        if (r2 == 0) goto L12;
        r8.edit().putLong("register_time", 0).apply();
        return 0;
    }

    @Override // com.bytedance.bdinstall.j
    protected boolean a() {
        q.a("Register#doRegister");
        JSONObject r0 = o();
        q.a("Register#doRegister result = " + r0);
        if (r0 == null) goto L8;
        boolean r1 = this.f2870h.a(r0, this.f2869g, this.f2871i);
        if (r1 == false) goto L7;
        p(System.currentTimeMillis());
    L7:
        return r1;
    L8:
        return false;
    }

    @Override // com.bytedance.bdinstall.j
    protected String b() {
        return "r";
    }

    @Override // com.bytedance.bdinstall.j
    protected long[] d() {
        int r1 = this.f2872j.n();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        q.i(null);
        goto L14
    L13:
        return f2867l;
    L14:
        return m;
    L12:
        return n;
    }

    @Override // com.bytedance.bdinstall.j
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.bdinstall.j
    protected boolean g() {
        return true;
    }

    @Override // com.bytedance.bdinstall.j
    protected long h() {
        if (this.f2868f.isForeground() == false) goto L5;
        return 21600000;
    L5:
        return 43200000;
    }

    JSONObject n() {
        JSONObject r0 = this.f2872j.g();
        JSONObject r1 = new JSONObject();
        v0.c(r1, r0);
        this.f2872j.C(r1, this.f2869g);
        return r1;
    }

    protected JSONObject o() {
        JSONObject r0 = n();
        if (r0 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = new JSONObject();
        r4.put("header", r0);
        r4.put("magic_tag", "ss_app_log");
        r4.put("_gen_time", System.currentTimeMillis());
        q.a("register request header = " + r4);
        String r3 = Uri.parse(this.f2869g.a().e()).buildUpon().appendQueryParameter("req_id", com.bytedance.bdinstall.d1.k.b()).build().toString();
        l0.b(true);
        if (TextUtils.isEmpty(r0.optString(WsConstants.KEY_DEVICE_ID)) == false) goto L8;
    L10:
        boolean r7 = false;
    L17:
        JSONObject r1 = d.f(this.f2873k.z(), r3, r4, this.f2873k.d(), this.f2873k.v(), r7);     // Catch: Throwable -> L14
        l0.b(false);
        com.bytedance.bdinstall.d1.d.a(this.f2873k, r0, r1);
        return r1;
    L14:
        th = move-exception;
        l0.b(false);
        com.bytedance.bdinstall.d1.d.a(this.f2873k, r0, null);
        throw th;
    L8:
        if (TextUtils.isEmpty(r0.optString("install_id")) == true) goto L10;
        r7 = true;
        goto L17
    }
}
