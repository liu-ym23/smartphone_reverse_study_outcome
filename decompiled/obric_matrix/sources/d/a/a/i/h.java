package d.a.a.i;

import d.a.a.j.a0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Constructor<?> f12422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f12423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Constructor<?> f12424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Method f12425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final d.a.a.k.a[] f12426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final d.a.a.k.a[] f12427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final d.a.a.h.c f12428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f12429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f12430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f12431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f12432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f12433l;

    h(Class<?> r5, Constructor<?> r6, Constructor<?> r7, Method r8, d.a.a.k.a[] r9, d.a.a.k.a[] r10, d.a.a.h.c r11) {
        int r0 = 0;
        this.f12429h = false;
        this.f12422a = r6;
        this.f12424c = r7;
        this.f12425d = r8;
        this.f12426e = r9;
        this.f12428g = r11;
        String r12 = null;
        if (r11 == null) goto L14;
        String r1 = r11.typeName();
        if (r1.length() > 0) goto L8;
        r1 = r5.getName();
    L8:
        this.f12431j = r1;
        String r13 = r11.typeKey();
        if (r13.length() <= 0) goto L11;
        r12 = r13;
    L11:
        this.f12432k = r12;
        d[] r14 = r11.parseFeatures();
        int r15 = r14.length;
        int r2 = 0;
        int r3 = 0;
    L12:
        if (r2 >= r15) goto L15;
        r3 = r3 | r14[r2].f12403f;
        r2 = r2 + 1;
    L15:
        this.f12433l = r3;
        if (r11 == null) goto L23;
        d[] r16 = r11.parseFeatures();
        int r17 = r16.length;
        int r18 = 0;
        boolean r4 = false;
    L18:
        if (r18 >= r17) goto L24;
        if (r16[r18] != d.t) goto L22;
        r4 = true;
    L22:
        r18 = r18 + 1;
    L24:
        this.f12430i = r4;
        d.a.a.k.a[] r19 = c(r9, r10);
        if (Arrays.equals(r9, r19) == true) goto L28;
        r9 = r19;
    L28:
        this.f12427f = r9;
        if (r6 == null) goto L31;
        r0 = r6.getParameterTypes().length;
    L33:
        this.f12423b = r0;
        return;
    L31:
        if (r8 == null) goto L33;
        r0 = r8.getParameterTypes().length;
        goto L33
    L23:
        r4 = false;
        goto L24
    L14:
        this.f12431j = r5.getName();
        this.f12432k = null;
        r3 = 0;
        goto L15
    }

    static boolean a(List<d.a.a.k.a> r5, d.a.a.k.a r6, boolean r7) {
        if (r7 == true) goto L14;
        int r8 = r5.size();
        int r1 = 0;
    L4:
        if (r1 >= r8) goto L14;
        d.a.a.k.a r2 = r5.get(r1);
        if (r2.f12528f.equals(r6.f12528f) == false) goto L13;
        if (r2.o == false) goto L12;
        if (r6.o == false) goto L13;
    L12:
        return false;
    L13:
        r1 = r1 + 1;
    L14:
        r5.add(r6);
        return true;
    }

    public static h b(Class<?> r36, int r37, Type r38, boolean r39, boolean r40, boolean r41, boolean r42, d.a.a.g r43) {
        Class<? super Object> r15 = Object.class;
        ArrayList r10 = new ArrayList();
        HashMap r9 = new HashMap();
        int r0 = r37 & 1024;
        int r7 = 0;
        if (r0 == 0) goto L314;
        Constructor<?> r6 = null;
    L22:
        if (r39 == false) goto L24;
        Method r8 = null;
        Method[] r11 = null;
    L50:
        Field[] r5 = r36.getDeclaredFields();
        if (r36.isInterface() == true) goto L55;
        if (r0 != 0) goto L55;
        boolean r1 = false;
    L56:
        if (r6 == null) goto L60;
        if (r1 == true) goto L60;
        Field[] r16 = r5;
        HashMap r14 = r9;
        int r12 = 0;
    L129:
        if (r6 == null) goto L131;
        d.a.a.k.d.D(r36, r6, r37);
    L131:
        int r3 = 4;
        if (r39 == true) goto L209;
        int r2 = r11.length;
        int r4 = r12;
    L134:
        if (r4 >= r2) goto L209;
        Method r13 = r11[r4];
        String r17 = r13.getName();
        if (r17.length() < r3) goto L138;
        Class<?> r18 = r13.getReturnType();
        if (r18 == Void.TYPE) goto L144;
        if (r18 != r13.getDeclaringClass()) goto L138;
    L144:
        if (r13.getParameterTypes().length != 1) goto L138;
        if (r41 == false) goto L148;
        d.a.a.h.b r19 = (d.a.a.h.b) r13.getAnnotation(d.a.a.h.b.class);
    L149:
        if (r19 != null) goto L152;
        if (r41 == false) goto L152;
        r19 = d.a.a.k.d.z(r36, r13);
    L152:
        d.a.a.h.b r110 = r19;
        if (r110 != null) goto L155;
        int r20 = 0;
        int r23 = 0;
    L163:
        if (r17.startsWith("set") == true) goto L165;
    L164:
        r16 = r16;
        r14 = r14;
    L208:
        r4 = r4 + 1;
        r10 = r10;
        r6 = r6;
        r16 = r16;
        r14 = r14;
        r2 = r2;
        r15 = r15;
        r11 = r11;
        r3 = 4;
        goto L134
    L165:
        char r21 = r17.charAt(3);
        if (Character.isUpperCase(r21) == false) goto L172;
        if (d.a.a.k.d.f12543a == false) goto L170;
        String r22 = d.a.a.k.d.t(r17.substring(3));
    L183:
        Field r24 = d.a.a.k.d.w(r36, r22, r16, r14);
        if (r24 != null) goto L189;
        boolean r25 = false;
        if (r13.getParameterTypes()[0] != Boolean.TYPE) goto L188;
        StringBuilder r26 = new StringBuilder();
        r26.append("is");
        r26.append(Character.toUpperCase(r22.charAt(0)));
        boolean r27 = true;
        r26.append(r22.substring(1));
        r24 = d.a.a.k.d.w(r36, r26.toString(), r16, r14);
    L190:
        Field r28 = r24;
        if (r28 == null) goto L204;
        if (r41 == false) goto L194;
        d.a.a.h.b r29 = (d.a.a.h.b) r28.getAnnotation(d.a.a.h.b.class);
    L195:
        if (r29 == null) goto L204;
        int r30 = r29.ordinal();
        int r210 = a0.a(r29.serialzeFeatures());
        if (r29.name().length() == 0) goto L199;
        r16 = r16;
        r14 = r14;
        a(r10, new d.a.a.k.a(r29.name(), r13, r28, r36, r38, r30, r210, r110, r29, r42), r39);
        goto L208
    L199:
        int r31 = r30;
        if (r110 != null) goto L202;
        d.a.a.h.b r32 = r29;
    L203:
        int r33 = r210;
    L205:
        if (r43 == 0) goto L207;
        r22 = r43.a(r22);
    L207:
        a(r10, new d.a.a.k.a(r22, r13, null, r36, r38, r31, r33, r32, null, r42), r39);
        d.a.a.k.d.D(r36, r13, r37);
        goto L208
    L202:
        r32 = r110;
        goto L203
    L194:
        r29 = null;
    L204:
        r31 = r20;
        r32 = r110;
        r33 = r23;
        goto L205
    L188:
        r27 = true;
        goto L190
    L189:
        r27 = true;
        r25 = false;
        goto L190
    L170:
        r22 = Character.toLowerCase(r17.charAt(3)) + r17.substring(4);
        goto L183
    L172:
        if (r21 != '_') goto L176;
        r22 = r17.substring(4);
        goto L183
    L176:
        if (r21 != 'f') goto L179;
        r22 = r17.substring(3);
        goto L183
    L179:
        if (r17.length() < 5) goto L164;
        if (Character.isUpperCase(r17.charAt(4)) == false) goto L164;
        r22 = d.a.a.k.d.t(r17.substring(3));
        goto L183
    L155:
        if (r110.deserialize() == false) goto L138;
        int r211 = r110.ordinal();
        r23 = a0.a(r110.serialzeFeatures());
        if (r110.name().length() == 0) goto L160;
        r4 = r4;
        r2 = r2;
        r6 = r6;
        r15 = r15;
        r11 = r11;
        r14 = r14;
        r10 = r10;
        a(r10, new d.a.a.k.a(r110.name(), r13, null, r36, r38, r211, r23, r110, null, r42), r39);
        d.a.a.k.d.D(r36, r13, r37);
        goto L164
    L160:
        r20 = r211;
        goto L163
    L148:
        r19 = null;
    L138:
        r10 = r10;
    L209:
        Constructor<?> r111 = r6;
        Class<? super Object> r34 = r15;
        Method[] r35 = r11;
        ArrayList r112 = r10;
        Field[] r212 = r16;
        ArrayList r44 = new ArrayList(r212.length);
        int r45 = r212.length;
        int r46 = 0;
    L210:
        if (r46 >= r45) goto L229;
        Field r47 = r212[r46];
        int r48 = r47.getModifiers();
        if ((r48 & 8) != 0) goto L228;
        if ((r48 & 16) == 0) goto L226;
        Class<?> r49 = r47.getType();
        if (Map.class.isAssignableFrom(r49) == false) goto L219;
    L222:
        boolean r50 = true;
    L223:
        if (r50 == true) goto L226;
    L219:
        if (Collection.class.isAssignableFrom(r49) == true) goto L222;
        r50 = false;
    L226:
        if ((r47.getModifiers() & 1) == 0) goto L228;
        r44.add(r47);
    L228:
        r46 = r46 + 1;
        goto L210
    L229:
        Class<? super Object> r51 = r36.getSuperclass();
    L230:
        if (r51 == null) goto L254;
        Class<? super Object> r52 = r34;
        if (r51 == r52) goto L254;
        Field[] r53 = r51.getDeclaredFields();
        int r54 = r53.length;
        int r55 = 0;
    L234:
        if (r55 >= r54) goto L253;
        Field r56 = r53[r55];
        int r57 = r56.getModifiers();
        if ((r57 & 8) != 0) goto L252;
        if ((r57 & 16) == 0) goto L250;
        Class<?> r58 = r56.getType();
        if (Map.class.isAssignableFrom(r58) == false) goto L243;
    L246:
        boolean r59 = true;
    L247:
        if (r59 == true) goto L250;
    L243:
        if (Collection.class.isAssignableFrom(r58) == true) goto L246;
        r59 = false;
    L250:
        if ((r57 & 1) == 0) goto L252;
        r44.add(r56);
    L252:
        r55 = r55 + 1;
        goto L234
    L253:
        r51 = r51.getSuperclass();
        r34 = r52;
    L254:
        Iterator r113 = r44.iterator();
    L256:
        if (r113.hasNext() == false) goto L277;
        Field r60 = (Field) r113.next();
        String r61 = r60.getName();
        int r62 = r112.size();
        int r63 = 0;
        boolean r64 = false;
    L258:
        if (r63 >= r62) goto L263;
        if (((d.a.a.k.a) r112.get(r63)).f12528f.equals(r61) == false) goto L262;
        r64 = true;
    L262:
        r63 = r63 + 1;
        goto L258
    L263:
        if (r64 == true) goto L256;
        if (r41 == false) goto L267;
        d.a.a.h.b r65 = (d.a.a.h.b) r60.getAnnotation(d.a.a.h.b.class);
    L268:
        if (r65 == null) goto L273;
        int r66 = r65.ordinal();
        int r67 = a0.a(r65.serialzeFeatures());
        if (r65.name().length() == 0) goto L272;
        r61 = r65.name();
    L272:
        int r68 = r66;
        int r69 = r67;
    L274:
        if (r43 == 0) goto L276;
        r61 = r43.a(r61);
    L276:
        d.a.a.k.d.D(r36, r60, r37);
        a(r112, new d.a.a.k.a(r61, null, r60, r36, r38, r68, r69, null, r65, r42), r39);
        goto L256
    L273:
        r68 = 0;
        r69 = 0;
        goto L274
    L267:
        r65 = null;
        goto L268
    L277:
        if (r39 == true) goto L306;
        int r114 = r35.length;
        int r70 = 0;
    L279:
        if (r70 >= r114) goto L306;
        Method r71 = r35[r70];
        String r72 = r71.getName();
        if (r72.length() < 4) goto L305;
        if (r72.startsWith("get") == false) goto L305;
        if (Character.isUpperCase(r72.charAt(3)) == false) goto L305;
        if (r71.getParameterTypes().length != 0) goto L305;
        Class<?> r73 = r71.getReturnType();
        if (Collection.class.isAssignableFrom(r73) == false) goto L293;
    L294:
        if (r41 == false) goto L296;
        d.a.a.h.b r115 = (d.a.a.h.b) r71.getAnnotation(d.a.a.h.b.class);
    L297:
        if (r115 == null) goto L301;
        String r74 = r115.name();
        if (r74.length() <= 0) goto L301;
    L302:
        a(r112, new d.a.a.k.a(r74, r71, null, r36, r38, 0, 0, r115, null, r42), r39);
        d.a.a.k.d.D(r36, r71, r37);
    L301:
        r74 = Character.toLowerCase(r72.charAt(3)) + r72.substring(4);
        goto L302
    L296:
        r115 = null;
        goto L297
    L293:
        if (Map.class.isAssignableFrom(r73) == true) goto L294;
    L305:
        r70 = r70 + 1;
        r114 = r114;
    L306:
        int r75 = r112.size();
        d.a.a.k.a[] r76 = new d.a.a.k.a[r75];
        r112.toArray(r76);
        d.a.a.k.a[] r77 = new d.a.a.k.a[r75];
        System.arraycopy(r76, 0, r77, 0, r75);
        Arrays.sort(r77);
        if (r40 == false) goto L309;
        d.a.a.h.c r78 = (d.a.a.h.c) r36.getAnnotation(d.a.a.h.c.class);
    L311:
        return new h(r36, r111, null, r8, r76, r77, r78);
    L309:
        r78 = null;
    L60:
        Constructor<?>[] r79 = r36.getDeclaredConstructors();
        int r80 = r79.length;
        int r81 = 0;
    L61:
        if (r81 >= r80) goto L66;
        Constructor<?> r82 = r79[r81];
        Constructor<?>[] r116 = r79;
        if (((d.a.a.h.a) r82.getAnnotation(d.a.a.h.a.class)) != null) goto L67;
        r81 = r81 + 1;
        r79 = r116;
    L67:
        String r83 = "illegal json creator";
        if (r82 == null) goto L96;
        d.a.a.k.d.D(r36, r82, r37);
        Class<?>[] r84 = r82.getParameterTypes();
        if (r42 == false) goto L72;
        Type[] r117 = r82.getGenericParameterTypes();
    L73:
        int r118 = 0;
    L75:
        if (r118 >= r84.length) goto L90;
        Annotation[] r85 = r82.getParameterAnnotations()[r118];
        int r86 = r85.length;
        int r87 = 0;
    L77:
        if (r87 >= r86) goto L82;
        Annotation r88 = r85[r87];
        if ((r88 instanceof d.a.a.h.b) == true) goto L80;
        r87 = r87 + 1;
        goto L77
    L80:
        d.a.a.h.b r89 = (d.a.a.h.b) r88;
    L83:
        if (r89 == null) goto L89;
        Class<?> r90 = r84[r118];
        Type r119 = r117[r118];
        Field r91 = d.a.a.k.d.w(r36, r89.name(), r5, r9);
        if (r91 == null) goto L87;
        d.a.a.k.d.D(r36, r91, r37);
    L87:
        a(r10, new d.a.a.k.a(r89.name(), r36, r90, r119, r91, r89.ordinal(), a0.a(r89.serialzeFeatures())), r39);
        r118 = r118 + 1;
        r84 = r84;
        r83 = r83;
        r9 = r9;
        r82 = r82;
        r5 = r5;
        r117 = r117;
        goto L75
    L89:
        throw new d.a.a.d(r83);
    L82:
        r89 = null;
        goto L83
    L90:
        Constructor<?> r213 = r82;
        int r92 = r10.size();
        d.a.a.k.a[] r93 = new d.a.a.k.a[r92];
        r10.toArray(r93);
        d.a.a.k.a[] r94 = new d.a.a.k.a[r92];
        System.arraycopy(r93, 0, r94, 0, r92);
        Arrays.sort(r94);
        if (r40 == false) goto L93;
        d.a.a.h.c r95 = (d.a.a.h.c) r36.getAnnotation(d.a.a.h.c.class);
    L95:
        return new h(r36, null, r213, null, r93, r94, r95);
    L93:
        r95 = null;
        goto L95
    L72:
        r117 = r84;
        goto L73
    L96:
        Field[] r214 = r5;
        HashMap r120 = r9;
        r12 = 0;
        if (r8 == null) goto L127;
        d.a.a.k.d.D(r36, r8, r37);
        Class<?>[] r96 = r8.getParameterTypes();
        if (r96.length <= 0) goto L126;
        if (r42 == false) goto L102;
        Type[] r97 = r8.getGenericParameterTypes();
    L103:
        int r121 = 0;
    L105:
        if (r121 >= r96.length) goto L117;
        Annotation[] r98 = r8.getParameterAnnotations()[r121];
        int r99 = r98.length;
        int r100 = r12;
    L107:
        if (r100 >= r99) goto L112;
        Annotation r101 = r98[r100];
        if ((r101 instanceof d.a.a.h.b) == true) goto L110;
        r100 = r100 + 1;
        goto L107
    L110:
        d.a.a.h.b r102 = (d.a.a.h.b) r101;
    L113:
        if (r102 == null) goto L116;
        HashMap r122 = r120;
        Field[] r103 = r214;
        a(r10, new d.a.a.k.a(r102.name(), r36, r96[r121], r97[r121], d.a.a.k.d.w(r36, r102.name(), r103, r122), r102.ordinal(), a0.a(r102.serialzeFeatures())), r39);
        r121 = r121 + 1;
        r8 = r8;
        r120 = r122;
        r96 = r96;
        r12 = 0;
        r214 = r103;
        goto L105
    L116:
        throw new d.a.a.d("illegal json creator");
    L112:
        r102 = null;
        goto L113
    L117:
        Method r123 = r8;
        int r104 = r10.size();
        d.a.a.k.a[] r105 = new d.a.a.k.a[r104];
        r10.toArray(r105);
        d.a.a.k.a[] r106 = new d.a.a.k.a[r104];
        System.arraycopy(r105, 0, r106, 0, r104);
        Arrays.sort(r106);
        if (Arrays.equals(r105, r106) == false) goto L120;
        d.a.a.k.a[] r107 = r105;
    L121:
        if (r40 == false) goto L123;
        d.a.a.h.c r108 = (d.a.a.h.c) r36.getAnnotation(d.a.a.h.c.class);
    L125:
        return new h(r36, null, null, r123, r105, r107, r108);
    L123:
        r108 = null;
        goto L125
    L120:
        r107 = r106;
        goto L121
    L102:
        r97 = r96;
        goto L103
    L126:
        r14 = r120;
        r16 = r214;
        goto L129
    L127:
        r14 = r120;
        r16 = r214;
        if (r1 == true) goto L129;
        throw new d.a.a.d("default constructor not found. " + r36);
    L66:
        r82 = null;
    L55:
        r1 = true;
        goto L56
    L24:
        ArrayList r109 = new ArrayList();
        Class<?> r124 = r36;
        Method r125 = null;
    L25:
        if (r124 == null) goto L49;
        if (r124 == r15) goto L49;
        Method[] r126 = r124.getDeclaredMethods();
        int r127 = r126.length;
    L28:
        if (r7 >= r127) goto L48;
        Method r128 = r126[r7];
        Method[] r129 = r126;
        int r130 = r128.getModifiers();
        if ((r130 & 8) == 0) goto L38;
        if (r128.isAnnotationPresent(d.a.a.h.a.class) == false) goto L45;
        if (r125 != null) goto L36;
        r125 = r128;
    L47:
        r7 = r7 + 1;
        r126 = r129;
        goto L28
    L36:
        throw new d.a.a.d("multi-json creator");
    L45:
        Method r215 = r125;
    L46:
        r125 = r215;
        goto L47
    L38:
        if ((r130 & 2) != 0) goto L45;
        r215 = r125;
        if ((r130 & 256) != 0) goto L46;
        if ((r130 & 4) != 0) goto L46;
        r109.add(r128);
        goto L46
    L48:
        r124 = r124.getSuperclass();
        r7 = 0;
    L49:
        Method[] r131 = new Method[r109.size()];
        r109.toArray(r131);
        r11 = r131;
        r8 = r125;
        goto L50
    L314:
        Constructor<?> r132 = r36.getDeclaredConstructor(new Class[0]);     // Catch: Exception -> L6
    L7:
        if (r132 == null) goto L9;
    L20:
        r6 = r132;
        goto L22
    L9:
        if (r36.isMemberClass() == false) goto L20;
        if ((r37 & 8) != 0) goto L20;
        Constructor<?>[] r133 = r36.getDeclaredConstructors();
        int r134 = r133.length;
        int r135 = 0;
    L13:
        if (r135 >= r134) goto L20;
        Constructor<?> r136 = r133[r135];
        Class<?>[] r137 = r136.getParameterTypes();
        Constructor<?> r138 = r132;
        if (r137.length != 1) goto L19;
        if (r137[0].equals(r36.getDeclaringClass()) == false) goto L19;
        r6 = r136;
    L19:
        r135 = r135 + 1;
        r132 = r138;
    L6:
        r132 = null;
        goto L7
    }

    private d.a.a.k.a[] c(d.a.a.k.a[] r9, d.a.a.k.a[] r10) {
        d.a.a.h.c r0 = this.f12428g;
        if (r0 != null) goto L5;
        return r10;
    L5:
        String[] r1 = r0.orders();
        if (r1 != null) goto L8;
    L77:
        return r10;
    L8:
        if (r1.length == 0) goto L77;
        int r2 = 0;
    L11:
        if (r2 >= r1.length) goto L23;
        int r3 = 0;
    L14:
        if (r3 >= r10.length) goto L19;
        if (r10[r3].f12528f.equals(r1[r2]) == true) goto L17;
        r3 = r3 + 1;
        goto L14
    L17:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L21;
        r2 = r2 + 1;
        goto L11
    L21:
        boolean r5 = false;
    L24:
        if (r5 == true) goto L27;
        return r10;
    L27:
        if (r1.length != r9.length) goto L51;
        int r11 = 0;
    L30:
        if (r11 >= r1.length) goto L35;
        if (r10[r11].f12528f.equals(r1[r11]) == false) goto L33;
        r11 = r11 + 1;
        goto L30
    L33:
        boolean r12 = false;
    L36:
        if (r12 == false) goto L38;
        return r10;
    L38:
        d.a.a.k.a[] r13 = new d.a.a.k.a[r10.length];
        int r6 = 0;
    L40:
        if (r6 >= r1.length) goto L49;
        int r7 = 0;
    L43:
        if (r7 >= r10.length) goto L48;
        if (r10[r7].f12528f.equals(r1[r6]) == true) goto L46;
        r7 = r7 + 1;
        goto L43
    L46:
        r13[r6] = r10[r7];
    L48:
        r6 = r6 + 1;
        goto L40
    L49:
        this.f12429h = true;
        return r13;
    L35:
        r12 = true;
        goto L36
    L51:
        int r14 = r10.length;
        d.a.a.k.a[] r8 = new d.a.a.k.a[r14];
        int r15 = 0;
    L53:
        if (r15 >= r1.length) goto L62;
        int r16 = 0;
    L56:
        if (r16 >= r10.length) goto L61;
        if (r10[r16].f12528f.equals(r1[r15]) == true) goto L59;
        r16 = r16 + 1;
        goto L56
    L59:
        r8[r15] = r10[r16];
    L61:
        r15 = r15 + 1;
        goto L53
    L62:
        int r17 = r1.length;
        int r18 = 0;
    L64:
        if (r18 >= r10.length) goto L76;
        int r19 = 0;
    L66:
        if (r19 >= r14) goto L72;
        if (r19 >= r17) goto L72;
        if (r8[r18].b(r10[r19]) == true) goto L70;
        r19 = r19 + 1;
        goto L66
    L70:
        boolean r20 = true;
    L73:
        if (r20 == true) goto L75;
        r8[r17] = r10[r18];
        r17 = r17 + 1;
    L75:
        r18 = r18 + 1;
    L72:
        r20 = false;
        goto L73
    L76:
        this.f12429h = true;
        goto L77
    L19:
        r4 = false;
        goto L20
    L23:
        r5 = true;
        goto L24
    }
}
