package androidx.core.os;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TraceKt {
    public static final <T> T trace(@NotNull String r1, @NotNull Function0<? extends T> r2) {
        Intrinsics.g(r1, "sectionName");
        Intrinsics.g(r2, "block");
        TraceCompat.beginSection(r1);
        T r3 = (T) r2.invoke();
        TraceCompat.endSection();
        return r3;
    L6:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }
}
