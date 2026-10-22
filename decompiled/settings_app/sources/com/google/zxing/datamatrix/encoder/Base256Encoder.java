package com.google.zxing.datamatrix.encoder;

import android.icu.lang.UCharacter;
import androidx.core.view.InputDeviceCompat;

/* JADX INFO: loaded from: classes4.dex */
final class Base256Encoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 5;
    }

    Base256Encoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext r7) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
        r0.append(0);
    L4:
        if (r7.hasMoreCharacters() == false) goto L8;
        r0.append(r7.getCurrentChar());
        r7.pos++;
        if (HighLevelEncoder.lookAheadTest(r7.getMessage(), r7.pos, getEncodingMode()) == getEncodingMode()) goto L4;
        r7.signalEncoderChange(0);
    L8:
        int r6 = r0.length() - 1;
        int r2 = (r7.getCodewordCount() + r6) + 1;
        r7.updateSymbolInfo(r2);
        if ((r7.getSymbolInfo().getDataCapacity() - r2) <= 0) goto L11;
        boolean r3 = true;
    L13:
        if (r7.hasMoreCharacters() == true) goto L16;
        if (r3 == true) goto L16;
    L21:
        int r8 = r0.length();
    L22:
        if (r1 >= r8) goto L24;
        r7.writeCodeword(randomize255State(r0.charAt(r1), r7.getCodewordCount() + 1));
        r1 = r1 + 1;
        goto L22
    L24:
        return;
    L16:
        if (r6 > 249) goto L19;
        r0.setCharAt(0, (char) r6);
        goto L21
    L19:
        if (r6 > 1555) goto L26;
        r0.setCharAt(0, (char) ((r6 / 250) + UCharacter.UnicodeBlock.SINHALA_ARCHAIC_NUMBERS_ID));
        r0.insert(1, (char) (r6 % 250));
        goto L21
    L26:
        throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(r6)));
    L11:
        r3 = false;
        goto L13
    }

    private static char randomize255State(char r1, int r2) {
        int r3 = r1 + (((r2 * 149) % 255) + 1);
        if (r3 > 255) goto L7;
        return (char) r3;
    L7:
        return (char) (r3 + InputDeviceCompat.SOURCE_ANY);
    }
}
