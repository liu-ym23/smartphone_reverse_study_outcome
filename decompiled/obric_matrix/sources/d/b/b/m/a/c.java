package d.b.b.m.a;

import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.apm.util.f;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements d.b.b.n.h.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile c f13029g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f13030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f13031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13035f;

    private c() {
        this.f13030a = new CopyOnWriteArraySet();
        this.f13031b = new ConcurrentHashMap();
    }

    public static c a() {
        if (f13029g != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13029g != null) goto L9;
        f13029g = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f13029g;
    }

    private void f() {
        this.f13032c = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r0 = Runtime.getRuntime();
        long r4 = r0.maxMemory();
        long r6 = r0.freeMemory();
        long r1 = r0.totalMemory();
        this.f13034e = r4 / 1048576;
        long r2 = r1 - r6;
        this.f13035f = r2 / 1048576;
        if (r2 <= (r4 * 0.95f)) goto L5;
        boolean r3 = true;
    L6:
        this.f13033d = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public JSONObject b() {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r3 = this.f13031b.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r3.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r3.next();     // Catch: JSONException -> L9
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L9
    L8:
        return r0;
    }

    public JSONObject c(boolean r4) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r3 = this.f13031b.entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r3.hasNext() == false) goto L7;
        Map.Entry<String, String> r1 = r3.next();     // Catch: JSONException -> L11
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r0.put("RealRefreshRate", String.valueOf(f.d()));     // Catch: JSONException -> L11
        r0.put("RealMaxRefreshRate", String.valueOf(f.d()));     // Catch: JSONException -> L11
        if (r4 == false) goto L10;
        com.bytedance.apm.util.c.k().e(r0);     // Catch: JSONException -> L11
        com.bytedance.apm.util.c.k().a(r0);     // Catch: JSONException -> L11
    L10:
        return r0;
    }

    public JSONObject d() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        f();     // Catch: Exception -> L4
        r0.put("apm_native_heap_size", this.f13032c);     // Catch: Exception -> L4
        r0.put("apm_java_heap_leak", this.f13033d);     // Catch: Exception -> L4
        r0.put("apm_java_heap_used", this.f13035f);     // Catch: Exception -> L4
        r0.put("apm_java_heap_max", this.f13034e);     // Catch: Exception -> L4
        return r0;
    L4:
        return null;
    }

    public String e() {
        String r1 = d.b.b.o.f.a(this.f13030a.toArray(), "#");
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        d.b.b.n.g.a r2 = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2.c();
    }
}
