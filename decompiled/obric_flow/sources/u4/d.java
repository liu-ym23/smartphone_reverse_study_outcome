package u4;

import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.common.wschannel.WsConstants;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.common.lib.AppLogNewUtils;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import mn.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f22248a = null;

    static {
        f22248a = AppLogNewUtils.class.getMethod("onEventV3", new Class[]{String.class, JSONObject.class});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        h.g("default_handle", th);
    }

    public static void a(com.bytedance.android.monitorV2.event.a r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "bid");
        com.bytedance.android.monitorV2.h.e().a().d().getClass();
        if (Switches.f3593l.f3600a == true) goto L6;
        return;
    L6:
        if (r14.f3560h != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual("jsbPv", r14.f3557a) == false) goto L33;
        x4.h r5 = r14.f;
        r5.getClass();
        JSONObject r10 = new JSONObject();
        r5.m(r10);
        String r11 = r10.optString("container_type", "");
        if (Intrinsics.areEqual(r11, "lynx") == false) goto L14;
        String r12 = r10.optString("lynx_version", null);
    L17:
        x4.a r13 = r14.f3560h;
        if (r13 == null) goto L20;
        JSONObject r16 = new JSONObject();
        r13.m(r16);
    L21:
        t4.a r17 = r14.f3550m;
        if (r17 == null) goto L24;
        JSONObject r18 = r17.s();
    L25:
        a5.c r19 = com.bytedance.android.monitorV2.h.e().a().getInitConfig();
        if (r19 == null) goto L28;
        String r20 = r19.f98a;
    L29:
        String r21 = qo.a.s("url", "", r10);
        String r110 = qo.a.s("container_name", "other", r16);
        String r111 = qo.a.s("schema", null, r16);
        String r22 = qo.a.s("container_version", null, r16);
        JSONObject r23 = qo.a.q(null, r18);
        qo.a.r("url", r21, r23);
        qo.a.r("engine_version", r12, r23);
        qo.a.r("engine_type", r11, r23);
        qo.a.r("schema", r111, r23);
        qo.a.r("container_version", r22, r23);
        qo.a.r("container_name", r110, r23);
        qo.a.r("bid", r15, r23);
        qo.a.r("origin_appid", r20, r23);
        c("bd_hybrid_monitor_jsb_pv", r23);
        r14.h();
        return;
    L28:
        r20 = "";
        goto L29
    L24:
        r18 = null;
        goto L25
    L20:
        r16 = null;
        goto L21
    L14:
        if (Intrinsics.areEqual(r11, "web") == false) goto L16;
        r12 = r10.optString("web_version", null);
        goto L17
    L16:
        r12 = null;
        goto L17
    }

    public static void b(com.bytedance.android.monitorV2.event.a r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "bid");
        com.bytedance.android.monitorV2.h.e().a().d().getClass();
        if (Switches.f3593l.f3600a == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual("navigationStart", r10.f3557a) == false) goto L40;
        JSONObject r5 = new JSONObject();
        x4.h r13 = r10.f;
        if (r13 != null) goto L10;
        return;
    L10:
        if (r10.f3560h == null) goto L43;
        JSONObject r14 = new JSONObject();
        r13.m(r14);
        String r15 = "";
        qo.a.t("url", r14.optString("url", ""), r5);
        String r16 = r14.optString("container_type", "");
        qo.a.t("engine_type", r16, r5);
        if (Intrinsics.areEqual("lynx", r16) == false) goto L16;
        String r17 = r14.optString("lynx_version", null);
    L19:
        if (r17 == null) goto L21;
        qo.a.t("engine_version", r17, r5);
    L21:
        String r18 = r14.optString("native_page", null);
        if (r18 == null) goto L24;
        qo.a.t("native_page", r18, r5);
    L24:
        qo.a.t(WsConstants.KEY_SDK_VERSION, r14.optString(WsConstants.KEY_SDK_VERSION, ""), r5);
        x4.a r19 = r10.f3560h;
        if (r19 == null) goto L27;
        JSONObject r20 = new JSONObject();
        r19.m(r20);
    L28:
        if (r20 == null) goto L35;
        String r21 = r20.optString("schema", null);
        if (r21 == null) goto L32;
        qo.a.t("schema", r21, r5);
    L32:
        qo.a.t("container_name", r20.optString("container_name", "other"), r5);
        String r22 = r20.optString("container_version", null);
        if (r22 == null) goto L35;
        qo.a.t("container_version", r22, r5);
    L35:
        qo.a.t("bid", r11, r5);
        qo.a.e(r12 ? 1 : 0, "is_hybrid_sample", r5);
        a5.c r23 = com.bytedance.android.monitorV2.h.e().a().getInitConfig();
        if (r23 == null) goto L38;
        r15 = r23.f98a;
    L38:
        qo.a.t("origin_appid", r15, r5);
        c("bd_hybrid_monitor_pv", r5);
        return;
    L27:
        r20 = null;
        goto L28
    L16:
        if (Intrinsics.areEqual("web", r16) == false) goto L18;
        r17 = r14.optString("web_version", null);
        goto L19
    L18:
        r17 = null;
        goto L19
    L43:
        return;
    }

    public static void c(String r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Method r11 = f22248a;
        if (r11 == null) goto L11;
        r11.invoke(null, new Object[]{r5, r10});     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        h.g("default_handle", th);
        return;
    }
}
