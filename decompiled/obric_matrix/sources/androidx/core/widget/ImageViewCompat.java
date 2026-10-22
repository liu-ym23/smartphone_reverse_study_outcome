package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ColorStateList getImageTintList(ImageView r0) {
            return r0.getImageTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getImageTintMode(ImageView r0) {
            return r0.getImageTintMode();
        }

        @DoNotInline
        static void setImageTintList(ImageView r0, ColorStateList r1) {
            r0.setImageTintList(r1);
        }

        @DoNotInline
        static void setImageTintMode(ImageView r0, PorterDuff.Mode r1) {
            r0.setImageTintMode(r1);
        }
    }

    private ImageViewCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getImageTintList(@NonNull ImageView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getImageTintList(r2);
    L7:
        if ((r2 instanceof TintableImageSourceView) == true) goto L11;
        return null;
    L11:
        return ((TintableImageSourceView) r2).getSupportImageTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getImageTintMode(@NonNull ImageView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getImageTintMode(r2);
    L7:
        if ((r2 instanceof TintableImageSourceView) == true) goto L11;
        return null;
    L11:
        return ((TintableImageSourceView) r2).getSupportImageTintMode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setImageTintList(@NonNull ImageView r2, @Nullable ColorStateList r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L15;
        Api21Impl.setImageTintList(r2, r3);
        if (r0 != 21) goto L18;
        Drawable r4 = r2.getDrawable();
        if (r4 != null) goto L9;
        return;
    L9:
        if (Api21Impl.getImageTintList(r2) != null) goto L11;
        return;
    L11:
        if (r4.isStateful() == false) goto L13;
        r4.setState(r2.getDrawableState());
    L13:
        r2.setImageDrawable(r4);
        return;
    L18:
        return;
    L15:
        if ((r2 instanceof TintableImageSourceView) == false) goto L22;
        ((TintableImageSourceView) r2).setSupportImageTintList(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setImageTintMode(@NonNull ImageView r2, @Nullable PorterDuff.Mode r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L15;
        Api21Impl.setImageTintMode(r2, r3);
        if (r0 != 21) goto L18;
        Drawable r4 = r2.getDrawable();
        if (r4 != null) goto L9;
        return;
    L9:
        if (Api21Impl.getImageTintList(r2) != null) goto L11;
        return;
    L11:
        if (r4.isStateful() == false) goto L13;
        r4.setState(r2.getDrawableState());
    L13:
        r2.setImageDrawable(r4);
        return;
    L18:
        return;
    L15:
        if ((r2 instanceof TintableImageSourceView) == false) goto L22;
        ((TintableImageSourceView) r2).setSupportImageTintMode(r3);
        return;
    }
}
