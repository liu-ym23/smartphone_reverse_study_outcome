package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Verify {
    public static void verify(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new VerifyException();
    }

    public static void verify(boolean r0, String r1, @CheckForNull Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r1, r2));
    }

    public static void verify(boolean r2, String r3, char r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4)}));
    }

    public static void verify(boolean r2, String r3, int r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4)}));
    }

    public static void verify(boolean r2, String r3, long r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4)}));
    }

    public static void verify(boolean r2, String r3, @CheckForNull Object r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{r4}));
    }

    public static void verify(boolean r2, String r3, char r4, char r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Character.valueOf(r5)}));
    }

    public static void verify(boolean r2, String r3, int r4, char r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Character.valueOf(r5)}));
    }

    public static void verify(boolean r2, String r3, long r4, char r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Character.valueOf(r6)}));
    }

    public static void verify(boolean r2, String r3, @CheckForNull Object r4, char r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{r4, Character.valueOf(r5)}));
    }

    public static void verify(boolean r2, String r3, char r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Integer.valueOf(r5)}));
    }

    public static void verify(boolean r2, String r3, int r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
    }

    public static void verify(boolean r2, String r3, long r4, int r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Integer.valueOf(r6)}));
    }

    public static void verify(boolean r2, String r3, @CheckForNull Object r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{r4, Integer.valueOf(r5)}));
    }

    public static void verify(boolean r2, String r3, char r4, long r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Long.valueOf(r5)}));
    }

    public static void verify(boolean r2, String r3, int r4, long r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Long.valueOf(r5)}));
    }

    public static void verify(boolean r2, String r3, long r4, long r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Long.valueOf(r6)}));
    }

    public static void verify(boolean r2, String r3, @CheckForNull Object r4, long r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{r4, Long.valueOf(r5)}));
    }

    public static void verify(boolean r2, String r3, char r4, @CheckForNull Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), r5}));
    }

    public static void verify(boolean r2, String r3, int r4, @CheckForNull Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), r5}));
    }

    public static void verify(boolean r2, String r3, long r4, @CheckForNull Object r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), r6}));
    }

    public static void verify(boolean r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{r4, r5}));
    }

    public static void verify(boolean r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5, @CheckForNull Object r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{r4, r5, r6}));
    }

    public static void verify(boolean r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5, @CheckForNull Object r6, @CheckForNull Object r7) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r3, new Object[]{r4, r5, r6, r7}));
    }

    public static <T> T verifyNotNull(@CheckForNull T r2) {
        return (T) verifyNotNull(r2, "expected a non-null reference", new Object[0]);
    }

    public static <T> T verifyNotNull(@CheckForNull T r0, String r1, @CheckForNull Object... r2) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new VerifyException(Strings.lenientFormat(r1, r2));
    }

    private Verify() {
    }
}
