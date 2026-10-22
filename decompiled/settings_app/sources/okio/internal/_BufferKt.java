package okio.internal;

import android.icu.text.DateFormat;
import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.DataUsageFragment;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.google.common.base.Ascii;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio._JvmPlatformKt;
import okio._UtilKt;

/* JADX INFO: compiled from: -Buffer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0080\b\u001a\r\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0080\b\u001a\r\u0010\u0018\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0015*\u00020\u0015H\u0080\b\u001a%\u0010\u001a\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0017\u0010\u001e\u001a\u00020\f*\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0007*\u00020\u00172\u0006\u0010\"\u001a\u00020\nH\u0080\b\u001a\u0015\u0010#\u001a\u00020$*\u00020\u00152\u0006\u0010%\u001a\u00020\u0007H\u0080\b\u001a\r\u0010&\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a%\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010,\u001a\u00020\u0007*\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\u0080\b\u001a\r\u0010.\u001a\u00020\n*\u00020\u0017H\u0080\b\u001a-\u0010/\u001a\u00020\f*\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u0015\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\u0080\b\u001a%\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u00100\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00102\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u000203H\u0080\b\u001a\u0014\u00104\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\r\u00106\u001a\u00020$*\u00020\u0015H\u0080\b\u001a\r\u00107\u001a\u00020\u0001*\u00020\u0015H\u0080\b\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u00108\u001a\u00020+*\u00020\u0015H\u0080\b\u001a\u0015\u00108\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\u0015\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010;\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010<\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a\r\u0010=\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010>\u001a\u00020?*\u00020\u0015H\u0080\b\u001a\u0014\u0010@\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\u0015\u0010A\u001a\u00020B*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010C\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a\u000f\u0010D\u001a\u0004\u0018\u00010B*\u00020\u0015H\u0080\b\u001a\u0015\u0010E\u001a\u00020B*\u00020\u00152\u0006\u0010F\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010G\u001a\u00020\u0007*\u00020\u00172\u0006\u0010H\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010I\u001a\u00020\n*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010J\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020LH\u0080\b\u001a\u0015\u0010M\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010N\u001a\u00020+*\u00020\u0015H\u0080\b\u001a\u0015\u0010N\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u0015\u0010O\u001a\u00020\u000e*\u00020\u00152\u0006\u0010P\u001a\u00020\nH\u0080\b\u001a\u0015\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u0001H\u0080\b\u001a%\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u0010Q\u001a\u00020\u0014*\u00020\u00152\u0006\u0010R\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a)\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010S\u001a\u00020+2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020T2\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010U\u001a\u00020\u0007*\u00020\u00152\u0006\u0010R\u001a\u00020TH\u0080\b\u001a\u0015\u0010V\u001a\u00020\u0015*\u00020\u00152\u0006\u0010(\u001a\u00020\nH\u0080\b\u001a\u0015\u0010W\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010Y\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010Z\u001a\u00020\u0015*\u00020\u00152\u0006\u0010[\u001a\u00020\nH\u0080\b\u001a\u0015\u0010\\\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010]\u001a\u00020\u0015*\u00020\u00152\u0006\u0010^\u001a\u00020\nH\u0080\b\u001a%\u0010_\u001a\u00020\u0015*\u00020\u00152\u0006\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0080\b\u001a\u0015\u0010c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010d\u001a\u00020\nH\u0080\b\u001a\u0014\u0010e\u001a\u00020B*\u00020\u00152\u0006\u0010f\u001a\u00020\u0007H\u0000\u001a?\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h*\u00020\u00152\u0006\u0010)\u001a\u00020\u00072\u001a\u0010i\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002Hh0jH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010k\u001a\u001e\u0010l\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020\fH\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006n"}, d2 = {"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES$annotations", "()V", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonClose", "Lokio/Buffer$UnsafeCursor;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", PluralRules.KEYWORD_OTHER, "", "commonExpandBuffer", "minByteCount", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonNext", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadAndWriteUnsafe", "unsafeCursor", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUnsafe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", DataUsageFragment.INTENT_EXTRA_LIMIT, "commonResizeBuffer", "newSize", "commonSeek", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteLong", "commonWriteShort", DateFormat.SECOND, "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", ExifInterface.GPS_DIRECTION_TRUE, "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = null;
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    static {
        HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment r5, int r6, byte[] r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r5, "segment");
        Intrinsics.checkNotNullParameter(r7, "bytes");
        int r0 = r5.limit;
        byte[] r1 = r5.data;
    L3:
        if (r8 >= r9) goto L11;
        if (r6 != r0) goto L7;
        r5 = r5.next;
        Intrinsics.checkNotNull(r5);
        byte[] r10 = r5.data;
        int r2 = r5.pos;
        r1 = r10;
        r6 = r2;
        r0 = r5.limit;
    L7:
        if (r1[r6] != r7[r8]) goto L8;
        r6 = r6 + 1;
        r8 = r8 + 1;
        goto L3
    L8:
        return false;
    L11:
        return true;
    }

    public static final String readUtf8Line(Buffer r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r7 <= 0) goto L7;
        long r3 = r7 - 1;
        if (r6.getByte(r3) != 13) goto L7;
        String r8 = r6.readUtf8(r3);
        r6.skip(2);
        return r8;
    L7:
        String r9 = r6.readUtf8(r7);
        r6.skip(1);
        return r9;
    }

    public static final <T> T seek(Buffer r5, long r6, Function2<? super Segment, ? super Long, ? extends T> r8) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r8, "lambda");
        Segment r0 = r5.head;
        if (r0 != null) goto L7;
        return r8.invoke(null, -1L);
    L7:
        if ((r5.size() - r6) >= r6) goto L14;
        long r1 = r5.size();
    L10:
        if (r1 <= r6) goto L13;
        r0 = r0.prev;
        Intrinsics.checkNotNull(r0);
        r1 = r1 - ((long) (r0.limit - r0.pos));
        goto L10
    L13:
        return r8.invoke(r0, Long.valueOf(r1));
    L14:
        long r2 = 0;
    L15:
        long r3 = ((long) (r0.limit - r0.pos)) + r2;
        if (r3 > r6) goto L19;
        r0 = r0.next;
        Intrinsics.checkNotNull(r0);
        r2 = r3;
        goto L15
    L19:
        return r8.invoke(r0, Long.valueOf(r2));
    }

    public static /* synthetic */ int selectPrefix$default(Buffer r0, Options r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return selectPrefix(r0, r1, r2);
    }

    public static final int selectPrefix(Buffer r17, Options r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "options");
        Segment r0 = r17.head;
        if (r0 != null) goto L8;
        if (r19 == false) goto L7;
        return -2;
    L7:
        return -1;
    L8:
        byte[] r4 = r0.data;
        int r5 = r0.pos;
        int r6 = r0.limit;
        int[] r2 = r18.getTrie$okio();
        Segment r9 = r0;
        int r10 = -1;
        int r8 = 0;
    L9:
        int r11 = r8 + 1;
        int r12 = r2[r8];
        int r13 = r11 + 1;
        int r14 = r2[r11];
        if (r14 == (-1)) goto L12;
        r10 = r14;
    L12:
        if (r9 == null) goto L28;
        if (r12 >= 0) goto L36;
        int r15 = r13 + (r12 * (-1));
    L17:
        int r16 = r5 + 1;
        int r110 = r13 + 1;
        if ((r4[r5] & 255) != r2[r13]) goto L19;
        if (r110 != r15) goto L22;
        boolean r7 = true;
    L23:
        if (r16 != r6) goto L32;
        Intrinsics.checkNotNull(r9);
        Segment r20 = r9.next;
        Intrinsics.checkNotNull(r20);
        int r21 = r20.pos;
        byte[] r22 = r20.data;
        int r23 = r20.limit;
        if (r20 != r0) goto L31;
        if (r7 == false) goto L28;
        r4 = r22;
        Segment r24 = null;
    L33:
        if (r7 == true) goto L34;
        r5 = r21;
        r6 = r23;
        r13 = r110;
        r9 = r24;
        goto L17
    L34:
        int r25 = r2[r110];
        int r111 = r21;
        r6 = r23;
        r9 = r24;
    L46:
        if (r25 >= 0) goto L47;
        r8 = -r25;
        r5 = r111;
        goto L9
    L47:
        return r25;
    L31:
        r24 = r20;
        r4 = r22;
        goto L33
    L32:
        Segment r112 = r9;
        r23 = r6;
        r21 = r16;
        r24 = r112;
        goto L33
    L22:
        r7 = false;
        goto L23
    L19:
        return r10;
    L36:
        r111 = r5 + 1;
        int r26 = r4[r5] & 255;
        int r113 = r13 + r12;
    L37:
        if (r13 == r113) goto L38;
        if (r26 == r2[r13]) goto L41;
        r13 = r13 + 1;
        goto L37
    L41:
        r25 = r2[r13 + r12];
        if (r111 != r6) goto L46;
        r9 = r9.next;
        Intrinsics.checkNotNull(r9);
        int r27 = r9.pos;
        r111 = r27;
        r4 = r9.data;
        r6 = r9.limit;
        if (r9 != r0) goto L46;
        r9 = null;
        goto L46
    L38:
        return r10;
    L28:
        if (r19 == false) goto L30;
        return -2;
    L30:
        return r10;
    }

    public static final Buffer commonCopyTo(Buffer r7, Buffer r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "out");
        _UtilKt.checkOffsetAndCount(r7.size(), r9, r11);
        if (r11 != 0) goto L5;
        return r7;
    L5:
        r8.setSize$okio(r8.size() + r11);
        Segment r2 = r7.head;
    L6:
        Intrinsics.checkNotNull(r2);
        if (r9 < (r2.limit - r2.pos)) goto L10;
        r9 = r9 - ((long) (r2.limit - r2.pos));
        r2 = r2.next;
    L10:
        if (r11 <= 0) goto L16;
        Intrinsics.checkNotNull(r2);
        Segment r3 = r2.sharedCopy();
        r3.pos += (int) r9;
        r3.limit = Math.min(r3.pos + ((int) r11), r3.limit);
        if (r8.head != null) goto L14;
        r3.prev = r3;
        r3.next = r3.prev;
        r8.head = r3.next;
    L15:
        r11 = r11 - ((long) (r3.limit - r3.pos));
        r2 = r2.next;
        r9 = 0;
        goto L10
    L14:
        Segment r10 = r8.head;
        Intrinsics.checkNotNull(r10);
        Segment r12 = r10.prev;
        Intrinsics.checkNotNull(r12);
        r12.push(r3);
        goto L15
    L16:
        return r7;
    }

    public static final long commonCompleteSegmentByteCount(Buffer r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        long r0 = r5.size();
        if (r0 != 0) goto L5;
        return 0;
    L5:
        Segment r6 = r5.head;
        Intrinsics.checkNotNull(r6);
        Segment r7 = r6.prev;
        Intrinsics.checkNotNull(r7);
        if (r7.limit < 8192) goto L8;
        return r0;
    L8:
        if (r7.owner == true) goto L10;
        return r0;
    L10:
        return r0 - ((long) (r7.limit - r7.pos));
    }

    public static final byte commonReadByte(Buffer r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r9.size() == 0) goto L10;
        Segment r0 = r9.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.pos;
        int r2 = r0.limit;
        int r4 = r1 + 1;
        byte r3 = r0.data[r1];
        r9.setSize$okio(r9.size() - 1);
        if (r4 != r2) goto L7;
        r9.head = r0.pop();
        SegmentPool.recycle(r0);
    L8:
        return r3;
    L7:
        r0.pos = r4;
        goto L8
    L10:
        throw new EOFException();
    }

    public static final short commonReadShort(Buffer r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r8.size() < 2) goto L15;
        Segment r0 = r8.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) >= 2) goto L8;
        int r2 = (r8.readByte() & 255) << 8;
        return (short) ((r8.readByte() & 255) | r2);
    L8:
        byte[] r5 = r0.data;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r3 = ((r5[r1] & 255) << 8) | (r5[r6] & 255);
        r8.setSize$okio(r8.size() - 2);
        if (r7 != r4) goto L11;
        r8.head = r0.pop();
        SegmentPool.recycle(r0);
    L13:
        return (short) r3;
    L11:
        r0.pos = r7;
        goto L13
    L15:
        throw new EOFException();
    }

    public static final int commonReadInt(Buffer r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r8.size() < 4) goto L14;
        Segment r0 = r8.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 4) goto L7;
        byte[] r5 = r0.data;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & 255) << 24) | ((r5[r6] & 255) << 16);
        int r9 = r7 + 1;
        int r3 = r2 | ((r5[r7] & 255) << 8);
        int r10 = r9 + 1;
        int r11 = r3 | (r5[r9] & 255);
        r8.setSize$okio(r8.size() - 4);
        if (r10 != r4) goto L11;
        r8.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r11;
    L11:
        r0.pos = r10;
        goto L12
    L7:
        return (r8.readByte() & 255) | ((((r8.readByte() & 255) << 24) | ((r8.readByte() & 255) << 16)) | ((r8.readByte() & 255) << 8));
    L14:
        throw new EOFException();
    }

    public static final long commonReadLong(Buffer r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        if (r14.size() < 8) goto L14;
        Segment r0 = r14.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 8) goto L7;
        byte[] r5 = r0.data;
        int r7 = r1 + 1;
        long r8 = (((long) r5[r1]) & 255) << 56;
        int r2 = r7 + 1;
        int r9 = r2 + 1;
        long r10 = (r8 | ((((long) r5[r7]) & 255) << 48)) | ((((long) r5[r2]) & 255) << 40);
        int r3 = r9 + 1;
        int r11 = r3 + 1;
        long r6 = (r10 | ((((long) r5[r9]) & 255) << 32)) | ((((long) r5[r3]) & 255) << 24);
        int r12 = r11 + 1;
        long r13 = r6 | ((((long) r5[r11]) & 255) << 16);
        int r15 = r12 + 1;
        long r16 = r13 | ((((long) r5[r12]) & 255) << 8);
        int r17 = r15 + 1;
        long r18 = r16 | (((long) r5[r15]) & 255);
        r14.setSize$okio(r14.size() - 8);
        if (r17 != r4) goto L11;
        r14.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r18;
    L11:
        r0.pos = r17;
        goto L12
    L7:
        return ((((long) r14.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) r14.readInt()));
    L14:
        throw new EOFException();
    }

    public static final byte commonGet(Buffer r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        _UtilKt.checkOffsetAndCount(r7.size(), r8, 1);
        Segment r0 = r7.head;
        if (r0 != null) goto L5;
        Segment r9 = null;
        Intrinsics.checkNotNull(null);
        byte[] r10 = r9.data;
        throw null;
    L5:
        if ((r7.size() - r8) >= r8) goto L12;
        long r1 = r7.size();
    L8:
        if (r1 <= r8) goto L10;
        r0 = r0.prev;
        Intrinsics.checkNotNull(r0);
        r1 = r1 - ((long) (r0.limit - r0.pos));
        goto L8
    L10:
        Intrinsics.checkNotNull(r0);
        return r0.data[(int) ((((long) r0.pos) + r8) - r1)];
    L12:
        long r2 = 0;
    L13:
        long r3 = ((long) (r0.limit - r0.pos)) + r2;
        if (r3 > r8) goto L16;
        r0 = r0.next;
        Intrinsics.checkNotNull(r0);
        r2 = r3;
        goto L13
    L16:
        Intrinsics.checkNotNull(r0);
        return r0.data[(int) ((((long) r0.pos) + r8) - r2)];
    }

    public static final void commonClear(Buffer r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.skip(r2.size());
    }

    public static final void commonSkip(Buffer r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
    L4:
        if (r7 <= 0) goto L12;
        Segment r0 = r6.head;
        if (r0 == null) goto L11;
        int r1 = (int) Math.min(r7, r0.limit - r0.pos);
        long r4 = r1;
        r6.setSize$okio(r6.size() - r4);
        r7 = r7 - r4;
        r0.pos += r1;
        if (r0.pos != r0.limit) goto L4;
        r6.head = r0.pop();
        SegmentPool.recycle(r0);
        goto L4
    L11:
        throw new EOFException();
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer r0, ByteString r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = r1.size();
    L8:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "byteString");
        r1.write$okio(r0, r2, r3);
        return r0;
    }

    public static final Buffer commonWrite(Buffer r1, ByteString r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "byteString");
        r2.write$okio(r1, r3, r4);
        return r1;
    }

    public static final Buffer commonWriteDecimalLong(Buffer r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if (r13 == 0) goto L5;
        int r3 = 1;
        if (r13 >= 0) goto L13;
        r13 = -r13;
        if (r13 < 0) goto L11;
        boolean r2 = true;
    L15:
        if (r13 >= 100000000) goto L39;
        if (r13 >= 10000) goto L29;
        if (r13 >= 100) goto L25;
        if (r13 < 10) goto L69;
        r3 = 2;
    L69:
        if (r2 == false) goto L71;
        r3 = r3 + 1;
    L71:
        Segment r4 = r12.writableSegment$okio(r3);
        byte[] r6 = r4.data;
        int r7 = r4.limit + r3;
    L73:
        if (r13 == 0) goto L75;
        long r8 = 10;
        r7 = r7 - 1;
        r6[r7] = getHEX_DIGIT_BYTES()[(int) (r13 % r8)];
        r13 = r13 / r8;
        goto L73
    L75:
        if (r2 == false) goto L77;
        r6[r7 - 1] = 45;
    L77:
        r4.limit += r3;
        r12.setSize$okio(r12.size() + ((long) r3));
        return r12;
    L25:
        if (r13 >= 1000) goto L27;
        r3 = 3;
        goto L69
    L27:
        r3 = 4;
        goto L69
    L29:
        if (r13 >= 1000000) goto L35;
        if (r13 >= 100000) goto L33;
        r3 = 5;
        goto L69
    L33:
        r3 = 6;
        goto L69
    L35:
        if (r13 >= StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L37;
        r3 = 7;
        goto L69
    L37:
        r3 = 8;
        goto L69
    L39:
        if (r13 >= 1000000000000L) goto L51;
        if (r13 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) goto L47;
        if (r13 >= 1000000000) goto L45;
        r3 = 9;
        goto L69
    L45:
        r3 = 10;
        goto L69
    L47:
        if (r13 >= 100000000000L) goto L49;
        r3 = 11;
        goto L69
    L49:
        r3 = 12;
        goto L69
    L51:
        if (r13 >= 1000000000000000L) goto L60;
        if (r13 >= 10000000000000L) goto L56;
        r3 = 13;
        goto L69
    L56:
        if (r13 >= 100000000000000L) goto L58;
        r3 = 14;
        goto L69
    L58:
        r3 = 15;
        goto L69
    L60:
        if (r13 >= 100000000000000000L) goto L66;
        if (r13 >= 10000000000000000L) goto L64;
        r3 = 16;
        goto L69
    L64:
        r3 = 17;
        goto L69
    L66:
        if (r13 >= 1000000000000000000L) goto L68;
        r3 = 18;
        goto L69
    L68:
        r3 = 19;
        goto L69
    L11:
        return r12.writeUtf8("-9223372036854775808");
    L13:
        r2 = false;
        goto L15
    L5:
        return r12.writeByte(48);
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if (r13 == 0) goto L5;
        long r1 = (r13 >>> 1) | r13;
        long r2 = r1 | (r1 >>> 2);
        long r3 = r2 | (r2 >>> 4);
        long r4 = r3 | (r3 >>> 8);
        long r5 = r4 | (r4 >>> 16);
        long r6 = r5 | (r5 >>> 32);
        long r7 = r6 - ((r6 >>> 1) & 6148914691236517205L);
        long r8 = ((r7 >>> 2) & 3689348814741910323L) + (r7 & 3689348814741910323L);
        long r9 = ((r8 >>> 4) + r8) & 1085102592571150095L;
        long r10 = r9 + (r9 >>> 8);
        long r11 = r10 + (r10 >>> 16);
        int r14 = (int) ((((r11 & 63) + ((r11 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment r15 = r12.writableSegment$okio(r14);
        byte[] r16 = r15.data;
        int r17 = (r15.limit + r14) - 1;
        int r0 = r15.limit;
    L7:
        if (r17 < r0) goto L9;
        r16[r17] = getHEX_DIGIT_BYTES()[(int) (15 & r13)];
        r13 = r13 >>> 4;
        r17 = r17 - 1;
        goto L7
    L9:
        r15.limit += r14;
        r12.setSize$okio(r12.size() + ((long) r14));
        return r12;
    L5:
        return r12.writeByte(48);
    }

    public static final Segment commonWritableSegment(Buffer r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        boolean r1 = true;
        if (r3 < 1) goto L6;
        if (r3 > 8192) goto L6;
    L7:
        if (r1 == false) goto L19;
        if (r2.head != null) goto L12;
        Segment r4 = SegmentPool.take();
        r2.head = r4;
        r4.prev = r4;
        r4.next = r4;
        return r4;
    L12:
        Segment r5 = r2.head;
        Intrinsics.checkNotNull(r5);
        Segment r6 = r5.prev;
        Intrinsics.checkNotNull(r6);
        if ((r6.limit + r3) > 8192) goto L17;
        if (r6.owner == false) goto L17;
        return r6;
    L17:
        return r6.push(SegmentPool.take());
    L19:
        throw new IllegalArgumentException("unexpected capacity".toString());
    L6:
        r1 = false;
        goto L7
    }

    public static final Buffer commonWrite(Buffer r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "source");
        return r2.write(r3, 0, r3.length);
    }

    public static final Buffer commonWrite(Buffer r9, byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "source");
        long r7 = r12;
        _UtilKt.checkOffsetAndCount(r10.length, r11, r7);
        int r13 = r12 + r11;
    L3:
        if (r11 >= r13) goto L5;
        Segment r0 = r9.writableSegment$okio(1);
        int r1 = Math.min(r13 - r11, 8192 - r0.limit);
        int r4 = r11 + r1;
        ArraysKt.copyInto(r10, r0.data, r0.limit, r11, r4);
        r0.limit += r1;
        r11 = r4;
        goto L3
    L5:
        r9.setSize$okio(r9.size() + r7);
        return r9;
    }

    public static final byte[] commonReadByteArray(Buffer r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.readByteArray(r2.size());
    }

    public static final byte[] commonReadByteArray(Buffer r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L16;
        if (r2.size() < r3) goto L14;
        byte[] r4 = new byte[(int) r3];
        r2.readFully(r4);
        return r4;
    L14:
        throw new EOFException();
    L16:
        throw new IllegalArgumentException(("byteCount: " + r3).toString());
    L5:
        if (r3 > 2147483647L) goto L7;
        r0 = true;
        goto L8
    }

    public static final int commonRead(Buffer r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "sink");
        return r2.read(r3, 0, r3.length);
    }

    public static final void commonReadFully(Buffer r3, byte[] r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "sink");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        int r1 = r3.read(r4, r0, r4.length - r0);
        if (r1 == (-1)) goto L9;
        r0 = r0 + r1;
        goto L4
    L9:
        throw new EOFException();
    }

    public static final int commonRead(Buffer r7, byte[] r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "sink");
        _UtilKt.checkOffsetAndCount(r8.length, r9, r10);
        Segment r0 = r7.head;
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r11 = Math.min(r10, r0.limit - r0.pos);
        ArraysKt.copyInto(r0.data, r8, r9, r0.pos, r0.pos + r11);
        r0.pos += r11;
        r7.setSize$okio(r7.size() - ((long) r11));
        if (r0.pos != r0.limit) goto L9;
        r7.head = r0.pop();
        SegmentPool.recycle(r0);
    L9:
        return r11;
    }

    public static final long commonReadDecimalLong(Buffer r18) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        if (r18.size() == 0) goto L56;
        int r1 = 0;
        boolean r2 = false;
        long r8 = 0;
        long r6 = -7;
        boolean r5 = false;
    L5:
        Segment r10 = r18.head;
        Intrinsics.checkNotNull(r10);
        byte[] r11 = r10.data;
        int r12 = r10.pos;
        int r13 = r10.limit;
    L6:
        if (r12 >= r13) goto L29;
        byte r15 = r11[r12];
        if (r15 < 48) goto L24;
        if (r15 > 57) goto L24;
        int r14 = 48 - r15;
        if (r8 < OVERFLOW_ZONE) goto L18;
        if (r8 == OVERFLOW_ZONE) goto L15;
    L17:
        r8 = (r8 * 10) + ((long) r14);
    L27:
        r12 = r12 + 1;
        r1 = r1 + 1;
        goto L6
    L15:
        if (r14 >= r6) goto L17;
    L18:
        Buffer r0 = new Buffer().writeDecimalLong(r8).writeByte(r15);
        if (r2 == true) goto L22;
        r0.readByte();
    L22:
        throw new NumberFormatException("Number too large: " + r0.readUtf8());
    L24:
        if (r15 != 45) goto L28;
        if (r1 != 0) goto L28;
        r6 = r6 - 1;
        r2 = true;
    L28:
        r5 = true;
    L29:
        if (r12 != r13) goto L31;
        r18.head = r10.pop();
        SegmentPool.recycle(r10);
    L32:
        if (r5 == true) goto L37;
        if (r18.head != null) goto L5;
    L37:
        r18.setSize$okio(r18.size() - ((long) r1));
        if (r2 == false) goto L40;
        int r16 = 2;
    L41:
        if (r1 < r16) goto L43;
        if (r2 == false) goto L54;
        return r8;
    L54:
        return -r8;
    L43:
        if (r18.size() == 0) goto L50;
        if (r2 == false) goto L46;
        String r3 = "Expected a digit";
    L48:
        throw new NumberFormatException(r3 + " but was 0x" + _UtilKt.toHexString(r18.getByte(0)));
    L46:
        r3 = "Expected a digit or '-'";
        goto L48
    L50:
        throw new EOFException();
    L40:
        r16 = 1;
        goto L41
    L31:
        r10.pos = r12;
        goto L32
    L56:
        throw new EOFException();
    }

    public static final long commonReadHexadecimalUnsignedLong(Buffer r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        if (r14.size() == 0) goto L41;
        int r0 = 0;
        boolean r1 = false;
        long r4 = 0;
    L5:
        Segment r6 = r14.head;
        Intrinsics.checkNotNull(r6);
        byte[] r7 = r6.data;
        int r8 = r6.pos;
        int r9 = r6.limit;
    L6:
        if (r8 >= r9) goto L32;
        byte r10 = r7[r8];
        if (r10 < 48) goto L13;
        if (r10 > 57) goto L13;
        int r11 = r10 - 48;
    L24:
        if (((-1152921504606846976L) & r4) != 0) goto L27;
        r4 = (r4 << 4) | ((long) r11);
        r8 = r8 + 1;
        r0 = r0 + 1;
        goto L6
    L27:
        throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(r4).writeByte(r10).readUtf8());
    L13:
        if (r10 < 97) goto L19;
        if (r10 > 102) goto L19;
        int r12 = r10 - 97;
    L17:
        r11 = r12 + 10;
    L19:
        if (r10 < 65) goto L28;
        if (r10 > 70) goto L28;
        r12 = r10 - 65;
    L28:
        if (r0 == 0) goto L31;
        r1 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + _UtilKt.toHexString(r10));
    L32:
        if (r8 != r9) goto L34;
        r14.head = r6.pop();
        SegmentPool.recycle(r6);
    L35:
        if (r1 == true) goto L38;
        if (r14.head != null) goto L5;
    L38:
        r14.setSize$okio(r14.size() - ((long) r0));
        return r4;
    L34:
        r6.pos = r8;
        goto L35
    L41:
        throw new EOFException();
    }

    public static final ByteString commonReadByteString(Buffer r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.readByteString(r2.size());
    }

    public static final ByteString commonReadByteString(Buffer r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L20;
        if (r2.size() < r3) goto L18;
        if (r3 < 4096) goto L16;
        ByteString r1 = r2.snapshot((int) r3);
        r2.skip(r3);
        return r1;
    L16:
        return new ByteString(r2.readByteArray(r3));
    L18:
        throw new EOFException();
    L20:
        throw new IllegalArgumentException(("byteCount: " + r3).toString());
    L5:
        if (r3 > 2147483647L) goto L7;
        r0 = true;
        goto L8
    }

    public static final int commonSelect(Buffer r3, Options r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "options");
        int r0 = selectPrefix$default(r3, r4, false, 2, null);
        if (r0 != (-1)) goto L5;
        return -1;
    L5:
        r3.skip(r4.getByteStrings$okio()[r0].size());
        return r0;
    }

    public static final void commonReadFully(Buffer r2, Buffer r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "sink");
        if (r2.size() < r4) goto L6;
        r3.write(r2, r4);
        return;
    L6:
        r3.write(r2, r2.size());
        throw new EOFException();
    }

    public static final long commonReadAll(Buffer r4, Sink r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "sink");
        long r0 = r4.size();
        if (r0 <= 0) goto L5;
        r5.write(r4, r0);
    L5:
        return r0;
    }

    public static final String commonReadUtf8(Buffer r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r7 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L25;
        if (r6.size() < r7) goto L23;
        if (r7 != 0) goto L14;
        return "";
    L14:
        Segment r0 = r6.head;
        Intrinsics.checkNotNull(r0);
        if ((((long) r0.pos) + r7) > r0.limit) goto L17;
        int r4 = (int) r7;
        String r1 = _Utf8Kt.commonToUtf8String(r0.data, r0.pos, r0.pos + r4);
        r0.pos += r4;
        r6.setSize$okio(r6.size() - r7);
        if (r0.pos != r0.limit) goto L21;
        r6.head = r0.pop();
        SegmentPool.recycle(r0);
    L21:
        return r1;
    L17:
        return _Utf8Kt.commonToUtf8String$default(r6.readByteArray(r7), 0, 0, 3, null);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(("byteCount: " + r7).toString());
    L5:
        if (r7 > 2147483647L) goto L7;
        r2 = true;
        goto L8
    }

    public static final String commonReadUtf8Line(Buffer r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        long r0 = r4.indexOf((byte) 10);
        if (r0 == (-1)) goto L6;
        return readUtf8Line(r4, r0);
    L6:
        if (r4.size() != 0) goto L11;
        return null;
    L11:
        return r4.readUtf8(r4.size());
    }

    public static final String commonReadUtf8LineStrict(Buffer r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r12 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L26;
        long r1 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L11;
        r1 = r12 + 1;
    L11:
        long r5 = r11.indexOf((byte) 10, 0, r1);
        if (r5 == (-1)) goto L16;
        return readUtf8Line(r11, r5);
    L16:
        if (r1 < r11.size()) goto L18;
    L23:
        Buffer r6 = new Buffer();
        r11.copyTo(r6, 0, Math.min(32, r11.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(r11.size(), r12) + " content=" + r6.readByteString().hex() + 8230);
    L18:
        if (r11.getByte(r1 - 1) != 13) goto L23;
        if (r11.getByte(r1) != 10) goto L23;
        return readUtf8Line(r11, r1);
    L26:
        throw new IllegalArgumentException(("limit < 0: " + r12).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final int commonReadUtf8CodePoint(Buffer r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        if (r14.size() == 0) goto L44;
        byte r0 = r14.getByte(0);
        boolean r2 = false;
        if ((r0 & 128) != 0) goto L8;
        int r1 = r0 & 127;
        int r7 = 0;
        int r6 = 1;
    L16:
        long r10 = r6;
        if (r14.size() < r10) goto L40;
        int r3 = 1;
    L19:
        if (r3 >= r6) goto L25;
        long r8 = r3;
        byte r12 = r14.getByte(r8);
        if ((r12 & 192) != 128) goto L23;
        r1 = (r1 << 6) | (r12 & Utf8.REPLACEMENT_BYTE);
        r3 = r3 + 1;
        goto L19
    L23:
        r14.skip(r8);
        return 65533;
    L25:
        r14.skip(r10);
        if (r1 <= 1114111) goto L29;
        return 65533;
    L29:
        if (55296 <= r1) goto L31;
    L33:
        if (r2 == true) goto L48;
        if (r1 >= r7) goto L38;
        return 65533;
    L38:
        return r1;
    L48:
        return 65533;
    L31:
        if (r1 >= 57344) goto L33;
        r2 = true;
        goto L33
    L40:
        throw new EOFException("size < " + r6 + ": " + r14.size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(r0) + ')');
    L8:
        if ((r0 & 224) != 192) goto L11;
        r1 = r0 & Ascii.US;
        r6 = 2;
        r7 = 128;
        goto L16
    L11:
        if ((r0 & 240) != 224) goto L14;
        r1 = r0 & 15;
        r6 = 3;
        r7 = 2048;
        goto L16
    L14:
        if ((r0 & 248) != 240) goto L41;
        r1 = r0 & 7;
        r6 = 4;
        r7 = 65536;
        goto L16
    L41:
        r14.skip(1);
        return 65533;
    L44:
        throw new EOFException();
    }

    public static final Buffer commonWriteUtf8(Buffer r12, String r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "string");
        if (r14 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L58;
        if (r15 < r14) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L56;
        if (r15 > r13.length()) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L54;
    L16:
        if (r14 >= r15) goto L52;
        char r5 = r13.charAt(r14);
        if (r5 < 128) goto L19;
        if (r5 < 2048) goto L28;
        if (r5 < 55296) goto L51;
        if (r5 > 57343) goto L51;
        int r6 = r14 + 1;
        if (r6 >= r15) goto L38;
        char r8 = r13.charAt(r6);
    L40:
        if (r5 > 56319) goto L50;
        if (56320 <= r8) goto L44;
    L46:
        boolean r9 = false;
    L47:
        if (r9 == false) goto L50;
        int r7 = (((r5 & 1023) << 10) | (r8 & 1023)) + 65536;
        Segment r10 = r12.writableSegment$okio(4);
        r10.data[r10.limit] = (byte) ((r7 >> 18) | 240);
        r10.data[r10.limit + 1] = (byte) (((r7 >> 12) & 63) | 128);
        r10.data[r10.limit + 2] = (byte) (((r7 >> 6) & 63) | 128);
        r10.data[r10.limit + 3] = (byte) ((r7 & 63) | 128);
        r10.limit += 4;
        r12.setSize$okio(r12.size() + 4);
        r14 = r14 + 2;
        goto L16
    L44:
        if (r8 >= 57344) goto L46;
        r9 = true;
    L50:
        r12.writeByte(63);
        r14 = r6;
        goto L16
    L38:
        r8 = 0;
    L51:
        Segment r11 = r12.writableSegment$okio(3);
        r11.data[r11.limit] = (byte) ((r5 >> '\f') | 224);
        r11.data[r11.limit + 1] = (byte) ((63 & (r5 >> 6)) | 128);
        r11.data[r11.limit + 2] = (byte) ((r5 & '?') | 128);
        r11.limit += 3;
        r12.setSize$okio(r12.size() + 3);
    L29:
        r14 = r14 + 1;
        goto L16
    L28:
        Segment r16 = r12.writableSegment$okio(2);
        r16.data[r16.limit] = (byte) ((r5 >> 6) | 192);
        r16.data[r16.limit + 1] = (byte) ((r5 & '?') | 128);
        r16.limit += 2;
        r12.setSize$okio(r12.size() + 2);
        goto L29
    L19:
        Segment r17 = r12.writableSegment$okio(1);
        byte[] r18 = r17.data;
        int r19 = r17.limit - r14;
        int r20 = Math.min(r15, 8192 - r19);
        int r21 = r14 + 1;
        r18[r14 + r19] = (byte) r5;
    L20:
        r14 = r21;
        if (r14 >= r20) goto L25;
        char r22 = r13.charAt(r14);
        if (r22 >= 128) goto L25;
        r21 = r14 + 1;
        r18[r14 + r19] = (byte) r22;
    L25:
        int r23 = (r19 + r14) - r17.limit;
        r17.limit += r23;
        r12.setSize$okio(r12.size() + ((long) r23));
        goto L16
    L52:
        return r12;
    L54:
        throw new IllegalArgumentException(("endIndex > string.length: " + r15 + " > " + r13.length()).toString());
    L14:
        r4 = false;
        goto L15
    L56:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r15 + " < " + r14).toString());
    L9:
        r3 = false;
        goto L10
    L58:
        throw new IllegalArgumentException(("beginIndex < 0: " + r14).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 >= 128) goto L6;
        r10.writeByte(r11);
    L21:
        return r10;
    L6:
        if (r11 >= 2048) goto L8;
        Segment r1 = r10.writableSegment$okio(2);
        r1.data[r1.limit] = (byte) ((r11 >> 6) | 192);
        r1.data[r1.limit + 1] = (byte) ((r11 & 63) | 128);
        r1.limit += 2;
        r10.setSize$okio(r10.size() + 2);
        goto L21
    L8:
        boolean r5 = false;
        if (55296 <= r11) goto L11;
    L13:
        if (r5 == false) goto L16;
        r10.writeByte(63);
        goto L21
    L16:
        if (r11 >= 65536) goto L19;
        Segment r2 = r10.writableSegment$okio(3);
        r2.data[r2.limit] = (byte) ((r11 >> 12) | 224);
        r2.data[r2.limit + 1] = (byte) (((r11 >> 6) & 63) | 128);
        r2.data[r2.limit + 2] = (byte) ((r11 & 63) | 128);
        r2.limit += 3;
        r10.setSize$okio(r10.size() + 3);
        goto L21
    L19:
        if (r11 > 1114111) goto L23;
        Segment r6 = r10.writableSegment$okio(4);
        r6.data[r6.limit] = (byte) ((r11 >> 18) | 240);
        r6.data[r6.limit + 1] = (byte) (((r11 >> 12) & 63) | 128);
        r6.data[r6.limit + 2] = (byte) (((r11 >> 6) & 63) | 128);
        r6.data[r6.limit + 3] = (byte) ((r11 & 63) | 128);
        r6.limit += 4;
        r10.setSize$okio(r10.size() + 4);
        goto L21
    L23:
        throw new IllegalArgumentException("Unexpected code point: 0x" + _UtilKt.toHexString(r11));
    L11:
        if (r11 >= 57344) goto L13;
        r5 = true;
        goto L13
    }

    public static final long commonWriteAll(Buffer r6, Source r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "source");
        long r0 = 0;
    L3:
        long r2 = r7.read(r6, 8192);
        if (r2 == (-1)) goto L6;
        r0 = r0 + r2;
        goto L3
    L6:
        return r0;
    }

    public static final Buffer commonWrite(Buffer r4, Source r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "source");
    L4:
        if (r6 <= 0) goto L10;
        long r0 = r5.read(r4, r6);
        if (r0 == (-1)) goto L9;
        r6 = r6 - r0;
        goto L4
    L9:
        throw new EOFException();
    L10:
        return r4;
    }

    public static final Buffer commonWriteByte(Buffer r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Segment r0 = r4.writableSegment$okio(1);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        r0.limit = r2 + 1;
        r1[r2] = (byte) r5;
        r4.setSize$okio(r4.size() + 1);
        return r4;
    }

    public static final Buffer commonWriteShort(Buffer r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Segment r0 = r5.writableSegment$okio(2);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 8) & 255);
        r1[r3] = (byte) (r6 & 255);
        r0.limit = r3 + 1;
        r5.setSize$okio(r5.size() + 2);
        return r5;
    }

    public static final Buffer commonWriteInt(Buffer r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Segment r0 = r5.writableSegment$okio(4);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 24) & 255);
        int r4 = r3 + 1;
        r1[r3] = (byte) ((r6 >>> 16) & 255);
        int r7 = r4 + 1;
        r1[r4] = (byte) ((r6 >>> 8) & 255);
        r1[r7] = (byte) (r6 & 255);
        r0.limit = r7 + 1;
        r5.setSize$okio(r5.size() + 4);
        return r5;
    }

    public static final Buffer commonWriteLong(Buffer r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Segment r1 = r9.writableSegment$okio(8);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r10 >>> 56) & 255);
        int r5 = r4 + 1;
        r2[r4] = (byte) ((r10 >>> 48) & 255);
        int r6 = r5 + 1;
        r2[r5] = (byte) ((r10 >>> 40) & 255);
        int r7 = r6 + 1;
        r2[r6] = (byte) ((r10 >>> 32) & 255);
        int r8 = r7 + 1;
        r2[r7] = (byte) ((r10 >>> 24) & 255);
        int r11 = r8 + 1;
        r2[r8] = (byte) ((r10 >>> 16) & 255);
        int r12 = r11 + 1;
        r2[r11] = (byte) ((r10 >>> 8) & 255);
        r2[r12] = (byte) (r10 & 255);
        r1.limit = r12 + 1;
        r9.setSize$okio(r9.size() + 8);
        return r9;
    }

    public static final void commonWrite(Buffer r8, Buffer r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "source");
        if (r9 == r8) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L35;
        _UtilKt.checkOffsetAndCount(r9.size(), 0, r10);
    L9:
        if (r10 <= 0) goto L33;
        Segment r2 = r9.head;
        Intrinsics.checkNotNull(r2);
        int r3 = r2.limit;
        Segment r4 = r9.head;
        Intrinsics.checkNotNull(r4);
        if (r10 < (r3 - r4.pos)) goto L13;
    L28:
        Segment r5 = r9.head;
        Intrinsics.checkNotNull(r5);
        long r6 = r5.limit - r5.pos;
        r9.head = r5.pop();
        if (r8.head != null) goto L31;
        r8.head = r5;
        r5.prev = r5;
        r5.next = r5.prev;
    L32:
        r9.setSize$okio(r9.size() - r6);
        r8.setSize$okio(r8.size() + r6);
        r10 = r10 - r6;
        goto L9
    L31:
        Segment r7 = r8.head;
        Intrinsics.checkNotNull(r7);
        Segment r11 = r7.prev;
        Intrinsics.checkNotNull(r11);
        r11.push(r5).compact();
        goto L32
    L13:
        if (r8.head == null) goto L15;
        Segment r12 = r8.head;
        Intrinsics.checkNotNull(r12);
        Segment r13 = r12.prev;
    L16:
        if (r13 != null) goto L18;
    L27:
        Segment r14 = r9.head;
        Intrinsics.checkNotNull(r14);
        r9.head = r14.split((int) r10);
        goto L28
    L18:
        if (r13.owner == false) goto L27;
        long r15 = ((long) r13.limit) + r10;
        if (r13.shared == false) goto L22;
        int r16 = 0;
    L24:
        if ((r15 - ((long) r16)) > 8192) goto L27;
        Segment r0 = r9.head;
        Intrinsics.checkNotNull(r0);
        r0.writeTo(r13, (int) r10);
        r9.setSize$okio(r9.size() - r10);
        r8.setSize$okio(r8.size() + r10);
        return;
    L22:
        r16 = r13.pos;
        goto L24
    L15:
        r13 = null;
        goto L16
    L33:
        return;
    L35:
        throw new IllegalArgumentException("source == this".toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final long commonRead(Buffer r4, Buffer r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "sink");
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        if (r4.size() != 0) goto L12;
        return -1;
    L12:
        if (r6 <= r4.size()) goto L14;
        r6 = r4.size();
    L14:
        r5.write(r4, r6);
        return r6;
    L17:
        throw new IllegalArgumentException(("byteCount < 0: " + r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final long commonIndexOf(Buffer r9, byte r10, long r11, long r13) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        long r0 = 0;
        boolean r3 = false;
        if (0 <= r11) goto L5;
    L7:
        if (r3 == false) goto L52;
        if (r13 <= r9.size()) goto L12;
        r13 = r9.size();
    L12:
        if (r11 != r13) goto L14;
        return -1;
    L14:
        Segment r2 = r9.head;
        if (r2 != null) goto L18;
        return -1;
    L18:
        if ((r9.size() - r11) >= r11) goto L36;
        r0 = r9.size();
    L21:
        if (r0 <= r11) goto L23;
        r2 = r2.prev;
        Intrinsics.checkNotNull(r2);
        r0 = r0 - ((long) (r2.limit - r2.pos));
        goto L21
    L23:
        if (r2 != null) goto L26;
        return -1;
    L26:
        if (r0 >= r13) goto L35;
        byte[] r12 = r2.data;
        int r5 = (int) Math.min(r2.limit, (((long) r2.pos) + r13) - r0);
        int r14 = (int) ((((long) r2.pos) + r11) - r0);
    L28:
        if (r14 >= r5) goto L34;
        if (r12[r14] == r10) goto L32;
        r14 = r14 + 1;
    L32:
        return ((long) (r14 - r2.pos)) + r0;
    L34:
        r0 = r0 + ((long) (r2.limit - r2.pos));
        r2 = r2.next;
        Intrinsics.checkNotNull(r2);
        r11 = r0;
        goto L26
    L35:
        return -1;
    L36:
        long r6 = ((long) (r2.limit - r2.pos)) + r0;
        if (r6 > r11) goto L39;
        r2 = r2.next;
        Intrinsics.checkNotNull(r2);
        r0 = r6;
        goto L36
    L39:
        if (r2 != null) goto L42;
        return -1;
    L42:
        if (r0 >= r13) goto L50;
        byte[] r15 = r2.data;
        int r7 = (int) Math.min(r2.limit, (((long) r2.pos) + r13) - r0);
        r14 = (int) ((((long) r2.pos) + r11) - r0);
    L44:
        if (r14 >= r7) goto L49;
        if (r15[r14] == r10) goto L32;
        r14 = r14 + 1;
        goto L44
    L49:
        r0 = r0 + ((long) (r2.limit - r2.pos));
        r2 = r2.next;
        Intrinsics.checkNotNull(r2);
        r11 = r0;
        goto L42
    L50:
        return -1;
    L52:
        throw new IllegalArgumentException(("size=" + r9.size() + " fromIndex=" + r11 + " toIndex=" + r13).toString());
    L5:
        if (r11 > r13) goto L7;
        r3 = true;
        goto L7
    }

    public static final long commonIndexOf(Buffer r16, ByteString r17, long r18) {
        long r1 = r18;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r17, "bytes");
        if (r17.size() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L63;
        long r7 = 0;
        if (r1 < 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L61;
        Segment r5 = r16.head;
        if (r5 != null) goto L16;
        return -1;
    L16:
        if ((r16.size() - r1) >= r1) goto L38;
        long r8 = r16.size();
    L19:
        if (r8 <= r1) goto L21;
        r5 = r5.prev;
        Intrinsics.checkNotNull(r5);
        r8 = r8 - ((long) (r5.limit - r5.pos));
        goto L19
    L21:
        if (r5 != null) goto L23;
        return -1;
    L23:
        byte[] r11 = r17.internalArray$okio();
        byte r6 = r11[0];
        int r9 = r17.size();
        long r14 = (r16.size() - ((long) r9)) + 1;
    L25:
        if (r8 >= r14) goto L36;
        byte[] r0 = r5.data;
        int r10 = (int) Math.min(r5.limit, (((long) r5.pos) + r14) - r8);
        int r2 = (int) ((((long) r5.pos) + r1) - r8);
    L27:
        if (r2 >= r10) goto L35;
        if (r0[r2] != r6) goto L34;
        if (rangeEquals(r5, r2 + 1, r11, 1, r9) == false) goto L34;
        return ((long) (r2 - r5.pos)) + r8;
    L34:
        r2 = r2 + 1;
        goto L27
    L35:
        r8 = r8 + ((long) (r5.limit - r5.pos));
        r5 = r5.next;
        Intrinsics.checkNotNull(r5);
        r1 = r8;
        goto L25
    L36:
        return -1;
    L38:
        long r12 = ((long) (r5.limit - r5.pos)) + r7;
        if (r12 > r1) goto L41;
        r5 = r5.next;
        Intrinsics.checkNotNull(r5);
        r7 = r12;
        goto L38
    L41:
        if (r5 != null) goto L44;
        return -1;
    L44:
        byte[] r13 = r17.internalArray$okio();
        byte r15 = r13[0];
        int r19 = r17.size();
        long r110 = (r16.size() - ((long) r19)) + 1;
    L46:
        if (r7 >= r110) goto L58;
        byte[] r20 = r5.data;
        long r111 = r7;
        int r21 = (int) Math.min(r5.limit, (((long) r5.pos) + r110) - r7);
        int r22 = (int) ((((long) r5.pos) + r1) - r111);
    L48:
        if (r22 >= r21) goto L57;
        if (r20[r22] != r15) goto L56;
        if (rangeEquals(r5, r22 + 1, r13, 1, r19) == false) goto L56;
        return ((long) (r22 - r5.pos)) + r111;
    L56:
        r22 = r22 + 1;
        goto L48
    L57:
        r7 = r111 + ((long) (r5.limit - r5.pos));
        r5 = r5.next;
        Intrinsics.checkNotNull(r5);
        r1 = r7;
        goto L46
    L58:
        return -1;
    L61:
        throw new IllegalArgumentException(("fromIndex < 0: " + r1).toString());
    L10:
        r4 = false;
        goto L11
    L63:
        throw new IllegalArgumentException("bytes is empty".toString());
    L5:
        r3 = false;
        goto L6
    }

    public static final boolean commonRangeEquals(Buffer r6, long r7, ByteString r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r9, "bytes");
        if (r7 < 0) goto L19;
        if (r10 < 0) goto L19;
        if (r11 < 0) goto L19;
        if ((r6.size() - r7) < r11) goto L19;
        if ((r9.size() - r10) < r11) goto L19;
        int r0 = 0;
    L12:
        if (r0 >= r11) goto L17;
        if (r6.getByte(((long) r0) + r7) != r9.getByte(r10 + r0)) goto L15;
        r0 = r0 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    public static final boolean commonEquals(Buffer r18, Object r19) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        if (r18 != r19) goto L6;
        return true;
    L6:
        if ((r19 instanceof Buffer) == true) goto L8;
        return false;
    L8:
        Buffer r1 = (Buffer) r19;
        if (r18.size() == r1.size()) goto L12;
        return false;
    L12:
        if (r18.size() != 0) goto L14;
        return true;
    L14:
        Segment r3 = r18.head;
        Intrinsics.checkNotNull(r3);
        Segment r2 = r1.head;
        Intrinsics.checkNotNull(r2);
        int r5 = r3.pos;
        int r6 = r2.pos;
        long r9 = 0;
    L16:
        if (r9 >= r18.size()) goto L31;
        long r11 = Math.min(r3.limit - r5, r2.limit - r6);
        long r13 = 0;
    L19:
        if (r13 >= r11) goto L25;
        int r16 = r5 + 1;
        int r17 = r6 + 1;
        if (r3.data[r5] != r2.data[r6]) goto L22;
        r13 = r13 + 1;
        r5 = r16;
        r6 = r17;
        goto L19
    L22:
        return false;
    L25:
        if (r5 != r3.limit) goto L28;
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r5 = r3.pos;
    L28:
        if (r6 != r2.limit) goto L30;
        r2 = r2.next;
        Intrinsics.checkNotNull(r2);
        r6 = r2.pos;
    L30:
        r9 = r9 + r11;
        goto L16
    L31:
        return true;
    }

    public static final int commonHashCode(Buffer r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Segment r0 = r5.head;
        if (r0 != null) goto L6;
        return 0;
    L6:
        int r1 = 1;
    L7:
        int r2 = r0.pos;
        int r3 = r0.limit;
    L8:
        if (r2 >= r3) goto L10;
        r1 = (r1 * 31) + r0.data[r2];
        r2 = r2 + 1;
        goto L8
    L10:
        r0 = r0.next;
        Intrinsics.checkNotNull(r0);
        if (r0 != r5.head) goto L7;
        return r1;
    }

    public static final Buffer commonCopy(Buffer r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Buffer r0 = new Buffer();
        if (r6.size() != 0) goto L5;
        return r0;
    L5:
        Segment r1 = r6.head;
        Intrinsics.checkNotNull(r1);
        Segment r2 = r1.sharedCopy();
        r0.head = r2;
        r2.prev = r0.head;
        r2.next = r2.prev;
        Segment r3 = r1.next;
    L6:
        if (r3 == r1) goto L8;
        Segment r4 = r2.prev;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r3);
        r4.push(r3.sharedCopy());
        r3 = r3.next;
        goto L6
    L8:
        r0.setSize$okio(r6.size());
        return r0;
    }

    public static final ByteString commonSnapshot(Buffer r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.size() > 2147483647L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return r4.snapshot((int) r4.size());
    L10:
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + r4.size()).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final ByteString commonSnapshot(Buffer r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r7 == 0) goto L5;
        _UtilKt.checkOffsetAndCount(r6.size(), 0, r7);
        Segment r0 = r6.head;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= r7) goto L13;
        Intrinsics.checkNotNull(r0);
        if (r0.limit == r0.pos) goto L12;
        r2 = r2 + (r0.limit - r0.pos);
        r3 = r3 + 1;
        r0 = r0.next;
        goto L7
    L12:
        throw new AssertionError("s.limit == s.pos");
    L13:
        byte[][] r4 = new byte[r3][];
        int[] r5 = new int[r3 * 2];
        Segment r8 = r6.head;
        int r9 = 0;
    L14:
        if (r1 >= r7) goto L17;
        Intrinsics.checkNotNull(r8);
        r4[r9] = r8.data;
        r1 = r1 + (r8.limit - r8.pos);
        r5[r9] = Math.min(r1, r7);
        r5[r4.length + r9] = r8.pos;
        r8.shared = true;
        r9 = r9 + 1;
        r8 = r8.next;
        goto L14
    L17:
        return new SegmentedByteString(r4, r5);
    L5:
        return ByteString.EMPTY;
    }

    public static final Buffer.UnsafeCursor commonReadUnsafe(Buffer r2, Buffer.UnsafeCursor r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "unsafeCursor");
        Buffer.UnsafeCursor r4 = _UtilKt.resolveDefaultParameter(r3);
        if (r4.buffer != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r4.buffer = r2;
        r4.readWrite = false;
        return r4;
    L10:
        throw new IllegalStateException("already attached to a buffer".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(Buffer r2, Buffer.UnsafeCursor r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "unsafeCursor");
        Buffer.UnsafeCursor r4 = _UtilKt.resolveDefaultParameter(r3);
        if (r4.buffer != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r4.buffer = r2;
        r4.readWrite = true;
        return r4;
    L10:
        throw new IllegalStateException("already attached to a buffer".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final int commonNext(Buffer.UnsafeCursor r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        long r0 = r4.offset;
        Buffer r2 = r4.buffer;
        Intrinsics.checkNotNull(r2);
        if (r0 == r2.size()) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        if (r4.offset != (-1)) goto L10;
        long r3 = 0;
    L12:
        return r4.seek(r3);
    L10:
        r3 = r4.offset + ((long) (r4.end - r4.start));
        goto L12
    L14:
        throw new IllegalStateException("no more bytes".toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final int commonSeek(Buffer.UnsafeCursor r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Buffer r0 = r12.buffer;
        if (r0 == null) goto L42;
        if (r13 < (-1)) goto L40;
        if (r13 > r0.size()) goto L40;
        if (r13 != (-1)) goto L10;
    L37:
        r12.setSegment$okio(null);
        r12.offset = r13;
        r12.data = null;
        r12.start = -1;
        r12.end = -1;
        return -1;
    L10:
        if (r13 == r0.size()) goto L37;
        long r1 = r0.size();
        Segment r3 = r0.head;
        Segment r4 = r0.head;
        long r6 = 0;
        if (r12.getSegment$okio() == null) goto L19;
        long r8 = r12.offset;
        int r5 = r12.start;
        Segment r10 = r12.getSegment$okio();
        Intrinsics.checkNotNull(r10);
        long r9 = r8 - ((long) (r5 - r10.pos));
        if (r9 <= r13) goto L17;
        r4 = r12.getSegment$okio();
        r1 = r9;
        goto L19
    L17:
        r3 = r12.getSegment$okio();
        r6 = r9;
    L19:
        if ((r1 - r13) <= (r13 - r6)) goto L24;
    L20:
        Intrinsics.checkNotNull(r3);
        if (r13 < (((long) (r3.limit - r3.pos)) + r6)) goto L28;
        r6 = r6 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
    L28:
        if (r12.readWrite == false) goto L35;
        Intrinsics.checkNotNull(r3);
        if (r3.shared == false) goto L35;
        Segment r2 = r3.unsharedCopy();
        if (r0.head != r3) goto L34;
        r0.head = r2;
    L34:
        r3 = r3.push(r2);
        Segment r7 = r3.prev;
        Intrinsics.checkNotNull(r7);
        r7.pop();
    L35:
        r12.setSegment$okio(r3);
        r12.offset = r13;
        Intrinsics.checkNotNull(r3);
        r12.data = r3.data;
        r12.start = r3.pos + ((int) (r13 - r6));
        r12.end = r3.limit;
        return r12.end - r12.start;
    L24:
        if (r1 <= r13) goto L26;
        Intrinsics.checkNotNull(r4);
        r4 = r4.prev;
        Intrinsics.checkNotNull(r4);
        r1 = r1 - ((long) (r4.limit - r4.pos));
        goto L24
    L26:
        r6 = r1;
        r3 = r4;
    L40:
        throw new ArrayIndexOutOfBoundsException("offset=" + r13 + " > size=" + r0.size());
    L42:
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final long commonResizeBuffer(Buffer.UnsafeCursor r16, long r17) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Buffer r3 = r16.buffer;
        if (r3 == null) goto L36;
        if (r16.readWrite == false) goto L34;
        long r4 = r3.size();
        int r8 = 1;
        if (r17 <= r4) goto L9;
        if (r17 <= r4) goto L31;
        long r11 = r17 - r4;
        boolean r6 = true;
    L26:
        if (r11 <= 0) goto L31;
        Segment r13 = r3.writableSegment$okio(r8);
        int r14 = (int) Math.min(r11, 8192 - r13.limit);
        r13.limit += r14;
        r11 = r11 - ((long) r14);
        if (r6 == false) goto L30;
        r16.setSegment$okio(r13);
        r16.offset = r4;
        r16.data = r13.data;
        r16.start = r13.limit - r14;
        r16.end = r13.limit;
        r6 = false;
    L30:
        r8 = 1;
    L31:
        r3.setSize$okio(r17);
        return r4;
    L9:
        if (r17 < 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L22;
        long r9 = r4 - r17;
    L15:
        if (r9 <= 0) goto L20;
        Segment r10 = r3.head;
        Intrinsics.checkNotNull(r10);
        Segment r12 = r10.prev;
        Intrinsics.checkNotNull(r12);
        long r15 = r12.limit - r12.pos;
        if (r15 > r9) goto L19;
        r3.head = r12.pop();
        SegmentPool.recycle(r12);
        r9 = r9 - r15;
        goto L15
    L19:
        r12.limit -= (int) r9;
    L20:
        r16.setSegment$okio(null);
        r16.offset = r17;
        r16.data = null;
        r16.start = -1;
        r16.end = -1;
        goto L31
    L22:
        throw new IllegalArgumentException(("newSize < 0: " + r17).toString());
    L11:
        r7 = false;
        goto L12
    L34:
        throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
    L36:
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final long commonExpandBuffer(Buffer.UnsafeCursor r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        boolean r0 = true;
        if (r10 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L25;
        if (r10 <= 8192) goto L11;
        r0 = false;
    L11:
        if (r0 == false) goto L23;
        Buffer r1 = r9.buffer;
        if (r1 == null) goto L21;
        if (r9.readWrite == false) goto L19;
        long r3 = r1.size();
        Segment r11 = r1.writableSegment$okio(r10);
        int r4 = 8192 - r11.limit;
        r11.limit = 8192;
        long r5 = r4;
        r1.setSize$okio(r3 + r5);
        r9.setSegment$okio(r11);
        r9.offset = r3;
        r9.data = r11.data;
        r9.start = 8192 - r4;
        r9.end = 8192;
        return r5;
    L19:
        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
    L21:
        throw new IllegalStateException("not attached to a buffer".toString());
    L23:
        throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + r10).toString());
    L25:
        throw new IllegalArgumentException(("minByteCount <= 0: " + r10).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final void commonClose(Buffer.UnsafeCursor r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.buffer == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r3.buffer = null;
        r3.setSegment$okio(null);
        r3.offset = -1;
        r3.data = null;
        r3.start = -1;
        r3.end = -1;
        return;
    L10:
        throw new IllegalStateException("not attached to a buffer".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final long commonIndexOfElement(Buffer r11, ByteString r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "targetBytes");
        long r0 = 0;
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L81;
        Segment r3 = r11.head;
        if (r3 != null) goto L11;
        return -1;
    L11:
        if ((r11.size() - r13) >= r13) goto L48;
        r0 = r11.size();
    L14:
        if (r0 <= r13) goto L16;
        r3 = r3.prev;
        Intrinsics.checkNotNull(r3);
        r0 = r0 - ((long) (r3.limit - r3.pos));
        goto L14
    L16:
        if (r3 != null) goto L19;
        return -1;
    L19:
        if (r12.size() != 2) goto L34;
        byte r4 = r12.getByte(0);
        byte r14 = r12.getByte(1);
    L22:
        if (r0 >= r11.size()) goto L47;
        byte[] r5 = r3.data;
        int r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r16 = r3.limit;
    L24:
        if (r15 >= r16) goto L33;
        byte r7 = r5[r15];
        if (r7 == r4) goto L30;
        if (r7 == r14) goto L30;
        r15 = r15 + 1;
    L30:
        int r17 = r3.pos;
    L32:
        return ((long) (r15 - r17)) + r0;
    L33:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r13 = r0;
    L47:
        return -1;
    L34:
        byte[] r18 = r12.internalArray$okio();
    L36:
        if (r0 >= r11.size()) goto L47;
        byte[] r6 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r19 = r3.limit;
    L38:
        if (r15 >= r19) goto L46;
        byte r8 = r6[r15];
        int r9 = r18.length;
        int r10 = 0;
    L40:
        if (r10 >= r9) goto L45;
        if (r8 == r18[r10]) goto L43;
        r10 = r10 + 1;
    L43:
        r17 = r3.pos;
        goto L32
    L45:
        r15 = r15 + 1;
        goto L38
    L46:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r13 = r0;
    L48:
        long r20 = ((long) (r3.limit - r3.pos)) + r0;
        if (r20 > r13) goto L51;
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r0 = r20;
        goto L48
    L51:
        if (r3 != null) goto L54;
        return -1;
    L54:
        if (r12.size() != 2) goto L66;
        byte r21 = r12.getByte(0);
        byte r110 = r12.getByte(1);
    L57:
        if (r0 >= r11.size()) goto L79;
        byte[] r22 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r111 = r3.limit;
    L59:
        if (r15 >= r111) goto L65;
        byte r23 = r22[r15];
        if (r23 == r21) goto L30;
        if (r23 == r110) goto L30;
        r15 = r15 + 1;
        goto L59
    L65:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r13 = r0;
    L79:
        return -1;
    L66:
        byte[] r112 = r12.internalArray$okio();
    L68:
        if (r0 >= r11.size()) goto L79;
        byte[] r24 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r113 = r3.limit;
    L70:
        if (r15 >= r113) goto L78;
        byte r25 = r24[r15];
        int r26 = r112.length;
        int r27 = 0;
    L72:
        if (r27 >= r26) goto L77;
        if (r25 == r112[r27]) goto L43;
        r27 = r27 + 1;
        goto L72
    L77:
        r15 = r15 + 1;
        goto L70
    L78:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r13 = r0;
        goto L68
    L81:
        throw new IllegalArgumentException(("fromIndex < 0: " + r13).toString());
    L5:
        r2 = false;
        goto L6
    }
}
