package com.bytedance.sync.v2.i.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.j;
import com.bytedance.sync.v2.j.f;
import com.bytedance.sync.v2.j.p;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import k.h;
import kotlin.b0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u0.i;
import kotlin.u0.k;
import org.json.JSONObject;

/* JADX WARN: Unexpected interfaces in signature: [com.bytedance.sync.v2.i.e<com.bytedance.sync.v2.j.j>] */
/* JADX INFO: loaded from: classes.dex */
public final class c extends com.bytedance.sync.v2.i.h.a implements Object {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f6024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d.b.u.e f6025g;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return kotlin.j0.a.a(((com.bytedance.sync.v2.j.c) r1).f6049f.f6032f, ((com.bytedance.sync.v2.j.c) r2).f6049f.f6032f);
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f6028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f6029d;

        public b(boolean r1, String r2, String r3, long r4) {
            this.f6026a = r1;
            this.f6027b = r2;
            this.f6028c = r3;
            this.f6029d = r4;
        }

        public final String a() {
            return this.f6027b;
        }

        public final boolean b() {
            return this.f6026a;
        }

        public String toString() {
            return "PatchResult(success=" + this.f6026a + ", data=~~~, errMsg=" + this.f6028c + ", timeConsumed=" + this.f6029d + ')';
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sync.v2.i.h.c$c, reason: collision with other inner class name */
    public static final class C0192c<T> implements Comparator<T> {
        public C0192c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return kotlin.j0.a.a(((f) r1).f6078j, ((f) r2).f6078j);
        }
    }

    public static final class d<T> implements Comparator<T> {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return kotlin.j0.a.a(((f) r1).f6078j, ((f) r2).f6078j);
        }
    }

    public c(Context r2, d.b.u.e r3) {
        o.g(r2, "mContext");
        o.g(r3, "mConfiguration");
        super(r2, r3);
        this.f6024f = r2;
        this.f6025g = r3;
    }

    private final b i(com.bytedance.sync.v2.presistence.d.d r13, String r14) {
        d.b.u.v.a r12 = new d.b.u.v.a();     // Catch: Throwable -> L40
        byte[] r15 = r13.f6240e;     // Catch: Throwable -> L37
        o.b(r15, "syncLog.data");     // Catch: Throwable -> L37
        String r0 = new String(r15, kotlin.u0.d.f21429a);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r14) == false) goto L7;
        r14 = "";
    L7:
        LinkedList<d.b.u.v.a.e> r16 = (LinkedList) r12.E(r0);     // Catch: Throwable -> L37
        if (r16 == null) goto L36;
        Object[] r17 = r12.C(r16, r14);     // Catch: Throwable -> L37
        if (r17 == null) goto L36;
        if (r17.length != 2) goto L36;
        if (r17[0] == null) goto L36;
        if (r17[1] == null) goto L36;
        Object r1 = r17[0];     // Catch: Throwable -> L37
        if (r1 == null) goto L35;
        String r3 = (String) r1;     // Catch: Throwable -> L37
        Object r18 = r17[1];     // Catch: Throwable -> L37
        if (r18 == null) goto L33;
        boolean[] r19 = (boolean[]) r18;     // Catch: Throwable -> L37
        int r2 = r19.length;     // Catch: Throwable -> L37
        int r4 = 0;
        boolean r5 = true;
    L23:
        if (r4 >= r2) goto L31;
        boolean r6 = r19[r4];     // Catch: Throwable -> L37
        if (r5 == false) goto L28;
        if (r6 == false) goto L28;
        r5 = true;
    L29:
        r4 = r4 + 1;     // Catch: Throwable -> L37
    L28:
        r5 = false;
        goto L29
    L31:
        return new b(true, r3, null, 0);
    L33:
        throw new b0("null cannot be cast to non-null type kotlin.BooleanArray");     // Catch: Throwable -> L37
    L35:
        throw new b0("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L37
    L36:
        return null;
    L37:
        th = move-exception;
        return new b(false, null, Log.getStackTraceString(th), 0);
    L41:
        return new b(false, null, null, 0);
    }

    private final String k(com.bytedance.sync.v2.presistence.d.d r2) {
        String r1 = r2.m;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r1) == true) goto L13;
        o.b(r1, "reqId");     // Catch: Throwable -> L15
        List<String> r3 = new i(":").f(r1, 0);     // Catch: Throwable -> L15
        if (r3 == null) goto L12;
        Object[] r4 = r3.toArray(new String[0]);     // Catch: Throwable -> L15
        if (r4 == null) goto L10;
        String[] r5 = (String[]) r4;     // Catch: Throwable -> L15
        return r5[r5.length - 1];
    L10:
        throw new b0("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L15
    L12:
        throw new b0("null cannot be cast to non-null type java.util.Collection<T>");     // Catch: Throwable -> L15
    L13:
        return null;
    }

    private final String l(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L14;
        if (r8 == null) goto L15;
        List r9 = k.n0(r8, new String[]{":"}, false, 0, 6, null);     // Catch: Throwable -> L11
        if (r9 == null) goto L16;
        return (String) r.b0(r9);
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    L17:
        return null;
    }

    private final int m(long r6, p r8, String r9) {
        int r1 = com.bytedance.sync.v2.i.h.d.f6030a[r8.ordinal()];     // Catch: Throwable -> L32
        if (r1 != 1) goto L7;
        com.bytedance.sync.v2.e.c r5 = this.f6025g.m.get(String.valueOf(r8.getValue()) + ":" + r6);     // Catch: Throwable -> L32
        if (r5 == null) goto L29;
        com.bytedance.sync.v2.e.c r7 = r5;     // Catch: Throwable -> L32
    L31:
        return r7.f5944a;
    L29:
        o.p();     // Catch: Throwable -> L32
        throw null;
    L7:
        if (r1 == 2) goto L17;
        if (r1 != 3) goto L34;
        com.bytedance.sync.v2.e.c r10 = this.f6025g.m.get(String.valueOf(r8.getValue()) + ":" + r6);     // Catch: Throwable -> L32
        if (r10 == null) goto L14;
        r7 = r10;     // Catch: Throwable -> L32
        goto L31
    L14:
        o.p();     // Catch: Throwable -> L32
        throw null;
    L34:
        return 0;
    L17:
        if (TextUtils.isEmpty(r9) == false) goto L19;
        return 0;
    L19:
        com.bytedance.sync.v2.e.c r11 = this.f6025g.m.get(String.valueOf(r8.getValue()) + ":" + r6 + ":" + r9);     // Catch: Throwable -> L32
        if (r11 == null) goto L23;
        r7 = r11;     // Catch: Throwable -> L32
        goto L31
    L23:
        o.p();     // Catch: Throwable -> L32
        throw null;
    L35:
        return 0;
    }

    private final int n(com.bytedance.sync.v2.presistence.d.d r5) {
        long r0 = r5.f6242g;
        p r2 = r5.n;
        o.b(r2, "syncHistoryLog.topicType");
        return m(r0, r2, k(r5));
    }

    private final com.bytedance.sync.v2.i.h.a.C0190a o(ArrayList<com.bytedance.sync.v2.presistence.d.d> r3, com.bytedance.sync.v2.presistence.d.c r4) {
        d.b.u.x.b.a("save history_sync_logs to db : " + r4 + " + " + r3);     // Catch: Exception -> L4
        d().a0(r3);     // Catch: Exception -> L4
        p(r3);     // Catch: Exception -> L4
        return new com.bytedance.sync.v2.i.h.a.C0190a(true, r4);
    L4:
        e = move-exception;
        d.b.u.k.c().ensureNotReachHere(e, "execute sql failed when handler history database");
        e.printStackTrace();
        return new com.bytedance.sync.v2.i.h.a.C0190a(false, null);
    }

    private final void p(ArrayList<com.bytedance.sync.v2.presistence.d.d> r10) {
        com.bytedance.sync.v2.presistence.d.d r0 = r10.get(0);     // Catch: Throwable -> L19
        o.b(r0, "historySyncLogs[0]");     // Catch: Throwable -> L19
        com.bytedance.sync.v2.presistence.d.d r1 = r0;     // Catch: Throwable -> L19
        int r2 = n(r1);     // Catch: Throwable -> L19
        d.b.u.b0.b r3 = d.b.u.b0.b.g(this.f6024f);     // Catch: Throwable -> L19
        o.b(r3, "SyncSettings.inst(mContext)");     // Catch: Throwable -> L19
        d.b.u.b0.a r4 = r3.f();     // Catch: Throwable -> L19
        o.b(r4, "SyncSettings.inst(mContext).settingsV2");     // Catch: Throwable -> L19
        int r8 = kotlin.r0.e.f(r2, r4.h());     // Catch: Throwable -> L19
        if (r8 > 0) goto L6;
        return;
    L6:
        d().a0(r10);     // Catch: Throwable -> L19
        String r7 = k(r1);     // Catch: Throwable -> L19
        com.bytedance.sync.v2.f.b r5 = d();     // Catch: Throwable -> L19
        p r6 = r1.n;     // Catch: Throwable -> L19
        o.b(r6, "syncLog.topicType");     // Catch: Throwable -> L19
        List<com.bytedance.sync.v2.presistence.d.d> r11 = r5.J(r6, r1.f6242g, r7, r8);     // Catch: Throwable -> L19
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.isEmpty() == true) goto L27;
        d().R(r11);     // Catch: Throwable -> L19
        d.b.u.w.c r9 = (d.b.u.w.c) com.ss.android.ug.bus.b.a(d.b.u.w.c.class);     // Catch: Throwable -> L19
        Iterator<com.bytedance.sync.v2.presistence.d.d> r12 = r11.iterator();     // Catch: Throwable -> L19
    L13:
        if (r12.hasNext() == false) goto L29;
        com.bytedance.sync.v2.presistence.d.d r13 = r12.next();     // Catch: Throwable -> L19
        if (r13.f6244i != d.b.u.y.a.f15125h) goto L13;
        byte[] r14 = r13.f6240e;     // Catch: Throwable -> L19
        o.b(r14, "syncHistoryLog.data");     // Catch: Throwable -> L19
        r9.S(new String(r14, kotlin.u0.d.f21429a));     // Catch: Throwable -> L19
    L29:
        return;
    L27:
        return;
    }

    private final boolean r(f r5, com.bytedance.sync.v2.j.c r6) {
        long r1 = r6.f6050g.f6061f.intValue();     // Catch: Throwable -> L8
        p r7 = r5.f6076h;     // Catch: Throwable -> L8
        o.b(r7, "topic.topic_type");     // Catch: Throwable -> L8
        if (m(r1, r7, l(r5.o)) <= 0) goto L11;
        return false;
    L11:
        return true;
    L12:
        return true;
    }

    private final b s(com.bytedance.sync.v2.presistence.d.d r14, String r15) {
        b r13 = i(r14, r15);
        if (r13 == null) goto L13;
        if (r13.b() == false) goto L11;
        String r16 = j.a(r13.a(), "MD5");
        if (TextUtils.equals(r16, r14.f6241f) == false) goto L9;
        return r13;
    L9:
        return new b(false, null, "different md5. local is  " + r16 + ",server is " + r14.f6241f + " when patch " + r14.f6239d + " and syncId = " + r14.f6236a, 0);
    L11:
        return new b(false, null, "patch failed", 0);
    L13:
        return new b(false, null, null, 0);
    }

    private final com.bytedance.sync.v2.i.h.a.C0190a t(int r21, long r22, com.bytedance.sync.v2.presistence.d.c r24, com.bytedance.sync.v2.j.b r25, f r26, List<com.bytedance.sync.v2.j.c> r27) {
        com.bytedance.sync.v2.presistence.d.c r13 = r24;
        f r12 = r26;
        ArrayList<com.bytedance.sync.v2.presistence.d.d> r9 = new ArrayList();
        p r10 = r12.f6076h;
        com.bytedance.sync.v2.presistence.d.b r0 = d().k(String.valueOf(r22), ((com.bytedance.sync.v2.j.c) r.P(r27)).f6050g.f6061f.intValue());
        if (r0 == null) goto L5;
        byte[] r1 = r0.f6222f;
    L6:
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r27.iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();
        if (((com.bytedance.sync.v2.j.c) r4).f6049f.f6032f.longValue() <= r13.f6234f) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
        r2.add(r4);
        goto L8
    L12:
        r7 = false;
        goto L13
    L15:
        List r5 = r.B0(r2);
        if (r5.size() <= 1) goto L18;
        r.u(r5, new a());
    L18:
        Iterator r16 = r5.iterator();
        byte[] r8 = r1;
    L20:
        if (r16.hasNext() == false) goto L74;
        com.bytedance.sync.v2.j.c r11 = (com.bytedance.sync.v2.j.c) r16.next();
        if (r(r12, r11) == false) goto L24;
        ArrayList<com.bytedance.sync.v2.presistence.d.d> r6 = r9;
        r10 = r10;
        r13 = r13;
    L73:
        r12 = r26;
        r9 = r6;
        r13 = r13;
        r10 = r10;
        goto L20
    L24:
        q(r22, r11, r12);
        j(r21, r22, r11, r26);
        com.bytedance.sync.v2.presistence.d.d r14 = new com.bytedance.sync.v2.presistence.d.d();
        if (r14.p != null) goto L27;
        r14.p = new HashMap();
    L27:
        Map<String, String> r15 = r14.p;
        o.b(r15, "syncHistoryLog.extra");
        r15.put("channel", String.valueOf(r21));
        Map<String, String> r17 = r11.f6053j;
        if (r17 == null) goto L30;
        r14.p.putAll(r17);
    L30:
        r14.n = r10;
        com.bytedance.sync.v2.j.d r18 = r11.f6050g;
        r14.f6242g = r18.f6061f.intValue();
        r14.f6243h = r18.f6062g;
        r14.f6236a = String.valueOf(r22);
        r14.f6241f = r18.f6063h;
        Long r19 = r11.f6052i;
        if (r19 != null) goto L34;
        r19 = com.bytedance.sync.v2.j.b.m;
        o.b(r19, "BsyncHeader.DEFAULT_TS");
    L34:
        r14.f6245j = r19.longValue();
        r14.f6246k = System.currentTimeMillis();
        Long r20 = r11.f6049f.f6032f;
        o.b(r20, "it.cursor.cursor");
        r14.f6239d = r20.longValue();
        r14.f6237b = r25.f6037h;
        r14.f6238c = r25.f6036g;
        r14.f6247l = r12.f6075g;
        String r23 = r12.o;
        String r28 = "";
        if (r23 != null) goto L38;
        r23 = "";
    L38:
        r14.m = r23;
        h r29 = r11.f6050g.f6064i;
        if (r29 != null) goto L41;
        r14.f6240e = h.f18266i.E();
        r14.f6244i = d.b.u.y.a.f15124g;
        byte[] r110 = r8;
        boolean r30 = false;
    L72:
        JSONObject r31 = new JSONObject();
        r31.put("save_file", r30);
        d.b.u.r.d("sync_sdk_synclog_save_file", r31, null, new JSONObject(), 4, null);
        d.b.u.x.b.e("add history_sync_log to list : " + r14);
        r6 = r9;
        r6.add(r14);
        r8 = r110;
        goto L73
    L41:
        byte[] r32 = r29.E();
        r14.f6240e = r32;
        if (r14.f6243h != com.bytedance.sync.v2.j.h.f6097h) goto L58;
        if (r8 == null) goto L45;
        r28 = new String(r8, kotlin.u0.d.f21429a);
    L45:
        b r33 = s(r14, r28);
        if (r33 == null) goto L58;
        if (r33.b() == false) goto L58;
        String r34 = r33.a();
        if (r34 == null) goto L56;
        Charset r35 = kotlin.u0.d.f21429a;
        if (r34 == null) goto L55;
        byte[] r36 = r34.getBytes(r35);
        o.b(r36, "(this as java.lang.String).getBytes(charset)");
        byte[] r37 = r36;
    L57:
        byte[] r38 = r37;
        byte[] r39 = r38;
    L60:
        if (r39.length > f().f()) goto L83;
        r110 = r38;
        r14.f6240e = r39;
        r14.f6244i = d.b.u.y.a.f15124g;
        r30 = false;
        goto L72
    L83:
        r110 = r38;
        com.bytedance.sync.v2.presistence.d.c r40 = null;
        String r41 = e().O("historySyncLog", r22, r14.f6239d, r39);     // Catch: Exception -> L80
        if (r41 == null) goto L66;
        byte[] r42 = r41.getBytes(kotlin.u0.d.f21429a);     // Catch: Exception -> L80
        o.b(r42, "(this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L80
        r14.f6240e = r42;     // Catch: Exception -> L80
        r14.f6244i = d.b.u.y.a.f15125h;     // Catch: Exception -> L80
        r30 = true;
        goto L72
    L66:
        d.b.u.x.b.b("save data to file failed");     // Catch: Exception -> L80
        return new com.bytedance.sync.v2.i.h.a.C0190a(false, null);
    L69:
        d.b.u.x.b.b("UnsupportedEncodingException when save syncLog data");
        return new com.bytedance.sync.v2.i.h.a.C0190a(false, r40);
    L68:
        r40 = null;
        goto L69
    L55:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L56:
        r37 = null;
    L58:
        r39 = r32;
        r38 = r8;
        goto L60
    L74:
        ArrayList<com.bytedance.sync.v2.presistence.d.d> r43 = r9;
        com.bytedance.sync.v2.presistence.d.c r44 = r13;
        com.bytedance.sync.v2.presistence.d.c r45 = new com.bytedance.sync.v2.presistence.d.c(r44);
        Long r46 = r26.f6079k;
        o.b(r46, "topic.new_cursor");
        r45.f6234f = r46.longValue();
        if (r43.isEmpty() == false) goto L79;
        d.b.u.x.b.a("history sync logs is empty,throw it ,syncId = " + r22);
        return new com.bytedance.sync.v2.i.h.a.C0190a(true, r44);
    L79:
        return o(r43, r45);
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ boolean a(Object r1) {
        return g((com.bytedance.sync.v2.j.j) r1);
    }

    public void b(int r9, com.bytedance.sync.v2.j.b r10, List<f> r11) {
        o.g(r10, "header");
        o.g(r11, "topics");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r1 = r12.next();
        Long r2 = ((f) r1).f6077i;
        Object r3 = r0.get(r2);
        if (r3 != null) goto L8;
        r3 = new ArrayList();
        r0.put(r2, r3);
    L8:
        ((List) r3).add(r1);
        goto L4
    L9:
        Iterator r13 = r0.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r13.next();
        Object r5 = r4.getKey();
        o.b(r5, "entry.key");
        h(r9, ((Number) r5).longValue(), r10, (List) r4.getValue());
        goto L11
    }

    public boolean g(com.bytedance.sync.v2.j.j r1) {
        o.g(r1, "obj");
        if (r1 != com.bytedance.sync.v2.j.j.f6109i) goto L5;
        return true;
    L5:
        return false;
    }

    public void h(int r9, long r10, com.bytedance.sync.v2.j.b r12, List<f> r13) {
        o.g(r12, "header");
        o.g(r13, "topics");
        com.bytedance.sync.v2.presistence.d.c r5 = d().x(r10);     // Catch: Exception -> L13
        if (r5 != null) goto L8;
        d.b.u.x.b.b(r10 + " can't be found in local db");
        return;
    L8:
        if (c(r10, r12, r5) == true) goto L11;
        d.b.u.x.b.b("info not match when handle " + r10 + '.');
        return;
    L11:
        d.b.u.x.b.e("local cursor info -> " + r5);
        u(r9, r10, r5, r12, r.s0(r13, new C0192c()));
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        d.b.u.k.c().ensureNotReachHere(e, "execute sql failed when queryLocalSyncCursorInfo when receive data");
    }

    public void j(int r1, long r2, com.bytedance.sync.v2.j.c r4, f r5) {
        o.g(r4, "packet");
        o.g(r5, "topic");
    }

    public void q(long r1, com.bytedance.sync.v2.j.c r3, f r4) {
        o.g(r3, "packet");
        o.g(r4, "topic");
    }

    protected com.bytedance.sync.v2.i.h.a.C0190a u(int r16, long r17, com.bytedance.sync.v2.presistence.d.c r19, com.bytedance.sync.v2.j.b r20, List<f> r21) {
        o.g(r19, "syncCursor");
        o.g(r20, "header");
        o.g(r21, "topics");
        ArrayList r0 = new ArrayList();
        Iterator r1 = r.s0(r21, new d()).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        f r2 = (f) r1.next();
        if (r2.f6078j.longValue() <= r19.f6234f) goto L7;
        d.b.u.x.b.b(r2.f6078j + " > " + r19.f6234f + ", server cursor > db cursor when patch syncId = " + r17);
        goto L4
    L7:
        List<com.bytedance.sync.v2.j.c> r3 = r2.f6080l;
        o.b(r3, "it.packets");
        r0.addAll(r3);
        goto L4
    L9:
        com.bytedance.sync.v2.i.h.a.C0190a r4 = new com.bytedance.sync.v2.i.h.a.C0190a(false, null);
        ArrayList r5 = new ArrayList();
        Iterator r6 = r0.iterator();
    L11:
        if (r6.hasNext() == false) goto L18;
        Object r7 = r6.next();
        if (((com.bytedance.sync.v2.j.c) r7).f6049f.f6032f.longValue() <= r19.f6234f) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L11;
        r5.add(r7);
        goto L11
    L15:
        r8 = false;
        goto L16
    L18:
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r10 = r5.iterator();
    L20:
        if (r10.hasNext() == false) goto L25;
        Object r11 = r10.next();
        Integer r12 = ((com.bytedance.sync.v2.j.c) r11).f6050g.f6061f;
        Object r13 = r9.get(r12);
        if (r13 != null) goto L24;
        r13 = new ArrayList();
        r9.put(r12, r13);
    L24:
        ((List) r13).add(r11);
        goto L20
    L25:
        Iterator r14 = r9.values().iterator();
    L27:
        if (r14.hasNext() == false) goto L29;
        r4 = t(r16, r17, r19, r20, (f) r.P(r21), (List) r14.next());
        goto L27
    L29:
        return r4;
    }
}
