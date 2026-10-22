package com.google.zxing.datamatrix.encoder;

import com.android.settingslib.accessibility.AccessibilityUtils;

/* JADX INFO: loaded from: classes4.dex */
final class TextEncoder extends C40Encoder {
    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 2;
    }

    TextEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    int encodeChar(char r5, StringBuilder r6) {
        if (r5 != ' ') goto L7;
        r6.append(3);
        return 1;
    L7:
        if (r5 < '0') goto L13;
        if (r5 > '9') goto L13;
        r6.append((char) ((r5 - '0') + 4));
        return 1;
    L13:
        if (r5 < 'a') goto L19;
        if (r5 > 'z') goto L19;
        r6.append((char) ((r5 - 'a') + 14));
        return 1;
    L19:
        if (r5 >= ' ') goto L23;
        r6.append(0);
        r6.append(r5);
        return 2;
    L23:
        if (r5 < '!') goto L29;
        if (r5 > '/') goto L29;
        r6.append(1);
        r6.append((char) (r5 - '!'));
        return 2;
    L29:
        if (r5 < ':') goto L35;
        if (r5 > '@') goto L35;
        r6.append(1);
        r6.append((char) ((r5 - AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR) + 15));
        return 2;
    L35:
        if (r5 < '[') goto L41;
        if (r5 > '_') goto L41;
        r6.append(1);
        r6.append((char) ((r5 - '[') + 22));
        return 2;
    L41:
        if (r5 != '`') goto L45;
        r6.append(2);
        r6.append((char) (r5 - '`'));
        return 2;
    L45:
        if (r5 < 'A') goto L51;
        if (r5 > 'Z') goto L51;
        r6.append(2);
        r6.append((char) ((r5 - 'A') + 1));
        return 2;
    L51:
        if (r5 >= '{') goto L53;
    L56:
        r6.append("\u0001\u001e");
        return encodeChar((char) (r5 - 128), r6) + 2;
    L53:
        if (r5 > 127) goto L56;
        r6.append(2);
        r6.append((char) ((r5 - '{') + 27));
        return 2;
    }
}
