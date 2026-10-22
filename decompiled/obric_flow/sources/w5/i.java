package w5;

import android.app.Activity;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends s6.a {
    public boolean f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f22736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f22737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f22738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedList f22739k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22740l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f22741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f22742n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22743o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f22744p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f22745q;

    public i() {
        this.f22738j = new ConcurrentHashMap();
        new LinkedList();
        this.f22739k = new LinkedList();
        this.f22740l = 0;
        this.f22741m = 0;
        this.f22742n = 0;
        this.f22743o = 0;
        this.f22744p = 0;
        this.d = "battery";
    }

    @Override // s6.a, oj.c
    public final void c(Activity r5) {
        super.c(r5);
        this.f22740l++;
    }

    @Override // s6.a, oj.c
    public final void f(Activity r5) {
        super.f(r5);
        this.f22740l++;
    }

    @Override // s6.a
    public final void g(JSONObject r5) {
        boolean r10 = false;
        if (r5.optInt("power_monitor_enable", 0) != 1) goto L5;
        r10 = true;
    L5:
        this.f = r10;
        if (r10 == false) goto L8;
        this.g = r5.optLong("power_cpu_monitor_interval", 60000);
        this.f22736h = r5.optLong("power_battery_monior_interval", 300000);
        this.f22737i = r5.optLong("power_proc_cpu_upload_interval", 120000);
        return;
    L8:
        ActivityLifeObserver.getInstance().unregister(this);
        z6.e r11 = z6.b.f23409a;
        r11.getClass();
        ((CopyOnWriteArraySet) r11.d).remove(this);     // Catch: Throwable -> L11
        return;
    }

    @Override // s6.a
    public final boolean h() {
        return this.f;
    }

    @Override // s6.a
    public final void i() {
        long r5 = com.bytedance.apm.util.a.h();
        long r10 = SystemClock.uptimeMillis();
        long r11 = this.f22742n;
        if (r11 != 0) goto L5;
    L14:
        this.f22743o = this.f22740l;
        this.f22741m = r5;
        this.f22742n = r10;
        long r12 = SystemClock.uptimeMillis();
        if ((this.f22744p + this.f22736h) <= r12) goto L34;
        long r13 = SystemClock.uptimeMillis();
        if ((this.f22745q + this.f22737i) > r13) goto L47;
        this.f22745q = r13;
        LinkedList r14 = this.f22739k;
        monitor-enter(r14);
        Iterator r15 = this.f22739k.iterator();     // Catch: Throwable -> L27
    L23:
        if (r15.hasNext() == false) goto L29;
        h r16 = (h) r15.next();     // Catch: Throwable -> L27
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L37 Throwable -> L27
        r16.getClass();     // Catch: Exception -> L37 Throwable -> L27
        r17.put("scene", null);     // Catch: Exception -> L37 Throwable -> L27
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L37 Throwable -> L27
        r18.put("cpu_speed", r16.a());     // Catch: Exception -> L37 Throwable -> L27
        h7.a.b(new j7.a("apm_proc_cpu_info", 0, null, r17, r18, null));     // Catch: Exception -> L37 Throwable -> L27
        goto L23
    L29:
        this.f22739k.clear();     // Catch: Throwable -> L27
        monitor-exit(r14);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        throw th;
    L47:
        return;
    L34:
        this.f22744p = r12;
        throw null;
    L5:
        if (this.f22743o != this.f22740l) goto L14;
        double r19 = (r10 - r11) / 60000.0d;
        if (r19 <= 0.0d) goto L14;
        double r20 = Math.round(((r5 - this.f22741m) / r19) * 100.0d) / 100.0d;
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L36
        if (this.f21823b == false) goto L12;
        String r21 = "background";
    L13:
        r110.put(NotificationCompat.CATEGORY_STATUS, r21);     // Catch: Exception -> L36
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L36
        r111.put("cpu_speed_min", r20);     // Catch: Exception -> L36
        h7.a.b(new j7.a("apm_cpu_speed", 0, null, r110, r111, null));     // Catch: Exception -> L36
        goto L14
    L12:
        r21 = "foreground";
        goto L13
    }

    @Override // s6.a
    public final long k() {
        return this.g;
    }
}
