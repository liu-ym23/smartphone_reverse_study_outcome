package u4;

import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.apm.ApmAgent;
import java.util.HashSet;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet f22246b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet f22247c = null;

    static {
        f22246b = SetsKt.hashSetOf(new String[]{"static", "js_exception", "fetchError", "jsbError", "nativeError", "navigationStart", "static_sri", "res_loader_error", "res_loader_error_template", "containerError"});
        f22247c = SetsKt.hashSetOf(new String[]{"perf", "performance", "ajax", "blank", "falconPerf", "res_loader_perf", "res_loader_perf_template"});
        SetsKt.hashSetOf(new String[]{"custom", "resource_performance", "jsbPerf", "jsbPerfV2", "jsbPv"});
    }

    public static String a(String r5, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter("bd_hybrid_monitor_service_all_in_one", "serviceName");
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r10, "containerType");
        Intrinsics.checkNotNullParameter(r11, "result");
        if (Switches.f3598q.f3600a == false) goto L16;
        if (f22246b.contains(r5) == false) goto L8;
        String r12 = "bd_hybrid_monitor_p_zero";
    L12:
        if (f22245a == true) goto L14;
        ApmAgent.monitorCommonLog(r12, r11);
    L14:
        return r12;
    L8:
        if (f22247c.contains(r5) == false) goto L10;
        r12 = "bd_hybrid_monitor_p_one";
        goto L12
    L10:
        r12 = "bd_hybrid_monitor_normal";
        goto L12
    L16:
        if (f22245a == true) goto L18;
        ApmAgent.monitorEvent("bd_hybrid_monitor_service_all_in_one", null, null, r11);
    L18:
        return "bd_hybrid_monitor_service_all_in_one";
    }
}
