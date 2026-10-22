package d.b.v.a;

import com.bytedance.apm.util.h;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements IConfigListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile b f15133e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f15136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f15137d;

    private b() {
        this.f15135b = true;
    }

    public static b a() {
        if (f15133e != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15133e != null) goto L9;
        f15133e = new b();     // Catch: Throwable -> L11
        ((IConfigManager) d.a(IConfigManager.class)).registerConfigListener(f15133e);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f15133e;
    }

    public int b(boolean r9, String r10) {
        int r1 = 0;
        if (this.f15135b == true) goto L6;
        return 0;
    L6:
        if (r9 == false) goto L12;
        JSONObject r11 = this.f15137d;
        if (r11 != null) goto L10;
    L11:
        r1 = 16;
        goto L12
    L10:
        if (r11.optDouble(r10, -1.0d) > 0.0d) goto L11;
    L12:
        JSONObject r8 = this.f15136c;
        if (r8 != null) goto L15;
        return r1;
    L15:
        if (r8.optDouble(r10, -1.0d) > 0.0d) goto L17;
        return r1;
    L17:
        return r1 | 1;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r3, boolean r4) {
        this.f15135b = h.d(r3, "tracing", "enable_open", true);
        if (this.f15134a == true) goto L6;
        this.f15136c = h.f(r3, "tracing", "allow_service_list");
        this.f15137d = h.f(r3, "tracing", "allow_error_list");
        this.f15134a = true;
        return;
    }
}
