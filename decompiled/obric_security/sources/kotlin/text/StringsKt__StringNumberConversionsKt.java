package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringNumberConversions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public StringsKt__StringNumberConversionsKt() {
    }

    public static final Byte toByteOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.toByteOrNull(r1, 10);
    }

    public static final Byte toByteOrNull(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Integer r3 = StringsKt.toIntOrNull(r1, r2);
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
        if (r4 < (-128)) goto L11;
        if (r4 > 127) goto L11;
        return Byte.valueOf((byte) r4);
    L11:
        return null;
    }

    public static final Short toShortOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.toShortOrNull(r1, 10);
    }

    public static final Short toShortOrNull(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Integer r3 = StringsKt.toIntOrNull(r1, r2);
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
        if (r4 < (-32768)) goto L11;
        if (r4 > 32767) goto L11;
        return Short.valueOf((short) r4);
    L11:
        return null;
    }

    public static final Integer toIntOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.toIntOrNull(r1, 10);
    }

    public static final Integer toIntOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CharsKt.checkRadix(r11);
        int r0 = r10.length();
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r2 = 0;
        char r3 = r10.charAt(0);
        int r5 = -2147483647;
        if (Intrinsics.compare(r3, 48) >= 0) goto L17;
        int r4 = 1;
        if (r0 != 1) goto L11;
        return null;
    L11:
        if (r3 != '-') goto L14;
        r5 = Integer.MIN_VALUE;
        boolean r6 = true;
    L18:
        int r7 = -59652323;
    L19:
        if (r4 >= r0) goto L32;
        int r8 = CharsKt.digitOf(r10.charAt(r4), r11);
        if (r8 < 0) goto L22;
        if (r2 >= r7) goto L28;
        if (r7 != (-59652323)) goto L27;
        r7 = r5 / r11;
        if (r2 >= r7) goto L28;
    L27:
        return null;
    L28:
        int r9 = r2 * r11;
        if (r9 < (r5 + r8)) goto L30;
        r2 = r9 - r8;
        r4 = r4 + 1;
        goto L19
    L30:
        return null;
    L22:
        return null;
    L32:
        if (r6 == false) goto L35;
        return Integer.valueOf(r2);
    L35:
        return Integer.valueOf(-r2);
    L14:
        if (r3 != '+') goto L16;
        r6 = false;
        goto L18
    L16:
        return null;
    L17:
        r6 = false;
        r4 = 0;
        goto L18
    }

    public static final Long toLongOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.toLongOrNull(r1, 10);
    }

    public static final Long toLongOrNull(String r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        CharsKt.checkRadix(r20);
        int r2 = r19.length();
        if (r2 != 0) goto L5;
        return null;
    L5:
        int r4 = 0;
        char r5 = r19.charAt(0);
        long r7 = -9223372036854775807L;
        if (Intrinsics.compare(r5, 48) >= 0) goto L17;
        boolean r6 = true;
        if (r2 != 1) goto L11;
        return null;
    L11:
        if (r5 != '-') goto L14;
        r7 = Long.MIN_VALUE;
        r4 = 1;
    L18:
        long r9 = -256204778801521550L;
        long r11 = 0;
        long r13 = -256204778801521550L;
    L19:
        if (r4 >= r2) goto L34;
        int r8 = CharsKt.digitOf(r19.charAt(r4), r20);
        if (r8 < 0) goto L22;
        if (r11 < r13) goto L26;
    L30:
        long r12 = r11 * ((long) r20);
        long r10 = r8;
        if (r12 < (r7 + r10)) goto L32;
        r11 = r12 - r10;
        r4 = r4 + 1;
        r9 = -256204778801521550L;
        goto L19
    L32:
        return null;
    L26:
        if (r13 != r9) goto L29;
        r13 = r7 / ((long) r20);
        if (r11 >= r13) goto L30;
    L29:
        return null;
    L22:
        return null;
    L34:
        if (r6 == false) goto L37;
        return Long.valueOf(r11);
    L37:
        return Long.valueOf(-r11);
    L14:
        if (r5 != '+') goto L16;
        r6 = false;
        r4 = 1;
        goto L18
    L16:
        return null;
    L17:
        r6 = false;
        goto L18
    }

    public static final Void numberFormatError(String r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        throw new NumberFormatException("Invalid number format: '" + r3 + '\'');
    }
}
