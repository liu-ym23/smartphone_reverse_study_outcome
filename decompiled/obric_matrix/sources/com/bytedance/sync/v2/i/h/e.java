package com.bytedance.sync.v2.i.h;

import androidx.annotation.VisibleForTesting;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.sync.v2.f.h;
import com.bytedance.sync.v2.f.k;
import com.bytedance.sync.v2.f.l;
import com.bytedance.sync.v2.j.f;
import com.bytedance.sync.v2.j.g;
import com.bytedance.sync.v2.j.j;
import com.bytedance.sync.v2.j.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.z;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.bytedance.sync.v2.i.d<j> {
    public e() {
    }

    private final void c(com.bytedance.sync.v2.presistence.d.c r5, f r6, com.bytedance.sync.v2.j.b r7) {
        if (r6 == null) goto L11;
        r5.f6229a = String.valueOf(r6.f6077i.longValue());
        r5.f6230b = r7.f6037h;
        g r4 = r6.f6075g;
        if (r4 != g.f6091g) goto L6;
        String r8 = BDLocationException.ERROR_TIMEOUT;
    L7:
        r5.f6231c = r8;
        r5.f6233e = r4;
        r5.f6232d = r6.f6076h;
        if (r6.f6078j.longValue() <= r5.f6235g) goto L13;
        Long r9 = r6.f6078j;
        o.b(r9, "topic.ref_cursor");
        r5.f6235g = r9.longValue();
        return;
    L13:
        return;
    L6:
        r8 = r7.f6036g;
        goto L7
    L11:
        o.p();
        throw null;
    }

    @Override // com.bytedance.sync.v2.i.d
    public /* bridge */ /* synthetic */ boolean a(j r1) {
        return d(r1);
    }

    @Override // com.bytedance.sync.v2.i.d
    public void b(com.bytedance.sync.v2.j.b r2, List<f> r3) {
        o.g(r2, "header");
        o.g(r3, "topics");
        z<List<String>, List<com.bytedance.sync.v2.presistence.d.c>, List<com.bytedance.sync.v2.presistence.d.a>> r1 = e(r3, r2);
        List<String> r4 = r1.a();
        List<com.bytedance.sync.v2.presistence.d.c> r5 = r1.b();
        List<com.bytedance.sync.v2.presistence.d.a> r6 = r1.c();
        ((com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class)).l0(r5, r4, r6);     // Catch: Exception -> L5
        k.a.a((k) com.ss.android.ug.bus.b.a(k.class), false, 1, null);     // Catch: Exception -> L5
        ((com.bytedance.sync.v2.f.a) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.a.class)).m();     // Catch: Exception -> L5
        ((l) com.ss.android.ug.bus.b.a(l.class)).m();     // Catch: Exception -> L5
        ((h) com.ss.android.ug.bus.b.a(h.class)).g0();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.b.u.k.c().ensureNotReachHere(e, "execute sql failed when bindUploadSyncId");
        e.printStackTrace();
    }

    public boolean d(j r1) {
        o.g(r1, "obj");
        if (r1 != j.f6110j) goto L5;
        return true;
    L5:
        return false;
    }

    @VisibleForTesting
    public final z<List<String>, List<com.bytedance.sync.v2.presistence.d.c>, List<com.bytedance.sync.v2.presistence.d.a>> e(List<f> r10, com.bytedance.sync.v2.j.b r11) {
        o.g(r10, "topics");
        o.g(r11, "header");
        ArrayList r0 = new ArrayList(r.q(r10, 10));
        Iterator<T> r2 = r10.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(((f) r2.next()).f6076h);
        goto L4
    L6:
        Set r1 = r.D0(r0);
        ArrayList r3 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L7:
        boolean r4 = true;
        if (r12.hasNext() == false) goto L17;
        Object r5 = r12.next();
        f r6 = (f) r5;
        if (r6.f6076h == p.f6136i) goto L12;
    L15:
        if (r4 == false) goto L7;
        r3.add(r5);
        goto L7
    L12:
        if (r6.m == com.bytedance.sync.v2.j.o.f6129h) goto L15;
        r4 = false;
        goto L15
    L17:
        ArrayList r13 = new ArrayList(r.q(r3, 10));
        Iterator r7 = r3.iterator();
    L19:
        if (r7.hasNext() == false) goto L21;
        f r8 = (f) r7.next();
        r13.add(a0.a(String.valueOf(r8.f6077i.longValue()), r8));
        goto L19
    L21:
        Map r14 = m0.q(r13);
        Set r9 = r14.keySet();
        List<com.bytedance.sync.v2.presistence.d.c> r15 = ((com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class)).v(new d.b.u.c0.a.d(r11.f6037h, r11.f6036g));     // Catch: Exception -> L24
    L26:
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L28:
        if (r17.hasNext() == false) goto L32;
        Object r18 = r17.next();
        if (r1.contains(((com.bytedance.sync.v2.presistence.d.c) r18).f6232d) == false) goto L28;
        r16.add(r18);
        goto L28
    L32:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r16.iterator();
    L34:
        if (r20.hasNext() == false) goto L38;
        Object r21 = r20.next();
        if ((!r9.contains(((com.bytedance.sync.v2.presistence.d.c) r21).f6229a)) == false) goto L34;
        r19.add(r21);
        goto L34
    L38:
        ArrayList r22 = new ArrayList(r.q(r19, 10));
        Iterator r23 = r19.iterator();
    L40:
        if (r23.hasNext() == false) goto L42;
        r22.add(((com.bytedance.sync.v2.presistence.d.c) r23.next()).f6229a);
        goto L40
    L42:
        ArrayList r24 = new ArrayList(r.q(r15, 10));
        Iterator<T> r25 = r15.iterator();
    L44:
        if (r25.hasNext() == false) goto L46;
        com.bytedance.sync.v2.presistence.d.c r26 = (com.bytedance.sync.v2.presistence.d.c) r25.next();
        r24.add(a0.a(r26.f6229a, r26));
        goto L44
    L46:
        Map r27 = m0.q(r24);
        ArrayList r28 = new ArrayList();
        Iterator r29 = r14.entrySet().iterator();
    L48:
        if (r29.hasNext() == false) goto L54;
        Map.Entry r30 = (Map.Entry) r29.next();
        com.bytedance.sync.v2.presistence.d.c r31 = (com.bytedance.sync.v2.presistence.d.c) r27.get(r30.getKey());
        if (r31 != null) goto L53;
        r31 = new com.bytedance.sync.v2.presistence.d.c();
    L53:
        c(r31, (f) r30.getValue(), r11);
        r28.add(r31);
        goto L48
    L54:
        ArrayList r32 = new ArrayList();
        Iterator r110 = r14.values().iterator();
    L56:
        if (r110.hasNext() == false) goto L66;
        f r111 = (f) r110.next();
        List<com.bytedance.sync.v2.j.c> r33 = r111.f6080l;
        if (r33 == null) goto L56;
        Iterator<T> r34 = r33.iterator();
    L61:
        if (r34.hasNext() == false) goto L56;
        com.bytedance.sync.v2.j.c r35 = (com.bytedance.sync.v2.j.c) r34.next();
        if (r35 == null) goto L61;
        com.bytedance.sync.v2.presistence.d.a r36 = new com.bytedance.sync.v2.presistence.d.a();
        Integer r37 = r35.f6050g.f6061f;
        o.b(r37, "pkg.payload.business");
        r36.f6214a = r37.intValue();
        r36.f6216c = r111.f6075g;
        r36.f6215b = r35.f6050g.f6062g;
        r32.add(r36);
        goto L61
    L66:
        return new z(r22, r28, r32);
    L24:
        e = move-exception;
        e.printStackTrace();
        r15 = new ArrayList();
        goto L26
    }
}
