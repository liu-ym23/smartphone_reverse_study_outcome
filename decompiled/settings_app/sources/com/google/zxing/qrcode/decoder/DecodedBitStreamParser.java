package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = null;
    private static final int GB2312_SUBSET = 1;

    /* JADX INFO: renamed from: com.google.zxing.qrcode.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode = null;

        static {
            int[] r0 = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = r0;
            r0[Mode.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ALPHANUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.KANJI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.TERMINATOR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.STRUCTURED_APPEND.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ECI.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.HANZI.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    static {
        ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    static DecoderResult decode(byte[] r17, Version r18, ErrorCorrectionLevel r19, Map<DecodeHintType, ?> r20) throws FormatException {
        BitSource r7 = new BitSource(r17);
        StringBuilder r9 = new StringBuilder(50);
        int r11 = 1;
        ArrayList r10 = new ArrayList(1);
        int r13 = -1;
        int r14 = -1;
        ?? r15 = 0;
        CharacterSetECI r16 = null;
    L53:
        if (r7.available() >= 4) goto L7;
        Mode r1 = Mode.TERMINATOR;     // Catch: IllegalArgumentException -> L51
    L6:
        Mode r6 = r1;
        ?? r110 = r15;
        switch(AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[r6.ordinal()]) {
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L24;
            case 8: goto L20;
            case 9: goto L14;
            case 10: goto L11;
            default: goto L26;
        };     // Catch: IllegalArgumentException -> L51
    L11:
        int r2 = r7.readBits(4);     // Catch: IllegalArgumentException -> L51
        int r3 = r7.readBits(r6.getCharacterCountBits(r18));     // Catch: IllegalArgumentException -> L51
        r110 = r15;
        if (r2 != r11) goto L25;
        decodeHanziSegment(r7, r9, r3);     // Catch: IllegalArgumentException -> L51
        r110 = r15;
        goto L25
    L14:
        r16 = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(r7));     // Catch: IllegalArgumentException -> L51
        if (r16 == null) goto L18;
        r110 = r15;
        goto L25
    L18:
        throw FormatException.getFormatInstance();     // Catch: IllegalArgumentException -> L51
    L24:
        r110 = r11;
    L25:
        ?? r111 = r110;
    L40:
        if (r6 == Mode.TERMINATOR) goto L41;
        r11 = 1;
        r15 = r111;
        goto L53
    L41:
        String r4 = r9.toString();
        if (r10.isEmpty() == false) goto L44;
        ArrayList r5 = null;
    L45:
        if (r19 != null) goto L47;
        String r8 = null;
    L49:
        return new DecoderResult(r17, r4, r5, r8, r13, r14);
    L47:
        r8 = r19.toString();
        goto L49
    L44:
        r5 = r10;
        goto L45
    L26:
        int r12 = r7.readBits(r6.getCharacterCountBits(r18));     // Catch: IllegalArgumentException -> L51
        int r21 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[r6.ordinal()];     // Catch: IllegalArgumentException -> L51
        if (r21 != r11) goto L29;
        decodeNumericSegment(r7, r9, r12);     // Catch: IllegalArgumentException -> L51
        r111 = r15;
        goto L40
    L29:
        if (r21 != 2) goto L31;
        decodeAlphanumericSegment(r7, r9, r12, r15);     // Catch: IllegalArgumentException -> L51
        r111 = r15;
        goto L40
    L31:
        if (r21 == 3) goto L36;
        if (r21 != 4) goto L35;
        decodeKanjiSegment(r7, r9, r12);     // Catch: IllegalArgumentException -> L51
        r110 = r15;
        goto L25
    L35:
        throw FormatException.getFormatInstance();     // Catch: IllegalArgumentException -> L51
    L36:
        decodeByteSegment(r7, r9, r12, r16, r10, r20);     // Catch: IllegalArgumentException -> L51
        r111 = r15;
        goto L40
    L20:
        if (r7.available() < 16) goto L23;
        int r22 = r7.readBits(8);     // Catch: IllegalArgumentException -> L51
        r14 = r7.readBits(8);     // Catch: IllegalArgumentException -> L51
        r13 = r22;
        r110 = r15;
        goto L25
    L23:
        throw FormatException.getFormatInstance();     // Catch: IllegalArgumentException -> L51
    L7:
        r1 = Mode.forBits(r7.readBits(4));     // Catch: IllegalArgumentException -> L51
        goto L6
    L52:
        throw FormatException.getFormatInstance();
    }

    private static void decodeHanziSegment(BitSource r4, StringBuilder r5, int r6) throws FormatException {
        if ((r6 * 13) > r4.available()) goto L16;
        byte[] r0 = new byte[r6 * 2];
        int r1 = 0;
    L5:
        if (r6 <= 0) goto L17;
        int r2 = r4.readBits(13);
        int r3 = (r2 % 96) | ((r2 / 96) << 8);
        if (r3 >= 959) goto L9;
        int r7 = 41377;
    L10:
        int r8 = r3 + r7;
        r0[r1] = (byte) (r8 >> 8);
        r0[r1 + 1] = (byte) r8;
        r1 = r1 + 2;
        r6 = r6 - 1;
        goto L5
    L9:
        r7 = 42657;
        goto L10
    L17:
        r5.append(new String(r0, StringUtils.GB2312));     // Catch: UnsupportedEncodingException -> L13
        return;
    L14:
        throw FormatException.getFormatInstance();
    L16:
        throw FormatException.getFormatInstance();
    }

    private static void decodeKanjiSegment(BitSource r4, StringBuilder r5, int r6) throws FormatException {
        if ((r6 * 13) > r4.available()) goto L16;
        byte[] r0 = new byte[r6 * 2];
        int r1 = 0;
    L5:
        if (r6 <= 0) goto L17;
        int r2 = r4.readBits(13);
        int r3 = (r2 % 192) | ((r2 / 192) << 8);
        if (r3 >= 7936) goto L9;
        int r7 = 33088;
    L10:
        int r8 = r3 + r7;
        r0[r1] = (byte) (r8 >> 8);
        r0[r1 + 1] = (byte) r8;
        r1 = r1 + 2;
        r6 = r6 - 1;
        goto L5
    L9:
        r7 = 49472;
        goto L10
    L17:
        r5.append(new String(r0, StringUtils.SHIFT_JIS));     // Catch: UnsupportedEncodingException -> L13
        return;
    L14:
        throw FormatException.getFormatInstance();
    L16:
        throw FormatException.getFormatInstance();
    }

    private static void decodeByteSegment(BitSource r3, StringBuilder r4, int r5, CharacterSetECI r6, Collection<byte[]> r7, Map<DecodeHintType, ?> r8) throws FormatException {
        if ((r5 << 3) > r3.available()) goto L16;
        byte[] r0 = new byte[r5];
        int r1 = 0;
    L5:
        if (r1 >= r5) goto L7;
        r0[r1] = (byte) r3.readBits(8);
        r1 = r1 + 1;
        goto L5
    L7:
        if (r6 != null) goto L9;
        String r9 = StringUtils.guessEncoding(r0, r8);
    L17:
        r4.append(new String(r0, r9));     // Catch: UnsupportedEncodingException -> L13
        r7.add(r0);
        return;
    L14:
        throw FormatException.getFormatInstance();
    L9:
        r9 = r6.name();
        goto L17
    L16:
        throw FormatException.getFormatInstance();
    }

    private static char toAlphaNumericChar(int r2) throws FormatException {
        char[] r0 = ALPHANUMERIC_CHARS;
        if (r2 >= r0.length) goto L7;
        return r0[r2];
    L7:
        throw FormatException.getFormatInstance();
    }

    private static void decodeAlphanumericSegment(BitSource r3, StringBuilder r4, int r5, boolean r6) throws FormatException {
        int r0 = r4.length();
    L4:
        if (r5 <= 1) goto L10;
        if (r3.available() < 11) goto L9;
        int r1 = r3.readBits(11);
        r4.append(toAlphaNumericChar(r1 / 45));
        r4.append(toAlphaNumericChar(r1 % 45));
        r5 = r5 - 2;
        goto L4
    L9:
        throw FormatException.getFormatInstance();
    L10:
        if (r5 == 1) goto L12;
    L16:
        if (r6 == true) goto L18;
        return;
    L18:
        if (r0 >= r4.length()) goto L35;
        if (r4.charAt(r0) != '%') goto L27;
        if (r0 >= (r4.length() - 1)) goto L26;
        int r7 = r0 + 1;
        if (r4.charAt(r7) != '%') goto L26;
        r4.deleteCharAt(r7);
    L26:
        r4.setCharAt(r0, 29);
    L27:
        r0 = r0 + 1;
        goto L18
    L35:
        return;
    L12:
        if (r3.available() < 6) goto L15;
        r4.append(toAlphaNumericChar(r3.readBits(6)));
        goto L16
    L15:
        throw FormatException.getFormatInstance();
    }

    private static void decodeNumericSegment(BitSource r3, StringBuilder r4, int r5) throws FormatException {
    L3:
        if (r5 < 3) goto L14;
        if (r3.available() < 10) goto L12;
        int r0 = r3.readBits(10);
        if (r0 >= 1000) goto L10;
        r4.append(toAlphaNumericChar(r0 / 100));
        r4.append(toAlphaNumericChar((r0 / 10) % 10));
        r4.append(toAlphaNumericChar(r0 % 10));
        r5 = r5 - 3;
        goto L3
    L10:
        throw FormatException.getFormatInstance();
    L12:
        throw FormatException.getFormatInstance();
    L14:
        if (r5 != 2) goto L26;
        if (r3.available() < 7) goto L24;
        int r6 = r3.readBits(7);
        if (r6 >= 100) goto L22;
        r4.append(toAlphaNumericChar(r6 / 10));
        r4.append(toAlphaNumericChar(r6 % 10));
        return;
    L22:
        throw FormatException.getFormatInstance();
    L24:
        throw FormatException.getFormatInstance();
    L26:
        if (r5 == 1) goto L28;
        return;
    L28:
        if (r3.available() < 4) goto L35;
        int r7 = r3.readBits(4);
        if (r7 >= 10) goto L33;
        r4.append(toAlphaNumericChar(r7));
        return;
    L33:
        throw FormatException.getFormatInstance();
    L35:
        throw FormatException.getFormatInstance();
    }

    private static int parseECIValue(BitSource r4) throws FormatException {
        int r1 = r4.readBits(8);
        if ((r1 & 128) != 0) goto L7;
        return r1 & 127;
    L7:
        if ((r1 & 192) != 128) goto L11;
        return r4.readBits(8) | ((r1 & 63) << 8);
    L11:
        if ((r1 & 224) != 192) goto L15;
        return r4.readBits(16) | ((r1 & 31) << 16);
    L15:
        throw FormatException.getFormatInstance();
    }
}
