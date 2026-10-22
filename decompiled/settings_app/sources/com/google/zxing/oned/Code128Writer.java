package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    private static final enum CType extends Enum<CType> {
        private static final /* synthetic */ CType[] $VALUES = null;
        public static final CType FNC_1 = null;
        public static final CType ONE_DIGIT = null;
        public static final CType TWO_DIGITS = null;
        public static final CType UNCODABLE = null;

        private CType(String r1, int r2) {
            super(r1, r2);
        }

        public static CType valueOf(String r1) {
            return (CType) Enum.valueOf(CType.class, r1);
        }

        public static CType[] values() {
            return (CType[]) $VALUES.clone();
        }

        static {
            CType r0 = new CType("UNCODABLE", 0);
            UNCODABLE = r0;
            CType r1 = new CType("ONE_DIGIT", 1);
            ONE_DIGIT = r1;
            CType r3 = new CType("TWO_DIGITS", 2);
            TWO_DIGITS = r3;
            CType r5 = new CType("FNC_1", 3);
            FNC_1 = r5;
            $VALUES = new CType[]{r0, r1, r3, r5};
        }
    }

    public Code128Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.CODE_128) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(r3)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r12) {
        int r11 = r12.length();
        if (r11 <= 0) goto L58;
        if (r11 > 80) goto L58;
        int r0 = 0;
        int r1 = 0;
    L7:
        if (r1 >= r11) goto L15;
        char r2 = r12.charAt(r1);
        switch(r2) {
            case 241: goto L12;
            case 242: goto L12;
            case 243: goto L12;
            case 244: goto L12;
            default: goto L11;
        };
    L11:
        if (r2 <= 127) goto L12;
        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(r2)));
    L12:
        r1 = r1 + 1;
        goto L7
    L15:
        ArrayList r3 = new ArrayList();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 1;
    L16:
        int r8 = 103;
        if (r4 >= r11) goto L46;
        int r9 = chooseCode(r12, r4, r6);
        int r10 = 100;
        if (r9 == r6) goto L21;
        if (r6 != 0) goto L41;
        if (r9 == 100) goto L40;
        if (r9 == 101) goto L42;
        r8 = 105;
    L42:
        r10 = r8;
        r6 = r9;
    L43:
        r3.add(Code128Reader.CODE_PATTERNS[r10]);
        r5 = r5 + (r10 * r7);
        if (r4 == 0) goto L16;
        r7 = r7 + 1;
        goto L16
    L40:
        r8 = 104;
        goto L42
    L41:
        r8 = r9;
        goto L42
    L21:
        switch(r12.charAt(r4)) {
            case 241: goto L27;
            case 242: goto L26;
            case 243: goto L25;
            case 244: goto L23;
            default: goto L28;
        };
    L23:
        if (r6 != 101) goto L35;
        r10 = 101;
    L35:
        r4 = r4 + 1;
        goto L43
    L25:
        r10 = 96;
        goto L35
    L26:
        r10 = 97;
        goto L35
    L27:
        r10 = 102;
        goto L35
    L28:
        if (r6 == 100) goto L34;
        if (r6 == 101) goto L31;
        r10 = Integer.parseInt(r12.substring(r4, r4 + 2));
        r4 = r4 + 1;
        goto L35
    L31:
        r10 = r12.charAt(r4) - ' ';
        if (r10 >= 0) goto L35;
        r10 = r10 + 96;
        goto L35
    L34:
        r10 = r12.charAt(r4) - ' ';
        goto L35
    L46:
        r3.add(Code128Reader.CODE_PATTERNS[r5 % 103]);
        r3.add(Code128Reader.CODE_PATTERNS[106(0x6a, float:1.49E-43)]);
        Iterator r13 = r3.iterator();
        int r14 = 0;
    L48:
        if (r13.hasNext() == false) goto L52;
        int[] r15 = (int[]) r13.next();
        int r16 = r15.length;
        int r17 = 0;
    L50:
        if (r17 >= r16) goto L48;
        r14 = r14 + r15[r17];
        r17 = r17 + 1;
        goto L50
    L52:
        boolean[] r18 = new boolean[r14];
        Iterator r19 = r3.iterator();
    L54:
        if (r19.hasNext() == false) goto L56;
        r0 = r0 + appendPattern(r18, r0, (int[]) r19.next(), true);
        goto L54
    L56:
        return r18;
    L58:
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(r11)));
    }

    private static CType findCType(CharSequence r4, int r5) {
        int r0 = r4.length();
        if (r5 >= r0) goto L5;
        char r1 = r4.charAt(r5);
        if (r1 != 241) goto L11;
        return CType.FNC_1;
    L11:
        if (r1 < '0') goto L28;
        if (r1 > '9') goto L28;
        int r6 = r5 + 1;
        if (r6 >= r0) goto L18;
        char r7 = r4.charAt(r6);
        if (r7 < '0') goto L26;
        if (r7 > '9') goto L26;
        return CType.TWO_DIGITS;
    L26:
        return CType.ONE_DIGIT;
    L18:
        return CType.ONE_DIGIT;
    L28:
        return CType.UNCODABLE;
    L5:
        return CType.UNCODABLE;
    }

    private static int chooseCode(CharSequence r3, int r4, int r5) {
        CType r0 = findCType(r3, r4);
        if (r0 != CType.ONE_DIGIT) goto L6;
        return 100;
    L6:
        if (r0 != CType.UNCODABLE) goto L17;
        if (r4 >= r3.length()) goto L15;
        char r6 = r3.charAt(r4);
        if (r6 < ' ') goto L14;
        if (r5 != 101) goto L15;
        if (r6 >= '`') goto L15;
    L14:
        return 101;
    L15:
        return 100;
    L17:
        if (r5 != 99) goto L19;
        return 99;
    L19:
        if (r5 != 100) goto L44;
        if (r0 != CType.FNC_1) goto L23;
        return 100;
    L23:
        CType r7 = findCType(r3, r4 + 2);
        if (r7 != CType.UNCODABLE) goto L26;
    L42:
        return 100;
    L26:
        if (r7 == CType.ONE_DIGIT) goto L42;
        if (r7 == CType.FNC_1) goto L31;
        int r8 = r4 + 4;
    L35:
        CType r9 = findCType(r3, r8);
        if (r9 != CType.TWO_DIGITS) goto L39;
        r8 = r8 + 2;
        goto L35
    L39:
        if (r9 != CType.ONE_DIGIT) goto L41;
        return 100;
    L41:
        return 99;
    L31:
        if (findCType(r3, r4 + 3) != CType.TWO_DIGITS) goto L33;
        return 99;
    L33:
        return 100;
    L44:
        if (r0 != CType.FNC_1) goto L47;
        r0 = findCType(r3, r4 + 1);
    L47:
        if (r0 != CType.TWO_DIGITS) goto L49;
        return 99;
    L49:
        return 100;
    }
}
