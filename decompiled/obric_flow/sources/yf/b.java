package yf;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f23254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23256c;
    public long d;
    public long e;

    public b() {
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        this.f23254a = r5;
        r5.put("scc_mode", "coreless");
        r5.put("scc_version", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        this.f23255b = 0;
        this.f23256c = 0;
        this.d = 0;
        this.e = 0;
    }

    public final void a() {
        this.f23256c = SystemClock.uptimeMillis();
        ConcurrentHashMap r5 = this.f23254a;
        r5.put("scc_report_reason", "scc_cloudservice");
        r5.put("scc_cloudservice_check_delta", "-1");
        r5.put("scc_cloudservice_label", "error");
        r5.put("scc_cloudservice_backend_code", "-1");
        r5.put("scc_cloudservice_ttnet_code", "-1");
        r5.put("scc_cloudservice_user_wait_time", "-1");
        r5.put("scc_cloudservice_result_apply", "0");
    }

    public final void b(String r5, boolean r10) {
        long r11 = SystemClock.uptimeMillis() - this.d;
        ConcurrentHashMap r12 = this.f23254a;
        r12.put("scc_cloudservice_user_wait_time", r11 + "");
        if (r10 == false) goto L5;
        String r13 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L6:
        r12.put("scc_cloudservice_result_apply", r13);
        if (TextUtils.isEmpty(r5) == true) goto L13;
        String r14 = (String) r12.get("scc_cloudservice_result");
        if (TextUtils.isEmpty(r14) == true) goto L13;
        JSONObject r15 = new JSONObject(r14);     // Catch: JSONException -> L12
        r15.put("error", r5);     // Catch: JSONException -> L12
        r12.put("scc_cloudservice_result", r15.toString());     // Catch: JSONException -> L12
    L12:
        Log.w("scc_sdk", "json format error:" + r14);
    L13:
        c();
        return;
    L5:
        r13 = "0";
        goto L6
    }

    public final void c() {
        if (this.f23254a.size() > 2) goto L5;
        return;
    L5:
        if (this.f23255b > 0) goto L7;
        return;
    L7:
        if (this.f23254a.containsKey("scc_report_reason") == false) goto L24;
        long r5 = SystemClock.uptimeMillis() - this.f23255b;
        this.f23254a.put("scc_total_cost", r5 + "");
        HashMap r10 = new HashMap(this.f23254a);
        we.a r11 = vf.a.f22571a;
        monitor-enter(vf.a.class);
    L14:
        th = move-exception;
        throw th;
    L11:
        if (vf.a.f22572b != null) goto L16;
        monitor-exit(vf.a.class);     // Catch: Throwable -> L14
        return;
    L16:
        com.bytedance.ies.bullet.web.scc.a.a("ttwebview_scc", r10);     // Catch: Throwable -> L14
        monitor-exit(vf.a.class);     // Catch: Throwable -> L14
        return;
    }
}
