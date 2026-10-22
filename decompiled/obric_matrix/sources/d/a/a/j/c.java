package d.a.a.j;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
final class c implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f12474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f12475b;

    c(Class<?> r1, t r2) {
        this.f12474a = r1;
        this.f12475b = r2;
    }

    @Override // d.a.a.j.t
    public final void b(m r10, Object r11, Object r12, Type r13) {
        z r14 = r10.f12492b;
        if (r11 == null) goto L5;
        int r5 = 0;
        if ((r11 instanceof boolean[]) == false) goto L20;
        boolean[] r15 = (boolean[]) r11;
        r14.write(91);
    L13:
        if (r5 >= r15.length) goto L17;
        if (r5 == 0) goto L16;
        r14.write(44);
    L16:
        r14.C(r15[r5]);
        r5 = r5 + 1;
        goto L13
    L17:
        r14.write(93);
        return;
    L20:
        if ((r11 instanceof byte[]) == false) goto L24;
        r14.E((byte[]) r11);
        return;
    L24:
        if ((r11 instanceof char[]) == false) goto L28;
        r14.S(new String((char[]) r11));
        return;
    L28:
        if ((r11 instanceof double[]) == false) goto L47;
        double[] r16 = (double[]) r11;
        int r9 = r16.length - 1;
        if (r9 != (-1)) goto L33;
        r14.b("[]");
        return;
    L33:
        r14.write(91);
    L34:
        if (r5 >= r9) goto L40;
        double r0 = r16[r5];
        if (Double.isNaN(r0) == false) goto L38;
        r14.Q();
    L39:
        r14.write(44);
        r5 = r5 + 1;
        goto L34
    L38:
        r14.b(Double.toString(r0));
        goto L39
    L40:
        double r17 = r16[r9];
        if (Double.isNaN(r17) == false) goto L43;
        r14.Q();
    L44:
        r14.write(93);
        return;
    L43:
        r14.b(Double.toString(r17));
        goto L44
    L47:
        if ((r11 instanceof float[]) == false) goto L66;
        float[] r18 = (float[]) r11;
        int r19 = r18.length - 1;
        if (r19 != (-1)) goto L52;
        r14.b("[]");
        return;
    L52:
        r14.write(91);
    L53:
        if (r5 >= r19) goto L59;
        float r110 = r18[r5];
        if (Float.isNaN(r110) == false) goto L57;
        r14.Q();
    L58:
        r14.write(44);
        r5 = r5 + 1;
        goto L53
    L57:
        r14.b(Float.toString(r110));
        goto L58
    L59:
        float r20 = r18[r19];
        if (Float.isNaN(r20) == false) goto L62;
        r14.Q();
    L63:
        r14.write(93);
        return;
    L62:
        r14.b(Float.toString(r20));
        goto L63
    L66:
        if ((r11 instanceof int[]) == false) goto L76;
        int[] r111 = (int[]) r11;
        r14.write(91);
    L69:
        if (r5 >= r111.length) goto L73;
        if (r5 == 0) goto L72;
        r14.write(44);
    L72:
        r14.L(r111[r5]);
        r5 = r5 + 1;
        goto L69
    L73:
        r14.write(93);
        return;
    L76:
        if ((r11 instanceof long[]) == false) goto L86;
        long[] r112 = (long[]) r11;
        r14.write(91);
    L79:
        if (r5 >= r112.length) goto L83;
        if (r5 == 0) goto L82;
        r14.write(44);
    L82:
        r14.O(r112[r5]);
        r5 = r5 + 1;
        goto L79
    L83:
        r14.write(93);
        return;
    L86:
        if ((r11 instanceof short[]) == false) goto L95;
        short[] r113 = (short[]) r11;
        r14.write(91);
    L89:
        if (r5 >= r113.length) goto L93;
        if (r5 == 0) goto L92;
        r14.write(44);
    L92:
        r14.L(r113[r5]);
        r5 = r5 + 1;
        goto L89
    L93:
        r14.write(93);
        return;
    L95:
        Object[] r1 = (Object[]) r11;
        int r2 = r1.length;
        w r6 = r10.m;
        r10.p(r6, r11, r12, 0);
        r14.write(91);     // Catch: Throwable -> L117
    L97:
        if (r5 >= r2) goto L114;
        if (r5 == 0) goto L100;
        r14.write(44);     // Catch: Throwable -> L117
    L100:
        Object r114 = r1[r5];     // Catch: Throwable -> L117
        if (r114 != null) goto L109;
        if (r14.A(a0.m) == true) goto L105;
    L107:
        r14.b("null");     // Catch: Throwable -> L117
    L113:
        r5 = r5 + 1;     // Catch: Throwable -> L117
        goto L97
    L105:
        if ((r11 instanceof String[]) == false) goto L107;
        r14.S("");     // Catch: Throwable -> L117
        goto L113
    L109:
        if (r114.getClass() != this.f12474a) goto L112;
        t r4 = this.f12475b;     // Catch: Throwable -> L117
        Integer r7 = Integer.valueOf(r5);     // Catch: Throwable -> L117
    L111:
        r4.b(r10, r114, r7, null);     // Catch: Throwable -> L117
        goto L113
    L112:
        r4 = r10.f12491a.a(r114.getClass());     // Catch: Throwable -> L117
        r7 = Integer.valueOf(r5);     // Catch: Throwable -> L117
        goto L111
    L114:
        r14.write(93);     // Catch: Throwable -> L117
        r10.m = r6;
        return;
    L117:
        th = move-exception;
        r10.m = r6;
        throw th;
    L5:
        if ((r14.f12526h & a0.f12470l.f12471f) == 0) goto L7;
        r14.write("[]");
        return;
    L7:
        r14.Q();
    }
}
