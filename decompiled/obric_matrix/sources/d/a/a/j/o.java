package d.a.a.j;

import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class o implements t {
    public o() {
    }

    @Override // d.a.a.j.t
    public final void b(m r17, Object r18, Object r19, Type r20) {
        z r3 = r17.f12492b;
        int r6 = 1;
        if ((r3.f12526h & a0.t.f12471f) == 0) goto L5;
        boolean r4 = true;
    L6:
        Type r7 = null;
        if (r4 == false) goto L10;
        r7 = d.a.a.k.d.v(r20);
    L10:
        if (r18 == null) goto L12;
        List r9 = (List) r18;
        int r10 = r9.size();
        if (r10 != 0) goto L20;
        r3.b("[]");
        return;
    L20:
        w r8 = r17.m;
        if ((r3.f12526h & a0.u.f12471f) != 0) goto L104;
        r17.m = new w(r8, r18, r19, 0);
        if (r17.f12502l != null) goto L25;
        r17.f12502l = new IdentityHashMap();
    L25:
        r17.f12502l.put(r18, r17.m);
    L104:
    L101:
        th = move-exception;
        r17.m = r8;
        throw th;
    L27:
        if ((r3.f12526h & a0.s.f12471f) == 0) goto L46;
        r3.write(91);     // Catch: Throwable -> L101
        r17.l();     // Catch: Throwable -> L101
        int r5 = 0;
    L29:
        if (r5 >= r10) goto L43;
        Object r11 = r9.get(r5);     // Catch: Throwable -> L101
        if (r5 == 0) goto L33;
        r3.write(44);     // Catch: Throwable -> L101
    L33:
        r17.m();     // Catch: Throwable -> L101
        if (r11 == null) goto L41;
        IdentityHashMap<Object, w> r12 = r17.f12502l;     // Catch: Throwable -> L101
        if (r12 != null) goto L38;
    L40:
        t r13 = r17.f12491a.a(r11.getClass());     // Catch: Throwable -> L101
        r17.m = new w(r8, r18, r19, 0);     // Catch: Throwable -> L101
        r13.b(r17, r11, Integer.valueOf(r5), r7);     // Catch: Throwable -> L101
    L42:
        r5 = r5 + 1;     // Catch: Throwable -> L101
        goto L29
    L38:
        if (r12.containsKey(r11) == false) goto L40;
        r17.t(r11);     // Catch: Throwable -> L101
        goto L42
    L41:
        r17.f12492b.Q();     // Catch: Throwable -> L101
        goto L42
    L43:
        r17.d();     // Catch: Throwable -> L101
        r17.m();     // Catch: Throwable -> L101
        r3.write(93);     // Catch: Throwable -> L101
        r17.m = r8;
        return;
    L46:
        int r14 = r3.f12525g + 1;     // Catch: Throwable -> L101
        if (r14 > r3.f12524f.length) goto L49;
    L52:
        r3.f12524f[r3.f12525g] = '[';     // Catch: Throwable -> L101
        r3.f12525g = r14;     // Catch: Throwable -> L101
        int r15 = 0;
    L54:
        if (r15 >= r9.size()) goto L91;
        Object r16 = r9.get(r15);     // Catch: Throwable -> L101
        if (r15 == 0) goto L64;
        int r110 = r3.f12525g + 1;     // Catch: Throwable -> L101
        if (r110 > r3.f12524f.length) goto L60;
    L63:
        r3.f12524f[r3.f12525g] = ',';     // Catch: Throwable -> L101
        r3.f12525g = r110;     // Catch: Throwable -> L101
        goto L64
    L60:
        if (r3.f12527i != null) goto L62;
        r3.s(r110);     // Catch: Throwable -> L101
        goto L63
    L62:
        r3.flush();     // Catch: Throwable -> L101
        r110 = 1;
    L64:
        if (r16 != null) goto L66;
        r3.b("null");     // Catch: Throwable -> L101
    L90:
        r15 = r15 + 1;     // Catch: Throwable -> L101
        goto L54
    L66:
        Class<?> r111 = r16.getClass();     // Catch: Throwable -> L101
        if (r111 != Integer.class) goto L70;
        r3.L(((Integer) r16).intValue());     // Catch: Throwable -> L101
        goto L90
    L70:
        if (r111 != Long.class) goto L76;
        long r112 = ((Long) r16).longValue();     // Catch: Throwable -> L101
        if (r4 == false) goto L74;
        r3.O(r112);     // Catch: Throwable -> L101
        r3.write(76);     // Catch: Throwable -> L101
        goto L90
    L74:
        r3.O(r112);     // Catch: Throwable -> L101
        goto L90
    L76:
        if (r111 != String.class) goto L82;
        String r113 = (String) r16;     // Catch: Throwable -> L101
        if ((r3.f12526h & a0.f12466h.f12471f) == 0) goto L80;
        r3.X(r113);     // Catch: Throwable -> L101
        goto L90
    L80:
        r3.V(r113, 0, true);     // Catch: Throwable -> L101
        goto L90
    L82:
        if ((r3.f12526h & a0.u.f12471f) != 0) goto L84;
        r17.m = new w(r8, r18, r19, 0);     // Catch: Throwable -> L101
    L84:
        IdentityHashMap<Object, w> r114 = r17.f12502l;     // Catch: Throwable -> L101
        if (r114 != null) goto L87;
    L89:
        r17.f12491a.a(r16.getClass()).b(r17, r16, Integer.valueOf(r15), r7);     // Catch: Throwable -> L101
        goto L90
    L87:
        if (r114.containsKey(r16) == false) goto L89;
        r17.t(r16);     // Catch: Throwable -> L101
        goto L90
    L91:
        int r0 = r3.f12525g + 1;     // Catch: Throwable -> L101
        if (r0 > r3.f12524f.length) goto L94;
    L97:
        r6 = r0;
    L98:
        r3.f12524f[r3.f12525g] = ']';     // Catch: Throwable -> L101
        r3.f12525g = r6;     // Catch: Throwable -> L101
        r17.m = r8;
        return;
    L94:
        if (r3.f12527i != null) goto L96;
        r3.s(r0);     // Catch: Throwable -> L101
        goto L97
    L96:
        r3.flush();     // Catch: Throwable -> L101
        goto L98
    L49:
        if (r3.f12527i != null) goto L51;
        r3.s(r14);     // Catch: Throwable -> L101
        goto L52
    L51:
        r3.flush();     // Catch: Throwable -> L101
        r14 = 1;
        goto L52
    L12:
        if ((r3.f12526h & a0.f12470l.f12471f) == 0) goto L14;
        r3.write("[]");
        return;
    L14:
        r3.Q();
        return;
    L5:
        r4 = false;
        goto L6
    }
}
