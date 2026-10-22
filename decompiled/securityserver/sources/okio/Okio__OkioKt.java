package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final /* synthetic */ class Okio__OkioKt {
    @JvmName
    @NotNull
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source r1) {
        Intrinsics.f(r1, "$this$buffer");
        return new RealBufferedSource(r1);
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink r1) {
        Intrinsics.f(r1, "$this$buffer");
        return new RealBufferedSink(r1);
    }
}
