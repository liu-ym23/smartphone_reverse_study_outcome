package com.bytedance.sync.v2.k;

import android.content.Context;
import android.util.Log;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.sync.v2.j.p;
import com.bytedance.sync.v2.presistence.d.f;
import d.b.u.e;
import d.b.u.g;
import d.b.u.k;
import d.b.u.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.a0;
import kotlin.b0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f6146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f6147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f6148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f6149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.b.u.b f6150e;

    /* JADX INFO: renamed from: com.bytedance.sync.v2.k.a$a, reason: collision with other inner class name */
    static final class RunnableC0195a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f6151f;

        RunnableC0195a(a r1) {
            this.f6151f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.b.u.x.b.e("sync upstream msg to server");
            if (a.c(this.f6151f).compareAndSet(true, false) == false) goto L5;
            a.a(this.f6151f);
        L5:
            a.b(this.f6151f);
        }
    }

    public a(Context r2, e r3, d.b.u.b r4) {
        o.g(r2, "context");
        o.g(r3, "configuration");
        o.g(r4, "businessMgr");
        this.f6148c = r2;
        this.f6149d = r3;
        this.f6150e = r4;
        this.f6146a = new AtomicBoolean(true);
        this.f6147b = new g();
    }

    public static final /* synthetic */ void a(a r0) {
        r0.d();
    }

    public static final /* synthetic */ void b(a r0) {
        r0.g();
    }

    public static final /* synthetic */ AtomicBoolean c(a r0) {
        return r0.f6146a;
    }

    private final void d() {
        f();
    }

    private final boolean e(com.bytedance.sync.v2.j.g r17, d.b.u.c0.a.d r18, com.bytedance.sync.v2.presistence.d.c r19) {
        com.bytedance.sync.v2.f.b r3 = (com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class);
    L47:
        e = move-exception;
        k.c().ensureNotReachHere(e, "execute sql failed when queryUploadMsgByDeviceInfo");
        e.printStackTrace();
        return false;
    L5:
        if (r17 != com.bytedance.sync.v2.j.g.f6091g) goto L7;
        String r1 = r18.f15019a;     // Catch: Exception -> L47
        o.b(r1, "deviceInfo.did");     // Catch: Exception -> L47
        List<f> r0 = r3.h(r17, r1, 100);     // Catch: Exception -> L47
    L9:
        if (r0 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
        return true;
    L17:
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r0.iterator();
        boolean r9 = false;
    L19:
        if (r8.hasNext() == false) goto L39;
        f r10 = (f) r8.next();
        Object[] r11 = this.f6150e.a(r10.f6262c).d();
        if (r11 == null) goto L35;
        int r12 = r11.length;
        int r13 = 0;
    L23:
        if (r13 >= r12) goto L35;
        Object r14 = r11[r13];
        if (r14 == null) goto L34;
        byte[] r15 = r10.f6267h;
        o.b(r15, "updateItem.data");
        if (((d.b.u.w.g) r14).a(r15) == true) goto L31;
        if (r9 == true) goto L31;
        r9 = false;
    L32:
        r13 = r13 + 1;
    L31:
        r9 = true;
        goto L32
    L34:
        throw new b0("null cannot be cast to non-null type com.bytedance.sync.interfaze.ISendInterceptor");
    L35:
        if (r9 == false) goto L37;
        r7.add(r10);
        goto L19
    L37:
        r6.add(r10);
        goto L19
    L39:
        Iterator r2 = r6.iterator();
    L41:
        if (r2.hasNext() == false) goto L43;
        f r4 = (f) r2.next();
        r4.f6261b = r19.f6229a;
        long r16 = r19.f6235g + 1;
        r19.f6235g = r16;
        r4.f6266g = r16;
        r4.f6265f = r19.f6233e;
        goto L41
    L43:
        boolean r20 = r3.Y(r0, r19, r7);
        if (r20 == false) goto L46;
        d.b.u.x.b.a("save distributed payload to db success");
    L46:
        return r20;
    L11:
        if (r0.isEmpty() == true) goto L14;
        r5 = false;
        goto L15
    L7:
        String r21 = r18.f15020b;     // Catch: Exception -> L47
        String r22 = r18.f15019a;     // Catch: Exception -> L47
        o.b(r22, "deviceInfo.did");     // Catch: Exception -> L47
        o.b(r21, "uid");     // Catch: Exception -> L47
        r0 = r3.g(r17, r22, r21, 100);     // Catch: Exception -> L47
        goto L9
    }

    private final void f() {
        ((com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class)).l();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        k.c().ensureNotReachHere(e, "execute sql failed when deleteMsgWhichBusinessNotExist");
        e.printStackTrace();
    }

    private final void g() {
        if (h() == false) goto L6;
        d.b.u.x.b.a("there is msg in dequeue, ignore this request");
        return;
    L6:
        com.ss.android.ug.bus.a r0 = com.ss.android.ug.bus.b.a(d.b.u.w.b.class);
        o.b(r0, "UgBusFramework.getServic…ceInfoGetter::class.java)");
        d.b.u.c0.a.d r1 = ((d.b.u.w.b) r0).e();
        com.bytedance.sync.v2.f.b r2 = (com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class);
        o.b(r1, "deviceInfo");     // Catch: Throwable -> L23
        List<com.bytedance.sync.v2.presistence.d.c> r3 = r2.v(r1);     // Catch: Throwable -> L23
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L23
        Iterator<T> r5 = r3.iterator();     // Catch: Throwable -> L23
    L9:
        if (r5.hasNext() == false) goto L16;
        Object r6 = r5.next();     // Catch: Throwable -> L23
        if (((com.bytedance.sync.v2.presistence.d.c) r6).f6232d != p.f6134g) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L9;
        r4.add(r6);     // Catch: Throwable -> L23
        goto L9
    L13:
        r7 = false;
        goto L14
    L16:
        ArrayList r8 = new ArrayList(r.q(r4, 10));     // Catch: Throwable -> L23
        Iterator r9 = r4.iterator();     // Catch: Throwable -> L23
    L18:
        if (r9.hasNext() == false) goto L20;
        com.bytedance.sync.v2.presistence.d.c r10 = (com.bytedance.sync.v2.presistence.d.c) r9.next();     // Catch: Throwable -> L23
        r8.add(a0.a(r10.f6233e, r10));     // Catch: Throwable -> L23
        goto L18
    L20:
        Map r11 = m0.q(r8);     // Catch: Throwable -> L23
        com.bytedance.sync.v2.j.g r12 = com.bytedance.sync.v2.j.g.f6091g;
        m(r12, r1, (com.bytedance.sync.v2.presistence.d.c) r11.get(r12));
        com.bytedance.sync.v2.j.g r13 = com.bytedance.sync.v2.j.g.f6092h;
        m(r13, r1, (com.bytedance.sync.v2.presistence.d.c) r11.get(r13));
        return;
    L23:
        th = move-exception;
        d.b.u.r.g(th, null, 2, null);
    }

    private final boolean h() {
        return ((com.bytedance.sync.v2.f.k) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.k.class)).c();
    }

    private final void i(boolean r11, List<f> r12, List<u<String, String>> r13) {
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L31
        Iterator<T> r14 = r12.iterator();     // Catch: Throwable -> L31
        int r3 = 0;
    L4:
        if (r14.hasNext() == false) goto L40;
        Object r4 = r14.next();     // Catch: Throwable -> L31
        int r5 = r3 + 1;     // Catch: Throwable -> L31
        if (r3 < 0) goto L28;
        f r6 = (f) r4;     // Catch: Throwable -> L31
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L31
        String r8 = "";
        if (r13 == null) goto L15;
        u<String, String> r9 = r13.get(r3);     // Catch: Throwable -> L31
        if (r9 == null) goto L15;
        String r10 = r9.c();     // Catch: Throwable -> L31
        if (r10 == null) goto L15;
    L16:
        d.b.u.d0.a.c(r7, "msg_id", r10);     // Catch: Throwable -> L31
        if (r13 == null) goto L23;
        u<String, String> r15 = r13.get(r3);     // Catch: Throwable -> L31
        if (r15 == null) goto L23;
        String r16 = r15.d();     // Catch: Throwable -> L31
        if (r16 == null) goto L23;
        r8 = r16;
    L23:
        d.b.u.d0.a.c(r7, "msg_req_id", r8);     // Catch: Throwable -> L31
        d.b.u.d0.a.a(r7, "business_id", (int) r6.f6262c);     // Catch: Throwable -> L31
        String r17 = this.f6149d.f15023a;     // Catch: Throwable -> L31
        o.b(r17, "configuration.aid");     // Catch: Throwable -> L31
        d.b.u.d0.a.a(r7, IBdInstall.PARAM_APP_ID, Integer.parseInt(r17));     // Catch: Throwable -> L31
        d.b.u.d0.a.c(r7, "device_platform", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L31
        String r18 = r6.f6261b;     // Catch: Throwable -> L31
        o.b(r18, "uploadItem.syncId");     // Catch: Throwable -> L31
        d.b.u.d0.a.b(r7, "sync_id", Long.parseLong(r18));     // Catch: Throwable -> L31
        d.b.u.d0.a.b(r7, "cursor", r6.f6266g);     // Catch: Throwable -> L31
        if (r11 == false) goto L26;
        int r19 = 1;
    L27:
        d.b.u.d0.a.a(r7, "channel", r19);     // Catch: Throwable -> L31
        d.b.u.d0.a.b(r7, "send_timestamp", r0);     // Catch: Throwable -> L31
        d.b.u.d0.a.c(r7, "params_for_special", "bytesync_sdk");     // Catch: Throwable -> L31
        q.a("sync_sdk_event_report", r7);     // Catch: Throwable -> L31
        r3 = r5;
        goto L4
    L26:
        r19 = 0;
    L15:
        r10 = "";
        goto L16
    L28:
        r.p();     // Catch: Throwable -> L31
        throw null;
    L40:
        return;
    L31:
        th = move-exception;
        d.b.u.x.b.b("onReportEvent error: " + Log.getStackTraceString(th));
    }

    private final void k(String r8, List<f> r9) {
        ArrayList r0 = new ArrayList();
        d.b.u.b0.b r1 = d.b.u.b0.b.g(this.f6148c);
        o.b(r1, "SyncSettings.inst(context)");
        d.b.u.b0.a r2 = r1.f();
        boolean r3 = false;
        int r4 = 0;
    L4:
        if ((!r9.isEmpty()) == false) goto L12;
        int r5 = r9.get(0).f6267h.length + r4;
        o.b(r2, "settings");
        if (r5 > r2.m()) goto L9;
        f r6 = r9.remove(0);
        r0.add(r6);
        r4 = r4 + r6.f6267h.length;
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L12;
        r0.add(r9.remove(0));
        r3 = true;
    L12:
        if ((!r0.isEmpty()) == false) goto L14;
        i(r3, r0, ((com.bytedance.sync.v2.f.k) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.k.class)).N(r8, r0, r3));
        return;
    L14:
        d.b.u.x.b.b("dataList is empty when send payload,maybe the first size too large or original data is empty");
    }

    private final void m(com.bytedance.sync.v2.j.g r4, d.b.u.c0.a.d r5, com.bytedance.sync.v2.presistence.d.c r6) {
        if (r6 == null) goto L25;
        com.bytedance.sync.v2.f.b r1 = (com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class);
        if (e(r4, r5, r6) == true) goto L23;
        d.b.u.x.b.b("save distributed payload to db failed");
        return;
    L23:
        String r7 = r6.f6229a;     // Catch: Exception -> L20
        o.b(r7, "syncCursor.syncId");     // Catch: Exception -> L20
        List<f> r8 = r1.n(r7, 100);     // Catch: Exception -> L20
        if (r8 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L18;
        d.b.u.x.b.e("local db is empty, not upload " + r4);
        return;
    L18:
        String r9 = r6.f6229a;
        o.b(r9, "syncCursor.syncId");
        k(r9, r8);
        return;
    L11:
        if (r8.isEmpty() == true) goto L14;
        r2 = false;
    L20:
        e = move-exception;
        k.c().ensureNotReachHere(e, "execute sql failed when queryDistributeMsgs");
        e.printStackTrace();
        return;
    }

    public final void j() {
        this.f6147b.b();
    }

    public final void l() {
        if (this.f6147b.a() == false) goto L6;
        d.b.u.x.b.e("there is upstream task in queue,throw current one");
        return;
    L6:
        this.f6147b.c(new RunnableC0195a(this));
    }
}
