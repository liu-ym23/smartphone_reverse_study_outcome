package okio;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-DeprecatedUtf8, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = null;

    static {
        INSTANCE = new DeprecatedUtf8();
    }

    private DeprecatedUtf8() {
    }

    @Deprecated
    public final long size(@NotNull String r3) {
        Intrinsics.f(r3, "string");
        return Utf8.size$default(r3, 0, 0, 3, null);
    }

    @Deprecated
    public final long size(@NotNull String r1, int r2, int r3) {
        Intrinsics.f(r1, "string");
        return Utf8.size(r1, r2, r3);
    }
}
