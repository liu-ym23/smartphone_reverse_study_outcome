package com.bytedance.applog.t;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.applog.o.e;
import com.bytedance.applog.util.n;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2382a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f2383b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f2384c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long[] f2385d = null;

    static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f2387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f2388c;

        a(int r1, JSONObject r2, b r3) {
            this.f2386a = r1;
            this.f2387b = r2;
            this.f2388c = r3;
        }

        @Override // com.bytedance.applog.t.b
        public void onFail(int r1) {
            this.f2388c.onFail(r1);
        }

        @Override // com.bytedance.applog.t.b
        public void onSuccess() {
            c.a()[this.f2386a] = this.f2387b.toString().hashCode();
            c.b()[this.f2386a] = System.currentTimeMillis();
            this.f2388c.onSuccess();
        }
    }

    static {
        f2382a = new String[]{WsConstants.KEY_APP_ID, "region", "os", "package", WsConstants.KEY_APP_VERSION, "sdk_version", "os_version", "device_model", "resolution", "language", "timezone", "access", "display_name", "channel", "carrier", "app_language", "app_region", "tz_name", "tz_offset", "install_id", "openudid", "mcc_mnc", "rom", "manifest_version_code", "device_manufacturer", "clientudid", "sig_hash", "display_density", "os_api", "update_version_code", "density_dpi", "version_code", "sim_serial_number", "release_build", "udid", "cpu_abi", "google_aid"};
        f2383b = new String[]{"setOnce", "synchronize"};
        f2384c = new int[]{-1, -1};
        f2385d = new long[]{-1, -1};
    }

    static /* synthetic */ int[] a() {
        return f2384c;
    }

    static /* synthetic */ long[] b() {
        return f2385d;
    }

    public static void c(e r10, int r11, JSONObject r12, b r13, Handler r14, boolean r15) {
        if (r15 == false) goto L5;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L36;
        Context r9 = com.bytedance.applog.a.j();
        String r16 = com.bytedance.applog.a.k();
        String r6 = com.bytedance.applog.a.h();
        String r17 = r10.z().d();
        if (TextUtils.isEmpty(r16) == false) goto L23;
    L34:
        if (r13 == null) goto L41;
        r13.onFail(3);
        return;
    L41:
        return;
    L23:
        if (TextUtils.isEmpty(r6) == true) goto L34;
        if (TextUtils.isEmpty(r17) == true) goto L34;
        d r18 = new d(r17 + String.format("/service/api/v3/userprofile/%s/%s", new Object[]{r6, f2383b[r11]}), r6, d(r12), new a(r11, r12, r13), r9);
        if (r14 == null) goto L30;
        r14.post(r18);
        return;
    L30:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L32;
        n.i(null);
    L32:
        r18.run();
        return;
    L36:
        if (r13 == null) goto L43;
        r13.onSuccess();
        return;
    L43:
        return;
    L5:
        if ((System.currentTimeMillis() - f2385d[r11]) <= 60000) goto L7;
        boolean r19 = true;
    L8:
        if (r12 != null) goto L10;
    L12:
        r3 = false;
    L13:
        n.b("exec " + r11 + ", " + r19 + ", " + r3, null);
        if (r19 == true) goto L19;
        if (r13 == null) goto L39;
        r13.onFail(4);
        return;
    L39:
        return;
    L10:
        if (f2384c[r11] == r12.toString().hashCode()) goto L12;
        r3 = true;
        goto L13
    L7:
        r19 = false;
        goto L8
    }

    private static String d(JSONObject r3) {
        JSONObject r0 = new JSONObject();
        r0.put("header", e());     // Catch: JSONException -> L5
        r0.put("profile", r3);     // Catch: JSONException -> L5
        r0.put("user", f());     // Catch: JSONException -> L5
    L8:
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private static JSONObject e() {
        JSONObject r2 = com.bytedance.applog.a.p();
        JSONObject r3 = new JSONObject(r2, f2382a);     // Catch: JSONException -> L7
        if (r2 == null) goto L6;
        r3.put("sdk_version", r2.opt("sdk_version").toString());     // Catch: JSONException -> L7
        r3.put("tz_offset", r2.opt("tz_offset").toString());     // Catch: JSONException -> L7
    L6:
        return r3;
    L7:
        e = move-exception;
        e.printStackTrace();
        return new JSONObject();
    }

    private static JSONObject f() {
        JSONObject r0 = com.bytedance.applog.a.p();
        JSONObject r1 = new JSONObject();
        if (r0 == null) goto L5;
        r1.put(WsConstants.KEY_DEVICE_ID, r0.opt(WsConstants.KEY_DEVICE_ID));
        r1.put("user_id", r0.opt("user_id"));
        r1.put("ssid", r0.opt("ssid"));
    L5:
        return r1;
    }
}
