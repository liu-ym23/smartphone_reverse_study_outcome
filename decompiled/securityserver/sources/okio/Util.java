package okio;

import a.a;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-Util, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class Util {
    public static final int and(byte r0, int r1) {
        return r0 & r1;
    }

    public static final boolean arrayRangeEquals(@NotNull byte[] r4, int r5, @NotNull byte[] r6, int r7, int r8) {
        Intrinsics.f(r4, "a");
        Intrinsics.f(r6, "b");
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

    public static final void checkOffsetAndCount(long r4, long r6, long r8) {
        if ((r6 | r8) >= 0) goto L5;
    L9:
        StringBuilder r5 = a.s("size=", r4, " offset=");
        r5.append(r6);
        r5.append(" byteCount=");
        r5.append(r8);
        throw new ArrayIndexOutOfBoundsException(r5.toString());
    L5:
        if (r6 > r4) goto L9;
        if ((r4 - r6) < r8) goto L9;
    }

    public static final long minOf(long r2, int r4) {
        return Math.min(r2, r4);
    }

    public static final int reverseBytes(int r2) {
        int r0 = ((((-16777216) & r2) >>> 24) | ((16711680 & r2) >>> 8)) | ((65280 & r2) << 8);
        return ((r2 & 255) << 24) | r0;
    }

    public static final int shl(byte r0, int r1) {
        return r0 << r1;
    }

    public static final int shr(byte r0, int r1) {
        return r0 >> r1;
    }

    @NotNull
    public static final String toHexString(byte r3) {
        return new String(new char[]{ByteStringKt.getHEX_DIGIT_CHARS()[(r3 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[r3 & 15]});
    }

    public static final long and(byte r2, long r3) {
        return ((long) r2) & r3;
    }

    public static final long minOf(int r2, long r3) {
        return Math.min(r2, r3);
    }

    public static final long reverseBytes(long r8) {
        long r0 = ((((((((-72057594037927936L) & r8) >>> 56) | ((71776119061217280L & r8) >>> 40)) | ((280375465082880L & r8) >>> 24)) | ((1095216660480L & r8) >>> 8)) | ((4278190080L & r8) << 8)) | ((16711680 & r8) << 24)) | ((65280 & r8) << 40);
        return ((r8 & 255) << 56) | r0;
    }

    public static final long and(int r2, long r3) {
        return ((long) r2) & r3;
    }

    public static final short reverseBytes(short r1) {
        int r0 = (65280 & r1) >>> 8;
        return (short) (((r1 & 255) << 8) | r0);
    }

    @NotNull
    public static final String toHexString(int r12) {
        int r1 = 0;
        if (r12 != 0) goto L6;
        return "0";
    L6:
        char[] r11 = {ByteStringKt.getHEX_DIGIT_CHARS()[(r12 >> 28) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(r12 >> 24) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(r12 >> 20) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(r12 >> 16) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(r12 >> 12) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(r12 >> 8) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(r12 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[r12 & 15]};
    L7:
        if (r1 >= 8) goto L13;
        if (r11[r1] != '0') goto L13;
        r1 = r1 + 1;
    L13:
        return new String(r11, r1, 8 - r1);
    }

    @NotNull
    public static final String toHexString(long r21) {
        if (r21 != 0) goto L6;
        return "0";
    L6:
        char[] r14 = {ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 60) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 56) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 52) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 48) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 44) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 40) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 36) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 32) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 28) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 24) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 20) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 16) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 12) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 8) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((r21 >> 4) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) (r21 & 15)]};
        int r1 = 0;
    L7:
        if (r1 >= 16) goto L13;
        if (r14[r1] != '0') goto L13;
        r1 = r1 + 1;
    L13:
        return new String(r14, r1, 16 - r1);
    }
}
