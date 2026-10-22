package t4;

import ai.j0;
import org.json.JSONObject;
import sj.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22098a;

    public a(String r5) {
        this.f22098a = r5;
    }

    public final JSONObject s() {
        JSONObject r5 = new JSONObject();
        m(r5);
        qo.a.t("event_type", this.f22098a, r5);
        return r5;
    }

    public String toString() {
        return j0.q(new StringBuilder("BaseNativeInfo{eventType='"), this.f22098a, "'}");
    }
}
