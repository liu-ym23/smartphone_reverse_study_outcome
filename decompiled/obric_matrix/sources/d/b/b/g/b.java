package d.b.b.g;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import d.b.b.o.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.apm6.perf.base.model.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f12884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private JSONArray f12885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private JSONArray f12886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private JSONArray f12887l;
    private JSONArray m;
    private int n;

    public b(long r4, long r6, long r8, long r10, long r12, long r14, long r16, double r18, JSONArray r20, JSONArray r21, JSONArray r22, JSONArray r23) {
        this.n = 262144;
        this.f12877b = r4;
        this.f12878c = r6;
        this.f12879d = r8;
        this.f12880e = r10;
        this.f12881f = r12;
        this.f12882g = r14;
        this.f12883h = r16;
        this.f12884i = r18;
        this.f12885j = r20;
        this.f12886k = r21;
        this.f12887l = r22;
        this.m = r23;
    }

    private static long i(JSONArray r2) {
        return r2.toString().getBytes("UTF-8").length;
    L5:
        return 0;
    }

    private JSONArray j(JSONArray r8, int r9) {
        JSONArray r0 = new JSONArray();
        int r1 = 0;
    L4:
        if (r1 >= r8.length()) goto L16;
        JSONObject r2 = r8.getJSONObject(r1);
        if (r2.getLong("size") < r9) goto L15;
        JSONArray r4 = r2.optJSONArray("next_disk");
        if (r4 == null) goto L14;
        JSONArray r5 = j(r4, r9);
        if (r5.length() <= 0) goto L13;
        r2.put("next_disk", r5);
        goto L14
    L13:
        r2.remove("next_disk");
    L14:
        r0.put(r2);
    L15:
        r1 = r1 + 1;
        goto L4
    L16:
        return r0;
    }

    private JSONArray k(JSONArray r7) {
        if (r7 == null) goto L4;
        int r0 = 102400;
        int r1 = 0;
    L7:
        if (i(r7) <= this.n) goto L12;
        if (r1 > 10) goto L12;
        r7 = j(r7, r0);     // Catch: JSONException -> L13
    L11:
        r0 = r0 * 2;
        r1 = r1 + 1;
    L12:
        return r7;
    L4:
        return new JSONArray();
    }

    @Override // d.b.b.l.b
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject d() {
        JSONObject r0 = new JSONObject();
        JSONArray r1 = this.f12885j;     // Catch: Exception -> L20
        if (r1 == null) goto L6;
        r0.put("top_usage", r1);     // Catch: Exception -> L20
    L6:
        JSONArray r2 = this.f12886k;     // Catch: Exception -> L20
        if (r2 == null) goto L9;
        r0.put("exception_folders", r2);     // Catch: Exception -> L20
    L9:
        JSONArray r3 = this.f12887l;     // Catch: Exception -> L20
        if (r3 == null) goto L13;
        r0.put("outdated_files", r3);     // Catch: Exception -> L20
    L13:
        if (this.m == null) goto L18;
        int r4 = 0;
        r4 = r0.toString().getBytes("UTF-8").length;     // Catch: Exception -> L19
    L17:
        this.n = (262144 - r4) - 12288;     // Catch: Exception -> L20
        JSONArray r5 = k(this.m);     // Catch: Exception -> L20
        this.m = r5;     // Catch: Exception -> L20
        r0.put("disk_info", r5);     // Catch: Exception -> L20
    L18:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject e() {
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L4
        r2.put("scene", d.b.b.m.a.c.a().e());     // Catch: Throwable -> L4
        r2.put("process_name", d.b.b.i.c.a.m());     // Catch: Throwable -> L4
        r2.put("is_front", false);     // Catch: Throwable -> L4
        r2.put("is_main_process", d.b.b.i.c.a.A());     // Catch: Throwable -> L4
        return r2;
    L4:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject f() {
        JSONObject r0 = new JSONObject();
        long r1 = this.f12877b;     // Catch: Exception -> L28
        if (r1 <= 0) goto L6;
        r0.put("data", r1);     // Catch: Exception -> L28
    L6:
        long r2 = this.f12878c;     // Catch: Exception -> L28
        if (r2 <= 0) goto L9;
        r0.put(LocationMonitorConst.CACHE, r2);     // Catch: Exception -> L28
    L9:
        long r3 = this.f12879d;     // Catch: Exception -> L28
        if (r3 <= 0) goto L12;
        r0.put("total", r3);     // Catch: Exception -> L28
    L12:
        long r4 = this.f12880e;     // Catch: Exception -> L28
        if (r4 <= 0) goto L15;
        r0.put("rom_free", r4);     // Catch: Exception -> L28
    L15:
        long r5 = this.f12881f;     // Catch: Exception -> L28
        if (r5 <= 0) goto L18;
        r0.put("app_usage", r5);     // Catch: Exception -> L28
    L18:
        long r6 = this.f12882g;     // Catch: Exception -> L28
        if (r6 <= 0) goto L21;
        r0.put("total_capacity", r6);     // Catch: Exception -> L28
    L21:
        long r7 = this.f12883h;     // Catch: Exception -> L28
        if (r7 <= 0) goto L24;
        r0.put("free_capacity", r7);     // Catch: Exception -> L28
    L24:
        double r8 = this.f12884i;     // Catch: Exception -> L28
        if (r8 <= 0.0d) goto L27;
        r0.put("app_occupied_rate", r8);     // Catch: Exception -> L28
    L27:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject g() {
        JSONObject r1 = d.b.b.m.a.c.a().b();
        e.a(r1, d.b.b.m.a.c.a().d());     // Catch: Exception -> L5
    L4:
        return r1;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected String h() {
        return "disk";
    }
}
