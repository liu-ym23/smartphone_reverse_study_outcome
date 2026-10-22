package y4;

import android.view.View;
import com.bytedance.android.monitorV2.h;
import com.bytedance.forest.model.w;
import com.bytedance.ies.web.jsbridge2.l;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import j5.b;
import j5.d;
import j5.e;
import j5.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import x4.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static void a(String r5, String r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14, int r15) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r12, "category");
        Intrinsics.checkNotNullParameter(r13, LynxMonitorService.KEY_METRICS);
        Intrinsics.checkNotNullParameter(r14, "extra");
        boolean r16 = true;
        l r17 = new l(r5, 1);
        Unit r18 = null;
        r17.f6291c = null;
        r17.f6290b = r10;
        r17.e = r11;
        r17.f6292h = r12;
        r17.f6293i = r13;
        r17.f6294j = r14;
        r17.b(r15);
        c r19 = r17.a();
        b r20 = e.f18241a;
        Intrinsics.checkNotNullParameter(r19, "customInfo");
        b r21 = e.f18241a;
        String r22 = r19.f22951i;
        r21.getClass();
        f r23 = b.i(r22);
        if (r23 == null) goto L13;
        String r24 = r23.f18244a;
        if (Intrinsics.areEqual(r24, "web") == true) goto L8;
        r16 = Intrinsics.areEqual(r24, "lynx");
    L8:
        if (r16 == false) goto L12;
        d r25 = (d) e.f18242b.get(r24);
        if (r25 == null) goto L13;
        r25.c((View) r23.f18245b.get(), r19);
        r18 = Unit.INSTANCE;
        goto L13
    L12:
        h.e().getClass();
        h.d(r19);
        r18 = Unit.INSTANCE;
    L13:
        if (r18 != null) goto L16;
        h.e().getClass();
        h.d(r19);
        return;
    }

    public static void b(String r5, LinkedHashMap r10, Map r11, w r12) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "extra");
        Intrinsics.checkNotNullParameter(r12, "response");
        Object r13 = r11.get("rl_container_uuid");
        Unit r14 = null;
        if ((r13 instanceof String) == false) goto L5;
        String r15 = (String) r13;
    L6:
        if (r15 == null) goto L21;
        b r16 = e.f18241a;
        JSONObject r17 = new JSONObject(r10);
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r17, "jsonObject");
        e.f18241a.getClass();
        Intrinsics.checkNotNullParameter(r15, "monitorId");
        f r18 = (f) b.e.get(r15);
        if (r18 == null) goto L18;
        String r19 = r18.f18244a;
        if (Intrinsics.areEqual(r19, "lynx") == false) goto L12;
        boolean r20 = true;
    L13:
        if (r20 == false) goto L17;
        d r21 = (d) e.f18242b.get(r19);
        if (r21 == null) goto L18;
        r21.b((View) r18.f18245b.get(), r5, r17);
        r14 = Unit.INSTANCE;
        goto L18
    L17:
        d5.b.e("ContainerStandardApi", "handleNativeInfo, type not register");
        r14 = Unit.INSTANCE;
        goto L18
    L12:
        r20 = Intrinsics.areEqual(r19, "web");
    L18:
        if (r14 != null) goto L20;
        d5.b.e("ContainerStandardApi", "handleNativeInfo, attachedView is null");
    L20:
        r14 = Unit.INSTANCE;
    L21:
        if (r14 != null) goto L24;
        d5.b.e("ForestMonitorHelper", "monitorId is null, skip");
        return;
    L24:
        return;
    L5:
        r15 = null;
        goto L6
    }
}
