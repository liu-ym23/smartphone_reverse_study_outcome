package d.a.a.j;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b implements t, d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12472a = null;

    static {
        f12472a = new b();
    }

    private b() {
    }

    private <T> T c(d.a.a.i.b r6, Class<?> r7, d.a.a.b r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        int r0 = r8.size();
        T r1 = (T) Array.newInstance(r7, r0);
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L19;
        Object r3 = r8.get(r2);
        if (r3 != r8) goto L11;
        Array.set(r1, r2, r1);
    L18:
        r2 = r2 + 1;
        goto L6
    L11:
        if (r7.isArray() == true) goto L13;
        r3 = d.a.a.k.d.a(r3, r7, r6.f12385g);
    L17:
        Array.set(r1, r2, r3);
        goto L18
    L13:
        if (r7.isInstance(r3) == true) goto L17;
        r3 = c(r6, r7, (d.a.a.b) r3);
        goto L17
    L19:
        r8.w(r1);
        r8.v(r7);
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.a.i.q.f
    public <T> T a(d.a.a.i.b r6, Type r7, Object r8) {
        d.a.a.i.e r0 = r6.f12388j;
        int r1 = r0.a0();
        if (r1 != 8) goto L7;
        r0.t(16);
        return null;
    L7:
        if (r7 != char[].class) goto L17;
        if (r1 != 4) goto L12;
        String r5 = r0.X();
        r0.t(16);
        return (T) r5.toCharArray();
    L12:
        if (r1 != 2) goto L16;
        Number r9 = r0.k();
        r0.t(16);
        return (T) r9.toString().toCharArray();
    L16:
        return (T) d.a.a.a.q(r6.F()).toCharArray();
    L17:
        if (r1 != 4) goto L20;
        T r10 = (T) r0.a();
        r0.t(16);
        return r10;
    L20:
        Class<?> r11 = ((Class) r7).getComponentType();
        d.a.a.b r2 = new d.a.a.b();
        r6.N(r11, r2, r8);
        return (T) c(r6, r11, r2);
    }

    @Override // d.a.a.j.t
    public final void b(m r9, Object r10, Object r11, Type r12) {
        z r8 = r9.f12492b;
        Object[] r13 = (Object[]) r10;
        if (r10 == null) goto L5;
        int r1 = r13.length;
        int r2 = r1 - 1;
        if (r2 != (-1)) goto L13;
        r8.b("[]");
        return;
    L13:
        w r0 = r9.m;
        int r3 = 0;
        r9.p(r0, r10, r11, 0);
        r8.write(91);     // Catch: Throwable -> L52
        if ((r8.f12526h & a0.s.f12471f) == 0) goto L24;
        r9.l();     // Catch: Throwable -> L52
        r9.m();     // Catch: Throwable -> L52
    L17:
        if (r3 >= r1) goto L21;
        if (r3 == 0) goto L20;
        r8.write(44);     // Catch: Throwable -> L52
        r9.m();     // Catch: Throwable -> L52
    L20:
        r9.r(r13[r3]);     // Catch: Throwable -> L52
        r3 = r3 + 1;     // Catch: Throwable -> L52
        goto L17
    L21:
        r9.d();     // Catch: Throwable -> L52
        r9.m();     // Catch: Throwable -> L52
        r8.write(93);     // Catch: Throwable -> L52
        r9.m = r0;
        return;
    L24:
        Class<?> r4 = null;
        t r5 = null;
    L25:
        if (r3 >= r2) goto L40;
        Object r6 = r13[r3];     // Catch: Throwable -> L52
        if (r6 != null) goto L29;
        r8.b("null,");     // Catch: Throwable -> L52
    L39:
        r3 = r3 + 1;     // Catch: Throwable -> L52
        goto L25
    L29:
        IdentityHashMap<Object, w> r7 = r9.f12502l;     // Catch: Throwable -> L52
        if (r7 != null) goto L32;
    L34:
        Class<?> r14 = r6.getClass();     // Catch: Throwable -> L52
        if (r14 != r4) goto L37;
        r5.b(r9, r6, null, null);     // Catch: Throwable -> L52
    L38:
        r8.write(44);     // Catch: Throwable -> L52
        goto L39
    L37:
        r5 = r9.f12491a.a(r14);     // Catch: Throwable -> L52
        r5.b(r9, r6, null, null);     // Catch: Throwable -> L52
        r4 = r14;
        goto L38
    L32:
        if (r7.containsKey(r6) == false) goto L34;
        r9.t(r6);     // Catch: Throwable -> L52
        goto L38
    L40:
        Object r15 = r13[r2];     // Catch: Throwable -> L52
        if (r15 != null) goto L43;
        r8.b("null]");     // Catch: Throwable -> L52
    L50:
        r9.m = r0;
        return;
    L43:
        IdentityHashMap<Object, w> r16 = r9.f12502l;     // Catch: Throwable -> L52
        if (r16 != null) goto L46;
    L48:
        r9.u(r15, Integer.valueOf(r2));     // Catch: Throwable -> L52
    L49:
        r8.write(93);     // Catch: Throwable -> L52
        goto L50
    L46:
        if (r16.containsKey(r15) == false) goto L48;
        r9.t(r15);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        r9.m = r0;
        throw th;
    L5:
        if ((r8.f12526h & a0.f12470l.f12471f) == 0) goto L7;
        r8.write("[]");
        return;
    L7:
        r8.Q();
    }
}
