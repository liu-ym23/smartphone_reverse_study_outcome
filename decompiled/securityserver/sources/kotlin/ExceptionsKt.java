package kotlin;

import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ExceptionsKt extends ExceptionsKt__ExceptionsKt {
    public static void a(Throwable r1, Throwable r2) {
        Intrinsics.f(r1, "<this>");
        Intrinsics.f(r2, "exception");
        if (r1 == r2) goto L6;
        PlatformImplementationsKt.f340a.a(r1, r2);
        return;
    }
}
