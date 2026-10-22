package d.b.h.a.a.j;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends d.b.h.a.a.a.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile e f13789d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicBoolean f13790c;

    public e(int r2) {
        super(r2);
        this.f13790c = new AtomicBoolean(false);
    }

    public static e f() {
        if (f13789d != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13789d != null) goto L9;
        f13789d = new e(LocationInfoConst.HALF_MINUTES);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f13789d;
    }

    @Override // d.b.h.a.a.a.b
    public void c() {
        this.f13790c.set(true);
        Logger.debug();
    }

    @Override // d.b.h.a.a.a.b
    public void d() {
        this.f13790c.set(false);
        Logger.debug();
    }

    public void g(JSONObject r3) {
        e(r3.optInt("qf_enter_background_time", LocationInfoConst.HALF_MINUTES));
    }
}
