package z2;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.monitor.AppletError$ErrorLevel;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.monitor.AppletMonitorableEvent$EventOrigin;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AppletErrorCode f23363k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AppletError$ErrorLevel f23364l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f23365m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f23366n;

    public a(AppletErrorCode r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "code");
        Intrinsics.checkNotNullParameter(r10, "message");
        AppletError$ErrorLevel r11 = AppletError$ErrorLevel.f2376a;
        Intrinsics.checkNotNullParameter(r5, "code");
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r11, "level");
        super("applet_error", AppletMonitorableEvent$EventOrigin.f2384a);
        this.f23363k = r5;
        this.f23365m = r10;
        this.f23364l = r11;
        Intrinsics.checkNotNullParameter("error_event", "<set-?>");
        this.f23384b = "error_event";
    }

    @Override // z2.f
    public final JSONObject a() {
        AppletErrorCode r5 = this.f23363k;
        JSONObject r10 = new JSONObject();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        r10.putOpt("packageId", this.f);     // Catch: Throwable -> L5
        r10.putOpt(Constant.APPID, this.g);     // Catch: Throwable -> L5
        r10.putOpt("code", Integer.valueOf(r5.f2380a));     // Catch: Throwable -> L5
        r10.putOpt("error_name", r5.name());     // Catch: Throwable -> L5
        r10.putOpt("message", this.f23365m);     // Catch: Throwable -> L5
        r10.putOpt("level", this.f23364l);     // Catch: Throwable -> L5
        Object r12 = Result.m124constructorimpl(r10.putOpt("ai_sdk_version", "0.90.0-rc.37-miniapp"));     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.m127exceptionOrNullimpl(r12);
        if (r13 == null) goto L12;
        String r14 = "Exception when get category: " + r13;
        Intrinsics.checkNotNullParameter("AppletError", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L12;
        r15.w("AppletError", r14);
    L12:
        return r10;
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // z2.f
    public final boolean g() {
        if (super.g() == true) goto L5;
        return false;
    L5:
        if (this.f23363k == AppletErrorCode.f2378b) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // z2.f
    public final JSONObject h() {
        if (g() == false) goto L5;
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L15
        f.d("recovery_suggestion", null, r5);     // Catch: JSONException -> L15
        f.d("error_stack", this.f23366n, r5);     // Catch: JSONException -> L15
        r5.putOpt("origin", this.f23385c.name());     // Catch: JSONException -> L15
        r5.put("timeStamp", this.e);     // Catch: JSONException -> L15
        JSONObject r10 = this.f23386h;     // Catch: JSONException -> L15
        Intrinsics.checkNotNullParameter(r5, "dst");     // Catch: JSONException -> L15
        if (r10 == null) goto L17;
        Iterator<String> r11 = r10.keys();     // Catch: JSONException -> L15
        if (r11 == null) goto L17;
    L11:
        if (r11.hasNext() == false) goto L17;
        String r12 = r11.next();     // Catch: JSONException -> L15
        Object r13 = r10.opt(r12);     // Catch: JSONException -> L15
        if (r13 == null) goto L11;
        r5.put(r12, r13);     // Catch: JSONException -> L15
    L17:
        f.f(r5);     // Catch: JSONException -> L15
        return r5;
    L15:
        e = move-exception;
        String r14 = "failed to convert error to json: " + e.getMessage();
        Intrinsics.checkNotNullParameter("AppletError", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L23;
        r15.d("AppletError", r14);
    L23:
        return new JSONObject();
    L5:
        return new JSONObject();
    }
}
