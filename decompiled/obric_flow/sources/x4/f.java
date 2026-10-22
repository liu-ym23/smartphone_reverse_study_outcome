package x4;

import ai.j0;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends t4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22970c;
    public String d;

    public f() {
        super("jsbError");
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        qo.a.e(0, "is_sync", r5);
        qo.a.e(this.f22969b, WsConstants.ERROR_CODE, r5);
        qo.a.t("error_message", this.f22970c, r5);
        qo.a.t("bridge_name", this.d, r5);
        qo.a.t("error_activity", null, r5);
        qo.a.t("protocol_version", null, r5);
    }

    @Override // t4.a
    public final String toString() {
        StringBuilder r5 = new StringBuilder("JsbErrorData(isSync=0, errorCode=");
        r5.append(this.f22969b);
        r5.append(", errorMessage=");
        r5.append(this.f22970c);
        r5.append(", bridgeName=");
        return j0.q(r5, this.d, ", errorActivity=null, protocol=null)");
    }
}
