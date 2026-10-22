package sj;

import ai.p0;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager$AppStartState;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.ttnet.TTNetInit;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements p0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static j f21928l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f21931c;
    public String d;
    public boolean e;
    public boolean f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CopyOnWriteArraySet f21932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap f21933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f21934j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f21935k;

    public j(Context r5, boolean r10) {
        this.f21931c = new ConcurrentHashMap();
        this.d = "";
        this.e = false;
        this.f = false;
        this.g = 100;
        this.f21932h = new CopyOnWriteArraySet();
        this.f21933i = new ConcurrentHashMap();
        this.f21934j = new ConcurrentHashMap();
        this.f21935k = new AtomicInteger(0);
        this.f21929a = r5.getApplicationContext();
        this.f21930b = r10;
    }

    public static j b(Context r5) {
        monitor-enter(j.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f21928l != null) goto L19;
        boolean r10 = com.bytedance.frameworks.baselib.network.http.util.b.b(r5);     // Catch: Throwable -> L9
        f21928l = new j(r5, r10);     // Catch: Throwable -> L9
        r5.getPackageName();     // Catch: Throwable -> L9
        if (r10 == false) goto L11;
        SsHttpCall.setThrottleControl(f21928l);     // Catch: Throwable -> L9
        goto L19
    L11:
        IntentFilter r11 = new IntentFilter();     // Catch: Throwable -> L9
        r11.addAction("com.bytedance.ttnet.config.appconfig.SYNC_APP_DELAY_CONFIG_ACTION");     // Catch: Throwable -> L9
        r5.registerReceiver(new com.lynx.tasm.base.e(2), r11, null, null);     // Catch: Throwable -> L15
    L17:
        k.m();     // Catch: Throwable -> L9
        throw null;     // Catch: Throwable -> L9
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L9
    L19:
        j r12 = f21928l;     // Catch: Throwable -> L9
        monitor-exit(j.class);     // Catch: Throwable -> L9
        return r12;
    }

    @Override // ai.p0
    public final boolean a() {
        return this.e;
    }

    @Override // ai.p0
    public final int c(String r5, String r10) {
        return x9.b.b().a(r5, r10);
    }

    @Override // ai.p0
    public final boolean d() {
        return !x9.b.b().f22999b.isEmpty();
    }

    @Override // ai.p0
    public final int e(String r5) {
        boolean r10 = this.f;
        int r11 = 0;
        if (r10 == false) goto L17;
        ConcurrentHashMap r12 = this.f21933i;
        if (r12 == null) goto L17;
        Iterator r13 = r12.keySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L21;
        String r14 = (String) r13.next();
        if (TextUtils.isEmpty(r14) == true) goto L8;
        if (r5.startsWith(r14) == false) goto L8;
        Integer r15 = (Integer) this.f21933i.get(r14);
        if (r15 == null) goto L21;
        r11 = r15.intValue();
    L21:
        if (r11 <= 0) goto L23;
        this.f21935k.incrementAndGet();
        this.f21934j.put(r5, Integer.valueOf(r11));
    L23:
        return r11;
    L17:
        if (r10 == true) goto L21;
        if (com.lynx.tasm.behavior.utils.d.m(r5, this.f21932h) == false) goto L21;
        r11 = this.g;
        goto L21
    }

    public final void f(JSONObject r12) {
        JSONArray r13 = r12.optJSONArray("tt_req_delay_config");
        ConcurrentHashMap r11 = this.f21931c;
        if (r13 != null) goto L6;
        r11.clear();
        return;
    L6:
        int r5 = 0;
    L8:
        if (r5 >= r13.length()) goto L44;
        h r10 = new h();
        r10.f21925a = new ConcurrentHashMap();
        r10.f21926b = new CopyOnWriteArraySet();
        r10.f21927c = 100;
        JSONObject r14 = r13.optJSONObject(r5);
        if (r14 == null) goto L43;
        int r15 = r14.optInt("state", -2);
        if (r15 != (-1)) goto L15;
        TTAppStateManager$AppStartState r16 = TTAppStateManager$AppStartState.NormalStart;
    L27:
        if (r14.isNull("bl_with_delay_ms") == true) goto L34;
        JSONObject r17 = r14.optJSONObject("bl_with_delay_ms");
        Iterator<String> r18 = r17.keys();
    L30:
        if (r18.hasNext() == false) goto L32;
        String r19 = r18.next();
        r10.f21925a.put(r19, Integer.valueOf(r17.optInt(r19)));
        goto L30
    L32:
        r14.optInt("bl_disable_time_ms", 1000);
    L42:
        r11.put(r16, r10);
        goto L43
    L34:
        if (r14.isNull("wl") == true) goto L42;
        JSONArray r20 = r14.optJSONArray("wl");
        if (r20 == null) goto L41;
        int r21 = 0;
    L39:
        if (r21 >= r20.length()) goto L41;
        r10.f21926b.add((String) r20.opt(r21));
        r21 = r21 + 1;
    L41:
        r10.f21927c = r14.optInt("delay_time_ms", 100);
        r14.optInt("wl_disable_time_ms", 1000);
        goto L42
    L15:
        if (r15 != 0) goto L18;
        r16 = TTAppStateManager$AppStartState.ColdStart;
        goto L27
    L18:
        if (r15 != 1) goto L21;
        r16 = TTAppStateManager$AppStartState.HotStart;
        goto L27
    L21:
        if (r15 != 2) goto L24;
        r16 = TTAppStateManager$AppStartState.WarmStart;
        goto L27
    L24:
        if (r15 != 3) goto L43;
        r16 = TTAppStateManager$AppStartState.WeakNet;
    L43:
        r5 = r5 + 1;
        goto L8
    }

    public final void g() {
        LinkedHashMap r5 = new LinkedHashMap();
        if (this.e == false) goto L5;
        r5.put("app_delay_enable", 1);
    L7:
        if (this.f == false) goto L9;
        r5.put("app_delay_use_black_list", 1);
    L10:
        r5.put("app_delay_whitelist_delay_time", Integer.valueOf(this.g));
        String[] r10 = (String[]) this.f21932h.toArray(new String[0]);
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L14;
        r11.append(r10[r13]);
        r11.append(",");
        r13 = r13 + 1;
        goto L11
    L14:
        if (r10.length <= 0) goto L16;
        r5.put("app_delay_white_list", r11.substring(0, r11.length() - 1));
    L17:
        r5.put("app_delay_black_list", new JSONObject(this.f21933i).toString());
        TTNetInit.getTTNetDepend();
        throw null;
    L16:
        r5.put("app_delay_white_list", "");
        goto L17
    L9:
        r5.put("app_delay_use_black_list", 0);
        goto L10
    L5:
        r5.put("app_delay_enable", 0);
        goto L7
    }
}
