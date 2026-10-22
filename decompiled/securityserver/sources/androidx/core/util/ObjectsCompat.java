package androidx.core.util;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object r0, @Nullable Object r1) {
        return Objects.equals(r0, r1);
    }

    public static int hash(@Nullable Object... r0) {
        return Objects.hash(r0);
    }

    public static int hashCode(@Nullable Object r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }
}
