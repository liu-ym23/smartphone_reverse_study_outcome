package androidx.core.util;

import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static boolean equals(Object r0, Object r1) {
            return Objects.equals(r0, r1);
        }

        @DoNotInline
        static int hash(Object... r0) {
            return Objects.hash(r0);
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object r2, @Nullable Object r3) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        if (r2 == r3) goto L12;
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.equals(r3) == false) goto L11;
    L12:
        return true;
    L5:
        return Api19Impl.equals(r2, r3);
    }

    public static int hash(@Nullable Object... r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.hash(r2);
    L7:
        return Arrays.hashCode(r2);
    }

    public static int hashCode(@Nullable Object r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T r0, @NonNull String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    @Nullable
    public static String toString(@Nullable Object r0, @Nullable String r1) {
        if (r0 != null) goto L4;
        return r1;
    L4:
        return r0.toString();
    }
}
