package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean r0, @CheckForNull Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r1));
    }

    public static void checkArgument(boolean r0, String r1, @CheckForNull Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r1, r2));
    }

    public static void checkArgument(boolean r2, String r3, char r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4)}));
    }

    public static void checkArgument(boolean r2, String r3, int r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4)}));
    }

    public static void checkArgument(boolean r2, String r3, long r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4)}));
    }

    public static void checkArgument(boolean r2, String r3, @CheckForNull Object r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{r4}));
    }

    public static void checkArgument(boolean r2, String r3, char r4, char r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Character.valueOf(r5)}));
    }

    public static void checkArgument(boolean r2, String r3, char r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Integer.valueOf(r5)}));
    }

    public static void checkArgument(boolean r2, String r3, char r4, long r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Long.valueOf(r5)}));
    }

    public static void checkArgument(boolean r2, String r3, char r4, @CheckForNull Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), r5}));
    }

    public static void checkArgument(boolean r2, String r3, int r4, char r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Character.valueOf(r5)}));
    }

    public static void checkArgument(boolean r2, String r3, int r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
    }

    public static void checkArgument(boolean r2, String r3, int r4, long r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Long.valueOf(r5)}));
    }

    public static void checkArgument(boolean r2, String r3, int r4, @CheckForNull Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), r5}));
    }

    public static void checkArgument(boolean r2, String r3, long r4, char r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Character.valueOf(r6)}));
    }

    public static void checkArgument(boolean r2, String r3, long r4, int r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Integer.valueOf(r6)}));
    }

    public static void checkArgument(boolean r2, String r3, long r4, long r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Long.valueOf(r6)}));
    }

    public static void checkArgument(boolean r2, String r3, long r4, @CheckForNull Object r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), r6}));
    }

    public static void checkArgument(boolean r2, String r3, @CheckForNull Object r4, char r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{r4, Character.valueOf(r5)}));
    }

    public static void checkArgument(boolean r2, String r3, @CheckForNull Object r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{r4, Integer.valueOf(r5)}));
    }

    public static void checkArgument(boolean r2, String r3, @CheckForNull Object r4, long r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{r4, Long.valueOf(r5)}));
    }

    public static void checkArgument(boolean r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{r4, r5}));
    }

    public static void checkArgument(boolean r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5, @CheckForNull Object r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{r4, r5, r6}));
    }

    public static void checkArgument(boolean r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5, @CheckForNull Object r6, @CheckForNull Object r7) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r3, new Object[]{r4, r5, r6, r7}));
    }

    public static void checkState(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static void checkState(boolean r0, @CheckForNull Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r1));
    }

    public static void checkState(boolean r0, @CheckForNull String r1, @CheckForNull Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r1, r2));
    }

    public static void checkState(boolean r2, String r3, char r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4)}));
    }

    public static void checkState(boolean r2, String r3, int r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4)}));
    }

    public static void checkState(boolean r2, String r3, long r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4)}));
    }

    public static void checkState(boolean r2, String r3, @CheckForNull Object r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{r4}));
    }

    public static void checkState(boolean r2, String r3, char r4, char r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Character.valueOf(r5)}));
    }

    public static void checkState(boolean r2, String r3, char r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Integer.valueOf(r5)}));
    }

    public static void checkState(boolean r2, String r3, char r4, long r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Long.valueOf(r5)}));
    }

    public static void checkState(boolean r2, String r3, char r4, @CheckForNull Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), r5}));
    }

    public static void checkState(boolean r2, String r3, int r4, char r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Character.valueOf(r5)}));
    }

    public static void checkState(boolean r2, String r3, int r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
    }

    public static void checkState(boolean r2, String r3, int r4, long r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Long.valueOf(r5)}));
    }

    public static void checkState(boolean r2, String r3, int r4, @CheckForNull Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), r5}));
    }

    public static void checkState(boolean r2, String r3, long r4, char r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Character.valueOf(r6)}));
    }

    public static void checkState(boolean r2, String r3, long r4, int r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Integer.valueOf(r6)}));
    }

    public static void checkState(boolean r2, String r3, long r4, long r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Long.valueOf(r6)}));
    }

    public static void checkState(boolean r2, String r3, long r4, @CheckForNull Object r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), r6}));
    }

    public static void checkState(boolean r2, String r3, @CheckForNull Object r4, char r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{r4, Character.valueOf(r5)}));
    }

    public static void checkState(boolean r2, String r3, @CheckForNull Object r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{r4, Integer.valueOf(r5)}));
    }

    public static void checkState(boolean r2, String r3, @CheckForNull Object r4, long r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{r4, Long.valueOf(r5)}));
    }

    public static void checkState(boolean r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{r4, r5}));
    }

    public static void checkState(boolean r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5, @CheckForNull Object r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{r4, r5, r6}));
    }

    public static void checkState(boolean r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5, @CheckForNull Object r6, @CheckForNull Object r7) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r3, new Object[]{r4, r5, r6, r7}));
    }

    public static <T> T checkNotNull(@CheckForNull T r0) {
        r0.getClass();
        return r0;
    }

    public static <T> T checkNotNull(@CheckForNull T r0, @CheckForNull Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }

    public static <T> T checkNotNull(@CheckForNull T r0, String r1, @CheckForNull Object... r2) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r1, r2));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, char r4) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, int r4) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, long r4) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, @CheckForNull Object r4) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{r4}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, char r4, char r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Character.valueOf(r5)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, char r4, int r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Integer.valueOf(r5)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, char r4, long r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), Long.valueOf(r5)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, char r4, @CheckForNull Object r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Character.valueOf(r4), r5}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, int r4, char r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Character.valueOf(r5)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, int r4, int r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, int r4, long r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), Long.valueOf(r5)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, int r4, @CheckForNull Object r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Integer.valueOf(r4), r5}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, long r4, char r6) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Character.valueOf(r6)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, long r4, int r6) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Integer.valueOf(r6)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, long r4, long r6) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), Long.valueOf(r6)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, long r4, @CheckForNull Object r6) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{Long.valueOf(r4), r6}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, @CheckForNull Object r4, char r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{r4, Character.valueOf(r5)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, @CheckForNull Object r4, int r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{r4, Integer.valueOf(r5)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, @CheckForNull Object r4, long r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{r4, Long.valueOf(r5)}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{r4, r5}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5, @CheckForNull Object r6) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{r4, r5, r6}));
    }

    public static <T> T checkNotNull(@CheckForNull T r2, String r3, @CheckForNull Object r4, @CheckForNull Object r5, @CheckForNull Object r6, @CheckForNull Object r7) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r3, new Object[]{r4, r5, r6, r7}));
    }

    public static int checkElementIndex(int r1, int r2) {
        return checkElementIndex(r1, r2, "index");
    }

    public static int checkElementIndex(int r1, int r2, String r3) {
        if (r1 < 0) goto L6;
        if (r1 >= r2) goto L6;
        return r1;
    L6:
        throw new IndexOutOfBoundsException(badElementIndex(r1, r2, r3));
    }

    private static String badElementIndex(int r4, int r5, String r6) {
        if (r4 < 0) goto L5;
        if (r5 < 0) goto L10;
        return Strings.lenientFormat("%s (%s) must be less than size (%s)", new Object[]{r6, Integer.valueOf(r4), Integer.valueOf(r5)});
    L10:
        throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(r5).toString());
    L5:
        return Strings.lenientFormat("%s (%s) must not be negative", new Object[]{r6, Integer.valueOf(r4)});
    }

    public static int checkPositionIndex(int r1, int r2) {
        return checkPositionIndex(r1, r2, "index");
    }

    public static int checkPositionIndex(int r1, int r2, String r3) {
        if (r1 < 0) goto L6;
        if (r1 > r2) goto L6;
        return r1;
    L6:
        throw new IndexOutOfBoundsException(badPositionIndex(r1, r2, r3));
    }

    private static String badPositionIndex(int r4, int r5, String r6) {
        if (r4 < 0) goto L5;
        if (r5 < 0) goto L10;
        return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", new Object[]{r6, Integer.valueOf(r4), Integer.valueOf(r5)});
    L10:
        throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(r5).toString());
    L5:
        return Strings.lenientFormat("%s (%s) must not be negative", new Object[]{r6, Integer.valueOf(r4)});
    }

    public static void checkPositionIndexes(int r1, int r2, int r3) {
        if (r1 < 0) goto L7;
        if (r2 < r1) goto L7;
        if (r2 > r3) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(badPositionIndexes(r1, r2, r3));
    }

    private static String badPositionIndexes(int r1, int r2, int r3) {
        if (r1 < 0) goto L13;
        if (r1 > r3) goto L13;
        if (r2 < 0) goto L11;
        if (r2 > r3) goto L11;
        return Strings.lenientFormat("end index (%s) must not be less than start index (%s)", new Object[]{Integer.valueOf(r2), Integer.valueOf(r1)});
    L11:
        return badPositionIndex(r2, r3, "end index");
    L13:
        return badPositionIndex(r1, r3, "start index");
    }
}
