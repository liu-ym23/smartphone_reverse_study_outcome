package d.a.a.j;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class e implements t, d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12478a = null;

    static {
        f12478a = new e();
    }

    private e() {
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.math.BigDecimal] */
    @Override // d.a.a.i.q.f
    public <T> T a(d.a.a.i.b r3, Type r4, Object r5) {
        d.a.a.i.e r2 = r3.f12388j;
        int r6 = r2.a0();
        if (r6 != 2) goto L11;
        if (r4 != BigInteger.class) goto L8;
        String r7 = r2.v();
        r2.t(16);
        return (T) new BigInteger(r7, 10);
    L8:
        T r8 = (T) r2.g();
        r2.t(16);
        return r8;
    L11:
        if (r6 != 3) goto L17;
        ?? r9 = (T) r2.g();
        r2.t(16);
        if (r4 == BigInteger.class) goto L15;
        return r9;
    L15:
        return (T) r9.toBigInteger();
    L17:
        Object r10 = r3.F();
        if (r10 != null) goto L22;
        return null;
    L22:
        if (r4 != BigInteger.class) goto L26;
        return (T) d.a.a.k.d.e(r10);
    L26:
        return (T) d.a.a.k.d.d(r10);
    }

    @Override // d.a.a.j.t
    public void b(m r1, Object r2, Object r3, Type r4) {
        z r0 = r1.f12492b;
        if (r2 != null) goto L10;
        if ((r0.f12526h & a0.n.f12471f) == 0) goto L7;
        r0.write(48);
        return;
    L7:
        r0.Q();
        return;
    L10:
        if ((r2 instanceof BigInteger) == false) goto L13;
        r0.write(((BigInteger) r2).toString());
        return;
    L13:
        BigDecimal r5 = (BigDecimal) r2;
        r0.write(r5.toString());
        if ((r0.f12526h & a0.t.f12471f) != 0) goto L16;
        return;
    L16:
        if (r4 != BigDecimal.class) goto L18;
        return;
    L18:
        if (r5.scale() != 0) goto L24;
        r0.write(46);
        return;
    }
}
