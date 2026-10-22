package ms.bd.c;

import com.bytedance.mobsec.matrix.utils.m.TN;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends s {
    public u() {
    }

    private int h(d.b.r.b<d.b.r.k0.i> r2, d.b.r.d0<d.b.r.k0.i> r3) {
        if (r2 == null) goto L19;
        if (r3 != null) goto L6;
        return 80004;
    L6:
        if ((r2 instanceof d.b.r.n) == false) goto L17;
        ((d.b.r.n) r2).c();
        d.b.r.h0.d r4 = r3.g();
        if (r4 == null) goto L16;
        Object r5 = r4.b();
        if ((r5 instanceof com.bytedance.ttnet.m.b) == false) goto L15;
        com.bytedance.ttnet.m.b r6 = (com.bytedance.ttnet.m.b) r5;
        if (r6 != null) goto L21;
        return 80008;
    L21:
        return i(r6.E);
    L15:
        return 80007;
    L16:
        return 80006;
    L17:
        return 80005;
    L19:
        return 80004;
    }

    private int i(String r22) {
        if (r22 != null) goto L5;
        return 80000;
    L5:
        if ("" == r22) goto L32;
    L23:
        return 80003;
    L9:
        JSONObject r1 = new JSONObject(r22).getJSONObject((String) m.a(16777217, 0, 0, "b23015", new byte[]{113, 49, 83, 65}));     // Catch: Throwable -> L23
        if (r1 != null) goto L13;
        return 80001;
    L13:
        String r2 = r1.getString((String) m.a(16777217, 0, 0, "d6161a", new byte[]{102, 32, 67, 86, 27, 101}));     // Catch: Throwable -> L23
        if (r2 != null) goto L17;
    L22:
        return 80002;
    L17:
        if (((String) m.a(16777217, 0, 0, "40bbf8", new byte[]{22, 7, 50, 53, 124, 28, 4})) == r2) goto L22;
        return r1.getInt((String) m.a(16777217, 0, 0, "24d88f", new byte[]{45, 51, 3, 115, 2, 99, 35, 26, 39}));
    L32:
        return 80000;
    }

    private String j(List<d.b.r.h0.b> r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        if (r9.size() <= 0) goto L24;
        Iterator<d.b.r.h0.b> r10 = r9.iterator();
    L9:
        if (r10.hasNext() == false) goto L25;
        d.b.r.h0.b r0 = r10.next();
        if (r0 == null) goto L9;
        if (((String) m.a(16777217, 0, 0, "3f8f09", new byte[]{58, 41, 95, 6, 66, 34, 63, 64, 96, 50})).equalsIgnoreCase(r0.a()) == false) goto L9;
        return r0.b();
    L25:
        return null;
    L24:
        return null;
    }

    private Object[] k(String r36, byte[] r37, String r38, String r39, String r40, boolean r41) {
        q.a r4 = new q.a();
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L70
        String r6 = (String) m.a(16777217, 0, 0, "f8b1f2", new byte[]{84, 53, 30, 78, 80, 32});     // Catch: Throwable -> L70
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L70
        r5.append((String) m.a(16777217, 0, 0, "4cbcf3", new byte[]{54, 100, 2, 4, 80, 43, 57, 75, 55, 110}));     // Catch: Throwable -> L70
        r5.append(r38);     // Catch: Throwable -> L70
        r14.add(new d.b.r.h0.b(r6, r5.toString()));     // Catch: Throwable -> L70
        r14.add(new d.b.r.h0.b((String) m.a(16777217, 0, 0, "8f48e1", new byte[]{8, 103, 68, 73, 74, 50}), (String) m.a(16777217, 0, 0, "7c382b", new byte[]{108, 46, 10})));     // Catch: Throwable -> L70
        r14.add(new d.b.r.h0.b((String) m.a(16777217, 0, 0, "4901f0", new byte[]{16, 40, 70, 87, 20, 6, 48, 29, 111, 117}), (String) m.a(16777217, 0, 0, "a5cbaf", new byte[]{82, 46, 4, 19, 122, 112, 108, 23, 55, 127, 93, 4, 35, 50, 117})));     // Catch: Throwable -> L70
        r14.add(new d.b.r.h0.b((String) m.a(16777217, 0, 0, "664d76", new byte[]{4, 59, 73, 4, 13, 47, 33, 90, 81, 45, 55, 49}), (String) m.a(16777217, 0, 0, "b4a8e1", new byte[]{114, 38, 2, 64, 83, 37, 96, 1, 57, 103, 125, 121, 29, 79, 78, 35, 117, 88, 35, 124, 97, 51, 19, 65})));     // Catch: Throwable -> L70
        if (r39 != null) goto L22;
    L26:
        TN r2 = (TN) com.bytedance.ttnet.s.d.h(r36).e(TN.class);     // Catch: Throwable -> L70
        if (r41 == true) goto L30;
        d.b.r.b<d.b.r.k0.i> r3 = r2.p2(r36, r14);     // Catch: Throwable -> L70
    L138:
        r4.a(r36);     // Catch: Throwable -> L66
        d.b.r.d0<d.b.r.k0.i> r7 = r3.execute();     // Catch: Throwable -> L66
        int r8 = r7.b();     // Catch: Throwable -> L64
        r4.c(j(r7.d()), r8);     // Catch: Throwable -> L62
        if (r40 == null) goto L37;
        OutputStream r0 = new FileOutputStream(r40);     // Catch: Throwable -> L62
    L38:
        OutputStream r9 = r0;
        InputStream r10 = r7.a().d();     // Catch: Throwable -> L60
        byte[] r1 = new byte[1024];     // Catch: Throwable -> L58
    L42:
        int r11 = r10.read(r1, 0, 1024);     // Catch: Throwable -> L58
        if (r11 <= 0) goto L45;
        r9.write(r1, 0, r11);     // Catch: Throwable -> L58
        goto L42
    L45:
        r9.flush();     // Catch: Throwable -> L58
        if ((r9 instanceof ByteArrayOutputStream) == false) goto L49;
        byte[] r12 = ((ByteArrayOutputStream) r9).toByteArray();     // Catch: Throwable -> L58
    L51:
        if (r8 == 200) goto L53;
        int r13 = h(r3, r7);
    L55:
        if (r8 != (-1)) goto L57;
        r8 = l(r3, r7);
    L57:
        d.b.h.a.a.h.p.f.l(r10);
        d.b.h.a.a.h.p.f.l(r9);
        r3.cancel();
    L122:
        return new Object[]{String.valueOf(r8), r12, Integer.valueOf(r13)};
    L53:
        r13 = 0;
        goto L55
    L49:
        r12 = null;
    L58:
        th = th;
    L73:
        int r15 = 99999;
    L123:
        th = move-exception;
        if (r8 == 200) goto L129;
        if (r15 != 0) goto L129;
        h(r3, r7);
    L129:
        if (r8 != (-1)) goto L131;
        l(r3, r7);
    L131:
        d.b.h.a.a.h.p.f.l(r10);
        d.b.h.a.a.h.p.f.l(r9);
        if (r3 == null) goto L134;
        r3.cancel();
    L134:
        throw th;
    L75:
        if ((th instanceof UnsupportedOperationException) == false) goto L78;
        r15 = 90000;
    L78:
        if ((th instanceof d.b.h.a.a.h.l.a) == false) goto L81;
        r15 = 90001;
    L81:
        if ((th instanceof d.b.h.a.a.h.l.b) == false) goto L84;
        r15 = 90002;
    L84:
        if ((th instanceof d.b.h.a.a.h.l.d) == false) goto L87;
        r15 = 90003;
    L87:
        if ((th instanceof d.b.h.a.a.h.l.e) == false) goto L90;
        r15 = 90004;
    L90:
        if ((th instanceof d.b.h.a.a.h.l.f) == false) goto L93;
        r15 = 90006;
    L93:
        if ((th instanceof d.b.h.a.a.h.l.g) == false) goto L96;
        r15 = 90007;
    L96:
        if ((th instanceof com.bytedance.frameworks.baselib.network.http.cronet.e.e) == false) goto L104;
        com.bytedance.frameworks.baselib.network.http.cronet.e.e r16 = th;     // Catch: Throwable -> L123
        r15 = i(r16.d());     // Catch: Throwable -> L123
        if (r15 < 80000) goto L101;
        r15 = 90009;
    L101:
        if (r8 != (-1)) goto L104;
        r8 = m(r16.d());     // Catch: Throwable -> L123
    L104:
        String r17 = (String) m.a(16777217, 0, 0, "fd227e", new byte[]{99, 110, 66, 121, 0, 99});     // Catch: Throwable -> L123
        if (r7 == null) goto L107;
        String r18 = j(r7.d());     // Catch: Throwable -> L123
    L108:
        r4.b(r18, r8);     // Catch: Throwable -> L123
        if (r8 == 200) goto L113;
        if (r15 != 0) goto L113;
        r13 = h(r3, r7);
    L115:
        if (r8 != (-1)) goto L117;
        r8 = l(r3, r7);
    L117:
        d.b.h.a.a.h.p.f.l(r10);
        d.b.h.a.a.h.p.f.l(r9);
        if (r3 == null) goto L120;
        r3.cancel();
    L120:
        r12 = null;
    L113:
        r13 = r15;
        goto L115
    L107:
        r18 = null;
    L60:
        th = th;
    L72:
        r10 = null;
        goto L73
    L37:
        r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L62
    L62:
        th = th;
    L69:
        r9 = null;
    L64:
        th = th;
    L68:
        r8 = -1;
    L66:
        th = th;
        r7 = null;
        goto L68
    L30:
        r3 = r2.p1(r36, r14, new d.b.r.k0.g((String) m.a(16777217, 0, 0, "128485", new byte[]{33, 32, 91, 76, 14, 33, 51, 7, 96, 107, 46, 127, 68, 67, 19, 39, 38, 94, 122, 112, 50, 53, 74, 77}), r37, new String[0]));     // Catch: Throwable -> L70
        goto L138
    L22:
        if (r39.trim().length() <= 0) goto L26;
        r14.add(new d.b.r.h0.b((String) m.a(16777217, 0, 0, "4002de", new byte[]{61, 127, 87, 82, 22, 96, 50, 0, 116, 103, 54, 38, 14, 82, 90, 117}), r39));     // Catch: Throwable -> L70
    L70:
        th = th;
        r3 = null;
        r9 = null;
        r7 = null;
        r8 = -1;
        goto L72
    }

    private int l(d.b.r.b<d.b.r.k0.i> r3, d.b.r.d0<d.b.r.k0.i> r4) {
        if (r3 == null) goto L16;
        if (r4 != null) goto L7;
        return -1;
    L7:
        if ((r3 instanceof d.b.r.n) == false) goto L17;
        ((d.b.r.n) r3).c();
        d.b.r.h0.d r5 = r4.g();
        if (r5 == null) goto L18;
        Object r6 = r5.b();
        if ((r6 instanceof com.bytedance.ttnet.m.b) == false) goto L19;
        com.bytedance.ttnet.m.b r7 = (com.bytedance.ttnet.m.b) r6;
        if (r7 != null) goto L15;
        return -1;
    L15:
        return m(r7.E);
    L19:
        return -1;
    L18:
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    private int m(String r18) {
        if (r18 != null) goto L5;
        return -1;
    L5:
        if ("" == r18) goto L17;
        return new JSONObject(r18).getJSONObject((String) m.a(16777217, 0, 0, "66fd7d", new byte[]{53, 49, 6, 0, 7, 125, 38, 18})).getInt((String) m.a(16777217, 0, 0, "c96113", new byte[]{113, 52, 65, 64}));
    L18:
        return -1;
    L17:
        return -1;
    }

    @Override // ms.bd.c.s
    public Object[] e(String r8, String r9, String r10) {
        return k(r8, null, null, r10, r9, false);
    }

    @Override // ms.bd.c.s
    public Object[] f(String r8, byte[] r9, String r10, String r11) {
        return k(r8, r9, r10, r11, null, true);
    }

    @Override // ms.bd.c.s
    public Object[] g(String r8, String r9, String r10) {
        return k(r8, null, r9, r10, null, false);
    }
}
