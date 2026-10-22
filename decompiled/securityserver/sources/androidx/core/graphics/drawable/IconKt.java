package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class IconKt {
    @RequiresApi(26)
    @NotNull
    public static final Icon toAdaptiveIcon(@NotNull Bitmap r1) {
        Intrinsics.g(r1, "$this$toAdaptiveIcon");
        Icon r2 = Icon.createWithAdaptiveBitmap(r1);
        Intrinsics.b(r2, "Icon.createWithAdaptiveBitmap(this)");
        return r2;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Bitmap r1) {
        Intrinsics.g(r1, "$this$toIcon");
        Icon r2 = Icon.createWithBitmap(r1);
        Intrinsics.b(r2, "Icon.createWithBitmap(this)");
        return r2;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Uri r1) {
        Intrinsics.g(r1, "$this$toIcon");
        Icon r2 = Icon.createWithContentUri(r1);
        Intrinsics.b(r2, "Icon.createWithContentUri(this)");
        return r2;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull byte[] r2) {
        Intrinsics.g(r2, "$this$toIcon");
        Icon r3 = Icon.createWithData(r2, 0, r2.length);
        Intrinsics.b(r3, "Icon.createWithData(this, 0, size)");
        return r3;
    }
}
