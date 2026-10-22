package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ArraysKt extends ArraysKt___ArraysKt {
    public static List b(Object[] r1) {
        Intrinsics.f(r1, "<this>");
        List r2 = Arrays.asList(r1);
        Intrinsics.e(r2, "asList(this)");
        return r2;
    }

    public static boolean c(byte r2) {
        Intrinsics.f(null, "<this>");
        o(r2);
        throw null;
    }

    public static boolean d(int r2) {
        Intrinsics.f(null, "<this>");
        p(r2);
        throw null;
    }

    public static boolean e(long r2) {
        Intrinsics.f(null, "<this>");
        q(r2);
        throw null;
    }

    public static boolean f(short r2) {
        Intrinsics.f(null, "<this>");
        r(r2);
        throw null;
    }

    public static void g(byte[] r1, int r2, byte[] r3, int r4, int r5) {
        Intrinsics.f(r1, "<this>");
        Intrinsics.f(r3, "destination");
        System.arraycopy(r1, r4, r3, r2, r5 - r4);
    }

    public static void h(Object[] r1, Object[] r2, int r3, int r4, int r5) {
        Intrinsics.f(r1, "<this>");
        Intrinsics.f(r2, "destination");
        System.arraycopy(r1, r4, r2, r3, r5 - r4);
    }

    public static /* synthetic */ void i(Object[] r2, Object[] r3, int r4, int r5, int r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = r2.length;
    L11:
        h(r2, r3, r4, r5, r6);
    }

    public static byte[] j(byte[] r1, int r2, int r3) {
        Intrinsics.f(r1, "<this>");
        ArraysKt__ArraysJVMKt.a(r3, r1.length);
        byte[] r4 = Arrays.copyOfRange(r1, r2, r3);
        Intrinsics.e(r4, "copyOfRange(this, fromIndex, toIndex)");
        return r4;
    }

    public static Object[] k(Object[] r1, int r2, int r3) {
        Intrinsics.f(r1, "<this>");
        ArraysKt__ArraysJVMKt.a(r3, r1.length);
        Object[] r4 = Arrays.copyOfRange(r1, r2, r3);
        Intrinsics.e(r4, "copyOfRange(this, fromIndex, toIndex)");
        return r4;
    }

    public static void l(Object r1, Object[] r2, int r3, int r4) {
        Intrinsics.f(r2, "<this>");
        Arrays.fill(r2, r3, r4, r1);
    }

    public static /* synthetic */ void m(Object[] r2, Object r3) {
        l(r3, r2, 0, r2.length);
    }

    public static Object n(Object[] r1, int r2) {
        if (r2 >= 0) goto L4;
    L6:
        return null;
    L4:
        if (r2 > (r1.length - 1)) goto L6;
        return r1[r2];
    }

    public static int o(byte r1) {
        Intrinsics.f(null, "<this>");
        throw null;
    }

    public static int p(int r1) {
        Intrinsics.f(null, "<this>");
        throw null;
    }

    public static int q(long r0) {
        Intrinsics.f(null, "<this>");
        throw null;
    }

    public static int r(short r1) {
        Intrinsics.f(null, "<this>");
        throw null;
    }

    public static int s(Object[] r3, Object r4) {
        Intrinsics.f(r3, "<this>");
        int r0 = 0;
        if (r4 != null) goto L10;
        int r5 = r3.length;
    L5:
        if (r0 >= r5) goto L16;
        if (r3[r0] == null) goto L22;
        r0 = r0 + 1;
        goto L5
    L22:
        return r0;
    L16:
        return -1;
    L10:
        int r1 = r3.length;
    L11:
        if (r0 >= r1) goto L16;
        if (r4.equals(r3[r0]) == true) goto L23;
        r0 = r0 + 1;
        goto L11
    L23:
        return r0;
    }

    public static char t(char[] r2) {
        int r0 = r2.length;
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L9;
        return r2[0];
    L9:
        throw new IllegalArgumentException("Array has more than one element.");
    L11:
        throw new NoSuchElementException("Array is empty.");
    }

    public static List u(Object[] r2) {
        Intrinsics.f(r2, "<this>");
        int r0 = r2.length;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return v(r2);
    L11:
        return CollectionsKt.j(r2[0]);
    L9:
        return EmptyList.b;
    }

    public static ArrayList v(Object[] r3) {
        Intrinsics.f(r3, "<this>");
        return new ArrayList(new ArrayAsCollection(r3, false));
    }
}
