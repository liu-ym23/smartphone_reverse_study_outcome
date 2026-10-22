package com.google.common.escape;

import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    @CheckForNull
    protected abstract char[] escape(int r1);

    protected UnicodeEscaper() {
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String r3) {
        Preconditions.checkNotNull(r3);
        int r0 = r3.length();
        int r1 = nextEscapeIndex(r3, 0, r0);
        if (r1 != r0) goto L6;
        return r3;
    L6:
        return escapeSlow(r3, r1);
    }

    protected int nextEscapeIndex(CharSequence r3, int r4, int r5) {
    L2:
        if (r4 >= r5) goto L13;
        int r0 = codePointAt(r3, r4, r5);
        if (r0 < 0) goto L13;
        if (escape(r0) != null) goto L13;
        if (Character.isSupplementaryCodePoint(r0) == false) goto L11;
        int r1 = 2;
    L12:
        r4 = r4 + r1;
        goto L2
    L11:
        r1 = 1;
    L13:
        return r4;
    }

    protected final String escapeSlow(String r12, int r13) {
        int r0 = r12.length();
        char[] r1 = Platform.charBufferFromThreadLocal();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r13 >= r0) goto L24;
        int r5 = codePointAt(r12, r13, r0);
        if (r5 < 0) goto L23;
        char[] r6 = escape(r5);
        if (Character.isSupplementaryCodePoint(r5) == false) goto L9;
        int r7 = 2;
    L10:
        int r8 = r7 + r13;
        if (r6 == null) goto L21;
        int r9 = r13 - r3;
        int r10 = r4 + r9;
        int r11 = r6.length + r10;
        if (r1.length >= r11) goto L15;
        r1 = growBuffer(r1, r4, (r11 + (r0 - r13)) + 32);
    L15:
        if (r9 <= 0) goto L18;
        r12.getChars(r3, r13, r1, r4);
        r4 = r10;
    L18:
        if (r6.length <= 0) goto L20;
        System.arraycopy(r6, 0, r1, r4, r6.length);
        r4 = r4 + r6.length;
    L20:
        r3 = r8;
    L21:
        r13 = nextEscapeIndex(r12, r8, r0);
        goto L3
    L9:
        r7 = 1;
        goto L10
    L23:
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
    L24:
        int r14 = r0 - r3;
        if (r14 <= 0) goto L31;
        int r15 = r14 + r4;
        if (r1.length >= r15) goto L29;
        r1 = growBuffer(r1, r4, r15);
    L29:
        r12.getChars(r3, r0, r1, r4);
        r4 = r15;
    L31:
        return new String(r1, 0, r4);
    }

    protected static int codePointAt(CharSequence r7, int r8, int r9) {
        Preconditions.checkNotNull(r7);
        if (r8 >= r9) goto L24;
        int r0 = r8 + 1;
        char r10 = r7.charAt(r8);
        if (r10 >= 55296) goto L7;
    L22:
        return r10;
    L7:
        if (r10 > 57343) goto L22;
        if (r10 > 56319) goto L20;
        if (r0 == r9) goto L13;
        char r11 = r7.charAt(r0);
        if (Character.isLowSurrogate(r11) == true) goto L17;
        String r12 = String.valueOf(r7);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r12).length() + 89).append("Expected low surrogate but got char '").append(r11).append("' with value ").append(r11).append(" at index ").append(r0).append(" in '").append(r12).append("'").toString());
    L17:
        return Character.toCodePoint(r10, r11);
    L13:
        return -r10;
    L20:
        String r13 = String.valueOf(r7);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r13).length() + 88).append("Unexpected low surrogate character '").append(r10).append("' with value ").append(r10).append(" at index ").append(r0 - 1).append(" in '").append(r13).append("'").toString());
    L24:
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] growBuffer(char[] r1, int r2, int r3) {
        if (r3 < 0) goto L8;
        char[] r4 = new char[r3];
        if (r2 <= 0) goto L6;
        System.arraycopy(r1, 0, r4, 0, r2);
    L6:
        return r4;
    L8:
        throw new AssertionError("Cannot increase internal buffer any further");
    }
}
