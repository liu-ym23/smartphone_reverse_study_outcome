package com.google.zxing.datamatrix.decoder;

import android.icu.util.ULocale;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.google.common.base.Ascii;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import com.ttnet.org.chromium.net.NetError;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = null;
    private static final char[] C40_SHIFT2_SET_CHARS = null;
    private static final char[] TEXT_BASIC_SET_CHARS = null;
    private static final char[] TEXT_SHIFT2_SET_CHARS = null;
    private static final char[] TEXT_SHIFT3_SET_CHARS = null;

    /* JADX INFO: renamed from: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode = null;

        static {
            int[] r0 = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode = r0;
            r0[Mode.C40_ENCODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.TEXT_ENCODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.ANSIX12_ENCODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.EDIFACT_ENCODE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.BASE256_ENCODE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode ANSIX12_ENCODE = null;
        public static final Mode ASCII_ENCODE = null;
        public static final Mode BASE256_ENCODE = null;
        public static final Mode C40_ENCODE = null;
        public static final Mode EDIFACT_ENCODE = null;
        public static final Mode PAD_ENCODE = null;
        public static final Mode TEXT_ENCODE = null;

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            Mode r0 = new Mode("PAD_ENCODE", 0);
            PAD_ENCODE = r0;
            Mode r1 = new Mode("ASCII_ENCODE", 1);
            ASCII_ENCODE = r1;
            Mode r3 = new Mode("C40_ENCODE", 2);
            C40_ENCODE = r3;
            Mode r5 = new Mode("TEXT_ENCODE", 3);
            TEXT_ENCODE = r5;
            Mode r7 = new Mode("ANSIX12_ENCODE", 4);
            ANSIX12_ENCODE = r7;
            Mode r9 = new Mode("EDIFACT_ENCODE", 5);
            EDIFACT_ENCODE = r9;
            Mode r11 = new Mode("BASE256_ENCODE", 6);
            BASE256_ENCODE = r11;
            $VALUES = new Mode[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    static {
        C40_BASIC_SET_CHARS = new char[]{'*', '*', '*', TokenParser.SP, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] r1 = {'!', '\"', '#', '$', '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', '.', IOUtils.DIR_SEPARATOR_UNIX, AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR, ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        C40_SHIFT2_SET_CHARS = r1;
        TEXT_BASIC_SET_CHARS = new char[]{'*', '*', '*', TokenParser.SP, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', ULocale.UNICODE_LOCALE_EXTENSION, 'v', 'w', ULocale.PRIVATE_USE_EXTENSION, 'y', 'z'};
        TEXT_SHIFT2_SET_CHARS = r1;
        TEXT_SHIFT3_SET_CHARS = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', Ascii.MAX};
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] r7) throws FormatException {
        BitSource r0 = new BitSource(r7);
        StringBuilder r1 = new StringBuilder(100);
        StringBuilder r2 = new StringBuilder(0);
        ArrayList r3 = new ArrayList(1);
        Mode r5 = Mode.ASCII_ENCODE;
    L4:
        if (r5 != Mode.ASCII_ENCODE) goto L6;
        r5 = decodeAsciiSegment(r0, r1, r2);
    L25:
        if (r5 == Mode.PAD_ENCODE) goto L29;
        if (r0.available() > 0) goto L4;
    L29:
        if (r2.length() <= 0) goto L31;
        r1.append(r2);
    L31:
        String r4 = r1.toString();
        if (r3.isEmpty() == false) goto L35;
        r3 = null;
    L35:
        return new DecoderResult(r7, r4, r3, null);
    L6:
        int r6 = AnonymousClass1.$SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[r5.ordinal()];
        if (r6 != 1) goto L9;
        decodeC40Segment(r0, r1);
    L23:
        r5 = Mode.ASCII_ENCODE;
        goto L25
    L9:
        if (r6 != 2) goto L11;
        decodeTextSegment(r0, r1);
        goto L23
    L11:
        if (r6 != 3) goto L13;
        decodeAnsiX12Segment(r0, r1);
        goto L23
    L13:
        if (r6 != 4) goto L15;
        decodeEdifactSegment(r0, r1);
        goto L23
    L15:
        if (r6 != 5) goto L18;
        decodeBase256Segment(r0, r1, r3);
        goto L23
    L18:
        throw FormatException.getFormatInstance();
    }

    private static Mode decodeAsciiSegment(BitSource r5, StringBuilder r6, StringBuilder r7) throws FormatException {
        boolean r1 = false;
    L3:
        int r2 = r5.readBits(8);
        if (r2 == 0) goto L49;
        if (r2 <= 128) goto L7;
        if (r2 == 129) goto L14;
        if (r2 > 229) goto L22;
        int r3 = r2 + NetError.ERR_PROXY_CONNECTION_FAILED;
        if (r3 >= 10) goto L20;
        r6.append('0');
    L20:
        r6.append(r3);
    L43:
        if (r5.available() > 0) goto L3;
        return Mode.ASCII_ENCODE;
    L22:
        switch(r2) {
            case 230: goto L41;
            case 231: goto L39;
            case 232: goto L37;
            case 233: goto L43;
            case 234: goto L43;
            case 235: goto L36;
            case 236: goto L35;
            case 237: goto L34;
            case 238: goto L33;
            case 239: goto L31;
            case 240: goto L29;
            case 241: goto L43;
            default: goto L24;
        };
    L34:
        r6.append("[)>\u001e06\u001d");
        r7.insert(0, "\u001e\u0004");
        goto L43
    L35:
        r6.append("[)>\u001e05\u001d");
        r7.insert(0, "\u001e\u0004");
        goto L43
    L36:
        r1 = true;
        goto L43
    L37:
        r6.append(29);
        goto L43
    L24:
        if (r2 != 254) goto L47;
        if (r5.available() == 0) goto L43;
    L47:
        throw FormatException.getFormatInstance();
    L29:
        return Mode.EDIFACT_ENCODE;
    L31:
        return Mode.TEXT_ENCODE;
    L33:
        return Mode.ANSIX12_ENCODE;
    L39:
        return Mode.BASE256_ENCODE;
    L41:
        return Mode.C40_ENCODE;
    L14:
        return Mode.PAD_ENCODE;
    L7:
        if (r1 == false) goto L9;
        r2 = r2 + 128;
    L9:
        r6.append((char) (r2 - 1));
        return Mode.ASCII_ENCODE;
    L49:
        throw FormatException.getFormatInstance();
    }

    private static void decodeC40Segment(BitSource r9, StringBuilder r10) throws FormatException {
        int[] r1 = new int[3];
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r9.available() == 8) goto L5;
        int r5 = r9.readBits(8);
        if (r5 == 254) goto L8;
        parseTwoBytes(r5, r9.readBits(8), r1);
        int r6 = 0;
    L10:
        if (r6 >= 3) goto L54;
        int r7 = r1[r6];
        if (r4 != 0) goto L14;
        if (r7 >= 3) goto L44;
        r4 = r7 + 1;
    L50:
        r6 = r6 + 1;
        goto L10
    L44:
        char[] r8 = C40_BASIC_SET_CHARS;
        if (r7 >= r8.length) goto L52;
        char r11 = r8[r7];
        if (r3 == false) goto L49;
        r10.append((char) (r11 + 128));
        r3 = false;
        goto L50
    L49:
        r10.append(r11);
        goto L50
    L52:
        throw FormatException.getFormatInstance();
    L14:
        if (r4 != 1) goto L16;
        if (r3 == false) goto L40;
        r10.append((char) (r7 + 128));
    L39:
        r3 = false;
    L41:
        r4 = 0;
        goto L50
    L40:
        r10.append((char) r7);
        goto L41
    L16:
        if (r4 == 2) goto L23;
        if (r4 != 3) goto L22;
        if (r3 == false) goto L20;
        r10.append((char) (r7 + 224));
        goto L39
    L20:
        r10.append((char) (r7 + 96));
        goto L41
    L22:
        throw FormatException.getFormatInstance();
    L23:
        char[] r12 = C40_SHIFT2_SET_CHARS;
        if (r7 >= r12.length) goto L30;
        char r13 = r12[r7];
        if (r3 == false) goto L28;
        r10.append((char) (r13 + 128));
        goto L39
    L28:
        r10.append(r13);
        goto L41
    L30:
        if (r7 != 27) goto L32;
        r10.append(29);
        goto L41
    L32:
        if (r7 != 30) goto L35;
        r3 = true;
        goto L41
    L35:
        throw FormatException.getFormatInstance();
    L54:
        if (r9.available() > 0) goto L4;
        return;
    L8:
        return;
    }

    private static void decodeTextSegment(BitSource r9, StringBuilder r10) throws FormatException {
        int[] r1 = new int[3];
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r9.available() == 8) goto L5;
        int r5 = r9.readBits(8);
        if (r5 == 254) goto L8;
        parseTwoBytes(r5, r9.readBits(8), r1);
        int r6 = 0;
    L10:
        if (r6 >= 3) goto L59;
        int r7 = r1[r6];
        if (r4 != 0) goto L14;
        if (r7 >= 3) goto L49;
        r4 = r7 + 1;
    L55:
        r6 = r6 + 1;
        goto L10
    L49:
        char[] r8 = TEXT_BASIC_SET_CHARS;
        if (r7 >= r8.length) goto L57;
        char r11 = r8[r7];
        if (r3 == false) goto L54;
        r10.append((char) (r11 + 128));
        r3 = false;
        goto L55
    L54:
        r10.append(r11);
        goto L55
    L57:
        throw FormatException.getFormatInstance();
    L14:
        if (r4 != 1) goto L16;
        if (r3 == false) goto L45;
        r10.append((char) (r7 + 128));
    L44:
        r3 = false;
    L46:
        r4 = 0;
        goto L55
    L45:
        r10.append((char) r7);
        goto L46
    L16:
        if (r4 == 2) goto L28;
        if (r4 != 3) goto L27;
        char[] r12 = TEXT_SHIFT3_SET_CHARS;
        if (r7 >= r12.length) goto L25;
        char r13 = r12[r7];
        if (r3 == false) goto L23;
        r10.append((char) (r13 + 128));
        goto L44
    L23:
        r10.append(r13);
        goto L46
    L25:
        throw FormatException.getFormatInstance();
    L27:
        throw FormatException.getFormatInstance();
    L28:
        char[] r14 = TEXT_SHIFT2_SET_CHARS;
        if (r7 >= r14.length) goto L35;
        char r15 = r14[r7];
        if (r3 == false) goto L33;
        r10.append((char) (r15 + 128));
        goto L44
    L33:
        r10.append(r15);
        goto L46
    L35:
        if (r7 != 27) goto L37;
        r10.append(29);
        goto L46
    L37:
        if (r7 != 30) goto L40;
        r3 = true;
        goto L46
    L40:
        throw FormatException.getFormatInstance();
    L59:
        if (r9.available() > 0) goto L4;
        return;
    L8:
        return;
    }

    private static void decodeAnsiX12Segment(BitSource r5, StringBuilder r6) throws FormatException {
        int[] r1 = new int[3];
    L4:
        if (r5.available() == 8) goto L5;
        int r2 = r5.readBits(8);
        if (r2 == 254) goto L8;
        parseTwoBytes(r2, r5.readBits(8), r1);
        int r3 = 0;
    L10:
        if (r3 >= 3) goto L32;
        int r4 = r1[r3];
        if (r4 != 0) goto L14;
        r6.append(TokenParser.CR);
    L30:
        r3 = r3 + 1;
        goto L10
    L14:
        if (r4 != 1) goto L16;
        r6.append('*');
        goto L30
    L16:
        if (r4 == 2) goto L27;
        if (r4 != 3) goto L19;
        r6.append(TokenParser.SP);
        goto L30
    L19:
        if (r4 >= 14) goto L22;
        r6.append((char) (r4 + 44));
        goto L30
    L22:
        if (r4 >= 40) goto L25;
        r6.append((char) (r4 + 51));
        goto L30
    L25:
        throw FormatException.getFormatInstance();
    L27:
        r6.append('>');
        goto L30
    L32:
        if (r5.available() > 0) goto L4;
        return;
    L8:
        return;
    }

    private static void parseTwoBytes(int r2, int r3, int[] r4) {
        int r5 = ((r2 << 8) + r3) - 1;
        int r0 = r5 / 1600;
        r4[0] = r0;
        int r6 = r5 - (r0 * 1600);
        int r1 = r6 / 40;
        r4[1] = r1;
        r4[2] = r6 - (r1 * 40);
    }

    private static void decodeEdifactSegment(BitSource r3, StringBuilder r4) {
    L3:
        if (r3.available() <= 16) goto L4;
        int r0 = 0;
    L7:
        if (r0 >= 4) goto L19;
        int r1 = r3.readBits(6);
        if (r1 == 31) goto L10;
        if ((r1 & 32) != 0) goto L17;
        r1 = r1 | 64;
    L17:
        r4.append((char) r1);
        r0 = r0 + 1;
        goto L7
    L10:
        int r5 = 8 - r3.getBitOffset();
        if (r5 == 8) goto L28;
        r3.readBits(r5);
        return;
    L28:
        return;
    L19:
        if (r3.available() > 0) goto L3;
        return;
    }

    private static void decodeBase256Segment(BitSource r7, StringBuilder r8, Collection<byte[]> r9) throws FormatException {
        int r0 = r7.getByteOffset() + 1;
        int r3 = r0 + 1;
        int r1 = unrandomize255State(r7.readBits(8), r0);
        if (r1 != 0) goto L6;
        r1 = r7.available() / 8;
    L9:
        if (r1 < 0) goto L24;
        byte[] r2 = new byte[r1];
        int r4 = 0;
    L11:
        if (r4 >= r1) goto L17;
        if (r7.available() < 8) goto L16;
        r2[r4] = (byte) unrandomize255State(r7.readBits(8), r3);
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L11
    L16:
        throw FormatException.getFormatInstance();
    L17:
        r9.add(r2);
        r8.append(new String(r2, "ISO8859_1"));     // Catch: UnsupportedEncodingException -> L20
        return;
    L20:
        e = move-exception;
        throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e)));
    L24:
        throw FormatException.getFormatInstance();
    L6:
        if (r1 < 250) goto L9;
        r1 = ((r1 - 249) * 250) + unrandomize255State(r7.readBits(8), r3);
        r3 = r3 + 1;
        goto L9
    }

    private static int unrandomize255State(int r0, int r1) {
        int r2 = r0 - (((r1 * 149) % 255) + 1);
        if (r2 < 0) goto L6;
        return r2;
    L6:
        return r2 + 256;
    }
}
