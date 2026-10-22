package com.bytedance.ttnet.p;

import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.throttle.TTNetThrottle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f6542j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Integer> f6543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f6544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f6545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f6546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f6547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f6549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f6550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f6551i;

    static {
        f6542j = new String[0];
    }

    public h() {
        this.f6543a = new ConcurrentHashMap();
        this.f6544b = new CopyOnWriteArraySet();
        this.f6545c = new CopyOnWriteArraySet();
        this.f6546d = new CopyOnWriteArraySet();
        this.f6547e = new CopyOnWriteArraySet();
        this.f6548f = -1;
        this.f6549g = -1;
        this.f6550h = -1;
        this.f6551i = -1;
    }

    public void a() {
        Logger.debug();
        if (this.f6544b.size() <= 0) goto L8;
        if (this.f6548f <= 0) goto L8;
        TTNetThrottle.start((String[]) this.f6544b.toArray(f6542j), 1, this.f6548f);
    L8:
        if (this.f6545c.size() <= 0) goto L13;
        if (this.f6549g <= 0) goto L13;
        TTNetThrottle.start((String[]) this.f6545c.toArray(f6542j), 2, this.f6549g);
    L13:
        if (this.f6546d.size() <= 0) goto L18;
        if (this.f6550h <= 0) goto L18;
        TTNetThrottle.start((String[]) this.f6546d.toArray(f6542j), 4, this.f6550h);
    L18:
        if (this.f6547e.size() > 0) goto L20;
        return;
    L20:
        if (this.f6551i <= 0) goto L24;
        TTNetThrottle.start((String[]) this.f6547e.toArray(f6542j), 8, this.f6551i);
        return;
    }

    public void b() {
        Set<String> r0 = this.f6544b;
        String[] r1 = f6542j;
        TTNetThrottle.stop((String[]) r0.toArray(r1), 1);
        TTNetThrottle.stop((String[]) this.f6545c.toArray(r1), 2);
        TTNetThrottle.stop((String[]) this.f6546d.toArray(r1), 4);
        TTNetThrottle.stop((String[]) this.f6547e.toArray(r1), 8);
    }

    public boolean c(JSONObject r7) {
        b();
        this.f6543a.clear();
        JSONObject r8 = r7.optJSONObject("throttle");
        if (r8 != null) goto L6;
        return false;
    L6:
        JSONObject r0 = r8.optJSONObject("request_throttle");
        if (r0 == null) goto L12;
        Iterator<String> r1 = r0.keys();
    L10:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        this.f6543a.put(r2, Integer.valueOf(r0.optInt(r2)));
    L12:
        JSONObject r9 = r8.optJSONObject("connection_throttle");
        if (r9 == null) goto L29;
        JSONObject r3 = r9.optJSONObject("normal_up");
        if (r3 == null) goto L17;
        this.f6544b = i.h(r3, "hosts");
        this.f6548f = r3.optInt("speed", -1);
    L17:
        JSONObject r4 = r9.optJSONObject("normal_down");
        if (r4 == null) goto L20;
        this.f6545c = i.h(r4, "hosts");
        this.f6549g = r4.optInt("speed", -1);
    L20:
        JSONObject r5 = r9.optJSONObject("ws_up");
        if (r5 == null) goto L23;
        this.f6546d = i.h(r5, "hosts");
        this.f6550h = r5.optInt("speed", -1);
    L23:
        JSONObject r10 = r9.optJSONObject("ws_down");
        if (r10 == null) goto L30;
        this.f6547e = i.h(r10, "hosts");
        this.f6551i = r10.optInt("speed", -1);
        return true;
    L30:
        return true;
    L29:
        return true;
    }

    public d.b.r.h0.c d(d.b.r.h0.c r5) {
        Integer r4 = i.g(this.f6543a, r5.A());
        if (r4 != null) goto L5;
        return r5;
    L5:
        d.b.r.h0.c.a r0 = r5.O();
        Object r6 = r5.t();
        if (r6 != null) goto L9;
        r6 = new com.bytedance.ttnet.m.d();
        r0.g(r6);
    L9:
        if ((r6 instanceof d.b.h.a.a.h.c) == false) goto L11;
        long r2 = r4.longValue();
        ((d.b.h.a.a.h.c) r6).t = r2;
    L11:
        r0.g(r6);
        return r0.a();
    }
}
