package com.bytedance.sync.v2.j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m implements com.bytedance.sync.v2.f.k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bytedance.sync.v2.f.g f6122f;

    public m() {
        com.ss.android.ug.bus.a r0 = com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.g.class);
        kotlin.n0.d.o.b(r0, "UgBusFramework.getService(IMsgSender::class.java)");
        this((com.bytedance.sync.v2.f.g) r0);
    }

    public m(com.bytedance.sync.v2.f.g r2) {
        kotlin.n0.d.o.g(r2, "mMsgSender");
        this.f6122f = r2;
    }

    @Override // com.bytedance.sync.v2.f.k
    public void G(boolean r8) {
        com.bytedance.sync.v2.f.b r0 = (com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class);
        d.b.u.w.b r1 = (d.b.u.w.b) com.ss.android.ug.bus.b.a(d.b.u.w.b.class);
        kotlin.n0.d.o.b(r1, "deviceInfoService");
        d.b.u.c0.a.d r2 = r1.e();
        kotlin.n0.d.o.b(r2, "deviceInfo");     // Catch: Throwable -> L18
        List<com.bytedance.sync.v2.presistence.d.c> r3 = r0.v(r2);     // Catch: Throwable -> L18
        com.ss.android.ug.bus.a r4 = com.ss.android.ug.bus.b.a(d.b.u.h.class);
        kotlin.n0.d.o.b(r4, "UgBusFramework.getServic…der::class.java\n        )");
        Map<String, String> r5 = ((d.b.u.h) r4).getCommonParams();
        HashMap r6 = new HashMap();
        if (r5 == null) goto L7;
        JSONObject r7 = new JSONObject(r5);
    L8:
        Integer r9 = Integer.valueOf(k.f6114g.getValue());
        k.h r10 = k.h.k(r7.toString());
        kotlin.n0.d.o.b(r10, "ByteString.encodeUtf8(params.toString())");
        r6.put(r9, r10);
        b.a r11 = new b.a();
        r11.g(q.f6142i);
        r11.c(r2.a());
        r11.f(r2.b());
        r11.e(Long.valueOf(System.currentTimeMillis()));
        r11.d(r6);
        b r12 = r11.a();
        ArrayList r13 = new ArrayList(r.q(r3, 10));
        Iterator<T> r14 = r3.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        com.bytedance.sync.v2.presistence.d.c r15 = (com.bytedance.sync.v2.presistence.d.c) r14.next();
        f.a r16 = new f.a();
        r16.d(j.f6111k);
        r16.k(r15.f6232d);
        r16.a(r15.f6233e);
        String r17 = r15.f6229a;
        kotlin.n0.d.o.b(r17, "it.syncId");
        r16.i(Long.valueOf(Long.parseLong(r17)));
        r16.g(Long.valueOf(r15.f6234f));
        r13.add(r16.b());
        goto L10
    L12:
        e.a r18 = new e.a();
        r18.b(r12);
        r18.c(r13);
        e r19 = r18.a();
        if (r8 == false) goto L15;
        com.bytedance.sync.v2.g.a r20 = new com.bytedance.sync.v2.g.a();
        r20.f5946b = false;
        r20.f5947c = true;
    L16:
        r20.f5945a = r19;
        this.f6122f.W(r20);
        return;
    L15:
        r20 = new com.bytedance.sync.v2.g.a();
        r20.f5946b = true;
        goto L16
    L7:
        r7 = new JSONObject();
    L18:
        th = move-exception;
        d.b.u.r.g(th, null, 2, null);
    }

    @Override // com.bytedance.sync.v2.f.k
    public List<u<String, String>> N(String r17, List<com.bytedance.sync.v2.presistence.d.f> r18, boolean r19) {
        kotlin.n0.d.o.g(r17, "syncId");
        kotlin.n0.d.o.g(r18, "dataList");
        if (r18.isEmpty() == false) goto L6;
        d.b.u.x.b.b("payload is null or empty when send to server,syncId = " + r17);
        return null;
    L6:
        long r3 = System.currentTimeMillis();
        d.b.u.w.b r5 = (d.b.u.w.b) com.ss.android.ug.bus.b.a(d.b.u.w.b.class);
        kotlin.n0.d.o.b(r5, "deviceInfoService");
        d.b.u.c0.a.d r6 = r5.e();
        com.ss.android.ug.bus.a r7 = com.ss.android.ug.bus.b.a(d.b.u.h.class);
        kotlin.n0.d.o.b(r7, "UgBusFramework.getServic…der::class.java\n        )");
        Map<String, String> r8 = ((d.b.u.h) r7).getCommonParams();
        HashMap r9 = new HashMap();
        if (r8 == null) goto L9;
        JSONObject r10 = new JSONObject(r8);
    L10:
        Integer r11 = Integer.valueOf(k.f6114g.getValue());
        k.h r12 = k.h.k(r10.toString());
        kotlin.n0.d.o.b(r12, "ByteString.encodeUtf8(params.toString())");
        r9.put(r11, r12);
        b.a r13 = new b.a();
        r13.g(q.f6142i);
        r13.c(r6.a());
        r13.f(r6.b());
        r13.e(Long.valueOf(r3));
        r13.d(r9);
        b r14 = r13.a();
        ArrayList r15 = new ArrayList();
        f.a r16 = new f.a();
        r16.d(j.f6109i);
        r16.k(p.f6134g);
        r16.i(Long.valueOf(Long.parseLong(r17)));
        ArrayList r0 = new ArrayList(r.q(r18, 10));
        Iterator<T> r1 = r18.iterator();
    L12:
        if (r1.hasNext() == false) goto L18;
        com.bytedance.sync.v2.presistence.d.f r20 = (com.bytedance.sync.v2.presistence.d.f) r1.next();
        String r110 = UUID.randomUUID().toString();
        kotlin.n0.d.o.b(r110, "UUID.randomUUID().toString()");
        String r111 = r20.f6269j;
        if (r111 != null) goto L17;
        r111 = r20.f6263d + r20.f6261b + r20.f6266g;
    L17:
        r15.add(a0.a(r111, r110));
        c.a r112 = new c.a();
        a.C0193a r113 = new a.C0193a();
        r113.b(Long.valueOf(r20.f6266g));
        r112.b(r113.a());
        d.a r114 = new d.a();
        r114.b(Integer.valueOf((int) r20.f6262c));
        byte[] r21 = r20.f6267h;
        r114.d(k.h.v(r21, 0, r21.length));
        r112.d(r114.a());
        r112.f(Long.valueOf(r3));
        r112.c(m0.k(new u[]{a0.a("msg_id", r111), a0.a("msg_req_id", r110)}));
        r0.add(r112.a());
        goto L12
    L18:
        r16.f(r.z0(r0));
        f r2 = r16.b();
        e.a r4 = new e.a();
        r4.b(r14);
        r4.c(r.e(new f[]{r2}));
        e r22 = r4.a();
        com.bytedance.sync.v2.g.a r23 = new com.bytedance.sync.v2.g.a();
        r23.f5946b = !r19;
        r23.f5945a = r22;
        r23.f5947c = r19;
        this.f6122f.W(r23);
        return r15;
    L9:
        r10 = new JSONObject();
        goto L10
    }

    @Override // com.bytedance.sync.v2.f.k
    public void P() {
        d.b.u.w.b r0 = (d.b.u.w.b) com.ss.android.ug.bus.b.a(d.b.u.w.b.class);
        kotlin.n0.d.o.b(r0, "deviceInfoService");
        d.b.u.c0.a.d r1 = r0.e();
        com.ss.android.ug.bus.a r2 = com.ss.android.ug.bus.b.a(d.b.u.h.class);
        kotlin.n0.d.o.b(r2, "UgBusFramework.getServic…aramProvider::class.java)");
        Map<String, String> r3 = ((d.b.u.h) r2).getCommonParams();
        HashMap r4 = new HashMap();
        if (r3 == null) goto L5;
        JSONObject r5 = new JSONObject(r3);
    L6:
        Integer r6 = Integer.valueOf(k.f6114g.getValue());
        k.h r7 = k.h.k(r5.toString());
        kotlin.n0.d.o.b(r7, "ByteString.encodeUtf8(params.toString())");
        r4.put(r6, r7);
        b.a r8 = new b.a();
        r8.g(q.f6142i);
        r8.c(r1.a());
        r8.f(r1.b());
        r8.e(Long.valueOf(System.currentTimeMillis()));
        r8.d(r4);
        b r9 = r8.a();
        f.a r10 = new f.a();
        j r11 = j.f6110j;
        r10.d(r11);
        r10.k(p.f6134g);
        f r12 = r10.b();
        f.a r13 = new f.a();
        r13.d(r11);
        r13.k(p.f6135h);
        f r14 = r13.b();
        f.a r15 = new f.a();
        r15.d(r11);
        r15.k(p.f6136i);
        f r16 = r15.b();
        e.a r17 = new e.a();
        r17.b(r9);
        r17.c(r.j(new f[]{r12, r14, r16}));
        e r18 = r17.a();
        com.bytedance.sync.v2.g.a r19 = new com.bytedance.sync.v2.g.a();
        r19.f5946b = true;
        r19.f5945a = r18;
        this.f6122f.W(r19);
        return;
    L5:
        r5 = new JSONObject();
        goto L6
    }

    @Override // com.bytedance.sync.v2.f.k
    public boolean c() {
        return this.f6122f.c();
    }
}
