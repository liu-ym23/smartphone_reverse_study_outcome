package d.a.a.i;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class j extends d.a.a.i.q.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Type f12435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.a.a.i.q.f f12436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f12437f;

    public j(m r1, Class<?> r2, d.a.a.k.a r3) {
        super(r2, r3, 14);
        Type r4 = r3.m;
        Class<?> r5 = r3.f12534l;
        if (r5.isArray() == false) goto L5;
        this.f12435d = r5.getComponentType();
        boolean r6 = true;
    L6:
        this.f12437f = r6;
        return;
    L5:
        this.f12435d = d.a.a.k.d.v(r4);
        r6 = false;
        goto L6
    }

    @Override // d.a.a.i.q.d
    public void b(b r6, Object r7, Type r8, Map<String, Object> r9) {
        e r0 = r6.f12388j;
        int r1 = r0.a0();
        if (r1 != 8) goto L5;
    L20:
        g(r7, null);
        r6.f12388j.s();
        return;
    L5:
        if (r1 != 4) goto L10;
        if (r0.X().length() == 0) goto L20;
    L10:
        if (this.f12437f == false) goto L12;
        d.a.a.b r2 = new d.a.a.b();
        r2.v(this.f12435d);
        d.a.a.b r3 = r2;
        List r4 = r2;
    L13:
        l r5 = r6.f12389k;
        r6.j0(r5, r7, this.f12460a.f12528f);
        h(r6, r8, r4);
        r6.k0(r5);
        Object r10 = r4;
        if (this.f12437f == false) goto L16;
        Object r11 = r4.toArray((Object[]) Array.newInstance((Class) this.f12435d, r4.size()));
        r3.w(r11);
        r10 = r11;
    L16:
        if (r7 != null) goto L18;
        r9.put(this.f12460a.f12528f, r10);
        return;
    L18:
        g(r7, r10);
        return;
    L12:
        r4 = new ArrayList();
        r3 = null;
        goto L13
    }

    final void h(b r18, Type r19, Collection r20) {
        Type r4 = this.f12435d;
        d.a.a.i.q.f r5 = this.f12436e;
        if ((r19 instanceof ParameterizedType) == false) goto L40;
        Class r9 = null;
        if ((r4 instanceof TypeVariable) == false) goto L22;
        TypeVariable r6 = (TypeVariable) r4;
        ParameterizedType r11 = (ParameterizedType) r19;
        if ((r11.getRawType() instanceof Class) == false) goto L9;
        r9 = (Class) r11.getRawType();
    L9:
        if (r9 == null) goto L16;
        int r12 = r9.getTypeParameters().length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L16;
        if (r9.getTypeParameters()[r13].getName().equals(r6.getName()) == true) goto L17;
        r13 = r13 + 1;
    L17:
        if (r13 == (-1)) goto L40;
        r4 = r11.getActualTypeArguments()[r13];
        if (r4.equals(this.f12435d) == true) goto L40;
        r5 = r18.f12385g.c(r4);
    L16:
        r13 = -1;
        goto L17
    L22:
        if ((r4 instanceof ParameterizedType) == false) goto L40;
        ParameterizedType r7 = (ParameterizedType) r4;
        Type[] r14 = r7.getActualTypeArguments();
        if (r14.length != 1) goto L40;
        if ((r14[0] instanceof TypeVariable) == false) goto L40;
        TypeVariable r15 = (TypeVariable) r14[0];
        ParameterizedType r16 = (ParameterizedType) r19;
        if ((r16.getRawType() instanceof Class) == false) goto L30;
        r9 = (Class) r16.getRawType();
    L30:
        if (r9 == null) goto L37;
        int r17 = r9.getTypeParameters().length;
        int r110 = 0;
    L32:
        if (r110 >= r17) goto L37;
        if (r9.getTypeParameters()[r110].getName().equals(r15.getName()) == true) goto L38;
        r110 = r110 + 1;
    L38:
        if (r110 == (-1)) goto L40;
        r14[0] = r16.getActualTypeArguments()[r110];
        r4 = new d.a.a.k.c(r14, r7.getOwnerType(), r7.getRawType());
    L37:
        r110 = -1;
    L40:
        e r8 = r18.f12388j;
        if (r5 != null) goto L43;
        r5 = r18.f12385g.c(r4);
        this.f12436e = r5;
    L43:
        int r0 = r8.f12404a;
        if (r0 == 14) goto L53;
        if (r0 != 12) goto L48;
        r20.add(r5.a(r18, r4, 0));
        return;
    L48:
        String r1 = "exepct '[', but " + f.a(r8.f12404a);
        if (r19 == null) goto L52;
        r1 = r1 + ", type : " + r19;
    L52:
        throw new d.a.a.d(r1);
    L53:
        int r2 = 0;
        char r3 = r8.f12407d;
        char r111 = 26;
        if (r3 != '[') goto L60;
        int r10 = r8.f12408e + 1;
        r8.f12408e = r10;
        if (r10 < r8.r) goto L58;
        char r21 = 26;
    L59:
        r8.f12407d = r21;
        r8.f12404a = 14;
    L75:
        int r22 = r8.f12404a;
        if (r22 == 16) goto L77;
        if (r22 == 15) goto L80;
        r20.add(r5.a(r18, r4, Integer.valueOf(r2)));
        if (r18.o != 1) goto L92;
        r18.g(r20);
    L92:
        if (r8.f12404a != 16) goto L111;
        char r23 = r8.f12407d;
        if (r23 != '[') goto L100;
        int r24 = r8.f12408e + 1;
        r8.f12408e = r24;
        if (r24 < r8.r) goto L98;
        char r25 = 26;
    L99:
        r8.f12407d = r25;
        r8.f12404a = 14;
        goto L111
    L98:
        r25 = r8.q.charAt(r24);
        goto L99
    L100:
        if (r23 != '{') goto L107;
        int r26 = r8.f12408e + 1;
        r8.f12408e = r26;
        if (r26 < r8.r) goto L104;
        char r27 = 26;
    L105:
        r8.f12407d = r27;
        r8.f12404a = 12;
        goto L111
    L104:
        r27 = r8.q.charAt(r26);
        goto L105
    L107:
        if (r23 != '\"') goto L109;
        r8.P();
        goto L111
    L109:
        r8.s();
    L111:
        r2 = r2 + 1;
        goto L75
    L80:
        if (r8.f12407d != ',') goto L86;
        int r28 = r8.f12408e + 1;
        r8.f12408e = r28;
        if (r28 >= r8.r) goto L85;
        r111 = r8.q.charAt(r28);
    L85:
        r8.f12407d = r111;
        r8.f12404a = 16;
        return;
    L86:
        r8.s();
        return;
    L77:
        r8.s();
        goto L75
    L58:
        r21 = r8.q.charAt(r10);
        goto L59
    L60:
        if (r3 != '{') goto L66;
        int r29 = r8.f12408e + 1;
        r8.f12408e = r29;
        if (r29 < r8.r) goto L64;
        char r30 = 26;
    L65:
        r8.f12407d = r30;
        r8.f12404a = 12;
        goto L75
    L64:
        r30 = r8.q.charAt(r29);
        goto L65
    L66:
        if (r3 != '\"') goto L69;
        r8.P();
        goto L75
    L69:
        if (r3 != ']') goto L77;
        int r31 = r8.f12408e + 1;
        r8.f12408e = r31;
        if (r31 < r8.r) goto L73;
        char r32 = 26;
    L74:
        r8.f12407d = r32;
        r8.f12404a = 15;
        goto L75
    L73:
        r32 = r8.q.charAt(r31);
        goto L74
    L112:
        r8.s();
        goto L75
    }
}
