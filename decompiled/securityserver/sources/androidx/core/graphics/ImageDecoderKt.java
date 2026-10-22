package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ImageDecoderKt {
    @RequiresApi(28)
    @NotNull
    public static final Bitmap decodeBitmap(@NotNull ImageDecoder.Source r1, @NotNull final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> r2) {
        Intrinsics.g(r1, "$this$decodeBitmap");
        Intrinsics.g(r2, "action");
        Bitmap r3 = ImageDecoder.decodeBitmap(r1, new AnonymousClass1(r2));
        Intrinsics.b(r3, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
        return r3;
    }

    @RequiresApi(28)
    @NotNull
    public static final Drawable decodeDrawable(@NotNull ImageDecoder.Source r1, @NotNull final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> r2) {
        Intrinsics.g(r1, "$this$decodeDrawable");
        Intrinsics.g(r2, "action");
        Drawable r3 = ImageDecoder.decodeDrawable(r1, new C00191(r2));
        Intrinsics.b(r3, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
        return r3;
    }
}
