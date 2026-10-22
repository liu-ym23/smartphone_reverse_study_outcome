package d.b.s.a.e0;

import com.bytedance.common.wschannel.WsConstants;
import d.b.s.a.l0.q;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class c extends q {
    public c(String r2) {
        o.g(r2, WsConstants.KEY_CONNECTION_URL);
        super(r2);
    }

    private final void g(String r3) {
        if (b.a(r3) == false) goto L5;
        return;
    L5:
        d.b.s.a.a0.a.b("ParamLimitUrlBuilder", "param key " + r3 + " is not reserved");
        throw new IllegalArgumentException("key " + r3 + " is reserved");
    }

    @Override // d.b.s.a.l0.q
    public void a(String r2, int r3) {
        o.g(r2, "name");
        g(r2);
        super.a(r2, r3);
    }

    @Override // d.b.s.a.l0.q
    public void b(String r2, String r3) {
        o.g(r2, "name");
        o.g(r3, "value");
        g(r2);
        super.b(r2, r3);
    }

    public final void f(String r2, String r3) {
        o.g(r2, "name");
        o.g(r3, "value");
        super.b(r2, r3);
    }
}
