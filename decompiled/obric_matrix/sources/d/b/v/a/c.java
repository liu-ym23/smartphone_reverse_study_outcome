package d.b.v.a;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.apm.t.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f15138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f15141d;

    public c(JSONObject r1, String r2, boolean r3, String r4) {
        this.f15138a = r1;
        this.f15139b = r2;
        this.f15140c = r3;
        this.f15141d = r4;
    }

    @Override // com.bytedance.apm.t.b
    public String a() {
        return this.f15141d;
    }

    @Override // com.bytedance.apm.t.b
    public boolean b(JSONObject r2) {
        if ("app_launch_trace".equals(this.f15139b) == false) goto L7;
        return com.bytedance.apm.d0.c.c("start_trace");
    L7:
        if (b.a().b(this.f15140c, this.f15139b) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.apm.t.b
    @Nullable
    public JSONObject c() {
        return this.f15138a;
    }

    @Override // com.bytedance.apm.t.b
    public boolean d() {
        return false;
    }

    @Override // com.bytedance.apm.t.b
    public String e() {
        return "tracing";
    }
}
