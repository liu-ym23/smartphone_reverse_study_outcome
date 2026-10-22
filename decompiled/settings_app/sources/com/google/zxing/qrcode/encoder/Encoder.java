package com.google.zxing.qrcode.encoder;

import android.icu.lang.UCharacter;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = null;
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    /* JADX INFO: renamed from: com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode = null;

        static {
            int[] r0 = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = r0;
            r0[Mode.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ALPHANUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.KANJI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        ALPHANUMERIC_TABLE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    }

    private Encoder() {
    }

    private static int calculateMaskPenalty(ByteMatrix r2) {
        return ((MaskUtil.applyMaskPenaltyRule1(r2) + MaskUtil.applyMaskPenaltyRule2(r2)) + MaskUtil.applyMaskPenaltyRule3(r2)) + MaskUtil.applyMaskPenaltyRule4(r2);
    }

    public static QRCode encode(String r1, ErrorCorrectionLevel r2) throws WriterException {
        return encode(r1, r2, null);
    }

    public static QRCode encode(String r7, ErrorCorrectionLevel r8, Map<EncodeHintType, ?> r9) throws WriterException {
        boolean r0 = true;
        if (r9 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        String r3 = r9.get(EncodeHintType.CHARACTER_SET).toString();
    L11:
        Mode r4 = chooseMode(r7, r3);
        BitArray r5 = new BitArray();
        if (r4 != Mode.BYTE) goto L17;
        if (r2 == false) goto L17;
        CharacterSetECI r6 = CharacterSetECI.getCharacterSetECIByName(r3);
        if (r6 == null) goto L17;
        appendECI(r6, r5);
    L17:
        if (r9 != null) goto L19;
    L21:
        r0 = false;
    L22:
        if (r0 == true) goto L24;
    L26:
        appendModeInfo(r4, r5);
        BitArray r1 = new BitArray();
        appendBytes(r7, r4, r1, r3);
        if (r9 != null) goto L29;
    L35:
        Version r10 = recommendVersion(r8, r4, r5, r1);
    L36:
        BitArray r11 = new BitArray();
        r11.appendBitArray(r5);
        if (r4 != Mode.BYTE) goto L39;
        int r12 = r1.getSizeInBytes();
    L40:
        appendLengthInfo(r12, r10, r4, r11);
        r11.appendBitArray(r1);
        Version.ECBlocks r13 = r10.getECBlocksForLevel(r8);
        int r14 = r10.getTotalCodewords() - r13.getTotalECCodewords();
        terminateBits(r14, r11);
        BitArray r15 = interleaveWithECBytes(r11, r10.getTotalCodewords(), r14, r13.getNumBlocks());
        QRCode r16 = new QRCode();
        r16.setECLevel(r8);
        r16.setMode(r4);
        r16.setVersion(r10);
        int r17 = r10.getDimensionForVersion();
        ByteMatrix r18 = new ByteMatrix(r17, r17);
        int r19 = chooseMaskPattern(r15, r8, r10, r18);
        r16.setMaskPattern(r19);
        MatrixUtil.buildMatrix(r15, r8, r10, r19, r18);
        r16.setMatrix(r18);
        return r16;
    L39:
        r12 = r7.length();
        goto L40
    L29:
        if (r9.containsKey(EncodeHintType.QR_VERSION) == false) goto L35;
        r10 = Version.getVersionForNumber(Integer.parseInt(r9.get(EncodeHintType.QR_VERSION).toString()));
        if (willFit(calculateBitsNeeded(r4, r5, r1, r10), r10, r8) == true) goto L36;
        throw new WriterException("Data too big for requested version");
    L24:
        if (Boolean.valueOf(r9.get(EncodeHintType.GS1_FORMAT).toString()).booleanValue() == false) goto L26;
        appendModeInfo(Mode.FNC1_FIRST_POSITION, r5);
        goto L26
    L19:
        if (r9.containsKey(EncodeHintType.GS1_FORMAT) == false) goto L21;
    L10:
        r3 = "ISO-8859-1";
        goto L11
    L5:
        if (r9.containsKey(EncodeHintType.CHARACTER_SET) == false) goto L7;
        r2 = true;
        goto L8
    }

    private static Version recommendVersion(ErrorCorrectionLevel r1, Mode r2, BitArray r3, BitArray r4) throws WriterException {
        return chooseVersion(calculateBitsNeeded(r2, r3, r4, chooseVersion(calculateBitsNeeded(r2, r3, r4, Version.getVersionForNumber(1)), r1)), r1);
    }

    private static int calculateBitsNeeded(Mode r0, BitArray r1, BitArray r2, Version r3) {
        return (r1.getSize() + r0.getCharacterCountBits(r3)) + r2.getSize();
    }

    static int getAlphanumericCode(int r2) {
        int[] r0 = ALPHANUMERIC_TABLE;
        if (r2 < r0.length) goto L5;
        return -1;
    L5:
        return r0[r2];
    }

    public static Mode chooseMode(String r1) {
        return chooseMode(r1, null);
    }

    private static Mode chooseMode(String r5, String r6) {
        if ("Shift_JIS".equals(r6) == true) goto L5;
    L8:
        int r7 = 0;
        boolean r0 = false;
        boolean r1 = false;
    L10:
        if (r7 >= r5.length()) goto L22;
        char r2 = r5.charAt(r7);
        if (r2 < '0') goto L17;
        if (r2 > '9') goto L17;
        r1 = true;
    L19:
        r7 = r7 + 1;
    L17:
        if (getAlphanumericCode(r2) == (-1)) goto L21;
        r0 = true;
        goto L19
    L21:
        return Mode.BYTE;
    L22:
        if (r0 == true) goto L24;
        if (r1 == false) goto L29;
        return Mode.NUMERIC;
    L29:
        return Mode.BYTE;
    L24:
        return Mode.ALPHANUMERIC;
    L5:
        if (isOnlyDoubleByteKanji(r5) == false) goto L8;
        return Mode.KANJI;
    }

    private static boolean isOnlyDoubleByteKanji(String r5) {
        byte[] r6 = r5.getBytes("Shift_JIS");     // Catch: UnsupportedEncodingException -> L22
        int r1 = r6.length;
        if ((r1 % 2) == 0) goto L7;
        return false;
    L7:
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L20;
        int r3 = r6[r2] & 255;
        if (r3 < 129) goto L14;
        if (r3 > 159) goto L14;
    L18:
        r2 = r2 + 2;
    L14:
        if (r3 < 224) goto L19;
        if (r3 <= 235) goto L18;
    L19:
        return false;
    L20:
        return true;
    L22:
        return false;
    }

    private static int chooseMaskPattern(BitArray r4, ErrorCorrectionLevel r5, Version r6, ByteMatrix r7) throws WriterException {
        int r0 = Integer.MAX_VALUE;
        int r1 = -1;
        int r2 = 0;
    L4:
        if (r2 >= 8) goto L9;
        MatrixUtil.buildMatrix(r4, r5, r6, r2, r7);
        int r3 = calculateMaskPenalty(r7);
        if (r3 >= r0) goto L8;
        r1 = r2;
        r0 = r3;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        return r1;
    }

    private static Version chooseVersion(int r3, ErrorCorrectionLevel r4) throws WriterException {
        int r0 = 1;
    L4:
        if (r0 > 40) goto L10;
        Version r1 = Version.getVersionForNumber(r0);
        if (willFit(r3, r1, r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L10:
        throw new WriterException("Data too big");
    }

    private static boolean willFit(int r1, Version r2, ErrorCorrectionLevel r3) {
        if ((r2.getTotalCodewords() - r2.getECBlocksForLevel(r3).getTotalECCodewords()) < ((r1 + 7) / 8)) goto L6;
        return true;
    L6:
        return false;
    }

    static void terminateBits(int r4, BitArray r5) throws WriterException {
        int r0 = r4 << 3;
        if (r5.getSize() > r0) goto L27;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= 4) goto L10;
        if (r5.getSize() >= r0) goto L10;
        r5.appendBit(false);
        r2 = r2 + 1;
    L10:
        int r3 = r5.getSize() & 7;
        if (r3 <= 0) goto L14;
    L12:
        if (r3 >= 8) goto L14;
        r5.appendBit(false);
        r3 = r3 + 1;
    L14:
        int r6 = r4 - r5.getSizeInBytes();
    L15:
        if (r1 >= r6) goto L22;
        if ((r1 & 1) != 0) goto L19;
        int r7 = UCharacter.UnicodeBlock.MODI_ID;
    L20:
        r5.appendBits(r7, 8);
        r1 = r1 + 1;
        goto L15
    L19:
        r7 = 17;
        goto L20
    L22:
        if (r5.getSize() != r0) goto L25;
        return;
    L25:
        throw new WriterException("Bits size does not equal capacity");
    L27:
        throw new WriterException("data bits cannot fit in the QR Code" + r5.getSize() + " > " + r0);
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int r6, int r7, int r8, int r9, int[] r10, int[] r11) throws WriterException {
        if (r9 >= r8) goto L22;
        int r0 = r6 % r8;
        int r1 = r8 - r0;
        int r2 = r6 / r8;
        int r3 = r2 + 1;
        int r12 = r7 / r8;
        int r4 = r12 + 1;
        int r5 = r2 - r12;
        int r13 = r3 - r4;
        if (r5 != r13) goto L20;
        if (r8 != (r1 + r0)) goto L18;
        if (r6 != (((r12 + r5) * r1) + ((r4 + r13) * r0))) goto L16;
        if (r9 >= r1) goto L13;
        r10[0] = r12;
        r11[0] = r5;
        return;
    L13:
        r10[0] = r4;
        r11[0] = r13;
        return;
    L16:
        throw new WriterException("Total bytes mismatch");
    L18:
        throw new WriterException("RS blocks mismatch");
    L20:
        throw new WriterException("EC bytes mismatch");
    L22:
        throw new WriterException("Block ID too large");
    }

    static BitArray interleaveWithECBytes(BitArray r17, int r18, int r19, int r20) throws WriterException {
        if (r17.getSizeInBytes() != r19) goto L34;
        ArrayList r9 = new ArrayList(r20);
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r11 >= r20) goto L7;
        int[] r15 = new int[1];
        int[] r5 = new int[1];
        getNumDataBytesAndNumECBytesForBlockID(r18, r19, r20, r11, r15, r5);
        int r0 = r15[0];
        byte[] r1 = new byte[r0];
        r17.toBytes(r12 << 3, r1, 0, r0);
        byte[] r2 = generateECBytes(r1, r5[0]);
        r9.add(new BlockPair(r1, r2));
        r13 = Math.max(r13, r0);
        r14 = Math.max(r14, r2.length);
        r12 = r12 + r15[0];
        r11 = r11 + 1;
        goto L5
    L7:
        if (r19 != r12) goto L32;
        BitArray r3 = new BitArray();
        int r4 = 0;
    L10:
        if (r4 >= r13) goto L18;
        Iterator r6 = r9.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        byte[] r7 = ((BlockPair) r6.next()).getDataBytes();
        if (r4 >= r7.length) goto L13;
        r3.appendBits(r7[r4], 8);
        goto L13
    L17:
        r4 = r4 + 1;
    L18:
        if (r10 >= r14) goto L27;
        Iterator r8 = r9.iterator();
    L21:
        if (r8.hasNext() == false) goto L25;
        byte[] r16 = ((BlockPair) r8.next()).getErrorCorrectionBytes();
        if (r10 >= r16.length) goto L21;
        r3.appendBits(r16[r10], 8);
        goto L21
    L25:
        r10 = r10 + 1;
        goto L18
    L27:
        if (r18 != r3.getSizeInBytes()) goto L30;
        return r3;
    L30:
        throw new WriterException("Interleaving error: " + r18 + " and " + r3.getSizeInBytes() + " differ.");
    L32:
        throw new WriterException("Data bytes does not match offset");
    L34:
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] generateECBytes(byte[] r5, int r6) {
        int r0 = r5.length;
        int[] r1 = new int[r0 + r6];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = r5[r3] & 255;
        r3 = r3 + 1;
        goto L3
    L5:
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(r1, r6);
        byte[] r7 = new byte[r6];
    L6:
        if (r2 >= r6) goto L8;
        r7[r2] = (byte) r1[r0 + r2];
        r2 = r2 + 1;
        goto L6
    L8:
        return r7;
    }

    static void appendModeInfo(Mode r1, BitArray r2) {
        r2.appendBits(r1.getBits(), 4);
    }

    static void appendLengthInfo(int r1, Version r2, Mode r3, BitArray r4) throws WriterException {
        int r5 = r3.getCharacterCountBits(r2);
        int r0 = 1 << r5;
        if (r1 >= r0) goto L7;
        r4.appendBits(r1, r5);
        return;
    L7:
        throw new WriterException(r1 + " is bigger than " + (r0 - 1));
    }

    static void appendBytes(String r2, Mode r3, BitArray r4, String r5) throws WriterException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[r3.ordinal()];
        if (r0 != 1) goto L5;
        appendNumericBytes(r2, r4);
        return;
    L5:
        if (r0 != 2) goto L7;
        appendAlphanumericBytes(r2, r4);
        return;
    L7:
        if (r0 != 3) goto L9;
        append8BitBytes(r2, r4, r5);
        return;
    L9:
        if (r0 != 4) goto L13;
        appendKanjiBytes(r2, r4);
        return;
    L13:
        throw new WriterException("Invalid mode: ".concat(String.valueOf(r3)));
    }

    static void appendNumericBytes(CharSequence r6, BitArray r7) {
        int r0 = r6.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        int r2 = r6.charAt(r1) - '0';
        int r3 = r1 + 2;
        if (r3 < r0) goto L6;
        r1 = r1 + 1;
        if (r1 < r0) goto L9;
        r7.appendBits(r2, 4);
        goto L3
    L9:
        r7.appendBits((r2 * 10) + (r6.charAt(r1) - '0'), 7);
        r1 = r3;
        goto L3
    L6:
        r7.appendBits(((r2 * 100) + ((r6.charAt(r1 + 1) - '0') * 10)) + (r6.charAt(r3) - '0'), 10);
        r1 = r1 + 3;
        goto L3
    }

    static void appendAlphanumericBytes(CharSequence r5, BitArray r6) throws WriterException {
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L16;
        int r2 = getAlphanumericCode(r5.charAt(r1));
        if (r2 == (-1)) goto L15;
        int r4 = r1 + 1;
        if (r4 < r0) goto L8;
        r6.appendBits(r2, 6);
        r1 = r4;
        goto L3
    L8:
        int r7 = getAlphanumericCode(r5.charAt(r4));
        if (r7 == (-1)) goto L12;
        r6.appendBits((r2 * 45) + r7, 11);
        r1 = r1 + 2;
        goto L3
    L12:
        throw new WriterException();
    L15:
        throw new WriterException();
    }

    static void append8BitBytes(String r3, BitArray r4, String r5) throws WriterException {
        byte[] r6 = r3.getBytes(r5);     // Catch: UnsupportedEncodingException -> L7
        int r7 = r6.length;
        int r0 = 0;
    L4:
        if (r0 >= r7) goto L6;
        r4.appendBits(r6[r0], 8);
        r0 = r0 + 1;
        goto L4
    L6:
        return;
    L7:
        e = move-exception;
        throw new WriterException(e);
    }

    static void appendKanjiBytes(String r6, BitArray r7) throws WriterException {
        byte[] r8 = r6.getBytes("Shift_JIS");     // Catch: UnsupportedEncodingException -> L21
        int r0 = r8.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L20;
        int r2 = ((r8[r1] & 255) << 8) | (r8[r1 + 1] & 255);
        int r3 = 33088;
        if (r2 < 33088) goto L11;
        if (r2 > 40956) goto L11;
    L9:
        int r4 = r2 - r3;
    L16:
        if (r4 == (-1)) goto L19;
        r7.appendBits(((r4 >> 8) * 192) + (r4 & 255), 13);
        r1 = r1 + 2;
        goto L4
    L19:
        throw new WriterException("Invalid byte sequence");
    L11:
        if (r2 >= 57408) goto L13;
    L15:
        r4 = -1;
        goto L16
    L13:
        if (r2 > 60351) goto L15;
        r3 = 49472;
        goto L9
    L20:
        return;
    L21:
        e = move-exception;
        throw new WriterException(e);
    }

    private static void appendECI(CharacterSetECI r2, BitArray r3) {
        r3.appendBits(Mode.ECI.getBits(), 4);
        r3.appendBits(r2.getValue(), 8);
    }
}
