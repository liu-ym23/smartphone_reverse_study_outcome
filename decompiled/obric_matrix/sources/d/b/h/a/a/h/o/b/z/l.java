package d.b.h.a.a.h.o.b.z;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private static volatile l m;
    private static AtomicBoolean n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f13679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f13680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicLong f13681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<k> f13682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ReentrantReadWriteLock f13683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<c> f13684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ReentrantReadWriteLock f13685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicInteger f13686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicLong f13687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ConcurrentMap<String, String> f13688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f13689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f13690l;

    static class a implements Comparator<d.b.h.a.a.h.o.b.z.a> {
        a() {
        }

        public int a(d.b.h.a.a.h.o.b.z.a r1, d.b.h.a.a.h.o.b.z.a r2) {
            return r1.b() - r2.b();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(d.b.h.a.a.h.o.b.z.a r1, d.b.h.a.a.h.o.b.z.a r2) {
            return a(r1, r2);
        }
    }

    static {
        n = new AtomicBoolean(false);
    }

    public l() {
        this.f13679a = null;
        this.f13680b = new AtomicBoolean(true);
        this.f13681c = new AtomicLong(0);
        this.f13682d = new ArrayList();
        this.f13683e = new ReentrantReadWriteLock();
        this.f13684f = new ArrayList();
        this.f13685g = new ReentrantReadWriteLock();
        this.f13686h = new AtomicInteger(0);
        this.f13687i = new AtomicLong(0);
        this.f13688j = new ConcurrentHashMap();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private e b(m r11) {
        String r0 = r11.d();
        e r1 = new e();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        r3.add(0, r0);
        this.f13683e.readLock().lock();
        Iterator<k> r5 = this.f13682d.iterator();
        String r6 = r0;
    L4:
        if (r5.hasNext() == false) goto L9;
        k r7 = r5.next();
        Logger.debug();
        d.b.h.a.a.h.o.b.z.a.EnumC0361a r8 = r7.w(r11, r6, r3, r2);
        String r9 = (String) r3.get(0);
        if (r8 == d.b.h.a.a.h.o.b.z.a.EnumC0361a.f13654h) goto L7;
        r6 = r9;
        goto L4
    L7:
        Logger.debug();
        r1.f13667d = r7.t();
    L9:
        String r12 = (String) r3.get(0);
        this.f13683e.readLock().unlock();
        ArrayList r10 = new ArrayList();
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L19
        r4.put("origin_url", r0);     // Catch: JSONException -> L19
        r4.put("dispatched_url", r12);     // Catch: JSONException -> L19
        JSONArray r13 = new JSONArray();     // Catch: JSONException -> L19
        Iterator r14 = r2.iterator();     // Catch: JSONException -> L19
    L12:
        if (r14.hasNext() == false) goto L17;
        d r15 = (d) r14.next();     // Catch: JSONException -> L19
        if (r15.f13660d == false) goto L12;
        JSONObject r16 = new JSONObject();     // Catch: JSONException -> L19
        r10.add(Long.valueOf(r15.f13658b));     // Catch: JSONException -> L19
        r16.put("rule_id", r15.f13658b);     // Catch: JSONException -> L19
        r16.put("service_name", r15.f13657a);     // Catch: JSONException -> L19
        r16.put("priority", r15.f13659c);     // Catch: JSONException -> L19
        r13.put(r16);     // Catch: JSONException -> L19
        goto L12
    L17:
        r4.put("action_info_list", r13);     // Catch: JSONException -> L19
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L19
        r17.put("dispatch", r4);     // Catch: JSONException -> L19
        new JSONObject().put("dispatchersdk", r17);     // Catch: JSONException -> L19
    L21:
        r1.f13665b = r10;
        r1.f13664a = r12;
        r1.f13666c = r2;
        return r1;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    public static l m() {
        if (m != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (m != null) goto L9;
        m = new l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return m;
    }

    private void q(JSONObject r20) {
        String r3 = r20.optString("action");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        int r5 = r20.optInt("act_priority", -1);
        if (r5 >= 0) goto L8;
        return;
    L8:
        JSONObject r4 = r20.optJSONObject("param");
        if (r4 != null) goto L11;
        return;
    L11:
        String r2 = r20.optString("lifecycle");
        int r7 = 0;
        long r8 = 0;
        long r10 = -1;
        if ("".equals(r2) == false) goto L14;
        r10 = 0;
    L20:
        long r12 = r20.optInt("rule_id");
        String r6 = r20.optString("sign");
        ArrayList r15 = new ArrayList();
        JSONArray r9 = r20.optJSONArray("request_method");
        if (r9 != null) goto L23;
    L28:
        long r11 = r8;
        long r13 = r10;
        d.b.h.a.a.h.o.b.z.a r1 = d.b.h.a.a.h.o.b.z.a.a(r3, r4, r5, r11, r13, r12, r6, this.f13681c.get(), r15, r20.optInt("set_req_priority", r5));
        if ((r1 instanceof k) == false) goto L35;
        this.f13682d.add((k) r1);
        return;
    L35:
        return;
    L23:
        if (r7 >= r9.length()) goto L28;
        String r14 = r9.optString(r7);
        if (TextUtils.isEmpty(r14) == true) goto L27;
        r15.add(r14);
    L27:
        r7 = r7 + 1;
        goto L23
    L14:
        ArrayList r16 = new ArrayList();
        if (d.b.h.a.a.h.s.g.c(r2, r16) == true) goto L17;
    L19:
        r8 = -1;
        goto L20
    L17:
        if (r16.size() != 2) goto L19;
        r8 = ((Long) r16.get(0)).longValue();
        r10 = ((Long) r16.get(1)).longValue();
        goto L20
    }

    private void r(JSONObject r19) {
        int r6 = r19.optInt("act_priority", -1);
        if (r6 >= 0) goto L5;
        return;
    L5:
        JSONObject r5 = r19.optJSONObject("param");
        if (r5 != null) goto L8;
        return;
    L8:
        String r1 = r19.optString("lifecycle");
        long r7 = -1;
        if ("".equals(r1) == false) goto L11;
        r7 = 0;
    L16:
        long r9 = r7;
    L17:
        d.b.h.a.a.h.o.b.z.a r2 = d.b.h.a.a.h.o.b.z.a.a("delay", r5, r6, r7, r9, 0, "", this.f13681c.get(), null, 0);
        if ((r2 instanceof c) == false) goto L21;
        this.f13684f.add((c) r2);
        return;
    L21:
        return;
    L11:
        ArrayList r3 = new ArrayList();
        if (d.b.h.a.a.h.s.g.c(r1, r3) != true) goto L16;
        if (r3.size() != 2) goto L16;
        r7 = ((Long) r3.get(0)).longValue();
        r9 = ((Long) r3.get(1)).longValue();
        goto L17
    }

    public Context c() {
        return this.f13679a;
    }

    public int d(String r6, String r7) {
        Logger.debug();
        if (d.b.h.a.a.h.s.l.f(r6) == true) goto L6;
        Logger.debug();
        return 0;
    L6:
        this.f13685g.readLock().lock();
        ArrayList r0 = new ArrayList();
        r0.add(0, 0);
        Iterator<c> r2 = this.f13684f.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        c r3 = r2.next();
        Logger.debug();
        if (r3.t(r6, r7, r0) != d.b.h.a.a.h.o.b.z.a.EnumC0361a.f13655i) goto L8;
        Logger.debug();
    L12:
        this.f13685g.readLock().unlock();
        return ((Integer) r0.get(0)).intValue();
    }

    public e e(m r3) {
        Logger.debug();
        if (d.b.h.a.a.h.s.l.f(r3.d()) == true) goto L7;
        Logger.debug();
        return null;
    L7:
        if (this.f13680b.get() == true) goto L11;
        Logger.debug();
        return null;
    L11:
        return b(r3);
    }

    public long f() {
        return this.f13681c.get();
    }

    public ConcurrentMap<String, String> g() {
        return this.f13688j;
    }

    public String h() {
        return this.f13690l;
    }

    public String i() {
        return this.f13689k;
    }

    public int j() {
        return this.f13686h.get();
    }

    public long k() {
        return this.f13687i.get();
    }

    public String l(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L39:
        return r5;
    L5:
        if (r5.contains("/network/get_network") == true) goto L39;
        if (r5.contains("/get_domains/v5") == true) goto L39;
        if (r5.contains("/ies/speed") == true) goto L39;
        String r0 = null;
        URL r1 = new URL(r5);     // Catch: Throwable -> L15
        String r2 = r1.getProtocol();     // Catch: Throwable -> L15
        r0 = r1.getHost();     // Catch: Throwable -> L40
    L17:
        if (TextUtils.isEmpty(r2) == true) goto L39;
        if ("http".equals(r2) == true) goto L23;
        if (LocationInfoConst.HTTPS.equals(r2) == false) goto L39;
    L23:
        if (TextUtils.isEmpty(r0) == true) goto L39;
        ConcurrentMap<String, String> r3 = this.f13688j;
        if (r3 != null) goto L28;
    L38:
        Logger.debug();
        goto L39
    L28:
        if (r3.containsKey(r0) == false) goto L38;
        String r4 = this.f13688j.get(r0);
        if (TextUtils.isEmpty(r4) == false) goto L33;
        return r5;
    L33:
        Logger.debug();
        String r6 = r2 + "://" + r0;
        String r7 = r2 + "://" + r4;
        if (r5.startsWith(r6) == false) goto L36;
        r5 = r5.replaceFirst(r6, r7);
    L36:
        Logger.debug();
        return r5;
    L15:
        r2 = null;
        goto L17
    }

    public boolean n() {
        return this.f13682d.isEmpty();
    }

    public void o(Context r11) {
        if (d.b.h.a.a.h.s.h.h(r11) == true) goto L5;
        return;
    L5:
        if (n.get() == true) goto L23;
        SharedPreferences r10 = a(r11, "ttnet_tnc_config", 0);
        boolean r12 = r10.getBoolean("is_full_config", false);
        String r0 = r10.getString("tnc_config_str", null);
        String r6 = r10.getString("ttnet_tnc_etag", null);
        String r7 = r10.getString("ttnet_tnc_abtest", null);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        n.set(true);
        return;
    L8:
        if (TextUtils.isEmpty(r0) == true) goto L18;
        JSONObject r13 = new JSONObject(r0);     // Catch: JSONException -> L16
        if (r12 == false) goto L14;
        JSONObject r14 = r13.optJSONObject("data");     // Catch: JSONException -> L16
        if (r14 == null) goto L14;
        r13 = r14;
    L14:
        l r3 = m();     // Catch: JSONException -> L16
        r3.p(r13, 0, r6, r7, System.currentTimeMillis());     // Catch: JSONException -> L16
        goto L18
    }

    public void p(JSONObject r2, int r3, String r4, String r5, long r6) {
        Logger.debug();
        this.f13686h.set(r3);
        this.f13689k = r4;
        this.f13690l = r5;
        this.f13687i.set(r6);
        int r7 = r2.optInt("ignore_retrofit_slash_enabled_v2", -1);
        int r8 = 0;
        boolean r9 = true;
        if (r7 < (-1)) goto L8;
        if (r7 != 1) goto L6;
        boolean r10 = true;
    L7:
        p000j.l0.a.r(r10);
        goto L8
    L6:
        r10 = false;
    L8:
        JSONArray r11 = r2.optJSONArray("request_delay_actions");
        this.f13685g.writeLock().lock();     // Catch: Throwable -> L50
        this.f13684f.clear();     // Catch: Throwable -> L50
        if (r11 == null) goto L19;
        int r12 = 0;
    L13:
        if (r12 >= r11.length()) goto L19;
        JSONObject r0 = r11.optJSONObject(r12);     // Catch: Throwable -> L50
        if (r0 == null) goto L17;
        r(r0);     // Catch: Throwable -> L50
    L17:
        r12 = r12 + 1;     // Catch: Throwable -> L50
    L19:
        if (this.f13684f.isEmpty() == true) goto L21;
        Collections.sort(this.f13684f, new a());     // Catch: Throwable -> L50
    L21:
        this.f13685g.writeLock().unlock();
        Logger.debug();
        int r13 = r2.optInt("ttnet_url_dispatcher_enabled", -1);
        if (r13 < 0) goto L28;
        AtomicBoolean r14 = this.f13680b;
        if (r13 == 1) goto L27;
        r9 = false;
    L27:
        r14.set(r9);
    L28:
        long r15 = r2.optInt("ttnet_dispatch_actions_epoch", -1);
        if (r15 != this.f13681c.get()) goto L32;
        Logger.debug();
        return;
    L32:
        this.f13681c.set(r15);
        JSONArray r16 = r2.optJSONArray("ttnet_dispatch_actions");
        if (r16 != null) goto L55;
        return;
    L55:
        this.f13683e.writeLock().lock();     // Catch: Throwable -> L47
        this.f13682d.clear();     // Catch: Throwable -> L47
    L37:
        if (r8 >= r16.length()) goto L43;
        JSONObject r17 = r16.optJSONObject(r8);     // Catch: Throwable -> L47
        if (r17 == null) goto L41;
        q(r17);     // Catch: Throwable -> L47
    L41:
        r8 = r8 + 1;     // Catch: Throwable -> L47
        goto L37
    L43:
        if (this.f13682d.isEmpty() == true) goto L45;
        Collections.sort(this.f13682d, new a());     // Catch: Throwable -> L47
    L45:
        this.f13683e.writeLock().unlock();
        Logger.debug();
        return;
    L47:
        th = move-exception;
        this.f13683e.writeLock().unlock();
        Logger.debug();
        throw th;
    L50:
        th = move-exception;
        this.f13685g.writeLock().unlock();
        Logger.debug();
        throw th;
    }

    public void s(Context r1) {
        this.f13679a = r1;
    }

    public void t(String r1) {
        this.f13690l = r1;
    }
}
