package x4;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends t4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22972c;

    public g() {
        super("jsbPerf");
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        qo.a.t("bridge_name", this.f22971b, r5);
        qo.a.e(0, "status_code", r5);
        qo.a.t("status_description", null, r5);
        qo.a.t("protocol_version", null, r5);
        qo.a.k("cost_time", this.f22972c, r5);
        qo.a.k("invoke_ts", 0, r5);
        qo.a.k("callback_ts", 0, r5);
        qo.a.k("fireEvent_ts", 0, r5);
    }

    @Override // t4.a
    public final String toString() {
        StringBuilder r5 = new StringBuilder("JsbInfoData(bridgeName=");
        r5.append(this.f22971b);
        r5.append(", statusCode=0, statusDescription=null, protocolVersion=null, costTime=");
        return j0.o(r5, this.f22972c, ", invokeTime=0, callbackTime=0, fireEventTime=0)");
    }
}
