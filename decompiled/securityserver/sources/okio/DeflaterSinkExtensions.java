package okio;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class DeflaterSinkExtensions {
    @NotNull
    public static final DeflaterSink deflate(@NotNull Sink r1, @NotNull Deflater r2) {
        Intrinsics.f(r1, "$this$deflate");
        Intrinsics.f(r2, "deflater");
        return new DeflaterSink(r1, r2);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink r0, Deflater r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new Deflater();
    L5:
        Intrinsics.f(r0, "$this$deflate");
        Intrinsics.f(r1, "deflater");
        return new DeflaterSink(r0, r1);
    }
}
