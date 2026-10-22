package androidx.core.location;

import android.location.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LocationKt {
    public static final double component1(@NotNull Location r2) {
        Intrinsics.g(r2, "$this$component1");
        return r2.getLatitude();
    }

    public static final double component2(@NotNull Location r2) {
        Intrinsics.g(r2, "$this$component2");
        return r2.getLongitude();
    }
}
