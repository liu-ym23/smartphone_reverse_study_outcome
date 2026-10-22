package okio;

import android.icu.text.PluralRules;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal._ByteStringKt;

/* JADX INFO: compiled from: -Util.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0015H\u0000\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0015H\u0080\b\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0080\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0015H\u0080\f\u001a\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\f\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\u0001H\u0000\u001a\f\u0010\"\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\"\u001a\u00020\u0015*\u00020\u0015H\u0000\u001a\f\u0010\"\u001a\u00020#*\u00020#H\u0000\u001a\u0015\u0010$\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010%\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010&\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\f\u0010'\u001a\u00020(*\u00020\u001bH\u0000\u001a\f\u0010'\u001a\u00020(*\u00020\u0001H\u0000\u001a\f\u0010'\u001a\u00020(*\u00020\u0015H\u0000\u001a\u0015\u0010)\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0080\f\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006*"}, d2 = {"DEFAULT__ByteString_size", "", "getDEFAULT__ByteString_size", "()I", "DEFAULT__new_UnsafeCursor", "Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "getDEFAULT__new_UnsafeCursor", "()Lokio/Buffer$UnsafeCursor;", "arrayRangeEquals", "", "a", "", "aOffset", "b", "bOffset", "byteCount", "checkOffsetAndCount", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "offset", "minOf", "resolveDefaultParameter", "unsafeCursor", "and", "", PluralRules.KEYWORD_OTHER, "leftRotate", "bitCount", "sizeParam", "Lokio/ByteString;", "position", "reverseBytes", "", "rightRotate", "shl", "shr", "toHexString", "", "xor", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _UtilKt {
    private static final int DEFAULT__ByteString_size = 0;
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = null;

    public static final int and(byte r0, int r1) {
        return r0 & r1;
    }

    public static final long and(byte r2, long r3) {
        return ((long) r2) & r3;
    }

    public static final long and(int r2, long r3) {
        return ((long) r2) & r3;
    }

    public static /* synthetic */ void getDEFAULT__new_UnsafeCursor$annotations() {
    }

    public static final int leftRotate(int r1, int r2) {
        int r0 = r1 << r2;
        return (r1 >>> (32 - r2)) | r0;
    }

    public static final int reverseBytes(int r2) {
        int r0 = ((((-16777216) & r2) >>> 24) | ((16711680 & r2) >>> 8)) | ((65280 & r2) << 8);
        return ((r2 & 255) << 24) | r0;
    }

    public static final long reverseBytes(long r8) {
        long r0 = ((((((((-72057594037927936L) & r8) >>> 56) | ((71776119061217280L & r8) >>> 40)) | ((280375465082880L & r8) >>> 24)) | ((1095216660480L & r8) >>> 8)) | ((4278190080L & r8) << 8)) | ((16711680 & r8) << 24)) | ((65280 & r8) << 40);
        return ((r8 & 255) << 56) | r0;
    }

    public static final short reverseBytes(short r1) {
        int r2 = r1 & 65535;
        int r0 = (65280 & r2) >>> 8;
        return (short) (((r2 & 255) << 8) | r0);
    }

    public static final long rightRotate(long r2, int r4) {
        long r0 = r2 >>> r4;
        return (r2 << (64 - r4)) | r0;
    }

    public static final int shl(byte r0, int r1) {
        return r0 << r1;
    }

    public static final int shr(byte r0, int r1) {
        return r0 >> r1;
    }

    public static final byte xor(byte r0, byte r1) {
        return (byte) (r0 ^ r1);
    }

    public static final void checkOffsetAndCount(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException("size=" + r4 + " offset=" + r6 + " byteCount=" + r8);
    }

    public static final long minOf(long r2, int r4) {
        return Math.min(r2, r4);
    }

    public static final long minOf(int r2, long r3) {
        return Math.min(r2, r3);
    }

    public static final boolean arrayRangeEquals(byte[] r4, int r5, byte[] r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r4, "a");
        Intrinsics.checkNotNullParameter(r6, "b");
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        if (r4[r1 + r5] != r6[r1 + r7]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final String toHexString(byte r3) {
        return StringsKt.concatToString(new char[]{_ByteStringKt.getHEX_DIGIT_CHARS()[(r3 >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[r3 & 15]});
    }

    public static final String toHexString(int r5) {
        if (r5 != 0) goto L5;
        return "0";
    L5:
        int r3 = 0;
        char[] r1 = {_ByteStringKt.getHEX_DIGIT_CHARS()[(r5 >> 28) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(r5 >> 24) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(r5 >> 20) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(r5 >> 16) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(r5 >> 12) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(r5 >> 8) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(r5 >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[r5 & 15]};
    L6:
        if (r3 >= 8) goto L11;
        if (r1[r3] != '0') goto L11;
        r3 = r3 + 1;
    L11:
        return StringsKt.concatToString(r1, r3, 8);
    }

    public static final String toHexString(long r12) {
        if (r12 != 0) goto L6;
        return "0";
    L6:
        int r3 = 0;
        char[] r1 = {_ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 60) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 56) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 52) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 48) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 44) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 40) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 36) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 32) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 28) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 24) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 20) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 16) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 12) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 8) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r12 >> 4) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) (r12 & 15)]};
    L7:
        if (r3 >= 16) goto L12;
        if (r1[r3] != '0') goto L12;
        r3 = r3 + 1;
    L12:
        return StringsKt.concatToString(r1, r3, 16);
    }

    static {
        DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
        DEFAULT__ByteString_size = -1234567890;
    }

    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static final Buffer.UnsafeCursor resolveDefaultParameter(Buffer.UnsafeCursor r1) {
        Intrinsics.checkNotNullParameter(r1, "unsafeCursor");
        if (r1 == DEFAULT__new_UnsafeCursor) goto L5;
        return r1;
    L5:
        return new Buffer.UnsafeCursor();
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    public static final int resolveDefaultParameter(ByteString r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == DEFAULT__ByteString_size) goto L5;
        return r2;
    L5:
        return r1.size();
    }

    public static final int resolveDefaultParameter(byte[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == DEFAULT__ByteString_size) goto L5;
        return r2;
    L5:
        return r1.length;
    }
}
