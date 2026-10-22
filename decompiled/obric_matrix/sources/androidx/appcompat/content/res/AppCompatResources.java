package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources {
    private AppCompatResources() {
    }

    public static ColorStateList getColorStateList(@NonNull Context r0, @ColorRes int r1) {
        return ContextCompat.getColorStateList(r0, r1);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r1, @DrawableRes int r2) {
        return ResourceManagerInternal.get().getDrawable(r1, r2);
    }
}
