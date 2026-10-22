package androidx.startup;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupException extends RuntimeException {
    public StartupException(@NonNull String r1) {
        super(r1);
    }

    public StartupException(@NonNull String r1, @NonNull Throwable r2) {
        super(r1, r2);
    }

    public StartupException(@NonNull Throwable r1) {
        super(r1);
    }
}
