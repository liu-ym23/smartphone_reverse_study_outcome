package kotlin.text;

import a.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TransformingSequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static boolean b(String r8, CharSequence r9) {
        Intrinsics.f(r9, "<this>");
        if ((r9 instanceof String) == false) goto L6;
        return StringsKt.o((String) r9, r8);
    L6:
        return g(r9, r9.length() - r8.length(), r8, 0, r8.length(), false);
    }

    public static final int c(int r10, CharSequence r11, String r12, boolean r13) {
        Intrinsics.f(r11, "<this>");
        Intrinsics.f(r12, "string");
        if (r13 == false) goto L5;
    L8:
        int r0 = r11.length();
        if (r10 >= 0) goto L11;
        r10 = 0;
    L11:
        int r2 = r11.length();
        if (r0 <= r2) goto L14;
        r0 = r2;
    L14:
        IntRange r3 = new IntRange(r10, r0, 1);
        boolean r14 = r11 instanceof String;
        int r1 = r3.e;
        int r4 = r3.c;
        int r5 = r3.b;
        if (r14 == true) goto L17;
    L27:
        if (r1 <= 0) goto L29;
        if (r5 > r4) goto L29;
    L32:
        if (g(r12, 0, r11, r5, r12.length(), r13) == true) goto L45;
        if (r5 == r4) goto L37;
        r5 = r5 + r1;
    L37:
        return -1;
    L45:
        return r5;
    L29:
        if (r1 >= 0) goto L37;
        if (r4 > r5) goto L37;
    L17:
        if ((r12 instanceof String) == false) goto L27;
        if (r1 <= 0) goto L20;
        if (r5 > r4) goto L20;
    L23:
        if (StringsKt__StringsJVMKt.a(r12, 0, r13, (String) r11, r5, r12.length()) == true) goto L45;
        if (r5 == r4) goto L37;
        r5 = r5 + r1;
    L20:
        if (r1 >= 0) goto L37;
        if (r4 > r5) goto L37;
    L5:
        if ((r11 instanceof String) == false) goto L8;
        return ((String) r11).indexOf(r12, r10);
    }

    public static final int d(CharSequence r6, char[] r7, int r8, boolean r9) {
        Intrinsics.f(r6, "<this>");
        if (r9 == true) goto L11;
        if (r7.length != 1) goto L11;
        if ((r6 instanceof String) == false) goto L11;
        return ((String) r6).indexOf(ArraysKt.t(r7), r8);
    L11:
        if (r8 >= 0) goto L13;
        r8 = 0;
    L13:
        IntProgressionIterator r10 = new IntRange(r8, StringsKt.q(r6), 1).a();
    L15:
        if (r10.e == false) goto L22;
        int r0 = r10.nextInt();
        char r1 = r6.charAt(r0);
        int r3 = r7.length;
        int r4 = 0;
    L17:
        if (r4 >= r3) goto L15;
        if (CharsKt__CharKt.b(r7[r4], r1, r9) == true) goto L20;
        r4 = r4 + 1;
        goto L17
    L20:
        return r0;
    L22:
        return -1;
    }

    public static final List e(final CharSequence r3) {
        Intrinsics.f(r3, "<this>");
        return SequencesKt.d(new TransformingSequence(f(r3, new String[]{"\r\n", "\n", "\r"}, false, 0), new StringsKt__StringsKt$splitToSequence$1(r3)));
    }

    public static Sequence f(CharSequence r2, String[] r3, final boolean r4, int r5) {
        h(r5);
        final List r6 = ArraysKt.b(r3);
        return new DelimitedRangesSequence(r2, 0, r5, new StringsKt__StringsKt$rangesDelimitedBy$2(r6, r4));
    }

    public static final boolean g(CharSequence r4, int r5, CharSequence r6, int r7, int r8, boolean r9) {
        Intrinsics.f(r4, "<this>");
        Intrinsics.f(r6, "other");
        if (r7 < 0) goto L18;
        if (r5 < 0) goto L18;
        if (r5 > (r4.length() - r8)) goto L18;
        if (r7 > (r6.length() - r8)) goto L18;
        int r1 = 0;
    L11:
        if (r1 >= r8) goto L16;
        if (CharsKt__CharKt.b(r4.charAt(r5 + r1), r6.charAt(r7 + r1), r9) == false) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static final void h(int r1) {
        if (r1 < 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(a.e(r1, "Limit must be non-negative, but was ").toString());
    }

    public static final List i(int r7, CharSequence r8, String r9, boolean r10) {
        h(r7);
        int r0 = 0;
        int r1 = c(0, r8, r9, r10);
        if (r1 == (-1)) goto L25;
        if (r7 == 1) goto L25;
        if (r7 <= 0) goto L9;
        boolean r4 = true;
    L10:
        int r6 = 10;
        if (r4 == false) goto L15;
        if (r7 > 10) goto L15;
        r6 = r7;
    L15:
        ArrayList r5 = new ArrayList(r6);
    L16:
        r5.add(r8.subSequence(r0, r1).toString());
        r0 = r9.length() + r1;
        if (r4 == true) goto L19;
    L20:
        r1 = c(r0, r8, r9, r10);
        if (r1 != (-1)) goto L16;
    L22:
        r5.add(r8.subSequence(r0, r8.length()).toString());
        return r5;
    L19:
        if (r5.size() == (r7 - 1)) goto L22;
    L9:
        r4 = false;
    L25:
        return CollectionsKt.j(r8.toString());
    }

    public static boolean j(String r6, CharSequence r7) {
        Intrinsics.f(r7, "<this>");
        if ((r7 instanceof String) == false) goto L6;
        return StringsKt.F((String) r7, r6, false);
    L6:
        return g(r7, 0, r6, 0, r6.length(), false);
    }

    public static final String k(CharSequence r1, IntRange r2) {
        Intrinsics.f(r1, "<this>");
        Intrinsics.f(r2, "range");
        int r0 = r2.c + 1;
        return r1.subSequence(r2.b, r0).toString();
    }
}
