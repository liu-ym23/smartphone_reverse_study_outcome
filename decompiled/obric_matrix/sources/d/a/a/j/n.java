package d.a.a.j;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class n implements t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char[] f12503f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char[] f12504g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j[] f12505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j[] f12506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f12507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f12508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f12509e;

    static {
        f12503f = new char[]{'t', 'r', 'u', 'e'};
        f12504g = new char[]{'f', 'a', 'l', 's', 'e'};
    }

    public n(Class<?> r15, int r16, Map<String, String> r17, boolean r18, boolean r19, boolean r20, boolean r21, d.a.a.g r22) {
        this.f12507c = 0;
        String[] r2 = null;
        if (r19 == false) goto L5;
        d.a.a.h.c r3 = (d.a.a.h.c) r15.getAnnotation(d.a.a.h.c.class);
    L6:
        if (r3 == null) goto L33;
        this.f12507c = a0.a(r3.serialzeFeatures());
        String r4 = r3.typeName();
        if (r4.length() == 0) goto L33;
        Class<? super Object> r5 = r15.getSuperclass();
        String r6 = null;
    L11:
        if (r5 == null) goto L21;
        if (r5 == Object.class) goto L21;
        d.a.a.h.c r7 = (d.a.a.h.c) r5.getAnnotation(d.a.a.h.c.class);
        if (r7 == null) goto L21;
        r6 = r7.typeKey();
        if (r6.length() != 0) goto L21;
        r5 = r5.getSuperclass();
    L21:
        Class<?>[] r8 = r15.getInterfaces();
        int r9 = r8.length;
        int r10 = 0;
    L22:
        if (r10 >= r9) goto L29;
        d.a.a.h.c r11 = (d.a.a.h.c) r8[r10].getAnnotation(d.a.a.h.c.class);
        if (r11 == null) goto L28;
        r6 = r11.typeKey();
        if (r6.length() != 0) goto L29;
    L28:
        r10 = r10 + 1;
    L29:
        if (r6 != null) goto L31;
    L34:
        this.f12508d = r4;
        this.f12509e = r6;
        List<d.a.a.k.a> r12 = d.a.a.k.d.s(r15, r16, r18, r3, r17, false, r20, r21, r22);
        ArrayList r13 = new ArrayList();
        Iterator<d.a.a.k.a> r14 = r12.iterator();
    L36:
        if (r14.hasNext() == false) goto L38;
        r13.add(new j(r14.next()));
        goto L36
    L38:
        j[] r23 = (j[]) r13.toArray(new j[r13.size()]);
        this.f12505a = r23;
        if (r3 == null) goto L41;
        r2 = r3.orders();
    L41:
        if (r2 != null) goto L43;
    L49:
        j[] r24 = new j[r23.length];
        System.arraycopy(r23, 0, r24, 0, r23.length);
        Arrays.sort(r24);
        if (Arrays.equals(r24, r23) == false) goto L52;
        this.f12506b = r23;
        return;
    L52:
        this.f12506b = r24;
        return;
    L43:
        if (r2.length == 0) goto L49;
        List<d.a.a.k.a> r1 = d.a.a.k.d.s(r15, r16, r18, r3, r17, true, r20, r21, r22);
        ArrayList r25 = new ArrayList();
        Iterator<d.a.a.k.a> r26 = r1.iterator();
    L46:
        if (r26.hasNext() == false) goto L48;
        r25.add(new j(r26.next()));
        goto L46
    L48:
        this.f12506b = (j[]) r25.toArray(new j[r25.size()]);
        return;
    L31:
        if (r6.length() != 0) goto L34;
        r6 = null;
    L33:
        r4 = null;
        r6 = null;
        goto L34
    L5:
        r3 = null;
        goto L6
    }

    public n(Class<?> r10, d.a.a.g r11) {
        this(r10, r10.getModifiers(), null, false, true, true, true, r11);
    }

    @Override // d.a.a.j.t
    public void b(m r35, Object r36, Object r37, Type r38) {
        n r0 = this;
        Class<?> r5 = Boolean.TYPE;
        z r6 = r35.f12492b;
        if (r36 != null) goto L6;
        r6.Q();
        return;
    L6:
        w r7 = r35.m;
        if (r7 != null) goto L9;
    L10:
        IdentityHashMap<Object, w> r8 = r35.f12502l;
        if (r8 != null) goto L13;
    L16:
        int r9 = r6.f12526h;
        if ((a0.q.f12471f & r9) == 0) goto L19;
        j[] r10 = r0.f12506b;
    L20:
        w r11 = r35.m;
        if ((r9 & a0.u.f12471f) != 0) goto L26;
        r35.m = new w(r11, r36, r37, r0.f12507c);
        if (r35.f12502l != null) goto L25;
        r35.f12502l = new IdentityHashMap();
    L25:
        r35.f12502l.put(r36, r35.m);
    L26:
        int r12 = r0.f12507c;
        int r13 = a0.A.f12471f;
        if ((r12 & r13) == 0) goto L29;
    L32:
        boolean r14 = true;
    L33:
        if (r14 == false) goto L35;
        char r15 = '[';
    L36:
        if (r14 == false) goto L38;
        char r16 = ']';
    L370:
        int r17 = r6.f12525g + 1;     // Catch: Throwable -> L356 Exception -> L358
        if (r17 > r6.f12524f.length) goto L42;
    L45:
        r6.f12524f[r6.f12525g] = r15;     // Catch: Throwable -> L356 Exception -> L358
        r6.f12525g = r17;     // Catch: Throwable -> L356 Exception -> L358
        if (r10.length > 0) goto L48;
    L50:
        int r18 = r0.f12507c;     // Catch: Throwable -> L356 Exception -> L358
        int r19 = a0.t.f12471f;     // Catch: Throwable -> L356 Exception -> L358
        if ((r18 & r19) != 0) goto L61;
        int r110 = r6.f12526h;     // Catch: Throwable -> L356 Exception -> L358
        if ((r19 & r110) == 0) goto L60;
        if (r38 != null) goto L61;
        if ((r110 & a0.y.f12471f) == 0) goto L61;
        if (r35.m.f12513a != null) goto L61;
    L60:
        boolean r111 = false;
    L62:
        if (r111 == true) goto L64;
    L73:
        boolean r4 = false;
    L75:
        if (r4 == false) goto L77;
        char r20 = ',';
    L78:
        List<d> r112 = r35.f12493c;     // Catch: Throwable -> L356 Exception -> L358
        if (r112 == null) goto L84;
        Iterator<d> r113 = r112.iterator();     // Catch: Throwable -> L356 Exception -> L358
    L82:
        if (r113.hasNext() == false) goto L84;
        r20 = r113.next().d(r35, r36, r20);     // Catch: Throwable -> L356 Exception -> L358
    L84:
        if (r20 != ',') goto L86;
        boolean r21 = true;
    L87:
        int r114 = r6.f12526h;     // Catch: Throwable -> L356 Exception -> L358
        if ((a0.f12465g.f12471f & r114) != 0) goto L90;
    L92:
        boolean r115 = false;
    L94:
        if ((a0.f12466h.f12471f & r114) == 0) goto L96;
        boolean r116 = true;
    L98:
        if ((a0.C.f12471f & r114) == 0) goto L100;
        boolean r117 = true;
    L101:
        List<u> r118 = r35.f12495e;     // Catch: Throwable -> L356 Exception -> L358
        List<r> r119 = r35.f12497g;     // Catch: Throwable -> L356 Exception -> L358
        boolean r120 = r21;
        List<c0> r22 = r35.f12496f;     // Catch: Throwable -> L356 Exception -> L358
        List<v> r3 = r35.f12498h;     // Catch: Throwable -> L356 Exception -> L358
        char r121 = r16;
        int r23 = 0;
    L372:
    L354:
        e = e;
        w r2 = r11;
    L360:
        String r24 = "write javaBean error";
        if (r37 == null) goto L364;
        r24 = "write javaBean error, fieldName : " + r37;     // Catch: Throwable -> L365
    L365:
        th = th;
    L366:
        r35.m = r2;
        throw th;
    L364:
        throw new d.a.a.d(r24, e);     // Catch: Throwable -> L365
    L352:
        th = th;
        r2 = r11;
        goto L366
    L104:
        if (r23 >= r10.length) goto L328;
        j r122 = r10[r23];     // Catch: Throwable -> L352 Exception -> L354
        j[] r123 = r10;
        d.a.a.k.a r25 = r122.f12482f;     // Catch: Throwable -> L352 Exception -> L354
        int r26 = r23;
        Class<?> r27 = r25.f12534l;     // Catch: Throwable -> L352 Exception -> L354
        boolean r28 = r116;
        String r124 = r25.f12528f;     // Catch: Throwable -> L352 Exception -> L354
        boolean r29 = r115;
        boolean r210 = r117;
        if ((a0.p.f12471f & r6.f12526h) != 0) goto L108;
    L112:
        String r125 = r0.f12509e;     // Catch: Throwable -> L352 Exception -> L354
        if (r125 != null) goto L115;
    L117:
        if (r3 == null) goto L124;
        Iterator<v> r126 = r3.iterator();     // Catch: Throwable -> L352 Exception -> L354
    L120:
        if (r126.hasNext() == false) goto L124;
        if (r126.next().c(r35, r36, r124) == true) goto L120;
        boolean r127 = false;
    L125:
        if (r127 == true) goto L127;
    L126:
        r3 = r3;
        r22 = r22;
        List<r> r31 = r119;
    L231:
        List<u> r32 = r118;
    L327:
        r23 = r26 + 1;     // Catch: Throwable -> L352 Exception -> L354
        r0 = this;
        r10 = r123;
        r116 = r28;
        r115 = r29;
        r117 = r210;
        r3 = r3;
        r22 = r22;
        r119 = r31;
        r118 = r32;
        goto L372
    L127:
        Object r128 = null;
        if (r25.f12531i == true) goto L130;
        r128 = r122.b(r36);     // Catch: Throwable -> L352 Exception -> L354
    L139:
        long r211 = 0;
        boolean r129 = false;
        boolean r212 = true;
    L140:
        int r213 = 0;
        boolean r214 = false;
    L141:
        if (r118 == null) goto L159;
        if (r129 == true) goto L144;
    L152:
        Iterator<u> r1 = r118.iterator();     // Catch: Throwable -> L352 Exception -> L354
    L154:
        if (r1.hasNext() == false) goto L159;
        Iterator<u> r30 = r1;
        if (r1.next().b(r36, r124, r128) == false) goto L157;
        r1 = r30;
        goto L154
    L157:
        boolean r33 = false;
    L160:
        if (r33 == false) goto L126;
        if (r119 == null) goto L178;
        if (r129 == false) goto L174;
        if (r212 == true) goto L174;
        if (r27 != Integer.TYPE) goto L170;
        Object r34 = Integer.valueOf(r213);     // Catch: Throwable -> L352 Exception -> L354
    L168:
        r128 = r34;
        r212 = true;
        goto L174
    L170:
        if (r27 != Long.TYPE) goto L172;
        r34 = Long.valueOf(r211);     // Catch: Throwable -> L352 Exception -> L354
        goto L168
    L172:
        if (r27 != r5) goto L174;
        r34 = Boolean.valueOf(r214);     // Catch: Throwable -> L352 Exception -> L354
    L174:
        Iterator<r> r39 = r119.iterator();     // Catch: Throwable -> L352 Exception -> L354
        String r40 = r124;
    L176:
        if (r39.hasNext() == false) goto L179;
        r40 = r39.next().a(r36, r40, r128);     // Catch: Throwable -> L352 Exception -> L354
        r39 = r39;
    L179:
        if (r22 == null) goto L196;
        if (r129 == false) goto L191;
        if (r212 == true) goto L191;
        if (r27 != Integer.TYPE) goto L187;
        r128 = Integer.valueOf(r213);     // Catch: Throwable -> L352 Exception -> L354
    L185:
        r212 = true;
        goto L191
    L187:
        if (r27 != Long.TYPE) goto L189;
        r128 = Long.valueOf(r211);     // Catch: Throwable -> L352 Exception -> L354
        goto L185
    L189:
        if (r27 != r5) goto L191;
        r128 = Boolean.valueOf(r214);     // Catch: Throwable -> L352 Exception -> L354
    L191:
        Iterator<c0> r41 = r22.iterator();     // Catch: Throwable -> L352 Exception -> L354
        Object r42 = r128;
    L193:
        if (r41.hasNext() == false) goto L195;
        r42 = r41.next().a(r36, r124, r42);     // Catch: Throwable -> L352 Exception -> L354
        r41 = r41;
        goto L193
    L195:
        Object r43 = r128;
        r128 = r42;
    L197:
        if (r212 == false) goto L205;
        if (r128 != null) goto L205;
        if (r14 == true) goto L205;
        if (r122.f12483g == true) goto L205;
        r31 = r119;
        if ((r6.f12526h & a0.f12467i.f12471f) == 0) goto L231;
    L206:
        if (r212 == false) goto L232;
        if (r128 == null) goto L232;
        if (r210 == false) goto L232;
        if (r27 == Byte.TYPE) goto L222;
        if (r27 == Short.TYPE) goto L222;
        if (r27 == Integer.TYPE) goto L222;
        if (r27 == Long.TYPE) goto L222;
        if (r27 == Float.TYPE) goto L222;
        if (r27 == Double.TYPE) goto L222;
    L226:
        if (r27 != r5) goto L232;
        if ((r128 instanceof Boolean) == false) goto L232;
        if (((Boolean) r128).booleanValue() == true) goto L232;
    L222:
        if ((r128 instanceof Number) == false) goto L226;
        if (((Number) r128).byteValue() != 0) goto L226;
    L232:
        if (r120 == false) goto L242;
        int r44 = r6.f12525g + 1;     // Catch: Throwable -> L352 Exception -> L354
        if (r44 > r6.f12524f.length) goto L236;
    L239:
        r32 = r118;
        r6.f12524f[r6.f12525g] = ',';     // Catch: Throwable -> L352 Exception -> L354
        r6.f12525g = r44;     // Catch: Throwable -> L352 Exception -> L354
        if ((r6.f12526h & a0.s.f12471f) == 0) goto L243;
        r35.m();     // Catch: Throwable -> L352 Exception -> L354
    L243:
        if (r40 == r124) goto L248;
        if (r14 == true) goto L246;
        r6.F(r40, true);     // Catch: Throwable -> L352 Exception -> L354
    L246:
        r35.r(r128);     // Catch: Throwable -> L352 Exception -> L354
    L326:
        r120 = true;
        goto L327
    L248:
        if (r43 == r128) goto L251;
        if (r14 == true) goto L246;
        r122.c(r35);     // Catch: Throwable -> L352 Exception -> L354
        goto L246
    L251:
        if (r14 == true) goto L265;
        if (r29 == false) goto L264;
        char[] r45 = r122.f12486j;     // Catch: Throwable -> L352 Exception -> L354
        int r46 = r45.length;     // Catch: Throwable -> L352 Exception -> L354
        int r47 = r6.f12525g + r46;     // Catch: Throwable -> L352 Exception -> L354
        if (r47 > r6.f12524f.length) goto L256;
    L262:
        int r130 = 0;
    L263:
        System.arraycopy(r45, r130, r6.f12524f, r6.f12525g, r46);     // Catch: Throwable -> L352 Exception -> L354
        r6.f12525g = r47;     // Catch: Throwable -> L352 Exception -> L354
        goto L265
    L256:
        if (r6.f12527i != null) goto L258;
        r6.s(r47);     // Catch: Throwable -> L352 Exception -> L354
        goto L262
    L258:
        int r48 = 0;
    L259:
        char[] r131 = r6.f12524f;     // Catch: Throwable -> L352 Exception -> L354
        int r132 = r131.length;     // Catch: Throwable -> L352 Exception -> L354
        int r133 = r6.f12525g;     // Catch: Throwable -> L352 Exception -> L354
        int r134 = r132 - r133;     // Catch: Throwable -> L352 Exception -> L354
        System.arraycopy(r45, r48, r131, r133, r134);     // Catch: Throwable -> L352 Exception -> L354
        r6.f12525g = r6.f12524f.length;     // Catch: Throwable -> L352 Exception -> L354
        r6.flush();     // Catch: Throwable -> L352 Exception -> L354
        r46 = r46 - r134;     // Catch: Throwable -> L352 Exception -> L354
        r48 = r48 + r134;     // Catch: Throwable -> L352 Exception -> L354
        if (r46 > r6.f12524f.length) goto L259;
        r130 = r48;
        r47 = r46;
        goto L263
    L264:
        r122.c(r35);     // Catch: Throwable -> L352 Exception -> L354
    L265:
        if (r129 == false) goto L296;
        if (r212 == true) goto L296;
        if (r27 != Integer.TYPE) goto L290;
        int r135 = r213;
        if (r135 != Integer.MIN_VALUE) goto L272;
        r6.write("-2147483648");     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L272:
        if (r135 >= 0) goto L274;
        int r49 = -r135;
    L275:
        int r50 = 0;
    L276:
        int r51 = z.f12522k[r50];     // Catch: Throwable -> L352 Exception -> L354
        r50 = r50 + 1;     // Catch: Throwable -> L352 Exception -> L354
        if (r49 > r51) goto L276;
        if (r135 >= 0) goto L280;
        r50 = r50 + 1;     // Catch: Throwable -> L352 Exception -> L354
    L280:
        int r52 = r6.f12525g + r50;     // Catch: Throwable -> L352 Exception -> L354
        if (r52 > r6.f12524f.length) goto L283;
    L286:
        boolean r53 = false;
    L287:
        if (r53 == true) goto L326;
        z.x(r135, r52, r6.f12524f);     // Catch: Throwable -> L352 Exception -> L354
        r6.f12525g = r52;     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L283:
        if (r6.f12527i != null) goto L285;
        r6.s(r52);     // Catch: Throwable -> L352 Exception -> L354
        goto L286
    L285:
        char[] r54 = new char[r50];     // Catch: Throwable -> L352 Exception -> L354
        z.x(r135, r50, r54);     // Catch: Throwable -> L352 Exception -> L354
        r6.write(r54, 0, r50);     // Catch: Throwable -> L352 Exception -> L354
        r53 = true;
        goto L287
    L274:
        r49 = r135;
        goto L275
    L290:
        if (r27 != Long.TYPE) goto L292;
        r35.f12492b.O(r211);     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L292:
        if (r27 != r5) goto L326;
        if (r214 == false) goto L295;
        z r55 = r35.f12492b;     // Catch: Throwable -> L352 Exception -> L354
        char[] r56 = f12503f;     // Catch: Throwable -> L352 Exception -> L354
        r55.write(r56, 0, r56.length);     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L295:
        z r57 = r35.f12492b;     // Catch: Throwable -> L352 Exception -> L354
        char[] r58 = f12504g;     // Catch: Throwable -> L352 Exception -> L354
        r57.write(r58, 0, r58.length);     // Catch: Throwable -> L352 Exception -> L354
    L296:
        if (r14 == false) goto L298;
    L325:
        r122.g(r35, r128);     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L298:
        if (r27 != String.class) goto L312;
        if (r128 != null) goto L307;
        int r59 = r6.f12526h;     // Catch: Throwable -> L352 Exception -> L354
        int r60 = a0.m.f12471f;     // Catch: Throwable -> L352 Exception -> L354
        if ((r59 & r60) == 0) goto L303;
    L306:
        r6.S("");     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L303:
        if ((r122.f12484h & r60) != 0) goto L306;
        r6.Q();     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L307:
        String r136 = (String) r128;     // Catch: Throwable -> L352 Exception -> L354
        if (r28 == false) goto L310;
        r6.X(r136);     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L310:
        r6.V(r136, 0, true);     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L312:
        if (r25.r == false) goto L325;
        if (r128 != null) goto L315;
        r6.Q();     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L315:
        if ((r6.f12526h & a0.f12468j.f12471f) == 0) goto L323;
        String r61 = ((Enum) r128).toString();     // Catch: Throwable -> L352 Exception -> L354
        if ((r6.f12526h & a0.f12466h.f12471f) == 0) goto L319;
        boolean r137 = true;
    L320:
        if (r137 == false) goto L322;
        r6.X(r61);     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L322:
        r6.V(r61, 0, false);     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L319:
        r137 = false;
        goto L320
    L323:
        r6.L(((Enum) r128).ordinal());     // Catch: Throwable -> L352 Exception -> L354
        goto L326
    L236:
        if (r6.f12527i != null) goto L238;
        r6.s(r44);     // Catch: Throwable -> L352 Exception -> L354
        goto L239
    L238:
        r6.flush();     // Catch: Throwable -> L352 Exception -> L354
        r44 = 1;
        goto L239
    L242:
        r32 = r118;
    L205:
        r31 = r119;
        goto L206
    L196:
        r43 = r128;
        goto L197
    L178:
        r40 = r124;
        goto L179
    L144:
        if (r27 != Integer.TYPE) goto L148;
        r128 = Integer.valueOf(r213);     // Catch: Throwable -> L352 Exception -> L354
    L146:
        r212 = true;
        goto L152
    L148:
        if (r27 != Long.TYPE) goto L150;
        r128 = Long.valueOf(r211);     // Catch: Throwable -> L352 Exception -> L354
        goto L146
    L150:
        if (r27 != r5) goto L152;
        r128 = Boolean.valueOf(r214);     // Catch: Throwable -> L352 Exception -> L354
    L159:
        r33 = true;
        goto L160
    L130:
        if (r27 != Integer.TYPE) goto L133;
        r211 = 0;
        r212 = false;
        r214 = false;
        r213 = r25.f12530h.getInt(r36);     // Catch: Throwable -> L352 Exception -> L354
        r129 = true;
        goto L141
    L133:
        if (r27 != Long.TYPE) goto L135;
        r211 = r25.f12530h.getLong(r36);     // Catch: Throwable -> L352 Exception -> L354
        r129 = true;
        r212 = false;
        goto L140
    L135:
        if (r27 != r5) goto L137;
        r214 = r25.f12530h.getBoolean(r36);     // Catch: Throwable -> L352 Exception -> L354
        r211 = 0;
        r129 = true;
        r212 = false;
        r213 = 0;
        goto L141
    L137:
        r128 = r25.f12530h.get(r36);     // Catch: Throwable -> L352 Exception -> L354
    L124:
        r127 = true;
        goto L125
    L115:
        if (r125.equals(r124) == false) goto L117;
    L108:
        if (r25.f12530h == null) goto L112;
        if (r25.f12532j == false) goto L112;
    L328:
        j[] r138 = r10;
        List<a> r62 = r35.f12494d;     // Catch: Throwable -> L352 Exception -> L354
        if (r62 == null) goto L338;
        if (r120 == false) goto L332;
        char r139 = ',';
    L333:
        Iterator<a> r63 = r62.iterator();     // Catch: Throwable -> L352 Exception -> L354
    L335:
        if (r63.hasNext() == false) goto L338;
        r139 = r63.next().d(r35, r36, r139);     // Catch: Throwable -> L352 Exception -> L354
        goto L335
    L332:
        r139 = 0;
    L338:
        if (r138.length > 0) goto L340;
    L342:
        int r64 = r6.f12525g + 1;     // Catch: Throwable -> L352 Exception -> L354
        if (r64 > r6.f12524f.length) goto L345;
    L348:
        int r140 = r64;
    L349:
        r6.f12524f[r6.f12525g] = r121;     // Catch: Throwable -> L352 Exception -> L354
        r6.f12525g = r140;     // Catch: Throwable -> L352 Exception -> L354
        r35.m = r11;
        return;
    L345:
        if (r6.f12527i != null) goto L347;
        r6.s(r64);     // Catch: Throwable -> L352 Exception -> L354
        goto L348
    L347:
        r6.flush();     // Catch: Throwable -> L352 Exception -> L354
        r140 = 1;
        goto L349
    L340:
        if ((r6.f12526h & a0.s.f12471f) == 0) goto L342;
        r35.d();     // Catch: Throwable -> L352 Exception -> L354
        r35.m();     // Catch: Throwable -> L352 Exception -> L354
        goto L342
    L100:
        r117 = false;
        goto L101
    L96:
        r116 = false;
        goto L98
    L90:
        if ((a0.f12466h.f12471f & r114) != 0) goto L92;
        r115 = true;
        goto L94
    L86:
        r21 = false;
        goto L87
    L77:
        r20 = 0;
        goto L78
    L64:
        if (r36.getClass() == r38) goto L73;
        String r65 = r0.f12509e;     // Catch: Throwable -> L356 Exception -> L358
        if (r65 != null) goto L69;
        r65 = r35.f12491a.f12519b;     // Catch: Throwable -> L356 Exception -> L358
    L69:
        r6.F(r65, false);     // Catch: Throwable -> L356 Exception -> L358
        String r66 = r0.f12508d;     // Catch: Throwable -> L356 Exception -> L358
        if (r66 != null) goto L72;
        r66 = r36.getClass().getName();     // Catch: Throwable -> L356 Exception -> L358
    L72:
        r35.s(r66);     // Catch: Throwable -> L356 Exception -> L358
        r4 = true;
    L61:
        r111 = true;
        goto L62
    L48:
        if ((r6.f12526h & a0.s.f12471f) == 0) goto L50;
        r35.l();     // Catch: Throwable -> L356 Exception -> L358
        r35.m();     // Catch: Throwable -> L356 Exception -> L358
        goto L50
    L42:
        if (r6.f12527i != null) goto L44;
        r6.s(r17);     // Catch: Throwable -> L356 Exception -> L358
        goto L45
    L44:
        r6.flush();     // Catch: Throwable -> L356 Exception -> L358
        r17 = 1;
    L358:
        e = e;
        r2 = r11;
    L356:
        th = th;
        r2 = r11;
        goto L366
    L38:
        r16 = '}';
        goto L370
    L35:
        r15 = '{';
        goto L36
    L29:
        if ((r6.f12526h & r13) != 0) goto L32;
        r14 = false;
        goto L33
    L19:
        r10 = r0.f12505a;
        goto L20
    L13:
        if (r8.containsKey(r36) == false) goto L16;
        r35.t(r36);
        return;
    L9:
        if ((r7.f12516d & a0.u.f12471f) != 0) goto L16;
        goto L10
    }
}
