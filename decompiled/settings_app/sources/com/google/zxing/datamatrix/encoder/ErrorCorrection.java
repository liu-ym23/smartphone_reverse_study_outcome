package com.google.zxing.datamatrix.encoder;

import android.icu.lang.UCharacter;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorCorrection {
    private static final int[] ALOG = null;
    private static final int[][] FACTORS = null;
    private static final int[] FACTOR_SETS = null;
    private static final int[] LOG = null;
    private static final int MODULO_VALUE = 301;

    static {
        FACTOR_SETS = new int[]{5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
        int r3 = 0;
        FACTORS = new int[][]{new int[]{UCharacter.UnicodeBlock.GRANTHA_ID, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, UCharacter.UnicodeBlock.ANATOLIAN_HIEROGLYPHS_ID}, new int[]{28, 24, 185, 166, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, UCharacter.UnicodeBlock.SIDDHAM_ID, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, UCharacter.UnicodeBlock.PAU_CIN_HAU_ID, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, UCharacter.UnicodeBlock.ORNAMENTAL_DINGBATS_ID}, new int[]{156, 97, 192, UCharacter.UnicodeBlock.WARANG_CITI_ID, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, UCharacter.UnicodeBlock.OLD_PERMIC_ID, 213, 109, 129, 94, UCharacter.UnicodeBlock.ANATOLIAN_HIEROGLYPHS_ID, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, UCharacter.UnicodeBlock.AHOM_ID, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, UCharacter.UnicodeBlock.TIRHUTA_ID, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, 155, 21, 5, 172, UCharacter.UnicodeBlock.ANATOLIAN_HIEROGLYPHS_ID, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, UCharacter.UnicodeBlock.LATIN_EXTENDED_E_ID, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, UCharacter.UnicodeBlock.SINHALA_ARCHAIC_NUMBERS_ID, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{UCharacter.UnicodeBlock.PAU_CIN_HAU_ID, 127, UCharacter.UnicodeBlock.ORNAMENTAL_DINGBATS_ID, UCharacter.UnicodeBlock.SORA_SOMPENG_ID, 130, 250, 162, 181, 102, 120, 84, 179, UCharacter.UnicodeBlock.TAKRI_ID, UCharacter.UnicodeBlock.TIRHUTA_ID, 80, 182, UCharacter.UnicodeBlock.KHOJKI_ID, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, UCharacter.UnicodeBlock.SHORTHAND_FORMAT_CONTROLS_ID, 105, 122, 2, UCharacter.UnicodeBlock.PAU_CIN_HAU_ID, 133, UCharacter.UnicodeBlock.ORNAMENTAL_DINGBATS_ID, 8, 175, 95, 100, 9, 167, 105, UCharacter.UnicodeBlock.MEROITIC_CURSIVE_ID, 111, 57, 121, 21, 1, UCharacter.UnicodeBlock.AHOM_ID, 57, 54, 101, UCharacter.UnicodeBlock.SIDDHAM_ID, 202, 69, 50, 150, 177, UCharacter.UnicodeBlock.ELBASAN_ID, 5, 9, 5}, new int[]{UCharacter.UnicodeBlock.PAU_CIN_HAU_ID, 132, 172, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, 96, 32, 117, 22, UCharacter.UnicodeBlock.MYANMAR_EXTENDED_B_ID, 133, UCharacter.UnicodeBlock.MYANMAR_EXTENDED_B_ID, UCharacter.UnicodeBlock.LATIN_EXTENDED_E_ID, 205, 188, UCharacter.UnicodeBlock.MRO_ID, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, UCharacter.UnicodeBlock.AHOM_ID, 225, 19}, new int[]{175, 9, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, UCharacter.UnicodeBlock.MYANMAR_EXTENDED_B_ID, 12, 17, UCharacter.UnicodeBlock.TAKRI_ID, 208, 100, 29, 175, 170, UCharacter.UnicodeBlock.KHUDAWADI_ID, 192, UCharacter.UnicodeBlock.MEROITIC_HIEROGLYPHS_ID, UCharacter.UnicodeBlock.MENDE_KIKAKUI_ID, 150, 159, 36, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, 38, 200, 132, 54, UCharacter.UnicodeBlock.GRANTHA_ID, 146, UCharacter.UnicodeBlock.SORA_SOMPENG_ID, UCharacter.UnicodeBlock.MANICHAEAN_ID, 117, 203, 29, UCharacter.UnicodeBlock.LINEAR_A_ID, 144, UCharacter.UnicodeBlock.MYANMAR_EXTENDED_B_ID, 22, 150, 201, 117, 62, 207, 164, 13, 137, UCharacter.UnicodeBlock.PAU_CIN_HAU_ID, 127, 67, UCharacter.UnicodeBlock.SHORTHAND_FORMAT_CONTROLS_ID, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{UCharacter.UnicodeBlock.ORNAMENTAL_DINGBATS_ID, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, UCharacter.UnicodeBlock.KHUDAWADI_ID, UCharacter.UnicodeBlock.PAU_CIN_HAU_ID, 63, 197, 190, 250, 106, 185, UCharacter.UnicodeBlock.BASSA_VAH_ID, 175, 64, 114, 71, 161, 44, 147, 6, 27, UCharacter.UnicodeBlock.SORA_SOMPENG_ID, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, UCharacter.UnicodeBlock.LINEAR_A_ID, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{UCharacter.UnicodeBlock.TAKRI_ID, UCharacter.UnicodeBlock.GRANTHA_ID, 173, 89, UCharacter.UnicodeBlock.TIRHUTA_ID, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, UCharacter.UnicodeBlock.SIDDHAM_ID, 180, UCharacter.UnicodeBlock.MANICHAEAN_ID, 197, 158, 177, 68, 122, 93, 213, 15, 160, UCharacter.UnicodeBlock.GEOMETRIC_SHAPES_EXTENDED_ID, UCharacter.UnicodeBlock.MODI_ID, 66, 139, 153, 185, 202, 167, 179, 25, UCharacter.UnicodeBlock.TAKRI_ID, UCharacter.UnicodeBlock.LINEAR_A_ID, 96, 210, UCharacter.UnicodeBlock.LATIN_EXTENDED_E_ID, 136, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, UCharacter.UnicodeBlock.NABATAEAN_ID, 181, UCharacter.UnicodeBlock.OLD_PERMIC_ID, 59, 52, 172, 25, 49, UCharacter.UnicodeBlock.LINEAR_A_ID, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
        LOG = new int[256];
        ALOG = new int[255];
        int r2 = 1;
    L3:
        if (r3 >= 255) goto L8;
        ALOG[r3] = r2;
        LOG[r2] = r3;
        r2 = r2 << 1;
        if (r2 < 256) goto L7;
        r2 = r2 ^ 301;
    L7:
        r3 = r3 + 1;
        goto L3
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String r11, SymbolInfo r12) {
        if (r11.length() != r12.getDataCapacity()) goto L27;
        StringBuilder r0 = new StringBuilder(r12.getDataCapacity() + r12.getErrorCodewords());
        r0.append(r11);
        int r1 = r12.getInterleavedBlockCount();
        if (r1 != 1) goto L7;
        r0.append(createECCBlock(r11, r12.getErrorCodewords()));
    L25:
        return r0.toString();
    L7:
        r0.setLength(r0.capacity());
        int[] r2 = new int[r1];
        int[] r3 = new int[r1];
        int[] r4 = new int[r1];
        int r6 = 0;
    L8:
        if (r6 >= r1) goto L13;
        int r7 = r6 + 1;
        r2[r6] = r12.getDataLengthForInterleavedBlock(r7);
        r3[r6] = r12.getErrorLengthForInterleavedBlock(r7);
        r4[r6] = 0;
        if (r6 <= 0) goto L12;
        r4[r6] = r4[r6 - 1] + r2[r6];
    L12:
        r6 = r7;
        goto L8
    L13:
        int r5 = 0;
    L14:
        if (r5 >= r1) goto L25;
        StringBuilder r8 = new StringBuilder(r2[r5]);
        int r9 = r5;
    L17:
        if (r9 >= r12.getDataCapacity()) goto L19;
        r8.append(r11.charAt(r9));
        r9 = r9 + r1;
        goto L17
    L19:
        String r10 = createECCBlock(r8.toString(), r3[r5]);
        int r13 = r5;
        int r14 = 0;
    L21:
        if (r13 >= (r3[r5] * r1)) goto L23;
        r0.setCharAt(r12.getDataCapacity() + r13, r10.charAt(r14));
        r13 = r13 + r1;
        r14 = r14 + 1;
        goto L21
    L23:
        r5 = r5 + 1;
        goto L14
    L27:
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence r2, int r3) {
        return createECCBlock(r2, 0, r2.length(), r3);
    }

    private static String createECCBlock(CharSequence r11, int r12, int r13, int r14) {
        int r0 = 0;
        int r1 = 0;
    L3:
        int[] r2 = FACTOR_SETS;
        if (r1 >= r2.length) goto L9;
        if (r2[r1] == r14) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L37;
        int[] r3 = FACTORS[r1];
        char[] r4 = new char[r14];
        int r5 = 0;
    L12:
        if (r5 >= r14) goto L14;
        r4[r5] = 0;
        r5 = r5 + 1;
        goto L12
    L14:
        int r6 = r12;
    L16:
        if (r6 >= (r12 + r13)) goto L31;
        int r7 = r14 - 1;
        int r8 = r4[r7] ^ r11.charAt(r6);
    L18:
        if (r7 <= 0) goto L25;
        if (r8 == 0) goto L23;
        int r9 = r3[r7];
        if (r9 == 0) goto L23;
        char r10 = r4[r7 - 1];
        int[] r15 = ALOG;
        int[] r16 = LOG;
        r4[r7] = (char) (r15[(r16[r8] + r16[r9]) % 255] ^ r10);
    L24:
        r7 = r7 - 1;
    L23:
        r4[r7] = r4[r7 - 1];
        goto L24
    L25:
        if (r8 == 0) goto L29;
        int r17 = r3[0];
        if (r17 == 0) goto L29;
        int[] r18 = ALOG;
        int[] r19 = LOG;
        r4[0] = (char) r18[(r19[r8] + r19[r17]) % 255];
    L30:
        r6 = r6 + 1;
    L29:
        r4[0] = 0;
        goto L30
    L31:
        char[] r110 = new char[r14];
    L32:
        if (r0 >= r14) goto L35;
        r110[r0] = r4[(r14 - r0) - 1];
        r0 = r0 + 1;
        goto L32
    L35:
        return String.valueOf(r110);
    L37:
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(r14)));
    L9:
        r1 = -1;
        goto L10
    }
}
