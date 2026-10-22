package com.bytedance.applog.p;

import android.content.Context;
import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.o.h;
import com.bytedance.applog.u.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.u.b f2303a;

    public e(com.bytedance.applog.u.b r1) {
        this.f2303a = r1;
    }

    private i b() {
        i r5 = new i(com.bytedance.applog.a.h(), com.bytedance.applog.a.k(), com.bytedance.applog.a.w());
        IBDAccountCallback r0 = com.bytedance.applog.a.i();
        if (r0 == null) goto L11;
        Pair<Integer, Long> r1 = r0.getOdinUserInfo();
        if (((Long) r1.second).longValue() <= 0) goto L9;
        r5.f(String.valueOf(r1.second));
        String r2 = String.valueOf(r1.first);
    L7:
        r5.g(r2);
    L12:
        return r5;
    L9:
        if (h.q != 0) goto L12;
        r5.f(String.valueOf(h.o));
        r2 = String.valueOf(h.o);
        goto L7
    L11:
        r5.f(String.valueOf(h.n));
        goto L12
    }

    public static e e(Context r2) {
        return new e(com.bytedance.applog.u.c.d(r2, "sampling_list"));
    }

    public static e f(Context r2, JSONObject r3, e r4) {
        return new e(com.bytedance.applog.u.c.c(r2, "sampling_list", r3, r4.c()));
    }

    @Override // com.bytedance.applog.p.d
    public boolean a(com.bytedance.applog.r.b.a r2, String r3, String r4) {
        if (com.bytedance.applog.r.b.a.f2332h.equals(r2) == false) goto L5;
    L8:
        boolean r1 = this.f2303a.c(b(), r3, r4);
        if (r1 == false) goto L11;
        com.bytedance.applog.o.b.d(r2, com.bytedance.applog.r.b.d.f2350k);
        com.bytedance.applog.o.b.i(com.bytedance.applog.r.b.a.y, r3);
    L11:
        return r1;
    L5:
        if (com.bytedance.applog.r.b.a.f2333i.equals(r2) == true) goto L8;
        return false;
    }

    public com.bytedance.applog.u.b c() {
        return this.f2303a;
    }

    public int d() {
        return this.f2303a.b();
    }
}
