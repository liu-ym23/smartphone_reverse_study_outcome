package okio;

import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Utf8.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", PerfConsts.PERF_DISK_FILE_SIZE, "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int r3) {
        if (r3 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return true;
    L10:
        if (127 <= r3) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L18;
        return true;
    L18:
        return false;
    L12:
        if (r3 >= 160) goto L14;
        r4 = true;
        goto L15
    L5:
        if (r3 >= 32) goto L7;
        r2 = true;
        goto L8
    }

    public static final boolean isUtf8Continuation(byte r1) {
        if ((r1 & 192) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    public static final long size(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return size$default(r3, 0, 0, 3, null);
    }

    public static final long size(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return size$default(r3, r4, 0, 2, null);
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

    public static final long size(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
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
        if (r1 == false) goto L46;
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
    L46:
        throw new IllegalArgumentException(("endIndex > string.length: " + r12 + " > " + r10.length()).toString());
    L48:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r12 + " < " + r11).toString());
    L9:
        r3 = false;
        goto L10
    L50:
        throw new IllegalArgumentException(("beginIndex < 0: " + r11).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final void processUtf8Bytes(String r9, int r10, int r11, Function1<? super Byte, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r12, "yield");
    L3:
        if (r10 >= r11) goto L35;
        char r0 = r9.charAt(r10);
        if (Intrinsics.compare(r0, 128) < 0) goto L6;
        if (Intrinsics.compare(r0, 2048) < 0) goto L13;
        boolean r4 = false;
        if (55296 > r0) goto L19;
        if (r0 >= 57344) goto L19;
        boolean r2 = true;
    L21:
        if (r2 == false) goto L22;
        if (Intrinsics.compare(r0, 56319) > 0) goto L34;
        int r3 = r10 + 1;
        if (r11 <= r3) goto L34;
        char r7 = r9.charAt(r3);
        if (56320 > r7) goto L31;
        if (r7 >= 57344) goto L31;
        r4 = true;
    L31:
        if (r4 == false) goto L34;
        int r1 = ((r0 << '\n') + r9.charAt(r3)) - 56613888;
        r12.invoke(Byte.valueOf((byte) ((r1 >> 18) | 240)));
        r12.invoke(Byte.valueOf((byte) (((r1 >> 12) & 63) | 128)));
        r12.invoke(Byte.valueOf((byte) (((r1 >> 6) & 63) | 128)));
        r12.invoke(Byte.valueOf((byte) ((r1 & 63) | 128)));
        r10 = r10 + 2;
    L34:
        r12.invoke(Byte.valueOf(REPLACEMENT_BYTE));
    L14:
        r10 = r10 + 1;
        goto L3
    L22:
        r12.invoke(Byte.valueOf((byte) ((r0 >> '\f') | 224)));
        r12.invoke(Byte.valueOf((byte) (((r0 >> 6) & 63) | 128)));
        r12.invoke(Byte.valueOf((byte) ((r0 & '?') | 128)));
    L19:
        r2 = false;
        goto L21
    L13:
        r12.invoke(Byte.valueOf((byte) ((r0 >> 6) | 192)));
        r12.invoke(Byte.valueOf((byte) ((r0 & '?') | 128)));
        goto L14
    L6:
        r12.invoke(Byte.valueOf((byte) r0));
        r10 = r10 + 1;
    L7:
        if (r10 >= r11) goto L3;
        if (Intrinsics.compare(r9.charAt(r10), 128) >= 0) goto L3;
        r12.invoke(Byte.valueOf((byte) r9.charAt(r10)));
        r10 = r10 + 1;
        goto L7
    }

    public static final void processUtf8CodePoints(byte[] r16, int r17, int r18, Function1<? super Integer, Unit> r19) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r19, "yield");
        int r3 = r17;
    L3:
        if (r3 >= r18) goto L115;
        byte r4 = r16[r3];
        if (r4 >= 0) goto L6;
        boolean r9 = false;
        if ((r4 >> 5) == (-2)) goto L13;
        if ((r4 >> 4) == (-2)) goto L31;
        if ((r4 >> 3) == (-2)) goto L65;
        r19.invoke(65533);
        r3 = r3 + 1;
        goto L3
    L65:
        int r5 = r3 + 3;
        if (r18 > r5) goto L82;
        r19.invoke(65533);
        Unit r6 = Unit.INSTANCE;
        int r7 = r3 + 1;
        if (r18 > r7) goto L70;
    L16:
        int r8 = 1;
    L28:
        r3 = r3 + r8;
        goto L3
    L70:
        if ((r16[r7] & 192) != 128) goto L72;
        boolean r10 = true;
    L73:
        if (r10 == false) goto L16;
        int r11 = r3 + 2;
        if (r18 > r11) goto L78;
    L27:
        r8 = 2;
        goto L28
    L78:
        if ((r16[r11] & 192) != 128) goto L80;
        r9 = true;
    L80:
        if (r9 == false) goto L27;
    L62:
        r8 = 3;
        goto L28
    L72:
        r10 = false;
        goto L73
    L82:
        byte r12 = r16[r3 + 1];
        if ((r12 & 192) != 128) goto L85;
        boolean r15 = true;
    L86:
        if (r15 == true) goto L88;
        r19.invoke(65533);
        Unit r13 = Unit.INSTANCE;
        goto L16
    L88:
        byte r110 = r16[r3 + 2];
        if ((r110 & 192) != 128) goto L91;
        boolean r14 = true;
    L92:
        if (r14 == true) goto L94;
        r19.invoke(65533);
        Unit r20 = Unit.INSTANCE;
        goto L27
    L94:
        byte r21 = r16[r5];
        if ((r21 & 192) != 128) goto L97;
        boolean r22 = true;
    L98:
        if (r22 == true) goto L100;
        r19.invoke(65533);
        Unit r23 = Unit.INSTANCE;
        goto L62
    L100:
        int r24 = (r4 << 18) ^ (((r21 ^ 3678080) ^ (r110 << 6)) ^ (r12 << 12));
        if (r24 <= 1114111) goto L104;
    L102:
        int r25 = 65533;
    L103:
        r19.invoke(r25);
        Unit r26 = Unit.INSTANCE;
        r8 = 4;
        goto L28
    L104:
        if (55296 > r24) goto L107;
        if (r24 >= 57344) goto L107;
        r9 = true;
    L107:
        if (r9 == true) goto L102;
        if (r24 < 65536) goto L102;
        r25 = Integer.valueOf(r24);
        goto L103
    L97:
        r22 = false;
        goto L98
    L91:
        r14 = false;
        goto L92
    L85:
        r15 = false;
        goto L86
    L31:
        int r27 = r3 + 2;
        if (r18 > r27) goto L40;
        r19.invoke(65533);
        Unit r28 = Unit.INSTANCE;
        int r29 = r3 + 1;
        if (r18 <= r29) goto L16;
        if ((r16[r29] & 192) != 128) goto L38;
        r9 = true;
    L38:
        if (r9 == true) goto L27;
    L40:
        byte r30 = r16[r3 + 1];
        if ((r30 & 192) != 128) goto L43;
        boolean r111 = true;
    L44:
        if (r111 == true) goto L46;
        r19.invoke(65533);
        Unit r31 = Unit.INSTANCE;
        goto L16
    L46:
        byte r32 = r16[r27];
        if ((r32 & 192) != 128) goto L49;
        boolean r33 = true;
    L50:
        if (r33 == true) goto L52;
        r19.invoke(65533);
        Unit r34 = Unit.INSTANCE;
        goto L27
    L52:
        int r35 = (r4 << 12) ^ ((r32 ^ (-123008)) ^ (r30 << 6));
        if (r35 >= 2048) goto L56;
    L54:
        int r36 = 65533;
    L55:
        r19.invoke(r36);
        Unit r37 = Unit.INSTANCE;
        goto L62
    L56:
        if (55296 > r35) goto L59;
        if (r35 >= 57344) goto L59;
        r9 = true;
    L59:
        if (r9 == true) goto L54;
        r36 = Integer.valueOf(r35);
        goto L55
    L49:
        r33 = false;
        goto L50
    L43:
        r111 = false;
        goto L44
    L13:
        int r38 = r3 + 1;
        if (r18 > r38) goto L17;
    L15:
        r19.invoke(65533);
        Unit r39 = Unit.INSTANCE;
        goto L16
    L17:
        byte r40 = r16[r38];
        if ((r40 & 192) != 128) goto L20;
        r9 = true;
    L20:
        if (r9 == false) goto L15;
        int r41 = (r4 << 6) ^ (r40 ^ 3968);
        if (r41 >= 128) goto L25;
        int r42 = 65533;
    L26:
        r19.invoke(r42);
        Unit r43 = Unit.INSTANCE;
        goto L27
    L25:
        r42 = Integer.valueOf(r41);
        goto L26
    L6:
        r19.invoke(Integer.valueOf(r4));
        r3 = r3 + 1;
    L7:
        if (r3 >= r18) goto L3;
        byte r44 = r16[r3];
        if (r44 < 0) goto L3;
        r3 = r3 + 1;
        r19.invoke(Integer.valueOf(r44));
        goto L7
    }

    public static final void processUtf16Chars(byte[] r16, int r17, int r18, Function1<? super Character, Unit> r19) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r19, "yield");
        int r3 = r17;
    L3:
        if (r3 >= r18) goto L116;
        byte r4 = r16[r3];
        if (r4 >= 0) goto L6;
        boolean r9 = false;
        if ((r4 >> 5) == (-2)) goto L13;
        if ((r4 >> 4) == (-2)) goto L31;
        if ((r4 >> 3) == (-2)) goto L65;
        r19.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        r3 = r3 + 1;
        goto L3
    L65:
        int r5 = r3 + 3;
        if (r18 > r5) goto L82;
        r19.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        Unit r6 = Unit.INSTANCE;
        int r7 = r3 + 1;
        if (r18 > r7) goto L70;
    L16:
        int r8 = 1;
    L28:
        r3 = r3 + r8;
        goto L3
    L70:
        if ((r16[r7] & 192) != 128) goto L72;
        boolean r10 = true;
    L73:
        if (r10 == false) goto L16;
        int r11 = r3 + 2;
        if (r18 > r11) goto L78;
    L27:
        r8 = 2;
        goto L28
    L78:
        if ((r16[r11] & 192) != 128) goto L80;
        r9 = true;
    L80:
        if (r9 == false) goto L27;
    L62:
        r8 = 3;
        goto L28
    L72:
        r10 = false;
        goto L73
    L82:
        byte r12 = r16[r3 + 1];
        if ((r12 & 192) != 128) goto L85;
        boolean r15 = true;
    L86:
        if (r15 == true) goto L88;
        r19.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        Unit r13 = Unit.INSTANCE;
        goto L16
    L88:
        byte r110 = r16[r3 + 2];
        if ((r110 & 192) != 128) goto L91;
        boolean r14 = true;
    L92:
        if (r14 == true) goto L94;
        r19.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        Unit r20 = Unit.INSTANCE;
        goto L27
    L94:
        byte r21 = r16[r5];
        if ((r21 & 192) != 128) goto L97;
        boolean r22 = true;
    L98:
        if (r22 == true) goto L100;
        r19.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        Unit r23 = Unit.INSTANCE;
        goto L62
    L100:
        int r24 = (r4 << 18) ^ (((r21 ^ 3678080) ^ (r110 << 6)) ^ (r12 << 12));
        if (r24 <= 1114111) goto L104;
    L102:
        r19.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
    L103:
        Unit r25 = Unit.INSTANCE;
        r8 = 4;
        goto L28
    L104:
        if (55296 > r24) goto L107;
        if (r24 >= 57344) goto L107;
        r9 = true;
    L107:
        if (r9 == true) goto L102;
        if (r24 < 65536) goto L102;
        if (r24 == 65533) goto L102;
        r19.invoke(Character.valueOf((char) ((r24 >>> 10) + HIGH_SURROGATE_HEADER)));
        r19.invoke(Character.valueOf((char) ((r24 & 1023) + LOG_SURROGATE_HEADER)));
        goto L103
    L97:
        r22 = false;
        goto L98
    L91:
        r14 = false;
        goto L92
    L85:
        r15 = false;
        goto L86
    L31:
        int r26 = r3 + 2;
        if (r18 > r26) goto L40;
        r19.invoke(Character.valueOf((char) 65533));
        Unit r27 = Unit.INSTANCE;
        int r28 = r3 + 1;
        if (r18 <= r28) goto L16;
        if ((r16[r28] & 192) != 128) goto L38;
        r9 = true;
    L38:
        if (r9 == true) goto L27;
    L40:
        byte r29 = r16[r3 + 1];
        if ((r29 & 192) != 128) goto L43;
        boolean r111 = true;
    L44:
        if (r111 == true) goto L46;
        r19.invoke(Character.valueOf((char) 65533));
        Unit r30 = Unit.INSTANCE;
        goto L16
    L46:
        byte r31 = r16[r26];
        if ((r31 & 192) != 128) goto L49;
        boolean r32 = true;
    L50:
        if (r32 == true) goto L52;
        r19.invoke(Character.valueOf((char) 65533));
        Unit r33 = Unit.INSTANCE;
        goto L27
    L52:
        int r34 = (r4 << 12) ^ ((r31 ^ (-123008)) ^ (r29 << 6));
        if (r34 >= 2048) goto L56;
    L54:
        char r35 = (char) 65533;
    L55:
        r19.invoke(Character.valueOf(r35));
        Unit r36 = Unit.INSTANCE;
        goto L62
    L56:
        if (55296 > r34) goto L59;
        if (r34 >= 57344) goto L59;
        r9 = true;
    L59:
        if (r9 == true) goto L54;
        r35 = (char) r34;
        goto L55
    L49:
        r32 = false;
        goto L50
    L43:
        r111 = false;
        goto L44
    L13:
        int r37 = r3 + 1;
        if (r18 > r37) goto L17;
    L15:
        r19.invoke(Character.valueOf((char) 65533));
        Unit r38 = Unit.INSTANCE;
        goto L16
    L17:
        byte r39 = r16[r37];
        if ((r39 & 192) != 128) goto L20;
        r9 = true;
    L20:
        if (r9 == false) goto L15;
        int r40 = (r4 << 6) ^ (r39 ^ 3968);
        if (r40 >= 128) goto L25;
        char r41 = (char) 65533;
    L26:
        r19.invoke(Character.valueOf(r41));
        Unit r42 = Unit.INSTANCE;
        goto L27
    L25:
        r41 = (char) r40;
        goto L26
    L6:
        r19.invoke(Character.valueOf((char) r4));
        r3 = r3 + 1;
    L7:
        if (r3 >= r18) goto L3;
        byte r43 = r16[r3];
        if (r43 < 0) goto L3;
        r3 = r3 + 1;
        r19.invoke(Character.valueOf((char) r43));
        goto L7
    }

    public static final int process2Utf8Bytes(byte[] r3, int r4, int r5, Function1<? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r6, "yield");
        int r0 = r4 + 1;
        if (r5 > r0) goto L6;
        r6.invoke(65533);
        return 1;
    L6:
        byte r7 = r3[r4];
        byte r8 = r3[r0];
        if ((r8 & 192) != 128) goto L9;
        boolean r9 = true;
    L10:
        if (r9 == true) goto L13;
        r6.invoke(65533);
        return 1;
    L13:
        int r10 = (r8 ^ 3968) ^ (r7 << 6);
        if (r10 >= 128) goto L16;
        r6.invoke(65533);
        return 2;
    L16:
        r6.invoke(Integer.valueOf(r10));
        return 2;
    L9:
        r9 = false;
        goto L10
    }

    public static final int process3Utf8Bytes(byte[] r7, int r8, int r9, Function1<? super Integer, Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r10, "yield");
        int r0 = r8 + 2;
        boolean r2 = false;
        if (r9 > r0) goto L13;
        r10.invoke(65533);
        int r11 = r8 + 1;
        if (r9 > r11) goto L7;
    L12:
        return 1;
    L7:
        if ((r7[r11] & 192) != 128) goto L9;
        r2 = true;
    L9:
        if (r2 == false) goto L12;
        return 2;
    L13:
        byte r12 = r7[r8];
        byte r13 = r7[r8 + 1];
        if ((r13 & 192) != 128) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L20;
        r10.invoke(65533);
        return 1;
    L20:
        byte r14 = r7[r0];
        if ((r14 & 192) != 128) goto L23;
        boolean r1 = true;
    L24:
        if (r1 == true) goto L27;
        r10.invoke(65533);
        return 2;
    L27:
        int r15 = ((r14 ^ (-123008)) ^ (r13 << 6)) ^ (r12 << 12);
        if (r15 >= 2048) goto L31;
        r10.invoke(65533);
        return 3;
    L31:
        if (55296 <= r15) goto L33;
    L35:
        if (r2 == false) goto L37;
        r10.invoke(65533);
        return 3;
    L37:
        r10.invoke(Integer.valueOf(r15));
        return 3;
    L33:
        if (r15 >= 57344) goto L35;
        r2 = true;
        goto L35
    L23:
        r1 = false;
        goto L24
    L16:
        r6 = false;
        goto L17
    }

    public static final int process4Utf8Bytes(byte[] r9, int r10, int r11, Function1<? super Integer, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r12, "yield");
        int r0 = r10 + 3;
        boolean r3 = false;
        if (r11 > r0) goto L22;
        r12.invoke(65533);
        int r13 = r10 + 1;
        if (r11 > r13) goto L7;
    L21:
        return 1;
    L7:
        if ((r9[r13] & 192) != 128) goto L9;
        boolean r14 = true;
    L10:
        if (r14 == false) goto L21;
        int r15 = r10 + 2;
        if (r11 > r15) goto L15;
    L20:
        return 2;
    L15:
        if ((r9[r15] & 192) != 128) goto L17;
        r3 = true;
    L17:
        if (r3 == false) goto L20;
        return 3;
    L9:
        r14 = false;
        goto L10
    L22:
        byte r16 = r9[r10];
        byte r7 = r9[r10 + 1];
        if ((r7 & 192) != 128) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L29;
        r12.invoke(65533);
        return 1;
    L29:
        byte r17 = r9[r10 + 2];
        if ((r17 & 192) != 128) goto L32;
        boolean r18 = true;
    L33:
        if (r18 == true) goto L36;
        r12.invoke(65533);
        return 2;
    L36:
        byte r19 = r9[r0];
        if ((r19 & 192) != 128) goto L39;
        boolean r1 = true;
    L40:
        if (r1 == true) goto L43;
        r12.invoke(65533);
        return 3;
    L43:
        int r20 = (((r19 ^ 3678080) ^ (r17 << 6)) ^ (r7 << 12)) ^ (r16 << 18);
        if (r20 <= 1114111) goto L47;
        r12.invoke(65533);
        return 4;
    L47:
        if (55296 <= r20) goto L49;
    L51:
        if (r3 == false) goto L54;
        r12.invoke(65533);
        return 4;
    L54:
        if (r20 >= 65536) goto L56;
        r12.invoke(65533);
        return 4;
    L56:
        r12.invoke(Integer.valueOf(r20));
        return 4;
    L49:
        if (r20 >= 57344) goto L51;
        r3 = true;
        goto L51
    L39:
        r1 = false;
        goto L40
    L32:
        r18 = false;
        goto L33
    L25:
        r8 = false;
        goto L26
    }
}
