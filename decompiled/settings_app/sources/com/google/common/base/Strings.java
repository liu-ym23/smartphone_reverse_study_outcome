package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Strings {
    private Strings() {
    }

    public static String nullToEmpty(@CheckForNull String r0) {
        return Platform.nullToEmpty(r0);
    }

    @CheckForNull
    public static String emptyToNull(@CheckForNull String r0) {
        return Platform.emptyToNull(r0);
    }

    public static boolean isNullOrEmpty(@CheckForNull String r0) {
        return Platform.stringIsNullOrEmpty(r0);
    }

    public static String padStart(String r2, int r3, char r4) {
        Preconditions.checkNotNull(r2);
        if (r2.length() < r3) goto L5;
        return r2;
    L5:
        StringBuilder r0 = new StringBuilder(r3);
        int r1 = r2.length();
    L6:
        if (r1 >= r3) goto L8;
        r0.append(r4);
        r1 = r1 + 1;
        goto L6
    L8:
        r0.append(r2);
        return r0.toString();
    }

    public static String padEnd(String r1, int r2, char r3) {
        Preconditions.checkNotNull(r1);
        if (r1.length() < r2) goto L5;
        return r1;
    L5:
        StringBuilder r0 = new StringBuilder(r2);
        r0.append(r1);
        int r4 = r1.length();
    L6:
        if (r4 >= r2) goto L9;
        r0.append(r3);
        r4 = r4 + 1;
        goto L6
    L9:
        return r0.toString();
    }

    public static String repeat(String r6, int r7) {
        Preconditions.checkNotNull(r6);
        boolean r0 = false;
        if (r7 > 1) goto L10;
        if (r7 < 0) goto L6;
        r0 = true;
    L6:
        Preconditions.checkArgument(r0, "invalid count: %s", r7);
        if (r7 != 0) goto L21;
        return "";
    L21:
        return r6;
    L10:
        int r1 = r6.length();
        long r2 = ((long) r1) * ((long) r7);
        int r8 = (int) r2;
        if (r8 != r2) goto L19;
        char[] r3 = new char[r8];
        r6.getChars(0, r1, r3, 0);
    L13:
        int r9 = r8 - r1;
        if (r1 >= r9) goto L16;
        System.arraycopy(r3, 0, r3, r1, r1);
        r1 = r1 << 1;
        goto L13
    L16:
        System.arraycopy(r3, 0, r3, r1, r9);
        return new String(r3);
    L19:
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(51).append("Required array size too large: ").append(r2).toString());
    }

    public static String commonPrefix(CharSequence r5, CharSequence r6) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        int r0 = Math.min(r5.length(), r6.length());
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L7;
        if (r5.charAt(r2) != r6.charAt(r2)) goto L7;
        r2 = r2 + 1;
    L7:
        int r1 = r2 - 1;
        if (validSurrogatePairAt(r5, r1) == false) goto L10;
    L11:
        r2 = r2 - 1;
    L13:
        return r5.subSequence(0, r2).toString();
    L10:
        if (validSurrogatePairAt(r6, r1) == false) goto L13;
        goto L11
    }

    public static String commonSuffix(CharSequence r4, CharSequence r5) {
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        int r0 = Math.min(r4.length(), r5.length());
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4.charAt((r4.length() - r1) - 1) != r5.charAt((r5.length() - r1) - 1)) goto L8;
        r1 = r1 + 1;
    L8:
        if (validSurrogatePairAt(r4, (r4.length() - r1) - 1) == false) goto L10;
    L11:
        r1 = r1 - 1;
    L13:
        return r4.subSequence(r4.length() - r1, r4.length()).toString();
    L10:
        if (validSurrogatePairAt(r5, (r5.length() - r1) - 1) == false) goto L13;
        goto L11
    }

    static boolean validSurrogatePairAt(CharSequence r1, int r2) {
        if (r2 >= 0) goto L4;
    L10:
        return false;
    L4:
        if (r2 > (r1.length() - 2)) goto L10;
        if (Character.isHighSurrogate(r1.charAt(r2)) == false) goto L10;
        if (Character.isLowSurrogate(r1.charAt(r2 + 1)) == false) goto L10;
        return true;
    }

    public static String lenientFormat(@CheckForNull String r6, @CheckForNull Object... r7) {
        String r8 = String.valueOf(r6);
        int r0 = 0;
        if (r7 != null) goto L5;
        r7 = new Object[]{"(Object[])null"};
    L9:
        StringBuilder r1 = new StringBuilder(r8.length() + (r7.length * 16));
        int r2 = 0;
    L11:
        if (r0 >= r7.length) goto L16;
        int r3 = r8.indexOf("%s", r2);
        if (r3 == (-1)) goto L16;
        r1.append(r8, r2, r3);
        r1.append(r7[r0]);
        r2 = r3 + 2;
        r0 = r0 + 1;
    L16:
        r1.append(r8, r2, r8.length());
        if (r0 >= r7.length) goto L24;
        r1.append(" [");
        int r9 = r0 + 1;
        r1.append(r7[r0]);
    L20:
        if (r9 >= r7.length) goto L22;
        r1.append(", ");
        r1.append(r7[r9]);
        r9 = r9 + 1;
        goto L20
    L22:
        r1.append(']');
    L24:
        return r1.toString();
    L5:
        int r4 = 0;
    L7:
        if (r4 >= r7.length) goto L9;
        r7[r4] = lenientToString(r7[r4]);
        r4 = r4 + 1;
        goto L7
    }

    private static String lenientToString(@CheckForNull Object r6) {
        if (r6 != null) goto L14;
        return "null";
    L14:
        return r6.toString();
    L7:
        e = move-exception;
        String r1 = r6.getClass().getName();
        String r7 = Integer.toHexString(System.identityHashCode(r6));
        String r8 = new StringBuilder((String.valueOf(r1).length() + 1) + String.valueOf(r7).length()).append(r1).append('@').append(r7).toString();
        Logger r2 = Logger.getLogger("com.google.common.base.Strings");
        Level r3 = Level.WARNING;
        String r4 = String.valueOf(r8);
        if (r4.length() == 0) goto L11;
        String r5 = "Exception during lenientFormat for ".concat(r4);
    L12:
        r2.log(r3, r5, e);
        String r0 = e.getClass().getName();
        return new StringBuilder((String.valueOf(r8).length() + 9) + String.valueOf(r0).length()).append("<").append(r8).append(" threw ").append(r0).append(">").toString();
    L11:
        r5 = new String("Exception during lenientFormat for ");
        goto L12
    }
}
