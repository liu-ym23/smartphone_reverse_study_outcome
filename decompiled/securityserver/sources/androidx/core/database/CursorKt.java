package androidx.core.database;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CursorKt {
    @Nullable
    public static final byte[] getBlobOrNull(@NotNull Cursor r1, int r2) {
        Intrinsics.g(r1, "$this$getBlobOrNull");
        if (r1.isNull(r2) == false) goto L6;
        return null;
    L6:
        return r1.getBlob(r2);
    }

    @Nullable
    public static final Double getDoubleOrNull(@NotNull Cursor r1, int r2) {
        Intrinsics.g(r1, "$this$getDoubleOrNull");
        if (r1.isNull(r2) == false) goto L6;
        return null;
    L6:
        return Double.valueOf(r1.getDouble(r2));
    }

    @Nullable
    public static final Float getFloatOrNull(@NotNull Cursor r1, int r2) {
        Intrinsics.g(r1, "$this$getFloatOrNull");
        if (r1.isNull(r2) == false) goto L6;
        return null;
    L6:
        return Float.valueOf(r1.getFloat(r2));
    }

    @Nullable
    public static final Integer getIntOrNull(@NotNull Cursor r1, int r2) {
        Intrinsics.g(r1, "$this$getIntOrNull");
        if (r1.isNull(r2) == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(r1.getInt(r2));
    }

    @Nullable
    public static final Long getLongOrNull(@NotNull Cursor r1, int r2) {
        Intrinsics.g(r1, "$this$getLongOrNull");
        if (r1.isNull(r2) == false) goto L6;
        return null;
    L6:
        return Long.valueOf(r1.getLong(r2));
    }

    @Nullable
    public static final Short getShortOrNull(@NotNull Cursor r1, int r2) {
        Intrinsics.g(r1, "$this$getShortOrNull");
        if (r1.isNull(r2) == false) goto L6;
        return null;
    L6:
        return Short.valueOf(r1.getShort(r2));
    }

    @Nullable
    public static final String getStringOrNull(@NotNull Cursor r1, int r2) {
        Intrinsics.g(r1, "$this$getStringOrNull");
        if (r1.isNull(r2) == false) goto L6;
        return null;
    L6:
        return r1.getString(r2);
    }
}
