package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UStrings.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0014\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UStringsKt {
    /* JADX INFO: renamed from: toString-LxnNnR4, reason: not valid java name */
    public static final String m2086toStringLxnNnR4(byte r0, int r1) {
        String r2 = Integer.toString(r0 & UByte.MAX_VALUE, CharsKt.checkRadix(r1));
        Intrinsics.checkNotNullExpressionValue(r2, "toString(this, checkRadix(radix))");
        return r2;
    }

    /* JADX INFO: renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m2088toStringolVBNx4(short r1, int r2) {
        String r3 = Integer.toString(r1 & UShort.MAX_VALUE, CharsKt.checkRadix(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "toString(this, checkRadix(radix))");
        return r3;
    }

    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m2087toStringV7xB4Y4(int r4, int r5) {
        String r6 = Long.toString(((long) r4) & 4294967295L, CharsKt.checkRadix(r5));
        Intrinsics.checkNotNullExpressionValue(r6, "toString(this, checkRadix(radix))");
        return r6;
    }

    /* JADX INFO: renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m2085toStringJSWoG40(long r0, int r2) {
        return UnsignedKt.ulongToString(r0, CharsKt.checkRadix(r2));
    }

    public static final byte toUByte(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UByte r0 = toUByteOrNull(r1);
        if (r0 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r0.m842unboximpl();
    }

    public static final byte toUByte(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UByte r3 = toUByteOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m842unboximpl();
    }

    public static final short toUShort(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UShort r0 = toUShortOrNull(r1);
        if (r0 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r0.m1105unboximpl();
    }

    public static final short toUShort(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UShort r3 = toUShortOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m1105unboximpl();
    }

    public static final int toUInt(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r0 = toUIntOrNull(r1);
        if (r0 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r0.m921unboximpl();
    }

    public static final int toUInt(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r3 = toUIntOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m921unboximpl();
    }

    public static final long toULong(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ULong r0 = toULongOrNull(r2);
        if (r0 != null) goto L5;
        StringsKt.numberFormatError(r2);
        throw new KotlinNothingValueException();
    L5:
        return r0.m1000unboximpl();
    }

    public static final long toULong(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ULong r3 = toULongOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m1000unboximpl();
    }

    public static final UByte toUByteOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toUByteOrNull(r1, 10);
    }

    public static final UByte toUByteOrNull(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r3 = toUIntOrNull(r1, r2);
        if (r3 == null) goto L9;
        int r4 = r3.m921unboximpl();
        if (Integer.compareUnsigned(r4, UInt.m869constructorimpl(255)) <= 0) goto L8;
        return null;
    L8:
        return UByte.m786boximpl(UByte.m792constructorimpl((byte) r4));
    L9:
        return null;
    }

    public static final UShort toUShortOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toUShortOrNull(r1, 10);
    }

    public static final UShort toUShortOrNull(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r3 = toUIntOrNull(r1, r2);
        if (r3 == null) goto L9;
        int r4 = r3.m921unboximpl();
        if (Integer.compareUnsigned(r4, UInt.m869constructorimpl(65535)) <= 0) goto L8;
        return null;
    L8:
        return UShort.m1049boximpl(UShort.m1055constructorimpl((short) r4));
    L9:
        return null;
    }

    public static final UInt toUIntOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toUIntOrNull(r1, 10);
    }

    public static final UInt toUIntOrNull(String r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        CharsKt.checkRadix(r10);
        int r0 = r9.length();
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r2 = 0;
        char r3 = r9.charAt(0);
        if (Intrinsics.compare(r3, 48) >= 0) goto L12;
        int r4 = 1;
        if (r0 != 1) goto L10;
    L11:
        return null;
    L10:
        if (r3 != '+') goto L11;
    L13:
        int r5 = UInt.m869constructorimpl(r10);
        int r6 = 119304647;
    L14:
        if (r4 >= r0) goto L29;
        int r7 = CharsKt.digitOf(r9.charAt(r4), r10);
        if (r7 < 0) goto L17;
        if (Integer.compareUnsigned(r2, r6) <= 0) goto L24;
        if (r6 != 119304647) goto L23;
        r6 = Integer.divideUnsigned(-1, r5);
        if (Integer.compareUnsigned(r2, r6) <= 0) goto L24;
    L23:
        return null;
    L24:
        int r8 = UInt.m869constructorimpl(r2 * r5);
        int r11 = UInt.m869constructorimpl(UInt.m869constructorimpl(r7) + r8);
        if (Integer.compareUnsigned(r11, r8) < 0) goto L26;
        r4 = r4 + 1;
        r2 = r11;
        goto L14
    L26:
        return null;
    L17:
        return null;
    L29:
        return UInt.m863boximpl(r2);
    L12:
        r4 = 0;
        goto L13
    }

    public static final ULong toULongOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toULongOrNull(r1, 10);
    }

    public static final ULong toULongOrNull(String r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        CharsKt.checkRadix(r18);
        int r2 = r17.length();
        if (r2 != 0) goto L5;
        return null;
    L5:
        int r4 = 0;
        char r5 = r17.charAt(0);
        if (Intrinsics.compare(r5, 48) >= 0) goto L12;
        r4 = 1;
        if (r2 != 1) goto L10;
    L11:
        return null;
    L10:
        if (r5 != '+') goto L11;
    L12:
        long r6 = ULong.m948constructorimpl(r18);
        long r9 = 0;
        long r11 = 512409557603043100L;
    L13:
        if (r4 >= r2) goto L29;
        int r13 = CharsKt.digitOf(r17.charAt(r4), r18);
        if (r13 < 0) goto L16;
        if (Long.compareUnsigned(r9, r11) > 0) goto L20;
    L24:
        long r10 = ULong.m948constructorimpl(r9 * r6);
        long r14 = ULong.m948constructorimpl(ULong.m948constructorimpl(((long) UInt.m869constructorimpl(r13)) & 4294967295L) + r10);
        if (Long.compareUnsigned(r14, r10) < 0) goto L26;
        r4 = r4 + 1;
        r9 = r14;
        goto L13
    L26:
        return null;
    L20:
        if (r11 != 512409557603043100L) goto L23;
        r11 = Long.divideUnsigned(-1, r6);
        if (Long.compareUnsigned(r9, r11) <= 0) goto L24;
    L23:
        return null;
    L16:
        return null;
    L29:
        return ULong.m942boximpl(r9);
    }
}
