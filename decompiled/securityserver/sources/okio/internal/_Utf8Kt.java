package okio.internal;

import com.bytedance.apm.battery.config.BatteryDetectConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String r12) {
        Intrinsics.f(r12, "$this$commonAsUtf8ToByteArray");
        byte[] r0 = new byte[r12.length() * 4];
        int r1 = r12.length();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L40;
        char r4 = r12.charAt(r2);
        if (Intrinsics.h(r4, 128) >= 0) goto L7;
        r0[r2] = (byte) r4;
        r2 = r2 + 1;
        goto L4
    L7:
        int r3 = r12.length();
        int r5 = r2;
    L8:
        if (r2 >= r3) goto L37;
        char r6 = r12.charAt(r2);
        if (Intrinsics.h(r6, 128) < 0) goto L11;
        if (Intrinsics.h(r6, 2048) < 0) goto L19;
        if (55296 > r6) goto L36;
        if (57343 < r6) goto L36;
        if (Intrinsics.h(r6, 56319) > 0) goto L35;
        int r9 = r2 + 1;
        if (r3 <= r9) goto L35;
        char r10 = r12.charAt(r9);
        if (56320 > r10) goto L35;
        if (57343 < r10) goto L35;
        int r7 = (r12.charAt(r9) + (r6 << '\n')) - 56613888;
        r0[r5] = (byte) ((r7 >> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND);
        r0[r5 + 1] = (byte) (((r7 >> 12) & 63) | 128);
        r0[r5 + 2] = (byte) (((r7 >> 6) & 63) | 128);
        r5 = r5 + 4;
        r0[r5 + 3] = (byte) ((r7 & 63) | 128);
        r2 = r2 + 2;
    L35:
        r0[r5] = Utf8.REPLACEMENT_BYTE;
        r2 = r2 + 1;
        r5 = r5 + 1;
    L36:
        r0[r5] = (byte) ((r6 >> '\f') | 224);
        r0[r5 + 1] = (byte) (((r6 >> 6) & 63) | 128);
        r5 = r5 + 3;
        r0[r5 + 2] = (byte) ((r6 & '?') | 128);
    L20:
        r2 = r2 + 1;
        goto L8
    L19:
        r0[r5] = (byte) ((r6 >> 6) | 192);
        r5 = r5 + 2;
        r0[r5 + 1] = (byte) ((r6 & '?') | 128);
        goto L20
    L11:
        int r8 = r5 + 1;
        r0[r5] = (byte) r6;
        r2 = r2 + 1;
    L12:
        if (r2 >= r3) goto L16;
        if (Intrinsics.h(r12.charAt(r2), 128) >= 0) goto L16;
        r0[r8] = (byte) r12.charAt(r2);
        r2 = r2 + 1;
        r8 = r8 + 1;
    L16:
        r5 = r8;
        goto L8
    L37:
        byte[] r13 = Arrays.copyOf(r0, r5);
        Intrinsics.e(r13, "java.util.Arrays.copyOf(this, newSize)");
        return r13;
    L40:
        byte[] r14 = Arrays.copyOf(r0, r12.length());
        Intrinsics.e(r14, "java.util.Arrays.copyOf(this, newSize)");
        return r14;
    }

    @NotNull
    public static final String commonToUtf8String(@NotNull byte[] r16, int r17, int r18) {
        int r1 = r17;
        Intrinsics.f(r16, "$this$commonToUtf8String");
        if (r1 < 0) goto L101;
        if (r18 > r16.length) goto L101;
        if (r1 > r18) goto L101;
        char[] r3 = new char[r18 - r1];
        int r5 = 0;
    L8:
        if (r1 >= r18) goto L99;
        byte r6 = r16[r1];
        if (r6 >= 0) goto L11;
        if ((r6 >> 5) == (-2)) goto L19;
        if ((r6 >> 4) == (-2)) goto L34;
        if ((r6 >> 3) != (-2)) goto L97;
        int r7 = r1 + 3;
        if (r18 > r7) goto L71;
        int r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        int r9 = r1 + 1;
        if (r18 > r9) goto L63;
    L70:
        int r10 = 1;
    L95:
        r1 = r1 + r10;
    L96:
        r5 = r8;
        goto L8
    L63:
        if ((r16[r9] & 192) != 128) goto L70;
        int r11 = r1 + 2;
        if (r18 > r11) goto L67;
    L69:
        r10 = 2;
        goto L95
    L67:
        if ((r16[r11] & 192) != 128) goto L69;
    L68:
        r10 = 3;
        goto L95
    L71:
        byte r12 = r16[r1 + 1];
        if ((r12 & 192) != 128) goto L94;
        byte r13 = r16[r1 + 2];
        if ((r13 & 192) != 128) goto L93;
        byte r14 = r16[r7];
        if ((r14 & 192) != 128) goto L92;
        int r15 = (r6 << 18) ^ (((r14 ^ 3678080) ^ (r13 << 6)) ^ (r12 << 12));
        if (r15 <= 1114111) goto L80;
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
    L91:
        r10 = 4;
        goto L95
    L80:
        if (55296 > r15) goto L85;
        if (57343 < r15) goto L85;
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
    L85:
        if (r15 >= 65536) goto L87;
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L91
    L87:
        if (r15 == 65533) goto L89;
        r3[r5] = (char) ((r15 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        int r19 = r5 + 2;
        r3[r5 + 1] = (char) ((r15 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    L90:
        r8 = r19;
        goto L91
    L89:
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        r19 = r5 + 1;
        goto L90
    L92:
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L68
    L93:
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L69
    L94:
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L70
    L97:
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        r1 = r1 + 1;
        goto L96
    L34:
        int r20 = r1 + 2;
        if (r18 > r20) goto L41;
        int r21 = r5 + 1;
        r3[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        int r22 = r1 + 1;
        if (r18 > r22) goto L39;
    L22:
        int r23 = 1;
    L31:
        r1 = r1 + r23;
    L16:
        r5 = r21;
        goto L8
    L39:
        if ((r16[r22] & 192) != 128) goto L22;
    L29:
        r23 = 2;
        goto L31
    L41:
        byte r24 = r16[r1 + 1];
        if ((r24 & 192) != 128) goto L55;
        byte r25 = r16[r20];
        if ((r25 & 192) != 128) goto L54;
        int r26 = (r6 << 12) ^ ((r25 ^ (-123008)) ^ (r24 << 6));
        if (r26 >= 2048) goto L48;
        r21 = r5 + 1;
        r3[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
    L53:
        r23 = 3;
        goto L31
    L48:
        if (55296 > r26) goto L52;
        if (57343 < r26) goto L52;
        r21 = r5 + 1;
        r3[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
    L52:
        r21 = r5 + 1;
        r3[r5] = (char) r26;
        goto L53
    L54:
        r21 = r5 + 1;
        r3[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L29
    L55:
        r21 = r5 + 1;
        r3[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L22
    L19:
        int r27 = r1 + 1;
        if (r18 > r27) goto L23;
        r21 = r5 + 1;
        r3[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L22
    L23:
        byte r28 = r16[r27];
        if ((r28 & 192) != 128) goto L30;
        int r29 = (r6 << 6) ^ (r28 ^ 3968);
        if (r29 >= 128) goto L28;
        r21 = r5 + 1;
        r3[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L29
    L28:
        r21 = r5 + 1;
        r3[r5] = (char) r29;
        goto L29
    L30:
        r21 = r5 + 1;
        r3[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L22
    L11:
        r21 = r5 + 1;
        r3[r5] = (char) r6;
        r1 = r1 + 1;
    L12:
        if (r1 >= r18) goto L16;
        byte r30 = r16[r1];
        if (r30 < 0) goto L16;
        r1 = r1 + 1;
        r3[r21] = (char) r30;
        r21 = r21 + 1;
        goto L12
    L99:
        return new String(r3, 0, r5);
    L101:
        throw new ArrayIndexOutOfBoundsException("size=" + r16.length + " beginIndex=" + r1 + " endIndex=" + r18);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length;
    L9:
        return commonToUtf8String(r0, r1, r2);
    }
}
