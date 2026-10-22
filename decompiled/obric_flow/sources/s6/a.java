package s6;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.j;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements oj.c, pj.a, z6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21824c;
    public String d;
    public long e;

    public static void j(j6.e r10) {
        Object[] r5 = ((CopyOnWriteArraySet) c.w().f21828b).toArray();
        if (r5 != null) goto L5;
        String r11 = "";
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L16;
        r11 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L16:
        JSONObject r12 = r10.f18261c;
        if (r12 != null) goto L29;
        r12 = new JSONObject();
    L29:
        if (TextUtils.isEmpty(r11) == false) goto L22;
        r11 = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: JSONException -> L28
    L22:
        r12.put("scene", r11);     // Catch: JSONException -> L28
        r12.put("process_name", j.a());     // Catch: JSONException -> L28
        r12.put("is_main_process", j.d());     // Catch: JSONException -> L28
        if (r12.isNull("is_front") == false) goto L25;
        r12.put("is_front", ActivityLifeObserver.getInstance().isForeground());     // Catch: JSONException -> L28
    L25:
        r10.f18261c = r12;     // Catch: JSONException -> L28
    L26:
        r10.d = c.w().x(TextUtils.equals(r10.f18259a, LynxMonitorService.KEY_MEMORY));
        i6.a.i().b(r10);
        return;
    L5:
        StringBuilder r13 = new StringBuilder();
        int r14 = r5.length;
        boolean r15 = true;
        int r16 = 0;
    L6:
        if (r16 >= r14) goto L12;
        Object r17 = r5[r16];
        if (r15 == false) goto L10;
        r15 = false;
    L11:
        r13.append(r17.toString());
        r16 = r16 + 1;
        goto L6
    L10:
        r13.append("#");
        goto L11
    L12:
        r11 = r13.toString();
        goto L14
    }

    @Override // z6.c
    public final void a(long r5) {
        long r10 = k();
        if (r10 > 0) goto L5;
        return;
    L5:
        if ((r5 - this.e) > r10) goto L7;
        return;
    L7:
        if (this.f21822a == false) goto L12;
        i();
        this.e = System.currentTimeMillis();
        return;
    }

    @Override // oj.c
    public void b(Activity r5) {
    }

    @Override // oj.c
    public void c(Activity r5) {
        this.f21823b = false;
        boolean r10 = j.f3887a;
    }

    @Override // pj.a
    public final void d(JSONObject r5, boolean r10) {
        JSONObject r11 = r5.optJSONObject("performance_modules");
        if (r11 != null) goto L5;
        return;
    L5:
        JSONObject r12 = r11.optJSONObject(this.d);
        if (r12 != null) goto L8;
        return;
    L8:
        g(r12);
    }

    @Override // pj.a
    public void e() {
        this.f21822a = true;
        if (this.f21824c == true) goto L7;
        this.f21824c = true;
        if (h() == false) goto L7;
        z6.b.f23409a.a(this);
    L7:
        i();
        this.e = System.currentTimeMillis();
    }

    @Override // oj.c
    public void f(Activity r5) {
        this.f21823b = true;
        boolean r10 = j.f3887a;
    }

    public abstract void g(JSONObject r5);

    public abstract boolean h();

    public void i() {
    }

    public abstract long k();
}
