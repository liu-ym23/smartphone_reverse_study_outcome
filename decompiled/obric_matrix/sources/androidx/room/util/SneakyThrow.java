package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void reThrow(@NonNull Exception r0) {
        sneakyThrow(r0);
    }

    private static <E extends Throwable> void sneakyThrow(@NonNull Throwable r0) {
        throw r0;
    }
}
