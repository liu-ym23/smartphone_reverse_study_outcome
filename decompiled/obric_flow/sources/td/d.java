package td;

import a3.i;
import ai.j0;
import android.util.Log;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements rd.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22126a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static i f22127b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f22128c = false;

    public static final n a(n r5) {
        if ((r5 instanceof com.bytedance.ies.bullet.pool.a) == false) goto L6;
        return null;
    L6:
        return r5;
    }

    public static String b(String r5, String r10) {
        return j0.C(r5, r10);
    }

    public static final String c() {
        return UUID.randomUUID().toString();
    }

    public static boolean d(List r5) {
        if (r5 != null) goto L4;
    L7:
        return true;
    L4:
        if (r5.size() == 0) goto L7;
        return false;
    }

    public static void e(JSONObject r5, JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter("event_send_cmd_result", "eventName");
        Intrinsics.checkNotNullParameter(r5, "category");
        Intrinsics.checkNotNullParameter(r10, LynxMonitorService.KEY_METRIC);
        Intrinsics.checkNotNullParameter(r11, "logExtr");
        com.lynx.jsbridge.a.q("SdkMonitorManager", "on event device_id = null");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.lynx.jsbridge.a.q("SdkMonitorManager", "event report exception " + Log.getStackTraceString(e));
    }
}
