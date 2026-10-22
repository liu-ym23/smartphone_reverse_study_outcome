package okio.internal;

import a.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ByteStringKt {

    @NotNull
    private static final char[] HEX_DIGIT_CHARS = null;

    static {
        HEX_DIGIT_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static final /* synthetic */ int access$codePointIndexToCharIndex(byte[] r0, int r1) {
        return codePointIndexToCharIndex(r0, r1);
    }

    public static final /* synthetic */ int access$decodeHexDigit(char r0) {
        return decodeHexDigit(r0);
    }

    private static final int codePointIndexToCharIndex(byte[] r18, int r19) {
        int r2 = r18.length;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r3 >= r2) goto L191;
        byte r6 = r18[r3];
        if (r6 >= 0) goto L6;
        if ((r6 >> 5) == (-2)) goto L46;
        if ((r6 >> 4) != (-2)) goto L130;
        int r14 = r3 + 2;
        if (r2 <= r14) goto L83;
        byte r15 = r18[r3 + 1];
        if ((r15 & 192) != 128) goto L126;
        byte r8 = r18[r14];
        if ((r8 & 192) != 128) goto L123;
        int r7 = (r6 << 12) ^ ((r8 ^ (-123008)) ^ (r15 << 6));
        if (r7 < 2048) goto L92;
        if (55296 > r7) goto L101;
        if (57343 < r7) goto L101;
        if (r5 != r19) goto L100;
        return r4;
    L100:
        return -1;
    L101:
        int r9 = r5 + 1;
        if (r5 == r19) goto L103;
        if (r7 == 10) goto L115;
        if (r7 == 13) goto L115;
        if (r7 < 0) goto L109;
        if (31 < r7) goto L109;
    L116:
        return -1;
    L109:
        if (127 > r7) goto L115;
        if (159 >= r7) goto L116;
    L115:
        if (r7 == 65533) goto L116;
        if (r7 >= 65536) goto L120;
        int r16 = 1;
    L121:
        r4 = r4 + r16;
        r3 = r3 + 3;
    L122:
        r5 = r9;
        goto L3
    L120:
        r16 = 2;
        goto L121
    L103:
        return r4;
    L92:
        if (r5 != r19) goto L94;
        return r4;
    L94:
        return -1;
    L123:
        if (r5 != r19) goto L125;
        return r4;
    L125:
        return -1;
    L126:
        if (r5 != r19) goto L128;
        return r4;
    L128:
        return -1;
    L83:
        if (r5 != r19) goto L85;
        return r4;
    L85:
        return -1;
    L130:
        if ((r6 >> 3) != (-2)) goto L188;
        int r10 = r3 + 3;
        if (r2 <= r10) goto L133;
        byte r17 = r18[r3 + 1];
        if ((r17 & 192) != 128) goto L185;
        byte r110 = r18[r3 + 2];
        if ((r110 & 192) != 128) goto L182;
        byte r11 = r18[r10];
        if ((r11 & 192) != 128) goto L179;
        int r12 = (r6 << 18) ^ (((r11 ^ 3678080) ^ (r110 << 6)) ^ (r17 << 12));
        if (r12 > 1114111) goto L144;
        if (55296 > r12) goto L153;
        if (57343 < r12) goto L153;
        if (r5 != r19) goto L152;
        return r4;
    L152:
        return -1;
    L153:
        if (r12 < 65536) goto L154;
        r9 = r5 + 1;
        if (r5 == r19) goto L159;
        if (r12 == 10) goto L172;
        if (r12 == 13) goto L172;
        if (r12 < 0) goto L166;
        if (31 < r12) goto L166;
    L173:
        return -1;
    L166:
        if (127 > r12) goto L172;
        if (159 >= r12) goto L173;
    L172:
        if (r12 == 65533) goto L173;
        if (r12 >= 65536) goto L177;
        int r111 = 1;
    L178:
        r4 = r4 + r111;
        r3 = r3 + 4;
        goto L122
    L177:
        r111 = 2;
        goto L178
    L159:
        return r4;
    L154:
        if (r5 != r19) goto L156;
        return r4;
    L156:
        return -1;
    L144:
        if (r5 != r19) goto L146;
        return r4;
    L146:
        return -1;
    L179:
        if (r5 != r19) goto L181;
        return r4;
    L181:
        return -1;
    L182:
        if (r5 != r19) goto L184;
        return r4;
    L184:
        return -1;
    L185:
        if (r5 != r19) goto L187;
        return r4;
    L187:
        return -1;
    L133:
        if (r5 != r19) goto L135;
        return r4;
    L135:
        return -1;
    L188:
        if (r5 != r19) goto L190;
        return r4;
    L190:
        return -1;
    L46:
        int r112 = r3 + 1;
        if (r2 <= r112) goto L48;
        byte r113 = r18[r112];
        if ((r113 & 192) != 128) goto L76;
        int r13 = (r6 << 6) ^ (r113 ^ 3968);
        if (r13 < 128) goto L55;
        int r114 = r5 + 1;
        if (r5 == r19) goto L60;
        if (r13 == 10) goto L69;
        if (r13 == 13) goto L69;
        if (r13 < 0) goto L65;
        if (31 < r13) goto L65;
    L70:
        return -1;
    L65:
        if (127 > r13) goto L69;
        if (159 >= r13) goto L70;
    L69:
        if (r13 == 65533) goto L70;
        if (r13 >= 65536) goto L74;
        int r115 = 1;
    L75:
        r4 = r4 + r115;
        r3 = r3 + 2;
        r5 = r114;
        goto L3
    L74:
        r115 = 2;
        goto L75
    L60:
        return r4;
    L55:
        if (r5 != r19) goto L57;
        return r4;
    L57:
        return -1;
    L76:
        if (r5 != r19) goto L78;
        return r4;
    L78:
        return -1;
    L48:
        if (r5 != r19) goto L50;
        return r4;
    L50:
        return -1;
    L6:
        int r116 = r5 + 1;
        if (r5 == r19) goto L8;
        if (r6 == 10) goto L17;
        if (r6 == 13) goto L17;
        if (r6 < 0) goto L13;
        if (31 < r6) goto L13;
    L18:
        return -1;
    L13:
        if (127 > r6) goto L17;
        if (159 >= r6) goto L18;
    L17:
        if (r6 == 65533) goto L18;
        if (r6 >= 65536) goto L21;
        int r20 = 1;
    L22:
        r4 = r4 + r20;
        r3 = r3 + 1;
    L23:
        r5 = r116;
        if (r3 >= r2) goto L3;
        byte r21 = r18[r3];
        if (r21 < 0) goto L3;
        r3 = r3 + 1;
        r116 = r5 + 1;
        if (r5 == r19) goto L29;
        if (r21 == 10) goto L38;
        if (r21 == 13) goto L38;
        if (r21 < 0) goto L34;
        if (31 < r21) goto L34;
    L39:
        return -1;
    L34:
        if (127 > r21) goto L38;
        if (159 >= r21) goto L39;
    L38:
        if (r21 == 65533) goto L39;
        if (r21 >= 65536) goto L42;
        int r22 = 1;
    L43:
        r4 = r4 + r22;
        goto L23
    L42:
        r22 = 2;
        goto L43
    L29:
        return r4;
    L21:
        r20 = 2;
        goto L22
    L8:
        return r4;
    L191:
        return r4;
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString r2) {
        Intrinsics.f(r2, "$this$commonBase64");
        return Base64.encodeBase64$default(r2.getData$okio(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString r1) {
        Intrinsics.f(r1, "$this$commonBase64Url");
        return Base64.encodeBase64(r1.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString r9, @NotNull ByteString r10) {
        Intrinsics.f(r9, "$this$commonCompareTo");
        Intrinsics.f(r10, "other");
        int r0 = r9.size();
        int r1 = r10.size();
        int r2 = Math.min(r0, r1);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L12;
        int r7 = r9.getByte(r4) & 255;
        int r8 = r10.getByte(r4) & 255;
        if (r7 != r8) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        if (r7 >= r8) goto L11;
        return -1;
    L11:
        return 1;
    L12:
        if (r0 != r1) goto L14;
        return 0;
    L14:
        if (r0 >= r1) goto L17;
        return -1;
    L17:
        return 1;
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String r1) {
        Intrinsics.f(r1, "$this$commonDecodeBase64");
        byte[] r2 = Base64.decodeBase64ToArray(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new ByteString(r2);
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String r6) {
        Intrinsics.f(r6, "$this$commonDecodeHex");
        int r1 = 0;
        if ((r6.length() % 2) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        int r2 = r6.length() / 2;
        byte[] r3 = new byte[r2];
    L8:
        if (r1 >= r2) goto L11;
        int r4 = r1 * 2;
        r3[r1] = (byte) (access$decodeHexDigit(r6.charAt(r4 + 1)) + (access$decodeHexDigit(r6.charAt(r4)) << 4));
        r1 = r1 + 1;
        goto L8
    L11:
        return new ByteString(r3);
    L13:
        throw new IllegalArgumentException("Unexpected hex string: ".concat(r6).toString());
    L5:
        r0 = false;
        goto L6
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String r2) {
        Intrinsics.f(r2, "$this$commonEncodeUtf8");
        ByteString r0 = new ByteString(Platform.asUtf8ToByteArray(r2));
        r0.setUtf8$okio(r2);
        return r0;
    }

    public static final boolean commonEndsWith(@NotNull ByteString r3, @NotNull ByteString r4) {
        Intrinsics.f(r3, "$this$commonEndsWith");
        Intrinsics.f(r4, "suffix");
        return r3.rangeEquals(r3.size() - r4.size(), r4, 0, r4.size());
    }

    public static final boolean commonEquals(@NotNull ByteString r4, @Nullable Object r5) {
        Intrinsics.f(r4, "$this$commonEquals");
        if (r5 != r4) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == false) goto L13;
        ByteString r6 = (ByteString) r5;
        if (r6.size() != r4.getData$okio().length) goto L13;
        if (r6.rangeEquals(0, r4.getData$okio(), 0, r4.getData$okio().length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString r1, int r2) {
        Intrinsics.f(r1, "$this$commonGetByte");
        return r1.getData$okio()[r2];
    }

    public static final int commonGetSize(@NotNull ByteString r1) {
        Intrinsics.f(r1, "$this$commonGetSize");
        return r1.getData$okio().length;
    }

    public static final int commonHashCode(@NotNull ByteString r1) {
        Intrinsics.f(r1, "$this$commonHashCode");
        int r0 = r1.getHashCode$okio();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r2 = Arrays.hashCode(r1.getData$okio());
        r1.setHashCode$okio(r2);
        return r2;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString r8) {
        Intrinsics.f(r8, "$this$commonHex");
        char[] r0 = new char[r8.getData$okio().length * 2];
        byte[] r9 = r8.getData$okio();
        int r1 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r4 = r9[r2];
        int r5 = r3 + 1;
        r0[r3] = getHEX_DIGIT_CHARS()[(r4 >> 4) & 15];
        r3 = r3 + 2;
        r0[r5] = getHEX_DIGIT_CHARS()[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return new String(r0);
    }

    public static final int commonIndexOf(@NotNull ByteString r4, @NotNull byte[] r5, int r6) {
        Intrinsics.f(r4, "$this$commonIndexOf");
        Intrinsics.f(r5, "other");
        int r0 = r4.getData$okio().length - r5.length;
        int r7 = Math.max(r6, 0);
        if (r7 <= r0) goto L5;
        return -1;
    L5:
        if (Util.arrayRangeEquals(r4.getData$okio(), r7, r5, 0, r5.length) == true) goto L6;
        if (r7 == r0) goto L13;
        r7 = r7 + 1;
        goto L5
    L13:
        return -1;
    L6:
        return r7;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString r1) {
        Intrinsics.f(r1, "$this$commonInternalArray");
        return r1.getData$okio();
    }

    public static final int commonLastIndexOf(@NotNull ByteString r1, @NotNull ByteString r2, int r3) {
        Intrinsics.f(r1, "$this$commonLastIndexOf");
        Intrinsics.f(r2, "other");
        return r1.lastIndexOf(r2.internalArray$okio(), r3);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] r2) {
        Intrinsics.f(r2, "data");
        byte[] r3 = Arrays.copyOf(r2, r2.length);
        Intrinsics.e(r3, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(r3);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString r1, int r2, @NotNull ByteString r3, int r4, int r5) {
        Intrinsics.f(r1, "$this$commonRangeEquals");
        Intrinsics.f(r3, "other");
        return r3.rangeEquals(r4, r1.getData$okio(), r2, r5);
    }

    public static final boolean commonStartsWith(@NotNull ByteString r2, @NotNull ByteString r3) {
        Intrinsics.f(r2, "$this$commonStartsWith");
        Intrinsics.f(r3, "prefix");
        return r2.rangeEquals(0, r3, 0, r3.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString r3, int r4, int r5) {
        Intrinsics.f(r3, "$this$commonSubstring");
        boolean r0 = false;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L27;
        if (r5 > r3.getData$okio().length) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L25;
        if ((r5 - r4) < 0) goto L15;
        r0 = true;
    L15:
        if (r0 == false) goto L23;
        if (r4 != 0) goto L21;
        if (r5 != r3.getData$okio().length) goto L21;
        return r3;
    L21:
        return new ByteString(ArraysKt.j(r3.getData$okio(), r4, r5));
    L23:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L25:
        throw new IllegalArgumentException(a.l(new StringBuilder("endIndex > length("), r3.getData$okio().length, ')').toString());
    L10:
        r6 = false;
        goto L11
    L27:
        throw new IllegalArgumentException("beginIndex < 0".toString());
    L5:
        r2 = false;
        goto L6
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString r5) {
        Intrinsics.f(r5, "$this$commonToAsciiLowercase");
        int r0 = 0;
    L4:
        if (r0 >= r5.getData$okio().length) goto L22;
        byte r1 = r5.getData$okio()[r0];
        byte r2 = (byte) 65;
        if (r1 < r2) goto L21;
        byte r3 = (byte) 90;
        if (r1 > r3) goto L21;
        byte[] r6 = r5.getData$okio();
        byte[] r7 = Arrays.copyOf(r6, r6.length);
        Intrinsics.e(r7, "java.util.Arrays.copyOf(this, size)");
        int r4 = r0 + 1;
        r7[r0] = (byte) (r1 + 32);
    L12:
        if (r4 >= r7.length) goto L20;
        byte r8 = r7[r4];
        if (r8 < r2) goto L18;
        if (r8 > r3) goto L18;
        r7[r4] = (byte) (r8 + 32);
    L18:
        r4 = r4 + 1;
        goto L12
    L20:
        return new ByteString(r7);
    L21:
        r0 = r0 + 1;
        goto L4
    L22:
        return r5;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString r5) {
        Intrinsics.f(r5, "$this$commonToAsciiUppercase");
        int r0 = 0;
    L4:
        if (r0 >= r5.getData$okio().length) goto L22;
        byte r1 = r5.getData$okio()[r0];
        byte r2 = (byte) 97;
        if (r1 < r2) goto L21;
        byte r3 = (byte) 122;
        if (r1 > r3) goto L21;
        byte[] r6 = r5.getData$okio();
        byte[] r7 = Arrays.copyOf(r6, r6.length);
        Intrinsics.e(r7, "java.util.Arrays.copyOf(this, size)");
        int r4 = r0 + 1;
        r7[r0] = (byte) (r1 - 32);
    L12:
        if (r4 >= r7.length) goto L20;
        byte r8 = r7[r4];
        if (r8 < r2) goto L18;
        if (r8 > r3) goto L18;
        r7[r4] = (byte) (r8 - 32);
    L18:
        r4 = r4 + 1;
        goto L12
    L20:
        return new ByteString(r7);
    L21:
        r0 = r0 + 1;
        goto L4
    L22:
        return r5;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString r1) {
        Intrinsics.f(r1, "$this$commonToByteArray");
        byte[] r2 = r1.getData$okio();
        byte[] r3 = Arrays.copyOf(r2, r2.length);
        Intrinsics.e(r3, "java.util.Arrays.copyOf(this, size)");
        return r3;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] r7, int r8, int r9) {
        Intrinsics.f(r7, "$this$commonToByteString");
        Util.checkOffsetAndCount(r7.length, r8, r9);
        return new ByteString(ArraysKt.j(r7, r8, r9 + r8));
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString r8) {
        Intrinsics.f(r8, "$this$commonToString");
        if (r8.getData$okio().length != 0) goto L6;
        return "[size=0]";
    L6:
        int r0 = access$codePointIndexToCharIndex(r8.getData$okio(), 64);
        if (r0 == (-1)) goto L9;
        String r1 = r8.utf8();
        if (r1 == null) goto L29;
        String r2 = r1.substring(0, r0);
        Intrinsics.e(r2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String r3 = StringsKt.B(StringsKt.B(StringsKt.B(r2, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
        if (r0 >= r1.length()) goto L27;
        return "[size=" + r8.getData$okio().length + " text=" + r3 + "…]";
    L27:
        return "[text=" + r3 + ']';
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        if (r8.getData$okio().length <= 64) goto L30;
        StringBuilder r4 = new StringBuilder("[size=");
        r4.append(r8.getData$okio().length);
        r4.append(" hex=");
        if (64 > r8.getData$okio().length) goto L20;
        if (64 == r8.getData$okio().length) goto L17;
        r8 = new ByteString(ArraysKt.j(r8.getData$okio(), 0, 64));
    L17:
        r4.append(r8.hex());
        r4.append("…]");
        return r4.toString();
    L20:
        throw new IllegalArgumentException(a.l(new StringBuilder("endIndex > length("), r8.getData$okio().length, ')').toString());
    L30:
        return "[hex=" + r8.hex() + ']';
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString r1) {
        Intrinsics.f(r1, "$this$commonUtf8");
        String r0 = r1.getUtf8$okio();
        if (r0 != null) goto L6;
        String r2 = Platform.toUtf8String(r1.internalArray$okio());
        r1.setUtf8$okio(r2);
        return r2;
    L6:
        return r0;
    }

    public static final void commonWrite(@NotNull ByteString r1, @NotNull Buffer r2, int r3, int r4) {
        Intrinsics.f(r1, "$this$commonWrite");
        Intrinsics.f(r2, "buffer");
        r2.write(r1.getData$okio(), r3, r4);
    }

    private static final int decodeHexDigit(char r3) {
        if ('0' > r3) goto L9;
        if ('9' < r3) goto L9;
        return r3 - '0';
    L9:
        if ('a' > r3) goto L15;
        if ('f' < r3) goto L15;
        return r3 - 'W';
    L15:
        if ('A' > r3) goto L21;
        if ('F' < r3) goto L21;
        return r3 - '7';
    L21:
        throw new IllegalArgumentException("Unexpected hex digit: " + r3);
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@NotNull ByteString r3, @NotNull byte[] r4) {
        Intrinsics.f(r3, "$this$commonEndsWith");
        Intrinsics.f(r4, "suffix");
        return r3.rangeEquals(r3.size() - r4.length, r4, 0, r4.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString r3, @NotNull byte[] r4, int r5) {
        Intrinsics.f(r3, "$this$commonLastIndexOf");
        Intrinsics.f(r4, "other");
        int r6 = Math.min(r5, r3.getData$okio().length - r4.length);
    L3:
        if (r6 < 0) goto L8;
        if (Util.arrayRangeEquals(r3.getData$okio(), r6, r4, 0, r4.length) == true) goto L6;
        r6 = r6 - 1;
        goto L3
    L6:
        return r6;
    L8:
        return -1;
    }

    public static final boolean commonRangeEquals(@NotNull ByteString r1, int r2, @NotNull byte[] r3, int r4, int r5) {
        Intrinsics.f(r1, "$this$commonRangeEquals");
        Intrinsics.f(r3, "other");
        if (r2 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r2 > (r1.getData$okio().length - r5)) goto L12;
        if (r4 < 0) goto L12;
        if (r4 > (r3.length - r5)) goto L12;
        if (Util.arrayRangeEquals(r1.getData$okio(), r2, r3, r4, r5) == false) goto L12;
        return true;
    }

    public static final boolean commonStartsWith(@NotNull ByteString r2, @NotNull byte[] r3) {
        Intrinsics.f(r2, "$this$commonStartsWith");
        Intrinsics.f(r3, "prefix");
        return r2.rangeEquals(0, r3, 0, r3.length);
    }
}
