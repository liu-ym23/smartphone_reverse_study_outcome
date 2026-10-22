package okio.internal;

import a.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SegmentedByteStringKt {
    public static final /* synthetic */ void access$forEachSegment(SegmentedByteString r0, int r1, int r2, Function3 r3) {
        forEachSegment(r0, r1, r2, r3);
    }

    public static final int binarySearch(@NotNull int[] r2, int r3, int r4, int r5) {
        Intrinsics.f(r2, "$this$binarySearch");
        int r6 = r5 - 1;
    L3:
        if (r4 > r6) goto L11;
        int r0 = (r4 + r6) >>> 1;
        int r1 = r2[r0];
        if (r1 < r3) goto L6;
        if (r1 <= r3) goto L9;
        r6 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return (-r4) - 1;
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString r4, @Nullable Object r5) {
        Intrinsics.f(r4, "$this$commonEquals");
        if (r5 != r4) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == false) goto L13;
        ByteString r6 = (ByteString) r5;
        if (r6.size() != r4.size()) goto L13;
        if (r4.rangeEquals(0, r6, 0, r4.size()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static final int commonGetSize(@NotNull SegmentedByteString r1) {
        Intrinsics.f(r1, "$this$commonGetSize");
        return r1.getDirectory$okio()[r1.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString r8) {
        Intrinsics.f(r8, "$this$commonHashCode");
        int r0 = r8.getHashCode$okio();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = r8.getSegments$okio().length;
        int r2 = 0;
        int r3 = 1;
        int r4 = 0;
    L6:
        if (r2 >= r1) goto L11;
        int r5 = r8.getDirectory$okio()[r1 + r2];
        int r6 = r8.getDirectory$okio()[r2];
        byte[] r7 = r8.getSegments$okio()[r2];
        int r9 = (r6 - r4) + r5;
    L8:
        if (r5 >= r9) goto L10;
        r3 = (r3 * 31) + r7[r5];
        r5 = r5 + 1;
        goto L8
    L10:
        r2 = r2 + 1;
        r4 = r6;
        goto L6
    L11:
        r8.setHashCode$okio(r3);
        return r3;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString r7, int r8) {
        Intrinsics.f(r7, "$this$commonInternalGet");
        Util.checkOffsetAndCount(r7.getDirectory$okio()[r7.getSegments$okio().length - 1], r8, 1);
        int r0 = segment(r7, r8);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L7:
        return r7.getSegments$okio()[r0][(r8 - r1) + r7.getDirectory$okio()[r7.getSegments$okio().length + r0]];
    L5:
        r1 = r7.getDirectory$okio()[r0 - 1];
        goto L7
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString r6, int r7, @NotNull ByteString r8, int r9, int r10) {
        Intrinsics.f(r6, "$this$commonRangeEquals");
        Intrinsics.f(r8, "other");
        if (r7 >= 0) goto L5;
    L18:
        return false;
    L5:
        if (r7 > (r6.size() - r10)) goto L18;
        int r11 = r10 + r7;
        int r1 = segment(r6, r7);
    L8:
        if (r7 >= r11) goto L16;
        if (r1 != 0) goto L11;
        int r2 = 0;
    L12:
        int r3 = r6.getDirectory$okio()[r1] - r2;
        int r4 = r6.getDirectory$okio()[r6.getSegments$okio().length + r1];
        int r5 = Math.min(r11, r3 + r2) - r7;
        if (r8.rangeEquals(r9, r6.getSegments$okio()[r1], (r7 - r2) + r4, r5) == false) goto L14;
        r9 = r9 + r5;
        r7 = r7 + r5;
        r1 = r1 + 1;
        goto L8
    L14:
        return false;
    L11:
        r2 = r6.getDirectory$okio()[r1 - 1];
        goto L12
    L16:
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString r11, int r12, int r13) {
        Intrinsics.f(r11, "$this$commonSubstring");
        int r0 = 0;
        if (r12 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L41;
        if (r13 > r11.size()) goto L10;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L38;
        int r4 = r13 - r12;
        if (r4 < 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L37;
        if (r12 == 0) goto L20;
    L22:
        if (r12 == r13) goto L24;
        int r6 = segment(r11, r12);
        int r14 = segment(r11, r13 - 1);
        byte[][] r7 = (byte[][]) ArraysKt.k(r11.getSegments$okio(), r6, r14 + 1);
        int[] r8 = new int[r7.length * 2];
        if (r6 > r14) goto L31;
        int r9 = 0;
        int r10 = r6;
    L28:
        r8[r9] = Math.min(r11.getDirectory$okio()[r10] - r12, r4);
        int r15 = r9 + 1;
        r8[r9 + r7.length] = r11.getDirectory$okio()[r11.getSegments$okio().length + r10];
        if (r10 == r14) goto L31;
        r10 = r10 + 1;
        r9 = r15;
    L31:
        if (r6 == 0) goto L34;
        r0 = r11.getDirectory$okio()[r6 - 1];
    L34:
        int r16 = r7.length;
        r8[r16] = (r12 - r0) + r8[r16];
        return new SegmentedByteString(r7, r8);
    L24:
        return ByteString.EMPTY;
    L20:
        if (r13 != r11.size()) goto L22;
        return r11;
    L37:
        throw new IllegalArgumentException(("endIndex=" + r13 + " < beginIndex=" + r12).toString());
    L16:
        r5 = false;
        goto L17
    L38:
        StringBuilder r17 = a.p(r13, "endIndex=", " > length(");
        r17.append(r11.size());
        r17.append(')');
        throw new IllegalArgumentException(r17.toString().toString());
    L10:
        r3 = false;
        goto L12
    L41:
        throw new IllegalArgumentException(a.f(r12, "beginIndex=", " < 0").toString());
    L5:
        r2 = false;
        goto L6
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString r9) {
        Intrinsics.f(r9, "$this$commonToByteArray");
        byte[] r0 = new byte[r9.size()];
        int r1 = r9.getSegments$okio().length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r5 = r9.getDirectory$okio()[r1 + r2];
        int r6 = r9.getDirectory$okio()[r2];
        int r7 = r6 - r3;
        ArraysKt.g(r9.getSegments$okio()[r2], r4, r0, r5, r5 + r7);
        r4 = r4 + r7;
        r2 = r2 + 1;
        r3 = r6;
        goto L3
    L5:
        return r0;
    }

    public static final void commonWrite(@NotNull SegmentedByteString r10, @NotNull Buffer r11, int r12, int r13) {
        Intrinsics.f(r10, "$this$commonWrite");
        Intrinsics.f(r11, "buffer");
        int r14 = r13 + r12;
        int r0 = segment(r10, r12);
    L3:
        if (r12 >= r14) goto L12;
        if (r0 != 0) goto L6;
        int r1 = 0;
    L7:
        int r2 = r10.getDirectory$okio()[r0] - r1;
        int r3 = r10.getDirectory$okio()[r10.getSegments$okio().length + r0];
        int r4 = Math.min(r14, r2 + r1) - r12;
        int r6 = (r12 - r1) + r3;
        Segment r5 = new Segment(r10.getSegments$okio()[r0], r6, r6 + r4, true, false);
        Segment r7 = r11.head;
        if (r7 != null) goto L10;
        r5.prev = r5;
        r5.next = r5;
        r11.head = r5;
    L11:
        r12 = r12 + r4;
        r0 = r0 + 1;
        goto L3
    L10:
        Intrinsics.c(r7);
        Segment r8 = r7.prev;
        Intrinsics.c(r8);
        r8.push(r5);
        goto L11
    L6:
        r1 = r10.getDirectory$okio()[r0 - 1];
        goto L7
    L12:
        r11.setSize$okio(r11.size() + ((long) r10.size()));
    }

    public static final void forEachSegment(@NotNull SegmentedByteString r6, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, Unit> r7) {
        Intrinsics.f(r6, "$this$forEachSegment");
        Intrinsics.f(r7, "action");
        int r0 = r6.getSegments$okio().length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = r6.getDirectory$okio()[r0 + r1];
        int r4 = r6.getDirectory$okio()[r1];
        r7.b(r6.getSegments$okio()[r1], Integer.valueOf(r3), Integer.valueOf(r4 - r2));
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    }

    public static final int segment(@NotNull SegmentedByteString r2, int r3) {
        Intrinsics.f(r2, "$this$segment");
        int r4 = binarySearch(r2.getDirectory$okio(), r3 + 1, 0, r2.getSegments$okio().length);
        if (r4 < 0) goto L6;
        return r4;
    L6:
        return ~r4;
    }

    private static final void forEachSegment(SegmentedByteString r5, int r6, int r7, Function3<? super byte[], ? super Integer, ? super Integer, Unit> r8) {
        int r0 = segment(r5, r6);
    L3:
        if (r6 >= r7) goto L8;
        if (r0 != 0) goto L6;
        int r1 = 0;
    L7:
        int r2 = r5.getDirectory$okio()[r0] - r1;
        int r3 = r5.getDirectory$okio()[r5.getSegments$okio().length + r0];
        int r4 = Math.min(r7, r2 + r1) - r6;
        r8.b(r5.getSegments$okio()[r0], Integer.valueOf((r6 - r1) + r3), Integer.valueOf(r4));
        r6 = r6 + r4;
        r0 = r0 + 1;
        goto L3
    L6:
        r1 = r5.getDirectory$okio()[r0 - 1];
        goto L7
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString r6, int r7, @NotNull byte[] r8, int r9, int r10) {
        Intrinsics.f(r6, "$this$commonRangeEquals");
        Intrinsics.f(r8, "other");
        if (r7 >= 0) goto L5;
    L21:
        return false;
    L5:
        if (r7 > (r6.size() - r10)) goto L21;
        if (r9 < 0) goto L21;
        if (r9 > (r8.length - r10)) goto L21;
        int r11 = r10 + r7;
        int r1 = segment(r6, r7);
    L11:
        if (r7 >= r11) goto L19;
        if (r1 != 0) goto L14;
        int r2 = 0;
    L15:
        int r3 = r6.getDirectory$okio()[r1] - r2;
        int r4 = r6.getDirectory$okio()[r6.getSegments$okio().length + r1];
        int r5 = Math.min(r11, r3 + r2) - r7;
        if (Util.arrayRangeEquals(r6.getSegments$okio()[r1], (r7 - r2) + r4, r8, r9, r5) == false) goto L17;
        r9 = r9 + r5;
        r7 = r7 + r5;
        r1 = r1 + 1;
        goto L11
    L17:
        return false;
    L14:
        r2 = r6.getDirectory$okio()[r1 - 1];
        goto L15
    L19:
        return true;
    }
}
