package d.b.u;

import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class q {
    public static void a(String r2, JSONObject r3) {
        d.b.u.x.b.c("onEventV3: eventName = " + r2 + " " + r3.toString());     // Catch: Throwable -> L4
        AppLogNewUtils.onEventV3(r2, r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
