package d.a.a.j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class g implements t, d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12480a = null;

    static {
        f12480a = new g();
    }

    private g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v28, types: [T, d.a.a.b, java.util.Collection] */
    @Override // d.a.a.i.q.f
    public <T> T a(d.a.a.i.b r2, Type r3, Object r4) {
        if (r2.f12388j.a0() != 8) goto L7;
        r2.f12388j.t(16);
        return null;
    L7:
        if (r3 != d.a.a.b.class) goto L10;
        ?? r1 = (T) new d.a.a.b();
        r2.O(r1);
        return r1;
    L10:
        Type r5 = r3;
    L12:
        if ((r5 instanceof Class) == true) goto L13;
        if ((r5 instanceof ParameterizedType) == false) goto L48;
        r5 = ((ParameterizedType) r5).getRawType();
        goto L12
    L48:
        throw new d.a.a.d("TODO");
    L13:
        Class r6 = (Class) r5;
        if (r6 != AbstractCollection.class) goto L16;
    L41:
        Collection r7 = (T) new ArrayList();
    L42:
        r2.N(d.a.a.k.d.v(r3), r7, r4);
        return (T) r7;
    L16:
        if (r6 == Collection.class) goto L41;
        if (r6.isAssignableFrom(HashSet.class) == false) goto L22;
        r7 = (T) new HashSet();
        goto L42
    L22:
        if (r6.isAssignableFrom(LinkedHashSet.class) == false) goto L25;
        r7 = (T) new LinkedHashSet();
        goto L42
    L25:
        if (r6.isAssignableFrom(TreeSet.class) == false) goto L28;
        r7 = (T) new TreeSet();
        goto L42
    L28:
        if (r6.isAssignableFrom(ArrayList.class) == false) goto L31;
        r7 = (T) new ArrayList();
        goto L42
    L31:
        if (r6.isAssignableFrom(EnumSet.class) == true) goto L33;
        r7 = (T) ((Collection) r6.newInstance());
    L40:
        throw new d.a.a.d("create instane error, class " + r6.getName());
    L33:
        if ((r3 instanceof ParameterizedType) == false) goto L35;
        Type r8 = ((ParameterizedType) r3).getActualTypeArguments()[0];
    L36:
        r7 = (T) EnumSet.noneOf((Class) r8);
        goto L42
    L35:
        r8 = Object.class;
        goto L36
    }

    @Override // d.a.a.j.t
    public void b(m r5, Object r6, Object r7, Type r8) {
        z r4 = r5.f12492b;
        if (r6 == null) goto L5;
        Type r0 = null;
        int r1 = r4.f12526h;
        a0 r2 = a0.t;
        if ((r1 & r2.f12471f) == 0) goto L12;
        r0 = d.a.a.k.d.v(r8);
    L12:
        Collection r9 = (Collection) r6;
        w r3 = r5.m;
        int r10 = 0;
        r5.p(r3, r6, r7, 0);
        if ((r4.f12526h & r2.f12471f) == 0) goto L46;
        if (HashSet.class != r9.getClass()) goto L19;
        String r11 = "Set";
    L17:
        r4.b(r11);
        goto L46
    L19:
        if (TreeSet.class != r9.getClass()) goto L46;
        r11 = "TreeSet";
    L46:
        r4.write(91);     // Catch: Throwable -> L43
        Iterator r12 = r9.iterator();     // Catch: Throwable -> L43
    L24:
        if (r12.hasNext() == false) goto L40;
        Object r13 = r12.next();     // Catch: Throwable -> L43
        int r14 = r10 + 1;     // Catch: Throwable -> L43
        if (r10 == 0) goto L28;
        r4.write(44);     // Catch: Throwable -> L43
    L28:
        if (r13 != null) goto L30;
        r4.Q();     // Catch: Throwable -> L43
    L39:
        r10 = r14;
        goto L24
    L30:
        Class<?> r15 = r13.getClass();     // Catch: Throwable -> L43
        if (r15 != Integer.class) goto L34;
        r4.L(((Integer) r13).intValue());     // Catch: Throwable -> L43
        goto L39
    L34:
        if (r15 != Long.class) goto L38;
        r4.O(((Long) r13).longValue());     // Catch: Throwable -> L43
        if ((r4.f12526h & a0.t.f12471f) == 0) goto L39;
        r4.write(76);     // Catch: Throwable -> L43
        goto L39
    L38:
        r5.f12491a.a(r15).b(r5, r13, Integer.valueOf(r14 - 1), r0);     // Catch: Throwable -> L43
        goto L39
    L40:
        r4.write(93);     // Catch: Throwable -> L43
        r5.m = r3;
        return;
    L43:
        th = move-exception;
        r5.m = r3;
        throw th;
    L5:
        if ((r4.f12526h & a0.f12470l.f12471f) == 0) goto L7;
        r4.write("[]");
        return;
    L7:
        r4.Q();
    }
}
