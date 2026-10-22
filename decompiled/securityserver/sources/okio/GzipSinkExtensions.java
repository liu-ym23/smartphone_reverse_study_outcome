package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class GzipSinkExtensions {
    @NotNull
    public static final GzipSink gzip(@NotNull Sink r1) {
        Intrinsics.f(r1, "$this$gzip");
        return new GzipSink(r1);
    }
}
