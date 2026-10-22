package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-GzipSourceExtensions, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    public static final /* synthetic */ boolean access$getBit(int r0, int r1) {
        return getBit(r0, r1);
    }

    private static final boolean getBit(int r0, int r1) {
        if (((r0 >> r1) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @NotNull
    public static final GzipSource gzip(@NotNull Source r1) {
        Intrinsics.f(r1, "$this$gzip");
        return new GzipSource(r1);
    }
}
