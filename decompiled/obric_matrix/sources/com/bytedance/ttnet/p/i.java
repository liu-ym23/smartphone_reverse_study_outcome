package com.bytedance.ttnet.p;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.j.k;
import d.b.r.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i implements d.b.r.l0.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile i f6552e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f6553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, a> f6554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f6555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReadWriteLock f6556d;

    public static abstract class a implements d.b.r.l0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final e f6557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f6558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f6559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d.b.h.a.a.d.b f6560d;

        /* JADX INFO: renamed from: com.bytedance.ttnet.p.i$a$a, reason: collision with other inner class name */
        class C0201a extends d.b.h.a.a.d.b {
            C0201a(a r1, long r2, long r4) {
                super(r2, r4);
            }

            @Override // java.lang.Runnable
            public void run() {
                i.f().k("");
            }
        }

        public a() {
            this.f6557a = new e();
            this.f6558b = "";
            this.f6559c = 1000;
            this.f6560d = null;
        }

        @Override // d.b.r.l0.b
        public void c(d.b.r.h0.c r1) {
            this.f6557a.e(r1);
        }

        boolean e(JSONObject r3) {
            String r0 = r3.optString("state_name", "");
            this.f6558b = r0;
            if (TextUtils.isEmpty(r0) == false) goto L6;
            return false;
        L6:
            r3.optInt(WsConstants.KEY_CONNECTION_STATE, -1);
            int r1 = 1000;
            int r4 = r3.optInt("delay_disable_time_ms", 1000);
            this.f6559c = r4;
            if (r4 <= 0) goto L10;
            r1 = r4;
        L10:
            this.f6559c = r1;
            return true;
        }

        public void f() {
            C0201a r6 = new C0201a(this, this.f6559c, 0);
            this.f6560d = r6;
            if (r6 == null) goto L6;
            d.b.h.a.a.d.c.c(d.b.h.a.a.d.d.f13252f).d(this.f6560d);
            return;
        }

        void g() {
            if (this.f6560d == null) goto L6;
            d.b.h.a.a.d.c.c(d.b.h.a.a.d.d.f13252f).e(this.f6560d);
            return;
        }

        b h() {
            return b.f6565k;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f6561g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f6562h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f6563i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f6564j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f6565k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final /* synthetic */ b[] f6566l = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f6567f;

        static {
            b r0 = new b("DEFAULT", 0, 0);
            f6561g = r0;
            b r1 = new b("NORMAL_DELAY", 1, 1);
            f6562h = r1;
            b r3 = new b("RUNTIME_DELAY", 2, 2);
            f6563i = r3;
            b r5 = new b("PRIORITY", 3, 3);
            f6564j = r5;
            b r7 = new b("NOT_REACHED", 4, 4);
            f6565k = r7;
            f6566l = new b[]{r0, r1, r3, r5, r7};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6567f = r3;
        }

        public static b a(int r5) {
            b[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            b r3 = r0[r2];
            if (r3.b() == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            throw new IllegalArgumentException("Invalid value: " + r5);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f6566l.clone();
        }

        public int b() {
            return this.f6567f;
        }
    }

    static {
    }

    public i() {
        this.f6553a = new AtomicBoolean(false);
        this.f6554b = new ConcurrentHashMap();
        this.f6555c = new com.bytedance.ttnet.p.a();
        this.f6556d = new ReentrantReadWriteLock();
    }

    private boolean e(d.b.r.h0.c r1, y r2) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r1.A()) == true) goto L15;
        if (r2 != null) goto L8;
        return false;
    L8:
        if (r1.z() != null) goto L14;
        r1.S(r2);
        return true;
    L14:
        return true;
    L15:
        return false;
    }

    public static i f() {
        if (f6552e != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6552e != null) goto L9;
        f6552e = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f6552e;
    }

    public static Integer g(Map<String, Integer> r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        Iterator<String> r0 = r4.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r2 = r0.next();
        if (r5.startsWith(r2) == false) goto L7;
        return r4.get(r2);
    L12:
        return null;
    }

    public static Set<String> h(JSONObject r3, String r4) {
        CopyOnWriteArraySet r0 = new CopyOnWriteArraySet();
        if (r3 != null) goto L5;
        return r0;
    L5:
        JSONArray r5 = r3.optJSONArray(r4);
        if (r5 != null) goto L8;
        return r0;
    L8:
        int r6 = 0;
    L10:
        if (r6 >= r5.length()) goto L15;
        String r1 = r5.optString(r6);
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r0.add(r1);
    L14:
        r6 = r6 + 1;
        goto L10
    L15:
        return r0;
    }

    public static boolean i(Set<String> r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        if (r2 != null) goto L7;
        return false;
    L7:
        Iterator<String> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        if (r3.startsWith(r4.next()) == false) goto L9;
        return true;
    L14:
        return false;
    }

    private void l(a r2) {
        this.f6556d.writeLock().lock();
        this.f6555c.g();     // Catch: Throwable -> L9
        if (r2 != null) goto L6;
        r2 = new com.bytedance.ttnet.p.a();     // Catch: Throwable -> L9
    L6:
        this.f6555c = r2;     // Catch: Throwable -> L9
        r2.f();     // Catch: Throwable -> L9
        Logger.debug();     // Catch: Throwable -> L9
        this.f6556d.writeLock().unlock();
        return;
    L9:
        th = move-exception;
        this.f6556d.writeLock().unlock();
        throw th;
    }

    @Override // d.b.r.l0.b
    public void a(d.b.r.h0.c r3, y r4) {
        Logger.debug();
        if (this.f6553a.get() == true) goto L8;
        if (this.f6555c.h() == b.f6561g) goto L8;
        return;
    L8:
        if (e(r3, r4) == true) goto L10;
        return;
    L10:
        this.f6555c.a(r3, r4);
    }

    @Override // d.b.r.l0.b
    public boolean b(d.b.r.h0.c r4, y r5, Executor r6, Runnable r7) {
        Logger.debug();
        if (this.f6553a.get() == true) goto L8;
        if (this.f6555c.h() == b.f6561g) goto L8;
        return false;
    L8:
        if (e(r4, r5) == true) goto L11;
        return false;
    L11:
        return this.f6555c.b(r4, r5, r6, r7);
    }

    @Override // d.b.r.l0.b
    public void c(d.b.r.h0.c r2) {
        if (this.f6553a.get() == false) goto L8;
        if (r2 == null) goto L9;
        this.f6555c.c(r2);
        return;
    L9:
        return;
    }

    @Override // d.b.r.l0.b
    public d.b.r.h0.c d(d.b.r.h0.c r2) {
        if (this.f6553a.get() == false) goto L8;
        if (r2 == null) goto L8;
        return this.f6555c.d(r2);
    L8:
        return r2;
    }

    public void j(JSONObject r10) {
        int r1 = 0;
        this.f6553a.set(false);
        this.f6554b.clear();
        JSONArray r0 = r10.optJSONArray("tt_req_delay_config");
        if (r10.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r2 = true;
    L7:
        if (r10.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r11 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r11 == false) goto L14;
        boolean r12 = true;
    L16:
        if (r2 == false) goto L44;
        if (r0 == null) goto L44;
        if (r12 == false) goto L44;
        ConcurrentHashMap r13 = new ConcurrentHashMap();
    L22:
        if (r1 >= r0.length()) goto L42;
        JSONObject r3 = r0.optJSONObject(r1);
        String r5 = r3.optString("state_name", "");
        if (r3 == null) goto L41;
        if (TextUtils.isEmpty(r5) == true) goto L41;
        b r6 = b.a(r3.optInt(WsConstants.KEY_CONNECTION_TYPE, b.f6565k.b()));
        a r7 = null;
        if (r6 != b.f6562h) goto L32;
        r7 = new com.bytedance.ttnet.p.b();
    L37:
        if (r7 == null) goto L41;
        if (r7.e(r3) == false) goto L41;
        Logger.debug();
        r13.put(r5, r7);
        goto L41
    L32:
        if (r6 != b.f6563i) goto L35;
        r7 = new d();
        goto L37
    L35:
        if (r6 != b.f6564j) goto L37;
        r7 = new c();
    L41:
        r1 = r1 + 1;
        goto L22
    L42:
        Logger.debug();
        this.f6554b.putAll(r13);
        this.f6553a.set(true);
        return;
    L44:
        k("");
        return;
    L14:
        r12 = false;
        goto L16
    L9:
        r11 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    public void k(String r2) {
        l(this.f6554b.get(r2));
    }
}
