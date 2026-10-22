package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.tmsecure.vd.TNative$aa;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import obric.widget.ChipsView;

/* JADX INFO: loaded from: classes5.dex */
public class q5 {
    public static final q5 f = null;
    public static final Set g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f433a;
    public final Set b;
    public final Object c;
    public k3 d;
    public d5 e;

    static {
        f = new q5();
        HashSet r0 = new HashSet();
        r0.add(2);
        r0.add(6);
        r0.add(3);
        r0.add(32);
        r0.add(5);
        r0.add(4);
        r0.add(40);
        r0.add(43);
        r0.add(19);
        r0.add(36);
        r0.add(45);
        r0.add(136);
        r0.add(143);
        r0.add(Integer.valueOf(ChipsView.HISTORY));
        r0.add(10002);
        r0.add(10003);
        int r1 = n0.f360a;
        if (r1 != 105668) goto L6;
        r0.add(18);
    L11:
        g = Collections.unmodifiableSet(r0);
        return;
    L6:
        if (r1 != 105928) goto L9;
        r0.add(18);
        goto L11
    L9:
        if (r1 != 108168) goto L11;
        r0.add(18);
        goto L11
    }

    public q5() {
        this.f433a = new HashSet();
        this.b = new HashSet();
        this.c = new Object();
    }

    public long a(Context r6) {
        long r1 = 0;
        if (o5.f.d() == false) goto L8;
        return 0;
    L8:
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L7
        b(r6);     // Catch: Throwable -> L7
        r1 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L7
        b();     // Catch: Throwable -> L7
        return r1;
    L10:
        return r1;
    }

    public final void b() {
        fi r0 = o5.f.b();     // Catch: Throwable -> L29
        if (r0 == null) goto L6;
        Map r1 = r0.e;     // Catch: Throwable -> L29
        if (r1 == null) goto L6;
    L7:
        HashSet r2 = new HashSet();     // Catch: Throwable -> L29
        HashSet r3 = new HashSet();     // Catch: Throwable -> L29
        Iterator r4 = r1.entrySet().iterator();     // Catch: Throwable -> L29
    L9:
        if (r4.hasNext() == false) goto L14;
        Map.Entry r5 = (Map.Entry) r4.next();     // Catch: Throwable -> L29
        if (((Integer) r5.getValue()).intValue() == 0) goto L12;
        r3.add(r5.getKey());     // Catch: Throwable -> L29
        goto L9
    L12:
        r2.add(r5.getKey());     // Catch: Throwable -> L29
        goto L9
    L14:
        Set r6 = this.b;     // Catch: Throwable -> L29
        monitor-enter(r6);     // Catch: Throwable -> L29
        this.b.clear();     // Catch: Throwable -> L25
        this.b.addAll(g);     // Catch: Throwable -> L25
        this.b.addAll(r2);     // Catch: Throwable -> L25
        this.b.removeAll(r3);     // Catch: Throwable -> L25
        Set r7 = this.f433a;     // Catch: Throwable -> L25
        monitor-enter(r7);     // Catch: Throwable -> L25
        this.b.addAll(this.f433a);     // Catch: Throwable -> L22
        monitor-exit(r7);     // Catch: Throwable -> L22
        monitor-exit(r6);     // Catch: Throwable -> L25
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L6:
        r1 = Collections.emptyMap();     // Catch: Throwable -> L29
    }

    public final byte[] a(Context r7, boolean r8) {
        byte[] r1 = new byte[0];
        HashMap r2 = new HashMap();
        String r3 = "";
        r2.put("1", p.a("").append(n0.f360a).toString());
        k3 r6 = this.d;
        if (TextUtils.isEmpty(r6.p) == true) goto L6;
        r3 = r6.p;
    L6:
        r2.put("101", r3);
        fi r9 = o5.f.b();
        if (r9 == null) goto L9;
        r2.put("2026", String.valueOf(r9.f205a));
        r2.put("2027", String.valueOf(r9.c));
    L9:
        r2.put("207", b5.l.a(r7).f594a);
        if (r8 == false) goto L12;
        r2.put("264", qk.a());
    L20:
        SparseArray r10 = new SparseArray();     // Catch: Throwable -> L19
        String r11 = q3.f431a;     // Catch: Throwable -> L19
        SparseArray<Object> r12 = TNative$aa.e90_A43184BF099FF466(r10, r7, r2, 0);     // Catch: Throwable -> L19
        if (ca.b(r12) == 0) goto L18;
        return r1;
    L18:
        return ca.a(r12);
    L19:
        return r1;
    L12:
        r2.put("264", "PPNA");
        goto L20
    }

    public final void b(Context r10) {
        Object r1 = this.c;     // Catch: Throwable -> L33
        monitor-enter(r1);     // Catch: Throwable -> L33
        o5 r2 = o5.f;     // Catch: Throwable -> L29
        if (r2.d() == false) goto L16;
        long r3 = this.e.a(r10, "501");     // Catch: Throwable -> L29
        fi r5 = r2.b();     // Catch: Throwable -> L29
        if (r5 == null) goto L11;
        long r6 = r5.f;     // Catch: Throwable -> L29
        if (r6 <= 0) goto L11;
    L13:
        if (Math.abs(System.currentTimeMillis() - r3) > (r6 * 1000)) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L29
        return;
    L11:
        r6 = 57600;
    L16:
        boolean r4 = this.d.c().a();     // Catch: Throwable -> L29
        byte[] r7 = a(r10, r4);     // Catch: Throwable -> L29
        if (r7.length != 0) goto L20;
        monitor-exit(r1);     // Catch: Throwable -> L29
        return;
    L20:
        fi r8 = a(s5.b.a(r7, 8119, 18119).b);     // Catch: Throwable -> L29
        if (r8 != null) goto L24;
        monitor-exit(r1);     // Catch: Throwable -> L29
        return;
    L24:
        r2.a(r8, r4);     // Catch: Throwable -> L29
        if (r4 == false) goto L27;
        d5 r9 = this.e;     // Catch: Throwable -> L29
        r9.getClass();     // Catch: Throwable -> L29
        r9.a(r10, "501", "" + System.currentTimeMillis(), true);     // Catch: Throwable -> L29
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    }

    public final fi a(byte[] r6) {
        String r1 = q3.f431a;
        k0 r2 = new k0();     // Catch: Throwable -> L26
        r2.a(new y1(r6));     // Catch: Throwable -> L26
        int r7 = r2.f297a;     // Catch: Throwable -> L26
        if (r7 >= 0) goto L7;
        return null;
    L7:
        if (r7 == 1) goto L9;
        fi r8 = r2.b;     // Catch: Throwable -> L26
        if (r8 == null) goto L13;
        Log.e("D" + n0.f360a, "s:" + r8.f205a + ",v:" + r8.c);     // Catch: Throwable -> L26
        Iterator r5 = r8.e.entrySet().iterator();     // Catch: Throwable -> L26
    L16:
        if (r5.hasNext() == false) goto L18;
        Map.Entry r0 = (Map.Entry) r5.next();     // Catch: Throwable -> L26
        goto L16
    L18:
        Map r9 = r8.g;     // Catch: Throwable -> L26
        if (r9 == null) goto L25;
        Iterator r10 = r9.keySet().iterator();     // Catch: Throwable -> L26
    L22:
        if (r10.hasNext() == false) goto L25;
        String r3 = (String) r10.next();     // Catch: Throwable -> L26
    L25:
        return r8;
    L13:
        return new fi();
    L9:
        return new fi();
    L26:
        return null;
    }

    public boolean a(int r2) {
        Set r0 = this.b;
        monitor-enter(r0);
        boolean r1 = !this.b.contains(Integer.valueOf(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String a() {
        StringBuilder r0 = new StringBuilder();
        Set r1 = this.b;
        monitor-enter(r1);
        Iterator r4 = this.b.iterator();     // Catch: Throwable -> L14
    L6:
        if (r4.hasNext() == false) goto L11;
        Integer r2 = (Integer) r4.next();     // Catch: Throwable -> L14
        if (r0.length() <= 0) goto L10;
        r0.append(",");     // Catch: Throwable -> L14
    L10:
        r0.append(r2);     // Catch: Throwable -> L14
        goto L6
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r0.toString();
    L14:
        th = move-exception;
        throw th;
    }
}
