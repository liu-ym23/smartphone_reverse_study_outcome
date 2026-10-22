package okio;

import a.a;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int r1) {
        if (r1 < 0) goto L6;
        if (31 < r1) goto L6;
    L10:
        return true;
    L6:
        if (127 <= r1) goto L9;
    L11:
        return false;
    L9:
        if (159 < r1) goto L11;
        goto L10
    }

    public static final boolean isUtf8Continuation(byte r1) {
        if ((r1 & 192) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] r3, int r4, int r5, @NotNull Function1<? super Integer, Unit> r6) {
        Intrinsics.f(r3, "$this$process2Utf8Bytes");
        Intrinsics.f(r6, "yield");
        int r0 = r4 + 1;
        Integer r1 = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (r5 > r0) goto L6;
        r6.invoke(r1);
        return 1;
    L6:
        byte r7 = r3[r4];
        byte r8 = r3[r0];
        if ((r8 & 192) != 128) goto L14;
        int r9 = (r8 ^ 3968) ^ (r7 << 6);
        if (r9 >= 128) goto L11;
        r6.invoke(r1);
        return 2;
    L11:
        r6.invoke(Integer.valueOf(r9));
        return 2;
    L14:
        r6.invoke(r1);
        return 1;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] r6, int r7, int r8, @NotNull Function1<? super Integer, Unit> r9) {
        Intrinsics.f(r6, "$this$process3Utf8Bytes");
        Intrinsics.f(r9, "yield");
        int r0 = r7 + 2;
        Integer r3 = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (r8 > r0) goto L10;
        r9.invoke(r3);
        int r10 = r7 + 1;
        if (r8 > r10) goto L7;
    L9:
        return 1;
    L7:
        if ((r6[r10] & 192) != 128) goto L9;
        return 2;
    L10:
        byte r11 = r6[r7];
        byte r12 = r6[r7 + 1];
        if ((r12 & 192) != 128) goto L28;
        byte r13 = r6[r0];
        if ((r13 & 192) != 128) goto L26;
        int r14 = ((r13 ^ (-123008)) ^ (r12 << 6)) ^ (r11 << 12);
        if (r14 >= 2048) goto L18;
        r9.invoke(r3);
        return 3;
    L18:
        if (55296 <= r14) goto L21;
    L23:
        r9.invoke(Integer.valueOf(r14));
        return 3;
    L21:
        if (57343 < r14) goto L23;
        r9.invoke(r3);
        return 3;
    L26:
        r9.invoke(r3);
        return 2;
    L28:
        r9.invoke(r3);
        return 1;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] r8, int r9, int r10, @NotNull Function1<? super Integer, Unit> r11) {
        Intrinsics.f(r8, "$this$process4Utf8Bytes");
        Intrinsics.f(r11, "yield");
        int r0 = r9 + 3;
        Integer r4 = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (r10 > r0) goto L15;
        r11.invoke(r4);
        int r12 = r9 + 1;
        if (r10 > r12) goto L7;
    L14:
        return 1;
    L7:
        if ((r8[r12] & 192) != 128) goto L14;
        int r13 = r9 + 2;
        if (r10 > r13) goto L11;
    L13:
        return 2;
    L11:
        if ((r8[r13] & 192) != 128) goto L13;
        return 3;
    L15:
        byte r14 = r8[r9];
        byte r6 = r8[r9 + 1];
        if ((r6 & 192) != 128) goto L40;
        byte r15 = r8[r9 + 2];
        if ((r15 & 192) != 128) goto L38;
        byte r16 = r8[r0];
        if ((r16 & 192) != 128) goto L36;
        int r17 = (((r16 ^ 3678080) ^ (r15 << 6)) ^ (r6 << 12)) ^ (r14 << 18);
        if (r17 <= 1114111) goto L25;
        r11.invoke(r4);
        return 4;
    L25:
        if (55296 > r17) goto L31;
        if (57343 < r17) goto L31;
        r11.invoke(r4);
        return 4;
    L31:
        if (r17 >= 65536) goto L33;
        r11.invoke(r4);
        return 4;
    L33:
        r11.invoke(Integer.valueOf(r17));
        return 4;
    L36:
        r11.invoke(r4);
        return 3;
    L38:
        r11.invoke(r4);
        return 2;
    L40:
        r11.invoke(r4);
        return 1;
    }

    public static final void processUtf16Chars(@NotNull byte[] r11, int r12, int r13, @NotNull Function1<? super Character, Unit> r14) {
        Intrinsics.f(r11, "$this$processUtf16Chars");
        Intrinsics.f(r14, "yield");
    L3:
        if (r12 >= r13) goto L86;
        byte r0 = r11[r12];
        if (r0 >= 0) goto L6;
        int r3 = 2;
        if ((r0 >> 5) == (-2)) goto L13;
        if ((r0 >> 4) == (-2)) goto L27;
        if ((r0 >> 3) == (-2)) goto L52;
        r14.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        r12 = r12 + 1;
        goto L3
    L52:
        int r1 = r12 + 3;
        if (r13 > r1) goto L63;
        r14.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        int r2 = r12 + 1;
        if (r13 > r2) goto L57;
    L16:
        r3 = 1;
    L24:
        r12 = r12 + r3;
        goto L3
    L57:
        if ((r11[r2] & 192) != 128) goto L16;
        int r4 = r12 + 2;
        if (r13 <= r4) goto L24;
        if ((r11[r4] & 192) != 128) goto L24;
    L47:
        r3 = 3;
        goto L24
    L63:
        byte r5 = r11[r12 + 1];
        if ((r5 & 192) != 128) goto L84;
        byte r6 = r11[r12 + 2];
        if ((r6 & 192) != 128) goto L83;
        byte r7 = r11[r1];
        if ((r7 & 192) != 128) goto L82;
        int r8 = (r0 << 18) ^ (((r7 ^ 3678080) ^ (r6 << 6)) ^ (r5 << 12));
        if (r8 <= 1114111) goto L72;
    L71:
        r14.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
    L81:
        r3 = 4;
        goto L24
    L72:
        if (55296 > r8) goto L77;
        if (57343 >= r8) goto L71;
    L77:
        if (r8 < 65536) goto L71;
        if (r8 == 65533) goto L71;
        r14.invoke(Character.valueOf((char) ((r8 >>> 10) + HIGH_SURROGATE_HEADER)));
        r14.invoke(Character.valueOf((char) ((r8 & 1023) + LOG_SURROGATE_HEADER)));
        goto L81
    L82:
        r14.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        goto L47
    L83:
        r14.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        goto L24
    L84:
        r14.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        goto L16
    L27:
        int r9 = r12 + 2;
        if (r13 > r9) goto L34;
        r14.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
        int r10 = r12 + 1;
        if (r13 <= r10) goto L16;
        if ((r11[r10] & 192) != 128) goto L16;
    L34:
        byte r15 = r11[r12 + 1];
        if ((r15 & 192) != 128) goto L49;
        byte r16 = r11[r9];
        if ((r16 & 192) != 128) goto L48;
        int r17 = (r0 << 12) ^ ((r16 ^ (-123008)) ^ (r15 << 6));
        if (r17 >= 2048) goto L42;
    L40:
        char r18 = (char) REPLACEMENT_CODE_POINT;
    L41:
        r14.invoke(Character.valueOf(r18));
        goto L47
    L42:
        if (55296 > r17) goto L46;
        if (57343 >= r17) goto L40;
    L46:
        r18 = (char) r17;
        goto L41
    L48:
        r14.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
        goto L24
    L49:
        r14.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
        goto L16
    L13:
        int r19 = r12 + 1;
        if (r13 > r19) goto L17;
    L15:
        r14.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
        goto L16
    L17:
        byte r20 = r11[r19];
        if ((r20 & 192) != 128) goto L15;
        int r21 = (r0 << 6) ^ (r20 ^ 3968);
        if (r21 >= 128) goto L23;
        char r22 = (char) REPLACEMENT_CODE_POINT;
    L22:
        r14.invoke(Character.valueOf(r22));
        goto L24
    L23:
        r22 = (char) r21;
        goto L22
    L6:
        r14.invoke(Character.valueOf((char) r0));
        r12 = r12 + 1;
    L7:
        if (r12 >= r13) goto L3;
        byte r23 = r11[r12];
        if (r23 < 0) goto L3;
        r12 = r12 + 1;
        r14.invoke(Character.valueOf((char) r23));
        goto L7
    }

    public static final void processUtf8Bytes(@NotNull String r7, int r8, int r9, @NotNull Function1<? super Byte, Unit> r10) {
        Intrinsics.f(r7, "$this$processUtf8Bytes");
        Intrinsics.f(r10, "yield");
    L3:
        if (r8 >= r9) goto L31;
        char r0 = r7.charAt(r8);
        if (Intrinsics.h(r0, 128) < 0) goto L6;
        if (Intrinsics.h(r0, 2048) < 0) goto L13;
        if (55296 > r0) goto L30;
        if (57343 < r0) goto L30;
        if (Intrinsics.h(r0, 56319) > 0) goto L29;
        int r4 = r8 + 1;
        if (r9 <= r4) goto L29;
        char r5 = r7.charAt(r4);
        if (56320 > r5) goto L29;
        if (57343 < r5) goto L29;
        int r2 = (r7.charAt(r4) + (r0 << '\n')) - 56613888;
        r10.invoke(Byte.valueOf((byte) ((r2 >> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND)));
        r10.invoke(Byte.valueOf((byte) (((r2 >> 12) & 63) | 128)));
        r10.invoke(Byte.valueOf((byte) (((r2 >> 6) & 63) | 128)));
        r10.invoke(Byte.valueOf((byte) ((r2 & 63) | 128)));
        r8 = r8 + 2;
    L29:
        r10.invoke(Byte.valueOf(REPLACEMENT_BYTE));
    L14:
        r8 = r8 + 1;
    L30:
        r10.invoke(Byte.valueOf((byte) ((r0 >> '\f') | 224)));
        r10.invoke(Byte.valueOf((byte) (((r0 >> 6) & 63) | 128)));
        r10.invoke(Byte.valueOf((byte) ((r0 & '?') | 128)));
        goto L14
    L13:
        r10.invoke(Byte.valueOf((byte) ((r0 >> 6) | 192)));
        r10.invoke(Byte.valueOf((byte) ((r0 & '?') | 128)));
        goto L14
    L6:
        r10.invoke(Byte.valueOf((byte) r0));
        r8 = r8 + 1;
    L7:
        if (r8 >= r9) goto L3;
        if (Intrinsics.h(r7.charAt(r8), 128) >= 0) goto L3;
        r10.invoke(Byte.valueOf((byte) r7.charAt(r8)));
        r8 = r8 + 1;
        goto L7
    }

    public static final void processUtf8CodePoints(@NotNull byte[] r11, int r12, int r13, @NotNull Function1<? super Integer, Unit> r14) {
        Intrinsics.f(r11, "$this$processUtf8CodePoints");
        Intrinsics.f(r14, "yield");
    L3:
        if (r12 >= r13) goto L86;
        byte r0 = r11[r12];
        if (r0 >= 0) goto L6;
        int r3 = 2;
        if ((r0 >> 5) == (-2)) goto L13;
        if ((r0 >> 4) == (-2)) goto L27;
        if ((r0 >> 3) == (-2)) goto L52;
        r14.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        r12 = r12 + 1;
        goto L3
    L52:
        int r1 = r12 + 3;
        if (r13 > r1) goto L63;
        r14.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        int r2 = r12 + 1;
        if (r13 > r2) goto L57;
    L16:
        r3 = 1;
    L24:
        r12 = r12 + r3;
        goto L3
    L57:
        if ((r11[r2] & 192) != 128) goto L16;
        int r4 = r12 + 2;
        if (r13 <= r4) goto L24;
        if ((r11[r4] & 192) != 128) goto L24;
    L47:
        r3 = 3;
        goto L24
    L63:
        byte r5 = r11[r12 + 1];
        if ((r5 & 192) != 128) goto L84;
        byte r6 = r11[r12 + 2];
        if ((r6 & 192) != 128) goto L83;
        byte r7 = r11[r1];
        if ((r7 & 192) != 128) goto L82;
        int r8 = (r0 << 18) ^ (((r7 ^ 3678080) ^ (r6 << 6)) ^ (r5 << 12));
        if (r8 <= 1114111) goto L73;
    L71:
        Integer r9 = Integer.valueOf(REPLACEMENT_CODE_POINT);
    L72:
        r14.invoke(r9);
        r3 = 4;
        goto L24
    L73:
        if (55296 > r8) goto L78;
        if (57343 >= r8) goto L71;
    L78:
        if (r8 < 65536) goto L71;
        r9 = Integer.valueOf(r8);
        goto L72
    L82:
        r14.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L47
    L83:
        r14.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L24
    L84:
        r14.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L16
    L27:
        int r10 = r12 + 2;
        if (r13 > r10) goto L34;
        r14.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        int r15 = r12 + 1;
        if (r13 <= r15) goto L16;
        if ((r11[r15] & 192) != 128) goto L16;
    L34:
        byte r16 = r11[r12 + 1];
        if ((r16 & 192) != 128) goto L49;
        byte r17 = r11[r10];
        if ((r17 & 192) != 128) goto L48;
        int r18 = (r0 << 12) ^ ((r17 ^ (-123008)) ^ (r16 << 6));
        if (r18 >= 2048) goto L42;
    L40:
        Integer r19 = Integer.valueOf(REPLACEMENT_CODE_POINT);
    L41:
        r14.invoke(r19);
        goto L47
    L42:
        if (55296 > r18) goto L46;
        if (57343 >= r18) goto L40;
    L46:
        r19 = Integer.valueOf(r18);
        goto L41
    L48:
        r14.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L24
    L49:
        r14.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L16
    L13:
        int r20 = r12 + 1;
        if (r13 > r20) goto L17;
    L15:
        r14.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L16
    L17:
        byte r21 = r11[r20];
        if ((r21 & 192) != 128) goto L15;
        int r22 = (r0 << 6) ^ (r21 ^ 3968);
        if (r22 >= 128) goto L23;
        Integer r23 = Integer.valueOf(REPLACEMENT_CODE_POINT);
    L22:
        r14.invoke(r23);
        goto L24
    L23:
        r23 = Integer.valueOf(r22);
        goto L22
    L6:
        r14.invoke(Integer.valueOf(r0));
        r12 = r12 + 1;
    L7:
        if (r12 >= r13) goto L3;
        byte r24 = r11[r12];
        if (r24 < 0) goto L3;
        r12 = r12 + 1;
        r14.invoke(Integer.valueOf(r24));
        goto L7
    }

    @JvmOverloads
    @JvmName
    public static final long size(@NotNull String r3) {
        return size$default(r3, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return size(r0, r1, r2);
    }

    @JvmOverloads
    @JvmName
    public static final long size(@NotNull String r3, int r4) {
        return size$default(r3, r4, 0, 2, null);
    }

    @JvmOverloads
    @JvmName
    public static final long size(@NotNull String r10, int r11, int r12) {
        Intrinsics.f(r10, "$this$utf8Size");
        boolean r1 = true;
        if (r11 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L50;
        if (r12 < r11) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L48;
        if (r12 <= r10.length()) goto L15;
        r1 = false;
    L15:
        if (r1 == false) goto L45;
        long r4 = 0;
    L17:
        if (r11 >= r12) goto L44;
        char r5 = r10.charAt(r11);
        if (r5 < 128) goto L20;
        if (r5 < 2048) goto L24;
        if (r5 < 55296) goto L43;
        if (r5 > 57343) goto L43;
        int r7 = r11 + 1;
        if (r7 >= r12) goto L34;
        char r8 = r10.charAt(r7);
    L36:
        if (r5 > 56319) goto L42;
        if (r8 < 56320) goto L42;
        if (r8 > 57343) goto L42;
        r4 = r4 + ((long) 4);
        r11 = r11 + 2;
    L42:
        r4 = r4 + 1;
        r11 = r7;
        goto L17
    L34:
        r8 = 0;
    L43:
        int r6 = 3;
    L25:
        r4 = r4 + ((long) r6);
    L21:
        r11 = r11 + 1;
        goto L17
    L24:
        r6 = 2;
        goto L25
    L20:
        r4 = r4 + 1;
        goto L21
    L44:
        return r4;
    L45:
        StringBuilder r13 = a.p(r12, "endIndex > string.length: ", " > ");
        r13.append(r10.length());
        throw new IllegalArgumentException(r13.toString().toString());
    L48:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r12 + " < " + r11).toString());
    L9:
        r3 = false;
        goto L10
    L50:
        throw new IllegalArgumentException(a.e(r11, "beginIndex < 0: ").toString());
    L5:
        r2 = false;
        goto L6
    }
}
