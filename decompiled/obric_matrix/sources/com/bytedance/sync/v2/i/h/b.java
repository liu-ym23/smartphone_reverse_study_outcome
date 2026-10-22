package com.bytedance.sync.v2.i.h;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.sync.v2.f.k;
import com.bytedance.sync.v2.j.f;
import com.bytedance.sync.v2.j.h;
import com.bytedance.sync.v2.j.j;
import com.bytedance.sync.v2.j.p;
import d.b.u.q;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.r;
import kotlin.n0.d.o;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public final class b extends com.bytedance.sync.v2.i.h.a implements com.bytedance.sync.v2.i.e<j> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.b.u.e f6023f;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return kotlin.j0.a.a(((com.bytedance.sync.v2.j.c) r1).f6049f.f6032f, ((com.bytedance.sync.v2.j.c) r2).f6049f.f6032f);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sync.v2.i.h.b$b, reason: collision with other inner class name */
    public static final class C0191b<T> implements Comparator<T> {
        public C0191b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return kotlin.j0.a.a(((f) r1).f6078j, ((f) r2).f6078j);
        }
    }

    public b(Context r2, d.b.u.e r3) {
        o.g(r2, "context");
        o.g(r3, "configuration");
        super(r2, r3);
        this.f6023f = r3;
    }

    private final void h() {
        d.b.u.x.b.c("handle data finished. continue poll again...");
        k.a.a((k) com.ss.android.ug.bus.b.a(k.class), false, 1, null);
    }

    private final com.bytedance.sync.v2.i.h.a.C0190a k(ArrayList<com.bytedance.sync.v2.presistence.d.e> r3, com.bytedance.sync.v2.presistence.d.c r4) {
        com.bytedance.sync.v2.f.b r2 = (com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class);     // Catch: Exception -> L4
        d.b.u.x.b.a("save sync_logs to db : " + r4 + " + " + r3);     // Catch: Exception -> L4
        r2.z(r3, r4);     // Catch: Exception -> L4
        return new com.bytedance.sync.v2.i.h.a.C0190a(true, r4);
    L4:
        e = move-exception;
        d.b.u.k.c().ensureNotReachHere(e, "execute sql failed when insertSyncLogAndCursor");
        e.printStackTrace();
        return new com.bytedance.sync.v2.i.h.a.C0190a(false, null);
    }

    @Override // com.bytedance.sync.v2.i.e
    public /* bridge */ /* synthetic */ boolean a(j r1) {
        return g(r1);
    }

    @Override // com.bytedance.sync.v2.i.e
    public void b(int r10, com.bytedance.sync.v2.j.b r11, List<f> r12) {
        o.g(r11, "header");
        o.g(r12, "topics");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        Object r1 = r13.next();
        Long r2 = ((f) r1).f6077i;
        Object r3 = r0.get(r2);
        if (r3 != null) goto L8;
        r3 = new ArrayList();
        r0.put(r2, r3);
    L8:
        ((List) r3).add(r1);
        goto L4
    L9:
        Iterator r14 = r0.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r14.next();
        Object r5 = r4.getKey();
        o.b(r5, "entry.key");
        i(r10, ((Number) r5).longValue(), r11, (List) r4.getValue());
        goto L11
    L13:
        ((com.bytedance.sync.v2.f.d) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.d.class)).o(r0.keySet());
        h();
    }

    public boolean g(j r1) {
        o.g(r1, "obj");
        if (r1 != j.f6109i) goto L5;
        return true;
    L5:
        return false;
    }

    public void i(int r9, long r10, com.bytedance.sync.v2.j.b r12, List<f> r13) {
        o.g(r12, "header");
        o.g(r13, "topics");
        com.bytedance.sync.v2.presistence.d.c r0 = d().x(r10);     // Catch: Exception -> L36
        if (r0 != null) goto L8;
        d.b.u.x.b.b(r10 + " can't be found in local db");
        return;
    L8:
        if (c(r10, r12, r0) == true) goto L11;
        d.b.u.x.b.b("info not match when handle " + r10 + '.');
        return;
    L11:
        d.b.u.x.b.e("local cursor info -> " + r0);
        Iterator r14 = r.s0(r13, new C0191b()).iterator();
    L13:
        if (r14.hasNext() == false) goto L35;
        f r7 = (f) r14.next();
        long r1 = r7.f6078j.longValue();
        if (r0 == null) goto L33;
        if (r1 > r0.f6234f) goto L27;
        if (r0 == null) goto L25;
        com.bytedance.sync.v2.i.h.a.C0190a r2 = m(r9, r10, r0, r12, r7);
        boolean r3 = r2.a();
        com.bytedance.sync.v2.presistence.d.c r4 = r2.b();
        if (r3 == false) goto L24;
        if (r4 == null) goto L24;
        d.b.u.x.b.e("update memory cursor " + r4);
        r0 = r4;
    L24:
        String r5 = "patchAndSave failed. break process data";
    L30:
        d.b.u.x.b.b(r5);
        goto L13
    L25:
        o.p();
        throw null;
    L27:
        StringBuilder r6 = new StringBuilder();
        r6.append(r7.f6078j);
        r6.append(" > ");
        if (r0 == null) goto L31;
        r6.append(r0.f6234f);
        r6.append(", server cursor > db cursor when patch syncId = ");
        r6.append(r10);
        r5 = r6.toString();
        goto L30
    L31:
        o.p();
        throw null;
    L33:
        o.p();
        throw null;
    L35:
        return;
    L36:
        e = move-exception;
        e.printStackTrace();
        d.b.u.k.c().ensureNotReachHere(e, "execute sql failed when queryLocalSyncCursorInfo when receive data");
    }

    public void j(int r19, long r20, com.bytedance.sync.v2.j.c r22, f r23) {
        o.g(r22, "packet");
        o.g(r23, "topic");
        Map<String, String> r7 = r22.f6053j;     // Catch: Throwable -> L29
        if (r7 != null) goto L6;
        return;
    L6:
        if ((!o.a(r7.get("hit_sampling"), LocationInfoConst.ALLOW_USE_LOCATION)) == false) goto L8;
        return;
    L8:
        String r8 = r7.get("realtime");     // Catch: Throwable -> L29
        long r9 = System.currentTimeMillis();     // Catch: Throwable -> L29
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L29
        String r12 = r7.get("msg_id");     // Catch: Throwable -> L29
        String r13 = "";
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        d.b.u.d0.a.c(r11, "msg_id", r12);     // Catch: Throwable -> L29
        String r4 = r7.get("msg_req_id");     // Catch: Throwable -> L29
        if (r4 == null) goto L16;
        r13 = r4;
    L16:
        d.b.u.d0.a.c(r11, "msg_req_id", r13);     // Catch: Throwable -> L29
        Integer r5 = r22.f6050g.f6061f;     // Catch: Throwable -> L29
        o.b(r5, "packet.payload.business");     // Catch: Throwable -> L29
        d.b.u.d0.a.a(r11, "business_id", r5.intValue());     // Catch: Throwable -> L29
        String r6 = this.f6023f.f15023a;     // Catch: Throwable -> L29
        o.b(r6, "configuration.aid");     // Catch: Throwable -> L29
        d.b.u.d0.a.a(r11, IBdInstall.PARAM_APP_ID, Integer.parseInt(r6));     // Catch: Throwable -> L29
        d.b.u.d0.a.c(r11, "device_platform", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L29
        p r10 = r23.f6076h;     // Catch: Throwable -> L29
        o.b(r10, "topic.topic_type");     // Catch: Throwable -> L29
        d.b.u.d0.a.a(r11, "topic_type", r10.getValue());     // Catch: Throwable -> L29
        String r14 = r23.o;     // Catch: Throwable -> L29
        if (r14 == null) goto L21;
        List r3 = kotlin.u0.k.n0(r14, new String[]{":"}, false, 0, 6, null);     // Catch: Throwable -> L29
        if (r3 == null) goto L21;
        String r15 = (String) r.b0(r3);     // Catch: Throwable -> L29
    L22:
        d.b.u.d0.a.c(r11, "topic", r15);     // Catch: Throwable -> L29
        Long r1 = r23.f6077i;     // Catch: Throwable -> L29
        o.b(r1, "topic.sync_id");     // Catch: Throwable -> L29
        d.b.u.d0.a.b(r11, "sync_id", r1.longValue());     // Catch: Throwable -> L29
        Long r16 = r22.f6049f.f6032f;     // Catch: Throwable -> L29
        o.b(r16, "packet.cursor.cursor");     // Catch: Throwable -> L29
        d.b.u.d0.a.b(r11, "cursor", r16.longValue());     // Catch: Throwable -> L29
        d.b.u.d0.a.a(r11, "channel", r19);     // Catch: Throwable -> L29
        h r17 = r22.f6050g.f6062g;     // Catch: Throwable -> L29
        o.b(r17, "packet.payload.consume_type");     // Catch: Throwable -> L29
        d.b.u.d0.a.a(r11, "consumer_type", r17.getValue());     // Catch: Throwable -> L29
        Long r18 = r22.f6052i;     // Catch: Throwable -> L29
        o.b(r18, "packet.ts");     // Catch: Throwable -> L29
        d.b.u.d0.a.b(r11, "send_timestamp", r18.longValue());     // Catch: Throwable -> L29
        d.b.u.d0.a.b(r11, "receive_timestamp", r9);     // Catch: Throwable -> L29
        Long r0 = r22.f6052i;     // Catch: Throwable -> L29
        o.b(r0, "packet.ts");     // Catch: Throwable -> L29
        d.b.u.d0.a.b(r11, TypedValues.TransitionType.S_DURATION, r9 - r0.longValue());     // Catch: Throwable -> L29
        if (r8 != null) goto L26;
        r8 = BDLocationException.ERROR_TIMEOUT;
    L26:
        d.b.u.d0.a.c(r11, "realtime", r8);     // Catch: Throwable -> L29
        d.b.u.d0.a.c(r11, "params_for_special", "bytesync_sdk");     // Catch: Throwable -> L29
        q.a("sync_sdk_event_receive", r11);     // Catch: Throwable -> L29
        return;
    L21:
        r15 = null;
    L29:
        th = move-exception;
        d.b.u.x.b.b("eventReceive error: " + Log.getStackTraceString(th));
    }

    public void l(long r6, com.bytedance.sync.v2.j.c r8, f r9) {
        o.g(r8, "packet");
        o.g(r9, "topic");
        JSONObject r0 = new JSONObject();
        p r10 = r9.f6076h;
        o.b(r10, "topic.topic_type");
        r0.put("topic", r10.getValue());
        JSONObject r5 = new JSONObject();
        long r1 = System.currentTimeMillis();
        Long r11 = r8.f6052i;
        o.b(r11, "packet.ts");
        r5.put("time_consuming", r1 - r11.longValue());
        r5.put("receive_cnt", 1);
        JSONObject r12 = new JSONObject();
        r12.put("sync_id", r6);
        com.bytedance.sync.v2.j.d r7 = r8.f6050g;
        if (r7 == null) goto L7;
        Integer r13 = r7.f6061f;
        if (r13 == null) goto L7;
        int r14 = r13.intValue();
    L8:
        r12.put("business", r14);
        d.b.u.r.c("sync_sdk_receive_data", r0, r5, r12);
        return;
    L7:
        r14 = 0;
        goto L8
    }

    protected com.bytedance.sync.v2.i.h.a.C0190a m(int r26, long r27, com.bytedance.sync.v2.presistence.d.c r29, com.bytedance.sync.v2.j.b r30, f r31) {
        com.bytedance.sync.v2.presistence.d.c r13 = r29;
        com.bytedance.sync.v2.j.b r11 = r30;
        f r12 = r31;
        o.g(r13, "syncCursor");
        o.g(r11, "header");
        o.g(r12, "topic");
        List<com.bytedance.sync.v2.j.c> r0 = r12.f6080l;
        o.b(r0, "topic.packets");
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((com.bytedance.sync.v2.j.c) r3).f6049f.f6032f.longValue() <= r13.f6234f) goto L8;
        boolean r9 = true;
    L9:
        if (r9 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r9 = false;
        goto L9
    L11:
        List r4 = r.B0(r1);
        if (r4.size() <= 1) goto L14;
        r.u(r4, new a());
    L14:
        ArrayList<com.bytedance.sync.v2.presistence.d.e> r8 = new ArrayList();
        p r7 = r12.f6076h;
        Iterator r16 = r4.iterator();
    L16:
        if (r16.hasNext() == false) goto L50;
        com.bytedance.sync.v2.j.c r5 = (com.bytedance.sync.v2.j.c) r16.next();
        o.b(r5, "it");
        l(r27, r5, r12);
        j(r26, r27, r5, r31);
        com.bytedance.sync.v2.presistence.d.e r6 = new com.bytedance.sync.v2.presistence.d.e();
        if (r6.p != null) goto L20;
        r6.p = new HashMap();
    L20:
        Map<String, String> r10 = r6.p;
        o.b(r10, "syncLog.extra");
        r10.put("channel", String.valueOf(r26));
        Map<String, String> r14 = r5.f6053j;
        if (r14 == null) goto L23;
        r6.p.putAll(r14);
    L23:
        r6.n = r7;
        com.bytedance.sync.v2.j.d r15 = r5.f6050g;
        r6.f6254g = r15.f6061f.intValue();
        r6.f6255h = r15.f6062g;
        r6.f6248a = String.valueOf(r27);
        r6.f6253f = r15.f6063h;
        Long r17 = r5.f6052i;
        if (r17 != null) goto L27;
        r17 = com.bytedance.sync.v2.j.b.m;
        o.b(r17, "BsyncHeader.DEFAULT_TS");
    L27:
        r6.f6257j = r17.longValue();
        r6.f6258k = System.currentTimeMillis();
        Long r18 = r5.f6049f.f6032f;
        o.b(r18, "it.cursor.cursor");
        r6.f6251d = r18.longValue();
        r6.f6249b = r11.f6037h;
        r6.f6250c = r11.f6036g;
        r6.f6259l = r12.f6075g;
        String r19 = r12.o;
        if (r19 != null) goto L31;
        r19 = "";
    L31:
        r6.m = r19;
        k.h r20 = r5.f6050g.f6064i;
        if (r20 != null) goto L35;
        r6.f6252e = k.h.f18266i.E();
        r6.f6256i = d.b.u.y.a.f15124g;
        boolean r21 = false;
    L48:
        boolean r22 = r21;
    L49:
        JSONObject r23 = new JSONObject();
        r23.put("save_file", r22);
        d.b.u.r.d("sync_sdk_synclog_save_file", r23, null, com.bytedance.sync.v2.l.b.d(r6), 4, null);
        d.b.u.x.b.e("add sync_log to list : " + r6);
        r8.add(r6);
        r11 = r30;
        r12 = r31;
        r8 = r8;
        r13 = r13;
        r7 = r7;
        goto L16
    L35:
        if (r20.size() > f().f()) goto L59;
        r21 = false;
        r6.f6252e = r5.f6050g.f6064i.E();
        r6.f6256i = d.b.u.y.a.f15124g;
        goto L48
    L59:
        r7 = r7;
        r8 = r8;
        boolean r24 = false;
        r13 = r13;
        String r25 = e().O("synclog", r27, r6.f6251d, r5.f6050g.f6064i.E());     // Catch: Exception -> L56
        if (r25 == null) goto L42;
        byte[] r28 = r25.getBytes(kotlin.u0.d.f21429a);     // Catch: Exception -> L56
        o.b(r28, "(this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L56
        r6.f6252e = r28;     // Catch: Exception -> L56
        r6.f6256i = d.b.u.y.a.f15125h;     // Catch: Exception -> L56
        r22 = true;
        goto L49
    L42:
        d.b.u.x.b.b("save data to file failed");     // Catch: Exception -> L56
        return new com.bytedance.sync.v2.i.h.a.C0190a(false, null);
    L45:
        d.b.u.x.b.b("UnsupportedEncodingException when save syncLog data");
        return new com.bytedance.sync.v2.i.h.a.C0190a(r24, null);
    L44:
        r24 = false;
        goto L45
    L50:
        ArrayList<com.bytedance.sync.v2.presistence.d.e> r32 = r8;
        com.bytedance.sync.v2.presistence.d.c r33 = r13;
        com.bytedance.sync.v2.presistence.d.c r34 = new com.bytedance.sync.v2.presistence.d.c(r33);
        Long r35 = r31.f6079k;
        o.b(r35, "topic.new_cursor");
        r34.f6234f = r35.longValue();
        if (r32.isEmpty() == false) goto L55;
        d.b.u.x.b.a("sync logs is empty,throw it ,syncId = " + r27);
        return new com.bytedance.sync.v2.i.h.a.C0190a(true, r33);
    L55:
        return k(r32, r34);
    }
}
