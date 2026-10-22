package d.b.u;

import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k implements d.b.u.w.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final l<d.b.u.w.f> f15055a = null;

    static class a extends l<d.b.u.w.f> {
        a() {
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ d.b.u.w.f a(Object[] r1) {
            return c(r1);
        }

        protected d.b.u.w.f c(Object... r1) {
            return new k();
        }
    }

    static {
        f15055a = new a();
    }

    public k() {
    }

    public static d.b.u.w.f c() {
        return f15055a.b(new Object[0]);
    }

    private void d(String r1, JSONObject r2) {
        r.c(r1, r2, null, null);
    }

    @Override // d.b.u.w.f
    public void a(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        d.b.u.d0.a.c(r0, "config", r3);
        d.b.u.d0.a.c(r0, WsConstants.KEY_CONNECTION_ERROR, r4);
        d("sync_config", r0);
    }

    @Override // d.b.u.w.f
    public void b(boolean r3) {
        JSONObject r0 = new JSONObject();
        d.b.u.d0.a.a(r0, "login", r3 ? 1 : 0);
        d("sync_account_status", r0);
    }

    @Override // d.b.u.w.f
    public void ensureNotReachHere(Throwable r1, String r2) {
        r.f(r1, r2);
    }
}
