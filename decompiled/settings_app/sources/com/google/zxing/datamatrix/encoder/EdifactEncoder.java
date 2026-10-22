package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes4.dex */
final class EdifactEncoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 4;
    }

    EdifactEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext r6) {
        StringBuilder r0 = new StringBuilder();
    L4:
        if (r6.hasMoreCharacters() == false) goto L10;
        encodeChar(r6.getCurrentChar(), r0);
        r6.pos++;
        if (r0.length() < 4) goto L4;
        r6.writeCodewords(encodeToCodewords(r0, 0));
        r0.delete(0, 4);
        if (HighLevelEncoder.lookAheadTest(r6.getMessage(), r6.pos, getEncodingMode()) == getEncodingMode()) goto L4;
        r6.signalEncoderChange(0);
    L10:
        r0.append(31);
        handleEOD(r6, r0);
    }

    private static void handleEOD(EncoderContext r7, CharSequence r8) {
        int r1 = r8.length();     // Catch: Throwable -> L36
        if (r1 != 0) goto L7;
        r7.signalEncoderChange(0);
        return;
    L7:
        boolean r3 = true;
        if (r1 != 1) goto L18;
        r7.updateSymbolInfo();     // Catch: Throwable -> L36
        int r4 = r7.getSymbolInfo().getDataCapacity() - r7.getCodewordCount();     // Catch: Throwable -> L36
        int r5 = r7.getRemainingCharacters();     // Catch: Throwable -> L36
        if (r5 <= r4) goto L13;
        r7.updateSymbolInfo(r7.getCodewordCount() + 1);     // Catch: Throwable -> L36
        r4 = r7.getSymbolInfo().getDataCapacity() - r7.getCodewordCount();
    L13:
        if (r5 > r4) goto L18;
        if (r4 > 2) goto L18;
        r7.signalEncoderChange(0);
        return;
    L18:
        if (r1 > 4) goto L35;
        int r2 = r1 - 1;
        String r9 = encodeToCodewords(r8, 0);     // Catch: Throwable -> L36
        if ((!r7.hasMoreCharacters()) == false) goto L24;
        if (r2 > 2) goto L24;
    L25:
        if (r2 > 2) goto L29;
        r7.updateSymbolInfo(r7.getCodewordCount() + r2);     // Catch: Throwable -> L36
        if ((r7.getSymbolInfo().getDataCapacity() - r7.getCodewordCount()) < 3) goto L29;
        r7.updateSymbolInfo(r7.getCodewordCount() + r9.length());     // Catch: Throwable -> L36
        r3 = false;
    L29:
        if (r3 == false) goto L31;
        r7.resetSymbolInfo();     // Catch: Throwable -> L36
        r7.pos -= r2;     // Catch: Throwable -> L36
    L32:
        r7.signalEncoderChange(0);
        return;
    L31:
        r7.writeCodewords(r9);     // Catch: Throwable -> L36
    L24:
        r3 = false;
        goto L25
    L35:
        throw new IllegalStateException("Count must not exceed 4");     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r7.signalEncoderChange(0);
        throw th;
    }

    private static void encodeChar(char r2, StringBuilder r3) {
        if (r2 < ' ') goto L9;
        if (r2 > '?') goto L9;
        r3.append(r2);
        return;
    L9:
        if (r2 >= '@') goto L11;
    L14:
        HighLevelEncoder.illegalCharacter(r2);
        return;
    L11:
        if (r2 > '^') goto L14;
        r3.append((char) (r2 - '@'));
    }

    private static String encodeToCodewords(CharSequence r8, int r9) {
        int r0 = r8.length() - r9;
        if (r0 == 0) goto L23;
        char r1 = r8.charAt(r9);
        char r2 = 0;
        if (r0 < 2) goto L7;
        char r4 = r8.charAt(r9 + 1);
    L9:
        if (r0 < 3) goto L11;
        char r6 = r8.charAt(r9 + 2);
    L13:
        if (r0 < 4) goto L15;
        r2 = r8.charAt(r9 + 3);
    L15:
        int r10 = (((r1 << 18) + (r4 << '\f')) + (r6 << 6)) + r2;
        char r11 = (char) ((r10 >> 16) & 255);
        char r3 = (char) ((r10 >> 8) & 255);
        char r12 = (char) (r10 & 255);
        StringBuilder r5 = new StringBuilder(3);
        r5.append(r11);
        if (r0 < 2) goto L18;
        r5.append(r3);
    L18:
        if (r0 < 3) goto L21;
        r5.append(r12);
    L21:
        return r5.toString();
    L11:
        r6 = 0;
        goto L13
    L7:
        r4 = 0;
        goto L9
    L23:
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
