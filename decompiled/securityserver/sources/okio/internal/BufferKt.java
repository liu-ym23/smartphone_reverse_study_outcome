package okio.internal;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.sysoptimizer.StackLeakChecker;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BufferKt {

    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = null;
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    static {
        HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    }

    public static final void commonClear(@NotNull Buffer r2) {
        Intrinsics.f(r2, "$this$commonClear");
        r2.skip(r2.size());
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer r5) {
        Intrinsics.f(r5, "$this$commonCompleteSegmentByteCount");
        long r0 = r5.size();
        if (r0 != 0) goto L5;
        return 0;
    L5:
        Segment r6 = r5.head;
        Intrinsics.c(r6);
        Segment r7 = r6.prev;
        Intrinsics.c(r7);
        int r2 = r7.limit;
        if (r2 < 8192) goto L8;
        return r0;
    L8:
        if (r7.owner == true) goto L10;
        return r0;
    L10:
        return r0 - ((long) (r2 - r7.pos));
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer r6) {
        Intrinsics.f(r6, "$this$commonCopy");
        Buffer r0 = new Buffer();
        if (r6.size() != 0) goto L5;
        return r0;
    L5:
        Segment r1 = r6.head;
        Intrinsics.c(r1);
        Segment r2 = r1.sharedCopy();
        r0.head = r2;
        r2.prev = r2;
        r2.next = r2;
        Segment r3 = r1.next;
    L6:
        if (r3 == r1) goto L8;
        Segment r4 = r2.prev;
        Intrinsics.c(r4);
        Intrinsics.c(r3);
        r4.push(r3.sharedCopy());
        r3 = r3.next;
        goto L6
    L8:
        r0.setSize$okio(r6.size());
        return r0;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer r7, @NotNull Buffer r8, long r9, long r11) {
        Intrinsics.f(r7, "$this$commonCopyTo");
        Intrinsics.f(r8, "out");
        Util.checkOffsetAndCount(r7.size(), r9, r11);
        if (r11 != 0) goto L5;
        return r7;
    L5:
        r8.setSize$okio(r8.size() + r11);
        Segment r2 = r7.head;
    L6:
        Intrinsics.c(r2);
        int r3 = r2.limit;
        int r4 = r2.pos;
        if (r9 < (r3 - r4)) goto L10;
        r9 = r9 - ((long) (r3 - r4));
        r2 = r2.next;
    L10:
        if (r11 <= 0) goto L16;
        Intrinsics.c(r2);
        Segment r5 = r2.sharedCopy();
        int r6 = r5.pos + ((int) r9);
        r5.pos = r6;
        r5.limit = Math.min(r6 + ((int) r11), r5.limit);
        Segment r10 = r8.head;
        if (r10 != null) goto L14;
        r5.prev = r5;
        r5.next = r5;
        r8.head = r5;
    L15:
        r11 = r11 - ((long) (r5.limit - r5.pos));
        r2 = r2.next;
        r9 = 0;
        goto L10
    L14:
        Intrinsics.c(r10);
        Segment r12 = r10.prev;
        Intrinsics.c(r12);
        r12.push(r5);
        goto L15
    L16:
        return r7;
    }

    public static final boolean commonEquals(@NotNull Buffer r18, @Nullable Object r19) {
        Intrinsics.f(r18, "$this$commonEquals");
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
        Intrinsics.c(r3);
        Segment r2 = r1.head;
        Intrinsics.c(r2);
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
        Intrinsics.c(r3);
        r5 = r3.pos;
    L28:
        if (r6 != r2.limit) goto L30;
        r2 = r2.next;
        Intrinsics.c(r2);
        r6 = r2.pos;
    L30:
        r9 = r9 + r11;
        goto L16
    L31:
        return true;
    }

    public static final byte commonGet(@NotNull Buffer r7, long r8) {
        Intrinsics.f(r7, "$this$commonGet");
        Util.checkOffsetAndCount(r7.size(), r8, 1);
        Segment r0 = r7.head;
        if (r0 != null) goto L5;
        Intrinsics.c(null);
        throw null;
    L5:
        if ((r7.size() - r8) >= r8) goto L12;
        long r1 = r7.size();
    L8:
        if (r1 <= r8) goto L11;
        r0 = r0.prev;
        Intrinsics.c(r0);
        r1 = r1 - ((long) (r0.limit - r0.pos));
        goto L8
    L11:
        return r0.data[(int) ((((long) r0.pos) + r8) - r1)];
    L12:
        long r2 = 0;
    L13:
        int r9 = r0.limit;
        int r3 = r0.pos;
        long r4 = ((long) (r9 - r3)) + r2;
        if (r4 > r8) goto L16;
        r0 = r0.next;
        Intrinsics.c(r0);
        r2 = r4;
        goto L13
    L16:
        return r0.data[(int) ((((long) r3) + r8) - r2)];
    }

    public static final int commonHashCode(@NotNull Buffer r5) {
        Intrinsics.f(r5, "$this$commonHashCode");
        Segment r0 = r5.head;
        if (r0 == null) goto L11;
        int r1 = 1;
    L5:
        int r2 = r0.pos;
        int r3 = r0.limit;
    L6:
        if (r2 >= r3) goto L8;
        r1 = (r1 * 31) + r0.data[r2];
        r2 = r2 + 1;
        goto L6
    L8:
        r0 = r0.next;
        Intrinsics.c(r0);
        if (r0 != r5.head) goto L5;
        return r1;
    L11:
        return 0;
    }

    public static final long commonIndexOf(@NotNull Buffer r9, byte r10, long r11, long r13) {
        Intrinsics.f(r9, "$this$commonIndexOf");
        long r0 = 0;
        if (0 <= r11) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L50;
        if (r13 <= r9.size()) goto L14;
        r13 = r9.size();
    L14:
        if (r11 != r13) goto L16;
        return -1;
    L16:
        Segment r3 = r9.head;
        if (r3 != null) goto L19;
        return -1;
    L19:
        if ((r9.size() - r11) >= r11) goto L35;
        r0 = r9.size();
    L22:
        if (r0 <= r11) goto L25;
        r3 = r3.prev;
        Intrinsics.c(r3);
        r0 = r0 - ((long) (r3.limit - r3.pos));
    L25:
        if (r0 >= r13) goto L34;
        byte[] r12 = r3.data;
        int r5 = (int) Math.min(r3.limit, (((long) r3.pos) + r13) - r0);
        int r14 = (int) ((((long) r3.pos) + r11) - r0);
    L27:
        if (r14 >= r5) goto L33;
        if (r12[r14] == r10) goto L31;
        r14 = r14 + 1;
    L31:
        return ((long) (r14 - r3.pos)) + r0;
    L33:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r11 = r0;
        goto L25
    L34:
        return -1;
    L35:
        long r6 = ((long) (r3.limit - r3.pos)) + r0;
        if (r6 > r11) goto L38;
        r3 = r3.next;
        Intrinsics.c(r3);
        r0 = r6;
    L38:
        if (r0 >= r13) goto L46;
        byte[] r15 = r3.data;
        int r7 = (int) Math.min(r3.limit, (((long) r3.pos) + r13) - r0);
        r14 = (int) ((((long) r3.pos) + r11) - r0);
    L40:
        if (r14 >= r7) goto L45;
        if (r15[r14] == r10) goto L31;
        r14 = r14 + 1;
        goto L40
    L45:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r11 = r0;
        goto L38
    L46:
        return -1;
    L50:
        throw new IllegalArgumentException(("size=" + r9.size() + " fromIndex=" + r11 + " toIndex=" + r13).toString());
    L6:
        if (r13 < r11) goto L8;
        r2 = true;
        goto L9
    }

    public static final long commonIndexOfElement(@NotNull Buffer r11, @NotNull ByteString r12, long r13) {
        Intrinsics.f(r11, "$this$commonIndexOfElement");
        Intrinsics.f(r12, "targetBytes");
        long r0 = 0;
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L77;
        Segment r3 = r11.head;
        if (r3 != null) goto L10;
        return -1;
    L10:
        if ((r11.size() - r13) >= r13) goto L45;
        r0 = r11.size();
    L13:
        if (r0 <= r13) goto L16;
        r3 = r3.prev;
        Intrinsics.c(r3);
        r0 = r0 - ((long) (r3.limit - r3.pos));
        goto L13
    L16:
        if (r12.size() != 2) goto L31;
        byte r4 = r12.getByte(0);
        byte r14 = r12.getByte(1);
    L19:
        if (r0 >= r11.size()) goto L44;
        byte[] r5 = r3.data;
        int r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r16 = r3.limit;
    L21:
        if (r15 >= r16) goto L30;
        byte r7 = r5[r15];
        if (r7 == r4) goto L27;
        if (r7 == r14) goto L27;
        r15 = r15 + 1;
    L27:
        int r17 = r3.pos;
    L29:
        return ((long) (r15 - r17)) + r0;
    L30:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r13 = r0;
    L44:
        return -1;
    L31:
        byte[] r18 = r12.internalArray$okio();
    L33:
        if (r0 >= r11.size()) goto L44;
        byte[] r6 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r19 = r3.limit;
    L35:
        if (r15 >= r19) goto L43;
        byte r8 = r6[r15];
        int r9 = r18.length;
        int r10 = 0;
    L37:
        if (r10 >= r9) goto L42;
        if (r8 == r18[r10]) goto L40;
        r10 = r10 + 1;
    L40:
        r17 = r3.pos;
        goto L29
    L42:
        r15 = r15 + 1;
        goto L35
    L43:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r13 = r0;
    L45:
        long r20 = ((long) (r3.limit - r3.pos)) + r0;
        if (r20 > r13) goto L48;
        r3 = r3.next;
        Intrinsics.c(r3);
        r0 = r20;
        goto L45
    L48:
        if (r12.size() != 2) goto L60;
        byte r21 = r12.getByte(0);
        byte r110 = r12.getByte(1);
    L51:
        if (r0 >= r11.size()) goto L73;
        byte[] r22 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r111 = r3.limit;
    L53:
        if (r15 >= r111) goto L59;
        byte r23 = r22[r15];
        if (r23 == r21) goto L27;
        if (r23 == r110) goto L27;
        r15 = r15 + 1;
        goto L53
    L59:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r13 = r0;
    L73:
        return -1;
    L60:
        byte[] r112 = r12.internalArray$okio();
    L62:
        if (r0 >= r11.size()) goto L73;
        byte[] r24 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r113 = r3.limit;
    L64:
        if (r15 >= r113) goto L72;
        byte r25 = r24[r15];
        int r26 = r112.length;
        int r27 = 0;
    L66:
        if (r27 >= r26) goto L71;
        if (r25 == r112[r27]) goto L40;
        r27 = r27 + 1;
        goto L66
    L71:
        r15 = r15 + 1;
        goto L64
    L72:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r13 = r0;
        goto L62
    L77:
        throw new IllegalArgumentException(a.h("fromIndex < 0: ", r13).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final boolean commonRangeEquals(@NotNull Buffer r6, long r7, @NotNull ByteString r9, int r10, int r11) {
        Intrinsics.f(r6, "$this$commonRangeEquals");
        Intrinsics.f(r9, "bytes");
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

    public static final int commonRead(@NotNull Buffer r2, @NotNull byte[] r3) {
        Intrinsics.f(r2, "$this$commonRead");
        Intrinsics.f(r3, "sink");
        return r2.read(r3, 0, r3.length);
    }

    public static final long commonReadAll(@NotNull Buffer r4, @NotNull Sink r5) {
        Intrinsics.f(r4, "$this$commonReadAll");
        Intrinsics.f(r5, "sink");
        long r0 = r4.size();
        if (r0 <= 0) goto L5;
        r5.write(r4, r0);
    L5:
        return r0;
    }

    public static final byte commonReadByte(@NotNull Buffer r9) {
        Intrinsics.f(r9, "$this$commonReadByte");
        if (r9.size() == 0) goto L10;
        Segment r0 = r9.head;
        Intrinsics.c(r0);
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

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer r2) {
        Intrinsics.f(r2, "$this$commonReadByteArray");
        return r2.readByteArray(r2.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer r2) {
        Intrinsics.f(r2, "$this$commonReadByteString");
        return r2.readByteString(r2.size());
    }

    public static final long commonReadDecimalLong(@NotNull Buffer r15) {
        Intrinsics.f(r15, "$this$commonReadDecimalLong");
        if (r15.size() == 0) goto L44;
        int r0 = 0;
        boolean r1 = false;
        long r5 = -7;
        long r3 = 0;
        boolean r2 = false;
    L5:
        Segment r7 = r15.head;
        Intrinsics.c(r7);
        byte[] r8 = r7.data;
        int r9 = r7.pos;
        int r10 = r7.limit;
    L6:
        if (r9 >= r10) goto L32;
        byte r11 = r8[r9];
        byte r12 = (byte) 48;
        if (r11 < r12) goto L24;
        if (r11 > ((byte) 57)) goto L24;
        int r13 = r12 - r11;
        if (r3 < OVERFLOW_ZONE) goto L18;
        if (r3 == OVERFLOW_ZONE) goto L15;
    L17:
        r3 = (r3 * 10) + ((long) r13);
    L27:
        r9 = r9 + 1;
        r0 = r0 + 1;
        goto L6
    L15:
        if (r13 >= r5) goto L17;
    L18:
        Buffer r16 = new Buffer().writeDecimalLong(r3).writeByte(r11);
        if (r1 == true) goto L22;
        r16.readByte();
    L22:
        throw new NumberFormatException("Number too large: " + r16.readUtf8());
    L24:
        if (r11 != ((byte) 45)) goto L28;
        if (r0 != 0) goto L28;
        r5 = r5 - 1;
        r1 = true;
    L28:
        if (r0 == 0) goto L31;
        r2 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Util.toHexString(r11));
    L32:
        if (r9 != r10) goto L34;
        r15.head = r7.pop();
        SegmentPool.recycle(r7);
    L35:
        if (r2 == true) goto L38;
        if (r15.head != null) goto L5;
    L38:
        r15.setSize$okio(r15.size() - ((long) r0));
        if (r1 == false) goto L42;
        return r3;
    L42:
        return -r3;
    L34:
        r7.pos = r9;
        goto L35
    L44:
        throw new EOFException();
    }

    public static final void commonReadFully(@NotNull Buffer r3, @NotNull byte[] r4) {
        Intrinsics.f(r3, "$this$commonReadFully");
        Intrinsics.f(r4, "sink");
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

    public static final long commonReadHexadecimalUnsignedLong(@NotNull Buffer r14) {
        Intrinsics.f(r14, "$this$commonReadHexadecimalUnsignedLong");
        if (r14.size() == 0) goto L40;
        int r0 = 0;
        boolean r1 = false;
        long r4 = 0;
    L5:
        Segment r6 = r14.head;
        Intrinsics.c(r6);
        byte[] r7 = r6.data;
        int r8 = r6.pos;
        int r9 = r6.limit;
    L6:
        if (r8 >= r9) goto L31;
        byte r10 = r7[r8];
        byte r11 = (byte) 48;
        if (r10 >= r11) goto L10;
    L12:
        byte r12 = (byte) 97;
        if (r10 >= r12) goto L15;
    L17:
        r12 = (byte) 65;
        if (r10 < r12) goto L27;
        if (r10 > ((byte) 70)) goto L27;
    L16:
        int r13 = (r10 - r12) + 10;
    L23:
        if (((-1152921504606846976L) & r4) != 0) goto L26;
        r4 = (r4 << 4) | ((long) r13);
        r8 = r8 + 1;
        r0 = r0 + 1;
        goto L6
    L26:
        throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(r4).writeByte(r10).readUtf8());
    L27:
        if (r0 == 0) goto L30;
        r1 = true;
        goto L31
    L30:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Util.toHexString(r10));
    L15:
        if (r10 > ((byte) HttpStatus.SC_PROCESSING)) goto L17;
    L10:
        if (r10 > ((byte) 57)) goto L12;
        r13 = r10 - r11;
    L31:
        if (r8 != r9) goto L33;
        r14.head = r6.pop();
        SegmentPool.recycle(r6);
    L34:
        if (r1 == true) goto L37;
        if (r14.head != null) goto L5;
    L37:
        r14.setSize$okio(r14.size() - ((long) r0));
        return r4;
    L33:
        r6.pos = r8;
        goto L34
    L40:
        throw new EOFException();
    }

    public static final int commonReadInt(@NotNull Buffer r9) {
        Intrinsics.f(r9, "$this$commonReadInt");
        if (r9.size() < 4) goto L14;
        Segment r0 = r9.head;
        Intrinsics.c(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 4) goto L7;
        byte[] r5 = r0.data;
        int r6 = ((r5[r1 + 1] & 255) << 16) | ((r5[r1] & 255) << 24);
        int r7 = r1 + 3;
        int r8 = r6 | ((r5[r1 + 2] & 255) << 8);
        int r2 = r1 + 4;
        int r10 = (r5[r7] & 255) | r8;
        r9.setSize$okio(r9.size() - 4);
        if (r2 != r4) goto L11;
        r9.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r10;
    L11:
        r0.pos = r2;
        goto L12
    L7:
        return (r9.readByte() & 255) | ((((r9.readByte() & 255) << 24) | ((r9.readByte() & 255) << 16)) | ((r9.readByte() & 255) << 8));
    L14:
        throw new EOFException();
    }

    public static final long commonReadLong(@NotNull Buffer r15) {
        Intrinsics.f(r15, "$this$commonReadLong");
        if (r15.size() < 8) goto L14;
        Segment r0 = r15.head;
        Intrinsics.c(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 8) goto L7;
        byte[] r5 = r0.data;
        int r8 = r1 + 7;
        long r6 = (((((((((long) r5[r1]) & 255) << 56) | ((((long) r5[r1 + 1]) & 255) << 48)) | ((((long) r5[r1 + 2]) & 255) << 40)) | ((((long) r5[r1 + 3]) & 255) << 32)) | ((((long) r5[r1 + 4]) & 255) << 24)) | ((((long) r5[r1 + 5]) & 255) << 16)) | ((((long) r5[r1 + 6]) & 255) << 8);
        int r2 = r1 + 8;
        long r7 = r6 | (((long) r5[r8]) & 255);
        r15.setSize$okio(r15.size() - 8);
        if (r2 != r4) goto L11;
        r15.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r7;
    L11:
        r0.pos = r2;
        goto L12
    L7:
        return ((((long) r15.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) r15.readInt()));
    L14:
        throw new EOFException();
    }

    public static final short commonReadShort(@NotNull Buffer r9) {
        Intrinsics.f(r9, "$this$commonReadShort");
        if (r9.size() < 2) goto L15;
        Segment r0 = r9.head;
        Intrinsics.c(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) >= 2) goto L8;
        int r2 = (r9.readByte() & 255) << 8;
        return (short) ((r9.readByte() & 255) | r2);
    L8:
        byte[] r5 = r0.data;
        int r7 = r1 + 1;
        int r8 = (r5[r1] & 255) << 8;
        int r3 = r1 + 2;
        int r6 = (r5[r7] & 255) | r8;
        r9.setSize$okio(r9.size() - 2);
        if (r3 != r4) goto L11;
        r9.head = r0.pop();
        SegmentPool.recycle(r0);
    L13:
        return (short) r6;
    L11:
        r0.pos = r3;
        goto L13
    L15:
        throw new EOFException();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer r7, long r8) {
        Intrinsics.f(r7, "$this$commonReadUtf8");
        if (r8 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L25;
        if (r7.size() < r8) goto L23;
        if (r8 != 0) goto L14;
        return "";
    L14:
        Segment r0 = r7.head;
        Intrinsics.c(r0);
        int r3 = r0.pos;
        if ((((long) r3) + r8) > r0.limit) goto L17;
        int r4 = (int) r8;
        String r1 = _Utf8Kt.commonToUtf8String(r0.data, r3, r3 + r4);
        r0.pos += r4;
        r7.setSize$okio(r7.size() - r8);
        if (r0.pos != r0.limit) goto L21;
        r7.head = r0.pop();
        SegmentPool.recycle(r0);
    L21:
        return r1;
    L17:
        return _Utf8Kt.commonToUtf8String$default(r7.readByteArray(r8), 0, 0, 3, null);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(a.h("byteCount: ", r8).toString());
    L5:
        if (r8 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L7;
        r2 = true;
        goto L8
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer r12) {
        Intrinsics.f(r12, "$this$commonReadUtf8CodePoint");
        if (r12.size() == 0) goto L42;
        byte r0 = r12.getByte(0);
        int r2 = 1;
        if ((r0 & 128) != 0) goto L8;
        int r1 = r0 & 127;
        int r6 = 0;
        int r5 = 1;
    L16:
        long r9 = r5;
        if (r12.size() < r9) goto L37;
    L18:
        if (r2 >= r5) goto L24;
        long r7 = r2;
        byte r3 = r12.getByte(r7);
        if ((r3 & 192) != 128) goto L22;
        r1 = (r1 << 6) | (r3 & Utf8.REPLACEMENT_BYTE);
        r2 = r2 + 1;
        goto L18
    L22:
        r12.skip(r7);
        return Utf8.REPLACEMENT_CODE_POINT;
    L24:
        r12.skip(r9);
        if (r1 <= 1114111) goto L28;
        return Utf8.REPLACEMENT_CODE_POINT;
    L28:
        if (55296 <= r1) goto L31;
    L33:
        if (r1 >= r6) goto L36;
        return Utf8.REPLACEMENT_CODE_POINT;
    L36:
        return r1;
    L31:
        if (57343 < r1) goto L33;
        return Utf8.REPLACEMENT_CODE_POINT;
    L37:
        StringBuilder r4 = a.p(r5, "size < ", ": ");
        r4.append(r12.size());
        r4.append(" (to read code point prefixed 0x");
        r4.append(Util.toHexString(r0));
        r4.append(')');
        throw new EOFException(r4.toString());
    L8:
        if ((r0 & 224) != 192) goto L11;
        r1 = r0 & 31;
        r5 = 2;
        r6 = 128;
        goto L16
    L11:
        if ((r0 & 240) != 224) goto L14;
        r1 = r0 & 15;
        r5 = 3;
        r6 = 2048;
        goto L16
    L14:
        if ((r0 & 248) != 240) goto L39;
        r1 = r0 & 7;
        r5 = 4;
        r6 = 65536;
        goto L16
    L39:
        r12.skip(1);
        return Utf8.REPLACEMENT_CODE_POINT;
    L42:
        throw new EOFException();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer r4) {
        Intrinsics.f(r4, "$this$commonReadUtf8Line");
        long r0 = r4.indexOf((byte) 10);
        if (r0 == (-1)) goto L6;
        return readUtf8Line(r4, r0);
    L6:
        if (r4.size() != 0) goto L11;
        return null;
    L11:
        return r4.readUtf8(r4.size());
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer r11, long r12) {
        Intrinsics.f(r11, "$this$commonReadUtf8LineStrict");
        if (r12 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L26;
        long r1 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L11;
        r1 = r12 + 1;
    L11:
        byte r2 = (byte) 10;
        long r5 = r11.indexOf(r2, 0, r1);
        if (r5 == (-1)) goto L16;
        return readUtf8Line(r11, r5);
    L16:
        if (r1 < r11.size()) goto L18;
    L23:
        Buffer r6 = new Buffer();
        r11.copyTo(r6, 0, Math.min(32, r11.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(r11.size(), r12) + " content=" + r6.readByteString().hex() + 8230);
    L18:
        if (r11.getByte(r1 - 1) != ((byte) 13)) goto L23;
        if (r11.getByte(r1) != r2) goto L23;
        return readUtf8Line(r11, r1);
    L26:
        throw new IllegalArgumentException(a.h("limit < 0: ", r12).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final int commonSelect(@NotNull Buffer r3, @NotNull Options r4) {
        Intrinsics.f(r3, "$this$commonSelect");
        Intrinsics.f(r4, "options");
        int r0 = selectPrefix$default(r3, r4, false, 2, null);
        if (r0 != (-1)) goto L5;
        return -1;
    L5:
        r3.skip(r4.getByteStrings$okio()[r0].size());
        return r0;
    }

    public static final void commonSkip(@NotNull Buffer r6, long r7) {
        Intrinsics.f(r6, "$this$commonSkip");
    L4:
        if (r7 <= 0) goto L12;
        Segment r0 = r6.head;
        if (r0 == null) goto L11;
        int r1 = (int) Math.min(r7, r0.limit - r0.pos);
        long r4 = r1;
        r6.setSize$okio(r6.size() - r4);
        r7 = r7 - r4;
        int r2 = r0.pos + r1;
        r0.pos = r2;
        if (r2 != r0.limit) goto L4;
        r6.head = r0.pop();
        SegmentPool.recycle(r0);
        goto L4
    L11:
        throw new EOFException();
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer r4) {
        Intrinsics.f(r4, "$this$commonSnapshot");
        if (r4.size() > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L5;
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

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer r2, int r3) {
        Intrinsics.f(r2, "$this$commonWritableSegment");
        boolean r1 = true;
        if (r3 < 1) goto L6;
        if (r3 > 8192) goto L6;
    L7:
        if (r1 == false) goto L19;
        Segment r4 = r2.head;
        if (r4 != null) goto L12;
        Segment r5 = SegmentPool.take();
        r2.head = r5;
        r5.prev = r5;
        r5.next = r5;
        return r5;
    L12:
        Intrinsics.c(r4);
        Segment r6 = r4.prev;
        Intrinsics.c(r6);
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

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer r1, @NotNull ByteString r2, int r3, int r4) {
        Intrinsics.f(r1, "$this$commonWrite");
        Intrinsics.f(r2, "byteString");
        r2.write$okio(r1, r3, r4);
        return r1;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer r0, ByteString r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = r1.size();
    L8:
        Intrinsics.f(r0, "$this$commonWrite");
        Intrinsics.f(r1, "byteString");
        r1.write$okio(r0, r2, r3);
        return r0;
    }

    public static final long commonWriteAll(@NotNull Buffer r6, @NotNull Source r7) {
        Intrinsics.f(r6, "$this$commonWriteAll");
        Intrinsics.f(r7, DBHelper.BATTERY_COL_SOURCE);
        long r0 = 0;
    L3:
        long r2 = r7.read(r6, 8192);
        if (r2 == (-1)) goto L5;
        r0 = r0 + r2;
        goto L3
    L5:
        return r0;
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer r4, int r5) {
        Intrinsics.f(r4, "$this$commonWriteByte");
        Segment r0 = r4.writableSegment$okio(1);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        r0.limit = r2 + 1;
        r1[r2] = (byte) r5;
        r4.setSize$okio(r4.size() + 1);
        return r4;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer r12, long r13) {
        Intrinsics.f(r12, "$this$commonWriteDecimalLong");
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
        r6[r7 - 1] = (byte) 45;
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

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer r12, long r13) {
        Intrinsics.f(r12, "$this$commonWriteHexadecimalUnsignedLong");
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
        int r17 = r15.limit;
        int r18 = (r17 + r14) - 1;
    L7:
        if (r18 < r17) goto L9;
        r16[r18] = getHEX_DIGIT_BYTES()[(int) (15 & r13)];
        r13 = r13 >>> 4;
        r18 = r18 - 1;
        goto L7
    L9:
        r15.limit += r14;
        r12.setSize$okio(r12.size() + ((long) r14));
        return r12;
    L5:
        return r12.writeByte(48);
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer r7, int r8) {
        Intrinsics.f(r7, "$this$commonWriteInt");
        Segment r1 = r7.writableSegment$okio(4);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        r2[r3] = (byte) ((r8 >>> 24) & 255);
        r2[r3 + 1] = (byte) ((r8 >>> 16) & 255);
        int r4 = r3 + 3;
        r2[r3 + 2] = (byte) ((r8 >>> 8) & 255);
        r2[r4] = (byte) (r8 & 255);
        r1.limit = r3 + 4;
        r7.setSize$okio(r7.size() + 4);
        return r7;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer r11, long r12) {
        Intrinsics.f(r11, "$this$commonWriteLong");
        Segment r1 = r11.writableSegment$okio(8);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        r2[r3] = (byte) ((r12 >>> 56) & 255);
        r2[r3 + 1] = (byte) ((r12 >>> 48) & 255);
        r2[r3 + 2] = (byte) ((r12 >>> 40) & 255);
        r2[r3 + 3] = (byte) ((r12 >>> 32) & 255);
        r2[r3 + 4] = (byte) ((r12 >>> 24) & 255);
        r2[r3 + 5] = (byte) ((r12 >>> 16) & 255);
        r2[r3 + 6] = (byte) ((r12 >>> 8) & 255);
        r2[r3 + 7] = (byte) (r12 & 255);
        r1.limit = r3 + 8;
        r11.setSize$okio(r11.size() + 8);
        return r11;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer r6, int r7) {
        Intrinsics.f(r6, "$this$commonWriteShort");
        Segment r1 = r6.writableSegment$okio(2);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r7 >>> 8) & 255);
        r2[r4] = (byte) (r7 & 255);
        r1.limit = r3 + 2;
        r6.setSize$okio(r6.size() + 2);
        return r6;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer r11, @NotNull String r12, int r13, int r14) {
        Intrinsics.f(r11, "$this$commonWriteUtf8");
        Intrinsics.f(r12, "string");
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L54;
        if (r14 < r13) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L52;
        if (r14 > r12.length()) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L49;
    L16:
        if (r13 >= r14) goto L48;
        char r5 = r12.charAt(r13);
        if (r5 < 128) goto L19;
        if (r5 < 2048) goto L28;
        if (r5 < 55296) goto L47;
        if (r5 > 57343) goto L47;
        int r6 = r13 + 1;
        if (r6 >= r14) goto L38;
        char r7 = r12.charAt(r6);
    L40:
        if (r5 > 56319) goto L46;
        if (56320 > r7) goto L46;
        if (57343 < r7) goto L46;
        int r8 = (((r5 & 1023) << 10) | (r7 & 1023)) + 65536;
        Segment r9 = r11.writableSegment$okio(4);
        byte[] r10 = r9.data;
        int r15 = r9.limit;
        r10[r15] = (byte) ((r8 >> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND);
        r10[r15 + 1] = (byte) (((r8 >> 12) & 63) | 128);
        r10[r15 + 2] = (byte) (((r8 >> 6) & 63) | 128);
        r10[r15 + 3] = (byte) ((r8 & 63) | 128);
        r9.limit = r15 + 4;
        r11.setSize$okio(r11.size() + 4);
        r13 = r13 + 2;
    L46:
        r11.writeByte(63);
        r13 = r6;
        goto L16
    L38:
        r7 = 0;
    L47:
        Segment r16 = r11.writableSegment$okio(3);
        byte[] r17 = r16.data;
        int r18 = r16.limit;
        r17[r18] = (byte) ((r5 >> '\f') | 224);
        r17[r18 + 1] = (byte) ((63 & (r5 >> 6)) | 128);
        r17[r18 + 2] = (byte) ((r5 & '?') | 128);
        r16.limit = r18 + 3;
        r11.setSize$okio(r11.size() + 3);
    L29:
        r13 = r13 + 1;
        goto L16
    L28:
        Segment r19 = r11.writableSegment$okio(2);
        byte[] r20 = r19.data;
        int r21 = r19.limit;
        r20[r21] = (byte) ((r5 >> 6) | 192);
        r20[r21 + 1] = (byte) ((r5 & '?') | 128);
        r19.limit = r21 + 2;
        r11.setSize$okio(r11.size() + 2);
        goto L29
    L19:
        Segment r22 = r11.writableSegment$okio(1);
        byte[] r23 = r22.data;
        int r24 = r22.limit - r13;
        int r25 = Math.min(r14, 8192 - r24);
        int r26 = r13 + 1;
        r23[r13 + r24] = (byte) r5;
    L20:
        if (r26 >= r25) goto L25;
        char r110 = r12.charAt(r26);
        if (r110 >= 128) goto L25;
        r23[r26 + r24] = (byte) r110;
        r26 = r26 + 1;
    L25:
        int r111 = r22.limit;
        int r27 = (r24 + r26) - r111;
        r22.limit = r111 + r27;
        r11.setSize$okio(r11.size() + ((long) r27));
        r13 = r26;
        goto L16
    L48:
        return r11;
    L49:
        StringBuilder r112 = a.p(r14, "endIndex > string.length: ", " > ");
        r112.append(r12.length());
        throw new IllegalArgumentException(r112.toString().toString());
    L14:
        r4 = false;
        goto L15
    L52:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r14 + " < " + r13).toString());
    L9:
        r3 = false;
        goto L10
    L54:
        throw new IllegalArgumentException(a.e(r13, "beginIndex < 0: ").toString());
    L5:
        r2 = false;
        goto L6
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer r8, int r9) {
        Intrinsics.f(r8, "$this$commonWriteUtf8CodePoint");
        if (r9 >= 128) goto L6;
        r8.writeByte(r9);
    L20:
        return r8;
    L6:
        if (r9 >= 2048) goto L9;
        Segment r3 = r8.writableSegment$okio(2);
        byte[] r4 = r3.data;
        int r5 = r3.limit;
        r4[r5] = (byte) ((r9 >> 6) | 192);
        r4[r5 + 1] = (byte) ((r9 & 63) | 128);
        r3.limit = r5 + 2;
        r8.setSize$okio(r8.size() + 2);
        goto L20
    L9:
        if (55296 > r9) goto L15;
        if (57343 < r9) goto L15;
        r8.writeByte(63);
    L15:
        if (r9 >= 65536) goto L18;
        Segment r6 = r8.writableSegment$okio(3);
        byte[] r7 = r6.data;
        int r10 = r6.limit;
        r7[r10] = (byte) ((r9 >> 12) | 224);
        r7[r10 + 1] = (byte) (((r9 >> 6) & 63) | 128);
        r7[r10 + 2] = (byte) ((r9 & 63) | 128);
        r6.limit = r10 + 3;
        r8.setSize$okio(r8.size() + 3);
        goto L20
    L18:
        if (r9 > 1114111) goto L22;
        Segment r11 = r8.writableSegment$okio(4);
        byte[] r12 = r11.data;
        int r13 = r11.limit;
        r12[r13] = (byte) ((r9 >> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND);
        r12[r13 + 1] = (byte) (((r9 >> 12) & 63) | 128);
        r12[r13 + 2] = (byte) (((r9 >> 6) & 63) | 128);
        r12[r13 + 3] = (byte) ((r9 & 63) | 128);
        r11.limit = r13 + 4;
        r8.setSize$okio(r8.size() + 4);
        goto L20
    L22:
        throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(r9));
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@NotNull Segment r5, int r6, @NotNull byte[] r7, int r8, int r9) {
        Intrinsics.f(r5, "segment");
        Intrinsics.f(r7, "bytes");
        int r0 = r5.limit;
        byte[] r1 = r5.data;
    L3:
        if (r8 >= r9) goto L11;
        if (r6 != r0) goto L7;
        r5 = r5.next;
        Intrinsics.c(r5);
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

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer r6, long r7) {
        Intrinsics.f(r6, "$this$readUtf8Line");
        if (r7 <= 0) goto L7;
        long r3 = r7 - 1;
        if (r6.getByte(r3) != ((byte) 13)) goto L7;
        String r8 = r6.readUtf8(r3);
        r6.skip(2);
        return r8;
    L7:
        String r9 = r6.readUtf8(r7);
        r6.skip(1);
        return r9;
    }

    public static final <T> T seek(@NotNull Buffer r5, long r6, @NotNull Function2<? super Segment, ? super Long, ? extends T> r8) {
        Intrinsics.f(r5, "$this$seek");
        Intrinsics.f(r8, "lambda");
        Segment r0 = r5.head;
        if (r0 == null) goto L19;
        if ((r5.size() - r6) >= r6) goto L12;
        long r1 = r5.size();
    L8:
        if (r1 <= r6) goto L11;
        r0 = r0.prev;
        Intrinsics.c(r0);
        r1 = r1 - ((long) (r0.limit - r0.pos));
        goto L8
    L11:
        return (T) r8.mo7invoke(r0, Long.valueOf(r1));
    L12:
        long r2 = 0;
    L13:
        long r3 = ((long) (r0.limit - r0.pos)) + r2;
        if (r3 > r6) goto L16;
        r0 = r0.next;
        Intrinsics.c(r0);
        r2 = r3;
        goto L13
    L16:
        return (T) r8.mo7invoke(r0, Long.valueOf(r2));
    L19:
        return (T) r8.mo7invoke(null, -1L);
    }

    public static final int selectPrefix(@NotNull Buffer r17, @NotNull Options r18, boolean r19) {
        Intrinsics.f(r17, "$this$selectPrefix");
        Intrinsics.f(r18, "options");
        Segment r0 = r17.head;
        if (r0 == null) goto L46;
        byte[] r4 = r0.data;
        int r5 = r0.pos;
        int r6 = r0.limit;
        int[] r2 = r18.getTrie$okio();
        Segment r9 = r0;
        int r10 = -1;
        int r8 = 0;
    L5:
        int r11 = r8 + 1;
        int r12 = r2[r8];
        int r13 = r8 + 2;
        int r14 = r2[r11];
        if (r14 == (-1)) goto L8;
        r10 = r14;
    L8:
        if (r9 == null) goto L23;
        if (r12 >= 0) goto L32;
        int r15 = (r12 * (-1)) + r13;
    L13:
        int r16 = r5 + 1;
        int r110 = r13 + 1;
        if ((r4[r5] & 255) != r2[r13]) goto L15;
        if (r110 != r15) goto L18;
        boolean r7 = true;
    L19:
        if (r16 != r6) goto L28;
        Intrinsics.c(r9);
        Segment r20 = r9.next;
        Intrinsics.c(r20);
        int r21 = r20.pos;
        byte[] r22 = r20.data;
        int r23 = r20.limit;
        if (r20 != r0) goto L27;
        if (r7 == false) goto L23;
        r4 = r22;
        Segment r24 = null;
    L29:
        if (r7 == true) goto L30;
        r5 = r21;
        r6 = r23;
        r9 = r24;
        r13 = r110;
        goto L13
    L30:
        int r25 = r2[r110];
        int r111 = r21;
        r6 = r23;
        r9 = r24;
    L42:
        if (r25 >= 0) goto L43;
        r8 = -r25;
        r5 = r111;
        goto L5
    L43:
        return r25;
    L27:
        r24 = r20;
        r4 = r22;
        goto L29
    L28:
        r24 = r9;
        r23 = r6;
        r21 = r16;
        goto L29
    L18:
        r7 = false;
        goto L19
    L15:
        return r10;
    L32:
        r111 = r5 + 1;
        int r26 = r4[r5] & 255;
        int r112 = r13 + r12;
    L33:
        if (r13 == r112) goto L34;
        if (r26 == r2[r13]) goto L37;
        r13 = r13 + 1;
        goto L33
    L37:
        r25 = r2[r13 + r12];
        if (r111 != r6) goto L42;
        r9 = r9.next;
        Intrinsics.c(r9);
        int r27 = r9.pos;
        r111 = r27;
        r4 = r9.data;
        r6 = r9.limit;
        if (r9 != r0) goto L42;
        r9 = null;
        goto L42
    L34:
        return r10;
    L23:
        if (r19 == false) goto L25;
        return -2;
    L25:
        return r10;
    L46:
        if (r19 == false) goto L49;
        return -2;
    L49:
        return -1;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer r0, Options r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return selectPrefix(r0, r1, r2);
    }

    public static final int commonRead(@NotNull Buffer r7, @NotNull byte[] r8, int r9, int r10) {
        Intrinsics.f(r7, "$this$commonRead");
        Intrinsics.f(r8, "sink");
        Util.checkOffsetAndCount(r8.length, r9, r10);
        Segment r0 = r7.head;
        if (r0 == null) goto L8;
        int r11 = Math.min(r10, r0.limit - r0.pos);
        byte[] r1 = r0.data;
        int r2 = r0.pos;
        ArraysKt.g(r1, r9, r8, r2, r2 + r11);
        r0.pos += r11;
        r7.setSize$okio(r7.size() - ((long) r11));
        if (r0.pos != r0.limit) goto L7;
        r7.head = r0.pop();
        SegmentPool.recycle(r0);
    L7:
        return r11;
    L8:
        return -1;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer r2, long r3) {
        Intrinsics.f(r2, "$this$commonReadByteArray");
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
        throw new IllegalArgumentException(a.h("byteCount: ", r3).toString());
    L5:
        if (r3 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L7;
        r0 = true;
        goto L8
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer r2, long r3) {
        Intrinsics.f(r2, "$this$commonReadByteString");
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
        throw new IllegalArgumentException(a.h("byteCount: ", r3).toString());
    L5:
        if (r3 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L7;
        r0 = true;
        goto L8
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer r2, @NotNull byte[] r3) {
        Intrinsics.f(r2, "$this$commonWrite");
        Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
        return r2.write(r3, 0, r3.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer r9, @NotNull byte[] r10, int r11, int r12) {
        Intrinsics.f(r9, "$this$commonWrite");
        Intrinsics.f(r10, DBHelper.BATTERY_COL_SOURCE);
        long r7 = r12;
        Util.checkOffsetAndCount(r10.length, r11, r7);
        int r13 = r12 + r11;
    L3:
        if (r11 >= r13) goto L5;
        Segment r0 = r9.writableSegment$okio(1);
        int r1 = Math.min(r13 - r11, 8192 - r0.limit);
        int r4 = r11 + r1;
        ArraysKt.g(r10, r0.limit, r0.data, r11, r4);
        r0.limit += r1;
        r11 = r4;
        goto L3
    L5:
        r9.setSize$okio(r9.size() + r7);
        return r9;
    }

    public static final void commonReadFully(@NotNull Buffer r2, @NotNull Buffer r3, long r4) {
        Intrinsics.f(r2, "$this$commonReadFully");
        Intrinsics.f(r3, "sink");
        if (r2.size() < r4) goto L6;
        r3.write(r2, r4);
        return;
    L6:
        r3.write(r2, r2.size());
        throw new EOFException();
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer r7, int r8) {
        Intrinsics.f(r7, "$this$commonSnapshot");
        if (r8 == 0) goto L5;
        Util.checkOffsetAndCount(r7.size(), 0, r8);
        Segment r0 = r7.head;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= r8) goto L13;
        Intrinsics.c(r0);
        int r4 = r0.limit;
        int r5 = r0.pos;
        if (r4 == r5) goto L12;
        r2 = r2 + (r4 - r5);
        r3 = r3 + 1;
        r0 = r0.next;
        goto L7
    L12:
        throw new AssertionError("s.limit == s.pos");
    L13:
        byte[][] r6 = new byte[r3][];
        int[] r9 = new int[r3 * 2];
        Segment r10 = r7.head;
        int r11 = 0;
    L14:
        if (r1 >= r8) goto L17;
        Intrinsics.c(r10);
        r6[r11] = r10.data;
        r1 = r1 + (r10.limit - r10.pos);
        r9[r11] = Math.min(r1, r8);
        r9[r11 + r3] = r10.pos;
        r10.shared = true;
        r11 = r11 + 1;
        r10 = r10.next;
        goto L14
    L17:
        return new SegmentedByteString(r6, r9);
    L5:
        return ByteString.EMPTY;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer r4, @NotNull Source r5, long r6) {
        Intrinsics.f(r4, "$this$commonWrite");
        Intrinsics.f(r5, DBHelper.BATTERY_COL_SOURCE);
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

    public static final long commonRead(@NotNull Buffer r4, @NotNull Buffer r5, long r6) {
        Intrinsics.f(r4, "$this$commonRead");
        Intrinsics.f(r5, "sink");
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
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final void commonWrite(@NotNull Buffer r8, @NotNull Buffer r9, long r10) {
        Intrinsics.f(r8, "$this$commonWrite");
        Intrinsics.f(r9, DBHelper.BATTERY_COL_SOURCE);
        if (r9 == r8) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L35;
        Util.checkOffsetAndCount(r9.size(), 0, r10);
    L9:
        if (r10 <= 0) goto L33;
        Segment r2 = r9.head;
        Intrinsics.c(r2);
        int r3 = r2.limit;
        Segment r4 = r9.head;
        Intrinsics.c(r4);
        if (r10 >= (r3 - r4.pos)) goto L28;
        Segment r5 = r8.head;
        if (r5 == null) goto L15;
        Intrinsics.c(r5);
        Segment r6 = r5.prev;
    L16:
        if (r6 != null) goto L18;
    L27:
        Segment r7 = r9.head;
        Intrinsics.c(r7);
        r9.head = r7.split((int) r10);
        goto L28
    L18:
        if (r6.owner == false) goto L27;
        long r11 = ((long) r6.limit) + r10;
        if (r6.shared == false) goto L22;
        int r12 = 0;
    L24:
        if ((r11 - ((long) r12)) > 8192) goto L27;
        Segment r0 = r9.head;
        Intrinsics.c(r0);
        r0.writeTo(r6, (int) r10);
        r9.setSize$okio(r9.size() - r10);
        r8.setSize$okio(r8.size() + r10);
        return;
    L22:
        r12 = r6.pos;
        goto L24
    L15:
        r6 = null;
    L28:
        Segment r13 = r9.head;
        Intrinsics.c(r13);
        long r14 = r13.limit - r13.pos;
        r9.head = r13.pop();
        Segment r15 = r8.head;
        if (r15 != null) goto L31;
        r8.head = r13;
        r13.prev = r13;
        r13.next = r13;
    L32:
        r9.setSize$okio(r9.size() - r14);
        r8.setSize$okio(r8.size() + r14);
        r10 = r10 - r14;
        goto L9
    L31:
        Intrinsics.c(r15);
        Segment r16 = r15.prev;
        Intrinsics.c(r16);
        r16.push(r13).compact();
        goto L32
    L33:
        return;
    L35:
        throw new IllegalArgumentException("source == this".toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final long commonIndexOf(@NotNull Buffer r16, @NotNull ByteString r17, long r18) {
        long r1 = r18;
        Intrinsics.f(r16, "$this$commonIndexOf");
        Intrinsics.f(r17, "bytes");
        boolean r6 = true;
        if (r17.size() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L59;
        long r7 = 0;
        if (r1 < 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L57;
        Segment r5 = r16.head;
        if (r5 != null) goto L15;
        return -1;
    L15:
        if ((r16.size() - r1) >= r1) goto L35;
        long r8 = r16.size();
    L18:
        if (r8 <= r1) goto L20;
        r5 = r5.prev;
        Intrinsics.c(r5);
        r8 = r8 - ((long) (r5.limit - r5.pos));
        goto L18
    L20:
        byte[] r11 = r17.internalArray$okio();
        byte r9 = r11[0];
        int r10 = r17.size();
        long r14 = (r16.size() - ((long) r10)) + 1;
    L22:
        if (r8 >= r14) goto L33;
        byte[] r0 = r5.data;
        int r12 = (int) Math.min(r5.limit, (((long) r5.pos) + r14) - r8);
        int r2 = (int) ((((long) r5.pos) + r1) - r8);
    L24:
        if (r2 >= r12) goto L32;
        if (r0[r2] != r9) goto L31;
        if (rangeEquals(r5, r2 + 1, r11, 1, r10) == false) goto L31;
        return ((long) (r2 - r5.pos)) + r8;
    L31:
        r2 = r2 + 1;
        goto L24
    L32:
        r8 = r8 + ((long) (r5.limit - r5.pos));
        r5 = r5.next;
        Intrinsics.c(r5);
        r1 = r8;
        goto L22
    L33:
        return -1;
    L35:
        long r13 = ((long) (r5.limit - r5.pos)) + r7;
        if (r13 > r1) goto L37;
        r5 = r5.next;
        Intrinsics.c(r5);
        r7 = r13;
        r6 = r6;
        goto L35
    L37:
        byte[] r15 = r17.internalArray$okio();
        byte r19 = r15[0];
        int r20 = r17.size();
        long r110 = (r16.size() - ((long) r20)) + 1;
    L39:
        if (r7 >= r110) goto L51;
        byte[] r21 = r5.data;
        long r111 = r7;
        int r22 = (int) Math.min(r5.limit, (((long) r5.pos) + r110) - r7);
        int r23 = (int) ((((long) r5.pos) + r1) - r111);
    L41:
        if (r23 >= r22) goto L50;
        if (r21[r23] != r19) goto L49;
        if (rangeEquals(r5, r23 + 1, r15, 1, r20) == false) goto L49;
        return ((long) (r23 - r5.pos)) + r111;
    L49:
        r23 = r23 + 1;
        goto L41
    L50:
        r7 = r111 + ((long) (r5.limit - r5.pos));
        r5 = r5.next;
        Intrinsics.c(r5);
        r1 = r7;
        goto L39
    L51:
        return -1;
    L57:
        throw new IllegalArgumentException(a.h("fromIndex < 0: ", r1).toString());
    L10:
        r4 = false;
        goto L11
    L59:
        throw new IllegalArgumentException("bytes is empty".toString());
    L5:
        r3 = false;
        goto L6
    }
}
