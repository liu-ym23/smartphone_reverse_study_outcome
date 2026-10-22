package kotlin.text;

import a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StringsKt extends StringsKt___StringsKt {
    public static String A(int r3, String r4) {
        if (r3 < 0) goto L22;
        if (r3 != 0) goto L6;
        return "";
    L6:
        if (r3 == 1) goto L20;
        int r2 = r4.length();
        if (r2 == 0) goto L26;
        if (r2 == 1) goto L15;
        StringBuilder r0 = new StringBuilder(r4.length() * r3);
        IntProgressionIterator r5 = new IntRange(1, r3, 1).a();
    L12:
        if (r5.e == false) goto L14;
        r5.nextInt();
        r0.append(r4);
        goto L12
    L14:
        String r1 = r0.toString();
        Intrinsics.e(r1, "{\n                    va…tring()\n                }");
        return r1;
    L15:
        int r6 = 0;
        char r7 = r4.charAt(0);
        char[] r8 = new char[r3];
    L16:
        if (r6 >= r3) goto L28;
        r8[r6] = r7;
        r6 = r6 + 1;
        goto L16
    L28:
        return new String(r8);
    L26:
        return "";
    L20:
        return r4.toString();
    L22:
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + r3 + '.').toString());
    }

    public static String B(String r7, String r8, String r9) {
        Intrinsics.f(r7, "<this>");
        int r1 = StringsKt__StringsKt.c(0, r7, r8, false);
        if (r1 < 0) goto L23;
        int r2 = r8.length();
        int r3 = 1;
        if (r2 < 1) goto L9;
        r3 = r2;
    L9:
        int r5 = r9.length() + (r7.length() - r2);
        if (r5 < 0) goto L19;
        StringBuilder r4 = new StringBuilder(r5);
        int r6 = 0;
    L12:
        r4.append(r7, r6, r1);
        r4.append(r9);
        r6 = r1 + r2;
        if (r1 >= r7.length()) goto L16;
        r1 = StringsKt__StringsKt.c(r1 + r3, r7, r8, false);
        if (r1 > 0) goto L12;
    L16:
        r4.append(r7, r6, r7.length());
        String r10 = r4.toString();
        Intrinsics.e(r10, "stringBuilder.append(this, i, length).toString()");
        return r10;
    L19:
        throw new OutOfMemoryError();
    L23:
        return r7;
    }

    public static List C(CharSequence r3, final char[] r4) {
        Intrinsics.f(r3, "<this>");
        final boolean r2 = false;
        if (r4.length == 1) goto L12;
        StringsKt__StringsKt.h(0);
        DelimitedRangesSequence r0 = new DelimitedRangesSequence(r3, 0, 0, new StringsKt__StringsKt$rangesDelimitedBy$1(r4, r2));
        ArrayList r1 = new ArrayList(CollectionsKt.e(new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(r0), 10));
        Iterator r5 = r0.iterator();
    L7:
        if (r5.hasNext() == false) goto L10;
        r1.add(StringsKt__StringsKt.k(r3, (IntRange) r5.next()));
        goto L7
    L10:
        return r1;
    L12:
        return StringsKt__StringsKt.i(0, r3, String.valueOf(r4[0]), false);
    }

    public static List D(CharSequence r3, String[] r4) {
        Intrinsics.f(r3, "<this>");
        if (r4.length != 1) goto L8;
        String r0 = r4[0];
        if (r0.length() == 0) goto L8;
        return StringsKt__StringsKt.i(0, r3, r0, false);
    L8:
        Sequence r5 = StringsKt__StringsKt.f(r3, r4, false, 0);
        ArrayList r1 = new ArrayList(CollectionsKt.e(new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(r5), 10));
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L13;
        r1.add(StringsKt__StringsKt.k(r3, (IntRange) r6.next()));
        goto L10
    L13:
        return r1;
    }

    public static boolean E(String r6, int r7, String r8, boolean r9) {
        Intrinsics.f(r6, "<this>");
        if (r9 == true) goto L6;
        return r6.startsWith(r8, r7);
    L6:
        return StringsKt__StringsJVMKt.a(r6, r7, r9, r8, 0, r8.length());
    }

    public static boolean F(String r6, String r7, boolean r8) {
        Intrinsics.f(r6, "<this>");
        Intrinsics.f(r7, "prefix");
        if (r8 == true) goto L6;
        return r6.startsWith(r7);
    L6:
        return StringsKt__StringsJVMKt.a(r6, 0, r8, r7, 0, r7.length());
    }

    public static String G(String r2, String r3) {
        int r0 = s(r2, r3, 0, false, 6);
        if (r0 == (-1)) goto L7;
        String r4 = r2.substring(r3.length() + r0, r2.length());
        Intrinsics.e(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        return r4;
    L7:
        return r2;
    }

    public static String H(String r3) {
        Intrinsics.f(r3, "<this>");
        Intrinsics.f(r3, "missingDelimiterValue");
        int r0 = v(r3, '.', 0, 6);
        if (r0 == (-1)) goto L7;
        String r4 = r3.substring(r0 + 1, r3.length());
        Intrinsics.e(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        return r4;
    L7:
        return r3;
    }

    public static Integer I(String r11) {
        CharsKt.c(10);
        int r1 = r11.length();
        if (r1 == 0) goto L42;
        int r3 = 0;
        char r4 = r11.charAt(0);
        int r6 = -2147483647;
        if (Intrinsics.h(r4, 48) >= 0) goto L16;
        int r5 = 1;
        if (r1 != 1) goto L11;
        return null;
    L11:
        if (r4 != '-') goto L14;
        r6 = Integer.MIN_VALUE;
        boolean r7 = true;
    L17:
        int r8 = -59652323;
    L18:
        if (r5 >= r1) goto L31;
        int r9 = Character.digit(r11.charAt(r5), 10);
        if (r9 < 0) goto L44;
        if (r3 >= r8) goto L27;
        if (r8 != (-59652323)) goto L45;
        r8 = r6 / 10;
        if (r3 >= r8) goto L27;
        return null;
    L45:
        return null;
    L27:
        int r10 = r3 * 10;
        if (r10 < (r6 + r9)) goto L47;
        r3 = r10 - r9;
        r5 = r5 + 1;
        goto L18
    L47:
        return null;
    L44:
        return null;
    L31:
        if (r7 == false) goto L34;
        Integer r12 = Integer.valueOf(r3);
    L41:
        return r12;
    L34:
        r12 = Integer.valueOf(-r3);
        goto L41
    L14:
        if (r4 != '+') goto L35;
        r7 = false;
        goto L17
    L35:
        return null;
    L16:
        r7 = false;
        r5 = 0;
        goto L17
    L42:
        return null;
    }

    public static CharSequence J(CharSequence r5) {
        Intrinsics.f(r5, "<this>");
        int r0 = r5.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r6 = CharsKt__CharJVMKt.a(r5.charAt(r4));
        if (r3 == false) goto L9;
        if (r6 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r6 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r5.subSequence(r2, r0 + 1);
    }

    public static String K(String r11) {
        Intrinsics.f(r11, "<this>");
        List r1 = StringsKt__StringsKt.e(r11);
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((!t((String) r4)) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        ArrayList r5 = new ArrayList(CollectionsKt.e(r2, 10));
        Iterator r6 = r2.iterator();
    L9:
        int r7 = 0;
        if (r6.hasNext() == false) goto L22;
        String r8 = (String) r6.next();
        int r9 = r8.length();
    L13:
        if (r7 >= r9) goto L18;
        if ((!CharsKt__CharJVMKt.a(r8.charAt(r7))) == true) goto L19;
        r7 = r7 + 1;
    L19:
        if (r7 != (-1)) goto L21;
        r7 = r8.length();
    L21:
        r5.add(Integer.valueOf(r7));
        goto L9
    L18:
        r7 = -1;
        goto L19
    L22:
        Iterator r10 = r5.iterator();
        if (r10.hasNext() == true) goto L25;
        Comparable r12 = null;
    L31:
        Integer r13 = (Integer) r12;
        if (r13 == null) goto L34;
        int r14 = r13.intValue();
    L35:
        int r15 = r11.length();
        r1.size();
        StringsKt__IndentKt$getIndentFunction$1 r16 = StringsKt__IndentKt$getIndentFunction$1.b;
        int r17 = CollectionsKt.f(r1);
        ArrayList r18 = new ArrayList();
        Iterator r19 = r1.iterator();
    L37:
        if (r19.hasNext() == false) goto L63;
        Object r20 = r19.next();
        int r21 = r7 + 1;
        if (r7 < 0) goto L61;
        String r22 = (String) r20;
        if (r7 == 0) goto L44;
        if (r7 == r17) goto L44;
    L46:
        Intrinsics.f(r22, "<this>");
        if (r14 < 0) goto L60;
        int r23 = r22.length();
        if (r14 > r23) goto L52;
        r23 = r14;
    L52:
        String r24 = r22.substring(r23);
        Intrinsics.e(r24, "this as java.lang.String).substring(startIndex)");
        String r25 = (String) r16.invoke(r24);
        if (r25 == null) goto L56;
        r22 = r25;
    L56:
        if (r22 == null) goto L58;
        r18.add(r22);
    L58:
        r7 = r21;
        goto L37
    L60:
        throw new IllegalArgumentException(a.f(r14, "Requested character count ", " is less than zero.").toString());
    L44:
        if (t(r22) == false) goto L46;
        r22 = null;
        goto L56
    L61:
        CollectionsKt.p();
        throw null;
    L63:
        StringBuilder r0 = new StringBuilder(r15);
        CollectionsKt.h(r18, r0);
        String r110 = r0.toString();
        Intrinsics.e(r110, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return r110;
    L34:
        r14 = 0;
        goto L35
    L25:
        r12 = (Comparable) r10.next();
    L27:
        if (r10.hasNext() == false) goto L31;
        Comparable r26 = (Comparable) r10.next();
        if (r12.compareTo(r26) <= 0) goto L27;
        r12 = r26;
        goto L27
    }

    public static String L(String r13) {
        Intrinsics.f(r13, "<this>");
        if ((!t("|")) == false) goto L40;
        List r1 = StringsKt__StringsKt.e(r13);
        int r14 = r13.length();
        r1.size();
        StringsKt__IndentKt$getIndentFunction$1 r2 = StringsKt__IndentKt$getIndentFunction$1.b;
        int r3 = CollectionsKt.f(r1);
        ArrayList r4 = new ArrayList();
        Iterator r5 = r1.iterator();
        int r6 = 0;
    L6:
        if (r5.hasNext() == false) goto L37;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        String r9 = null;
        if (r6 < 0) goto L35;
        String r10 = (String) r7;
        if (r6 == 0) goto L13;
        if (r6 == r3) goto L13;
    L15:
        int r11 = r10.length();
        int r12 = 0;
    L17:
        if (r12 >= r11) goto L22;
        if ((!CharsKt__CharJVMKt.a(r10.charAt(r12))) == true) goto L23;
        r12 = r12 + 1;
    L23:
        if (r12 != (-1)) goto L26;
    L28:
        if (r9 == null) goto L31;
        r9 = (String) r2.invoke(r9);
        if (r9 == null) goto L31;
    L32:
        if (r9 == null) goto L34;
        r4.add(r9);
    L34:
        r6 = r8;
    L31:
        r9 = r10;
        goto L32
    L26:
        if (E(r10, r12, "|", false) == false) goto L28;
        r9 = r10.substring("|".length() + r12);
        Intrinsics.e(r9, "this as java.lang.String).substring(startIndex)");
        goto L28
    L22:
        r12 = -1;
    L13:
        if (t(r10) == false) goto L15;
    L35:
        CollectionsKt.p();
        throw null;
    L37:
        StringBuilder r0 = new StringBuilder(r14);
        CollectionsKt.h(r4, r0);
        String r15 = r0.toString();
        Intrinsics.e(r15, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return r15;
    L40:
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static void l(StringBuilder r0, Object r1, Function1 r2) {
        if (r2 == null) goto L4;
        r0.append((CharSequence) r2.invoke(r1));
        return;
    L4:
        if (r1 != null) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L10;
        r0.append((CharSequence) r1);
        return;
    L10:
        if ((r1 instanceof Character) == false) goto L12;
        r0.append(((Character) r1).charValue());
        return;
    L12:
        r0.append(String.valueOf(r1));
        return;
    L6:
        r3 = r1 instanceof CharSequence;
        goto L7
    }

    public static boolean m(String r2, boolean r3, CharSequence r4) {
        Intrinsics.f(r4, "<this>");
        Intrinsics.f(r2, "other");
        if (s(r4, r2, 0, r3, 2) < 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean n(CharSequence r2, char r3) {
        Intrinsics.f(r2, "<this>");
        if (r(r2, r3, 0, false, 2) < 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean o(String r1, String r2) {
        Intrinsics.f(r1, "<this>");
        Intrinsics.f(r2, "suffix");
        return r1.endsWith(r2);
    }

    public static boolean p(String r0, String r1, boolean r2) {
        if (r0 != null) goto L6;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L6:
        if (r2 == true) goto L9;
        return r0.equals(r1);
    L9:
        return r0.equalsIgnoreCase(r1);
    }

    public static int q(CharSequence r1) {
        Intrinsics.f(r1, "<this>");
        return r1.length() - 1;
    }

    public static int r(CharSequence r2, char r3, int r4, boolean r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = false;
    L8:
        Intrinsics.f(r2, "<this>");
        if (r5 == true) goto L15;
        if ((r2 instanceof String) == false) goto L15;
        return ((String) r2).indexOf(r3, r4);
    L15:
        return StringsKt__StringsKt.d(r2, new char[]{r3}, r4, r5);
    }

    public static /* synthetic */ int s(CharSequence r2, String r3, int r4, boolean r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r5 = false;
    L9:
        return StringsKt__StringsKt.c(r4, r2, r3, r5);
    }

    public static boolean t(CharSequence r4) {
        Intrinsics.f(r4, "<this>");
        if (r4.length() == 0) goto L19;
        Iterable r0 = new IntRange(0, r4.length() - 1, 1);
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator<Integer> r1 = r0.iterator();
    L11:
        if (((IntProgressionIterator) r1).hasNext() == false) goto L21;
        if (CharsKt__CharJVMKt.a(r4.charAt(((IntIterator) r1).nextInt())) == true) goto L11;
        return false;
    L21:
        return true;
    L7:
        if (((Collection) r0).isEmpty() == false) goto L9;
        return true;
    L19:
        return true;
    }

    public static int u(int r1, String r2, String r3) {
        if ((r1 & 2) == 0) goto L5;
        int r4 = q(r2);
    L6:
        Intrinsics.f(r2, "<this>");
        Intrinsics.f(r3, "string");
        return r2.lastIndexOf(r3, r4);
    L5:
        r4 = 0;
        goto L6
    }

    public static int v(CharSequence r3, char r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L5;
        r5 = q(r3);
    L5:
        Intrinsics.f(r3, "<this>");
        if ((r3 instanceof String) == true) goto L19;
        char[] r7 = {r4};
        if ((r3 instanceof String) == true) goto L23;
        int r8 = q(r3);
        if (r5 <= r8) goto L13;
        r5 = r8;
    L13:
        if ((-1) >= r5) goto L25;
        if (CharsKt__CharKt.b(r7[0], r3.charAt(r5), false) == true) goto L24;
        r5 = r5 - 1;
        goto L13
    L24:
        return r5;
    L25:
        return -1;
    L23:
        return ((String) r3).lastIndexOf(ArraysKt.t(r7), r5);
    L19:
        return ((String) r3).lastIndexOf(r4, r5);
    }

    public static /* synthetic */ boolean w(String r6, int r7, String r8, int r9, int r10) {
        return StringsKt__StringsJVMKt.a(r6, r7, false, r8, r9, r10);
    }

    public static String x(String r1, String r2) {
        Intrinsics.f(r1, "<this>");
        if (StringsKt__StringsKt.j(r2, r1) == false) goto L6;
        String r3 = r1.substring(r2.length());
        Intrinsics.e(r3, "this as java.lang.String).substring(startIndex)");
        return r3;
    L6:
        return r1;
    }

    public static String y(String r2) {
        if (StringsKt__StringsKt.b("Client", r2) == false) goto L6;
        String r3 = r2.substring(0, r2.length() - "Client".length());
        Intrinsics.e(r3, "this as java.lang.String…ing(startIndex, endIndex)");
        return r3;
    L6:
        return r2;
    }

    public static String z(String r4) {
        Intrinsics.f(r4, "<this>");
        int r0 = r4.length();
        int r2 = "\"".length();
        if (r0 >= ("\"".length() + r2)) goto L5;
        return r4;
    L5:
        if (StringsKt__StringsKt.j("\"", r4) == true) goto L7;
        return r4;
    L7:
        if (StringsKt__StringsKt.b("\"", r4) == false) goto L12;
        String r5 = r4.substring("\"".length(), r4.length() - "\"".length());
        Intrinsics.e(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        return r5;
    L12:
        return r4;
    }
}
