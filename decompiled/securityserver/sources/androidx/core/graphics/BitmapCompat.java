package androidx.core.graphics;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapCompat {
    private BitmapCompat() {
    }

    public static int getAllocationByteCount(@NonNull Bitmap r0) {
        return r0.getAllocationByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap r0) {
        return r0.hasMipMap();
    }

    public static void setHasMipMap(@NonNull Bitmap r0, boolean r1) {
        r0.setHasMipMap(r1);
    }
}
