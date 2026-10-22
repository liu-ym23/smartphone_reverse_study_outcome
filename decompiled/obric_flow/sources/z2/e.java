package z2;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.monitor.AppletJSBEvent$JSBType;
import com.bytedance.ai.monitor.AppletMonitorableEvent$EventOrigin;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f23376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f23377l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppletJSBEvent$JSBType f23378m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f23379n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f23380o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONObject f23381p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f23382q;

    public e(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "bridgeName");
        super("applet_jsb_event", AppletMonitorableEvent$EventOrigin.f2384a);
        this.f23378m = AppletJSBEvent$JSBType.f2381a;
        this.f23380o = true;
        Intrinsics.checkNotNullParameter("jsb_event", "<set-?>");
        this.f23384b = "jsb_event";
        this.f23376k = r5;
        this.f23377l = r10;
    }

    @Override // z2.f
    public final JSONObject a() {
        JSONObject r5 = new JSONObject();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        r5.putOpt("packageId", this.f);     // Catch: Throwable -> L5
        r5.putOpt(Constant.APPID, this.g);     // Catch: Throwable -> L5
        r5.putOpt("bridgeName", this.f23376k);     // Catch: Throwable -> L5
        r5.putOpt("code", Integer.valueOf(this.f23377l));     // Catch: Throwable -> L5
        r5.putOpt("jsbType", this.f23378m.name());     // Catch: Throwable -> L5
        r5.putOpt("message", this.f23379n);     // Catch: Throwable -> L5
        r5.putOpt("success", Boolean.valueOf(this.f23380o));     // Catch: Throwable -> L5
        r5.putOpt("url", this.f23382q);     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(r5.putOpt("containerType", null));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L12;
        String r13 = "Exception when get category: " + r12;
        Intrinsics.checkNotNullParameter("AppletJSBEvent", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L12;
        r14.w("AppletJSBEvent", r13);
    L12:
        return r5;
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // z2.f
    public final boolean g() {
        if (super.g() == false) goto L10;
        String r5 = this.f23376k;
        if (StringsKt.isBlank(r5) == false) goto L7;
        return false;
    L7:
        if (r5.length() <= 0) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    @Override // z2.f
    public final JSONObject h() {
        JSONObject r5 = super.h();
        if (r5.length() != 0) goto L13;
    L12:
        return r5;
    L13:
    L9:
        Intrinsics.checkNotNullParameter("AppletJSBEvent", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L12;
        r10.w("AppletJSBEvent", "Exception occurred when parse jsb event to json");
        goto L12
    L6:
        if (this.f23380o == true) goto L12;
        r5.putOpt(LynxResourceModule.PARAMS_KEY, this.f23381p);     // Catch: JSONException -> L9
        return r5;
    }
}
