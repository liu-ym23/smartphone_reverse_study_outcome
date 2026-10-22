package z1;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.web.jsbridge2.l;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import x4.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f23362c;

    public b(String r5) {
        this.f23360a = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        this.f23361b = r5;
        this.f23362c = new JSONObject();
    }

    public final void a(JSONObject r12) {
        Intrinsics.checkNotNullParameter(r12, "data");
        String r5 = "reportCustomEvent: data = " + r12;
        Intrinsics.checkNotNullParameter("EventReporter", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        a1.a.f43a.i("EventReporter", r5);
        l r10 = new l(r12.optString("eventName"), 1);
        r10.f6291c = r12.optString("bid");
        String r11 = this.f23361b;
        r10.f6290b = r11;
        r10.f6292h = r12.optJSONObject("category");
        r10.f6293i = r12.optJSONObject(LynxMonitorService.KEY_METRICS);
        r10.f6294j = r12.optJSONObject("extra");
        r10.f6295k = r12.optJSONObject("timing");
        int r13 = 2;
        int r14 = r12.optInt("level", 2);
        int r15 = r12.optInt("canSample", 1);
        boolean r16 = r12.optBoolean("canSample", true);
        if (r12.has("level") == false) goto L6;
        r13 = r14;
    L10:
        r10.b(r13);
        x4.c r17 = r10.a();
        Intrinsics.checkNotNull(r17);
        com.bytedance.android.monitorV2.event.b r18 = new com.bytedance.android.monitorV2.event.b(r17);
        a1.a.f43a.i("EventReporter", androidx.room.jarjarred.org.antlr.runtime.a.w(new StringBuilder("addBasicAttributes: naviBid is "), this.f23360a, "EventReporter", "tag", "msg"));
        LinkedHashMap r19 = r18.e;
        r19.put("config_bid", this.f23360a);
        r19.put("jsb_bid", this.f23360a);
        r18.g = this.f23362c;
        h r110 = r18.f;
        r110.f22973a = r11;
        r110.f22975c = "lynx";
        qo.a.e(3, WsConstants.KEY_PLATFORM, r18.f3553m.f22950h);
        com.bytedance.android.monitorV2.dataprocessor.b r111 = com.bytedance.android.monitorV2.c.f3517a;
        com.bytedance.android.monitorV2.c.d(r18, Boolean.TRUE);
        return;
    L6:
        if (r12.has("canSample") == false) goto L10;
        if (r15 == 0) goto L9;
        if (r16 == true) goto L10;
    L9:
        r13 = 0;
        goto L10
    }
}
