package x4;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends t4.a {
    public b() {
        super("containerError");
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
    }

    @Override // t4.a
    public final String toString() {
        return "event_type:" + this.f22098a;
    }
}
