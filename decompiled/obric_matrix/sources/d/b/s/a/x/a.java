package d.b.s.a.x;

import android.content.Context;
import com.ss.android.i.j;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f14972b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f14973a;

    private a() {
        this.f14973a = j.k().e();
    }

    public static b c() {
        if (f14972b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f14972b != null) goto L9;
        f14972b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f14972b;
    }

    @Override // d.b.s.a.x.b
    public void a(String r1, d.b.s.a.x.d.c.a r2) {
        d.b.s.a.x.d.c.b.L(this.f14973a, r1, r2).D();
    }

    @Override // d.b.s.a.x.b
    public void b(Map<String, String> r2, JSONObject r3, d.b.s.a.x.d.b.a r4) {
        d(r2, r3, false, r4);
    }

    public void d(Map<String, String> r7, JSONObject r8, boolean r9, d.b.s.a.x.d.b.a r10) {
        d.b.s.a.x.d.b.b.P(this.f14973a, r7, r8, null, r9, r10).D();
    }
}
