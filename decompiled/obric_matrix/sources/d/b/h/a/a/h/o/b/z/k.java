package d.b.h.a.a.h.o.b.z;

import android.text.TextUtils;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends a {
    private boolean o;

    static {
    }

    public k() {
        this.o = false;
    }

    @Override // d.b.h.a.a.h.o.b.z.a
    public boolean e(JSONObject r9, String r10, long r11) {
        ArrayList r6 = new ArrayList();
        r6.add(0, Boolean.FALSE);
        boolean r12 = u(r9, r6, r10, r11);
        this.o = r6.get(0).booleanValue();
        return r12;
    }

    public abstract a.EnumC0361a r(m r1, String r2, List<String> r3);

    public abstract int s();

    public int t() {
        return NetError.ERR_TTNET_TRAFFIC_CONTROL_DROP;
    }

    protected abstract boolean u(JSONObject r1, List<Boolean> r2, String r3, long r4);

    public boolean v() {
        return this.o;
    }

    public a.EnumC0361a w(m r5, String r6, List<String> r7, List<d> r8) {
        if (f(r5) == true) goto L5;
    L15:
        r7.set(0, r6);
        return a.EnumC0361a.f13652f;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L15;
        a.EnumC0361a r9 = r(r5, r6, r7);
        d r0 = new d();
        if (r9 == a.EnumC0361a.f13652f) goto L13;
        r0.f13660d = true;
        r0.f13658b = c();
        r0.f13659c = b();
        r0.f13661e = s();
        r0.f13657a = d();
        if (r9 != a.EnumC0361a.f13653g) goto L12;
        r0.f13663g = r7.get(0);
        r0.f13662f = v();
    L12:
        r5.e(this.m);
    L13:
        r8.add(r0);
        return r9;
    }
}
