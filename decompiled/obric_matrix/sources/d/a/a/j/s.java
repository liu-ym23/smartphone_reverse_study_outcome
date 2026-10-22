package d.a.a.j;

import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class s implements t, d.a.a.i.q.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f12511b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DecimalFormat f12512a;

    static {
        f12511b = new s();
    }

    private s() {
        this.f12512a = null;
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [T, java.math.BigDecimal] */
    @Override // d.a.a.i.q.f
    public <T> T a(d.a.a.i.b r7, Type r8, Object r9) {
        d.a.a.i.e r2 = r7.f12388j;
        int r3 = r2.a0();
        if (r3 != 2) goto L37;
        if (r8 == Double.TYPE) goto L34;
        if (r8 == Double.class) goto L34;
        if (r8 == Float.TYPE) goto L32;
        if (r8 == Float.class) goto L32;
        long r0 = r2.n();
        r2.t(16);
        if (r8 == Short.TYPE) goto L31;
        if (r8 == Short.class) goto L31;
        if (r8 == Byte.TYPE) goto L29;
        if (r8 == Byte.class) goto L29;
        if (r0 < (-2147483648L)) goto L27;
        if (r0 > 2147483647L) goto L27;
        return (T) Integer.valueOf((int) r0);
    L27:
        return (T) Long.valueOf(r0);
    L29:
        return (T) Byte.valueOf((byte) r0);
    L31:
        return (T) Short.valueOf((short) r0);
    L32:
        String r6 = r2.v();
        r2.t(16);
        return (T) Float.valueOf(Float.parseFloat(r6));
    L34:
        String r10 = r2.v();
        r2.t(16);
        return (T) Double.valueOf(Double.parseDouble(r10));
    L37:
        if (r3 == 3) goto L39;
        Object r11 = r7.F();
        if (r11 != null) goto L68;
        return null;
    L68:
        if (r8 == Double.TYPE) goto L92;
        if (r8 == Double.class) goto L92;
        if (r8 == Float.TYPE) goto L90;
        if (r8 == Float.class) goto L90;
        if (r8 == Short.TYPE) goto L88;
        if (r8 == Short.class) goto L88;
        if (r8 == Byte.TYPE) goto L86;
        if (r8 == Byte.class) goto L86;
        return (T) d.a.a.k.d.d(r11);
    L86:
        return (T) d.a.a.k.d.g(r11);
    L88:
        return (T) d.a.a.k.d.q(r11);
    L90:
        return (T) d.a.a.k.d.m(r11);
    L92:
        return (T) d.a.a.k.d.k(r11);
    L39:
        if (r8 == Double.TYPE) goto L61;
        if (r8 == Double.class) goto L61;
        if (r8 == Float.TYPE) goto L59;
        if (r8 == Float.class) goto L59;
        ?? r12 = (T) r2.g();
        r2.t(16);
        if (r8 == Short.TYPE) goto L58;
        if (r8 == Short.class) goto L58;
        if (r8 == Byte.TYPE) goto L56;
        if (r8 == Byte.class) goto L56;
        return r12;
    L56:
        return (T) Byte.valueOf(r12.byteValue());
    L58:
        return (T) Short.valueOf(r12.shortValue());
    L59:
        String r13 = r2.v();
        r2.t(16);
        return (T) Float.valueOf(Float.parseFloat(r13));
    L61:
        String r14 = r2.v();
        r2.t(16);
        return (T) Double.valueOf(Double.parseDouble(r14));
    }

    @Override // d.a.a.j.t
    public void b(m r3, Object r4, Object r5, Type r6) {
        z r7 = r3.f12492b;
        if (r4 != null) goto L10;
        if ((r7.f12526h & a0.n.f12471f) == 0) goto L7;
        r7.write(48);
        return;
    L7:
        r7.Q();
        return;
    L10:
        if ((r4 instanceof Float) == false) goto L24;
        float r2 = ((Float) r4).floatValue();
        if (Float.isNaN(r2) == false) goto L15;
    L13:
        r7.Q();
        return;
    L15:
        if (Float.isInfinite(r2) == true) goto L13;
        String r8 = Float.toString(r2);
        if (r8.endsWith(".0") == false) goto L20;
        r8 = r8.substring(0, r8.length() - 2);
    L20:
        r7.write(r8);
        if ((r7.f12526h & a0.t.f12471f) == 0) goto L42;
        r7.write(70);
        return;
    L42:
        return;
    L24:
        double r9 = ((Double) r4).doubleValue();
        if (Double.isNaN(r9) == false) goto L28;
    L26:
        r7.Q();
        return;
    L28:
        if (Double.isInfinite(r9) == true) goto L26;
        DecimalFormat r10 = this.f12512a;
        if (r10 != null) goto L35;
        String r11 = Double.toString(r9);
        if (r11.endsWith(".0") == false) goto L36;
        r11 = r11.substring(0, r11.length() - 2);
    L36:
        r7.b(r11);
        if ((r7.f12526h & a0.t.f12471f) == 0) goto L44;
        r7.write(68);
        return;
    L44:
        return;
    L35:
        r11 = r10.format(r9);
        goto L36
    }
}
