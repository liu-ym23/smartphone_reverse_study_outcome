package d.b.h.a.a.j;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Logger;
import d.b.h.a.a.h.s.k;
import d.b.h.a.a.h.s.l;
import d.b.r.k0.j;
import d.b.r.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile d f13782f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f13783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f13784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<c> f13785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f13786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13787e;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13788a = null;

        static {
            int[] r0 = new int[y.a.values().length];
            f13788a = r0;
            r0[y.a.f14629j.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f13788a[y.a.f14628i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f13788a[y.a.f14627h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    class b implements Comparator<c> {
        b(d r1) {
        }

        public int a(c r1, c r2) {
            return r1.d() - r2.d();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(c r1, c r2) {
            return a(r1, r2);
        }
    }

    private d() {
        this.f13784b = false;
        this.f13785c = new CopyOnWriteArrayList();
        this.f13786d = new CopyOnWriteArrayList();
        this.f13787e = true;
    }

    private static void a(List<d.b.r.h0.b> r4, y.a r5) {
        int r6 = a.f13788a[r5.ordinal()];
        if (r6 != 1) goto L5;
        r4.add(new d.b.r.h0.b("x-tt-cipher-version", "1.0.0"));
        d.b.r.h0.b r7 = new d.b.r.h0.b("x-tt-encrypt-info", "2");
    L12:
        r4.add(r7);
        return;
    L5:
        if (r6 != 2) goto L7;
        r4.add(new d.b.r.h0.b("x-tt-cipher-version", "1.0.0"));
        r7 = new d.b.r.h0.b("x-tt-encrypt-info", LocationInfoConst.ALLOW_USE_LOCATION);
        goto L12
    L7:
        if (r6 != 3) goto L14;
        r4.add(new d.b.r.h0.b("x-tt-cipher-version", "1.0.0"));
        r7 = new d.b.r.h0.b("x-tt-encrypt-info", BDLocationException.ERROR_TIMEOUT);
        goto L12
    }

    private JSONArray b(List<d.b.h.a.a.j.a> r10) {
        JSONArray r0 = new JSONArray();
        Iterator<d.b.h.a.a.j.a> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L20;
        d.b.h.a.a.j.a r1 = r11.next();
        long r2 = r1.b();     // Catch: JSONException -> L18
        if (this.f13787e == false) goto L13;
        if (r1.c() == true) goto L13;
        if (r2 <= 0) goto L4;
    L13:
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L18
        r4.put("hit", r1.c());     // Catch: JSONException -> L18
        r4.put("priority", r1.a());     // Catch: JSONException -> L18
        if (r2 <= 0) goto L16;
        r4.put("consume", r2);     // Catch: JSONException -> L18
    L16:
        r0.put(r4);     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L20:
        Logger.debug();
        return r0;
    }

    private boolean c(d.b.r.h0.c r5, Map<String, List<String>> r6) {
        ArrayList r0 = new ArrayList();
        boolean r1 = false;
        r5.U(0);
        Iterator<c> r2 = this.f13785c.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r2.next().n(r5, r6, r0) == false) goto L4;
        r1 = true;
        goto L4
    L8:
        Logger.debug();
        if (r5.z() == null) goto L11;
        y r7 = r5.z();
        r7.l0 = b(r0);
    L11:
        return r1;
    }

    public static d f() {
        if (f13782f != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13782f != null) goto L9;
        f13782f = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f13782f;
    }

    private void h(JSONObject r4, ArrayList<c> r5) {
        String r3 = r4.getString("action");
        int r0 = r4.getInt("act_priority");
        if (r0 >= 0) goto L5;
        return;
    L5:
        JSONObject r1 = r4.getJSONObject("param");
        int r6 = r4.optInt("set_req_priority", r0);
        if (r6 != (-1)) goto L8;
        r6 = Integer.MAX_VALUE;
    L8:
        c r7 = c.a(r3, r0, r6, r1);
        if (r7 == null) goto L12;
        r5.add(r7);
        return;
    }

    static void i(JSONArray r3, List<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r0 = 0;
    L14:
        if (r0 >= r3.length()) goto L21;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4.add(r1);     // Catch: JSONException -> L13
    L11:
        r0 = r0 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private synchronized void j(String r5) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.f13783a) == false) goto L6;
    L10:
        ArrayList<c> r0 = new ArrayList();     // Catch: Throwable -> L17
        JSONArray r1 = new JSONArray(r5);     // Catch: Throwable -> L17
        int r2 = 0;
    L12:
        if (r2 >= r1.length()) goto L14;
        h(r1.getJSONObject(r2), r0);     // Catch: Throwable -> L17
        r2 = r2 + 1;     // Catch: Throwable -> L17
        goto L12
    L14:
        Collections.sort(r0, new b(this));     // Catch: Throwable -> L17
        this.f13785c.clear();     // Catch: Throwable -> L17
        this.f13785c.addAll(r0);     // Catch: Throwable -> L17
        this.f13783a = r5;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L6:
        if (this.f13783a.equals(r5) == false) goto L10;
        Logger.debug();     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    private static void l(d.b.r.h0.c.a r7, d.b.r.h0.c r8, String r9) {
        if ((r8.s() instanceof d.b.r.k0.a) == false) goto L5;
        boolean r0 = ((d.b.r.k0.a) r8.s()).j();
    L7:
        if (r8.M() == false) goto L9;
    L12:
        ArrayList r1 = new ArrayList();
        if (TextUtils.isEmpty(r9) == true) goto L16;
        r1.add(new d.b.r.h0.b("x-tt-encrypt-queries", r9));
    L16:
        if (r8.v() == null) goto L18;
        r1.addAll(r8.v());
    L18:
        y r10 = r8.z();
        if (r0 == false) goto L21;
    L27:
        y.a r2 = y.a.f14626g;
        if (r0 == true) goto L30;
    L32:
        if (r0 == false) goto L36;
        r2 = y.a.f14628i;
    L34:
        a(r1, r2);
    L38:
        if (r10 == null) goto L40;
        r10.k(r2);
    L40:
        r7.b(r1);
        return;
    L36:
        if (r8.M() == false) goto L38;
        r2 = y.a.f14627h;
        goto L34
    L30:
        if (r8.M() == false) goto L32;
        r2 = y.a.f14629j;
        goto L34
    L21:
        if (r8.J() == false) goto L27;
        j r3 = r8.s();
        if ((r3 instanceof d.b.r.k0.a) == false) goto L27;
        long r4 = System.currentTimeMillis();
        r0 = ((d.b.r.k0.a) r3).i();
        if (r10 == null) goto L27;
        r10.h0 = System.currentTimeMillis() - r4;
        goto L27
    L9:
        if (r8.J() == true) goto L12;
        if (r0 == true) goto L12;
        return;
    L5:
        r0 = false;
        goto L7
    }

    public void d(boolean r1) {
        this.f13784b = r1;
    }

    public d.b.r.h0.c e(d.b.r.h0.c r8) {
        if (this.f13784b == true) goto L7;
        Logger.debug();
        return null;
    L7:
        if (r8.L() == false) goto L9;
        return null;
    L9:
        String r1 = r8.G();
        if (TextUtils.isEmpty(r1) == false) goto L50;
        return null;
    L50:
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L49
        Pair<String, String> r2 = l.k(r1, r3);     // Catch: Throwable -> L49
        if (r2 != null) goto L16;
        return null;
    L16:
        if (c(r8, r3) == true) goto L19;
        return null;
    L19:
        if (r8.M() == true) goto L21;
    L27:
        String r7 = null;
    L28:
        k r0 = new k(((String) r2.first) + ((String) r2.second));     // Catch: Throwable -> L49
        if (r3.isEmpty() == true) goto L47;
        Iterator<Map.Entry<String, List<String>>> r4 = r3.entrySet().iterator();     // Catch: Throwable -> L49
    L32:
        if (r4.hasNext() == false) goto L47;
        Map.Entry<String, List<String>> r5 = r4.next();     // Catch: Throwable -> L49
        if (r5 == null) goto L32;
        if (r5.getKey() == null) goto L32;
        List<String> r6 = r5.getValue();     // Catch: Throwable -> L49
        if (r6 == null) goto L32;
        if (r6.isEmpty() == true) goto L32;
        Iterator<String> r9 = r6.iterator();     // Catch: Throwable -> L49
    L45:
        if (r9.hasNext() == false) goto L32;
        r0.b(r5.getKey(), r9.next());     // Catch: Throwable -> L49
    L47:
        d.b.r.h0.c.a r10 = r8.O();     // Catch: Throwable -> L49
        l(r10, r8, r7);     // Catch: Throwable -> L49
        r10.h(r0.c());     // Catch: Throwable -> L49
        return r10.a();
    L21:
        if (r3.containsKey("x-tt-encrypt-queries") == false) goto L27;
        List<String> r11 = r3.get("x-tt-encrypt-queries");     // Catch: Throwable -> L49
        if (r11 == null) goto L27;
        if (r11.size() <= 0) goto L27;
        r7 = r11.get(0);     // Catch: Throwable -> L49
        r3.remove("x-tt-encrypt-queries");     // Catch: Throwable -> L49
    L49:
        return null;
    }

    public void g(String r2) {
        Logger.debug();
        if (this.f13784b == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        j(r2);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public void k(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        this.f13786d.clear();
        JSONArray r0 = new JSONArray(r4);     // Catch: JSONException -> L11
        int r5 = 0;
    L8:
        if (r5 >= r0.length()) goto L17;
        String r1 = r0.getString(r5);     // Catch: JSONException -> L11
        this.f13786d.add(r1);     // Catch: JSONException -> L11
        r5 = r5 + 1;
        goto L8
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
