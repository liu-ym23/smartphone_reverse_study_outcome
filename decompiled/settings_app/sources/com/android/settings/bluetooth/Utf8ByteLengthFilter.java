package com.android.settings.bluetooth;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes2.dex */
public class Utf8ByteLengthFilter implements InputFilter {
    private final int mMaxBytes;

    public Utf8ByteLengthFilter(int r1) {
        this.mMaxBytes = r1;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r17, int r18, int r19, Spanned r20, int r21, int r22) {
        int r3 = 0;
        int r4 = r18;
        int r5 = 0;
    L3:
        int r6 = 2;
        if (r4 >= r19) goto L12;
        char r11 = r17.charAt(r4);
        if (r11 >= 128) goto L8;
        r6 = 1;
    L11:
        r5 = r5 + r6;
        r4 = r4 + 1;
        goto L3
    L8:
        if (r11 < 2048) goto L11;
        r6 = 3;
        goto L11
    L12:
        int r7 = r20.length();
        int r12 = 0;
    L13:
        if (r3 >= r7) goto L25;
        if (r3 < r21) goto L17;
        if (r3 >= r22) goto L17;
    L24:
        r3 = r3 + 1;
    L17:
        char r15 = r20.charAt(r3);
        if (r15 >= 128) goto L20;
        int r16 = 1;
    L23:
        r12 = r12 + r16;
        goto L24
    L20:
        if (r15 >= 2048) goto L22;
        r16 = 2;
        goto L23
    L22:
        r16 = 3;
        goto L23
    L25:
        int r8 = this.mMaxBytes - r12;
        if (r8 > 0) goto L29;
        return "";
    L29:
        if (r8 < r5) goto L31;
        return null;
    L31:
        int r9 = r18;
    L32:
        if (r9 >= r19) goto L50;
        char r13 = r17.charAt(r9);
        if (r13 >= 128) goto L36;
        int r14 = 1;
    L39:
        r8 = r8 - r14;
        if (r8 < 0) goto L41;
        r9 = r9 + 1;
        goto L32
    L41:
        if (r9 != r18) goto L43;
        return "";
    L43:
        int r2 = r9 - 1;
        if (Character.isHighSurrogate(r17.charAt(r2)) == false) goto L48;
        return r17.subSequence(r18, r2);
    L48:
        return r17.subSequence(r18, r9);
    L36:
        if (r13 >= 2048) goto L38;
        r14 = 2;
        goto L39
    L38:
        r14 = 3;
        goto L39
    L50:
        return null;
    }
}
