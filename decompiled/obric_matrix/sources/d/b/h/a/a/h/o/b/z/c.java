package d.b.h.a.a.h.o.b.z;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    private int o;
    private int p;
    private int q;
    private final Map<String, Set<String>> r;

    static {
    }

    public c() {
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private a.EnumC0361a r(String r5, String r6, List<Integer> r7) {
        Uri r8 = Uri.parse(r5);
        if (r8.getHost() == null) goto L48;
        if (i(r8) == false) goto L48;
        if (this.r.isEmpty() == false) goto L12;
        r7.set(0, Integer.valueOf(s()));
        Logger.debug();
        return a.EnumC0361a.f13655i;
    L12:
        if (d.b.h.a.a.b.c() == true) goto L16;
        Logger.debug();
        return a.EnumC0361a.f13652f;
    L16:
        if ("".equals(r6) == false) goto L18;
        r6 = "s=0;p=0";
    L18:
        HashMap r9 = new HashMap();
        ArrayList r1 = new ArrayList();
        if (d.b.h.a.a.h.s.g.b(r6, ";", "=", r1) == false) goto L21;
        Iterator r10 = r1.iterator();
    L24:
        if (r10.hasNext() == false) goto L26;
        Pair r2 = (Pair) r10.next();
        r9.put((String) r2.first, (String) r2.second);
        goto L24
    L26:
        d.b.h.a.a.b.EnumC0353b r11 = d.b.h.a.a.b.EnumC0353b.f13218g;
        String r3 = Integer.toString(r11.a());
        if (d.b.h.a.a.b.a() == r11) goto L29;
        r3 = Integer.toString(d.b.h.a.a.b.b().a());
    L29:
        r9.put("s", r3);
        Context r12 = l.m().c();
        if (r12 == null) goto L32;
        boolean r13 = d.b.h.a.a.h.s.h.h(r12);
    L33:
        r9.put("p", Integer.toString(!r13));
        Logger.debug();
        a.EnumC0361a r14 = a.EnumC0361a.f13655i;
        Iterator<Map.Entry<String, Set<String>>> r4 = this.r.entrySet().iterator();
    L35:
        if (r4.hasNext() == false) goto L43;
        Map.Entry<String, Set<String>> r15 = r4.next();
        String r16 = (String) r9.get(r15.getKey());
        if (r16 == null) goto L38;
        if (r15.getValue().contains(r16) == true) goto L35;
    L38:
        r14 = a.EnumC0361a.f13652f;
    L43:
        if (r14 != a.EnumC0361a.f13655i) goto L45;
        r7.set(0, Integer.valueOf(s()));
    L45:
        Logger.debug();
        return r14;
    L32:
        r13 = 1;
        goto L33
    L21:
        return a.EnumC0361a.f13652f;
    L48:
        return a.EnumC0361a.f13652f;
    }

    private int s() {
        int r0 = this.o;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (this.p < this.q) goto L8;
        return 0;
    L8:
        return new Random().nextInt(this.q - this.p) + this.p;
    }

    @Override // d.b.h.a.a.h.o.b.z.a
    public boolean e(JSONObject r6, String r7, long r8) {
        k(r6);
        String r9 = r6.optString(LocationMonitorConst.TAG);
        int r10 = 0;
        if (TextUtils.isEmpty(r9) == true) goto L17;
        String[] r11 = r9.split(";");
        int r12 = r11.length;
        int r0 = 0;
    L5:
        if (r0 >= r12) goto L17;
        String r1 = r11[r0];
        ArrayList r2 = new ArrayList();
        if (d.b.h.a.a.h.s.g.b(r1, ",", "=", r2) == false) goto L16;
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Pair r4 = (Pair) r3.next();
        Set<String> r5 = this.r.get(r4.first);
        if (r5 != null) goto L15;
        r5 = new HashSet();
    L15:
        r5.add((String) r4.second);
        this.r.put((String) r4.first, r5);
    L16:
        r0 = r0 + 1;
    L17:
        this.o = r6.optInt("delay");
        JSONArray r13 = r6.optJSONArray("random");
        if (this.o > 0) goto L37;
        if (r13 == null) goto L37;
        if (r13.length() == 2) goto L42;
        return false;
    L42:
        int r14 = r13.getInt(0);     // Catch: JSONException -> L28
        int r15 = r13.getInt(1);     // Catch: JSONException -> L26
    L31:
        if (r14 <= 0) goto L36;
        if (r15 <= 0) goto L36;
        if (r14 >= r15) goto L36;
        r10 = r14;
    L38:
        this.p = r10;
        this.q = r15;
        Logger.debug();
        return true;
    L36:
        return false;
    L26:
        e = e;
    L30:
        e.printStackTrace();
        r15 = 0;
    L28:
        e = e;
        r14 = 0;
    L37:
        r15 = 0;
        goto L38
    }

    public a.EnumC0361a t(String r2, String r3, List<Integer> r4) {
        Logger.debug();
        if (g() == true) goto L5;
    L9:
        r4.set(0, 0);
        return a.EnumC0361a.f13652f;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        return r(r2, r3, r4);
    }
}
