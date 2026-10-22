package d.b.h.a.a.h.o.b.z;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends k {
    private f p;

    static {
    }

    public g() {
    }

    @Override // d.b.h.a.a.h.o.b.z.k
    public a.EnumC0361a r(m r6, String r7, List<String> r8) {
        Logger.debug();
        a.EnumC0361a r0 = a.EnumC0361a.f13652f;
        Uri r1 = Uri.parse(r7);
        if (r1.getHost() != null) goto L5;
    L16:
        return r0;
    L5:
        if (i(r1) == false) goto L16;
        f r2 = this.p;
        if (r2 == null) goto L16;
        r0 = a.EnumC0361a.f13653g;
        f.b r3 = r2.c();
        f.b r4 = f.b.f13676l;
        f r5 = this.p;
        if (r3 != r4) goto L12;
        r5.a(r6);
        r8.set(0, r7);
        return r0;
    L12:
        String r9 = r5.d(r1);
        if (r7.equals(r9) == true) goto L15;
        r8.set(0, r9);
        goto L16
    L15:
        r8.set(0, r7);
        goto L16
    }

    @Override // d.b.h.a.a.h.o.b.z.k
    public int s() {
        return this.p.c().ordinal();
    }

    @Override // d.b.h.a.a.h.o.b.z.k
    protected boolean u(JSONObject r10, List<Boolean> r11, String r12, long r13) {
        k(r10);
        String r0 = r10.optString("service_name");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        this.f13651l = r0;
    L5:
        int r1 = r10.optInt("dispatch_strategy", 0);
        JSONObject r4 = r10.optJSONObject("strategy_info");
        if (r1 >= 0) goto L8;
    L12:
        this.p = null;
        return false;
    L8:
        if (r1 > 6) goto L12;
        f r14 = f.b(f.b.values()[r1], r4, r12, r13, b());
        this.p = r14;
        r11.set(0, Boolean.valueOf(r14.e()));
        return true;
    }
}
