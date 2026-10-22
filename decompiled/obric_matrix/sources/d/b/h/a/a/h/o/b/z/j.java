package d.b.h.a.a.h.o.b.z;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.net.NetError;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j extends k {
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;

    static {
    }

    public j() {
        this.u = false;
        this.v = NetError.ERR_TTNET_TRAFFIC_CONTROL_DROP;
        this.w = 100;
        this.x = false;
    }

    private boolean x(String r5, String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return false;
    L6:
        if (r5.equals(r6) == false) goto L9;
        return true;
    L9:
        if (r5.equals("http") == true) goto L13;
        if (r5.equals(LocationInfoConst.HTTPS) == true) goto L13;
    L18:
        if (r5.equals("ws") == true) goto L22;
        if (r5.equals("wss") == true) goto L22;
    L26:
        return false;
    L22:
        if (r6.equals("ws") == false) goto L24;
    L27:
        return true;
    L24:
        if (r6.equals("wss") == false) goto L26;
    L13:
        if (r6.equals("http") == true) goto L27;
        if (r6.equals(LocationInfoConst.HTTPS) == false) goto L18;
        goto L27
    }

    private boolean y() {
        int r0 = this.w;
        if (r0 < 100) goto L6;
        return true;
    L6:
        if (r0 > 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(100) >= this.w) goto L11;
        return true;
    L11:
        Logger.debug();
        return false;
    }

    @Override // d.b.h.a.a.h.o.b.z.k
    public a.EnumC0361a r(m r4, String r5, List<String> r6) {
        Logger.debug();
        Uri r7 = Uri.parse(r5);
        if (this.x == false) goto L5;
    L47:
        r6.set(0, r5);
        return a.EnumC0361a.f13652f;
    L5:
        if (i(r7) == false) goto L47;
        r6.set(0, r5);
        if (this.u == false) goto L16;
        Logger.debug();
        if (y() == false) goto L14;
        r6.set(0, "");
        return a.EnumC0361a.f13654h;
    L14:
        return a.EnumC0361a.f13652f;
    L16:
        if (this.q.isEmpty() == false) goto L31;
        if (this.p.isEmpty() == false) goto L31;
        if (this.r.isEmpty() == false) goto L31;
        if (TextUtils.isEmpty(this.t) == true) goto L29;
        if (TextUtils.isEmpty(this.s) == true) goto L29;
        r6.set(0, r5.replaceAll(this.s, this.t));
        return a.EnumC0361a.f13653g;
    L29:
        return a.EnumC0361a.f13652f;
    L31:
        if (r7.getScheme() == null) goto L36;
        if (x(r7.getScheme(), this.p) == false) goto L36;
        r5 = r5.replaceFirst(r7.getScheme(), this.p);
    L36:
        if (r7.getHost() == null) goto L41;
        if (TextUtils.isEmpty(this.q) == true) goto L41;
        r5 = r5.replaceFirst(r7.getHost(), this.q);
    L41:
        if (r7.getPath() != null) goto L43;
    L45:
        r6.set(0, r5);
        return a.EnumC0361a.f13653g;
    L43:
        if (TextUtils.isEmpty(this.r) == true) goto L45;
        r5 = r5.replaceFirst(r7.getPath(), this.r);
        goto L45
    }

    @Override // d.b.h.a.a.h.o.b.z.k
    public int s() {
        return -1;
    }

    @Override // d.b.h.a.a.h.o.b.z.k
    public int t() {
        return this.v;
    }

    @Override // d.b.h.a.a.h.o.b.z.k
    protected boolean u(JSONObject r2, List<Boolean> r3, String r4, long r5) {
        k(r2);
        this.f13651l = r2.optString("service_name");
        this.p = r2.optString("scheme_replace");
        this.q = r2.optString("host_replace");
        this.r = r2.optString("path_replace");
        String r6 = r2.optString("replace");
        this.t = r6;
        if (TextUtils.isEmpty(r6) == true) goto L10;
        String r7 = r2.optString("regex");
        if (a.j(r7) == false) goto L7;
        this.s = r7;
        goto L10
    L7:
        this.x = true;
        return true;
    L10:
        if (r2.optInt("drop") != 1) goto L12;
        boolean r8 = true;
    L13:
        this.u = r8;
        int r9 = r2.optInt("drop_code", -1);
        if (r9 != (-555)) goto L16;
    L19:
        this.v = r9;
    L20:
        int r10 = r2.optInt("possibility", 100);
        if (r10 < 0) goto L25;
        if (r10 > 100) goto L25;
        this.w = r10;
    L25:
        if (this.f13641b.isEmpty() == false) goto L35;
        if (this.f13642c.isEmpty() == false) goto L35;
        if (this.f13643d.isEmpty() == false) goto L35;
        if (this.f13644e.isEmpty() == false) goto L35;
        if (this.f13645f.isEmpty() == false) goto L35;
    L44:
        this.x = true;
    L45:
        r3.set(0, Boolean.FALSE);
        return true;
    L35:
        if (this.u == true) goto L45;
        if (this.p.isEmpty() == false) goto L45;
        if (this.q.isEmpty() == false) goto L45;
        if (this.r.isEmpty() == false) goto L45;
        if (this.t.isEmpty() == false) goto L45;
    L16:
        if (r9 < (-5559)) goto L20;
        if (r9 > (-5551)) goto L20;
    L12:
        r8 = false;
        goto L13
    }
}
