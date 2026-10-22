package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HalfKt {
    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(short r1) {
        Half r2 = Half.valueOf(r1);
        Intrinsics.b(r2, "Half.valueOf(this)");
        return r2;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(float r1) {
        Half r2 = Half.valueOf(r1);
        Intrinsics.b(r2, "Half.valueOf(this)");
        return r2;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(@NotNull String r1) {
        Intrinsics.g(r1, "$this$toHalf");
        Half r2 = Half.valueOf(r1);
        Intrinsics.b(r2, "Half.valueOf(this)");
        return r2;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(double r0) {
        Half r1 = Half.valueOf((float) r0);
        Intrinsics.b(r1, "Half.valueOf(this)");
        return r1;
    }
}
