package z4;

import android.os.Build;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.salamander.adapter.Lock;
import com.bytedance.salamander.anniex.p;
import com.bytedance.salamander.anniex.q;
import com.ss.android.agilelogger.ALog;
import java.io.IOException;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import mn.h;
import okhttp3.OkHttpClient;
import okhttp3.h0;
import okhttp3.l0;
import okhttp3.n0;
import okhttp3.q0;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.obric.flow.cardlistpage.mvi.c {
    public final OkHttpClient d;

    public c(a5.c r5) {
        super(r5);
        this.d = new OkHttpClient(new l0());
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final a5.d a() {
        Pattern r5 = h0.e;
        h0 r10 = z.j("application/json");
        JSONObject r11 = new JSONObject();
        a5.c r12 = (a5.c) this.f11531a;
        qo.a.t(WsConstants.KEY_APP_ID, r12.f98a, r11);
        if (r12.f98a != null) goto L5;
        d5.b.e("ISettingRequestService", "monitor setting aid should not be null");
    L5:
        qo.a.t("os", r12.f100c, r11);
        qo.a.t("os_version", r12.d, r11);
        qo.a.t("install_id", null, r11);
        qo.a.t(WsConstants.KEY_DEVICE_ID, r12.e, r11);
        qo.a.t(LynxMonitorService.KEY_CHANNEL, r12.f, r11);
        qo.a.t("version_code", r12.g, r11);
        qo.a.t("update_version_code", r12.f101h, r11);
        qo.a.t("region", r12.f102i, r11);
        qo.a.t("language", r12.f103j, r11);
        qo.a.t("device_model", Build.MODEL, r11);
        qo.a.t(WsConstants.KEY_SDK_VERSION, "9.0.0", r11);
        qo.a.t("device_brand", Build.BRAND, r11);
        q0 r13 = q0.create(r10, r11.toString());
        n0 r14 = new n0();
        r14.g(r12.f99b + "/monitor_web/settings/hybrid-settings");
        r14.d("POST", r13);
        r14.a("Content-Type", "application/json");
        String r15 = this.d.a(r14.b()).execute().f20748h.string();     // Catch: IOException -> L8
        Lock r16 = q.d;     // Catch: IOException -> L8
        p.a().getClass();     // Catch: IOException -> L8
        Intrinsics.checkNotNullParameter(r15, "responseStr");     // Catch: IOException -> L8
        Intrinsics.checkNotNullParameter(r15, "settingsString");     // Catch: IOException -> L8
        p.a().getClass();     // Catch: IOException -> L8
        Intrinsics.checkNotNullParameter("HybridSettings", "tag");     // Catch: IOException -> L8
        Intrinsics.checkNotNullParameter("disable parseSettingsWithV2Response", "msg");     // Catch: IOException -> L8
        ALog.i("HybridSettings", "disable parseSettingsWithV2Response");     // Catch: IOException -> L8
        return b(r15);
    L8:
        e = move-exception;
        h.g("startup_handle", e);
        return null;
    }
}
