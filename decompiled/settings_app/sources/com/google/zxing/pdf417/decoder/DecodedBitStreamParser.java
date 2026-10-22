package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900 = null;
    private static final int LL = 27;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = null;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = null;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    /* JADX INFO: renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = null;

        static {
            int[] r0 = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = r0;
            r0[Mode.ALPHA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    private static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode ALPHA = null;
        public static final Mode ALPHA_SHIFT = null;
        public static final Mode LOWER = null;
        public static final Mode MIXED = null;
        public static final Mode PUNCT = null;
        public static final Mode PUNCT_SHIFT = null;

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
            Mode r0 = new Mode("ALPHA", 0);
            ALPHA = r0;
            Mode r1 = new Mode("LOWER", 1);
            LOWER = r1;
            Mode r3 = new Mode("MIXED", 2);
            MIXED = r3;
            Mode r5 = new Mode("PUNCT", 3);
            PUNCT = r5;
            Mode r7 = new Mode("ALPHA_SHIFT", 4);
            ALPHA_SHIFT = r7;
            Mode r9 = new Mode("PUNCT_SHIFT", 5);
            PUNCT_SHIFT = r9;
            $VALUES = new Mode[]{r0, r1, r3, r5, r7, r9};
        }
    }

    static {
        PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
        MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
        BigInteger[] r0 = new BigInteger[16];
        EXP900 = r0;
        r0[0] = BigInteger.ONE;
        BigInteger r1 = BigInteger.valueOf(900);
        r0[1] = r1;
        int r2 = 2;
    L3:
        BigInteger[] r3 = EXP900;
        if (r2 >= r3.length) goto L6;
        r3[r2] = r3[r2 - 1].multiply(r1);
        r2 = r2 + 1;
        goto L3
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] r6, String r7) throws FormatException {
        StringBuilder r0 = new StringBuilder(r6.length << 1);
        Charset r1 = StandardCharsets.ISO_8859_1;
        int r2 = r6[1];
        PDF417ResultMetadata r3 = new PDF417ResultMetadata();
        int r4 = 2;
    L4:
        if (r4 >= r6[0]) goto L26;
        if (r2 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L19;
        switch(r2) {
            case 900: goto L18;
            case 901: goto L17;
            case 902: goto L16;
            default: goto L8;
        };
    L8:
        switch(r2) {
            case 922: goto L15;
            case 923: goto L15;
            case 924: goto L17;
            case 925: goto L13;
            case 926: goto L12;
            case 927: goto L11;
            case 928: goto L10;
            default: goto L9;
        };
    L9:
        int r5 = textCompaction(r6, r4 - 1, r0);
    L21:
        if (r5 >= r6.length) goto L24;
        r4 = r5 + 1;
        r2 = r6[r5];
        goto L4
    L24:
        throw FormatException.getFormatInstance();
    L10:
        r5 = decodeMacroBlock(r6, r4, r3);
        goto L21
    L11:
        r5 = r4 + 1;
        r1 = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(r6[r4]).name());
        goto L21
    L12:
        r5 = r4 + 2;
        goto L21
    L13:
        r5 = r4 + 1;
        goto L21
    L15:
        throw FormatException.getFormatInstance();
    L16:
        r5 = numericCompaction(r6, r4, r0);
    L17:
        r5 = byteCompaction(r2, r6, r1, r4, r0);
        goto L21
    L18:
        r5 = textCompaction(r6, r4, r0);
        goto L21
    L19:
        r5 = r4 + 1;
        r0.append((char) r6[r4]);
        goto L21
    L26:
        if (r0.length() == 0) goto L30;
        DecoderResult r8 = new DecoderResult(null, r0.toString(), null, r7);
        r8.setOther(r3);
        return r8;
    L30:
        throw FormatException.getFormatInstance();
    }

    static int decodeMacroBlock(int[] r6, int r7, PDF417ResultMetadata r8) throws FormatException {
        if ((r7 + 2) > r6[0]) goto L37;
        int[] r2 = new int[2];
        int r3 = 0;
    L5:
        if (r3 >= 2) goto L7;
        r2[r3] = r6[r7];
        r3 = r3 + 1;
        r7 = r7 + 1;
        goto L5
    L7:
        r8.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(r2, 2)));
        StringBuilder r0 = new StringBuilder();
        int r9 = textCompaction(r6, r7, r0);
        r8.setFileId(r0.toString());
        if (r6[r9] != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) goto L10;
        int r1 = r9 + 1;
    L12:
        if (r9 >= r6[0]) goto L30;
        int r4 = r6[r9];
        if (r4 != MACRO_PDF417_TERMINATOR) goto L15;
        r9 = r9 + 1;
        r8.setLastSegment(true);
        goto L12
    L15:
        if (r4 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) goto L28;
        int r10 = r9 + 1;
        switch(r6[r10]) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            default: goto L19;
        };
    L19:
        throw FormatException.getFormatInstance();
    L21:
        StringBuilder r5 = new StringBuilder();
        r9 = numericCompaction(r6, r10 + 1, r5);
        r8.setFileSize(Long.parseLong(r5.toString()));
        goto L12
    L22:
        StringBuilder r11 = new StringBuilder();
        r9 = textCompaction(r6, r10 + 1, r11);
        r8.setAddressee(r11.toString());
        goto L12
    L23:
        StringBuilder r12 = new StringBuilder();
        r9 = textCompaction(r6, r10 + 1, r12);
        r8.setSender(r12.toString());
        goto L12
    L24:
        StringBuilder r13 = new StringBuilder();
        r9 = numericCompaction(r6, r10 + 1, r13);
        r8.setTimestamp(Long.parseLong(r13.toString()));
        goto L12
    L25:
        StringBuilder r14 = new StringBuilder();
        r9 = numericCompaction(r6, r10 + 1, r14);
        r8.setSegmentCount(Integer.parseInt(r14.toString()));
        goto L12
    L26:
        StringBuilder r15 = new StringBuilder();
        r9 = textCompaction(r6, r10 + 1, r15);
        r8.setFileName(r15.toString());
        goto L12
    L20:
        StringBuilder r16 = new StringBuilder();
        r9 = numericCompaction(r6, r10 + 1, r16);
        r8.setChecksum(Integer.parseInt(r16.toString()));
        goto L12
    L28:
        throw FormatException.getFormatInstance();
    L30:
        if (r1 == (-1)) goto L35;
        int r17 = r9 - r1;
        if (r8.isLastSegment() == false) goto L34;
        r17 = r17 - 1;
    L34:
        r8.setOptionalData(Arrays.copyOfRange(r6, r1, r17 + r1));
    L35:
        return r9;
    L10:
        r1 = -1;
        goto L12
    L37:
        throw FormatException.getFormatInstance();
    }

    private static int textCompaction(int[] r9, int r10, StringBuilder r11) {
        int r1 = r9[0];
        int[] r2 = new int[(r1 - r10) << 1];
        int[] r3 = new int[(r1 - r10) << 1];
        boolean r4 = false;
        int r5 = 0;
    L4:
        if (r10 >= r9[0]) goto L20;
        if (r4 == true) goto L20;
        int r6 = r10 + 1;
        int r12 = r9[r10];
        if (r12 < 900) goto L8;
        if (r12 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L13;
        r2[r5] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
        r10 = r6 + 1;
        r3[r5] = r9[r6];
        r5 = r5 + 1;
        goto L4
    L13:
        if (r12 == 928) goto L18;
        switch(r12) {
            case 900: goto L17;
            case 901: goto L18;
            case 902: goto L18;
            default: goto L15;
        };
    L15:
        switch(r12) {
            case 922: goto L18;
            case 923: goto L18;
            case 924: goto L18;
            default: goto L9;
        };
    L9:
        r10 = r6;
        goto L4
    L17:
        r2[r5] = 900;
        r5 = r5 + 1;
    L18:
        r10 = r6 - 1;
        r4 = true;
        goto L4
    L8:
        r2[r5] = r12 / 30;
        r2[r5 + 1] = r12 % 30;
        r5 = r5 + 2;
    L20:
        decodeTextCompaction(r2, r3, r5, r11);
        return r10;
    }

    private static void decodeTextCompaction(int[] r12, int[] r13, int r14, StringBuilder r15) {
        Mode r0 = Mode.ALPHA;
        Mode r1 = Mode.ALPHA;
        int r3 = 0;
    L3:
        if (r3 >= r14) goto L74;
        int r4 = r12[r3];
        int r5 = AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[r0.ordinal()];
        char r6 = TokenParser.SP;
        switch(r5) {
            case 1: goto L57;
            case 2: goto L46;
            case 3: goto L34;
            case 4: goto L24;
            case 5: goto L17;
            case 6: goto L7;
            default: goto L70;
        };
    L7:
        if (r4 >= 29) goto L9;
        r6 = PUNCT_CHARS[r4];
    L19:
        r0 = r1;
    L71:
        if (r6 == 0) goto L73;
        r15.append(r6);
    L73:
        r3 = r3 + 1;
        goto L3
    L9:
        if (r4 == 29) goto L16;
        if (r4 == 900) goto L15;
        if (r4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L14;
        r15.append((char) r13[r3]);
    L14:
        r0 = r1;
        goto L70
    L15:
        r0 = Mode.ALPHA;
        goto L70
    L16:
        r0 = Mode.ALPHA;
        goto L70
    L17:
        if (r4 >= 26) goto L20;
        r6 = (char) (r4 + 65);
        goto L19
    L20:
        if (r4 == 26) goto L19;
        if (r4 != 900) goto L14;
        r0 = Mode.ALPHA;
        goto L70
    L24:
        if (r4 >= 29) goto L26;
        r6 = PUNCT_CHARS[r4];
        goto L71
    L26:
        if (r4 == 29) goto L32;
        if (r4 == 900) goto L31;
        if (r4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L70;
        r15.append((char) r13[r3]);
        goto L70
    L31:
        r0 = Mode.ALPHA;
        goto L70
    L32:
        r0 = Mode.ALPHA;
        goto L70
    L46:
        if (r4 >= 26) goto L48;
        int r7 = r4 + 97;
    L59:
        r6 = (char) r7;
        goto L71
    L48:
        if (r4 == 900) goto L56;
        if (r4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L55;
        switch(r4) {
            case 26: goto L71;
            case 27: goto L54;
            case 28: goto L53;
            case 29: goto L52;
            default: goto L70;
        };
    L52:
        Mode r2 = Mode.PUNCT_SHIFT;
    L65:
        r6 = 0;
        Mode r11 = r2;
        r1 = r0;
        r0 = r11;
        goto L71
    L53:
        r0 = Mode.MIXED;
        goto L70
    L54:
        r2 = Mode.ALPHA_SHIFT;
        goto L65
    L55:
        r15.append((char) r13[r3]);
        goto L70
    L56:
        r0 = Mode.ALPHA;
        goto L70
    L57:
        if (r4 >= 26) goto L60;
        r7 = r4 + 65;
        goto L59
    L60:
        if (r4 == 900) goto L69;
        if (r4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L68;
        switch(r4) {
            case 26: goto L71;
            case 27: goto L67;
            case 28: goto L66;
            case 29: goto L64;
            default: goto L70;
        };
    L64:
        r2 = Mode.PUNCT_SHIFT;
        goto L65
    L66:
        r0 = Mode.MIXED;
        goto L70
    L67:
        r0 = Mode.LOWER;
        goto L70
    L68:
        r15.append((char) r13[r3]);
        goto L70
    L69:
        r0 = Mode.ALPHA;
    L70:
        r6 = 0;
        goto L71
    L34:
        if (r4 >= 25) goto L36;
        r6 = MIXED_CHARS[r4];
        goto L71
    L36:
        if (r4 == 900) goto L45;
        if (r4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L44;
        switch(r4) {
            case 25: goto L43;
            case 26: goto L71;
            case 27: goto L42;
            case 28: goto L41;
            case 29: goto L40;
            default: goto L70;
        };
    L40:
        r2 = Mode.PUNCT_SHIFT;
        goto L65
    L41:
        r0 = Mode.ALPHA;
        goto L70
    L42:
        r0 = Mode.LOWER;
        goto L70
    L43:
        r0 = Mode.PUNCT;
        goto L70
    L44:
        r15.append((char) r13[r3]);
        goto L70
    L45:
        r0 = Mode.ALPHA;
        goto L70
    }

    private static int byteCompaction(int r16, int[] r17, Charset r18, int r19, StringBuilder r20) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        long r3 = 900;
        int r7 = 6;
        int r9 = 0;
        if (r16 != 901) goto L5;
        int[] r0 = new int[6];
        int r2 = r19 + 1;
        int r10 = r17[r19];
        boolean r11 = false;
        int r12 = 0;
    L28:
        long r13 = 0;
    L29:
        int r15 = r17[0];
        if (r2 >= r15) goto L45;
        if (r11 == true) goto L45;
        r12 = r12 + 1;
        r0[r12] = r10;
        r13 = (r13 * r3) + ((long) r10);
        int r4 = r2 + 1;
        r10 = r17[r2];
        if (r10 == 928) goto L44;
        switch(r10) {
            case 900: goto L44;
            case 901: goto L44;
            case 902: goto L44;
            default: goto L35;
        };
    L35:
        switch(r10) {
            case 922: goto L44;
            case 923: goto L44;
            case 924: goto L44;
            default: goto L37;
        };
    L37:
        if ((r12 % 5) != 0) goto L43;
        if (r12 <= 0) goto L43;
        int r5 = 0;
    L40:
        if (r5 >= r7) goto L42;
        r1.write((byte) (r13 >> ((5 - r5) * 8)));
        r5 = r5 + 1;
        r7 = 6;
        goto L40
    L42:
        r2 = r4;
        r12 = 0;
        r3 = 900;
    L43:
        r2 = r4;
        r3 = 900;
        r7 = 6;
    L44:
        r2 = r4 - 1;
        r3 = 900;
        r7 = 6;
        r11 = true;
    L45:
        if (r2 != r15) goto L48;
        if (r10 >= 900) goto L48;
        r0[r12] = r10;
        r12 = r12 + 1;
    L48:
        if (r9 >= r12) goto L50;
        r1.write((byte) r0[r9]);
        r9 = r9 + 1;
        goto L48
    L50:
        int r6 = r2;
    L51:
        r20.append(new String(r1.toByteArray(), r18));
        return r6;
    L5:
        if (r16 == BYTE_COMPACTION_MODE_LATCH_6) goto L7;
        r6 = r19;
        goto L51
    L7:
        r6 = r19;
        boolean r8 = false;
        int r14 = 0;
    L8:
        long r110 = 0;
    L10:
        if (r6 >= r17[0]) goto L51;
        if (r8 == true) goto L51;
        int r111 = r6 + 1;
        int r21 = r17[r6];
        if (r21 >= 900) goto L15;
        r14 = r14 + 1;
        r110 = (r110 * 900) + ((long) r21);
    L18:
        r6 = r111;
    L21:
        if ((r14 % 5) != 0) goto L10;
        if (r14 <= 0) goto L10;
        int r112 = 0;
    L24:
        if (r112 >= 6) goto L26;
        r1.write((byte) (r110 >> ((5 - r112) * 8)));
        r112 = r112 + 1;
        goto L24
    L26:
        r14 = 0;
        goto L8
    L15:
        if (r21 == 928) goto L19;
        switch(r21) {
            case 900: goto L19;
            case 901: goto L19;
            case 902: goto L19;
            default: goto L17;
        };
    L17:
        switch(r21) {
            case 922: goto L19;
            case 923: goto L19;
            case 924: goto L19;
            default: goto L18;
        };
    L19:
        r6 = r111 - 1;
        r8 = true;
        goto L21
    }

    private static int numericCompaction(int[] r7, int r8, StringBuilder r9) throws FormatException {
        int[] r0 = new int[15];
        boolean r2 = false;
        int r3 = 0;
    L3:
        int r4 = r7[0];
        if (r8 >= r4) goto L28;
        if (r2 == true) goto L28;
        int r5 = r8 + 1;
        int r10 = r7[r8];
        if (r5 != r4) goto L10;
        r2 = true;
    L10:
        if (r10 >= 900) goto L12;
        r0[r3] = r10;
        r3 = r3 + 1;
    L21:
        if ((r3 % 15) != 0) goto L23;
    L25:
        if (r3 <= 0) goto L27;
        r9.append(decodeBase900toBase10(r0, r3));
        r3 = 0;
    L27:
        r8 = r5;
        goto L3
    L23:
        if (r10 == 902) goto L25;
        if (r2 == false) goto L27;
    L12:
        if (r10 != 900) goto L14;
    L19:
        r5 = r5 - 1;
        r2 = true;
        goto L21
    L14:
        if (r10 == 901) goto L19;
        if (r10 == 928) goto L19;
        switch(r10) {
            case 922: goto L19;
            case 923: goto L19;
            case 924: goto L19;
            default: goto L21;
        };
    L28:
        return r8;
    }

    private static String decodeBase900toBase10(int[] r6, int r7) throws FormatException {
        BigInteger r0 = BigInteger.ZERO;
        int r2 = 0;
    L4:
        if (r2 >= r7) goto L6;
        r0 = r0.add(EXP900[(r7 - r2) - 1].multiply(BigInteger.valueOf(r6[r2])));
        r2 = r2 + 1;
        goto L4
    L6:
        String r8 = r0.toString();
        if (r8.charAt(0) != '1') goto L11;
        return r8.substring(1);
    L11:
        throw FormatException.getFormatInstance();
    }
}
