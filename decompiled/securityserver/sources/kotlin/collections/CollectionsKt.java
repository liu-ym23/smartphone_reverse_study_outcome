package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CollectionsKt extends CollectionsKt___CollectionsKt {
    public static void d(Collection r1, Iterable r2) {
        Intrinsics.f(r1, "<this>");
        Intrinsics.f(r2, "elements");
        if ((r2 instanceof Collection) == false) goto L5;
        r1.addAll((Collection) r2);
        return;
    L5:
        Iterator r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        r1.add(r3.next());
        goto L7
    }

    public static int e(Iterable r1, int r2) {
        Intrinsics.f(r1, "<this>");
        if ((r1 instanceof Collection) == true) goto L5;
        return r2;
    L5:
        return ((Collection) r1).size();
    }

    public static int f(List r1) {
        Intrinsics.f(r1, "<this>");
        return r1.size() - 1;
    }

    public static Object g(List r1, int r2) {
        Intrinsics.f(r1, "<this>");
        if (r2 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r2 > f(r1)) goto L7;
        return r1.get(r2);
    }

    public static /* synthetic */ void h(ArrayList r8, StringBuilder r9) {
        CollectionsKt___CollectionsKt.b(r8, r9, "\n", "", "", -1, "...", null);
    }

    public static String i(Iterable r8, String r9, String r10, String r11, Function1 r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r9 = ", ";
    L5:
        String r2 = r9;
        if ((r13 & 2) == 0) goto L8;
        String r3 = "";
    L10:
        if ((r13 & 4) == 0) goto L12;
        String r4 = "";
    L14:
        if ((r13 & 32) == 0) goto L16;
        r12 = null;
    L16:
        Intrinsics.f(r8, "<this>");
        Intrinsics.f(r2, "separator");
        Intrinsics.f(r3, "prefix");
        Intrinsics.f(r4, "postfix");
        StringBuilder r14 = new StringBuilder();
        CollectionsKt___CollectionsKt.b(r8, r14, r2, r3, r4, -1, "...", r12);
        String r15 = r14.toString();
        Intrinsics.e(r15, "joinTo(StringBuilder(), …ed, transform).toString()");
        return r15;
    L12:
        r4 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }

    public static List j(Object r1) {
        List r2 = Collections.singletonList(r1);
        Intrinsics.e(r2, "singletonList(element)");
        return r2;
    }

    public static List k(Object... r1) {
        Intrinsics.f(r1, "elements");
        if (r1.length <= 0) goto L6;
        return ArraysKt.b(r1);
    L6:
        return EmptyList.b;
    }

    public static ArrayList l(Object... r3) {
        Intrinsics.f(r3, "elements");
        if (r3.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(new ArrayAsCollection(r3, true));
    }

    public static List m(List r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L10;
        return r2;
    L10:
        return j(r2.get(0));
    L9:
        return EmptyList.b;
    }

    public static ArrayList n(Collection r3, Iterable r4) {
        Intrinsics.f(r3, "<this>");
        Intrinsics.f(r4, "elements");
        if ((r4 instanceof Collection) == false) goto L5;
        int r1 = r3.size();
        Collection r5 = (Collection) r4;
        ArrayList r0 = new ArrayList(r5.size() + r1);
        r0.addAll(r3);
        r0.addAll(r5);
        return r0;
    L5:
        ArrayList r2 = new ArrayList(r3);
        d(r2, r4);
        return r2;
    }

    public static List o(Iterable r3) {
        Intrinsics.f(r3, "<this>");
        boolean r0 = r3 instanceof Collection;
        if (r0 == true) goto L5;
    L7:
        if (r0 == false) goto L9;
        ArrayList r4 = r((Collection) r3);
    L10:
        Collections.reverse(r4);
        return r4;
    L9:
        ArrayList r1 = new ArrayList();
        CollectionsKt___CollectionsKt.c(r3, r1);
        r4 = r1;
        goto L10
    L5:
        if (((Collection) r3).size() > 1) goto L7;
        return q(r3);
    }

    public static void p() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static List q(Iterable r3) {
        Intrinsics.f(r3, "<this>");
        boolean r0 = r3 instanceof Collection;
        if (r0 == false) goto L15;
        Collection r1 = (Collection) r3;
        int r2 = r1.size();
        if (r2 == 0) goto L22;
        if (r2 == 1) goto L10;
        return r(r1);
    L10:
        if ((r3 instanceof List) == false) goto L12;
        Object r4 = ((List) r3).get(0);
    L21:
        return j(r4);
    L12:
        r4 = r3.iterator().next();
        goto L21
    L22:
        return EmptyList.b;
    L15:
        if (r0 == false) goto L17;
        ArrayList r5 = r((Collection) r3);
    L19:
        return m(r5);
    L17:
        ArrayList r6 = new ArrayList();
        CollectionsKt___CollectionsKt.c(r3, r6);
        r5 = r6;
        goto L19
    }

    public static ArrayList r(Collection r1) {
        Intrinsics.f(r1, "<this>");
        return new ArrayList(r1);
    }

    public static Set s(Iterable r5) {
        Intrinsics.f(r5, "<this>");
        boolean r0 = r5 instanceof Collection;
        EmptySet r1 = EmptySet.b;
        if (r0 == false) goto L13;
        Collection r2 = (Collection) r5;
        int r4 = r2.size();
        if (r4 == 0) goto L19;
        if (r4 == 1) goto L9;
        LinkedHashSet r3 = new LinkedHashSet(MapsKt.c(r2.size()));
        CollectionsKt___CollectionsKt.c(r5, r3);
        return r3;
    L9:
        if ((r5 instanceof List) == false) goto L11;
        Object r6 = ((List) r5).get(0);
    L12:
        Set r7 = Collections.singleton(r6);
        Intrinsics.e(r7, "singleton(element)");
        return r7;
    L11:
        r6 = r5.iterator().next();
        goto L12
    L19:
        return r1;
    L13:
        LinkedHashSet r8 = new LinkedHashSet();
        CollectionsKt___CollectionsKt.c(r5, r8);
        int r9 = r8.size();
        if (r9 == 0) goto L22;
        if (r9 != 1) goto L23;
        Set r10 = Collections.singleton(r8.iterator().next());
        Intrinsics.e(r10, "singleton(element)");
        return r10;
    L23:
        return r8;
    L22:
        return r1;
    }
}
