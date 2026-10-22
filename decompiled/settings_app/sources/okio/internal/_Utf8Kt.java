package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8;

/* JADX INFO: compiled from: -Utf8.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length;
    L9:
        return commonToUtf8String(r0, r1, r2);
    }

    public static final String commonToUtf8String(byte[] r16, int r17, int r18) {
        int r1 = r17;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        if (r1 < 0) goto L138;
        if (r18 > r16.length) goto L138;
        if (r1 > r18) goto L138;
        char[] r3 = new char[r18 - r1];
        int r5 = 0;
    L8:
        if (r1 >= r18) goto L136;
        byte r6 = r16[r1];
        if (r6 >= 0) goto L11;
        if ((r6 >> 5) == (-2)) goto L19;
        if ((r6 >> 4) == (-2)) goto L41;
        if ((r6 >> 3) == (-2)) goto L78;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        r1 = r1 + 1;
        r5 = r5 + 1;
        goto L8
    L78:
        int r7 = r1 + 3;
        if (r18 > r7) goto L99;
        int r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        Unit r9 = Unit.INSTANCE;
        int r10 = r1 + 1;
        if (r18 > r10) goto L83;
    L98:
        r5 = r8;
    L24:
        int r11 = 1;
    L38:
        r1 = r1 + r11;
        goto L8
    L83:
        if ((r16[r10] & 192) != 128) goto L85;
        boolean r12 = true;
    L86:
        if (r12 == false) goto L98;
        int r13 = r1 + 2;
        if (r18 > r13) goto L91;
    L97:
        r5 = r8;
    L37:
        r11 = 2;
        goto L38
    L91:
        if ((r16[r13] & 192) != 128) goto L93;
        boolean r14 = true;
    L94:
        if (r14 == false) goto L97;
    L96:
        r5 = r8;
    L75:
        r11 = 3;
        goto L38
    L93:
        r14 = false;
        goto L94
    L85:
        r12 = false;
        goto L86
    L99:
        byte r15 = r16[r1 + 1];
        if ((r15 & 192) != 128) goto L102;
        boolean r19 = true;
    L103:
        if (r19 == true) goto L105;
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        Unit r20 = Unit.INSTANCE;
        goto L98
    L105:
        byte r21 = r16[r1 + 2];
        if ((r21 & 192) != 128) goto L108;
        boolean r110 = true;
    L109:
        if (r110 == true) goto L111;
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        Unit r22 = Unit.INSTANCE;
        goto L97
    L111:
        byte r23 = r16[r7];
        if ((r23 & 192) != 128) goto L114;
        boolean r111 = true;
    L115:
        if (r111 == true) goto L117;
        r8 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        Unit r24 = Unit.INSTANCE;
        goto L96
    L117:
        int r25 = (r6 << 18) ^ (((r23 ^ 3678080) ^ (r21 << 6)) ^ (r15 << 12));
        if (r25 <= 1114111) goto L121;
        int r26 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
    L120:
        Unit r27 = Unit.INSTANCE;
        r11 = 4;
        r5 = r26;
        goto L38
    L121:
        if (55296 > r25) goto L124;
        if (r25 >= 57344) goto L124;
        boolean r112 = true;
    L125:
        if (r112 == false) goto L128;
        r26 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L120
    L128:
        if (r25 >= 65536) goto L130;
        r26 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L120
    L130:
        if (r25 == 65533) goto L132;
        int r28 = r5 + 1;
        r3[r5] = (char) ((r25 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        char r29 = (char) ((r25 & 1023) + Utf8.LOG_SURROGATE_HEADER);
        r26 = r28 + 1;
        r3[r28] = r29;
        goto L120
    L132:
        r26 = r5 + 1;
        r3[r5] = Utf8.REPLACEMENT_CHARACTER;
    L124:
        r112 = false;
        goto L125
    L114:
        r111 = false;
        goto L115
    L108:
        r110 = false;
        goto L109
    L102:
        r19 = false;
        goto L103
    L41:
        int r30 = r1 + 2;
        if (r18 > r30) goto L51;
        int r31 = r5 + 1;
        r3[r5] = (char) 65533;
        Unit r32 = Unit.INSTANCE;
        int r33 = r1 + 1;
        if (r18 > r33) goto L46;
    L23:
        r5 = r31;
        goto L24
    L46:
        if ((r16[r33] & 192) != 128) goto L48;
        boolean r34 = true;
    L49:
        if (r34 == false) goto L23;
    L36:
        r5 = r31;
        goto L37
    L48:
        r34 = false;
        goto L49
    L51:
        byte r35 = r16[r1 + 1];
        if ((r35 & 192) != 128) goto L54;
        boolean r36 = true;
    L55:
        if (r36 == true) goto L57;
        r31 = r5 + 1;
        r3[r5] = (char) 65533;
        Unit r37 = Unit.INSTANCE;
        goto L23
    L57:
        byte r38 = r16[r30];
        if ((r38 & 192) != 128) goto L60;
        boolean r39 = true;
    L61:
        if (r39 == true) goto L63;
        r31 = r5 + 1;
        r3[r5] = (char) 65533;
        Unit r40 = Unit.INSTANCE;
        goto L36
    L63:
        int r41 = (r6 << 12) ^ ((r38 ^ (-123008)) ^ (r35 << 6));
        if (r41 >= 2048) goto L67;
        int r42 = r5 + 1;
        r3[r5] = (char) 65533;
    L66:
        Unit r43 = Unit.INSTANCE;
        r5 = r42;
        goto L75
    L67:
        if (55296 > r41) goto L70;
        if (r41 >= 57344) goto L70;
        boolean r113 = true;
    L71:
        if (r113 == false) goto L73;
        r42 = r5 + 1;
        r3[r5] = (char) 65533;
        goto L66
    L73:
        r42 = r5 + 1;
        r3[r5] = (char) r41;
    L70:
        r113 = false;
        goto L71
    L60:
        r39 = false;
        goto L61
    L54:
        r36 = false;
        goto L55
    L19:
        int r44 = r1 + 1;
        if (r18 > r44) goto L25;
        r31 = r5 + 1;
        r3[r5] = (char) 65533;
    L22:
        Unit r45 = Unit.INSTANCE;
        goto L23
    L25:
        byte r46 = r16[r44];
        if ((r46 & 192) != 128) goto L28;
        boolean r47 = true;
    L29:
        if (r47 == true) goto L31;
        r31 = r5 + 1;
        r3[r5] = (char) 65533;
        goto L22
    L31:
        int r48 = (r6 << 6) ^ (r46 ^ 3968);
        if (r48 >= 128) goto L34;
        r31 = r5 + 1;
        r3[r5] = (char) 65533;
    L35:
        Unit r49 = Unit.INSTANCE;
        goto L36
    L34:
        r31 = r5 + 1;
        r3[r5] = (char) r48;
        goto L35
    L28:
        r47 = false;
        goto L29
    L11:
        int r50 = r5 + 1;
        r3[r5] = (char) r6;
        r1 = r1 + 1;
    L12:
        r5 = r50;
        if (r1 >= r18) goto L8;
        byte r51 = r16[r1];
        if (r51 < 0) goto L8;
        r1 = r1 + 1;
        r50 = r5 + 1;
        r3[r5] = (char) r51;
        goto L12
    L136:
        return StringsKt.concatToString(r3, 0, r5);
    L138:
        throw new ArrayIndexOutOfBoundsException("size=" + r16.length + " beginIndex=" + r1 + " endIndex=" + r18);
    }

    public static final byte[] commonAsUtf8ToByteArray(String r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        byte[] r0 = new byte[r14.length() * 4];
        int r1 = r14.length();
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L46;
        char r5 = r14.charAt(r3);
        if (Intrinsics.compare(r5, 128) >= 0) goto L7;
        r0[r3] = (byte) r5;
        r3 = r3 + 1;
        goto L4
    L7:
        int r2 = r14.length();
        int r6 = r3;
    L8:
        if (r3 >= r2) goto L43;
        char r7 = r14.charAt(r3);
        if (Intrinsics.compare(r7, 128) < 0) goto L11;
        if (Intrinsics.compare(r7, 2048) >= 0) goto L22;
        int r9 = r6 + 1;
        r0[r6] = (byte) ((r7 >> 6) | 192);
        byte r8 = (byte) ((r7 & '?') | 128);
        int r10 = r9 + 1;
        r0[r9] = r8;
    L20:
        r3 = r3 + 1;
    L21:
        r6 = r10;
        goto L8
    L22:
        boolean r11 = true;
        if (55296 > r7) goto L26;
        if (r7 >= 57344) goto L26;
        boolean r12 = true;
    L28:
        if (r12 == true) goto L31;
        int r13 = r6 + 1;
        r0[r6] = (byte) ((r7 >> '\f') | 224);
        int r15 = r13 + 1;
        r0[r13] = (byte) (((r7 >> 6) & 63) | 128);
        byte r16 = (byte) ((r7 & '?') | 128);
        r10 = r15 + 1;
        r0[r15] = r16;
        goto L20
    L31:
        if (Intrinsics.compare(r7, 56319) > 0) goto L42;
        int r17 = r3 + 1;
        if (r2 <= r17) goto L42;
        char r18 = r14.charAt(r17);
        if (56320 > r18) goto L38;
        if (r18 >= 57344) goto L38;
    L39:
        if (r11 == false) goto L42;
        int r19 = ((r7 << '\n') + r14.charAt(r17)) - 56613888;
        int r20 = r6 + 1;
        r0[r6] = (byte) ((r19 >> 18) | 240);
        int r21 = r20 + 1;
        r0[r20] = (byte) (((r19 >> 12) & 63) | 128);
        int r22 = r21 + 1;
        r0[r21] = (byte) (((r19 >> 6) & 63) | 128);
        byte r23 = (byte) ((r19 & 63) | 128);
        r10 = r22 + 1;
        r0[r22] = r23;
        r3 = r3 + 2;
    L38:
        r11 = false;
    L42:
        r10 = r6 + 1;
        r0[r6] = Utf8.REPLACEMENT_BYTE;
    L26:
        r12 = false;
        goto L28
    L11:
        int r24 = r6 + 1;
        r0[r6] = (byte) r7;
        r3 = r3 + 1;
    L12:
        r6 = r24;
        if (r3 >= r2) goto L8;
        if (Intrinsics.compare(r14.charAt(r3), 128) >= 0) goto L8;
        r24 = r6 + 1;
        r0[r6] = (byte) r14.charAt(r3);
        r3 = r3 + 1;
        goto L12
    L43:
        byte[] r110 = Arrays.copyOf(r0, r6);
        Intrinsics.checkNotNullExpressionValue(r110, "copyOf(this, newSize)");
        return r110;
    L46:
        byte[] r111 = Arrays.copyOf(r0, r14.length());
        Intrinsics.checkNotNullExpressionValue(r111, "copyOf(this, newSize)");
        return r111;
    }
}
