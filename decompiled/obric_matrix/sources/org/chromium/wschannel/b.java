package org.chromium.wschannel;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import d.b.h.a.a.h.g;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f22692d = 100;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f22693e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f22694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f22695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f22696c;

    static {
    }

    public b(Map<String, Object> r12, boolean r13) {
        this.f22696c = true;
        if (g.m() <= 0) goto L5;
        f22692d = g.m();
        long r5 = a(r12, "destroy_timeout_millis", 0);
        if (r5 < 1000) goto L11;
        f22693e = true;
        if (r13 == false) goto L20;
        this.f22694a = r5 - f22692d;
        if (Logger.debug() == false) goto L39;
        Logger.d("CronetFrontierConnection", "Destroy ws timeout: " + this.f22694a);
        return;
    L39:
        return;
    L20:
        long r14 = a(r12, "fallback_timeout_mills", BDLocationConfig.sScanBleMaxInterval);
        if (Logger.debug() == false) goto L24;
        Logger.d("CronetFrontierConnection", "fallback timeout:" + r14 + " destroy timeout:" + r5);
    L24:
        if (r14 < r5) goto L30;
        this.f22696c = false;
        if (Logger.debug() == false) goto L28;
        Logger.d("CronetFrontierConnection", "Disable fallback to websocket, fallback >= destroy timeout");
    L28:
        this.f22695b = r5 - f22692d;
        return;
    L30:
        long r7 = f22692d;
        this.f22695b = r14 - r7;
        long r6 = (r5 - r14) - r7;
        this.f22694a = r6;
        if (r6 < 0) goto L33;
        return;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d("CronetFrontierConnection", "Disable fallback to websocket, timeout <= 0:" + this.f22694a);
    L35:
        this.f22696c = false;
        return;
    L11:
        if (Logger.debug() == false) goto L38;
        Logger.d("CronetFrontierConnection", "Destroy timeout disable: " + r5);
        return;
    L38:
        return;
    L5:
        if (Logger.debug() == false) goto L37;
        Logger.d("CronetFrontierConnection", "Destroy delta disable: " + g.m());
        return;
    }

    private static long a(Map<String, Object> r1, String r2, long r3) {
        Map r4 = (Map) r1.get(WsConstants.KEY_HEADERS);
        if (r4 != null) goto L5;
        return r3;
    L5:
        if (r4.isEmpty() == false) goto L8;
        return r3;
    L8:
        if (r4.containsKey(r2) == true) goto L10;
        return r3;
    L10:
        String r5 = (String) r4.get(r2);
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return r3;
    L18:
        int r6 = Integer.valueOf(r5).intValue();     // Catch: Exception -> L17
        if (r6 > 0) goto L16;
        return r3;
    L16:
        return r6;
    L23:
        return r3;
    }

    public static boolean d(String r2, boolean r3) {
        if (f22693e == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        if (r3 == false) goto L16;
        if (r2.contains("\\\"net_error\\\":-7") == true) goto L12;
        return false;
    L12:
        if (r2.contains("WebSocket opening handshake timed out") == true) goto L14;
        return false;
    L14:
        return true;
    L16:
        if (r2.contains("\"error_code\":-193") == true) goto L22;
        if (r2.contains("\"error_code\":-356") == true) goto L20;
        return false;
    L20:
        if (r2.contains("\\\"internal_error\\\":67") == true) goto L22;
        return false;
    L22:
        return true;
    }

    public long b() {
        if (f22693e == true) goto L7;
        return 0;
    L7:
        return this.f22695b;
    }

    public long c() {
        if (f22693e == true) goto L7;
        return 0;
    L7:
        return this.f22694a;
    }

    public boolean e() {
        if (f22693e == true) goto L7;
        return true;
    L7:
        return this.f22696c;
    }
}
