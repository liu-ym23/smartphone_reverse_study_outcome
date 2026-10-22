package d.b.s.a.q.j;

import com.bytedance.sdk.account.impl.l;
import d.b.s.a.q.j.b;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends b> extends com.bytedance.sdk.account.impl.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14884b;

    public a() {
    }

    private void f() {
        d.b.s.a.q.l.a r2 = this.f5521a;
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof l) == false) goto L9;
        ((l) r2).G(System.currentTimeMillis());
        return;
    }

    public final void a(T r2) {
        if (b() == true) goto L6;
        f();
        c(r2);
        return;
    }

    public boolean b() {
        return this.f14884b;
    }

    public abstract void c(T r1);

    public Map<String, String> d(T r1) {
        return null;
    }

    public JSONObject e(String r1) {
        return null;
    }
}
