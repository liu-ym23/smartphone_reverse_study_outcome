package d.b.b.f.c;

import android.util.Log;
import androidx.annotation.Nullable;
import com.bytedance.apm.util.n;
import com.bytedance.common.utility.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.bytedance.apm6.perf.base.model.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.b.f.c.a.EnumC0334a f12772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.w.a.a.c.a f12773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f12775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f12776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f12777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f12778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f12779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f12780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f12781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<n<String, Double>> f12782l;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12783a = null;

        static {
            int[] r0 = new int[d.b.b.f.c.a.EnumC0334a.values().length];
            f12783a = r0;
            r0[d.b.b.f.c.a.EnumC0334a.f12740f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f12783a[d.b.b.f.c.a.EnumC0334a.f12742h.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f12783a[d.b.b.f.c.a.EnumC0334a.f12741g.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public e(d.b.b.f.c.a.EnumC0334a r3, String r4, double r5, double r7, double r9, double r11, @Nullable d.b.w.a.a.c.a r13) {
        this.f12775e = -1.0d;
        this.f12776f = -1.0d;
        this.f12777g = -1.0d;
        this.f12778h = -1.0d;
        this.f12779i = -1.0f;
        this.f12780j = true;
        this.f12781k = true;
        this.f12772b = r3;
        this.f12774d = r4;
        this.f12775e = r5;
        this.f12776f = r7;
        this.f12777g = r9;
        this.f12778h = r11;
        this.f12773c = r13;
    }

    public e(d.b.b.f.c.a.EnumC0334a r3, String r4, List<n<String, Double>> r5, d.b.w.a.a.c.a r6) {
        this.f12775e = -1.0d;
        this.f12776f = -1.0d;
        this.f12777g = -1.0d;
        this.f12778h = -1.0d;
        this.f12779i = -1.0f;
        this.f12780j = true;
        this.f12781k = true;
        this.f12782l = new ArrayList(r5);
        this.f12772b = r3;
        this.f12774d = r4;
        this.f12773c = r6;
    }

    @Override // d.b.b.l.b
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject e() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L16
        r0.put("process_name", com.bytedance.apm.d.i());     // Catch: Throwable -> L16
        r0.put("is_main_process", com.bytedance.apm.d.G());     // Catch: Throwable -> L16
        r0.put("scene", this.f12774d);     // Catch: Throwable -> L16
        int r3 = a.f12783a[this.f12772b.ordinal()];     // Catch: Throwable -> L16
        if (r3 != 1) goto L6;
        String r4 = "mix";
    L11:
        r0.put("data_type", r4);     // Catch: Throwable -> L16
    L15:
        return r0;
    L6:
        if (r3 != 2) goto L8;
        r4 = "back";
        goto L11
    L8:
        if (r3 != 3) goto L15;
        r4 = "front";
    L16:
        th = move-exception;
        Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject f() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L30
        if (i() == false) goto L19;
        Iterator<n<String, Double>> r7 = this.f12782l.iterator();     // Catch: Throwable -> L30
    L6:
        if (r7.hasNext() == false) goto L29;
        n<String, Double> r1 = r7.next();     // Catch: Throwable -> L30
        if (r1 == null) goto L6;
        String r2 = r1.f2055a;     // Catch: Throwable -> L30
        if (r2 == null) goto L6;
        if (r2.isEmpty() == true) goto L6;
        Double r3 = r1.f2056b;     // Catch: Throwable -> L30
        if (r3 == null) goto L6;
        if (r3.doubleValue() == 0.0d) goto L6;
        r0.put(r1.f2055a, r1.f2056b);     // Catch: Throwable -> L30
    L29:
        return r0;
    L19:
        double r4 = this.f12775e;     // Catch: Throwable -> L30
        if (r4 > (-1.0d)) goto L22;
    L24:
        double r5 = this.f12777g;     // Catch: Throwable -> L30
        if (r5 <= (-1.0d)) goto L29;
        if (this.f12778h <= (-1.0d)) goto L29;
        r0.put("app_stat_speed", r5);     // Catch: Throwable -> L30
        r0.put("app_max_stat_speed", this.f12778h);     // Catch: Throwable -> L30
        goto L29
    L22:
        if (this.f12776f <= (-1.0d)) goto L24;
        r0.put("app_usage_rate", r4);     // Catch: Throwable -> L30
        r0.put("app_max_usage_rate", this.f12776f);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected JSONObject g() {
        JSONObject r0 = d.b.b.m.a.c.a().b();     // Catch: Throwable -> L9
        r0.put("is_auto_sample", this.f12780j);     // Catch: Throwable -> L9
        if (this.f12773c == null) goto L5;
        r0.put("network_type", i.j(com.bytedance.apm.d.h()));     // Catch: Throwable -> L9
        r0.put("battery_level", this.f12773c.f15159c);     // Catch: Throwable -> L9
        r0.put("cpu_hardware", this.f12773c.f15157a);     // Catch: Throwable -> L9
        r0.put("is_charging", this.f12773c.f15158b);     // Catch: Throwable -> L9
        r0.put("power_save_mode", this.f12773c.f15161e);     // Catch: Throwable -> L9
        r0.put("thermal_status", this.f12773c.f15160d);     // Catch: Throwable -> L9
        r0.put("battery_thermal", this.f12773c.f15162f);     // Catch: Throwable -> L9
        r0.put("is_normal_sample_state", this.f12781k);     // Catch: Throwable -> L9
    L5:
        float r4 = this.f12779i;     // Catch: Throwable -> L9
        if (r4 <= 0.0f) goto L8;
        r0.put("battery_current", r4);     // Catch: Throwable -> L9
    L8:
        return r0;
    L9:
        th = move-exception;
        Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    protected String h() {
        if (i() == false) goto L6;
        return "cpu_thread";
    L6:
        return "cpu";
    }

    public boolean i() {
        List<n<String, Double>> r0 = this.f12782l;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    public void j(float r1) {
        this.f12779i = r1;
    }

    public void k(boolean r1) {
        this.f12781k = r1;
    }
}
