package kotlin.i0;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2 = {"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/SetsKt")
class w0 extends v0 {
    public static <T> Set<T> f(Set<? extends T> r3, Iterable<? extends T> r4) {
        kotlin.n0.d.o.f(r3, "<this>");
        kotlin.n0.d.o.f(r4, "elements");
        Collection<?> r5 = p.a(r4, r3);
        if (r5.isEmpty() == false) goto L7;
        return r.D0(r3);
    L7:
        if ((r5 instanceof Set) == false) goto L15;
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        T r1 = r6.next();
        if (r5.contains(r1) == true) goto L10;
        r0.add(r1);
        goto L10
    L14:
        return r0;
    L15:
        LinkedHashSet r2 = new LinkedHashSet(r3);
        r2.removeAll(r5);
        return r2;
    }

    public static <T> Set<T> g(Set<? extends T> r6, T r7) {
        kotlin.n0.d.o.f(r6, "<this>");
        LinkedHashSet r0 = new LinkedHashSet(m0.d(r6.size()));
        Iterator<T> r8 = r6.iterator();
        boolean r2 = false;
    L4:
        if (r8.hasNext() == false) goto L12;
        T r3 = r8.next();
        boolean r4 = true;
        if (r2 == false) goto L8;
    L10:
        if (r4 == false) goto L4;
        r0.add(r3);
        goto L4
    L8:
        if (kotlin.n0.d.o.a(r3, r7) == false) goto L10;
        r2 = true;
        r4 = false;
        goto L10
    L12:
        return r0;
    }

    public static <T> Set<T> h(Set<? extends T> r2, Iterable<? extends T> r3) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.n0.d.o.f(r3, "elements");
        Integer r0 = u.r(r3);
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
        int r4 = r2.size() + r1;
    L6:
        LinkedHashSet r5 = new LinkedHashSet(m0.d(r4));
        r5.addAll(r2);
        r.v(r5, r3);
        return r5;
    L5:
        r4 = r2.size() * 2;
        goto L6
    }

    public static <T> Set<T> i(Set<? extends T> r2, T r3) {
        kotlin.n0.d.o.f(r2, "<this>");
        LinkedHashSet r0 = new LinkedHashSet(m0.d(r2.size() + 1));
        r0.addAll(r2);
        r0.add(r3);
        return r0;
    }
}
