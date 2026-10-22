package d.b.b.d.c;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements d.b.b.l.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONArray f12570a;

    public d(JSONArray r1) {
        this.f12570a = r1;
    }

    public d(JSONObject r2) {
        JSONArray r0 = new JSONArray();
        r0.put(r2);
        this.f12570a = r0;
    }

    @Override // d.b.b.l.b
    public String a() {
        return "tracing";
    }

    @Override // d.b.b.l.b
    public boolean b() {
        return true;
    }

    @Override // d.b.b.l.b
    public final JSONObject c() {
        return d.b.b.o.b.b(a(), this.f12570a);
    }
}
