package d.a.a.j;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class h implements t, d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12481a = null;

    static {
        f12481a = new h();
    }

    private h() {
    }

    @Override // d.a.a.i.q.f
    public <T> T a(d.a.a.i.b r2, Type r3, Object r4) {
        return (T) d(r2, r3, r4, null);
    }

    @Override // d.a.a.j.t
    public void b(m r18, Object r19, Object r20, Type r21) {
        z r2 = r18.f12492b;
        if (r19 != null) goto L7;
        r2.Q();
        return;
    L7:
        if ((r2.f12526h & a0.t.f12471f) == 0) goto L17;
        if (r19.getClass() == r21) goto L17;
        if (r19.getClass() != Date.class) goto L13;
        r2.write("new Date(");
        r2.O(((Date) r19).getTime());
        int r0 = 41;
    L14:
        r2.write(r0);
        return;
    L13:
        r2.write(123);
        r2.F("@type", false);
        r18.s(r19.getClass().getName());
        r2.write(44);
        r2.F("val", false);
        r2.O(((Date) r19).getTime());
        r0 = 125;
    L17:
        if ((r19 instanceof Calendar) == false) goto L19;
        Date r1 = ((Calendar) r19).getTime();
    L21:
        if ((r2.f12526h & a0.x.f12471f) == 0) goto L27;
        DateFormat r3 = r18.g();
        if (r3 != null) goto L25;
        r3 = new SimpleDateFormat(d.a.a.a.f12372i, r18.o);
        r3.setTimeZone(r18.n);
    L25:
        r2.S(r3.format(r1));
        return;
    L27:
        long r4 = r1.getTime();
        int r5 = r2.f12526h;
        if ((a0.f12469k.f12471f & r5) == 0) goto L46;
        a0 r6 = a0.f12466h;
        if ((r5 & r6.f12471f) == 0) goto L32;
        r2.write(39);
    L33:
        Calendar r7 = Calendar.getInstance(r18.n, r18.o);
        r7.setTimeInMillis(r4);
        int r8 = r7.get(1);
        int r9 = r7.get(2) + 1;
        int r10 = r7.get(5);
        int r11 = r7.get(11);
        int r12 = r7.get(12);
        int r13 = r7.get(13);
        int r14 = r7.get(14);
        if (r14 == 0) goto L36;
        char[] r15 = "0000-00-00T00:00:00.000".toCharArray();
        z.x(r14, 23, r15);
        z.x(r13, 19, r15);
        z.x(r12, 16, r15);
        z.x(r11, 13, r15);
        z.x(r10, 10, r15);
        z.x(r9, 7, r15);
        z.x(r8, 4, r15);
    L41:
        r2.write(r15);
        if ((r2.f12526h & r6.f12471f) == 0) goto L44;
        int r16 = 39;
    L45:
        r2.write(r16);
        return;
    L44:
        r16 = 34;
        goto L45
    L36:
        if (r13 != 0) goto L40;
        if (r12 != 0) goto L40;
        if (r11 != 0) goto L40;
        r15 = "0000-00-00".toCharArray();
        z.x(r10, 10, r15);
        z.x(r9, 7, r15);
        z.x(r8, 4, r15);
    L40:
        r15 = "0000-00-00T00:00:00".toCharArray();
        z.x(r13, 19, r15);
        z.x(r12, 16, r15);
        z.x(r11, 13, r15);
        z.x(r10, 10, r15);
        z.x(r9, 7, r15);
        z.x(r8, 4, r15);
        goto L41
    L32:
        r2.write(34);
        goto L33
    L46:
        r2.O(r4);
        return;
    L19:
        r1 = (Date) r19;
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.Calendar] */
    protected <T> T c(d.a.a.i.b r1, Type r2, Object r3, Object r4, String r5) {
        if (r4 != 0) goto L6;
        return null;
    L6:
        if ((r4 instanceof Date) == false) goto L9;
        return r4;
    L9:
        if ((r4 instanceof Number) == false) goto L13;
        return (T) new Date(((Number) r4).longValue());
    L13:
        if ((r4 instanceof String) == false) goto L39;
        String r6 = (String) r4;
        if (r6.length() != 0) goto L17;
        return null;
    L17:
        d.a.a.i.e r0 = new d.a.a.i.e(r6);
    L35:
        th = move-exception;
        r0.e();
        throw th;
    L19:
        if (r0.K(false) == false) goto L27;
        ?? r7 = (T) r0.o;
        if (r2 != Calendar.class) goto L24;
        r0.e();
        return r7;
    L24:
        T r8 = (T) r7.getTime();
        r0.e();
        return r8;
    L27:
        r0.e();
        if (r5 == null) goto L30;
        DateFormat r9 = new SimpleDateFormat(r5);
    L42:
        return (T) r9.parse(r6);
    L34:
        return (T) new Date(Long.parseLong(r6));
    L30:
        r9 = r1.s();
        goto L42
    L39:
        throw new d.a.a.d("parse error");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, java.util.Calendar] */
    public <T> T d(d.a.a.i.b r11, Type r12, Object r13, String r14) {
        d.a.a.i.e r0 = r11.f12388j;
        int r1 = r0.a0();
        if (r1 != 2) goto L7;
        Object r2 = Long.valueOf(r0.n());
        r0.t(16);
        Object r3 = r2;
    L5:
        Object r7 = r3;
    L51:
        T r10 = (T) c(r11, r12, r13, r7, r14);
        if (r12 == Calendar.class) goto L54;
        return r10;
    L54:
        if ((r10 instanceof Calendar) == false) goto L56;
        return r10;
    L56:
        Date r15 = (Date) r10;
        if (r15 != null) goto L59;
        return null;
    L59:
        ?? r16 = (T) Calendar.getInstance(r0.m, r0.n);
        r16.setTime(r15);
        return r16;
    L7:
        if (r1 != 4) goto L19;
        String r4 = r0.X();
        r0.t(16);
        r3 = r4;
        if ((r0.f12406c & d.a.a.i.d.f12402l.f12403f) == 0) goto L5;
        d.a.a.i.e r5 = new d.a.a.i.e(r4);
        Object r6 = r4;
        if (r5.K(true) == false) goto L17;
        ?? r8 = (T) r5.o;
        if (r12 != Calendar.class) goto L16;
        r5.e();
        return r8;
    L16:
        r6 = r8.getTime();
    L17:
        r5.e();
        r3 = r6;
        goto L5
    L19:
        if (r1 != 8) goto L22;
        r0.s();
        r7 = null;
        goto L51
    L22:
        if (r1 != 12) goto L39;
        r0.s();
        if (r0.a0() != 4) goto L37;
        if ("@type".equals(r0.X()) == false) goto L31;
        r0.s();
        r11.a(17);
        Type r9 = d.a.a.k.d.C(r0.X(), r11.f12385g.f12447c);
        if (r9 == null) goto L30;
        r12 = r9;
    L30:
        r11.a(4);
        r11.a(16);
    L31:
        r0.u(':');
        int r17 = r0.a0();
        if (r17 != 2) goto L35;
        long r18 = r0.n();
        r0.s();
        Object r19 = Long.valueOf(r18);
    L45:
        r11.a(13);
        r3 = r19;
        goto L5
    L35:
        throw new d.a.a.d("syntax error : " + d.a.a.i.f.a(r17));
    L37:
        throw new d.a.a.d("syntax error");
    L39:
        if (r11.o != 2) goto L50;
        r11.o = 0;
        r11.a(16);
        if (r0.a0() != 4) goto L49;
        if ("val".equals(r0.X()) == false) goto L47;
        r0.s();
        r11.a(17);
        r19 = r11.F();
        goto L45
    L47:
        throw new d.a.a.d("syntax error");
    L49:
        throw new d.a.a.d("syntax error");
    L50:
        r3 = r11.F();
        goto L5
    }
}
