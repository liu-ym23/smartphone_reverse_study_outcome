package d.b.b.k.h;

import d.b.b.m.a.c;
import d.b.b.o.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends com.bytedance.apm6.perf.base.model.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f13014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f13019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f13020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f13021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f13022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f13023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f13024l;
    private double m;
    private boolean n;
    private boolean o;
    private Map<Object, Object> p;

    public a(long r4, long r6, long r8, long r10, boolean r12, long r13, long r15, long r17, long r19, long r21, long r23, double r25, boolean r27, boolean r28) {
        this.f13014b = r4;
        this.f13015c = r6;
        this.f13016d = r8;
        this.f13017e = r10;
        this.f13018f = r12;
        this.f13019g = r13;
        this.f13020h = r15;
        this.f13021i = r17;
        this.f13022j = r19;
        this.f13023k = r21;
        this.f13024l = r23;
        this.m = r25;
        this.n = r27;
        this.o = r28;
    }

    private void i(JSONObject r5) {
        if (r5 != null) goto L14;
        return;
    L14:
        Map<Object, Object> r4 = this.p;     // Catch: Exception -> L13
        if (r4 != null) goto L7;
        return;
    L7:
        Iterator<Map.Entry<Object, Object>> r6 = r4.entrySet().iterator();     // Catch: Exception -> L13
    L9:
        if (r6.hasNext() == false) goto L18;
        Map.Entry<Object, Object> r0 = r6.next();     // Catch: Exception -> L13
        r5.put((String) r0.getKey(), Long.parseLong((String) r0.getValue()));     // Catch: Exception -> L13
    L18:
        return;
    }

    @Override // d.b.b.l.b
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject e() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L8
        r0.put("scene", c.a().e());     // Catch: Throwable -> L8
        r0.put("process_name", d.b.b.i.c.a.m());     // Catch: Throwable -> L8
        if (this.f13018f == true) goto L5;
        boolean r3 = true;
    L6:
        r0.put("is_front", r3);     // Catch: Throwable -> L8
        r0.put("is_main_process", d.b.b.i.c.a.A());     // Catch: Throwable -> L8
        return r0;
    L5:
        r3 = false;
    L8:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject f() {
        JSONObject r0 = new JSONObject();
        r0.put("gc_count", this.f13014b);     // Catch: JSONException -> L13
        r0.put("gc_time", this.f13015c);     // Catch: JSONException -> L13
        r0.put("block_gc_count", this.f13016d);     // Catch: JSONException -> L13
        r0.put("block_gc_time", this.f13017e);     // Catch: JSONException -> L13
        if (this.f13018f == false) goto L7;
        r0.put("dalvik_pss_background", this.f13022j);     // Catch: JSONException -> L13
        r0.put("native_pss_background", this.f13019g);     // Catch: JSONException -> L13
        r0.put("total_pss_background", this.f13020h);     // Catch: JSONException -> L13
        r0.put("java_heap_background", this.f13021i);     // Catch: JSONException -> L13
        r0.put("java_heap_background_used_rate", this.m);     // Catch: JSONException -> L13
        r0.put("vm_size_background", this.f13024l);     // Catch: JSONException -> L13
        String r1 = "graphics_background";
        long r2 = this.f13023k;     // Catch: JSONException -> L13
    L6:
        r0.put(r1, r2);     // Catch: JSONException -> L13
        if (this.n == false) goto L11;
        r0.put("reach_top_java", 1);     // Catch: JSONException -> L13
    L11:
        i(r0);     // Catch: JSONException -> L13
    L15:
        return r0;
    L7:
        r0.put("dalvik_pss_foreground", this.f13022j);     // Catch: JSONException -> L13
        r0.put("native_pss_foreground", this.f13019g);     // Catch: JSONException -> L13
        r0.put("total_pss_foreground", this.f13020h);     // Catch: JSONException -> L13
        r0.put("java_heap_foreground", this.f13021i);     // Catch: JSONException -> L13
        r0.put("java_heap_foreground_used_rate", this.m);     // Catch: JSONException -> L13
        r0.put("vm_size_foreground", this.f13024l);     // Catch: JSONException -> L13
        r1 = "graphics_foreground";
        r2 = this.f13023k;     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject g() {
        JSONObject r0 = c.a().b();
        if (this.o == true) goto L14;
    L6:
        d.b.b.n.d.a r1 = (d.b.b.n.d.a) d.b.b.n.c.a(d.b.b.n.d.a.class);
        if (r1 != null) goto L12;
    L9:
        return r0;
    L12:
        e.a(r0, r1.e());     // Catch: Exception -> L11
        goto L9
    L14:
        e.a(r0, c.a().d());     // Catch: Exception -> L10
        goto L6
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected String h() {
        return "memory";
    }

    public double j() {
        return this.m;
    }

    public d.b.b.k.e.a k() {
        d.b.b.k.e.a r0 = new d.b.b.k.e.a();
        r0.f12996a = this.f13014b;
        r0.f12997b = this.f13015c;
        r0.f12998c = this.f13016d;
        r0.f12999d = this.f13017e;
        r0.f13000e = this.f13018f;
        r0.f13001f = this.f13019g;
        r0.f13002g = this.f13020h;
        r0.f13003h = this.f13021i;
        r0.f13004i = this.f13022j;
        r0.f13005j = this.f13023k;
        r0.f13006k = this.f13024l;
        r0.f13007l = this.n;
        return r0;
    }

    public void l(Map<Object, Object> r1) {
        this.p = r1;
    }

    public String toString() {
        return "MemoryPerfMonitorable{gcCount=" + this.f13014b + ", gcTime=" + this.f13015c + ", blockingGcCount=" + this.f13016d + ", blockingGcTime=" + this.f13017e + ", background=" + this.f13018f + ", nativePss=" + this.f13019g + ", totalPss=" + this.f13020h + ", javaUsedMemory=" + this.f13021i + ", dalvikUsedSize=" + this.f13022j + ", graphics=" + this.f13023k + ", vmSize=" + this.f13024l + ", javaUsedMemoryRate=" + this.m + ", isMemoryReachTop=" + this.n + '}';
    }
}
