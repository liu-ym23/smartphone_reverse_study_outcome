package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewCompat {
    private ImageViewCompat() {
    }

    @Nullable
    public static ColorStateList getImageTintList(@NonNull ImageView r0) {
        return r0.getImageTintList();
    }

    @Nullable
    public static PorterDuff.Mode getImageTintMode(@NonNull ImageView r0) {
        return r0.getImageTintMode();
    }

    public static void setImageTintList(@NonNull ImageView r0, @Nullable ColorStateList r1) {
        r0.setImageTintList(r1);
    }

    public static void setImageTintMode(@NonNull ImageView r0, @Nullable PorterDuff.Mode r1) {
        r0.setImageTintMode(r1);
    }
}
