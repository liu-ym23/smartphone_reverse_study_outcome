package kotlin.internal.jdk7;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class JDK7PlatformImplementations extends PlatformImplementations {
    public JDK7PlatformImplementations() {
    }

    @Override // kotlin.internal.PlatformImplementations
    public final void a(Throwable r1, Throwable r2) {
        Intrinsics.f(r1, "cause");
        Intrinsics.f(r2, "exception");
        r1.addSuppressed(r2);
    }
}
