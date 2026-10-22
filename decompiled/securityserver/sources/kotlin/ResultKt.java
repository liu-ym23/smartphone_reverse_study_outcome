package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ResultKt {
    public static final Result.Failure a(Throwable r1) {
        Intrinsics.f(r1, "exception");
        return new Result.Failure(r1);
    }

    public static final void b(Object r1) {
        if ((r1 instanceof Result.Failure) == true) goto L6;
        return;
    L6:
        throw ((Result.Failure) r1).b;
    }
}
