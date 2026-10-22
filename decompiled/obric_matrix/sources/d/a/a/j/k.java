package d.a.a.j;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class k implements t, d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f12490a;

    static {
        f12490a = new k();
    }

    private k() {
    }

    @Override // d.a.a.i.q.f
    public <T> T a(d.a.a.i.b r5, Type r6, Object r7) {
        d.a.a.i.e r0 = r5.f12388j;
        int r1 = r0.a0();
        if (r1 != 8) goto L7;
        r0.t(16);
        return null;
    L7:
        if (r1 != 2) goto L20;
        if (r6 == Long.TYPE) goto L17;
        if (r6 == Long.class) goto L17;
        T r4 = (T) Integer.valueOf(r0.j());
    L18:
        r0.t(16);
        return r4;
    L14:
        e = move-exception;
        throw new d.a.a.d("int value overflow, field : " + r7, e);
    L17:
        r4 = (T) Long.valueOf(r0.n());
        goto L18
    L20:
        if (r1 != 3) goto L27;
        BigDecimal r8 = r0.g();
        r0.t(16);
        if (r6 == Long.TYPE) goto L45;
        if (r6 == Long.class) goto L45;
        return (T) Integer.valueOf(r8.intValue());
    L45:
        return (T) Long.valueOf(r8.longValue());
    L27:
        Object r9 = r5.F();
    L35:
        e = move-exception;
        throw new d.a.a.d("cast error, field : " + r7 + ", value " + r9, e);
    L29:
        if (r6 == Long.TYPE) goto L33;
        if (r6 == Long.class) goto L33;
        T r10 = (T) d.a.a.k.d.n(r9);
    L40:
        return r10;
    L33:
        r10 = (T) d.a.a.k.d.p(r9);
        goto L40
    }

    @Override // d.a.a.j.t
    public void b(m r3, Object r4, Object r5, Type r6) {
        z r7 = r3.f12492b;
        Number r8 = (Number) r4;
        if (r8 != null) goto L10;
        if ((r7.f12526h & a0.n.f12471f) == 0) goto L7;
        r7.write(48);
        return;
    L7:
        r7.Q();
        return;
    L10:
        if ((r4 instanceof Long) == false) goto L12;
        r7.O(r8.longValue());
    L14:
        if ((r7.f12526h & a0.t.f12471f) == 0) goto L29;
        Class<?> r9 = r8.getClass();
        if (r9 != Byte.class) goto L20;
        int r2 = 66;
    L18:
        r7.write(r2);
        return;
    L20:
        if (r9 != Short.class) goto L22;
        r2 = 83;
        goto L18
    L22:
        if (r9 != Long.class) goto L32;
        long r10 = r8.longValue();
        if (r10 <= 2147483647L) goto L26;
        return;
    L26:
        if (r10 < (-2147483648L)) goto L34;
        if (r6 == Long.class) goto L35;
        r2 = 76;
        goto L18
    L35:
        return;
    L34:
        return;
    L32:
        return;
    L29:
        return;
    L12:
        r7.L(r8.intValue());
        goto L14
    }
}
