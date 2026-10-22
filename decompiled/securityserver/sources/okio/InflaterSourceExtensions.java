package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class InflaterSourceExtensions {
    @NotNull
    public static final InflaterSource inflate(@NotNull Source r1, @NotNull Inflater r2) {
        Intrinsics.f(r1, "$this$inflate");
        Intrinsics.f(r2, "inflater");
        return new InflaterSource(r1, r2);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source r0, Inflater r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new Inflater();
    L5:
        Intrinsics.f(r0, "$this$inflate");
        Intrinsics.f(r1, "inflater");
        return new InflaterSource(r0, r1);
    }
}
