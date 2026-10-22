package com.bytedance.applog.t;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.applog.o.e;
import com.bytedance.applog.util.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f2375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, C0073a> f2376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Set<String> f2377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f2378i;

    /* JADX INFO: renamed from: com.bytedance.applog.t.a$a, reason: collision with other inner class name */
    static class C0073a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f2380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        JSONObject f2381c;

        public String toString() {
            return "ProfileDataWrapper{timeStamp=" + this.f2379a + ", apiName='" + this.f2380b + "', jsonObject=" + this.f2381c + '}';
        }
    }

    public a(e r2) {
        this.f2378i = "";
        this.f2375f = r2;
        HandlerThread r3 = new HandlerThread("bd_tracker_profile");
        r3.start();
        new Handler(r3.getLooper(), this);
        this.f2376g = new HashMap();
        this.f2377h = new HashSet();
    }

    private void a(C0073a r1) {
        f(r1);
    }

    private void b(C0073a r1) {
        f(r1);
    }

    private void c(C0073a r13) {
        String r0 = this.f2378i;
        if (r0 == null) goto L5;
        boolean r1 = r0.equals(com.bytedance.applog.a.v());
    L6:
        this.f2378i = com.bytedance.applog.a.v();
        Iterator<String> r2 = r13.f2381c.keys();
        boolean r4 = false;
        boolean r5 = true;
    L8:
        if (r2.hasNext() == false) goto L21;
        String r6 = r2.next();
        if (this.f2376g.containsKey(r6) == true) goto L12;
    L19:
        r5 = false;
        r4 = true;
    L20:
        this.f2376g.put(r6, r13);
        goto L8
    L12:
        if (this.f2376g.get(r6) == null) goto L19;
        C0073a r7 = this.f2376g.get(r6);
        if ((System.currentTimeMillis() - r7.f2379a) < 60000) goto L27;
        r4 = true;
    L27:
        if (i.e(r13.f2381c, r7.f2381c, null) == true) goto L20;
        r5 = false;
        goto L20
    L21:
        if (r1 == false) goto L24;
        if (r4 == true) goto L24;
        if (r5 == false) goto L24;
        return;
    L24:
        f(r13);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void d(C0073a r7) {
        String r0 = this.f2378i;
        if (r0 == null) goto L5;
        boolean r1 = r0.equals(com.bytedance.applog.a.v());
    L6:
        this.f2378i = com.bytedance.applog.a.v();
        Iterator<String> r2 = r7.f2381c.keys();
        boolean r3 = true;
    L8:
        if (r2.hasNext() == false) goto L13;
        String r4 = r2.next();
        if (this.f2377h.contains(r4) == true) goto L12;
        r3 = false;
    L12:
        this.f2377h.add(r4);
        goto L8
    L13:
        if (r1 == false) goto L15;
        if (r3 == false) goto L15;
        return;
    L15:
        f(r7);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void e(C0073a r1) {
        f(r1);
    }

    public void f(C0073a r3) {
        com.bytedance.applog.a.F("__profile_" + r3.f2380b, r3.f2381c);
        e r2 = this.f2375f;
        if (r2 == null) goto L6;
        r2.J();
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        switch(r2.what) {
            case 100: goto L9;
            case 101: goto L16;
            case 102: goto L8;
            case 103: goto L7;
            case 104: goto L6;
            case 105: goto L5;
            default: goto L16;
        };
    L5:
        a((C0073a) r2.obj);
        return true;
    L6:
        e((C0073a) r2.obj);
        return true;
    L7:
        b((C0073a) r2.obj);
        return true;
    L8:
        d((C0073a) r2.obj);
        return true;
    L9:
        c((C0073a) r2.obj);
        return true;
    L16:
        return true;
    }
}
