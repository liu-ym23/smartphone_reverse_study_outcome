package kotlin.s0.w.d.l0.f.a0.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.i0.g0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
public class g implements kotlin.s0.w.d.l0.f.z.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f19884d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<String> f19885e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f19886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f19887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<kotlin.s0.w.d.l0.f.a0.a.e.c> f19888c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19889a = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.f.a0.a.e.c.EnumC0540c.values().length];
            r0[kotlin.s0.w.d.l0.f.a0.a.e.c.EnumC0540c.f19868g.ordinal()] = 1;
            r0[kotlin.s0.w.d.l0.f.a0.a.e.c.EnumC0540c.f19869h.ordinal()] = 2;
            r0[kotlin.s0.w.d.l0.f.a0.a.e.c.EnumC0540c.f19870i.ordinal()] = 3;
            f19889a = r0;
        }
    }

    static {
        String r1 = r.Z(r.j(new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f19884d = r1;
        List<String> r0 = r.j(new String[]{r1 + "/Any", r1 + "/Nothing", r1 + "/Unit", r1 + "/Throwable", r1 + "/Number", r1 + "/Byte", r1 + "/Double", r1 + "/Float", r1 + "/Int", r1 + "/Long", r1 + "/Short", r1 + "/Boolean", r1 + "/Char", r1 + "/CharSequence", r1 + "/String", r1 + "/Comparable", r1 + "/Enum", r1 + "/Array", r1 + "/ByteArray", r1 + "/DoubleArray", r1 + "/FloatArray", r1 + "/IntArray", r1 + "/LongArray", r1 + "/ShortArray", r1 + "/BooleanArray", r1 + "/CharArray", r1 + "/Cloneable", r1 + "/Annotation", r1 + "/collections/Iterable", r1 + "/collections/MutableIterable", r1 + "/collections/Collection", r1 + "/collections/MutableCollection", r1 + "/collections/List", r1 + "/collections/MutableList", r1 + "/collections/Set", r1 + "/collections/MutableSet", r1 + "/collections/Map", r1 + "/collections/MutableMap", r1 + "/collections/Map.Entry", r1 + "/collections/MutableMap.MutableEntry", r1 + "/collections/Iterator", r1 + "/collections/MutableIterator", r1 + "/collections/ListIterator", r1 + "/collections/MutableListIterator"});
        f19885e = r0;
        Iterable r2 = r.F0(r0);
        LinkedHashMap r3 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r.q(r2, 10)), 16));
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        g0 r5 = (g0) r4.next();
        r3.put((String) r5.d(), Integer.valueOf(r5.c()));
        goto L4
    }

    public g(String[] r2, Set<Integer> r3, List<kotlin.s0.w.d.l0.f.a0.a.e.c> r4) {
        o.f(r2, "strings");
        o.f(r3, "localNameIndices");
        o.f(r4, "records");
        this.f19886a = r2;
        this.f19887b = r3;
        this.f19888c = r4;
    }

    @Override // kotlin.s0.w.d.l0.f.z.c
    public String a(int r1) {
        return b(r1);
    }

    @Override // kotlin.s0.w.d.l0.f.z.c
    public String b(int r15) {
        kotlin.s0.w.d.l0.f.a0.a.e.c r0 = this.f19888c.get(r15);
        if (r0.P() == false) goto L6;
        String r14 = r0.I();
    L16:
        if (r0.K() < 2) goto L24;
        List<Integer> r16 = r0.L();
        o.e(r16, "substringIndexList");
        Integer r6 = r16.get(0);
        Integer r17 = r16.get(1);
        o.e(r6, "begin");
        if (r6.intValue() < 0) goto L24;
        int r7 = r6.intValue();
        o.e(r17, "end");
        if (r7 > r17.intValue()) goto L24;
        if (r17.intValue() > r14.length()) goto L24;
        o.e(r14, TypedValues.Custom.S_STRING);
        r14 = r14.substring(r6.intValue(), r17.intValue());
        o.e(r14, "this as java.lang.String…ing(startIndex, endIndex)");
    L24:
        String r8 = r14;
        if (r0.G() < 2) goto L27;
        List<Integer> r18 = r0.H();
        o.e(r18, "replaceCharList");
        Integer r19 = r18.get(0);
        Integer r110 = r18.get(1);
        o.e(r8, TypedValues.Custom.S_STRING);
        r8 = k.v(r8, (char) r19.intValue(), (char) r110.intValue(), false, 4, null);
    L27:
        String r9 = r8;
        kotlin.s0.w.d.l0.f.a0.a.e.c.EnumC0540c r111 = r0.D();
        if (r111 != null) goto L30;
        r111 = kotlin.s0.w.d.l0.f.a0.a.e.c.EnumC0540c.f19868g;
    L30:
        int r112 = a.f19889a[r111.ordinal()];
        if (r112 != 2) goto L33;
        o.e(r9, TypedValues.Custom.S_STRING);
        r9 = k.v(r9, '$', '.', false, 4, null);
    L40:
        o.e(r9, TypedValues.Custom.S_STRING);
        return r9;
    L33:
        if (r112 != 3) goto L40;
        if (r9.length() < 2) goto L38;
        o.e(r9, TypedValues.Custom.S_STRING);
        r9 = r9.substring(1, r9.length() - 1);
        o.e(r9, "this as java.lang.String…ing(startIndex, endIndex)");
    L38:
        String r10 = r9;
        o.e(r10, TypedValues.Custom.S_STRING);
        r9 = k.v(r10, '$', '.', false, 4, null);
        goto L40
    L6:
        if (r0.N() == false) goto L14;
        List<String> r1 = f19885e;
        int r4 = r1.size();
        int r5 = r0.E();
        if (r5 < 0) goto L11;
        if (r5 >= r4) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L14;
        r14 = r1.get(r0.E());
    L11:
        r11 = false;
    L14:
        r14 = this.f19886a[r15];
        goto L16
    }

    @Override // kotlin.s0.w.d.l0.f.z.c
    public boolean c(int r1) {
        return this.f19887b.contains(Integer.valueOf(r1));
    }
}
