package kotlin.u0;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class s extends r {
    public static Integer i(String r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return j(r1, 10);
    }

    public static final Integer j(String r10, int r11) {
        kotlin.n0.d.o.f(r10, "<this>");
        a.a(r11);
        int r0 = r10.length();
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r2 = 0;
        char r3 = r10.charAt(0);
        int r5 = -2147483647;
        int r6 = 1;
        if (kotlin.n0.d.o.h(r3, 48) >= 0) goto L16;
        if (r0 != 1) goto L10;
        return null;
    L10:
        if (r3 != '-') goto L13;
        r5 = Integer.MIN_VALUE;
        boolean r4 = true;
    L17:
        int r7 = -59652323;
    L18:
        if (r6 >= r0) goto L31;
        int r8 = b.b(r10.charAt(r6), r11);
        if (r8 < 0) goto L21;
        if (r2 >= r7) goto L27;
        if (r7 != (-59652323)) goto L26;
        r7 = r5 / r11;
        if (r2 >= r7) goto L27;
    L26:
        return null;
    L27:
        int r9 = r2 * r11;
        if (r9 < (r5 + r8)) goto L29;
        r2 = r9 - r8;
        r6 = r6 + 1;
        goto L18
    L29:
        return null;
    L21:
        return null;
    L31:
        if (r4 == false) goto L34;
        return Integer.valueOf(r2);
    L34:
        return Integer.valueOf(-r2);
    L13:
        if (r3 != '+') goto L15;
        r4 = false;
        goto L17
    L15:
        return null;
    L16:
        r4 = false;
        r6 = 0;
        goto L17
    }

    public static Long k(String r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return l(r1, 10);
    }

    public static final Long l(String r19, int r20) {
        kotlin.n0.d.o.f(r19, "<this>");
        a.a(r20);
        int r2 = r19.length();
        if (r2 != 0) goto L5;
        return null;
    L5:
        int r4 = 0;
        char r5 = r19.charAt(0);
        long r7 = -9223372036854775807L;
        boolean r9 = true;
        if (kotlin.n0.d.o.h(r5, 48) >= 0) goto L16;
        if (r2 != 1) goto L10;
        return null;
    L10:
        if (r5 != '-') goto L13;
        r7 = Long.MIN_VALUE;
        r4 = 1;
    L17:
        long r6 = -256204778801521550L;
        long r10 = 0;
        long r12 = -256204778801521550L;
    L18:
        if (r4 >= r2) goto L33;
        int r14 = b.b(r19.charAt(r4), r20);
        if (r14 < 0) goto L21;
        if (r10 < r12) goto L25;
    L29:
        long r11 = r10 * ((long) r20);
        long r8 = r14;
        if (r11 < (r7 + r8)) goto L31;
        r10 = r11 - r8;
        r4 = r4 + 1;
        r6 = -256204778801521550L;
        goto L18
    L31:
        return null;
    L25:
        if (r12 != r6) goto L28;
        r12 = r7 / ((long) r20);
        if (r10 >= r12) goto L29;
    L28:
        return null;
    L21:
        return null;
    L33:
        if (r9 == false) goto L36;
        return Long.valueOf(r10);
    L36:
        return Long.valueOf(-r10);
    L13:
        if (r5 != '+') goto L15;
        r9 = false;
        r4 = 1;
        goto L17
    L15:
        return null;
    L16:
        r9 = false;
        goto L17
    }
}
