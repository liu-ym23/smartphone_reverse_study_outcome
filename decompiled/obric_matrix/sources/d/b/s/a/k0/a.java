package d.b.s.a.k0;

import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sdk.account.impl.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, com.ss.android.i.l.a> f14830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Map<String, com.ss.android.i.l.a>> f14831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f14832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14834g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14835h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f14836i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f14837j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f14838k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14839l;
    public boolean m;
    public boolean n;
    public String o;
    public int p;
    protected JSONObject q;
    protected JSONObject r;
    protected JSONObject s;

    public a() {
        this.f14830c = new HashMap();
        this.f14831d = new HashMap();
    }

    public a(JSONObject r2) {
        this.f14830c = new HashMap();
        this.f14831d = new HashMap();
        this.r = r2;
        JSONObject r3 = r2.optJSONObject("data");
        this.q = r3;
        this.s = r3;
    }

    public a(JSONObject r2, JSONObject r3) {
        this.f14830c = new HashMap();
        this.f14831d = new HashMap();
        this.r = r2;
        this.q = r2.optJSONObject("data");
        this.s = r3;
    }

    public static void b(a r6, JSONObject r7, JSONObject r8) {
        if (com.bytedance.sdk.account.settings.f.a.i() == true) goto L28;
    L6:
        r6.f14828a = r8.optLong("user_id", 0);
    L7:
        r6.f14829b = r8.optInt("odin_user_type", 0);
        r6.f14832e = r8.optString("sec_user_id", "");
        r6.f14835h = r8.optString("session_key", "");
        boolean r3 = true;
        if (r8.optInt("new_user") == 0) goto L10;
        boolean r2 = true;
    L11:
        r6.f14834g = r2;
        r6.f14836i = r8.optString("mobile", "");
        if (r8.optInt("has_password") == 0) goto L14;
        boolean r4 = true;
    L15:
        r6.f14839l = r4;
        r6.f14838k = r8.optString("sec_user_id", "");
        r6.m = r8.optBoolean("is_visitor_account", false);
        r6.f14837j = r8.optString(NotificationCompat.CATEGORY_EMAIL, "");
        com.ss.android.i.l.a r5 = com.ss.android.i.l.a.c("mobile");
        com.ss.android.i.l.a r9 = com.ss.android.i.l.a.c(NotificationCompat.CATEGORY_EMAIL);
        String r10 = r6.f14837j;
        r9.f11909h = r10;
        if (TextUtils.isEmpty(r10) == true) goto L18;
        r6.d().put(r9.f11907f, r9);
    L18:
        String r11 = r6.f14836i;
        r5.f11909h = r11;
        if (TextUtils.isEmpty(r11) == true) goto L21;
        r6.d().put(r5.f11907f, r5);
    L21:
        c(r6, r8);
        r6.f14833f = r8.optInt("country_code", -1);
        if (r8.optInt("is_kids_mode") == 1) goto L25;
        r3 = false;
    L25:
        r6.n = r3;
        r6.o = r8.optString("lite_user_info_string", "");
        r6.p = r8.optInt("lite_user_info_demotion", 0);
        return;
    L14:
        r4 = false;
        goto L15
    L10:
        r2 = false;
        goto L11
    L28:
        r6.f14828a = Long.parseLong(r8.optString("user_id_str", null));     // Catch: Exception -> L27
        goto L7
    }

    public static void c(a r16, JSONObject r17) {
        int r2 = com.bytedance.sdk.account.settings.f.a.h();
        JSONArray r3 = r17.optJSONArray("connects");
        if (r3 == null) goto L48;
        int r4 = r3.length();
        System.currentTimeMillis();
        int r5 = 0;
        int r6 = 0;
    L5:
        if (r6 >= r4) goto L53;
        JSONObject r7 = r3.getJSONObject(r6);
        String r8 = r7.getString(WsConstants.KEY_PLATFORM);
        if (r8 != null) goto L9;
    L46:
        int r15 = r6;
    L47:
        r6 = r15 + 1;
        r5 = 0;
        goto L5
    L9:
        if (r8.length() == 0) goto L46;
        com.ss.android.i.l.a r9 = com.ss.android.i.l.a.c(r8);
        r9.p = r17.optLong("user_id", 0);
        String r10 = "screen_name";
        if (r7.has("screen_name") == false) goto L14;
    L13:
        r9.f11909h = r7.optString(r10);
    L17:
        r9.f11910i = r7.optString("profile_image_url");
        r9.f11911j = r7.optString("platform_uid");
        r9.f11912k = r7.optString("sec_platform_uid");
        r9.m = r7.optLong("modify_time");
        r9.f11913l = r7.optString("create_time");
        r9.q = r7.optInt("platform_app_id", r5);
        r9.f11908g = true;
        r9.u = r7.optString(WsConstants.KEY_EXTRA);
        if (r2 == 0) goto L20;
        r9.s = r7.optString("open_id");
    L20:
        a r11 = g.c().a();
        if (r11 == null) goto L34;
        r15 = r6;
        if (r11.f14828a != r16.f14828a) goto L35;
        Map<String, com.ss.android.i.l.a> r12 = r11.f14831d.get(r8);
        if (r12 == null) goto L35;
        com.ss.android.i.l.a r13 = r12.get(String.valueOf(r9.q));
        if (r13 == null) goto L35;
        r9.r = r13.r;
        if (r2 != 0) goto L31;
    L32:
        r9.s = r13.s;
    L33:
        r9.t = r13.t;
        r9.o = r13.o;
        r9.n = r13.n;
        r9.w = r13.w;
        r9.v = r13.v;
        goto L35
    L31:
        if (TextUtils.isEmpty(r9.s) == false) goto L33;
    L35:
        Map<String, com.ss.android.i.l.a> r14 = r16.f14831d.get(r8);
        if (r14 != null) goto L38;
        r14 = new HashMap();
        r16.f14831d.put(r8, r14);
    L38:
        com.ss.android.i.l.a r18 = r14.get(String.valueOf(r9.q));
        if (r18 == null) goto L45;
        long r19 = r18.m;
        if (r19 <= 0) goto L45;
        if (r19 > r9.m) goto L47;
    L45:
        r16.d().put(r8, r9.a());
        r14.put(String.valueOf(r9.q), r9);
        goto L47
    L34:
        r15 = r6;
        goto L35
    L14:
        r10 = "platform_screen_name";
        if (r7.has("platform_screen_name") == false) goto L17;
    L53:
        return;
    }

    @CallSuper
    public void a() {
        b(this, this.r, this.s);
    }

    public Map<String, com.ss.android.i.l.a> d() {
        return this.f14830c;
    }

    public int e() {
        return this.f14833f;
    }

    public String f() {
        return this.f14837j;
    }

    public String g() {
        return this.f14836i;
    }

    public int h() {
        return this.f14829b;
    }

    public JSONObject i() {
        return this.q;
    }

    public JSONObject j() {
        return this.r;
    }

    public String k() {
        return this.f14832e;
    }

    public String l() {
        return this.f14835h;
    }

    public Map<String, Map<String, com.ss.android.i.l.a>> m() {
        return this.f14831d;
    }

    public JSONObject n() {
        return this.s;
    }

    public long o() {
        return this.f14828a;
    }

    public boolean p() {
        return this.f14834g;
    }

    public void q(JSONObject r2) {
        this.r = r2;
        JSONObject r3 = r2.optJSONObject("data");
        this.q = r3;
        this.s = r3;
    }
}
