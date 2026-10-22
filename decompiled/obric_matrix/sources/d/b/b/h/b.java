package d.b.b.h;

import d.b.b.m.a.c;
import d.b.b.o.f;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.apm6.perf.base.model.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f12945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12946d;

    public b(int r1, List<String> r2, boolean r3) {
        this.f12944b = r1;
        this.f12945c = r2;
        this.f12946d = r3;
    }

    @Override // d.b.b.l.b
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject d() {
        JSONObject r0 = new JSONObject();
        r0.put("fd_count", this.f12944b);     // Catch: Exception -> L7
        if (f.b(this.f12945c) == true) goto L6;
        r0.put("fd_detail", f.d(this.f12945c, "\n"));     // Catch: Exception -> L7
    L6:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject e() {
        JSONObject r0 = super.e();
        if (r0 == null) goto L8;
    L5:
        r0.put("is_front", this.f12946d);     // Catch: Exception -> L7
    L6:
        return r0;
    L8:
        r0 = new JSONObject();     // Catch: Exception -> L7
        goto L5
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject f() {
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject g() {
        return c.a().b();
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected String h() {
        return "fd";
    }
}
