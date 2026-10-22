package com.ss.android.i;

import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.ss.android.i.a {
    public String A;
    public boolean B;
    public String C;
    public String D;
    public String E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f11876J;
    public int K;
    public int L;
    public long M;
    public String N;
    public int O;
    public int P;
    public boolean Q;
    public boolean R;
    public String S;
    public String T;
    public String U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public int Z;
    public JSONObject a0;
    public int b0;
    public boolean c0;
    public String w;
    public String x;
    public long y;
    public String z;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.ss.android.i.e>] */
    public static class a {
        public a() {
        }

        public e a(JSONObject r1) {
            e r0 = new e(r1);
            r0.a();
            return r0;
        }

        public e b(JSONObject r1, JSONObject r2) {
            e r0 = new e(r1, r2);
            r0.a();
            return r0;
        }
    }

    public e() {
        this.O = 0;
        this.b0 = 0;
    }

    public e(JSONObject r1) {
        super(r1);
        this.O = 0;
        this.b0 = 0;
    }

    public e(JSONObject r1, JSONObject r2) {
        super(r1, r2);
        this.O = 0;
        this.b0 = 0;
    }

    public static void s(e r4, JSONObject r5) {
        r4.F = r5.optInt("can_be_found_by_phone");
        r4.G = r5.optInt("share_to_repost", -1);
        boolean r2 = true;
        r4.H = r5.optInt("user_privacy_extend") & 1;
        r4.I = r5.optInt("user_privacy_extend");
        r4.P = r5.optInt("gender");
        r4.w = r5.optString("screen_name");
        r4.x = r5.optString("verified_content");
        r4.Q = r5.optBoolean("is_generated");
        r4.R = r5.optBoolean("user_verified");
        if (r5.optInt("is_recommend_allowed") == 0) goto L5;
        boolean r0 = true;
    L6:
        r4.B = r0;
        r4.C = r5.optString("recommend_hint_message");
        r4.D = r5.optString("user_decoration");
        r4.E = r5.optString("user_auth_info");
        r4.S = r5.optString("birthday");
        r4.T = r5.optString("area");
        r4.U = r5.optString("industry");
        r4.W = r5.optInt("is_blocked");
        r4.V = r5.optInt("is_blocking");
        r4.X = r5.optBoolean("is_toutiao");
        if (r5.optInt("has_password") != 0) goto L10;
        r2 = false;
    L10:
        r4.Y = r2;
        JSONObject r1 = r5.optJSONObject("media");
        if (r1 == null) goto L13;
        r4.z = r1.optString("avatar_url");
        r4.y = r1.optLong("id");
        r4.A = r1.optString("name");
        r4.O = r1.optInt("display_app_ocr_entrance", 0);
    L13:
        r4.f11876J = r5.optInt("followings_count");
        r4.K = r5.optInt("followers_count");
        r4.L = r5.optInt("visit_count_recent");
        r4.M = r5.optLong("media_id");
        r4.N = r5.optString("bg_img_url");
        r4.Z = r5.optInt(IBdInstall.PARAM_APP_ID);
        r4.a0 = r5.optJSONObject("expend_attrs");
        r4.b0 = r5.optInt("hm_region");
        r4.c0 = r5.optBoolean("use_hm_region", false);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.i.a, d.b.s.a.k0.a
    public void a() {
        super.a();
        s(this, n());
    }
}
