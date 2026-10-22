package com.google.zxing.oned.rss.expanded.decoders;

import com.android.settingslib.accessibility.AccessibilityUtils;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import cz.msebera.android.httpclient.message.TokenParser;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
final class GeneralAppIdDecoder {
    private final StringBuilder buffer;
    private final CurrentParsingState current;
    private final BitArray information;

    GeneralAppIdDecoder(BitArray r2) {
        this.current = new CurrentParsingState();
        this.buffer = new StringBuilder();
        this.information = r2;
    }

    String decodeAllCodes(StringBuilder r5, int r6) throws NotFoundException, FormatException {
        String r1 = null;
    L3:
        DecodedInformation r2 = decodeGeneralPurposeField(r6, r1);
        String r3 = FieldParser.parseFieldsInGeneralPurpose(r2.getNewString());
        if (r3 == null) goto L7;
        r5.append(r3);
    L7:
        if (r2.isRemaining() == false) goto L9;
        String r4 = String.valueOf(r2.getRemainingValue());
    L11:
        if (r6 == r2.getNewPosition()) goto L14;
        r6 = r2.getNewPosition();
        r1 = r4;
        goto L3
    L14:
        return r5.toString();
    L9:
        r4 = null;
        goto L11
    }

    private boolean isStillNumeric(int r4) {
        if ((r4 + 7) > this.information.getSize()) goto L5;
        int r0 = r4;
    L10:
        int r1 = r4 + 3;
        if (r0 >= r1) goto L17;
        if (this.information.get(r0) == true) goto L14;
        r0 = r0 + 1;
        goto L10
    L14:
        return true;
    L17:
        return this.information.get(r1);
    L5:
        if ((r4 + 4) > this.information.getSize()) goto L7;
        return true;
    L7:
        return false;
    }

    private DecodedNumeric decodeNumeric(int r3) throws FormatException {
        int r0 = r3 + 7;
        if (r0 <= this.information.getSize()) goto L10;
        int r4 = extractNumericValueFromBitArray(r3, 4);
        if (r4 != 0) goto L9;
        return new DecodedNumeric(this.information.getSize(), 10, 10);
    L9:
        return new DecodedNumeric(this.information.getSize(), r4 - 1, 10);
    L10:
        int r2 = extractNumericValueFromBitArray(r3, 7) - 8;
        return new DecodedNumeric(r0, r2 / 11, r2 % 11);
    }

    int extractNumericValueFromBitArray(int r1, int r2) {
        return extractNumericValueFromBitArray(this.information, r1, r2);
    }

    static int extractNumericValueFromBitArray(BitArray r4, int r5, int r6) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r6) goto L8;
        if (r4.get(r5 + r0) == false) goto L7;
        r1 = r1 | (1 << ((r6 - r0) - 1));
    L7:
        r0 = r0 + 1;
        goto L3
    L8:
        return r1;
    }

    DecodedInformation decodeGeneralPurposeField(int r3, String r4) throws FormatException {
        this.buffer.setLength(0);
        if (r4 == null) goto L5;
        this.buffer.append(r4);
    L5:
        this.current.setPosition(r3);
        DecodedInformation r5 = parseBlocks();
        if (r5 == null) goto L12;
        if (r5.isRemaining() == false) goto L12;
        return new DecodedInformation(this.current.getPosition(), this.buffer.toString(), r5.getRemainingValue());
    L12:
        return new DecodedInformation(this.current.getPosition(), this.buffer.toString());
    }

    private DecodedInformation parseBlocks() throws FormatException {
    L2:
        int r0 = this.current.getPosition();
        if (this.current.isAlpha() == false) goto L6;
        BlockParsedResult r1 = parseAlphaBlock();
        boolean r2 = r1.isFinished();
    L10:
        if (r0 == this.current.getPosition()) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        if (r2 == true) goto L15;
    L17:
        return r1.getDecodedInformation();
    L15:
        if (r2 == false) goto L2;
    L12:
        r3 = false;
        goto L13
    L6:
        if (this.current.isIsoIec646() == false) goto L8;
        r1 = parseIsoIec646Block();
        r2 = r1.isFinished();
        goto L10
    L8:
        r1 = parseNumericBlock();
        r2 = r1.isFinished();
        goto L10
    }

    private BlockParsedResult parseNumericBlock() throws FormatException {
    L3:
        if (isStillNumeric(this.current.getPosition()) == false) goto L18;
        DecodedNumeric r0 = decodeNumeric(this.current.getPosition());
        this.current.setPosition(r0.getNewPosition());
        if (r0.isFirstDigitFNC1() == true) goto L7;
        this.buffer.append(r0.getFirstDigit());
        if (r0.isSecondDigitFNC1() == true) goto L15;
        this.buffer.append(r0.getSecondDigit());
        goto L3
    L15:
        return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
    L7:
        if (r0.isSecondDigitFNC1() == false) goto L9;
        DecodedInformation r1 = new DecodedInformation(this.current.getPosition(), this.buffer.toString());
    L11:
        return new BlockParsedResult(r1, true);
    L9:
        r1 = new DecodedInformation(this.current.getPosition(), this.buffer.toString(), r0.getSecondDigit());
        goto L11
    L18:
        if (isNumericToAlphaNumericLatch(this.current.getPosition()) == false) goto L21;
        this.current.setAlpha();
        this.current.incrementPosition(4);
    L21:
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseIsoIec646Block() throws FormatException {
    L3:
        if (isStillIsoIec646(this.current.getPosition()) == false) goto L10;
        DecodedChar r0 = decodeIsoIec646(this.current.getPosition());
        this.current.setPosition(r0.getNewPosition());
        if (r0.isFNC1() == true) goto L7;
        this.buffer.append(r0.getValue());
        goto L3
    L7:
        return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
    L10:
        if (isAlphaOr646ToNumericLatch(this.current.getPosition()) == false) goto L13;
        this.current.incrementPosition(3);
        this.current.setNumeric();
    L20:
        return new BlockParsedResult(false);
    L13:
        if (isAlphaTo646ToAlphaLatch(this.current.getPosition()) == false) goto L20;
        if ((this.current.getPosition() + 5) >= this.information.getSize()) goto L17;
        this.current.incrementPosition(5);
    L18:
        this.current.setAlpha();
        goto L20
    L17:
        this.current.setPosition(this.information.getSize());
        goto L18
    }

    private BlockParsedResult parseAlphaBlock() {
    L3:
        if (isStillAlpha(this.current.getPosition()) == false) goto L10;
        DecodedChar r0 = decodeAlphanumeric(this.current.getPosition());
        this.current.setPosition(r0.getNewPosition());
        if (r0.isFNC1() == true) goto L7;
        this.buffer.append(r0.getValue());
        goto L3
    L7:
        return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
    L10:
        if (isAlphaOr646ToNumericLatch(this.current.getPosition()) == false) goto L13;
        this.current.incrementPosition(3);
        this.current.setNumeric();
    L20:
        return new BlockParsedResult(false);
    L13:
        if (isAlphaTo646ToAlphaLatch(this.current.getPosition()) == false) goto L20;
        if ((this.current.getPosition() + 5) >= this.information.getSize()) goto L17;
        this.current.incrementPosition(5);
    L18:
        this.current.setIsoIec646();
        goto L20
    L17:
        this.current.setPosition(this.information.getSize());
        goto L18
    }

    private boolean isStillIsoIec646(int r5) {
        if ((r5 + 5) <= this.information.getSize()) goto L5;
        return false;
    L5:
        int r1 = extractNumericValueFromBitArray(r5, 5);
        if (r1 < 5) goto L11;
        if (r1 >= 16) goto L11;
        return true;
    L11:
        if ((r5 + 7) <= this.information.getSize()) goto L13;
        return false;
    L13:
        int r0 = extractNumericValueFromBitArray(r5, 7);
        if (r0 < 64) goto L19;
        if (r0 >= 116) goto L19;
        return true;
    L19:
        if ((r5 + 8) <= this.information.getSize()) goto L21;
        return false;
    L21:
        int r4 = extractNumericValueFromBitArray(r5, 8);
        if (r4 >= 232) goto L24;
    L26:
        return false;
    L24:
        if (r4 >= 253) goto L26;
        return true;
    }

    private DecodedChar decodeIsoIec646(int r5) throws FormatException {
        int r1 = extractNumericValueFromBitArray(r5, 5);
        if (r1 == 15) goto L5;
        if (r1 < 5) goto L10;
        if (r1 >= 15) goto L10;
        return new DecodedChar(r5 + 5, (char) ((r1 + 48) - 5));
    L10:
        int r2 = extractNumericValueFromBitArray(r5, 7);
        if (r2 < 64) goto L15;
        if (r2 >= 90) goto L15;
        return new DecodedChar(r5 + 7, (char) (r2 + 1));
    L15:
        if (r2 < 90) goto L21;
        if (r2 >= 116) goto L21;
        return new DecodedChar(r5 + 7, (char) (r2 + 7));
    L21:
        switch(extractNumericValueFromBitArray(r5, 8)) {
            case 232: goto L44;
            case 233: goto L43;
            case 234: goto L42;
            case 235: goto L41;
            case 236: goto L40;
            case 237: goto L39;
            case 238: goto L38;
            case 239: goto L37;
            case 240: goto L36;
            case 241: goto L35;
            case 242: goto L34;
            case 243: goto L33;
            case 244: goto L32;
            case 245: goto L31;
            case 246: goto L30;
            case 247: goto L29;
            case 248: goto L28;
            case 249: goto L27;
            case 250: goto L26;
            case 251: goto L25;
            case 252: goto L24;
            default: goto L23;
        };
    L24:
        char r4 = TokenParser.SP;
    L46:
        return new DecodedChar(r5 + 8, r4);
    L25:
        r4 = '_';
        goto L46
    L26:
        r4 = '?';
        goto L46
    L27:
        r4 = '>';
        goto L46
    L28:
        r4 = '=';
        goto L46
    L29:
        r4 = '<';
        goto L46
    L30:
        r4 = ';';
        goto L46
    L31:
        r4 = AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR;
        goto L46
    L32:
        r4 = IOUtils.DIR_SEPARATOR_UNIX;
        goto L46
    L33:
        r4 = '.';
        goto L46
    L34:
        r4 = '-';
        goto L46
    L35:
        r4 = ',';
        goto L46
    L36:
        r4 = '+';
        goto L46
    L37:
        r4 = '*';
        goto L46
    L38:
        r4 = ')';
        goto L46
    L39:
        r4 = '(';
        goto L46
    L40:
        r4 = '\'';
        goto L46
    L41:
        r4 = Typography.amp;
        goto L46
    L42:
        r4 = '%';
        goto L46
    L43:
        r4 = '\"';
        goto L46
    L44:
        r4 = '!';
        goto L46
    L23:
        throw FormatException.getFormatInstance();
    L5:
        return new DecodedChar(r5 + 5, '$');
    }

    private boolean isStillAlpha(int r6) {
        if ((r6 + 5) <= this.information.getSize()) goto L5;
        return false;
    L5:
        int r1 = extractNumericValueFromBitArray(r6, 5);
        if (r1 < 5) goto L10;
        if (r1 >= 16) goto L10;
        return true;
    L10:
        if ((r6 + 6) <= this.information.getSize()) goto L12;
        return false;
    L12:
        int r5 = extractNumericValueFromBitArray(r6, 6);
        if (r5 >= 16) goto L15;
    L17:
        return false;
    L15:
        if (r5 >= 63) goto L17;
        return true;
    }

    private DecodedChar decodeAlphanumeric(int r4) {
        int r1 = extractNumericValueFromBitArray(r4, 5);
        if (r1 == 15) goto L5;
        if (r1 < 5) goto L10;
        if (r1 >= 15) goto L10;
        return new DecodedChar(r4 + 5, (char) ((r1 + 48) - 5));
    L10:
        int r3 = extractNumericValueFromBitArray(r4, 6);
        if (r3 >= 32) goto L13;
    L16:
        switch(r3) {
            case 58: goto L23;
            case 59: goto L22;
            case 60: goto L21;
            case 61: goto L20;
            case 62: goto L19;
            default: goto L18;
        };
    L19:
        char r5 = IOUtils.DIR_SEPARATOR_UNIX;
    L25:
        return new DecodedChar(r4 + 6, r5);
    L20:
        r5 = '.';
        goto L25
    L21:
        r5 = '-';
        goto L25
    L22:
        r5 = ',';
        goto L25
    L23:
        r5 = '*';
        goto L25
    L18:
        throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(r3)));
    L13:
        if (r3 >= 58) goto L16;
        return new DecodedChar(r4 + 6, (char) (r3 + 33));
    L5:
        return new DecodedChar(r4 + 5, '$');
    }

    private boolean isAlphaTo646ToAlphaLatch(int r5) {
        if ((r5 + 1) <= this.information.getSize()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= 5) goto L19;
        int r1 = r0 + r5;
        if (r1 >= this.information.getSize()) goto L27;
        if (r0 != 2) goto L16;
        if (this.information.get(r5 + 2) == true) goto L18;
        return false;
    L18:
        r0 = r0 + 1;
        goto L7
    L16:
        if (this.information.get(r1) == false) goto L18;
        return false;
    L27:
        return true;
    L19:
        return true;
    }

    private boolean isAlphaOr646ToNumericLatch(int r4) {
        int r0 = r4 + 3;
        if (r0 <= this.information.getSize()) goto L5;
        return false;
    L5:
        if (r4 >= r0) goto L10;
        if (this.information.get(r4) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        return false;
    L10:
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int r5) {
        if ((r5 + 1) <= this.information.getSize()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= 4) goto L14;
        int r1 = r0 + r5;
        if (r1 >= this.information.getSize()) goto L19;
        if (this.information.get(r1) == true) goto L12;
        r0 = r0 + 1;
        goto L7
    L12:
        return false;
    L19:
        return true;
    L14:
        return true;
    }
}
