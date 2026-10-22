package androidx.constraintlayout.motion.widget;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkThreadFactory;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.securityserver.WorkflowManager;
import com.bytedance.securityserver.observer.SettingsViaMatrixListener;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.bytedance.securityserver.securitylog.SecurityLogConfigUtils;
import com.bytedance.securityserver.trustcircle.TrustCircleException;
import com.bytedance.securityserver.trustcircle.TrustCircleManager;
import com.bytedance.securityserver.trustcircle.account.AccountUtils;
import com.bytedance.securityserver.trustcircle.c;
import com.bytedance.securityserver.trustcircle.d;
import com.bytedance.securityserver.trustcircle.e;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.FPSMonitor;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.FPSSceneMonitor;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.ListViewFPSMonitor;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.UnownedUserData;
import com.ttnet.org.chromium.base.UnownedUserDataHost;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(int r1, Object r2, Object r3) {
        this.b = r1;
        this.c = r2;
        this.e = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.b) {
            case 0: goto L61;
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        AsyncTask.a((AsyncTask) this.c, this.e);
        return;
    L6:
        UnownedUserDataHost.a((UnownedUserDataHost) this.c, (UnownedUserData) this.e);
        return;
    L8:
        Callback.a((Callback) this.c, this.e);
        return;
    L10:
        ListViewFPSMonitor.a((String) this.c, (FpsTracer) this.e);
        return;
    L12:
        FPSMonitor.a((String) this.c, (FPSSceneMonitor) this.e);
        return;
    L14:
        TrustCircleManager.Callback r0 = (TrustCircleManager.Callback) this.e;
        Handler r9 = ((TrustCircleManager) this.c).b;
        AccountUtils.e(AccountUtils.c(AccountUtils.b()));     // Catch: Exception -> L17 TrustCircleException -> L19
        r9.post(new c((com.bytedance.securityserver.a) r0, 1));     // Catch: Exception -> L17 TrustCircleException -> L19
    L70:
        return;
    L19:
        e = move-exception;
        r9.post(new d((com.bytedance.securityserver.a) r0, e, 1));
        return;
    L17:
        e = move-exception;
        r9.post(new e((com.bytedance.securityserver.a) r0, e, 1));
        return;
    L24:
        ((WorkflowManager.ApiCallback) this.c).onSuccess((String) this.e);
        return;
    L26:
        ((WorkflowManager.ApiCallback) this.c).onError("Network error: " + ((IOException) this.e).getMessage());
        return;
    L28:
        SSCookieHandler.a((SSCookieHandler) this.c, (ConcurrentHashMap) ((Map) this.e));
        return;
    L30:
        NetworkThreadFactory.a((NetworkThreadFactory) this.c, (Runnable) this.e);
        return;
    L32:
        String r1 = (String) this.e;
        SettingsViaMatrixListener r10 = (SettingsViaMatrixListener) this.c;
        r10.getClass();
        JSONObject r8 = new JSONObject(r1);     // Catch: Exception -> L36
        if (r8.has("sensitive_words") == false) goto L38;
        boolean r2 = r10.d(r8.getString("sensitive_words"));     // Catch: Exception -> L36
    L40:
        if (r8.has("sensitive_views") == false) goto L43;
        r2 = r2 | r10.c(r8.getString("sensitive_views"));     // Catch: Exception -> L36
    L43:
        if (r8.has("robots_policy") == false) goto L46;
        r2 = r2 | r10.a(r8.getString("robots_policy"));     // Catch: Exception -> L36
    L46:
        if (r8.has("security_log_config") == false) goto L50;
        boolean r11 = r10.b(r8.getString("security_log_config"));     // Catch: Exception -> L36
    L48:
        r2 = r2 | r11;     // Catch: Exception -> L36
    L57:
        Log.i("SettingsViaMatrixListener", "applyAllSettings result: " + r2);     // Catch: Exception -> L36
        return;
    L50:
        if (r8.has("security_log_enabled") == false) goto L57;
        Object r3 = r8.get("security_log_enabled");     // Catch: Exception -> L36
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L54
        r4.put(RobotsPolicyContract.COL_VERSION, "1");     // Catch: Exception -> L54
        r4.put("security_log_enabled", SecurityLogConfigUtils.c(r3));     // Catch: Exception -> L54
        String r5 = r4.toString();     // Catch: Exception -> L54
    L56:
        r11 = r10.b(r5);     // Catch: Exception -> L36
        goto L48
    L54:
        e = move-exception;
        Log.e("SecurityLogConfigUtils", "wrapDirectValue failed", e);     // Catch: Exception -> L36
        r5 = null;
        goto L56
    L38:
        r2 = false;
    L36:
        e = move-exception;
        Log.e("SettingsViaMatrixListener", "Failed to apply settings", e);
        return;
    L61:
        ViewTransition.a((ViewTransition) this.c, (View[]) this.e);
    }
}
