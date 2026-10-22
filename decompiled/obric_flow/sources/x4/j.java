package x4;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends t4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22980b;

    public j() {
        super("navigationStart");
        this.f22980b = System.currentTimeMillis();
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        qo.a.k("invoke_ts", this.f22980b, r5);
    }
}
