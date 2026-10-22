package androidx.core.util;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static int checkArgumentInRange(int r3, int r4, int r5, @NonNull String r6) {
        if (r3 < r4) goto L8;
        if (r3 > r5) goto L6;
        return r3;
    L6:
        Locale r2 = Locale.US;
        throw new IllegalArgumentException(r6 + " is out of range of [" + r4 + ", " + r5 + "] (too high)");
    L8:
        Locale r7 = Locale.US;
        throw new IllegalArgumentException(r6 + " is out of range of [" + r4 + ", " + r5 + "] (too low)");
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int r0, @Nullable String r1) {
        if (r0 < 0) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException(r1);
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T r0) {
        r0.getClass();
        return r0;
    }

    public static void checkState(boolean r0, @Nullable String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r1);
    }

    public static void checkArgument(boolean r0, @NonNull Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r1));
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int r0) {
        if (r0 < 0) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T r0, @NonNull Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }

    public static void checkState(boolean r1) {
        checkState(r1, null);
    }
}
