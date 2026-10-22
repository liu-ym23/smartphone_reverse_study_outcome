package androidx.core.os;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(@Nullable String r1) {
        if (r1 != null) goto L5;
        r1 = "The operation has been canceled.";
    L5:
        super(r1);
    }
}
