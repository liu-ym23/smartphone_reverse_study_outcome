package d.b.s.a.v.a.d;

import android.text.TextUtils;
import com.ss.android.ShowDialogActivity;
import com.ss.android.d;
import com.ss.android.i.g;
import com.ss.android.i.j;
import com.ss.android.i.k.b;
import java.util.Map;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements d.b.s.a.v.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f14942a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f14943b = true;

    /* JADX INFO: renamed from: d.b.s.a.v.a.d.a$a, reason: collision with other inner class name */
    public static final class C0401a implements b.a {
        C0401a(d.b.s.a.v.a.a.InterfaceC0400a r1) {
        }
    }

    static {
    }

    public a() {
    }

    private final void c() {
        if (f14942a == true) goto L27;
        boolean r3 = false;
        Class<?> r0 = Class.forName("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L7
        String r1 = r0.getMethod("getVersionName", new Class[0]).invoke(r0.newInstance(), new Object[0]).toString();     // Catch: Throwable -> L7
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L11;
    L12:
        r3 = true;
    L13:
        f14943b = r3;
        if (r3 == false) goto L23;
        g r4 = g.b();
        o.b(r4, "BdTruingManager.getInst()");
        if (r4.a() == null) goto L23;
        g r5 = g.b();
        o.b(r5, "BdTruingManager.getInst()");
        if (r5.a().a() == false) goto L23;
        d r6 = j.k();
        o.b(r6, "TTAccountInit.getConfig()");
        if (r6.g() == false) goto L22;
        d r7 = j.k();
        o.b(r7, "TTAccountInit.getConfig()");
        ShowDialogActivity.d(r7.e(), "未接入验证码SDK或版本过低", "请升级验证码SDK到3.1.0版本以上！");
        goto L23
    L22:
        d.b.s.a.a0.a.b("CaptchaErrorHandler", "未接入验证码SDK或版本过低，请升级验证码SDK到3.1.0版本以上！");
    L23:
        f14942a = true;
        return;
    L11:
        if (d.b.s.a.s.e.a.b("3.1.0", r1) <= 0) goto L13;
    L7:
        r1 = "";
        goto L9
    }

    @Override // d.b.s.a.v.a.a
    public boolean b(int r4, Map<String, String> r5, d.b.s.a.q.j.b r6, d.b.s.a.v.a.a.InterfaceC0400a r7) {
        o.g(r7, "callback");
        String r8 = null;
        if (r6 == null) goto L5;
        JSONObject r0 = r6.m;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        c();
        String r3 = r6.m.optString("verify_center_decision_conf");
        if (TextUtils.isEmpty(r3) == false) goto L15;
        JSONObject r9 = r6.m.optJSONObject("data");
        if (r9 == null) goto L14;
        r8 = r9.optString("verify_center_decision_conf");
    L14:
        r3 = r8;
    L15:
        g r10 = g.b();
        o.b(r10, "BdTruingManager.getInst()");
        b r11 = r10.a();
        if (f14943b == true) goto L18;
    L28:
        return false;
    L18:
        if (r4 != 1104) goto L20;
    L23:
        if (r11 == null) goto L28;
        if (r11.b() == true) goto L28;
        r11.c(r4, r3, new C0401a(r7));
        return true;
    L20:
        if (r4 == 1105) goto L23;
        if (TextUtils.isEmpty(r3) == true) goto L28;
    L5:
        r0 = null;
        goto L7
    }

    @Override // d.b.s.a.v.a.a
    public String getName() {
        return "captcha";
    }
}
