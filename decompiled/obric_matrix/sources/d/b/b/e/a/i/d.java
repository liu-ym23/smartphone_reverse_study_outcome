package d.b.b.e.a.i;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import d.b.b.o.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f12628a = -1;

    static {
    }

    public static a a(byte[] r5) {
        a r1 = new a();     // Catch: Exception -> L9
        JSONObject r2 = new JSONObject(new String(r5));     // Catch: Exception -> L9
        r1.i0(e.k(r2, "version_code"));     // Catch: Exception -> L9
        r1.j0(e.k(r2, "version_name"));     // Catch: Exception -> L9
        r1.S(e.k(r2, "manifest_version_code"));     // Catch: Exception -> L9
        r1.g0(e.k(r2, "update_version_code"));     // Catch: Exception -> L9
        r1.H(e.k(r2, WsConstants.KEY_APP_VERSION));     // Catch: Exception -> L9
        r1.W(e.k(r2, "os"));     // Catch: Exception -> L9
        r1.P(e.k(r2, "device_platform"));     // Catch: Exception -> L9
        r1.X(e.k(r2, "os_version"));     // Catch: Exception -> L9
        r1.G(e.i(r2, "os_api"));     // Catch: Exception -> L9
        r1.O(e.k(r2, "device_model"));     // Catch: Exception -> L9
        r1.L(e.k(r2, "device_brand"));     // Catch: Exception -> L9
        r1.N(e.k(r2, "device_manufacturer"));     // Catch: Exception -> L9
        r1.a0(e.k(r2, "process_name"));     // Catch: Exception -> L9
        r1.d0(e.j(r2, WsConstants.KEY_SESSION_ID));     // Catch: Exception -> L9
        r1.c0(e.k(r2, "rom_version"));     // Catch: Exception -> L9
        r1.Y(e.k(r2, "package"));     // Catch: Exception -> L9
        r1.T(e.k(r2, "monitor_version"));     // Catch: Exception -> L9
        r1.I(e.k(r2, "channel"));     // Catch: Exception -> L9
        r1.F(e.i(r2, WsConstants.KEY_APP_ID));     // Catch: Exception -> L9
        r1.M(e.k(r2, WsConstants.KEY_DEVICE_ID));     // Catch: Exception -> L9
        r1.Z(e.j(r2, "phone_startup_time"));     // Catch: Exception -> L9
        r1.b0(e.k(r2, "release_build"));     // Catch: Exception -> L9
        r1.f0(e.j(r2, "uid"));     // Catch: Exception -> L9
        r1.h0(e.k(r2, "verify_info"));     // Catch: Exception -> L9
        r1.K(e.k(r2, "current_update_version_code"));     // Catch: Exception -> L9
        if (r2.has("config_time") == false) goto L12;
        r1.J(e.i(r2, "config_time"));     // Catch: Exception -> L9
    L12:
        r1.R(new JSONObject((String) r2.remove("filters")));     // Catch: Exception -> L11
    L7:
        r1.e0(r2);     // Catch: Exception -> L9
        return r1;
    L9:
        return null;
    }

    static long b(long r3) {
        if (r3 >= 0) goto L6;
        return 0;
    L6:
        return r3 >> 16;
    }

    public static long c() {
        if (f12628a != (-1)) goto L6;
        long r0 = d.b.b.i.c.a.u();
        f12628a = (r0 << 16) | ((long) Process.myPid());
    L6:
        return f12628a;
    }

    public static JSONObject d(a r8) {
        if (r8 != null) goto L31;
        return null;
    L31:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L30
        if (r8.z() == null) goto L9;
        r1 = e.a(r1, r8.z());     // Catch: Exception -> L30
    L9:
        if (r8.l() == null) goto L11;
        r1 = e.a(r1, r8.l());     // Catch: Exception -> L30
    L11:
        r1.put("version_code", r8.D());     // Catch: Exception -> L30
        r1.put("version_name", r8.E());     // Catch: Exception -> L30
        r1.put("manifest_version_code", r8.n());     // Catch: Exception -> L30
        r1.put("update_version_code", r8.B());     // Catch: Exception -> L30
        r1.put(WsConstants.KEY_APP_VERSION, r8.c());     // Catch: Exception -> L30
        r1.put("os", r8.r());     // Catch: Exception -> L30
        r1.put("device_platform", r8.k());     // Catch: Exception -> L30
        r1.put("os_version", r8.s());     // Catch: Exception -> L30
        r1.put("os_api", r8.b());     // Catch: Exception -> L30
        r1.put("device_model", r8.j());     // Catch: Exception -> L30
        r1.put("device_brand", r8.g());     // Catch: Exception -> L30
        r1.put("device_manufacturer", r8.i());     // Catch: Exception -> L30
        r1.put("process_name", r8.v());     // Catch: Exception -> L30
        r1.put(WsConstants.KEY_SESSION_ID, r8.y());     // Catch: Exception -> L30
        r1.put("rom_version", r8.x());     // Catch: Exception -> L30
        r1.put("package", r8.t());     // Catch: Exception -> L30
        r1.put("monitor_version", r8.o());     // Catch: Exception -> L30
        r1.put("channel", r8.d());     // Catch: Exception -> L30
        r1.put(WsConstants.KEY_APP_ID, r8.a());     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r8.h()) == true) goto L14;
        r1.put(WsConstants.KEY_DEVICE_ID, r8.h());     // Catch: Exception -> L30
    L14:
        r1.put("uid", r8.A());     // Catch: Exception -> L30
        r1.put("phone_startup_time", r8.u());     // Catch: Exception -> L30
        r1.put("release_build", r8.w());     // Catch: Exception -> L30
        if (r8.e() == (-1)) goto L18;
        r1.put("config_time", String.valueOf(r8.e()));     // Catch: Exception -> L30
    L18:
        if (TextUtils.isEmpty(r8.C()) == true) goto L20;
        r1.put("verify_info", r8.C());     // Catch: Exception -> L30
    L20:
        r1.put("current_update_version_code", r8.f());     // Catch: Exception -> L30
        if (r8.q() == (-1)) goto L24;
        r1.put("ntp_time", r8.q());     // Catch: Exception -> L30
    L24:
        if (r8.p() == (-1)) goto L27;
        r1.put("ntp_offset", r8.p());     // Catch: Exception -> L30
    L27:
        if (r8.m() == null) goto L29;
        r1.put("filters", r8.m());     // Catch: Exception -> L30
    L29:
        return r1;
    L30:
        return null;
    }
}
