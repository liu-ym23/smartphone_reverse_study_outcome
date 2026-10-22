package com.bytedance.ttnet.p;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f6539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f6540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f6541c;

    public g() {
        this.f6539a = new CopyOnWriteArraySet();
        this.f6540b = new CopyOnWriteArraySet();
        this.f6541c = new CopyOnWriteArraySet();
    }

    private boolean c(Set<String> r1, String r2, d.b.r.h0.c.a r3, int r4, int r5) {
        if (i.i(r1, r2) == false) goto L6;
        r3.e(r4);
        r3.f(r5);
        return true;
    L6:
        return false;
    }

    public void a(JSONObject r2) {
        this.f6539a = i.h(r2, "high");
        this.f6540b = i.h(r2, "normal");
        this.f6541c = i.h(r2, "low");
    }

    public d.b.r.h0.c b(d.b.r.h0.c r10) {
        d.b.r.h0.c.a r6 = r10.O();
        if (c(this.f6539a, r10.A(), r6, 3, 4) == false) goto L7;
        return r6.a();
    L7:
        if (c(this.f6541c, r10.A(), r6, -1, 1) == true) goto L9;
        int r0 = r10.B();
        if (r0 < 3) goto L14;
        r0 = 1;
    L14:
        if (r0 > (-1)) goto L16;
        r0 = 0;
    L16:
        int r4 = r0;
        int r1 = r10.E();
        if (r1 < 4) goto L19;
        r1 = 3;
    L19:
        if (r1 < 1) goto L22;
        r1 = 2;
    L22:
        if (c(this.f6540b, r10.A(), r6, r4, r1) == true) goto L24;
        r6.e(1);
        r6.f(3);
        return r6.a();
    L24:
        return r6.a();
    L9:
        return r6.a();
    }
}
