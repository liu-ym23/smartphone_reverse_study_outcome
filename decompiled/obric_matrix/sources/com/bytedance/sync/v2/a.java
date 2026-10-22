package com.bytedance.sync.v2;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.j;
import com.bytedance.sync.v2.j.g;
import com.bytedance.sync.v2.j.p;
import d.b.u.e;
import d.b.u.k;
import d.b.u.n;
import d.b.u.w.i;
import d.b.u.w.m;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.b0;
import kotlin.h;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Handler.Callback {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final /* synthetic */ l[] f5856j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f5857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h f5858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e f5859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d.b.u.b f5860i;

    /* JADX INFO: renamed from: com.bytedance.sync.v2.a$a, reason: collision with other inner class name */
    static final class RunnableC0188a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f5861f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sync.v2.presistence.d.e f5862g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i.a f5863h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f5864i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Object[] f5865j;

        RunnableC0188a(a r1, com.bytedance.sync.v2.presistence.d.e r2, i.a r3, int r4, Object[] r5) {
            this.f5861f = r1;
            this.f5862g = r2;
            this.f5863h = r3;
            this.f5864i = r4;
            this.f5865j = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.sync.v2.presistence.d.e r0 = this.f5862g;
            if (r0 != null) goto L6;
            d.b.u.x.b.b("asyncNotify syncLog is null !!!");
            return;
        L6:
            a.c(this.f5861f, r0.f6254g, this.f5863h, this.f5864i);
            a.b(this.f5861f, this.f5862g);
            d.b.u.x.b.e("notify ->>>>>> business=" + this.f5862g.f6254g + ", data=" + this.f5863h + " to " + this.f5865j);
            a.a(this.f5861f, this.f5865j, this.f5863h, this.f5862g.f6254g);
        }
    }

    static final class b extends q implements kotlin.n0.c.a<d.b.u.w.c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f5866f = null;

        static {
            f5866f = new b();
        }

        b() {
            super(0);
        }

        public final d.b.u.w.c a() {
            return (d.b.u.w.c) com.ss.android.ug.bus.b.a(d.b.u.w.c.class);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ d.b.u.w.c invoke() {
            return a();
        }
    }

    static final class c extends q implements kotlin.n0.c.a<Handler> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f5867f;

        c(a r1) {
            this.f5867f = r1;
            super(0);
        }

        public final Handler a() {
            return new Handler(((d.b.u.w.e) com.ss.android.ug.bus.b.a(d.b.u.w.e.class)).get(), this.f5867f);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Handler invoke() {
            return a();
        }
    }

    static {
        f5856j = new l[]{e0.g(new y(e0.b(a.class), "mFileDataCache", "getMFileDataCache()Lcom/bytedance/sync/interfaze/IFileDataCacheService;")), e0.g(new y(e0.b(a.class), "mHandler", "getMHandler()Landroid/os/Handler;"))};
    }

    public a(e r2, d.b.u.b r3) {
        o.g(r2, "configuration");
        o.g(r3, "mBusinessManager");
        this.f5859h = r2;
        this.f5860i = r3;
        this.f5857f = kotlin.i.b(b.f5866f);
        this.f5858g = kotlin.i.b(new c(this));
    }

    public static final /* synthetic */ void a(a r0, Object[] r1, i.a r2, long r3) {
        r0.e(r1, r2, r3);
    }

    public static final /* synthetic */ void b(a r0, com.bytedance.sync.v2.presistence.d.e r1) {
        r0.q(r1);
    }

    public static final /* synthetic */ void c(a r0, long r1, i.a r3, int r4) {
        r0.r(r1, r3, r4);
    }

    private final void d(ExecutorService r8, Object[] r9, i.a r10, com.bytedance.sync.v2.presistence.d.e r11, int r12) {
        r8.submit(new RunnableC0188a(this, r11, r10, r12, r9));
    }

    private final void e(Object[] r8, i.a r9, long r10) {
        d.b.u.x.b.e("notify ->>>>>> business=" + r10 + ", data=" + r9 + " to " + r8);
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        Object r2 = r8[r1];
        if (r2 == null) goto L10;
        ((m) r2).a(r9);     // Catch: Exception -> L7
    L14:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        e.printStackTrace();
        if (this.f5859h.f15033k == true) goto L16;
        k.c().ensureNotReachHere(e, "crash when dispatch to business " + r10 + ", listener = " + r2);
        goto L14
    L16:
        throw new RuntimeException(e);
    L10:
        throw new b0("null cannot be cast to non-null type com.bytedance.sync.interfaze.OnDataUpdateListener");     // Catch: Exception -> L7
    }

    private final int g(long r23, List<? extends com.bytedance.sync.v2.presistence.d.e> r25) {
        ExecutorService r8 = com.bytedance.sync.v2.l.b.a();     // Catch: Exception -> L46
        n r3 = this.f5860i.a(r23);
        if (r3 != null) goto L8;
        d.b.u.x.b.e("business not register,ignore it. business = " + r23);
        return -1;
    L8:
        Object[] r9 = r3.c();
        boolean r10 = true;
        if (r9 != null) goto L11;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L21;
        d.b.u.x.b.a("listener is empty ,ignore it. business = " + r23);
        return -1;
    L21:
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r25.iterator();
    L23:
        if (r13.hasNext() == false) goto L41;
        com.bytedance.sync.v2.presistence.d.e r14 = (com.bytedance.sync.v2.presistence.d.e) r13.next();
        i.a r5 = new i.a();
        if (r14.f6256i != d.b.u.y.a.f15125h) goto L31;
        d.b.u.w.c r1 = k();
        String r2 = r14.f6248a;
        o.b(r2, "it.syncId");
        long r6 = Long.parseLong(r2);
        byte[] r7 = r14.f6252e;
        o.b(r7, "it.data");
        byte[] r11 = r1.Q(r6, new String(r7, kotlin.u0.d.f21429a));
        if (r11 == null) goto L28;
        r5.f15120a = r11;
    L32:
        String r15 = r14.f6249b;
        String r16 = r14.f6250c;
        r5.f15121b = r14.f6258k;
        long r17 = r14.f6257j;
        r5.f15122c = r14.f6251d;
        String r18 = r14.m;
        if (r18 == null) goto L38;
        List r19 = kotlin.u0.k.m0(r18, new char[]{':'}, false, 0, 6, null);
        if (r19 == null) goto L38;
        String r20 = (String) r.b0(r19);
    L38:
        if (t(r14) == false) goto L40;
        d(r8, r9, r5, r14, 1);
        r12.add(r14);
        goto L23
    L40:
        d.b.u.x.b.b("delete syncLog failed, not notify, syncId = " + r14.f6248a + ", cursor = " + r14.f6251d);
    L29:
        r10 = false;
        goto L41
    L28:
        String r21 = r14.f6248a;
        o.b(r21, "it.syncId");
        s(Long.parseLong(r21), "deserialization failed when submit syncLog");
        goto L29
    L31:
        r5.f15120a = r14.f6252e;
    L41:
        if (r10 == true) goto L43;
        return -1;
    L43:
        return r12.size();
    L11:
        if (r9.length != 0) goto L13;
        boolean r22 = true;
    L14:
        if (r22 == true) goto L17;
        r4 = false;
        goto L18
    L13:
        r22 = false;
    L46:
        e = move-exception;
        e.printStackTrace();
        k.c().ensureNotReachHere(e, null);
        return -1;
    }

    private final void h(long r13, int r15) {
        List<com.bytedance.sync.v2.presistence.d.e> r16 = ((com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class)).u(r13, 50, r15);
        boolean r0 = false;
        if (r16 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        d.b.u.x.b.e("submit one by one finished, business = " + r13);
        return;
    L13:
        int r4 = g(r13, r16);
        if (r4 >= 0) goto L17;
        return;
    L17:
        if (r16.size() < 50) goto L19;
        r0 = true;
    L19:
        if (r0 == false) goto L21;
        d.b.u.x.b.e("continue one by one, business = " + r13);
        v(this, r13, r16.size() - r4, 0, 4, null);
        return;
    L21:
        d.b.u.x.b.e("submit one by one finished, business = " + r13);
        return;
    L5:
        if (r16.isEmpty() == true) goto L8;
        r3 = false;
        goto L10
    }

    private final void i(com.bytedance.sync.v2.presistence.d.e r19) {
        d.b.u.x.b.e("doNotifySnapshots");
        com.bytedance.sync.v2.f.b r8 = (com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class);
        ArrayList r9 = new ArrayList();
        ExecutorService r10 = com.bytedance.sync.v2.l.b.a();     // Catch: Exception -> L66
        boolean r0 = true;
        int r1 = 0;
    L5:
        if (r0 == false) goto L83;
        List<com.bytedance.sync.v2.presistence.d.b> r2 = r8.f(50, r1);     // Catch: Exception -> L63
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L15;
        int r13 = r1 + r2.size();
        if (r2.size() < 50) goto L19;
        boolean r14 = true;
    L20:
        com.ss.android.ug.bus.a r4 = com.ss.android.ug.bus.b.a(d.b.u.w.b.class);
        o.b(r4, "UgBusFramework.getServic…ceInfoGetter::class.java)");
        d.b.u.c0.a.d r15 = ((d.b.u.w.b) r4).e();
        o.b(r15, "UgBusFramework.getServic…r::class.java).deviceInfo");
        d.b.u.w.c r6 = (d.b.u.w.c) com.ss.android.ug.bus.b.a(d.b.u.w.c.class);
        Iterator<T> r16 = r2.iterator();
    L22:
        if (r16.hasNext() == false) goto L62;
        com.bytedance.sync.v2.presistence.d.b r5 = (com.bytedance.sync.v2.presistence.d.b) r16.next();
        n r7 = this.f5860i.a(r5.f6218b);
        if (r7 != null) goto L27;
        d.b.u.x.b.a("business not register,ignore submit snapshot. business = " + r5.f6218b);
    L26:
        int r17 = r13;
    L61:
        r6 = r6;
        r13 = r17;
        goto L22
    L27:
        Object[] r11 = r7.c();
        if (r11 != null) goto L30;
    L36:
        boolean r12 = true;
    L37:
        if (r12 == false) goto L41;
        StringBuilder r18 = new StringBuilder();
        r18.append("listener is null ,not notify.snapshot = ");
        r18.append(r5);
        r18.append(" business = ");
        r18.append(r5.f6218b);
    L39:
        d.b.u.x.b.b(r18.toString());
        goto L26
    L41:
        if (TextUtils.equals(r5.f6220d, r15.f15019a) == true) goto L45;
        r18 = new StringBuilder();
        r18.append("did is error ,not notify. did = ");
        r18.append(r5.f6220d);
        r18.append(", current = ");
        String r20 = r15.f15019a;
    L43:
        r18.append(r20);
        goto L39
    L45:
        if (r5.f6224h == g.f6092h) goto L47;
    L49:
        i.a r21 = new i.a();
        if (r5.f6225i != d.b.u.y.a.f15125h) goto L55;
        String r22 = r5.f6217a;
        o.b(r22, "it.syncId");
        long r110 = Long.parseLong(r22);
        byte[] r23 = r5.f6222f;
        o.b(r23, "it.data");
        r17 = r13;
        Charset r111 = kotlin.u0.d.f21429a;
        String r24 = r6.A(r110, new String(r23, r111));
        if (r24 != null) goto L54;
        String r25 = r5.f6217a;
        o.b(r25, "it.syncId");
        s(Long.parseLong(r25), "deserialization failed when submit snapshots");
        goto L61
    L54:
        byte[] r26 = r24.getBytes(r111);
        o.b(r26, "(this as java.lang.String).getBytes(charset)");
        r21.f15120a = r26;
    L56:
        String r27 = r5.f6220d;
        String r28 = r5.f6219c;
        long r29 = r5.f6226j;
        r21.f15121b = r5.f6227k;
        long r30 = r5.f6221e;
        r21.f15122c = r30;
        r5.f6223g = r30;
        int r112 = r5.m;
        r5.m = 0;
        r8.d(r5);     // Catch: Exception -> L59
        r9.add(r5);     // Catch: Exception -> L59
        d(r10, r11, r21, r19, r112);
    L59:
        e = move-exception;
        e.printStackTrace();
        k.c().ensureNotReachHere(e, "execute sql failed when changeSnapshotToNotified.");
        goto L61
    L55:
        r17 = r13;
        r21.f15120a = r5.f6222f;
        goto L56
    L47:
        if (d.b.u.d0.b.b(r5.f6219c, r15.f15020b) == true) goto L49;
        r18 = new StringBuilder();
        r18.append("uid is error ,not notify. uid = ");
        r18.append(r5.f6219c);
        r18.append(", current = ");
        r20 = r15.f15020b;
        goto L43
    L30:
        if (r11.length != 0) goto L32;
        boolean r31 = true;
    L33:
        if (r31 == true) goto L36;
        r12 = false;
        goto L37
    L32:
        r31 = false;
        goto L33
    L62:
        r0 = r14;
        r1 = r13;
        goto L5
    L19:
        r14 = false;
        goto L20
    L15:
        d.b.u.x.b.c("snapshots is null ,not notify");
        return;
    L10:
        if (r2.isEmpty() == true) goto L13;
        r3 = false;
    L63:
        e = move-exception;
        e.printStackTrace();
        k.c().ensureNotReachHere(e, "execute sql failed. notifySnapshots .");
        return;
    L83:
        return;
    L66:
        e = move-exception;
        e.printStackTrace();
        k.c().ensureNotReachHere(e, null);
    }

    static /* synthetic */ void j(a r0, com.bytedance.sync.v2.presistence.d.e r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.i(r1);
    }

    private final d.b.u.w.c k() {
        h r2 = this.f5857f;
        l r0 = f5856j[0];
        return (d.b.u.w.c) r2.getValue();
    }

    private final Handler l() {
        h r2 = this.f5858g;
        l r0 = f5856j[1];
        return (Handler) r2.getValue();
    }

    public static /* synthetic */ void p(a r0, com.bytedance.sync.v2.presistence.d.e r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.o(r1, r2);
    }

    private final void q(com.bytedance.sync.v2.presistence.d.e r13) {
        if (r13 != null) goto L38;
        return;
    L38:
        Map<String, String> r4 = r13.p;     // Catch: Throwable -> L35
        if (r4 != null) goto L8;
        return;
    L8:
        if ((!o.a(r4.get("hit_sampling"), LocationInfoConst.ALLOW_USE_LOCATION)) == true) goto L40;
        String r5 = r4.get("realtime");     // Catch: Throwable -> L35
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L35
        String r7 = r13.p.get("msg_id");     // Catch: Throwable -> L35
        String r8 = "";
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        d.b.u.d0.a.c(r6, "msg_id", r7);     // Catch: Throwable -> L35
        String r2 = r13.p.get("msg_req_id");     // Catch: Throwable -> L35
        if (r2 == null) goto L18;
        r8 = r2;
    L18:
        d.b.u.d0.a.c(r6, "msg_req_id", r8);     // Catch: Throwable -> L35
        d.b.u.d0.a.a(r6, "business_id", (int) r13.f6254g);     // Catch: Throwable -> L35
        String r12 = this.f5859h.f15023a;     // Catch: Throwable -> L35
        o.b(r12, "configuration.aid");     // Catch: Throwable -> L35
        d.b.u.d0.a.a(r6, IBdInstall.PARAM_APP_ID, Integer.parseInt(r12));     // Catch: Throwable -> L35
        d.b.u.d0.a.c(r6, "device_platform", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L35
        p r1 = r13.n;     // Catch: Throwable -> L35
        o.b(r1, "syncLog.topicType");     // Catch: Throwable -> L35
        d.b.u.d0.a.a(r6, "topic_type", r1.getValue());     // Catch: Throwable -> L35
        String r9 = r13.m;     // Catch: Throwable -> L35
        if (r9 == null) goto L23;
        List r3 = kotlin.u0.k.n0(r9, new String[]{":"}, false, 0, 6, null);     // Catch: Throwable -> L35
        if (r3 == null) goto L23;
        String r10 = (String) r.b0(r3);     // Catch: Throwable -> L35
    L24:
        d.b.u.d0.a.c(r6, "topic", r10);     // Catch: Throwable -> L35
        String r11 = r13.f6248a;     // Catch: Throwable -> L35
        o.b(r11, "syncLog.syncId");     // Catch: Throwable -> L35
        d.b.u.d0.a.b(r6, "sync_id", Long.parseLong(r11));     // Catch: Throwable -> L35
        d.b.u.d0.a.b(r6, "cursor", r13.f6251d);     // Catch: Throwable -> L35
        String r14 = r13.p.get("channel");     // Catch: Throwable -> L35
        if (r14 == null) goto L27;
        int r15 = Integer.parseInt(r14);     // Catch: Throwable -> L35
    L28:
        d.b.u.d0.a.a(r6, "channel", r15);     // Catch: Throwable -> L35
        com.bytedance.sync.v2.j.h r0 = r13.f6255h;     // Catch: Throwable -> L35
        o.b(r0, "syncLog.consumeType");     // Catch: Throwable -> L35
        d.b.u.d0.a.a(r6, "consumer_type", r0.getValue());     // Catch: Throwable -> L35
        d.b.u.d0.a.b(r6, "send_timestamp", r13.f6257j);     // Catch: Throwable -> L35
        d.b.u.d0.a.b(r6, "receive_timestamp", r13.f6258k);     // Catch: Throwable -> L35
        d.b.u.d0.a.b(r6, TypedValues.TransitionType.S_DURATION, r13.f6258k - r13.f6257j);     // Catch: Throwable -> L35
        if (r5 != null) goto L32;
        r5 = BDLocationException.ERROR_TIMEOUT;
    L32:
        d.b.u.d0.a.c(r6, "realtime", r5);     // Catch: Throwable -> L35
        d.b.u.d0.a.c(r6, "params_for_special", "bytesync_sdk");     // Catch: Throwable -> L35
        d.b.u.q.a("sync_sdk_event_submit", r6);     // Catch: Throwable -> L35
        return;
    L27:
        r15 = -1;
    L23:
        r10 = null;
        goto L24
    L40:
        return;
    L35:
        th = move-exception;
        d.b.u.x.b.b("onEventSubmit error: " + Log.getStackTraceString(th));
    }

    private final void r(long r9, i.a r11, int r12) {
        JSONObject r8 = new JSONObject();
        d.b.u.d0.a.b(r8, "business", r9);
        d.b.u.d0.a.b(r8, "cursor", r11.f15122c);
        byte[] r1 = r11.f15120a;
        o.b(r1, "data.data");
        d.b.u.d0.a.c(r8, "data_md5", j.a(new String(r1, kotlin.u0.d.f21429a), "MD5"));
        d.b.u.q.a("sync_sdk_submit", r8);
        JSONObject r4 = new JSONObject();
        r4.put("time_consuming", System.currentTimeMillis() - r11.f15121b);
        r4.put("submit_cnt", r12);
        JSONObject r3 = new JSONObject();
        r3.put("business", r9);
        d.b.u.r.d("sync_sdk_submit_data", r3, r4, null, 8, null);
    }

    private final void s(long r2, String r4) {
        d.b.u.x.b.b("something is wrong when notify. syncId = " + r2 + ", errMsg = " + r4);
    }

    private final boolean t(com.bytedance.sync.v2.presistence.d.e r4) {
        boolean r0 = ((com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class)).i0(r.e(new com.bytedance.sync.v2.presistence.d.e[]{r4}));
        if (r0 == true) goto L5;
    L7:
        return r0;
    L5:
        if (r4.f6256i != d.b.u.y.a.f15125h) goto L7;
        d.b.u.w.c r3 = k();
        byte[] r5 = r4.f6252e;
        o.b(r5, "obj.data");
        r3.S(new String(r5, kotlin.u0.d.f21429a));
        goto L7
    }

    private final void u(long r4, int r6, long r7) {
        l().removeMessages(103, Long.valueOf(r4));
        Message r5 = l().obtainMessage(103, Long.valueOf(r4));
        r5.arg1 = r6;
        l().sendMessageDelayed(r5, r7);
    }

    static /* synthetic */ void v(a r6, long r7, int r9, long r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r9 = 0;
    L5:
        int r3 = r9;
        if ((r12 & 4) == 0) goto L8;
        r10 = 0;
    L8:
        r6.u(r7, r3, r10);
    }

    public final void f(long r9) {
        n(50);
        u(r9, 0, 50);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r6) {
        o.g(r6, NotificationCompat.CATEGORY_MESSAGE);
        if (r6.what != 102) goto L6;
        l().removeMessages(102);
        j(this, null, 1, null);
    L6:
        if (r6.what != 104) goto L23;
        Object r0 = r6.obj;
        if (r0 == null) goto L21;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = ((List) r0).iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        Long r4 = Long.valueOf(((com.bytedance.sync.v2.presistence.d.e) r3).f6254g);
        Object r5 = r1.get(r4);
        if (r5 != null) goto L15;
        r5 = new ArrayList();
        r1.put(r4, r5);
    L15:
        ((List) r5).add(r3);
        goto L11
    L16:
        Iterator r7 = r1.entrySet().iterator();
    L18:
        if (r7.hasNext() == false) goto L23;
        Map.Entry r8 = (Map.Entry) r7.next();
        g(((Number) r8.getKey()).longValue(), (List) r8.getValue());
        goto L18
    L21:
        throw new b0("null cannot be cast to non-null type kotlin.collections.List<com.bytedance.sync.v2.presistence.table.SyncLog>");
    L23:
        if (r6.what != 103) goto L29;
        Object r9 = r6.obj;
        if (r9 == null) goto L28;
        long r10 = ((Long) r9).longValue();
        int r11 = r6.arg1;
        l().removeMessages(103, Long.valueOf(r10));
        h(r10, r11);
        return false;
    L28:
        throw new b0("null cannot be cast to non-null type kotlin.Long");
    L29:
        return false;
    }

    public final void m(List<? extends com.bytedance.sync.v2.presistence.d.e> r2) {
        o.g(r2, "syncLog");
        l().obtainMessage(104, r2).sendToTarget();
    }

    public final void n(long r3) {
        l().removeMessages(102);
        Message r0 = l().obtainMessage(102);
        l().sendMessageDelayed(r0, r3);
    }

    public final void o(com.bytedance.sync.v2.presistence.d.e r1, long r2) {
        i(r1);
    }
}
