package okio.internal;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio._UtilKt;

/* JADX INFO: compiled from: -SegmentedByteString.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0080\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u001a\u001a\u00020\u0019*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\bH\u0080\b\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a]\u0010!\u001a\u00020\u0007*\u00020\b2K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0080\bø\u0001\u0000\u001aj\u0010!\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0082\b\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonCopyInto", "", "Lokio/SegmentedByteString;", "offset", "target", "", "targetOffset", "byteCount", "commonEquals", "", PluralRules.KEYWORD_OTHER, "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "otherOffset", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _SegmentedByteStringKt {
    public static final int binarySearch(int[] r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
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

    public static final int segment(SegmentedByteString r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = binarySearch(r2.getDirectory$okio(), r3 + 1, 0, r2.getSegments$okio().length);
        if (r4 < 0) goto L6;
        return r4;
    L6:
        return ~r4;
    }

    public static final void forEachSegment(SegmentedByteString r6, Function3<? super byte[], ? super Integer, ? super Integer, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "action");
        int r0 = r6.getSegments$okio().length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = r6.getDirectory$okio()[r0 + r1];
        int r4 = r6.getDirectory$okio()[r1];
        r7.invoke(r6.getSegments$okio()[r1], Integer.valueOf(r3), Integer.valueOf(r4 - r2));
        r1 = r1 + 1;
        r2 = r4;
        goto L3
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
        r8.invoke(r5.getSegments$okio()[r0], Integer.valueOf(r3 + (r6 - r1)), Integer.valueOf(r4));
        r6 = r6 + r4;
        r0 = r0 + 1;
        goto L3
    L6:
        r1 = r5.getDirectory$okio()[r0 - 1];
        goto L7
    }

    public static final ByteString commonSubstring(SegmentedByteString r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        SegmentedByteString r0 = r12;
        int r15 = _UtilKt.resolveDefaultParameter(r0, r14);
        int r1 = 0;
        if (r13 < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L41;
        if (r15 > r12.size()) goto L10;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L39;
        int r5 = r15 - r13;
        if (r5 < 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L37;
        if (r13 == 0) goto L20;
    L22:
        if (r13 == r15) goto L24;
        int r2 = segment(r12, r13);
        int r16 = segment(r12, r15 - 1);
        byte[][] r7 = (byte[][]) ArraysKt.copyOfRange(r12.getSegments$okio(), r2, r16 + 1);
        byte[][] r8 = r7;
        int[] r9 = new int[r8.length * 2];
        if (r2 > r16) goto L31;
        int r10 = r2;
        int r11 = 0;
    L28:
        r9[r11] = Math.min(r12.getDirectory$okio()[r10] - r13, r5);
        int r17 = r11 + 1;
        r9[r11 + r8.length] = r12.getDirectory$okio()[r12.getSegments$okio().length + r10];
        if (r10 == r16) goto L31;
        r10 = r10 + 1;
        r11 = r17;
    L31:
        if (r2 == 0) goto L34;
        r1 = r12.getDirectory$okio()[r2 - 1];
    L34:
        int r18 = r8.length;
        r9[r18] = r9[r18] + (r13 - r1);
        return new SegmentedByteString(r7, r9);
    L24:
        return ByteString.EMPTY;
    L20:
        if (r15 != r12.size()) goto L22;
        return r0;
    L37:
        throw new IllegalArgumentException(("endIndex=" + r15 + " < beginIndex=" + r13).toString());
    L16:
        r6 = false;
        goto L17
    L39:
        throw new IllegalArgumentException(("endIndex=" + r15 + " > length(" + r12.size() + ')').toString());
    L10:
        r4 = false;
        goto L12
    L41:
        throw new IllegalArgumentException(("beginIndex=" + r13 + " < 0").toString());
    L5:
        r3 = false;
        goto L6
    }

    public static final byte commonInternalGet(SegmentedByteString r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        _UtilKt.checkOffsetAndCount(r7.getDirectory$okio()[r7.getSegments$okio().length - 1], r8, 1);
        int r0 = segment(r7, r8);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L7:
        return r7.getSegments$okio()[r0][(r8 - r1) + r7.getDirectory$okio()[r7.getSegments$okio().length + r0]];
    L5:
        r1 = r7.getDirectory$okio()[r0 - 1];
        goto L7
    }

    public static final int commonGetSize(SegmentedByteString r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getDirectory$okio()[r1.getSegments$okio().length - 1];
    }

    public static final byte[] commonToByteArray(SegmentedByteString r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
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
        ArraysKt.copyInto(r9.getSegments$okio()[r2], r0, r4, r5, r5 + r7);
        r4 = r4 + r7;
        r2 = r2 + 1;
        r3 = r6;
        goto L3
    L5:
        return r0;
    }

    public static final boolean commonRangeEquals(SegmentedByteString r6, int r7, ByteString r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r8, PluralRules.KEYWORD_OTHER);
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
        if (r8.rangeEquals(r9, r6.getSegments$okio()[r1], r4 + (r7 - r2), r5) == false) goto L14;
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

    public static final boolean commonRangeEquals(SegmentedByteString r6, int r7, byte[] r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r8, PluralRules.KEYWORD_OTHER);
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
        if (_UtilKt.arrayRangeEquals(r6.getSegments$okio()[r1], r4 + (r7 - r2), r8, r9, r5) == false) goto L17;
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

    public static final void commonCopyInto(SegmentedByteString r11, int r12, byte[] r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r13, "target");
        long r9 = r15;
        _UtilKt.checkOffsetAndCount(r11.size(), r12, r9);
        _UtilKt.checkOffsetAndCount(r13.length, r14, r9);
        int r16 = r15 + r12;
        int r0 = segment(r11, r12);
    L3:
        if (r12 >= r16) goto L8;
        if (r0 != 0) goto L6;
        int r1 = 0;
    L7:
        int r2 = r11.getDirectory$okio()[r0] - r1;
        int r3 = r11.getDirectory$okio()[r11.getSegments$okio().length + r0];
        int r4 = Math.min(r16, r2 + r1) - r12;
        int r5 = r3 + (r12 - r1);
        ArraysKt.copyInto(r11.getSegments$okio()[r0], r13, r14, r5, r5 + r4);
        r14 = r14 + r4;
        r12 = r12 + r4;
        r0 = r0 + 1;
        goto L3
    L6:
        r1 = r11.getDirectory$okio()[r0 - 1];
        goto L7
    }

    public static final boolean commonEquals(SegmentedByteString r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
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

    public static final int commonHashCode(SegmentedByteString r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
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

    public static final void commonWrite(SegmentedByteString r11, Buffer r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "buffer");
        int r0 = r13 + r14;
        int r1 = segment(r11, r13);
    L3:
        if (r13 >= r0) goto L12;
        if (r1 != 0) goto L6;
        int r2 = 0;
    L7:
        int r3 = r11.getDirectory$okio()[r1] - r2;
        int r4 = r11.getDirectory$okio()[r11.getSegments$okio().length + r1];
        int r5 = Math.min(r0, r3 + r2) - r13;
        int r7 = r4 + (r13 - r2);
        Segment r6 = new Segment(r11.getSegments$okio()[r1], r7, r7 + r5, true, false);
        if (r12.head != null) goto L10;
        r6.prev = r6;
        r6.next = r6.prev;
        r12.head = r6.next;
    L11:
        r13 = r13 + r5;
        r1 = r1 + 1;
        goto L3
    L10:
        Segment r8 = r12.head;
        Intrinsics.checkNotNull(r8);
        Segment r9 = r8.prev;
        Intrinsics.checkNotNull(r9);
        r9.push(r6);
        goto L11
    L6:
        r2 = r11.getDirectory$okio()[r1 - 1];
        goto L7
    L12:
        r12.setSize$okio(r12.size() + ((long) r14));
    }
}
